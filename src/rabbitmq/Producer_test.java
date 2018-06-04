package rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer_test {

    public static void main(String[] args) throws IOException, TimeoutException{

        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost("127.0.0.1");

        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();

        String exchangeName = "exchange_test";
        channel.exchangeDeclare(exchangeName, "direct", true);

        String routing_key = "redhat";

        String message = null;
        for(int i=0; i<1000; i++){
            message = "I am: " + i;
            channel.basicPublish(exchangeName, routing_key, null, message.getBytes("UTF-8"));
            System.out.println("Producer message: " + message);
        }

        channel.close();
        connection.close();

    }
}
