/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diptaisme
 */
public class DBqueryAdministrator 
{
    Connection conn;
    
    
    public DBqueryAdministrator(Connection conn)
    {
        this.conn = conn;
    }
    
    
    public void insertFotoBlob(String nippns, FileInputStream fotobinari) throws SQLException
    {
        try 
        {
            String _nippns = nippns;
            FileInputStream _fotobinari = fotobinari;

            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO fotobinary VALUES(?,?)");
            ps.setString(1, _nippns);
            ps.setBinaryStream(2, _fotobinari, _fotobinari.available());
            
            int i = ps.executeUpdate();
            if (i != 0) 
            {
                System.out.println("image inserted successfully");
            } 
            else 
            {
                System.out.println("problem in image insertion");
            }
            
            ps.close();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(DBqueryAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    public fotobinary getImageBlob(String sid_pns) throws SQLException
    {
        String sql = "SELECT * FROM fotobinary WHERE nippns =? ";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        fotobinary ipns = null;
        FileInputStream _fotobinari = null;
        pst.setString(1, sid_pns);
        ResultSet rs = pst.executeQuery();
        if (rs.next())
        {
            ipns = new fotobinary();
            ipns.setNippns(rs.getString(1));
            ipns.setFotobinari(_fotobinari);
            //ipns.setFotobinari(rs.getBinaryStream(2), _fotobinari, _fotobinari.available());
        }
        else
        {
            System.out.println("rs KOSONG");
        }
        return ipns;
    }
    
    
    
}
