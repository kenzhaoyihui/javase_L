package com.yzhao.crud.bean.network;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class UdpMulticastRecv {

    public static void main(String[] args) throws Exception{
        int mcPort = 12345;
        String mcIPStr = "230.1.1.1";
        MulticastSocket mcSocket = null;

        InetAddress mcIPAddress = InetAddress.getByName(mcIPStr);

        mcSocket = new MulticastSocket(mcPort);

        System.out.println("Multicast Receiver running as: " + mcSocket.getLocalSocketAddress());

        mcSocket.joinGroup(mcIPAddress);

        //DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
        System.out.println("Waiting for a multicast message...");


        while (true){
            //System.out.println("Waiting for a UDP packet...");
            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
            String msg = new String(packet.getData(), packet.getOffset(), packet.getLength());

            mcSocket.receive(packet);

//            System.out.println("[Multicast  Receiver] Received:" + msg.toString());

            displayPacketDetails(packet);
        }

        //mcSocket.receive(packet);

        //String msg = new String(packet.getData(), packet.getOffset(), packet.getLength());

        //System.out.println("[Multicast  Receiver] Received:" + msg);

//        mcSocket.leaveGroup(mcIPAddress);
//
//        mcSocket.close();

    }

    public static void displayPacketDetails(DatagramPacket packet){

        byte [] msgBuffer = packet.getData();
        int length = packet.getLength();
        int offset = packet.getOffset();

        int remotePort = packet.getPort();

        InetAddress remoteAddr = packet.getAddress();

        String msg = new String(msgBuffer, offset, length);

        System.out.println("Received a packet: [IP Address=" + remoteAddr + ", port=" + remotePort + ", message=" + msg + "]");

    }
}
