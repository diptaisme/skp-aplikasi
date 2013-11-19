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
import model.PnsSkp;

/**
 *
 * @author diptaisme
 */
public class administratorFunctionServlet extends HttpServlet {

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
            out.println("<title>Servlet administratorFunctionServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet administratorFunctionServlet at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        String param = request.getParameter("param");
        
        if (param.equalsIgnoreCase("AMBIL"))
        {
            String nip = request.getParameter("nipbaru");
            PnsSkp pns = new GoIndex().getPns(nip);
            request.setAttribute("pns", pns);
            RequestDispatcher dis = request.getRequestDispatcher("manajemenUser.jsp");  
            dis.forward(request, response);
        }
        else if (param.equalsIgnoreCase("OK"))
        {
           String nipbaru = request.getParameter("getNipBaruPns"); 
           String usernamebaru = request.getParameter("usernameinputan"); 
           String passwordbaru = request.getParameter("passwordinputan");
           String kewenangan = request.getParameter("kewenangan");
           String apakah;
           
           if (!"-".equals(kewenangan))
           {
               loginweb getSudahAdaUser = new GoIndex().getSudahAdaUser(nipbaru);
               if (getSudahAdaUser == null)
               {
                    apakah = "simpan";
                    String masukLogin = new GoIndex().getSimpanLogin(usernamebaru,passwordbaru,kewenangan,nipbaru,apakah);
               }
               else
               {
                   apakah = "ubah";
                   String updateLogin = new GoIndex().getSimpanLogin(usernamebaru,passwordbaru,kewenangan,nipbaru,apakah);
               }
           }
           else
           {
               
           }
           
        }
        else if (param.equalsIgnoreCase("UBAH"))
        {
            
        }
        else if (param.equalsIgnoreCase("HAPUS"))
        {
            
        }
        else if (param == null)   
        {
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
