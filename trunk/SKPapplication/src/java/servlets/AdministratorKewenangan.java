/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.GoIndex;
import model.loginweb;

/**
 *
 * @author bkn04
 */
public class AdministratorKewenangan extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdministratorKewenangan</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdministratorKewenangan at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        String param = request.getParameter("param");
        if(param.equalsIgnoreCase("ubah"))
        {
           RequestDispatcher dis = null;
           String username = request.getParameter("usernameinputan");
           String password = request.getParameter("passwordinputan");
           String nip_baru = request.getParameter("nip_baru");
           new GoIndex().getubahUser(username, password, nip_baru);
           loginweb lw = new GoIndex().getSudahAdaUser(nip_baru);
           request.setAttribute("username", lw.getusername_login());
           request.setAttribute("password", lw.getpassword_login());
           request.setAttribute("nip", nip_baru);
           dis = request.getRequestDispatcher("/WEB-INF/jsp/ManajemenUserTambahUbah.jsp");
           dis.forward(request, response);
        }
        if(param.equalsIgnoreCase("TambahKewenangan"))
        {
           RequestDispatcher dis = null;
           String username = request.getParameter("usernameinputan");
           String password = request.getParameter("passwordinputan");
           String nip_baru = request.getParameter("nip_baru");
           String kewenangan = request.getParameter("kewenangan");
           new GoIndex().gettambahkeweanagan(username,password,kewenangan,nip_baru); 
           loginweb lw = new GoIndex().getSudahAdaUser(nip_baru);
           request.setAttribute("username", lw.getusername_login());
           request.setAttribute("password", lw.getpassword_login());
           request.setAttribute("nip", nip_baru);
           dis = request.getRequestDispatcher("/WEB-INF/jsp/ManajemenUserTambahUbah.jsp");
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
