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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

/**
 *
 * @author Sony
 */
@WebServlet(name = "TugasTambahanServlet", urlPatterns = {"/TugasTambahanServlet"})
public class TugasTambahanServlet extends HttpServlet {

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
            out.println("<title>Servlet TugasTambahanServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TugasTambahanServlet at " + request.getContextPath () + "</h1>");
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
        String idTupoksiUntukHapus = request.getParameter("idTambahanHapus");
        String idTupoksiUntukUpdate = request.getParameter("idTambahanUpdate");
               
        String SidNipe =  request.getParameter("idNip");
        String SidNip =  request.getParameter("idTambahan");
        
        String idNiptambahan = request.getParameter("idNiptambahan");
      
        if (action != null && action.equalsIgnoreCase("HapusTambahan"))
        {
            TugasTambahan tugasTambahan = new GoIndex().getTugasTambahan(idTupoksiUntukHapus);
            String idNip = tugasTambahan.getIdNip();
            request.setAttribute("idNip", idNip);
            
            String _nama = request.getParameter("namaText");
            request.setAttribute("namaPns", _nama);
            
            String _getDeleteTugasTambahan = new GoIndex().getdeleteTambahan(idTupoksiUntukHapus);
            
            List<TugasTambahan> tugasTambahans = new GoIndex().getTugasTambahanList(idNip);
            request.setAttribute("tugasTambahans", tugasTambahans);
            
            List<TugasTambahan> kereaktifitas = new GoIndex().getKreatifitasList(idNip);
            request.setAttribute("kereaktifitas", kereaktifitas);
            
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/TugasTambahan.jsp");
            dis.forward(request, response);
        }
        else if(action != null && action.equalsIgnoreCase("UpdateTambahan"))
        {
            TugasTambahan tugasTambahan = new GoIndex().getTugasTambahan(idTupoksiUntukUpdate);

            String idTambahan = tugasTambahan.getIdTambahan();
            String JenisTambahan = tugasTambahan.getJenisTambahan();
            String nama = tugasTambahan.getNama();
            String TmtPeriode = tugasTambahan.getTmtPeriode();
            String nilai1 = tugasTambahan.getNilai1();
            String nilai2 = tugasTambahan.getNilai2();
            String idNip = tugasTambahan.getIdNip();
            String maks = "0000";

            request.setAttribute("idTambahan", idTambahan);
            request.setAttribute("JenisTambahan",JenisTambahan);

            request.setAttribute("nama", nama);
            request.setAttribute("TmtPeriode",TmtPeriode);

            request.setAttribute("nilai1", nilai1);
            request.setAttribute("nilai2",nilai2);

            request.setAttribute("idNip", idNip);
            
            String _nama = request.getParameter("namaText");
            request.setAttribute("namaPns", _nama);

            List<TugasTambahan> tugasTambahans = new GoIndex().getTugasTambahanList(idNip);
            request.setAttribute("tugasTambahans", tugasTambahans);
            
            List<TugasTambahan> kereaktifitas = new GoIndex().getKreatifitasList(idNip);
            request.setAttribute("kereaktifitas", kereaktifitas);

            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/TugasTambahan.jsp");
            dis.forward(request, response);
        }
        else if (action == null && idNiptambahan != null)
        {
            request.setAttribute("idNiptambahan", idNiptambahan);
            RequestDispatcher dis = request.getRequestDispatcher("/GetPnsServlet?etst=test");
            dis.forward(request, response);   
        }
        else
        {}
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
       String Submit = request.getParameter("Submit");
        
        if(Submit != null)
        {
            if (Submit.equalsIgnoreCase("SIMPAN"))
            {
                String _idTambahan = request.getParameter("idTambahanText");
                String _JenisTambahan = request.getParameter("JenisTambahanText");

                String _namaket = request.getParameter("namaText");
                String _nama = request.getParameter("namaPnsText");
                
                String _TmtPeriode = request.getParameter("TmtPeriodeText");
                 String _koef_kreatifitas = request.getParameter("koef_kreatifitas");

//                String _nilai1 = request.getParameter("nilai1Text");
//                String _nilai2 = request.getParameter("nilai2Text");
//                _nilai2 = _nilai1;
//**************03092012***********************//
                String _nilai1 = "1";
                String _nilai2 = _nilai1;
                
                String _idNip = request.getParameter("idNipText");
                String maks="0";
                
                String _hitungtambahan = "-";
                String _nilaitambahan = "-";
                
                String koef_kreatifitas = "-";

                TugasTambahan tugasTambahan = new GoIndex().getTugasTambahan(_idTambahan);
                
                if(tugasTambahan != null)
                { 
                    //update!
                    String _getUpdateTugasTambahan = new GoIndex().getsimpanTugasTambahan(maks, _idTambahan,_JenisTambahan,_namaket,_TmtPeriode,_nilai1,_nilai2,_idNip,_hitungtambahan,_nilaitambahan);
                    
                    String s_HitungTugasTambahan = new GoIndex().HitungTugasTambahan(_idTambahan, _idNip);
                }
                else
                {
                    //insert!
                    _JenisTambahan = request.getParameter("jenis_tambahan");
                    String tpMaksimum = new GoIndex().getInsertTugasTambahan(maks,_idTambahan,_JenisTambahan,_namaket,_TmtPeriode,_nilai1,_nilai2,_idNip,_hitungtambahan,_nilaitambahan,koef_kreatifitas);
                    _idTambahan = tpMaksimum;
                    String s_HitungTugasTambahan = new GoIndex().HitungTugasTambahan(_idTambahan, _idNip);
                    
                } 
                
                
                
                List<TugasTambahan> tugasTambahans = new GoIndex().getTugasTambahanList(_idNip);
                request.setAttribute("tugasTambahans", tugasTambahans);
                List<TugasTambahan> kereaktifitas = new GoIndex().getKreatifitasList(_idNip);
                request.setAttribute("kereaktifitas", kereaktifitas);
                request.setAttribute("namaPns", _nama);
                request.setAttribute("idNip", _idNip);
                

                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/TugasTambahan.jsp");
                dis.forward(request, response);
           }
           else if (Submit.equalsIgnoreCase("TUGAS TAMBAHAN"))
           {
                String _nama = request.getParameter("namaPnsText");
                String _idNip = request.getParameter("idNipText");
                String maks="0";

                List<TugasTambahan> tugasTambahans = new GoIndex().getTugasTambahanAllList(_idNip);
                request.setAttribute("tugasTambahans", tugasTambahans);  
//                List<TugasTambahan> tugasTambahans = new GoIndex().getTugasTambahanList(_idNip);
//                request.setAttribute("tugasTambahans", tugasTambahans);
//                List<TugasTambahan> kereaktifitas = new GoIndex().getKreatifitasList(_idNip);
//                request.setAttribute("kereaktifitas", kereaktifitas);
                request.setAttribute("namaPns", _nama);
                request.setAttribute("idNip", _idNip);

                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/TugasTambahan.jsp");
                dis.forward(request, response);
           }
           else if (Submit.equalsIgnoreCase("BATAL"))
           {
                String _idTambahan = request.getParameter("idTambahanText");
                String _JenisTambahan = request.getParameter("JenisTambahanText");

                String _namaket = request.getParameter("namaText");
                String _nama = request.getParameter("namaPnsText");
                
                String _TmtPeriode = request.getParameter("TmtPeriodeText");

                String _nilai1 = request.getParameter("nilai1Text");
                String _nilai2 = request.getParameter("nilai2Text");
                String _idNip = request.getParameter("idNipText");
                String maks="0";
          
                List<TugasTambahan> tugasTambahans = new GoIndex().getTugasTambahanList(_idNip);
                request.setAttribute("tugasTambahans", tugasTambahans);
                List<TugasTambahan> kereaktifitas = new GoIndex().getKreatifitasList(_idNip);
                request.setAttribute("kereaktifitas", kereaktifitas);
                request.setAttribute("namaPns", _nama);
                request.setAttribute("idNip", _idNip);

                
               RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/TugasTambahan.jsp");
              //  RequestDispatcher dis = request.getRequestDispatcher("/ReportIsi4FaktorServlet?etst=test");
                dis.forward(request, response);
           }
//           else if (Submit.equalsIgnoreCase("KELUAR"))
//           {
//               //<li><a href="GetPnsServlet?txtNIPBaru=<c:out value="${pns.getNipBaru()}"/>
//               //&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>" 
//               //target="_parent" title="Realisasi Capaian SKI"><span></span>Realisasi</a></li>  
//                String id = request.getParameter("idNipText");   
//
//                pnsskp pns = new GoIndex().getPns(id);
//                if (pns ==null)
//                {   
//                }
//                else
//                {
//                    String unorAtasan = pns.getDiAtasanId();
//                    String UnorPns = pns.getUnorId();
//                    String InstansiPns = pns.getInstansiId();
//                    String NipPns = pns.getNipBaru();
//
//                    pnsskp UnorAts = new GoIndex().getUnorAtasan(unorAtasan);
//
//                    List<Map<String,Object>> listResult = new ArrayList<Map<String,Object>>();
//
//                    List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);
//
//                    List<RealisasiIsi4faktorTupoksi> realkesiServlet = new GoIndex().getRealkesi(id);
//
//                    //StringBuffer Keterangan = new StringBuffer();
//
//                    int nomorHitung=0;
//                    String nomorstr;
//
//                    for (TupoksiKeIsi4Faktor tukesiDomain : tukesiServlet)
//                    {
//                        nomorHitung=nomorHitung+1;
//                        Map<String, Object> test = new HashMap<String, Object>();
//                        String idTupoksi=tukesiDomain.getIdTupoksi();
//                        String idIsi4faktor=tukesiDomain.getIdIsi4Faktor();
//                        realisasi Realisasi= new GoIndex().getIdRealitas(idTupoksi, id, idIsi4faktor);
//                        nomorstr =Integer.toString(nomorHitung);
//                        if (Realisasi != null)
//                        {
//                        test.put("KUALITASR", Realisasi.getKualitasR());
//                        test.put("KUANTITASR",Realisasi.getKuantitasR());
//                        test.put("WAKTUR",Realisasi.getWaktuR());
//                        test.put("BAYARR",Realisasi.getBiayaR());
//
//                        test.put("NOMORTUPOKSI",nomorstr); 
//                        test.put("NAMATUPOKSI",tukesiDomain.getNamaTupoksi()); 
//
//                        test.put("KUANTITAS4",tukesiDomain.getKuantitas4());
//                        test.put("KUALITAS4",tukesiDomain.getKualitas4());
//                        test.put("WAKTU4",tukesiDomain.getWaktu4());
//                        test.put("BIAYA4",tukesiDomain.getBiaya4());
//
//                        listResult.add(test);
//                        }
//                        else
//                        {
//                            test.put("KUALITASR", "-");
//                            test.put("KUANTITASR","-");
//                            test.put("WAKTUR","-");
//                            test.put("BAYARR","-");
//
//                            test.put("NOMORTUPOKSI",nomorstr); 
//                            test.put("NAMATUPOKSI",tukesiDomain.getNamaTupoksi()); 
//                            test.put("KUANTITAS4",tukesiDomain.getKuantitas4());
//                            test.put("KUALITAS4",tukesiDomain.getKualitas4());
//                            test.put("WAKTU4",tukesiDomain.getWaktu4());
//                            test.put("BIAYA4",tukesiDomain.getBiaya4());
//
//
//                        }
//                    }
//
//                    request.setAttribute("pns", pns);
//                    request.setAttribute("UnorAts", UnorAts);
//                    request.setAttribute("listResult",listResult);
//                    //request.setAttribute("tukesiServlet", tukesiServlet);
//                    request.setAttribute("realkesiServlet", realkesiServlet);
//                }
//               
//                RequestDispatcher dis = request.getRequestDispatcher("indexRealisasiBaruBiru.jsp");
//                dis.forward(request, response);
//           }
//           else if (Submit.equalsIgnoreCase("KELUAR"))
//           {
//               request.setAttribute("idNiptambahan", idNiptambahan);
//                RequestDispatcher dis = request.getRequestDispatcher("/GetPnsServlet?etst=test");
//                dis.forward(request, response);               
//           }
           else
           {}
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
