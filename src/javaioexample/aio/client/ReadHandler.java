package javaioexample.aio.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

public class ReadHandler implements CompletionHandler<Integer, ByteBuffer> {

    private AsynchronousSocketChannel clientChannel;
    private CountDownLatch latch;

    public ReadHandler(AsynchronousSocketChannel clientChannel, CountDownLatch latch){
        this.clientChannel = clientChannel;
        this.latch = latch;
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        attachment.flip();
        byte[] bytes = new byte[attachment.remaining()];

        attachment.get(bytes);

        String body;

        try{
            body = new String(bytes, "UTF-8");
            System.out.println("Client rceived the result: " + body);
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        System.out.println("Data read failed...");
        try{
            clientChannel.close();
            latch.countDown();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
