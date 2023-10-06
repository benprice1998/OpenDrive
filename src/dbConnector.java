import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnector {
    private String connector;
    dbConnector (String jdbc){
        this.connector = jdbc;
    }

    public Connection dbConnector() {
        //creating a connection variable
        Connection connection;
        //attempting to define connection properties
        try {
            //manually loading the driver, most systems do this automatically
            // but one of us did have an issue that this resolved
            Class.forName("com.mysql.jdbc.Driver");
            //refreshing the driver list
            DriverManager.getDrivers();
            System.out.println("JavaFilesAndServlets.Driver loaded....");
            //setting the connection to be the jdbc driver url for our AWS database
            connection = DriverManager.getConnection("jdbc:mysql://apptest.cyu0zp5qje42.us-east-2.rds.amazonaws.com:3306/sys", "****", "*******");
        }
        //error handling if there is a sql error or if the drivermanager cannot find the db driver
        catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error connecting to DB");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        //confirmation message in chat so that users can quickly verify db connectivity
        System.out.println("Connected to the database....");
        return connection;

    }
}
