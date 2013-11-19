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
public class DBqueryNilaiPrestasiKerja
{
    Connection conn;
    
    
    public DBqueryNilaiPrestasiKerja(Connection conn)
    {
        this.conn = conn;
    }
    
    
    public nilaiprestasikerja getNilaiPrestasiKerja(String nippns) throws SQLException
    {
        String sql = "SELECT nip_pns, skp, perilaku, prestasi, periode FROM nilaiprestasikerja WHERE nip_pns =? ";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        nilaiprestasikerja ipns = null;
        pst.setString(1, nippns);
        ResultSet rs = pst.executeQuery();
        if (rs.next())
        {
            ipns = new nilaiprestasikerja();
            ipns.setNipPns(rs.getString(1));
            ipns.setSkp(rs.getString(2));
            ipns.setPerilaku(rs.getString(3));
            ipns.setPrestasi(rs.getString(4));
            ipns.setPeriode(rs.getString(5));
           
        }
        return ipns;
    }
    
}
