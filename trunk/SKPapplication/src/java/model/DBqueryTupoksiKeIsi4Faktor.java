/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author diptaisme
 */
public class DBqueryTupoksiKeIsi4Faktor
{
    Connection conn;
    
    
    public DBqueryTupoksiKeIsi4Faktor(Connection conn)
    {
        this.conn = conn;
    }
    
     public List<TupoksiKeIsi4Faktor> getDBqueryTupoksiKeIsi4FaktornonUnor(String sid_unor, String sid_instansi, String snip_pns) throws SQLException
    {
        List<TupoksiKeIsi4Faktor> TupoksiKeIsi4Faktories = new ArrayList<TupoksiKeIsi4Faktor>();
                
        String sql = "SELECT T.id_tupoksi, T.nama_tupoksi, T.id_unor, T.id_instansi, T.id_atasan, T.instansi_nama, "
                + " I.id_isi4faktor, I.nip_pns, I.id_tupoksi, I.kuantitas4, I.kualitas4, I.waktu4, I.biaya4, I.kuantitas_label, I.waktu_label,T.angka_krdt,I.angka_krdt "
                + " FROM TUPOKSI T, ISI4FAKTOR I "
                + " WHERE T.id_tupoksi = I.id_tupoksi AND I.nip_pns =? ";
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryTupoksiKeIsi4Faktor nDBqueryTupoksiKeIsi4Faktor = null;
        pst.setString(1, snip_pns);
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            TupoksiKeIsi4Faktor tukeisi = new TupoksiKeIsi4Faktor();
            tukeisi.setIdTupoksi(rs.getString(1));
            tukeisi.setNamaTupoksi(rs.getString(2));
            tukeisi.setIdUnor(rs.getString(3));
            tukeisi.setIdInstansi(rs.getString(4));
            tukeisi.setIdDiAtasan(rs.getString(5));
            tukeisi.setInstansiNama(rs.getString(6));
            tukeisi.setIdIsi4Faktor(rs.getString(7));
            tukeisi.setNipPns(rs.getString(8));
            tukeisi.setIdTupoksi2(rs.getString(9));
            tukeisi.setKuantitas4(rs.getString(10));
            tukeisi.setKualitas4(rs.getString(11));
            tukeisi.setWaktu4(rs.getString(12));
            tukeisi.setBiaya4(rs.getString(13));
                String s = tukeisi.getBiaya4();
                if (s.equals("-"))
                {
                    s ="000000";
                }
                long n = Long.parseLong(s);
                DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
                formatter.setMaximumFractionDigits(2);
                String nilaibi=formatter.format(n);
                //String hasil=nilaibi.replace('.', ',');
                //String hasil3=hasil.toString();
                String hasil3=nilaibi.toString();
            tukeisi.setBiaya4(hasil3);
            tukeisi.setkuantitas_label(rs.getString(14));
                tukeisi.setwaktu_label(rs.getString(15)); 
                String w = tukeisi.getwaktu_label();
                if (w.equals("-"))
                {
                    w ="bln";
                }
            tukeisi.setwaktu_label(w);
            tukeisi.setangka_krdt(rs.getString(16));
             tukeisi.setangka_krdtR(rs.getString(17));
                
           TupoksiKeIsi4Faktories.add(tukeisi);
        }
        return TupoksiKeIsi4Faktories;
    }
    
    
    
    //
    public TupoksiKeIsi4Faktor getDBqueryTupoksiKeIsi4FaktorId(String sid_tupoksi) throws SQLException
    {
        String sql = "SELECT T.id_tupoksi, T.nama_tupoksi, T.id_unor, T.id_instansi, T.id_atasan, T.instansi_nama, "
                + " I.id_isi4faktor, I.nip_pns, I.id_tupoksi, I.kuantitas4, I.kualitas4, I.waktu4, I.biaya4, I.kuantitas_label,T.angka_krdt,I.angka_krdt "
                + " FROM TUPOKSI T, ISI4FAKTOR I "
                + " WHERE T.id_tupoksi = I.id_tupoksi AND T.id_tupoksi =? ";
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
        TupoksiKeIsi4Faktor tukeisi = null;
        pst.setString(1, sid_tupoksi);
        ResultSet rs = pst.executeQuery();
        if (rs.next())
        {
            tukeisi = new TupoksiKeIsi4Faktor();
            tukeisi.setIdTupoksi(rs.getString(1));
            tukeisi.setNamaTupoksi(rs.getString(2));
            tukeisi.setIdUnor(rs.getString(3));
            tukeisi.setIdInstansi(rs.getString(4));
            tukeisi.setIdDiAtasan(rs.getString(5));
            tukeisi.setInstansiNama(rs.getString(6));
            tukeisi.setIdIsi4Faktor(rs.getString(7));
            tukeisi.setNipPns(rs.getString(8));
            tukeisi.setIdTupoksi2(rs.getString(9));
            tukeisi.setKuantitas4(rs.getString(10));
            tukeisi.setKualitas4(rs.getString(11));
            tukeisi.setWaktu4(rs.getString(12));
            tukeisi.setBiaya4(rs.getString(13));
            tukeisi.setkuantitas_label(rs.getString(14));
            tukeisi.setangka_krdt(rs.getString(15));
            tukeisi.setangka_krdtR(rs.getString(16));
            
        }
        return tukeisi;
    }
    
     public TupoksiKeIsi4Faktor getDBqueryTupoksiKeIsi4FaktorId4(String sid_tupoksi) throws SQLException
    {
        String sql = "SELECT T.id_tupoksi, T.nama_tupoksi, T.id_unor, T.id_instansi, T.id_atasan, T.instansi_nama, "
                + " I.id_isi4faktor, I.nip_pns, I.id_tupoksi, I.kuantitas4, I.kualitas4, I.waktu4, I.biaya4, I.kuantitas_label,T.angka_krdt,I.angka_krdt "
                + " FROM TUPOKSI T, ISI4FAKTOR I "
                + " WHERE T.id_tupoksi = I.id_tupoksi AND I.id_isi4faktor =? ";
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
        TupoksiKeIsi4Faktor tukeisi = null;
        pst.setString(1, sid_tupoksi);
        ResultSet rs = pst.executeQuery();
        if (rs.next())
        {
            tukeisi = new TupoksiKeIsi4Faktor();
            tukeisi.setIdTupoksi(rs.getString(1));
            tukeisi.setNamaTupoksi(rs.getString(2));
            tukeisi.setIdUnor(rs.getString(3));
            tukeisi.setIdInstansi(rs.getString(4));
            tukeisi.setIdDiAtasan(rs.getString(5));
            tukeisi.setInstansiNama(rs.getString(6));
            tukeisi.setIdIsi4Faktor(rs.getString(7));
            tukeisi.setNipPns(rs.getString(8));
            tukeisi.setIdTupoksi2(rs.getString(9));
            tukeisi.setKuantitas4(rs.getString(10));
            tukeisi.setKualitas4(rs.getString(11));
            tukeisi.setWaktu4(rs.getString(12));
            tukeisi.setBiaya4(rs.getString(13));
            tukeisi.setkuantitas_label(rs.getString(14));
            tukeisi.setangka_krdt(rs.getString(15));
            tukeisi.setangka_krdtR(rs.getString(16));
            
        }
        return tukeisi;
    }
    
    
    public List<TupoksiKeIsi4Faktor> getDBqueryTupoksiKeIsi4FaktorSesion(String sid_unor, String sid_instansi, String snip_pns,String _pilih_session) throws SQLException
    {
        List<TupoksiKeIsi4Faktor> TupoksiKeIsi4Faktories = new ArrayList<TupoksiKeIsi4Faktor>();
          
        // String sql = "SELECT T.id_tupoksi, T.nama_tupoksi, T.id_unor, T.id_instansi, T.id_atasan, T.instansi_nama "
        //        + " FROM TUPOKSI T "
        //        + " WHERE T.id_unor = '"+sid_unor+ "'"
        //        + " AND ID_INSTANSI ='"+sid_instansi+ "'";
        
       //  PreparedStatement pst = this.conn.prepareStatement(sql);
       // DBqueryTupoksiKeIsi4Faktor nDBqueryTupoksiKeIsi4Faktor = null;
      // tupoksi tukeisi = null;
      //  ResultSet rs = pst.executeQuery();
        
        String sql = "SELECT T.id_tupoksi, T.nama_tupoksi, T.id_unor, T.id_instansi, T.id_atasan, T.instansi_nama, "
                + " I.id_isi4faktor, I.nip_pns, I.id_tupoksi, I.kuantitas4, I.kualitas4, I.waktu4, I.biaya4, I.kuantitas_label, I.waktu_label,T.angka_krdt,I.angka_krdt,I.session "
                + " FROM TUPOKSI T, ISI4FAKTOR I "
                + " WHERE T.id_tupoksi = I.id_tupoksi AND I.nip_pns ='" +snip_pns+"' and I.session='" +_pilih_session+"' and I.id_unor='"+sid_unor+"'";
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryTupoksiKeIsi4Faktor nDBqueryTupoksiKeIsi4Faktor = null;
       // pst.setString(1, snip_pns);
      //  pst.setString(2, _pilih_session);
       // pst.setString(3, sid_unor);
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            TupoksiKeIsi4Faktor tukeisi = new TupoksiKeIsi4Faktor();
            tukeisi.setIdTupoksi(rs.getString(1));
            tukeisi.setNamaTupoksi(rs.getString(2));
            tukeisi.setIdUnor(rs.getString(3));
            tukeisi.setIdInstansi(rs.getString(4));
            tukeisi.setIdDiAtasan(rs.getString(5));
            tukeisi.setInstansiNama(rs.getString(6));
            tukeisi.setIdIsi4Faktor(rs.getString(7));
            tukeisi.setNipPns(rs.getString(8));
            tukeisi.setIdTupoksi2(rs.getString(9));
            tukeisi.setKuantitas4(rs.getString(10));
            tukeisi.setKualitas4(rs.getString(11));
            tukeisi.setWaktu4(rs.getString(12));
            tukeisi.setBiaya4(rs.getString(13));
                String s = tukeisi.getBiaya4();
                if (s.equals("-"))
                {
                    s ="000000";
                }
                if (s.equals(""))
                {
                    s ="000000";
                }
                 if (s.equals(" "))
                {
                    s ="000000";
                }
                long n = Long.parseLong(s);
                DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
                formatter.setMaximumFractionDigits(2);
                String nilaibi=formatter.format(n);
                //String hasil=nilaibi.replace('.', ',');
                //String hasil3=hasil.toString();
                String hasil3=nilaibi.toString();
            tukeisi.setBiaya4(hasil3);
            tukeisi.setkuantitas_label(rs.getString(14));
                tukeisi.setwaktu_label(rs.getString(15)); 
                String w = tukeisi.getwaktu_label();
                if (w.equals("-"))
                {
                    w ="bln";
                }
                 if (w.equals(""))
                {
                    w ="bln";
                }
                 if (w.equals(" "))
                {
                    w ="bln";
                }
            tukeisi.setwaktu_label(w);
            tukeisi.setangka_krdt(rs.getString(16));
            tukeisi.setangka_krdtR(rs.getString(17));
            tukeisi.setpilih_session(rs.getString(18));
            
           TupoksiKeIsi4Faktories.add(tukeisi);
        }
        return TupoksiKeIsi4Faktories;
    }
    
    
    
      public void hapusTupoksiKeIsi4Faktor(String _id_tupoksi,String _nip) throws SQLException{
       
         String sql = "DELETE FROM ISI4FAKTOR where id_tupoksi='"+_id_tupoksi+"' and  nip_pns='"+ _nip+"'";
          PreparedStatement st = this.conn.prepareStatement(sql);
     //   st.setString(1,IdTupoksi);
        st.executeUpdate(sql);
        st.close();
        
          sql = "DELETE FROM REALISASI where id_tupoksi='"+_id_tupoksi+"' and  nip_pns='"+ _nip+"'";
          PreparedStatement st2 = this.conn.prepareStatement(sql);
     //   st.setString(1,IdTupoksi);
        st2.executeUpdate(sql);
        st2.close();
   }
    
    
     public void hapusTupoksiKeIsi4FaktorRevisi(String _id_tupoksi,String _nip) throws SQLException{
       
         String sql = "DELETE FROM revisi4faktor where id_revisiTarget='"+_id_tupoksi+"' and  nip_pns='"+ _nip+"'";
          PreparedStatement st = this.conn.prepareStatement(sql);
     //   st.setString(1,IdTupoksi);
        st.executeUpdate(sql);
        st.close();
        
       
   }
    
    public List<TupoksiKeIsi4Faktor> getDBqueryTupoksiKeIsi4Faktor(String sid_unor, String sid_instansi, String snip_pns) throws SQLException
    {
        List<TupoksiKeIsi4Faktor> TupoksiKeIsi4Faktories = new ArrayList<TupoksiKeIsi4Faktor>();
                
        String sql = "SELECT T.id_tupoksi, T.nama_tupoksi, T.id_unor, T.id_instansi, T.id_atasan, T.instansi_nama, "
                + " I.id_isi4faktor, I.nip_pns, I.id_tupoksi, I.kuantitas4, I.kualitas4, I.waktu4, I.biaya4, I.kuantitas_label, I.waktu_label,T.angka_krdt,I.angka_krdt "
                + " FROM TUPOKSI T, ISI4FAKTOR I "
                + " WHERE T.id_tupoksi = I.id_tupoksi AND I.nip_pns =? ";
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryTupoksiKeIsi4Faktor nDBqueryTupoksiKeIsi4Faktor = null;
        pst.setString(1, snip_pns);
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            TupoksiKeIsi4Faktor tukeisi = new TupoksiKeIsi4Faktor();
            tukeisi.setIdTupoksi(rs.getString(1));
            tukeisi.setNamaTupoksi(rs.getString(2));
            tukeisi.setIdUnor(rs.getString(3));
            tukeisi.setIdInstansi(rs.getString(4));
            tukeisi.setIdDiAtasan(rs.getString(5));
            tukeisi.setInstansiNama(rs.getString(6));
            tukeisi.setIdIsi4Faktor(rs.getString(7));
            tukeisi.setNipPns(rs.getString(8));
            tukeisi.setIdTupoksi2(rs.getString(9));
            tukeisi.setKuantitas4(rs.getString(10));
            tukeisi.setKualitas4(rs.getString(11));
            tukeisi.setWaktu4(rs.getString(12));
            tukeisi.setBiaya4(rs.getString(13));
                String s = tukeisi.getBiaya4();
                if (s.equals("-"))
                {
                    s ="000000";
                }
                long n = Long.parseLong(s);
                DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
                formatter.setMaximumFractionDigits(2);
                String nilaibi=formatter.format(n);
                //String hasil=nilaibi.replace('.', ',');
                //String hasil3=hasil.toString();
                String hasil3=nilaibi.toString();
            tukeisi.setBiaya4(hasil3);
            tukeisi.setkuantitas_label(rs.getString(14));
                tukeisi.setwaktu_label(rs.getString(15)); 
                String w = tukeisi.getwaktu_label();
                if (w.equals("-"))
                {
                    w ="bln";
                }
            tukeisi.setwaktu_label(w);
            tukeisi.setangka_krdt(rs.getString(16));
             tukeisi.setangka_krdtR(rs.getString(17));
                
           TupoksiKeIsi4Faktories.add(tukeisi);
        }
        return TupoksiKeIsi4Faktories;
    }
    
    
    
    public List<TupoksiKeIsi4Faktor> getDBqueryTupoksiKeIsi4Faktor2(String sid_unor, String sid_instansi, String snip_pns) throws SQLException
    {
        List<TupoksiKeIsi4Faktor> TupoksiKeIsi4Faktories = new ArrayList<TupoksiKeIsi4Faktor>();
                
        String sql = "SELECT T.id_tupoksi, T.nama_tupoksi, T.id_unor, T.id_instansi, T.id_atasan, T.instansi_nama, "
                + " I.id_isi4faktor, I.nip_pns, I.id_tupoksi, I.kuantitas4, I.kualitas4, I.waktu4, I.biaya4, I.kuantitas_label, "
                + "I.waktu_label,T.angka_krdt,I.angka_krdt,I.session,I.detailtupoksi"
                + " FROM TUPOKSI T, ISI4FAKTOR I "
                + " WHERE T.id_tupoksi = I.id_tupoksi AND I.nip_pns =? ";
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryTupoksiKeIsi4Faktor nDBqueryTupoksiKeIsi4Faktor = null;
        pst.setString(1, snip_pns);
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            String detailtupoksi = rs.getString(19);
            TupoksiKeIsi4Faktor tukeisi = new TupoksiKeIsi4Faktor();
            tukeisi.setIdTupoksi(rs.getString(1));
            if(detailtupoksi.equals("") || detailtupoksi == null)
            {
                tukeisi.setNamaTupoksi(rs.getString(2));
            }
            else
            {
                tukeisi.setNamaTupoksi(rs.getString(2) + "-" + rs.getString(19));
            }
            tukeisi.setIdUnor(rs.getString(3));
            tukeisi.setIdInstansi(rs.getString(4));
            tukeisi.setIdDiAtasan(rs.getString(5));
            tukeisi.setInstansiNama(rs.getString(6));
            tukeisi.setIdIsi4Faktor(rs.getString(7));
            tukeisi.setNipPns(rs.getString(8));
            tukeisi.setIdTupoksi2(rs.getString(9));
            tukeisi.setKuantitas4(rs.getString(10));
            tukeisi.setKualitas4(rs.getString(11));
            tukeisi.setWaktu4(rs.getString(12));
            tukeisi.setBiaya4(rs.getString(13));
              
                String s = tukeisi.getBiaya4();
                if (s.equals("-"))
                {
                    s ="000000";
                }
                long n = Long.parseLong(s);
                DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
                formatter.setMaximumFractionDigits(2);
                String nilaibi=formatter.format(n);
                //String hasil=nilaibi.replace('.', ',');
                //String hasil3=hasil.toString();
                String hasil3=nilaibi.toString();
            tukeisi.setBiaya4(hasil3);
            tukeisi.setkuantitas_label(rs.getString(14));
                tukeisi.setwaktu_label(rs.getString(15)); 
                String w = tukeisi.getwaktu_label();
                if (w.equals("-"))
                {
                    w ="bln";
                }
            tukeisi.setwaktu_label(w);
            tukeisi.setangka_krdt(rs.getString(16));
             tukeisi.setangka_krdtR(rs.getString(17));
              tukeisi.setpilih_session(rs.getString(18));
                
           TupoksiKeIsi4Faktories.add(tukeisi);
        }
        return TupoksiKeIsi4Faktories;
    }
    
    
    public List<TupoksiKeIsi4Faktor> getDBqueryTupoksiKeIsi4Faktor2Revisi(String sid_unor, String sid_instansi, String snip_pns) throws SQLException
    {
        List<TupoksiKeIsi4Faktor> TupoksiKeIsi4Faktories = new ArrayList<TupoksiKeIsi4Faktor>();
                
        String sql = "SELECT T.id_tupoksi, T.nama_tupoksi, T.id_unor, T.id_instansi, T.id_atasan, T.instansi_nama, "
                + " I.id_isi4faktor, I.nip_pns, I.id_tupoksi, I.kuantitas4, I.kualitas4, I.waktu4, I.biaya4, I.kuantitas_label, I.waktu_label,T.angka_krdt,I.angka_krdt,I.session "
                + " FROM TUPOKSI T, ISI4FAKTOR I "
                + " WHERE T.id_tupoksi = I.id_tupoksi AND I.nip_pns =? ";
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryTupoksiKeIsi4Faktor nDBqueryTupoksiKeIsi4Faktor = null;
        pst.setString(1, snip_pns);
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            TupoksiKeIsi4Faktor tukeisi = new TupoksiKeIsi4Faktor();
            tukeisi.setIdTupoksi(rs.getString(1));
            tukeisi.setNamaTupoksi(rs.getString(2));
            tukeisi.setIdUnor(rs.getString(3));
            tukeisi.setIdInstansi(rs.getString(4));
            tukeisi.setIdDiAtasan(rs.getString(5));
            tukeisi.setInstansiNama(rs.getString(6));
            tukeisi.setIdIsi4Faktor(rs.getString(7));
            tukeisi.setNipPns(rs.getString(8));
            tukeisi.setIdTupoksi2(rs.getString(9));
            tukeisi.setKuantitas4(rs.getString(10));
            tukeisi.setKualitas4(rs.getString(11));
            tukeisi.setWaktu4(rs.getString(12));
            tukeisi.setBiaya4(rs.getString(13));
              
                String s = tukeisi.getBiaya4();
                if (s.equals("-"))
                {
                    s ="000000";
                }
                long n = Long.parseLong(s);
                DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
                formatter.setMaximumFractionDigits(2);
                String nilaibi=formatter.format(n);
                //String hasil=nilaibi.replace('.', ',');
                //String hasil3=hasil.toString();
                String hasil3=nilaibi.toString();
            tukeisi.setBiaya4(hasil3);
            tukeisi.setkuantitas_label(rs.getString(14));
                tukeisi.setwaktu_label(rs.getString(15)); 
                String w = tukeisi.getwaktu_label();
                if (w.equals("-"))
                {
                    w ="bln";
                }
            tukeisi.setwaktu_label(w);
            tukeisi.setangka_krdt(rs.getString(16));
             tukeisi.setangka_krdtR(rs.getString(17));
              tukeisi.setpilih_session(rs.getString(18));
                
           TupoksiKeIsi4Faktories.add(tukeisi);
        }
        return TupoksiKeIsi4Faktories;
    }
    
      public List<tupoksi> getDBqueryTupoksiStruktural(String sid_unor, String sid_instansi, String snip_pns) throws SQLException
    {
        List<tupoksi> TupoksiKeIsi4Faktories = new ArrayList<tupoksi>();
                
        //String sql = "SELECT T.id_tupoksi, T.nama_tupoksi, T.id_unor, T.id_instansi, T.id_diatasan, T.instansi_nama, "
        //        + " I.id_isi4faktor, I.nip_pns, I.id_tupoksi, I.kuantitas4, I.kualitas4, I.waktu4, I.biaya4, I.kuantitas_label, I.waktu_label,T.angka_krdt,I.angka_krdt "
        //        + " FROM TUPOKSI2 T, ISI4FAKTOR I "
        //        + " WHERE T.id_tupoksi = I.id_tupoksi AND I.nip_pns =? ";
        
        String sql = "SELECT T.id_tupoksi, T.nama_tupoksi, T.id_unor, T.id_instansi, T.id_atasan, T.instansi_nama "
                + " FROM TUPOKSI T "
                + " WHERE T.id_unor = '"+sid_unor+ "'"
                + " AND ID_INSTANSI ='"+sid_instansi+ "'";
        
        
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
       // DBqueryTupoksiKeIsi4Faktor nDBqueryTupoksiKeIsi4Faktor = null;
       tupoksi tukeisi = null;
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            tukeisi = new tupoksi();
            tukeisi.setIdTupoksi(rs.getString(1));
            tukeisi.setNamaTupoksi(rs.getString(2));
            tukeisi.setIdUnor(rs.getString(3));
            tukeisi.setIdInstansi(rs.getString(4));
            tukeisi.setIdDiAtasan(rs.getString(5));
            tukeisi.setInstansiNama(rs.getString(6));
              String test = tukeisi.getNamaTupoksi();
            
            
            
        }
        return TupoksiKeIsi4Faktories;
    }
    
    public List<tupoksi> getDBqueryTupoksiFungsional(String Jabatan) throws SQLException
    {
        List<tupoksi> TupoksiKeIsi4Faktories = new ArrayList<tupoksi>();
                
        //String sql = "SELECT T.id_tupoksi, T.nama_tupoksi, T.id_unor, T.id_instansi, T.id_diatasan, T.instansi_nama, "
        //        + " I.id_isi4faktor, I.nip_pns, I.id_tupoksi, I.kuantitas4, I.kualitas4, I.waktu4, I.biaya4, I.kuantitas_label, I.waktu_label,T.angka_krdt,I.angka_krdt "
        //        + " FROM TUPOKSI2 T, ISI4FAKTOR I "
        //        + " WHERE T.id_tupoksi = I.id_tupoksi AND I.nip_pns =? ";
        
        String sql = "SELECT T.id_tupoksi, T.nama_tupoksi, T.id_unor, T.id_instansi, T.id_atasan, T.instansi_nama "
                + " FROM TUPOKSI T "
                + " WHERE T.JABATAN_ID = '"+Jabatan+ "'";
        
        
        
        PreparedStatement pst = this.conn.prepareStatement(sql);
       // DBqueryTupoksiKeIsi4Faktor nDBqueryTupoksiKeIsi4Faktor = null;
       tupoksi tukeisi = null;
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            tukeisi = new tupoksi();
            tukeisi.setIdTupoksi(rs.getString(1));
            tukeisi.setNamaTupoksi(rs.getString(2));
            tukeisi.setIdUnor(rs.getString(3));
            tukeisi.setIdInstansi(rs.getString(4));
            tukeisi.setIdDiAtasan(rs.getString(5));
            tukeisi.setInstansiNama(rs.getString(6));
              String test = tukeisi.getNamaTupoksi();
            
            
            
        }
        return TupoksiKeIsi4Faktories;
    }
    
    
    
    
    
    
}
