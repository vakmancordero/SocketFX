package socketfx.server;

import socketfx.connection.Connection;
import socketfx.server.utils.MessageHandler;


class EchoHandler implements MessageHandler {
    
    @Override
    public void onReceive(Connection connection, String message) {
        connection.println(message);
    }
}