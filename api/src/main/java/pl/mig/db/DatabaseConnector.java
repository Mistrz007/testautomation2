package pl.mig.db;

import pl.mig.qa.api.configuration.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static Connection connection = null;

    public static Connection getConnection(){
        if(connection==null){
            initConnection();
        }
        return connection;
    }

    private static void initConnection(){
        try {
            Class.forName(Configuration.DB_CLASS);
            connection = DriverManager.getConnection(Configuration.DB_URL,Configuration.DB_USER,Configuration.DB_PASS);
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
