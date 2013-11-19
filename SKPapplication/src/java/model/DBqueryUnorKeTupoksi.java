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
public class DBqueryUnorKeTupoksi
{
    Connection conn;
    
    public DBqueryUnorKeTupoksi(Connection conn)
    {
        this.conn = conn;
    }
    
    public List<UnorKeTupoksi> getDBqueryUnorKeTupoksiId(String sid_unor, String sid_instansi) throws SQLException
    {
        List<UnorKeTupoksi> UnorKeTupoksies = new ArrayList<UnorKeTupoksi>();
        
//        String sql = "SELECT t.id_tupoksi, t.nama_tupoksi, t.id_unor, t.nama_unor, t.id_instansi, t.instansi_nama, t.id_diatasan, "
//                + " u.idunor, u.diatasan_id, u.eselon_id, u.nama_unor, u.nama_jabatan, u.pemimpin_pns_id "
//                + " FROM tupoksi t, unorskp u "
//                + " WHERE t.id_unor = u.idunor AND u.idunor =? AND t.id_instansi =?";
        
        String sql = "SELECT t.id_tupoksi, t.nama_tupoksi, t.id_unor, t.nama_unor, t.id_instansi, t.instansi_nama, t.id_atasan, "
                + " u.idunor, u.diatasan_id, u.eselon_id, u.nama_unor, u.nama_jabatan, u.pemimpin_pns_id,t.angka_krdt "
                + " FROM tupoksi t, unorskp u "
                + " WHERE t.id_unor = u.idunor AND t.id_unor =? AND t.id_instansi =?";
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryUnorKeTupoksi nDBqueryUnorKeTupoksi = null;
        pst.setString(1, sid_unor);
        pst.setString(2, sid_instansi);
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            UnorKeTupoksi unosi = new UnorKeTupoksi();
            unosi.setIdTupoksi(rs.getString(1));
            unosi.setNamaTupoksi(rs.getString(2));
            unosi.setIdUnor(rs.getString(3));
            
            unosi.setNamaUnor(rs.getString(4));
            unosi.setIdInstansi(rs.getString(5));
            unosi.setInstansiNama(rs.getString(6));
            unosi.setIdDiAtasan(rs.getString(7));
            unosi.set_IdUnor(rs.getString(8));
            unosi.setDiAtasanId(rs.getString(9));
            unosi.setEselonId(rs.getString(10));
            unosi.setNamaUnor2(rs.getString(11));
            unosi.setNamaJabatan(rs.getString(12));
            unosi.setPemimpinPnsId(rs.getString(13));
            unosi.setangka_krdt(rs.getString(14));
            UnorKeTupoksies.add(unosi);
        }
        
        return UnorKeTupoksies;
    }
    
    
    
    public List<UnorKeTupoksi> getDBqueryTupoksiFungsional(String sid_unor, String sid_instansi, String Jabatan) throws SQLException
    {
        List<UnorKeTupoksi> UnorKeTupoksies = new ArrayList<UnorKeTupoksi>();
        
//        String sql = "SELECT t.id_tupoksi, t.nama_tupoksi, t.id_unor, t.nama_unor, t.id_instansi, t.instansi_nama, t.id_diatasan, "
//                + " u.idunor, u.diatasan_id, u.eselon_id, u.nama_unor, u.nama_jabatan, u.pemimpin_pns_id "
//                + " FROM tupoksi t, unorskp u "
//                + " WHERE t.id_unor = u.idunor AND u.idunor =? AND t.id_instansi =?";
        
        String sql = "SELECT t.id_tupoksi, t.nama_tupoksi, t.id_unor, t.nama_unor, t.id_instansi, t.instansi_nama, t.id_atasan, "
               + " t.angka_krdt "
                + " FROM tupoksi t"
                + " WHERE  t.jabatan_id =?";
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryUnorKeTupoksi nDBqueryUnorKeTupoksi = null;
        
         pst.setString(1, Jabatan);
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            UnorKeTupoksi unosi = new UnorKeTupoksi();
            unosi.setIdTupoksi(rs.getString(1));
            unosi.setNamaTupoksi(rs.getString(2));
            unosi.setIdUnor(rs.getString(3));
            
            unosi.setNamaUnor(rs.getString(4));
            unosi.setIdInstansi(rs.getString(5));
            unosi.setInstansiNama(rs.getString(6));
            unosi.setIdDiAtasan(rs.getString(7));
            unosi.setangka_krdt(rs.getString(8));
           
            UnorKeTupoksies.add(unosi);
        }
        
        return UnorKeTupoksies;
    }
    
    public List<UnorKeTupoksi> getDBqueryTupoksiStruktural(String sid_unor, String sid_instansi) throws SQLException
    {
        List<UnorKeTupoksi> UnorKeTupoksies = new ArrayList<UnorKeTupoksi>();
        
//        String sql = "SELECT t.id_tupoksi, t.nama_tupoksi, t.id_unor, t.nama_unor, t.id_instansi, t.instansi_nama, t.id_diatasan, "
//                + " u.idunor, u.diatasan_id, u.eselon_id, u.nama_unor, u.nama_jabatan, u.pemimpin_pns_id "
//                + " FROM tupoksi t, unorskp u "
//                + " WHERE t.id_unor = u.idunor AND u.idunor =? AND t.id_instansi =?";
        
        String sql = "SELECT t.id_tupoksi, t.nama_tupoksi, t.id_unor, t.nama_unor, t.id_instansi, t.instansi_nama, t.id_atasan, "
                + " u.idunor, u.diatasan_id, u.eselon_id, u.nama_unor, u.nama_jabatan, u.pemimpin_pns_id,t.angka_krdt "
                + " FROM tupoksi t, unorskp u "
                + " WHERE t.id_unor = u.idunor AND t.id_unor =? AND t.id_instansi =?";
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryUnorKeTupoksi nDBqueryUnorKeTupoksi = null;
        pst.setString(1, sid_unor);
        pst.setString(2, sid_instansi);
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            UnorKeTupoksi unosi = new UnorKeTupoksi();
            unosi.setIdTupoksi(rs.getString(1));
            unosi.setNamaTupoksi(rs.getString(2));
            unosi.setIdUnor(rs.getString(3));
            
            unosi.setNamaUnor(rs.getString(4));
            unosi.setIdInstansi(rs.getString(5));
            unosi.setInstansiNama(rs.getString(6));
            unosi.setIdDiAtasan(rs.getString(7));
            unosi.set_IdUnor(rs.getString(8));
            unosi.setDiAtasanId(rs.getString(9));
            unosi.setEselonId(rs.getString(10));
            unosi.setNamaUnor2(rs.getString(11));
            unosi.setNamaJabatan(rs.getString(12));
            unosi.setPemimpinPnsId(rs.getString(13));
            unosi.setangka_krdt(rs.getString(14));
            UnorKeTupoksies.add(unosi);
        }
        
        return UnorKeTupoksies;
    }
    
    
    
    
    
      public List<UnorKeTupoksi> getDBqueryKeTupoksiIdAll( String namaKreteria) throws SQLException
    {
        List<UnorKeTupoksi> UnorKeTupoksies = new ArrayList<UnorKeTupoksi>();
        
        String sql = "SELECT t.id_tupoksi, t.nama_tupoksi, t.id_unor, t.nama_unor, t.id_instansi, t.instansi_nama, t.id_atasan, "
                + " t.angka_krdt "
                + " FROM tupoksi t "
                + " WHERE  t.nama_tupoksi like '%"+namaKreteria+"%'";       
        PreparedStatement pst = this.conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        DBqueryUnorKeTupoksi nDBqueryUnorKeTupoksi = null;
        while (rs.next())
        {
            UnorKeTupoksi unosi = new UnorKeTupoksi();
            unosi.setIdTupoksi(rs.getString(1));
            unosi.setNamaTupoksi(rs.getString(2));
            unosi.setIdUnor(rs.getString(3));
            unosi.setNamaUnor(rs.getString(4));
            unosi.setIdInstansi(rs.getString(5));
            unosi.setInstansiNama(rs.getString(6));
            unosi.setIdDiAtasan(rs.getString(7));
            unosi.setangka_krdt(rs.getString(8));
            UnorKeTupoksies.add(unosi);
        }
        return UnorKeTupoksies;
    }
    public List<UnorKeTupoksi> getDBqueryKeTupoksiIdAll(String cariKriteriaKlTgs, String namaKreteria) throws SQLException
    {String sql=null;
        List<UnorKeTupoksi> UnorKeTupoksies = new ArrayList<UnorKeTupoksi>();
        if(namaKreteria==null || namaKreteria.equals("") || namaKreteria.equals(" ")){
         sql = "SELECT t.id_tupoksi, t.nama_tupoksi, t.id_unor, t.nama_unor, t.id_instansi, t.instansi_nama, t.id_atasan, t.angka_krdt  FROM tupoksi t ";    
        }else
        if(cariKriteriaKlTgs==null || cariKriteriaKlTgs.equals("") || cariKriteriaKlTgs.equals(" ")){
         sql = "SELECT t.id_tupoksi, t.nama_tupoksi, t.id_unor, t.nama_unor, t.id_instansi, t.instansi_nama, t.id_atasan, "
                + " t.angka_krdt "
                + " FROM tupoksi t "
                + " WHERE  t.nama_tupoksi like '%"+namaKreteria+"%'";    
        }else{
           sql = "SELECT t.id_tupoksi, t.nama_tupoksi, t.id_unor, t.nama_unor, t.id_instansi, t.instansi_nama, t.id_atasan, "
                + " t.angka_krdt "
                + " FROM tupoksi t "
                + " WHERE  t.nama_tupoksi like '%"+namaKreteria+"%' and t.namaKelompok like '%"+cariKriteriaKlTgs+"%'";    
        }
        PreparedStatement pst = this.conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        DBqueryUnorKeTupoksi nDBqueryUnorKeTupoksi = null;
        while (rs.next())
        {
            UnorKeTupoksi unosi = new UnorKeTupoksi();
            unosi.setIdTupoksi(rs.getString(1));
            unosi.setNamaTupoksi(rs.getString(2));
            unosi.setIdUnor(rs.getString(3));
            unosi.setNamaUnor(rs.getString(4));
            unosi.setIdInstansi(rs.getString(5));
            unosi.setInstansiNama(rs.getString(6));
            unosi.setIdDiAtasan(rs.getString(7));
            unosi.setangka_krdt(rs.getString(8));
            UnorKeTupoksies.add(unosi);
        }
        return UnorKeTupoksies;
    }
    
      public List<tupoksi_lama> getDBqueryKeLompokTupoksiIdAll(String cariKriteriaKlTgs) throws SQLException
    {
         List<tupoksi_lama> Tupoksies = new ArrayList<tupoksi_lama>();
        if(cariKriteriaKlTgs==null || cariKriteriaKlTgs.equals("")||cariKriteriaKlTgs.equals(" ") ){
          String sql = "SELECT t.namaKelompok FROM tupoksi t   GROUP BY t.namaKelompok";       
        PreparedStatement pst = this.conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        DBqueryUnorKeTupoksi nDBqueryUnorKeTupoksi = null;
        while (rs.next())
        {
            tupoksi_lama Tupoksi = new tupoksi_lama();
            Tupoksi.setnamaKelompok(rs.getString(1));
            Tupoksies.add(Tupoksi);
        } 
       }else{
        String sql = "SELECT t.namaKelompok FROM tupoksi t  WHERE  t.namaKelompok like '%"+cariKriteriaKlTgs+"%' GROUP BY t.namaKelompok";       
        PreparedStatement pst = this.conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        DBqueryUnorKeTupoksi nDBqueryUnorKeTupoksi = null;
        while (rs.next())
        {
            tupoksi_lama Tupoksi = new tupoksi_lama();
            Tupoksi.setnamaKelompok(rs.getString(1));
            Tupoksies.add(Tupoksi);
        }
       }
        return Tupoksies;
    }
}
