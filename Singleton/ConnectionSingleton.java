package bd.edu.seu.bdcash.Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class  ConnectionSingleton {
    public static final String DB_HOST="localhost";
    public static final String DB_DATABSENAME="bdcash";
    public static final String DB_PASSWORD="1516747595@mysql";
    public static final String DB_USER="root";
    public static final String DB_URL="jdbc:mysql://"+DB_HOST+"/"+DB_DATABSENAME;
    private static Connection connection;
  private static  ConnectionSingleton singleton=new ConnectionSingleton();


    private ConnectionSingleton(){
        try{
             connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            System.out.println("database...");

        }catch (SQLException ex){
            ex.printStackTrace();
            System.err.println("Failled to connect database.");
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
