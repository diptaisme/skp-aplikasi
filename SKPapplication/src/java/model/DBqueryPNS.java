package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.nilaiprestasikerja;
import servlets.ModelLocatorSKP;

/**
 *
 * @author diptaisme
 *
 * ini seperti DAO di Framework NCSIS **************
 *
 * DAO PNS
 *
 */
public class DBqueryPNS {

    Connection conn;

    public DBqueryPNS(Connection conn) {
        this.conn = conn;
    }

    public void getDBqueryUpdateUnorPNS(String nipBaru, String AtasanBaru, String UnorBaru, String namaUnor, String namaJabatan) throws SQLException {

        String sql = "UPDATE pnsskp SET unorid = '" + UnorBaru + "', diatasanid = '" + AtasanBaru + "', namaunor = '" + namaUnor + "', namajabatan = '" + namaJabatan + "' WHERE nip_baru = '" + nipBaru + "'";

        PreparedStatement st = this.conn.prepareStatement(sql);
        st.executeUpdate(sql);
        st.close();

    }
    public void getDBqueryinsertrw_unor(String nip_baru,String unor_lama,String unor_baru) throws SQLException
    {
        String sql = "insert into rw_perubahanunor values ('"+nip_baru+"','"+unor_lama+"','"+unor_baru+"',NOW())";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.executeUpdate(sql);
        st.close();  
    }
    public void getDBqueryUpdateImportUnor(String diatasan_id, String eselon_id,
            String nama_unor, String nama_jabatan, String pemimpin_pns_id) throws SQLException {
        String sql = "update unorskp "
                + "set diatasan_id = '" + diatasan_id + "',eselon_id = '" + eselon_id + "',nama_unor =  '" + nama_unor + "',nama_jabatan = '" + nama_jabatan + "',"
                + "pemimpin_pns_id = '" + pemimpin_pns_id + "'";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.executeUpdate(sql);
        st.close();
    }

    public String getcekUnor(String id) throws SQLException {
        String sql = "select * from unorskp where idunor = ?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            return "ada";
        }
        return "tidakada";
    }

    public void getDBqueryUpdateImportPNS(String golonganid, String namagolru,
            String pangkat, String unorid, String namaunor, String namajabatan,
            String diatasanid, String jenisjabatan, String jabatan_fungsional,
            String jabatan_fungsional_umum) throws SQLException {
        String sql = "update pnsskp "
                + "set golongan_id = '" + golonganid + "',namagolru = '" + namagolru + "',pangkat = '" + pangkat + "',"
                + "unorid = '" + unorid + "',namaunor = '" + namaunor + "',namajabatan = '" + namajabatan + "',diatasanid = '" + jenisjabatan + "',"
                + "jabatan_fungsional = '" + jabatan_fungsional + "',jabatan_umum = '" + jabatan_fungsional_umum + "'"
                + "";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.executeUpdate(sql);
        st.close();
    }

    public void getDBqueryInsertUNOR(String id_unor, String instansi_id, String diatasan_id, String eselon_id,
            String nama_unor, String nama_jabatan, String pemimpin_pns_id) throws SQLException {

        String sql = "insert into unorskp values('" + id_unor + "','" + instansi_id + "','" + diatasan_id + "','" + eselon_id + "',"
                + "'" + nama_unor + "','" + nama_jabatan + "','" + pemimpin_pns_id + "')";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.executeUpdate(sql);
        st.close();
    }

    public void getDBqueryInsertPNS(String id, String nip_lama, String nip_baru, String nama_pns, String golonganid, String namagolru, String pangkat, String unorid,
            String namaunor, String namajabatan, String diatasanid, String instansiid, String jenisjabatan, String jabatan_fungsional, String jabatan_fungsional_umum) throws SQLException {

        String sql = "insert into pnsskp values('" + id + "','" + nip_lama + "','" + nip_baru + "','" + nama_pns + "','" + golonganid + "','" + namagolru + "','" + pangkat + "',"
                + "'" + unorid + "','" + namaunor + "','" + namajabatan + "','" + diatasanid + "',"
                + "'" + instansiid + "','" + jenisjabatan + "','" + jabatan_fungsional + "','" + jabatan_fungsional_umum + "')";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.executeUpdate(sql);
        st.close();



    }

    public String getcekpns(String id) throws SQLException {
        String sql = "select * from pnsskp where idpns = ?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            return "ada";
        }
        return "tidakada";
    }

    public PnsSkp getDBqueryPNSId(String sid_pns) throws SQLException {

        String nip = sid_pns;
        String sql2 = "SELECT idpns, nip_lama, nip_baru, namapns, golongan_id, namagolru, pangkat, unorid, namaunor, namajabatan, diatasanid, instansi_id, jenis_jabatan, JABATAN_FUNGSIONAL, JABATAN_UMUM FROM pnsskp WHERE nip_baru = '" + nip + "' ";
        PreparedStatement pst2 = this.conn.prepareStatement(sql2);
        PnsSkp ipns = null;
        ResultSet rs = pst2.executeQuery();


        // String sql = "SELECT idpns, nip_lama, nip_baru, namapns, golongan_id, namagolru, pangkat, unorid, namaunor, namajabatan, diatasanid, instansi_id, jenis_jabatan, JABATAN_FUNGSIONAL, JABATAN_UMUM FROM pnsskp WHERE nip_baru =? ";
        // PreparedStatement pst = this.conn.prepareStatement(sql);
        //  PnsSkp ipns = null;
        //  pst.setString(1, sid_pns);
        // ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            ipns = new PnsSkp();
            ipns.setIdPns(rs.getString(1));
            ipns.setNipLama(rs.getString(2));
            ipns.setNipBaru(rs.getString(3));
            ipns.setNamaPns(rs.getString(4));
            ipns.setGolonganId(rs.getString(5));
            ipns.setNamaGolru(rs.getString(6));
            ipns.setPangkat(rs.getString(7));
            ipns.setUnorId(rs.getString(8));
            ipns.setNamaUnor(rs.getString(9));
            ipns.setNamaJabatan(rs.getString(10));

            ipns.setInstansiId(rs.getString(12));
            ipns.setjnsjbtn_id(rs.getString(13));
            ipns.setJabatanFungsionalId(rs.getString(14));
            ipns.setJabatanUmumId(rs.getString(15));



//              if(ipns.getjnsjbtn_id().equals("2")||ipns.getjnsjbtn_id().equals("4")|| ipns.getjnsjbtn_id().equals("")){
//                  ipns.setDiAtasanId(rs.getString(8));
//              }else{
            ipns.setDiAtasanId(rs.getString(11));
//              }
            String x = ipns.getNipBaru();
            //String z = getDBqueryPNSStruktural(x);
            String Struktural = ipns.getUnorId();
            String Fungsional = ipns.getJabatanFungsionalId();
            String Umum = ipns.getJabatanUmumId();

            String NamaJabatan;
            String a = ipns.getjnsjbtn_id();

            if (a.equals("1")) //struktural
            {

                NamaJabatan = getStruktural(Struktural);
                ipns.setNamaJabatan(NamaJabatan);
            } else if (a.equals("2")) // fungsional tertentu
            {
                NamaJabatan = getFungsional(Fungsional);
                ipns.setNamaJabatan(NamaJabatan);
            } else if (a.equals("4")) // fungsional umum
            {
                NamaJabatan = getUmum(Umum);
                ipns.setNamaJabatan(NamaJabatan);

            } else {
                ipns.setNamaJabatan("RANGKAP");
            }

            /*
             1	Jabatan Struktural
             2	Jabatan Fungsional Tertentu
             4	Jabatan Fungsional Umum
             3	Jabatan Rangkap (Struktural dan Fungsional)
            
             * 
             * 
             * 
             * 
             */
            /*      if (z == null || "".equals(z) || " ".equals(z))
             {
             String y = getDBqueryPNSnamaJabfum(x);
             if (y == null || "".equals(y) || " ".equals(y))
             { 
             y = getDBqueryPNSnamaJabfung(x);
             if (y == null || "".equals(y) || " ".equals(y)){
             ipns.setNamaJabatan("PELAKSANA");
             }else{
             ipns.setNamaJabatan(y);
             }
             }
             else 
             {
             ipns.setNamaJabatan(y);
             }
             }
             else
             {
             ipns.setNamaJabatan(rs.getString(10));
             }
             */
        }
        return ipns;
    }

    public String getDBqueryPNSnamaJabfum(String sid_pns) throws SQLException {
        String sql2 = "SELECT nipbaru, namajabfum FROM jabfum_bkn WHERE nipbaru = '" + sid_pns + "' ";
        PreparedStatement pst2 = this.conn.prepareStatement(sql2);
        String ipns = null;
        ResultSet rs2 = pst2.executeQuery();
        if (rs2.next()) {
            ipns = rs2.getString("namajabfum");
        }
        return ipns;
    }

    public String getUmum(String id) throws SQLException {
        String sql2 = "SELECT nama FROM jabfum WHERE id = '" + id + "' ";
        PreparedStatement pst2 = this.conn.prepareStatement(sql2);
        String ipns = null;
        ResultSet rs2 = pst2.executeQuery();
        if (rs2.next()) {
            ipns = rs2.getString("nama");
        }
        return ipns;
    }

    public String getDBqueryPNSnamaJabfung(String sid_pns) throws SQLException {
        String sql2 = "SELECT namajabfungt FROM jabfungt_bkn WHERE  nippns = '" + sid_pns + "' ";
        PreparedStatement pst2 = this.conn.prepareStatement(sql2);
        String ipns = null;
        ResultSet rs2 = pst2.executeQuery();
        if (rs2.next()) {
            ipns = rs2.getString("namajabfungt");
        }
        return ipns;
    }

    public String getFungsional(String id) throws SQLException {
        String sql2 = "SELECT nama FROM jabfung WHERE  id = '" + id + "' ";
        PreparedStatement pst2 = this.conn.prepareStatement(sql2);
        String ipns = null;
        ResultSet rs2 = pst2.executeQuery();
        if (rs2.next()) {
            ipns = rs2.getString("nama");
        }
        return ipns;
    }

    public String getDBqueryPNSStruktural(String sid_pns) throws SQLException {
        String sql2 = "SELECT nipbaru FROM struktural_bkn WHERE nipbaru = '" + sid_pns + "' ";
        PreparedStatement pst2 = this.conn.prepareStatement(sql2);
        String ipns = null;
        ResultSet rs2 = pst2.executeQuery();
        if (rs2.next()) {
            ipns = rs2.getString("nipbaru");
        }
        return ipns;
    }

    public String getStruktural(String UnorId) throws SQLException {
        String sql2 = "SELECT nama_jabatan FROM unorskp WHERE idunor = '" + UnorId + "' ";
        PreparedStatement pst2 = this.conn.prepareStatement(sql2);
        String ipns = null;
        ResultSet rs2 = pst2.executeQuery();
        if (rs2.next()) {
            ipns = rs2.getString("nama_jabatan");
        }
        return ipns;
    }

    public PnsSkp getDBqueryAtasanId(String sid_pns) throws SQLException {
        String sql = "SELECT idpns, nip_lama, nip_baru, namapns, golongan_id, namagolru, pangkat, unorid, namaunor, namajabatan, diatasanid, instansi_id FROM pnsskp WHERE jenis_jabatan ='1' and unorid =? ";
        //  String sql = "SELECT idpns, nip_lama, nip_baru, namapns, golongan_id, namagolru, pangkat, unorid, namaunor, namajabatan, diatasanid, instansi_id, jenis_jabatan, JABATAN_FUNGSIONAL, JABATAN_UMUM FROM PnsSkp WHERE nip_baru =? ";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        PnsSkp ipns = null;
        pst.setString(1, sid_pns);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            ipns = new PnsSkp();
            ipns.setIdPns(rs.getString(1));
            ipns.setNipLama(rs.getString(2));
            ipns.setNipBaru(rs.getString(3));
            ipns.setNamaPns(rs.getString(4));
            ipns.setGolonganId(rs.getString(5));
            ipns.setNamaGolru(rs.getString(6));
            ipns.setPangkat(rs.getString(7));
            ipns.setUnorId(rs.getString(8));
            ipns.setNamaUnor(rs.getString(9));
            ipns.setNamaJabatan(rs.getString(10));
            ipns.setDiAtasanId(rs.getString(11));
            if (ipns.getDiAtasanId().equals("")) {
                ipns.setDiAtasanId(rs.getString(8));
            } else {
                ipns.setDiAtasanId(rs.getString(11));
            }
            ipns.setInstansiId(rs.getString(12));
        } else {
            System.out.println("rs KOSONG");
        }
        return ipns;
    }

    public PnsSkp getDBqueryAtasanIdSama(String sid_pns) throws SQLException {
        String sql = "SELECT idpns, nip_lama, nip_baru, namapns, golongan_id, namagolru, pangkat, unorid, namaunor, namajabatan, diatasanid, instansi_id FROM pnsskp WHERE nip_baru =? ";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        PnsSkp ipns = null;
        pst.setString(1, sid_pns);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            ipns = new PnsSkp();
            ipns.setIdPns(rs.getString(1));
            ipns.setNipLama(rs.getString(2));
            ipns.setNipBaru(rs.getString(3));
            ipns.setNamaPns(rs.getString(4));
            ipns.setGolonganId(rs.getString(5));
            ipns.setNamaGolru(rs.getString(6));
            ipns.setPangkat(rs.getString(7));
            ipns.setUnorId(rs.getString(8));
            ipns.setNamaUnor(rs.getString(9));
            ipns.setNamaJabatan(rs.getString(10));
            ipns.setDiAtasanId(rs.getString(11));
            if (ipns.getDiAtasanId().equals("")) {
                ipns.setDiAtasanId(rs.getString(8));
            } else {
                ipns.setDiAtasanId(rs.getString(11));
            }
            ipns.setInstansiId(rs.getString(12));
        } else {
            System.out.println("rs KOSONG");
        }
        return ipns;
    }

    public List<PnsSkp> getDBqueryPNS(String snip_pns, String sid_unor) throws SQLException {
        List<PnsSkp> pnsies = new ArrayList<PnsSkp>();
        String sql = "SELECT idpns, nip_lama, nip_baru, namapns, golongan_id, namagolru, pangkat, unorid, namaunor, namajabatan, diatasanid, instansi_id FROM pnsskp WHERE nip_baru =? and unorid =?";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryPNS nDBqueryPNS = null;
        pst.setString(3, snip_pns);
        pst.setString(8, sid_unor);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            PnsSkp ipns = new PnsSkp();
            ipns.setIdPns(rs.getString(1));
            ipns.setNipLama(rs.getString(2));
            ipns.setNipBaru(rs.getString(3));
            ipns.setNamaPns(rs.getString(4));
            ipns.setGolonganId(rs.getString(5));
            ipns.setNamaGolru(rs.getString(6));
            ipns.setPangkat(rs.getString(7));
            ipns.setUnorId(rs.getString(8));
            ipns.setNamaUnor(rs.getString(9));
            ipns.setNamaJabatan(rs.getString(10));
            ipns.setDiAtasanId(rs.getString(11));
            ipns.setInstansiId(rs.getString(12));
            pnsies.add(ipns);
        }
        return pnsies;
    }

    //BILA MENGGUNAKAN STRUKTURAL SAJA
//    public List<pnsskp_strukturalbkn> getDBqueryPNSTambahan(String sid_unor) throws SQLException
//    {
//        
//        List<pnsskp_strukturalbkn> pnsies = new ArrayList<pnsskp_strukturalbkn>();
//        //String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id FROM PnsSkp p, struktural_bkn s WHERE p.diatasanid ='"+sid_unor+"' AND p.nip_baru = s.nipbaru";
//        String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id FROM PnsSkp p, struktural_bkn s WHERE p.diatasanid ='"+sid_unor+"'";
//        PreparedStatement pst = this.conn.prepareStatement(sql);
//        DBqueryPNS nDBqueryPNS = null;
//        //pst.setString(1, sid_unor);
//        ResultSet rs = pst.executeQuery();
//        while (rs.next())
//        {
//            pnsskp_strukturalbkn ipns = new pnsskp_strukturalbkn();
//            ipns.setIdpns(rs.getString(1));
//            ipns.setNip_lama(rs.getString(2));
//            ipns.setNip_baru(rs.getString(3));
//            ipns.setNamapns(rs.getString(4));
//            ipns.setGolongan_id(rs.getString(5));
//            ipns.setNamagolru(rs.getString(6));
//            ipns.setPangkat(rs.getString(7));
//            ipns.setUnorid(rs.getString(8));
//            ipns.setNamaunor(rs.getString(9));
//            ipns.setNamajabatan(rs.getString(10));
//            ipns.setDiatasanid(rs.getString(11));
//            ipns.setInstansi_id(rs.getString(12));
//            pnsies.add(ipns);
//        }
//        return pnsies;
//    }
    //BILA MENGGUNAKAN STRUKTURAL SAJA DAN MENGHILANGKAN FUNGSIONAL
    public List<pnsskp_jabfungtbkn> getDBqueryPNSTambahan(String sid_unor) throws SQLException {

        List<pnsskp_jabfungtbkn> pnsies = new ArrayList<pnsskp_jabfungtbkn>();
        //  String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id FROM PnsSkp p WHERE p.diatasanid = '"+sid_unor+"' AND p.nip_baru not in (select s.nippns from jabfungt_bkn s)";
        String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id FROM pnsskp p WHERE p.diatasanid = '" + sid_unor + "' ";
        //String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id FROM PnsSkp p, jabfungt_bkn s WHERE p.diatasanid = '"+sid_unor+"' AND p.nip_baru <> j.nipbaru";
        //String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id FROM PnsSkp p, struktural_bkn s WHERE p.diatasanid ='"+sid_unor+"'";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryPNS nDBqueryPNS = null;
        //pst.setString(1, sid_unor);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            pnsskp_jabfungtbkn ipns = new pnsskp_jabfungtbkn();
            ipns.setIdpns(rs.getString(1));
            ipns.setNip_lama(rs.getString(2));
            ipns.setNip_baru(rs.getString(3));
            ipns.setNamapns(rs.getString(4));
            ipns.setGolongan_id(rs.getString(5));
            ipns.setNamagolru(rs.getString(6));
            ipns.setPangkat(rs.getString(7));
            ipns.setUnorid(rs.getString(8));
            ipns.setNamaunor(rs.getString(9));
            ipns.setNamajabatan(rs.getString(10));
            ipns.setDiatasanid(rs.getString(11));
            ipns.setInstansi_id(rs.getString(12));
            pnsies.add(ipns);
        }
        return pnsies;
    }

    public List<PnsSkp> getDBqueryPNSTambahan2Session(String sid_unor, String thnSession) throws SQLException {

        List<PnsSkp> pnsies = new ArrayList<PnsSkp>();
        //  String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id FROM PnsSkp p WHERE p.diatasanid = '"+sid_unor+"' AND p.nip_baru not in (select s.nippns from jabfungt_bkn s)";
        String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id, p.jenis_jabatan, JABATAN_FUNGSIONAL, JABATAN_UMUM FROM pnsskp p WHERE p.diatasanid = '" + sid_unor + "'";
        //String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id FROM PnsSkp p, jabfungt_bkn s WHERE p.diatasanid = '"+sid_unor+"' AND p.nip_baru <> j.nipbaru";
        //String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id FROM PnsSkp p, struktural_bkn s WHERE p.diatasanid ='"+sid_unor+"'";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryPNS nDBqueryPNS = null;
        //pst.setString(1, sid_unor);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            PnsSkp ipns = new PnsSkp();
            ipns.setIdPns(rs.getString(1));
            ipns.setNipLama(rs.getString(2));
            ipns.setNipBaru(rs.getString(3));
            ipns.setNamaPns(rs.getString(4));
            ipns.setGolonganId(rs.getString(5));
            ipns.setNamaGolru(rs.getString(6));
            ipns.setPangkat(rs.getString(7));
            ipns.setUnorId(rs.getString(8));
            ipns.setNamaUnor(rs.getString(9));
            ipns.setNamaJabatan(rs.getString(10));
            ipns.setDiAtasanId(rs.getString(11));
            ipns.setInstansiId(rs.getString(12));
            ipns.setjnsjbtn_id(rs.getString(13));
            ipns.setJabatanFungsionalId(rs.getString(14));
            ipns.setJabatanUmumId(rs.getString(15));
            String Struktural = ipns.getUnorId();
            String Fungsional = ipns.getJabatanFungsionalId();
            String Umum = ipns.getJabatanUmumId();

            String NamaJabatan;
            String a = ipns.getjnsjbtn_id();

            if (a.equals("1")) //struktural
            {

                NamaJabatan = getStruktural(Struktural);
                ipns.setNamaJabatan(NamaJabatan);
            } else if (a.equals("2")) // fungsional tertentu
            {
                NamaJabatan = getFungsional(Fungsional);
                ipns.setNamaJabatan(NamaJabatan);
            } else if (a.equals("4")) // fungsional umum
            {
                NamaJabatan = getUmum(Umum);
                ipns.setNamaJabatan(NamaJabatan);

            } else {
                ipns.setNamaJabatan("RANGKAP");
            }



            //  nilaiprestasikerja nilaiprestasikerjas = new GoIndex().getNilaiPrestasiKerjaAllNotList(ipns.getNipBaru());

            nilaiprestasikerja nilaiprestasikerjas = new GoIndex().getNilaiPrestasiKerjaAllNotList_session(ipns.getNipBaru(), thnSession, sid_unor);
            if (nilaiprestasikerjas == null) {
                String nilprest = "0";
                //   nilaiprestasikerjas.setRealisasi(nilprest);
                ipns.setRealisasi(nilprest);
            }
            //  ipns.setRealisasi(nilaiprestasikerjas.getRealisasi());
            pnsies.add(ipns);
        }
        return pnsies;
    }

    public List<PnsSkp> getDBqueryPNSTambahan2(String sid_unor) throws SQLException {
        String instInduk = ModelLocatorSKP.logininstansi;
        List<PnsSkp> pnsies = new ArrayList<PnsSkp>();
        //  String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id FROM PnsSkp p WHERE p.diatasanid = '"+sid_unor+"' AND p.nip_baru not in (select s.nippns from jabfungt_bkn s)";
        String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id, p.jenis_jabatan,p.JABATAN_FUNGSIONAL, p.JABATAN_UMUM FROM pnsskp p WHERE p.instansi_id ='" + instInduk + "' and p.diatasanid = '" + sid_unor + "'";
        //String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id FROM PnsSkp p, jabfungt_bkn s WHERE p.diatasanid = '"+sid_unor+"' AND p.nip_baru <> j.nipbaru";
        //String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id FROM PnsSkp p, struktural_bkn s WHERE p.diatasanid ='"+sid_unor+"'";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryPNS nDBqueryPNS = null;
        //pst.setString(1, sid_unor);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            PnsSkp ipns = new PnsSkp();

            ipns.setIdPns(rs.getString(1));
            ipns.setNipLama(rs.getString(2));
            ipns.setNipBaru(rs.getString(3));
            ipns.setNamaPns(rs.getString(4));
            ipns.setGolonganId(rs.getString(5));
            ipns.setNamaGolru(rs.getString(6));
            ipns.setPangkat(rs.getString(7));
            ipns.setUnorId(rs.getString(8));
            ipns.setNamaUnor(rs.getString(9));

            ipns.setNamaJabatan(rs.getString(10));
            ipns.setDiAtasanId(rs.getString(11));
            ipns.setInstansiId(rs.getString(12));
            ipns.setjnsjbtn_id(rs.getString(13));
            ipns.setJabatanFungsionalId(rs.getString(14));
            ipns.setJabatanUmumId(rs.getString(15));
            String NamaJabatan;
            String a = ipns.getjnsjbtn_id();


            String Struktural = ipns.getUnorId();
            String Fungsional = ipns.getJabatanFungsionalId();
            String Umum = ipns.getJabatanUmumId();


            if (a.equals("1")) //struktural
            {

                NamaJabatan = getStruktural(Struktural);
                ipns.setNamaJabatan(NamaJabatan);
            } else if (a.equals("2")) // fungsional tertentu
            {
                NamaJabatan = getFungsional(Fungsional);
                ipns.setNamaJabatan(NamaJabatan);
            } else if (a.equals("4")) // fungsional umum
            {
                NamaJabatan = getUmum(Umum);
                ipns.setNamaJabatan(NamaJabatan);

            } else {
                ipns.setNamaJabatan("RANGKAP");
            }




            nilaiprestasikerja nilaiprestasikerjas = new GoIndex().getNilaiPrestasiKerjaAllNotList(ipns.getNipBaru());
            if (nilaiprestasikerjas == null) {
                String nilprest = "0";

                ModelLocatorSKP.globalNilainonvalTarget = ModelLocatorSKP.globalNilainonvalTarget + 1;
                //   nilaiprestasikerjas.setRealisasi(nilprest);
                ipns.setRealisasi(nilprest);
            } else {
                ModelLocatorSKP.globalNilaivalTarget = ModelLocatorSKP.globalNilaivalTarget + 1;
                ipns.setRealisasi(nilaiprestasikerjas.getRealisasi());
            }


            String statyus = "tdk";
            // pnsies.add(ipns);
            //  ipns.setRealisasi(nilaiprestasikerjas.getRealisasi());
            if (ModelLocatorSKP.arraypGcavernip != null) {
                for (Object objResult : ModelLocatorSKP.arraypGcavernip) {
                    String strid = String.valueOf(objResult);
                    if (strid.equals(ipns.getNipBaru())) {
                        statyus = "ada";
                    }

                }
            }
            if (statyus.equals("tdk")) {
                pnsies.add(ipns);
            }
        }
        return pnsies;
    }

    public List<PnsSkp> getDBqueryPNSInstansi(String sid_Instansi) throws SQLException {

        List<PnsSkp> pnsies = new ArrayList<PnsSkp>();
        //  String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id FROM PnsSkp p WHERE p.diatasanid = '"+sid_unor+"' AND p.nip_baru not in (select s.nippns from jabfungt_bkn s)";
        String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id, p.jenis_jabatan FROM pnsskp p WHERE p.instansi_id= '" + sid_Instansi + "' ";
        //String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id FROM PnsSkp p, jabfungt_bkn s WHERE p.diatasanid = '"+sid_unor+"' AND p.nip_baru <> j.nipbaru";
        //String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id FROM PnsSkp p, struktural_bkn s WHERE p.diatasanid ='"+sid_unor+"'";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryPNS nDBqueryPNS = null;
        //pst.setString(1, sid_unor);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            PnsSkp ipns = new PnsSkp();
            ipns.setIdPns(rs.getString(1));
            ipns.setNipLama(rs.getString(2));
            ipns.setNipBaru(rs.getString(3));
            ipns.setNamaPns(rs.getString(4));
            ipns.setGolonganId(rs.getString(5));
            ipns.setNamaGolru(rs.getString(6));
            ipns.setPangkat(rs.getString(7));
            ipns.setUnorId(rs.getString(8));
            ipns.setNamaUnor(rs.getString(9));
            ipns.setNamaJabatan(rs.getString(10));
            ipns.setDiAtasanId(rs.getString(11));
            ipns.setInstansiId(rs.getString(12));
            ipns.setjnsjbtn_id(rs.getString(13));
            pnsies.add(ipns);
        }
        return pnsies;
    }

    public List<PnsSkp> getDBqueryPNSInstansiNamaAtasan(String instansiAtasant, String _carinamapnsatasan) throws SQLException {

        List<PnsSkp> pnsies = new ArrayList<PnsSkp>();
        //  String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id FROM PnsSkp p WHERE p.diatasanid = '"+sid_unor+"' AND p.nip_baru not in (select s.nippns from jabfungt_bkn s)";
        String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id, p.jenis_jabatan FROM pnsskp p WHERE p.instansi_id='" + instansiAtasant + "' and p.namapns like'%" + _carinamapnsatasan + "%' ";

        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryPNS nDBqueryPNS = null;
        //pst.setString(1, sid_unor);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            PnsSkp ipns = new PnsSkp();
            ipns.setIdPns(rs.getString(1));
            ipns.setNipLama(rs.getString(2));
            ipns.setNipBaru(rs.getString(3));
            ipns.setNamaPns(rs.getString(4));
            ipns.setGolonganId(rs.getString(5));
            ipns.setNamaGolru(rs.getString(6));
            ipns.setPangkat(rs.getString(7));
            ipns.setUnorId(rs.getString(8));
            ipns.setNamaUnor(rs.getString(9));
            ipns.setNamaJabatan(rs.getString(10));
            ipns.setDiAtasanId(rs.getString(11));
            ipns.setInstansiId(rs.getString(12));
            String ddd = ipns.getInstansiId();
            ipns.setjnsjbtn_id(rs.getString(13));
            pnsies.add(ipns);
        }
        return pnsies;
    }

    public List<PnsSkp> getDBqueryInstansinNamaPns(String sid_Instansi, String pencarian) throws SQLException {

        List<PnsSkp> pnsies = new ArrayList<PnsSkp>();
        //  String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id FROM PnsSkp p WHERE p.diatasanid = '"+sid_unor+"' AND p.nip_baru not in (select s.nippns from jabfungt_bkn s)";
        String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id, p.jenis_jabatan FROM pnsskp p WHERE p.instansi_id = '" + sid_Instansi + "' and p.namapns like'%" + pencarian + "%'";
        //String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id FROM PnsSkp p, jabfungt_bkn s WHERE p.diatasanid = '"+sid_unor+"' AND p.nip_baru <> j.nipbaru";
        //String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id FROM PnsSkp p, struktural_bkn s WHERE p.diatasanid ='"+sid_unor+"'";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryPNS nDBqueryPNS = null;
        //pst.setString(1, sid_unor);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            PnsSkp ipns = new PnsSkp();
            ipns.setIdPns(rs.getString(1));
            ipns.setNipLama(rs.getString(2));
            ipns.setNipBaru(rs.getString(3));
            ipns.setNamaPns(rs.getString(4));
            ipns.setGolonganId(rs.getString(5));
            ipns.setNamaGolru(rs.getString(6));
            ipns.setPangkat(rs.getString(7));
            ipns.setUnorId(rs.getString(8));
            ipns.setNamaUnor(rs.getString(9));
            ipns.setNamaJabatan(rs.getString(10));
            ipns.setDiAtasanId(rs.getString(11));
            ipns.setInstansiId(rs.getString(12));
            ipns.setjnsjbtn_id(rs.getString(13));
            pnsies.add(ipns);
        }
        return pnsies;
    }

    public List<PnsSkp> getDBqueryBawahanByNama(String sid_unor, String pencarian) throws SQLException {

        List<PnsSkp> pnsies = new ArrayList<PnsSkp>();
        //  String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id FROM PnsSkp p WHERE p.diatasanid = '"+sid_unor+"' AND p.nip_baru not in (select s.nippns from jabfungt_bkn s)";
        String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id, p.jenis_jabatan FROM pnsskp p WHERE p.diatasanid = '" + sid_unor + "' and p.namapns like'%" + pencarian + "%'";
        //String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id FROM PnsSkp p, jabfungt_bkn s WHERE p.diatasanid = '"+sid_unor+"' AND p.nip_baru <> j.nipbaru";
        //String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id FROM PnsSkp p, struktural_bkn s WHERE p.diatasanid ='"+sid_unor+"'";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryPNS nDBqueryPNS = null;
        //pst.setString(1, sid_unor);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            PnsSkp ipns = new PnsSkp();
            ipns.setIdPns(rs.getString(1));
            ipns.setNipLama(rs.getString(2));
            ipns.setNipBaru(rs.getString(3));
            ipns.setNamaPns(rs.getString(4));
            ipns.setGolonganId(rs.getString(5));
            ipns.setNamaGolru(rs.getString(6));
            ipns.setPangkat(rs.getString(7));
            ipns.setUnorId(rs.getString(8));
            ipns.setNamaUnor(rs.getString(9));
            ipns.setNamaJabatan(rs.getString(10));
            ipns.setDiAtasanId(rs.getString(11));
            ipns.setInstansiId(rs.getString(12));
            ipns.setjnsjbtn_id(rs.getString(13));
            pnsies.add(ipns);
        }
        return pnsies;
    }

    public List<PnsSkp> getDBqueryBawahanByNIP(String sid_unor, String pencarian) throws SQLException {

        List<PnsSkp> pnsies = new ArrayList<PnsSkp>();
        //  String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id FROM PnsSkp p WHERE p.diatasanid = '"+sid_unor+"' AND p.nip_baru not in (select s.nippns from jabfungt_bkn s)";
        String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id, p.jenis_jabatan FROM pnsskp p WHERE p.diatasanid = '" + sid_unor + "' and p.nip_baru ='" + pencarian + "'";
        //String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id FROM PnsSkp p, jabfungt_bkn s WHERE p.diatasanid = '"+sid_unor+"' AND p.nip_baru <> j.nipbaru";
        //String sql = "SELECT distinct p.idpns, p.nip_lama, p.nip_baru, p.namapns, p.golongan_id, p.namagolru, p.pangkat, p.unorid, p.namaunor, p.namajabatan, p.diatasanid, p.instansi_id FROM PnsSkp p, struktural_bkn s WHERE p.diatasanid ='"+sid_unor+"'";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryPNS nDBqueryPNS = null;
        //pst.setString(1, sid_unor);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            PnsSkp ipns = new PnsSkp();
            ipns.setIdPns(rs.getString(1));
            ipns.setNipLama(rs.getString(2));
            ipns.setNipBaru(rs.getString(3));
            ipns.setNamaPns(rs.getString(4));
            ipns.setGolonganId(rs.getString(5));
            ipns.setNamaGolru(rs.getString(6));
            ipns.setPangkat(rs.getString(7));
            ipns.setUnorId(rs.getString(8));
            ipns.setNamaUnor(rs.getString(9));
            ipns.setNamaJabatan(rs.getString(10));
            ipns.setDiAtasanId(rs.getString(11));
            ipns.setInstansiId(rs.getString(12));
            ipns.setjnsjbtn_id(rs.getString(13));
            pnsies.add(ipns);
        }
        return pnsies;
    }

    //******************************MANAJEMEN USER***********ADMIN ONLY****************************//
    public void updateSimpanLogin(String usernamebaru, String passwordbaru, String kewenangan, String nipbaru) throws SQLException {
        String _nipbaru = nipbaru;
        String _kewenangan = kewenangan;
        String _passwordbaru = passwordbaru;
        String _usernamebaru = usernamebaru;

        String sql = "UPDATE loginweb SET username_login = '" + _usernamebaru + "', password_login = '" + _passwordbaru + "', kewenangan_login = '" + _kewenangan + "' WHERE nippns_login = '" + _nipbaru + "'";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.executeUpdate(sql);
        st.close();

    }

    public void insertSimpanLogin(String usernamebaru, String passwordbaru, String kewenangan, String nipbaru) throws SQLException {
        String _nipbaru = nipbaru;
        String _kewenangan = kewenangan;
        String _passwordbaru = passwordbaru;
        String _usernamebaru = usernamebaru;

        String sql = "INSERT INTO loginweb(username_login, password_login, kewenangan_login, nippns_login) VALUES('" + _usernamebaru + "', '" + _passwordbaru + "', '" + _kewenangan + "', '" + _nipbaru + "')";
        PreparedStatement st = this.conn.prepareStatement(sql);
        st.executeUpdate(sql);
        st.close();

    }

    public loginweb getSudahAdaUser(String sid_pns) throws SQLException {
        String sql = "SELECT username_login, password_login, kewenangan_login, nippns_login FROM loginweb WHERE nippns_login = '" + sid_pns + "' ";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        loginweb ipns = null;
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            ipns = new loginweb();
            ipns.setusername_login(rs.getString(1));
            ipns.setpassword_login(rs.getString(2));
            ipns.setkewenangan_login(rs.getString(3));
            ipns.setnippns_login(rs.getString(4));
        } else {
            System.out.println("rs KOSONG");
        }
        return ipns;
    }
    public List<loginweb> getlistUser(String sid_pns) throws SQLException {
        List<loginweb> listuser = new ArrayList<loginweb>();
        String sql = "SELECT username_login, password_login, kewenangan_login, nippns_login FROM loginweb WHERE nippns_login = '" + sid_pns + "' ";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        loginweb ipns = null;
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            ipns = new loginweb();
            ipns.setusername_login(rs.getString(1));
            ipns.setpassword_login(rs.getString(2));
            ipns.setkewenangan_login(rs.getString(3));
            ipns.setnippns_login(rs.getString(4));
            listuser.add(ipns);
        } 
        return listuser;
    }
}
