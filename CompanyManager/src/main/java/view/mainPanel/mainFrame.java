package view.mainPanel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainFrame extends JFrame implements ActionListener {

    Container container = getContentPane();

    private JButton addNewWorkerButton = new JButton("add new worker");
    private JButton displayWorkersButton = new JButton("display workers");
    private JComboBox<String> workerFilters = new JComboBox<>();
    private JTable table;
    private JScrollPane allDataTable;

    Session s;
    SessionFactory sf;

    public mainFrame() {
        container.setLayout(null);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(550,150));
        table = new JTable(2,2);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        allDataTable = new JScrollPane(table);
        add(allDataTable, BorderLayout.NORTH);

        setButtonsAndFields();
        addComponentsToContainer();
        getDataFromDataBase();

        addNewWorkerButton.addActionListener(this);
    }

    private void setButtonsAndFields() {
        addNewWorkerButton.setBounds(150,300,100,30);
    }

    private void addComponentsToContainer() {

        container.add(addNewWorkerButton);
    }

    private void getDataFromDataBase() {

    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
