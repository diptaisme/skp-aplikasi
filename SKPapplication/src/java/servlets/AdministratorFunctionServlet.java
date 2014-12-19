/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.GoIndex;
import model.loginweb;
import model.PnsSkp;
import model.TupoksiKeIsi4Faktor;
import model.unorskp;
import model.loginweb;
/**
 *
 * @author diptaisme
 */
public class AdministratorFunctionServlet extends HttpServlet {

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
            out.println("<title>Servlet administratorFunctionServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet administratorFunctionServlet at " + request.getContextPath() + "</h1>");
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
        String nip_ubah = request.getParameter("nip_ubah");
        String nip = request.getParameter("nip_ubah");
        String status = request.getParameter("status");
        String kewenangan = request.getParameter("kewenangan");
        if(status.equalsIgnoreCase("masuk"))
        {
            String namauser = ""; 
            String userkewenagan = ""; 
            String status1 = new GoIndex().getdeletekewenagan(nip_ubah, kewenangan);
            PnsSkp pns = new GoIndex().getPns(nip_ubah);
            List<loginweb> kewenaganuser = new ArrayList<loginweb>();
            kewenaganuser = new GoIndex().getKewengan(nip_ubah);
            loginweb ambiluser = new GoIndex().getSudahAdaUser(nip_ubah);
            namauser = ambiluser.getusername_login();
            if(namauser != null && !namauser.equals("null"))
            {
                userkewenagan = "ada";
                namauser = "";
            }
            else
            {
               namauser = ""; 
               kewenaganuser = null;
            }
            request.setAttribute("pns", pns);
            request.setAttribute("kewenaganuser", kewenaganuser);
            request.setAttribute("userkewenagan", userkewenagan);
            request.setAttribute("namauser", namauser);
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/manajemenUser.jsp");
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
        String param = request.getParameter("param");

        if (param.equalsIgnoreCase("AMBIL")) {
            String namauser = null;
             String kewenaganuser1 = null;
            String nipUsername="";
            String nip = request.getParameter("nipbaru");
            String userkewenagan = null;
            List<loginweb> kewenaganuser = new ArrayList<loginweb>();
            PnsSkp pns = new GoIndex().getPns(nip);
            kewenaganuser = new GoIndex().getKewengan(nip);
            int jjk = kewenaganuser.size();
            if(jjk == 0)
            {
                namauser = "null";
            }
            else
            {
               new GoIndex().getSudahAdaUser(nip);
               loginweb ambiluser = new GoIndex().getSudahAdaUser(nip);
               namauser = ambiluser.getusername_login();
                kewenaganuser1 = ambiluser.getkewenangan_login();
               //nipUsername = ambiluser.getusername_login();
            }
            
            if(namauser != null && !namauser.equals("null"))
            {
                userkewenagan = "ada";
                namauser = "";
            }
            else
            {
               namauser = ""; 
               kewenaganuser = null;
            }
            
            loginweb hasUser = new GoIndex().getSudahAdaUser(nip);
            if (hasUser != null){
                nipUsername = hasUser.getusername_login();
            }
            request.setAttribute("nipUsername", nipUsername);
            request.setAttribute("nip", nip);
            request.setAttribute("pns", pns);
            request.setAttribute("kewenaganuser", kewenaganuser);
            request.setAttribute("userkewenagan", userkewenagan);
            request.setAttribute("kewenaganuser1", kewenaganuser1);
            request.setAttribute("namauser", namauser);
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/manajemenUser.jsp");
            dis.forward(request, response);
        } 
        
        else if (param.equalsIgnoreCase("Simpan")) {
            RequestDispatcher dis = null;
            PnsSkp pns = new PnsSkp();
            String nipbaru = request.getParameter("getNipBaruPns");
            String usernamebaru = request.getParameter("usernameinputan");
            String passwordbaru = request.getParameter("passwordinputan");
            String kewenanganuser1 = request.getParameter("kewenanganuser1");
            String apakah;
            
            if (!"-".equals(kewenanganuser1)) {
                loginweb getSudahAdaUser = new GoIndex().getSudahAdaUser(nipbaru);
                if (getSudahAdaUser == null) {
                    apakah = "simpan";
                    String masukLogin = new GoIndex().getSimpanLogin(usernamebaru, passwordbaru, kewenanganuser1, nipbaru, apakah);
                    pns = new GoIndex().getPns(ModelLocatorSKP.loginNipPengguna);
                } else {
                    apakah = "ubah";
                    String updateLogin = new GoIndex().getSimpanLogin(usernamebaru, passwordbaru, kewenanganuser1, nipbaru, apakah);
                    pns = new GoIndex().getPns(ModelLocatorSKP.loginNipPengguna);
                }



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
                    request.setAttribute("nipbaru", nipbaru);
                    
                    request.setAttribute("UnorAts", UnorAts);
                    request.setAttribute("tukesiServlet", tukesiServlet);
                    request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
                    String prevPage = "";
                    request.setAttribute("prevPage", "AdmUser.simpan");
                    dis = request.getRequestDispatcher("/WEB-INF/jsp/navigasiPenggunadat_1.jsp");
                    dis.forward(request, response);

                }



            } else {
            }

        } else if (param.equalsIgnoreCase("Kembali")) {
            PnsSkp pns = new PnsSkp();
            pns = new GoIndex().getPns(ModelLocatorSKP.loginNipPengguna);
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
                     RequestDispatcher dis = null;
                    request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
                    dis = request.getRequestDispatcher("/WEB-INF/jsp/navigasiPenggunadat.jsp");
                    dis.forward(request, response);

                }
        } else if (param.equalsIgnoreCase("ubah")) {
            String nipygmaudibuatlogin = request.getParameter("getNipBaruPns");
            loginweb getSudahAdaUser = new GoIndex().getSudahAdaUser(nipygmaudibuatlogin);
            String username = getSudahAdaUser.getusername_login();
            String password = getSudahAdaUser.getpassword_login();
            request.setAttribute("nip", nipygmaudibuatlogin);
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/ManajemenUserTambahUbah.jsp");
            dis.forward(request, response);
        } 
        
        else if (param == null) {
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
