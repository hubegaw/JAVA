package chatServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class Server {
    private static final int port = 8989;
    private static ServerSocket serverSocket = null;

    public Server(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException ex) {
            System.out.println("Error in the server: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void work() {
        System.out.println("Chat Server is listening on port " + port);

        while(!serverSocket.isClosed()) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("New user has connected");

                ClientHandler clientHandler = new ClientHandler(socket);
                Thread th = new Thread(clientHandler);
                th.start();
            } catch(IOException e) {
                System.out.println("Could not listen on port " + port);
                closeServer();
            }
        }
    }

    public void closeServer() {
        try {
            if(serverSocket != null) {
                serverSocket.close();
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Server server = new Server(port);
        server.work();
        server.closeServer();
    }

}
