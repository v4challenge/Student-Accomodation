package com.accommodation.dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.accommodation.util.Constant.*;

/**
 * @author chanthan
 */
public class DBConnector {
    //check
    //private static Connection con;

    private static Connection getConnection(){
        Connection con = null;
        try {
            Class.forName(MYSQL_DRIVER);
            con = DriverManager.getConnection(DB_URL+DB_NAME,DB_USER,DB_PASSWORD);
        } catch (Exception ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    static void executeQuery(String query) throws SQLException {
        //check getConnection();
        Connection con = getConnection();
        Statement stmt=null;
        try {
            stmt=con.createStatement();
            stmt.execute(query);
            System.out.println("Query executed successfully!");
        }
        catch (Exception ex) {
            System.out.println("Error in executing query!");
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        stmt.close();
        con.close();
    }

    public static ResultSet resultsetExecute(String query) throws SQLException{
        //check getConnection();
        Connection con = getConnection();
        Statement stmt=null;
        ResultSet resultset=null;
        try {
            stmt=con.createStatement();
            resultset=stmt.executeQuery(query);
            System.out.println("Query executed successfully!");
        }
        catch (Exception ex) {
            System.out.println("Error in executing query!");
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultset;
    }
}
