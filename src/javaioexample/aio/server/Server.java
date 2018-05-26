package javaioexample.aio.server;

/**
 * @author kenzhaoyihui yzhao_sherry
 * @version 1.0
 */


public class Server {
    private static int DEFAULT_PORT = 12345;
    private static AsyncServerHandler asyncServerHandler;

    public volatile static long clientCount = 0;

    public static void start(){
        start(DEFAULT_PORT);
    }

    public static synchronized void start(int port){
        if(asyncServerHandler != null){
            return;
        }

        asyncServerHandler = new AsyncServerHandler(port);

        new Thread(asyncServerHandler, "Server").start();
    }


    public static void main(String[] args){
        Server.start();
    }
}
