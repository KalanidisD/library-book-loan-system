import java.awt.print.Book;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class queries {

    public static void insertUser(user user) {
        String query = "INSERT INTO user VALUES(?,?,?,?)";                               //query structure for inserting a new user
        try {
            DatabaseConnection.StartConnection(); //establish connection
            PreparedStatement stmt = DatabaseConnection.conn.prepareStatement(query); //prepare the statement

            stmt.setInt(1, user.getId());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getSurname());
            stmt.setString(4, user.getMail());

            stmt.executeUpdate();                                                   //execute the query

        } catch (Exception e) {
            System.out.println("Problem " + e.getMessage());
        }
        DatabaseConnection.closeConnection();                                   //close the connection
    }


    public static void showUsers() {                                                     //show all users method

        String query = "SELECT * FROM user";
        try {

            DatabaseConnection.StartConnection(); //establish connection
            PreparedStatement stmt = DatabaseConnection.conn.prepareStatement(query); //prepare the statement

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //loop through users
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String mail = rs.getString("email");

                System.out.println(id + " " + name + " " + surname + " " + mail + " ");

            }
        } catch (SQLException e) {

            System.out.println("Problem " + e.getMessage());                              //close connection

            }
            DatabaseConnection.closeConnection();


    }
}