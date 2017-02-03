package socketfx.connection;

import java.net.Socket;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Connection {
    
    private Socket socket;

    public Connection(Socket socket) {
        this.socket = socket;
    }

    public void println(String message) {
        
        PrintWriter writer;
        
        try {
            
            writer = new PrintWriter(
                    new OutputStreamWriter(socket.getOutputStream()), true
            );
            
            writer.println(message);
            System.out.println();
            
        } catch (IOException e) {
            
            e.printStackTrace();
            
        }
    }
}