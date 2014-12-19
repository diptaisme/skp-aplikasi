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
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author diptaisme
 */
public class DBqueryPerilaku
{
    Connection conn;
    
    public DBqueryPerilaku(Connection conn)
    {
        this.conn = conn;
    }
    
    public void insertPerilaku(String _nip, String _Pelayanan, String _Integritas, String _Komitmen, String _Disiplin, String _Kerjasama, String _Kepemimpinan, String _jumlah, String _ratarata, String _Penilaian) throws SQLException
    {
        String nip;
        String Pelayanan;
        String Integritas;
        String Komitmen;
        String Disiplin;
        String Kerjasama;
        String Kepemimpinan;
        String jumlah;
        String ratarata;
        String Penilaian;
        
        nip = _nip;
        Pelayanan = _Pelayanan;
        Integritas = _Integritas;
        Komitmen = _Komitmen;
        Disiplin = _Disiplin;
        Kerjasama = _Kerjasama;
        Kepemimpinan = _Kepemimpinan;
         if (_Kepemimpinan == null || _Kepemimpinan.equals(" ") || _Kepemimpinan.equals(""))
                {
                    Kepemimpinan ="0"; 
                     _Kepemimpinan ="0"; 
                }
          
        jumlah = _jumlah;
        ratarata = _ratarata;
        Penilaian = _Penilaian;
        
        validasiString vs = new validasiString();
          vs.setmashudi(Pelayanan);
         Pelayanan = vs.getmashudi();
        
        vs.setmashudi(Integritas);
        Integritas = vs.getmashudi();
        
        vs.setmashudi(Komitmen);
        Komitmen = vs.getmashudi();
        
        vs.setmashudi(Disiplin);
        Disiplin = vs.getmashudi();
        
        vs.setmashudi(Kerjasama);
        Kerjasama = vs.getmashudi();
         if (Kepemimpinan.equals("0"))
                {
                  Kepemimpinan ="0"; 
                }else{
              vs.setmashudi(Kepemimpinan);
        Kepemimpinan = vs.getmashudi();
       };
     
        
        double d_Integritas;
        double d_Komitmen;
        double d_Disiplin;
        double d_Kerjasama;
        double d_Kepemimpinan;
        double d_jumlah;
        double d_ratarata;
           double d_pelayanan;
        d_pelayanan = Double.parseDouble(Pelayanan);        
        d_Integritas = Double.parseDouble(Integritas);
        d_Komitmen = Double.parseDouble(Komitmen);
        d_Disiplin = Double.parseDouble(Disiplin);
        d_Kerjasama = Double.parseDouble(Kerjasama);
        d_Kepemimpinan = Double.parseDouble(Kepemimpinan);
         DecimalFormat formatterR = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
         formatterR.setMaximumFractionDigits(2);
        d_jumlah = d_pelayanan+d_Integritas + d_Komitmen + d_Disiplin + d_Kerjasama + d_Kepemimpinan; 
        
           if ( d_Kepemimpinan > 0)
                {
                       d_ratarata = d_jumlah / 6;
                }else {
                        d_ratarata = d_jumlah / 5;
         }
         jumlah= formatterR.format(d_jumlah);
             
      ratarata= formatterR.format(d_ratarata);
        
       // jumlah = Double.toString(d_jumlah);
     //   ratarata = Double.toString(d_ratarata);
                
        String sql = "INSERT INTO nilaiperilaku(NIPPNS, Pelayanan, Integritas, Komitmen, Disiplin, Kerjasama, Kepemimpinan, Jumlah, ratarata, periode) VALUES('"+nip+"', '"+Pelayanan+"', '"+Integritas+"', '"+Komitmen +"', '"+Disiplin+"', '"+Kerjasama +"', '"+Kepemimpinan+"', '"+jumlah+"', '"+ratarata+"', '"+Penilaian+"')";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.executeUpdate(sql);
        st.close();   
    }
    
    
    public List<nilaiPerilaku> getDbQueryPerilakuAllList(String idPns) throws SQLException
    {
        List<nilaiPerilaku> prilakus = new ArrayList<nilaiPerilaku>();
        
        String sql = "SELECT NIPPNS, Pelayanan, Integritas, Komitmen, Disiplin, Kerjasama, Kepemimpinan, Jumlah, ratarata, periode FROM nilaiperilaku WHERE NIPPNS =?";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        nilaiPerilaku np = null;
        pst.setString(1, idPns);
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            np = new nilaiPerilaku();
            np.setNIPPNS(rs.getString(1));
            np.setPelayanan(rs.getString(2));
            np.setIntegritas(rs.getString(3)); 
            np.setKomitmen(rs.getString(4)); 
            np.setDisiplin(rs.getString(5));
            np.setKerjasama(rs.getString(6));
            np.setKepemimpinan(rs.getString(7));
            np.setJumlah(rs.getString(8));
            np.setRatarata(rs.getString(9));
            np.setPeriode(rs.getString(10));
            
             prilakus.add(np);
        }
        return prilakus;
    }        
    
    
    
    public void DeletePerilaku(String nipPerilaku) throws SQLException
    {   
        String sql = "DELETE FROM nilaiperilaku where NIPPNS='"+nipPerilaku+"'";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.executeUpdate(sql);
        st.close();
    }
    
    
    
    public nilaiPerilaku getDBqueryPerilaku(String nippns) throws SQLException
    {
        String sql;
        PreparedStatement pst;
        nilaiPerilaku np;
        ResultSet rs;
        
        sql = "SELECT NIPPNS, Pelayanan, Integritas, Komitmen, Disiplin, Kerjasama, Kepemimpinan, Jumlah, ratarata, periode FROM nilaiperilaku WHERE NIPPNS = '"+nippns+"'";
        pst = this.conn.prepareStatement(sql);
        np = null;
        //pst.setString(1, nippns);
        rs = pst.executeQuery();
        if (rs.next())
        {
            np = new nilaiPerilaku();
            np.setNIPPNS(rs.getString(1));
            np.setPelayanan(rs.getString(2));
            np.setIntegritas(rs.getString(3)); 
            np.setKomitmen(rs.getString(4)); 
            np.setDisiplin(rs.getString(5));
            np.setKerjasama(rs.getString(6));
            np.setKepemimpinan(rs.getString(7));
            np.setJumlah(rs.getString(8));
            np.setRatarata(rs.getString(9));
            np.setPeriode(rs.getString(10));
        }
        return np;
    }

    
    
    
    
    
    
    public void updatePerilaku(String _nip, String _Pelayanan, String _Integritas, String _Komitmen, String _Disiplin, String _Kerjasama, String _Kepemimpinan, String _jumlah, String _ratarata, String _Penilaian) throws SQLException
    {
        String nip;
        String Pelayanan;
        String Integritas;
        String Komitmen;
        String Disiplin;
        String Kerjasama;
        String Kepemimpinan;
        String jumlah;
        String ratarata;
        String Penilaian;
        
        nip = _nip;
        Pelayanan = _Pelayanan;
        Integritas = _Integritas;
        Komitmen = _Komitmen;
        Disiplin = _Disiplin;
        Kerjasama = _Kerjasama;
        Kepemimpinan = _Kepemimpinan;
        jumlah = _jumlah;
        ratarata = _ratarata;
        Penilaian = _Penilaian;
          if (_Kepemimpinan == null || _Kepemimpinan.equals(" ") || _Kepemimpinan.equals(""))
                {
                    Kepemimpinan ="0"; 
                   _Kepemimpinan ="0"; 
                }
        
        validasiString vs = new validasiString();
         vs.setmashudi(Pelayanan);
         Pelayanan = vs.getmashudi();
        vs.setmashudi(Integritas);
        Integritas = vs.getmashudi();
        
        vs.setmashudi(Komitmen);
        Komitmen = vs.getmashudi();
        
        vs.setmashudi(Disiplin);
        Disiplin = vs.getmashudi();
        
        vs.setmashudi(Kerjasama);
        Kerjasama = vs.getmashudi();
        
       if (Kepemimpinan.equals("0"))
                {
                  Kepemimpinan ="0"; 
                }else{
              vs.setmashudi(Kepemimpinan);
        Kepemimpinan = vs.getmashudi();
       };
      
       
        double d_Integritas;
        double d_Komitmen;
        double d_Disiplin;
        double d_Kerjasama;
        double d_Kepemimpinan;
        double d_jumlah;
        double d_ratarata;
         double d_pelayanan;
          DecimalFormat formatterR = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
         formatterR.setMaximumFractionDigits(2);
          d_pelayanan = Double.parseDouble(Pelayanan);
        d_Integritas = Double.parseDouble(Integritas);
        d_Komitmen = Double.parseDouble(Komitmen);
        d_Disiplin = Double.parseDouble(Disiplin);
        d_Kerjasama = Double.parseDouble(Kerjasama);
        
        d_Kepemimpinan = Double.parseDouble(Kepemimpinan);
     
        
        d_jumlah = d_pelayanan+d_Integritas + d_Komitmen + d_Disiplin + d_Kerjasama + d_Kepemimpinan; 
        
           if ( d_Kepemimpinan > 0)
                {
                       d_ratarata = d_jumlah / 6;
                }else {
                        d_ratarata = d_jumlah / 5;
         }
      //  d_ratarata = d_jumlah / 5;
        
      //  jumlah = Double.toString(d_jumlah);
        jumlah= formatterR.format(d_jumlah);
             
      ratarata= formatterR.format(d_ratarata);
        
        //ratarata = Double.toString(d_ratarata);
                
        String sql = "UPDATE nilaiperilaku SET Pelayanan = '"+Pelayanan+"', Integritas = '"+Integritas+"', Komitmen = '"+Komitmen +"', Disiplin = '"+Disiplin+"', Kerjasama = '"+Kerjasama +"', Kepemimpinan = '"+Kepemimpinan+"', Jumlah = '"+jumlah+"', ratarata = '"+ratarata+"', periode = '"+Penilaian+"' WHERE NIPPNS = '"+nip+"'";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.executeUpdate(sql);
        st.close();   
    }
    
    
    
    
    public PnsSkp getDbqueryLihatNipNama(String nippns) throws SQLException
    {
        String sql;
        PreparedStatement pst;
        PnsSkp np;
        ResultSet rs;
        
        sql = "SELECT nip_baru, namapns, jenis_jabatan FROM pnsskp WHERE nip_baru = '"+nippns+"'";
        pst = this.conn.prepareStatement(sql);
        np = null;
        //pst.setString(1, nippns);
        rs = pst.executeQuery();
        if (rs.next())
        {
            np = new PnsSkp();
            np.setNipBaru(rs.getString(1));
            np.setNamaPns(rs.getString(2));
            np.setjnsjbtn_id(rs.getString(3));
        }
        return np;
    }
    
    
}
