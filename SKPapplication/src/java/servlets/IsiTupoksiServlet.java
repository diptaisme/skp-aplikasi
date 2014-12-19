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
import javax.servlet.http.HttpSession;
import model.*;

/**
 *
 * @author diptaisme
 */
public class IsiTupoksiServlet extends HttpServlet {

    PnsSkp pnsp;
    tupoksi_lama idTupoksi;

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
            out.println("<title>Servlet isiTupoksiServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet isiTupoksiServlet at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        String isCetak = request.getParameter("isCetak");
        
        //String nipbarupns = request.getParameter("nipnilai");
        //String idtupoksi = request.getParameter("idTupoksi");
        
        if (isCetak != null && isCetak.equalsIgnoreCase("true"))
        {
            insertData(request, response);
        }
        else
        {

            String id = request.getParameter("idnip");
            
            pnsp = new GoIndex().getPns(id);
            String _idInstansi = pnsp.getInstansiId();
            String _idunor = pnsp.getUnorId();
            String _namaUnor = pnsp.getNamaUnor();
            String _namaJabatan = pnsp.getNamaJabatan();

            unorskp unor = new GoIndex().getIdUnorskp(_idunor);
            String _idinstansi = unor.getInstansiId();
            String _idunorAtasan = unor.getDiAtasanId();

            idTupoksi = new GoIndex().getIdtupoksi(id);
            String _idTupoksi = idTupoksi.getIdTupoksi();
            String namaTupoksi = idTupoksi.getNamaTupoksi();

            request.setAttribute("_idTupoksi", _idTupoksi);
            request.setAttribute("namaTupoksi", namaTupoksi);

            RequestDispatcher dis = getServletContext().getRequestDispatcher("/ReportIsi4FaktorServlet?etst=test");
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
        //processRequest(request, response);
        insertData(request, response);

    }

    private void insertData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //29022012
        String _idIsi4Faktortext = "-";
        //String _nipPnstext = pnsp.getNipBaru();
        //String _idTupoksitext = idTupoksi.getIdTupoksi();
        String _nipPnstext = request.getParameter("nipnilai");
        String _idTupoksitext = request.getParameter("idTupoksi");
         String _UnorIdisert = request.getParameter("UnorIdisert");
         String sesiontahun = request.getParameter("sesiontahun");
        String _kuantitas4text = "-";
        String _kualitas4text = "-";
        String _waktu4text = "-";
        String _biaya4text = "-";
        //String _idTupoksi=P_idTupoksi;
        //String _kuantitas4text=request.getParameter("kuantitas4text");
        //String _kualitas4text=request.getParameter("kualitas4text");
        //String _waktu4text=request.getParameter("waktu4text");
        //String _biaya4text=request.getParameter("biaya4text");
        //String iNip_id=P_nipbaru;
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
        
        isi4faktor banding = new GoIndex().getSamaNipDanTupoksi(_nipPnstext, _idTupoksitext,sesiontahun);
        if (banding == null)
        {
            String _Isi4Faktor = new GoIndex().getInsertIsiEmpatFaktor(_idIsi4Faktortext, _nipPnstext, _UnorIdisert,_idTupoksitext, _kuantitas4text, _kualitas4text, _waktu4text, _biaya4text, _kuantitas_label, _waktu_label, _realisasitext, _kuantitasRtext, _kualitasRtext, _waktuRtext, _biayaRtext, _penghitungan, _nilaiCapaian, _waktunya,_angkakrdt,sesiontahun);
            //String _idIsi4Faktortext4realisasi = _idIsi4Faktortext;
            //String _realisasi = new GoIndex().getInsertRealisasi(_realisasitext, _idIsi4Faktortext, _nipPnstext, _idTupoksitext, _kuantitasRtext, _kualitasRtext, _waktuRtext, _biayaRtext, _penghitungan, _nilaiCapaian, _waktunya);
        
            request.setAttribute("NipPns", _nipPnstext);
            request.setAttribute("sesiontahun", sesiontahun);
            RequestDispatcher dis = request.getRequestDispatcher("/GetPnsServlet?nipnilai=nipnilai");
            //RequestDispatcher dis = request.getRequestDispatcher("/GetPnsServlet");
            PrintWriter out = response.getWriter();
            out.println(_Isi4Faktor);
            dis.include(request, response);
        
        }
        else
        {
            ///NOTIFIKASI BAHWA NIP INI SUDAH MEMILIH TUPOKSI YANG DIKLIK!
            String id = request.getParameter("nipnilai");
            
            //GetPnsServlet gps = new GetPnsServlet();
            //gps.getTusiDariIsiTupoksi(request, response);
            
            PnsSkp pns = new GoIndex().getPns(id);
            String unorAtasan = pns.getDiAtasanId();
            String UnorPns = pns.getUnorId();
            String InstansiPns = pns.getInstansiId();
            String NipPns = pns.getNipBaru();

            //PnsSkp UnorAts = new GoIndex().getUnorAtasan(unorAtasan);
            PnsSkp UnorAts = null;
                            if (ModelLocatorSKP.nipBaruAtasan == null || ModelLocatorSKP.nipBaruAtasan.equals("") || ModelLocatorSKP.nipBaruAtasan.equals(" ")) {
                                UnorAts = new GoIndex().getUnorAtasan(unorAtasan);
                            } else {
                                  
                                UnorAts = new GoIndex().getPns(ModelLocatorSKP.nipBaruAtasan);
                            }

            List<TupoksiKeIsi4Faktor> tukesiServlet = null;
           //Ubahan List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);
            if(sesiontahun.equalsIgnoreCase("") && sesiontahun == null)
            {
               tukesiServlet = new GoIndex().getTukesiNonUnor(UnorPns, InstansiPns, NipPns);
            }else
            {
                tukesiServlet = new GoIndex().getTukesiSession(UnorPns, InstansiPns, NipPns, sesiontahun);
            }
              

            request.setAttribute("pns", pns);
            request.setAttribute("UnorAts", UnorAts);
            request.setAttribute("sesiontahun", sesiontahun);
            request.setAttribute("tukesiServlet", tukesiServlet);

            //kirim ke jsp lagi
            //RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
            
              request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);
            request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
         RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/navigasiPenggunadat.jsp");
           // RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/indexBaruBiru2.jsp");
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
