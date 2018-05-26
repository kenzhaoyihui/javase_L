package javaioexample.aio.server;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;


//as the handler ro receive the client connection

public class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, AsyncServerHandler>{

    @Override
    public void completed(AsynchronousSocketChannel channel, AsyncServerHandler serverHandler) {
        Server.clientCount++;
        System.out.println("The number of the client connection is : " + Server.clientCount);

        serverHandler.channel.accept(serverHandler, this);

        //Create the new Buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //async read, the third args as the received message to invoke the business Handler
        channel.read(buffer, buffer, new ReadHandler(channel));


    }


    @Override
    public void failed(Throwable exc, AsyncServerHandler serverHandler) {
        exc.printStackTrace();
        serverHandler.latch.countDown();
    }
}
