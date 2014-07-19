/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.*;
import java.util.List;

/**
 *
 * @author Radius Imam Taufik
 */
public class RekapitulasiTarget extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RekapitulasiTarget</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RekapitulasiTarget at " + request.getContextPath () + "</h1>");
            
             out.println("<SCRIPT language='javascript' type='text/javascript'>");
                     
             out.println("</script>");        
                     
            out.println("</body>");
            out.println("</html>");
             
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        String _session = request.getParameter("pilih_session");
        String _idEselon = request.getParameter("pilih_session");
        String nipatasanMonitoringLaporan = request.getParameter("nipatasanMonitoringLaporan");
        List<PnsSkp> pnsskpList = new ArrayList<PnsSkp>();
        List<unorskp> rkppnsskpList = new ArrayList<unorskp>();
        unorskp rkppnsskpObjek = new unorskp();
        double totalBytesRead = 0;
        double totalBytesReadTarget = 0;
        double totalBytesReadNonTarget = 0;


        if (action != null && (action.equalsIgnoreCase("realisasi2"))) {
            List<unorskp> eselonIds = new GoIndex().getDBqueryUnorIdEselon(_idEselon);

            for (unorskp eselonId : eselonIds) {
                ModelLocatorSKP.globalNilaivalTarget = 0;
                ModelLocatorSKP.globalNilainonvalTarget = 0;
                pnsskpList = new GoIndex().getDBqueryUnorIdRekapitulasi(eselonId.getIdUnor(), _session);
                totalBytesRead = 0;
                totalBytesReadTarget = 0;
                totalBytesReadNonTarget = 0;
                rkppnsskpObjek = new unorskp();
                rkppnsskpObjek = eselonId;

                /*if (pnsskpList != null) {
                for (PnsSkp pnsSkp : pnsskpList) {
                totalBytesRead = totalBytesRead + 1;
                if (pnsSkp.getRealisasi().equals("0")) {
                totalBytesReadNonTarget = totalBytesReadNonTarget + 1;
                } else {
                totalBytesReadTarget = totalBytesReadTarget + 1;
                }
                }
                
                }*/
                rkppnsskpObjek.setjum1(Double.toString(ModelLocatorSKP.globalNilaivalTarget));
                rkppnsskpObjek.setjum2(Double.toString(ModelLocatorSKP.globalNilainonvalTarget));
                rkppnsskpList.add(rkppnsskpObjek);
            }


            request.setAttribute("rkppnsskpList", rkppnsskpList);
            PrintWriter out = response.getWriter();
            StringBuilder sb = new StringBuilder();
            String warna = "b";
            for (int i = 0; i < rkppnsskpList.size(); i++) {
                if (warna.equals("b")) {
                    sb.append("<tr style='background: #b9c9fe'>"
                            + "<td width='30' align='center'>" + (i + 1) + "</td>"
                            + "<td width='200'><div align='left'><a href='RekapitulasiTarget?action=Monitor&txtNIPBaru='" + rkppnsskpList.get(i).getEselonId() + "id=url"+rkppnsskpList.get(i).getIdUnor() +" onclick='redirectToFB(this.id)'>" + rkppnsskpList.get(i).getNamaUnor() + "</a></div></td>"
                            + "  <td><div align='left'><a href='RekapitulasiTarget?action=Monitor&txtNIPBaru='" + rkppnsskpList.get(i).getEselonId() + "id=url"+rkppnsskpList.get(i).getIdUnor() +" onclick='redirectToFB(this.id)'>" + rkppnsskpList.get(i).getjum1() + " </a></div></td>"
                            + "  <td><div align='left'><a href='RekapitulasiTarget?action=Monitor&txtNIPBaru='" + rkppnsskpList.get(i).getEselonId() + "id=url"+rkppnsskpList.get(i).getIdUnor() +" onclick='redirectToFB(this.id)'>" + rkppnsskpList.get(i).getjum2() + "</a></div></td>"
                            + "</tr>");
                    warna = "c";
                } else {
                    sb.append("<tr style='background: #e8edff'>"
                            + "<td width='30' align='center'>" + (i + 1) + "</td>"
                            + "<td width='200'><div align='left'><a href='RekapitulasiTarget?action=Monitor&txtNIPBaru='" + rkppnsskpList.get(i).getEselonId() + "id=url"+rkppnsskpList.get(i).getIdUnor() +" onclick='redirectToFB(this.id)'>" + rkppnsskpList.get(i).getNamaUnor() + " </a></div></td>"
                            + "<td><div align='left'><a href='RekapitulasiTarget?action=Monitor&txtNIPBaru='" + rkppnsskpList.get(i).getEselonId() + "id=url"+rkppnsskpList.get(i).getIdUnor() +" onclick='redirectToFB(this.id)'>" + rkppnsskpList.get(i).getjum1() + " </a></div></td>"
                            + "<td><div align='left'><a href='RekapitulasiTarget?action=Monitor&txtNIPBaru='" + rkppnsskpList.get(i).getEselonId() + "id=url"+rkppnsskpList.get(i).getIdUnor() +" onclick='redirectToFB(this.id)'>" + rkppnsskpList.get(i).getjum2() + "</a></div></td>"
                            + "</tr>");
                 warna = "b";
                }
               
            }
       
             out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RekapitulasiTarget</title>");  
            out.println("</head>");
            
            out.print("<table  width='800' >");
            out.print("<tr align='center' style='background: #ccccff'>");
            out.print("<td width ='30'>No.</td>");
            out.print("<td  width ='200' >Nama Unor</td>");
            out.print("<td width ='100' >Jumlah PNS yang belum mengisi SKP</td>");
            out.print("<td width ='100' >Jumlah PNS yang sudah mengisi SKP</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print(sb);
            out.print("</tr>");
            out.print("</table>");
            
             StringBuilder perintah = new StringBuilder();
             StringBuilder perintah2 = new StringBuilder();
            
            out.println("<SCRIPT language='javascript' type='text/javascript'>");
                     perintah.append("function redirectToFB(id){url2=document.getElementById(id);" 
                             + " pilihan='test';"
                             + "url2.href=url2.href +'&pilih_session=' + pilihan;}");
                  
              out.print(perintah);       
                     perintah2.append("function redirectToFB2(id){"
                + "url3test=document.getElementById(id);"
                + " window.opener.location.href=url3test;"
                 + "self.close();}");
                     
                out.print(perintah2);     
                     
             out.println("</script>");        
                     
            out.println("</body>");
            out.println("</html>");
            out.close();

        } if (action != null && (action.equalsIgnoreCase("Monitor"))) {
             PrintWriter out = response.getWriter();
            StringBuilder sb = new StringBuilder();
              out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RekapitulasiTarget</title>");  
            out.println("</head>");
            
            out.print("<table  width='800' >");
            out.print("<tr align='center' style='background: #FF9900'>");
            out.print("<td width ='30'>No.</td>");
            out.print("<td  width ='200' >Nama Unor Test</td>");
            out.print("<td width ='50' >Jumlah PNS yang belum mengisi SKP</td>");
            out.print("<td width ='50' >Jumlah PNS yang sudah mengisi SKP</td>");
            out.print("</tr>");
            out.print("<tr>");
           // out.print(sb);
            out.print("</tr>");
            out.print("</table>");
            out.close();
             StringBuilder perintah = new StringBuilder();
            
            out.println("</body>");
            out.println("</html>");
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
