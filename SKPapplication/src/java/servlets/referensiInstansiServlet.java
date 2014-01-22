/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class referensiInstansiServlet extends HttpServlet {

    public String cariInstansi;
    public String isAllInstansi;
    public String cariUnor;
    public String SkodeInstansi;
 public String updateUnor;
 public String instansi;
 public String nipbaru;
 public String diatasanUnor;
  public String namaUnorBaru;
  public String namaJabatanBaru;
   public String jenisJab;
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
            throws ServletException, IOException, SQLException {
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
       String Jenis = String.valueOf(ModelLocatorSKP.jenisJabatan); 
        ModelLocatorSKP.jenisJabatan = Integer.valueOf(Jenis);
        String action = request.getParameter("action");
        String idTupoksiUntukHapus = request.getParameter("idTupoksiHapus");
        String idTupoksiUntukUpdate = request.getParameter("idTupoksiUpdate");
        String updateUnorAtasan = request.getParameter("jenisStatus");
        String InstansiId = request.getParameter("idInstansiText");
        
        String getIdPns=request.getParameter("getIdPns");
        String getinstansiId=request.getParameter("getinstansiId");
        String getUnorId=request.getParameter("getUnorId");
        if (action != null && action.equalsIgnoreCase("HapusTupoksi"))
            
        {
            String kodeUnor =null;
            String kodeInstansi = null;
            
            String _kodeIdInstansi = request.getParameter("InstansiHapus");
                       
           String idUnorTextJ = request.getParameter("UnorHapus");           

           
                   
                  String KodeJabatan = request.getParameter("JabHapus");
                           
                  
                  if (Jenis.equals("1")){
                       instansiri instansie = new GoIndex().getInstansi(_kodeIdInstansi);
                     String namaInstansi = instansie.getNamaInstansi();
                       kodeInstansi = instansie.getIdInstansi();
                       unorskp unorie = new GoIndex().getUnor(idUnorTextJ, _kodeIdInstansi);
                request.setAttribute("unorie", unorie);
                String namaUnor = unorie.getNamaUnor();
                  kodeUnor = unorie.getIdUnor();
//kalau struktural yang dihapus harus liat unor dan instansi nya dulu!!!
                      
                      String _pesan = new GoIndex().getHpsIdTupoksi(idTupoksiUntukHapus, Jenis, _kodeIdInstansi,idUnorTextJ, KodeJabatan);
                     
                request.setAttribute("namaInstansi", namaInstansi);
                request.setAttribute("kodeInstansi", kodeInstansi);
                
                request.setAttribute("namaUnor", namaUnor);
                request.setAttribute("kodeUnor", kodeUnor);
               
                 }
                  else if(Jenis.equals("2")){//fungsional
                      String _pesan = new GoIndex().getHpsIdTupoksi(idTupoksiUntukHapus, Jenis, _kodeIdInstansi,idUnorTextJ, KodeJabatan);
                    // jabfung jabatanfungfum = new GoIndex().getJabatanFungsional(KodeJabatan); 
                     
                      List<jabfung> jabatanfungfum = new GoIndex().getListJabatanFungsional(KodeJabatan);
                     jabfung jabatanfung = new GoIndex().getJabatanFungsional(KodeJabatan);    
               String kelompok =  jabatanfung.getkelJabatanId();
               List<kelompokJabatan> kelJab = new GoIndex().getSatuRumpun(kelompok);
               request.setAttribute("kelJab", kelJab);
                     
                     request.setAttribute("jabatanfungfum", jabatanfungfum);
                   
                  }
                   else if(Jenis.equals("4")){//umum
                      String _pesan = new GoIndex().getHpsIdTupoksi(idTupoksiUntukHapus, Jenis, _kodeIdInstansi,idUnorTextJ, KodeJabatan);
                        
                        // jabfum jabatanfungfum = new GoIndex().getJabatanUmum(KodeJabatan);
               List<jabfum> jabatanfungfum = new GoIndex().getRumpunUmumById(KodeJabatan);
               
                      request.setAttribute("jabatanfungfum", jabatanfungfum);
                      
                  }

           
            
            List<tupoksi> Tupoksi = new GoIndex().getTupoksiAllJabatan(kodeUnor, kodeInstansi, KodeJabatan, Jenis);  
             
             
             request.setAttribute("Tupoksi", Tupoksi);
            request.setAttribute("jabatan", Jenis);
               
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/insertTupoksiBaruBiru.jsp");
            dis.forward(request, response);
            
        }
        
          else if (updateUnorAtasan != null && updateUnorAtasan.equalsIgnoreCase("updateUnorAtasan")){
            
            updateUnor = request.getParameter("idUnorBaru"); //id unor baru
        jenisJab = request.getParameter("jenis");
        if (jenisJab.equals("2")||jenisJab.equals("4") ){
             diatasanUnor = request.getParameter("idUnorBaru");
        }else{
             diatasanUnor = request.getParameter("diatasanId");
        }
       
        nipbaru = request.getParameter("nipBaru");
      
        
         if (updateUnor != null ) {
            DBConnection dbConn = DBConnection.getInstance();
             
            //pnsskp pns = (PnsSkp) new GoIndex().getUpdateUnor(nipbaru, updateUnor, diatasanUnor);
           unorskp namaUnor = new GoIndex().getIdUnorskp(updateUnor);
       
           request.setAttribute("namaUnor", namaUnor);
          InstansiId = request.getParameter("instansi");
                 
           namaUnorBaru = namaUnor.getNamaUnor();
           namaJabatanBaru = namaUnor.getNamaJabatan();
            new GoIndex().getUpdateUnorPns(nipbaru, diatasanUnor, updateUnor, namaUnorBaru, namaJabatanBaru);
            ModelLocatorSKP.IdUnorUser=updateUnor;
             PnsSkp pns = new GoIndex().getPns(nipbaru);
            request.setAttribute("pns", pns);
             instansiri ins = new GoIndex().getInstansi(instansi);
            request.setAttribute("ins", ins);
           
            //RequestDispatcher dis = request.getRequestDispatcher("TabelUnor.jsp");
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/updateMenu.jsp");
            dis.forward(request, response);
        }
        
            
        }
        
        else if(action != null && action.equalsIgnoreCase("UpdateTupoksi"))
        {
            tupoksi_lama _getIdInstansiIdUnorDariIdTupoksi = new GoIndex().getallDariIdTupoksi(idTupoksiUntukUpdate);
            tupoksi Tupoksi = new GoIndex().getIdtupoksiAll(idTupoksiUntukUpdate);
            
            //String kodeInstansi = _getIdInstansiIdUnorDariIdTupoksi.getIdInstansi();
            //String kodeUnor = _getIdInstansiIdUnorDariIdTupoksi.getIdUnor();
            //String namaInstansi = _getIdInstansiIdUnorDariIdTupoksi.getInstansiNama();
            //String namaUnor = _getIdInstansiIdUnorDariIdTupoksi.getNamaUnor();
            //String namaTupoksi = _getIdInstansiIdUnorDariIdTupoksi.getNamaTupoksi();
            //String kodeTupoksi = _getIdInstansiIdUnorDariIdTupoksi.getIdTupoksi();
            //String angkakrdt = _getIdInstansiIdUnorDariIdTupoksi.getangka_krdt();
           // String jenis = request.getParameter("jabatan");
            
            // List<jabfung> jabatanfungfum = new GoIndex().getSatuRumpunFungsional(kelJabatan);
                           
            //                List<kelompokJabatan> kelJab = new GoIndex().getSatuRumpun(kelJabatan);
            
            //String kelJab = request.getParameter("kelJab");
           
           
            
            String kodeInstansi = Tupoksi.getIdInstansi();
            String kodeUnor = Tupoksi.getIdUnor();
            String namaInstansi = Tupoksi.getInstansiNama();
            String namaUnor = Tupoksi.getNamaUnor();
            String namaTupoksi = Tupoksi.getNamaTupoksi();
            String kodeTupoksi = Tupoksi.getIdTupoksi();
            String kelJab = Tupoksi.getnamaKelompok();
            String JabId = Tupoksi.getjabatanId();
            String angkakrdt = Tupoksi.getangka_krdt();
            
            request.setAttribute("kodeInstansi", kodeInstansi);
            request.setAttribute("kodeUnor", kodeUnor);
            request.setAttribute("namaInstansi", namaInstansi);
            request.setAttribute("namaUnor", namaUnor);
            request.setAttribute("namaTupoksi", namaTupoksi);
            request.setAttribute("kodeTupoksi", kodeTupoksi);
            if ( Jenis.equals("2")){
               // List<kelompokJabatan> kelJab2 = new GoIndex().getSatuRumpun(JabId);                
               // List<jabfung> jabatanfungfum = new GoIndex().getSatuRumpunFungsional(JabId);
                kelompokJabatan kelJab2 = new GoIndex().getKelompokJabatan(kelJab);
                jabfung jabatanfungfum = new GoIndex().getJabatanFungsional(JabId);          
                    
                           request.setAttribute("kelJab", kelJab2);
                           request.setAttribute("JabId", jabatanfungfum);
            } 
            if(Jenis.equals("4")){//update umum
                  jabfum jabatanfungfum = new GoIndex().getJabatanUmum(JabId);
                           //request.setAttribute("kelJab", kelJab);
                           request.setAttribute("JabId", jabatanfungfum);
                   
            }
           
            
          //  request.setAttribute("kelJab", kelJab);
          //  request.setAttribute("JabId", JabId);
            request.setAttribute("angkakrdt", angkakrdt);
            request.setAttribute("listTupoksi", idTupoksiUntukUpdate);
            
            
            request.setAttribute("jabatan", Jenis);
            request.setAttribute("Tupoksi", Tupoksi);
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/ubahInsertTupoksiBaruBiru.jsp"); //update
            dis.forward(request, response);
        }
        else //klik link instansi
        {
            SkodeInstansi = request.getParameter("idInstkode");
           // SkodeInstansi = request.getParameter("idInstansiText");
            String SnamaInstansi = request.getParameter("namaInstansiL");
            String idUnorKode = request.getParameter("idUnorKode");
            String namaUnorL = request.getParameter("namaUnorL");
            String namaIDInstansiUnor = request.getParameter("namaIDInstansiUnor");

            if (SkodeInstansi != null && namaIDInstansiUnor == null) {
                instansiri instansie = new GoIndex().getInstansi(SkodeInstansi);
                
                String namaInstansi = instansie.getNamaInstansi();
                String kodeInstansi = instansie.getIdInstansi();
                
                request.setAttribute("namaInstansi", namaInstansi);
                request.setAttribute("kodeInstansi", kodeInstansi);
                
                request.setAttribute("SkodeInstansi", SkodeInstansi);
                request.setAttribute("instansie", instansie);
                request.setAttribute("jabatan", ModelLocatorSKP.jenisJabatan);

                //RequestDispatcher dis = request.getRequestDispatcher("insertTupoksi.jsp");
                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/insertTupoksiBaruBiru.jsp");
                dis.forward(request, response);
            } else if (namaIDInstansiUnor != null) {
                instansiri instansie = new GoIndex().getInstansi(cariInstansi);
                 instansie = new GoIndex().getInstansi(namaIDInstansiUnor);
                request.setAttribute("instansie", instansie);
                
                String namaInstansi = instansie.getNamaInstansi();
                String kodeInstansi = instansie.getIdInstansi();
                
                request.setAttribute("namaInstansi", namaInstansi);
                request.setAttribute("kodeInstansi", kodeInstansi);
               // unorskp unorie = new GoIndex().getUnor(idUnorKode, kodeInstansi);
             unorskp unorie = new GoIndex().getUnor(idUnorKode, namaIDInstansiUnor);
                request.setAttribute("unorie", unorie);
                
                String namaUnor = unorie.getNamaUnor();
                String kodeUnor = unorie.getIdUnor();
                request.setAttribute("namaUnor", namaUnor);
                request.setAttribute("kodeUnor", kodeUnor);
                 request.setAttribute("jabatan", Jenis);

                //RequestDispatcher dis = request.getRequestDispatcher("insertTupoksi.jsp");
                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/insertTupoksiBaruBiru.jsp");
                dis.forward(request, response);
            } else {
                ambilDataInstansi(request, response);
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
        //dari klik 'cari instansi' di insertTupoksi.jsp
        String Submit = request.getParameter("Submit");
        String Submit1 = request.getParameter("Submit1");
        String jenisJabatan = request.getParameter("jabatan");
        
        if(jenisJabatan == null){
              jenisJabatan = Integer.toString(ModelLocatorSKP.jenisJabatan);
           
         }else{
               jenisJabatan = request.getParameter("jabatan");
           
         }
        
         String kelJabatan = request.getParameter("kelJab");
          //jenisJabatan = Integer.toString(ModelLocatorSKP.jenisJabatan);
         
          ModelLocatorSKP.jenisJabatan = Integer.valueOf(jenisJabatan); 
        isAllInstansi = request.getParameter("isAllInstansi");
        cariInstansi = request.getParameter("cariInstansi");
        cariUnor = request.getParameter("cariUnor");
         updateUnor = request.getParameter("updateUnor");

        if (isAllInstansi != null || cariInstansi != null) {
            ambilDataInstansi(request, response);
        }

        if (isAllInstansi != null || cariUnor != null) {
            ambilDataUnor(request, response);
        }
          if (updateUnor != null) {
            ambilDataUnorForUpdate(request, response);
        }
        
        
        if(Submit != null)
        {
            //dari klik 'cari instansi' di insertTupoksi.jsp   
            if (Submit.equalsIgnoreCase("CARI INSTANSI") || "CARI INSTANSI".equals(Submit))
            {
                cariInstansi = request.getParameter("cariInstansi");

                if (cariInstansi == null)
                {
                    try
                    {
                        DBConnection dbConn = DBConnection.getInstance();
                        List<instansiri> instansies = new GoIndex().getAllInstansi();
                        request.setAttribute("instansies", instansies);
                        //RequestDispatcher dis = request.getRequestDispatcher("TabelInstansi.jsp");
                        RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/TabelInstansiBaruBiru.jsp");
                        dis.forward(request, response);
                    }
                    catch (SQLException ex)
                    {
                        Logger.getLogger(referensiInstansiServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else
                {
                    DBConnection dbConn = DBConnection.getInstance();
                    List<instansiri> instansies = new GoIndex().getCariInstansi(cariInstansi);
                    request.setAttribute("instansies", instansies);
                    //RequestDispatcher dis = request.getRequestDispatcher("TabelInstansi.jsp");
                    RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/TabelInstansiBaruBiru.jsp");
                    dis.forward(request, response);
                }
            }
            else if (Submit.equalsIgnoreCase("CARI UNOR"))
            {
                                cariInstansi = request.getParameter("idInstansiText");
                cariUnor = request.getParameter("cariUnor");

                if (cariUnor == null)
                {
                    DBConnection dbConn = DBConnection.getInstance();
                    List<unorskp> unories = new GoIndex().getUnoriUN(cariInstansi);
                    request.setAttribute("unories", unories);
                    request.setAttribute("instansi", cariInstansi);
                    //RequestDispatcher dis = request.getRequestDispatcher("TabelUnor.jsp");
                    RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/TabelUnorBaruBiru.jsp");
                    dis.forward(request, response);
                }
                else
                {
                    DBConnection dbConn = DBConnection.getInstance();
                    List<unorskp> unories = new GoIndex().getCariUnor(cariUnor, cariInstansi);
                    request.setAttribute("unories", unories);
                    //RequestDispatcher dis = request.getRequestDispatcher("TabelUnor.jsp");
                    RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/TabelUnorBaruBiru.jsp");
                    dis.forward(request, response);
                }
            }
                    
                   else if (Submit.equalsIgnoreCase("CARI KELOMPOK"))  
                   {
                        jenisJabatan = request.getParameter("jabatan");
                        
                        
                        ModelLocatorSKP.jenisJabatan = Integer.valueOf(jenisJabatan);
                        
                       if (ModelLocatorSKP.jenisJabatan ==  2)
                       {
                           DBConnection dbConn = DBConnection.getInstance();
                           List<kelompokJabatan> kelJab = new GoIndex().getSatuRumpun("null");
                           request.setAttribute("kelJab", kelJab);
                       }
                                      
                       else if (ModelLocatorSKP.jenisJabatan ==  4)
                       {
                           
                       }
                        request.setAttribute("jabatan", jenisJabatan);
                      // List<kelompokJabatan> kelompok = new GoIndex().getUnoriUN(SkodeInstansi);
                        RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/insertTupoksiBaruBiru.jsp");
                        //request.setAttribute("jabatan", ModelLocatorSKP.jenisJabatan );
                    dis.forward(request, response);
                   }
                    
                     else if (Submit.equalsIgnoreCase("CARI JABATAN"))  
                   {
                       kelJabatan = request.getParameter("kelJab");
                        jenisJabatan = request.getParameter("jabatan");
                        String cariUmum = request.getParameter("cariUmum");
                        String IdKelJabatan = request.getParameter("kelJab");
                          ModelLocatorSKP.jenisJabatan = Integer.valueOf(jenisJabatan);
                          
                         
                       if (ModelLocatorSKP.jenisJabatan ==  2)
                       {
                           DBConnection dbConn = DBConnection.getInstance();
                           List<jabfung> jabatanfungfum = new GoIndex().getSatuRumpunFungsional(kelJabatan);
                           
                            List<kelompokJabatan> kelJab = new GoIndex().getSatuRumpun(kelJabatan);
                           request.setAttribute("kelJab", kelJab);
                           request.setAttribute("jabatanfungfum", jabatanfungfum);
                       }
                                      
                       else if (ModelLocatorSKP.jenisJabatan ==  4)
                       {
                            DBConnection dbConn = DBConnection.getInstance();
                             List<jabfum> jabatanfungfum = new GoIndex().getRumpunUmum(cariUmum);
                           //request.setAttribute("kelJab", kelJab);
                           request.setAttribute("jabatanfungfum", jabatanfungfum);
                            
                       }
                         request.setAttribute("jabatan", jenisJabatan);
                         //request.setAttribute("kelJab", IdKelJabatan);
                      // List<kelompokJabatan> kelompok = new GoIndex().getUnoriUN(SkodeInstansi);
                        RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/insertTupoksiBaruBiru.jsp");
                        //request.setAttribute("jabatan", ModelLocatorSKP.jenisJabatan );
                    dis.forward(request, response);
                   }
                    
                    
                    
            else if (Submit.equalsIgnoreCase("LIHAT TUPOKSI"))
            {
             
                String kodeInstansi = "";
                String kodeUnor = "";
                String _kodeIdInstansi = request.getParameter("idInstansiText");
                String idUnorTextJ = request.getParameter("idUnorText");
              jenisJabatan = request.getParameter("jabatan");
               String KodeJabatan = request.getParameter("jabatanfungfum");
               String kelompokJabatan = request.getParameter("kelJab");
                   if (jenisJabatan.equals("1")){
                    
                 
                     instansiri instansie = new GoIndex().getInstansi(_kodeIdInstansi);
                     String namaInstansi = instansie.getNamaInstansi();
                      kodeInstansi = instansie.getIdInstansi();
                request.setAttribute("namaInstansi", namaInstansi);
                request.setAttribute("kodeInstansi", kodeInstansi);
                
                
                unorskp unorie = new GoIndex().getUnor(idUnorTextJ, _kodeIdInstansi);
                request.setAttribute("unorie", unorie);
                String namaUnor = unorie.getNamaUnor();
                 kodeUnor = unorie.getIdUnor();
                request.setAttribute("namaUnor", namaUnor);
                request.setAttribute("kodeUnor", kodeUnor);
                  KodeJabatan = request.getParameter("jabatanfungfum");
                 }  
                   
                  
                   
                                else if (jenisJabatan.equals("2"))
                {
                    
                      
                           List<jabfung> jabatanfungfum = new GoIndex().getSatuRumpunFungsionalId(kelompokJabatan,KodeJabatan);
                           
                            List<kelompokJabatan> kelJab = new GoIndex().getSatuRumpun(kelompokJabatan);
                           
                           
                           request.setAttribute("kelJab", kelJab);
                           request.setAttribute("jabatanfungfum", jabatanfungfum);
                     
                    
                       }
                   
                                  else if (jenisJabatan.equals("4")){
                   
                             List<jabfum> jabatanfungfum = new GoIndex().getRumpunUmumById(KodeJabatan);
                           //request.setAttribute("kelJab", kelJab);
                           request.setAttribute("jabatanfungfum", jabatanfungfum);
                   
                   }
                
                
                 List<tupoksi> Tupoksi = new GoIndex().getTupoksiAllJabatan(kodeUnor, kodeInstansi, KodeJabatan, jenisJabatan);  
               
                
//                List<tupoksi_lama> Tupoksi = new GoIndex().getIdtupoksiUnor(idUnorTextJ, _kodeIdInstansi);
                request.setAttribute("Tupoksi", Tupoksi);
                request.setAttribute("jabatan", jenisJabatan);
              //  request.setAttribute("jabatanfungfum", KodeJabatan);
                // request.setAttribute("jabatanfungfum", jabatanfungfum);
                //RequestDispatcher dis = request.getRequestDispatcher("insertTupoksi.jsp");
                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/insertTupoksiBaruBiru.jsp");
                dis.forward(request, response);
                
            }
            else if (Submit.equalsIgnoreCase("SIMPAN"))
            {
                String idUnor = "";
                 String _pilih_output_Jabatan = request.getParameter("pilih_output_Jabatan");
                 String namaKelompok = request.getParameter("kelJab");
                 jenisJabatan = request.getParameter("jabatan");
                String namaInstansiTextJ = request.getParameter("namaInstansiText");
                String _kodeIdInstansi = request.getParameter("idInstansiText");
                String JabatanId = request.getParameter("jabatanfungfum");
                String namaUnorTextJ = request.getParameter("namaUnorText");
                String idUnorTextJ = request.getParameter("idUnorText");

                String textArea1 = request.getParameter("textarea1");
                String angka_Krdt = request.getParameter("angka_krdtText");
                request.setAttribute("namaInstansi", namaInstansiTextJ);
                request.setAttribute("kodeInstansi", _kodeIdInstansi);
                 
                 request.setAttribute("namaUnor", namaUnorTextJ);
                 request.setAttribute("kodeUnor", idUnorTextJ);
                 
                
               if (jenisJabatan.equals("1")){
                 unorskp _unorskp = new GoIndex().getUnor(idUnorTextJ, _kodeIdInstansi);
                 idUnor = _unorskp.getDiAtasanId();
               } 
               else if (jenisJabatan.equals("2"))
                {
                          // List<jabfung> jabatanfungfum = new GoIndex().getSatuRumpunFungsional(JabatanId);
                           
                            List<jabfung> jabatanfungfum = new GoIndex().getSatuRumpunFungsionalId(namaKelompok,JabatanId);
                           
                            List<kelompokJabatan> kelJab = new GoIndex().getSatuRumpun(namaKelompok);
                           
                            
                            
                            request.setAttribute("kelJab", kelJab);
                           request.setAttribute("jabatanfungfum", jabatanfungfum);
                       }
               else if (jenisJabatan.equals("4"))
                {
                           List<jabfum> jabatanfungfum = new GoIndex().getRumpunUmumById(JabatanId);
                            request.setAttribute("jabatanfungfum", jabatanfungfum);
                    
                }
               
               
                         request.setAttribute("jabatan", jenisJabatan);
               
                String tpMaksimum = new GoIndex().MaksimumTupoksi();
                String test = textArea1;

                DBConnection dbConn = DBConnection.getInstance();
                String _pesan = new GoIndex().getInsertTupoksiOperator(tpMaksimum, textArea1, idUnorTextJ, namaUnorTextJ, _kodeIdInstansi, namaInstansiTextJ, idUnor,angka_Krdt,JabatanId,namaKelompok, jenisJabatan);


               // List<tupoksi_lama> Tupoksi = new GoIndex().getIdtupoksiUnor(idUnorTextJ, _kodeIdInstansi);
                 List<tupoksi> Tupoksi = new GoIndex().getTupoksiAllJabatan(idUnorTextJ, _kodeIdInstansi, JabatanId, jenisJabatan);  
                request.setAttribute("Tupoksi", Tupoksi);
                // DBConnection dbConn = DBConnection.getInstance();
                   request.setAttribute("jabatan", jenisJabatan);
                  
                  
                   
                //   request.setAttribute("jabatanfungfum", jenisJabatan);
                //String _Isi4Faktor = new GoIndex().getsimpanIsiEmpatFaktor(iNip_id,_idTupoksi, _kuantitas4text, _kualitas4text, _waktu4text, _biaya4text);
                // String isiTupoksiOperator = ;
                //RequestDispatcher dis = request.getRequestDispatcher("insertTupoksi.jsp");
                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/insertTupoksiBaruBiru.jsp");
                dis.forward(request, response);

            }
//            else if (Submit.equalsIgnoreCase("HAPUS"))
//            {
//                String _kodeIdInstansi = request.getParameter("idInstansiText");
//                String idUnorTextJ = request.getParameter("idUnorText");
//                String idtupoksi = request.getParameter("idTupoksihit");
//
//                DBConnection dbConn = DBConnection.getInstance();
//                String _pesan = new GoIndex().getHpsTupoksi(idtupoksi, cariUnor, _kodeIdInstansi);
//
//                List<tupoksi> Tupoksi = new GoIndex().getIdtupoksiUnor(idUnorTextJ, _kodeIdInstansi);
//                request.setAttribute("Tupoksi", Tupoksi);
//
//                RequestDispatcher dis = request.getRequestDispatcher("insertTupoksi.jsp");
//                dis.forward(request, response);
//            }
            else if (Submit.equalsIgnoreCase("BATAL"))
            {
                String _kodeIdInstansi = request.getParameter("idInstansiText");
                String idUnorTextJ = request.getParameter("idUnorText");
             
                String namaKelompok = request.getParameter("kelJab");
                jenisJabatan = request.getParameter("jabatan");
                String namaInstansiTextJ = request.getParameter("namaInstansiText");
              
                String JabatanId = request.getParameter("jabatanfungfum");
               String namaUnorTextJ = request.getParameter("namaUnorText");
                
                
                
             
                
               
                //------------------------------------------------------------
                
                if (jenisJabatan.equals("1")){
                    
                       instansiri instansie = new GoIndex().getInstansi(_kodeIdInstansi);
                String namaInstansi = instansie.getNamaInstansi();
                String kodeInstansi = instansie.getIdInstansi();
                request.setAttribute("namaInstansi", namaInstansi);
                request.setAttribute("kodeInstansi", kodeInstansi);
                
                 unorskp unorie = new GoIndex().getUnor(idUnorTextJ, _kodeIdInstansi);
                request.setAttribute("unorie", unorie);
                String namaUnor = unorie.getNamaUnor();
                String kodeUnor = unorie.getIdUnor();
                request.setAttribute("namaUnor", namaUnor);
                request.setAttribute("kodeUnor", kodeUnor);
                
                    
                 unorskp _unorskp = new GoIndex().getUnor(idUnorTextJ, _kodeIdInstansi);
                 String idUnor = _unorskp.getDiAtasanId();
               } 
               else if (jenisJabatan.equals("2"))
                {
                          // List<jabfung> jabatanfungfum = new GoIndex().getSatuRumpunFungsional(JabatanId);
                           
                            List<jabfung> jabatanfungfum = new GoIndex().getSatuRumpunFungsionalId(namaKelompok,JabatanId);
                           
                            List<kelompokJabatan> kelJab = new GoIndex().getSatuRumpun(namaKelompok);
                           
                            
                            
                            request.setAttribute("kelJab", kelJab);
                           request.setAttribute("jabatanfungfum", jabatanfungfum);
                       }
               else if (jenisJabatan.equals("4"))
                {
                           List<jabfum> jabatanfungfum = new GoIndex().getRumpunUmumById(JabatanId);
                            request.setAttribute("jabatanfungfum", jabatanfungfum);
                    
                }
               
               
                         request.setAttribute("jabatan", jenisJabatan);
               
              
                DBConnection dbConn = DBConnection.getInstance();
              
               // List<tupoksi_lama> Tupoksi = new GoIndex().getIdtupoksiUnor(idUnorTextJ, _kodeIdInstansi);
                 List<tupoksi> Tupoksi = new GoIndex().getTupoksiAllJabatan(idUnorTextJ, _kodeIdInstansi, JabatanId, jenisJabatan);  
                request.setAttribute("Tupoksi", Tupoksi);
                // DBConnection dbConn = DBConnection.getInstance();
                   request.setAttribute("jabatan", jenisJabatan);
                  
                
                
                
                //-------------------------------------------------------------
                
             //   List<tupoksi_lama> Tupoksi = new GoIndex().getIdtupoksiUnor(idUnorTextJ, _kodeIdInstansi);
                request.setAttribute("Tupoksi", Tupoksi);

                //RequestDispatcher dis = request.getRequestDispatcher("insertTupoksi.jsp");
                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/insertTupoksiBaruBiru.jsp");
                dis.forward(request, response);
            }
            else if (Submit.equalsIgnoreCase("KELUAR"))
            {
               
                if (ModelLocatorSKP.levelUser.equals("3") || ModelLocatorSKP.levelUser.equals("2")) {
                
                    PnsSkp pns = new GoIndex().getPns(ModelLocatorSKP.loginNipsession);
                    if (pns == null) {
                    } else {
                        String unorAtasan;
                        PnsSkp UnorAts;
                        unorAtasan = pns.getDiAtasanId();
                        String UnorPns = pns.getUnorId();
                        if (unorAtasan.equals("")) {
                            unorAtasan = pns.getUnorId();
                        } else {
                            unorAtasan = pns.getDiAtasanId();
                        }
                        String InstansiPns = pns.getInstansiId();
                        String NipPns = pns.getNipBaru();

                        ModelLocatorSKP.nipBaruAtasan = NipPns;
                        ModelLocatorSKP.loginNipPengguna = NipPns;
                        ModelLocatorSKP.IdUnorUser = pns.getUnorId();

                        UnorAts = new GoIndex().getUnorAtasan(unorAtasan);
                        ModelLocatorSKP.nipBaruAtasan = UnorAts.getNipBaru();
                        if (UnorAts == null) {
                            unorskp unorAtasanLagi = new GoIndex().getIdUnorAtasan(unorAtasan);
                            String namaUnorAtasNyaLagi = unorAtasanLagi.getNamaUnor();
                            String IdUnorAtasNyaLagi = unorAtasanLagi.getDiAtasanId();

                            String UnorAtasanAtasan = new GoIndex().getUpdateUnorYangKosong(NipPns, IdUnorAtasNyaLagi);
                            unorAtasan = pns.getDiAtasanId();
                            UnorAts = new GoIndex().getUnorAtasan(unorAtasan);
                            ModelLocatorSKP.nipBaruAtasan = UnorAts.getNipBaru();
                        }

                        List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);
                        request.setAttribute("pns", pns);
                        request.setAttribute("UnorAts", UnorAts);
                        request.setAttribute("tukesiServlet", tukesiServlet);
                        request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);

                    }
                }
                
                
                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/navigasiPenggunadat.jsp");
                dis.forward(request, response);
            }
            
        }
        else if (Submit1 != null)
        {
            if (Submit1.equalsIgnoreCase("SIMPAN"))
            {
                 //jenisJabatan = request.getParameter("jenisJabatan");
                 String jenis = jenisJabatan;
                 String JabId = request.getParameter("JabId");
                 String namaKelompok = request.getParameter("kelJab");
                 String _kodeInstansi = request.getParameter("idInstansiText");
                 String _kodeUnor = request.getParameter("idUnorText");
                 String _kodeTupoksi = request.getParameter("idTupoksiText");
                 String _namaTupoksi = request.getParameter("textarea1");
                 String _angka_krdt = request.getParameter("angkakrdtText");
                                                
                DBConnection dbConn = DBConnection.getInstance();
                String _pesan = new GoIndex().getUpdateInsertTupoksiOperator(jenis,_kodeTupoksi,_namaTupoksi,_kodeUnor,_kodeInstansi,_angka_krdt,JabId, namaKelompok);
                
                tupoksi_lama _getIdInstansiIdUnorDariIdTupoksi = new GoIndex().getallDariIdTupoksi(_kodeTupoksi);
            
                String kodeInstansi = _getIdInstansiIdUnorDariIdTupoksi.getIdInstansi();
                String kodeUnor = _getIdInstansiIdUnorDariIdTupoksi.getIdUnor();
                String namaInstansi = _getIdInstansiIdUnorDariIdTupoksi.getInstansiNama();
                String namaUnor = _getIdInstansiIdUnorDariIdTupoksi.getNamaUnor();
                String namaTupoksi = _getIdInstansiIdUnorDariIdTupoksi.getNamaTupoksi();
                String angka_krdt = _getIdInstansiIdUnorDariIdTupoksi.getangka_krdt();
                
                  String kodeTupoksi = _getIdInstansiIdUnorDariIdTupoksi.getIdTupoksi();

                request.setAttribute("kodeInstansi", kodeInstansi);
                request.setAttribute("kodeUnor", kodeUnor);
                request.setAttribute("namaInstansi", namaInstansi);
                request.setAttribute("namaUnor", namaUnor);
                request.setAttribute("namaTupoksi", namaTupoksi);
                request.setAttribute("kodeTupoksi", kodeTupoksi);
                request.setAttribute("angkakrdt", angka_krdt);
                      if ( jenisJabatan.equals("2")){
               // List<kelompokJabatan> kelJab2 = new GoIndex().getSatuRumpun(JabId);                
               // List<jabfung> jabatanfungfum = new GoIndex().getSatuRumpunFungsional(JabId);
                kelompokJabatan kelJab2 = new GoIndex().getKelompokJabatan(namaKelompok);
                jabfung jabatanfungfum = new GoIndex().getJabatanFungsional(JabId);          
                    
                           request.setAttribute("kelJab", kelJab2);
                           request.setAttribute("JabId", jabatanfungfum);
            } 
            if(jenisJabatan.equals("4")){
                  jabfum jabatanfungfum = new GoIndex().getJabatanUmum(JabId);
                           //request.setAttribute("kelJab", kelJab);
                           request.setAttribute("JabId", jabatanfungfum);
                   
            }     
                request.setAttribute("jabatan", jenis);
                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/ubahInsertTupoksiBaruBiru.jsp");//simpan
                dis.forward(request, response);
            }
            else if (Submit1.equalsIgnoreCase("BATAL"))
            {
                String _kodeTupoksi = request.getParameter("idTupoksiText");
                
                tupoksi_lama _getIdInstansiIdUnorDariIdTupoksi = new GoIndex().getallDariIdTupoksi(_kodeTupoksi);
            
                String kodeInstansi = _getIdInstansiIdUnorDariIdTupoksi.getIdInstansi();
                String kodeUnor = _getIdInstansiIdUnorDariIdTupoksi.getIdUnor();
                String namaInstansi = _getIdInstansiIdUnorDariIdTupoksi.getInstansiNama();
                String namaUnor = _getIdInstansiIdUnorDariIdTupoksi.getNamaUnor();
                String namaTupoksi = _getIdInstansiIdUnorDariIdTupoksi.getNamaTupoksi();
                String kodeTupoksi = _getIdInstansiIdUnorDariIdTupoksi.getIdTupoksi();
                
                String angka_krdt = _getIdInstansiIdUnorDariIdTupoksi.getangka_krdt();

                request.setAttribute("kodeInstansi", kodeInstansi);
                request.setAttribute("kodeUnor", kodeUnor);
                request.setAttribute("namaInstansi", namaInstansi);
                request.setAttribute("namaUnor", namaUnor);
                request.setAttribute("namaTupoksi", namaTupoksi);
                request.setAttribute("kodeTupoksi", kodeTupoksi);
                request.setAttribute("angkakrdt", angka_krdt);
                
                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/ubahInsertTupoksiBaruBiru.jsp");//batal
                dis.forward(request, response);
            }
            else if (Submit1.equalsIgnoreCase("KELUAR"))//tes keluar balik lagi gak value nya ke halaman awal
            {
              String _kodeIdInstansi = request.getParameter("idInstansiText");
                String idUnorTextJ = request.getParameter("idUnorText"); 
                String KodeJabatan = request.getParameter("JabId");
               String kelompokJabatan = request.getParameter("kelJab");
               String kodeUnor ="";
               String kodeInstansi="";
                
             if (jenisJabatan.equals("1")){
                instansiri instansie = new GoIndex().getInstansi(_kodeIdInstansi);
                String namaInstansi = instansie.getNamaInstansi();
                 kodeInstansi = instansie.getIdInstansi();
                request.setAttribute("namaInstansi", namaInstansi);
                request.setAttribute("kodeInstansi", kodeInstansi);
                
                unorskp unorie = new GoIndex().getUnor(idUnorTextJ, _kodeIdInstansi);
                request.setAttribute("unorie", unorie);
                String namaUnor = unorie.getNamaUnor();
                 kodeUnor = unorie.getIdUnor();
                request.setAttribute("namaUnor", namaUnor);
                request.setAttribute("kodeUnor", kodeUnor);
             }
             if (jenisJabatan.equals("2")){
                 
                                             List<jabfung> jabatanfungfum = new GoIndex().getSatuRumpunFungsionalId(kelompokJabatan,KodeJabatan);
                           
                            List<kelompokJabatan> kelJab = new GoIndex().getSatuRumpun(kelompokJabatan);
                           
                           
                           request.setAttribute("kelJab", kelJab);
                           request.setAttribute("jabatanfungfum", jabatanfungfum);

                 
                 
             }
             if(jenisJabatan.equals("4")){
                  //jabfum jabatanfungfum = new GoIndex().getJabatanUmum(KodeJabatan);
                  List<jabfum> jabatanfungfum = new GoIndex().getRumpunUmumById(KodeJabatan);
                  request.setAttribute("jabatanfungfum", jabatanfungfum);
             }
            //    List<tupoksi_lama> Tupoksi = new GoIndex().getIdtupoksiUnor(idUnorTextJ, _kodeIdInstansi);
            //    request.setAttribute("Tupoksi", Tupoksi);
                 List<tupoksi> Tupoksi = new GoIndex().getTupoksiAllJabatan(kodeUnor, kodeInstansi, KodeJabatan, jenisJabatan);  
               request.setAttribute("Tupoksi", Tupoksi);
               request.setAttribute("jabatan", jenisJabatan);
                //RequestDispatcher dis = request.getRequestDispatcher("insertTupoksi.jsp");
                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/insertTupoksiBaruBiru.jsp");
                dis.forward(request, response);
            }
        }
        else
        {}

    }

    private void ambilDataInstansi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        isAllInstansi = request.getParameter("isAllInstansi");
        cariInstansi = request.getParameter("cariInstansi");

        if (isAllInstansi != null && isAllInstansi.equalsIgnoreCase("true") && cariInstansi == null) {
            try {
                DBConnection dbConn = DBConnection.getInstance();
                List<instansiri> instansies = new GoIndex().getAllInstansi();
                request.setAttribute("instansies", instansies);
                //RequestDispatcher dis = request.getRequestDispatcher("TabelInstansi.jsp");
                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/TabelInstansiBaruBiru.jsp");
                dis.forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(referensiInstansiServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


        if (cariInstansi != null && isAllInstansi == null) {
            DBConnection dbConn = DBConnection.getInstance();
            List<instansiri> instansies = new GoIndex().getCariInstansi(cariInstansi);
            request.setAttribute("instansies", instansies);
            //RequestDispatcher dis = request.getRequestDispatcher("TabelInstansi.jsp");
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/TabelInstansiBaruBiru.jsp");
            dis.forward(request, response);
        }


    }
  private void ambilDataUnorForUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //isAllInstansi = request.getParameter("isAllInstansi");
        updateUnor = request.getParameter("updateUnor");
        instansi = request.getParameter("instansi");
        nipbaru = request.getParameter("idnip");
        diatasanUnor = request.getParameter("diatasanId");
        if (updateUnor != null ) {
            DBConnection dbConn = DBConnection.getInstance();
            List<unorskp> unories = new GoIndex().getCariUnorByInstansi(updateUnor, instansi, nipbaru);
            request.setAttribute("unories", unories);
             PnsSkp pns=new GoIndex().getPns(nipbaru);
            request.setAttribute("pns", pns);
            instansiri ins = new GoIndex().getInstansi(instansi);
            request.setAttribute("ins", ins);
            //RequestDispatcher dis = request.getRequestDispatcher("TabelUnor.jsp");
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/updateMenu.jsp");
            dis.forward(request, response);
        }
     }
    private void ambilDataUnor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        isAllInstansi = request.getParameter("isAllInstansi");
                        cariInstansi = request.getParameter("idInstansiText");
        cariUnor = request.getParameter("cariUnor");

        if (cariUnor != null && isAllInstansi == null) {
            DBConnection dbConn = DBConnection.getInstance();
            List<unorskp> unories = new GoIndex().getCariUnor(cariUnor, cariInstansi);
            request.setAttribute("unories", unories);
            request.setAttribute("instansi",cariInstansi );
            //RequestDispatcher dis = request.getRequestDispatcher("TabelUnor.jsp");
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/TabelUnorBaruBiru.jsp");
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
