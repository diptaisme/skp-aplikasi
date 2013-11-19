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
import model.GoIndex;
import model.TupoksiKeIsi4Faktor;
import model.loginweb;
import model.PnsSkp;
import model.unorskp;

/**
 *
 * @author diptaisme
 */
public class loginPassServlet extends HttpServlet {

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
            throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        
       
        RequestDispatcher dis = null;
        
        String user = request.getParameter("usernametext");
        String pass = request.getParameter("passwordtext");
        
        
        String username = "xxx";  
        
           String param = request.getParameter("Submit");
       
        if (param != null)
        {
            
            if(param.equalsIgnoreCase("Batal"))
            {
                  HttpSession session = request.getSession();
            
               if (session.getAttribute("user") !=null){
                  String test1=(String) session.getAttribute("user");
                   session.removeAttribute("user");
                  //  session.removeAttribute("NipPnsSession");
                  // session.invalidate();
               }
                 if (session.getAttribute("NipPnsSession") !=null){
                //  String test1=(String) session.getAttribute("user");
                  // session.removeAttribute("user");
                    session.removeAttribute("NipPnsSession");
                  // session.invalidate();
               }
                 session.invalidate(); 
                 out.close();
            }
            
        }
        if ((user != null && !"".equals(user) && !" ".equals(user)) && (pass != null && !"".equals(pass) && !" ".equals(pass)))
        {
                loginweb log = new GoIndex().getLoginPass(user, pass);
                
                if (log == null)
                {
                    dis = request.getRequestDispatcher("indexloginBaru.jsp");
                    
                    dis.include(request, response);
                    out.close();
                }
                else
                {
                    String kewenangan = log.getkewenangan_login();
                    String nippns = log.getnippns_login();
                    //
                    //
                    if (!nippns.equals(null)){
                    if (kewenangan.equals("user"))
                    {
                        getUserMasuk(request, response);
                        //dis = request.getRequestDispatcher("indexBaruBiru.jsp");
                        //dis.forward(request, response);
                    }
                    else if (kewenangan.equals("operator"))
                    {
                        getOperatorMasuk(request, response);
                        //dis = request.getRequestDispatcher("insertTupoksiBaruBiru.jsp");
                        //dis.forward(request, response);
                    }
                    else if (kewenangan.equals("administrator"))
                    {
                        dis = request.getRequestDispatcher("manajemenUser.jsp");
                        dis.forward(request, response);
                    }
                    else
                    {
                         dis = request.getRequestDispatcher("indexloginBaru.jsp");
                         out.println("LOGIN SALAH!!!");
                         dis.include(request, response);
                         out.close();
                    }
//                    username = "member";
//                    if(user.equals("operator") && pass.equals("operator"))
//                    {
//                        //session.setAttribute("log", log);
//                        //dis = request.getRequestDispatcher("operatorIndex.jsp");
//                        dis = request.getRequestDispatcher("insertTupoksiBaruBiru.jsp");
//                        dis.forward(request, response);
//                    }
//                    else if (username.equals("member")) 
//                    {
//                        session.setAttribute("log", log);
//                        //dis = request.getRequestDispatcher("cobaIndex.jsp");
//                        //dis = request.getRequestDispatcher("SKIBiru.jsp");
//                        dis = request.getRequestDispatcher("indexBaruBiru.jsp");
//                        dis.forward(request, response);
//                    }
//                    else if(user.equals("administrator") && pass.equals("administrator"))
//                    {
//                        dis = request.getRequestDispatcher("manajemenUser.jsp");
//                        dis.forward(request, response);
//                    }
//                    else
//                    {
//                        //dis = request.getRequestDispatcher("indexlogin.jsp");
//                        dis = request.getRequestDispatcher("indexloginBaru.jsp");
//                        out.println("LOGIN SALAH!!!");
//                        dis.include(request, response);
//                        out.close();
//                    }
                    }
                    else{
                        dis = request.getRequestDispatcher("indexloginBaru.jsp");
                    
                    dis.include(request, response);
                    
                    }
                }
        }
        else if ((user == null || "".equals(user) || " ".equals(user)) || (pass == null || "".equals(pass) || " ".equals(pass)))
        {
                dis = request.getRequestDispatcher("indexloginBaru.jsp");
                dis.forward(request, response);
        }
        else
        {}
    }
    
    
     private void getOperatorMasuk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
     {
         
          RequestDispatcher dis = request.getRequestDispatcher("insertTupoksiBaruBiru.jsp");
                dis.forward(request, response);
         
         
         
     }
    
    private void getUserMasuk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    { 
            HttpSession session = request.getSession();
            String user = request.getParameter("usernametext");
            String pass = request.getParameter("passwordtext");
            
            loginweb log = new GoIndex().getLoginPass(user, pass);
            String id = log.getnippns_login();
            
            if (id != null && !"".equals(id) && !" ".equals(id))
            {
                PnsSkp pns = new GoIndex().getPns(id);

                if (pns == null)
                {
                }
                else
                {
                    String unorAtasan; 
                    PnsSkp UnorAts;
                    unorAtasan = pns.getDiAtasanId();
                    String UnorPns = pns.getUnorId();
                    if(unorAtasan.equals("")){
                        unorAtasan = pns.getUnorId();
                    }else{
                        unorAtasan = pns.getDiAtasanId();
                    }
                    String InstansiPns = pns.getInstansiId();
                    String NipPns = pns.getNipBaru();
                     ModelLocatorSKP.nipBaruAtasan=NipPns;
                      ModelLocatorSKP.IdUnorUser=pns.getUnorId();
                     session.setAttribute("NipPnsSession",NipPns);
                    UnorAts = new GoIndex().getUnorAtasan(unorAtasan);
                    ModelLocatorSKP.nipBaruAtasan= UnorAts.getNipBaru();
                    if (UnorAts == null){
                        unorskp unorAtasanLagi = new GoIndex().getIdUnorAtasan(unorAtasan);
                        String namaUnorAtasNyaLagi = unorAtasanLagi.getNamaUnor();
                        String IdUnorAtasNyaLagi = unorAtasanLagi.getDiAtasanId();
        
                        String UnorAtasanAtasan = new GoIndex().getUpdateUnorYangKosong(NipPns,IdUnorAtasNyaLagi);
                         unorAtasan = pns.getDiAtasanId();
                         UnorAts = new GoIndex().getUnorAtasan(unorAtasan);
                         ModelLocatorSKP.nipBaruAtasan= UnorAts.getNipBaru();
                    }
                    
                    List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPns, InstansiPns, NipPns);

                    request.setAttribute("pns", pns);
                    request.setAttribute("UnorAts", UnorAts);
                    request.setAttribute("tukesiServlet", tukesiServlet); 
                    
                    session.setAttribute("user",user);
                }  

                //kirim ke jsp lagi
                //RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
                //RequestDispatcher dis = request.getRequestDispatcher("indexBaru.jsp");
                //RequestDispatcher dis = request.getRequestDispatcher("indexBaruBiru.jsp");
                RequestDispatcher dis = request.getRequestDispatcher("indexBaruBiru2.jsp");
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
