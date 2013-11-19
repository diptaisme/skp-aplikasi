///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package servlets;
//
//import java.io.*;
//import java.text.DateFormat;
//import java.text.DecimalFormat;
//import java.text.NumberFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Locale;
//import java.util.Map;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import model.GoIndex;
//import model.GoIndex;
//import model.TupoksiKeIsi4Faktor;
//import model.TupoksiKeIsi4Faktor;
//import model.pnsskp;
//import model.pnsskp;
//import model.realisasi;
//import net.sf.jasperreports.engine.JasperRunManager;
//import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
////org.apache.commons.logging.impl.Jdk14Logger
///**
// *
// * @author diptaisme
// */
//public class ReportIsi4FaktorRealitaServlet extends HttpServlet {
//    
//  private static String defaultDirectory = "reports" + File.separator;
//    
//    public static final String VAR_REPORTISI4FAKTOR = "var_reportisi4faktor";
//    
//    private static String var_reportisi4faktor = defaultDirectory + "report_isi4faktor.jasper";
//    
//    private static final Log LOG = (Log) LogFactory.getLog(ReportIsi4FaktorRealitaServlet.class);
//  
//    /**
//     * Processes requests for both HTTP
//     * <code>GET</code> and
//     * <code>POST</code> methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        
////*********************************************DIPINDAHKAN KE doget***********************************//
////        response.setContentType("text/html;charset=UTF-8");
////        PrintWriter out = response.getWriter();
////       
////        DateFormat rf = new SimpleDateFormat("dd-MM-yyyy");
////		String baseDir = getBaseDirectory(request);
////		String typeReport = request.getParameter("report_isi4faktor");
////		String fileName = "";
////              
////	String jenisReporting = "";
////        
////        jenisReporting = "ISI4FAKTOR";
////        fileName = baseDir + "/" + typeReport;
////                
////        String namaPNScetak = (String) request.getAttribute("namaPNScetak");
////        String nipPNScetak = (String) request.getAttribute("nipPNScetak");
////        String golruPNScetak = (String) request.getAttribute("golruPNScetak");
////        String jabatanPNScetak = (String) request.getAttribute("jabatanPNScetak");
////        String unkerPNScetak = (String) request.getAttribute("unkerPNScetak");
////        
////        String unorAtasan = (String) request.getAttribute("unorAtasan");
////        String UnorPnsid = (String) request.getAttribute("UnorPnsid");
////        String InstansiPns = (String) request.getAttribute("InstansiPns");
////        String NipPns = (String) request.getAttribute("NipPns");
////        
////        
////        pnsskp UnorAts=new GoIndex().getUnorAtasan(unorAtasan);
////        List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPnsid, InstansiPns, NipPns);
////        
////        
////        Map<String, Object> myMap = new HashMap<String, Object>();
////        myMap.put("NAMAPNSCETAK", namaPNScetak);
////        myMap.put("NiPPNSCETAK", nipPNScetak);
////        myMap.put("GOLRUPNSCETAK", golruPNScetak);
////        myMap.put("JABATANPNSCETAK", jabatanPNScetak);
////        myMap.put("UNKERPNSCETAK", unkerPNScetak);
////        
////        List<Map<String,Object>> listResult = new ArrayList<Map<String,Object>>();
////        StringBuffer Keterangan = new StringBuffer();
////        int nomorHitung=0;
////        String nomorstr;
////        for (TupoksiKeIsi4Faktor tukesiDomain : tukesiServlet)
////        {
////              Map<String, Object> test = new HashMap<String, Object>();
////              nomorHitung=nomorHitung+1;
////              
////                nomorstr =Integer.toString(nomorHitung);
////                test.put("NOMORTUPOKSI",nomorstr); 
////                test.put("NAMATUPOKSI",tukesiDomain.getNamaTupoksi()); 
////                test.put("KUANTITAS4",tukesiDomain.getKuantitas4());
////                test.put("KUALITAS4",tukesiDomain.getKualitas4());
////                test.put("WAKTU4",tukesiDomain.getWaktu4());
////                test.put("BIAYA4",tukesiDomain.getBiaya4());
////                
////                 listResult.add(test);
////            // membuat MAP : Map<String, Object> test = new HashMap<String, Object>();
////            // di : public class ReportPertimbanganTeknisPensiunCommand
////            // listResult ==> toArray
////        }
////        
////        
////        
////     //   this.generalPDFReports(listResult.toArray(), request, response, myMap, fileName);
////        
////        this.generalPDFReports(listResult.toArray(),request, response, myMap, fileName);
////        
////        try {
////            /*
////             * TODO output your page here. You may use following sample code.
////             */
////            out.println("<html>");
////            out.println("<head>");
////            out.println("<title>Servlet ReportIsi4FaktorServlet</title>");            
////            out.println("</head>");
////            out.println("<body>");
////            out.println("<h1>Servlet ReportIsi4FaktorServlet at " + request.getContextPath() + "</h1>");
////            out.println("</body>");
////            out.println("</html>");
////        } finally {            
////            out.close();
////        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP
//     * <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//       // processRequest(request, response);
//        
//        
//        DateFormat tglskrg = new SimpleDateFormat("dd-MM-yyyy");
//        DecimalFormat df = new DecimalFormat();
//		String baseDir = getBaseDirectory(request);
//		String typeReport = (String)request.getAttribute("typeReport");
//		String fileName = "";
//              
//	String jenisReporting = "";
//        
//        jenisReporting = "ISI4FAKTOR";
//        fileName = baseDir ;
//            String rf=tglskrg.format(Calendar.getInstance().getTime()) ;
//            
//            DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
//            formatter.setMaximumFractionDigits(2);
//            int nilai=1000; //long //double
//            System.out.println(formatter.format(nilai)); 
//            
//        String namaPNScetak = (String) request.getAttribute("namaPNScetak");
//        String nipPNScetak = (String) request.getAttribute("nipPNScetak");
//        String golruPNScetak = (String) request.getAttribute("golruPNScetak");
//        String jabatanPNScetak = (String) request.getAttribute("jabatanPNScetak");
//        String unkerPNScetak = (String) request.getAttribute("unkerPNScetak");
//        
//        String unorAtasan = (String) request.getAttribute("unorAtasan");
//        String UnorPnsid = (String) request.getAttribute("UnorPnsid");
//        String InstansiPns = (String) request.getAttribute("InstansiPns");
//        String NipPns = (String) request.getAttribute("NipPns");
//        
//        //  pnsskp CetakPns = new GoIndex().getPns(NipPns);
//            pnsskp UnorAts = new GoIndex().getUnorAtasan(unorAtasan);
//           
//            
//        
//        String nipPNScetak2 = UnorAts.getNipBaru();
//        String jabatanPNScetak2 =UnorAts.getNamaJabatan();
//        String unkerPNScetak2 = UnorAts.getNamaUnor();
//        
//         pnsskp CetakPns = new GoIndex().getPns(nipPNScetak2);
//         String namaPNScetak2 =CetakPns.getNamaPns();
//          
//         String golruPNScetak2 = CetakPns.getPangkat();
//      
//         List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPnsid, InstansiPns, NipPns);
//        
//        
//        Map<String, Object> myMap = new HashMap<String, Object>();
//        
//        myMap.put("rf", rf);
//        myMap.put("NAMAPNSCETAK", namaPNScetak);
//        myMap.put("NIPPNSCETAK", nipPNScetak);
//        myMap.put("GOLRUPNSCETAK", golruPNScetak);
//        myMap.put("JABATANPNSCETAK", jabatanPNScetak);
//        myMap.put("UNKERPNSCETAK", unkerPNScetak);
//        
//        myMap.put("NAMAPNSCETAK2", namaPNScetak2);
//        myMap.put("NIPPNSCETAK2", nipPNScetak2);
//        myMap.put("GOLRUPNSCETAK2", golruPNScetak2);
//        myMap.put("JABATANPNSCETAK2", jabatanPNScetak2);
//        myMap.put("UNKERPNSCETAK2", unkerPNScetak2);
//        
//        List<Map<String,Object>> listResult = new ArrayList<Map<String,Object>>();
//        StringBuffer Keterangan = new StringBuffer();
//        int nomorHitung=0;
//        String nomorstr;
//        for (TupoksiKeIsi4Faktor tukesiDomain : tukesiServlet)
//        {
//              Map<String, Object> test = new HashMap<String, Object>();
//              nomorHitung=nomorHitung+1;
//              
//              
//            //  String s =  tukesiDomain.getBiaya4();
//            //  int n = Integer.parseInt(s);
//            //  System.out.println(formatter.format(n)); 
//           //   String nilaibi=formatter.format(n);
//              
//           //     String  harga=number_format(n,0,",",".");
//              
//              String idTupoksi=tukesiDomain.getIdTupoksi();
//              String idIsi4faktor=tukesiDomain.getIdIsi4Faktor();
//              
//               realisasi Realisasi= new GoIndex().getIdRealitas(idTupoksi, nipPNScetak, idIsi4faktor);
//                
//                nomorstr =Integer.toString(nomorHitung);
//                  if (Realisasi != null)
//              {
//                
//                 test.put("KUALITASR", Realisasi.getKualitasR());
//                 test.put("KUANTITASR",Realisasi.getKuantitasR());
//                 test.put("WAKTUR",Realisasi.getWaktuR());
//                 test.put("BAYARR",Realisasi.getBiayaR());
//                
//                test.put("NOMORTUPOKSI",nomorstr); 
//                test.put("NAMATUPOKSI",tukesiDomain.getNamaTupoksi()); 
//                test.put("KUANTITAS4",tukesiDomain.getKuantitas4());
//                test.put("KUALITAS4",tukesiDomain.getKualitas4());
//                test.put("WAKTU4",tukesiDomain.getWaktu4());
//                test.put("BIAYA4",tukesiDomain.getBiaya4());
//              }  else
//              {
//                  test.put("KUALITASR", "-");
//                  test.put("KUANTITASR","-");
//                  test.put("WAKTUR","-");
//                  test.put("BAYARR","-");
//                  
//                  test.put("NOMORTUPOKSI",nomorstr); 
//                  test.put("NAMATUPOKSI",tukesiDomain.getNamaTupoksi()); 
//                  test.put("KUANTITAS4",tukesiDomain.getKuantitas4());
//                  test.put("KUALITAS4",tukesiDomain.getKualitas4());
//                  test.put("WAKTU4",tukesiDomain.getWaktu4());
//                  test.put("BIAYA4",tukesiDomain.getBiaya4());
//                  
//              }
//                  
//                 listResult.add(test);
//            // membuat MAP : Map<String, Object> test = new HashMap<String, Object>();
//            // di : public class ReportPertimbanganTeknisPensiunCommand
//            // listResult ==> toArray
//        }
//        
//        
//        
//     //   this.generalPDFReports(listResult.toArray(), request, response, myMap, fileName);
//        
//        this.generalPDFReports(listResult.toArray(),request, response, myMap, fileName);
//        
//    }
//    
//    protected static String getBaseDirectory(HttpServletRequest request) 
//    {
//        return request.getSession().getServletContext().getRealPath("/WEB-INF/REPORT/report_isi4faktorrealita.jasper");
//    }
//    
//    public static void setRptIsi4Faktor(String rptIsi4Faktor)
//    {
//	rptIsi4Faktor = rptIsi4Faktor;
//    }
//
//    public static String getRptIsi4Faktor()
//    {
//	return var_reportisi4faktor;
//    }
//    
//    /**
//     * Handles the HTTP
//     * <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//       // processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//    private void generalPDFReports(Object[] pMyData,HttpServletRequest request, HttpServletResponse response, Map<String, Object> myMap, String fileName) throws ServletException
//    {
//       		try {
//			byte[] bytes = null;
//			net.sf.jasperreports.engine.data.JRBeanArrayDataSource myJrDataSource = new JRBeanArrayDataSource(
//					pMyData);
//			bytes = JasperRunManager.runReportToPdf(fileName, myMap, myJrDataSource);
//			serveReport(request, response, bytes);
//		} catch (Exception e) {
//                    e.printStackTrace();
//                    System.out.println("eee === "+e.getMessage());
//		}
//    }
//    
//    	private void serveReport(HttpServletRequest request, HttpServletResponse response, byte[] bytes)
//			throws IOException {
//		InputStream inputStream = new ByteArrayInputStream(bytes);
//		OutputStream outputStream = response.getOutputStream();
//
//			response.setContentType("application/pdf");
//			response.setContentLength(bytes.length);
//			outputStream.write(bytes, 0, bytes.length);
//			outputStream.flush();
//			outputStream.close();
//
//	}
//
//    private String number_format(int n, int i, String string, String string0) {
//        throw new UnsupportedOperationException("Not yet implemented");
//    }
//        
//}