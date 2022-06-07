package addressbook.pl.addresbook.view;

import addressbook.pl.addresbook.DatabaseConnector.Data;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddressBookView {
    private JPanel mainPanel = new JPanel();
    private JPanel displayBookPanel = new JPanel();
    private JLabel nameLabel = new JLabel("name");
    private JLabel surnameLabel = new JLabel("surname");
    private JLabel phoneNumberLabel = new JLabel("phone number");
    private JLabel streetLabel = new JLabel("street");
    private JLabel houseNumberLabel = new JLabel("house number");
    private JLabel apartmentNumberLabel = new JLabel("apartment number");
    private JLabel townLabel = new JLabel("town");
    private JLabel stateLabel = new JLabel("state");
    private JLabel countryLabel = new JLabel("country");
    private JLabel searchLabel = new JLabel("search by");
    private JLabel deletePersonLabel = new JLabel("insert person id to delete");

    private JTextField nameTextField = new JTextField();
    private JTextField surnameTextField = new JTextField();
    private JTextField phoneNumberTextField = new JTextField();
    private JTextField streetTextField = new JTextField();
    private JTextField houseNumberTextField = new JTextField();
    private JTextField apartmentNumberTextField = new JTextField();
    private JTextField townTextField = new JTextField();
    private JTextField stateTextField = new JTextField();
    private JTextField countryTextField = new JTextField();
    private JTextField deletePersonTextField = new JTextField();
    private JTextField searchInput = new JTextField();
    private JTextField updatePersonInput = new JTextField();
    private JComboBox namedQueries = new JComboBox();

    JButton searchButton = new JButton("search");
    JButton exitButton = new JButton("exit");
    JButton addButton = new JButton("add");
    JButton backButton = new JButton("back");
    JButton deleteButton = new JButton("delete");
    //JButton updateButton = new JButton("update");

    public AddressBookView() {
        prepareGUI();
    }

    private void prepareGUI() {
        JFrame window = new JFrame("Address Book");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(600,600);
        window.setLayout(new BorderLayout());

        final CardLayout cardLayout = new CardLayout();
        final JPanel controlPanel = new JPanel(cardLayout);

        setMainPanelComponents();

        controlPanel.add(mainPanel,"main");
        controlPanel.add(displayBookPanel,"display");
        displayBookPanel.setLayout(null);

        backButton.setBounds(500, 20, 70, 30);
        displayBookPanel.add(backButton);
        deleteButton.setBounds(150, 450, 70, 30);
        displayBookPanel.add(deleteButton);
        deletePersonTextField.setBounds(80, 450, 40, 30);
        displayBookPanel.add(deletePersonTextField);
        deletePersonLabel.setBounds(80, 420, 160, 30);
        displayBookPanel.add(deletePersonLabel);
        //updatePersonInput.setBounds(20, 370, 70, 30);
        //displayBookPanel.add(updatePersonInput);


    addButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
            List<String> info = new ArrayList<>();
            Collections.addAll(info, nameTextField.getText(), surnameTextField.getText(), phoneNumberTextField.getText(),
                    streetTextField.getText(), houseNumberTextField.getText(), apartmentNumberTextField.getText(), townTextField.getText(),
                    stateTextField.getText(), countryTextField.getText());

            if (nameTextField.getText().equals("") || surnameTextField.getText().equals("")) {
                JOptionPane.showMessageDialog(mainPanel, "Must have: name and surname!");
                return;
            }

            Data.create(info);
            nameTextField.setText("");
            surnameTextField.setText("");
            phoneNumberTextField.setText("");
            streetTextField.setText("");
            houseNumberTextField.setText("");
            apartmentNumberTextField.setText("");
            townTextField.setText("");
            stateTextField.setText("");
            countryTextField.setText("");
            cardLayout.show(controlPanel, "main");
        }
    });

    searchButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
            setDisplayBookPanel();
            cardLayout.show(controlPanel, "display");
        }
    });

    backButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.previous(controlPanel);

        }
    });

    exitButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
            System.exit(0);
        }
    });

    deleteButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
            String id = deletePersonTextField.getText();
            Data.delete(id);
        }
    });

    window.add(controlPanel,BorderLayout.CENTER);
    window.setVisible(true);
    }

    private void setDisplayBookPanel() {
        displayBookPanel.setLayout(null);
        int qNumber = namedQueries.getSelectedIndex();
        List<Object[]> persons = Data.getPersonsInfo(qNumber, searchInput.getText());
        String[] cols = {"no.", "name", "surname", "phone no.", "street", "house", "apartment", "town", "state", "country"};
        String[][] data = new String[persons.size()][cols.length];

        for(int i = 0; i < persons.size(); i++) {
            for(int j = 0; j < persons.get(0).length; j++) {
                if(persons.get(i)[j] == null) {
                    data[i][j] = "-";
                } else {
                    data[i][j] = persons.get(i)[j].toString();
                }
            }
        }

        JTable table = new JTable(data, cols);
        JTableHeader header = new JTableHeader();
        JScrollPane pane = new JScrollPane(table);
        header.setBackground(Color.pink);
        header = table.getTableHeader();
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        table.setEnabled(false);
        pane.setBounds(10, 50, 570, 350);
        displayBookPanel.add(pane);
    }

    private void setMainPanelComponents() {
        mainPanel.setLayout(null);
        exitButton.setBounds(500, 20, 70, 30);
        searchButton.setBounds(440, 450, 100, 30);
        addButton.setBounds(160, 400, 130, 30);
        nameLabel.setBounds(50, 40, 100, 30);
        surnameLabel.setBounds(50, 80, 100, 30);
        phoneNumberLabel.setBounds(50, 120, 100, 30);
        streetLabel.setBounds(50, 160, 100, 30);
        houseNumberLabel.setBounds(50, 200, 100, 30);
        apartmentNumberLabel.setBounds(50, 240, 100, 30);
        townLabel.setBounds(50, 280, 100, 30);
        stateLabel.setBounds(50, 320, 100, 30);
        countryLabel.setBounds(50, 360, 100, 30);
        searchLabel.setBounds(50, 450, 100, 30);

        nameTextField.setBounds(160, 40, 130, 30);
        nameTextField.setText("");
        surnameTextField.setBounds(160, 80, 130, 30);
        surnameTextField.setText("");
        phoneNumberTextField.setBounds(160, 120, 130, 30);
        phoneNumberTextField.setText("");
        streetTextField.setBounds(160, 160, 130, 30);
        streetTextField.setText("");
        houseNumberTextField.setBounds(160, 200, 130, 30);
        houseNumberTextField.setText("");
        apartmentNumberTextField.setBounds(160, 240, 130, 30);
        apartmentNumberTextField.setText("");
        townTextField.setBounds(160, 280, 130, 30);
        townTextField.setText("");
        stateTextField.setBounds(160, 320, 130, 30);
        stateTextField.setText("");
        countryTextField.setBounds(160, 360, 130, 30);
        countryTextField.setText("");
        searchInput.setBounds(300, 450, 120, 30);
        searchInput.setText("");
        namedQueries.setBounds(150, 450, 120, 30);

        List<String> queries = new ArrayList<>();
        queries.add("all");
        queries.add("name");
        queries.add("surname");
        queries.add("phone number");
        queries.add("town");
        queries.add("state");
        queries.add("country");
        for(String p : queries)
            namedQueries.addItem(p);

        mainPanel.add(exitButton);
        mainPanel.add(searchButton);
        mainPanel.add(addButton);
        mainPanel.add(nameLabel);
        mainPanel.add(surnameLabel);
        mainPanel.add(phoneNumberLabel);
        mainPanel.add(streetLabel);
        mainPanel.add(houseNumberLabel);
        mainPanel.add(apartmentNumberLabel);
        mainPanel.add(townLabel);
        mainPanel.add(stateLabel);
        mainPanel.add(countryLabel);
        mainPanel.add(searchLabel);

        mainPanel.add(nameTextField);
        mainPanel.add(surnameTextField);
        mainPanel.add(phoneNumberTextField);
        mainPanel.add(streetTextField);
        mainPanel.add(houseNumberTextField);
        mainPanel.add(apartmentNumberTextField);
        mainPanel.add(townTextField);
        mainPanel.add(stateTextField);
        mainPanel.add(countryTextField);
        mainPanel.add(namedQueries);
        mainPanel.add(searchInput);
    }

    public static void main(String[] args) {
        new AddressBookView();


    }
}
