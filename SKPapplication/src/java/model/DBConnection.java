/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author diptaisme
 */
public class DBConnection
{
    Connection conn = null;
    
    public DBConnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
           // conn = DriverManager.getConnection("jdbc:mysql://localhost/skpwebbased","root","admin");
             conn = DriverManager.getConnection("jdbc:mysql://localhost/skpwebbased","root","");
            
            //untuk koneksi ke komputer lain yg ip nya sudah diketahui
            //conn = DriverManager.getConnection("jdbc:mysql://192.168.200.61:8084/skpwebbased","root","admin");
        }
        catch(Exception e)
        {
            System.out.println("Pesan Kesalahan : "+e.getMessage());
        } 
    }
    
    public Connection getConnection()
    {
        return this.conn;
    }
    
    public void closeConnection()
    {
        if (this.conn != null)
        {
            try
            {
                this.conn.close();
            }
            catch(Exception ex)
            {
                
            }
        }
    }
}
