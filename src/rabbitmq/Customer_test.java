package rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Customer_test {

    public static void main(String[] args) throws IOException, TimeoutException{

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");

        Connection connection = connectionFactory.newConnection();

        final Channel channel = connection.createChannel();

        String exchangeName = "exchange_test";
        channel.exchangeDeclare(exchangeName, "direct", true);


        String queueName = channel.queueDeclare().getQueue();
        String routing_key = "redhat";


        channel.queueBind(queueName, exchangeName, routing_key);


        System.out.println("Customer received message from the producer: ");
        while(true){
            boolean autoAck = false;
            String consumerTag = "";
            channel.basicConsume(queueName, autoAck, consumerTag, new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    //super.handleDelivery(consumerTag, envelope, properties, body);
                    String routingKey = envelope.getRoutingKey();
                    String contentType = properties.getContentType();

                    System.out.println("RoutingKey: " + routingKey);
                    System.out.println("ContentType: " + contentType);


                    long deliverTag = envelope.getDeliveryTag();

                    channel.basicAck(deliverTag, false);
                    System.out.println("---------------------------------------Consumer content-------------------------------------------------------------" );
                    String bodycontent = new String(body, "UTF-8");
                    System.out.println(bodycontent);
                }
            });
        }

    }
}
