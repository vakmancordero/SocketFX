package socketfx.server.utils;

import socketfx.connection.Connection;

public interface MessageHandler {
    public void onReceive(Connection connection, String message);
}