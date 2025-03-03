import com.mysql.cj.xdevapi.Column;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GUI {

    public static void mainFrame() {
        Object []data;
        String []tableColumns={"id","username","password","firstname","lastname","email"};

       //DefaultTableModel model = new DefaultTableModel(data, tableColumns);

        JFrame frame = new JFrame("Lbrary Book Loan System"); // create item frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //frame settings
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(1900, 600);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel mainPanel = new JPanel();                            //create results panel
        mainPanel.setBounds(450,100,1000,600);
        mainPanel.setLayout(null);

        JButton resultsButton = new JButton("Show results");   //create  results button
        resultsButton.setFocusable(false);
        resultsButton.setBounds(850,800,150,100);

        JPanel buttonPanel = new JPanel();                          //create button panel
        buttonPanel.setBounds(850,800,150,100);
        buttonPanel.setLayout(null);

        JTable usersTable = new JTable(4,6);    //create user Table
        usersTable.setShowGrid(true);
        usersTable.setGridColor(Color.black);
        usersTable.setBorder(BorderFactory.createLineBorder(Color.black));
        usersTable.setBounds(0,0,1000,400);


        JScrollPane userPane = new JScrollPane(usersTable);

        mainPanel.add(usersTable);
        buttonPanel.add(resultsButton);

        frame.add(mainPanel);
        frame.add(buttonPanel);
        frame.setVisible(true);
    };
}
