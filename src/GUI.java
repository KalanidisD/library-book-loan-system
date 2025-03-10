import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class GUI {

    public static JFrame frame = new JFrame("Library Book Loan System");
    public static JFrame addFrame = new JFrame("Add User");
    public static JFrame deleteFrame = new JFrame("Delete User");
    public static JPanel mainPanel = new JPanel();
    public static JTable usersTable = new JTable();
    public static JScrollPane userPane = new JScrollPane(usersTable);
    public static JTextArea idArea = new JTextArea();
    public static JTextArea nameArea = new JTextArea();
    public static JTextArea surnameArea = new JTextArea();
    public static JTextArea emailArea = new JTextArea();
    public static JTextArea deleteIdArea =new JTextArea();
    public static JLabel resultsLabel = new JLabel("Users");
    public static JLabel id = new JLabel("ID");
    public static JLabel name = new JLabel("Name");
    public static JLabel surname = new JLabel("Surname");
    public static JLabel email = new JLabel("E-mail");
    public static JLabel helpMessage = new JLabel("Please insert the id of the user you want to delete");
    public static JButton addButton = new JButton("Add User1111");
    public static JButton deleteUserButton = new JButton("Delete User!");
    public static JButton addUserButton = new JButton("Add User");
    public static JButton resultsButton = new JButton("Show all Users");
    public static JButton deleteButton = new JButton("Delete User");

    public static void mainFrame() {                                        //creates the main frame where the curreny
                                                                            //user are being shown and all the available
        addUserButton.addActionListener(new events());                      //option
        deleteButton.addActionListener(new events());
        deleteUserButton.addActionListener(new events());
        addButton.addActionListener(new events());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //frame settings
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(1900, 600);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);

        mainPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        mainPanel.setBounds(0, 50, 600, 500);
        mainPanel.setBackground(Color.DARK_GRAY);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

        usersTable.setBackground(Color.DARK_GRAY);
        usersTable.setForeground(Color.WHITE);
        usersTable.setFont(new Font("ITALIC", Font.BOLD, 15));
        usersTable.setShowGrid(true);
        usersTable.setGridColor(Color.black);
        usersTable.setBorder(BorderFactory.createLineBorder(Color.black));
        usersTable.setBounds(0, 0, 400, 499);

        userPane.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        userPane.setBounds(0, 0, 400, 500);

        resultsButton.setFocusable(false);
        resultsButton.setBounds(800, 600, 150, 100);

        addButton.setFocusable(false);
        addButton.setBackground(Color.green);
        addButton.setBounds(1000, 600, 150, 100);

        deleteButton.setFocusable(false);
        deleteButton.setBounds(1200, 600, 150, 100);
        deleteButton.setBackground(Color.red);

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
            queries.showUsers();
        });

        queries.showUsers();
        frame.setVisible(true);

    }// end of mainFrame

    public static  void addFrame() {                                          //creates the frame to add a user
        addFrame.setVisible(true);
        addFrame.setTitle("Add User");
        addFrame.setLocationRelativeTo(null);
        addFrame.setLayout(null);
        addFrame.setSize(400, 500);
        addFrame.setResizable(false);

        id.setBounds(42, 40, 100, 30);
        id.setFont(new Font("ITALIC", Font.BOLD, 17));
        addFrame.add(id);

        name.setBounds(23, 120, 100, 30);
        name.setFont(new Font("ITALIC", Font.BOLD, 17));
        addFrame.add(name);

        surname.setBounds(6, 200, 100, 30);
        surname.setFont(new Font("ITALIC", Font.BOLD, 17));
        addFrame.add(surname);

        email.setBounds(20, 280, 100, 30);
        email.setFont(new Font("ITALIC", Font.BOLD, 17));
        addFrame.add(email);

        idArea.setEditable(true);
        idArea.setBounds(100, 40, 200, 20);
        addFrame.add(idArea);

        nameArea.setEditable(true);
        nameArea.setBounds(100, 120, 200, 20);
        addFrame.add(nameArea);

        surnameArea.setEditable(true);
        surnameArea.setBounds(100, 200, 200, 20);
        addFrame.add(surnameArea);

        emailArea.setEditable(true);
        emailArea.setBounds(100, 280, 200, 20);
        addFrame.add(emailArea);

        GUI.addUserButton.setBounds(130, 350, 150, 30);
        addFrame.add(GUI.addUserButton);
    }// end of addFrame

    public static void openDeleteFrame() {                                     //creates the frame for deletig a user

        GUI.deleteFrame.setVisible(true);
        GUI.deleteFrame.setTitle("Delete User");
        GUI.deleteFrame.setLocationRelativeTo(null);
        GUI.deleteFrame.setLayout(null);
        GUI.deleteFrame.setSize(400, 300);
        GUI.deleteFrame.setResizable(false);
         
        GUI.helpMessage.setBounds(30, -45, 450, 150);
        GUI.helpMessage.setFont(new Font("ITALIC", Font.BOLD, 13));
        GUI.deleteFrame.add(GUI.helpMessage);

        GUI.deleteIdArea.setEditable(true);
        GUI.deleteIdArea.setBounds(150, 100, 20, 20);
        GUI.deleteFrame.add(GUI.deleteIdArea);

        GUI.deleteUserButton.setBounds(100, 180, 150, 30);
        GUI.deleteFrame.add(GUI.deleteUserButton);

    }
}