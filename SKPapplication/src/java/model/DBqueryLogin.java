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
public class DBqueryLogin
{
    Connection conn;
    
    
    public DBqueryLogin(Connection conn)
    {
        this.conn = conn;
    }
    
    
    
    public loginweb getDBqueryLoginPass(String USERNAME, String PASSWORD) throws SQLException
    {
        String sql = "SELECT username_login, password_login, nippns_login, kewenangan_login FROM loginweb WHERE username_login =? and password_login =?";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        loginweb ipns = null;
        pst.setString(1, USERNAME);
        pst.setString(2, PASSWORD);
        ResultSet rs = pst.executeQuery();
        if (rs.next())
        {
            ipns = new loginweb();
            ipns.setusername_login(rs.getString(1));
            ipns.setpassword_login(rs.getString(2));
            ipns.setnippns_login(rs.getString(3));
            ipns.setkewenangan_login(rs.getString(4));
        }
        return ipns;
    }
    
    
    
    
    public loginweb getDBqueryLoginPassByNip(String nip) throws SQLException
    {
        String sql = "SELECT username_login, password_login, nippns_login, kewenangan_login FROM loginweb WHERE nippns_login =?";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        loginweb ipns = null;
        pst.setString(1, nip);
        ResultSet rs = pst.executeQuery();
        if (rs.next())
        {
            ipns = new loginweb();
            ipns.setusername_login(rs.getString(1));
            ipns.setpassword_login(rs.getString(2));
            ipns.setnippns_login(rs.getString(3));
            ipns.setkewenangan_login(rs.getString(4));
        }
        return ipns;
    }
    
    
    
    
       public void hapusUser(String nipbaru) throws SQLException
       {
       
            String sql = "DELETE FROM loginweb where nippns_login ='"+ nipbaru +"'";
            PreparedStatement st = this.conn.prepareStatement(sql);    
            st.executeUpdate(sql);
            st.close();
        }
}
