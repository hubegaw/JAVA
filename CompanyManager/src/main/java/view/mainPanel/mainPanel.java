package view.mainPanel;

import javax.swing.*;

public class mainPanel {
    public mainPanel() {
        mainFrame frame = new mainFrame();
        frame.setTitle("main Form");
        frame.setVisible(true);
        frame.setBounds(10, 10, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}
