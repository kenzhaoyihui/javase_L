package rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    public final static String QUEUE_NAME = "rabbitMQ.test";

    public static  void main(String[] args) throws TimeoutException, IOException{
        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost("127.0.0.1");
//        connectionFactory.setUsername("root");
//        connectionFactory.setPassword("redhat");
//        connectionFactory.setPort(2000);

        Connection connection = connectionFactory.newConnection();

        //Create the channel
        Channel channel = connection.createChannel();

        //Queue
        /**
         * Return Param:
         * 1. Queue_name
         * 2. 是否持久化（true表示是，队列将在服务器重启时生存）
         * 3. 是否是独占队列（创建者可以使用的私有队列，断开后自动删除）
         * 4. 当所有消费者客户端连接断开时是否自动删除队列
         * 5. 为队列的其他参数
         */
        channel.queueDeclare(QUEUE_NAME, false, false, false, null );

        String message = null;

        for(int i=0; i<1000; i++){
            message = "hello" + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));


            System.out.println("Producer send: " + message + "....");
        }

        /**
         * Return Param:
         * 1. 交换机名称
         * 2. 队列映射的路由key
         * 3. 消息的其他属性
         * 4. 发送信息的主体
         */


        channel.close();
        connection.close();

    }
}
