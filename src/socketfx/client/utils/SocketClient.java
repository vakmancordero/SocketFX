package socketfx.client.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

//Clase para la conexion por medio de sockets
import java.net.Socket;

public class SocketClient {
    
    private Socket socket;

    public SocketClient(String ip, int port) {
        
        try {
            
            //Instancia de la clase 
            // parametros la dirección ip y el puerto
            socket = new Socket(ip, port);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void println(String message) {
        PrintWriter writer;
        try {
            //Entablamas la comunicación utlizando el socket como canal o interfaz
            writer = new PrintWriter(new OutputStreamWriter(
                                     socket.getOutputStream()), true);
            //Envio de datos por medio de la clase PrintWriter.
            writer.println(message);
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }

    /*
    This function blocks.
    */
    public String readLine() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(
                                        socket.getInputStream()));
            return reader.readLine();
        } catch (IOException e) {
            
            e.printStackTrace();
            return "";
        }
    }
    
    /*
     * Ready for use.
     */
    public void close() {
        try {
            if (socket != null && !socket.isClosed())
                socket.close();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
}