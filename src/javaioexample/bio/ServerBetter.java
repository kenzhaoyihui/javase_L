package javaioexample.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerBetter {
    private static int DEFAULT_PORT = 12345;

    //singleton (lazy men)
    private static ServerSocket serverSocket;

    private static ExecutorService executorService = Executors.newFixedThreadPool(60);

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

            while(true){
                socket = serverSocket.accept();

                executorService.execute(new ServerHandler(socket));
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if(serverSocket != null){
                System.out.println("Server is closed...");
                serverSocket.close();
                serverSocket = null;
            }
        }
    }
}
