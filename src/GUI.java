import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GUI {

    public static void mainFrame() {
        JFrame frame = new JFrame("Lbrary Book Loan System");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(400, 400);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        JButton resultsButton = new JButton("Show results");

        resultsButton.setFocusable(false);
        resultsButton.setBounds(850,800,150,100);


        JTextArea resultsTextArea = new JTextArea();
        resultsTextArea.setEditable(false);
        resultsTextArea.setLineWrap(true);
        resultsTextArea.setWrapStyleWord(true);
        JScrollPane resultsScrollPane = new JScrollPane(resultsTextArea);
        resultsTextArea.setBounds(0, 0, 1000, 500);





        frame.add(mainPanel);
        mainPanel.add(resultsButton);
        mainPanel.add(resultsScrollPane);
        mainPanel.add(resultsTextArea);




    };
}
