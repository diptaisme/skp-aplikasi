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
import javax.servlet.http.HttpSession;
import model.*;

/**
 *
 * @author diptaisme
 */
public class GetPnsServlet extends HttpServlet {

    String idp;
    String cetak = null;

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
//        HttpSession session = request.getSession();
//
//        cetak = "t";
//        session.setAttribute("CeTaK", cetak);
//
//
//
//        String id = request.getParameter("txtNIPBaru");
//
//        PnsSkp CetakPns = new GoIndex().getPns(id);
//
//
//        //***************CETAK PNS
//        String namaPNScetak = request.getParameter(CetakPns.getNamaPns());
//        String nipPNScetak = request.getParameter(CetakPns.getNipBaru());
//        String golruPNScetak = request.getParameter(CetakPns.getNamaGolru());
//        String jabatanPNScetak = request.getParameter(CetakPns.getNamaJabatan());
//        String unkerPNScetak = request.getParameter(CetakPns.getNamaUnor());
//
//        String unorAtasan = request.getParameter(CetakPns.getDiAtasanId());
//        String UnorPnsid = request.getParameter(CetakPns.getUnorId());
//        String InstansiPns = request.getParameter(CetakPns.getInstansiId());
//        String NipPns = request.getParameter(CetakPns.getNipBaru());
//
//
//
//        String typeReport = "report_isi4faktor";
//        request.setAttribute("report_isi4faktor", typeReport);
//
//
//        request.setAttribute("namaPNScetak", namaPNScetak);
//        request.setAttribute("nipPNScetak", nipPNScetak);
//        request.setAttribute("golruPNScetak", golruPNScetak);
//        request.setAttribute("jabatanPNScetak", jabatanPNScetak);
//        request.setAttribute("unkerPNScetak", unkerPNScetak);
//
//        request.setAttribute("unorAtasan", unorAtasan);
//        request.setAttribute("UnorPnsid", UnorPnsid);
//        request.setAttribute("InstansiPns", InstansiPns);
//        request.setAttribute("NipPns", NipPns);
//
//
//
//        RequestDispatcher dis = request.getRequestDispatcher("ReportIsi4FaktorServlet");
//        dis.forward(request, response);
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

        //String niprealisasi = request.getParameter("niprealisasi");
        String id = request.getParameter("txtNIPBaru"); //mendapatkan NIP, saat di index klik REALISASI menuju ke indexRealisasi
        String idB = request.getParameter("txtNIPBaruB"); //mendapatkan NIP pada KEMBALI isi4faktor
        String idR = request.getParameter("txtNIPBaruReal"); //mendapatkan NIP pada KEMBALI realisasi
        String idRisi = request.getParameter("txtNIPBaruReal"); //mendapatkan NIP pada KEMBALI realisasi

        String idP = request.getParameter("txtNIPBaruPerilaku");
        String _pilih_session = request.getParameter("pilih_session");
        //String periode = request.getParameter("Periode");

        String idNiptambahan = (String) request.getAttribute("idNiptambahan");
        if (_pilih_session == null) {
            _pilih_session = "-";
        }
        //  if(niprealisasi == null)
        // {
        if (idRisi == null) {
            if (id == null) {
                if (idB == null) {
                    if (idNiptambahan != null) {
                        getRealisasi2(request, response);

                        if (idP != null) {
                            PnsSkp pns = new GoIndex().getPns(idP);

                            String nip = pns.getNipBaru();
                            String nama = pns.getNamaPns();

                            request.setAttribute("nip", nip);
                            request.setAttribute("nama", nama);

                            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/indexPerilaku.jsp");
                            dis.forward(request, response);
                        }
                    } else {
                        getTusiDariIsiTupoksi(request, response);
                    }
                } else {
                    if (idR == null) {
                        //untuk button KEMBALI di isi4faktor.jsp
                        //jika idB ada isinya (nip pns ybs)
                        PnsSkp pns = new GoIndex().getPns(idB);

                        if (pns == null) {
                        } else {
                            String unorAtasan = pns.getDiAtasanId();
                            String UnorPns = pns.getUnorId();
                            String InstansiPns = pns.getInstansiId();
                            String NipPns = pns.getNipBaru();

                            PnsSkp UnorAts = null;
                            if (ModelLocatorSKP.nipBaruAtasan == null || ModelLocatorSKP.nipBaruAtasan.equals("") || ModelLocatorSKP.nipBaruAtasan.equals(" ")) {
                                UnorAts = new GoIndex().getUnorAtasan(unorAtasan);
                            } else {
                                UnorAts = new GoIndex().getPns(ModelLocatorSKP.nipBaruAtasan);
                            }


                            //   PnsSkp UnorAts = new GoIndex().getUnorAtasan(unorAtasan);



                            List<TupoksiKeIsi4Faktor> tukesiServlet = null;
                            if (_pilih_session.equals("-")) {
                                tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);
                            } else {
                                tukesiServlet = new GoIndex().getTukesiSession(UnorPns, InstansiPns, NipPns, _pilih_session);
                            }


                            // List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);

                            request.setAttribute("pns", pns);
                            request.setAttribute("UnorAts", UnorAts);
                            request.setAttribute("tukesiServlet", tukesiServlet);

                        }
                         ModelLocatorSKP.navigasiPil = "3";
                         request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);
                             request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
            //====================

            //  dis = request.getRequestDispatcher("/WEB-INF/jsp/indexBaruBiru2.jsp");
            //  dis.forward(request, response);

           RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/navigasiPenggunadat.jsp");
            dis.forward(request, response);

                        //kirim ke jsp lagi
                        //RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
                        //RequestDispatcher dis = request.getRequestDispatcher("indexBaru.jsp");
                       // RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/indexBaruBiru2.jsp");
                      //  dis.forward(request, response);
                    } else {
                        PnsSkp pns = new GoIndex().getPns(idR);
                        if (pns == null) {
                        } else {
                            String unorAtasan = pns.getDiAtasanId();
                            String UnorPns = pns.getUnorId();
                            String InstansiPns = pns.getInstansiId();
                            String NipPns = pns.getNipBaru();

                            PnsSkp UnorAts = new GoIndex().getUnorAtasan(unorAtasan);

                            List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();

                            List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);

                            List<RealisasiIsi4faktorTupoksi> realkesiServlet = new GoIndex().getRealkesi(id);

                            //StringBuffer Keterangan = new StringBuffer();

                            int nomorHitung = 0;
                            String nomorstr;

                            for (TupoksiKeIsi4Faktor tukesiDomain : tukesiServlet) {
                                nomorHitung = nomorHitung + 1;
                                Map<String, Object> test = new HashMap<String, Object>();
                                String idTupoksi = tukesiDomain.getIdTupoksi();
                                String idIsi4faktor = tukesiDomain.getIdIsi4Faktor();
                                realisasi Realisasi = new GoIndex().getIdRealitas(idTupoksi, idp, idIsi4faktor);
                                nomorstr = Integer.toString(nomorHitung);
                                if (Realisasi != null) {
                                    test.put("KUALITASR", Realisasi.getKualitasR());
                                    test.put("KUANTITASR", Realisasi.getKuantitasR());
                                    test.put("WAKTUR", Realisasi.getWaktuR());
                                    test.put("BAYARR", Realisasi.getBiayaR());

                                    test.put("NOMORTUPOKSI", nomorstr);
                                    test.put("NAMATUPOKSI", tukesiDomain.getNamaTupoksi());

                                    test.put("KUANTITAS4", tukesiDomain.getKuantitas4());
                                    test.put("KUALITAS4", tukesiDomain.getKualitas4());
                                    test.put("WAKTU4", tukesiDomain.getWaktu4());
                                    test.put("BIAYA4", tukesiDomain.getBiaya4());

                                    listResult.add(test);
                                } else {
                                    test.put("KUALITASR", "-");
                                    test.put("KUANTITASR", "-");
                                    test.put("WAKTUR", "-");
                                    test.put("BAYARR", "-");

                                    test.put("NOMORTUPOKSI", nomorstr);
                                    test.put("NAMATUPOKSI", tukesiDomain.getNamaTupoksi());
                                    test.put("KUANTITAS4", tukesiDomain.getKuantitas4());
                                    test.put("KUALITAS4", tukesiDomain.getKualitas4());
                                    test.put("WAKTU4", tukesiDomain.getWaktu4());
                                    test.put("BIAYA4", tukesiDomain.getBiaya4());


                                }
                            }

                            request.setAttribute("pns", pns);
                            request.setAttribute("UnorAts", UnorAts);
                            request.setAttribute("listResult", listResult);
                            //request.setAttribute("tukesiServlet", tukesiServlet);
                            request.setAttribute("realkesiServlet", realkesiServlet);
                        }

                        getTugasTambahan(request, response);

                        //RequestDispatcher dis = request.getRequestDispatcher("indexRealisasi.jsp");
                        RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/indexRealisasiBaruBiru2.jsp");
                        dis.forward(request, response);
                    }
                }
            } else {
                //di index.jsp mengklik link REALISASI dan menuju ke indexRealisasi.jsp dan otomatis terisi
                //sesuai dengan nip ybs 
                getRealisasi2(request, response);
                getTugasTambahan(request, response);
            }
        } else {
            getKembaliRealisasi(request, response);
        }
        // }
        // else
        // {
        //getRealisasi(request, response);
        //}


//*********************ISIAN KETIGA***************************
//         String id=request.getParameter("txtNIPBaru");
//        idp = id;
//        PnsSkp pns=new GoIndex().getPns(id);
//        
//       // String unorAtasan = pns.getDiAtasanId();
//   
//        String UnorPns = pns.getUnorId();
//        String InstansiPns = pns.getInstansiId();
//        String NipPns = pns.getNipBaru();
//
//       // PnsSkp UnorAts=new GoIndex().getUnorAtasan(unorAtasan);
//        
//        List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);
//        
//        request.setAttribute("pns", pns);
//     //   request.setAttribute("UnorAts", UnorAts);    
//        
//        request.setAttribute("tukesiServlet", tukesiServlet);
//
//        RequestDispatcher dis=request.getRequestDispatcher("tupoksiServlet.java");
//        dis.forward(request, response); 



//***************************ISIAN KEDUA********************************        
//        PnsSkp pnsp = new GoIndex().getPns(idp);
//        
//         request.setAttribute("pnsp", pnsp);
//         
//           RequestDispatcher dis=request.getRequestDispatcher("isi4faktor.jsp");
//        dis.forward(request, response); 


//****************************ISIAN PERTAMA**************         
//        //ke java, db, dll
//        String id=request.getParameter("id");
//        PnsSkp pns=new GoIndex().getPns(id);
//        
//        //membuat session
//        HttpSession session=request.getSession();
//        session.setAttribute("pns", pns);
//        
//        //kirim ke jsp lagi
//        response.sendRedirect("index.jsp");        
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

//**********************************cara 1 dengan MENGGUNAKAN JAVA BEAN****************************************//
        //ke java, db, dll

        String param = request.getParameter("param");
        //String paramR = request.getParameter("paramR");

        if (param.equalsIgnoreCase("CARI")) {
            String id = request.getParameter("txtNIPBaru");

            if (id != null && id != "" && id != " ") {
                idp = id;
                PnsSkp pns = new GoIndex().getPns(id);

                if (pns == null) {
                } else {
                    String unorAtasan = pns.getDiAtasanId();
                    String UnorPns = pns.getUnorId();
                    String InstansiPns = pns.getInstansiId();
                    String NipPns = pns.getNipBaru();
                    PnsSkp UnorAts = new GoIndex().getUnorAtasan(unorAtasan);

                    List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);

                    request.setAttribute("pns", pns);
                    request.setAttribute("UnorAts", UnorAts);
                    request.setAttribute("tukesiServlet", tukesiServlet);
                }

                //kirim ke jsp lagi
                //RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
                //RequestDispatcher dis = request.getRequestDispatcher("indexBaru.jsp");
                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/indexBaruBiru2.jsp");
                dis.forward(request, response);
            } else if (id == null || id == "" || id == " ") {
                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/indexBaruBiru2.jsp");
                dis.forward(request, response);
            } else {
            }
        } else if (param.equalsIgnoreCase("CARI_PNS")) {
            getRealisasi2(request, response);
        } else if (param.equalsIgnoreCase("CARI_NIP")) {
            getPerilaku(request, response);
        } else if (param.equalsIgnoreCase("INSERT")) {
            String dd = "cccC";
            String nip = request.getParameter("_getInstansi");

            PnsSkp pnsp = new GoIndex().getPns(nip);
            TupoksiKeIsi4Faktor tupoksiKeIsi4Faktor = new GoIndex().getTupoksi(nip);

            request.setAttribute("pnsp", pnsp);
            request.setAttribute("tupoksiKeIsi4Faktor", tupoksiKeIsi4Faktor);
            //RequestDispatcher dis = request.getRequestDispatcher("isi4faktor.jsp");
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/isi4faktorBaru.jsp");
            dis.forward(request, response);
        } //        else if (param.equalsIgnoreCase("AMBIL"))
        //        {
        //            String nip = request.getParameter("nipbaru");
        //            PnsSkp pns = new GoIndex().getPns(nip);
        //            request.setAttribute("pns", pns);
        //            RequestDispatcher dis = request.getRequestDispatcher("manajemenUser.jsp");  
        //            dis.forward(request, response);
        //        }
        //        else if (param.equalsIgnoreCase("OK"))
        //        {
        //           String nipbaru = request.getParameter("getNipBaruPns"); 
        //           String usernamebaru = request.getParameter("usernameinputan"); 
        //           String passwordbaru = request.getParameter("passwordinputan");
        //           String kewenangan = request.getParameter("kewenangan");
        //           String apakah;
        //           
        //           if (!"-".equals(kewenangan))
        //           {
        //               loginweb getSudahAdaUser = new GoIndex().getSudahAdaUser(nipbaru);
        //               if (getSudahAdaUser == null)
        //               {
        //                    apakah = "simpan";
        //                    String masukLogin = new GoIndex().getSimpanLogin(usernamebaru,passwordbaru,kewenangan,nipbaru,apakah);
        //               }
        //               else
        //               {
        //                   apakah = "ubah";
        //                   String updateLogin = new GoIndex().getSimpanLogin(usernamebaru,passwordbaru,kewenangan,nipbaru,apakah);
        //               }
        //           }
        //           else
        //           {
        //               
        //           }
        //           
        //        }
        //        else if (param.equalsIgnoreCase("UBAH"))
        //        {
        //            
        //        }
        //        else if (param.equalsIgnoreCase("HAPUS"))
        //        {
        //            
        //        }
        else if (param == null) {
//            String id = request.getParameter("txtNIPBaru");
//            idp = id;
//            PnsSkp pns = new GoIndex().getPns(id);
//
//            if (pns == null)
//            {
//            }
//            else
//            {
//                String unorAtasan = pns.getDiAtasanId();
//                String UnorPns = pns.getUnorId();
//                String InstansiPns = pns.getInstansiId();
//                String NipPns = pns.getNipBaru();
//                PnsSkp UnorAts = new GoIndex().getUnorAtasan(unorAtasan);
//
//                List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);
//
//                request.setAttribute("pns", pns);
//                request.setAttribute("UnorAts", UnorAts);
//                request.setAttribute("tukesiServlet", tukesiServlet); 
//            }
//
//            //kirim ke jsp lagi
//            RequestDispatcher dis = request.getRequestDispatcher("indexRealisasi.jsp");
//            dis.forward(request, response);
        }
//*********************************cara ke2 dengan membuat session**************************************************//
        //        HttpSession session=request.getSession();
        //        session.setAttribute("pns", pns);
        //        session.setAttribute("unorAts", UnorAts);

    }

    private void getKembaliRealisasi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idRisi = request.getParameter("txtNIPBaruReal"); //mendapatkan NIP pada KEMBALI realisasi
        PnsSkp pns = new GoIndex().getPns(idRisi);
        if (pns == null) {
        } else {

            String unorAtasan = pns.getDiAtasanId();
            String UnorPns = pns.getUnorId();

            String InstansiPns = pns.getInstansiId();
            String NipPns = pns.getNipBaru();

            PnsSkp UnorAts = new GoIndex().getUnorAtasan(unorAtasan);

            List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();

            List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);

            List<RealisasiIsi4faktorTupoksi> realkesiServlet = new GoIndex().getRealkesi(idRisi);

            //StringBuffer Keterangan = new StringBuffer();

            int nomorHitung = 0;
            String nomorstr;

            for (TupoksiKeIsi4Faktor tukesiDomain : tukesiServlet) {
                nomorHitung = nomorHitung + 1;
                Map<String, Object> test = new HashMap<String, Object>();
                String idTupoksi = tukesiDomain.getIdTupoksi();
                String idIsi4faktor = tukesiDomain.getIdIsi4Faktor();
                realisasi Realisasi = new GoIndex().getIdRealitas(idTupoksi, idp, idIsi4faktor);
                nomorstr = Integer.toString(nomorHitung);
                if (Realisasi != null) {
                    test.put("KUALITASR", Realisasi.getKualitasR());
                    test.put("KUANTITASR", Realisasi.getKuantitasR());
                    test.put("WAKTUR", Realisasi.getWaktuR());
                    test.put("BAYARR", Realisasi.getBiayaR());

                    test.put("NOMORTUPOKSI", nomorstr);
                    test.put("NAMATUPOKSI", tukesiDomain.getNamaTupoksi());

                    test.put("KUANTITAS4", tukesiDomain.getKuantitas4());
                    test.put("KUALITAS4", tukesiDomain.getKualitas4());
                    test.put("WAKTU4", tukesiDomain.getWaktu4());
                    test.put("BIAYA4", tukesiDomain.getBiaya4());

                    listResult.add(test);
                } else {
                    test.put("KUALITASR", "-");
                    test.put("KUANTITASR", "-");
                    test.put("WAKTUR", "-");
                    test.put("BAYARR", "-");

                    test.put("NOMORTUPOKSI", nomorstr);
                    test.put("NAMATUPOKSI", tukesiDomain.getNamaTupoksi());
                    test.put("KUANTITAS4", tukesiDomain.getKuantitas4());
                    test.put("KUALITAS4", tukesiDomain.getKualitas4());
                    test.put("WAKTU4", tukesiDomain.getWaktu4());
                    test.put("BIAYA4", tukesiDomain.getBiaya4());


                }
            }

            request.setAttribute("pns", pns);
            request.setAttribute("UnorAts", UnorAts);
            request.setAttribute("listResult", listResult);
            //request.setAttribute("tukesiServlet", tukesiServlet);
            request.setAttribute("realkesiServlet", realkesiServlet);
        }

        getTugasTambahan(request, response);

        //RequestDispatcher dis = request.getRequestDispatcher("indexRealisasi.jsp");
        RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/indexRealisasiBaruBiru2.jsp");
        dis.forward(request, response);
    }

    private void getRealisasi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("niprealisasi");
        idp = id;
        PnsSkp pns = new GoIndex().getPns(id);
        if (pns == null) {
        } else {
            String unorAtasan = pns.getDiAtasanId();
            String UnorPns = pns.getUnorId();
            String InstansiPns = pns.getInstansiId();
            String NipPns = pns.getNipBaru();

            PnsSkp UnorAts = new GoIndex().getUnorAtasan(unorAtasan);

            List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();

            List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);

            //StringBuffer Keterangan = new StringBuffer();

            int nomorHitung = 0;
            String nomorstr;

            for (TupoksiKeIsi4Faktor tukesiDomain : tukesiServlet) {
                nomorHitung = nomorHitung + 1;
                Map<String, Object> test = new HashMap<String, Object>();
                String idTupoksi = tukesiDomain.getIdTupoksi();
                String idIsi4faktor = tukesiDomain.getIdIsi4Faktor();
                realisasi Realisasi = new GoIndex().getIdRealitas(idTupoksi, idp, idIsi4faktor);
                nomorstr = Integer.toString(nomorHitung);
                if (Realisasi != null) {
                    test.put("KUALITASR", Realisasi.getKualitasR());
                    test.put("KUANTITASR", Realisasi.getKuantitasR());
                    test.put("WAKTUR", Realisasi.getWaktuR());
                    test.put("BAYARR", Realisasi.getBiayaR());

                    test.put("NOMORTUPOKSI", nomorstr);
                    test.put("NAMATUPOKSI", tukesiDomain.getNamaTupoksi());

                    test.put("KUANTITAS4", tukesiDomain.getKuantitas4());
                    test.put("KUALITAS4", tukesiDomain.getKualitas4());
                    test.put("WAKTU4", tukesiDomain.getWaktu4());
                    test.put("BIAYA4", tukesiDomain.getBiaya4());

                    listResult.add(test);
                } else {
                    test.put("KUALITASR", "-");
                    test.put("KUANTITASR", "-");
                    test.put("WAKTUR", "-");
                    test.put("BAYARR", "-");

                    test.put("NOMORTUPOKSI", nomorstr);
                    test.put("NAMATUPOKSI", tukesiDomain.getNamaTupoksi());
                    test.put("KUANTITAS4", tukesiDomain.getKuantitas4());
                    test.put("KUALITAS4", tukesiDomain.getKualitas4());
                    test.put("WAKTU4", tukesiDomain.getWaktu4());
                    test.put("BIAYA4", tukesiDomain.getBiaya4());
                }
            }
            request.setAttribute("pns", pns);
            request.setAttribute("UnorAts", UnorAts);
            request.setAttribute("listResult", listResult);
        }
        RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/realisasi2.jsp");
        dis.forward(request, response);
    }

//    private void getRealisasi2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
//    {
//        String id = request.getParameter("txtNIPBaru");
//        //String tupo = request.getParameter("idTupoksi");
//        
//        idp = id;
//        PnsSkp pns = new GoIndex().getPns(id);
//        if (pns ==null)
//        {   
//        }
//        else
//        {
//            String unorAtasan = pns.getDiAtasanId();
//            String UnorPns = pns.getUnorId();
//            String InstansiPns = pns.getInstansiId();
//            String NipPns = pns.getNipBaru();
//
//            PnsSkp UnorAts = new GoIndex().getUnorAtasan(unorAtasan);
//
//            List<Map<String,Object>> listResult = new ArrayList<Map<String,Object>>();
//
//            List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);
//            
//            List<RealisasiIsi4faktorTupoksi> realkesiServlet = new GoIndex().getRealkesi(id);
//            
//            //StringBuffer Keterangan = new StringBuffer();
//            
//            int nomorHitung=0;
//            String nomorstr;
//            
//            for (TupoksiKeIsi4Faktor tukesiDomain : tukesiServlet)
//            {
//                nomorHitung=nomorHitung+1;
//                Map<String, Object> test = new HashMap<String, Object>();
//                String idTupoksi=tukesiDomain.getIdTupoksi();
//                String idIsi4faktor=tukesiDomain.getIdIsi4Faktor();
//                
//                realisasi Realisasi= new GoIndex().getIdRealitas(idTupoksi, idp, idIsi4faktor);
//                
//                RealisasiIsi4faktorTupoksi ambilIsi = new GoIndex().getIsiRealisasi4FaktorDao(idTupoksi, idp, idIsi4faktor);
//                
//                if(ambilIsi == null)
//                {
//                    nomorstr =Integer.toString(nomorHitung);
//                    if (Realisasi != null)
//                    {
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
//                        test.put("PENGHITUNGAN","-");
//                        test.put("NILAICAPAIAN","-");
//
//                        listResult.add(test);
//                    }
//                    else
//                    {
//                        test.put("KUALITASR", "-");
//                        test.put("KUANTITASR","-");
//                        test.put("WAKTUR","-");
//                        test.put("BAYARR","-");
//
//                        test.put("NOMORTUPOKSI",nomorstr); 
//                        test.put("NAMATUPOKSI",tukesiDomain.getNamaTupoksi()); 
//                        test.put("KUANTITAS4",tukesiDomain.getKuantitas4());
//                        test.put("KUALITAS4",tukesiDomain.getKualitas4());
//                        test.put("WAKTU4",tukesiDomain.getWaktu4());
//                        test.put("BIAYA4",tukesiDomain.getBiaya4());
//
//                        test.put("PENGHITUNGAN","-");
//                        test.put("NILAICAPAIAN","-");
//                    }
//                }
//                else
//                {
//                    String kuantr = ambilIsi.getKuantitasR();
//                    String kualr = ambilIsi.getKualitasR();
//                    String waktr = ambilIsi.getWaktuR();
//                    String biayr = ambilIsi.getBiayaR();
//                    String kuant4 = ambilIsi.getKuantitas4();
//                    String kual4 = ambilIsi.getKualitas4();
//                    String wakt4 = ambilIsi.getWaktu4();
//                    String biay4 = ambilIsi.getBiaya4();
//
//                    if ("-".equals(kuantr) || "-".equals(kualr) || "-".equals(waktr) || "-".equals(biayr) || "-".equals(kuant4) || "-".equals(kual4) || "-".equals(wakt4) || "-".equals(biay4))
//                    {
//                        nomorstr =Integer.toString(nomorHitung);
//                        if (Realisasi != null)
//                        {
//                            test.put("KUALITASR", Realisasi.getKualitasR());
//                            test.put("KUANTITASR",Realisasi.getKuantitasR());
//                            test.put("WAKTUR",Realisasi.getWaktuR());
//                            test.put("BAYARR",Realisasi.getBiayaR());
//
//                            test.put("NOMORTUPOKSI",nomorstr); 
//                            test.put("NAMATUPOKSI",tukesiDomain.getNamaTupoksi()); 
//
//                            test.put("KUANTITAS4",tukesiDomain.getKuantitas4());
//                            test.put("KUALITAS4",tukesiDomain.getKualitas4());
//                            test.put("WAKTU4",tukesiDomain.getWaktu4());
//                            test.put("BIAYA4",tukesiDomain.getBiaya4());
//
//                            test.put("PENGHITUNGAN","-");
//                            test.put("NILAICAPAIAN","-");
//
//        //                    test.put("PENGHITUNGAN",hitungannya.getPenghitungan());
//        //                    test.put("NILAICAPAIAN",hitungannya.getNilaiCapaianSKP());
//
//                            listResult.add(test);
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
//                            test.put("PENGHITUNGAN","-");
//                            test.put("NILAICAPAIAN","-");
//                        }
//                    }
//                    else
//                    {
//                        RealisasiIsi4faktorTupoksi hitungannya = new GoIndex().getFormatPenghitunganIsi4FaktorDao(idTupoksi, idp, idIsi4faktor);
//                        nomorstr =Integer.toString(nomorHitung);
//                        if (Realisasi != null)
//                        {
//                            test.put("KUALITASR", Realisasi.getKualitasR());
//                            test.put("KUANTITASR",Realisasi.getKuantitasR());
//                            test.put("WAKTUR",Realisasi.getWaktuR());
//                            test.put("BAYARR",Realisasi.getBiayaR());
//
//                            test.put("NOMORTUPOKSI",nomorstr); 
//                            test.put("NAMATUPOKSI",tukesiDomain.getNamaTupoksi()); 
//
//                            test.put("KUANTITAS4",tukesiDomain.getKuantitas4());
//                            test.put("KUALITAS4",tukesiDomain.getKualitas4());
//                            test.put("WAKTU4",tukesiDomain.getWaktu4());
//                            test.put("BIAYA4",tukesiDomain.getBiaya4());
//
//                            test.put("PENGHITUNGAN",hitungannya.getPenghitungan());
//                            test.put("NILAICAPAIAN",hitungannya.getNilaiCapaianSKP());
//
//                            listResult.add(test);
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
//                            test.put("PENGHITUNGAN","-");
//                            test.put("NILAICAPAIAN","-");
//                        }
//                    }
//                    
//                }
//            }
//            
//            request.setAttribute("pns", pns);
//            request.setAttribute("UnorAts", UnorAts);
//            request.setAttribute("listResult",listResult);
//            //request.setAttribute("tukesiServlet", tukesiServlet);
//            request.setAttribute("realkesiServlet", realkesiServlet);
//        }
//        RequestDispatcher dis = request.getRequestDispatcher("indexRealisasi.jsp");
//        dis.forward(request, response); 
//    }
    private void getRealisasi2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //di index.jsp mengklik link REALISASI dan menuju ke indexRealisasi.jsp dan otomatis terisi
        //sesuai dengan nip ybs 

        String id = request.getParameter("txtNIPBaru");
        String action = request.getParameter("action");

        //String tupo = request.getParameter("idTupoksi");
        String _pilih_session = request.getParameter("pilih_session");
        String idNiptambahan = (String) request.getAttribute("idNiptambahan");
        if (_pilih_session == null) {
            _pilih_session = "-";
        }
        if (id == null) {
            id = idNiptambahan;
        }

        if (id != null && id != "" && id != " ") {
            idp = id;
            PnsSkp pns = new GoIndex().getPns(id);
            if (pns == null) {
            } else {
                String unorAtasan = pns.getDiAtasanId();
                String UnorPns = pns.getUnorId();
                String InstansiPns = pns.getInstansiId();
                String NipPns = pns.getNipBaru();
                PnsSkp UnorAts = null;
                if (ModelLocatorSKP.nipBaruAtasan == null || ModelLocatorSKP.nipBaruAtasan.equals("") || ModelLocatorSKP.nipBaruAtasan.equals(" ")) {

                    UnorAts = new GoIndex().getUnorAtasan(unorAtasan);
                } else {
                    UnorAts = new GoIndex().getPns(ModelLocatorSKP.nipBaruAtasan);
                }


                List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();

                List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);

                List<RealisasiIsi4faktorTupoksi> realkesiServlet = new GoIndex().getRealkesi(id);
                if (_pilih_session.equals("-")) {
                    realkesiServlet = new GoIndex().getRealkesi(id);
                } else {

                    realkesiServlet = new GoIndex().getRealkesiSession(ModelLocatorSKP.IdUnorUser, id, _pilih_session);
                }
                //StringBuffer Keterangan = new StringBuffer();

                int nomorHitung = 0;
                String nomorstr;

                for (TupoksiKeIsi4Faktor tukesiDomain : tukesiServlet) {
                    nomorHitung = nomorHitung + 1;
                    Map<String, Object> test = new HashMap<String, Object>();
                    String idTupoksi = tukesiDomain.getIdTupoksi();
                    String idIsi4faktor = tukesiDomain.getIdIsi4Faktor();
                    realisasi Realisasi = new GoIndex().getIdRealitas(idTupoksi, idp, idIsi4faktor);
                    nomorstr = Integer.toString(nomorHitung);
                    if (Realisasi != null) {
                        test.put("KUALITASR", Realisasi.getKualitasR());
                        test.put("KUANTITASR", Realisasi.getKuantitasR());
                        test.put("WAKTUR", Realisasi.getWaktuR());
                        test.put("BAYARR", Realisasi.getBiayaR());
                        test.put("ANGKAKREDITR", Realisasi.getangkaKrdt());

                        test.put("NOMORTUPOKSI", nomorstr);
                        test.put("NAMATUPOKSI", tukesiDomain.getNamaTupoksi());

                        test.put("KUANTITAS4", tukesiDomain.getKuantitas4());
                        test.put("KUALITAS4", tukesiDomain.getKualitas4());
                        test.put("WAKTU4", tukesiDomain.getWaktu4());
                        test.put("BIAYA4", tukesiDomain.getBiaya4());
                        test.put("ANGKAKREDIT4", tukesiDomain.getangka_krdt());

                        listResult.add(test);
                    } else {
                        test.put("KUALITASR", "-");
                        test.put("KUANTITASR", "-");
                        test.put("WAKTUR", "-");
                        test.put("BAYARR", "-");

                        test.put("NOMORTUPOKSI", nomorstr);
                        test.put("NAMATUPOKSI", tukesiDomain.getNamaTupoksi());
                        test.put("KUANTITAS4", tukesiDomain.getKuantitas4());
                        test.put("KUALITAS4", tukesiDomain.getKualitas4());
                        test.put("WAKTU4", tukesiDomain.getWaktu4());
                        test.put("BIAYA4", tukesiDomain.getBiaya4());
                        test.put("ANGKAKREDIT4", tukesiDomain.getangka_krdt());


                    }
                }

                request.setAttribute("pns", pns);
                request.setAttribute("UnorAts", UnorAts);
                request.setAttribute("listResult", listResult);
                //request.setAttribute("tukesiServlet", tukesiServlet);
                request.setAttribute("realkesiServlet", realkesiServlet);
            }

            getTugasTambahan(request, response);



            //======================*********************

            if ("Monitor".equals(action)) {
                String nipAtasanMonitoring = request.getParameter("NipAtasan");
                id = request.getParameter("txtNIPBaru");
                //String nipAtasanMonitoring = request.getParameter("nipBaru"); 
                String idNipTambahan = nipAtasanMonitoring;

                PnsSkp pns2 = new GoIndex().getPns(nipAtasanMonitoring);

                String iUnorTambahan = pns2.getUnorId();
                //List<pnsskp_strukturalbkn> pnsList = new GoIndex().getTugasTambahanBawahanList(iUnorTambahan);
                List<PnsSkp> pnsList = new GoIndex().getTugasTambahanBawahanList2(iUnorTambahan);
                request.setAttribute("pnsList", pnsList);
                request.setAttribute("pns", pns2);
                request.setAttribute("nipBaru", idNipTambahan);
                request.setAttribute("nipAtasan", idNipTambahan);
                request.setAttribute("nipdimonitoring", nipAtasanMonitoring);
                request.setAttribute("nipsendiri", id);

                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/monitoring.jsp");
                List<RealisasiIsi4faktorTupoksi> realkesiServlet = new GoIndex().getRealkesi(id);


                request.setAttribute("realkesiServlet", realkesiServlet);
                dis.forward(request, response);
            } else {
                  ModelLocatorSKP.navigasiPil = "44";
            request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);
            
              request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
            

            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/navigasiPenggunadat.jsp");
            dis.forward(request, response);
                
               // RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/indexRealisasiBaruBiru2.jsp");
                //dis.forward(request, response);
            }


            //=====================***********************


            //RequestDispatcher dis = request.getRequestDispatcher("indexRealisasi.jsp");
//            RequestDispatcher dis = request.getRequestDispatcher("indexRealisasiBaruBiru.jsp");
            // RequestDispatcher dis = request.getRequestDispatcher("indexRealisasiBaruBiru2.jsp");
            //  dis.forward(request, response);
        } else if (id == null || id == "" || id == " ") {
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/indexRealisasiBaruBiru2.jsp");
            dis.forward(request, response);
        } else {
        }

    }

    private void getPerilaku(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idP = request.getParameter("txtNIPBaruPerilaku");

        PnsSkp pns = new GoIndex().getPns(idP);

        String nip = pns.getNipBaru();
        String nama = pns.getNamaPns();

        request.setAttribute("nip", nip);
        request.setAttribute("nama", nama);

        RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/indexPerilaku.jsp");
        dis.forward(request, response);

    }

    public void getTusiDariIsiTupoksi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _vnipInputan = request.getParameter("vnipInputan");
        String _pilih_session = request.getParameter("pilih_session");
        String id = null;
        if (_vnipInputan != null) {
            id = _vnipInputan;
        } else {
            id = (String) request.getAttribute("NipPns");
        }

        idp = id;

        PnsSkp pns = new GoIndex().getPns(id);
        String unorAtasan = pns.getDiAtasanId();
        String UnorPns = pns.getUnorId();
        String InstansiPns = pns.getInstansiId();
        String NipPns = pns.getNipBaru();

        PnsSkp UnorAts = new GoIndex().getUnorAtasan(unorAtasan);

        List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);

        request.setAttribute("pns", pns);
        request.setAttribute("UnorAts", UnorAts);

        request.setAttribute("tukesiServlet", tukesiServlet);

        //kirim ke jsp lagi
        //RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
        RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/indexBaruBiru2.jsp");
        dis.forward(request, response);
    }

    public void getTugasTambahan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String id = (String) request.getAttribute("NipPns"); 
        String id = idp;

        List<TugasTambahan> tugasTambahans = new GoIndex().getTugasTambahanList(id);
        request.setAttribute("tugasTambahans", tugasTambahans);

        List<TugasTambahan> kereaktifitas = new GoIndex().getKreatifitasList(id);
        request.setAttribute("kereaktifitas", kereaktifitas);
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
