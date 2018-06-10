package com.yzhao.crud.bean.network;

import java.io.*;
import java.net.Socket;

public class Client1 {

    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("localhost", 12900);

        System.out.println("Started client at: " + socket.getLocalSocketAddress());

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        String promptMsg = "Please enter a messgae (Bye to quit): ";

        String outMsg = null;

        System.out.print(promptMsg);

        while ((outMsg = consoleReader.readLine()) != null){
            if ("quit".equals(outMsg)){
                break;
            }

            // Add a new line to the message to the server,
            // because the server reads one line at a time.
            bufferedWriter.write(outMsg);
            bufferedWriter.write("\n");
            bufferedWriter.flush();

            //Read and display the message from the server
            String inMsg = bufferedReader.readLine();
            System.out.println("Server: " + inMsg);
            System.out.println();
            System.out.print(promptMsg);


        }

    }
}
