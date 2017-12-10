package Servidores;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    private static int PORT = 9090;//instanciamos el puerto que vamos a utilizar
    public static void main(String [] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(PORT);// instanciamos un socket por el que enviaremos los datos
        System.out.println("Server listening on port"+PORT);//mu¿ostramos un mensaje de escuchandi        
        try{
            while(true){
                Socket socket = serverSocket.accept();//se crea un socket para el envio de la respuesta
                try{
                    PrintWriter out= new PrintWriter(socket.getOutputStream(),true);//se envia la respuesta
                    out.println("Message drom server");//mensaje que se mostrara al cliente
                }finally{
                    socket.close();//cerramos el socket
                }
            }
        }finally{
            serverSocket.close();//cerramos el socket del servidor
        }
    }    
}
