package chatServer;

import java.io.*;
import java.net.*;
import java.util.HashSet;
import java.util.Set;

public class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedWriter writer;
    private BufferedReader reader;
    private String username;

    private Set<ClientHandler> clients = new HashSet<>();

    public ClientHandler(Socket socket) {
        try {
            this.socket = socket;
            this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.username = reader.readLine();

            clients.add(this);
            sendMessage(this.username + "has joined the chat!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sendMessage(String message) throws IOException {
        for(ClientHandler client : clients) {
            client.writer.write(message);
            client.writer.newLine();
            client.writer.flush();
        }
    }

    public void removeClient() {
        try {
            sendMessage(this.username + " has left the chat.");
            clients.remove(this);
            System.out.println("Client has left the chat");

            socket.close();
            reader.close();
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String message;
        while(!socket.isClosed()) {
            try {
                message = reader.readLine();
                if(message != null) {
                    sendMessage(message);
                }
                else {
                    removeClient();
                    break;
                }
            } catch(IOException e) {
                e.printStackTrace();
                removeClient();
                break;
            }
        }
    }
}