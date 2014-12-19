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
 * 
 * ini seperti DAO di Framework NCSIS **************
 * 
 * DAO ISI4FAKTOR
 */
public class DBqueryIsi4Faktor
{
    Connection conn;
      
    
    
    public DBqueryIsi4Faktor(Connection conn)
    {
        this.conn = conn;
    }
    
    
    
    public isi4faktor getDBqueryIsi4FaktorId(String sid_isi4faktor) throws SQLException
    {
        String sql = "SELECT id_isi4faktor,nip_pns,id_tupoksi,kuantitas4,kualitas4,waktu4,biaya4 FROM isi4faktor WHERE id_isi4faktor =? ";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        isi4faktor iisi4faktor = null;
        pst.setString(1, sid_isi4faktor);
        ResultSet rs = pst.executeQuery();
        if (rs.next())
        {
            iisi4faktor = new isi4faktor();
            iisi4faktor.setIdIsi4Faktor(rs.getString(1));
            iisi4faktor.setNipPns(rs.getString(2));
            iisi4faktor.setIdTupoksi(rs.getString(3)); 
            iisi4faktor.setKuantitas4(rs.getString(4)); 
            iisi4faktor.setKualitas4(rs.getString(5));
            iisi4faktor.setWaktu4(rs.getString(6));
            iisi4faktor.setBiaya4(rs.getString(7));
        }
        return iisi4faktor;
    }

    
    
    
    
    public List<isi4faktor> getDBqueryIsi4Faktor(String sId_Tupoksi,String snip_pns) throws SQLException
    {
        List<isi4faktor> isi4faktories = new ArrayList<isi4faktor>();
        String sql = "SELECT id_isi4faktor,nip_pns,id_tupoksi,kuantitas4,kualitas4,waktu4,biaya4 FROM isi4faktor WHERE id_tupoksi =? and nip_pns =? ";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryIsi4Faktor nDBqueryIsi4Faktor = null;
        pst.setString(3, sId_Tupoksi);
        pst.setString(2, snip_pns);
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            isi4faktor iisi4faktor = new isi4faktor();
            iisi4faktor.setIdIsi4Faktor(rs.getString(1));
            iisi4faktor.setNipPns(rs.getString(2));
            iisi4faktor.setIdTupoksi(rs.getString(3)); 
            iisi4faktor.setKuantitas4(rs.getString(4)); 
            iisi4faktor.setKualitas4(rs.getString(5));
            iisi4faktor.setWaktu4(rs.getString(6));
            iisi4faktor.setBiaya4(rs.getString(7));
            isi4faktories.add(iisi4faktor);
        }
        return isi4faktories;
    }
    
    
    
    
    
    
    
    public isi4faktor getDBqueryCariNipTupoksiDiIsi4Faktor(String nip_pns,String id_tupoksi, String sesiontahun) throws SQLException
    {
        String sql = "SELECT id_isi4faktor,nip_pns,id_tupoksi,kuantitas4,kualitas4,waktu4,biaya4 FROM isi4faktor WHERE nip_pns =? AND id_tupoksi =? AND session=?";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        isi4faktor band = null;
        pst.setString(1, nip_pns);
        pst.setString(2, id_tupoksi);
        pst.setString(3, sesiontahun);
        ResultSet rs = pst.executeQuery();
        if (rs.next())
        {
            band = new isi4faktor();
            band.setIdIsi4Faktor(rs.getString(1));
            band.setNipPns(rs.getString(2));
            band.setIdTupoksi(rs.getString(3)); 
            band.setKuantitas4(rs.getString(4)); 
            band.setKualitas4(rs.getString(5));
            band.setWaktu4(rs.getString(6));
            band.setBiaya4(rs.getString(7));
        }
        return band;
    }
    
    
    
}
