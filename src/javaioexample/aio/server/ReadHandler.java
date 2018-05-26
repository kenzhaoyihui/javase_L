package javaioexample.aio.server;

import javaioexample.utils.Calculator;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class ReadHandler implements CompletionHandler<Integer, ByteBuffer> {

    private AsynchronousSocketChannel channel;
    public ReadHandler(AsynchronousSocketChannel channel){
        this.channel = channel;
    }


    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        try{
            this.channel.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {

        attachment.flip();

        byte[] message = new byte[attachment.remaining()];
        attachment.get(message);

        try{
            String expression = new String(message, "UTF-8");
            System.out.println("Expression is: " + expression);

            String calResult = null;

            try{
                calResult = Calculator.Instance.cal(expression).toString();
            }catch (Exception e){
                calResult = "Error: " + e.getMessage();
            }
            doWrite(calResult);
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }

    private void doWrite(String result){
        byte[] bytes = result.getBytes();

        ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
        writeBuffer.put(bytes);

        writeBuffer.flip();

        channel.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                if(attachment.hasRemaining()){
                    channel.write(attachment, attachment, this);
                }else{
                    ByteBuffer readBuffer  = ByteBuffer.allocate(1024);
                    channel.read(readBuffer, readBuffer, new ReadHandler(channel));
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                try{
                    channel.close();
                }catch (IOException e){
                    e.printStackTrace();
                }

            }
        });
    }
}
