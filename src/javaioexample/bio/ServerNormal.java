package javaioexample.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yzhao_sherry
 * @description ServerNormal
 * @version 1.0
 * @Data 2018.05.25
 */


public class ServerNormal {

    private static int DEFAULT_PORT = 12345;

    private static ServerSocket serverSocket;

    public static void start() throws IOException{
        start(DEFAULT_PORT);
    }

    public synchronized static void start(int port) throws IOException{
        if(serverSocket != null){
            return;
        }

        try{
            serverSocket = new ServerSocket(port);
            System.out.println("Server is started, port: " + port);
            Socket socket;

            while (true){

                //client connected
                socket = serverSocket.accept();

                new Thread(new ServerHandler(socket)).start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(serverSocket != null){
                System.out.println("Server is closed...");
                serverSocket.close();
                serverSocket = null;
            }
        }
    }
}
