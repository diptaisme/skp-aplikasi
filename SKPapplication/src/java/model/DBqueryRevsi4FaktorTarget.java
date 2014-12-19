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
import servlets.ModelLocatorSKP;

/**
 *
 * @author Sony
 */
public class DBqueryRevsi4FaktorTarget {

    Connection conn;

    public DBqueryRevsi4FaktorTarget(Connection conn) {
        this.conn = conn;
    }

    public List<Revisi4FaktorTarget> getDBqueryRevsi4FaktorTargetid(String sid_isi4faktor) throws SQLException {
        List<Revisi4FaktorTarget> isi4faktories = new ArrayList<Revisi4FaktorTarget>();
        String sql = "SELECT id_isi4faktor,nip_pns,id_tupoksi,kuantitas4,kualitas4,waktu4,biaya4,revisi,id_revisiTarget FROM revisi4faktor WHERE id_isi4faktor =? order by revisi";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        Revisi4FaktorTarget revisi4FaktorTarget = null;
        pst.setString(1, sid_isi4faktor);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            revisi4FaktorTarget = new Revisi4FaktorTarget();
            revisi4FaktorTarget.setIdIsi4Faktor(rs.getString(1));
            revisi4FaktorTarget.setNipPns(rs.getString(2));
            revisi4FaktorTarget.setIdTupoksi(rs.getString(3));
            revisi4FaktorTarget.setKuantitas4(rs.getString(4));
            revisi4FaktorTarget.setKualitas4(rs.getString(5));
            revisi4FaktorTarget.setWaktu4(rs.getString(6));
            revisi4FaktorTarget.setBiaya4(rs.getString(7));
            revisi4FaktorTarget.setrevisi(rs.getString(8));
            revisi4FaktorTarget.setid_revisiTarget(rs.getString(9));
        }
        return isi4faktories;
    }

    public List<Revisi4FaktorTarget> getDBqueryRevsi4FaktorTarget(String sId_Tupoksi, String snip_pns) throws SQLException {
        List<Revisi4FaktorTarget> isi4faktories = new ArrayList<Revisi4FaktorTarget>();
        String sql = "SELECT id_isi4faktor,nip_pns,id_tupoksi,kuantitas4,kualitas4,waktu4,biaya4,revisi,id_revisiTarget FROM revisi4faktor WHERE id_isi4faktor =? and nip_pns =? order by revisi";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryIsi4Faktor nDBqueryIsi4Faktor = null;
        pst.setString(3, sId_Tupoksi);
        pst.setString(2, snip_pns);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Revisi4FaktorTarget iisi4faktor = new Revisi4FaktorTarget();
            iisi4faktor.setIdIsi4Faktor(rs.getString(1));
            iisi4faktor.setNipPns(rs.getString(2));
            iisi4faktor.setIdTupoksi(rs.getString(3));
            iisi4faktor.setKuantitas4(rs.getString(4));
            iisi4faktor.setKualitas4(rs.getString(5));
            iisi4faktor.setWaktu4(rs.getString(6));
            iisi4faktor.setBiaya4(rs.getString(7));
            iisi4faktor.setrevisi(rs.getString(8));
            iisi4faktor.setid_revisiTarget(rs.getString(9));
            isi4faktories.add(iisi4faktor);
        }
        return isi4faktories;
    }

    public List<Revisi4FaktorTarget> getDBqueryRevsi4FaktorTargetSesion(String sId_Tupoksi, String snip_pns, String session) throws SQLException {
        List<Revisi4FaktorTarget> isi4faktories = new ArrayList<Revisi4FaktorTarget>();
        String sql = "SELECT id_isi4faktor,nip_pns,id_tupoksi,kuantitas4,kualitas4,waktu4,biaya4,revisi,id_revisiTarget FROM revisi4faktor WHERE id_isi4faktor =? and nip_pns =? and session =? order by revisi";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryIsi4Faktor nDBqueryIsi4Faktor = null;
        pst.setString(1, sId_Tupoksi);
        pst.setString(2, snip_pns);
        pst.setString(3, session);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Revisi4FaktorTarget iisi4faktor = new Revisi4FaktorTarget();
            iisi4faktor.setIdIsi4Faktor(rs.getString(1));
            iisi4faktor.setNipPns(rs.getString(2));
            iisi4faktor.setIdTupoksi(rs.getString(3));
            iisi4faktor.setKuantitas4(rs.getString(4));
            iisi4faktor.setKualitas4(rs.getString(5));
            iisi4faktor.setWaktu4(rs.getString(6));
            iisi4faktor.setBiaya4(rs.getString(7));
            iisi4faktor.setrevisi(rs.getString(8));
            iisi4faktor.setid_revisiTarget(rs.getString(9));
            isi4faktories.add(iisi4faktor);
        }
        return isi4faktories;
    }

    public List<TupoksiRevisiTarget> getDBqueryRevsi4FaktorTargetFaktor2(String sid_unor, String sid_instansi, String snip_pns) throws SQLException {
        List<TupoksiRevisiTarget> TupoksiKeIsi4Faktories = new ArrayList<TupoksiRevisiTarget>();

        String sql = "SELECT T.id_tupoksi, T.nama_tupoksi, T.id_unor, T.id_instansi, T.id_atasan, T.instansi_nama, "
                + " I.id_isi4faktor, I.nip_pns, I.id_tupoksi, I.kuantitas4, I.kualitas4, I.waktu4, I.biaya4, I.kuantitas_label, I.waktu_label,T.angka_krdt,I.angka_krdt,I.session, "
                + " I.revisi,I.id_revisiTarget,I.jnsperubahan FROM tupoksi T, revisi4faktor I "
                + " WHERE T.id_tupoksi = I.id_tupoksi AND I.nip_pns =? order by I.id_isi4faktor,I.revisi";

        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryTupoksiKeIsi4Faktor nDBqueryTupoksiKeIsi4Faktor = null;
        pst.setString(1, snip_pns);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            TupoksiRevisiTarget tukeisi = new TupoksiRevisiTarget();
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
            if (s.equals("-")) {
                s = "000000";
            }
            long n = Long.parseLong(s);
            DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            formatter.setMaximumFractionDigits(2);
            String nilaibi = formatter.format(n);
            //String hasil=nilaibi.replace('.', ',');
            //String hasil3=hasil.toString();
            String hasil3 = nilaibi.toString();
            tukeisi.setBiaya4(hasil3);
            tukeisi.setkuantitas_label(rs.getString(14));
            tukeisi.setwaktu_label(rs.getString(15));
            String w = tukeisi.getwaktu_label();
            if (w.equals("-")) {
                w = "bln";
            }
            tukeisi.setwaktu_label(w);
            tukeisi.setangka_krdt(rs.getString(16));
            tukeisi.setangka_krdtR(rs.getString(17));
            tukeisi.setpilih_session(rs.getString(18));
            tukeisi.setrevisi(rs.getString(19));
            tukeisi.setid_revisiTarget(rs.getString(20));
            tukeisi.setjns_perubahan(rs.getString(21));

            TupoksiKeIsi4Faktories.add(tukeisi);
        }
        return TupoksiKeIsi4Faktories;
    }

    public List<TupoksiRevisiTarget> getDBqueryRevsi4FaktorTargetFaktor2Session(String sid_unor, String session, String snip_pns) throws SQLException {
        List<TupoksiRevisiTarget> TupoksiKeIsi4Faktories = new ArrayList<TupoksiRevisiTarget>();

        String sql = "SELECT T.id_tupoksi, T.nama_tupoksi, T.id_unor, T.id_instansi, T.id_atasan, T.instansi_nama, "
                + " I.id_isi4faktor, I.nip_pns, I.id_tupoksi, I.kuantitas4, I.kualitas4, I.waktu4, I.biaya4, I.kuantitas_label, I.waktu_label,T.angka_krdt,I.angka_krdt,I.session, "
                + " I.revisi,I.id_revisiTarget,I.jnsperubahan FROM tupoksi T, revisi4faktor I "
                + " WHERE T.id_tupoksi = I.id_tupoksi AND I.nip_pns =? and I.session =? order by I.id_isi4faktor,I.revisi";

        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryTupoksiKeIsi4Faktor nDBqueryTupoksiKeIsi4Faktor = null;
        pst.setString(1, snip_pns);
        pst.setString(2, session);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            TupoksiRevisiTarget tukeisi = new TupoksiRevisiTarget();
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
            if (s.equals("-")) {
                s = "000000";
            }
            long n = Long.parseLong(s);
            DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            formatter.setMaximumFractionDigits(2);
            String nilaibi = formatter.format(n);
            //String hasil=nilaibi.replace('.', ',');
            //String hasil3=hasil.toString();
            String hasil3 = nilaibi.toString();
            tukeisi.setBiaya4(hasil3);
            tukeisi.setkuantitas_label(rs.getString(14));
            tukeisi.setwaktu_label(rs.getString(15));
            String w = tukeisi.getwaktu_label();
            if (w.equals("-")) {
                w = "bln";
            }
            tukeisi.setwaktu_label(w);
            tukeisi.setangka_krdt(rs.getString(16));
            tukeisi.setangka_krdtR(rs.getString(17));
            tukeisi.setpilih_session(rs.getString(18));
            tukeisi.setrevisi(rs.getString(19));
            tukeisi.setid_revisiTarget(rs.getString(20));
            tukeisi.setjns_perubahan(rs.getString(21));

            TupoksiKeIsi4Faktories.add(tukeisi);
        }
        return TupoksiKeIsi4Faktories;
    }

    public String makRevisi4faktorId() throws SQLException {
        String max = null;
        int imax;

        String sql = "SELECT MAX(id_revisiTarget) as maks FROM  revisi4faktor";
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

    public String makRevisi4faktorRevisi(String idisi4faktor) throws SQLException {
        String max = null;
        int imax;

        String sql = "SELECT MAX(revisi) as maks FROM  revisi4faktor where id_isi4faktor='" + idisi4faktor + "'";
        PreparedStatement st = this.conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            max = rs.getString("maks");
            if (max != null) {

                imax = Integer.parseInt(max);
            } else {
                imax = 0;
            }
            imax++;
            max = Integer.toString(imax);
        } else {
            max = "1";
        }

        return max;
    }

    public void insertRevisi4faktorRevisi(String maksId, String maksrevisi, String idisi4faktor, String _iNip_id, String UnorIdisert, String IdTupoksi, String ikuantitas4, String ikualitas4, String iWaktu4, String iBiaya, String _angkaKreditr, String ipilih, String iwaktuL, String s_pilih_session,String _detailkegiatan) throws SQLException {
        String _maksId = maksId;
        String _maksrevisi = maksrevisi;
        String __iNip_id = _iNip_id;
        String _IdTupoksi = IdTupoksi;
        String _idisi4faktor = idisi4faktor;
        String _ikuantitas4 = ikuantitas4;
        String _ikualitas4 = ikualitas4;
        String _iWaktu4 = iWaktu4;
        String _iBiaya = iBiaya;
        String _ipilih = ipilih;
        String _iwaktuL = iwaktuL;
        String _UnorIdisertL = UnorIdisert;
        String __angkaKreditr = _angkaKreditr;
        String __s_pilih_session = s_pilih_session;

        validasiString vs = new validasiString();
        vs.setmashudi(_maksId);
        _maksId = vs.getmashudi();
        vs.setmashudi(__iNip_id);
        __iNip_id = vs.getmashudi();
        vs.setmashudi(_IdTupoksi);
        _IdTupoksi = vs.getmashudi();

        vs.setmashudi(_maksrevisi);
        _maksrevisi = vs.getmashudi();

        vs.setmashudi(_idisi4faktor);
        _idisi4faktor = vs.getmashudi();

        vs.setmashudi(__angkaKreditr);
        __angkaKreditr = vs.getmashudi();
        String perubahan = "x";
        String perubahan_Kuantitas = "x";
        String perubahan_Kualitas = "x";
        String perubahan_Waktu = "x";
        String perubahan_Biaya = "x";
        String perubahan_krdt = "x";


        if (!ModelLocatorSKP.globalKuantitasTarget.equals(_ikuantitas4)) {
            perubahan_Kuantitas = "u";
        }
        if (!ModelLocatorSKP.globalKualitasTarget.equals(_ikualitas4)) {
            perubahan_Kualitas = "u";
        }
        if (!ModelLocatorSKP.globalWaktuTarget.equals(_iWaktu4)) {
            perubahan_Waktu = "u";
        }
        if (!ModelLocatorSKP.globalBiayaTarget.equals(_iBiaya)) {
            perubahan_Biaya = "u";
        }
        if (ModelLocatorSKP.globalNilaiKreditTarget != null) {
            if (!ModelLocatorSKP.globalNilaiKreditTarget.equals(__angkaKreditr)) {
                perubahan_krdt = "u";
            }
        }

        perubahan = perubahan_Kuantitas + perubahan_Kualitas + perubahan_Waktu + perubahan_Biaya + perubahan_krdt;


        String sql = "INSERT INTO revisi4faktor(revisi,id_revisiTarget,id_isi4faktor, nip_pns, id_unor,id_tupoksi, kuantitas4, kualitas4, waktu4, biaya4,waktu_label, kuantitas_label,angka_krdt,jnsperubahan,session) VALUES('" + _maksrevisi + "', '" + _maksId + "','" + _idisi4faktor + "', '" + __iNip_id + "', '" + _UnorIdisertL + "', '" + _IdTupoksi + "', '" + _ikuantitas4 + "', '" + _ikualitas4 + "', '" + _iWaktu4 + "', '" + _iBiaya + "', '" + _iwaktuL + "', '" + _ipilih + "', '" + __angkaKreditr + "', '" + perubahan + "','" + __s_pilih_session + "')";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.executeUpdate(sql);
        st.close();

    }
}
