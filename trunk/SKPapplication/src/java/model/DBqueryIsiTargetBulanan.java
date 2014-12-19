/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author radius
 */
public class DBqueryIsiTargetBulanan {

    Connection conn;

    public DBqueryIsiTargetBulanan(Connection conn) {
        this.conn = conn;
    }

    public String makTargetBulananId() throws SQLException {
        String max = null;
        int imax;

        String sql = "SELECT MAX(id) as maks FROM isitargetbulanan";
        PreparedStatement st = this.conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            max = rs.getString("maks");
            if (max != null) {

                imax = Integer.parseInt(max);
            } else {
                imax = 1000000000;
            }

            imax++;

            max = Integer.toString(imax);
        } else {
            max = "1000000001";
        }

        return max;
    }

    public void insertTargetBulanan(String maks, String id_isi4faktor, String nip_pns, String id_tupoksi, String kuantitas_bulan, String kualitas_bulan, String waktu_bulan, String biaya_bulan, String bulanke) throws SQLException {
        String _maks = maks;

        String _id_isi4faktor = id_isi4faktor;
        String _nip_pns = nip_pns;
        String _id_tupoksi = id_tupoksi;
        String _kuantitas_bulan = kuantitas_bulan;
        String _kualitas_bulan = kualitas_bulan;
        String _waktu_bulan = waktu_bulan;
        String _biaya_bulan = biaya_bulan;
        String _bulanke = bulanke;
        String detailtupoksi = null;
        validasiString vs = new validasiString();
        vs.setmashudi(_maks);
        _maks = vs.getmashudi();
        _biaya_bulan=vs.validasidata(_biaya_bulan);

        //vs.setmashudi(_IdTupoksi);
        //_IdTupoksi = vs.getmashudi();
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

        String sql = "INSERT INTO isitargetbulanan(id,id_isi4faktor,nip_pns,id_tupoksi, kuantitas_bulan, kualitas_bulan, waktu_bulan, biaya_bulan, bulanke) VALUES('" + _maks + "', '" + _id_isi4faktor + "', '" + _nip_pns + "', '" + _id_tupoksi + "', '" + _kuantitas_bulan + "', '" + _kualitas_bulan + "', '" + _waktu_bulan + "', '" + _biaya_bulan + "', '" + _bulanke + "')";
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

    public void DeleteIsiTargetBulanke(String id) throws SQLException {
        String sql = "DELETE FROM isitargetbulanan where id='" + id + "'";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.executeUpdate(sql);
        st.close();
    }

    public void updateisitargetbulanan(String id, String id_isi4faktor, String nip_pns, String id_tupoksi, String kuantitas_bulan, String kualitas_bulan, String waktu_bulan, String biaya_bulan, String bulanke) throws SQLException {
        String _id = id;

        String _id_isi4faktor = id_isi4faktor;
        String _nip_pns = nip_pns;
        String _id_tupoksi = id_tupoksi;
        String _kuantitas_bulan = kuantitas_bulan;
        String _kualitas_bulan = kualitas_bulan;
        String _waktu_bulan = waktu_bulan;
        String _biaya_bulan = biaya_bulan;
        String _bulanke = bulanke;
        String detailtupoksi = null;
        validasiString vs = new validasiString();
         _biaya_bulan=vs.validasidata(_biaya_bulan);

        String sql = "UPDATE isitargetbulanan SET kuantitas_bulan ='" + _kuantitas_bulan + "', kualitas_bulan ='" + kualitas_bulan + "', waktu_bulan='" + waktu_bulan + "', biaya_bulan='" + biaya_bulan + "'  where id_tupoksi='" + _id_tupoksi + "' and nip_pns ='" + _nip_pns + "' and id_isi4faktor='" + id_isi4faktor + "' and bulanke='" + bulanke + "' ";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.executeUpdate(sql);
        st.close();
    }

    public List<IsiTargetBulanan> getDBqueryTargetBulan(String sId_Tupoksi, String snip_pns, String sid_isi4faktor) throws SQLException {
        List<IsiTargetBulanan> RealisasiIsi4faktorTupoksies = new ArrayList<IsiTargetBulanan>();
        //  List<realisasi> realisasies = new ArrayList<realisasi>();
        String sql = "SELECT i.id,i.id_isi4faktor,i.nip_pns,i.id_tupoksi,i.kuantitas_bulan,i.kualitas_bulan,i.waktu_bulan,i.biaya_bulan,i.bulanke,t.nama_tupoksi FROM isitargetbulanan i,tupoksi t WHERE i.id_tupoksi=t.id_tupoksi and i.id_tupoksi =? and i.nip_pns =? and i.id_isi4faktor =? ORDER BY i.bulanke ";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryRealisasi nDBqueryRealisasi = null;
        IsiTargetBulanan irealisasi = null;
        pst.setString(1, sId_Tupoksi);
        pst.setString(2, snip_pns);
        pst.setString(3, sid_isi4faktor);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            irealisasi = new IsiTargetBulanan();
            irealisasi.setId(rs.getString(1));
            irealisasi.setid_Isi4faktor(rs.getString(2));
            irealisasi.setnip_pns(rs.getString(3));
            irealisasi.setid_tupoksi(rs.getString(4));
            irealisasi.setkuantitas_bulan(rs.getString(5));
            irealisasi.setkualitas_bulan(rs.getString(6));
            irealisasi.setwaktu_bulan(rs.getString(7));
            irealisasi.setbiaya_bulan(rs.getString(8));
            irealisasi.setbulanke(rs.getString(9));
            irealisasi.setNamaTupoksi(rs.getString(10));
            RealisasiIsi4faktorTupoksies.add(irealisasi);

            //  realisasies.add(irealisasi);
        }
        return RealisasiIsi4faktorTupoksies;
    }
public IsiTargetBulanan getDBqueryTargetBulanId(String sId) throws SQLException {
        //  List<realisasi> realisasies = new ArrayList<realisasi>();
       List<IsiTargetBulanan> RealisasiIsi4faktorTupoksies = new ArrayList<IsiTargetBulanan>();
        String sql = "SELECT i.id,i.id_isi4faktor,i.nip_pns,i.id_tupoksi,i.kuantitas_bulan,i.kualitas_bulan,i.waktu_bulan,i.biaya_bulan,i.bulanke,t.nama_tupoksi FROM isitargetbulanan i,tupoksi t WHERE t.id_tupoksi=i.id_tupoksi and i.id =? ";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryRealisasi nDBqueryRealisasi = null;
        IsiTargetBulanan irealisasi = null;
        pst.setString(1, sId);
       
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            irealisasi = new IsiTargetBulanan();
            irealisasi.setId(rs.getString(1));
            irealisasi.setid_Isi4faktor(rs.getString(2));
            irealisasi.setnip_pns(rs.getString(3));
            irealisasi.setid_tupoksi(rs.getString(4));
            irealisasi.setkuantitas_bulan(rs.getString(5));
            irealisasi.setkualitas_bulan(rs.getString(6));
            irealisasi.setwaktu_bulan(rs.getString(7));
            irealisasi.setbiaya_bulan(rs.getString(8));
            irealisasi.setbulanke(rs.getString(9));
            irealisasi.setNamaTupoksi(rs.getString(10));
           // RealisasiIsi4faktorTupoksies.add(irealisasi);
            
            //  realisasies.add(irealisasi);
        }
        return irealisasi;
    }
    public List<IsiTargetBulanan> getDBqueryTargetBulanke(String sId_Tupoksi, String snip_pns, String sid_isi4faktor, String bulanke) throws SQLException {
        //  List<realisasi> realisasies = new ArrayList<realisasi>();
       List<IsiTargetBulanan> RealisasiIsi4faktorTupoksies = new ArrayList<IsiTargetBulanan>();
        String sql = "SELECT i.id,i.id_isi4faktor,i.nip_pns,i.id_tupoksi,i.kuantitas_bulan,i.kualitas_bulan,i.waktu_bulan,i.biaya_bulan,i.bulanke,t.nama_tupoksi FROM isitargetbulanan i,tupoksi t WHERE t.id_tupoksi=i.id_tupoksi and i.id_tupoksi =? and i.nip_pns =? and i.id_isi4faktor =? and i.bulanke=? ";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryRealisasi nDBqueryRealisasi = null;
        IsiTargetBulanan irealisasi = null;
        pst.setString(1, sId_Tupoksi);
        pst.setString(2, snip_pns);
        pst.setString(3, sid_isi4faktor);
        pst.setString(4, bulanke);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            irealisasi = new IsiTargetBulanan();
            irealisasi.setId(rs.getString(1));
            irealisasi.setid_Isi4faktor(rs.getString(2));
            irealisasi.setnip_pns(rs.getString(3));
            irealisasi.setid_tupoksi(rs.getString(4));
            irealisasi.setkuantitas_bulan(rs.getString(5));
            irealisasi.setkualitas_bulan(rs.getString(6));
            irealisasi.setwaktu_bulan(rs.getString(7));
            irealisasi.setbiaya_bulan(rs.getString(8));
            irealisasi.setbulanke(rs.getString(9));
            irealisasi.setNamaTupoksi(rs.getString(10));
            RealisasiIsi4faktorTupoksies.add(irealisasi);
            
            //  realisasies.add(irealisasi);
        }
        return RealisasiIsi4faktorTupoksies;
    }
}
