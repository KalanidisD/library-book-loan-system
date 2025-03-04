import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;


public class GUI {

    public static void mainFrame() {

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

        JTable usersTable = new JTable();

        JScrollPane userPane = new JScrollPane(usersTable);

        usersTable.setBackground(Color.DARK_GRAY);
        usersTable.setForeground(Color.WHITE);
        usersTable.setFont(new Font("ITALIC", Font.BOLD, 15));
        usersTable.setShowGrid(true);
        usersTable.setGridColor(Color.black);
        usersTable.setBorder(BorderFactory.createLineBorder(Color.black));
        usersTable.setBounds(0, 0, 400, 499);

        userPane.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        userPane.setBounds(0, 0, 400, 500);

        JButton resultsButton = new JButton("Show all Users");   //create  results button
        resultsButton.setFocusable(false);
        resultsButton.setBounds(800, 600, 150, 100);

        JButton addButton = new JButton("Add User");
        addButton.setFocusable(false);
        addButton.setBackground(Color.green);
        addButton.setBounds(1000, 600, 150, 100);

        JButton deleteButton = new JButton("Delete User");
        deleteButton.setFocusable(false);
        deleteButton.setBounds(1200, 600, 150, 100);
        deleteButton.setBackground(Color.red);

        JLabel resultsLabel = new JLabel("Users");
        resultsLabel.setFont(resultsLabel.getFont().deriveFont(Font.BOLD, 25));
        resultsLabel.setForeground(Color.BLACK);
        resultsLabel.setBounds(200, 0, 100, 45);

        mainPanel.add(userPane);
        frame.add(resultsLabel);
        frame.add(addButton);
        frame.add(resultsButton);
        frame.add(deleteButton);
        frame.add(mainPanel);

        resultsButton.addActionListener(e -> {
            try {
                String query = "SELECT * FROM users";
                DatabaseConnection.StartConnection(); //establish connection
                PreparedStatement stmt = DatabaseConnection.conn.prepareStatement(query); //prepare the statement

                ResultSet rs = stmt.executeQuery();
                ResultSetMetaData rsmd = rs.getMetaData();
                int columns = rsmd.getColumnCount();

                Vector<String> columnNames = new Vector<>();

                for (int i = 0; i < columns; i++) {
                    columnNames.add(rsmd.getColumnName(i + 1));
                }

                Vector<Vector<Object>> data = new Vector<>();

                while (rs.next()) {
                    Vector<Object> row = new Vector<>();
                    for (int j = 0; j < columns; j++) {
                        Object value = rs.getObject(j + 1);
                        row.add(value);
                    }
                    data.add(row);
                }
                DefaultTableModel model = new DefaultTableModel(data, columnNames);
                usersTable.setModel(model);
                rs.close();
                stmt.close();
            } catch (SQLException r) {

                //if false
                System.out.println("Connection failed " + r.getMessage());
            }
        });

        addButton.addActionListener(e -> {
            JFrame addFrame = new JFrame("Add User");
            addFrame.setVisible(true);
            addFrame.setTitle("Add User");
            addFrame.setLocationRelativeTo(null);
            addFrame.setLayout(null);
            addFrame.setSize(400, 500);
            addFrame.setResizable(false);

            JLabel id = new JLabel("ID");
            id.setBounds(42, 40, 100, 30);
            id.setFont(new Font("ITALIC", Font.BOLD, 17));
            addFrame.add(id);

            JLabel name = new JLabel("Name");
            name.setBounds(23, 120, 100, 30);
            name.setFont(new Font("ITALIC", Font.BOLD, 17));
            addFrame.add(name);

            JLabel surname = new JLabel("Surname");
            surname.setBounds(6, 200, 100, 30);
            surname.setFont(new Font("ITALIC", Font.BOLD, 17));
            addFrame.add(surname);

            JLabel email = new JLabel("E-mail");
            email.setBounds(20, 280, 100, 30);
            email.setFont(new Font("ITALIC", Font.BOLD, 17));
            addFrame.add(email);

            JTextArea idArea = new JTextArea();
            idArea.setEditable(true);
            idArea.setBounds(100, 40, 200, 20);
            addFrame.add(idArea);

            JTextArea nameArea = new JTextArea();
            nameArea.setEditable(true);
            nameArea.setBounds(100, 120, 200, 20);
            addFrame.add(nameArea);

            JTextArea surnameArea = new JTextArea();
            surnameArea.setEditable(true);
            surnameArea.setBounds(100, 200, 200, 20);
            addFrame.add(surnameArea);

            JTextArea emailArea = new JTextArea();
            emailArea.setEditable(true);
            emailArea.setBounds(100, 280, 200, 20);
            addFrame.add(emailArea);

            JButton addUserButton = new JButton("Add User");
            addUserButton.setBounds(130, 350, 150, 30);
            addFrame.add(addUserButton);

            addUserButton.addActionListener(r -> {
                try {
                    String query = "INSERT INTO users VALUES(?,?,?,?)";                               //query structure for inserting a new user

                    DatabaseConnection.StartConnection(); //establish connection
                    PreparedStatement stmt = DatabaseConnection.conn.prepareStatement(query); //prepare the statement

                    stmt.setInt(1, Integer.parseInt(idArea.getText()));
                    stmt.setString(2, nameArea.getText());
                    stmt.setString(3, surnameArea.getText());
                    stmt.setString(4, emailArea.getText());

                    stmt.executeUpdate();
                    ActionEvent fakeEvent=new ActionEvent(resultsButton,ActionEvent.ACTION_PERFORMED,"");
                    resultsButton.getActionListeners()[0].actionPerformed(fakeEvent);
                    addFrame.setVisible(false);
                    System.out.println("Zitoumeno "+ ActionEvent.ACTION_PERFORMED);

                } catch (SQLException p) {
                    System.out.println("Failed becuz ");
                    p.printStackTrace();
                }
            });
        });

        deleteButton.addActionListener(r -> {
            JFrame deleteFrame = new JFrame("Delete User");
            deleteFrame.setVisible(true);
            deleteFrame.setTitle("Delete User");
            deleteFrame.setLocationRelativeTo(null);
            deleteFrame.setLayout(null);
            deleteFrame.setSize(400, 300);
            deleteFrame.setResizable(false);

            JLabel helpMessage = new JLabel("Please insert the id of the user you want to delete");
            helpMessage.setBounds(30,-45,450,150);
            helpMessage.setFont(new Font("ITALIC", Font.BOLD, 13));
            deleteFrame.add(helpMessage);

            JTextArea idArea = new JTextArea();
            idArea.setEditable(true);
            idArea.setBounds(150, 100, 20, 20);
            deleteFrame.add(idArea);

            JButton deleteUserButton = new JButton("Delete User!");
            deleteUserButton.setBounds(100, 180, 150, 30);
            deleteFrame.add(deleteUserButton);

            deleteUserButton.addActionListener(t->{

                try{

                    String query = "DELETE from USERS WHERE id=";                               //query structure for inserting a new user

                    DatabaseConnection.StartConnection(); //establish connection
                    PreparedStatement stmt = DatabaseConnection.conn.prepareStatement(query+Integer.parseInt(idArea.getText()));

                    stmt.execute();

                    System.out.println("Deleted User with ID: "+Integer.parseInt(idArea.getText()));
                    deleteFrame.setVisible(false);
                    ActionEvent fakeEvent=new ActionEvent(resultsButton,ActionEvent.ACTION_PERFORMED,"");
                    resultsButton.getActionListeners()[0].actionPerformed(fakeEvent);
                }
                catch(SQLException e){
                    e.printStackTrace();
                }

            });


        });
        frame.setVisible(true);


    };

}