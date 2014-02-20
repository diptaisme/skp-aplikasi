/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;

/**
 *
 * @author Sony
 */
public class SalinDataUtamaServlet extends HttpServlet {

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
            out.println("<title>Servlet SalinDataUtamaServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SalinDataUtamaServlet at " + request.getContextPath () + "</h1>");
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

        String action = request.getParameter("action");
        String idB = request.getParameter("txtNIPBaruBData");
        String _pilih_session = request.getParameter("pilih_session");

        String nipImportdata2 = request.getParameter("nipImportdata");
        if (action != null && (action.equalsIgnoreCase("InsertData") || action.equalsIgnoreCase("InsertDataUnor"))) {
            String tambahan = "oke";
              if(action.equals("InsertData"))
            {
              try {
                String isiData = new GoIndex().getInsertPns(tambahan);
            } catch (Exception ex) {
                Logger.getLogger(SalinDataUtamaServlet.class.getName()).log(Level.SEVERE, null, ex);
            }  
            }
           else
            {
               try {
                String isiData = new GoIndex().getInsertUnor(tambahan);
            } catch (Exception ex) {
                Logger.getLogger(SalinDataUtamaServlet.class.getName()).log(Level.SEVERE, null, ex);
            }   
            }

            PnsSkp pns = new GoIndex().getPns(idB);

            if (pns == null) {
            } else {
                String unorAtasan = pns.getDiAtasanId();
                String UnorPns = pns.getUnorId();
                String InstansiPns = pns.getInstansiId();
                String NipPns = pns.getNipBaru();
                PnsSkp UnorAts = new GoIndex().getUnorAtasan(unorAtasan);

                // List<TupoksiKeIsi4Faktor> tukesiServlet = null;
                /// if (_pilih_session.equals("-")) {
                //     tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);
                // } else {
                //      tukesiServlet = new GoIndex().getTukesiSession(UnorPns, InstansiPns, NipPns, _pilih_session);
                //  }

                request.setAttribute("pns", pns);
                request.setAttribute("UnorAts", UnorAts);
                // request.setAttribute("tukesiServlet", tukesiServlet);
            }

            // RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/indexBaruBiru2.jsp");
            //  dis.forward(request, response);   

            ModelLocatorSKP.navigasiPil = "3";
            request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
            request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/ImportData.jsp");
            dis.forward(request, response);
        } else if (action == null && nipImportdata2 != null) {
              HttpSession session = request.getSession();
            ModelLocatorSKP.arraypGcavernip = new ArrayList<String>();
            ModelLocatorSKP.navigasiPil = "3";
            String idNipTambahan = nipImportdata2;
            PnsSkp pns = new GoIndex().getPns(nipImportdata2);
            String iUnorTambahan = pns.getUnorId();
           //  iUnorTambahan ="A8ACA73A4DF63912E040640A040269BB";
            //List<pnsskp_strukturalbkn> pnsList = new GoIndex().getTugasTambahanBawahanList(iUnorTambahan);
            //  List<pnsskp> pnsList = new GoIndex().getTugasTambahanBawahanList2(iUnorTambahan);
            List<PnsSkp> pnsList = new GoIndex().getTugasTambahanBawahanListALL(iUnorTambahan);
            PnsSkp ipns = null;
            List<PnsSkp> pnsBawahan = new ArrayList<PnsSkp>();
            List<PnsSkp> pnsBawahan2 = new ArrayList<PnsSkp>();
            List<PnsSkp> pnsBawahan3 = new ArrayList<PnsSkp>();
            List<PnsSkp> pnsBawahan4 = new ArrayList<PnsSkp>();
            for (PnsSkp ipns3 : pnsList) {
                ipns = new PnsSkp();

                if (ipns3.getLevel().length() == 1) {
                    pnsBawahan.add(ipns3);
                } else if (ipns3.getLevel().length() == 2) {
                    pnsBawahan2.add(ipns3);
                } else if (ipns3.getLevel().length() == 3) {
                    pnsBawahan3.add(ipns3);
                } else if (ipns3.getLevel().length() == 4) {
                    pnsBawahan4.add(ipns3);
                }
            }
            request.setAttribute("pnsBawahan", pnsBawahan);
            request.setAttribute("pnsBawahan2", pnsBawahan2);
            request.setAttribute("pnsBawahan3", pnsBawahan3);
            request.setAttribute("pnsBawahan4", pnsBawahan4);

            request.setAttribute("pnsList", pnsList);
            request.setAttribute("pns", pns);
            String unorAtasan = pns.getDiAtasanId();
            String UnorPns = pns.getUnorId();
            String InstansiPns = pns.getInstansiId();
            String NipPns = pns.getNipBaru();
            PnsSkp UnorAts = new GoIndex().getUnorAtasan(unorAtasan);
            request.setAttribute("nipAtasan", idNipTambahan);
            ModelLocatorSKP.navigasiPil = "46";
            request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
            request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);

            request.setAttribute("UnorAts", UnorAts);
            session.setAttribute("levelPemakaian", ModelLocatorSKP.levelUser);
            request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
            request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/ImportData.jsp");
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
        // processRequest(request, response);
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
