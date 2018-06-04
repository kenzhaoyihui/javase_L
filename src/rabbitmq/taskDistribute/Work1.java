package rabbitmq.taskDistribute;

import com.rabbitmq.client.*;

import java.io.IOException;

import java.util.concurrent.TimeoutException;

public class Work1 {

    private static final String TASK_QUEUE_NAME = "task_queue";

    public static void main(String[] args) throws IOException, TimeoutException{
        final ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost("127.0.0.1");
        Connection connection = connectionFactory.newConnection();

        final Channel channel = connection.createChannel();

        channel.queueDeclare(TASK_QUEUE_NAME, false, false, false, null);

        System.out.println("Work1 waiting for message : ");


        //每次从队列获取的数量--
        channel.basicQos(1);

        final Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //super.handleDelivery(consumerTag, envelope, properties, body);
                String message = new String(body, "UTF-8");
                System.out.println("Work1 Received: " + message + "...");

                try{
                    //throw new Exception();
                    //doWork(message);
                }catch (Exception e){
                    channel.abort();
                }finally {
                    System.out.println("Work1 done");
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };

        boolean autoAck = false;
        //消息消费完成确认
        channel.basicConsume(TASK_QUEUE_NAME, autoAck, consumer);
    }


    private static void doWork(String task){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            //e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
