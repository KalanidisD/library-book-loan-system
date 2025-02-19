import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;

public class queries {

public static void insertUser(user user){
    String query = "INSERT INTO user VALUES(?,?,?,?)";                               //query structure for inserting a new user
        try{
            DatabaseConnection.StartConnection(); //establish connection
            PreparedStatement stmt =DatabaseConnection.conn.prepareStatement(query); //prepare the statement

            stmt.setInt(1, user.getId());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getSurname());
            stmt.setString(4, user.getMail());

            stmt.executeUpdate();                                                   //execute the query

         }
        catch (Exception e) {
            System.out.println("Problem "+e.getMessage());
    }
            DatabaseConnection.closeConnection();                                   //close the connection
}


}
