/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diptaisme
 */
public class DbqueryINS
{
    Connection conn;
    
    
    public DbqueryINS(Connection conn)
    {
        this.conn = conn;
    }
    
    
    
    public instansiri getDBqueryINS(String sidInstansi) throws SQLException
    {
        String sql = "SELECT id_instansi, nama_instansi, cepat_kode "
                + " FROM instansiri "
                + " WHERE id_instansi =? ";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        instansiri ins = null;
        pst.setString(1, sidInstansi);
        ResultSet rs = pst.executeQuery();
        if (rs.next())
        {
            ins = new instansiri();
            ins.setIdInstansi(rs.getString(1));
            ins.setNamaInstansi(rs.getString(2));
            ins.setCepatKode(rs.getString(3));
        }
        return ins;
    }
    
    public List<instansiri> getDBqueryInstansiRi() throws SQLException
    {
        List<instansiri> instansies = new ArrayList<instansiri>();
        String sql = "SELECT * FROM instansiri";
        PreparedStatement pst = this.conn.prepareStatement(sql);
//        DBqueryPNS nDBqueryPNS = null;
//        pst.setString(1, sidInstansi);
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            instansiri insri = new instansiri();
            insri.setIdInstansi(rs.getString(1));
            insri.setNamaInstansi(rs.getString(2));
            insri.setCepatKode(rs.getString(3));
            instansies.add(insri);
        }
        return instansies;
    }
    
    public List<instansiri> getDBqueryCariINS(String snamaInstansi) throws SQLException
    {
        List<instansiri> instansiesByCriteria = new ArrayList<instansiri>();
        String sql = "SELECT id_instansi, nama_instansi, cepat_kode "
                + " FROM instansiri "
                + " WHERE nama_instansi like '%"+snamaInstansi+"%'";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            instansiri insri = new instansiri();
            insri.setIdInstansi(rs.getString(1));
            insri.setNamaInstansi(rs.getString(2));
            insri.setCepatKode(rs.getString(3));
            instansiesByCriteria.add(insri);
        }
        return instansiesByCriteria;
    }
    
}
