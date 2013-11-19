/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author diptaisme
 */
public class DBqueryKeberatanPns
{
    Connection conn;
    
    
    
    public DBqueryKeberatanPns(Connection conn)
    {
        this.conn = conn;
    }
    
    
             
              
              
    public void insertRekomendasiPns(String nippns,String nipatasan,String periode,String rekomendasi) throws SQLException
    {
        String _nippns = nippns;
        String _nipatasan = nipatasan;
        String _periode = periode;
        String _rekomendasi = rekomendasi;
        
        String sql = "INSERT INTO rekomendasipns(nippns, nipatasan, periode, rekomendasi) VALUES('"+_nippns+"', '"+_nipatasan+"', '"+_periode+"', '"+_rekomendasi +"')";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.executeUpdate(sql);
        st.close();
        
    }
    
    
    
    
//    public void updateSimpanLogin(String usernamebaru,String passwordbaru,String kewenangan,String nipbaru) throws SQLException
//    {
//        String _nipbaru = nipbaru;
//        String _kewenangan = kewenangan;
//        String _passwordbaru = passwordbaru;
//        String _usernamebaru = usernamebaru;
//        
//        String sql = "UPDATE loginweb SET username_login = '"+_usernamebaru+"', password_login = '"+_passwordbaru+"', kewenangan_login = '"+_kewenangan+"' WHERE nippns_login = '"+_nipbaru +"'";
//        PreparedStatement st = this.conn.prepareStatement(sql);
//        st.executeUpdate(sql);
//        st.close();
//        
//    }
}
