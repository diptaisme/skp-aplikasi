/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diptaisme
 */
public class DBConnection {

    private Connection conn = null;
    private static DBConnection instance = null;

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    private DBConnection() {
        
        try {
            Class.forName(DBProperties.DB_DRIVER);            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Pesan Kesalahan : " + e.getMessage());
        }
    }

    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public Connection getConnection(){
        try {
            conn = DriverManager.getConnection(DBProperties.DB_URL, DBProperties.DB_USERNAME, DBProperties.DB_PASSWORD);
            return conn;
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
