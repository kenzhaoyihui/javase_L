package javaioexample.bio;

import javaioexample.utils.Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerHandler implements Runnable{

    private Socket socket;
    public ServerHandler(Socket socket){
        this.socket = socket;
    }


    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;

        try{
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            String expression;
            String result;

            while(true){
                if((expression = in.readLine()) == null){
                    break;
                }
                System.out.println("Server received message: " + expression);

                try{
                    //result = "123";
                    result = Calculator.Instance.cal(expression).toString();
                }catch (Exception e){
                    result = "Error message: " + e.getMessage();
                }

                out.println(result);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            //clean operation

            if(in != null){
                try {
                    in.close();
                }catch (IOException e){
                    e.printStackTrace();
                }

                in = null;
            }

            if (out != null){
                out.close();
                out = null;
            }

            if(socket != null){
                try{
                    socket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }

                socket = null;
            }
        }
    }
}
