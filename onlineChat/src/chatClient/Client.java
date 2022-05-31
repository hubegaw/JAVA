package chatClient;

import java.io.*;
import java.net.Socket;

public class Client {
    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private String username;

    public Client(Socket socket, String username) {
        try {
            this.socket = socket;
            this.username = username;
            this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            sendMessage(this.username);
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sendMessage(String message) {
        try {
            writer.write("[" + username + "]: " + message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            removeClient();
        }
    }

    public String getMessage() {
        String message = null;
        try {
            message = reader.readLine();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return message;
    }

    public void removeClient() {
        try {
            socket.close();
            reader.close();
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    String getUsername() {
        return this.username;
    }

}
