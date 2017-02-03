package socketfx.connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import socketfx.server.utils.SocketServer;

public class ListeningThread extends Thread {
    private SocketServer socketServer;
    private ServerSocket serverSocket;
    private List<ConnectionThread> connThreads;
    private boolean isRunning;

    public ListeningThread(SocketServer socketServer, ServerSocket serverSocket) {
        this.socketServer = socketServer;
        this.serverSocket = serverSocket;
        this.connThreads = new ArrayList<>();
        isRunning = true;
    }

    @Override
    public void run() {
        while(isRunning) {
            if (serverSocket.isClosed()) {
                isRunning = false;
                break;
            }
            
            try {
                Socket socket = serverSocket.accept();
                ConnectionThread conn = new ConnectionThread(socket, socketServer);
                connThreads.add(conn);
                conn.start();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void stopRunning() {
        for (int i = 0; i < connThreads.size(); i++)
            connThreads.get(i).stopRunning();
        isRunning = false;
    }
} 