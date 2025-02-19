import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.forName;

public class DatabaseConnection {

    private static final String url="jdbc:mysql://localhost:3306/library";
    private static final String USER="root";
    private static final String PASSWORD="";
    public static Connection conn;

    public static void StartConnection(){                               //Start connection method
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,USER,PASSWORD);

            //if success
            System.out.println("Connected to database established!");
            }

        catch(Exception e){

            //if false
            System.out.println("Connection failed "+e.getMessage());
         }
        }

    public static void closeConnection(){                               //close connection method
      try{
          conn.close();
          System.out.println("Connection closed successfully!");
        }

       catch (SQLException e) {
           System.out.println("Connection Failed to close");
       }
   }
};
