package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import chatClient.Client;

public class ClientView {
    static Client client;
    static String appName = "chat online";
    static JFrame mainFrame = new JFrame(appName);
    static JButton sendMessage;
    static JTextField messageBox;
    static JTextArea chatBox;
    static JTextField usernameField;
    static JFrame enterFrame;
    static String username;

    public static void main(String[] args) {

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        LoginPanel();
    }

    public static void LoginPanel() {
        mainFrame.setVisible(false);
        enterFrame = new JFrame(appName);
        usernameField = new JTextField(15);
        JLabel chooseUsernameLabel = new JLabel("Enter a username:");
        JButton enterServer = new JButton("Enter Chat Server");
        enterServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username = usernameField.getText();
                if (username.length() > 0) {
                    enterFrame.setVisible(false);
                    chatPanel();
                }
            }
        });
        JPanel logPanel = new JPanel(new GridBagLayout());

        GridBagConstraints preRight = new GridBagConstraints();
        GridBagConstraints preLeft = new GridBagConstraints();

        logPanel.add(chooseUsernameLabel, preLeft);
        logPanel.add(usernameField, preRight);
        enterFrame.add(logPanel, BorderLayout.CENTER);
        enterFrame.add(enterServer, BorderLayout.SOUTH);
        enterFrame.setSize(300, 300);
        enterFrame.setVisible(true);
    }

    public static void chatPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel textPanel = new JPanel();
        textPanel.setBackground(Color.GRAY);
        textPanel.setLayout(new GridBagLayout());

        createClient();
        getMessage();

        messageBox = new JTextField(30);
        messageBox.requestFocusInWindow();

        sendMessage = new JButton("Send Message");
        sendMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "";
                message = messageBox.getText();
                if(!message.equals("")) {
                    if(message.equals("/exit")){
                        client.removeClient();
                        System.exit(1);
                    }
                    client.sendMessage(message);
                    messageBox.setText("");
                }
            }
        });

        chatBox = new JTextArea();
        chatBox.setEditable(false);
        chatBox.setFont(new Font("Serif", Font.PLAIN, 15));
        chatBox.setLineWrap(true);

        mainPanel.add(new JScrollPane(chatBox), BorderLayout.CENTER);

        textPanel.add(messageBox);
        textPanel.add(sendMessage);

        mainPanel.add(BorderLayout.SOUTH, textPanel);

        mainFrame.add(mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 300);
        mainFrame.setVisible(true);
    }

    private static void createClient() {
        try {
            Socket socket = new Socket("localhost", 8989);
            client = new Client(socket, username);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static void getMessage() {
        new Thread(new Runnable() {
            String message;

            @Override
            public void run() {
                while(client.getMessage() != null) {
                    message = client.getMessage();
                    chatBox.append(message + "\n");
                }
            }
        }).start();

    }
}