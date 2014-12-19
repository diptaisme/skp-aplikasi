/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
import javax.servlet.ServletOutputStream;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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
        String _txtNIPBaruAjax = request.getParameter("txtNIPBaruAjax");
        String _txtNIPBaruAjaxnipTambah = request.getParameter("_nipTambah");
        String _filechooserfoto=request.getParameter("filechooserfoto");

        String nipImportdata2 = request.getParameter("nipImportdata");
        if (action != null && (action.equalsIgnoreCase("InsertData") || action.equalsIgnoreCase("InsertDataUnor"))) {
            String tambahan = "oke";
            if (action.equals("InsertData")) {
                try {
                    String isiData = new GoIndex().getInsertPns(tambahan);
                } catch (Exception ex) {
                    Logger.getLogger(SalinDataUtamaServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
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
           // ModelLocatorSKP.arraypGcavernip = new ArrayList<String>();
            ModelLocatorSKP.arraypGcaverunor = new ArrayList<String>();
            ModelLocatorSKP.navigasiPil = "3";
            String idNipTambahan = nipImportdata2;
            PnsSkp pns = new GoIndex().getPns(nipImportdata2);
            String iUnorTambahan = pns.getUnorId();
            //  iUnorTambahan ="A8ACA73A4DF63912E040640A040269BB";
            //List<pnsskp_strukturalbkn> pnsList = new GoIndex().getTugasTambahanBawahanList(iUnorTambahan);
            //  List<pnsskp> pnsList = new GoIndex().getTugasTambahanBawahanList2(iUnorTambahan);
            //iUnorTambahan ="A8ACA73A4DF63912E040640A040269BB";
            List<unorskp> pnsList = new GoIndex().getunorAjakListALL(iUnorTambahan);
            PnsSkp ipns = null;
            List<unorskp> pnsBawahan = new ArrayList<unorskp>();
            List<unorskp> pnsBawahan2 = new ArrayList<unorskp>();
            List<unorskp> pnsBawahan3 = new ArrayList<unorskp>();
            List<unorskp> pnsBawahan4 = new ArrayList<unorskp>();
            for (unorskp ipns3 : pnsList) {
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
            if(unorAtasan.length()< 8){
                unorAtasan="A8ACA73A4DF63912E040640A040269BB";
            }
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
        } else if (_txtNIPBaruAjax != null) {
            ModelLocatorSKP.arraypGcavernip = new ArrayList<String>();
            unorskp Unorskp = new GoIndex().getIdUnorskp(_txtNIPBaruAjax);
            String iUnorTambahan =Unorskp.getDiAtasanId();
          
            List<PnsSkp> pnsList = new GoIndex().getTugasTambahanBawahanListALL(iUnorTambahan);
            request.setAttribute("pnsList", pnsList);
            PrintWriter out = response.getWriter();
            StringBuilder sb = new StringBuilder();
            String warna="b";
            for (int i = 0; i < pnsList.size(); i++) {
                if (warna.equals("b")){
                sb.append("<tr style='background: #ccccff'>"
                        + "<td width='30' align='center'>" + (i + 1) + "</td>"
                        + "<td width='140'><div align='left'><a href='GetPnsServlet?action=Monitor&txtNIPBaru='" + pnsList.get(i).getNipBaru() + ">" + pnsList.get(i).getNipBaru() + "</a></div></td>"
                        + "  <td><div align='left'><a href='GetPnsServlet?action=Monitor&txtNIPBaru='" + pnsList.get(i).getNipBaru() + ">" + pnsList.get(i).getNamaPns() + "</a></div></td>"
                        + "</tr>");
                }else{
                     sb.append("<tr style='background: #FF9900'>"
                        + "<td width='30' align='center'>" + (i + 1) + "</td>"
                        + "<td width='140'><div align='left'><a href='GetPnsServlet?action=Monitor&txtNIPBaru='" + pnsList.get(i).getNipBaru() + ">" + pnsList.get(i).getNipBaru() + "</a></div></td>"
                        + "  <td><div align='left'><a href='GetPnsServlet?action=Monitor&txtNIPBaru='" + pnsList.get(i).getNipBaru() + ">" + pnsList.get(i).getNamaPns() + "</a></div></td>"
                        + "</tr>");
                }
                warna="c";
            }
            out.print("<table  width='300'  >");

            out.print("<tr style='background: #FF9900'>");
            out.print("<td width ='30'>No.</td>");
            out.print("<td  width ='140' >NIP BARU</td>");
            out.print("<td width ='200' >NAMA</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print(sb);
            out.print("</tr>");
            out.print("</table>");
            out.close();

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
        
         String nipPns = "";
         String session_pil="";
        int totalBytesRead = 0;
          String Submit = request.getParameter("Submit");
                String _nipatasan = request.getParameter("nipatasan");
        File file2;
        
          {
          InputStream in = null;
            try {
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                Iterator<FileItem> iterator = upload.parseRequest(request).iterator();
                File uploadedFile;
                FileInputStream fs = null;
                String dirPath = "";
                
                while (iterator.hasNext()) {
                    FileItem item = iterator.next();
                    if (!item.isFormField()) {
                        String fileNameWithExt = item.getName();
                        File filePath = new File(dirPath);

                        if (!filePath.exists()) {
                            filePath.mkdirs();
                        }

                        dirPath = this.getServletContext().getRealPath(fileNameWithExt);
                        uploadedFile = new File(dirPath);

                        try {
                            item.write(uploadedFile);
                        } catch (Exception ex) {
                            Logger.getLogger(SalinDataUtamaServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        file2 = new File(dirPath);
                        fs = new FileInputStream(file2);
                        try {
                            try {
                                Class.forName("com.mysql.jdbc.Driver").newInstance();
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(SalinDataUtamaServlet.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } catch (InstantiationException ex) {
                            Logger.getLogger(SalinDataUtamaServlet.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IllegalAccessException ex) {
                            Logger.getLogger(SalinDataUtamaServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        String otherFieldName = item.getFieldName();
                        String otherFieldValue = item.getString();
                        System.out.println("otherFieldName = " + otherFieldName);
                        System.out.println("otherFieldValue = " + otherFieldValue);
                        if (otherFieldName.equals("nipAtasan")) {
                            nipPns = otherFieldValue;
                        }
                         if (otherFieldName.equals("session")) {
                            session_pil = otherFieldValue;
                        }
                    }
                }
              //  String fotoBlob = new GoIndex().getSimpanFotoBlob(nipPns, fs);
            
                fs.close();
                File file3 = new File(dirPath);
                if (session_pil.equals("Pns SKP")||session_pil.equals("pns")){
                 String isiData = new GoIndex().getInsertPns(dirPath);
                System.out.println("file3.delete( = " + file3.delete());
                }else if (session_pil.equals("Unor SKP") ||session_pil.equals("unor") ){ 
                     // String isiData = new GoIndex().getInsertPns(dirPath);
                       String isiData = new GoIndex().getInsertUnor(dirPath);
                System.out.println("file3.delete( = " + file3.delete());
                }
                
                
            } catch (Exception ex) {
                Logger.getLogger(SalinDataUtamaServlet.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(SalinDataUtamaServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            RequestDispatcher dis = null;
            dis = request.getRequestDispatcher("/WEB-INF/jsp/indexloginBaru.jsp");
            dis.include(request, response);
        }
          
        
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
