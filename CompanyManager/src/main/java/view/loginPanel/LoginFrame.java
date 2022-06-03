package view.loginPanel;

import entity.WorkersEntity;
import view.mainPanel.mainPanel;

import javax.persistence.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class LoginFrame extends JFrame implements ActionListener {

        Container container = getContentPane();
        private JLabel loginField = new JLabel("username");
        private JTextField loginInput = new JTextField();
        private JLabel passwordField = new JLabel("password");
        private JPasswordField passwordInput = new JPasswordField();
        private JButton logInButton = new JButton("log in");
        LoginFrame() {
            container.setLayout(null);
            setButtonsAndFields();
            addComponentsToContainer();

            logInButton.addActionListener(this);
        }

        private void setButtonsAndFields() {
            loginField.setBounds(50,150,100,30);
            passwordField.setBounds(50,220,100,30);
            loginInput.setBounds(150,150,150,30);
            passwordInput.setBounds(150,220,150,30);
            logInButton.setBounds(150,300,100,30);
        }

        private void addComponentsToContainer() {
            container.add(loginField);
            container.add(passwordField);
            container.add(loginInput);
            container.add(passwordInput);
            container.add(logInButton);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String username, password;

            username = loginInput.getText();
            password = passwordInput.getText();

            if (!username.equalsIgnoreCase("admin") || !password.equalsIgnoreCase("passwd")) {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
            } else {
                this.setVisible(false);
                EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
                EntityManager entityManager = entityManagerFactory.createEntityManager();
                EntityTransaction transaction = entityManager.getTransaction();
                try {
                    TypedQuery<WorkersEntity> q = entityManager.createNamedQuery("WorkersEntity.ByName", WorkersEntity.class);
                    q.setParameter(1, "HR");
                    for(WorkersEntity w : q.getResultList()) {
                        System.out.println(w);
                    }
                } finally {
                    if(transaction.isActive()){
                        transaction.rollback();
                    }
                }
                new mainPanel();
            }
        }
    }

