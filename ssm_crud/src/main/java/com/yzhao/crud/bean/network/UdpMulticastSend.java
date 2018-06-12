package com.yzhao.crud.bean.network;

/**
 * 组播IP地址不能用作数据包的源地址。
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UdpMulticastSend {

    public static void main(String[] args) throws Exception {

//        int mcPort = 12345;
//
//        String mcIPStr = "230.1.1.1";
//
//        DatagramSocket udpSocket = new DatagramSocket();
//
//        InetAddress mcIpAddress = InetAddress.getByName(mcIPStr);
//
//        byte[] msg = "Hello World!".getBytes();
//
//        DatagramPacket packet = new DatagramPacket(msg, msg.length);
//
//        packet.setAddress(mcIpAddress);
//        packet.setPort(mcPort);
//        udpSocket.send(packet);
//
//        System.out.println("Send a multicast message.");
//
//        System.out.println("Exiting the appliaction");
//
//        udpSocket.close();


        int port = 12345;
        String mcIPStr = "230.1.1.1";
        DatagramSocket udpSocket = new DatagramSocket();

        String msg = null;

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Please enter a message (Bye to quit): ");

        while ((msg = br.readLine()) != null) {

            if ("quit".equals(msg)) {
                break;
            }

            DatagramPacket packet = UdpMulticastSend.getPacket(msg, mcIPStr, port);

            udpSocket.send(packet);
            //udpSocket.receive(packet);
            System.out.print("Please enter a message (Bye to quit): ");
        }

    }

    public static DatagramPacket getPacket(String msg, String host, int port) throws UnknownHostException {
        int PACKET_MAX_LENGTH = 1024;
        byte[] msgBuffer = msg.getBytes();

        int length = msgBuffer.length;

        if (length > PACKET_MAX_LENGTH) {
            length = PACKET_MAX_LENGTH;
        }

        DatagramPacket packet = new DatagramPacket(msgBuffer, length);

        InetAddress serverIPAddress = InetAddress.getByName(host);

        packet.setAddress(serverIPAddress);

        packet.setPort(port);

        return packet;

    }
}
