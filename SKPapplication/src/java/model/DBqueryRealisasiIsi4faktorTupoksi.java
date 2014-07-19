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
public class DBqueryRealisasiIsi4faktorTupoksi {
    //dari DOMAIN : RealisasiIsi4faktorTupoksi

    Connection conn;

    public DBqueryRealisasiIsi4faktorTupoksi(Connection conn) {
        this.conn = conn;
    }
public List<RealisasiIsi4faktorTupoksi> getDBqueryRealisasiIsi4faktorTupoksiSessionRevisi(String id_unor, String snippns, String _pilih_session) throws SQLException {
        List<RealisasiIsi4faktorTupoksi> RealisasiIsi4faktorTupoksies = new ArrayList<RealisasiIsi4faktorTupoksi>();

        String sql = "select "
                + "r.id_realisasi, "
                + "r.id_isi4faktor, "
                + "r.nip_pns, "
                + "r.id_tupoksi, "
                + "r.kuantitasr, "
                + "r.kualitasr, "
                + "r.waktur, "
                + "r.biayar, "
                + "r.penghitungan, "
                + "r.nilai_capaian_skp, "
                + "r.waktu, "
                + "i.kuantitas4, "
                + "i.kualitas4, "
                + "i.waktu4, "
                + "i.biaya4, "
                + "i.kuantitas_label, "
                + "i.waktu_label, "
                + "r.angka_krdt, "
                + "i.angka_krdt, "
                + "t.nama_tupoksi, "
                + "r.session,i.revisi,i.id_revisiTarget,i.jnsperubahan "
                + "from "
                + "realisasi r, "
                + "tupoksi t, "
                + "revisi4faktor i "
                + "where "
                + "r.id_isi4faktor = i.id_isi4faktor and "
                + "r.id_tupoksi = t.id_tupoksi and "
                + "r.nip_pns =? and r.session =? and r.id_unor =?  order by i.id_isi4faktor,i.revisi ";
        //+ "r.nip_pns =? and "
        //+ "r.id_tupoksi =?";
        //+ "i.id_isi4faktor = ''";

        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryRealisasiIsi4faktorTupoksi nDBqueryRealisasiIsi4faktorTupoksi = null;
        //pst.setString(1, sid_isi4faktor);
        pst.setString(1, snippns);
        pst.setString(2, _pilih_session);
        pst.setString(3, id_unor);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            RealisasiIsi4faktorTupoksi real4faktupok = new RealisasiIsi4faktorTupoksi();
            real4faktupok.setId_realisasi(rs.getString(1));
            real4faktupok.setId_isi4faktor(rs.getString(2));
            real4faktupok.setNip_pns(rs.getString(3));
            real4faktupok.setId_tupoksi(rs.getString(4));
            real4faktupok.setKuantitasr(rs.getString(5));
            real4faktupok.setKualitasr(rs.getString(6));
            real4faktupok.setWaktur(rs.getString(7));
            real4faktupok.setBiayar(rs.getString(8));
            String sR = real4faktupok.getBiayar();
            if (sR.equals("-")) {
                sR = "000000";
            }
            long nR = Long.parseLong(sR);
            DecimalFormat formatterR = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            formatterR.setMaximumFractionDigits(2);
            String nilaibiR = formatterR.format(nR);
            String hasil3R = nilaibiR.toString();
            real4faktupok.setBiayar(hasil3R);
            real4faktupok.setPenghitungan(rs.getString(9));
            real4faktupok.setNilai_capaian_skp(rs.getString(10));
            real4faktupok.setWaktu(rs.getString(11));
            real4faktupok.setKuantitas4(rs.getString(12));
            real4faktupok.setKualitas4(rs.getString(13));
            real4faktupok.setWaktu4(rs.getString(14));
            real4faktupok.setBiaya4(rs.getString(15));
            String s4 = real4faktupok.getBiaya4();
            if (s4.equals("-")) {
                s4 = "000000";
            }
            long n4 = Long.parseLong(s4);
            DecimalFormat formatter4 = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            formatter4.setMaximumFractionDigits(2);
            String nilaibi4 = formatter4.format(n4);
            String hasil34 = nilaibi4.toString();
            real4faktupok.setBiaya4(hasil34);
            real4faktupok.setKuantitas_label(rs.getString(16));
            real4faktupok.setWaktu_label(rs.getString(17));
            real4faktupok.setangkaKrdtr(rs.getString(18));
            real4faktupok.setangkaKrdt4(rs.getString(19));
            real4faktupok.setNama_tupoksi(rs.getString(20));
            real4faktupok.set_pilih_session(rs.getString(21));
            real4faktupok.setrevisi(rs.getString(22));
            real4faktupok.setid_revisiTarget(rs.getString(23));
            real4faktupok.setjns_perubahan(rs.getString(24));
            tupoksi tupoksiak = new GoIndex().getIdtupoksiAll(rs.getString(4));
            String namaAk = tupoksiak.getangka_krdt();

            String namat = real4faktupok.getNama_tupoksi();

            if (namaAk.equals("")) {
                namaAk = " ";
            } else if (namaAk == null) {
                namaAk = " ";
            } else {
                namaAk = " (" + namaAk + ")";
            }

            namat = namat + namaAk;
            real4faktupok.setNama_tupoksi(namat);


            RealisasiIsi4faktorTupoksies.add(real4faktupok);
        }
        return RealisasiIsi4faktorTupoksies;
    }
 public List<RealisasiIsi4faktorTupoksi> getDBqueryRealisasiIsi4faktorTupoksiReviai(String snippns) throws SQLException {
        List<RealisasiIsi4faktorTupoksi> RealisasiIsi4faktorTupoksies = new ArrayList<RealisasiIsi4faktorTupoksi>();

        String sql = "select "
                + "r.id_realisasi, "
                + "r.id_isi4faktor, "
                + "r.nip_pns, "
                + "r.id_tupoksi, "
                + "r.kuantitasr, "
                + "r.kualitasr, "
                + "r.waktur, "
                + "r.biayar, "
                + "r.penghitungan, "
                + "r.nilai_capaian_skp, "
                + "r.waktu, "
                + "i.kuantitas4, "
                + "i.kualitas4, "
                + "i.waktu4, "
                + "i.biaya4, "
                + "i.kuantitas_label, "
                + "i.waktu_label, "
                + "r.angka_krdt, "
                + "i.angka_krdt, "
                + "t.nama_tupoksi, "
                + "r.session,i.revisi,i.id_revisiTarget,i.jnsperubahan "
                + "from "
                + "realisasi r, "
                + "tupoksi t, "
                + "revisi4faktor i "
                + "where "
                + "r.id_isi4faktor = i.id_isi4faktor and "
                + "r.id_tupoksi = t.id_tupoksi and "
                + "r.nip_pns =? order by i.id_isi4faktor,i.revisi ";
        //+ "r.nip_pns =? and "
        //+ "r.id_tupoksi =?";
        //+ "i.id_isi4faktor = ''";

        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryRealisasiIsi4faktorTupoksi nDBqueryRealisasiIsi4faktorTupoksi = null;
        //pst.setString(1, sid_isi4faktor);
        pst.setString(1, snippns);
        //pst.setString(2, sidtupoksi);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            RealisasiIsi4faktorTupoksi real4faktupok = new RealisasiIsi4faktorTupoksi();
            real4faktupok.setId_realisasi(rs.getString(1));
            real4faktupok.setId_isi4faktor(rs.getString(2));
            real4faktupok.setNip_pns(rs.getString(3));
            real4faktupok.setId_tupoksi(rs.getString(4));
            real4faktupok.setKuantitasr(rs.getString(5));
            real4faktupok.setKualitasr(rs.getString(6));
            real4faktupok.setWaktur(rs.getString(7));
            real4faktupok.setBiayar(rs.getString(8));
            String sR = real4faktupok.getBiayar();
            if (sR.equals("-")) {
                sR = "000000";
            }
            long nR = Long.parseLong(sR);
            DecimalFormat formatterR = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            formatterR.setMaximumFractionDigits(2);
            String nilaibiR = formatterR.format(nR);
            String hasil3R = nilaibiR.toString();
            real4faktupok.setBiayar(hasil3R);
            real4faktupok.setPenghitungan(rs.getString(9));
            real4faktupok.setNilai_capaian_skp(rs.getString(10));
            real4faktupok.setWaktu(rs.getString(11));
            real4faktupok.setKuantitas4(rs.getString(12));
            real4faktupok.setKualitas4(rs.getString(13));
            real4faktupok.setWaktu4(rs.getString(14));
            real4faktupok.setBiaya4(rs.getString(15));
            String s4 = real4faktupok.getBiaya4();
            if (s4.equals("-")) {
                s4 = "000000";
            }
            long n4 = Long.parseLong(s4);
            DecimalFormat formatter4 = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            formatter4.setMaximumFractionDigits(2);
            String nilaibi4 = formatter4.format(n4);
            String hasil34 = nilaibi4.toString();
            real4faktupok.setBiaya4(hasil34);
            real4faktupok.setKuantitas_label(rs.getString(16));
            real4faktupok.setWaktu_label(rs.getString(17));
            real4faktupok.setangkaKrdtr(rs.getString(18));
            real4faktupok.setangkaKrdt4(rs.getString(19));
            real4faktupok.setNama_tupoksi(rs.getString(20));
            real4faktupok.set_pilih_session(rs.getString(21));
            real4faktupok.setrevisi(rs.getString(22));
            real4faktupok.setid_revisiTarget(rs.getString(23));
            real4faktupok.setjns_perubahan(rs.getString(24));

            tupoksi tupoksiak = new GoIndex().getIdtupoksiAll(rs.getString(4));
            String namaAk = tupoksiak.getangka_krdt();

            String namat = real4faktupok.getNama_tupoksi();

            if (namaAk.equals("")) {
                namaAk = " ";
            } else if (namaAk == null) {
                namaAk = " ";
            } else {
                namaAk = " (" + namaAk + ")";
            }

            namat = namat + namaAk;
            real4faktupok.setNama_tupoksi(namat);


            RealisasiIsi4faktorTupoksies.add(real4faktupok);
        }
        return RealisasiIsi4faktorTupoksies;
    }
    
    public List<RealisasiIsi4faktorTupoksi> getDBqueryRealisasiIsi4faktorTupoksiSession(String id_unor, String snippns, String _pilih_session) throws SQLException {
        List<RealisasiIsi4faktorTupoksi> RealisasiIsi4faktorTupoksies = new ArrayList<RealisasiIsi4faktorTupoksi>();

        String sql = "select "
                + "r.id_realisasi, "
                + "r.id_isi4faktor, "
                + "r.nip_pns, "
                + "r.id_tupoksi, "
                + "r.kuantitasr, "
                + "r.kualitasr, "
                + "r.waktur, "
                + "r.biayar, "
                + "r.penghitungan, "
                + "r.nilai_capaian_skp, "
                + "r.waktu, "
                + "i.kuantitas4, "
                + "i.kualitas4, "
                + "i.waktu4, "
                + "i.biaya4, "
                + "i.kuantitas_label, "
                + "i.waktu_label, "
                + "r.angka_krdt, "
                + "i.angka_krdt, "
                + "t.nama_tupoksi, "
                + "r.session "
                + "from "
                + "realisasi r, "
                + "tupoksi t, "
                + "isi4faktor i "
                + "where "
                + "r.id_isi4faktor = i.id_isi4faktor and "
                + "r.id_tupoksi = t.id_tupoksi and "
                + "r.nip_pns =? and r.session =? and r.id_unor =? ";
        //+ "r.nip_pns =? and "
        //+ "r.id_tupoksi =?";
        //+ "i.id_isi4faktor = ''";

        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryRealisasiIsi4faktorTupoksi nDBqueryRealisasiIsi4faktorTupoksi = null;
        //pst.setString(1, sid_isi4faktor);
        pst.setString(1, snippns);
        pst.setString(2, _pilih_session);
        pst.setString(3, id_unor);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            RealisasiIsi4faktorTupoksi real4faktupok = new RealisasiIsi4faktorTupoksi();
            real4faktupok.setId_realisasi(rs.getString(1));
            real4faktupok.setId_isi4faktor(rs.getString(2));
            real4faktupok.setNip_pns(rs.getString(3));
            real4faktupok.setId_tupoksi(rs.getString(4));
            real4faktupok.setKuantitasr(rs.getString(5));
            real4faktupok.setKualitasr(rs.getString(6));
            real4faktupok.setWaktur(rs.getString(7));
            real4faktupok.setBiayar(rs.getString(8));
            String sR = real4faktupok.getBiayar();
            if (sR.equals("-")) {
                sR = "000000";
            }
            long nR = Long.parseLong(sR);
            DecimalFormat formatterR = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            formatterR.setMaximumFractionDigits(2);
            String nilaibiR = formatterR.format(nR);
            String hasil3R = nilaibiR.toString();
            real4faktupok.setBiayar(hasil3R);
            real4faktupok.setPenghitungan(rs.getString(9));
            real4faktupok.setNilai_capaian_skp(rs.getString(10));
            real4faktupok.setWaktu(rs.getString(11));
            real4faktupok.setKuantitas4(rs.getString(12));
            real4faktupok.setKualitas4(rs.getString(13));
            real4faktupok.setWaktu4(rs.getString(14));
            real4faktupok.setBiaya4(rs.getString(15));
            String s4 = real4faktupok.getBiaya4();
            if (s4.equals("-")) {
                s4 = "000000";
            }
            long n4 = Long.parseLong(s4);
            DecimalFormat formatter4 = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            formatter4.setMaximumFractionDigits(2);
            String nilaibi4 = formatter4.format(n4);
            String hasil34 = nilaibi4.toString();
            real4faktupok.setBiaya4(hasil34);
            real4faktupok.setKuantitas_label(rs.getString(16));
            real4faktupok.setWaktu_label(rs.getString(17));
            real4faktupok.setangkaKrdtr(rs.getString(18));
            real4faktupok.setangkaKrdt4(rs.getString(19));
            real4faktupok.setNama_tupoksi(rs.getString(20));
            real4faktupok.set_pilih_session(rs.getString(21));
            tupoksi tupoksiak = new GoIndex().getIdtupoksiAll(rs.getString(4));
            String namaAk = tupoksiak.getangka_krdt();

            String namat = real4faktupok.getNama_tupoksi();

            if (namaAk.equals("")) {
                namaAk = " ";
            } else if (namaAk == null) {
                namaAk = " ";
            } else {
                namaAk = " (" + namaAk + ")";
            }

            namat = namat + namaAk;
            real4faktupok.setNama_tupoksi(namat);


            RealisasiIsi4faktorTupoksies.add(real4faktupok);
        }
        return RealisasiIsi4faktorTupoksies;
    }

    //public List<RealisasiIsi4faktorTupoksi> getDBqueryRealisasiIsi4faktorTupoksi(String sid_isi4faktor) throws SQLException
    //public List<RealisasiIsi4faktorTupoksi> getDBqueryRealisasiIsi4faktorTupoksi(String snippns, String sidtupoksi) throws SQLException
    public List<RealisasiIsi4faktorTupoksi> getDBqueryRealisasiIsi4faktorTupoksi(String snippns) throws SQLException {
        List<RealisasiIsi4faktorTupoksi> RealisasiIsi4faktorTupoksies = new ArrayList<RealisasiIsi4faktorTupoksi>();

        String sql = "select "
                + "r.id_realisasi, "
                + "r.id_isi4faktor, "
                + "r.nip_pns, "
                + "r.id_tupoksi, "
                + "r.kuantitasr, "
                + "r.kualitasr, "
                + "r.waktur, "
                + "r.biayar, "
                + "r.penghitungan, "
                + "r.nilai_capaian_skp, "
                + "r.waktu, "
                + "i.kuantitas4, "
                + "i.kualitas4, "
                + "i.waktu4, "
                + "i.biaya4, "
                + "i.kuantitas_label, "
                + "i.waktu_label, "
                + "r.angka_krdt, "
                + "i.angka_krdt, "
                + "t.nama_tupoksi, "
                + "r.session "
                + "from "
                + "realisasi r, "
                + "tupoksi t, "
                + "isi4faktor i "
                + "where "
                + "r.id_isi4faktor = i.id_isi4faktor and "
                + "r.id_tupoksi = t.id_tupoksi and "
                + "r.nip_pns =?";
        //+ "r.nip_pns =? and "
        //+ "r.id_tupoksi =?";
        //+ "i.id_isi4faktor = ''";

        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryRealisasiIsi4faktorTupoksi nDBqueryRealisasiIsi4faktorTupoksi = null;
        //pst.setString(1, sid_isi4faktor);
        pst.setString(1, snippns);
        //pst.setString(2, sidtupoksi);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            RealisasiIsi4faktorTupoksi real4faktupok = new RealisasiIsi4faktorTupoksi();
            real4faktupok.setId_realisasi(rs.getString(1));
            real4faktupok.setId_isi4faktor(rs.getString(2));
            real4faktupok.setNip_pns(rs.getString(3));
            real4faktupok.setId_tupoksi(rs.getString(4));
            real4faktupok.setKuantitasr(rs.getString(5));
            real4faktupok.setKualitasr(rs.getString(6));
            real4faktupok.setWaktur(rs.getString(7));
            real4faktupok.setBiayar(rs.getString(8));
            String sR = real4faktupok.getBiayar();
            if (sR.equals("-")) {
                sR = "000000";
            }
            long nR = Long.parseLong(sR);
            DecimalFormat formatterR = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            formatterR.setMaximumFractionDigits(2);
            String nilaibiR = formatterR.format(nR);
            String hasil3R = nilaibiR.toString();
            real4faktupok.setBiayar(hasil3R);
            real4faktupok.setPenghitungan(rs.getString(9));
            real4faktupok.setNilai_capaian_skp(rs.getString(10));
            real4faktupok.setWaktu(rs.getString(11));
            real4faktupok.setKuantitas4(rs.getString(12));
            real4faktupok.setKualitas4(rs.getString(13));
            real4faktupok.setWaktu4(rs.getString(14));
            real4faktupok.setBiaya4(rs.getString(15));
            String s4 = real4faktupok.getBiaya4();
            if (s4.equals("-")) {
                s4 = "000000";
            }
            long n4 = Long.parseLong(s4);
            DecimalFormat formatter4 = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            formatter4.setMaximumFractionDigits(2);
            String nilaibi4 = formatter4.format(n4);
            String hasil34 = nilaibi4.toString();
            real4faktupok.setBiaya4(hasil34);
            real4faktupok.setKuantitas_label(rs.getString(16));
            real4faktupok.setWaktu_label(rs.getString(17));
            real4faktupok.setangkaKrdtr(rs.getString(18));
            real4faktupok.setangkaKrdt4(rs.getString(19));
            real4faktupok.setNama_tupoksi(rs.getString(20));
            real4faktupok.set_pilih_session(rs.getString(21));
            tupoksi tupoksiak = new GoIndex().getIdtupoksiAll(rs.getString(4));
            String namaAk = tupoksiak.getangka_krdt();

            String namat = real4faktupok.getNama_tupoksi();

            if (namaAk.equals("")) {
                namaAk = " ";
            } else if (namaAk == null) {
                namaAk = " ";
            } else {
                namaAk = " (" + namaAk + ")";
            }

            namat = namat + namaAk;
            real4faktupok.setNama_tupoksi(namat);


            RealisasiIsi4faktorTupoksies.add(real4faktupok);
        }
        return RealisasiIsi4faktorTupoksies;
    }

    public RealisasiIsi4faktorTupoksi getDBqueryRealEmpatFaktorTupoksiId(String sidnippns, String sidtupoksi) throws SQLException {
        String sql = "select "
                + "r.id_realisasi, "
                + "r.id_isi4faktor, "
                + "r.nip_pns, "
                + "r.id_tupoksi, "
                + "r.kuantitasr, "
                + "r.kualitasr, "
                + "r.waktur, "
                + "r.biayar, "
                + "r.penghitungan, "
                + "r.nilai_capaian_skp, "
                + "r.waktu, "
                + "i.kuantitas4, "
                + "i.kualitas4, "
                + "i.waktu4, "
                + "i.biaya4, "
                + "i.kuantitas_label, "
                + "i.waktu_label, "
                + "r.angka_krdt, "
                + "i.angka_krdt, "
                + "t.nama_tupoksi, "
                + "i.session "
                + "from "
                + "realisasi r, "
                + "tupoksi t, "
                + "isi4faktor i "
                + "where "
                + "r.id_isi4faktor = i.id_isi4faktor and "
                + "r.id_tupoksi = t.id_tupoksi and "
                + "r.nip_pns =? and "
                + "r.id_tupoksi =?";

        PreparedStatement pst = this.conn.prepareStatement(sql);
        RealisasiIsi4faktorTupoksi realkesi = null;
        pst.setString(1, sidnippns);
        pst.setString(2, sidtupoksi);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            realkesi = new RealisasiIsi4faktorTupoksi();

            realkesi.setId_realisasi(rs.getString(1));
            realkesi.setId_isi4faktor(rs.getString(2));
            realkesi.setNip_pns(rs.getString(3));
            realkesi.setId_tupoksi(rs.getString(4));
            realkesi.setKuantitasr(rs.getString(5));
            realkesi.setKualitasr(rs.getString(6));
            realkesi.setWaktur(rs.getString(7));
            realkesi.setBiayar(rs.getString(8));
//                String sR = realkesi.getBiayaR();
//                if (sR.equals("-"))
//                {
//                    sR ="000000";
//                }
//                long nR = Long.parseLong(sR);
//                DecimalFormat formatterR = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
//                formatterR.setMaximumFractionDigits(2);
//                String nilaibiR = formatterR.format(nR);
//                String hasil3R = nilaibiR.toString();
//            realkesi.setBiayaR(hasil3R);
            realkesi.setPenghitungan(rs.getString(9));
            realkesi.setNilai_capaian_skp(rs.getString(10));
            realkesi.setWaktu(rs.getString(11));
            realkesi.setKuantitas4(rs.getString(12));
            realkesi.setKualitas4(rs.getString(13));
            realkesi.setWaktu4(rs.getString(14));
            realkesi.setBiaya4(rs.getString(15));
            String s4 = realkesi.getBiaya4();
            if (s4.equals("-")) {
                s4 = "000000";
            }
            long n4 = Long.parseLong(s4);
            DecimalFormat formatter4 = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            formatter4.setMaximumFractionDigits(2);
            String nilaibi4 = formatter4.format(n4);
            String hasil34 = nilaibi4.toString();
            realkesi.setBiaya4(hasil34);
            realkesi.setKuantitas_label(rs.getString(16));
            realkesi.setWaktu_label(rs.getString(17));
            realkesi.setangkaKrdtr(rs.getString(18));
            realkesi.setangkaKrdt4(rs.getString(19));
            realkesi.setNama_tupoksi(rs.getString(20));
            realkesi.set_pilih_session(rs.getString(21));


        }

        return realkesi;
    }
}
