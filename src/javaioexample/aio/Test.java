package javaioexample.aio;

//import javaioexample.nio.Client;
//import javaioexample.nio.Server;

import javaioexample.aio.client.Client;
import javaioexample.aio.server.Server;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws Exception{
        Server.start();

        Thread.sleep(1000);

        Client.start();

        Scanner scanner = new Scanner(System.in);

        while(Client.sendMsg(scanner.nextLine()));
    }
}
