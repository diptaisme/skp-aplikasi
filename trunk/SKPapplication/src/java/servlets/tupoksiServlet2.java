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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.GoIndex;
import model.TupoksiKeIsi4Faktor;
import model.UnorKeTupoksi;
import model.instansiri;
import model.jabfum;
import model.jabfung;
import model.kelompokJabatan;
import model.PnsSkp;
import model.isi4faktor;
import model.tupoksi_lama;
import model.tupoksi;

/**
 *
 * @author asus-U46E
 */
@WebServlet(name = "tupoksiServlet2", urlPatterns = {"/tupoksiServlet2"})
public class tupoksiServlet2 extends HttpServlet {

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
            /* TODO output your page here
             out.println("<html>");
             out.println("<head>");
             out.println("<title>Servlet tupoksiServlet2</title>");  
             out.println("</head>");
             out.println("<body>");
             out.println("<h1>Servlet tupoksiServlet2 at " + request.getContextPath () + "</h1>");
             out.println("</body>");
             out.println("</html>");
             */
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
        String id = request.getParameter("txtNIPBaru"); //ambil NIPBARU dari lemparan hiperlink index.jsp (parameter : txtNIPBaru)
        String idTB = request.getParameter("txtNIPBaruTB");
        String nipKelokpokKriteria = request.getParameter("nipKelokpokKriteria");
        String namaKelompok = request.getParameter("namaKelompok");
        String test = request.getParameter("test");
        String jenis = request.getParameter("jenis");
        String sesiontahun = request.getParameter("sesiontahun");
        if (id != null && id != "" && id != " ") {
            //domain PnsSkp
            PnsSkp pns = new GoIndex().getPns(id); //ambil data dari tabel pns (semuanya), ke business (goindex) lalu ke dao (ada where = id (nipbaru))
            String unorAtasan = pns.getDiAtasanId(); //ambil satu2 dari "pns" diatas
            String UnorPns = pns.getUnorId();
            String InstansiPns = pns.getInstansiId();
            String NipPns = pns.getNipBaru();
            String Jenis = pns.getjnsjbtn_id();
            String JabFung = pns.getJabatanUmumId();
            String Jabatan;
            if (Jenis.equals("1")) {
                Jabatan = null;
            } else if (Jenis.equals("2")) {
                Jabatan = pns.getJabatanFungsionalId();
            } else if (Jenis.equals("4")) {
                Jabatan = pns.getJabatanUmumId();
            } else {
                Jabatan = null;
            }

            //PnsSkp UnorAts = new GoIndex().getUnorAtasan(unorAtasan); //ambil gelondongan    
            PnsSkp UnorAts = null;
            if (ModelLocatorSKP.nipBaruAtasan == null || ModelLocatorSKP.nipBaruAtasan.equals("") || ModelLocatorSKP.nipBaruAtasan.equals(" ")) {
                UnorAts = new GoIndex().getUnorAtasan(unorAtasan);
            } else {

                UnorAts = new GoIndex().getPns(ModelLocatorSKP.nipBaruAtasan);
            }
            //List<tupoksi2> tukesiServlet = new GoIndex().getTukesiPerJenisJabatan(UnorPns, InstansiPns, NipPns, Jenis, Jabatan);

            List<tupoksi> tukesiServlet = new GoIndex().getTukesiPerJenisJabatan(UnorPns, InstansiPns, NipPns, Jenis, Jabatan);

            //baru 22022012
            instansiri ins = new GoIndex().getInstansi(InstansiPns);
            String NamaInstansi = ins.getNamaInstansi();

            //baru 22022012 -- untuk list
            //String insA = request.getParameter("instansiA");
            //String unoA = request.getParameter("unorA");
            List<UnorKeTupoksi> unosiServlet = new GoIndex().getUnosi2(UnorPns, InstansiPns, NipPns, Jenis, Jabatan);
            if (Jenis.equals("2")) {
                jabfung kelompok = new GoIndex().getJabatanFungsional(Jabatan);
                String kelompoks = kelompok.getkelJabatanId();
                List<jabfung> lisJabfung = new GoIndex().getSatuRumpunFungsional(kelompoks);
                request.setAttribute("lisJabfung", lisJabfung);
            } else if (Jenis.equals("4")) {
                jabfum kelompok = new GoIndex().getJabatanUmum(Jabatan);
                String kelompoks = kelompok.getId();
                List<jabfum> lisJabfung = new GoIndex().getRumpunUmumById(Jabatan);
                request.setAttribute("lisJabfung", lisJabfung);
            }

            //  List<kelompokJabatan> lisKelompok =  new GoIndex().getSatuRumpun(kelompoks);

            request.setAttribute("pns", pns);
            request.setAttribute("UnorAts", UnorAts);





//           request.setAttribute("lisJabfung", lisJabfung);


            request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);
            request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
            if (!sesiontahun.equalsIgnoreCase("") && sesiontahun != null) {
                request.setAttribute("tukesiServlet", tukesiServlet);
                request.setAttribute("ins", ins);
                request.setAttribute("unosiServlet", unosiServlet);
                request.setAttribute("jabatan", jenis);
                request.setAttribute("sesiontahun", sesiontahun);
                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/tupoksiBaru2.jsp");
                dis.forward(request, response);
            } else {
                tukesiServlet = null;
                request.setAttribute("tukesiServlet", tukesiServlet);
                RequestDispatcher dis = null;
                dis = request.getRequestDispatcher("/WEB-INF/jsp/navigasiPenggunadat.jsp");
                dis.forward(request, response);
            }
            // dis = request.getRequestDispatcher("/WEB-INF/jsp/navigasiPenggunadat.jsp");



        } else if (nipKelokpokKriteria != null) {
            PnsSkp pns = new GoIndex().getPns(nipKelokpokKriteria); //ambil data dari tabel pns (semuanya), ke business (goindex) lalu ke dao (ada where = id (nipbaru))
            String unorAtasan = pns.getDiAtasanId(); //ambil satu2 dari "pns" diatas
            String UnorPns = pns.getUnorId();
            String InstansiPns = pns.getInstansiId();
            String NipPns = pns.getNipBaru();

            //PnsSkp UnorAts = new GoIndex().getUnorAtasan(unorAtasan); //ambil gelondongan    
            PnsSkp UnorAts = null;
            if (ModelLocatorSKP.nipBaruAtasan == null || ModelLocatorSKP.nipBaruAtasan.equals("") || ModelLocatorSKP.nipBaruAtasan.equals(" ")) {
                UnorAts = new GoIndex().getUnorAtasan(unorAtasan);
            } else {

                UnorAts = new GoIndex().getPns(ModelLocatorSKP.nipBaruAtasan);
            }
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
            request.setAttribute("namaKelompok", namaKelompok);

            //RequestDispatcher dis=request.getRequestDispatcher("tupoksi.jsp");
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/tupoksiBaru.jsp");
            dis.forward(request, response);
        } else if ((id == null || id == "" || id == " ") && (idTB == null || idTB == "" || idTB == " ")) {
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/indexBaruBiru2.jsp");
            dis.forward(request, response);
        } else if (idTB != null && idTB != "" && idTB != " ") {
            String pilih_session = request.getParameter("pilih_session");
            PnsSkp pns = new GoIndex().getPns(idTB);
            String idNip = pns.getNipBaru();
            String namaPns = pns.getNamaPns();
            request.setAttribute("namaPns", namaPns);
            request.setAttribute("idNip", idNip);
            request.setAttribute("sesiontahun", pilih_session);

            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/TugasTambahan.jsp");
            dis.forward(request, response);
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
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String cariKriteria = request.getParameter("cariKriteria");
        String cariKriteriaKlTgs = request.getParameter("cariKriteriaKlTgs");
        String submitCari = request.getParameter("submitCari");
        String id = request.getParameter("idnipText"); //ambil NIPBARU dari lemparan hiperlink index.jsp (parameter : txtNIPBaru)
        String idTB = request.getParameter("txtNIPBaruTB");
        String[] favoritetupoksis = request.getParameterValues("tupoksipaporit");
        String sesiontahun = request.getParameter("sesiontahun");

        if (submitCari.equalsIgnoreCase("CARI")) {
            if (cariKriteria != null && cariKriteria != "" && cariKriteria != " " || cariKriteria.equals("")) {
                PnsSkp pns = new GoIndex().getPns(id); //ambil data dari tabel pns (semuanya), ke business (goindex) lalu ke dao (ada where = id (nipbaru))
                String unorAtasan = pns.getDiAtasanId(); //ambil satu2 dari "pns" diatas
                String UnorPns = pns.getUnorId();
                String InstansiPns = pns.getInstansiId();
                String NipPns = pns.getNipBaru();

                //PnsSkp UnorAts = new GoIndex().getUnorAtasan(unorAtasan); //ambil gelondongan    
                PnsSkp UnorAts = null;
                if (ModelLocatorSKP.nipBaruAtasan == null || ModelLocatorSKP.nipBaruAtasan.equals("") || ModelLocatorSKP.nipBaruAtasan.equals(" ")) {
                    UnorAts = new GoIndex().getUnorAtasan(unorAtasan);
                } else {

                    UnorAts = new GoIndex().getPns(ModelLocatorSKP.nipBaruAtasan);
                }
                List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);

                instansiri ins = new GoIndex().getInstansi(InstansiPns);
                String NamaInstansi = ins.getNamaInstansi();

                List<UnorKeTupoksi> unosiServlet = new GoIndex().getSamaLikeTupoksi(cariKriteriaKlTgs, cariKriteria);

                request.setAttribute("pns", pns);
                request.setAttribute("UnorAts", UnorAts);
                request.setAttribute("ins", ins);

                request.setAttribute("tukesiServlet", tukesiServlet);
                request.setAttribute("unosiServlet", unosiServlet);

                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/tupoksiBaru.jsp");
                dis.forward(request, response);
            } else if ((id == null || id == "" || id == " ") && (idTB == null || idTB == "" || idTB == " ")) {
                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/indexBaruBiru2.jsp");
                dis.forward(request, response);
            } else if (idTB != null && idTB != "" && idTB != " ") {
                PnsSkp pns = new GoIndex().getPns(idTB);
                String idNip = pns.getNipBaru();
                String namaPns = pns.getNamaPns();
                request.setAttribute("namaPns", namaPns);
                request.setAttribute("idNip", idNip);

                RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/TugasTambahan.jsp");
                dis.forward(request, response);
            }
        } else if (submitCari.equalsIgnoreCase("CARIKLTGS")) {

            PnsSkp pns = new GoIndex().getPns(id); //ambil data dari tabel pns (semuanya), ke business (goindex) lalu ke dao (ada where = id (nipbaru))
            String unorAtasan = pns.getDiAtasanId(); //ambil satu2 dari "pns" diatas
            String UnorPns = pns.getUnorId();
            String InstansiPns = pns.getInstansiId();
            String NipPns = pns.getNipBaru();
            if (cariKriteriaKlTgs == null || cariKriteriaKlTgs.equals("")) {
                cariKriteriaKlTgs = " ";
            }
            //PnsSkp UnorAts = new GoIndex().getUnorAtasan(unorAtasan); //ambil gelondongan    
            PnsSkp UnorAts = null;
            if (ModelLocatorSKP.nipBaruAtasan == null || ModelLocatorSKP.nipBaruAtasan.equals("") || ModelLocatorSKP.nipBaruAtasan.equals(" ")) {
                UnorAts = new GoIndex().getUnorAtasan(unorAtasan);
            } else {

                UnorAts = new GoIndex().getPns(ModelLocatorSKP.nipBaruAtasan);
            }
            List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);

            instansiri ins = new GoIndex().getInstansi(InstansiPns);
            String NamaInstansi = ins.getNamaInstansi();

            List<tupoksi_lama> tupoksiServlets = new GoIndex().getSamaLikeKeLompokTupoksiIdAll(cariKriteriaKlTgs);

            request.setAttribute("pns", pns);
            request.setAttribute("UnorAts", UnorAts);
            request.setAttribute("ins", ins);

            request.setAttribute("tukesiServlet", tukesiServlet);
            request.setAttribute("tupoksiServlets", tupoksiServlets);

            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/tabelKelompokTugas.jsp");
            dis.forward(request, response);

        } else if (submitCari.equalsIgnoreCase("cariJabatan")) {
            String jabFungPilih = request.getParameter("jabfung");
            String nip = request.getParameter("txtNIPBaru");
            PnsSkp pns = new GoIndex().getPns(nip);

            String unorAtasan = pns.getDiAtasanId(); //ambil satu2 dari "pns" diatas
            String UnorPns = pns.getUnorId();
            String InstansiPns = pns.getInstansiId();
            String NipPns = pns.getNipBaru();
            String Jenis = pns.getjnsjbtn_id();
            String JabFung = pns.getJabatanUmumId();
            String Jabatan;
            if (Jenis.equals("1")) {
                Jabatan = null;
            } else if (Jenis.equals("2")) {
                Jabatan = pns.getJabatanFungsionalId();
            } else if (Jenis.equals("4")) {
                Jabatan = pns.getJabatanUmumId();
            } else {
                Jabatan = null;
            }

            //PnsSkp UnorAts = new GoIndex().getUnorAtasan(unorAtasan); //ambil gelondongan    
            PnsSkp UnorAts = null;
            if (ModelLocatorSKP.nipBaruAtasan == null || ModelLocatorSKP.nipBaruAtasan.equals("") || ModelLocatorSKP.nipBaruAtasan.equals(" ")) {
                UnorAts = new GoIndex().getUnorAtasan(unorAtasan);
            } else {

                UnorAts = new GoIndex().getPns(ModelLocatorSKP.nipBaruAtasan);
            }
            //List<tupoksi2> tukesiServlet = new GoIndex().getTukesiPerJenisJabatan(UnorPns, InstansiPns, NipPns, Jenis, Jabatan);
            List<tupoksi> tukesiServlet = new GoIndex().getTukesiPerJenisJabatan(UnorPns, InstansiPns, NipPns, Jenis, jabFungPilih);

            //baru 22022012
            instansiri ins = new GoIndex().getInstansi(InstansiPns);
            String NamaInstansi = ins.getNamaInstansi();

            //baru 22022012 -- untuk list
            //String insA = request.getParameter("instansiA");
            //String unoA = request.getParameter("unorA");
            List<UnorKeTupoksi> unosiServlet = new GoIndex().getUnosi2(UnorPns, InstansiPns, NipPns, Jenis, jabFungPilih);

            jabfung kelompok = new GoIndex().getJabatanFungsional(Jabatan);
            String kelompoks = kelompok.getkelJabatanId();
            //  List<kelompokJabatan> lisKelompok =  new GoIndex().getSatuRumpun(kelompoks);
            List<jabfung> lisJabfung = new GoIndex().getSatuRumpunFungsional(kelompoks);

            request.setAttribute("pns", pns);
            request.setAttribute("UnorAts", UnorAts);
            request.setAttribute("ins", ins);
            request.setAttribute("jabatan", Jenis);


            request.setAttribute("tukesiServlet", tukesiServlet);
            request.setAttribute("unosiServlet", unosiServlet);
            request.setAttribute("lisJabfung", lisJabfung);
            request.setAttribute("sesiontahun", sesiontahun);
            //RequestDispatcher dis=request.getRequestDispatcher("tupoksi.jsp");
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/tupoksiBaru2.jsp");
            dis.forward(request, response);



        } else if (submitCari.equalsIgnoreCase("SIMPAN")) {
            String jabFungPilih = request.getParameter("jabfung");

            PnsSkp pns = new GoIndex().getPns(id);
            String unorAtasan = pns.getDiAtasanId();
            String UnorPns = pns.getUnorId();
            String InstansiPns = pns.getInstansiId();
            String NipPns = pns.getNipBaru();

            String Jenis = pns.getjnsjbtn_id();
            String JabFung = pns.getJabatanUmumId();

            String Jabatan;
            if (Jenis.equals("1")) {
                Jabatan = null;
            } else if (Jenis.equals("2")) {
                Jabatan = pns.getJabatanFungsionalId();
            } else if (Jenis.equals("4")) {
                Jabatan = pns.getJabatanUmumId();
            } else {
                Jabatan = null;
            }

            PnsSkp UnorAts = null;
            if (ModelLocatorSKP.nipBaruAtasan == null || ModelLocatorSKP.nipBaruAtasan.equals("") || ModelLocatorSKP.nipBaruAtasan.equals(" ")) {
                UnorAts = new GoIndex().getUnorAtasan(unorAtasan);
            } else {

                UnorAts = new GoIndex().getPns(ModelLocatorSKP.nipBaruAtasan);
            }
            List<TupoksiKeIsi4Faktor> tukesiServlet = null;
            if (sesiontahun.equalsIgnoreCase("") && sesiontahun == null) {
                tukesiServlet = new GoIndex().getTukesiNonUnor(UnorPns, InstansiPns, NipPns);
            } else {
                tukesiServlet = new GoIndex().getTukesiSession(UnorPns, InstansiPns, NipPns, sesiontahun);
            }

            // List<tupoksi> tukesiServlet = new GoIndex().getTukesiPerJenisJabatan(UnorPns, InstansiPns, NipPns, Jenis, jabFungPilih);

            instansiri ins = new GoIndex().getInstansi(InstansiPns);
            String NamaInstansi = ins.getNamaInstansi();


            List<UnorKeTupoksi> unosiServlet = new GoIndex().getUnosi2(UnorPns, InstansiPns, NipPns, Jenis, jabFungPilih);

            jabfung kelompok = new GoIndex().getJabatanFungsional(Jabatan);
            String kelompoks = kelompok.getkelJabatanId();

            List<jabfung> lisJabfung = new GoIndex().getSatuRumpunFungsional(kelompoks);

            request.setAttribute("pns", pns);
            request.setAttribute("UnorAts", UnorAts);
            request.setAttribute("ins", ins);
            request.setAttribute("jabatan", Jenis);


            request.setAttribute("tukesiServlet", tukesiServlet);
            request.setAttribute("unosiServlet", unosiServlet);
            request.setAttribute("lisJabfung", lisJabfung);
            request.setAttribute("sesiontahun", sesiontahun);

            String _idIsi4Faktortext = "-";
            String _kuantitas4text = "-";
            String _kualitas4text = "-";
            String _waktu4text = "-";
            String _biaya4text = "-";

            String _realisasitext = "-";
            String _kuantitasRtext = "-";
            String _kualitasRtext = "-";
            String _waktuRtext = "-";
            String _biayaRtext = "-";
            String _penghitungan = "-";
            String _nilaiCapaian = "0";
            String _waktunya = "-";
            String _kuantitas_label = "-";
            String _waktu_label = "-";
            String _angkakrdt = " ";
            if(favoritetupoksis !=null){
            for (String s : favoritetupoksis) {
                isi4faktor banding = new GoIndex().getSamaNipDanTupoksi(NipPns, s, sesiontahun);

                if (banding == null) {
                    String _Isi4Faktor = new GoIndex().getInsertIsiEmpatFaktor(_idIsi4Faktortext, NipPns, UnorPns, s, _kuantitas4text, _kualitas4text, _waktu4text, _biaya4text, _kuantitas_label, _waktu_label, _realisasitext, _kuantitasRtext, _kualitasRtext, _waktuRtext, _biayaRtext, _penghitungan, _nilaiCapaian, _waktunya, _angkakrdt, sesiontahun);


                }
            }
            }

            //  request.setAttribute("NipPns", NipPns);
            request.setAttribute("sesiontahun", sesiontahun);

            request.setAttribute("pns", pns);
            request.setAttribute("UnorAts", UnorAts);
           // request.setAttribute("sesiontahun", sesiontahun);
            request.setAttribute("tukesiServlet", tukesiServlet);
            
            
          //    request.setAttribute("sesiontahun", _pilih_session);
            //                request.setAttribute("pns", pns);
            //                request.setAttribute("UnorAts", UnorAts);
            //                request.setAttribute("tukesiServlet", tukesiServlet);
            

            //kirim ke jsp lagi
            //RequestDispatcher dis = request.getRequestDispatcher("index.jsp");

            request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);
            request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);


          //  session.setAttribute("levelPemakaian", ModelLocatorSKP.levelUser);
          
        

            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/navigasiPenggunadat.jsp");
        
            dis.forward(request, response);
            
           // RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/tupoksiBaru2.jsp");
           // dis.forward(request, response);


        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
