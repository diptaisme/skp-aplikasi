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

/**
 *
 * @author Andez
 */
public class RequestServlet extends HttpServlet {

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
        // controller untuk halaman
        String page = request.getParameter("page");
        if (page == null) {
            cetakNotAvailable(response);
        } else {
            if (page.equalsIgnoreCase("validasi")) {
                if (request.getParameter("jenis_tambahan").toString().equals("Keterampilan")) {
                    PrintWriter out = response.getWriter();
                    out.print("<select name='koef_kreatifitas'><option value='10'>Unit Organisasi</option><option value='20'>Instansi</option><option value='30'>Nasional</option> </select>");
                    out.close();
                }
            } else {
                page = "/WEB-INF/jsp/" + page + ".jsp";
                try {
                    RequestDispatcher rd = request.getRequestDispatcher(page);
                    rd.forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                    cetakNotAvailable(response);
                }
            }
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

    private void cetakNotAvailable(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML><HEAD><TITLE>SKP</TITLE>"
                + "</HEAD><BODY>Maaf anda tidak dapat mengakses halaman ini. Klik <a href='"
                + "/SKPapplication"
                + "'>link ini </a> untuk kembali</BODY></HTML>");
        out.close();
    }
}
