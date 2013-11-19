/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

//import com.mysql.jdbc.PreparedStatement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author diptaisme
 */
public class DBqueryUpdateTupoksi {
       Connection conn;
    
    public DBqueryUpdateTupoksi(Connection conn)
    {
        this.conn = conn;
    }
    
    public void updateTupoksi(String _iNip_id,String IdTupoksi, String ikuantitas4,String ikualitas4,String iWaktu4,String iBiaya, String pilih, String waktuL,String _angkaKredit,String _pilih_session,String _getidUnor4jspSesiion4) throws SQLException{
          String __iNip_id = _iNip_id;
          String _IdTupoksi=IdTupoksi;
          String _ikuantitas4=ikuantitas4;
          String _ikualitas4=ikualitas4;
          String _iWaktu4=iWaktu4;
          String _iBiaya=iBiaya;
          String _pilih = pilih;
          String _waktuL = waktuL;
          String _angkaKreditik=_angkaKredit;
           String s_pilih_session=_pilih_session;
            String s_getidUnor4jspSesiion4=_getidUnor4jspSesiion4;
           String hasil3R =" ";
          if (_angkaKreditik !=null || !_angkaKreditik.equals("-")  || !_angkaKreditik.equals(" ")  ) {
              if (_angkaKreditik.length() > 0 ) {
           //  double nR = java.lang.Double.parseDouble(_angkaKreditik);
           float nR = Float.parseFloat(_angkaKreditik);
      //    int nR =Integer.parseInt(_angkaKreditik);
              int t_ikuantitas4=Integer.parseInt(_ikuantitas4);
            //   String counter = java.lang.Integer.toString(i); 
                nR=nR * t_ikuantitas4;
                DecimalFormat formatterR = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
                formatterR.setMaximumFractionDigits(4);
                String nilaibiR = formatterR.format(nR);
                hasil3R = nilaibiR.toString();
              }
          }
         
          
        validasiString vs = new validasiString();
        
        vs.setkoma(hasil3R);
        _angkaKreditik = vs.getmashudi();
        
        vs.setmashudi(__iNip_id);
        __iNip_id = vs.getmashudi();
        
        vs.setmashudi(_IdTupoksi);
        _IdTupoksi = vs.getmashudi();
        
        vs.setmashudi(_ikuantitas4);
        _ikuantitas4 = vs.getmashudi();
        
        vs.setmashudi(_ikualitas4);
        _ikualitas4 = vs.getmashudi();
        
        vs.setmashudi(_iWaktu4);
        _iWaktu4 = vs.getmashudi();
        
        vs.setmashudi(_iBiaya);
        _iBiaya = vs.getmashudi();
        
        vs.setmashudi(_pilih);
        _pilih = vs.getmashudi();
        
        vs.setmashudi(_waktuL);
        _waktuL = vs.getmashudi();
        
       
        String sql = "UPDATE isi4faktor SET angka_krdt='"+_angkaKreditik +"',kuantitas4 ='"+_ikuantitas4 +"', kualitas4='"+_ikualitas4+"', waktu4='"+_iWaktu4 +"', biaya4='"+_iBiaya+"', kuantitas_label='"+_pilih+"', waktu_label='"+_waktuL+"', session='"+s_pilih_session+"', id_unor='"+ s_getidUnor4jspSesiion4+"' where id_tupoksi='"+_IdTupoksi+"' and nip_pns ='"+__iNip_id+"' ";
      //  PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
          PreparedStatement st = this.conn.prepareStatement(sql);
     //   st.setString(1,IdTupoksi);
        st.executeUpdate(sql);
        st.close();
    }
    
    public void insertTupoksi(String maks,String _iNip_id, String UnorIdisert,String IdTupoksi,String ikuantitas4,String ikualitas4,String iWaktu4,String iBiaya, String ipilih, String iwaktuL) throws SQLException
    {
          String _maks = maks;
          String __iNip_id = _iNip_id;
          String _IdTupoksi=IdTupoksi;
          String _ikuantitas4=ikuantitas4;
          String _ikualitas4=ikualitas4;
          String _iWaktu4=iWaktu4;
          String _iBiaya=iBiaya;
          String _ipilih = ipilih;
          String _iwaktuL = iwaktuL;
           String _UnorIdisertL = UnorIdisert;
        
        validasiString vs = new validasiString();
        vs.setmashudi(_maks);
        _maks = vs.getmashudi();
        vs.setmashudi(__iNip_id);
        __iNip_id = vs.getmashudi();
        vs.setmashudi(_IdTupoksi);
        _IdTupoksi = vs.getmashudi();
//        vs.setmashudi(_ikuantitas4);
//        vs.setmashudi(_ikualitas4);
//        vs.setmashudi(_iWaktu4);
//        vs.setmashudi(_iBiaya);
//        vs.setmashudi(_ipilih);
//        vs.setmashudi(_iwaktuL);
//        _ikuantitas4 = vs.getmashudi();
//        _ikualitas4 = vs.getmashudi();
//        _iWaktu4 = vs.getmashudi();
//        _iBiaya = vs.getmashudi();
//        _ipilih = vs.getmashudi();
//        _iwaktuL = vs.getmashudi();
        
        String sql = "INSERT INTO isi4faktor(id_isi4faktor, nip_pns, id_unor,id_tupoksi, kuantitas4, kualitas4, waktu4, biaya4, kuantitas_label, waktu_label) VALUES('"+_maks+"', '"+__iNip_id+"', '"+_UnorIdisertL+"', '"+_IdTupoksi+"', '"+_ikuantitas4 +"', '"+_ikualitas4+"', '"+_iWaktu4 +"', '"+_iBiaya+"', '"+_ipilih+"', '"+_iwaktuL+"')";
        PreparedStatement st = this.conn.prepareStatement(sql);
//        st.setString(1, maks);
//        st.setString(2, _iNip_id);
//        st.setString(3, IdTupoksi);
//        st.setString(4, ikuantitas4);
//        st.setString(5, ikualitas4);
//        st.setString(6, iWaktu4);
//        st.setString(7, iBiaya);
        st.executeUpdate(sql);
        st.close();
        
    }
    
    public String makIsi4faktorId() throws SQLException
    {
        String max = null;
        int imax;
        
        String sql = "SELECT MAX(id_isi4faktor) as maks FROM isi4faktor";
        PreparedStatement st = this.conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        if (rs.next())
        {
            max = rs.getString("maks");
            if (max!=null){
                
                 imax = Integer.parseInt(max);
            }else{
                imax = 2000000;
            }
           
            imax++;
            
            max = Integer.toString(imax);
        }
        else
        {
            max = "2000001";
        }
        
        return max;
    }
    
    
    
    
    
    
    public void updateTupoksiRealisasi(String _iNip_id,String IdTupoksi, String ikuantitasR,String ikualitasR,String iWaktuR,String iBiayaR,String angkakrdtR,String _pilih_sessionR) throws SQLException
    {
        String __iNip_id = _iNip_id;
        String _IdTupoksi = IdTupoksi;
        String _ikuantitasR = ikuantitasR;
        String _ikualitasR = ikualitasR;
        String _iWaktuR = iWaktuR;
        String _iBiayaR = iBiayaR;
        String _angkakrdtR=angkakrdtR;
          String _pilih_sessionRr=_pilih_sessionR;
        validasiString vs = new validasiString();
        vs.setmashudi(__iNip_id);
        __iNip_id = vs.getmashudi();
        
           vs.setkoma(_angkakrdtR);
       _angkakrdtR= vs.getmashudi();
        
        vs.setmashudi(_IdTupoksi);
        _IdTupoksi = vs.getmashudi();
        
        vs.setmashudi(_ikuantitasR);
        _ikuantitasR = vs.getmashudi();
        
        vs.setmashudi(_ikualitasR);
        _ikualitasR = vs.getmashudi();
        
        vs.setmashudi(_iWaktuR);
        _iWaktuR = vs.getmashudi();
        
        vs.setmashudi(_iBiayaR);
        _iBiayaR = vs.getmashudi();

        String sql = "UPDATE realisasi SET kuantitasR ='"+_ikuantitasR +"', kualitasR ='"+_ikualitasR+"', waktuR='"+_iWaktuR +"', biayaR='"+_iBiayaR+"',angka_krdt='"+_angkakrdtR+"',session='"+_pilih_sessionRr+"'  where id_tupoksi='"+_IdTupoksi+"' and nip_pns ='"+__iNip_id+"' ";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.executeUpdate(sql);
        st.close();
    }
    
    
    
    public void updateHitunganRealisasi(String _iNip_id,String IdTupoksi, String penghitungan,String nilaicapaian) throws SQLException
    {
        String __iNip_id = _iNip_id;
        String _IdTupoksi = IdTupoksi;
        String _penghitungan = penghitungan;
        String _nilaicapaian = nilaicapaian;
        
        validasiString vs = new validasiString();
        vs.setmashudi(__iNip_id);
        __iNip_id = vs.getmashudi();
        
        vs.setmashudi(_IdTupoksi);
        _IdTupoksi = vs.getmashudi();
        
//        vs.setmashudi(_penghitungan);
//        _penghitungan = vs.getmashudi();
//        
//        vs.setmashudi(_nilaicapaian);
//        _nilaicapaian = vs.getmashudi();

        String sql = "UPDATE realisasi SET penghitungan = '"+_penghitungan+"', nilai_capaian_skp = '"+_nilaicapaian+"' where id_tupoksi='"+_IdTupoksi+"' and nip_pns ='"+__iNip_id+"' ";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.executeUpdate(sql);
        st.close();
    }
    
    
    
    
    public void insertRealisasi(String maks,String idisi4faktor,String insertRealisasi,String nip_pns,String idtupoksi,String ikuantitasR,String ikualitasR,String iWaktuR,String iBiayaR,String iPenghitungan,String iNilaiCapaian,String iBiayanya,String angkakrdtR) throws SQLException
    {
        String _maks = maks;
        String _idisi4faktor = idisi4faktor;
        String _nip_pns = nip_pns;
        String _idtupoksi = idtupoksi;
        String _ikuantitasR = ikuantitasR;
        String _ikualitasR = ikualitasR;
        String _iWaktuR = iWaktuR;
        String _iBiayaR = iBiayaR;
        String _iPenghitungan = iPenghitungan;
        String _iNilaiCapaian = iNilaiCapaian;
        String _iBiayanya = iBiayanya;
         String _angkakrdtR=angkakrdtR;
          String _insertRealisasiR=insertRealisasi;
        
        validasiString vs = new validasiString();
        vs.setmashudi(_maks);
        _maks = vs.getmashudi();
        
         vs.setkoma(_angkakrdtR);
        _angkakrdtR = vs.getmashudi();
        
        vs.setmashudi(_idisi4faktor);
        _idisi4faktor = vs.getmashudi();
        
        vs.setmashudi(_nip_pns);
        _nip_pns = vs.getmashudi();
        
        vs.setmashudi(_idtupoksi);
        _idtupoksi = vs.getmashudi();
        
       // vs.setmashudi(_ikuantitasR);
       // _ikuantitasR = vs.getmashudi();
        
        //vs.setmashudi(_ikualitasR);
        //_ikualitasR = vs.getmashudi();
        
       // vs.setmashudi(_iWaktuR);
       // _iWaktuR = vs.getmashudi();
        
       // vs.setmashudi(_iBiayaR);
       // _iBiayaR = vs.getmashudi();
        
       // vs.setmashudi(_iPenghitungan);
       // _iPenghitungan = vs.getmashudi();
        
       // vs.setmashudi(_iNilaiCapaian);
      //  _iNilaiCapaian = vs.getmashudi();
        
        //vs.setmashudi(_iBiayanya);
        //_iBiayanya = vs.getmashudi();
        
        String sql = "INSERT INTO realisasi(id_realisasi, id_isi4faktor, id_unor,nip_pns, id_tupoksi, kuantitasr, kualitasr, waktur, biayar, penghitungan, nilai_capaian_skp, waktu,angka_krdt) VALUES('"+_maks+"', '"+_idisi4faktor+"', '"+_insertRealisasiR+"', '"+_nip_pns+"', '"+_idtupoksi +"', '"+_ikuantitasR +"', '"+_ikualitasR +"','"+_iWaktuR +"','"+_iBiayaR +"','"+_iPenghitungan +"','"+_iNilaiCapaian +"','"+_iBiayanya +"','"+ _angkakrdtR +"')";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.executeUpdate(sql);
        st.close(); 
    }
    
    public String makRealisasi() throws SQLException
    {
        String max = null;
        int imax;
        
        String sql = "SELECT MAX(id_realisasi) as maks FROM realisasi";
        PreparedStatement st = this.conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        //String a = rs.getString("maks");
        //System.out.println("a = "+a);
        if (rs.next())
        //if (a != null)
        {
            max = rs.getString("maks");
          if (max  != null)  {
               imax = Integer.parseInt(max);
          }else{
              imax =3000000;
          }
           
            imax++;
            
            max = Integer.toString(imax);
        }
        else
        {
            max = "3000001";
        }
        
        return max;
    }
}
