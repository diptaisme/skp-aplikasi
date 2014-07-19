/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.GoIndex;
import model.PnsSkp;
import model.RealisasiIsi4faktorTupoksi;
import model.TupoksiKeIsi4Faktor;
import model.TupoksiRevisiTarget;
import model.tupoksi_lama;

/**
 *
 * @author Sony
 */
public class RevisiServlet extends HttpServlet {

    String P_nipbaru;
    String idtupoksidijsp;
    String namaTupoksijsp;
    String namaAngka_krdtjsp;
    String namaAngka_krdtjspR;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RevisiServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RevisiServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String P_idTupoksi;
        RequestDispatcher dis = null;
        String STupoksiKode = (String) request.getAttribute("STupoksiKode");
        String SnamaTupoksi = (String) request.getAttribute("SnamaTupoksi");
        String Snipbaru = (String) request.getAttribute("Snipbaru");
        String sNama = (String) request.getAttribute("sNama");
        String _pilih_session = request.getParameter("pilih_session");
        String action = request.getParameter("action");
        String nipsendiriR = request.getParameter("nipsendiriR");
        String nipsendiriMonitoring = request.getParameter("nipsendiriMonitoring");
        String idB = request.getParameter("txtNIPBaruB");
        String idRevisiHapus= request.getParameter("idRevisiHapus");

        P_idTupoksi = STupoksiKode;
        P_nipbaru = Snipbaru;
        String idtupoksidijspreal;
        String namaTupoksijspreal;
        String idTupoksi4 = request.getParameter("idTupoksi");
        String nipnilai4 = request.getParameter("nipnilai");
        String nipHapus=request.getParameter("nipHapusi");
        String _getidUnor4 = request.getParameter("_idUnor");
        String getIdIsi4Faktor = request.getParameter("getIdIsi4Faktor");
        String idTupoksiR = request.getParameter("idTupoksiR");
        String nipnilaiR = request.getParameter("nipnilaiR");
        String i_dTupoksiHapus = request.getParameter("idTupoksiHapus");
        String i_nipHapus = request.getParameter("nipHapus");
        if (idTupoksi4 != null && nipnilai4 != null) {
            P_idTupoksi = idTupoksi4;
            P_nipbaru = nipnilai4;
            String _idUnor4 = request.getParameter("_idUnor");
            _getidUnor4 = request.getParameter("_idUnor");
            PnsSkp pnsp = new GoIndex().getPns(nipnilai4);
            TupoksiKeIsi4Faktor tupoksiKeIsi4Faktor = new GoIndex().getTupoksi4(getIdIsi4Faktor);
            idtupoksidijsp = tupoksiKeIsi4Faktor.getIdTupoksi();
            namaTupoksijsp = tupoksiKeIsi4Faktor.getNamaTupoksi();
            namaAngka_krdtjsp = tupoksiKeIsi4Faktor.getangka_krdt();
            namaAngka_krdtjspR = tupoksiKeIsi4Faktor.getangka_krdtR();

            ModelLocatorSKP.globalKuantitasTarget = tupoksiKeIsi4Faktor.getKuantitas4();
            ModelLocatorSKP.globalKualitasTarget = tupoksiKeIsi4Faktor.getKualitas4();
            ModelLocatorSKP.globalWaktuTarget = tupoksiKeIsi4Faktor.getWaktu4();
            ModelLocatorSKP.globalBiayaTarget = tupoksiKeIsi4Faktor.getBiaya4();
            ModelLocatorSKP.globalNilaiKreditTarget = tupoksiKeIsi4Faktor.getangka_krdtR();

            request.setAttribute("pnsp", pnsp);
            request.setAttribute("idtupoksidijsp", idtupoksidijsp);
            request.setAttribute("tupoksiKeIsi4Faktor", tupoksiKeIsi4Faktor);
            request.setAttribute("namaTupoksijsp", namaTupoksijsp);
            request.setAttribute("namaAngka_krdtjsp", namaAngka_krdtjsp);

            request.setAttribute("_getidUnor4jsp", _getidUnor4);
            request.setAttribute("getIdIsi4Faktor", getIdIsi4Faktor);

            //RequestDispatcher dis=request.getRequestDispatcher("isi4faktor.jsp");
            dis = request.getRequestDispatcher("/WEB-INF/jsp/IsiRevisi.jsp");
            dis.forward(request, response);

        } else if (idB != null) {

            ModelLocatorSKP.navigasiPil = "47";
            request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
            request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);

            String id = idB;
            PnsSkp pns = new GoIndex().getPns(id);
            String unorAtasan = pns.getDiAtasanId();
            String UnorPns = pns.getUnorId();
            String InstansiPns = pns.getInstansiId();
            String NipPns = pns.getNipBaru();
            List<TupoksiRevisiTarget> tukesiServlet = new ArrayList<TupoksiRevisiTarget>();
            List<TupoksiRevisiTarget> tukesiServlet2 = new ArrayList<TupoksiRevisiTarget>();
            PnsSkp UnorAts = new GoIndex().getUnorAtasan(unorAtasan);
            if (_pilih_session == null) {
                _pilih_session = "-";
            }
            //   List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);
            if (_pilih_session.equals("-")) {
                tukesiServlet = new GoIndex().getDBqueryTupoksiRevisiTarget(idTupoksiR, _pilih_session, NipPns);
            } else {
                tukesiServlet = new GoIndex().getDBqueryTupoksiRevisiTargetSesion(idTupoksiR, _pilih_session, NipPns);
            }
            tukesiServlet2 = tukesiServlet;
            int i = 0;
            String awal = "1";
            String id4faktor = "-";

            for (TupoksiRevisiTarget tukesiDomain : tukesiServlet) {
                if (awal.equals("1")) {
                    awal = "2";
                    id4faktor = tukesiDomain.getIdIsi4Faktor();
                }
                if (id4faktor.equals(tukesiDomain.getIdIsi4Faktor())) {


                    if (i > 0) {
                        int testnum = tukesiDomain.getjns_perubahani().length();
                        tukesiServlet2.get(i - 1).setvar_perubahan1("x");
                        tukesiServlet2.get(i - 1).setvar_perubahan2("x");
                        tukesiServlet2.get(i - 1).setvar_perubahan3("x");
                        tukesiServlet2.get(i - 1).setvar_perubahan4("x");


                        String t1 = tukesiServlet2.get(i - 1).getvar_perubahan1();
                        String t2 = tukesiServlet2.get(i - 1).getvar_perubahan2();
                        String t3 = tukesiServlet2.get(i - 1).getvar_perubahan3();
                        String t4 = tukesiServlet2.get(i - 1).getvar_perubahan4();
                        for (int k = 0; k < tukesiDomain.getjns_perubahani().length(); k++) {
                            String test = tukesiDomain.getjns_perubahani().substring(k, k + 1);


                            if (tukesiDomain.getjns_perubahani().substring(k, k + 1).equals("u")) {
                                if (k == 0) {
                                    tukesiServlet2.get(i - 1).setvar_perubahan1("u");
                                    tukesiServlet2.get(i - 1).getvar_perubahan1();
                                } else if (k == 1) {
                                    tukesiServlet2.get(i - 1).setvar_perubahan2("u");
                                    tukesiServlet2.get(i - 1).getvar_perubahan2();
                                } else if (k == 2) {
                                    tukesiServlet2.get(i - 1).setvar_perubahan3("u");
                                    tukesiServlet2.get(i - 1).getvar_perubahan3();
                                } else if (k == 3) {
                                    tukesiServlet2.get(i - 1).setvar_perubahan4("u");
                                    tukesiServlet2.get(i - 1).getvar_perubahan4();
                                }

                                //break;
                            }
                        }


                    }
                    i = i + 1;
                } else {
                    id4faktor = tukesiDomain.getIdIsi4Faktor();
                   i = i + 1;
                }
            }
            tukesiServlet = tukesiServlet2;
            request.setAttribute("pns", pns);
            request.setAttribute("UnorAts", UnorAts);

            request.setAttribute("tukesiServlet", tukesiServlet);
            request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
            request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);

            dis = request.getRequestDispatcher("/WEB-INF/jsp/revisiTarget.jsp");
            dis.forward(request, response);
        }else if(idRevisiHapus !=null){
            
            ModelLocatorSKP.navigasiPil = "47";
            request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
            request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);
            
              String id = i_nipHapus ;
            PnsSkp pns = new GoIndex().getPns(id);
            String unorAtasan = pns.getDiAtasanId();
            String UnorPns = pns.getUnorId();
            String InstansiPns = pns.getInstansiId();
            String NipPns = pns.getNipBaru();
            List<TupoksiRevisiTarget> tukesiServlet = new ArrayList<TupoksiRevisiTarget>();
            List<TupoksiRevisiTarget> tukesiServlet2 = new ArrayList<TupoksiRevisiTarget>();
             PnsSkp UnorAts = new GoIndex().getUnorAtasan(unorAtasan);
             String berhasil= new GoIndex().getHapusRealitaRevisi(idRevisiHapus, NipPns);
            if (_pilih_session == null) {
                _pilih_session = "-";
            }
            //   List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);
            if (_pilih_session.equals("-")) {
                tukesiServlet = new GoIndex().getDBqueryTupoksiRevisiTarget(idTupoksiR, _pilih_session, NipPns);
            } else {
                tukesiServlet = new GoIndex().getDBqueryTupoksiRevisiTargetSesion(idTupoksiR, _pilih_session, NipPns);
            }
           
            

            request.setAttribute("pns", pns);
            request.setAttribute("UnorAts", UnorAts);

            request.setAttribute("tukesiServlet", tukesiServlet);
            request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
            request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);

            dis = request.getRequestDispatcher("/WEB-INF/jsp/revisiTarget.jsp");
            dis.forward(request, response);

        }
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String P_idTupoksi;
        HttpSession session = request.getSession();
        String param = request.getParameter("param");
        String paramRealisasi = request.getParameter("paramRealisasi");
        String userSession = (String) session.getAttribute("user");
        P_idTupoksi = request.getParameter("idtupoksidiSesiion");
        String NipPnsSession = (String) session.getAttribute("NipPnsSession");
        String _pilih_session = request.getParameter("pilih_session");
        String idisi4faktor = request.getParameter("getIdIsi4Faktor");

        if (param != null) {
            P_idTupoksi = request.getParameter("idtupoksidiSesiion");

            if (param.equalsIgnoreCase("SIMPAN")) {
                String _idTupoksi = P_idTupoksi;
                String _kuantitas4text = request.getParameter("kuantitas4text");
                String _kualitas4text = request.getParameter("kualitas4text");
                String _waktu4text = request.getParameter("waktu4text");
                String _biaya4text = request.getParameter("biaya4text");
                String _angkaKredit = request.getParameter("akt");
                String __getidUnor4jspSesiion = request.getParameter("_getidUnor4jspSesiion");
                String iNip_id = null;

                if (ModelLocatorSKP.loginNipPengguna != null) {
                    iNip_id = ModelLocatorSKP.loginNipPengguna;
                } else {
                    iNip_id = NipPnsSession;
                }

                String pilih = request.getParameter("pilih_output");
                String waktuL = "bln";

                if (!"-".equals(pilih)) {

                    String _Isi4Faktor = "-";
                    String _Isi4FaktorRevisi = null;
                    _Isi4Faktor = new GoIndex().getsimpanIsiEmpatFaktor(iNip_id, _idTupoksi, _kuantitas4text, _kualitas4text, _waktu4text, _biaya4text, pilih, waktuL, _angkaKredit, _pilih_session, __getidUnor4jspSesiion);
                    try {
                        _Isi4FaktorRevisi = new GoIndex().getsimpanIsiEmpatFaktorRevisi(iNip_id, _idTupoksi, idisi4faktor, _kuantitas4text, _kualitas4text, _waktu4text, _biaya4text, pilih, waktuL, _angkaKredit, _pilih_session, __getidUnor4jspSesiion);
                    } catch (SQLException ex) {
                        Logger.getLogger(RevisiServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }


                    String xidTupoksi = request.getParameter("idTupoksi");
                    String nip = request.getParameter("nipnilai");

                    PnsSkp pnsp = new GoIndex().getPns(iNip_id);
                    TupoksiKeIsi4Faktor tupoksiKeIsi4Faktor = new GoIndex().getTupoksi(_idTupoksi);

                    request.setAttribute("pnsp", pnsp);
                    request.setAttribute("tupoksiKeIsi4Faktor", tupoksiKeIsi4Faktor);

                    if (tupoksiKeIsi4Faktor != null) {
                        tupoksi_lama Tupoksi = new GoIndex().getIdtupoksi(P_idTupoksi);
                        idtupoksidijsp = Tupoksi.getIdTupoksi();
                        namaTupoksijsp = Tupoksi.getNamaTupoksi();
                        namaAngka_krdtjspR = Tupoksi.getangka_krdt();
                        request.setAttribute("idtupoksidijsp", idtupoksidijsp);
                        request.setAttribute("namaTupoksijsp", namaTupoksijsp);
                        request.setAttribute("namaAngka_krdtjsp", namaAngka_krdtjspR);
                        request.setAttribute("getIdIsi4Faktor", tupoksiKeIsi4Faktor.getIdIsi4Faktor());
                    }
                    request.setAttribute("alerting", _Isi4FaktorRevisi);

                    RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/IsiRevisi.jsp");

                    dis.include(request, response);

                } else {
                    String xidTupoksi = request.getParameter("idTupoksi");
                    String nip = request.getParameter("nipnilai");

                    PnsSkp pnsp = new GoIndex().getPns(iNip_id);
                    TupoksiKeIsi4Faktor tupoksiKeIsi4Faktor = new GoIndex().getTupoksi(_idTupoksi);

                    request.setAttribute("pnsp", pnsp);
                    request.setAttribute("tupoksiKeIsi4Faktor", tupoksiKeIsi4Faktor);

                    if (tupoksiKeIsi4Faktor != null) {
                        tupoksi_lama Tupoksi = new GoIndex().getIdtupoksi(P_idTupoksi);
                        idtupoksidijsp = Tupoksi.getIdTupoksi();
                        namaTupoksijsp = Tupoksi.getNamaTupoksi();
                        namaAngka_krdtjspR = Tupoksi.getangka_krdt();
                        request.setAttribute("idtupoksidijsp", idtupoksidijsp);
                        request.setAttribute("namaTupoksijsp", namaTupoksijsp);
                        request.setAttribute("namaAngka_krdtjsp", namaAngka_krdtjspR);
                    }


                    RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/IsiRevisi.jsp");
                    PrintWriter out = response.getWriter();
                    dis.include(request, response);
                    out.println("Pilih Jenis Kuantitas");
                }

            } else if (param.equalsIgnoreCase("BATAL")) {
                String _idTupoksi = P_idTupoksi;
                String _kuantitas4text = request.getParameter("kuantitas4text");
                String _kualitas4text = request.getParameter("kualitas4text");
                String _waktu4text = request.getParameter("waktu4text");
                String _biaya4text = request.getParameter("biaya4text");
                String _angkaKredit = request.getParameter("akt");

                String iNip_id = NipPnsSession;

                String pilih = request.getParameter("pilih_output");
                String waktuL = "bln";

                String xidTupoksi = request.getParameter("idTupoksi");
                String nip = request.getParameter("nipnilai");

                PnsSkp pnsp = new GoIndex().getPns(iNip_id);
                TupoksiKeIsi4Faktor tupoksiKeIsi4Faktor = new GoIndex().getTupoksi(_idTupoksi);

                request.setAttribute("pnsp", pnsp);
                request.setAttribute("tupoksiKeIsi4Faktor", tupoksiKeIsi4Faktor);

                if (tupoksiKeIsi4Faktor != null) {
                    tupoksi_lama Tupoksi = new GoIndex().getIdtupoksi(P_idTupoksi);
                    idtupoksidijsp = Tupoksi.getIdTupoksi();
                    namaTupoksijsp = Tupoksi.getNamaTupoksi();
                    namaAngka_krdtjspR = Tupoksi.getangka_krdt();
                    request.setAttribute("idtupoksidijsp", idtupoksidijsp);
                    request.setAttribute("namaTupoksijsp", namaTupoksijsp);
                    request.setAttribute("namaAngka_krdtjsp", namaAngka_krdtjspR);
                    request.setAttribute("getIdIsi4Faktor", tupoksiKeIsi4Faktor.getIdIsi4Faktor());
                }

                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/IsiRevisi.jsp");
                PrintWriter out = response.getWriter();
                dis.include(request, response);



            } else if (param.equalsIgnoreCase("CARI TUPOKSI")) {

                String _idNipBaruText = request.getParameter("idNipBaruText");
                PnsSkp pns = new GoIndex().getPns(_idNipBaruText);
                String unorAtasan = pns.getDiAtasanId();
                String UnorPns = pns.getUnorId();
                String InstansiPns = pns.getInstansiId();
                String NipPns = pns.getNipBaru();
                List<tupoksi_lama> tupoksiobjek = new GoIndex().getIdtupoksiUnor(UnorPns, InstansiPns);

                request.setAttribute("pns", pns);
                request.setAttribute("tupoksiobjek", tupoksiobjek);

                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/tabeltupoksi.jsp");
                dis.forward(request, response);

            } else {
            }
        } else {
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
