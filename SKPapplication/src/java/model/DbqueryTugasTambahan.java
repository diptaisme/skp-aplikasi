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
 * @author Sony
 */
public class DbqueryTugasTambahan {

    Connection conn;

    public DbqueryTugasTambahan(Connection conn) {
        this.conn = conn;
    }

    public TugasTambahan getDBqueryTugasTambahan(String idTambahan) throws SQLException {
        String sql = "SELECT idTambahan,JenisTambahan,nama,TmtPeriode,nilai1,nilai2,idNip,hitungtambahan,nilaitambahan FROM tugastambahan WHERE idTambahan =? ";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        TugasTambahan tugasTambahan = null;
        pst.setString(1, idTambahan);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            tugasTambahan = new TugasTambahan();
            tugasTambahan.setIdTambahan(rs.getString(1));
            tugasTambahan.setJenisTambahan(rs.getString(2));
            tugasTambahan.setNama(rs.getString(3));
            tugasTambahan.setTmtPeriode(rs.getString(4));
            tugasTambahan.setNilai1(rs.getString(5));
            tugasTambahan.setNilai2(rs.getString(6));
            tugasTambahan.setIdNip(rs.getString(7));
            tugasTambahan.setHitungTambahan(rs.getString(8));
            tugasTambahan.setNilaiTambahan(rs.getString(9));
        }
        return tugasTambahan;
    }

    public List<TugasTambahan> getDBqueryTugasTambahanlist(String idPns) throws SQLException {
        List<TugasTambahan> tugasTambahans = new ArrayList<TugasTambahan>();

        String sql = "SELECT idTambahan,JenisTambahan,nama,TmtPeriode,nilai1,nilai2,idNip,hitungtambahan,nilaitambahan FROM tugastambahan WHERE idNip =? AND JenisTambahan = 'Tugas Tambahan'";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        TugasTambahan tugasTambahan = null;
        pst.setString(1, idPns);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            tugasTambahan = new TugasTambahan();
            tugasTambahan.setIdTambahan(rs.getString(1));
            tugasTambahan.setJenisTambahan(rs.getString(2));
            tugasTambahan.setNama(rs.getString(3));
            tugasTambahan.setTmtPeriode(rs.getString(4));
            tugasTambahan.setNilai1(rs.getString(5));
            tugasTambahan.setNilai2(rs.getString(6));
            tugasTambahan.setIdNip(rs.getString(7));
            tugasTambahan.setHitungTambahan(rs.getString(8));
            tugasTambahan.setNilaiTambahan(rs.getString(9));

            tugasTambahans.add(tugasTambahan);
        }
        return tugasTambahans;
    }

    public List<TugasTambahan> getDBqueryTugasTambahanAlllist(String idPns) throws SQLException {
        List<TugasTambahan> tugasTambahans = new ArrayList<TugasTambahan>();

        String sql = "SELECT idTambahan,JenisTambahan,nama,TmtPeriode,nilai1,nilai2,idNip,hitungtambahan,nilaitambahan FROM tugastambahan WHERE idNip =?";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        TugasTambahan tugasTambahan = null;
        pst.setString(1, idPns);
        ResultSet rs = pst.executeQuery();
//        int nomorurut=0;
//        String status = "TIDAK";
        while (rs.next()) {
            tugasTambahan = new TugasTambahan();
            //nomorurut = nomorurut+1;
            tugasTambahan.setIdTambahan(rs.getString(1));
            tugasTambahan.setJenisTambahan(rs.getString(2));
            tugasTambahan.setNama(rs.getString(3));
            tugasTambahan.setTmtPeriode(rs.getString(4));
            tugasTambahan.setNilai1(rs.getString(5));
            tugasTambahan.setNilai2(rs.getString(6));
            tugasTambahan.setIdNip(rs.getString(7));
            tugasTambahan.setHitungTambahan(rs.getString(8));
//                String x1 = tugasTambahan.getIdNip();
//                String y1 = getDBqueryRealisasiCount(x1);
//                tugasTambahan.setHitungTambahan(y1);
            tugasTambahan.setNilaiTambahan(rs.getString(9));
//                String x = tugasTambahan.getIdNip();
//                String y = getDBqueryRealisasi(x);
//                tugasTambahan.setNilaiTambahan(y);
            tugasTambahans.add(tugasTambahan);
//            if (nomorurut >= 7 && "TIDAK".equals(status)) 
//            {
//                tugasTambahans.add(tugasTambahan);
//                status = "OK";
//            }
//            else if ((nomorurut >= 4 && nomorurut <= 6) && "OK".equals(status))
//            {
//                tugasTambahans.add(tugasTambahan);
//                status = "TIDAK";
//            }
//            else if ((nomorurut >= 1 && nomorurut <= 3) && "TIDAK".equals(status))
//            {
//                tugasTambahans.add(tugasTambahan);
//                status = "OK";
//            }
//            else
//            {
//                
//            }
        }
        return tugasTambahans;
    }

    public TugasTambahan getDBqueryTugasTambahanAllnotList(String idTambahan) throws SQLException {
        String sql = "SELECT idTambahan,JenisTambahan,nama,TmtPeriode,nilai1,nilai2,idNip,hitungtambahan,nilaitambahan FROM tugastambahan WHERE idNip =? ";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        TugasTambahan tugasTambahan = null;
        pst.setString(1, idTambahan);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            tugasTambahan = new TugasTambahan();
            tugasTambahan.setIdTambahan(rs.getString(1));
            tugasTambahan.setJenisTambahan(rs.getString(2));
            tugasTambahan.setNama(rs.getString(3));
            tugasTambahan.setTmtPeriode(rs.getString(4));
            tugasTambahan.setNilai1(rs.getString(5));
            tugasTambahan.setNilai2(rs.getString(6));
            tugasTambahan.setIdNip(rs.getString(7));

            tugasTambahan.setHitungTambahan(rs.getString(8));
            String x1 = tugasTambahan.getIdNip();
            String y1 = getDBqueryRealisasiCount(x1);
            tugasTambahan.setHitungTambahan(y1);

            tugasTambahan.setNilaiTambahan(rs.getString(9));
            String x = tugasTambahan.getIdNip();
            String y = getDBqueryRealisasi(x);
            tugasTambahan.setNilaiTambahan(y);
        }
        return tugasTambahan;
    }

    public List<TugasTambahan> getDBqueryTugasTambahanList(String idTambahan) throws SQLException {
        List<TugasTambahan> tugasTambahans = new ArrayList<TugasTambahan>();

        //String sql = "SELECT DISTINCT idTambahan,JenisTambahan,nama,TmtPeriode,nilai1,nilai2,idNip,hitungtambahan,nilaitambahan FROM tugastambahan WHERE idNip =? ";
        String sql = "SELECT idTambahan,JenisTambahan,nama,TmtPeriode,nilai1,nilai2,idNip,hitungtambahan,nilaitambahan FROM tugastambahan WHERE idNip =? and JenisTambahan = 'Tugas Tambahan' ";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        TugasTambahan tugasTambahan = null;
        pst.setString(1, idTambahan);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            tugasTambahan = new TugasTambahan();
            tugasTambahan.setIdTambahan(rs.getString(1));
            tugasTambahan.setJenisTambahan(rs.getString(2));
            tugasTambahan.setNama(rs.getString(3));
            tugasTambahan.setTmtPeriode(rs.getString(4));
            tugasTambahan.setNilai1(rs.getString(5));
            tugasTambahan.setNilai2(rs.getString(6));
            tugasTambahan.setIdNip(rs.getString(7));

            tugasTambahan.setHitungTambahan(rs.getString(8));
//                String x1 = tugasTambahan.getIdNip();
//                String y1 = getDBqueryRealisasiCount(x1);
//                tugasTambahan.setHitungTambahan(y1);

            tugasTambahan.setNilaiTambahan(rs.getString(9));
//                String x = tugasTambahan.getIdNip();
//                String y = getDBqueryRealisasi(x);
//                tugasTambahan.setNilaiTambahan(y);
        }
        return tugasTambahans;
    }

    public nilaiprestasikerja getDBqueryNPKAllnotList(String idTambahan) throws SQLException {
        String sql = "SELECT nip_pns, skp, realisasi, tugastambahan, kreatifitas, perilaku, prestasi, periode FROM nilaiprestasikerja WHERE nip_pns =? ";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        nilaiprestasikerja tugasTambahan = null;
        pst.setString(1, idTambahan);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            tugasTambahan = new nilaiprestasikerja();
            tugasTambahan.setNipPns(rs.getString(1));
            tugasTambahan.setSkp(rs.getString(2));
            tugasTambahan.setRealisasi(rs.getString(3));
            tugasTambahan.setTugastambahan(rs.getString(4));
            tugasTambahan.setKreatifitas(rs.getString(5));
            tugasTambahan.setPerilaku(rs.getString(6));
            tugasTambahan.setPrestasi(rs.getString(7));
            tugasTambahan.setPeriode(rs.getString(8));
        }
        return tugasTambahan;
    }

    public nilaiprestasikerja getDBqueryNPKAllnotList_session(String idTambahan, String thn_sesion, String idUnorNilai) throws SQLException {
        // String sql = "SELECT nip_pns, skp, realisasi, tugastambahan, kreatifitas, perilaku, prestasi, periode FROM nilaiprestasikerja WHERE nip_pns =? ";
        // PreparedStatement pst = this.conn.prepareStatement(sql);
        nilaiprestasikerja tugasTambahan = null;
        //  pst.setString(1, idTambahan);
        //  ResultSet rs = pst.executeQuery();

        String sql = "SELECT nip_pns, skp, realisasi, tugastambahan, kreatifitas, perilaku, prestasi, periode FROM nilaiprestasikerja WHERE nip_pns = '" + idTambahan + "' and periode = '" + thn_sesion + "' and id_unor = '" + idUnorNilai + "' ";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();


        if (rs.next()) {
            tugasTambahan = new nilaiprestasikerja();
            tugasTambahan.setNipPns(rs.getString(1));
            tugasTambahan.setSkp(rs.getString(2));
            tugasTambahan.setRealisasi(rs.getString(3));
            tugasTambahan.setTugastambahan(rs.getString(4));
            tugasTambahan.setKreatifitas(rs.getString(5));
            tugasTambahan.setPerilaku(rs.getString(6));
            tugasTambahan.setPrestasi(rs.getString(7));
            tugasTambahan.setPeriode(rs.getString(8));
        }
        return tugasTambahan;
    }

    public String getDBqueryRealisasiCount(String sid_pns) throws SQLException {
        String sql2 = "SELECT count(*) as jumRealisasi FROM tugastambahan WHERE idnip = '" + sid_pns + "' and jenistambahan = 'Tugas Tambahan'";
        PreparedStatement pst2 = this.conn.prepareStatement(sql2);
        String ipns = null;
        ResultSet rs2 = pst2.executeQuery();
        if (rs2.next()) {
            ipns = rs2.getString("jumRealisasi");
        }
        return ipns;
    }

    public String getDBqueryRealisasi(String sid_pns) throws SQLException {
        String sql2 = "SELECT realisasi FROM nilaiprestasikerja WHERE nip_pns = '" + sid_pns + "' ";
        PreparedStatement pst2 = this.conn.prepareStatement(sql2);
        String ipns = null;
        ResultSet rs2 = pst2.executeQuery();
        if (rs2.next()) {
            ipns = rs2.getString("realisasi");
        }
        return ipns;
    }

    public List<TugasTambahan> getDBqueryKreatifitaslist(String idPns) throws SQLException {
        List<TugasTambahan> tugasTambahans = new ArrayList<TugasTambahan>();

        String sql = "SELECT idTambahan,JenisTambahan,nama,TmtPeriode,nilai1,nilai2,idNip,hitungtambahan,nilaitambahan, koef_kreatifitas FROM tugastambahan WHERE idNip =? AND JenisTambahan = 'Keterampilan'";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        TugasTambahan tugasTambahan = null;
        pst.setString(1, idPns);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            tugasTambahan = new TugasTambahan();
            tugasTambahan.setIdTambahan(rs.getString(1));
            tugasTambahan.setJenisTambahan(rs.getString(2));
            tugasTambahan.setNama(rs.getString(3));
            tugasTambahan.setTmtPeriode(rs.getString(4));
            tugasTambahan.setNilai1(rs.getString(5));
            tugasTambahan.setNilai2(rs.getString(6));
            tugasTambahan.setIdNip(rs.getString(7));
            tugasTambahan.setHitungTambahan(rs.getString(8));
            tugasTambahan.setNilaiTambahan(rs.getString(9));
            tugasTambahan.setKoef_kreatifitas(rs.getString(10));

            tugasTambahans.add(tugasTambahan);
        }
        return tugasTambahans;
    }

    public List<TugasTambahan> getDBqueryTugasTambahanMaxlist(String idPns) throws SQLException {
        List<TugasTambahan> tugasTambahans = new ArrayList<TugasTambahan>();
        int nomk = 0;
        String sql = "SELECT idTambahan,JenisTambahan,nama,TmtPeriode,nilai1,nilai2,idNip,hitungtambahan,nilaitambahan,koef_kreatifitas FROM tugastambahan WHERE jenistambahan = 'Keterampilan' and idNip =? order by koef_kreatifitas desc";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        TugasTambahan tugasTambahan = null;
        pst.setString(1, idPns);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            nomk = nomk + 1;
            tugasTambahan = new TugasTambahan();
            tugasTambahan.setIdTambahan(rs.getString(1));
            tugasTambahan.setJenisTambahan(rs.getString(2));
            tugasTambahan.setNama(rs.getString(3));
            tugasTambahan.setTmtPeriode(rs.getString(4));
            tugasTambahan.setNilai1(rs.getString(5));
            tugasTambahan.setNilai2(rs.getString(6));
            tugasTambahan.setIdNip(rs.getString(7));
            tugasTambahan.setHitungTambahan(rs.getString(8));
            tugasTambahan.setNilaiTambahan(rs.getString(9));
            tugasTambahan.setKoef_kreatifitas(rs.getString(10));
            if (nomk == 1) {
                tugasTambahans.add(tugasTambahan);
            }

        }
        return tugasTambahans;
    }

    public List<TugasTambahan> getDBqueryTugasTambahanOnelist(String idPns) throws SQLException {
        List<TugasTambahan> tugasTambahans = new ArrayList<TugasTambahan>();
        int nomk = 0;
        String sql = "SELECT idTambahan,JenisTambahan,nama,TmtPeriode,nilai1,nilai2,idNip,hitungtambahan,nilaitambahan,koef_kreatifitas FROM tugastambahan WHERE jenistambahan = 'Tugas Tambahan' and idNip =?";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        TugasTambahan tugasTambahan = null;
        pst.setString(1, idPns);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            nomk = nomk + 1;
            tugasTambahan = new TugasTambahan();
            tugasTambahan.setIdTambahan(rs.getString(1));
            tugasTambahan.setJenisTambahan(rs.getString(2));
            tugasTambahan.setNama(rs.getString(3));
            tugasTambahan.setTmtPeriode(rs.getString(4));
            tugasTambahan.setNilai1(rs.getString(5));
            tugasTambahan.setNilai2(rs.getString(6));
            tugasTambahan.setIdNip(rs.getString(7));

            tugasTambahan.setHitungTambahan(rs.getString(8));
            String x1 = tugasTambahan.getIdNip();
            String y1 = getDBqueryRealisasiCount(x1);
            tugasTambahan.setHitungTambahan(y1);

            tugasTambahan.setNilaiTambahan(rs.getString(9));
            String x = tugasTambahan.getIdNip();
            String y = getDBqueryNilaiTugasTambahan(x);
            tugasTambahan.setNilaiTambahan(y1);


            if (Integer.parseInt(y1) > 0 && Integer.parseInt(y1) < 4) {
                y = "1";
                tugasTambahan.setNilaiTambahan(y);
            } else if (Integer.parseInt(y1) > 3 && Integer.parseInt(y1) < 7) {
                y = "2";
                tugasTambahan.setNilaiTambahan(y);
            } else if (Integer.parseInt(y1) > 6) {
                y = "3";
                tugasTambahan.setNilaiTambahan(y);
            }



            tugasTambahan.setKoef_kreatifitas(rs.getString(10));
            if (nomk == 1) {
                tugasTambahans.add(tugasTambahan);
            }


        }

        return tugasTambahans;
    }

    public String getDBqueryNilaiTugasTambahan(String sid_pns) throws SQLException {
        String sql2 = "SELECT tugastambahan FROM nilaiprestasikerja WHERE nip_pns = '" + sid_pns + "' ";
        PreparedStatement pst2 = this.conn.prepareStatement(sql2);
        String ipns = null;
        ResultSet rs2 = pst2.executeQuery();
        if (rs2.next()) {
            ipns = rs2.getString("tugastambahan");
        }
        return ipns;
    }

    public TugasTambahan getDBquerySatoeKreatifitas(String idPns, String idTambahan) throws SQLException {
        //List<TugasTambahan> tugasTambahans = new ArrayList<TugasTambahan>();

        String sql = "SELECT idTambahan,JenisTambahan,nama,TmtPeriode,nilai1,nilai2,idNip,hitungtambahan,nilaitambahan FROM tugastambahan WHERE idNip = '" + idPns + "' AND idTambahan = '" + idTambahan + "' AND JenisTambahan = 'Keterampilan'";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        TugasTambahan tugasTambahan = null;
        //pst.setString(1, idPns);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            tugasTambahan = new TugasTambahan();
            tugasTambahan.setIdTambahan(rs.getString(1));
            tugasTambahan.setJenisTambahan(rs.getString(2));
            tugasTambahan.setNama(rs.getString(3));
            tugasTambahan.setTmtPeriode(rs.getString(4));
            tugasTambahan.setNilai1(rs.getString(5));
            tugasTambahan.setNilai2(rs.getString(6));
            tugasTambahan.setIdNip(rs.getString(7));
            tugasTambahan.setHitungTambahan(rs.getString(8));
            tugasTambahan.setNilaiTambahan(rs.getString(9));
        }
        return tugasTambahan;
    }

    public String makIsTugasTambahanl() throws SQLException {
        String max = null;
        int imax;

        String sql = "SELECT MAX(idTambahan) as maks FROM tugastambahan";
        PreparedStatement st = this.conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            max = rs.getString("maks");
            if (max == null) {
                max = "600000000";
            }

            imax = Integer.parseInt(max);
            imax++;

            max = Integer.toString(imax);
        } else {
            max = "600000001";
        }

        return max;
    }

    public void UpdateTugasTambahan(String maks, String idTambahan, String jenisTambahan, String nama, String TmtPeriode, String nilai1, String nilai2, String idNip, String hitungtambahan, String nilaitambahan) throws SQLException {
        String _maks = maks;
        String _idTambahan = idTambahan;
        String _jenisTambahan = jenisTambahan;
        String _nama = nama;
        String _TmtPeriode = TmtPeriode;
        String _nilai1 = nilai1;
        String _nilai2 = nilai2;
        String _idNip = idNip;
        String _hitungtambahan = hitungtambahan;
        String _nilaitambahan = nilaitambahan;

        String sql = "UPDATE TugasTambahan SET JenisTambahan ='" + _jenisTambahan + "', nama='" + _nama + "', TmtPeriode='" + _TmtPeriode + "', nilai1='" + _nilai1 + "', nilai2='" + _nilai2 + "', hitungtambahan = '" + _hitungtambahan + "', nilaitambahan = '" + _nilaitambahan + "' where idTambahan='" + _idTambahan + "' and idNip ='" + _idNip + "' ";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.executeUpdate(sql);
        st.close();
    }

    public void InsertTugasTambahanl(String maks, String idTambahan, String jenisTambahan, String nama, String TmtPeriode, String nilai1, String nilai2, String idNip, String hitungtambahan, String nilaitambahan, String koef_kreatifitas) throws SQLException {
        String _maks = maks;
        idTambahan = _maks;
        String _idTambahan = idTambahan;
        String _jenisTambahan = jenisTambahan;
        String _nama = nama;
        String _TmtPeriode = TmtPeriode;
        String _nilai1 = nilai1;
        String _nilai2 = nilai2;
        String _idNip = idNip;
        String _hitungtambahan = hitungtambahan;
        String _nilaitambahan = nilaitambahan;
        String _koef_kreatifitas = koef_kreatifitas;

        String sql = "INSERT INTO tugastambahan(idTambahan,JenisTambahan, nama, TmtPeriode,nilai1,nilai2, idNip, hitungtambahan, nilaitambahan, koef_kreatifitas) VALUES('" + _idTambahan + "', '" + _jenisTambahan + "','" + _nama + "', '" + _TmtPeriode + "', '" + _nilai1 + "', '" + _nilai2 + "', '" + _idNip + "', '" + _hitungtambahan + "', '" + _nilaitambahan + "', '" + _koef_kreatifitas + "')";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.executeUpdate(sql);
        st.close();

    }

    public void DeleteTugasTambahan(String idTambahan) throws SQLException {
        String sql = "DELETE FROM tugastambahan where idTambahan='" + idTambahan + "'";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.executeUpdate(sql);
        st.close();
    }

    public TugasTambahan getDBqueryHitungTugasTambahan(String idTambahan, String nipPns) throws SQLException {
        String sql = "SELECT idTambahan,jenisTambahan,nilai1,nilai2,idNip,koef_kreatifitas FROM tugastambahan WHERE idTambahan = '" + idTambahan + "' and idNip = '" + nipPns + "' ";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        TugasTambahan tugasTambahan = null;
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            tugasTambahan = new TugasTambahan();
            tugasTambahan.setIdTambahan(rs.getString(1));
            tugasTambahan.setJenisTambahan(rs.getString(2));
            tugasTambahan.setNilai1(rs.getString(3));
            tugasTambahan.setNilai2(rs.getString(4));
            tugasTambahan.setIdNip(rs.getString(5));
            tugasTambahan.setKoef_kreatifitas(rs.getString(6));
        }
        return tugasTambahan;
    }

    public void UpdateTugasTambahanHitungan(String idTambahan, String idNip, String nilai, String hitung) throws SQLException {

        String _idTambahan = idTambahan;
        String _idNip = idNip;
        String _hitung = hitung;
        String _nilai = nilai;

        String sql = "UPDATE TugasTambahan SET nilaitambahan = '" + _nilai + "', hitungtambahan = '" + _hitung + "' where idTambahan='" + _idTambahan + "' and idNip ='" + _idNip + "' ";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.executeUpdate(sql);
        st.close();
    }

    public List<RealisasiIsi4faktorTupoksiHitung> getDBqueryRealisasiIsi4faktorTupoksiTambahan(String snippns) throws SQLException {
        List<RealisasiIsi4faktorTupoksiHitung> RealisasiIsi4faktorTupoksies = new ArrayList<RealisasiIsi4faktorTupoksiHitung>();

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
                + "t.nama_tupoksi, "
                + "tb.nama, "
                + "tb.nilai1, "
                + "tb.nilai2, "
                + "tb.hitungtambahan, "
                + "tb.nilaitambahan "
                + "from "
                + "realisasi r, "
                + "tupoksi t, "
                + "isi4faktor i, "
                + "tugastambahan tb "
                + "where "
                + "r.id_isi4faktor = i.id_isi4faktor and "
                + "r.id_tupoksi = t.id_tupoksi and "
                + "r.nip_pns = tb.idNip and "
                + "r.nip_pns =?";
        //+ "r.nip_pns =? and "
        //+ "r.id_tupoksi =?";
        //+ "i.id_isi4faktor = ''";

        PreparedStatement pst = this.conn.prepareStatement(sql);
        DbqueryTugasTambahan nDBqueryRealisasiIsi4faktorTupoksi = null;
        //pst.setString(1, sid_isi4faktor);
        pst.setString(1, snippns);
        //pst.setString(2, sidtupoksi);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            RealisasiIsi4faktorTupoksiHitung real4faktupok = new RealisasiIsi4faktorTupoksiHitung();
            real4faktupok.setIdRealisasi(rs.getString(1));
            real4faktupok.setIdIsi4Faktor(rs.getString(2));
            real4faktupok.setNipPns(rs.getString(3));
            real4faktupok.setIdTupoksi(rs.getString(4));
            real4faktupok.setKuantitasR(rs.getString(5));
            real4faktupok.setKualitasR(rs.getString(6));
            real4faktupok.setWaktuR(rs.getString(7));
            real4faktupok.setBiayaR(rs.getString(8));
            String sR = real4faktupok.getBiayaR();
            if (sR.equals("-")) {
                sR = "000000";
            }
            long nR = Long.parseLong(sR);
            DecimalFormat formatterR = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            formatterR.setMaximumFractionDigits(2);
            String nilaibiR = formatterR.format(nR);
            String hasil3R = nilaibiR.toString();
            real4faktupok.setBiayaR(hasil3R);
            real4faktupok.setPenghitungan(rs.getString(9));
            real4faktupok.setNilaiCapaianSKP(rs.getString(10));
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
            real4faktupok.setkuantitas_label(rs.getString(16));
            real4faktupok.setwaktu_label(rs.getString(17));
            real4faktupok.setNamaTupoksi(rs.getString(18));
            real4faktupok.setnama(rs.getString(19));
            real4faktupok.setnilai1(rs.getString(20));
            real4faktupok.setnilai2(rs.getString(21));
            real4faktupok.sethitungtambahan(rs.getString(22));
            real4faktupok.setnilaitambahan(rs.getString(23));

            RealisasiIsi4faktorTupoksies.add(real4faktupok);
        }
        return RealisasiIsi4faktorTupoksies;
    }

    //VERSI A
//    public String nilaicapaianall(String nippns) throws SQLException
//    {
//        int i_sum_skp;
//        int i_sum_tamb;
//        int i_sum_kreaf;
//        int i_count_skp;
//        int i_count_tamb;
//        int i_count_kreaf;
//        
//        String s_sum_skp;
//        String s_sum_tamb;
//        String s_sum_kreaf;
//        String s_count_skp;
//        String s_count_tamb;
//        String s_count_kreaf;
//        
//        
//        //*******************JUMLAH TOTAL SKP***************************************//
//        String sql = "SELECT SUM(nilai_capaian_skp) as s_sum_skp FROM realisasi WHERE nip_pns = '"+nippns+"'";
//        PreparedStatement pst = this.conn.prepareStatement(sql);
//        ResultSet rs = pst.executeQuery();
//        if (rs.next())
//        {
//            s_sum_skp = rs.getString("s_sum_skp");
//            i_sum_skp = Integer.parseInt(s_sum_skp);
//        }
//        else
//        {
//            i_sum_skp = 0;
//        }
//        
//        //*******************JUMLAH NILAI SKP***************************************//
//        String sqlc = "SELECT COUNT(nilai_capaian_skp) as s_count_skp FROM realisasi WHERE nip_pns = '"+nippns+"'";
//        PreparedStatement pstc = this.conn.prepareStatement(sqlc);
//        ResultSet rsc = pstc.executeQuery();
//        if (rsc.next())
//        {
//            s_count_skp = rsc.getString("s_count_skp");
//            i_count_skp = Integer.parseInt(s_count_skp);
//        }
//        else
//        {
//            i_count_skp = 0;
//        }
//        
//        int i_skp = i_sum_skp / i_count_skp;
//        
//        
////**************CARA PENGHITUNGAN TUGAS TAMBAHAN VERSI PERKA LAMA********************************************************//       
////        //*******************JUMLAH TOTAL TUGAS TAMBAHAN***************************************//
////        String sqla = "SELECT SUM(nilaitambahan) as s_sum_tamb FROM tugastambahan WHERE idNip = '"+nippns+"' AND jenisTambahan = 'Tugas Tambahan'";
////        PreparedStatement psta = this.conn.prepareStatement(sqla);
////        ResultSet rsa = psta.executeQuery();
////        if (rsa.next())
////        {
////            s_sum_tamb = rsa.getString("s_sum_tamb");
////            i_sum_tamb = Integer.parseInt(s_sum_tamb);
////        }
////        else
////        {
////            i_sum_tamb = 0;
////        }
////        
////        //*******************JUMLAH NILAI TUGAS TAMBAHAN***************************************//
////        String sqlt = "SELECT COUNT(nilaitambahan) as s_count_tamb FROM tugastambahan WHERE idNip = '"+nippns+"' AND jenisTambahan = 'Tugas Tambahan'";
////        PreparedStatement pstt = this.conn.prepareStatement(sqlt);
////        ResultSet rst = pstt.executeQuery();
////        if (rst.next())
////        {
////            s_count_tamb = rst.getString("s_count_tamb");
////            i_count_tamb = Integer.parseInt(s_count_tamb);
////        }
////        else
////        {
////            i_count_tamb = 0;
////        }
////        
////        int i_tamb = i_sum_tamb / i_count_tamb;
//
//        
////*******************************CARA PENGHITUNGAN TUGAS TAMBAHAN VERSI PERKA BARU **********************************************//
//        //*******************JUMLAH NILAI TUGAS TAMBAHAN***************************************//
//        String sqlt = "SELECT COUNT(nilaitambahan) as s_count_tamb FROM tugastambahan WHERE idNip = '"+nippns+"' AND jenisTambahan = 'Tugas Tambahan'";
//        PreparedStatement pstt = this.conn.prepareStatement(sqlt);
//        ResultSet rst = pstt.executeQuery();
//        if (rst.next())
//        {
//            s_count_tamb = rst.getString("s_count_tamb");
//            i_count_tamb = Integer.parseInt(s_count_tamb);
//        }
//        else
//        {
//            i_count_tamb = 0;
//        }
//        
//        int i_tamb = 0;
//        if (i_count_tamb >= 1 && i_count_tamb <= 3)
//        {
//            i_tamb = 1;
//        }
//        else if (i_count_tamb >= 4 && i_count_tamb <= 6)
//        {
//            i_tamb = 2;
//        }
//        else if (i_count_tamb >= 7)
//        {
//            i_tamb = 3;
//        }
//        else
//        {}
//        
//        
////**************CARA PENGHITUNGAN KREATIFITAS VERSI PERKA LAMA********************************************************//        
////        //*******************JUMLAH TOTAL KREATIFITAS***************************************//
////        String sqlb = "SELECT SUM(nilaitambahan) as s_sum_kreaf FROM tugastambahan WHERE idNip = '"+nippns+"' AND jenisTambahan = 'Keterampilan'";
////        PreparedStatement pstb = this.conn.prepareStatement(sqlb);
////        ResultSet rsb = pstb.executeQuery();
////        if (rsb.next())
////        {
////            s_sum_kreaf = rsb.getString("s_sum_kreaf");
////            i_sum_kreaf = Integer.parseInt(s_sum_kreaf);
////        }
////        else
////        {
////            i_sum_kreaf = 0;
////        }
////        
////        //*******************JUMLAH NILAI KREATIFITAS***************************************//
////        String sqlk = "SELECT COUNT(nilaitambahan) as s_count_kreaf FROM tugastambahan WHERE idNip = '"+nippns+"' AND jenisTambahan = 'Keterampilan'";
////        PreparedStatement pstk = this.conn.prepareStatement(sqlk);
////        ResultSet rsk = pstk.executeQuery();
////        if (rsk.next())
////        {
////            s_count_kreaf = rsk.getString("s_count_kreaf");
////            i_count_kreaf = Integer.parseInt(s_count_kreaf);
////        }
////        else
////        {
////            i_count_kreaf = 0;
////        }
////        
////        int i_kreaf = i_sum_kreaf / i_count_kreaf;
//        
// 
//        
////****CARA PENGHITUNGAN KREATIFITAS VERSI PERKA BARU ADA DI :GoIndex().HitungTugasTambahanKoef(String idTambahan, String nip)****//        
//        //*******************JUMLAH TOTAL KREATIFITAS***************************************//
//        String sqlb = "SELECT SUM(nilaitambahan) as s_sum_kreaf FROM tugastambahan WHERE idNip = '"+nippns+"' AND jenisTambahan = 'Keterampilan'";
//        PreparedStatement pstb = this.conn.prepareStatement(sqlb);
//        ResultSet rsb = pstb.executeQuery();
//        if (rsb.next())
//        {
//            s_sum_kreaf = rsb.getString("s_sum_kreaf");
//            i_sum_kreaf = Integer.parseInt(s_sum_kreaf);
//        }
//        else
//        {
//            i_sum_kreaf = 0;
//        }
//        
//        //*******************JUMLAH NILAI KREATIFITAS***************************************//
//        String sqlk = "SELECT COUNT(nilaitambahan) as s_count_kreaf FROM tugastambahan WHERE idNip = '"+nippns+"' AND jenisTambahan = 'Keterampilan'";
//        PreparedStatement pstk = this.conn.prepareStatement(sqlk);
//        ResultSet rsk = pstk.executeQuery();
//        if (rsk.next())
//        {
//            s_count_kreaf = rsk.getString("s_count_kreaf");
//            i_count_kreaf = Integer.parseInt(s_count_kreaf);
//        }
//        else
//        {
//            i_count_kreaf = 0;
//        }
//        
//        int i_kreaf = i_sum_kreaf / i_count_kreaf;
//        
//        
//        
//        //********************JADI***********************************//
//        String s_total;
//        int i_total;
//        
//        i_total =  i_skp + i_tamb + i_kreaf;
//        s_total = Integer.toString(i_total);
//        
//        return s_total;
//    }
    //VERSI B (03-09-2012)
    public String nilaicapaianallSession(String id_unor, String nippns, String _pilih_session) throws SQLException {
        double i_sum_skp;
        int i_sum_tamb;
        int i_sum_kreaf;
        double i_count_skp;
        int i_count_tamb;
        int i_count_kreaf;

        String s_sum_skp;
        String s_sum_tamb;
        String s_sum_kreaf;
        String s_count_skp;
        String s_count_tamb;
        String s_count_kreaf;
        String s_pilih_session;

        double i_skp;


//        //******************VALIDASI "-"***********************************//
//        String x = "-";
//        String x1 = "0";
//        String sqlx = "SELECT * FROM realisasi WHERE nip_pns = '"+nippns+"' and nilai_capaian_skp = '"+x+"'";
//        PreparedStatement pstx = this.conn.prepareStatement(sqlx);
//        ResultSet rsx = pstx.executeQuery();
//        while (rsx.next())
//        {
//            String idRealisasi = rsx.getString("id_realisasi");
//            String idIsi4Faktor = rsx.getString("id_isi4faktor");
//            String sqlx1 = "UPDATE realisasi SET nilai_capaian_skp = '"+x1+"' where nippns='"+nippns+"' and id_realisasi = '"+idRealisasi+"' and id_isi4faktor = '"+idIsi4Faktor+"'";
//            PreparedStatement stx1 = this.conn.prepareStatement(sqlx1);
//            stx1.executeUpdate(sqlx1);
//            stx1.close();
//        }

        //*******************JUMLAH TOTAL SKP***************************************//
        String sql = "SELECT SUM(nilai_capaian_skp) as s_sum_skp FROM realisasi WHERE id_unor='" + id_unor + "' and nip_pns = '" + nippns + "' and session ='" + _pilih_session + "'";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            s_sum_skp = rs.getString("s_sum_skp");
            //  i_sum_skp = Integer.parseInt(s_sum_skp);
            i_sum_skp = Double.parseDouble(s_sum_skp);
        } else {
            i_sum_skp = 0;
        }

        //*******************JUMLAH NILAI SKP***************************************//
        String sqlc = "SELECT COUNT(nilai_capaian_skp) as s_count_skp FROM realisasi WHERE id_unor='" + id_unor + "' and nip_pns = '" + nippns + "' and session ='" + _pilih_session + "'";
        PreparedStatement pstc = this.conn.prepareStatement(sqlc);
        ResultSet rsc = pstc.executeQuery();
        if (rsc.next()) {
            s_count_skp = rsc.getString("s_count_skp");
            i_count_skp = Double.parseDouble(s_count_skp);
        } else {
            i_count_skp = 0;
        }

        i_skp = i_sum_skp / i_count_skp;



        //*********************JADI...
        String _realisasi;
        double i_total;
        int i_count_tugastambahan = 0;
        int i_count_kreatifitas = 0;
        i_total = i_skp;
        _realisasi = Double.toString(i_total);

        String _skp = "0";
        String _tugastambahan = "0";
        String _kreatifitas = "0";
        String _perilaku = "0";
        String _prestasi = "0";
        String _periode = "0";
        String s_count_tugastambahan = "0";


        //*******************INSERT DULU****************************************//
        String sqla = "SELECT * FROM nilaiprestasikerja WHERE nip_pns = '" + nippns + "' and periode ='" + _pilih_session + "'";
        PreparedStatement psta = this.conn.prepareStatement(sqla);
        ResultSet rsa = psta.executeQuery();
        if (rsa.next()) {
            s_count_tugastambahan = rsa.getString("tugastambahan");
            i_count_tugastambahan = Integer.parseInt(s_count_tugastambahan);

            s_count_tugastambahan = rsa.getString("kreatifitas");
            i_count_kreatifitas = Integer.parseInt(s_count_tugastambahan);

            i_total = i_total + i_count_tugastambahan + i_count_kreatifitas;




            DecimalFormat formatterR = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            formatterR.setMaximumFractionDigits(2);
            _realisasi = formatterR.format(i_total);

            validasiString vs = new validasiString();

            vs.setkoma(_realisasi);
            _realisasi = vs.getmashudi();

            // _realisasi = Double.toString(i_total);



            String sqld = "UPDATE nilaiprestasikerja SET realisasi = '" + _realisasi + "' where id_unor='" + id_unor + "' and  nip_pns='" + nippns + "' and periode ='" + _pilih_session + "' ";
            PreparedStatement std = this.conn.prepareStatement(sqld);
            std.executeUpdate(sqld);
            std.close();
        } else {
            String sqlb = "INSERT INTO nilaiprestasikerja(nip_pns,skp, realisasi, tugastambahan, kreatifitas, perilaku, prestasi, periode,id_unor) VALUES('" + nippns + "', '" + _skp + "','" + _realisasi + "', '" + _tugastambahan + "', '" + _kreatifitas + "', '" + _perilaku + "', '" + _prestasi + "', '" + _pilih_session + "', '" + id_unor + "')";
            PreparedStatement stb = this.conn.prepareStatement(sqlb);
            stb.executeUpdate(sqlb);
            stb.close();
        }

        return _realisasi;
    }

    public String nilaicapaianallSession_unor(String nippns, String unorid, String _pilih_session) throws SQLException {
        double i_sum_skp;
        int i_sum_tamb;
        int i_sum_kreaf;
        double i_count_skp;
        int i_count_tamb;
        int i_count_kreaf;

        String s_sum_skp;
        String s_sum_tamb;
        String s_sum_kreaf;
        String s_count_skp;
        String s_count_tamb;
        String s_count_kreaf;
        String s_pilih_session;

        double i_skp;
        int kurang_thn;


        String sql = "SELECT SUM(nilai_capaian_skp) as s_sum_skp FROM realisasi r  WHERE r.nip_pns = '" + nippns + "' and r.session ='" + _pilih_session + "'  and r.id_unor='" + unorid + "' ";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            s_sum_skp = rs.getString("s_sum_skp");
            if (s_sum_skp == null) {
                kurang_thn = Integer.parseInt(_pilih_session) - 1;
                s_sum_skp = Integer.toString(kurang_thn);
                
                _pilih_session = s_sum_skp;
                String sql2 = "SELECT SUM(nilai_capaian_skp) as s_sum_skp FROM realisasi r  WHERE r.nip_pns = '" + nippns + "' and r.session ='" + _pilih_session + "'  and r.id_unor='" + unorid + "' ";
                PreparedStatement pst2 = this.conn.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                if (rs2.next()) {
                     s_sum_skp = rs.getString("s_sum_skp");
                     if (s_sum_skp == null) {
                         s_sum_skp="20";
                     }
                }


            }


            i_sum_skp = Double.parseDouble(s_sum_skp);
        } else {
            i_sum_skp = 0;
        }

        String sqlc = "SELECT COUNT(nilai_capaian_skp) as s_count_skp FROM realisasi WHERE nip_pns = '" + nippns + "' and session ='" + _pilih_session + "' and id_unor='" + unorid + "'";
        PreparedStatement pstc = this.conn.prepareStatement(sqlc);
        ResultSet rsc = pstc.executeQuery();
        if (rsc.next()) {
            s_count_skp = rsc.getString("s_count_skp");
            i_count_skp = Double.parseDouble(s_count_skp);
        } else {
            i_count_skp = 0;
        }

        i_skp = i_sum_skp / i_count_skp;


        String _realisasi;
        double i_total;
        int i_count_tugastambahan = 0;
        int i_count_kreatifitas = 0;
        i_total = i_skp;
        _realisasi = Double.toString(i_total);

        String _skp = "0";
        String _tugastambahan = "0";
        String _kreatifitas = "0";
        String _perilaku = "0";
        String _prestasi = "0";
        String _periode = "0";
        String s_count_tugastambahan = "0";


        //*******************INSERT DULU****************************************//
        String sqla = "SELECT * FROM nilaiprestasikerja WHERE nip_pns = '" + nippns + "' and periode ='" + _pilih_session + "' ";
        PreparedStatement psta = this.conn.prepareStatement(sqla);
        ResultSet rsa = psta.executeQuery();
        if (rsa.next()) {
            s_count_tugastambahan = rsa.getString("tugastambahan");
            i_count_tugastambahan = Integer.parseInt(s_count_tugastambahan);

            s_count_tugastambahan = rsa.getString("kreatifitas");
            i_count_kreatifitas = Integer.parseInt(s_count_tugastambahan);

            i_total = i_total + i_count_tugastambahan + i_count_kreatifitas;




            DecimalFormat formatterR = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            formatterR.setMaximumFractionDigits(2);
            _realisasi = formatterR.format(i_total);

            validasiString vs = new validasiString();

            vs.setkoma(_realisasi);
            _realisasi = vs.getmashudi();

            // _realisasi = Double.toString(i_total);
            String sqla2 = "SELECT * FROM nilaiprestasikerja WHERE nip_pns = '" + nippns + "' and periode ='" + _pilih_session + "' and id_unor ='" + unorid + "'  ";
            PreparedStatement psta2 = this.conn.prepareStatement(sqla2);
            ResultSet rsa2 = psta2.executeQuery();
            if (rsa2.next()) {
                String sqld = "UPDATE nilaiprestasikerja SET realisasi = '" + _realisasi + "' where nip_pns='" + nippns + "' and periode ='" + _pilih_session + "' and id_unor ='" + unorid + "' ";
                PreparedStatement std = this.conn.prepareStatement(sqld);
                std.executeUpdate(sqld);
                std.close();
            } else {
                String sqlb = "INSERT INTO nilaiprestasikerja(nip_pns,skp, realisasi, tugastambahan, kreatifitas, perilaku, prestasi,id_unor) VALUES('" + nippns + "', '" + _skp + "','" + _realisasi + "', '" + _tugastambahan + "', '" + _kreatifitas + "', '" + _perilaku + "', '" + _prestasi + "', '" + _pilih_session + "','" + unorid + "')";
                PreparedStatement stb = this.conn.prepareStatement(sqlb);
                stb.executeUpdate(sqlb);
                stb.close();
            }
        } else {
            String sqlb = "INSERT INTO nilaiprestasikerja(nip_pns,skp, realisasi, tugastambahan, kreatifitas, perilaku, prestasi,id_unor) VALUES('" + nippns + "', '" + _skp + "','" + _realisasi + "', '" + _tugastambahan + "', '" + _kreatifitas + "', '" + _perilaku + "', '" + _prestasi + "', '" + _pilih_session + "','" + unorid + "')";
            PreparedStatement stb = this.conn.prepareStatement(sqlb);
            stb.executeUpdate(sqlb);
            stb.close();
        }

        return _realisasi;
    }

    public String nilaicapaianallIunor(String nippns, String Idunor) throws SQLException {
        double i_sum_skp;
        int i_sum_tamb;
        int i_sum_kreaf;
        double i_count_skp;
        int i_count_tamb;
        int i_count_kreaf;

        String s_sum_skp;
        String s_sum_tamb;
        String s_sum_kreaf;
        String s_count_skp;
        String s_count_tamb;
        String s_count_kreaf;


        double i_skp;


        String sql = "SELECT SUM(nilai_capaian_skp) as s_sum_skp FROM realisasi WHERE nip_pns = '" + nippns + "' and id_unor='" + Idunor + "' ";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            s_sum_skp = rs.getString("s_sum_skp");
            //  i_sum_skp = Integer.parseInt(s_sum_skp);
            i_sum_skp = Double.parseDouble(s_sum_skp);
        } else {
            i_sum_skp = 0;
        }

        //*******************JUMLAH NILAI SKP***************************************//
        String sqlc = "SELECT COUNT(nilai_capaian_skp) as s_count_skp FROM realisasi WHERE nip_pns = '" + nippns + "' and id_unor='" + Idunor + "' ";
        PreparedStatement pstc = this.conn.prepareStatement(sqlc);
        ResultSet rsc = pstc.executeQuery();
        if (rsc.next()) {
            s_count_skp = rsc.getString("s_count_skp");
            i_count_skp = Double.parseDouble(s_count_skp);
        } else {
            i_count_skp = 0;
        }

        i_skp = i_sum_skp / i_count_skp;



        //*********************JADI...
        String _realisasi;
        double i_total;
        int i_count_tugastambahan = 0;
        int i_count_kreatifitas = 0;
        i_total = i_skp;
        _realisasi = Double.toString(i_total);

        String _skp = "0";
        String _tugastambahan = "0";
        String _kreatifitas = "0";
        String _perilaku = "0";
        String _prestasi = "0";
        String _periode = "0";
        String s_count_tugastambahan = "0";


        //*******************INSERT DULU****************************************//
        String sqla = "SELECT * FROM nilaiprestasikerja WHERE nip_pns = '" + nippns + "'  ";
        PreparedStatement psta = this.conn.prepareStatement(sqla);
        ResultSet rsa = psta.executeQuery();
        if (rsa.next()) {
            s_count_tugastambahan = rsa.getString("tugastambahan");
            i_count_tugastambahan = Integer.parseInt(s_count_tugastambahan);

            s_count_tugastambahan = rsa.getString("kreatifitas");
            i_count_kreatifitas = Integer.parseInt(s_count_tugastambahan);

            i_total = i_total + i_count_tugastambahan + i_count_kreatifitas;




            DecimalFormat formatterR = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            formatterR.setMaximumFractionDigits(2);
            _realisasi = formatterR.format(i_total);

            validasiString vs = new validasiString();

            vs.setkoma(_realisasi);
            _realisasi = vs.getmashudi();

            // _realisasi = Double.toString(i_total);

            String sqla2 = "SELECT * FROM nilaiprestasikerja WHERE nip_pns = '" + nippns + "' and id_unor='" + Idunor + "' ";
            PreparedStatement psta2 = this.conn.prepareStatement(sqla2);
            ResultSet rsa2 = psta2.executeQuery();
            if (rsa2.next()) {

                String sqld = "UPDATE nilaiprestasikerja SET realisasi = '" + _realisasi + "' where nip_pns='" + nippns + "'  and id_unor='" + Idunor + "' ";
                PreparedStatement std = this.conn.prepareStatement(sqld);
                std.executeUpdate(sqld);
                std.close();
            } else {
                String sqlb = "INSERT INTO nilaiprestasikerja(nip_pns,skp, realisasi, tugastambahan, kreatifitas, perilaku, prestasi, periode,id_unor) VALUES('" + nippns + "', '" + _skp + "','" + _realisasi + "', '" + _tugastambahan + "', '" + _kreatifitas + "', '" + _perilaku + "', '" + _prestasi + "', '" + _periode + "','" + Idunor + "')";
                PreparedStatement stb = this.conn.prepareStatement(sqlb);
                stb.executeUpdate(sqlb);
                stb.close();
            }
        } else {
            String sqlb = "INSERT INTO nilaiprestasikerja(nip_pns,skp, realisasi, tugastambahan, kreatifitas, perilaku, prestasi, periode,id_unor) VALUES('" + nippns + "', '" + _skp + "','" + _realisasi + "', '" + _tugastambahan + "', '" + _kreatifitas + "', '" + _perilaku + "', '" + _prestasi + "', '" + _periode + "','" + Idunor + "')";
            PreparedStatement stb = this.conn.prepareStatement(sqlb);
            stb.executeUpdate(sqlb);
            stb.close();
        }

        return _realisasi;
    }

    public String nilaicapaianall(String nippns) throws SQLException {
        double i_sum_skp;
        int i_sum_tamb;
        int i_sum_kreaf;
        double i_count_skp;
        int i_count_tamb;
        int i_count_kreaf;

        String s_sum_skp;
        String s_sum_tamb;
        String s_sum_kreaf;
        String s_count_skp;
        String s_count_tamb;
        String s_count_kreaf;


        double i_skp;


//        //******************VALIDASI "-"***********************************//
//        String x = "-";
//        String x1 = "0";
//        String sqlx = "SELECT * FROM realisasi WHERE nip_pns = '"+nippns+"' and nilai_capaian_skp = '"+x+"'";
//        PreparedStatement pstx = this.conn.prepareStatement(sqlx);
//        ResultSet rsx = pstx.executeQuery();
//        while (rsx.next())
//        {
//            String idRealisasi = rsx.getString("id_realisasi");
//            String idIsi4Faktor = rsx.getString("id_isi4faktor");
//            String sqlx1 = "UPDATE realisasi SET nilai_capaian_skp = '"+x1+"' where nippns='"+nippns+"' and id_realisasi = '"+idRealisasi+"' and id_isi4faktor = '"+idIsi4Faktor+"'";
//            PreparedStatement stx1 = this.conn.prepareStatement(sqlx1);
//            stx1.executeUpdate(sqlx1);
//            stx1.close();
//        }

        //*******************JUMLAH TOTAL SKP***************************************//
        String sql = "SELECT SUM(nilai_capaian_skp) as s_sum_skp FROM realisasi WHERE nip_pns = '" + nippns + "'";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            s_sum_skp = rs.getString("s_sum_skp");
            //  i_sum_skp = Integer.parseInt(s_sum_skp);
            i_sum_skp = Double.parseDouble(s_sum_skp);
        } else {
            i_sum_skp = 0;
        }

        //*******************JUMLAH NILAI SKP***************************************//
        String sqlc = "SELECT COUNT(nilai_capaian_skp) as s_count_skp FROM realisasi WHERE nip_pns = '" + nippns + "'";
        PreparedStatement pstc = this.conn.prepareStatement(sqlc);
        ResultSet rsc = pstc.executeQuery();
        if (rsc.next()) {
            s_count_skp = rsc.getString("s_count_skp");
            i_count_skp = Double.parseDouble(s_count_skp);
        } else {
            i_count_skp = 0;
        }

        i_skp = i_sum_skp / i_count_skp;



        //*********************JADI...
        String _realisasi;
        double i_total;
        int i_count_tugastambahan = 0;
        int i_count_kreatifitas = 0;
        i_total = i_skp;
        _realisasi = Double.toString(i_total);

        String _skp = "0";
        String _tugastambahan = "0";
        String _kreatifitas = "0";
        String _perilaku = "0";
        String _prestasi = "0";
        String _periode = "0";
        String s_count_tugastambahan = "0";


        //*******************INSERT DULU****************************************//
        String sqla = "SELECT * FROM nilaiprestasikerja WHERE nip_pns = '" + nippns + "'";
        PreparedStatement psta = this.conn.prepareStatement(sqla);
        ResultSet rsa = psta.executeQuery();
        if (rsa.next()) {
            s_count_tugastambahan = rsa.getString("tugastambahan");
            i_count_tugastambahan = Integer.parseInt(s_count_tugastambahan);

            s_count_tugastambahan = rsa.getString("kreatifitas");
            i_count_kreatifitas = Integer.parseInt(s_count_tugastambahan);

            i_total = i_total + i_count_tugastambahan + i_count_kreatifitas;




            DecimalFormat formatterR = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            formatterR.setMaximumFractionDigits(2);
            _realisasi = formatterR.format(i_total);

            validasiString vs = new validasiString();

            vs.setkoma(_realisasi);
            _realisasi = vs.getmashudi();

            // _realisasi = Double.toString(i_total);



            String sqld = "UPDATE nilaiprestasikerja SET realisasi = '" + _realisasi + "' where nip_pns='" + nippns + "' ";
            PreparedStatement std = this.conn.prepareStatement(sqld);
            std.executeUpdate(sqld);
            std.close();
        } else {
            String sqlb = "INSERT INTO nilaiprestasikerja(nip_pns,skp, realisasi, tugastambahan, kreatifitas, perilaku, prestasi, periode) VALUES('" + nippns + "', '" + _skp + "','" + _realisasi + "', '" + _tugastambahan + "', '" + _kreatifitas + "', '" + _perilaku + "', '" + _prestasi + "', '" + _periode + "')";
            PreparedStatement stb = this.conn.prepareStatement(sqlb);
            stb.executeUpdate(sqlb);
            stb.close();
        }

        return _realisasi;
    }

    public String nilaicapaianallTugasTambahan(String nippns) throws SQLException {
        int i_sum_skp;
        int i_sum_tamb;
        int i_sum_kreaf;
        int i_count_skp;
        int i_count_tamb;
        int i_count_kreaf;

        String s_sum_skp;
        String s_sum_tamb;
        String s_sum_kreaf;
        String s_count_skp;
        String s_count_tamb;
        String s_count_kreaf;

        ////*******************************CARA PENGHITUNGAN TUGAS TAMBAHAN VERSI PERKA BARU **********************************************//
        //*******************JUMLAH NILAI TUGAS TAMBAHAN***************************************//
        String sqlt = "SELECT COUNT(nilaitambahan) as s_count_tamb FROM tugastambahan WHERE idNip = '" + nippns + "' AND jenisTambahan = 'Tugas Tambahan'";
        PreparedStatement pstt = this.conn.prepareStatement(sqlt);
        ResultSet rst = pstt.executeQuery();
        if (rst.next()) {
            s_count_tamb = rst.getString("s_count_tamb");
            i_count_tamb = Integer.parseInt(s_count_tamb);
        } else {
            i_count_tamb = 0;
        }

        int i_tamb = 0;
        if (i_count_tamb >= 1 && i_count_tamb <= 3) {
            i_tamb = 1;
        } else if (i_count_tamb >= 4 && i_count_tamb <= 6) {
            i_tamb = 2;
        } else if (i_count_tamb >= 7) {
            i_tamb = 3;
        } else {
        }

        //JADI....................................
        String s_tamb;
        s_tamb = Integer.toString(i_tamb);


        String _skp = "0";
        String _realisasi = "0";
        String _kreatifitas = "0";
        String _perilaku = "0";
        String _prestasi = "0";
        String _periode = "0";
        //***************INSERT DOELOE**************************//
        String sqla = "SELECT * FROM nilaiprestasikerja WHERE nip_pns = '" + nippns + "'";
        PreparedStatement psta = this.conn.prepareStatement(sqla);
        ResultSet rsa = psta.executeQuery();
        if (rsa.next()) {
            String sqld = "UPDATE nilaiprestasikerja SET tugastambahan = '" + s_tamb + "' where nip_pns='" + nippns + "' and periode ='" + _periode + "' ";
            PreparedStatement std = this.conn.prepareStatement(sqld);
            std.executeUpdate(sqld);
            std.close();
        } else {
            String sqlb = "INSERT INTO nilaiprestasikerja(nip_pns,skp, realisasi, tugastambahan, kreatifitas, perilaku, prestasi, periode) VALUES('" + nippns + "', '" + _skp + "','" + _realisasi + "', '" + s_tamb + "', '" + _kreatifitas + "', '" + _perilaku + "', '" + _prestasi + "', '" + _periode + "')";
            PreparedStatement stb = this.conn.prepareStatement(sqlb);
            stb.executeUpdate(sqlb);
            stb.close();
        }



        return s_tamb;
    }

    public void UpdateTugasTambahanKoef(String idTamb, String koef) throws SQLException {
        String _idTamb = idTamb;
        String _koef = koef;
        String _koefn;

        if ("10".equals(_koef)) {
            _koefn = "Unit Kerja";
        } else if ("20".equals(_koef)) {
            _koefn = "Instansi";
        } else if ("30".equals(_koef)) {
            _koefn = "Nasional";
        } else if ("40".equals(_koef)) {
            _koefn = "Tidak Valid";
        } else {
            _koefn = "-";
        }

        String sql = "UPDATE TugasTambahan SET koef_kreatifitas ='" + _koefn + "' where idTambahan='" + _idTamb + "'";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.executeUpdate(sql);
        st.close();
    }

    public void kreafSimpanKeNilaiPrestasi(String _nip) throws SQLException {
        String _skp = "0";
        String _realisasi = "0";
        String _kreatifitas = "0";
        String _perilaku = "0";
        String _prestasi = "0";
        String _periode = "0";
        String nip = _nip;


        //CARI MAKS NILAI DARI NILAI KREATIFITAS
        String sqlmaks = "SELECT max(nilaitambahan) as maksnilaitambahan FROM tugastambahan WHERE idnip = '" + _nip + "' and jenistambahan = 'Keterampilan'";
        PreparedStatement pstmaks = this.conn.prepareStatement(sqlmaks);
        ResultSet rsmaks = pstmaks.executeQuery();
        String s_hitungdao = null;
        if (rsmaks.next()) {
            s_hitungdao = rsmaks.getString("maksnilaitambahan");
        }


        //***************INSERT DOELOE**************************//
        String sqla = "SELECT * FROM nilaiprestasikerja WHERE nip_pns = '" + nip + "'";
        PreparedStatement psta = this.conn.prepareStatement(sqla);
        ResultSet rsa = psta.executeQuery();
        if (rsa.next()) {
            String sqld = "UPDATE nilaiprestasikerja SET kreatifitas = '" + s_hitungdao + "' where nip_pns='" + nip + "' and periode ='" + _periode + "' ";
            PreparedStatement std = this.conn.prepareStatement(sqld);
            std.executeUpdate(sqld);
            std.close();
        } else {
            String sqlb = "INSERT INTO nilaiprestasikerja(nip_pns,skp, realisasi, tugastambahan, kreatifitas, perilaku, prestasi, periode) VALUES('" + nip + "', '" + _skp + "','" + _realisasi + "', '" + s_hitungdao + "', '" + _kreatifitas + "', '" + _perilaku + "', '" + _prestasi + "', '" + _periode + "')";
            PreparedStatement stb = this.conn.prepareStatement(sqlb);
            stb.executeUpdate(sqlb);
            stb.close();
        }
    }
}
