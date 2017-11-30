package Clientes;

import java.io.IOException;
import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;
/*
author Richard Jorge Heredia
 */
public class ClienteUDP {
    private static int SERVER_PORT=9091;
    public static void main(String[] args) throws IOException {
        String sAdress = JOptionPane.showInputDialog("Enter IP Adress connect on port "+SERVER_PORT+":");
        
        //Request
        DatagramSocket clientSock=new DatagramSocket();
        byte bufferSend[]=sAdress.getBytes();
        DatagramPacket sendPack= new DatagramPacket(bufferSend,bufferSend.length,InetAddress.getByName(sAdress),SERVER_PORT);
        clientSock.send(sendPack);
        //Receive packet
        byte bufferReceive[]=new byte[128];
            DatagramPacket receivePack=new DatagramPacket(bufferReceive,bufferReceive.length);
            clientSock.receive(receivePack);
    
         //Transforma bytes a String
            InputStream myInputStream = new ByteArrayInputStream(receivePack.getData());
            BufferedReader input =  new BufferedReader(new InputStreamReader(myInputStream));
            String answer= input.readLine();
         //Despliega mensaje
            JOptionPane.showConfirmDialog(null, answer);
            clientSock.close();
            System.exit(0);
    } 
}
