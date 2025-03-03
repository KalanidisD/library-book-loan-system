import com.mysql.cj.xdevapi.Column;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;


public class GUI {



    public static void mainFrame() {
        Vector data = new Vector();
        Vector columnNames=new Vector();

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
        resultsButton.setBounds(800,600,150,100);


        resultsButton.addActionListener(e -> {
            try {
                String query = "SELECT * FROM users";
                DatabaseConnection.StartConnection(); //establish connection
                PreparedStatement stmt = DatabaseConnection.conn.prepareStatement(query); //prepare the statement

                ResultSet rs = stmt.executeQuery();
                ResultSetMetaData rsmd = rs.getMetaData();
                int columns=rsmd.getColumnCount();

                while (rs.next()) {
                    Vector row = new Vector(columns);
                    for(int i=1; i<= columns; i++) {
                        row.add(rs.getObject(i));
                    }
                    data.add(row);
                }
                rs.close();
                stmt.close();
            }
            catch(SQLException r){

                //if false
                System.out.println("Connection failed "+r.getMessage());
            }
        });

        DefaultTableModel model = new DefaultTableModel(data,columnNames );
        JTable usersTable = new JTable(model);    //create user Table
        usersTable.setBackground(Color.DARK_GRAY);
        usersTable.setForeground(Color.WHITE);
        usersTable.setFont(new Font("ITALIC", Font.BOLD, 15));
        usersTable.setShowGrid(true);
        usersTable.setGridColor(Color.black);
        usersTable.setBorder(BorderFactory.createLineBorder(Color.black));
        usersTable.setBounds(0,0,400,499);


        JScrollPane userPane = new JScrollPane(usersTable);
        userPane.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        userPane.setBounds(0,0,400,500);

        JLabel resultsLabel = new JLabel("Users");
        resultsLabel.setFont(resultsLabel.getFont().deriveFont(Font.BOLD,25));
        resultsLabel.setForeground(Color.BLACK);
        resultsLabel.setBounds(200,0,100,45);

        mainPanel.add(userPane);
        frame.add(resultsButton);
        frame.add(resultsLabel);
        frame.add(mainPanel);

        frame.setVisible(true);
    };
}
