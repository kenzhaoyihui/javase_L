package javaioexample.aio.client;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

public class WriteHandler implements CompletionHandler<Integer, ByteBuffer>{

    private AsynchronousSocketChannel clientChannel;
    private CountDownLatch latch;

    public WriteHandler(AsynchronousSocketChannel clientChannel, CountDownLatch latch){
        this.clientChannel = clientChannel;
        this.latch = latch;
    }


    @Override
    public void completed(Integer result, ByteBuffer attachment) {

        if (attachment.hasRemaining()){
            clientChannel.write(attachment, attachment, this);
        }else{
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            clientChannel.read(readBuffer, readBuffer, new ReadHandler(clientChannel, latch));
        }
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        System.out.println("Data sended failed...");
        try{
            clientChannel.close();
            latch.countDown();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
