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
import model.GoIndex;
import model.RiwayatAtasanBawahan;
import model.TupoksiKeIsi4Faktor;
import model.PnsSkp;
import model.rw_periode;
import model.unorskp;

/**
 *
 * @author Sony
 */
public class SimpanatasanBawahanRiwayatServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
          
        } finally {            
            out.close();
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          String idAtasan=request.getParameter("getIdPns"); //ambil NIPBARU dari lemparan hiperlink index.jsp (parameter : txtNIPBaru)
          String instansiIdAtasan= request.getParameter("getinstansiId");        
          String UnorIdatasan= request.getParameter("getUnorId");
          
          String instansiIdpnsBawahan= request.getParameter("instansiIdpns");
          String instansiIdunorbawahan= request.getParameter("instansiIdunorbwhandocument");
         
          if(instansiIdpnsBawahan==null ||instansiIdpnsBawahan.equals("") || instansiIdpnsBawahan.equals(" ") ){
              instansiIdpnsBawahan= ModelLocatorSKP.nipBaruUser;
              instansiIdunorbawahan=ModelLocatorSKP.IdUnorUser;
          }
           String _pesan = new GoIndex().getsimpanRiwayatAtasan_Bawahan(idAtasan,instansiIdAtasan,UnorIdatasan,instansiIdpnsBawahan,instansiIdunorbawahan);
            
           RiwayatAtasanBawahan riwayatAtasanBawahan  = new GoIndex().getSimpanRiwayatAtasan_Bawahan(idAtasan,instansiIdAtasan,UnorIdatasan,instansiIdpnsBawahan,instansiIdunorbawahan);
           PnsSkp pns = new GoIndex().getPns(instansiIdpnsBawahan);   
           PnsSkp UnorAts=null;
            if (riwayatAtasanBawahan==null){
                 UnorAts= new GoIndex().getPns(ModelLocatorSKP.nipBaruAtasan);  
            }else{
                
                unorskp unorskp =new GoIndex().getIdUnorskp(UnorIdatasan);
                String idunorskp=unorskp.getIdUnor();
                String InstansiIdskp=unorskp.getInstansiId();
                String NamaUnordskp=unorskp.getNamaUnor();
                String NamaJabatanskp=unorskp.getNamaJabatan();
                
              /*  iunor.setIdUnor(rs.getString(1));
            iunor.setInstansiId(rs.getString(2));
            iunor.setDiAtasanId(rs.getString(3));
            iunor.setEselonId(rs.getString(4));
            iunor.setNamaUnor(rs.getString(5));
            iunor.setNamaJabatan(rs.getString(6));
            iunor.setPemimpinPnsId(rs.getString(7));*/
                  ModelLocatorSKP.nipBaruAtasan=idAtasan;
                  UnorAts= new GoIndex().getPns(idAtasan);
                  UnorAts.setUnorId(UnorIdatasan);
                  UnorAts.setNamaUnor(NamaUnordskp);
                  UnorAts.setNamaJabatan(NamaJabatanskp);
                 
            }
            
             List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(instansiIdunorbawahan, instansiIdAtasan,instansiIdpnsBawahan);

                    request.setAttribute("pns", pns);
                    request.setAttribute("UnorAts", UnorAts);
                    request.setAttribute("tukesiServlet", tukesiServlet); 
                    RequestDispatcher dis = request.getRequestDispatcher("indexBaruBiru2.jsp");
                    dis.forward(request, response);
    
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
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
