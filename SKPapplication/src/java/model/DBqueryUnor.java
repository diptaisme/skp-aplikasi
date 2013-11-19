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
public class DBqueryUnor
{
    Connection conn;
    
    public DBqueryUnor(Connection conn)
    {
        this.conn = conn;
    }
    
    public unorskp getDBqueryUnorId(String sidUnor) throws SQLException
    {
        
        String sql = "SELECT idunor, instansi_id, diatasan_id, eselon_id, nama_unor, nama_jabatan, pemimpin_pns_id FROM unorskp WHERE idunor  ='"+sidUnor+"'";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        unorskp iunor = null;
        ResultSet rs = pst.executeQuery();
        if (rs.next())
        {
            iunor = new unorskp();
            iunor.setIdUnor(rs.getString(1));
            iunor.setInstansiId(rs.getString(2));
            iunor.setDiAtasanId(rs.getString(3));
            iunor.setEselonId(rs.getString(4));
            iunor.setNamaUnor(rs.getString(5));
            iunor.setNamaJabatan(rs.getString(6));
            iunor.setPemimpinPnsId(rs.getString(7));
        }
        return iunor;
    }
    
    
      public void getDBqueryUnorAtasanKosong(String NipPns,String unorAtasan) throws SQLException
    {
        
       // String sql = "SELECT idunor, instansi_id, diatasan_id, eselon_id, nama_unor, nama_jabatan, pemimpin_pns_id FROM unorskp WHERE idunor  ='"+sidUnor+"'";
        String sql = "UPDATE PNSSKP set diatasanid ='"+unorAtasan+"' where NIP_BARU ='"+NipPns+"'";
       PreparedStatement st = this.conn.prepareStatement(sql);
        st.executeUpdate(sql);
        st.close();
    }
    
    
    
//    public unorskp getDBqueryUnorFromInstansiId(String sidInstansi) throws SQLException
//    {
//        String sql = "SELECT idunor, instansi_id, diatasan_id, eselon_id, nama_unor, nama_jabatan, pemimpin_pns_id FROM unorskp WHERE instansi_id =? ";
//        PreparedStatement pst = this.conn.prepareStatement(sql);
//        unorskp _iunor = null;
//        pst.setString(1, sidInstansi);
//        ResultSet rs = pst.executeQuery();
//        if (rs.next())
//        {
//            _iunor = new unorskp();
//            _iunor.setIdUnor(rs.getString(1));
//            _iunor.setInstansiId(rs.getString(2));
//            _iunor.setDiAtasanId(rs.getString(3));
//            _iunor.setEselonId(rs.getString(4));
//            _iunor.setNamaUnor(rs.getString(5));
//            _iunor.setNamaJabatan(rs.getString(6));
//            _iunor.setPemimpinPnsId(rs.getString(7));
//        }
//        return _iunor;
//    }
     public List<unorskp> getDBqueryUpdateUnorAtasan(String snamaUnor, String instansi, String nipBaru) throws SQLException
    {
        List<unorskp> unoriesByCriteria = new ArrayList<unorskp>();
    String sql = "   SELECT u.idunor, u.instansi_id, u.diatasan_id, u.eselon_id, u.nama_unor, u.nama_jabatan, u.pemimpin_pns_id, atas.nama_unor AS diatasan, atas2.nama_unor as diatasan2 "
+" FROM unorskp u "
+"LEFT OUTER JOIN unorskp atas ON u.diatasan_id = atas.idunor "
+"LEFT OUTER JOIN unorskp atas2 ON atas.diatasan_id = atas2.idunor "
                        + " WHERE u.nama_unor like '%"+snamaUnor+"%' and u.instansi_id ='"+instansi+"'";
        
        /* String sql = "SELECT u.idunor, u.instansi_id, u.diatasan_id, u.eselon_id, u.nama_unor, u.nama_jabatan, u.pemimpin_pns_id, atas.nama_unor as diatasan "
                + " FROM unorskp u "
                + " LEFT OUTER JOIN unorskp atas ON u.diatasan_id = atas.idunor "
                + " WHERE nama_unor like '%"+snamaUnor+"%' and instansi_id ='"+instansi+"'";
        */
        /* REKURSIF
         * 
         */
        /*
         * SELECT u.idunor, u.instansi_id, u.diatasan_id, u.eselon_id, u.nama_unor, u.nama_jabatan, u.pemimpin_pns_id, atas.nama_unor AS diatasan, atas2.nama_unor as diatasan2
FROM unorskp u
LEFT OUTER JOIN unorskp atas ON u.diatasan_id = atas.idunor
LEFT OUTER JOIN unorskp atas2 ON atas.diatasan_id = atas2.idunor
WHERE u.nama_unor LIKE '%olahan da%'
AND u.instansi_id = 'A5EB03E23B00F6A0E040640A040252AD'
         * 
         */
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
             unorskp _iunor = new unorskp();
            _iunor.setIdUnor(rs.getString(1));
            _iunor.setInstansiId(rs.getString(2));
            _iunor.setDiAtasanId(rs.getString(3));
            _iunor.setEselonId(rs.getString(4));
           if(rs.getString(4).equals("11")||rs.getString(4).equals("12")||rs.getString(4).equals("21")||rs.getString(4).equals("22")){
            _iunor.setNamaUnor(rs.getString(5));
           }
           else{
               _iunor.setNamaUnor(rs.getString(5)+" - "+rs.getString(9));
           }
           
            _iunor.setNamaJabatan(rs.getString(6));
            _iunor.setPemimpinPnsId(rs.getString(7));
            
            unoriesByCriteria.add(_iunor);
        }
        return unoriesByCriteria;
    }
    
    public List<unorskp> getDBqueryUnorFromInstansiId(String sidInstansi) throws SQLException
    {
        List<unorskp> _iunories = new ArrayList<unorskp>();
        String sql = "SELECT idunor, instansi_id, diatasan_id, eselon_id, nama_unor, nama_jabatan, pemimpin_pns_id FROM unorskp WHERE instansi_id = '"+sidInstansi+"' ";
        /*String sql = "SELECT idunor, instansi_id, diatasan_id, eselon_id, (LPAD(' ',5*level-1) || nama_unor), nama_jabatan, pemimpin_pns_id FROM unorskp START WITH instansi_id = '"+sidInstansi+"' "
        +" AND diatasan_id IS NULL CONNECT BY PRIOR idunor = diatasan_id order SIBLINGS BY eselon_id";
        */
        PreparedStatement pst = this.conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            unorskp _iunor = new unorskp();
            _iunor.setIdUnor(rs.getString(1));
            _iunor.setInstansiId(rs.getString(2));
            _iunor.setDiAtasanId(rs.getString(3));
            _iunor.setEselonId(rs.getString(4));
            _iunor.setNamaUnor(rs.getString(5));
            _iunor.setNamaJabatan(rs.getString(6));
            _iunor.setPemimpinPnsId(rs.getString(7));
            _iunories.add(_iunor);
        }
        return _iunories;
    }
    
    
    
    
    public List<unorskp> getDBqueryAllUnor() throws SQLException
    {
        List<unorskp> _iunories = new ArrayList<unorskp>();
        String sql = "SELECT * FROM unorskp";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            unorskp _iunor = new unorskp();
            _iunor.setIdUnor(rs.getString(1));
            _iunor.setInstansiId(rs.getString(2));
            _iunor.setDiAtasanId(rs.getString(3));
            _iunor.setEselonId(rs.getString(4));
            _iunor.setNamaUnor(rs.getString(5));
            _iunor.setNamaJabatan(rs.getString(6));
            _iunor.setPemimpinPnsId(rs.getString(7));
            _iunories.add(_iunor);
        }
        return _iunories;
    }
    
    
    
    
    
     public List<unorskp> getDBqueryCariUnor(String snamaUnor, String InstansiId) throws SQLException
    {
        List<unorskp> unoriesByCriteria = new ArrayList<unorskp>();
        /*String sql = "SELECT idunor, instansi_id, diatasan_id, eselon_id, nama_unor, nama_jabatan, pemimpin_pns_id "
                + " FROM unorskp "
                + " WHERE nama_unor like '%"+snamaUnor+"%'and instansi_id ='"+InstansiId+"' ";
        */
         String sql = "   SELECT u.idunor, u.instansi_id, u.diatasan_id, u.eselon_id, u.nama_unor, u.nama_jabatan, u.pemimpin_pns_id, atas.nama_unor AS diatasan, atas2.nama_unor as diatasan2 "
+" FROM unorskp u "
+"LEFT OUTER JOIN unorskp atas ON u.diatasan_id = atas.idunor "
+"LEFT OUTER JOIN unorskp atas2 ON atas.diatasan_id = atas2.idunor "
                        + " WHERE u.nama_unor like '%"+snamaUnor+"%' and u.instansi_id ='"+InstansiId+"'";
   
        PreparedStatement pst = this.conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
             unorskp _iunor = new unorskp();
            _iunor.setIdUnor(rs.getString(1));
            _iunor.setInstansiId(rs.getString(2));
            _iunor.setDiAtasanId(rs.getString(3));
            _iunor.setEselonId(rs.getString(4));
            if(rs.getString(4).equals("11")||rs.getString(4).equals("12")||rs.getString(4).equals("21")||rs.getString(4).equals("22")){
                _iunor.setNamaUnor(rs.getString(5));
            }else{
                _iunor.setNamaUnor(rs.getString(5)+ " - " +rs.getString(9) );
            }
           // _iunor.setNamaUnor(rs.getString(5));
            _iunor.setNamaJabatan(rs.getString(6));
            _iunor.setPemimpinPnsId(rs.getString(7));
            unoriesByCriteria.add(_iunor);
        }
        return unoriesByCriteria;
    }
     
     
    
    
    
//        public List<unorskp> getDBqueryUN(String sidInstansi) throws SQLException
//    {
//        List<unorskp> _iunories = new ArrayList<unorskp>();
//        String sql = "SELECT idunor, instansi_id, diatasan_id, eselon_id, nama_unor, nama_jabatan, pemimpin_pns_id FROM unorskp WHERE instansi_id =? ";
//        PreparedStatement pst = this.conn.prepareStatement(sql);
////        DBqueryUnor nDBqueryUnor = null;
////        pst.setString(1, sidInstansi);
//        ResultSet rs = pst.executeQuery();
//        while (rs.next())
//        {
//            unorskp _iunor = new unorskp();
//            _iunor.setIdUnor(rs.getString(1));
//            _iunor.setInstansiId(rs.getString(2));
//            _iunor.setDiAtasanId(rs.getString(3));
//            _iunor.setEselonId(rs.getString(4));
//            _iunor.setNamaUnor(rs.getString(5));
//            _iunor.setNamaJabatan(rs.getString(6));
//            _iunor.setPemimpinPnsId(rs.getString(7));
//            _iunories.add(_iunor);
//        }
//        return _iunories;
//    }
        
        
        
        
     public unorskp getDBqueryUNOR(String sidUnor, String sidInstansi) throws SQLException
    {
        String sql = "SELECT idunor, instansi_id, diatasan_id, eselon_id, nama_unor, nama_jabatan, pemimpin_pns_id "
                + " FROM unorskp "
                + " WHERE idunor =? AND instansi_id =? ";
        
        /* String sql = "   SELECT u.idunor, u.instansi_id, u.diatasan_id, u.eselon_id, u.nama_unor, u.nama_jabatan, u.pemimpin_pns_id, atas.nama_unor AS diatasan, atas2.nama_unor as diatasan2 "
+" FROM unorskp u "
+"LEFT OUTER JOIN unorskp atas ON u.diatasan_id = atas.idunor "
+"LEFT OUTER JOIN unorskp atas2 ON atas.diatasan_id = atas2.idunor "
                        + " WHERE u.nama_unor like '%"+sidUnor+"%' and u.instansi_id ='"+sidInstansi+"'";
   
        */
        PreparedStatement pst = this.conn.prepareStatement(sql);
        unorskp _iunor = null;
       pst.setString(1, sidUnor);
        pst.setString(2, sidInstansi);
        ResultSet rs = pst.executeQuery();
        if (rs.next())
        {
            _iunor = new unorskp();
            _iunor.setIdUnor(rs.getString(1));
            _iunor.setInstansiId(rs.getString(2));
            _iunor.setDiAtasanId(rs.getString(3));
            _iunor.setEselonId(rs.getString(4));
           
                _iunor.setNamaUnor(rs.getString(5));
            
            _iunor.setNamaJabatan(rs.getString(6));
            _iunor.setPemimpinPnsId(rs.getString(7));
        }
        return _iunor;
    }
}
