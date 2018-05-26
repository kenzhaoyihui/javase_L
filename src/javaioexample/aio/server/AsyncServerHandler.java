package javaioexample.aio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

public class AsyncServerHandler implements Runnable {

    public CountDownLatch latch;
    public AsynchronousServerSocketChannel channel;

    public AsyncServerHandler(int port){
        try{
            channel = AsynchronousServerSocketChannel.open();

            channel.bind(new InetSocketAddress(port));

            System.out.println("Server is started, port: " + port);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        //CountDownLatch init
        //its effort: before one group operations finished, please block the event
        //avoid the server exit after finishing the operations
        //by the way, in the production, the server is not exit, and did't care this problem in the production.

        latch = new CountDownLatch(1);

        channel.accept(this, new AcceptHandler());
        try{
            latch.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
