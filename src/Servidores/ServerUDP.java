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
            serverSock.receive(receivePack);//recibe el paquete
            InetAddress clientAdd=receivePack.getAddress();//obtiene el IP de donde se envio el paquete
            int clientPort=receivePack.getPort();//obtiene el puerto que utilza el cliente
            System.out.println("Client port: "+clientPort);//muestra en consola el puerto usado por el cliente
            
            //Send Packet
            String msg="Mensaje de Richard Jorge Heredia";//mensaje que se envia
            byte bufferSend[]=msg.getBytes();//codifica el mensaje en un arreglo
            DatagramPacket sendPack=new DatagramPacket(bufferSend,bufferSend.length,clientAdd,clientPort);//se pone en el datagrama el mensaje codificado y el tamaño
            serverSock.send(sendPack);//envia el mensaje
            
        }
       }finally{
        serverSock.close();
        }  
    }
}
