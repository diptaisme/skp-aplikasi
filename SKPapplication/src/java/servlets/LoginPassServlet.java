/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DBProperties;
import model.GoIndex;
import model.TupoksiKeIsi4Faktor;
import model.loginweb;
import model.PnsSkp;
import model.unorskp;

/**
 *
 * @author diptaisme
 */
public class LoginPassServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        Properties properties = new Properties();
        try {
            properties.load(getServletContext().getResourceAsStream("/WEB-INF/application.properties"));
            DBProperties.DB_URL = properties.getProperty("db.url");
            DBProperties.DB_USERNAME = properties.getProperty("db.username");
            DBProperties.DB_PASSWORD = properties.getProperty("db.password");
            DBProperties.DB_DRIVER = properties.getProperty("db.driver");

        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(LoginPassServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
    }

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
            out.println("<title>Servlet loginPassServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loginPassServlet at " + request.getContextPath() + "</h1>");
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

        ModelLocatorSKP.navigasiPil = "0";
        RequestDispatcher dis = null;

        String user = request.getParameter("usernametext");
        String pass = request.getParameter("passwordtext");


        String username = "xxx";

        String param = request.getParameter("Submit");

        if (param != null) {

            if (param.equalsIgnoreCase("Batal")) {
                HttpSession session = request.getSession();

                if (session.getAttribute("user") != null) {
                    String test1 = (String) session.getAttribute("user");
                    session.removeAttribute("user");
                    //  session.removeAttribute("NipPnsSession");
                    //session.invalidate();
                }
                if (session.getAttribute("NipPnsSession") != null) {
                    //  String test1=(String) session.getAttribute("user");
                    // session.removeAttribute("user");
                    session.removeAttribute("NipPnsSession");
                    // session.invalidate();
                }
                session.invalidate();
                out.close();
            }

        }
        if ((user != null && !"".equals(user) && !" ".equals(user)) && (pass != null && !"".equals(pass) && !" ".equals(pass))) {
            loginweb log = new GoIndex().getLoginPass(user, pass);

            if (log == null) {
                dis = request.getRequestDispatcher("/WEB-INF/jsp/indexloginBaru.jsp");

                dis.include(request, response);
                out.close();
            } else {
                String kewenangan = log.getkewenangan_login();
                String nippns = log.getnippns_login();
                //
                //
                if (!nippns.equals(null)) {
                    if (kewenangan.equals("user")) {
                        getUserMasuk(request, response);
                        //dis = request.getRequestDispatcher("indexBaruBiru.jsp");
                        //dis.forward(request, response);
                    } else if (kewenangan.equals("operator")) {
                        getOperatorMasuk(request, response);
                        //dis = request.getRequestDispatcher("insertTupoksiBaruBiru.jsp");
                        //dis.forward(request, response);
                    } else if (kewenangan.equals("administrator")) {
                        HttpSession session = request.getSession();

                        user = request.getParameter("usernametext");
                        pass = request.getParameter("passwordtext");
                        log = new GoIndex().getLoginPass(user, pass);
                        String id = log.getnippns_login();

                        if (id != null && !"".equals(id) && !" ".equals(id)) {
                            PnsSkp pns = new GoIndex().getPns(id);

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
                                ModelLocatorSKP.loginNipsession = NipPns;
                                ModelLocatorSKP.nipBaruAtasan = NipPns;
                                ModelLocatorSKP.loginNipPengguna = NipPns;
                                ModelLocatorSKP.IdUnorUser = pns.getUnorId();
                                session.setAttribute("NipPnsSession", NipPns);
                                 session.setAttribute("levelPemakaian", ModelLocatorSKP.levelUser);
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

                                session.setAttribute("user", user);
                            }


                        }



                        ModelLocatorSKP.levelUser = "3";
                        ModelLocatorSKP.navigasiPil = "0";
                        String levelUser = ModelLocatorSKP.levelUser;


                        request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
                        request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);

                        //RequestDispatcher dis2 = getServletContext().getRequestDispatcher("/NavigasiProfile?etst=test");
                        // dis2.forward(request, response);



                        dis = request.getRequestDispatcher("/WEB-INF/jsp/navigasiPenggunadat.jsp");
                        dis.forward(request, response);

                        //  dis = request.getRequestDispatcher("/WEB-INF/jsp/manajemenUser.jsp");
                        // dis.forward(request, response);
                    } else if (kewenangan.equals("Perwakilan_user")) {
                        HttpSession session = request.getSession();
                        user = request.getParameter("usernametext");
                        pass = request.getParameter("passwordtext");
                        log = new GoIndex().getLoginPass(user, pass);
                        String id = log.getnippns_login();

                        if (id != null && !"".equals(id) && !" ".equals(id)) {
                            PnsSkp pns = new GoIndex().getPns(id);

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
                                ModelLocatorSKP.loginNipsession = NipPns;
                                ModelLocatorSKP.nipBaruAtasan = NipPns;
                                ModelLocatorSKP.loginNipPengguna = NipPns;
                                ModelLocatorSKP.IdUnorUser = pns.getUnorId();
                                session.setAttribute("NipPnsSession", NipPns);
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

                                session.setAttribute("user", user);
                            }


                        }

                        ModelLocatorSKP.levelUser = "2";
                        String levelUser = ModelLocatorSKP.levelUser;
                        ModelLocatorSKP.navigasiPil = "0";
                        session.setAttribute("levelPemakaian", ModelLocatorSKP.levelUser);

                        request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);
                        request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
                        dis = request.getRequestDispatcher("/WEB-INF/jsp/navigasiPenggunadat.jsp");
                        dis.forward(request, response);

                    } else {
                        dis = request.getRequestDispatcher("/WEB-INF/jsp/indexloginBaru.jsp");
                        out.println("LOGIN SALAH!!!");
                        dis.include(request, response);
                        out.close();
                    }

                } else {
                    dis = request.getRequestDispatcher("/WEB-INF/jsp/indexloginBaru.jsp");

                    dis.include(request, response);

                }
            }
        } else if ((user == null || "".equals(user) || " ".equals(user)) || (pass == null || "".equals(pass) || " ".equals(pass))) {
            dis = request.getRequestDispatcher("/WEB-INF/jsp/indexloginBaru.jsp");
            dis.forward(request, response);
        } else {
        }
    }

    private void getOperatorMasuk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String user = request.getParameter("usernametext");
        String pass = request.getParameter("passwordtext");
        loginweb log = new GoIndex().getLoginPass(user, pass);
        String id = log.getnippns_login();

        if (id != null && !"".equals(id) && !" ".equals(id)) {
            PnsSkp pns = new GoIndex().getPns(id);

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
                ModelLocatorSKP.loginNipsession = NipPns;
                ModelLocatorSKP.nipBaruAtasan = NipPns;
                ModelLocatorSKP.loginNipPengguna = NipPns;
                ModelLocatorSKP.IdUnorUser = pns.getUnorId();
                session.setAttribute("NipPnsSession", NipPns);
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

                session.setAttribute("user", user);
            }


        }

        ModelLocatorSKP.levelUser = "1";
        String levelUser = ModelLocatorSKP.levelUser;


        request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
session.setAttribute("levelPemakaian", ModelLocatorSKP.levelUser);

        RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/navigasiPenggunadat.jsp");
        dis.forward(request, response);

        //RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/insertTupoksiBaruBiru.jsp");
        // dis.forward(request, response);



    }

    private void getUserMasuk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user = request.getParameter("usernametext");
        String pass = request.getParameter("passwordtext");

        loginweb log = new GoIndex().getLoginPass(user, pass);
        String id = log.getnippns_login();

        if (id != null && !"".equals(id) && !" ".equals(id)) {
            PnsSkp pns = new GoIndex().getPns(id);

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
                ModelLocatorSKP.IdUnorUser = pns.getUnorId();
                session.setAttribute("NipPnsSession", NipPns);
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

                session.setAttribute("user", user);
            }

            //kirim ke jsp lagi
            //RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
            //RequestDispatcher dis = request.getRequestDispatcher("indexBaru.jsp");
            //RequestDispatcher dis = request.getRequestDispatcher("indexBaruBiru.jsp");

            ModelLocatorSKP.levelUser = "0";
            ModelLocatorSKP.navigasiPil = "0";
            session.setAttribute("levelPemakaian", ModelLocatorSKP.levelUser);
            String levelUser = ModelLocatorSKP.levelUser;


            request.setAttribute("tingkatPengguna", ModelLocatorSKP.levelUser);
            request.setAttribute("navigasiPilihan", ModelLocatorSKP.navigasiPil);

            //RequestDispatcher dis2 = getServletContext().getRequestDispatcher("/NavigasiProfile?etst=test");
            // dis2.forward(request, response);



            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/navigasiPenggunadat.jsp");
            dis.forward(request, response);

            //RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/indexBaruBiru2.jsp");
            //dis.forward(request, response);
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
