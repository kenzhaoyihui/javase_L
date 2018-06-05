package rabbitmq.RabbitMQRPC;


import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeoutException;

public class rabbitmqRpcClient {

    private Connection connection;
    private Channel channel;
    private String requestQueueName = "rpc_queue";

    private String replyQueueName;


    public rabbitmqRpcClient() throws IOException, TimeoutException{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");

        connection = factory.newConnection();

        channel = connection.createChannel();

        replyQueueName = channel.queueDeclare().getQueue();
    }

    public String call(String message) throws IOException, InterruptedException{
        final String corrId = UUID.randomUUID().toString();

        AMQP.BasicProperties props = new AMQP.BasicProperties
                .Builder()
                .correlationId(corrId)
                .replyTo(replyQueueName)
                .build();

        channel.basicPublish("", requestQueueName, props, message.getBytes("UTF-8"));

        final BlockingQueue<String> response = new ArrayBlockingQueue<>(1);
        channel.basicConsume(replyQueueName, true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //super.handleDelivery(consumerTag, envelope, properties, body);

                if (properties.getCorrelationId().equals(corrId)){
                    response.offer(new String(body, "UTF-8"));
                }
            }
        });

        return response.take();
    }

    public void close() throws IOException{
        connection.close();
    }

    public static void main(String[] args) throws IOException{
        rabbitmqRpcClient client = null;
        String response;

        try{
            client = new rabbitmqRpcClient();
            System.out.println("RPCClient Requesting fib(20)");

            response = client.call("7");

            System.out.println("RPCClient Got:  " + response + "...");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(client != null){
                client.close();
            }
        }
    }

}
