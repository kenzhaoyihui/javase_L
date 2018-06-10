package com.yzhao.crud.bean.network;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(12900, 100, InetAddress.getByName("localhost"));

        System.out.println("Server started at: " + serverSocket);

        System.out.println("Waiting for a connection...");

        while (true){


            final Socket socket = serverSocket.accept();

            System.out.println("Received a connection from " + socket);

            System.out.println("Waiting for the client message...");

            //Runnable runnable = () -> handleClientRequest(socket);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    handleClientRequest(socket);
                }
            }).start();

        }
    }


    public static void handleClientRequest(Socket socket){
        try{
            BufferedReader socketReader = null;
            BufferedWriter socketWriter = null;

            socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String inMsg = null;

            while ((inMsg = socketReader.readLine()) != null){
                System.out.println("Received from Client: " + inMsg);

                String outMsg = inMsg;
                socketWriter.write(outMsg);
                socketWriter.write("\n");
                socketWriter.flush();
            }

            socket.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
