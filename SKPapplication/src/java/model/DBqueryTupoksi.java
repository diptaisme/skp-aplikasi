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
 * DAO TUPOKSI
 */
public class DBqueryTupoksi
{
    Connection conn;
    
    
    
    public DBqueryTupoksi(Connection conn)
    {
        this.conn = conn;
    }
    
    
    
    public tupoksi_lama getDBqueryTupoksiId(String sId_Tupoksi) throws SQLException
    {
        String sql = "SELECT id_tupoksi,nama_tupoksi,id_unor,id_instansi,id_atasan,instansi_nama,angka_krdt FROM TUPOKSI WHERE id_tupoksi =? ";
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
        tupoksi_lama iTupoksi = null;
        pst.setString(1, sId_Tupoksi);
        ResultSet rs = pst.executeQuery();
        if (rs.next())
        {
            iTupoksi = new tupoksi_lama();
            iTupoksi.setIdTupoksi(rs.getString(1));
            iTupoksi.setNamaTupoksi(rs.getString(2));
            iTupoksi.setIdUnor(rs.getString(3)); 
            iTupoksi.setIdInstansi(rs.getString(4)); 
            iTupoksi.setIdDiAtasan(rs.getString(5)); 
            iTupoksi.setIdDiAtasan(rs.getString(6)); 
            iTupoksi.setangka_krdt(rs.getString(7)); 
        }
        return iTupoksi;
    }
    
    
    public tupoksi getDBqueryAllTupoksiId(String sId_Tupoksi) throws SQLException
    {
//        String sql = "SELECT id_tupoksi,nama_tupoksi,id_unor,id_instansi,id_atasan,instansi_nama,angka_krdt FROM TUPOKSI WHERE id_tupoksi =? ";
        
     String sql =   "Select ID_TUPOKSI,NAMA_TUPOKSI,ID_UNOR,NAMA_UNOR,ID_INSTANSI,INSTANSI_NAMA,ID_ATASAN,ANGKA_KRDT,KELOMPOK_JAB_ID,JENIS_JABATAN,JABATAN_ID,SATUAN FROM TUPOKSI WHERE id_tupoksi =? ";

        PreparedStatement pst = this.conn.prepareStatement(sql);
        tupoksi iTupoksi = null;
        pst.setString(1, sId_Tupoksi);
        ResultSet rs = pst.executeQuery();
        if (rs.next())
        {
            iTupoksi = new tupoksi();
            iTupoksi.setIdTupoksi(rs.getString(1));
            iTupoksi.setNamaTupoksi(rs.getString(2));
            iTupoksi.setIdUnor(rs.getString(3));
            iTupoksi.setNamaUnor(rs.getString(4));            
            iTupoksi.setIdInstansi(rs.getString(5)); 
            iTupoksi.setInstansiNama(rs.getString(6)); 
            iTupoksi.setIdDiAtasan(rs.getString(7));
            iTupoksi.setangka_krdt(rs.getString(8));
            iTupoksi.setnamaKelompok(rs.getString(9));
            iTupoksi.setidJenisJabatan(rs.getString(10));
            iTupoksi.setJabatanId(rs.getString(11));
            iTupoksi.setSatuan(rs.getString(12));
            
        }
        return iTupoksi;
    }
    
    
    
    
    public List<tupoksi> getDBqueryTupoksiStruktural(String sId_Unor,String sId_Instansi) throws SQLException
    {
        List<tupoksi> itupoksies = new ArrayList<tupoksi>();
        
        String sql = "SELECT id_tupoksi,nama_tupoksi,id_unor,id_instansi,id_atasan,instansi_nama,angka_krdt from tupoksi where id_unor =? and id_instansi =? ";
        
        PreparedStatement st = this.conn.prepareStatement(sql);
        DBqueryTupoksi nDBqueryTupoksi = null;
        st.setString(1, sId_Unor);
        st.setString(2, sId_Instansi);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            tupoksi itupoksi = new tupoksi();
            itupoksi.setIdTupoksi(rs.getString(1));
            itupoksi.setNamaTupoksi(rs.getString(2));
            itupoksi.setIdUnor(rs.getString(3)); 
            itupoksi.setIdInstansi(rs.getString(4)); 
            itupoksi.setIdDiAtasan(rs.getString(5));
            itupoksi.setIdDiAtasan(rs.getString(6)); 
            itupoksi.setangka_krdt(rs.getString(7)); 
            itupoksies.add(itupoksi);  
        }
        return  itupoksies;
    }
    
     public List<tupoksi> getDBqueryTupoksiFungsional(String kodeJabatanFung) throws SQLException
    {
        List<tupoksi> itupoksies = new ArrayList<tupoksi>();
        
        String sql = "SELECT id_tupoksi,nama_tupoksi,id_unor,id_instansi,id_atasan,instansi_nama,angka_krdt, jabatan_id from tupoksi where jabatan_id =? ";
        
        PreparedStatement st = this.conn.prepareStatement(sql);
        DBqueryTupoksi nDBqueryTupoksi = null;
        st.setString(1, kodeJabatanFung);
        
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            tupoksi itupoksi = new tupoksi();
            itupoksi.setIdTupoksi(rs.getString(1));
            itupoksi.setNamaTupoksi(rs.getString(2));
            itupoksi.setIdUnor(rs.getString(3)); 
            itupoksi.setIdInstansi(rs.getString(4)); 
            itupoksi.setIdDiAtasan(rs.getString(5));
            itupoksi.setIdDiAtasan(rs.getString(6)); 
            itupoksi.setangka_krdt(rs.getString(7)); 
             itupoksi.setJabatanId(rs.getString(8)); 
            itupoksies.add(itupoksi);  
        }
        return  itupoksies;
    }
    
    
    
    
    
    //Menampilkan hanya berdasarkan ID_UNOR dan ID_INSTANSI saja
    public List<tupoksi_lama> getDBqueryTupoksi(String sId_Unor,String sId_Instansi) throws SQLException
    {
        List<tupoksi_lama> itupoksies = new ArrayList<tupoksi_lama>();
        
        String sql = "SELECT id_tupoksi,nama_tupoksi,id_unor,id_instansi,id_atasan,instansi_nama,angka_krdt from tupoksi where id_unor =? and id_instansi =? ";
        
        PreparedStatement st = this.conn.prepareStatement(sql);
        DBqueryTupoksi nDBqueryTupoksi = null;
        st.setString(1, sId_Unor);
        st.setString(2, sId_Instansi);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            tupoksi_lama itupoksi = new tupoksi_lama();
            itupoksi.setIdTupoksi(rs.getString(1));
            itupoksi.setNamaTupoksi(rs.getString(2));
            itupoksi.setIdUnor(rs.getString(3)); 
            itupoksi.setIdInstansi(rs.getString(4)); 
            itupoksi.setIdDiAtasan(rs.getString(5));
            itupoksi.setIdDiAtasan(rs.getString(6)); 
            itupoksi.setangka_krdt(rs.getString(7)); 
            itupoksies.add(itupoksi);  
        }
        return  itupoksies;
    }
    
     public List<tupoksi_lama> getDBqueryTupoksi_UnorId_IdAtasan(String sId_Unor,String sId_Instansi,String idAtasan) throws SQLException
    {
        List<tupoksi_lama> itupoksies = new ArrayList<tupoksi_lama>();
        
        String sql = "SELECT id_tupoksi,nama_tupoksi,id_unor,id_instansi,id_atasan,instansi_nama,angka_krdt from tupoksi where id_unor =? and id_instansi =?  and id_atasan =?";
        
        PreparedStatement st = this.conn.prepareStatement(sql);
        DBqueryTupoksi nDBqueryTupoksi = null;
        st.setString(3, sId_Unor);
        st.setString(4, sId_Instansi);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            tupoksi_lama itupoksi = new tupoksi_lama();
            itupoksi.setIdTupoksi(rs.getString(1));
            itupoksi.setNamaTupoksi(rs.getString(2));
            itupoksi.setIdUnor(rs.getString(3)); 
            itupoksi.setIdInstansi(rs.getString(4)); 
            itupoksi.setIdDiAtasan(rs.getString(5));
            itupoksi.setIdDiAtasan(rs.getString(6)); 
            itupoksi.setangka_krdt(rs.getString(7)); 
            itupoksies.add(itupoksi);  
        }
        return  itupoksies;
    }
    
    
    public void insertTupoksiOperator(String _id_tupoksi,String _nama_tupoksi,String _id_unor,String _nama_unor,String _id_instansi,String _instansi_nama, String _id_diatasan,String _angka_krdt,String s_pilih_output_Jabatan,String s_namaKelompok, String Jenis) throws SQLException
    {
          String maks_id_tupoksi        = _id_tupoksi;
          String s_nama_tupoksi         = _nama_tupoksi;
          String s_id_unor              = _id_unor;
          String s_nama_unor            = _nama_unor;
          String s_id_instansi          = _id_instansi;
          String s_instansi_nama        = _instansi_nama;
          String s_id_diatasan          = _id_diatasan;
          String s_angka_krdt           = _angka_krdt;
          String jenisJabatan          = Jenis;
          String satuan = "";
        
                validasiString vs = new validasiString();
                vs.setmashudi(maks_id_tupoksi);
                maks_id_tupoksi = vs.getmashudi();
                
                vs.setmashudi(s_nama_tupoksi);
                s_nama_tupoksi = vs.getmashudi();
                
                vs.setmashudi(s_id_unor);
                s_id_unor = vs.getmashudi();
                
                vs.setmashudi(s_nama_unor);
                s_nama_unor = vs.getmashudi();
                
                vs.setmashudi(s_id_instansi);
                s_id_instansi = vs.getmashudi();
                
                vs.setmashudi(s_instansi_nama);
                s_instansi_nama = vs.getmashudi();
                
                vs.setmashudi(s_id_diatasan);
                s_id_diatasan = vs.getmashudi();
                
                 vs.setkoma(s_angka_krdt);
               s_angka_krdt  = vs.getmashudi();
        
        String sql = "INSERT INTO tupoksi(id_tupoksi, nama_tupoksi, id_unor, nama_unor, id_instansi, instansi_nama, id_atasan,angka_krdt,KELOMPOK_JAB_ID,JENIS_JABATAN,JABATAN_ID,SATUAN) VALUES('"+maks_id_tupoksi+"', '"+s_nama_tupoksi+"', '"+s_id_unor+"', '"+s_nama_unor +"', '"+s_id_instansi+"', '"+s_instansi_nama +"', '"+s_id_diatasan+"','"+ s_angka_krdt+"','"+ s_namaKelompok+"','" +jenisJabatan+"','"+s_pilih_output_Jabatan+"','"+satuan+"')";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.executeUpdate(sql);
        st.close();
        
//tupoksi
//
//id_tupoksi
//nama_tupoksi
//id_unor
//nama_unor
//id_instansi
//instansi_nama
//id_diatasan
//        
    }
    
    
    public void UpdateinsertTupoksiOperator(String _id_tupoksi,String _nama_tupoksi,String _id_unor,String _id_instansi,String _angka_krdt,String s_pilih_output_Jabatan,String s_namaKelompok) throws SQLException
    {
          String s_id_tupoksi           = _id_tupoksi;
          String s_nama_tupoksi         = _nama_tupoksi;
          String s_id_unor              = _id_unor;
          String s_id_instansi          = _id_instansi;  
          String s_angka_krdt           = _angka_krdt;
          
                validasiString vs = new validasiString();
                vs.setmashudi(s_id_tupoksi);
                s_id_tupoksi = vs.getmashudi();
                
                vs.setmashudi(s_nama_tupoksi);
                s_nama_tupoksi = vs.getmashudi();
                
                vs.setmashudi(s_id_unor);
                s_id_unor = vs.getmashudi();
                
                vs.setmashudi(s_id_instansi);
                s_id_instansi = vs.getmashudi();
                
                 vs.setkoma(s_angka_krdt);
                s_angka_krdt  = vs.getmashudi();
                
        
        String sql = "UPDATE tupoksi SET nama_tupoksi = '"+s_nama_tupoksi+"',angka_krdt = '"+s_angka_krdt+"',jabatan_id = '"+s_pilih_output_Jabatan+"' WHERE id_tupoksi = '"+s_id_tupoksi+"' and id_unor = '"+s_id_unor+"' and id_instansi = '"+s_id_instansi+"'";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.executeUpdate(sql);
        st.close();        
    }
     public void InsertRiwayatAtasanBawahan (String s_idAtasani,String s_instansiIdAtasan,String s_UnorIdatasan,String s_instansiIdpnsBawahan,String s_instansiIdunorbawahan) throws SQLException{
       
        RiwayatAtasanBawahan riwayatAtasanBawahan= SimpanRiwayatAtasan_Bawahan(s_idAtasani,s_instansiIdAtasan,s_UnorIdatasan,s_instansiIdpnsBawahan,s_instansiIdunorbawahan);
           if (riwayatAtasanBawahan==null){
                  String sql = "INSERT INTO RwAtasanBawahan(idAtasani,instansiIdAtasan,UnorIdatasan, instansiIdpnsBawahan, instansiIdunorbawahan) VALUES('"+s_idAtasani+"', '"+s_instansiIdAtasan+"', '"+s_UnorIdatasan+"', '"+s_instansiIdpnsBawahan +"', '"+s_instansiIdunorbawahan+"')";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.executeUpdate(sql);
        st.close();
           }
   }
    
    public  RiwayatAtasanBawahan SimpanRiwayatAtasan_Bawahan(String s_idAtasani,String s_instansiIdAtasan,String s_UnorIdatasan,String s_instansiIdpnsBawahan,String s_instansiIdunorbawahan) throws SQLException
    {
          String idAtasani         = s_idAtasani;
          String instansiIdAtasan  = s_instansiIdAtasan;
          String UnorIdatasan      = s_UnorIdatasan;
          String instansiIdpnsBawahan    = s_instansiIdpnsBawahan;  
          String instansiIdunorbawahan   = s_instansiIdunorbawahan;
          
        String sql = "SELECT idAtasani,instansiIdAtasan,UnorIdatasan,instansiIdpnsBawahan,instansiIdunorbawahan FROM RwAtasanBawahan WHERE idAtasani =? AND instansiIdAtasan =? and UnorIdatasan=? and instansiIdpnsBawahan=? and instansiIdunorbawahan=?";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        RiwayatAtasanBawahan riwayatAtasanBawahan = null;
        pst.setString(1, idAtasani);
        pst.setString(2, instansiIdAtasan);
        pst.setString(3, UnorIdatasan);
        pst.setString(4,instansiIdpnsBawahan);
        pst.setString(5,instansiIdunorbawahan);
        
        ResultSet rs = pst.executeQuery();
        if (rs.next())
        {
            riwayatAtasanBawahan = new RiwayatAtasanBawahan();
            riwayatAtasanBawahan.setidAtasani(rs.getString(1));
            riwayatAtasanBawahan.setinstansiIdAtasan(rs.getString(2));
            riwayatAtasanBawahan.setUnorIdatasan(rs.getString(3)); 
            riwayatAtasanBawahan.setinstansiIdpnsBawahan(rs.getString(4)); 
            riwayatAtasanBawahan.setinstansiIdunorbawahan(rs.getString(5));
            
         }
        return riwayatAtasanBawahan;
       
    }
      public  RiwayatAtasanBawahan ListRiwayatAtasan_Bawahan(String s_idAtasani,String s_instansiIdAtasan,String s_UnorIdatasan,String s_instansiIdpnsBawahan,String s_instansiIdunorbawahan) throws SQLException
    {
          String idAtasani         = s_idAtasani;
          String instansiIdAtasan  = s_instansiIdAtasan;
          String UnorIdatasan      = s_UnorIdatasan;
          String instansiIdpnsBawahan    = s_instansiIdpnsBawahan;  
          String instansiIdunorbawahan   = s_instansiIdunorbawahan;
          
        String sql = "SELECT idAtasani,instansiIdAtasan,UnorIdatasan,instansiIdpnsBawahan,instansiIdunorbawahan FROM RwAtasanBawahan WHERE idAtasani =? AND instansiIdAtasan =? and UnorIdatasan=? and instansiIdpnsBawahan=? and instansiIdunorbawahan=?";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        RiwayatAtasanBawahan riwayatAtasanBawahan = null;
        pst.setString(1, idAtasani);
        pst.setString(2, instansiIdAtasan);
        pst.setString(3, UnorIdatasan);
        pst.setString(4,instansiIdpnsBawahan);
        pst.setString(5,instansiIdunorbawahan);
        
        ResultSet rs = pst.executeQuery();
        if (rs.next())
        {
            riwayatAtasanBawahan = new RiwayatAtasanBawahan();
            riwayatAtasanBawahan.setidAtasani(rs.getString(1));
            riwayatAtasanBawahan.setinstansiIdAtasan(rs.getString(2));
            riwayatAtasanBawahan.setUnorIdatasan(rs.getString(3)); 
            riwayatAtasanBawahan.setinstansiIdpnsBawahan(rs.getString(4)); 
            riwayatAtasanBawahan.setinstansiIdunorbawahan(rs.getString(5));
            
         }
        return riwayatAtasanBawahan;
       
    }  
    
    //Struktural tanpa angka kredit cek
    public void UpdateinsertTupoksiOperatorStruktural(String _id_tupoksi,String _nama_tupoksi,String _id_unor,String _id_instansi) throws SQLException
    {
          String s_id_tupoksi           = _id_tupoksi;
          String s_nama_tupoksi         = _nama_tupoksi;
          String s_id_unor              = _id_unor;
          String s_id_instansi          = _id_instansi;  
          //String s_angka_krdt           = _angka_krdt;
          
                validasiString vs = new validasiString();
                vs.setmashudi(s_id_tupoksi);
                s_id_tupoksi = vs.getmashudi();
                
                vs.setmashudi(s_nama_tupoksi);
                s_nama_tupoksi = vs.getmashudi();
                
                vs.setmashudi(s_id_unor);
                s_id_unor = vs.getmashudi();
                
                vs.setmashudi(s_id_instansi);
                s_id_instansi = vs.getmashudi();
                
                
        
        String sql = "UPDATE tupoksi SET nama_tupoksi = '"+s_nama_tupoksi+"' WHERE id_tupoksi = '"+s_id_tupoksi+"' and id_unor = '"+s_id_unor+"' and id_instansi = '"+s_id_instansi+"'";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.executeUpdate(sql);
        st.close();        
    }
    
    
    
    
   public void hapusTupoksi(String _id_tupoksi,String _id_unor,String _id_instansi) throws SQLException{
       
        List<isi4faktor>  isi4faktorDelete= getDBqueryIsi4FaktorDelete(_id_tupoksi);
           
           
           if (isi4faktorDelete.size() == 0){
                 String sql = "DELETE FROM tupoksi where id_tupoksi='"+_id_tupoksi+"' and id_unor='"+ _id_unor+"' and id_instansi ='"+ _id_instansi +"'";
          PreparedStatement st = this.conn.prepareStatement(sql);
     //   st.setString(1,IdTupoksi);
        st.executeUpdate(sql);
        st.close();
           }
   }
   
   
   
      public void hapusIdTupoksi(String _id_tupoksi) throws SQLException{
         List<isi4faktor>  isi4faktorDelete= getDBqueryIsi4FaktorDelete(_id_tupoksi);
           
           
           if (isi4faktorDelete.size() == 0){
                  String sql = "DELETE FROM tupoksi where id_tupoksi='"+_id_tupoksi+"'";
          PreparedStatement st = this.conn.prepareStatement(sql);
     //   st.setString(1,IdTupoksi);
        st.executeUpdate(sql);
        st.close();
           }
   }
    
      
       public void hapusIdTupoksiFungFum(String _id_tupoksi, String KodeJabatan) throws SQLException{
       
           
       List<isi4faktor>  isi4faktorDelete= getDBqueryIsi4FaktorDelete(_id_tupoksi);
           
           if (isi4faktorDelete.size() == 0){
                  String sql = "DELETE FROM tupoksi where id_tupoksi='"+_id_tupoksi+"' and JABATAN_ID ='"+KodeJabatan+"'";
          PreparedStatement st = this.conn.prepareStatement(sql);
     //   st.setString(1,IdTupoksi);
        st.executeUpdate(sql);
        st.close();
           }
   }
    
    
    
    public String makTupoksiOperator() throws SQLException
    {
        String max = null;
        int imax;
        
        String sql = "SELECT MAX(id_tupoksi) as maks FROM tupoksi";
        PreparedStatement st = this.conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        if (rs.next())
        {
            max = rs.getString("maks");
            
            imax = Integer.parseInt(max);
            imax++;
            
            max = Integer.toString(imax);
        }
        return max;
    }
    
    
    
    
    
    public tupoksi_lama getDBqueryIdInstansiDanIdUnorDariIdTupoksi(String sId_Tupoksi) throws SQLException
    {
        String sql = "SELECT id_unor, id_instansi FROM tupoksi where id_tupoksi = '"+sId_Tupoksi+"' ";
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
        tupoksi_lama iTupoksi = null;
        ResultSet rs = pst.executeQuery();
        if (rs.next())
        {
            iTupoksi = new tupoksi_lama();
            iTupoksi.setIdUnor(rs.getString(1)); 
            iTupoksi.setIdInstansi(rs.getString(2)); 
        }
        return iTupoksi;
    }
    
    public tupoksi_lama getDBqueryallDariIdTupoksi(String sId_Tupoksi) throws SQLException
    {
        String sql = "SELECT id_unor, id_instansi, nama_unor, instansi_nama, id_tupoksi, nama_tupoksi,angka_krdt FROM tupoksi where id_tupoksi = '"+sId_Tupoksi+"' ";
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
        tupoksi_lama iTupoksi = null;
        ResultSet rs = pst.executeQuery();
        if (rs.next())
        {
            iTupoksi = new tupoksi_lama();
            iTupoksi.setIdUnor(rs.getString(1)); 
            iTupoksi.setIdInstansi(rs.getString(2));
            iTupoksi.setNamaUnor(rs.getString(3)); 
            iTupoksi.setInstansiNama(rs.getString(4)); 
            iTupoksi.setIdTupoksi(rs.getString(5)); 
            iTupoksi.setNamaTupoksi(rs.getString(6)); 
            iTupoksi.setangka_krdt(rs.getString(7)); 
        }
        return iTupoksi;
    }
    
        public List<isi4faktor> getDBqueryIsi4FaktorDelete(String sId_Tupoksi) throws SQLException
    {
        List<isi4faktor> isi4faktories = new ArrayList<isi4faktor>();
        String sql = "SELECT id_isi4faktor,nip_pns,id_tupoksi,kuantitas4,kualitas4,waktu4,biaya4 FROM isi4faktor WHERE id_tupoksi = '"+sId_Tupoksi+"' ";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryIsi4Faktor nDBqueryIsi4Faktor = null;
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
}
