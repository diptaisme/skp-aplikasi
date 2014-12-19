/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.GoIndex;
import model.IsiTargetBulanan;
import model.PnsSkp;
import model.TupoksiKeIsi4Faktor;
import model.TupoksiRevisiTarget;
import model.tupoksi_lama;

/**
 *
 * @author radius
 */
public class LaporanBulananServlet extends HttpServlet {

    String P_nipbaru;
    String idtupoksidijsp;
    String namaTupoksijsp;
    String namaAngka_krdtjsp;
    String namaAngka_krdtjspR;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LaporanBulananServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LaporanBulananServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



        HttpSession session = request.getSession();
        String param = request.getParameter("param");

        String paramRealisasi = request.getParameter("paramRealisasi");
        String userSession = (String) session.getAttribute("user");
        String P_idTupoksi = request.getParameter("idtupoksidiSesiion");

        String NipPnsSession = (String) session.getAttribute("NipPnsSession");
        String _pilih_session = request.getParameter("pilih_session");
        String idisi4faktor = request.getParameter("getIdIsi4Faktor");
        String sessionwaktu = request.getParameter("session");
        String getIdUbah = request.getParameter("getidbulan");
        String getidbulanHapus = request.getParameter("getidbulanHapus");

        String getnipBaruTargetBulanKembali = request.getParameter("nipBaruTargetBulanKembali");
        List<IsiTargetBulanan> isiTargetBulanan = new ArrayList<IsiTargetBulanan>();

        if (getIdUbah != null) {
            String getidITupoksiBulalanList = request.getParameter("getidITupoksiBulalanList");
            P_idTupoksi = getidITupoksiBulalanList;
            idtupoksidijsp = P_idTupoksi;
            IsiTargetBulanan Realkesi = new IsiTargetBulanan();
            Realkesi = new GoIndex().getIsiTargetBulananId(getIdUbah);
            TupoksiKeIsi4Faktor TKI4F = new TupoksiKeIsi4Faktor();
            String getidIsi$faktorList = request.getParameter("getidIsi$faktorList");
            idisi4faktor = getidIsi$faktorList;
            TKI4F = new GoIndex().getTupoksi4(idisi4faktor);

            request.setAttribute("kuantitasTahun", TKI4F.getKuantitas4());
            request.setAttribute("kualitasTahun", TKI4F.getKualitas4());
            request.setAttribute("waktuTahun", TKI4F.getWaktu4());
            //request.setAttribute("tukesiServlet", tukesiServlet);
            request.setAttribute("biayaTahun", TKI4F.getBiaya4());
            request.setAttribute("getIdIsi4Faktor", idisi4faktor);

            request.setAttribute("kuantitasBulanText", Realkesi.getkuantitas_bulan());
            request.setAttribute("kualitasBulanText", Realkesi.getkualitas_bulan());
            request.setAttribute("waktuBulanText", Realkesi.getwaktu_bulan());
            //request.setAttribute("tukesiServlet", tukesiServlet);
            request.setAttribute("biayaBulanText", Realkesi.biaya_bulan());
            request.setAttribute("getIdIsi4Faktor", idisi4faktor);
            request.setAttribute("bulankeText", Realkesi.getbulanke());
            request.setAttribute("idtupoksidijsp", P_idTupoksi);

            String iNip_id = null;
            if (ModelLocatorSKP.loginNipPengguna != null) {
                iNip_id = ModelLocatorSKP.loginNipPengguna;
            } else {
                iNip_id = NipPnsSession;
            }
            isiTargetBulanan = new GoIndex().getIsiTargetBulananAll(P_idTupoksi, iNip_id, idisi4faktor);
            request.setAttribute("isiTargetBulanan", isiTargetBulanan);
            String kualitasMaxBulan = "0";
            String kuanitasMaxBulan = "0";
            String waktusMaxBulan = "0";
            String biayaMaxBulan = "0";


            for (IsiTargetBulanan tukesiDomain : isiTargetBulanan) {
                kualitasMaxBulan = tukesiDomain.getkualitas_bulan();
                kuanitasMaxBulan = tukesiDomain.getkuantitas_bulan();
                waktusMaxBulan = tukesiDomain.getwaktu_bulan();
                biayaMaxBulan = tukesiDomain.biaya_bulan();
            }
            double d_kualitasMaxBulan;
            double d_kuanitasMaxBulan;
            double d_waktusMaxBulan;
            double d_biayaMaxBulan;
            d_kualitasMaxBulan = Double.parseDouble(kualitasMaxBulan);
            d_kuanitasMaxBulan = Double.parseDouble(kuanitasMaxBulan);
            d_waktusMaxBulan = Double.parseDouble(waktusMaxBulan);
            d_biayaMaxBulan = Double.parseDouble(biayaMaxBulan);

             d_kualitasMaxBulan = (d_kualitasMaxBulan / 100) * Double.parseDouble(TKI4F.getKualitas4());
            d_kuanitasMaxBulan = (d_kuanitasMaxBulan / 100) * Double.parseDouble(TKI4F.getKuantitas4());
            d_waktusMaxBulan = (d_waktusMaxBulan / 100) * Double.parseDouble(TKI4F.getWaktu4());
             d_biayaMaxBulan = (d_biayaMaxBulan / 100) * Double.parseDouble(TKI4F.getBiaya4());

            kualitasMaxBulan = Double.toString(d_kualitasMaxBulan);
            kuanitasMaxBulan = Double.toString(d_kuanitasMaxBulan);
            waktusMaxBulan = Double.toString(d_waktusMaxBulan);


            request.setAttribute("kualitasMaxBulan", kualitasMaxBulan);
            request.setAttribute("kuanitasMaxBulan", kuanitasMaxBulan);
            request.setAttribute("waktusMaxBulan", waktusMaxBulan);
            request.setAttribute("biayaMaxBulan", biayaMaxBulan);

            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/Bulalanan.jsp");
            dis.forward(request, response);
        } else if (getidbulanHapus != null) {
            String getidITupoksiBulalanList = request.getParameter("getidITupoksiBulalanList");
            P_idTupoksi = getidITupoksiBulalanList;
            idtupoksidijsp = P_idTupoksi;
            IsiTargetBulanan Realkesi = new IsiTargetBulanan();
            try {
                String berhasil30 = new GoIndex().getDeleteIsiTargetBulanke(getidbulanHapus);
            } catch (Exception ex) {
                Logger.getLogger(LaporanBulananServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            TupoksiKeIsi4Faktor TKI4F = new TupoksiKeIsi4Faktor();
            String getidIsi$faktorList = request.getParameter("getidIsi$faktorList");
            idisi4faktor = getidIsi$faktorList;
            TKI4F = new GoIndex().getTupoksi4(idisi4faktor);

            request.setAttribute("kuantitasTahun", TKI4F.getKuantitas4());
            request.setAttribute("kualitasTahun", TKI4F.getKualitas4());
            request.setAttribute("waktuTahun", TKI4F.getWaktu4());
            //request.setAttribute("tukesiServlet", tukesiServlet);
            request.setAttribute("biayaTahun", TKI4F.getBiaya4());
            request.setAttribute("getIdIsi4Faktor", idisi4faktor);

            request.setAttribute("kuantitasBulanText", Realkesi.getkuantitas_bulan());
            request.setAttribute("kualitasBulanText", Realkesi.getkualitas_bulan());
            request.setAttribute("waktuBulanText", Realkesi.getwaktu_bulan());
            //request.setAttribute("tukesiServlet", tukesiServlet);
            request.setAttribute("biayaBulanText", Realkesi.biaya_bulan());
            request.setAttribute("getIdIsi4Faktor", idisi4faktor);
            request.setAttribute("bulankeText", Realkesi.getbulanke());
            request.setAttribute("idtupoksidijsp", P_idTupoksi);

            String iNip_id = null;
            if (ModelLocatorSKP.loginNipPengguna != null) {
                iNip_id = ModelLocatorSKP.loginNipPengguna;
            } else {
                iNip_id = NipPnsSession;
            }
            isiTargetBulanan = new GoIndex().getIsiTargetBulananAll(P_idTupoksi, iNip_id, idisi4faktor);
            request.setAttribute("isiTargetBulanan", isiTargetBulanan);
            String kualitasMaxBulan = "0";
            String kuanitasMaxBulan = "0";
            String waktusMaxBulan = "0";
            String biayaMaxBulan = "0";


            for (IsiTargetBulanan tukesiDomain : isiTargetBulanan) {
                kualitasMaxBulan = tukesiDomain.getkualitas_bulan();
                kuanitasMaxBulan = tukesiDomain.getkuantitas_bulan();
                waktusMaxBulan = tukesiDomain.getwaktu_bulan();
                biayaMaxBulan = tukesiDomain.biaya_bulan();
            }

            double d_kualitasMaxBulan;
            double d_kuanitasMaxBulan;
            double d_waktusMaxBulan;
            double d_biayaMaxBulan;

            d_kualitasMaxBulan = Double.parseDouble(kualitasMaxBulan);
            d_kuanitasMaxBulan = Double.parseDouble(kuanitasMaxBulan);
            d_waktusMaxBulan = Double.parseDouble(waktusMaxBulan);
            d_biayaMaxBulan = Double.parseDouble(biayaMaxBulan);

            d_kualitasMaxBulan = (d_kualitasMaxBulan / 100) * Double.parseDouble(TKI4F.getKualitas4());
            d_kuanitasMaxBulan = (d_kuanitasMaxBulan / 100) * Double.parseDouble(TKI4F.getKuantitas4());
            d_waktusMaxBulan = (d_waktusMaxBulan / 100) * Double.parseDouble(TKI4F.getWaktu4());
             d_biayaMaxBulan = (d_biayaMaxBulan / 100) * Double.parseDouble(TKI4F.getBiaya4());

            kualitasMaxBulan = Double.toString(d_kualitasMaxBulan);
            kuanitasMaxBulan = Double.toString(d_kuanitasMaxBulan);
            waktusMaxBulan = Double.toString(d_waktusMaxBulan);


            request.setAttribute("kualitasMaxBulan", kualitasMaxBulan);
            request.setAttribute("kuanitasMaxBulan", kuanitasMaxBulan);
            request.setAttribute("waktusMaxBulan", waktusMaxBulan);
            request.setAttribute("biayaMaxBulan", biayaMaxBulan);

            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/Bulalanan.jsp");
            dis.forward(request, response);
        } else if (getnipBaruTargetBulanKembali != null) {
            String idTargetBulan = request.getParameter("idIsi4faktorBulan");
            String idtupoksidiSesiion = request.getParameter("idtupoksidiSesiion_");
            NipPnsSession = (String) session.getAttribute("NipPnsSession");
            idisi4faktor = idTargetBulan;
            String iNip_id = null;
            if (ModelLocatorSKP.loginNipPengguna != null) {
                iNip_id = ModelLocatorSKP.loginNipPengguna;
            } else {
                iNip_id = NipPnsSession;
            }
            TupoksiKeIsi4Faktor tupoksiKeIsi4Faktor = new TupoksiKeIsi4Faktor();
            tupoksiKeIsi4Faktor = new GoIndex().getTupoksi4(idisi4faktor);

            PnsSkp pnsp = new GoIndex().getPns(iNip_id);
            //   TupoksiKeIsi4Faktor tupoksiKeIsi4Faktor = new GoIndex().getTupoksi(_idTupoksi);

            request.setAttribute("pnsp", pnsp);
            request.setAttribute("tupoksiKeIsi4Faktor", tupoksiKeIsi4Faktor);

            if (tupoksiKeIsi4Faktor != null) {
                tupoksi_lama Tupoksi = new GoIndex().getIdtupoksi(tupoksiKeIsi4Faktor.getIdTupoksi());
                idtupoksidijsp = Tupoksi.getIdTupoksi();
                namaTupoksijsp = Tupoksi.getNamaTupoksi();
                namaAngka_krdtjspR = Tupoksi.getangka_krdt();
                request.setAttribute("idtupoksidijsp", idtupoksidijsp);
                request.setAttribute("namaTupoksijsp", namaTupoksijsp);
                request.setAttribute("namaAngka_krdtjsp", namaAngka_krdtjspR);
                request.setAttribute("sesiontahun", tupoksiKeIsi4Faktor.getpilih_session());
            }
            //    request.setAttribute("alerting", _Isi4Faktor);
            //RequestDispatcher dis=request.getRequestDispatcher("isi4faktor.jsp");
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/isi4faktorBaru.jsp");
            //PrintWriter out = response.getWriter();
            dis.include(request, response);

        }
        // processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);

        String P_idTupoksi;
        HttpSession session = request.getSession();
        String param = request.getParameter("param");

        String paramRealisasi = request.getParameter("paramRealisasi");
        String userSession = (String) session.getAttribute("user");
        P_idTupoksi = request.getParameter("idtupoksidiSesiion");

        String NipPnsSession = (String) session.getAttribute("NipPnsSession");
        String _pilih_session = request.getParameter("pilih_session");
        String idisi4faktor = request.getParameter("getIdIsi4Faktor");
        String sessionwaktu = request.getParameter("session");
        String getId = request.getParameter("getId");
        session.setAttribute("levelPemakaian", ModelLocatorSKP.levelUser);

        if (param != null) {
            P_idTupoksi = request.getParameter("idtupoksidiSesiion");
            //if(param.equalsIgnoreCase("SAVE"))
            if (param.equalsIgnoreCase("SIMPAN")) {

                //---------------------------------
                String _idTupoksi = P_idTupoksi;
                String _bulankeText = request.getParameter("bulankeText");
                String _kuantitas4text = request.getParameter("kuantitasBulanText");
                String _kualitas4text = request.getParameter("kualitasBulanText");
                String _waktu4text = request.getParameter("waktuBulanText");
                String _biaya4text = request.getParameter("biayaBulanText");
                String _angkaKredit = request.getParameter("akt");
                String __getidUnor4jspSesiion = request.getParameter("_getidUnor4jspSesiion");

                String _biayaBulanText = request.getParameter("biayaBulanText");
                String _waktuBulanText = request.getParameter("waktuBulanText");

                String _kuantitasBulanText = request.getParameter("kuantitasBulanText");
                String _kualitasBulanText = request.getParameter("kualitasBulanText");
                String _BulankeText = request.getParameter("bulankeText");




                String iNip_id = null;
                if (ModelLocatorSKP.loginNipPengguna != null) {
                    iNip_id = ModelLocatorSKP.loginNipPengguna;
                } else {
                    iNip_id = NipPnsSession;
                }

                String pilih = request.getParameter("pilih_output");
                pilih = "x";
                String waktuL = "bln";

                if (!"-".equals(pilih)) {
                    // isi4faktor Isi4Faktor = new GoIndex().getsimpanIsiEmpatFaktor(_idTupoksi, _kuantitas4text, _kualitas4text, _waktu4text, _biaya4text);

                    //  String _Isi4Faktor = new GoIndex().getsimpanIsiEmpatFaktor(iNip_id,_idTupoksi, _kuantitas4text, _kualitas4text, _waktu4text, _biaya4text, pilih, waktuL,_angkaKredit);
                    String _Isi4FaktorRevisi = null;
                    List<IsiTargetBulanan> isiTargetBulanan = new ArrayList<IsiTargetBulanan>();
                    try {
                        isiTargetBulanan = new GoIndex().getIsiTargetBulanke(P_idTupoksi, iNip_id, idisi4faktor, _BulankeText);
                    } catch (SQLException ex) {
                        Logger.getLogger(LaporanBulananServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    if (isiTargetBulanan.isEmpty()) {
                        try {
                            String berhasil = new GoIndex().getInsertIsiTargetBulanke(null, idisi4faktor, iNip_id, P_idTupoksi, _kuantitas4text, _kualitas4text, _waktu4text, _biaya4text, _bulankeText);
                        } catch (Exception ex) {
                            Logger.getLogger(LaporanBulananServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        try {
                            String berhasil = new GoIndex().getUpdateIsiTargetBulanke(getId, idisi4faktor, iNip_id, P_idTupoksi, _kuantitas4text, _kualitas4text, _waktu4text, _biaya4text, _bulankeText);
                        } catch (Exception ex) {
                            Logger.getLogger(LaporanBulananServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    TupoksiKeIsi4Faktor TKI4F = new TupoksiKeIsi4Faktor();
                    TKI4F = new GoIndex().getTupoksi4(idisi4faktor);


                    String xidTupoksi = request.getParameter("idTupoksi");
                    String nip = request.getParameter("nipnilai");

                    PnsSkp pnsp = new GoIndex().getPns(iNip_id);
                    TupoksiKeIsi4Faktor tupoksiKeIsi4Faktor = new GoIndex().getTupoksi(_idTupoksi);

                    request.setAttribute("pns", pnsp);
                    request.setAttribute("tupoksiKeIsi4Faktor", tupoksiKeIsi4Faktor);

                    if (tupoksiKeIsi4Faktor != null) {
                        tupoksi_lama Tupoksi = new GoIndex().getIdtupoksi(P_idTupoksi);
                        idtupoksidijsp = Tupoksi.getIdTupoksi();
                        namaTupoksijsp = Tupoksi.getNamaTupoksi();
                        namaAngka_krdtjspR = Tupoksi.getangka_krdt();
                        request.setAttribute("idtupoksidijsp", idtupoksidijsp);
                        request.setAttribute("namaTupoksijsp", namaTupoksijsp);
                        request.setAttribute("namaAngka_krdtjsp", namaAngka_krdtjspR);
                        request.setAttribute("sesiontahun", sessionwaktu);
                    }

                    request.setAttribute("kuantitasTahun", TKI4F.getKuantitas4());
                    request.setAttribute("kualitasTahun", TKI4F.getKualitas4());
                    request.setAttribute("waktuTahun", TKI4F.getWaktu4());
                    //request.setAttribute("tukesiServlet", tukesiServlet);
                    request.setAttribute("biayaTahun", TKI4F.getBiaya4());
                    request.setAttribute("getIdIsi4Faktor", idisi4faktor);

                    isiTargetBulanan = new GoIndex().getIsiTargetBulananAll(P_idTupoksi, iNip_id, idisi4faktor);
                    request.setAttribute("isiTargetBulanan", isiTargetBulanan);

                    String kualitasMaxBulan = "0";
                    String kuanitasMaxBulan = "0";
                    String waktusMaxBulan = "0";
                    String biayaMaxBulan = "0";


                    for (IsiTargetBulanan tukesiDomain : isiTargetBulanan) {
                        kualitasMaxBulan = tukesiDomain.getkualitas_bulan();
                        kuanitasMaxBulan = tukesiDomain.getkuantitas_bulan();
                        waktusMaxBulan = tukesiDomain.getwaktu_bulan();
                        biayaMaxBulan = tukesiDomain.biaya_bulan();
                    }

                    double d_kualitasMaxBulan;
                    double d_kuanitasMaxBulan;
                    double d_waktusMaxBulan;
                    double d_biayaMaxBulan;

                    d_kualitasMaxBulan = Double.parseDouble(kualitasMaxBulan);
                    d_kuanitasMaxBulan = Double.parseDouble(kuanitasMaxBulan);
                    d_waktusMaxBulan = Double.parseDouble(waktusMaxBulan);
                    d_biayaMaxBulan = Double.parseDouble(biayaMaxBulan);

                    d_kualitasMaxBulan = (d_kualitasMaxBulan / 100) * Double.parseDouble(TKI4F.getKualitas4());
                    d_kuanitasMaxBulan = (d_kuanitasMaxBulan / 100) * Double.parseDouble(TKI4F.getKuantitas4());
                    d_waktusMaxBulan = (d_waktusMaxBulan / 100) * Double.parseDouble(TKI4F.getWaktu4());
                     d_biayaMaxBulan = (d_biayaMaxBulan / 100) * Double.parseDouble(TKI4F.getBiaya4());

                    kualitasMaxBulan = Double.toString(d_kualitasMaxBulan);
                    kuanitasMaxBulan = Double.toString(d_kuanitasMaxBulan);
                    waktusMaxBulan = Double.toString(d_waktusMaxBulan);

                    request.setAttribute("kualitasMaxBulan", kualitasMaxBulan);
                    request.setAttribute("kuanitasMaxBulan", kuanitasMaxBulan);
                    request.setAttribute("waktusMaxBulan", waktusMaxBulan);
                    request.setAttribute("biayaMaxBulan", biayaMaxBulan);

                    RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/Bulalanan.jsp");
                    //PrintWriter out = response.getWriter();
                    dis.include(request, response);
                }
                //out.println(_Isi4Faktor);
                //---------------------------------



            } else if (param.equalsIgnoreCase("LIHAT")) {
                String _idTupoksi = P_idTupoksi;

                String _detailkegiatan = request.getParameter("detailkegiatan");
                String _kuantitas4text = request.getParameter("kuantitasTahun");
                String _kualitas4text = request.getParameter("kualitasTahun");
                String _waktu4text = request.getParameter("waktuTahun");
                String _biaya4text = request.getParameter("biayaTahun");
                List<IsiTargetBulanan> isiTargetBulanan = new ArrayList<IsiTargetBulanan>();

                String iNip_id = null;
                if (ModelLocatorSKP.loginNipPengguna != null) {
                    iNip_id = ModelLocatorSKP.loginNipPengguna;
                } else {
                    iNip_id = NipPnsSession;
                }
                PnsSkp pnsp = new GoIndex().getPns(iNip_id);
                TupoksiKeIsi4Faktor tupoksiKeIsi4Faktor = new GoIndex().getTupoksi(_idTupoksi);
                request.setAttribute("tupoksiKeIsi4Faktor", tupoksiKeIsi4Faktor);

                request.setAttribute("pnsp", pnsp);
                isiTargetBulanan = new GoIndex().getIsiTargetBulananAll(P_idTupoksi, iNip_id, idisi4faktor);
                request.setAttribute("isiTargetBulanan", isiTargetBulanan);
                tupoksi_lama Tupoksi = new GoIndex().getIdtupoksi(P_idTupoksi);
                idtupoksidijsp = Tupoksi.getIdTupoksi();
                namaTupoksijsp = Tupoksi.getNamaTupoksi();
                namaAngka_krdtjspR = Tupoksi.getangka_krdt();
                request.setAttribute("idtupoksidijsp", idtupoksidijsp);
                request.setAttribute("namaTupoksijsp", namaTupoksijsp);
                request.setAttribute("namaAngka_krdtjsp", namaAngka_krdtjspR);
                request.setAttribute("sesiontahun", sessionwaktu);
                request.setAttribute("getIdIsi4Faktor", idisi4faktor);
                TupoksiKeIsi4Faktor TKI4F = new TupoksiKeIsi4Faktor();
                TKI4F = new GoIndex().getTupoksi4(idisi4faktor);
                request.setAttribute("kuantitasTahun", _kuantitas4text);
                request.setAttribute("kualitasTahun", _kualitas4text);
                request.setAttribute("waktuTahun", _waktu4text);
                //request.setAttribute("tukesiServlet", tukesiServlet);
                request.setAttribute("biayaTahun", _biaya4text);
                session.setAttribute("levelPemakaian", ModelLocatorSKP.levelUser);
                isiTargetBulanan = new GoIndex().getIsiTargetBulananAll(P_idTupoksi, iNip_id, idisi4faktor);
                request.setAttribute("isiTargetBulanan", isiTargetBulanan);

                String kualitasMaxBulan = "0";
                String kuanitasMaxBulan = "0";
                String waktusMaxBulan = "0";
                String biayaMaxBulan = "0";


                for (IsiTargetBulanan tukesiDomain : isiTargetBulanan) {
                    kualitasMaxBulan = tukesiDomain.getkualitas_bulan();
                    kuanitasMaxBulan = tukesiDomain.getkuantitas_bulan();
                    waktusMaxBulan = tukesiDomain.getwaktu_bulan();
                    biayaMaxBulan = tukesiDomain.biaya_bulan();
                }
                double d_kualitasMaxBulan;
                double d_kuanitasMaxBulan;
                double d_waktusMaxBulan;
                double d_biayaMaxBulan;
                d_kualitasMaxBulan = Double.parseDouble(kualitasMaxBulan);
                d_kuanitasMaxBulan = Double.parseDouble(kuanitasMaxBulan);
                d_waktusMaxBulan = Double.parseDouble(waktusMaxBulan);
                d_biayaMaxBulan = Double.parseDouble(biayaMaxBulan);

                 d_kualitasMaxBulan = (d_kualitasMaxBulan / 100) * Double.parseDouble(TKI4F.getKualitas4());
                d_kuanitasMaxBulan = (d_kuanitasMaxBulan / 100) * Double.parseDouble(TKI4F.getKuantitas4());
                d_waktusMaxBulan = (d_waktusMaxBulan / 100) * Double.parseDouble(TKI4F.getWaktu4());
                 d_biayaMaxBulan = (d_biayaMaxBulan / 100) * Double.parseDouble(TKI4F.getBiaya4());

                kualitasMaxBulan = Double.toString(d_kualitasMaxBulan);
                kuanitasMaxBulan = Double.toString(d_kuanitasMaxBulan);
                waktusMaxBulan = Double.toString(d_waktusMaxBulan);
                request.setAttribute("kualitasMaxBulan", kualitasMaxBulan);
                request.setAttribute("kuanitasMaxBulan", kuanitasMaxBulan);
                request.setAttribute("waktusMaxBulan", waktusMaxBulan);
                request.setAttribute("biayaMaxBulan", biayaMaxBulan);


                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/Bulalanan.jsp");
                dis.forward(request, response);



            } else if (param.equalsIgnoreCase("LANJUT")) {
                String _idTupoksi = P_idTupoksi;
                String _detailkegiatan = request.getParameter("detailkegiatan");
                String _kuantitas4text = request.getParameter("kuantitas4text");
                String _kualitas4text = request.getParameter("kualitas4text");
                String _waktu4text = request.getParameter("waktu4text");
                String _biaya4text = request.getParameter("biaya4text");
                String _angkaKredit = request.getParameter("akt");
                String __getidUnor4jspSesiion = request.getParameter("_getidUnor4jspSesiion");
                String iNip_id = null;
                List<IsiTargetBulanan> isiTargetBulanan = new ArrayList<IsiTargetBulanan>();
                if (ModelLocatorSKP.loginNipPengguna != null) {
                    iNip_id = ModelLocatorSKP.loginNipPengguna;
                } else {
                    iNip_id = NipPnsSession;
                }

                tupoksi_lama Tupoksi = new GoIndex().getIdtupoksi(P_idTupoksi);
                idtupoksidijsp = Tupoksi.getIdTupoksi();
                namaTupoksijsp = Tupoksi.getNamaTupoksi();
                namaAngka_krdtjspR = Tupoksi.getangka_krdt();
                request.setAttribute("idtupoksidijsp", idtupoksidijsp);
                request.setAttribute("namaTupoksijsp", namaTupoksijsp);

                PnsSkp pnsp = new GoIndex().getPns(iNip_id);
                TupoksiKeIsi4Faktor tupoksiKeIsi4Faktor = new GoIndex().getTupoksi(_idTupoksi);
                request.setAttribute("tupoksiKeIsi4Faktor", tupoksiKeIsi4Faktor);


                String xidTupoksi = request.getParameter("idTupoksi");
                String nip = request.getParameter("nipnilai");

                request.setAttribute("kuantitasTahun", _kuantitas4text);
                request.setAttribute("kualitasTahun", _kualitas4text);
                request.setAttribute("waktuTahun", _waktu4text);
                //request.setAttribute("tukesiServlet", tukesiServlet);
                request.setAttribute("biayaTahun", _biaya4text);
                request.setAttribute("getIdIsi4Faktor", idisi4faktor);
                //request.setAttribute("biayaTahun", _biaya4text);

                isiTargetBulanan = new GoIndex().getIsiTargetBulananAll(P_idTupoksi, iNip_id, idisi4faktor);
                request.setAttribute("isiTargetBulanan", isiTargetBulanan);
                session.setAttribute("levelPemakaian", ModelLocatorSKP.levelUser);

                String kualitasMaxBulan = "0";
                String kuanitasMaxBulan = "0";
                String waktusMaxBulan = "0";
                String biayaMaxBulan = "0";
                TupoksiKeIsi4Faktor TKI4F = new TupoksiKeIsi4Faktor();
                TKI4F = new GoIndex().getTupoksi4(idisi4faktor);

                for (IsiTargetBulanan tukesiDomain : isiTargetBulanan) {
                    kualitasMaxBulan = tukesiDomain.getkualitas_bulan();
                    kuanitasMaxBulan = tukesiDomain.getkuantitas_bulan();
                    waktusMaxBulan = tukesiDomain.getwaktu_bulan();
                    biayaMaxBulan = tukesiDomain.biaya_bulan();
                }
                double d_kualitasMaxBulan;
                double d_kuanitasMaxBulan;
                double d_waktusMaxBulan;
                double d_biayaMaxBulan;
                d_kualitasMaxBulan = Double.parseDouble(kualitasMaxBulan);
                d_kuanitasMaxBulan = Double.parseDouble(kuanitasMaxBulan);
                d_waktusMaxBulan = Double.parseDouble(waktusMaxBulan);
                d_biayaMaxBulan = Double.parseDouble(biayaMaxBulan);

                d_kualitasMaxBulan = (d_kualitasMaxBulan / 100) * Double.parseDouble(TKI4F.getKualitas4());
                d_kuanitasMaxBulan = (d_kuanitasMaxBulan / 100) * Double.parseDouble(TKI4F.getKuantitas4());
                d_waktusMaxBulan = (d_waktusMaxBulan / 100) * Double.parseDouble(TKI4F.getWaktu4());
                d_biayaMaxBulan = (d_biayaMaxBulan / 100) * Double.parseDouble(TKI4F.getBiaya4());

                kualitasMaxBulan = Double.toString(d_kualitasMaxBulan);
                kuanitasMaxBulan = Double.toString(d_kuanitasMaxBulan);
                waktusMaxBulan = Double.toString(d_waktusMaxBulan);
                request.setAttribute("kualitasMaxBulan", kualitasMaxBulan);
                request.setAttribute("kuanitasMaxBulan", kuanitasMaxBulan);
                request.setAttribute("waktusMaxBulan", waktusMaxBulan);
                request.setAttribute("biayaMaxBulan", biayaMaxBulan);


                request.setAttribute("kualitasMaxBulan", kualitasMaxBulan);
                request.setAttribute("kuanitasMaxBulan", kuanitasMaxBulan);
                request.setAttribute("waktusMaxBulan", waktusMaxBulan);
                request.setAttribute("biayaMaxBulan", biayaMaxBulan);

                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/Bulalanan.jsp");
                dis.forward(request, response);
            }

        } else {
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/Bulalanan.jsp");
            dis.forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
