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
 * @author asus-U46E
 */
public class DBqueryJabatan {
    
    Connection conn;
    
    public DBqueryJabatan(Connection conn)
    {
        this.conn = conn;
    }
    
    
    public kelompokJabatan getDBqueryKelompok(String Jabatan) throws SQLException
    {
       //String sql = "SELECT idunor, instansi_id, diatasan_id, eselon_id, nama_unor, nama_jabatan, pemimpin_pns_id FROM unorskp WHERE idunor  ='"+sidUnor+"'";
        String sql = "SELECT id, nama, pembina_id from kelompok_jabatan where id = '"+Jabatan+"'";
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
        kelompokJabatan iunor = null;
        ResultSet rs = pst.executeQuery();
        if (rs.next())
        {
            iunor = new kelompokJabatan();
            iunor.setId(rs.getString(1));
            iunor.setNama(rs.getString(2));
            iunor.setPembinaId(rs.getString(3));
           
           
        }
        return iunor;
        
    }
    
    
    
     public jabfung getDBqueryKelompokJabatan(String Jabatan) throws SQLException
    {
       //String sql = "SELECT idunor, instansi_id, diatasan_id, eselon_id, nama_unor, nama_jabatan, pemimpin_pns_id FROM unorskp WHERE idunor  ='"+sidUnor+"'";
        String sql = "SELECT id, nama, kel_jabatan_id, cepat_kode from jabfung where id = '"+Jabatan+"'";
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
        jabfung iunor = null;
        ResultSet rs = pst.executeQuery();
        if (rs.next())
        {
            iunor = new jabfung();
            iunor.setId(rs.getString(1));
            iunor.setNama(rs.getString(2));
            iunor.setkelJabatanId(rs.getString(3));
            iunor.setCepatKode(rs.getString(4));
           
        }
        return iunor;
        
    }
     
     
      public List<jabfung> getDBqueryListJabFungsional(String Jabatan) throws SQLException
      {
           List<jabfung> iunor = new ArrayList<jabfung>();
       //String sql = "SELECT idunor, instansi_id, diatasan_id, eselon_id, nama_unor, nama_jabatan, pemimpin_pns_id FROM unorskp WHERE idunor  ='"+sidUnor+"'";
        String sql = "SELECT id, nama, kel_jabatan_id, cepat_kode from jabfung where id = '"+Jabatan+"'";
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryJabatan nDBqueryJabatan = null;
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            jabfung _iunor = new jabfung();
            _iunor.setId(rs.getString(1));
            _iunor.setNama(rs.getString(2));
            _iunor.setkelJabatanId(rs.getString(3));
            
            _iunor.setCepatKode(rs.getString(4));
            iunor.add(_iunor);
        }
        return iunor;
        
      }

     
     
     
     
     
     
     
     public jabfum getDBqueryJabatanUmum(String Jabatan) throws SQLException
    {
       //String sql = "SELECT idunor, instansi_id, diatasan_id, eselon_id, nama_unor, nama_jabatan, pemimpin_pns_id FROM unorskp WHERE idunor  ='"+sidUnor+"'";
        String sql = "SELECT id, nama, cepat_kode from jabfum where id = '"+Jabatan+"'";
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
        jabfum iunor = null;
        ResultSet rs = pst.executeQuery();
        if (rs.next())
        {
            iunor = new jabfum();
            iunor.setId(rs.getString(1));
            iunor.setNama(rs.getString(2));
            iunor.setCepatKode(rs.getString(3));
           
        }
        return iunor;
        
    }
     
     public List<jabfum> getDBqueryListJabatanUmum(String Jabatan) throws SQLException
    {
        List<jabfum> listjabatanumum = new ArrayList<jabfum>();
       //String sql = "SELECT idunor, instansi_id, diatasan_id, eselon_id, nama_unor, nama_jabatan, pemimpin_pns_id FROM unorskp WHERE idunor  ='"+sidUnor+"'";
        String sql = "SELECT id, nama, cepat_kode from jabfum where nama like '%"+Jabatan+"%'";
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
        jabfum iunor = null;
        ResultSet rs = pst.executeQuery();
        while(rs.next())
        {
            iunor = new jabfum();
            iunor.setId(rs.getString(1));
            iunor.setNama(rs.getString(2));
            iunor.setCepatKode(rs.getString(3));
            listjabatanumum.add(iunor);
        }
        return listjabatanumum;
        
    }
     
     public List<jabfung> getDBqueryListJabatanFungWithName(String Jabatan) throws SQLException
    {
        List<jabfung> listjabatanumum = new ArrayList<jabfung>();
       //String sql = "SELECT idunor, instansi_id, diatasan_id, eselon_id, nama_unor, nama_jabatan, pemimpin_pns_id FROM unorskp WHERE idunor  ='"+sidUnor+"'";
        String sql = "SELECT id, nama, cepat_kode from jabfung where nama like '%"+Jabatan+"%'";
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
        jabfung iunor = null;
        ResultSet rs = pst.executeQuery();
        while(rs.next())
        {
            iunor = new jabfung();
            iunor.setId(rs.getString(1));
            iunor.setNama(rs.getString(2));
            iunor.setCepatKode(rs.getString(3));
            listjabatanumum.add(iunor);
        }
        return listjabatanumum;
        
    }
     
      public List<kelompokJabatan> getDBqueryRumpunJabatanAll(String Kelompok) throws SQLException
      {
           List<kelompokJabatan> iunor = new ArrayList<kelompokJabatan>();
       //String sql = "SELECT idunor, instansi_id, diatasan_id, eselon_id, nama_unor, nama_jabatan, pemimpin_pns_id FROM unorskp WHERE idunor  ='"+sidUnor+"'";
        String sql = "SELECT id, nama, pembina_id from kelompok_jabatan order by nama";
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryJabatan nDBqueryJabatan = null;
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            kelompokJabatan _iunor = new kelompokJabatan();
            _iunor.setId(rs.getString(1));
            _iunor.setNama(rs.getString(2));
            _iunor.setPembinaId(rs.getString(3));           
            iunor.add(_iunor);
        }
        return iunor;
        
      }
     
      public List<kelompokJabatan> getDBqueryRumpunJabatan(String Kelompok) throws SQLException
      {
           List<kelompokJabatan> iunor = new ArrayList<kelompokJabatan>();
       //String sql = "SELECT idunor, instansi_id, diatasan_id, eselon_id, nama_unor, nama_jabatan, pemimpin_pns_id FROM unorskp WHERE idunor  ='"+sidUnor+"'";
        String sql = "SELECT id, nama, pembina_id from kelompok_jabatan where id ='" +Kelompok+"' order by nama";
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryJabatan nDBqueryJabatan = null;
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            kelompokJabatan _iunor = new kelompokJabatan();
            _iunor.setId(rs.getString(1));
            _iunor.setNama(rs.getString(2));
            _iunor.setPembinaId(rs.getString(3));           
            iunor.add(_iunor);
        }
        return iunor;
        
      }
     
      
      
      
       public List<kelompokJabatan> getFungsionalById(String Kelompok) throws SQLException
    {
       //String sql = "SELECT idunor, instansi_id, diatasan_id, eselon_id, nama_unor, nama_jabatan, pemimpin_pns_id FROM unorskp WHERE idunor  ='"+sidUnor+"'";
        String sql = "SELECT id, nama, pembina_id from kelompok_jabatan where id = '"+Kelompok+"'";
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
        List<kelompokJabatan> iunor = new ArrayList<kelompokJabatan>();
        ResultSet rs = pst.executeQuery();
        if (rs.next())
        {
            kelompokJabatan _iunor = new kelompokJabatan();
            _iunor.setId(rs.getString(1));
            _iunor.setNama(rs.getString(2));
            _iunor.setPembinaId(rs.getString(3));
            iunor.add(_iunor);
        }
        return iunor;
        
    }
      
        public List<jabfung> getDBquerySatuRumpunJabatan(String Kelompok) throws SQLException
    {
         List<jabfung> iunor = new ArrayList<jabfung>();
       //String sql = "SELECT idunor, instansi_id, diatasan_id, eselon_id, nama_unor, nama_jabatan, pemimpin_pns_id FROM unorskp WHERE idunor  ='"+sidUnor+"'";
        String sql = "SELECT id, nama, kel_jabatan_id, cepat_kode from jabfung where kel_jabatan_id = '"+Kelompok+"'";
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryJabatan nDBqueryJabatan = null;
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            jabfung _iunor = new jabfung();
            _iunor.setId(rs.getString(1));
            _iunor.setNama(rs.getString(2));
            _iunor.setkelJabatanId(rs.getString(3));
            _iunor.setCepatKode(rs.getString(4));
            iunor.add(_iunor);
        }
        return iunor;
        
    }
    
         public List<jabfung> getDBquerySatuRumpunJabatanIdDanIdJabfung(String kelompok,String idJabfung) throws SQLException
    {
         List<jabfung> iunor = new ArrayList<jabfung>();
       //String sql = "SELECT idunor, instansi_id, diatasan_id, eselon_id, nama_unor, nama_jabatan, pemimpin_pns_id FROM unorskp WHERE idunor  ='"+sidUnor+"'";
        String sql = "SELECT id, nama, kel_jabatan_id, cepat_kode from jabfung where kel_jabatan_id = '"+kelompok+"' and id='" +idJabfung+"'";
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryJabatan nDBqueryJabatan = null;
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            jabfung _iunor = new jabfung();
            _iunor.setId(rs.getString(1));
            _iunor.setNama(rs.getString(2));
            _iunor.setkelJabatanId(rs.getString(3));
            _iunor.setCepatKode(rs.getString(4));
            iunor.add(_iunor);
        }
        return iunor;
        
    }
        
         public List<jabfum> getDBquerySemuaUmum(String id) throws SQLException
    {
         List<jabfum> iunor = new ArrayList<jabfum>();
       //String sql = "SELECT idunor, instansi_id, diatasan_id, eselon_id, nama_unor, nama_jabatan, pemimpin_pns_id FROM unorskp WHERE idunor  ='"+sidUnor+"'";
        String sql = "SELECT id, nama, cepat_kode from jabfum order by nama";
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryJabatan nDBqueryJabatan = null;
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            jabfum _iunor = new jabfum();
            _iunor.setId(rs.getString(1));
            _iunor.setNama(rs.getString(2));           
            _iunor.setCepatKode(rs.getString(3));
            iunor.add(_iunor);
        }
        return iunor;
        
    }
         
         
         
          public List<jabfum> getDBqueryUmumbyNama(String namaUmum) throws SQLException
    {
         List<jabfum> iunor = new ArrayList<jabfum>();
       //String sql = "SELECT idunor, instansi_id, diatasan_id, eselon_id, nama_unor, nama_jabatan, pemimpin_pns_id FROM unorskp WHERE idunor  ='"+sidUnor+"'";
        String sql = "SELECT id, nama, cepat_kode from jabfum where nama like '%"+namaUmum+"%' order by nama";
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryJabatan nDBqueryJabatan = null;
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            jabfum _iunor = new jabfum();
            _iunor.setId(rs.getString(1));
            _iunor.setNama(rs.getString(2));           
            _iunor.setCepatKode(rs.getString(3));
            iunor.add(_iunor);
        }
        return iunor;
        
    }
    
          
          public List<jabfum> getDBqueryUmumbyId(String IdUmum) throws SQLException
    {
         List<jabfum> iunor = new ArrayList<jabfum>();
       //String sql = "SELECT idunor, instansi_id, diatasan_id, eselon_id, nama_unor, nama_jabatan, pemimpin_pns_id FROM unorskp WHERE idunor  ='"+sidUnor+"'";
        String sql = "SELECT id, nama, cepat_kode from jabfum where id = '"+IdUmum+"' order by nama";
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryJabatan nDBqueryJabatan = null;
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            jabfum _iunor = new jabfum();
            _iunor.setId(rs.getString(1));
            _iunor.setNama(rs.getString(2));           
            _iunor.setCepatKode(rs.getString(3));
            iunor.add(_iunor);
        }
        return iunor;
        
    }
    
    
}
