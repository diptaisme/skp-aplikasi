/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
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
public class IsiPerilakuServlet extends HttpServlet {

    String nipPerilaku;

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
            out.println("<title>Servlet isiPerilakuServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet isiPerilakuServlet at " + request.getContextPath() + "</h1>");
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

        String action = request.getParameter("action");

        String nipHapusPerilaku = request.getParameter("NipPerilakuHapus");
        String nipUpdatePerilaku = request.getParameter("NipPerilakuUpdate");
        String nipLihatPerilaku = request.getParameter("NipPerilakuLihat");

        nipPerilaku = request.getParameter("nipnilaiPrilaku");

        String NipKoefKreatifitas = request.getParameter("NipKoefKreatifitas");

        String nipAtasan = request.getParameter("nipAtasan");
        //String nipAtasan = "x";

        String idTambahanKreatifitas = request.getParameter("idTambahanKreatifitas");

        String idTambahanTgsTmbhn = request.getParameter("idTambahanTgsTmbhn");
        String NipDicari = request.getParameter("cariNip");

        String NamaDicari = request.getParameter("cariNama");

        String nipBaruAtasan = request.getParameter("nipBaru");
        String nipAtasanMonitoring = request.getParameter("nipAtasanMonitoring");
        String nipAtasanMonitoring2 = request.getParameter("nipatasanMonitoring2");
        String pilih_session_monit = request.getParameter("pilih_session_monit");
        String nipatasanMonitoringCetak = request.getParameter("nipatasanMonitoringCetak");
        String nipatasanMonitoringView = request.getParameter("nipatasanMonitoringView");


        /* if (action != null && action.equalsIgnoreCase("CariBawahan")){
        
        
        String idNipTambahan = nipAtasan;
        PnsSkp pns = new GoIndex().getPns(idNipTambahan);
        
        String iUnorTambahan = pns.getUnorId();
        //List<pnsskp_strukturalbkn> pnsList = new GoIndex().getTugasTambahanBawahanList(iUnorTambahan);
        List<pnsskp_jabfungtbkn> pnsList = new GoIndex().getTugasTambahanBawahanList(iUnorTambahan);
        request.setAttribute("pnsList", pnsList);
        
        request.setAttribute("nipAtasan", idNipTambahan);
        
        //            List<TugasTambahan> tugasTambahans = new GoIndex().getTugasTambahanList(idNipTambahan);
        //            request.setAttribute("tugasTambahans", tugasTambahans);
        //            
        //            List<TugasTambahan> kereaktifitas = new GoIndex().getKreatifitasList(idNipTambahan);
        //            request.setAttribute("kereaktifitas", kereaktifitas);
        
        RequestDispatcher dis = request.getRequestDispatcher("nilaiTugasTambahan.jsp");
        dis.forward(request, response); 
        
        } */



        if (action != null && action.equalsIgnoreCase("HapusPerilaku")) {
            String hapusPerilaku = new GoIndex().getHapusPerilaku(nipHapusPerilaku);

            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/indexPerilaku.jsp");
            dis.forward(request, response);
        } else if (action != null && action.equalsIgnoreCase("Lihat")) {
            String idNipTambahan = nipLihatPerilaku;
            PnsSkp pns = new GoIndex().getPns(idNipTambahan);
            String iUnorTambahan = pns.getDiAtasanId();
            System.out.println("idunor = " + iUnorTambahan);
            //List<pnsskp_strukturalbkn> pnsList = new GoIndex().getTugasTambahanBawahanList(iUnorTambahan);
            List<PnsSkp> pnsList = new GoIndex().getTugasTambahanBawahanList2(iUnorTambahan);
            //  List<pnsskp> pnsList = new GoIndex().getTugasTambahanBawahanListALL(iUnorTambahan);

            request.setAttribute("pnsList", pnsList);

            PnsSkp nipnama = new GoIndex().getLihatNipNama(nipLihatPerilaku);
            String nip = nipnama.getNipBaru();
            String nama = nipnama.getNamaPns();
            String jenis = nipnama.getjnsjbtn_id();
            request.setAttribute("nip", nip);
            request.setAttribute("nama", nama);
            request.setAttribute("jenis", jenis);

            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/indexPerilaku.jsp");
            dis.forward(request, response);
        } else if (action != null && action.equalsIgnoreCase("UpdatePerilaku")) {
            nilaiPerilaku nilaiPrilak = new GoIndex().getPrilaku(nipUpdatePerilaku);

            String _nip = nilaiPrilak.getNIPPNS();
            String _Penilaian = nilaiPrilak.getPeriode();
            String _Pelayanan = nilaiPrilak.getPelayanan();
            String _Integritas = nilaiPrilak.getIntegritas();
            String _Komitmen = nilaiPrilak.getKomitmen();
            String _Disiplin = nilaiPrilak.getDisiplin();
            String _Kerjasama = nilaiPrilak.getKerjasama();
            String _Kepemimpinan = nilaiPrilak.getKepemimpinan();
            String _jumlah = nilaiPrilak.getJumlah();
            String _ratarata = nilaiPrilak.getRatarata();

            PnsSkp pns = new GoIndex().getPns(nipUpdatePerilaku);

            String _nama = pns.getNamaPns();

            request.setAttribute("nip", _nip);
            request.setAttribute("Penilaian", _Penilaian);
            request.setAttribute("Pelayanan", _Pelayanan);
            request.setAttribute("Integritas", _Integritas);
            request.setAttribute("Komitmen", _Komitmen);
            request.setAttribute("Disiplin", _Disiplin);
            request.setAttribute("Kerjasama", _Kerjasama);
            request.setAttribute("Kepemimpinan", _Kepemimpinan);
            request.setAttribute("jumlah", _jumlah);
            request.setAttribute("ratarata", _ratarata);
            request.setAttribute("nama", _nama);

            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/indexPerilaku.jsp");
            dis.forward(request, response);
        } else if (action == null && nipPerilaku != null) {
            String idNipTambahan = nipPerilaku;
            PnsSkp pns = new GoIndex().getPns(idNipTambahan);
            String jnsjabtn = pns.getjnsjbtn_id();

            String iUnorTambahan = pns.getUnorId();
            System.out.println("idunor = " + iUnorTambahan);
            //List<pnsskp_strukturalbkn> pnsList = new GoIndex().getTugasTambahanBawahanList(iUnorTambahan);
            ModelLocatorSKP.arraypGcavernip = new ArrayList<String>();
            List<PnsSkp> pnsList = new GoIndex().getTugasTambahanBawahanList2(iUnorTambahan);

            PnsSkp nipatasan = new GoIndex().getUnorAtasan(iUnorTambahan);
            String nipAtasan123 = nipatasan.getNipBaru();
            request.setAttribute("nipAtasan", nipAtasan123);
            request.setAttribute("isJab", jnsjabtn);
            request.setAttribute("jenis", jnsjabtn);
            request.setAttribute("pnsList", pnsList);
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/indexPerilaku.jsp");
            dis.forward(request, response);
        } else if (action == null && nipAtasanMonitoring != null) {
            ModelLocatorSKP.arraypGcavernip = new ArrayList<String>();
            String idNipTambahan = nipAtasanMonitoring;
            PnsSkp pns = new GoIndex().getPns(idNipTambahan);

            String iUnorTambahan = pns.getUnorId();
            //List<pnsskp_strukturalbkn> pnsList = new GoIndex().getTugasTambahanBawahanList(iUnorTambahan);
            List<PnsSkp> pnsList = new GoIndex().getTugasTambahanBawahanList2(iUnorTambahan);


            //   List<pnsskp> pnsList = new GoIndex().getTugasTambahanBawahanListALL(iUnorTambahan);
            request.setAttribute("pnsList", pnsList);
            request.setAttribute("pns", pns);

            request.setAttribute("nipAtasan", idNipTambahan);
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/monitoring.jsp");
            dis.forward(request, response);
        } else if (action == null && nipAtasanMonitoring2 != null) {
            ModelLocatorSKP.arraypGcavernip = new ArrayList<String>();
            String idNipTambahan = nipAtasanMonitoring2;
            PnsSkp pns = new GoIndex().getPns(idNipTambahan);
            String iUnorTambahan = pns.getUnorId();
            //List<pnsskp_strukturalbkn> pnsList = new GoIndex().getTugasTambahanBawahanList(iUnorTambahan);
            //  List<pnsskp> pnsList = new GoIndex().getTugasTambahanBawahanList2(iUnorTambahan);
            List<PnsSkp> pnsList = new GoIndex().getTugasTambahanBawahanListALL(iUnorTambahan);
            PnsSkp ipns = null;
            List<PnsSkp> pnsBawahan = new ArrayList<PnsSkp>();
            List<PnsSkp> pnsBawahan2 = new ArrayList<PnsSkp>();
            List<PnsSkp> pnsBawahan3 = new ArrayList<PnsSkp>();
            List<PnsSkp> pnsBawahan4 = new ArrayList<PnsSkp>();
            for (PnsSkp ipns3 : pnsList) {
                ipns = new PnsSkp();
                if (ipns3.getNipBaru().equals("198612262009121001")){
                    String testnip = ipns3.getNipBaru();
                }
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

            request.setAttribute("nipAtasan", idNipTambahan);
            ModelLocatorSKP.navigasiPil = "46";
            request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
            request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);

            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/navigasiPenggunadat.jsp");
            dis.forward(request, response);

            //RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/monitoring.jsp");
            // dis.forward(request, response);
        } else if (nipatasanMonitoringView!=null){
            ModelLocatorSKP.arraypGcavernip = new ArrayList<String>();
            String idNipTambahan = nipatasanMonitoringView;
            PnsSkp pns = new GoIndex().getPns(idNipTambahan);
            String iUnorTambahan = pns.getUnorId();
           
            List<PnsSkp> pnsList = new GoIndex().getTugasTambahanBawahanListALL(iUnorTambahan);
            PnsSkp ipns = null;
            List<PnsSkp> pnsBawahan = new ArrayList<PnsSkp>();
            List<PnsSkp> pnsBawahan2 = new ArrayList<PnsSkp>();
            List<PnsSkp> pnsBawahan3 = new ArrayList<PnsSkp>();
            List<PnsSkp> pnsBawahan4 = new ArrayList<PnsSkp>();
            for (PnsSkp ipns3 : pnsList) {
                ipns = new PnsSkp();
                if (ipns3.getNipBaru().equals("198612262009121001")){
                    String testnip = ipns3.getNipBaru();
                }
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

            request.setAttribute("nipAtasan", idNipTambahan);
            ModelLocatorSKP.navigasiPil = "46";
            request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
            request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);

            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/navigasiPenggunadat.jsp");
            dis.forward(request, response);

        }else if (action == null && nipatasanMonitoringCetak != null) {
            ModelLocatorSKP.arraypGcavernip = new ArrayList<String>();
            String idNipTambahan = nipatasanMonitoringCetak;
            PnsSkp pns = new GoIndex().getPns(idNipTambahan);

            String iUnorTambahan = pns.getUnorId();

            List<PnsSkp> pnsList = new GoIndex().getTugasTambahanBawahanListALL(iUnorTambahan);
            request.setAttribute("pnsList", pnsList);
            request.setAttribute("pns", pns);

            request.setAttribute("nipAtasan", idNipTambahan);
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/monitoring.jsp");
            dis.forward(request, response);
        } else if (action == null && nipAtasan != null) {
            //nipAtasan = request.getParameter("nipAtasan");

            String idNipTambahan = nipAtasan;
            PnsSkp pns = new GoIndex().getPns(idNipTambahan);

            String iUnorTambahan = pns.getUnorId();
            //List<pnsskp_strukturalbkn> pnsList = new GoIndex().getTugasTambahanBawahanList(iUnorTambahan);
            List<PnsSkp> pnsList = new GoIndex().getTugasTambahanBawahanList2(iUnorTambahan);
            request.setAttribute("pnsList", pnsList);
            request.setAttribute("pns", pns);

            request.setAttribute("nipAtasan", idNipTambahan);

//            List<TugasTambahan> tugasTambahans = new GoIndex().getTugasTambahanList(idNipTambahan);
//            request.setAttribute("tugasTambahans", tugasTambahans);
//            
//            List<TugasTambahan> kereaktifitas = new GoIndex().getKreatifitasList(idNipTambahan);
//            request.setAttribute("kereaktifitas", kereaktifitas);

            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/nilaiTugasTambahan.jsp");
            dis.forward(request, response);
        } else if ("Koef".equals(action) && NipKoefKreatifitas != null) {
            String idNipTambahan = NipKoefKreatifitas;
            PnsSkp pns = new GoIndex().getPns(idNipTambahan);
            //masalahnya disini
            String iUnorTambahan = pns.getDiAtasanId();
            String unoridbaru = pns.getUnorId();

            if (unoridbaru.equals(iUnorTambahan)) {
                iUnorTambahan = unoridbaru;
            }

            //List<pnsskp_strukturalbkn> pnsList = new GoIndex().getTugasTambahanBawahanList(iUnorTambahan);
            List<PnsSkp> pnsList = new GoIndex().getTugasTambahanBawahanList2(iUnorTambahan);
            request.setAttribute("pnsList", pnsList);
            PnsSkp nipatasan;
            // if (unoridbaru.equals(iUnorTambahan)){
            //   nipatasan = new GoIndex().getUnorAtasanSama(idNipTambahan);
            // }else{
            nipatasan = new GoIndex().getUnorAtasan(iUnorTambahan);

            // } 
            String nipAtasan123 = nipatasan.getNipBaru();
            request.setAttribute("nipAtasan", nipAtasan123);

            request.setAttribute("idNipTambahan", idNipTambahan);

            List<TugasTambahan> tugasTambahans = new GoIndex().getTugasTambahanList(idNipTambahan);
            request.setAttribute("tugasTambahans", tugasTambahans);

            List<TugasTambahan> kereaktifitas = new GoIndex().getKreatifitasList(idNipTambahan);
            request.setAttribute("kereaktifitas", kereaktifitas);

            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/nilaiTugasTambahan.jsp");
            dis.forward(request, response);
        } else if ("Kreaf".equals(action) && NipKoefKreatifitas != null) {

            String idNipTambahan = NipKoefKreatifitas;
            String idTambahan = request.getParameter("idTam");


            //TAMPILAN
            PnsSkp pns = new GoIndex().getPns(idNipTambahan);
            String iUnorTambahan = pns.getDiAtasanId();
            //List<pnsskp_strukturalbkn> pnsList = new GoIndex().getTugasTambahanBawahanList(iUnorTambahan);
            List<PnsSkp> pnsList = new GoIndex().getTugasTambahanBawahanList2(iUnorTambahan);
            request.setAttribute("pnsList", pnsList);
            PnsSkp nipatasan = new GoIndex().getUnorAtasan(iUnorTambahan);
            String nipAtasan123 = nipatasan.getNipBaru();
            request.setAttribute("nipAtasan", nipAtasan123);
            request.setAttribute("idNipTambahan", idNipTambahan);
            List<TugasTambahan> tugasTambahans = new GoIndex().getTugasTambahanList(idNipTambahan);
            request.setAttribute("tugasTambahans", tugasTambahans);
            List<TugasTambahan> kereaktifitas = new GoIndex().getKreatifitasList(idNipTambahan);
            request.setAttribute("kereaktifitas", kereaktifitas);

            TugasTambahan kereaktifitas2 = new GoIndex().getKreatifitasSatoe(idNipTambahan, idTambahan);
            request.setAttribute("kereaktifitas2", kereaktifitas2);
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/nilaiTugasTambahan.jsp");
            dis.forward(request, response);

        } else if ("HitungTambahan".equals(action)) {
            String nip = request.getParameter("nipTambahan");
            String hitunganTugasTambahan = new GoIndex().getNilaiAllTugasTambahan(nip);
            request.setAttribute("hitunganTugasTambahan", hitunganTugasTambahan);



            //TAMPILAN
            String idNipTambahan = nip;
            PnsSkp pns = new GoIndex().getPns(idNipTambahan);

            String iUnorTambahan = pns.getDiAtasanId();
            //List<pnsskp_strukturalbkn> pnsList = new GoIndex().getTugasTambahanBawahanList(iUnorTambahan);
            List<PnsSkp> pnsList = new GoIndex().getTugasTambahanBawahanList2(iUnorTambahan);
            request.setAttribute("pnsList", pnsList);

            PnsSkp nipatasan = new GoIndex().getUnorAtasan(iUnorTambahan);
            String nipAtasan123 = nipatasan.getNipBaru();
            request.setAttribute("nipAtasan", nipAtasan123);

            request.setAttribute("idNipTambahan", idNipTambahan);

            List<TugasTambahan> tugasTambahans = new GoIndex().getTugasTambahanList(idNipTambahan);
            request.setAttribute("tugasTambahans", tugasTambahans);

            List<TugasTambahan> kereaktifitas = new GoIndex().getKreatifitasList(idNipTambahan);
            request.setAttribute("kereaktifitas", kereaktifitas);

            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/nilaiTugasTambahan.jsp");
            dis.forward(request, response);

        } else if ("HitungKreatifitas".equals(action) && idTambahanKreatifitas != null) {
            //String nilai = request.getParameter("nilai");
            String nilai = request.getParameter("koef_kreatifitas");
            //String nilai[] = request.getParameterValues("koef_kreatifitas");
            String idTam = idTambahanKreatifitas;
            String nip = request.getParameter("nipTambahan");

            if (!"-".equals(nilai)) {
                String masukKoef = new GoIndex().getsimpanTugasTambahanKoef(idTam, nilai);
                String hitungKoefKreaf = new GoIndex().HitungTugasTambahanKoef(idTam, nip);

                //TAMPILAN
                String idNipTambahan = nip;
                PnsSkp pns = new GoIndex().getPns(idNipTambahan);
                request.setAttribute("idNipTambahan", idNipTambahan);

                String iUnorTambahan = pns.getDiAtasanId();
                //List<pnsskp_strukturalbkn> pnsList = new GoIndex().getTugasTambahanBawahanList(iUnorTambahan);
                List<PnsSkp> pnsList = new GoIndex().getTugasTambahanBawahanList2(iUnorTambahan);
                request.setAttribute("pnsList", pnsList);

                PnsSkp nipatasan = new GoIndex().getUnorAtasan(iUnorTambahan);
                String nipAtasan123 = nipatasan.getNipBaru();
                request.setAttribute("nipAtasan", nipAtasan123);

                List<TugasTambahan> tugasTambahans = new GoIndex().getTugasTambahanList(idNipTambahan);
                request.setAttribute("tugasTambahans", tugasTambahans);

                List<TugasTambahan> kereaktifitas = new GoIndex().getKreatifitasList(idNipTambahan);
                request.setAttribute("kereaktifitas", kereaktifitas);
                
                 request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
            request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);

          //  RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/navigasiPenggunadat.jsp");
          //  dis.forward(request, response);
                

              RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/nilaiTugasTambahan.jsp");
                PrintWriter out = response.getWriter();
                dis.include(request, response);
                out.println(hitungKoefKreaf);
            } else {
                //TAMPILAN
                String idNipTambahan = nip;
                PnsSkp pns = new GoIndex().getPns(idNipTambahan);
                request.setAttribute("idNipTambahan", idNipTambahan);

                String iUnorTambahan = pns.getDiAtasanId();
                //List<pnsskp_strukturalbkn> pnsList = new GoIndex().getTugasTambahanBawahanList(iUnorTambahan);
                List<PnsSkp> pnsList = new GoIndex().getTugasTambahanBawahanList2(iUnorTambahan);
                request.setAttribute("pnsList", pnsList);

                PnsSkp nipatasan = new GoIndex().getUnorAtasan(iUnorTambahan);
                String nipAtasan123 = nipatasan.getNipBaru();
                request.setAttribute("nipAtasan", nipAtasan123);

                List<TugasTambahan> tugasTambahans = new GoIndex().getTugasTambahanList(idNipTambahan);
                request.setAttribute("tugasTambahans", tugasTambahans);

                List<TugasTambahan> kereaktifitas = new GoIndex().getKreatifitasList(idNipTambahan);
                request.setAttribute("kereaktifitas", kereaktifitas);

                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/nilaiTugasTambahan.jsp");
                PrintWriter out = response.getWriter();
                dis.include(request, response);
            }

        } else if ("TolakTugasTambahan".equals(action) && idTambahanTgsTmbhn != null) {
            String nip = request.getParameter("nipTambahan");
            String idTugasTambahanTolak = request.getParameter("idTambahanTgsTmbhn");

            String idNipTambahan = nip;
            PnsSkp pns = new GoIndex().getPns(idNipTambahan);
            request.setAttribute("idNipTambahan", idNipTambahan);


            String tolakanAtasanTugasTambahan = new GoIndex().getdeleteTambahan(idTugasTambahanTolak);

            //TAMPILAN
            String iUnorTambahan = pns.getDiAtasanId();
            //List<pnsskp_strukturalbkn> pnsList = new GoIndex().getTugasTambahanBawahanList(iUnorTambahan);
            List<PnsSkp> pnsList = new GoIndex().getTugasTambahanBawahanList2(iUnorTambahan);
            request.setAttribute("pnsList", pnsList);

            PnsSkp nipatasan = new GoIndex().getUnorAtasan(iUnorTambahan);
            String nipAtasan123 = nipatasan.getNipBaru();
            request.setAttribute("nipAtasan", nipAtasan123);

            List<TugasTambahan> tugasTambahans = new GoIndex().getTugasTambahanList(idNipTambahan);
            request.setAttribute("tugasTambahans", tugasTambahans);

            List<TugasTambahan> kereaktifitas = new GoIndex().getKreatifitasList(idNipTambahan);
            request.setAttribute("kereaktifitas", kereaktifitas);

            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/nilaiTugasTambahan.jsp");
            PrintWriter out = response.getWriter();
            dis.include(request, response);
            out.println(tolakanAtasanTugasTambahan);
        } else {
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
        String param = request.getParameter("param");
        String NipDicari = request.getParameter("cariNip");
        String NipBaruAtasan = request.getParameter("nipBaru");
        String NamaDicari = request.getParameter("cariNama");
        String Submit = request.getParameter("Submit");
        if (param != null) {
            if (param.equalsIgnoreCase("SIMPAN")) {
                String _nip = request.getParameter("nippns");

                String _Penilaian = request.getParameter("Penilaian");
                String _Pelayanan = request.getParameter("Pelayanan");
                String _Integritas = request.getParameter("Integritas");
                String _Komitmen = request.getParameter("Komitmen");
                String _Disiplin = request.getParameter("Disiplin");
                String _Kerjasama = request.getParameter("Kerjasama");
                String _Kepemimpinan = request.getParameter("Kepemimpinan");
                String _jumlah = "-";
                String _ratarata = "-";

                nilaiPerilaku adaNipPerilaku = new GoIndex().getPrilaku(_nip);

                if (adaNipPerilaku == null) {
                    String simpanPerilaku = new GoIndex().getInsertPerilaku(_nip, _Pelayanan, _Integritas, _Komitmen, _Disiplin, _Kerjasama, _Kepemimpinan, _jumlah, _ratarata, _Penilaian);
                } else {
                    String updatePerilaku = new GoIndex().getUpdatePerilaku(_nip, _Pelayanan, _Integritas, _Komitmen, _Disiplin, _Kerjasama, _Kepemimpinan, _jumlah, _ratarata, _Penilaian);
                }

                List<nilaiPerilaku> prilakumu = new GoIndex().getPerilakuAllList(_nip);
                request.setAttribute("prilakumu", prilakumu);

                String idNipTambahan = _nip;
                PnsSkp pns = new GoIndex().getPns(idNipTambahan);
                String iUnorTambahan = pns.getDiAtasanId();
                String jnsjabtn = pns.getjnsjbtn_id();

                PnsSkp pns40 = new GoIndex().getUnorAtasan(iUnorTambahan);
                String nipAtasanInput = pns40.getNipBaru();
                request.setAttribute("nipAtasan", nipAtasanInput);

                System.out.println("idunor = " + iUnorTambahan);
                //List<pnsskp_strukturalbkn> pnsList = new GoIndex().getTugasTambahanBawahanList(iUnorTambahan);
                List<PnsSkp> pnsList = new GoIndex().getTugasTambahanBawahanList2(iUnorTambahan);
                request.setAttribute("pnsList", pnsList);
                request.setAttribute("isJab", jnsjabtn);
                request.setAttribute("jenis", jnsjabtn);

                PnsSkp nipnama = new GoIndex().getLihatNipNama(_nip);
                String nip = nipnama.getNipBaru();
                String nama = nipnama.getNamaPns();
                request.setAttribute("nip", nip);
                request.setAttribute("nama", nama);

                request.setAttribute("nip", _nip);
                request.setAttribute("Penilaian", _Penilaian);
                request.setAttribute("Pelayanan", _Pelayanan);
                request.setAttribute("Integritas", _Integritas);
                request.setAttribute("Komitmen", _Komitmen);
                request.setAttribute("Disiplin", _Disiplin);
                request.setAttribute("Kerjasama", _Kerjasama);
                request.setAttribute("Kepemimpinan", _Kepemimpinan);
                request.setAttribute("jumlah", _jumlah);
                request.setAttribute("ratarata", _ratarata);

                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/indexPerilaku.jsp");
                dis.forward(request, response);

            } else if (param.equalsIgnoreCase("LIHAT")) {
                //************************************************************
//                String _nip = request.getParameter("nippns");
//                
//                List<nilaiPerilaku> prilakumu = new GoIndex().getPerilakuAllList(_nip);
//                request.setAttribute("prilakumu", prilakumu); 
//                
//                RequestDispatcher dis = request.getRequestDispatcher("indexPerilaku.jsp");
//                dis.forward(request, response);


                //*******************************************************************
                String niplihat = request.getParameter("nippns");

                String idNipTambahan = niplihat;
                PnsSkp pns = new GoIndex().getPns(idNipTambahan);
                String iUnorTambahan = pns.getDiAtasanId();
                String jnsjabtn = pns.getjnsjbtn_id();
                PnsSkp pns40 = new GoIndex().getUnorAtasan(iUnorTambahan);

                String nipAtasanInput = pns40.getNipBaru();
                request.setAttribute("nipAtasan", nipAtasanInput);
                System.out.println("idunor = " + iUnorTambahan);
                //List<pnsskp_strukturalbkn> pnsList = new GoIndex().getTugasTambahanBawahanList(iUnorTambahan);
                List<PnsSkp> pnsList = new GoIndex().getTugasTambahanBawahanList2(iUnorTambahan);

                request.setAttribute("pnsList", pnsList);
                request.setAttribute("jenis", jnsjabtn);
                request.setAttribute("isJab", jnsjabtn);
                nilaiPerilaku nilaiPrilak = new GoIndex().getPrilaku(niplihat);

                if (nilaiPrilak != null) {
                    String _nip = nilaiPrilak.getNIPPNS();
                    String _Penilaian = nilaiPrilak.getPeriode();
                    String _Pelayanan = nilaiPrilak.getPelayanan();
                    String _Integritas = nilaiPrilak.getIntegritas();
                    String _Komitmen = nilaiPrilak.getKomitmen();
                    String _Disiplin = nilaiPrilak.getDisiplin();
                    String _Kerjasama = nilaiPrilak.getKerjasama();
                    String _Kepemimpinan = nilaiPrilak.getKepemimpinan();
                    String _jumlah = nilaiPrilak.getJumlah();
                    String _ratarata = nilaiPrilak.getRatarata();

                    PnsSkp pns1 = new GoIndex().getPns(niplihat);

                    String _nama = pns1.getNamaPns();

                    request.setAttribute("nip", _nip);
                    request.setAttribute("Penilaian", _Penilaian);
                    request.setAttribute("Pelayanan", _Pelayanan);
                    request.setAttribute("Integritas", _Integritas);
                    request.setAttribute("Komitmen", _Komitmen);
                    request.setAttribute("Disiplin", _Disiplin);
                    request.setAttribute("Kerjasama", _Kerjasama);
                    request.setAttribute("Kepemimpinan", _Kepemimpinan);
                    request.setAttribute("jumlah", _jumlah);
                    request.setAttribute("ratarata", _ratarata);
                    request.setAttribute("nama", _nama);

                    RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/indexPerilaku.jsp");
                    dis.forward(request, response);
                } else {
                    String idNipTambahan1 = niplihat;
                    PnsSkp pns2 = new GoIndex().getPns(idNipTambahan1);
                    String iUnorTambahan1 = pns2.getDiAtasanId();
                    System.out.println("idunor = " + iUnorTambahan);
                    //List<pnsskp_strukturalbkn> pnsList1 = new GoIndex().getTugasTambahanBawahanList(iUnorTambahan1);
                    List<PnsSkp> pnsList1 = new GoIndex().getTugasTambahanBawahanList2(iUnorTambahan);
                    request.setAttribute("pnsList", pnsList1);


                    PnsSkp nipnama = new GoIndex().getLihatNipNama(niplihat);
                    String nip = nipnama.getNipBaru();
                    String nama = nipnama.getNamaPns();
                    request.setAttribute("nip", nip);
                    request.setAttribute("nama", nama);

                    RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/indexPerilaku.jsp");
                    dis.forward(request, response);
                }

            } else if (param.equalsIgnoreCase("BATAL")) {
                String nip = request.getParameter("nippns");

                nilaiPerilaku nilaiPrilak = new GoIndex().getPrilaku(nip);

                String _nip = nilaiPrilak.getNIPPNS();
                String _Penilaian = nilaiPrilak.getPeriode();
                String _Pelayanan = nilaiPrilak.getPelayanan();
                String _Integritas = nilaiPrilak.getIntegritas();
                String _Komitmen = nilaiPrilak.getKomitmen();
                String _Disiplin = nilaiPrilak.getDisiplin();
                String _Kerjasama = nilaiPrilak.getKerjasama();
                String _Kepemimpinan = nilaiPrilak.getKepemimpinan();
                String _jumlah = nilaiPrilak.getJumlah();
                String _ratarata = nilaiPrilak.getRatarata();

                PnsSkp pns = new GoIndex().getPns(nip);
                String jnsjabtn = pns.getjnsjbtn_id();
                String iUnorTambahan = pns.getDiAtasanId();

                PnsSkp pns40 = new GoIndex().getUnorAtasan(iUnorTambahan);
                String nipAtasanInput = pns40.getNipBaru();
                request.setAttribute("nipAtasan", nipAtasanInput);

                String _nama = pns.getNamaPns();

                request.setAttribute("nip", _nip);
                request.setAttribute("Penilaian", _Penilaian);
                request.setAttribute("Pelayanan", _Pelayanan);
                request.setAttribute("Integritas", _Integritas);
                request.setAttribute("Komitmen", _Komitmen);
                request.setAttribute("Disiplin", _Disiplin);
                request.setAttribute("Kerjasama", _Kerjasama);
                request.setAttribute("Kepemimpinan", _Kepemimpinan);
                request.setAttribute("jumlah", _jumlah);
                request.setAttribute("ratarata", _ratarata);
                request.setAttribute("nama", _nama);

                String idNipTambahan = nip;
                PnsSkp pns3 = new GoIndex().getPns(idNipTambahan);
                iUnorTambahan = pns3.getDiAtasanId();
                System.out.println("idunor = " + iUnorTambahan);
                //List<pnsskp_strukturalbkn> pnsList = new GoIndex().getTugasTambahanBawahanList(iUnorTambahan);
                List<PnsSkp> pnsList = new GoIndex().getTugasTambahanBawahanList2(iUnorTambahan);

                request.setAttribute("pnsList", pnsList);
                request.setAttribute("jenis", jnsjabtn);
                request.setAttribute("isJab", jnsjabtn);

                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/indexPerilaku.jsp");
                dis.forward(request, response);
            } else if (param.equalsIgnoreCase("KEMBALI")) {
                RequestDispatcher dis = getServletContext().getRequestDispatcher("/GetPnsServlet?etst=test");
                dis.forward(request, response);
            } //            else if(param.equalsIgnoreCase("SELESAI"))
            //            {
            //                RequestDispatcher dis = getServletContext().getRequestDispatcher("/GetPnsServlet?etst=test");        
            //                dis.forward(request, response);
            //                //location = 'GetPnsServlet?txtNIPBaruReal=<c:out value="${pnsp.getNipBaru()}"/>';
            //            }
            else if (param.equalsIgnoreCase("SIMPAN_KOEF")) {
                String idTam = request.getParameter("idTambahanText");

            } else if (param.equalsIgnoreCase("REKOMENDASI")) {
                String _nip = request.getParameter("nippns");
                String _periode = request.getParameter("Penilaian");
                String _nipA = request.getParameter("nipAtasan");

                String _Rekomendasi = request.getParameter("textarea1");

                //getRekomendasiPns
                String simpanRekomendasi = new GoIndex().getRekomendasiPns(_nip, _nipA, _periode, _Rekomendasi);


                String idNipTambahan = _nip;
                PnsSkp pns = new GoIndex().getPns(idNipTambahan);
                String iUnorTambahan = pns.getDiAtasanId();

                System.out.println("idunor = " + iUnorTambahan);
                //List<pnsskp_strukturalbkn> pnsList = new GoIndex().getTugasTambahanBawahanList(iUnorTambahan);
                List<PnsSkp> pnsList = new GoIndex().getTugasTambahanBawahanList2(iUnorTambahan);
                request.setAttribute("pnsList", pnsList);

                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/indexPerilaku.jsp");
                dis.forward(request, response);

            } //            else if(param.equalsIgnoreCase("HITUNG"))
            //            {
            //                String nilai = request.getParameter("koef_kreatifitas");
            //                
            //                if ("-".equals(nilai))
            //                {
            //                    
            //                }
            //                else if (!"-".equals(nilai))
            //                {
            //                    int i_nilai = Integer.parseInt(nilai);
            //                    
            //                }
            //                else
            //                {
            //                    
            //                }
            //                    
            //            }
            else {
            }
        } else if (Submit != null) {
            if (Submit.equalsIgnoreCase("SIMPAN")) {

                String _Id_tupoksir = request.getParameter("Id_tupoksi");
                String _biayar = request.getParameter("biayaRtext");
                String _kuantitasRtext = request.getParameter("kuantitasRtext");
                String _kualitasr = request.getParameter("kualitasRtext");
                String _waktur = request.getParameter("waktuRtext");
                String _nipAtasan = request.getParameter("nipAtasan");
                String _nipsendiri = request.getParameter("nipsendiri");
                String _thn_sesion = request.getParameter("thn_sesion");

                tupoksi_lama tupoksiv = new GoIndex().getIdtupoksi(_Id_tupoksir);
                int t_ikuantitas4 = 0;
                if (!"-".equals(_kuantitasRtext) || !" ".equals(_kuantitasRtext) || !"".equals(_kuantitasRtext) || _kuantitasRtext != null) {
                    t_ikuantitas4 = Integer.parseInt(_kuantitasRtext);
                } else {
                    t_ikuantitas4 = 0;
                }
                String _angkakrdt4t = tupoksiv.getangka_krdt();

                if (tupoksiv.getangka_krdt() == null) {
                    _angkakrdt4t = "0";
                }
                if (!"-".equals(_angkakrdt4t) || !" ".equals(_angkakrdt4t) || !"".equals(_angkakrdt4t) || _angkakrdt4t != null) {


                    if (_angkakrdt4t.equals("0") || _angkakrdt4t.equals("")) {
                        _angkakrdt4t = "";
                    } else {
                        //double nR = java.lang.Double.parseDouble(_angkakrdt4t);
                        float nR = Float.parseFloat(_angkakrdt4t);
                        //   String counter = java.lang.Integer.toString(i); 
                        nR = nR * t_ikuantitas4;
                        DecimalFormat formatterR = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
                        formatterR.setMaximumFractionDigits(4);
                        String nilaibiR = formatterR.format(nR);
                        _angkakrdt4t = nilaibiR.toString();
                    }
                }
                String _realisasi = new GoIndex().getsimpanRealisasi(_nipsendiri, _Id_tupoksir, _kuantitasRtext, _kualitasr, _waktur, _biayar, _angkakrdt4t, _thn_sesion);

                String xidTupoksi = request.getParameter("idTupoksi");
                String nip = request.getParameter("nipnilai");
                RealisasiIsi4faktorTupoksi hitungannya = new GoIndex().getFormatPenghitunganIsi4FaktorBusiness(_Id_tupoksir, _nipsendiri);
                String penghitungan = hitungannya.getPenghitungan();
                String nilaicapaian = hitungannya.getNilai_capaian_skp();

                String _hitungan = new GoIndex().getsimpanHitungRealisasi(_nipsendiri, _Id_tupoksir, penghitungan, nilaicapaian);

                ModelLocatorSKP.arraypGcavernip = new ArrayList<String>();
                String idNipTambahan = _nipAtasan;
                PnsSkp pns = new GoIndex().getPns(idNipTambahan);

                String iUnorTambahan = pns.getUnorId();
                //List<pnsskp_strukturalbkn> pnsList = new GoIndex().getTugasTambahanBawahanList(iUnorTambahan);
                //  List<pnsskp> pnsList = new GoIndex().getTugasTambahanBawahanList2(iUnorTambahan);
                List<PnsSkp> pnsList = new GoIndex().getTugasTambahanBawahanListALL(iUnorTambahan);
                PnsSkp ipns = null;
                List<PnsSkp> pnsBawahan = new ArrayList<PnsSkp>();
                List<PnsSkp> pnsBawahan2 = new ArrayList<PnsSkp>();
                List<PnsSkp> pnsBawahan3 = new ArrayList<PnsSkp>();
                List<PnsSkp> pnsBawahan4 = new ArrayList<PnsSkp>();
                for (PnsSkp ipns3 : pnsList) {
                    ipns = new PnsSkp();
                    if (ipns3.getLevel().equals("1")) {
                        pnsBawahan.add(ipns3);
                    } else if (ipns3.getLevel().equals("2")) {
                        pnsBawahan2.add(ipns3);
                    } else if (ipns3.getLevel().equals("3")) {
                        pnsBawahan3.add(ipns3);
                    } else if (ipns3.getLevel().equals("4")) {
                        pnsBawahan4.add(ipns3);
                    }
                }
                request.setAttribute("pnsBawahan", pnsBawahan);
                request.setAttribute("pnsBawahan2", pnsBawahan2);
                request.setAttribute("pnsBawahan3", pnsBawahan3);
                request.setAttribute("pnsBawahan4", pnsBawahan4);

                request.setAttribute("pnsList", pnsList);
                request.setAttribute("pns", pns);

                request.setAttribute("nipAtasan", idNipTambahan);

                String id = _nipsendiri;

                List<TugasTambahan> tugasTambahans = new GoIndex().getTugasTambahanList(id);
                request.setAttribute("tugasTambahans", tugasTambahans);

                List<TugasTambahan> kereaktifitas = new GoIndex().getKreatifitasList(id);
                request.setAttribute("kereaktifitas", kereaktifitas);
                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/monitoring.jsp");
                dis.forward(request, response);

            }


        } else if (NamaDicari != null || NipDicari != null) {

            //   String idNipTambahan = nipAtasan;
            String pencarian = "";
            String kriteria = "";
            if (!NamaDicari.equals("")) {
                pencarian = NamaDicari;
                kriteria = "nama";
            } else if (!NipDicari.equals("")) {
                pencarian = NipDicari;
                kriteria = "nip";
            }

            PnsSkp pns = new GoIndex().getPns(NipBaruAtasan);

            String iUnorTambahan = pns.getUnorId();
            //List<pnsskp_strukturalbkn> pnsList = new GoIndex().getTugasTambahanBawahanList(iUnorTambahan);
            List<PnsSkp> pnsAnakBuahList = new GoIndex().getPNSbawahan(iUnorTambahan, pencarian, kriteria);
            if (!pnsAnakBuahList.equals(null)) {
                request.setAttribute("pnsList", pnsAnakBuahList);
            }

//           PnsSkp nipatasan = new GoIndex().getUnorAtasan(iUnorTambahan);
//            String nipAtasan123 = nipatasan.getNipBaru();

            request.setAttribute("nipAtasan", NipBaruAtasan);

//            List<TugasTambahan> tugasTambahans = new GoIndex().getTugasTambahanList(idNipTambahan);
//            request.setAttribute("tugasTambahans", tugasTambahans);
//            
//            List<TugasTambahan> kereaktifitas = new GoIndex().getKreatifitasList(idNipTambahan);
//            request.setAttribute("kereaktifitas", kereaktifitas);

            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/nilaiTugasTambahan.jsp");
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
