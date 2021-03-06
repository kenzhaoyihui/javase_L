package rabbitmq.RabbitMQRPC;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class rabbitmqRpcServer {

    private static final String RPC_QUEUE_NAME = "rpc_queue";

    private static int fib(int n) {
        if (n == 0) {
            return 0;
        } else if(n == 1){
            return 1;
        } else{
            return fib(n-1) + fib(n-2);
        }
    }

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost("127.0.0.1");

        Connection connection = null;
        try{
            connection = connectionFactory.newConnection();

            Channel channel = connection.createChannel();

            channel.queueDeclare(RPC_QUEUE_NAME, false, false, false, null);

            channel.basicQos(1);

            System.out.println(" [X] Awaiting RPC requests");

            Consumer consumer = new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    //super.handleDelivery(consumerTag, envelope, properties, body);

                    AMQP.BasicProperties replyProps = new AMQP.BasicProperties
                            .Builder()
                            .correlationId(properties.getCorrelationId())
                            .build();

                    String response = "";
                    try{
                        String message = new String(body, "UTF-8");
                        int n = Integer.parseInt(message);

                        System.out.println(" [.] fib(" + message + ")");

                        response += String.valueOf(fib(n));
                    }catch (RuntimeException e){
                        System.out.println(" [.] " + e.toString());
                    }finally {
                        channel.basicPublish("", properties.getReplyTo(), replyProps, response.getBytes("UTF-8"));

                        channel.basicAck(envelope.getDeliveryTag(), false);

                        // RabbitMq consumer worker thread notifies the RPC server owner thread
                        synchronized (this){
                            this.notify();
                        }
                    }
                }
            };

            channel.basicConsume(RPC_QUEUE_NAME, false, consumer);

            // Wait and be prepared to consume the message from RPC client.


            while(true){

                synchronized (consumer){
                    try{
                        consumer.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }catch (IOException | TimeoutException e){
            e.printStackTrace();
        }finally {
            if(connection != null){
                try{
                    connection.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
