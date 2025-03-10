import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.print.Book;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

public class queries {

    public static void insertUser() {

        try {
            String query = "INSERT INTO users VALUES(?,?,?,?)";                               //query structure for inserting a new user

            DatabaseConnection.StartConnection(); //establish connection
            PreparedStatement stmt = DatabaseConnection.conn.prepareStatement(query); //prepare the statement

            stmt.setInt(1, Integer.parseInt(GUI.idArea.getText()));
            stmt.setString(2, GUI.nameArea.getText());
            stmt.setString(3,GUI.surnameArea.getText());
            stmt.setString(4, GUI.emailArea.getText());

            GUI.idArea.setText("");
            GUI.nameArea.setText(null);
            GUI.surnameArea.setText(null);
            GUI.emailArea.setText(null);

            stmt.executeUpdate();
            queries.showUsers();
            GUI.addFrame.setVisible(false);
           // GUI.addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            System.out.println("Zitoumeno " + ActionEvent.ACTION_PERFORMED);

        } catch (SQLException p) {
            System.out.println("Failed becuz ");
            p.printStackTrace();
        }
    }// end if


    public static void showUsers() {                                                     //show all users method
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
            GUI.usersTable.setModel(model);
            rs.close();
            stmt.close();
        } catch (SQLException r) {
            //if fails
            System.out.println("Connection failed " + r.getMessage());
        }
    }// end showUsers()

    public static void deleteUser() {
        System.out.println("working here 1");
             try {
                String query = "DELETE from USERS WHERE id=";                               //query structure for inserting a new user

                DatabaseConnection.StartConnection(); //establish connection
                PreparedStatement stmt = DatabaseConnection.conn.prepareStatement(query + Integer.parseInt(GUI.deleteIdArea.getText()));
                System.out.println("working here");
                stmt.execute();

                System.out.println("Deleted User with ID: " + Integer.parseInt(GUI.deleteIdArea.getText()));
                queries.showUsers();
                GUI.deleteIdArea.setText(null);
                GUI.deleteFrame.setVisible(false);

             } catch (SQLException t) {
                t.printStackTrace();
        }
    }// end of delete
}