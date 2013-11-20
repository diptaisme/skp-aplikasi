/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Image;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;
import javax.imageio.ImageIO;
import servlets.ModelLocatorSKP;

/**
 *
 * @author diptaisme
 * 
 * ini seperti BUSINESS di framework NCSIS **************
 * 
 * 
 */
public class GoIndex {

    public GoIndex() {
    }

    public loginweb getLoginPass(String username, String password) {
        DBConnection dbConn = DBConnection.getInstance();
        loginweb ipns = new loginweb();
        DBqueryLogin dBqueryLogin = new DBqueryLogin(dbConn.getConnection());

        if (username == null) {
            username = "0";
        }
        String _username = username;
        String _password = password;

        try {
            if (!_username.equals("0")) {
                ipns = dBqueryLogin.getDBqueryLoginPass(_username, _password);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return ipns;
    }

    public void getUpdateUnorPns(String nipbaru, String AtasanBaru, String UnorBaru, String NamaUnor, String NamaJabatanBaru) {
        DBConnection dbConn = DBConnection.getInstance();
        PnsSkp ipns = new PnsSkp();
        DBqueryPNS dBqueryPNS = new DBqueryPNS(dbConn.getConnection());

        if (nipbaru == null) {
            nipbaru = "0";
        }
        String nipBaru = nipbaru;

        try {
            if (!nipBaru.equals("0")) {
                dBqueryPNS.getDBqueryUpdateUnorPNS(nipBaru, AtasanBaru, UnorBaru, NamaUnor, NamaJabatanBaru);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }

    }

    public List<unorskp> getCariUnorByInstansi(String snamaUnor, String instansi, String nipbaru) {
        DBConnection dbConn = DBConnection.getInstance();
        List<unorskp> unoriesByCriteria = new ArrayList<unorskp>();
        DBqueryUnor dbqueryUnor = new DBqueryUnor(dbConn.getConnection());

        if (snamaUnor == null) {
            snamaUnor = "0";
        }
        String CariNamaUnor = snamaUnor; //unor baru yang kepilih
        String AtasanUnorBaru = snamaUnor;

        String namaInstansi = instansi;
        String nipBaru = nipbaru;

        try {
            if (!CariNamaUnor.equals("0")) {
                unoriesByCriteria = dbqueryUnor.getDBqueryUpdateUnorAtasan(CariNamaUnor, instansi, nipBaru);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return unoriesByCriteria;
    }

    public loginweb getLoginPassByNip(String nip) {
        DBConnection dbConn = DBConnection.getInstance();
        loginweb ipns = new loginweb();
        DBqueryLogin dBqueryLogin = new DBqueryLogin(dbConn.getConnection());

        if (nip == null) {
            nip = "0";
        }
        String _nip = nip;

        try {
            if (!_nip.equals("0")) {
                ipns = dBqueryLogin.getDBqueryLoginPassByNip(_nip);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return ipns;
    }

    public PnsSkp getPns(String id) {
        DBConnection dbConn = DBConnection.getInstance();
        PnsSkp ipns = new PnsSkp();
        DBqueryPNS dBqueryPNS = new DBqueryPNS(dbConn.getConnection());

        if (id == null) {
            id = "0";
        }
        String nipBaru = id;

        try {
            if (!nipBaru.equals("0")) {
                ipns = dBqueryPNS.getDBqueryPNSId(nipBaru);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return ipns;
    }

    public List<UnorKeTupoksi> getSamaLikeTupoksi(String cariKriteria) {
        DBConnection dbConn = DBConnection.getInstance();
        List<UnorKeTupoksi> unorKeTupoksi = new ArrayList<UnorKeTupoksi>();
        DBqueryUnorKeTupoksi dbqueryCariNipTupoksiDiIsi4Faktor = new DBqueryUnorKeTupoksi(dbConn.getConnection());

        if (cariKriteria == null) {
            cariKriteria = "0";
        }
        String _cariKriteria = cariKriteria;
        String _cariKriterias = cariKriteria;

        try {
            if (!cariKriteria.equals("0")) {
                unorKeTupoksi = dbqueryCariNipTupoksiDiIsi4Faktor.getDBqueryKeTupoksiIdAll(_cariKriterias);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return unorKeTupoksi;
    }

    public String getdeleteUser(String idTambahan) {
        DBConnection dbConn = DBConnection.getInstance();
        //  isi4faktor Isi4faktor = new isi4faktor();

        String berhasil = "Data Berhasil di Hapus";
        DBqueryLogin dBqueryLogin = new DBqueryLogin(dbConn.getConnection());
        if (idTambahan == null) {
            idTambahan = "0";
        }

        String _idTambahan = idTambahan;

        try {
            if (!_idTambahan.equals("0")) {
                dBqueryLogin.hapusUser(_idTambahan);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return berhasil;
    }

    public String getInsertPns(String idTambahan) throws Exception {

        String berhasil = "Data Berhasil di Update";
        bacaexcel2 bacaExcel2 = new bacaexcel2();
        bacaExcel2.main2();
        try {
            berhasil = "Data Berhasil di Update";
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return berhasil;
    }

    public String MaksimumTupoksi() {
        DBConnection dbConn = DBConnection.getInstance();
        String _max = null;
        _max = "X";
        int _imax;
        DBqueryTupoksi dBqueryTupoksi = new DBqueryTupoksi(dbConn.getConnection());



        try {
            if (!_max.equals("0")) {
                _max = dBqueryTupoksi.makTupoksiOperator();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return _max;
    }

    public unorskp getIdUnorskp(String idUnor) {
        DBConnection dbConn = DBConnection.getInstance();
        unorskp unorSkp = new unorskp();
        DBqueryUnor dBqueryUnor = new DBqueryUnor(dbConn.getConnection());
        if (idUnor == null) {
            idUnor = "0";
        }
        String _unor = idUnor;

        try {
            if (!_unor.equals("0")) {
                unorSkp = dBqueryUnor.getDBqueryUnorId(idUnor);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return unorSkp;
    }

    public tupoksi_lama getIdtupoksi(String idTupoksi) {
        DBConnection dbConn = DBConnection.getInstance();
        tupoksi_lama itupoksi = new tupoksi_lama();
        DBqueryTupoksi dBqueryTupoksi = new DBqueryTupoksi(dbConn.getConnection());

        if (idTupoksi == null) {
            idTupoksi = "0";
        }
        String nipBaru = idTupoksi;

        try {
            if (!nipBaru.equals("0")) {
                itupoksi = dBqueryTupoksi.getDBqueryTupoksiId(idTupoksi);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return itupoksi;
    }

    public tupoksi getIdtupoksiAll(String idTupoksi) {
        DBConnection dbConn = DBConnection.getInstance();
        tupoksi itupoksi = new tupoksi();
        DBqueryTupoksi dBqueryTupoksi = new DBqueryTupoksi(dbConn.getConnection());

        if (idTupoksi == null) {
            idTupoksi = "0";
        }
        String _idTupoksi = idTupoksi;

        try {
            if (!_idTupoksi.equals("0")) {
                itupoksi = dBqueryTupoksi.getDBqueryAllTupoksiId(idTupoksi);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return itupoksi;
    }

    public TugasTambahan getTugasTambahan(String idTambahan) {
        DBConnection dbConn = DBConnection.getInstance();
        TugasTambahan tugasTambahan = new TugasTambahan();
        DbqueryTugasTambahan dbqueryTugasTambahan = new DbqueryTugasTambahan(dbConn.getConnection());

        if (idTambahan == null) {
            idTambahan = "0";
        }
        String _idTambahan = idTambahan;

        try {
            if (!_idTambahan.equals("0")) {
                tugasTambahan = dbqueryTugasTambahan.getDBqueryTugasTambahan(_idTambahan);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return tugasTambahan;
    }

    public TugasTambahan getTugasTambahanNotList(String idTambahan) {
        DBConnection dbConn = DBConnection.getInstance();
        TugasTambahan tugasTambahan = new TugasTambahan();
        DbqueryTugasTambahan dbqueryTugasTambahan = new DbqueryTugasTambahan(dbConn.getConnection());

        if (idTambahan == null) {
            idTambahan = "0";
        }
        String _idTambahan = idTambahan;

        try {
            if (!_idTambahan.equals("0")) {
                tugasTambahan = dbqueryTugasTambahan.getDBqueryTugasTambahanAllnotList(_idTambahan);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return tugasTambahan;
    }

    public nilaiprestasikerja getNilaiPrestasiKerjaAllNotList(String idTambahan) {
        DBConnection dbConn = DBConnection.getInstance();
        nilaiprestasikerja tugasTambahan = new nilaiprestasikerja();
        DbqueryTugasTambahan dbqueryTugasTambahan = new DbqueryTugasTambahan(dbConn.getConnection());

        if (idTambahan == null) {
            idTambahan = "0";
        }
        String _idTambahan = idTambahan;

        try {
            if (!_idTambahan.equals("0")) {
                tugasTambahan = dbqueryTugasTambahan.getDBqueryNPKAllnotList(_idTambahan);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return tugasTambahan;
    }

    public nilaiprestasikerja getNilaiPrestasiKerjaAllNotList_session(String idTambahan, String thn_sesion, String idUnorNilai) {
        DBConnection dbConn = DBConnection.getInstance();
        nilaiprestasikerja tugasTambahan = new nilaiprestasikerja();
        DbqueryTugasTambahan dbqueryTugasTambahan = new DbqueryTugasTambahan(dbConn.getConnection());

        if (idTambahan == null) {
            idTambahan = "0";
        }
        String _idTambahan = idTambahan;

        try {
            if (!_idTambahan.equals("0")) {
                //  tugasTambahan=dbqueryTugasTambahan.getDBqueryNPKAllnotList(_idTambahan
                tugasTambahan = dbqueryTugasTambahan.getDBqueryNPKAllnotList_session(idTambahan, thn_sesion, idUnorNilai);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return tugasTambahan;
    }

    public nilaiPerilaku getPrilaku(String nippri) {
        DBConnection dbConn = DBConnection.getInstance();
        nilaiPerilaku pri = new nilaiPerilaku();
        DBqueryPerilaku dBqueryPerilaku = new DBqueryPerilaku(dbConn.getConnection());

        if (nippri == null) {
            nippri = "0";
        }
        String _nippri = nippri;

        try {
            if (!_nippri.equals("0")) {
                pri = dBqueryPerilaku.getDBqueryPerilaku(_nippri);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return pri;
    }

    public PnsSkp getLihatNipNama(String nippri) {
        DBConnection dbConn = DBConnection.getInstance();
        PnsSkp pri = new PnsSkp();
        DBqueryPerilaku dBqueryPerilaku = new DBqueryPerilaku(dbConn.getConnection());

        if (nippri == null) {
            nippri = "0";
        }
        String _nippri = nippri;

        try {
            if (!_nippri.equals("0")) {
                pri = dBqueryPerilaku.getDbqueryLihatNipNama(_nippri);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return pri;
    }

    public List<TugasTambahan> getTugasTambahanList(String idNip) {
        DBConnection dbConn = DBConnection.getInstance();
        List<TugasTambahan> tugasTambahan = new ArrayList<TugasTambahan>();
        DbqueryTugasTambahan dbqueryTugasTambahan = new DbqueryTugasTambahan(dbConn.getConnection());

        if (idNip == null && idNip == null) {
            idNip = "0";
        }
        String _idNip = idNip;

        try {
            if (!_idNip.equals("0")) {
                tugasTambahan = dbqueryTugasTambahan.getDBqueryTugasTambahanlist(_idNip);
                //tugasTambahan=dbqueryTugasTambahan.getDBqueryTugasTambahanAlllist(_idNip);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return tugasTambahan;
    }

    public List<TugasTambahan> getTugasTambahanListList(String idNip) {
        DBConnection dbConn = DBConnection.getInstance();
        List<TugasTambahan> tugasTambahan = new ArrayList<TugasTambahan>();
        DbqueryTugasTambahan dbqueryTugasTambahan = new DbqueryTugasTambahan(dbConn.getConnection());

        if (idNip == null && idNip == null) {
            idNip = "0";
        }
        String _idNip = idNip;

        try {
            if (!_idNip.equals("0")) {
                tugasTambahan = dbqueryTugasTambahan.getDBqueryTugasTambahanList(_idNip);
                //tugasTambahan=dbqueryTugasTambahan.getDBqueryTugasTambahanAlllist(_idNip);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return tugasTambahan;
    }

    public List<TugasTambahan> getTugasTambahanAllList(String idNip) {
        DBConnection dbConn = DBConnection.getInstance();
        List<TugasTambahan> tugasTambahan = new ArrayList<TugasTambahan>();
        DbqueryTugasTambahan dbqueryTugasTambahan = new DbqueryTugasTambahan(dbConn.getConnection());

        if (idNip == null && idNip == null) {
            idNip = "0";
        }
        String _idNip = idNip;

        try {
            if (!_idNip.equals("0")) {
                tugasTambahan = dbqueryTugasTambahan.getDBqueryTugasTambahanAlllist(_idNip);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return tugasTambahan;
    }

    public List<nilaiPerilaku> getPerilakuAllList(String idNip) {
        DBConnection dbConn = DBConnection.getInstance();
        List<nilaiPerilaku> prilaku = new ArrayList<nilaiPerilaku>();
        DBqueryPerilaku dBqueryPerilaku = new DBqueryPerilaku(dbConn.getConnection());

        if (idNip == null && idNip == null) {
            idNip = "0";
        }
        String _idNip = idNip;

        try {
            if (!_idNip.equals("0")) {
                prilaku = dBqueryPerilaku.getDbQueryPerilakuAllList(_idNip);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return prilaku;
    }

    public List<PnsSkp> getDBqueryPNSInstansiList(String sid_Instansi) {
        DBConnection dbConn = DBConnection.getInstance();
        List<PnsSkp> pnsskps = new ArrayList<PnsSkp>();
        DBqueryPNS dBqueryPNS = new DBqueryPNS(dbConn.getConnection());

        if (sid_Instansi == null && sid_Instansi == null) {
            sid_Instansi = "0";
        }
        String _sid_Instansi = sid_Instansi;

        try {
            if (!_sid_Instansi.equals("0")) {
                pnsskps = dBqueryPNS.getDBqueryPNSInstansi(_sid_Instansi);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return pnsskps;
    }

    public List<PnsSkp> getDBqueryPNSInstansiNamaAtasanList(String instansiAtasant, String carinamapnsatasan) {
        DBConnection dbConn = DBConnection.getInstance();
        List<PnsSkp> pnsskps = new ArrayList<PnsSkp>();
        DBqueryPNS dBqueryPNS = new DBqueryPNS(dbConn.getConnection());

        if (carinamapnsatasan == null && carinamapnsatasan == null) {
            carinamapnsatasan = "0";
        }
        String _carinamapnsatasan = carinamapnsatasan;

        try {
            if (!_carinamapnsatasan.equals("0")) {
                pnsskps = dBqueryPNS.getDBqueryPNSInstansiNamaAtasan(instansiAtasant, _carinamapnsatasan);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return pnsskps;
    }

    public List<PnsSkp> getDBqueryInstansinNamaPnsList(String sid_Instansi, String pencarian) {
        DBConnection dbConn = DBConnection.getInstance();
        List<PnsSkp> pnsskps = new ArrayList<PnsSkp>();
        DBqueryPNS dBqueryPNS = new DBqueryPNS(dbConn.getConnection());

        if (sid_Instansi == null && sid_Instansi == null) {
            sid_Instansi = "0";
        }
        String _sid_Instansi = sid_Instansi;

        try {
            if (!_sid_Instansi.equals("0")) {
                pnsskps = dBqueryPNS.getDBqueryInstansinNamaPns(_sid_Instansi, pencarian);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return pnsskps;
    }

    public List<TugasTambahan> getKreatifitasList(String idNip) {
        DBConnection dbConn = DBConnection.getInstance();
        List<TugasTambahan> tugasTambahan = new ArrayList<TugasTambahan>();
        DbqueryTugasTambahan dbqueryTugasTambahan = new DbqueryTugasTambahan(dbConn.getConnection());

        if (idNip == null && idNip == null) {
            idNip = "0";
        }
        String _idNip = idNip;

        try {
            if (!_idNip.equals("0")) {
                tugasTambahan = dbqueryTugasTambahan.getDBqueryKreatifitaslist(_idNip);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return tugasTambahan;
    }

    public TugasTambahan getKreatifitasSatoe(String idNip, String idTambahan) {
        DBConnection dbConn = DBConnection.getInstance();
        TugasTambahan tugasTambahan = new TugasTambahan();
        DbqueryTugasTambahan dbqueryTugasTambahan = new DbqueryTugasTambahan(dbConn.getConnection());

        if (idNip == null && idNip == null) {
            idNip = "0";
        }
        String _idNip = idNip;
        String _idTambahan = idTambahan;

        try {
            if (!_idNip.equals("0")) {
                tugasTambahan = dbqueryTugasTambahan.getDBquerySatoeKreatifitas(_idNip, _idTambahan);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return tugasTambahan;
    }

    public String getsimpanTugasTambahan(String maks, String idTambahan, String jenisTambahan, String nama, String TmtPeriode, String nilai1, String nilai2, String idNip, String hitungtambahan, String nilaitambahan) {
        DBConnection dbConn = DBConnection.getInstance();
        //  isi4faktor Isi4faktor = new isi4faktor();

        String berhasil = "Data Berhasil di Update";
        DbqueryTugasTambahan dbqueryTugasTambahan = new DbqueryTugasTambahan(dbConn.getConnection());
        if (idNip == null) {
            idNip = "0";
        }

        String _idNip = idNip;
        String _idTambahan = idTambahan;
        String _jenisTambahan = jenisTambahan;
        String _nama = nama;
        String _TmtPeriode = TmtPeriode;
        String _nilai1 = nilai1;
        String _nilai2 = nilai2;
        String _hitungtambahan = hitungtambahan;
        String _nilaitambahan = nilaitambahan;

        try {
            if (!_idNip.equals("0")) {
                dbqueryTugasTambahan.UpdateTugasTambahan(maks, _idTambahan, _jenisTambahan, _nama, _TmtPeriode, _nilai1, _nilai2, _idNip, _hitungtambahan, _nilaitambahan);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return berhasil;
    }

    public String getsimpanTugasTambahanKoef(String idTamb, String koef) {
        DBConnection dbConn = DBConnection.getInstance();
        //  isi4faktor Isi4faktor = new isi4faktor();

        String berhasil = "Data Berhasil di Update";
        DbqueryTugasTambahan dbqueryTugasTambahan = new DbqueryTugasTambahan(dbConn.getConnection());
        if (idTamb == null) {
            idTamb = "0";
        }

        String _idTamb = idTamb;
        String _koef = koef;

        try {
            if (!_idTamb.equals("0")) {
                dbqueryTugasTambahan.UpdateTugasTambahanKoef(_idTamb, _koef);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return berhasil;
    }

    public String getdeleteTambahan(String idTambahan) {
        DBConnection dbConn = DBConnection.getInstance();
        //  isi4faktor Isi4faktor = new isi4faktor();

        String berhasil = "Data Berhasil di Hapus";
        DbqueryTugasTambahan dbqueryTugasTambahan = new DbqueryTugasTambahan(dbConn.getConnection());
        if (idTambahan == null) {
            idTambahan = "0";
        }

        String _idTambahan = idTambahan;

        try {
            if (!_idTambahan.equals("0")) {
                dbqueryTugasTambahan.DeleteTugasTambahan(_idTambahan);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return berhasil;
    }

    public String getHapusPerilaku(String nipPerilaku) {
        DBConnection dbConn = DBConnection.getInstance();
        //  isi4faktor Isi4faktor = new isi4faktor();

        String berhasil = "Data Berhasil di Hapus";
        DBqueryPerilaku dBqueryPerilaku = new DBqueryPerilaku(dbConn.getConnection());
        if (nipPerilaku == null) {
            nipPerilaku = "0";
        }

        String _nipPerilaku = nipPerilaku;

        try {
            if (!_nipPerilaku.equals("0")) {
                dBqueryPerilaku.DeletePerilaku(_nipPerilaku);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return berhasil;
    }

    public String getHapusRealita(String _id_tupoksi, String _nip) {
        DBConnection dbConn = DBConnection.getInstance();
        //  isi4faktor Isi4faktor = new isi4faktor();

        String berhasil = "Data Berhasil di Hapus";
        DBqueryTupoksiKeIsi4Faktor dBqueryTupoksiKeIsi4Faktor = new DBqueryTupoksiKeIsi4Faktor(dbConn.getConnection());
        if (_id_tupoksi == null) {
            _id_tupoksi = "0";
        }

        String t_id_tupoksi = _id_tupoksi;

        try {
            if (!t_id_tupoksi.equals("0")) {
                dBqueryTupoksiKeIsi4Faktor.hapusTupoksiKeIsi4Faktor(t_id_tupoksi, _nip);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return berhasil;
    }

    public String getInsertTugasTambahan(String maks, String idTambahan, String jenisTambahan, String nama, String TmtPeriode, String nilai1, String nilai2, String idNip, String hitungtambahan, String nilaitambahan, String koef_kreatifitas) {
        DBConnection dbConn = DBConnection.getInstance();

        String berhasil = "Data Berhasil di Insert";
        DbqueryTugasTambahan dbqueryTugasTambahan = new DbqueryTugasTambahan(dbConn.getConnection());
        String maksHasil = null;

        if (maks == null) {
            maks = "0";
        }
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
        String _koef_kreatifitas = koef_kreatifitas;

        try {
            if (!_idNip.equals("0")) {
                maksHasil = dbqueryTugasTambahan.makIsTugasTambahanl();
                dbqueryTugasTambahan.InsertTugasTambahanl(maksHasil, _idTambahan, _jenisTambahan, _nama, _TmtPeriode, _nilai1, _nilai2, _idNip, _hitungtambahan, _nilaitambahan, _koef_kreatifitas);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return maksHasil;
    }

    public String HitungTugasTambahan(String idTambahan, String nippns) {
        DBConnection dbConn = DBConnection.getInstance();
        String berhasil = "Data Berhasil di Hitung";
        TugasTambahan tugasTambahan = new TugasTambahan();
        DbqueryTugasTambahan dbqueryTugasTambahan = new DbqueryTugasTambahan(dbConn.getConnection());

        if (idTambahan == null) {
            idTambahan = "0";
        }

        String _idTambahan = idTambahan;
        String _nippns = nippns;

        try {
            if (!_idTambahan.equals("0")) {
                tugasTambahan = dbqueryTugasTambahan.getDBqueryHitungTugasTambahan(_idTambahan, _nippns);
                String _target = tugasTambahan.getNilai1();
                String _realisasi = tugasTambahan.getNilai2();
                String _jenisTambahan = tugasTambahan.getJenisTambahan();

                if ("Tugas Tambahan".equals(_jenisTambahan)) {
                    int i_target = Integer.parseInt(_target);
                    int i_realisasi = Integer.parseInt(_realisasi);
                    int hitung = (i_target / i_realisasi) * 1; //10 * 10% * 
                    System.out.println("HITUNG tambahan = " + hitung);
                    int nilai = hitung;
                    String s_hitung = Integer.toString(hitung);
                    String s_nilai = Integer.toString(nilai);

                    dbqueryTugasTambahan.UpdateTugasTambahanHitungan(_idTambahan, _nippns, s_nilai, s_hitung);
                } else if ("Keterampilan".equals(_jenisTambahan)) {
                    int i_target = Integer.parseInt(_target);
                    int i_realisasi = Integer.parseInt(_realisasi);
                    //int hitung =  (i_target/i_realisasi)*9; //30 * 30% * ==> PERATURAN LAMA dengan NILAI = 9
                    int hitung = (i_target / i_realisasi) * 1;
                    System.out.println("HITUNG tambahan = " + hitung);
                    int nilai = hitung;
                    String s_hitung = Integer.toString(hitung);
                    String s_nilai = Integer.toString(nilai);

                    dbqueryTugasTambahan.UpdateTugasTambahanHitungan(_idTambahan, _nippns, s_nilai, s_hitung);
                } else {
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }

        return berhasil;
    }

    public String HitungTugasTambahanKoef(String idTambahan, String nip) {
        DBConnection dbConn = DBConnection.getInstance();
        String berhasil = "Data Berhasil di Hitung";
        TugasTambahan tugasTambahan = new TugasTambahan();
        DbqueryTugasTambahan dbqueryTugasTambahan = new DbqueryTugasTambahan(dbConn.getConnection());

        if (idTambahan == null) {
            idTambahan = "0";
        }

        String _idTambahan = idTambahan;
        String _nip = nip;

        try {
//************************PP LAMA --> menggunakan koefisien 10,20,30****************************************//
//            if(!_idTambahan.equals("0"))
//            {
//                tugasTambahan=dbqueryTugasTambahan.getDBqueryHitungTugasTambahan(_idTambahan, _nip);
//                String _target = tugasTambahan.getNilai1();
//                String _realisasi = tugasTambahan.getNilai2();
//                String _jenisTambahan = tugasTambahan.getJenisTambahan();
//                String _koef = tugasTambahan.getKoef_kreatifitas();
//                
//                if ("Keterampilan".equals(_jenisTambahan))
//                {
//                    int i_target = Integer.parseInt(_target);
//                    int i_realisasi = Integer.parseInt(_realisasi);
//                    int i_koef = Integer.parseInt(_koef);
//                    
//                    double d_hitung =  (i_target/i_realisasi)*i_koef*0.3; //(RO/TO) * koef * 30% 
//
//                    String s_hitung = Double.toString(d_hitung);
//                    System.out.println(" NILAI KOEF KETRAMPILAN = "+s_hitung);
//                    
//                    dbqueryTugasTambahan.UpdateTugasTambahanHitungan(_idTambahan, _nip, s_hitung, s_hitung);
//                }
//                else
//                {}
//                
//            }

//************************PP BARU --> menggunakan koefisien : unker = 5, instansi = 15, nasional 20*****************//            
            String s_hitung = null;
            if (!_idTambahan.equals("0")) {
                tugasTambahan = dbqueryTugasTambahan.getDBqueryHitungTugasTambahan(_idTambahan, _nip);
                String _target = tugasTambahan.getNilai1();
                //String _realisasi = tugasTambahan.getNilai2();
                String _jenisTambahan = tugasTambahan.getJenisTambahan();
                String _koef = tugasTambahan.getKoef_kreatifitas();
                String _koefn;
                if ("Unit Kerja".equals(_koef)) {
                    _koefn = "10";
                } else if ("Instansi".equals(_koef)) {
                    _koefn = "20";
                } else if ("Nasional".equals(_koef)) {
                    _koefn = "30";
                } else if ("Tidak Valid".equals(_koef)) {
                    _koefn = "40";
                } else {
                    _koefn = "-";
                }

                if ("Keterampilan".equals(_jenisTambahan)) {
                    //int i_target = Integer.parseInt(_target);
                    //int i_realisasi = Integer.parseInt(_realisasi);
                    //int i_koef = Integer.parseInt(_koef);
                    if ("10".equals(_koefn)) {
                        //Unit Kerja
                        s_hitung = "3";
                    } else if ("20".equals(_koefn)) {
                        //Instansi
                        s_hitung = "6";
                    } else if ("30".equals(_koefn)) {
                        //Nasional
                        s_hitung = "12";
                    } else if ("40".equals(_koefn)) {
                        //TIDAK VALID
                        s_hitung = "0";
                    } else {
                    }
                    //double d_hitung =  (i_target/i_realisasi)*i_koef*0.3; //(RO/TO) * koef * 30% 

                    //String s_hitung = Double.toString(d_hitung);
                    //System.out.println(" NILAI KOEF KETRAMPILAN = "+s_hitung);

                    dbqueryTugasTambahan.UpdateTugasTambahanHitungan(_idTambahan, _nip, s_hitung, s_hitung);



                    dbqueryTugasTambahan.kreafSimpanKeNilaiPrestasi(_nip);


                } else {
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }

        return berhasil;
    }

    public realisasi getIdRealitas(String idTupoksi, String nipRealita, String idTupoksiRealita) {
        DBConnection dbConn = DBConnection.getInstance();
        realisasi Realisasi = new realisasi();
        DBqueryRealisasi dBqueryRealisasi = new DBqueryRealisasi(dbConn.getConnection());

        if (nipRealita == null && idTupoksi == null && idTupoksiRealita == null) {
            nipRealita = "0";
        }
        String nipBaru = nipRealita;

        try {
            if (!nipBaru.equals("0")) {
                Realisasi = dBqueryRealisasi.getDBqueryRealisasi(idTupoksi, nipBaru, idTupoksiRealita);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return Realisasi;
    }

    public RealisasiIsi4faktorTupoksi getFormatPenghitunganIsi4FaktorBusiness(String idTupoksi, String nipRealita) {
        DBConnection dbConn = DBConnection.getInstance();
        RealisasiIsi4faktorTupoksi Realisasi = new RealisasiIsi4faktorTupoksi();
        DBqueryRealisasi dBqueryRealisasi = new DBqueryRealisasi(dbConn.getConnection());

        if (nipRealita == null && idTupoksi == null) {
            nipRealita = "0";
        }
        String nipBaru = nipRealita;

        try {
            if (!nipBaru.equals("0")) {
                Realisasi = dBqueryRealisasi.getFormatPenghitunganIsi4FaktorDao(idTupoksi, nipBaru);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return Realisasi;
    }

    public List<TugasTambahan> getNilaiTugasTambahanList(String idNip) {
        DBConnection dbConn = DBConnection.getInstance();
        List<TugasTambahan> tugasTambahan = new ArrayList<TugasTambahan>();
        DbqueryTugasTambahan dbqueryTugasTambahan = new DbqueryTugasTambahan(dbConn.getConnection());

        if (idNip == null && idNip == null) {
            idNip = "0";
        }
        String _idNip = idNip;

        try {
            if (!_idNip.equals("0")) {
                tugasTambahan = dbqueryTugasTambahan.getDBqueryTugasTambahanOnelist(_idNip);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return tugasTambahan;
    }

    public List<TugasTambahan> getTugasTambahanMakList(String idNip) {
        DBConnection dbConn = DBConnection.getInstance();
        List<TugasTambahan> tugasTambahan = new ArrayList<TugasTambahan>();
        DbqueryTugasTambahan dbqueryTugasTambahan = new DbqueryTugasTambahan(dbConn.getConnection());

        if (idNip == null && idNip == null) {
            idNip = "0";
        }
        String _idNip = idNip;

        try {
            if (!_idNip.equals("0")) {
                tugasTambahan = dbqueryTugasTambahan.getDBqueryTugasTambahanMaxlist(_idNip);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return tugasTambahan;
    }

    public RealisasiIsi4faktorTupoksi getIsiRealisasi4FaktorDao(String idTupoksi, String nipRealita, String idTupoksiRealita) {
        DBConnection dbConn = DBConnection.getInstance();
        RealisasiIsi4faktorTupoksi Realisasi = new RealisasiIsi4faktorTupoksi();
        DBqueryRealisasi dBqueryRealisasi = new DBqueryRealisasi(dbConn.getConnection());

        if (nipRealita == null && idTupoksi == null && idTupoksiRealita == null) {
            nipRealita = "0";
        }
        String nipBaru = nipRealita;

        try {
            if (!nipBaru.equals("0")) {
                Realisasi = dBqueryRealisasi.getIsiRealisasi4Faktor(idTupoksi, nipBaru, idTupoksiRealita);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return Realisasi;
    }

    //--------------------------
    public List<tupoksi> getTupoksiAllJabatan(String sId_Unor, String sId_Instansi, String IdJabatan, String Jenis) {
        DBConnection dbConn = DBConnection.getInstance();
        // tupoksi itupoksi = new tupoksi();
        List<tupoksi> itupoksi = new ArrayList<tupoksi>();
        DBqueryTupoksi dBqueryTupoksi = new DBqueryTupoksi(dbConn.getConnection());

        if (sId_Unor == null && sId_Instansi == null) {
            sId_Unor = "0";
        }
        String _idUnor = sId_Unor;
        String _idInstansi = sId_Instansi;
        String _idJabatan = IdJabatan;
        String jenis = Jenis;
        try {
            if (jenis.equals("1")) {
                itupoksi = dBqueryTupoksi.getDBqueryTupoksiStruktural(sId_Unor, sId_Instansi);
            } else if (jenis.equals("2") || jenis.equals("4")) {
                itupoksi = dBqueryTupoksi.getDBqueryTupoksiFungsional(IdJabatan);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return itupoksi;
    }

    public List<tupoksi_lama> getIdtupoksiUnor(String sId_Unor, String sId_Instansi) {
        DBConnection dbConn = DBConnection.getInstance();
        // tupoksi itupoksi = new tupoksi();
        List<tupoksi_lama> itupoksi = new ArrayList<tupoksi_lama>();
        DBqueryTupoksi dBqueryTupoksi = new DBqueryTupoksi(dbConn.getConnection());

        if (sId_Unor == null && sId_Instansi == null) {
            sId_Unor = "0";
        }
        String _idUnor = sId_Unor;
        String _idInstansi = sId_Instansi;
        try {
            if (!_idUnor.equals("0")) {
                itupoksi = dBqueryTupoksi.getDBqueryTupoksi(sId_Unor, sId_Instansi);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return itupoksi;
    }
    //--------------------------

    public PnsSkp getUnorAtasan(String unorId) {
        DBConnection dbConn = DBConnection.getInstance();
        PnsSkp ipns = new PnsSkp();

        DBqueryPNS dBqueryPNS = new DBqueryPNS(dbConn.getConnection());
        if (unorId == null) {
            unorId = "0";
        }
        String UnorAtasan = unorId;

        try {
            if (!UnorAtasan.equals("0")) {
                ipns = dBqueryPNS.getDBqueryAtasanId(UnorAtasan);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return ipns;
    }

    public PnsSkp getUnorAtasanSama(String unorId) {
        DBConnection dbConn = DBConnection.getInstance();
        PnsSkp ipns = new PnsSkp();

        DBqueryPNS dBqueryPNS = new DBqueryPNS(dbConn.getConnection());
        if (unorId == null) {
            unorId = "0";
        }
        String UnorAtasan = unorId;

        try {
            if (!UnorAtasan.equals("0")) {
                ipns = dBqueryPNS.getDBqueryAtasanIdSama(UnorAtasan);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return ipns;
    }

    public List<TupoksiKeIsi4Faktor> getTukesi(String unorId, String instansiId, String nipPns) {
        //KONEKSi
        DBConnection dbConn = DBConnection.getInstance();

        //DOMAIN
        List<TupoksiKeIsi4Faktor> tukesi = new ArrayList<TupoksiKeIsi4Faktor>();

        //DAO
        DBqueryTupoksiKeIsi4Faktor dbQueryTukesi = new DBqueryTupoksiKeIsi4Faktor(dbConn.getConnection());


        if (unorId == null || instansiId == null || nipPns == null) {
            unorId = "0";
            instansiId = "0";
            nipPns = "0";
        }
        String UnorPns = unorId;
        String InstansiPns = instansiId;
        String NipPns = nipPns;

        try {
            if (!UnorPns.equals("0")) {
                // tukesi=dbQueryTukesi.getDBqueryTupoksiKeIsi4Faktor(UnorPns,InstansiPns,NipPns);
                tukesi = dbQueryTukesi.getDBqueryTupoksiKeIsi4Faktor2(UnorPns, InstansiPns, NipPns);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return tukesi;
    }

    public List<TupoksiKeIsi4Faktor> getTukesiSession(String unorId, String instansiId, String nipPns, String _pilih_session) {
        //KONEKSi
        DBConnection dbConn = DBConnection.getInstance();

        //DOMAIN
        List<TupoksiKeIsi4Faktor> tukesi = new ArrayList<TupoksiKeIsi4Faktor>();

        //DAO
        DBqueryTupoksiKeIsi4Faktor dbQueryTukesi = new DBqueryTupoksiKeIsi4Faktor(dbConn.getConnection());


        if (unorId == null || instansiId == null || nipPns == null) {
            unorId = "0";
            instansiId = "0";
            nipPns = "0";
        }
        String UnorPns = unorId;
        String InstansiPns = instansiId;
        String NipPns = nipPns;

        try {
            if (!UnorPns.equals("0")) {
                // tukesi=dbQueryTukesi.getDBqueryTupoksiKeIsi4Faktor(UnorPns,InstansiPns,NipPns);
                tukesi = dbQueryTukesi.getDBqueryTupoksiKeIsi4FaktorSesion(UnorPns, InstansiPns, NipPns, _pilih_session);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return tukesi;
    }

    public List<tupoksi> getTukesiPerJenisJabatan(String unorId, String instansiId, String nipPns, String jenis, String Jabatan) {
        //KONEKSi
        DBConnection dbConn = DBConnection.getInstance();

        //DOMAIN
        List<tupoksi> tukesi = new ArrayList<tupoksi>();

        //DAO
        DBqueryTupoksiKeIsi4Faktor dbQueryTukesi = new DBqueryTupoksiKeIsi4Faktor(dbConn.getConnection());


        if (unorId == null || instansiId == null || nipPns == null) {
            unorId = "0";
            instansiId = "0";
            nipPns = "0";
            jenis = "0";
            Jabatan = "0";
        }
        String UnorPns = unorId;
        String InstansiPns = instansiId;
        String NipPns = nipPns;
        String Jenis = jenis;
        String JabId = Jabatan;

        try {
            if (Jenis.equals("1")) {
                tukesi = dbQueryTukesi.getDBqueryTupoksiStruktural(UnorPns, InstansiPns, NipPns);
            } else {
                tukesi = dbQueryTukesi.getDBqueryTupoksiFungsional(JabId);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return tukesi;
    }

    public List<TupoksiKeIsi4Faktor> getTukesiNonUnor(String unorId, String instansiId, String nipPns) {
        //KONEKSi
        DBConnection dbConn = DBConnection.getInstance();

        //DOMAIN
        List<TupoksiKeIsi4Faktor> tukesi = new ArrayList<TupoksiKeIsi4Faktor>();

        //DAO
        DBqueryTupoksiKeIsi4Faktor dbQueryTukesi = new DBqueryTupoksiKeIsi4Faktor(dbConn.getConnection());


        if (unorId == null || instansiId == null || nipPns == null) {
            unorId = "0";
            instansiId = "0";
            nipPns = "0";
        }
        String UnorPns = unorId;
        String InstansiPns = instansiId;
        String NipPns = nipPns;

        try {
            if (!UnorPns.equals("0")) {
                tukesi = dbQueryTukesi.getDBqueryTupoksiKeIsi4FaktornonUnor(UnorPns, InstansiPns, NipPns);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return tukesi;
    }

    //public List<RealisasiIsi4faktorTupoksi> getRealkesi(String sidisi4faktor)
    public List<RealisasiIsi4faktorTupoksi> getRealkesiSession(String unorIdPns, String snippns, String _pilih_session) {
        //KONEKSi
        DBConnection dbConn = DBConnection.getInstance();

        //DOMAIN
        List<RealisasiIsi4faktorTupoksi> Realkesi = new ArrayList<RealisasiIsi4faktorTupoksi>();

        //DAO
        DBqueryRealisasiIsi4faktorTupoksi dbQueryrealkesi = new DBqueryRealisasiIsi4faktorTupoksi(dbConn.getConnection());


        if (snippns == null) {
            snippns = "0";
        }

        String _snippns = snippns;



        try {
            if (!_snippns.equals("0")) {
                Realkesi = dbQueryrealkesi.getDBqueryRealisasiIsi4faktorTupoksiSession(unorIdPns, _snippns, _pilih_session);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return Realkesi;
    }

    public List<RealisasiIsi4faktorTupoksi> getRealkesi(String snippns) {
        //KONEKSi
        DBConnection dbConn = DBConnection.getInstance();

        //DOMAIN
        List<RealisasiIsi4faktorTupoksi> Realkesi = new ArrayList<RealisasiIsi4faktorTupoksi>();

        //DAO
        DBqueryRealisasiIsi4faktorTupoksi dbQueryrealkesi = new DBqueryRealisasiIsi4faktorTupoksi(dbConn.getConnection());


        if (snippns == null) {
            snippns = "0";
        }

        String _snippns = snippns;



        try {
            if (!_snippns.equals("0")) {
                Realkesi = dbQueryrealkesi.getDBqueryRealisasiIsi4faktorTupoksi(_snippns);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return Realkesi;
    }

    public List<RealisasiIsi4faktorTupoksiHitung> getRealkesiHitung(String snippns) {
        //KONEKSi
        DBConnection dbConn = DBConnection.getInstance();

        //DOMAIN
        List<RealisasiIsi4faktorTupoksiHitung> Realkesi = new ArrayList<RealisasiIsi4faktorTupoksiHitung>();

        //DAO
        DbqueryTugasTambahan dbQueryrealkesiH = new DbqueryTugasTambahan(dbConn.getConnection());


        if (snippns == null) {
            snippns = "0";
        }

        String _snippns = snippns;



        try {
            if (!_snippns.equals("0")) {
                Realkesi = dbQueryrealkesiH.getDBqueryRealisasiIsi4faktorTupoksiTambahan(_snippns);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return Realkesi;
    }

    public TupoksiKeIsi4Faktor getTupoksi(String inputTupoksi) {
        DBConnection dbConn = DBConnection.getInstance();
        TupoksiKeIsi4Faktor TKI4F = new TupoksiKeIsi4Faktor();
        DBqueryTupoksiKeIsi4Faktor dBquerytupoksi = new DBqueryTupoksiKeIsi4Faktor(dbConn.getConnection());

        if (inputTupoksi == null) {
            inputTupoksi = "0";
        }
        String _inputTupoksi = inputTupoksi;

        try {
            if (!_inputTupoksi.equals("0")) {
                TKI4F = dBquerytupoksi.getDBqueryTupoksiKeIsi4FaktorId(_inputTupoksi);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return TKI4F;
    }

    public RealisasiIsi4faktorTupoksi getRealkesiid(String sidnippns, String sidtupoksi) {
        DBConnection dbConn = DBConnection.getInstance();
        RealisasiIsi4faktorTupoksi RIS4FT = new RealisasiIsi4faktorTupoksi();
        DBqueryRealisasiIsi4faktorTupoksi dbqueryRealkesi = new DBqueryRealisasiIsi4faktorTupoksi(dbConn.getConnection());

        if (sidnippns == null) {
            sidnippns = "0";
        }
        String _sidnippns = sidnippns;
        String _sidtupoksi = sidtupoksi;

        try {
            if (!_sidnippns.equals("0")) {
                RIS4FT = dbqueryRealkesi.getDBqueryRealEmpatFaktorTupoksiId(_sidnippns, _sidtupoksi);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return RIS4FT;
    }

    //pak RD --> untuk update
    public String getsimpanIsiEmpatFaktor(String iNip_id, String idTupoksi, String ikuantitas4, String ikualitas4, String iWaktu4, String iBiaya, String pilih, String waktuL, String _angkaKredit, String _pilih_session, String _getidUnor4jspSesiion) {
        DBConnection dbConn = DBConnection.getInstance();
        //  isi4faktor Isi4faktor = new isi4faktor();

        String berhasil = "Data Berhasil di Update";
        DBqueryUpdateTupoksi dBqueryUpdateTupoksi = new DBqueryUpdateTupoksi(dbConn.getConnection());
        if (idTupoksi == null) {
            idTupoksi = "0";
        }

        String _iNip_id = iNip_id;
        String _idTupoksi = idTupoksi;
        String _ikuantitas4 = ikuantitas4;
        String _ikualitas4 = ikualitas4;
        String _iWaktu4 = iWaktu4;
        String _iBiaya = iBiaya;
        String _pilih = pilih;
        String _waktuL = waktuL;
        String _angkaKreditr = _angkaKredit;
        String _getidUnor4jspSesiion4 = _getidUnor4jspSesiion;

        String s_pilih_session = _pilih_session;
        try {
            if (!_idTupoksi.equals("0")) {
                // dBqueryUpdateTupoksi.updateTupoksi(_iNip_id,_idTupoksi,_ikuantitas4,_ikualitas4,_iWaktu4,_iBiaya, _pilih, _waktuL,_angkaKreditr);
                dBqueryUpdateTupoksi.updateTupoksi(_iNip_id, _idTupoksi, _ikuantitas4, _ikualitas4, _iWaktu4, _iBiaya, _pilih, _waktuL, _angkaKreditr, s_pilih_session, _getidUnor4jspSesiion4);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return berhasil;
    }

    public String getSimpanLogin(String usernamebaru, String passwordbaru, String kewenangan, String nipbaru, String apakah) {
        DBConnection dbConn = DBConnection.getInstance();
        //  isi4faktor Isi4faktor = new isi4faktor();

        String berhasil = "Data Berhasil di Update";
        DBqueryPNS dBqueryPNS = new DBqueryPNS(dbConn.getConnection());
        if (nipbaru == null) {
            nipbaru = "0";
        }

        String _nipbaru = nipbaru;
        String _kewenangan = kewenangan;
        String _passwordbaru = passwordbaru;
        String _usernamebaru = usernamebaru;
        String _apakah = apakah;

        try {
            if (!_nipbaru.equals("0")) {
                if ("simpan".equals(apakah)) {
                    dBqueryPNS.insertSimpanLogin(_usernamebaru, _passwordbaru, _kewenangan, _nipbaru);
                } else if ("ubah".equals(apakah)) {
                    dBqueryPNS.updateSimpanLogin(_usernamebaru, _passwordbaru, _kewenangan, _nipbaru);
                } else {
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return berhasil;
    }

    public String getRekomendasiPns(String nippns, String nipatasan, String periode, String rekomendasi) {
        DBConnection dbConn = DBConnection.getInstance();
        //  isi4faktor Isi4faktor = new isi4faktor();

        String berhasil = "Data Berhasil di Update";
        DBqueryKeberatanPns dBqueryPNS = new DBqueryKeberatanPns(dbConn.getConnection());
        if (nippns == null) {
            nippns = "0";
        }

        String _nippns = nippns;
        String _nipatasan = nipatasan;
        String _periode = periode;
        String _rekomendasi = rekomendasi;

        try {
            if (!_nippns.equals("0")) {
                dBqueryPNS.insertRekomendasiPns(_nippns, _nipatasan, _periode, _rekomendasi);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return berhasil;
    }

    public loginweb getSudahAdaUser(String nippns) {
        DBConnection dbConn = DBConnection.getInstance();
        loginweb ipns = new loginweb();

        DBqueryPNS dBqueryPNS = new DBqueryPNS(dbConn.getConnection());
        if (nippns == null) {
            nippns = "0";
        }
        String _nippns = nippns;

        try {
            if (!_nippns.equals("0")) {
                ipns = dBqueryPNS.getSudahAdaUser(_nippns);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return ipns;
    }

    public String getsimpanRealisasi(String iNip_id, String idTupoksi, String ikuantitasR, String ikualitasR, String iWaktuR, String iBiayaR, String _angkakrdt4t, String _pilih_session) {
        DBConnection dbConn = DBConnection.getInstance();
        //  isi4faktor Isi4faktor = new isi4faktor();

        String berhasil = "Data Berhasil di Update";
        DBqueryUpdateTupoksi dBqueryUpdateTupoksi = new DBqueryUpdateTupoksi(dbConn.getConnection());
        if (idTupoksi == null) {
            idTupoksi = "0";
        }

        String _iNip_id = iNip_id;
        String _idTupoksi = idTupoksi;
        String _ikuantitasR = ikuantitasR;
        String _ikualitasR = ikualitasR;
        String _iWaktuR = iWaktuR;
        String _iBiayaR = iBiayaR;
        String _angkakrdt4tR = _angkakrdt4t;
        String _pilih_sessionR = _pilih_session;

        try {
            if (!_idTupoksi.equals("0")) {
                //     dBqueryUpdateTupoksi.updateTupoksiRealisasi(_iNip_id,_idTupoksi,_ikuantitasR,_ikualitasR,_iWaktuR,_iBiayaR,_angkakrdt4tR);
                dBqueryUpdateTupoksi.updateTupoksiRealisasi(_iNip_id, _idTupoksi, _ikuantitasR, _ikualitasR, _iWaktuR, _iBiayaR, _angkakrdt4tR, _pilih_sessionR);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return berhasil;
    }

    public String getsimpanHitungRealisasi(String iNip_id, String idTupoksi, String hitungan, String nilaiC) {
        DBConnection dbConn = DBConnection.getInstance();
        //  isi4faktor Isi4faktor = new isi4faktor();

        String berhasil = "Data Berhasil di Update";
        DBqueryUpdateTupoksi dBqueryUpdateTupoksi = new DBqueryUpdateTupoksi(dbConn.getConnection());
        if (idTupoksi == null) {
            idTupoksi = "0";
        }

        String _iNip_id = iNip_id;
        String _idTupoksi = idTupoksi;
        String _hitungan = hitungan;
        String _nilaiC = nilaiC;

        try {
            if (!_idTupoksi.equals("0")) {
                dBqueryUpdateTupoksi.updateHitunganRealisasi(_iNip_id, _idTupoksi, _hitungan, _nilaiC);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return berhasil;
    }

    //untuk insert
    public String getInsertIsiEmpatFaktor(String maks, String _iNip_id, String UnorIdisert, String IdTupoksi, String ikuantitas4, String ikualitas4, String iWaktu4, String ipilih, String waktuL, String iBiaya, String maksR, String ikuantitasR, String ikualitasR, String iWaktuR, String iBiayaR, String penghitungan, String nilaiCapaian, String iBiayanya, String angkakrdtR) {
        DBConnection dbConn = DBConnection.getInstance();

        String berhasil = "Data Berhasil di Insert";
        DBqueryUpdateTupoksi dBqueryUpdateTupoksi = new DBqueryUpdateTupoksi(dbConn.getConnection());

        if (IdTupoksi == null) {
            IdTupoksi = "0";
        }
        String _maks = maks;
        String __iNip_id = _iNip_id;
        String __UnorIdisert = UnorIdisert;
        String _idTupoksi = IdTupoksi;
        String _ikuantitas4 = ikuantitas4;
        String _ikualitas4 = ikualitas4;
        String _iWaktu4 = iWaktu4;
        String _iBiaya = iBiaya;
        String _maksR = maksR;
        String _ikuantitasR = ikuantitasR;
        String _ikualitasR = ikualitasR;
        String _iWaktuR = iWaktuR;
        String _iBiayaR = iBiayaR;
        String _penghitungan = penghitungan;
        String _nilaiCapaian = nilaiCapaian;
        String _iBiayanya = iBiayanya;
        String _kuantitas_label = ipilih;
        String _waktu_label = waktuL;
        String _angkakrdtR = angkakrdtR;

        try {
            if (!_idTupoksi.equals("0")) {
                String maksHasil = dBqueryUpdateTupoksi.makIsi4faktorId();
                dBqueryUpdateTupoksi.insertTupoksi(maksHasil, __iNip_id, __UnorIdisert, _idTupoksi, _ikuantitas4, _ikualitas4, _iWaktu4, _iBiaya, _kuantitas_label, _waktu_label);
                String maksHasilR = dBqueryUpdateTupoksi.makRealisasi();
                dBqueryUpdateTupoksi.insertRealisasi(maksHasilR, maksHasil, __UnorIdisert, __iNip_id, _idTupoksi, _ikuantitasR, _ikualitasR, _iWaktuR, _iBiayaR, _penghitungan, _nilaiCapaian, _iBiayanya, _angkakrdtR);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return berhasil;
    }

    public String getInsertPerilaku(String _nip, String _Pelayanan, String _Integritas, String _Komitmen, String _Disiplin, String _Kerjasama, String _Kepemimpinan, String _jumlah, String _ratarata, String _Penilaian) {
        DBConnection dbConn = DBConnection.getInstance();

        String berhasil = "Data Perilaku Berhasil di Insert";
        DBqueryPerilaku dBqueryPerilaku = new DBqueryPerilaku(dbConn.getConnection());

        if (_nip == null) {
            _nip = "0";
        }

        String nip = _nip;
        String Pelayanan = _Pelayanan;
        String Integritas = _Integritas;
        String Komitmen = _Komitmen;
        String Disiplin = _Disiplin;
        String Kerjasama = _Kerjasama;
        String Kepemimpinan = _Kepemimpinan;
        String jumlah = _jumlah;
        String ratarata = _ratarata;
        String Penilaian = _Penilaian;

        try {
            if (!nip.equals("0")) {
                dBqueryPerilaku.insertPerilaku(nip, Pelayanan, Integritas, Komitmen, Disiplin, Kerjasama, _Kepemimpinan, jumlah, ratarata, Penilaian);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return berhasil;
    }

    public String getUpdatePerilaku(String _nip, String _Pelayanan, String _Integritas, String _Komitmen, String _Disiplin, String _Kerjasama, String _Kepemimpinan, String _jumlah, String _ratarata, String _Penilaian) {
        DBConnection dbConn = DBConnection.getInstance();

        String berhasil = "Data Perilaku Berhasil di UPDATE";
        DBqueryPerilaku dBqueryPerilaku = new DBqueryPerilaku(dbConn.getConnection());

        if (_nip == null) {
            _nip = "0";
        }

        String nip = _nip;
        String Pelayanan = _Pelayanan;
        String Integritas = _Integritas;
        String Komitmen = _Komitmen;
        String Disiplin = _Disiplin;
        String Kerjasama = _Kerjasama;
        String Kepemimpinan = _Kepemimpinan;
        String jumlah = _jumlah;
        String ratarata = _ratarata;
        String Penilaian = _Penilaian;

        try {
            if (!nip.equals("0")) {
                dBqueryPerilaku.updatePerilaku(nip, Pelayanan, Integritas, Komitmen, Disiplin, Kerjasama, Kepemimpinan, jumlah, ratarata, Penilaian);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return berhasil;
    }

    public String getInsertRealisasi(String maks, String idisi4faktor, String insertRealisasi, String nip_pns, String idtupoksi, String ikuantitasR, String ikualitasR, String iWaktuR, String iBiayaR, String iPenghitungan, String iNilaiCapaian, String iBiayanya, String iangkakrdtR) {
        DBConnection dbConn = DBConnection.getInstance();

        String berhasil = "Data Berhasil di Insert";
        DBqueryUpdateTupoksi dBqueryUpdateTupoksi = new DBqueryUpdateTupoksi(dbConn.getConnection());

        if (idisi4faktor == null) {
            idisi4faktor = "0";
        }
        String _maks = maks;
        String _idisi4faktor = idisi4faktor;
        String _nip_pns = nip_pns;
        String _idtupoksi = idtupoksi;
        String _ikuantitasR = ikuantitasR;
        String _ikualitasR = ikualitasR;
        String _iWaktuR = iWaktuR;
        String _iBiayaR = iBiayaR;
        String _penghitungan = iPenghitungan;
        String _nilaiCapaian = iNilaiCapaian;
        String _iBiayanya = iBiayanya;
        String _angkakrdtR = iangkakrdtR;
        String _insertRealisasiR = insertRealisasi;

        try {
            if (!_idtupoksi.equals("0")) {
                String maksHasil = dBqueryUpdateTupoksi.makRealisasi();

                dBqueryUpdateTupoksi.insertRealisasi(_maks, _idisi4faktor, _insertRealisasiR, _nip_pns, _idtupoksi, _ikuantitasR, _ikualitasR, _iWaktuR, _iBiayaR, _penghitungan, _nilaiCapaian, _iBiayanya, _angkakrdtR);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return berhasil;
    }

    public String getHpsTupoksi(String _id_tupoksi, String _id_unor, String _id_instansi) {
        DBConnection dbConn = DBConnection.getInstance();
        String berhasil = "Data Berhasil di Hapus";
        DBqueryTupoksi dBqueryTupoksi = new DBqueryTupoksi(dbConn.getConnection());

        if (_id_tupoksi == null) {
            _id_tupoksi = "0";
        }

        String _idtupoksi = _id_tupoksi;
        String _idUnor = _id_unor;
        String _idInstansi = _id_instansi;


        try {
            if (!_idtupoksi.equals("0")) {
                dBqueryTupoksi.hapusTupoksi(_id_tupoksi, _idUnor, _idInstansi);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return berhasil;
    }

    public String getHpsIdTupoksi(String _id_tupoksi, String Jenis, String Instansi, String Unor, String Jabatan) {
        DBConnection dbConn = DBConnection.getInstance();
        String berhasil = "Data Berhasil di Hapus";
        DBqueryTupoksi dBqueryTupoksi = new DBqueryTupoksi(dbConn.getConnection());

        if (_id_tupoksi == null) {
            _id_tupoksi = "0";
        }

        String _idtupoksi = _id_tupoksi;

        try {
            if (!_idtupoksi.equals("0")) {
                if (Jenis.equals("1")) {
                    dBqueryTupoksi.hapusTupoksi(_id_tupoksi, Unor, Instansi);
                } else {
                    dBqueryTupoksi.hapusIdTupoksiFungFum(_id_tupoksi, Jabatan);
                    // dBqueryTupoksi.hapusIdTupoksi(_id_tupoksi);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return berhasil;
    }

    public String getInsertTupoksiOperator(String _id_tupoksi, String _nama_tupoksi, String _id_unor, String _nama_unor, String _id_instansi, String _instansi_nama, String _id_diatasan, String _angka_krdt, String _pilih_output_Jabatan, String namaKelompok, String jenisJabatan) {
        DBConnection dbConn = DBConnection.getInstance();

        String berhasil = "Data Berhasil di Insert";
        DBqueryTupoksi dBqueryTupoksi = new DBqueryTupoksi(dbConn.getConnection());

        if (_id_unor == null) {
            _id_unor = "0";
        }
        String maks_id_tupoksi = _id_tupoksi;
        String s_nama_tupoksi = _nama_tupoksi;
        String s_id_unor = _id_unor;
        String s_nama_unor = _nama_unor;
        String s_id_instansi = _id_instansi;
        String s_instansi_nama = _instansi_nama;
        String s_id_diatasan = _id_diatasan;
        String s_angka_krdt = _angka_krdt;
        String s_pilih_output_Jabatan = _pilih_output_Jabatan;
        String s_namaKelompok = namaKelompok;
        String Jenis = jenisJabatan;
        try {
            if (!s_nama_unor.equals("0")) {
                String maksHasil = dBqueryTupoksi.makTupoksiOperator();
                dBqueryTupoksi.insertTupoksiOperator(_id_tupoksi, _nama_tupoksi, _id_unor, _nama_unor, _id_instansi, _instansi_nama, _id_diatasan, s_angka_krdt, s_pilih_output_Jabatan, s_namaKelompok, Jenis);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return berhasil;
    }

    public String getsimpanRiwayatAtasan_Bawahan(String idAtasan, String instansiIdAtasan, String UnorIdatasan, String instansiIdpnsBawahan, String instansiIdunorbawahan) {
        DBConnection dbConn = DBConnection.getInstance();

        String berhasil = "Data Berhasil di simpan";
        DBqueryTupoksi dBqueryTupoksi = new DBqueryTupoksi(dbConn.getConnection());

        if (idAtasan == null) {
            idAtasan = "0";
        }
        String s_idAtasan = idAtasan;
        String s_instansiIdAtasan = instansiIdAtasan;
        String s_UnorIdatasan = UnorIdatasan;
        String s_instansiIdpnsBawahan = instansiIdpnsBawahan;
        String s_instansiIdunorbawahan = instansiIdunorbawahan;

        try {
            if (!s_idAtasan.equals("0")) {

                dBqueryTupoksi.InsertRiwayatAtasanBawahan(s_idAtasan, s_instansiIdAtasan, s_UnorIdatasan, s_instansiIdpnsBawahan, s_instansiIdunorbawahan);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return berhasil;
    }

    public String getUpdateUnorYangKosong(String NipPns, String unorAtasan) {
        DBConnection dbConn = DBConnection.getInstance();

        String berhasil = "Data Berhasil di Update";
        DBqueryUnor dBqueryunor = new DBqueryUnor(dbConn.getConnection());


        try {
            dBqueryunor.getDBqueryUnorAtasanKosong(NipPns, unorAtasan);



        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return berhasil;

    }

    public RiwayatAtasanBawahan getSimpanRiwayatAtasan_Bawahan(String s_idAtasani, String s_instansiIdAtasan, String s_UnorIdatasan, String s_instansiIdpnsBawahan, String s_instansiIdunorbawahan) {
        DBConnection dbConn = DBConnection.getInstance();
        RiwayatAtasanBawahan ipns = new RiwayatAtasanBawahan();
        DBqueryTupoksi dBqueryTupoksi = new DBqueryTupoksi(dbConn.getConnection());

        try {

            ipns = dBqueryTupoksi.SimpanRiwayatAtasan_Bawahan(s_idAtasani, s_instansiIdAtasan, s_UnorIdatasan, s_instansiIdpnsBawahan, s_instansiIdunorbawahan);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return ipns;
    }

    public unorskp getIdUnorAtasan(String unorAtasan) {
        DBConnection dbConn = DBConnection.getInstance();
        unorskp ipns = new unorskp();
        DBqueryUnor dBqueryunor = new DBqueryUnor(dbConn.getConnection());



        try {

            ipns = dBqueryunor.getDBqueryUnorId(unorAtasan);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return ipns;
    }

    /*  public unorskp getIdUnorAtasan(String unorAtasan)
    {
    DBConnection dbConn = DBConnection.getInstance();
    
    String berhasil="Data Berhasil di Update";
    DBqueryUnor dBqueryunor = new  DBqueryUnor(dbConn.getConnection());
    
    
    try
    {   
    dBqueryunor.getDBqueryUnorId( unorAtasan);
    
    
    
    }
    catch(Exception ex)
    {
    ex.printStackTrace();
    }
    finally
    {
    dbConn.closeConnection();
    }         
    return  berhasil;  
    
    }
    
    
     */
    public String getUpdateInsertTupoksiOperator(String jenis, String _id_tupoksi, String _nama_tupoksi, String _id_unor, String _id_instansi, String _angka_krdt, String _pilih_output_Jabatan, String namaKelompok) {
        DBConnection dbConn = DBConnection.getInstance();

        String berhasil = "Data Berhasil di Update";
        DBqueryTupoksi dBqueryTupoksi = new DBqueryTupoksi(dbConn.getConnection());

        if (_id_unor == null) {
            _id_unor = "0";
        }
        String s_id_tupoksi = _id_tupoksi;
        String s_nama_tupoksi = _nama_tupoksi;
        String s_id_unor = _id_unor;
        String s_id_instansi = _id_instansi;
        String s_angka_krdt = _angka_krdt;

        try {
            if (!s_id_tupoksi.equals("0")) {
                if (!jenis.equals("1")) {
                    dBqueryTupoksi.UpdateinsertTupoksiOperator(_id_tupoksi, _nama_tupoksi, _id_unor, _id_instansi, s_angka_krdt, _pilih_output_Jabatan, namaKelompok);
                } else {
                    dBqueryTupoksi.UpdateinsertTupoksiOperatorStruktural(_id_tupoksi, _nama_tupoksi, _id_unor, _id_instansi);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return berhasil;
    }

    //baru 22022012
    public instansiri getInstansi(String InstansiPns) {
        DBConnection dbConn = DBConnection.getInstance();
        instansiri ins = new instansiri();
        DbqueryINS dbqueryINS = new DbqueryINS(dbConn.getConnection());

        if (InstansiPns == null) {
            InstansiPns = "0";
        }
        String Namainstansi = InstansiPns;

        try {
            if (!Namainstansi.equals("0")) {
                ins = dbqueryINS.getDBqueryINS(Namainstansi);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return ins;
    }

    public unorskp getUnor(String UnorPns, String InstansiPns) {
        DBConnection dbConn = DBConnection.getInstance();
        unorskp ukp = new unorskp();
        DBqueryUnor dbqueryUNOR = new DBqueryUnor(dbConn.getConnection());

        if (InstansiPns == null) {
            InstansiPns = "0";
        }
        String UnorPnsId = UnorPns;
        String Namainstansi = InstansiPns;

        try {
            if (!Namainstansi.equals("0")) {
                ukp = dbqueryUNOR.getDBqueryUNOR(UnorPnsId, Namainstansi);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return ukp;
    }

    public isi4faktor getSamaNipDanTupoksi(String nip_pns, String id_tupoksi) {
        DBConnection dbConn = DBConnection.getInstance();
        isi4faktor ukp = new isi4faktor();
        DBqueryIsi4Faktor dbqueryCariNipTupoksiDiIsi4Faktor = new DBqueryIsi4Faktor(dbConn.getConnection());

        if (nip_pns == null) {
            nip_pns = "0";
        }
        String nipbarupns = nip_pns;
        String tupoksipns = id_tupoksi;

        try {
            if (!nipbarupns.equals("0")) {
                ukp = dbqueryCariNipTupoksiDiIsi4Faktor.getDBqueryCariNipTupoksiDiIsi4Faktor(nipbarupns, tupoksipns);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return ukp;
    }

    public List<UnorKeTupoksi> getSamaLikeTupoksi(String cariKriteriaKlTgs, String cariKriteria) {
        DBConnection dbConn = DBConnection.getInstance();
        List<UnorKeTupoksi> unorKeTupoksi = new ArrayList<UnorKeTupoksi>();
        DBqueryUnorKeTupoksi dbqueryCariNipTupoksiDiIsi4Faktor = new DBqueryUnorKeTupoksi(dbConn.getConnection());

        if (cariKriteria == null) {
            cariKriteria = "0";
        }
        String _cariKriterias = cariKriteria;
        String _cariKriteriaKlTgs = cariKriteriaKlTgs;

        try {
            if (!cariKriteria.equals("0")) {
                unorKeTupoksi = dbqueryCariNipTupoksiDiIsi4Faktor.getDBqueryKeTupoksiIdAll(_cariKriteriaKlTgs, _cariKriterias);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return unorKeTupoksi;
    }

    public List<tupoksi_lama> getSamaLikeKeLompokTupoksiIdAll(String cariKriteriaKlTgs) {
        DBConnection dbConn = DBConnection.getInstance();
        List<tupoksi_lama> Tupoksis = new ArrayList<tupoksi_lama>();
        DBqueryUnorKeTupoksi dbqueryCariNipTupoksiDiIsi4Faktor = new DBqueryUnorKeTupoksi(dbConn.getConnection());

        if (cariKriteriaKlTgs == null) {
            cariKriteriaKlTgs = "0";
        }
        String _cariKriteriaKlTgs = cariKriteriaKlTgs;

        try {
            if (!cariKriteriaKlTgs.equals("0")) {
                Tupoksis = dbqueryCariNipTupoksiDiIsi4Faktor.getDBqueryKeLompokTupoksiIdAll(_cariKriteriaKlTgs);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return Tupoksis;
    }

    public List<instansiri> getAllInstansi() throws SQLException {
        DBConnection dbConn = DBConnection.getInstance();
        List<instansiri> instansies = new ArrayList<instansiri>();
        DbqueryINS dbqueryINS = new DbqueryINS(dbConn.getConnection());

        instansies = dbqueryINS.getDBqueryInstansiRi();

        return instansies;


    }

    public List<UnorKeTupoksi> getUnosi(String sid_unor, String sid_instansi) {
        //KONEKSi
        DBConnection dbConn = DBConnection.getInstance();

        //DOMAIN
        List<UnorKeTupoksi> unosi = new ArrayList<UnorKeTupoksi>();

        //DAO
        DBqueryUnorKeTupoksi dBqueryUnorKeTupoksi = new DBqueryUnorKeTupoksi(dbConn.getConnection());


        if (sid_instansi == null || sid_unor == null) {
            sid_instansi = "0";
            sid_unor = "0";
        }
        String instansiID = sid_instansi;
        String unorID = sid_unor;

        try {
            if (!instansiID.equals("0") || !unorID.equals("0")) {
                unosi = dBqueryUnorKeTupoksi.getDBqueryUnorKeTupoksiId(sid_unor, sid_instansi);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return unosi;
    }

    public List<UnorKeTupoksi> getUnosi2(String sid_unor, String sid_instansi, String NipPns, String Jenis, String Jabatan) {
        //KONEKSi
        DBConnection dbConn = DBConnection.getInstance();

        //DOMAIN
        List<UnorKeTupoksi> unosi = new ArrayList<UnorKeTupoksi>();

        //DAO
        DBqueryUnorKeTupoksi dBqueryUnorKeTupoksi = new DBqueryUnorKeTupoksi(dbConn.getConnection());


        if (sid_instansi == null || sid_unor == null) {
            sid_instansi = "0";
            sid_unor = "0";
            Jenis = "0";
            Jabatan = "0";

        }
        String instansiID = sid_instansi;
        String unorID = sid_unor;

        try {
            if (Jenis.equals("1")) {
                unosi = dBqueryUnorKeTupoksi.getDBqueryTupoksiStruktural(sid_unor, sid_instansi);
            } else if (Jenis.equals("2") || Jenis.equals("4")) {
                unosi = dBqueryUnorKeTupoksi.getDBqueryTupoksiFungsional(sid_unor, sid_instansi, Jabatan);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return unosi;
    }

    public List<unorskp> getUnori(String sidInstansi) {
        DBConnection dbConn = DBConnection.getInstance();
        List<unorskp> unori = new ArrayList<unorskp>();
        DBqueryUnor dbqueryUnor = new DBqueryUnor(dbConn.getConnection());


        if (sidInstansi == null) {
            sidInstansi = "0";
        }
        String _sidInstansi = sidInstansi;

        try {
            if (!_sidInstansi.equals("0")) {
                unori = dbqueryUnor.getDBqueryUnorFromInstansiId(_sidInstansi);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return unori;
    }

    public List<instansiri> getCariInstansi(String snamaInstansi) {
        DBConnection dbConn = DBConnection.getInstance();
        List<instansiri> instansies = new ArrayList<instansiri>();
        DbqueryINS dbqueryINS = new DbqueryINS(dbConn.getConnection());

        if (snamaInstansi == null) {
            snamaInstansi = "0";
        }
        String CariNamainstansi = snamaInstansi;

        try {
            if (!CariNamainstansi.equals("0")) {
                instansies = dbqueryINS.getDBqueryCariINS(CariNamainstansi);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return instansies;
    }

    public List<unorskp> getCariUnor(String snamaUnor, String InstansiId) {
        DBConnection dbConn = DBConnection.getInstance();
        List<unorskp> unoriesByCriteria = new ArrayList<unorskp>();
        DBqueryUnor dbqueryUnor = new DBqueryUnor(dbConn.getConnection());

        if (snamaUnor == null) {
            snamaUnor = "0";
        }
        String CariNamaUnor = snamaUnor;
        String CariInstansi = InstansiId;

        try {
            if (!CariNamaUnor.equals("0")) {
                unoriesByCriteria = dbqueryUnor.getDBqueryCariUnor(CariNamaUnor, CariInstansi);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return unoriesByCriteria;
    }

    public List<unorskp> getUnoriUN(String sidInstansi) {
        DBConnection dbConn = DBConnection.getInstance();
        List<unorskp> unori = new ArrayList<unorskp>();
        DBqueryUnor dbqueryUnor = new DBqueryUnor(dbConn.getConnection());


        if (sidInstansi == null) {
            sidInstansi = "0";
        }
        String _sidInstansi = sidInstansi;

        try {
            if (!_sidInstansi.equals("0")) {
                unori = dbqueryUnor.getDBqueryUnorFromInstansiId(_sidInstansi);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return unori;
    }

    public tupoksi_lama getIdInstansiIdUnorDariIdTupoksi(String IdTupoksi) {
        DBConnection dbConn = DBConnection.getInstance();
        tupoksi_lama tup = new tupoksi_lama();
        DBqueryTupoksi dbqueryINS = new DBqueryTupoksi(dbConn.getConnection());

        if (IdTupoksi == null) {
            IdTupoksi = "0";
        }
        String _IdTupoksi = IdTupoksi;

        try {
            if (!_IdTupoksi.equals("0")) {
                tup = dbqueryINS.getDBqueryIdInstansiDanIdUnorDariIdTupoksi(_IdTupoksi);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return tup;
    }

    public tupoksi_lama getallDariIdTupoksi(String IdTupoksi) {
        DBConnection dbConn = DBConnection.getInstance();
        tupoksi_lama tup = new tupoksi_lama();
        DBqueryTupoksi dbqueryINS = new DBqueryTupoksi(dbConn.getConnection());

        if (IdTupoksi == null) {
            IdTupoksi = "0";
        }
        String _IdTupoksi = IdTupoksi;

        try {
            if (!_IdTupoksi.equals("0")) {
                tup = dbqueryINS.getDBqueryallDariIdTupoksi(_IdTupoksi);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return tup;
    }

    public String getNilaiAllSession(String id_unoruser, String nip_pns, String _pilih_session) {
        DBConnection dbConn = DBConnection.getInstance();

        String berhasil = null;
        DbqueryTugasTambahan _DbqueryTugasTambahan = new DbqueryTugasTambahan(dbConn.getConnection());

        if (nip_pns == null) {
            nip_pns = "0";
        }

        String _nip_pns = nip_pns;

        try {
            if (!_nip_pns.equals("0")) {
                berhasil = _DbqueryTugasTambahan.nilaicapaianallSession(id_unoruser, nip_pns, _pilih_session);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return berhasil;
    }

    public String getNilaiAllSession_unor(String nip_pns, String unorIdPns, String _pilih_session) {
        DBConnection dbConn = DBConnection.getInstance();

        String berhasil = null;
        DbqueryTugasTambahan _DbqueryTugasTambahan = new DbqueryTugasTambahan(dbConn.getConnection());

        if (nip_pns == null) {
            nip_pns = "0";
        }

        String _nip_pns = nip_pns;

        try {
            if (!_nip_pns.equals("0")) {
                berhasil = _DbqueryTugasTambahan.nilaicapaianallSession_unor(nip_pns, unorIdPns, _pilih_session);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return berhasil;
    }

    public String getNilaiAll(String nip_pns) {
        DBConnection dbConn = DBConnection.getInstance();

        String berhasil = null;
        DbqueryTugasTambahan _DbqueryTugasTambahan = new DbqueryTugasTambahan(dbConn.getConnection());

        if (nip_pns == null) {
            nip_pns = "0";
        }

        String _nip_pns = nip_pns;

        try {
            if (!_nip_pns.equals("0")) {
                berhasil = _DbqueryTugasTambahan.nilaicapaianall(nip_pns);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return berhasil;
    }

    public String getNilaiAllIdunor(String nip_pns, String Idunor) {
        DBConnection dbConn = DBConnection.getInstance();

        String berhasil = null;
        DbqueryTugasTambahan _DbqueryTugasTambahan = new DbqueryTugasTambahan(dbConn.getConnection());

        if (nip_pns == null) {
            nip_pns = "0";
        }

        String _nip_pns = nip_pns;

        try {
            if (!_nip_pns.equals("0")) {
                berhasil = _DbqueryTugasTambahan.nilaicapaianallIunor(nip_pns, Idunor);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return berhasil;
    }

    public String getNilaiAllTugasTambahan(String nip_pns) {
        DBConnection dbConn = DBConnection.getInstance();

        String berhasil = null;
        DbqueryTugasTambahan _DbqueryTugasTambahan = new DbqueryTugasTambahan(dbConn.getConnection());

        if (nip_pns == null) {
            nip_pns = "0";
        }

        String _nip_pns = nip_pns;

        try {
            if (!_nip_pns.equals("0")) {
                berhasil = _DbqueryTugasTambahan.nilaicapaianallTugasTambahan(nip_pns);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return berhasil;
    }

    //BILA MENGGUNAKAN STRUKTURAL SAJA ==> DBqueryPNS.java
//     public  List<pnsskp_strukturalbkn> getTugasTambahanBawahanList(String iunorAtasan){
//          DBConnection dbConn = DBConnection.getInstance();
//          List<pnsskp_strukturalbkn> pnsBawahan = new ArrayList<pnsskp_strukturalbkn>();
//          DBqueryPNS dbquerypns = new  DBqueryPNS(dbConn.getConnection());
//        
//        if (iunorAtasan ==null && iunorAtasan ==null )
//        {
//             iunorAtasan="0";
//        }
//         
//           String _iunorAtasan=iunorAtasan;
//           
//        try
//        {
//            if(!_iunorAtasan.equals("0"))
//            {
//                pnsBawahan=dbquerypns.getDBqueryPNSTambahan(_iunorAtasan);
//            }
//        }
//        catch(Exception ex)
//        {
//            ex.printStackTrace();
//        }
//        finally
//        {
//            dbConn.closeConnection();
//        }         
//        return pnsBawahan;         
//    }
    //BILA MENGGUNAKAN STRUKTURAL SAJA DAN MENGHILANGKAN FUNGSIONAL
    public List<PnsSkp> getTugasTambahanBawahanListALLSession(String iunorAtasan, String thnSession) {
        DBConnection dbConn = DBConnection.getInstance();
        List<PnsSkp> pnsBawahan = new ArrayList<PnsSkp>();
        List<PnsSkp> pnsBawahan2 = new ArrayList<PnsSkp>();
        List<PnsSkp> pnsBawahan3 = new ArrayList<PnsSkp>();
        List<PnsSkp> pnsBawahan4 = new ArrayList<PnsSkp>();
        List<PnsSkp> ismus = new ArrayList<PnsSkp>();
        DBqueryPNS dbquerypns = new DBqueryPNS(dbConn.getConnection());
        if (iunorAtasan == null && iunorAtasan == null) {
            iunorAtasan = "0";
        }
        String _iunorAtasan = iunorAtasan;
        try {
            if (!_iunorAtasan.equals("0")) {
                String akhirPns = null;
                String akhirAts = null;
                PnsSkp ipns = null;
                //  pnsBawahan=dbquerypns.getDBqueryPNSTambahan2(_iunorAtasan);
                pnsBawahan = dbquerypns.getDBqueryPNSTambahan2Session(_iunorAtasan, thnSession);
                for (PnsSkp ipns2 : pnsBawahan) {
                    ipns = new PnsSkp();
                    ipns = ipns2;
                    ismus.add(ipns);
                    akhirPns = ipns.getUnorId();
                    akhirAts = ipns.getDiAtasanId();
                    if (!akhirAts.equals(akhirPns)) {
                        // pnsBawahan2=dbquerypns.getDBqueryPNSTambahan2(akhirPns);
                        pnsBawahan2 = dbquerypns.getDBqueryPNSTambahan2Session(akhirPns, thnSession);
                        for (PnsSkp ipns3 : pnsBawahan2) {
                            ipns = new PnsSkp();
                            ipns = ipns3;
                            ismus.add(ipns);
                            akhirPns = ipns.getUnorId();
                            akhirAts = ipns.getDiAtasanId();
                            if (!akhirAts.equals(akhirPns)) {
                                // pnsBawahan3=dbquerypns.getDBqueryPNSTambahan2(akhirPns);
                                pnsBawahan3 = dbquerypns.getDBqueryPNSTambahan2Session(akhirPns, thnSession);
                                for (PnsSkp ipns4 : pnsBawahan3) {
                                    ipns = new PnsSkp();
                                    ipns = ipns4;
                                    ismus.add(ipns);
                                    akhirPns = ipns.getUnorId();
                                    akhirAts = ipns.getDiAtasanId();
                                    if (!akhirAts.equals(akhirPns)) {
                                        //  pnsBawahan4=dbquerypns.getDBqueryPNSTambahan2(akhirPns) ;
                                        pnsBawahan4 = dbquerypns.getDBqueryPNSTambahan2Session(akhirPns, thnSession);
                                        for (PnsSkp ipns5 : pnsBawahan4) {
                                            ipns = new PnsSkp();
                                            ipns = ipns5;
                                            ismus.add(ipns);
                                            akhirPns = ipns.getUnorId();
                                            akhirAts = ipns.getDiAtasanId();
                                        }

                                    }

                                }
                            }
                        }




                    }


                    //  ismus.get(0).
                }


            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return ismus;
    }

    public List<PnsSkp> getTugasTambahanBawahanListALL(String iunorAtasan) {
        DBConnection dbConn = DBConnection.getInstance();
        List<PnsSkp> pnsBawahan = new ArrayList<PnsSkp>();
        List<PnsSkp> pnsBawahan2 = new ArrayList<PnsSkp>();
        List<PnsSkp> pnsBawahan3 = new ArrayList<PnsSkp>();
        List<PnsSkp> pnsBawahan4 = new ArrayList<PnsSkp>();
        List<PnsSkp> ismus = new ArrayList<PnsSkp>();
        String caverNip = null;
        caverNip = ModelLocatorSKP.Gcavernip;
        caverNip = "awal";
        DBqueryPNS dbquerypns = new DBqueryPNS(dbConn.getConnection());
        if (iunorAtasan == null && iunorAtasan == null) {
            iunorAtasan = "0";
        }
        String _iunorAtasan = iunorAtasan;
        try {
            if (!_iunorAtasan.equals("0")) {
                String akhirPns = null;
                String akhirAts = null;
                PnsSkp ipns = null;
                String oneAsString = null;
                String strone="";

                int one = 0;
                int two=0;
                int tree=0;
                int four=0;
                Object[] obj2 = null;
                ModelLocatorSKP.arraypGcavernip = new ArrayList<String>();
                pnsBawahan = dbquerypns.getDBqueryPNSTambahan2(_iunorAtasan);
                for (PnsSkp ipns2 : pnsBawahan) {
                    one = 1 + one;
                    oneAsString = String.valueOf(one);
                    
                    ipns = new PnsSkp();
                    ipns = ipns2;
                    ipns.setLevel(oneAsString);
                    ismus.add(ipns);
                    akhirPns = ipns.getUnorId();
                    akhirAts = ipns.getDiAtasanId();
                    caverNip = ipns.getNipBaru();

                    if (!akhirAts.equals(akhirPns) && ipns.getjnsjbtn_id().equals("1")) {
                        pnsBawahan2 = dbquerypns.getDBqueryPNSTambahan2(akhirPns);
                         two =0;
                         String twoAsString ="";
                        for (PnsSkp ipns3 : pnsBawahan2) {
                             
                            ipns = new PnsSkp();
                            ipns = ipns3;
                            two = 1 + two;
                            twoAsString=String.valueOf(one) +String.valueOf(two);
                            ipns.setLevel(twoAsString);
                            ismus.add(ipns);
                            akhirPns = ipns.getUnorId();
                            akhirAts = ipns.getDiAtasanId();
                            if (!akhirAts.equals(akhirPns) &&  ipns.getjnsjbtn_id().equals("1")) {
                                pnsBawahan3 = dbquerypns.getDBqueryPNSTambahan2(akhirPns);
                                String treeAsString ="";
                                tree=0;
                                for (PnsSkp ipns4 : pnsBawahan3) {
                                    ipns = new PnsSkp();
                                    ipns = ipns4;
                                    tree = 1 + tree;
                                    treeAsString=String.valueOf(one)+String.valueOf(two)+String.valueOf(tree);
                                    ipns.setLevel(treeAsString);
                                   
                                    ismus.add(ipns);
                                    akhirPns = ipns.getUnorId();
                                    akhirAts = ipns.getDiAtasanId();
                                    if (!akhirAts.equals(akhirPns) && ipns.getjnsjbtn_id().equals("1")) {
                                        pnsBawahan4 = dbquerypns.getDBqueryPNSTambahan2(akhirPns);
                                        four=0;
                                        String fourAsString ="";
                                        for (PnsSkp ipns5 : pnsBawahan4) {
                                            ipns = new PnsSkp();
                                            ipns = ipns5;
                                            four = 1 + four;
                                            fourAsString=String.valueOf(one)+String.valueOf(two)+String.valueOf(tree)+String.valueOf(four);
                                            ipns.setLevel(fourAsString);
                                           
                                            ismus.add(ipns);
                                            akhirPns = ipns.getUnorId();
                                            akhirAts = ipns.getDiAtasanId();
                                            caverNip = ipns.getNipBaru();
                                            ModelLocatorSKP.Gcavernip = caverNip;

                                            ModelLocatorSKP.arraypGcavernip.add(caverNip);
                                        }

                                    }
                                    caverNip = ipns.getNipBaru();
                                    ModelLocatorSKP.Gcavernip = caverNip;
                                    ModelLocatorSKP.arraypGcavernip.add(caverNip);
                                }
                            }
                            caverNip = ipns.getNipBaru();
                            ModelLocatorSKP.Gcavernip = caverNip;

                            ModelLocatorSKP.arraypGcavernip.add(caverNip);
                        }

                    } else {
                    }


                    //  ismus.get(0).
                    caverNip = ipns.getNipBaru();
                    ModelLocatorSKP.Gcavernip = caverNip;

                    ModelLocatorSKP.arraypGcavernip.add(caverNip);
                }


            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return ismus;
    }

    public List<pnsskp_jabfungtbkn> getTugasTambahanBawahanList(String iunorAtasan) {
        DBConnection dbConn = DBConnection.getInstance();
        List<pnsskp_jabfungtbkn> pnsBawahan = new ArrayList<pnsskp_jabfungtbkn>();
        DBqueryPNS dbquerypns = new DBqueryPNS(dbConn.getConnection());
        if (iunorAtasan == null && iunorAtasan == null) {
            iunorAtasan = "0";
        }
        String _iunorAtasan = iunorAtasan;
        try {
            if (!_iunorAtasan.equals("0")) {

                pnsBawahan = dbquerypns.getDBqueryPNSTambahan(_iunorAtasan);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return pnsBawahan;
    }

    public List<PnsSkp> getTugasTambahanBawahanList2(String iunorAtasan) {
        DBConnection dbConn = DBConnection.getInstance();
        List<PnsSkp> pnsBawahan = new ArrayList<PnsSkp>();
        DBqueryPNS dbquerypns = new DBqueryPNS(dbConn.getConnection());

        if (iunorAtasan == null && iunorAtasan == null) {
            iunorAtasan = "0";
        }

        String _iunorAtasan = iunorAtasan;

        try {
            if (!_iunorAtasan.equals("0")) {
                pnsBawahan = dbquerypns.getDBqueryPNSTambahan2(_iunorAtasan);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return pnsBawahan;
    }

    public List<PnsSkp> getPNSbawahan(String iunorAtasan, String pencarian, String Kriteria) {
        DBConnection dbConn = DBConnection.getInstance();
        List<PnsSkp> pnsBawahan = new ArrayList<PnsSkp>();
        DBqueryPNS dbquerypns = new DBqueryPNS(dbConn.getConnection());

        if (iunorAtasan == null && iunorAtasan == null) {
            iunorAtasan = "0";
        }

        String _iunorAtasan = iunorAtasan;

        try {
            if (!_iunorAtasan.equals("0")) {
                if (Kriteria.equals("nama")) {
                    pnsBawahan = dbquerypns.getDBqueryBawahanByNama(_iunorAtasan, pencarian);
                } else if (Kriteria.equals("nip")) {
                    pnsBawahan = dbquerypns.getDBqueryBawahanByNIP(_iunorAtasan, pencarian);
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return pnsBawahan;
    }

    public String getSimpanFotoBlob(String nippns, FileInputStream fotobinari) {

        DBConnection dbConn = DBConnection.getInstance();
        //  isi4faktor Isi4faktor = new isi4faktor();

        String berhasil = "Data BLOB Berhasil di Update";
        DBqueryAdministrator dBqueryAdministrator = new DBqueryAdministrator(dbConn.getConnection());
        if (nippns == null) {
            nippns = "0";
        }

        String _nippns = nippns;
        FileInputStream _fotobinari = fotobinari;

        try {
            if (!_nippns.equals("0")) {
                dBqueryAdministrator.insertFotoBlob(_nippns, _fotobinari);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return berhasil;
    }

    public jabfung getJabatanFungsional(String Jabatan) {
        DBConnection dbConn = DBConnection.getInstance();

        jabfung kelJabFung = new jabfung();
        //jabfung kelJabFung = null;
        String berhasil = "Data Berhasil di Hapus";
        DBqueryJabatan dBqueryJabatan = new DBqueryJabatan(dbConn.getConnection());
        if (Jabatan == null) {
            Jabatan = "0";
        }



        try {
            if (!Jabatan.equals("0")) {
                kelJabFung = dBqueryJabatan.getDBqueryKelompokJabatan(Jabatan);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return kelJabFung;
    }

    public jabfum getJabatanUmum(String Jabatan) {
        DBConnection dbConn = DBConnection.getInstance();

        jabfum kelJabFum = new jabfum();
        //jabfung kelJabFung = null;
        String berhasil = "Data Berhasil di Hapus";
        DBqueryJabatan dBqueryJabatan = new DBqueryJabatan(dbConn.getConnection());
        if (Jabatan == null) {
            Jabatan = "0";
        }



        try {
            if (!Jabatan.equals("0")) {
                kelJabFum = dBqueryJabatan.getDBqueryJabatanUmum(Jabatan);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return kelJabFum;
    }

    public kelompokJabatan getKelompokJabatan(String Jabatan) {
        DBConnection dbConn = DBConnection.getInstance();

        kelompokJabatan kelJabFung = new kelompokJabatan();
        //jabfung kelJabFung = null;
        String berhasil = "Data Berhasil di Hapus";
        DBqueryJabatan dBqueryJabatan = new DBqueryJabatan(dbConn.getConnection());
        if (Jabatan == null) {
            Jabatan = "0";
        }



        try {
            if (!Jabatan.equals("0")) {
                kelJabFung = dBqueryJabatan.getDBqueryKelompok(Jabatan);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return kelJabFung;
    }

    public List<kelompokJabatan> getSatuRumpun(String kelompok) {
        DBConnection dbConn = DBConnection.getInstance();
        List<kelompokJabatan> jabfung = new ArrayList<kelompokJabatan>();
        DBqueryJabatan dBqueryJabatan = new DBqueryJabatan(dbConn.getConnection());

        if (kelompok.equals(null) || kelompok.equals("") || kelompok.equals("null")) {
            kelompok = "0";
        }



        try {
            if (!kelompok.equals("0")) {
                jabfung = dBqueryJabatan.getDBqueryRumpunJabatan(kelompok);
            } else {
                jabfung = dBqueryJabatan.getDBqueryRumpunJabatanAll(kelompok);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return jabfung;
    }

    public List<jabfum> getRumpunUmum(String namaUmum) {
        DBConnection dbConn = DBConnection.getInstance();
        List<jabfum> jabfum = new ArrayList<jabfum>();
        DBqueryJabatan dBqueryJabatan = new DBqueryJabatan(dbConn.getConnection());

        if (namaUmum.equals("null") || namaUmum.equals("") || namaUmum.equals(null)) {
            namaUmum = "0";
        }



        try {
            if (namaUmum.equals("0")) {
                jabfum = dBqueryJabatan.getDBquerySemuaUmum(namaUmum);
            } else {
                jabfum = dBqueryJabatan.getDBqueryUmumbyNama(namaUmum);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return jabfum;
    }

    public List<jabfum> getRumpunUmumById(String IdUmum) {
        DBConnection dbConn = DBConnection.getInstance();
        List<jabfum> jabfum = new ArrayList<jabfum>();
        DBqueryJabatan dBqueryJabatan = new DBqueryJabatan(dbConn.getConnection());


        if (IdUmum == null) {
            IdUmum = "0";
        }

        if (IdUmum.equals("null") || IdUmum.equals("") || IdUmum.equals(null)) {
            IdUmum = "0";
        }



        try {
            if (!IdUmum.equals("0")) {
                jabfum = dBqueryJabatan.getDBqueryUmumbyId(IdUmum);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return jabfum;
    }

    public List<jabfung> getSatuRumpunFungsionalId(String kelompok, String idJabfung) {
        DBConnection dbConn = DBConnection.getInstance();
        List<jabfung> jabfung = new ArrayList<jabfung>();
        DBqueryJabatan dBqueryJabatan = new DBqueryJabatan(dbConn.getConnection());

        if (kelompok == null) {
            kelompok = "0";
        }



        try {
            if (!kelompok.equals("0")) {
                jabfung = dBqueryJabatan.getDBquerySatuRumpunJabatanIdDanIdJabfung(kelompok, idJabfung);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return jabfung;
    }

    public List<jabfung> getListJabatanFungsional(String Jabatan) {
        DBConnection dbConn = DBConnection.getInstance();
        List<jabfung> kelJabFung = new ArrayList<jabfung>();
        // jabfung kelJabFung = new jabfung();
        //jabfung kelJabFung = null;
        String berhasil = "Data Berhasil di Hapus";
        DBqueryJabatan dBqueryJabatan = new DBqueryJabatan(dbConn.getConnection());
        if (Jabatan == null) {
            Jabatan = "0";
        }



        try {
            if (!Jabatan.equals("0")) {
                kelJabFung = dBqueryJabatan.getDBqueryListJabFungsional(Jabatan);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return kelJabFung;
    }

    public List<jabfung> getSatuRumpunFungsional(String kelompok) {
        DBConnection dbConn = DBConnection.getInstance();
        List<jabfung> jabfung = new ArrayList<jabfung>();
        DBqueryJabatan dBqueryJabatan = new DBqueryJabatan(dbConn.getConnection());

        if (kelompok == null) {
            kelompok = "0";
        }



        try {
            if (!kelompok.equals("0")) {
                jabfung = dBqueryJabatan.getDBquerySatuRumpunJabatan(kelompok);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return jabfung;
    }
}
