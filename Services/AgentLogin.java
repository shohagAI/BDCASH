package bd.edu.seu.bdcash.Services;

import bd.edu.seu.bdcash.Singleton.ConnectionSingleton;

import java.sql.Connection;

import static java.lang.Class.forName;

public class AgentLogin {
    public static Connection connectbd(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect= ConnectionSingleton.getConnection();
            return connect;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
