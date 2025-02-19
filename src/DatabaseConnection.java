import java.sql.Connection;
import java.sql.DriverManager;

import static java.lang.Class.forName;

public class DatabaseConnection {

    private static final String url="jdbc:mysql://localhost:3306/library";
    private static final String USER="root";
    private static final String PASSWORD="";

    //Test connection method

    public static boolean TestConnection(){
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,USER,PASSWORD);
            //if success
            System.out.println("Connected to database!");
            return true;

        }catch(Exception e){
            //if false
            System.out.println("Connection failed "+e.getMessage());
            return false;
        }
    }
};
