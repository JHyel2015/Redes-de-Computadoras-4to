package Servidores;

import java.io.IOException;
import java.net.*;
//autor: Richard Jorge Heredia
public class ServerUDP {
    private static int PORT=9091;    
    public static void main(String[] args )throws IOException{
        DatagramSocket serverSock = new DatagramSocket(PORT);
        System.err.println("Server listening on PORT "+PORT+" UDP conection");
        long initialTime=System.currentTimeMillis();
        System.out.println("Tiempo Inicial: "+initialTime+" /n");
        
        try{
        while(true){
            //Receive Packet
         byte bufferReceive[]=new byte[128];
            DatagramPacket receivePack=new DatagramPacket(bufferReceive,bufferReceive.length);
            serverSock.receive(receivePack);
            InetAddress clientAdd=receivePack.getAddress();
            int clientPort=receivePack.getPort();
            System.out.println("Client port: "+clientPort);
            
            //Send Packet
            String msg="Hola Mundo";
            byte bufferSend[]=msg.getBytes();
            DatagramPacket sendPack=new DatagramPacket(bufferSend,bufferSend.length,clientAdd,clientPort);
            serverSock.send(sendPack);
            
        }
       }finally{
        serverSock.close();
        }  
    }
}
