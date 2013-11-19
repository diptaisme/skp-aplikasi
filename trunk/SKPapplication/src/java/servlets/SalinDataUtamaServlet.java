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
            String _pilih_session=request.getParameter("pilih_session");
          if (action != null && action.equalsIgnoreCase("InsertData"))
        {
                  String tambahan = "oke";
            try {
                String isiData = new GoIndex().getInsertPns(tambahan);
            } catch (Exception ex) {
                Logger.getLogger(SalinDataUtamaServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
         
                  PnsSkp pns = new GoIndex().getPns(idB);

                            if (pns == null)
                            {
                                
                            }
                            else
                            {
                                String unorAtasan = pns.getDiAtasanId();
                                String UnorPns = pns.getUnorId();
                                String InstansiPns = pns.getInstansiId();
                                String NipPns = pns.getNipBaru();
                                PnsSkp UnorAts = new GoIndex().getUnorAtasan(unorAtasan);
                                
                                 List<TupoksiKeIsi4Faktor> tukesiServlet =null;
                                      if(_pilih_session.equals("-")) {
                                            tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);
                                     }else{
                                             tukesiServlet = new GoIndex().getTukesiSession(UnorPns, InstansiPns, NipPns,_pilih_session); 
                                          }
                             
                                request.setAttribute("pns", pns);
                                request.setAttribute("UnorAts", UnorAts);
                                request.setAttribute("tukesiServlet", tukesiServlet); 
                            }  

                            RequestDispatcher dis = request.getRequestDispatcher("indexBaruBiru2.jsp");
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
