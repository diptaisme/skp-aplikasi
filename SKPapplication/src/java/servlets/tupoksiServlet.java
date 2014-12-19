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
import model.*;

/**
 *
 * @author diptaisme
 */
public class tupoksiServlet extends HttpServlet {

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
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        try {
//            /*
//             * TODO output your page here. You may use following sample code.
//             */
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet tupoksiServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet tupoksiServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        } finally {            
//            out.close();
//        }
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
            throws ServletException, IOException 
    {
      
        String id=request.getParameter("txtNIPBaru"); //ambil NIPBARU dari lemparan hiperlink index.jsp (parameter : txtNIPBaru)
        String idTB = request.getParameter("txtNIPBaruTB");
         String nipKelokpokKriteria= request.getParameter("nipKelokpokKriteria");
          String namaKelompok= request.getParameter("namaKelompok");
        if (id != null && id != "" && id != " ")                        
        {
            //domain PnsSkp
            PnsSkp pns=new GoIndex().getPns(id); //ambil data dari tabel pns (semuanya), ke business (goindex) lalu ke dao (ada where = id (nipbaru))
            String unorAtasan = pns.getDiAtasanId(); //ambil satu2 dari "pns" diatas
            String UnorPns = pns.getUnorId();
            String InstansiPns = pns.getInstansiId();
            String NipPns = pns.getNipBaru(); 

            PnsSkp UnorAts=new GoIndex().getUnorAtasan(unorAtasan); //ambil gelondongan    

            List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);

            //baru 22022012
            instansiri ins = new GoIndex().getInstansi(InstansiPns);
            String NamaInstansi = ins.getNamaInstansi();

            //baru 22022012 -- untuk list
            //String insA = request.getParameter("instansiA");
            //String unoA = request.getParameter("unorA");
            List<UnorKeTupoksi> unosiServlet = new GoIndex().getUnosi(UnorPns, InstansiPns);

            request.setAttribute("pns", pns);
            request.setAttribute("UnorAts", UnorAts);  
            request.setAttribute("ins", ins);

            request.setAttribute("tukesiServlet", tukesiServlet);
            request.setAttribute("unosiServlet", unosiServlet);
           

            //RequestDispatcher dis=request.getRequestDispatcher("tupoksi.jsp");
            RequestDispatcher dis=request.getRequestDispatcher("/WEB-INF/jsp/tupoksiBaru.jsp");
            dis.forward(request, response); 
       
        }else if(nipKelokpokKriteria!= null){
             PnsSkp pns=new GoIndex().getPns(nipKelokpokKriteria); //ambil data dari tabel pns (semuanya), ke business (goindex) lalu ke dao (ada where = id (nipbaru))
            String unorAtasan = pns.getDiAtasanId(); //ambil satu2 dari "pns" diatas
            String UnorPns = pns.getUnorId();
            String InstansiPns = pns.getInstansiId();
            String NipPns = pns.getNipBaru(); 

            PnsSkp UnorAts=new GoIndex().getUnorAtasan(unorAtasan); //ambil gelondongan    

            List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);

            //baru 22022012
            instansiri ins = new GoIndex().getInstansi(InstansiPns);
            String NamaInstansi = ins.getNamaInstansi();

            //baru 22022012 -- untuk list
            //String insA = request.getParameter("instansiA");
            //String unoA = request.getParameter("unorA");
            List<UnorKeTupoksi> unosiServlet = new GoIndex().getUnosi(UnorPns, InstansiPns);

            request.setAttribute("pns", pns);
            request.setAttribute("UnorAts", UnorAts);  
            request.setAttribute("ins", ins);

            request.setAttribute("tukesiServlet", tukesiServlet);
            request.setAttribute("unosiServlet", unosiServlet);
           request.setAttribute("namaKelompok",namaKelompok);

            //RequestDispatcher dis=request.getRequestDispatcher("tupoksi.jsp");
            RequestDispatcher dis=request.getRequestDispatcher("/WEB-INF/jsp/tupoksiBaru.jsp");
            dis.forward(request, response); 
        } 
          else if ((id == null || id == "" || id == " ") && (idTB == null || idTB == "" || idTB == " "))
        {
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/indexBaruBiru2.jsp");
            dis.forward(request, response);
        }
        else if(idTB != null && idTB != "" && idTB != " ")
        {
            PnsSkp pns=new GoIndex().getPns(idTB);
            String idNip = pns.getNipBaru();
            String namaPns = pns.getNamaPns();
            request.setAttribute("namaPns", namaPns);
            request.setAttribute("idNip", idNip);
            
            RequestDispatcher dis=request.getRequestDispatcher("/WEB-INF/jsp/TugasTambahan.jsp");
            dis.forward(request, response); 
        }
        else
        {}
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
            throws ServletException, IOException 
    {
      PrintWriter out =response.getWriter();
        // String id=request.getParameter("txtNIPBaru"); //ambil NIPBARU dari lemparan hiperlink index.jsp (parameter : txtNIPBaru)
       String cariKriteria = request.getParameter("cariKriteria");
       String  cariKriteriaKlTgs = request.getParameter("cariKriteriaKlTgs");
       String submitCari = request.getParameter("submitCari");
       String id=request.getParameter("idnipText"); //ambil NIPBARU dari lemparan hiperlink index.jsp (parameter : txtNIPBaru)
       String idTB = request.getParameter("txtNIPBaruTB");
       String [] favoritetupoksis=request.getParameterValues("tupoksipaporit");
       
       
       
       
       if (submitCari.equalsIgnoreCase("CARI")){
            if (cariKriteria != null && cariKriteria!= "" && cariKriteria != " " ||  cariKriteria.equals(""))
            {
            PnsSkp pns=new GoIndex().getPns(id); //ambil data dari tabel pns (semuanya), ke business (goindex) lalu ke dao (ada where = id (nipbaru))
            String unorAtasan = pns.getDiAtasanId(); //ambil satu2 dari "pns" diatas
            String UnorPns = pns.getUnorId();
            String InstansiPns = pns.getInstansiId();
            String NipPns = pns.getNipBaru(); 

            PnsSkp UnorAts=new GoIndex().getUnorAtasan(unorAtasan); //ambil gelondongan    

            List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);

            instansiri ins = new GoIndex().getInstansi(InstansiPns);
            String NamaInstansi = ins.getNamaInstansi();

             List<UnorKeTupoksi> unosiServlet = new GoIndex().getSamaLikeTupoksi(cariKriteriaKlTgs,cariKriteria);
            
            request.setAttribute("pns", pns);
            request.setAttribute("UnorAts", UnorAts);  
            request.setAttribute("ins", ins);

            request.setAttribute("tukesiServlet", tukesiServlet);
            request.setAttribute("unosiServlet", unosiServlet);
           
            RequestDispatcher dis=request.getRequestDispatcher("/WEB-INF/jsp/tupoksiBaru.jsp");
            dis.forward(request, response); 
        }
        else if ((id == null || id == "" || id == " ") && (idTB == null || idTB == "" || idTB == " "))
        {
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/indexBaruBiru2.jsp");
            dis.forward(request, response);
        }
        else if(idTB != null && idTB != "" && idTB != " ")
        {
            PnsSkp pns=new GoIndex().getPns(idTB);
            String idNip = pns.getNipBaru();
            String namaPns = pns.getNamaPns();
            request.setAttribute("namaPns", namaPns);
            request.setAttribute("idNip", idNip);
            
            RequestDispatcher dis=request.getRequestDispatcher("/WEB-INF/jsp/TugasTambahan.jsp");
            dis.forward(request, response); 
            }
       }else if(submitCari.equalsIgnoreCase("CARIKLTGS")){
           
            PnsSkp pns=new GoIndex().getPns(id); //ambil data dari tabel pns (semuanya), ke business (goindex) lalu ke dao (ada where = id (nipbaru))
            String unorAtasan = pns.getDiAtasanId(); //ambil satu2 dari "pns" diatas
            String UnorPns = pns.getUnorId();
            String InstansiPns = pns.getInstansiId();
            String NipPns = pns.getNipBaru(); 
           if(cariKriteriaKlTgs==null ||cariKriteriaKlTgs.equals("")){
               cariKriteriaKlTgs=" ";
           }
            PnsSkp UnorAts=new GoIndex().getUnorAtasan(unorAtasan); //ambil gelondongan    

            List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);

            instansiri ins = new GoIndex().getInstansi(InstansiPns);
            String NamaInstansi = ins.getNamaInstansi();

             List<tupoksi_lama> tupoksiServlets = new GoIndex().getSamaLikeKeLompokTupoksiIdAll(cariKriteriaKlTgs);
            
            request.setAttribute("pns", pns);
            request.setAttribute("UnorAts", UnorAts);  
            request.setAttribute("ins", ins);

            request.setAttribute("tukesiServlet", tukesiServlet);
            request.setAttribute("tupoksiServlets", tupoksiServlets);
           
            RequestDispatcher dis=request.getRequestDispatcher("/WEB-INF/jsp/tabelKelompokTugas.jsp");
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
