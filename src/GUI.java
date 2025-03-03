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
        Object [][]data={{"John,", 1, 1, 1, 1, 1},
                         {"Jim",2,2,2,2,2},
                         {"Jim",2,2,2,2,2},
                         {"John,", 1, 1, 1, 1, 1},
                         {"Jim",2,2,2,2,2},
                         {"Jim",2,2,2,2,2},


        };
        String []tableColumns={"id","username","password","firstname","lastname","email"};

        DefaultTableModel model = new DefaultTableModel(data, tableColumns);

        JFrame frame = new JFrame("Library Book Loan System"); // create item frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //frame settings
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(1900, 600);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);

        JPanel mainPanel = new JPanel();                            //create results panel
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        mainPanel.setBounds(0, 50, 600, 500);
        mainPanel.setBackground(Color.DARK_GRAY);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

        JButton resultsButton = new JButton("Show results");   //create  results button
        resultsButton.setFocusable(false);
        resultsButton.setBounds(1300,600,150,100);

        JTable usersTable = new JTable(model);    //create user Table
        usersTable.setShowGrid(true);
        usersTable.setGridColor(Color.black);
        usersTable.setBorder(BorderFactory.createLineBorder(Color.black));
        usersTable.setBounds(0,0,400,499);

        JScrollPane userPane = new JScrollPane(usersTable);
        userPane.setBorder(BorderFactory.createLineBorder(Color.red));
        userPane.setBounds(0,0,400,500);

        JLabel resultsLabel = new JLabel("Users");
        resultsLabel.setFont(resultsLabel.getFont().deriveFont(Font.BOLD,25));
        resultsLabel.setForeground(Color.BLACK);
        resultsLabel.setBounds(200,0,100,45);

        mainPanel.add(userPane);
        frame.add(resultsLabel);
        frame.add(mainPanel);

        frame.setVisible(true);
    };
}
