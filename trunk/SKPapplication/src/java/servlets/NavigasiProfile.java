/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DBProperties;
import model.GoIndex;
import model.TupoksiKeIsi4Faktor;
import model.loginweb;
import model.PnsSkp;
import model.TupoksiRevisiTarget;
import model.unorskp;
import servlets.ModelLocatorSKP;
import model.instansiri;
/**
 *
 * @author Sony
 */
public class NavigasiProfile extends HttpServlet {

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
            out.println("<title>Servlet NavigasiProfile</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NavigasiProfile at " + request.getContextPath () + "</h1>");
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
        //   processRequest(request, response);

        PrintWriter out = response.getWriter();


        RequestDispatcher dis = null;
        String action = request.getParameter("action");
        
        String nip_Manajemen_Pengguna = request.getParameter("nipManajemenPengguna");
        String nip_Perwakilan = request.getParameter("nipPerwakilan");
        String nip_Pengguna = request.getParameter("nipPengguna");
        String nip_Entri_Tupoksi = request.getParameter("nipentriTupoksi");
        String nip_Monitoring = request.getParameter("nipmonitoring");
        String nip_salin_data = request.getParameter("salindata");
        String refisidata = request.getParameter("refisidata");
        String rekapdata = request.getParameter("rekapdata");

        String nipAtasanMonitoring = nip_Monitoring;

        request.setAttribute("namaPNScetak", nip_Manajemen_Pengguna);
        request.setAttribute("nipPNScetak", nip_Perwakilan);
        request.setAttribute("golruPNScetak", nip_Pengguna);
        request.setAttribute("jabatanPNScetak", nip_Entri_Tupoksi);
        if (ModelLocatorSKP.loginNipsession != null) {
            ModelLocatorSKP.loginNipPengguna = ModelLocatorSKP.loginNipsession;
        }

        if (nip_Manajemen_Pengguna != null) {
            ModelLocatorSKP.navigasiPil = "3";
            dis = request.getRequestDispatcher("/WEB-INF/jsp/manajemenUser.jsp");
            dis.forward(request, response);
        } else if (nip_Perwakilan != null) {
            ModelLocatorSKP.navigasiPil = "3";
            request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);

            //=====================
            String id = nip_Perwakilan;
            PnsSkp pns = new GoIndex().getPns(id);
            String unorAtasan = pns.getDiAtasanId();
            String UnorPns = pns.getUnorId();
            String InstansiPns = pns.getInstansiId();
            String NipPns = pns.getNipBaru();

            PnsSkp UnorAts = new GoIndex().getUnorAtasan(unorAtasan);

            List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);

            request.setAttribute("pns", pns);
            request.setAttribute("UnorAts", UnorAts);

            request.setAttribute("tukesiServlet", tukesiServlet);
            request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
            //====================

            //  dis = request.getRequestDispatcher("/WEB-INF/jsp/indexBaruBiru2.jsp");
            //  dis.forward(request, response);

            dis = request.getRequestDispatcher("/WEB-INF/jsp/navigasiPenggunadat.jsp");
            dis.forward(request, response);

        } else if (nip_Pengguna != null) {
            
            ModelLocatorSKP.navigasiPil = "1";
            request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);

            //=====================
            String id = nip_Pengguna;
            PnsSkp pns = new GoIndex().getPns(id);
            String unorAtasan = pns.getDiAtasanId();
            String UnorPns = pns.getUnorId();
            String InstansiPns = pns.getInstansiId();
            String NipPns = pns.getNipBaru();

            PnsSkp UnorAts = new GoIndex().getUnorAtasan(unorAtasan);

            List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);

            request.setAttribute("pns", pns);
            request.setAttribute("UnorAts", UnorAts);

            request.setAttribute("tukesiServlet", tukesiServlet);
            request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
            request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);
            //   request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
            //====================

            //  dis = request.getRequestDispatcher("/WEB-INF/jsp/indexBaruBiru2.jsp");
            //  dis.forward(request, response);

            dis = request.getRequestDispatcher("/WEB-INF/jsp/navigasiPenggunadat.jsp");
            dis.forward(request, response);

            // dis = request.getRequestDispatcher("/WEB-INF/jsp/indexBaruBiru2.jsp");
            // dis.forward(request, response);
            //====================

        } else if (nip_Entri_Tupoksi != null) {
            String nipengguna = ModelLocatorSKP.loginNipPengguna;
            HttpSession session = request.getSession();
            ModelLocatorSKP.navigasiPil = "2";
            instansiri objekinstansi = new GoIndex().getCariInstansiNip(nipengguna);
            String namaInstansi = objekinstansi.getNamaInstansi();
            String kodeInstansi = objekinstansi.getIdInstansi();
            request.setAttribute("namaInstansi", namaInstansi);
            request.setAttribute("kodeInstansi", kodeInstansi);
            request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
            request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);
            //  request.setAttribute("navigasiPilihanjns", "2");
            //  request.setAttribute("navigasiPilihan", '2');


            dis = request.getRequestDispatcher("/WEB-INF/jsp/insertTupoksiBaruBiru.jsp");
            dis.forward(request, response);
        } else if (nip_Monitoring != null) {
            ModelLocatorSKP.navigasiPil = "46";
            request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
            request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);

            if (nipAtasanMonitoring != null) {
                ModelLocatorSKP.arraypGcavernip = new ArrayList<String>();
                String idNipTambahan = nipAtasanMonitoring;
                PnsSkp pns = new GoIndex().getPns(idNipTambahan);

                String iUnorTambahan = pns.getUnorId();
                //List<pnsskp_strukturalbkn> pnsList = new GoIndex().getTugasTambahanBawahanList(iUnorTambahan);
                List<PnsSkp> pnsList = new GoIndex().getTugasTambahanBawahanList2(iUnorTambahan);


                //   List<pnsskp> pnsList = new GoIndex().getTugasTambahanBawahanListALL(iUnorTambahan);
                request.setAttribute("pnsList", pnsList);
                request.setAttribute("pns", pns);

                request.setAttribute("nipAtasan", idNipTambahan);
                // dis = request.getRequestDispatcher("/WEB-INF/jsp/monitoring.jsp");
                dis = request.getRequestDispatcher("/WEB-INF/jsp/navigasiPenggunadat.jsp");
                dis.forward(request, response);

                // dis = request.getRequestDispatcher("/WEB-INF/jsp/insertTupoksiBaruBiru.jsp");
                //dis.forward(request, response);
            }
        } else if (nip_salin_data != null) {
            ModelLocatorSKP.navigasiPil = "3";
            HttpSession session = request.getSession();
            String unorAtasan = null;
            //=====================
            String id = nip_salin_data;
            PnsSkp pns = new GoIndex().getPns(id);
            if (pns != null) {
                unorAtasan = pns.getDiAtasanId();
                String UnorPns = pns.getUnorId();
                String InstansiPns = pns.getInstansiId();
                String NipPns = pns.getNipBaru();
            }

            PnsSkp UnorAts = new GoIndex().getUnorAtasan(unorAtasan);
            request.setAttribute("nipAtasan", nip_salin_data);
            request.setAttribute("pns", pns);
            request.setAttribute("UnorAts", UnorAts);
            session.setAttribute("levelPemakaian", ModelLocatorSKP.levelUser);
            request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
            request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);
            dis = request.getRequestDispatcher("/WEB-INF/jsp/ImportData.jsp");
            dis.forward(request, response);


        } else if (refisidata != null) {
            ModelLocatorSKP.navigasiPil = "47";
            request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
            request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);

            request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);

            //=====================
            String id = refisidata;
            PnsSkp pns = new GoIndex().getPns(id);
            String unorAtasan = pns.getDiAtasanId();
            String UnorPns = pns.getUnorId();
            String InstansiPns = pns.getInstansiId();
            String NipPns = pns.getNipBaru();

            PnsSkp UnorAts = new GoIndex().getUnorAtasan(unorAtasan);

            //  List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);



            //   List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);

            List<TupoksiRevisiTarget> tukesiServlet = new GoIndex().getDBqueryTupoksiRevisiTarget(UnorPns, InstansiPns, NipPns);
            // tukesiServlet = new GoIndex().getDBqueryTupoksiRevisiTarget(idTupoksiR, _pilih_session, NipPns);

            request.setAttribute("pns", pns);
            request.setAttribute("UnorAts", UnorAts);

            request.setAttribute("tukesiServlet", tukesiServlet);
            request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
            request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);

            dis = request.getRequestDispatcher("/WEB-INF/jsp/revisiTarget.jsp");
            dis.forward(request, response);

        } else if (rekapdata != null) {
            ModelLocatorSKP.navigasiPil = "57";
            request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
            request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);

            String id = rekapdata;
            
            request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
            request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);

            dis = request.getRequestDispatcher("/WEB-INF/jsp/RekapitulasiView.jsp");
            dis.forward(request, response);

        } else {
            request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
            request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);
            // dis = request.getRequestDispatcher("/WEB-INF/jsp/monitoring.jsp");
            dis = request.getRequestDispatcher("/WEB-INF/jsp/navigasiPenggunadat.jsp");
            dis.forward(request, response);
        }





    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
