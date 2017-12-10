package Clientes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JOptionPane;

public class ClienteTCP {
    private static int SERVER_PORT = 9090;//instanciamos el puerto que vamos a utilizar
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        String serverAddress =JOptionPane.showInputDialog(null,
                "Enter IP Address of machine that "+
                        "running the date service on port "+ SERVER_PORT+ 
                        ":");//ingresaremos el ip del servidor
        Socket clientSocket = new Socket(serverAddress,SERVER_PORT);//instanciamos un socket por el que recibiremos los datos
        //extraemos los datos y los presentamos por una ventana de mensaje
        InputStreamReader inputStream = new InputStreamReader(clientSocket.getInputStream());
        BufferedReader input = new BufferedReader(inputStream);
        String answer= input.readLine();
        
        JOptionPane.showMessageDialog(null, answer);
        //saldremos del sistema
        System.exit(0);
    }    
}
