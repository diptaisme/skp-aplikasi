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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javax.servlet.http.HttpSession;

/**
 *
 * @author diptaisme
 */
public class Isi4FaktorServlet extends HttpServlet {

String P_nipbaru;
 String idtupoksidijsp;
        String namaTupoksijsp;
        String  namaAngka_krdtjsp;
        String namaAngka_krdtjspR;
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
            out.println("<title>Servlet Isi4FaktorServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Isi4FaktorServlet at " + request.getContextPath() + "</h1>");
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
        String P_idTupoksi;
        String STupoksiKode = (String) request.getAttribute("STupoksiKode");
        String SnamaTupoksi = (String) request.getAttribute("SnamaTupoksi");
        String Snipbaru = (String) request.getAttribute("Snipbaru");
        String sNama = (String) request.getAttribute("sNama");
         String _pilih_session=request.getParameter("pilih_session");
           String action = request.getParameter("action");
           String nipsendiriR=request.getParameter("nipsendiriR");
            String nipsendiriMonitoring=request.getParameter("nipsendiriMonitoring");
        P_idTupoksi=STupoksiKode;
        P_nipbaru = Snipbaru; 
        String idtupoksidijspreal;
        String namaTupoksijspreal;

////**************************************************BILA MENGGUNAKAN LINK HREF, BUKAN TOMBOL SUBMIT************************//
//        String saveIsi4FaktorServletTupoksi = request.getParameter("saveIsi4FaktorServletTupoksi");
//        String saveIsi4FaktorServletNip = request.getParameter("saveIsi4FaktorServletNip");
//        String i_kuantitas4text=request.getParameter("kuantitas4text");
//        String i_kualitas4text=request.getParameter("kualitas4text");
//        String i_waktu4text=request.getParameter("waktu4text");
//        String i_biaya4text=request.getParameter("biaya4text");
//        
//        
//        
//        String caritupoksiIsi4FaktorServlet = request.getParameter("caritupoksiIsi4FaktorServlet");
//        
//        
//        if (saveIsi4FaktorServletTupoksi != null && saveIsi4FaktorServletNip != null)
//        {      
//            //getSAVEisi4faktor(request, response);
//            String _idTupoksi=saveIsi4FaktorServletTupoksi;
//            String iNip_id=saveIsi4FaktorServletNip;
//
////            TupoksiKeIsi4Faktor tupoksiKeIsi4Faktor = new GoIndex().getTupoksi(_idTupoksi);
////            
////            String _kuantitas4text=tupoksiKeIsi4Faktor.getKuantitas4();
////            String _kualitas4text=tupoksiKeIsi4Faktor.getKualitas4();
////            String _waktu4text=tupoksiKeIsi4Faktor.getWaktu4();
////            String _biaya4text=tupoksiKeIsi4Faktor.getBiaya4();
//            
//            String _kuantitas4text=request.getParameter("kuantitas4text");
//            String _kualitas4text=request.getParameter("kualitas4text");
//            String _waktu4text=request.getParameter("waktu4text");
//            String _biaya4text=request.getParameter("biaya4text");
////             String _kuantitas4text=(String) request.getAttribute("kuantitas4text");
////             String _kualitas4text=(String) request.getAttribute("kualitas4text");
////             String _waktu4text=(String) request.getAttribute("waktu4text");
////             String _biaya4text=(String) request.getAttribute("biaya4text");
//             
//            // isi4faktor Isi4Faktor = new GoIndex().getsimpanIsiEmpatFaktor(_idTupoksi, _kuantitas4text, _kualitas4text, _waktu4text, _biaya4text);
//
//            String _Isi4Faktor = new GoIndex().getsimpanIsiEmpatFaktor(iNip_id,_idTupoksi, _kuantitas4text, _kualitas4text, _waktu4text, _biaya4text);
//
//            String xidTupoksi=request.getParameter("idTupoksi");
//            String nip=request.getParameter("nipnilai");
//
//            PnsSkp pnsp = new GoIndex().getPns(iNip_id);
//            TupoksiKeIsi4Faktor tupoksiKeIsi4Faktor1 = new GoIndex().getTupoksi(_idTupoksi);
//
//            request.setAttribute("pnsp", pnsp);
//            request.setAttribute("tupoksiKeIsi4Faktor", tupoksiKeIsi4Faktor1);
//
//            RequestDispatcher dis=request.getRequestDispatcher("isi4faktor.jsp");
//            PrintWriter out = response.getWriter();
//            dis.include(request, response); 
//            out.println(_Isi4Faktor);
//
//        }
//        else if (caritupoksiIsi4FaktorServlet == "CARITUPOKSI")
//        {
//            getCARITUPOKSIisi4faktor(request, response);
//        }
//        else 
//*********************************************************************************************************************************
        
            
        if(sNama==null || Snipbaru==null)
        {
            String idTupoksi4 = request.getParameter("idTupoksi");
            String nipnilai4 = request.getParameter("nipnilai");
            String _getidUnor4 = request.getParameter("_idUnor");
            
            String idTupoksiR = request.getParameter("idTupoksiR");
            String nipnilaiR = request.getParameter("nipnilaiR");
            String i_dTupoksiHapus = request.getParameter("idTupoksiHapus");
             String i_nipHapus = request.getParameter("nipHapus");
             if  (i_dTupoksiHapus != null  && i_nipHapus != null )
            {
                  PnsSkp pns = new GoIndex().getPns(i_nipHapus);
                  
                           String vi_dTupoksiHapus = i_dTupoksiHapus;
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
                    String _hasilHapus= new GoIndex().getHapusRealita(vi_dTupoksiHapus, NipPns);

                    List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);

                    request.setAttribute("pns", pns);
                    request.setAttribute("UnorAts", UnorAts);
                    request.setAttribute("tukesiServlet", tukesiServlet); 
                }  

                //kirim ke jsp lagi
                //RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
                //RequestDispatcher dis = request.getRequestDispatcher("indexBaru.jsp");
                RequestDispatcher dis = request.getRequestDispatcher("indexBaruBiru2.jsp");
                dis.forward(request, response);
            }else  if (idTupoksi4 != null && nipnilai4 != null)
            {
                P_idTupoksi = idTupoksi4;
                P_nipbaru = nipnilai4;
                
                PnsSkp pnsp = new GoIndex().getPns(nipnilai4);
                TupoksiKeIsi4Faktor tupoksiKeIsi4Faktor = new GoIndex().getTupoksi(idTupoksi4);
                idtupoksidijsp = tupoksiKeIsi4Faktor.getIdTupoksi();
                namaTupoksijsp = tupoksiKeIsi4Faktor.getNamaTupoksi();
                namaAngka_krdtjsp = tupoksiKeIsi4Faktor.getangka_krdt();
                namaAngka_krdtjspR = tupoksiKeIsi4Faktor.getangka_krdtR();

                request.setAttribute("pnsp", pnsp);
                request.setAttribute("idtupoksidijsp", idtupoksidijsp); 
                request.setAttribute("tupoksiKeIsi4Faktor", tupoksiKeIsi4Faktor); 
                request.setAttribute("namaTupoksijsp", namaTupoksijsp); 
                request.setAttribute("namaAngka_krdtjsp", namaAngka_krdtjsp); 
                  request.setAttribute("_getidUnor4jsp", _getidUnor4); 

                //RequestDispatcher dis=request.getRequestDispatcher("isi4faktor.jsp");
                RequestDispatcher dis=request.getRequestDispatcher("isi4faktorBaru.jsp");
                dis.forward(request, response); 
            }
            else if (idTupoksiR != null && nipnilaiR != null && action == null)
            {
                P_idTupoksi = idTupoksiR;
                P_nipbaru = nipnilaiR;
                PnsSkp pnsp = new GoIndex().getPns(nipnilaiR);
                //TupoksiKeIsi4Faktor tupoksiKeIsi4Faktor = new GoIndex().getTupoksi(idTupoksiR);
                //List<RealisasiIsi4faktorTupoksi> realisasiIsi4faktorTupoksi  = new GoIndex().getRealkesi(nipnilaiR);
                RealisasiIsi4faktorTupoksi realisasiIsi4faktorTupoksiId = new GoIndex().getRealkesiid(nipnilaiR, idTupoksiR);
                //idtupoksidijspreal = realisasiIsi4faktorTupoksiId.getIdTupoksi();
                //namaTupoksijspreal = realisasiIsi4faktorTupoksiId.getNamaTupoksi();
                String kuantitas4 = realisasiIsi4faktorTupoksiId.getKuantitas4();
                String kualitas4 = realisasiIsi4faktorTupoksiId.getKualitas4();
                String waktu4 = realisasiIsi4faktorTupoksiId.getWaktu4();
                String biaya4 = realisasiIsi4faktorTupoksiId.getBiaya4();
                String angkaKrdt4 = realisasiIsi4faktorTupoksiId.getangkaKrdt4();
                  String _pilih_session4 = realisasiIsi4faktorTupoksiId.get_pilih_session();
                if (biaya4.equals("-")){
                    biaya4 ="0";
                }
                 if(!"-".equals(kuantitas4) && !"-".equals(kualitas4) && !"-".equals(waktu4) )
               // if(!"-".equals(kuantitas4) && !"-".equals(kualitas4) && !"-".equals(waktu4) && !"0".equals(biaya4))
                {
                    request.setAttribute("pnsp", pnsp);
                    //request.setAttribute("idtupoksidijsp", idtupoksidijspreal); 
                    //request.setAttribute("tupoksiKeIsi4Faktor", tupoksiKeIsi4Faktor); 
                    //request.setAttribute("namaTupoksijsp", namaTupoksijspreal);
                                    
                    request.setAttribute("realisasiIsi4faktorTupoksiId", realisasiIsi4faktorTupoksiId);

                    idtupoksidijsp=realisasiIsi4faktorTupoksiId.getId_tupoksi();
                    namaTupoksijsp=realisasiIsi4faktorTupoksiId.getNama_tupoksi();

                    request.setAttribute("idtupoksidijsp",idtupoksidijsp); 
                    request.setAttribute("namaTupoksijsp", namaTupoksijsp);   
                    request.setAttribute("_pilih_session", _pilih_session4);   

                    //RequestDispatcher dis=request.getRequestDispatcher("realisasi.jsp");
                    RequestDispatcher dis=request.getRequestDispatcher("realisasiBaru2.jsp");
                    dis.forward(request, response); 
                }
                else if("-".equals(kuantitas4) && "-".equals(kualitas4) && "-".equals(waktu4) && "0".equals(biaya4))
                {
                    String id = request.getParameter("nipnilaiR");
                    //String tupo = request.getParameter("idTupoksi");

                    if (id != null && !"".equals(id) && !" ".equals(id))
                    {
                        PnsSkp pns = new GoIndex().getPns(id);
                        if (pns ==null)
                        {   
                        }
                        else
                        {
                            String unorAtasan = pns.getDiAtasanId();
                            String UnorPns = pns.getUnorId();
                            String InstansiPns = pns.getInstansiId();
                            String NipPns = pns.getNipBaru();

                            PnsSkp UnorAts = new GoIndex().getUnorAtasan(unorAtasan);

                            List<Map<String,Object>> listResult = new ArrayList<Map<String,Object>>();

                            List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);

                            List<RealisasiIsi4faktorTupoksi> realkesiServlet = new GoIndex().getRealkesi(id);

                            //StringBuffer Keterangan = new StringBuffer();

                            int nomorHitung=0;
                            String nomorstr;

                            for (TupoksiKeIsi4Faktor tukesiDomain : tukesiServlet)
                            {
                                nomorHitung=nomorHitung+1;
                                Map<String, Object> test = new HashMap<String, Object>();
                                String idTupoksi=tukesiDomain.getIdTupoksi();
                                String idIsi4faktor=tukesiDomain.getIdIsi4Faktor();
                                realisasi Realisasi= new GoIndex().getIdRealitas(idTupoksi, id, idIsi4faktor);
                                nomorstr =Integer.toString(nomorHitung);
                                if (Realisasi != null)
                                {
                                    test.put("KUALITASR", Realisasi.getKualitasR());
                                    test.put("KUANTITASR",Realisasi.getKuantitasR());
                                    test.put("WAKTUR",Realisasi.getWaktuR());
                                    test.put("BAYARR",Realisasi.getBiayaR());

                                    test.put("NOMORTUPOKSI",nomorstr); 
                                    test.put("NAMATUPOKSI",tukesiDomain.getNamaTupoksi()); 

                                    test.put("KUANTITAS4",tukesiDomain.getKuantitas4());
                                    test.put("KUALITAS4",tukesiDomain.getKualitas4());
                                    test.put("WAKTU4",tukesiDomain.getWaktu4());
                                    test.put("BIAYA4",tukesiDomain.getBiaya4());

                                    listResult.add(test);
                                }
                                else
                                {
                                    test.put("KUALITASR", "-");
                                    test.put("KUANTITASR","-");
                                    test.put("WAKTUR","-");
                                    test.put("BAYARR","-");

                                    test.put("NOMORTUPOKSI",nomorstr); 
                                    test.put("NAMATUPOKSI",tukesiDomain.getNamaTupoksi()); 
                                    test.put("KUANTITAS4",tukesiDomain.getKuantitas4());
                                    test.put("KUALITAS4",tukesiDomain.getKualitas4());
                                    test.put("WAKTU4",tukesiDomain.getWaktu4());
                                    test.put("BIAYA4",tukesiDomain.getBiaya4());


                                }
                            }

                            request.setAttribute("pns", pns);
                            request.setAttribute("UnorAts", UnorAts);
                            request.setAttribute("listResult",listResult);
                            //request.setAttribute("tukesiServlet", tukesiServlet);
                            request.setAttribute("realkesiServlet", realkesiServlet);
                        }

                        //RequestDispatcher dis = request.getRequestDispatcher("indexRealisasi.jsp");
                        RequestDispatcher dis = request.getRequestDispatcher("indexRealisasiBaruBiru2.jsp");
                        dis.forward(request, response);
                    }
                    else if (id == null || "".equals(id) || " ".equals(id))
                    {
                        RequestDispatcher dis = request.getRequestDispatcher("indexRealisasiBaruBiru2.jsp");
                        dis.forward(request, response);
                    }
                    else
                    {}
                }
                else
                {}
            }
            else
            if("Monitor".equals(action)){
              nipsendiriR=request.getParameter("nipsendiriR");
             nipsendiriMonitoring=request.getParameter("nipsendiriMonitoring");
                P_idTupoksi = idTupoksiR;
                P_nipbaru = nipnilaiR;
                String nipAtasanMonitoring = request.getParameter("NipAtasan"); 
                PnsSkp pnsp = new GoIndex().getPns(nipnilaiR);
                
                RealisasiIsi4faktorTupoksi realisasiIsi4faktorTupoksiId = new GoIndex().getRealkesiid(nipsendiriMonitoring, idTupoksiR);
             
                String kuantitas4 = realisasiIsi4faktorTupoksiId.getKuantitas4();
                String kualitas4 = realisasiIsi4faktorTupoksiId.getKualitas4();
                String waktu4 = realisasiIsi4faktorTupoksiId.getWaktu4();
                String biaya4 = realisasiIsi4faktorTupoksiId.getBiaya4();
                String angkaKrdt4 = realisasiIsi4faktorTupoksiId.getangkaKrdt4();
                if (biaya4==null) {
                     biaya4 ="0";
                } 
                if (biaya4.equals("-")) {
                    biaya4 ="0";
                }
                 if(!"-".equals(kuantitas4) && !"-".equals(kualitas4) && !"-".equals(waktu4) )
             
                {
                    request.setAttribute("pnsp", pnsp);
                    request.setAttribute("realisasiIsi4faktorTupoksiId", realisasiIsi4faktorTupoksiId);

                    idtupoksidijsp=realisasiIsi4faktorTupoksiId.getId_tupoksi();
                    namaTupoksijsp=realisasiIsi4faktorTupoksiId.getNama_tupoksi();

                    request.setAttribute("idtupoksidijsp",idtupoksidijsp); 
                    request.setAttribute("namaTupoksijsp", namaTupoksijsp); 
                    P_idTupoksi = idTupoksiR;
                    P_nipbaru = nipnilaiR;
                    
                    String idNipTambahan = nipAtasanMonitoring;
                    PnsSkp pns2 = new GoIndex().getPns(idNipTambahan);
                    String iUnorTambahan = pns2.getUnorId();
            List<RealisasiIsi4faktorTupoksi> realkesiServlet = new GoIndex().getRealkesi(nipsendiriR);
                  request.setAttribute("realkesiServlet", realkesiServlet);
            //List<pnsskp_strukturalbkn> pnsList = new GoIndex().getTugasTambahanBawahanList(iUnorTambahan);
            List<PnsSkp> pnsList = new GoIndex().getTugasTambahanBawahanList2(iUnorTambahan);
            request.setAttribute("pnsList", pnsList);
            request.setAttribute("pns", pns2);
            
            request.setAttribute("nipAtasan", idNipTambahan);
            request.setAttribute("nipdimonitoring", P_nipbaru);
             request.setAttribute("nipsendiri",nipsendiriMonitoring);           
            RequestDispatcher dis = request.getRequestDispatcher("monitoring.jsp");
            dis.forward(request, response);
            
            
                 }
            }
        }
        else
        {
            PnsSkp pnsp = new GoIndex().getPns(P_nipbaru );
            TupoksiKeIsi4Faktor tupoksiKeIsi4Faktor = new GoIndex().getTupoksi(P_idTupoksi);
             
            if(tupoksiKeIsi4Faktor==null)
            {
                tupoksi_lama Tupoksi = new GoIndex().getIdtupoksi(P_idTupoksi);
                idtupoksidijsp=Tupoksi.getIdTupoksi();
                namaTupoksijsp=Tupoksi.getNamaTupoksi();
                request.setAttribute("idtupoksidijsp",idtupoksidijsp); 
                request.setAttribute("namaTupoksijsp", namaTupoksijsp);     
            }
            else
            {
                idtupoksidijsp=tupoksiKeIsi4Faktor.getIdTupoksi();
                namaTupoksijsp=tupoksiKeIsi4Faktor.getNamaTupoksi();
                request.setAttribute("idtupoksidijsp", idtupoksidijsp); 
                request.setAttribute("namaTupoksijsp", namaTupoksijsp); 
            }       
                request.setAttribute("pnsp", pnsp);
                request.setAttribute("tupoksiKeIsi4Faktor", tupoksiKeIsi4Faktor); 
                //  request.setAttribute("idtupoksidijsp", idtupoksidijsp); 

                //RequestDispatcher dis=request.getRequestDispatcher("isi4faktor.jsp");
                RequestDispatcher dis=request.getRequestDispatcher("isi4faktorBaru.jsp");
                dis.forward(request, response); 
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
            String P_idTupoksi;
            HttpSession session = request.getSession();
            String param = request.getParameter("param");
            String paramRealisasi = request.getParameter("paramRealisasi");
            String userSession=(String) session.getAttribute("user");
            P_idTupoksi=request.getParameter("idtupoksidiSesiion");
            String NipPnsSession=(String) session.getAttribute("NipPnsSession");
            String _pilih_session=request.getParameter("pilih_session");
            
            if (param != null)
            {
               P_idTupoksi=request.getParameter("idtupoksidiSesiion");
                //if(param.equalsIgnoreCase("SAVE"))
                if(param.equalsIgnoreCase("SIMPAN"))
                {
                    String _idTupoksi=P_idTupoksi;
                    String _kuantitas4text=request.getParameter("kuantitas4text");
                    String _kualitas4text=request.getParameter("kualitas4text");
                    String _waktu4text=request.getParameter("waktu4text");
                    String _biaya4text=request.getParameter("biaya4text");
                    String _angkaKredit=request.getParameter("akt");
                      String __getidUnor4jspSesiion=request.getParameter("_getidUnor4jspSesiion");
                     
                    String iNip_id=NipPnsSession;
                    
                    String pilih = request.getParameter("pilih_output");
                    String waktuL = "bln";
                    
                    if (!"-".equals(pilih))
                    {
                        // isi4faktor Isi4Faktor = new GoIndex().getsimpanIsiEmpatFaktor(_idTupoksi, _kuantitas4text, _kualitas4text, _waktu4text, _biaya4text);

                      //  String _Isi4Faktor = new GoIndex().getsimpanIsiEmpatFaktor(iNip_id,_idTupoksi, _kuantitas4text, _kualitas4text, _waktu4text, _biaya4text, pilih, waktuL,_angkaKredit);

                        String _Isi4Faktor = new GoIndex().getsimpanIsiEmpatFaktor(iNip_id,_idTupoksi, _kuantitas4text, _kualitas4text, _waktu4text, _biaya4text, pilih, waktuL,_angkaKredit,_pilih_session,__getidUnor4jspSesiion);
                        String xidTupoksi=request.getParameter("idTupoksi");
                        String nip=request.getParameter("nipnilai");

                        PnsSkp pnsp = new GoIndex().getPns(iNip_id);
                        TupoksiKeIsi4Faktor tupoksiKeIsi4Faktor = new GoIndex().getTupoksi(_idTupoksi);

                        request.setAttribute("pnsp", pnsp);
                        request.setAttribute("tupoksiKeIsi4Faktor", tupoksiKeIsi4Faktor);

                        if(tupoksiKeIsi4Faktor!=null)
                        {
                            tupoksi_lama Tupoksi = new GoIndex().getIdtupoksi(P_idTupoksi);
                            idtupoksidijsp=Tupoksi.getIdTupoksi();
                            namaTupoksijsp=Tupoksi.getNamaTupoksi();
                            namaAngka_krdtjspR = Tupoksi.getangka_krdt();
                            request.setAttribute("idtupoksidijsp",idtupoksidijsp); 
                            request.setAttribute("namaTupoksijsp", namaTupoksijsp);   
                            request.setAttribute("namaAngka_krdtjsp", namaAngka_krdtjspR);
                        }
 request.setAttribute("alerting", _Isi4Faktor);
                        //RequestDispatcher dis=request.getRequestDispatcher("isi4faktor.jsp");
                        RequestDispatcher dis=request.getRequestDispatcher("isi4faktorBaru.jsp");
                        //PrintWriter out = response.getWriter();
                        dis.include(request, response); 
                        //out.println(_Isi4Faktor);
                        
                    }
                    else
                    {
                        String xidTupoksi=request.getParameter("idTupoksi");
                        String nip=request.getParameter("nipnilai");

                        PnsSkp pnsp = new GoIndex().getPns(iNip_id);
                        TupoksiKeIsi4Faktor tupoksiKeIsi4Faktor = new GoIndex().getTupoksi(_idTupoksi);

                        request.setAttribute("pnsp", pnsp);
                        request.setAttribute("tupoksiKeIsi4Faktor", tupoksiKeIsi4Faktor);

                        if(tupoksiKeIsi4Faktor!=null)
                        {
                            tupoksi_lama Tupoksi = new GoIndex().getIdtupoksi(P_idTupoksi);
                            idtupoksidijsp=Tupoksi.getIdTupoksi();
                            namaTupoksijsp=Tupoksi.getNamaTupoksi();
                            namaAngka_krdtjspR = Tupoksi.getangka_krdt();
                            request.setAttribute("idtupoksidijsp",idtupoksidijsp); 
                            request.setAttribute("namaTupoksijsp", namaTupoksijsp);    
                            request.setAttribute("namaAngka_krdtjsp", namaAngka_krdtjspR);
                        }

                        //RequestDispatcher dis=request.getRequestDispatcher("isi4faktor.jsp");
                        RequestDispatcher dis=request.getRequestDispatcher("isi4faktorBaru.jsp");
                        PrintWriter out = response.getWriter();
                        dis.include(request, response);
                        out.println("Pilih Jenis Kuantitas");        
                    }
                    
                }
                else if (param.equalsIgnoreCase("BATAL"))
                {
                    String _idTupoksi=P_idTupoksi;
                    String _kuantitas4text=request.getParameter("kuantitas4text");
                    String _kualitas4text=request.getParameter("kualitas4text");
                    String _waktu4text=request.getParameter("waktu4text");
                    String _biaya4text=request.getParameter("biaya4text");
                    String _angkaKredit=request.getParameter("akt");
                     
                    String iNip_id=NipPnsSession;
                    
                    String pilih = request.getParameter("pilih_output");
                    String waktuL = "bln";
                    
                        String xidTupoksi=request.getParameter("idTupoksi");
                        String nip=request.getParameter("nipnilai");

                        PnsSkp pnsp = new GoIndex().getPns(iNip_id);
                        TupoksiKeIsi4Faktor tupoksiKeIsi4Faktor = new GoIndex().getTupoksi(_idTupoksi);

                        request.setAttribute("pnsp", pnsp);
                        request.setAttribute("tupoksiKeIsi4Faktor", tupoksiKeIsi4Faktor);

                        if(tupoksiKeIsi4Faktor!=null)
                        {
                            tupoksi_lama Tupoksi = new GoIndex().getIdtupoksi(P_idTupoksi);
                            idtupoksidijsp=Tupoksi.getIdTupoksi();
                            namaTupoksijsp=Tupoksi.getNamaTupoksi();
                            namaAngka_krdtjspR = Tupoksi.getangka_krdt();
                            request.setAttribute("idtupoksidijsp",idtupoksidijsp); 
                            request.setAttribute("namaTupoksijsp", namaTupoksijsp);   
                            request.setAttribute("namaAngka_krdtjsp", namaAngka_krdtjspR);
                        }

                        //RequestDispatcher dis=request.getRequestDispatcher("isi4faktor.jsp");
                        RequestDispatcher dis=request.getRequestDispatcher("isi4faktorBaru.jsp");
                        PrintWriter out = response.getWriter();
                        dis.include(request, response); 
                     
                

                }
                else if(param.equalsIgnoreCase("CARI TUPOKSI"))
                {

                    String _idNipBaruText = request.getParameter("idNipBaruText");
                    PnsSkp pns=new GoIndex().getPns(_idNipBaruText);
                    String unorAtasan = pns.getDiAtasanId();
                    String UnorPns = pns.getUnorId();
                    String InstansiPns = pns.getInstansiId();
                    String NipPns = pns.getNipBaru();
                    List<tupoksi_lama> tupoksiobjek = new GoIndex().getIdtupoksiUnor(UnorPns, InstansiPns);

                    request.setAttribute("pns", pns);
                    request.setAttribute("tupoksiobjek", tupoksiobjek);    

                    RequestDispatcher dis=request.getRequestDispatcher("tabeltupoksi.jsp");
                    dis.forward(request, response); 
                    // PnsSkp UnorAts=new GoIndex().getUnorAtasan(unorAtasan);      
                }
                else
                {}
            }
            else if (paramRealisasi != null)
            {
                //if(paramRealisasi.equalsIgnoreCase("SAVE"))
               NipPnsSession=(String) session.getAttribute("NipPnsSession");
               _pilih_session=request.getParameter("_pilih_session");
                if(paramRealisasi.equalsIgnoreCase("SIMPAN"))    
                {
                    //String _idTupoksi = request.getParameter("idTupoksiR");
                    //String iNip_id = request.getParameter("nipnilaiR");
                    String _idTupoksi = P_idTupoksi;
                    String iNip_id = NipPnsSession;
                    tupoksi_lama tupoksiv=new GoIndex().getIdtupoksi(_idTupoksi);
                     
                     int t_ikuantitas4=0;
                     String _kuantitas4text=request.getParameter("kuantitas4text");
                     String _kuantitasRtext=request.getParameter("kuantitasRtext");
                     
                       if (!"-".equals(_kuantitasRtext) || !" ".equals(_kuantitasRtext) || !"".equals(_kuantitasRtext)|| _kuantitasRtext != null ){
                             t_ikuantitas4=Integer.parseInt(_kuantitasRtext);
                       }else{
                            t_ikuantitas4=0;
                       }
                           
                     String _angkakrdt4t= tupoksiv.getangka_krdt();
                     
                      if (tupoksiv.getangka_krdt() == null){
                           _angkakrdt4t="0";
                      }
         if (!"-".equals(_angkakrdt4t) || !" ".equals(_angkakrdt4t) || !"".equals(_angkakrdt4t)|| _angkakrdt4t != null ){
                   
                     
                      if (_angkakrdt4t.equals("0")|| _angkakrdt4t.equals("")){
                           _angkakrdt4t="";
                      }else{
                            //double nR = java.lang.Double.parseDouble(_angkakrdt4t);
                               float nR = Float.parseFloat(_angkakrdt4t);
                 //   String counter = java.lang.Integer.toString(i); 
                     nR=nR * t_ikuantitas4;
                     DecimalFormat formatterR = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
                     formatterR.setMaximumFractionDigits(4);
                     String nilaibiR = formatterR.format(nR);
                     _angkakrdt4t = nilaibiR.toString();
                     
                      }       
         }
                 
                    String _kualitas4text=request.getParameter("kualitas4text");
                    String _waktu4text=request.getParameter("waktu4text");
                    String _biaya4text=request.getParameter("biaya4text");
                    
                    _kuantitasRtext=request.getParameter("kuantitasRtext");
                    String _kualitasRtext=request.getParameter("kualitasRtext");
                    String _waktuRtext=request.getParameter("waktuRtext");
                    String _biayaRtext=request.getParameter("biayaRtext");
                  //  String _akRtext=request.getParameter("akRtext");
                    
                  //  String _realisasi = new GoIndex().getsimpanRealisasi(iNip_id,_idTupoksi, _kuantitasRtext, _kualitasRtext, _waktuRtext, _biayaRtext,_angkakrdt4t);
                    
                     String _realisasi = new GoIndex().getsimpanRealisasi(iNip_id,_idTupoksi, _kuantitasRtext, _kualitasRtext, _waktuRtext, _biayaRtext,_angkakrdt4t,_pilih_session);

                    String xidTupoksi=request.getParameter("idTupoksi");
                    String nip=request.getParameter("nipnilai");

                    PnsSkp pnsp = new GoIndex().getPns(iNip_id);
                    RealisasiIsi4faktorTupoksi realisasiIsi4faktorTupoksi = new GoIndex().getRealkesiid(iNip_id,_idTupoksi);
                    
                    if ("-".equals(_kuantitas4text) || "-".equals(_kualitas4text) || "-".equals(_waktu4text) || "-".equals(_biaya4text) || "-".equals(_kuantitasRtext) || "-".equals(_kualitasRtext) || "-".equals(_waktuRtext) || "-".equals(_biayaRtext))
                    {
                        request.setAttribute("pnsp", pnsp);
                      
                         idtupoksidijsp=realisasiIsi4faktorTupoksi.getId_tupoksi();
                         namaTupoksijsp=realisasiIsi4faktorTupoksi.getNama_tupoksi();
                         
                         request.setAttribute("idtupoksidijsp",idtupoksidijsp); 
                         request.setAttribute("namaTupoksijsp", namaTupoksijsp);     
                        // request.setAttribute("realisasiIsi4faktorTupoksi", realisasiIsi4faktorTupoksi);
                         request.setAttribute("realisasiIsi4faktorTupoksiId", realisasiIsi4faktorTupoksi);
                        

                        //RequestDispatcher dis=request.getRequestDispatcher("realisasi.jsp");
                        RequestDispatcher dis=request.getRequestDispatcher("realisasiBaru2.jsp");
                        PrintWriter out = response.getWriter();
                        dis.include(request, response); 
                        out.println(_realisasi);
                    }
                    else
                    {
                        RealisasiIsi4faktorTupoksi hitungannya = new GoIndex().getFormatPenghitunganIsi4FaktorBusiness(_idTupoksi, iNip_id);
                        String penghitungan = hitungannya.getPenghitungan();
                        String nilaicapaian = hitungannya.getNilai_capaian_skp();
                        
                        String _hitungan = new GoIndex().getsimpanHitungRealisasi(iNip_id,_idTupoksi, penghitungan, nilaicapaian);
                        
                        request.setAttribute("pnsp", pnsp);
                        
                          idtupoksidijsp=realisasiIsi4faktorTupoksi.getId_tupoksi();
                         namaTupoksijsp=realisasiIsi4faktorTupoksi.getNama_tupoksi();
                         
                         request.setAttribute("idtupoksidijsp",idtupoksidijsp); 
                         request.setAttribute("namaTupoksijsp", namaTupoksijsp);     
                        // request.setAttribute("realisasiIsi4faktorTupoksi", realisasiIsi4faktorTupoksi);
                          request.setAttribute("realisasiIsi4faktorTupoksiId", realisasiIsi4faktorTupoksi);
                       
                        //RequestDispatcher dis=request.getRequestDispatcher("realisasi.jsp");
                        RequestDispatcher dis=request.getRequestDispatcher("realisasiBaru2.jsp");
                        PrintWriter out = response.getWriter();
                        dis.include(request, response); 
                        out.println(_hitungan);
                    }
                }
                else if (paramRealisasi.equalsIgnoreCase("BATAL"))
                {
                        String idTupoksiR = P_idTupoksi;
                        String nipnilaiR = NipPnsSession;
                        
                        PnsSkp pnsp = new GoIndex().getPns(nipnilaiR);
                        
                        RealisasiIsi4faktorTupoksi realisasiIsi4faktorTupoksiId = new GoIndex().getRealkesiid(nipnilaiR, idTupoksiR);

                        request.setAttribute("pnsp", pnsp);
                        
                        request.setAttribute("realisasiIsi4faktorTupoksiId", realisasiIsi4faktorTupoksiId);

                                idtupoksidijsp=realisasiIsi4faktorTupoksiId.getId_tupoksi();
                                namaTupoksijsp=realisasiIsi4faktorTupoksiId.getNama_tupoksi();

                                request.setAttribute("idtupoksidijsp",idtupoksidijsp); 
                                request.setAttribute("namaTupoksijsp", namaTupoksijsp);   

                        RequestDispatcher dis=request.getRequestDispatcher("realisasiBaru2.jsp");
                        dis.forward(request, response); 
                }
                else if(paramRealisasi.equalsIgnoreCase("CARI TUPOKSI"))
                {}
                else
                {}
            }
            else
            {}
            
    }
    
    
    private void getSAVEisi4faktor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
            //String idtupoksidijsp = (String) request.getAttribute("idtupoksidijsp");
            //String idTupoksi4 = request.getParameter("idTupoksi");
            //String _idTupoksi=idTupoksi4;
            //String _idTupoksi=P_idTupoksi;
            HttpSession session = request.getSession();
            String _kuantitas4text=request.getParameter("kuantitas4text");
            String _kualitas4text=request.getParameter("kualitas4text");
            String _waktu4text=request.getParameter("waktu4text");
            String _biaya4text=request.getParameter("biaya4text");
            String pilih = request.getParameter("pilih_output");
             String _angkaKredit = request.getParameter("akt");
             String NipPnsSession=(String) session.getAttribute("NipPnsSession");
               String _pilih_session=request.getParameter("pilih_session");
                 String __getidUnor4jspSesiion=request.getParameter("_getidUnor4jspSesiion");
             String P_idTupoksi=NipPnsSession;
            String waktuL = "-";
            //String iNip_id=P_nipbaru;
            // isi4faktor Isi4Faktor = new GoIndex().getsimpanIsiEmpatFaktor(_idTupoksi, _kuantitas4text, _kualitas4text, _waktu4text, _biaya4text);

            //String _Isi4Faktor = new GoIndex().getsimpanIsiEmpatFaktor(iNip_id,_idTupoksi, _kuantitas4text, _kualitas4text, _waktu4text, _biaya4text);
           // String _Isi4Faktor = new GoIndex().getsimpanIsiEmpatFaktor(P_nipbaru,P_idTupoksi, _kuantitas4text, _kualitas4text, _waktu4text, _biaya4text, pilih, waktuL,_angkaKredit);
             String _Isi4Faktor = new GoIndex().getsimpanIsiEmpatFaktor(P_nipbaru,P_idTupoksi, _kuantitas4text, _kualitas4text, _waktu4text, _biaya4text, pilih, waktuL,_angkaKredit, _pilih_session,__getidUnor4jspSesiion);
            String xidTupoksi=request.getParameter("idTupoksi");
            String nip=request.getParameter("nipnilai");

            PnsSkp pnsp = new GoIndex().getPns(P_nipbaru);
            //pnsskp pnsp = new GoIndex().getPns(iNip_id);
            //TupoksiKeIsi4Faktor tupoksiKeIsi4Faktor = new GoIndex().getTupoksi(_idTupoksi);
            TupoksiKeIsi4Faktor tupoksiKeIsi4Faktor = new GoIndex().getTupoksi(P_idTupoksi);

            request.setAttribute("pnsp", pnsp);
            request.setAttribute("tupoksiKeIsi4Faktor", tupoksiKeIsi4Faktor);

            //RequestDispatcher dis=request.getRequestDispatcher("isi4faktor.jsp");
            RequestDispatcher dis=request.getRequestDispatcher("isi4faktorBaru.jsp");
            PrintWriter out = response.getWriter();
            dis.include(request, response); 
            out.println(_Isi4Faktor);
    }
    
    
    private void getCARITUPOKSIisi4faktor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String _idNipBaruText = request.getParameter("idNipBaruText");
        PnsSkp pns=new GoIndex().getPns(_idNipBaruText);
        String unorAtasan = pns.getDiAtasanId();
        String UnorPns = pns.getUnorId();
        String InstansiPns = pns.getInstansiId();
        String NipPns = pns.getNipBaru();
        List<tupoksi_lama> tupoksiobjek = new GoIndex().getIdtupoksiUnor(UnorPns, InstansiPns);

        request.setAttribute("pns", pns);
        request.setAttribute("tupoksiobjek", tupoksiobjek);    

        RequestDispatcher dis=request.getRequestDispatcher("tabeltupoksi.jsp");
        dis.forward(request, response); 
        // PnsSkp UnorAts=new GoIndex().getUnorAtasan(unorAtasan);      
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
