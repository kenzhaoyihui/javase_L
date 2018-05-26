package javaioexample.nio;

import javaioexample.utils.Calculator;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class ServerHandler implements Runnable {

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;

    private volatile boolean started;

    public ServerHandler(int port){
        try{
            selector = Selector.open();

            serverSocketChannel = ServerSocketChannel.open();

            serverSocketChannel.configureBlocking(false);

            serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024);

            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            started = true;

            System.out.println("Server is started, port: " + port);
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }

    }

    public void stop(){
        started = false;
    }

    @Override
    public void run() {

        while(started){
            try{
                selector.select(1000);

                //selector.select();

                Set<SelectionKey> keys = selector.selectedKeys();

                Iterator<SelectionKey> iterator = keys.iterator();

                SelectionKey key = null;

                while(iterator.hasNext()){
                    key = iterator.next();
                    iterator.remove();

                    try{
                        handleInput(key);
                    }catch (Exception e){
                        if(key != null){
                            key.cancel();

                            if(key.channel() != null){
                                key.channel().close();
                            }
                        }
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        if (selector != null){
            try{
                selector.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException{
        if(key.isValid()){
            if(key.isAcceptable()){
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();

                SocketChannel sc = ssc.accept();

                sc.configureBlocking(false);

                sc.register(selector, SelectionKey.OP_READ);
            }

            if(key.isReadable()){
                SocketChannel sc = (SocketChannel) key.channel();

                ByteBuffer buffer = ByteBuffer.allocate(1024);

                int readBytes = sc.read(buffer);

                if(readBytes>0){
                    buffer.flip();

                    byte[] bytes = new byte[buffer.remaining()];

                    buffer.get(bytes);

                    String expression = new String(bytes, "UTF-8");

                    System.out.println("Expression is " + expression);

                    String result = null;

                    try{
                        result = Calculator.Instance.cal(expression).toString();
                    }catch (Exception e){
                        result = "Error: " + e.getMessage();
                    }

                    doWrite(sc, result);
                }else if(readBytes<0){
                    key.cancel();
                    sc.close();
                }
            }
        }
    }


    private void doWrite(SocketChannel channel, String response) throws  IOException{

        byte[] bytes = response.getBytes();

        ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);

        writeBuffer.put(bytes);

        writeBuffer.flip();

        channel.write(writeBuffer);
    }
}
