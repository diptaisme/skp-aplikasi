/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.GoIndex;
import model.PnsSkp;

/**
 *
 * @author diptaisme
 */
public class cetakIsi4FaktorServlet extends HttpServlet {

    String idp;
    String cetak = null;

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
            out.println("<title>Servlet cetakIsi4FaktorServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet cetakIsi4FaktorServlet at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);

        String id = request.getParameter("nipnilai2");
        String idR = request.getParameter("nipnilai2R");
        String idU = request.getParameter("nipnilai2U");
        String idSB = request.getParameter("nipnilai2SB");
        String idP = request.getParameter("nipPrestasi");
        String pilih_session_monit = request.getParameter("pilih_session_monit");
        String target = request.getParameter("target");
        String realisasi = request.getParameter("realisasi");
        String tglCetak = request.getParameter("tglCetak");


        String pilihSession = request.getParameter("pilih_session");
        String nipatasanMonitoringCetak = request.getParameter("nipatasanMonitoringCetak");

        if ((id != null && !"".equals(id) && !" ".equals(id)) || (nipatasanMonitoringCetak != null) || (idR != null && !"".equals(idR) && !" ".equals(idR)) || (idU != null && !"".equals(idU) && !" ".equals(idU)) || (idSB != null && !"".equals(idSB) && !" ".equals(idSB)) || (idP != null && !"".equals(idP) && !" ".equals(idP))) {
            if (id != null) {
                idp = id;
                PnsSkp pnsp = new GoIndex().getPns(idp);
                request.setAttribute("pnsp", pnsp);

                HttpSession session = request.getSession();
                cetak = "t";
                session.setAttribute("CeTaK", cetak);

                PnsSkp cetakPns = new GoIndex().getPns(id);

               
                //***************CETAK PNS
                String namaPNScetak = cetakPns.getNamaPns();
                String nipPNScetak = cetakPns.getNipBaru();
                String golruPNScetak = cetakPns.getNamaGolru();
                golruPNScetak = cetakPns.getNamaGolru() + " / " + cetakPns.getPangkat();
                String jabatanPNScetak = cetakPns.getNamaJabatan();
                String unkerPNScetak = cetakPns.getNamaUnor();

                String unorAtasan = cetakPns.getDiAtasanId();
                String UnorPnsid = cetakPns.getUnorId();
                String InstansiPns = cetakPns.getInstansiId();
                String NipPns = cetakPns.getNipBaru();
                String typeReport;
                // if (){
                // typeReport ="report_isi4faktor";
                // }else
                // {
                typeReport = "report_isi4faktor";
                // }

                request.setAttribute("typeReport", typeReport);

                request.setAttribute("namaPNScetak", namaPNScetak);
                request.setAttribute("nipPNScetak", nipPNScetak);
                request.setAttribute("golruPNScetak", golruPNScetak);
                request.setAttribute("jabatanPNScetak", jabatanPNScetak);
                request.setAttribute("unkerPNScetak", unkerPNScetak);

                request.setAttribute("unorAtasan", unorAtasan);
                request.setAttribute("UnorPnsid", UnorPnsid);
                request.setAttribute("InstansiPns", InstansiPns);
                request.setAttribute("NipPns", NipPns);
                request.setAttribute("_pilih_session", pilihSession);
                request.setAttribute("tglCetak", tglCetak);

                RequestDispatcher dis = getServletContext().getRequestDispatcher("/ReportIsi4FaktorServlet?etst=test");
                dis.forward(request, response);
            } else if (nipatasanMonitoringCetak != null) {
                String typeReport = "report_Cetak_nominatif_bawahan";

                String idNipTambahan = nipatasanMonitoringCetak;

                PnsSkp pns = new GoIndex().getPns(idNipTambahan);

                String iUnorTambahan = pns.getUnorId();

                // List<pnsskp> pnsList = new GoIndex().getTugasTambahanBawahanListALL(iUnorTambahan);
                List<PnsSkp> pnsList = new GoIndex().getTugasTambahanBawahanListALLSession(iUnorTambahan, pilih_session_monit);
                request.setAttribute("pnsList", pnsList);
                request.setAttribute("pns", pns);
                request.setAttribute("typeReport", typeReport);
                request.setAttribute("_pilih_session", pilih_session_monit);

                request.setAttribute("nipAtasan", idNipTambahan);
                // RequestDispatcher dis = request.getRequestDispatcher("monitoring.jsp");
                RequestDispatcher dis = getServletContext().getRequestDispatcher("/ReportIsi4FaktorServlet?etst=test");
                dis.forward(request, response);
            } else if (idR != null) {
                idp = idR;
                PnsSkp pnsp = new GoIndex().getPns(idp);
                request.setAttribute("pnsp", pnsp);

                HttpSession session = request.getSession();
                cetak = "t";
                session.setAttribute("CeTaK", cetak);

                PnsSkp CetakPns = new GoIndex().getPns(idR);

                //***************CETAK PNS
                String namaPNScetak = CetakPns.getNamaPns();
                String nipPNScetak = CetakPns.getNipBaru();
                String golruPNScetak = CetakPns.getNamaGolru();
                golruPNScetak = CetakPns.getNamaGolru() + " / " + CetakPns.getPangkat();
                String jabatanPNScetak = CetakPns.getNamaJabatan();
                String unkerPNScetak = CetakPns.getNamaUnor();

                String unorAtasan = CetakPns.getDiAtasanId();
                String UnorPnsid = CetakPns.getUnorId();
                String InstansiPns = CetakPns.getInstansiId();
                String NipPns = CetakPns.getNipBaru();

                String typeReport = "SKPrealisasi";
                request.setAttribute("typeReport", typeReport);

                request.setAttribute("namaPNScetak", namaPNScetak);
                request.setAttribute("nipPNScetak", nipPNScetak);
                request.setAttribute("golruPNScetak", golruPNScetak);
                request.setAttribute("jabatanPNScetak", jabatanPNScetak);
                request.setAttribute("unkerPNScetak", unkerPNScetak);

                request.setAttribute("unorAtasan", unorAtasan);
                request.setAttribute("UnorPnsid", UnorPnsid);
                request.setAttribute("InstansiPns", InstansiPns);
                request.setAttribute("NipPns", NipPns);
                request.setAttribute("tglCetak", tglCetak);

                RequestDispatcher dis = getServletContext().getRequestDispatcher("/ReportIsi4FaktorServlet?etst=test");
                dis.forward(request, response);
            } else if (idSB != null) {
                idp = idSB;
                PnsSkp pnsp = new GoIndex().getPns(idp);
                request.setAttribute("pnsp", pnsp);

                HttpSession session = request.getSession();
                cetak = "t";
                session.setAttribute("CeTaK", cetak);

                PnsSkp CetakPns = new GoIndex().getPns(idSB);

                //***************CETAK PNS
                String namaPNScetak = CetakPns.getNamaPns();
                String nipPNScetak = CetakPns.getNipBaru();
                String golruPNScetak = CetakPns.getNamaGolru();
                //  golruPNScetak =cetakPns.getNamaGolru() +" / " + cetakPns.getPangkat();
                String jabatanPNScetak = CetakPns.getNamaJabatan();
                String unkerPNScetak = CetakPns.getNamaUnor();

                String unorAtasan = CetakPns.getDiAtasanId();
                String UnorPnsid = CetakPns.getUnorId();
                String InstansiPns = CetakPns.getInstansiId();
                String NipPns = CetakPns.getNipBaru();

                String typeReport = "SKPrealisasiSubReport";
                request.setAttribute("typeReport", typeReport);

                request.setAttribute("namaPNScetak", namaPNScetak);
                request.setAttribute("nipPNScetak", nipPNScetak);
                request.setAttribute("golruPNScetak", golruPNScetak);
                request.setAttribute("jabatanPNScetak", jabatanPNScetak);
                request.setAttribute("unkerPNScetak", unkerPNScetak);

                request.setAttribute("unorAtasan", unorAtasan);
                request.setAttribute("UnorPnsid", UnorPnsid);
                request.setAttribute("InstansiPns", InstansiPns);
                request.setAttribute("NipPns", NipPns);
                request.setAttribute("tglCetak", tglCetak);
                request.setAttribute("_pilih_session", pilihSession);

                RequestDispatcher dis = getServletContext().getRequestDispatcher("/ReportIsi4FaktorServlet?etst=test");
                dis.forward(request, response);
            } else if (idU != null) {
                idp = idU;
                PnsSkp pnsp = new GoIndex().getPns(idp);
                request.setAttribute("pnsp", pnsp);

                HttpSession session = request.getSession();
                cetak = "t";
                session.setAttribute("CeTaK", cetak);

                PnsSkp CetakPns = new GoIndex().getPns(idU);

                //***************CETAK PNS
                String namaPNScetak = CetakPns.getNamaPns();
                String nipPNScetak = CetakPns.getNipBaru();
                String golruPNScetak = CetakPns.getNamaGolru();
                //  golruPNScetak =cetakPns.getNamaGolru() +" / " + cetakPns.getPangkat();
                String jabatanPNScetak = CetakPns.getNamaJabatan();
                String unkerPNScetak = CetakPns.getNamaUnor();

                String unorAtasan = CetakPns.getDiAtasanId();
                String UnorPnsid = CetakPns.getUnorId();
                String InstansiPns = CetakPns.getInstansiId();
                String NipPns = CetakPns.getNipBaru();

                String typeReport = "SKPunsurpenunjang";
                request.setAttribute("typeReport", typeReport);

                request.setAttribute("namaPNScetak", namaPNScetak);
                request.setAttribute("nipPNScetak", nipPNScetak);
                request.setAttribute("golruPNScetak", golruPNScetak);
                request.setAttribute("jabatanPNScetak", jabatanPNScetak);
                request.setAttribute("unkerPNScetak", unkerPNScetak);

                request.setAttribute("unorAtasan", unorAtasan);
                request.setAttribute("UnorPnsid", UnorPnsid);
                request.setAttribute("InstansiPns", InstansiPns);
                request.setAttribute("NipPns", NipPns);

                RequestDispatcher dis = getServletContext().getRequestDispatcher("/ReportIsi4FaktorServlet?etst=test");
                dis.forward(request, response);
            } else if (idP != null) {
                PnsSkp pnsp = new GoIndex().getPns(idP);
                request.setAttribute("pnsp", pnsp);

                String namaPns = pnsp.getNamaPns();
                String nipPns = pnsp.getNipBaru();
                String pangkatPns = pnsp.getPangkat();
                String golonganPns = pnsp.getNamaGolru();
                String unorPns = pnsp.getNamaUnor();
                String jabatan = pnsp.getNamaJabatan();

                request.setAttribute("namaPns", namaPns);
                request.setAttribute("nipPns", nipPns);
                request.setAttribute("pangkatPns", pangkatPns);
                request.setAttribute("golonganPns", golonganPns);
                request.setAttribute("unorPns", unorPns);
                request.setAttribute("jabatan", jabatan);

                String diAtasanPns = pnsp.getDiAtasanId();
                String instansiIdPns = pnsp.getInstansiId();
                String unorIdPns = pnsp.getUnorId();

                request.setAttribute("diAtasanPns", diAtasanPns);
                request.setAttribute("instansiIdPns", instansiIdPns);
                request.setAttribute("unorIdPns", unorIdPns);
                request.setAttribute("_pilih_session", pilihSession);
                String typeReport = "reportPenilaianPrestasiKerja";
                request.setAttribute("typeReport", typeReport);

                RequestDispatcher dis = getServletContext().getRequestDispatcher("/ReportIsi4FaktorServlet?etst=test");
                dis.forward(request, response);

            } else {
            }
        } else if ((id == null || "".equals(id) || " ".equals(id)) && ("target".equals(target))) {
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/indexBaruBiru2.jsp");
            dis.forward(request, response);
        } else if ((idR == null || "".equals(idR) || " ".equals(idR)) && ("realisasi".equals(realisasi))) {
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/indexRealisasiBaruBiru.jsp");
            dis.forward(request, response);
        } else {
        }
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
        processRequest(request, response);
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
