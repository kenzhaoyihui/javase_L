package rabbitmq;


import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Customer {

    private final static String QUEUE_NAME = "rabbitMQ.test";

    public static void  main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");

        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        System.out.println("Customer waiting received message: ");


        //DefaultConsumer类实现了Consumer接口，通过传入一个频道，
        //告诉服务器我们需要那个频道的消息，如果频道中有消息，就会执行回调函数handleDelivery


        Consumer consumer = new DefaultConsumer(channel){
            @Override
            //Envelope envelope, envelope主要存放生产者相关信息（比如交换机、路由key等）body是消息实体
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //super.handleDelivery(consumerTag, envelope, properties, body);
                String message = new String(body, "UTF-8");
                System.out.println("Customer Received: " + message + ".....");
            }
        };

        //自动回复队列应答 -- RabbitMQ中的消息确认机制
        channel.basicConsume(QUEUE_NAME, true, consumer);

    }
}