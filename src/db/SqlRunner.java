package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by user on 08/07/2017.
 */

public class SqlRunner {


    private static Connection c = null;
    private static Statement stmt = null;

    private static void connect() {

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/db/contract.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }

    public static void closeConnection(){
        try{
            stmt.close();
            c.close();
        } catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static int executeUpdate(String sql) {
        int id = 0;
        try {
            connect();
            stmt.executeUpdate(sql);
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = (generatedKeys.getInt(1));
            }

            c.commit();


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return id;
    }

    public static ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        try {
            connect();
            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return rs;
    }

}