/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//org.apache.commons.logging.impl.Jdk14Logger
/**
 *
 * @author diptaisme
 */
public class ReportIsi4FaktorServlet extends HttpServlet
{
    private static String defaultDirectory = "reports" + File.separator;
 
    //REPORT untuk isi4faktor
    public static final String VAR_REPORTISI4FAKTOR = "var_reportisi4faktor";
    private static String var_reportisi4faktor = defaultDirectory + "report_isi4faktor.jasper";
    //private static String var_reportisi4faktor = defaultDirectory + "report_isi4faktor_baru.jasper";
    
    //REPORT untuk realisasi
    public static final String VAR_REPORTREALISASI = "var_realisasi";
    //private static String var_realisasi = defaultDirectory + "SKPrealisasi.jasper";
    //private static String var_realisasi = defaultDirectory + "SKPrealisasi_baru.jasper";
    private static String var_realisasi = defaultDirectory + "SKPrealisasi_baru_subreport.jasper";

   //REPORT untuk tambhana
    public static final String VAR_REPORTTAMBAHAN = "var_tambahan";
    private static String var_tambahan = defaultDirectory + "SKPunsurpenunjang.jasper";
    
    //REPORT untuk realisasi dengan sub report
    public static final String VAR_REPORTREALISASISUBREPORT = "var_RealisasiSubReport";
    //private static String var_RealisasiSubReport = defaultDirectory + "SKPrealisasi_baru_subreport.jasper";
    private static String var_RealisasiSubReport = defaultDirectory + "SKPrealisasi_baru_subreportBaru.jasper";
    
    //REPORT untuk penilaian prestasi kerja
    public static final String VAR_REPORTPRESTASIKERJA = "var_prestasikerja";
    //private static String var_RealisasiSubReport = defaultDirectory + "SKPrealisasi_baru_subreport.jasper";
    private static String var_prestasikerja = defaultDirectory + "prestasikerja3.jasper";
    
    private static final Log LOG = (Log) LogFactory.getLog(ReportIsi4FaktorServlet.class);
        
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
        
//*********************************************DIPINDAHKAN KE doget***********************************//
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//       
//        DateFormat rf = new SimpleDateFormat("dd-MM-yyyy");
//		String baseDir = getBaseDirectory(request);
//		String typeReport = request.getParameter("report_isi4faktor");
//		String fileName = "";
//              
//	String jenisReporting = "";
//        
//        jenisReporting = "ISI4FAKTOR";
//        fileName = baseDir + "/" + typeReport;
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
//        
//        PnsSkp UnorAts=new GoIndex().getUnorAtasan(unorAtasan);
//        List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPnsid, InstansiPns, NipPns);
//        
//        
//        Map<String, Object> myMap = new HashMap<String, Object>();
//        myMap.put("NAMAPNSCETAK", namaPNScetak);
//        myMap.put("NiPPNSCETAK", nipPNScetak);
//        myMap.put("GOLRUPNSCETAK", golruPNScetak);
//        myMap.put("JABATANPNSCETAK", jabatanPNScetak);
//        myMap.put("UNKERPNSCETAK", unkerPNScetak);
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
//                nomorstr =Integer.toString(nomorHitung);
//                test.put("NOMORTUPOKSI",nomorstr); 
//                test.put("NAMATUPOKSI",tukesiDomain.getNamaTupoksi()); 
//                test.put("KUANTITAS4",tukesiDomain.getKuantitas4());
//                test.put("KUALITAS4",tukesiDomain.getKualitas4());
//                test.put("WAKTU4",tukesiDomain.getWaktu4());
//                test.put("BIAYA4",tukesiDomain.getBiaya4());
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
//        try {
//            /*
//             * TODO output your page here. You may use following sample code.
//             */
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ReportIsi4FaktorServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ReportIsi4FaktorServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        } finally {            
//            out.close();
//        }
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

        
        DateFormat tglskrg = new SimpleDateFormat("dd-MM-yyyy");
        DecimalFormat df = new DecimalFormat();
        
        String baseDir = getBaseDirectory(request);
        //String baseDirR = getBaseDirectoryR(request);
        String baseDirU = getBaseDirectoryU(request);
     //   String baseDirSB = getBaseDirectorySB(request);
        String baseDirP = getBaseDirectoryP(request);
         String baseDirSN = getBaseDirectorySN(request);
        
        
        String typeReport = (String)request.getAttribute("typeReport");
        String fileName;
        String fileNameR;
        String fileNameU;
        String fileNameSB;
        String fileNameP;
        String fileNamen;
	String jenisReporting = "";
        String jenisReportingR = "";
        String jenisReportingU = "";
        String jenisReportingSB = "";
        String jenisReportingP = "";
        
        if(typeReport.equalsIgnoreCase("report_isi4faktor"))
        {
        
            jenisReporting = "ISI4FAKTOR";
            fileName = baseDir ;
             String tglCetak_= (String) request.getAttribute("tglCetak");

            String rf=tglskrg.format(Calendar.getInstance().getTime()) ;
            rf="02 Januari 2013";
            
            if(tglCetak_==null){
                   rf="02 Januari 2013";
                 
             }else  if (tglCetak_.length()==10){
                  rf=tglCetak_;
              
                validasiString vs = new validasiString();
                vs.setNamaBulan(rf);
                String brf = vs.getNamaBulan();
                rf=rf.substring(0,2) +" " + brf + " "+rf.substring(6,10); 
              }else{
                  rf="02 Januari 2013";
             }
            
            DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            formatter.setMaximumFractionDigits(2);
            int nilai=1000; //long //double
            System.out.println(formatter.format(nilai)); 

            String namaPNScetak = (String) request.getAttribute("namaPNScetak");
            String nipPNScetak = (String) request.getAttribute("nipPNScetak");
            String golruPNScetak = (String) request.getAttribute("golruPNScetak");
            String jabatanPNScetak = (String) request.getAttribute("jabatanPNScetak");
            String unkerPNScetak = (String) request.getAttribute("unkerPNScetak");

            String unorAtasan = (String) request.getAttribute("unorAtasan");
            String UnorPnsid = (String) request.getAttribute("UnorPnsid");
            String InstansiPns = (String) request.getAttribute("InstansiPns");
            String NipPns = (String) request.getAttribute("NipPns");
            
             String _pilih_session= (String) request.getAttribute("_pilih_session");
             
             if (_pilih_session==null){
                 _pilih_session="-";
             }
             
             
              PnsSkp UnorAts = null;
         if(ModelLocatorSKP.nipBaruAtasan==null || ModelLocatorSKP.nipBaruAtasan.equals("")|| ModelLocatorSKP.nipBaruAtasan.equals(" ")){
               UnorAts = new GoIndex().getUnorAtasan(unorAtasan);
         }else{
                UnorAts = new GoIndex().getPns(ModelLocatorSKP.nipBaruAtasan);
         }
          
             

            //pnsskp CetakPns = new GoIndex().getPns(NipPns);
          // PnsSkp UnorAts = new GoIndex().getUnorAtasan(unorAtasan);

            String nipPNScetak2 = UnorAts.getNipBaru();
            String jabatanPNScetak2 =UnorAts.getNamaJabatan();
            String unkerPNScetak2 = UnorAts.getNamaUnor();

            PnsSkp CetakPns = new GoIndex().getPns(nipPNScetak2);
            String namaPNScetak2 =CetakPns.getNamaPns();

            String golruPNScetak2 = CetakPns.getNamaGolru() +" / " + CetakPns.getPangkat();

          //  List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPnsid, InstansiPns, NipPns);
            List<TupoksiKeIsi4Faktor> tukesiServlet =null;
            if (_pilih_session.equals("-")) {
            tukesiServlet = new GoIndex().getTukesi(UnorPnsid, InstansiPns, NipPns);
 }else{         
            tukesiServlet = new GoIndex().getTukesiSession(UnorPnsid, InstansiPns, NipPns,_pilih_session);
 }      
            
            
            if(tukesiServlet != null && tukesiServlet.size() > 0)
            {
                Map<String, Object> myMap = new HashMap<String, Object>();

                myMap.put("rf", rf);
                myMap.put("NAMAPNSCETAK", namaPNScetak);
                myMap.put("NIPPNSCETAK", nipPNScetak);
                myMap.put("GOLRUPNSCETAK", golruPNScetak);
                myMap.put("JABATANPNSCETAK", jabatanPNScetak);
                myMap.put("UNKERPNSCETAK", unkerPNScetak);

                myMap.put("NAMAPNSCETAK2", namaPNScetak2);
                myMap.put("NIPPNSCETAK2", nipPNScetak2);
                myMap.put("GOLRUPNSCETAK2", golruPNScetak2);
                myMap.put("JABATANPNSCETAK2", jabatanPNScetak2);
                myMap.put("UNKERPNSCETAK2", unkerPNScetak2);

                List<Map<String,Object>> listResult = new ArrayList<Map<String,Object>>();
                StringBuffer Keterangan = new StringBuffer();
                int nomorHitung=0;
                double hitnr=0;
                String nomorstr;
                for (TupoksiKeIsi4Faktor tukesiDomain : tukesiServlet)
                {
                        Map<String, Object> test = new HashMap<String, Object>();
                        nomorHitung=nomorHitung+1;

                        //String s =  tukesiDomain.getBiaya4();
                        //int n = Integer.parseInt(s);
                        //System.out.println(formatter.format(n)); 
                        // String nilaibi=formatter.format(n);

                        //String  harga=number_format(n,0,",",".");
                        String idTupoksi=tukesiDomain.getIdTupoksi();
                        String id4Faktor=tukesiDomain.getIdIsi4Faktor();
                        String tmp=tukesiDomain.getangka_krdtR();
                         if (tmp ==null) {
                             tmp="0";
                         }
                          if (tmp.equals("")) {
                             tmp="0";
                         }
                          if (tmp.equals(" ")) {
                             tmp="0";
                         }
                           if (tmp.equals("-")) {
                             tmp="0";
                         }
                       if (tukesiDomain.getangka_krdtR() !=null) {
                           //  double nR = java.lang.Double.parseDouble(tmp);
                             
                                float nR = Float.parseFloat(tmp);
                             hitnr=  nR + hitnr;
                        }else{
                            tmp=" ";
                        }
                         if (tmp==null){
                              tmp=" ";
                         }
                         if (tmp.equals("0")){
                              tmp=" ";
                         }
                        String namatpk=tukesiDomain.getNamaTupoksi();
                        tupoksi tupoksiak = new GoIndex().getIdtupoksiAll(idTupoksi);
                        String tmp2 = tupoksiak.getangka_krdt();
                        if(tmp2.equals("")){
                          tmp2=" ";
                        }else if(tmp2==null){
                             tmp2=" ";
                        }else{
                            tmp2= " (" + tmp2 +")";  
                        }
                        namatpk=namatpk+tmp2 ;     
                        nomorstr =Integer.toString(nomorHitung);
                        test.put("NOMORTUPOKSI",nomorstr); 
                        test.put("NAMATUPOKSI",namatpk); 
                        test.put("KUANTITAS4",tukesiDomain.getKuantitas4());
                        test.put("KUALITAS4",tukesiDomain.getKualitas4());
                        test.put("WAKTU4",tukesiDomain.getWaktu4());
                        test.put("BIAYA4",tukesiDomain.getBiaya4());
                        test.put("kuantitas_label",tukesiDomain.getkuantitas_label());
                        test.put("waktu_label",tukesiDomain.getwaktu_label());
                        test.put("Angka_Kredit",tmp);

                        listResult.add(test);
                        //membuat MAP : Map<String, Object> test = new HashMap<String, Object>();
                        //di : public class ReportPertimbanganTeknisPensiunCommand
                        //listResult ==> toArray
                }
                
               
             //    long n4 = Long.parseLong(pq);
                 DecimalFormat formatterR = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
                 formatterR.setMaximumFractionDigits(4);
                 String  phitnr= formatterR.format(hitnr);
                if (phitnr.equals("0")){
                              phitnr="-";
                         }
               myMap.put("PHITNR", phitnr);
                //this.generalPDFReports(listResult.toArray(), request, response, myMap, fileName);
                this.generalPDFReports(listResult.toArray(),request, response, myMap, fileName);
            }
            else
            {
                getTarget2(request, response);
            }
        }else if (typeReport.equalsIgnoreCase("report_Cetak_nominatif_bawahan")){
            
             jenisReporting = "NOMINATIFBAWAHAN";
            fileNamen =baseDirSN ;
             String tglCetak_= (String) request.getAttribute("tglCetak");

            String rf=tglskrg.format(Calendar.getInstance().getTime()) ;
            rf="02 Januari 2013";
            
            if(tglCetak_==null){
                   rf="02 Januari 2013";
                 
             }else  if (tglCetak_.length()==10){
                  rf=tglCetak_;
              
                validasiString vs = new validasiString();
                vs.setNamaBulan(rf);
                String brf = vs.getNamaBulan();
                rf=rf.substring(0,2) +" " + brf + " "+rf.substring(6,10); 
              }else{
                  rf="02 Januari 2013";
             }
            
            DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            formatter.setMaximumFractionDigits(2);
            int nilai=1000; //long //double
            System.out.println(formatter.format(nilai)); 

            List<PnsSkp> pnsListNominatif = (List<PnsSkp>) request.getAttribute("pnsList");
             PnsSkp pnsNominatif =(PnsSkp) request.getAttribute("pns");
             
            String unorAtasan = (String) request.getAttribute("unorAtasan");
            String UnorPnsid = (String) request.getAttribute("UnorPnsid");
            String InstansiPns = (String) request.getAttribute("InstansiPns");
            String NipPns = (String) request.getAttribute("NipPns");
            
            unorAtasan=pnsNominatif.getDiAtasanId();
            
            String nipPNScetak2 = pnsNominatif.getNipBaru();
            String jabatanPNScetak2 =pnsNominatif.getNamaJabatan();
            String unkerPNScetak2 = pnsNominatif.getNamaUnor();

            PnsSkp CetakPns = new GoIndex().getPns(nipPNScetak2);
            String namaPNScetak2 =CetakPns.getNamaPns();

            String golruPNScetak2 = CetakPns.getNamaGolru() +" / " + CetakPns.getPangkat();
            
             String _pilih_session= (String) request.getAttribute("_pilih_sessiont");
             
             if (_pilih_session==null){
                 _pilih_session="-";
             }
               Map<String, Object> myMap = new HashMap<String, Object>();

                myMap.put("rf", rf);
                myMap.put("NAMAPNSCETAK2", namaPNScetak2);
                myMap.put("NIPPNSCETAK2", nipPNScetak2);
                myMap.put("GOLRUPNSCETAK2", golruPNScetak2);
                myMap.put("JABATANPNSCETAK2", jabatanPNScetak2);
                myMap.put("UNKERPNSCETAK2", unkerPNScetak2);
                List<Map<String,Object>> listResult = new ArrayList<Map<String,Object>>();
                 int nomorHitung=0;
                String nomorstr;
                  for (PnsSkp pnsObjeckt : pnsListNominatif)
            {
                    Map<String, Object> test = new HashMap<String, Object>();
                    
                    nomorHitung=nomorHitung+1;

                    nomorstr =Integer.toString(nomorHitung);
                    test.put("NOMORTAMBAHAN",nomorstr); 
                    test.put("NIPBARU",pnsObjeckt.getNipBaru());
                    test.put("NAMAPNS",pnsObjeckt.getNamaPns());
                    test.put("NAMAGOLRU",pnsObjeckt.getNamaGolru());
                    test.put("PANGKAT",pnsObjeckt.getPangkat());
                    test.put("NAMAUNOR",pnsObjeckt.getNamaUnor());
                    test.put("NAMAJABATAN",pnsObjeckt.getNamaJabatan());
                    test.put("REALISASI",pnsObjeckt.getRealisasi());
                   
                    listResult.add(test);
            }
           this.generalPDFReports(listResult.toArray(),request, response, myMap, fileNamen);
            
        }
            
        else if (typeReport.equalsIgnoreCase("SKPrealisasiSubReport"))
        { 
            jenisReportingSB = "REALISASISUBREPORT";
              String baseDirSB = getBaseDirectorySB(request);
            fileNameSB = baseDirSB ;

            String rf = tglskrg.format(Calendar.getInstance().getTime());
            String tglCetak_= (String) request.getAttribute("tglCetak");
           rf="31 Desember 2013";
           if(tglCetak_==null){
                   rf="31 Desember 2013";
                 
             }else  if (tglCetak_.length()==10){
                  rf=tglCetak_;
                  validasiString vs = new validasiString();
                  vs.setNamaBulan(rf);
                  String brf = vs.getNamaBulan();
                  rf=rf.substring(0,2) +" " + brf + " "+rf.substring(6,10); 
              }else{
                  rf="31 Desember 2013";
             }
           
            DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            formatter.setMaximumFractionDigits(2);
            int nilai=1000;
            System.out.println(formatter.format(nilai)); 

            String namaPNScetak = (String) request.getAttribute("namaPNScetak");
            String nipPNScetak = (String) request.getAttribute("nipPNScetak");
            String golruPNScetak = (String) request.getAttribute("golruPNScetak");
            String jabatanPNScetak = (String) request.getAttribute("jabatanPNScetak");
            String unkerPNScetak = (String) request.getAttribute("unkerPNScetak");

            String unorAtasan = (String) request.getAttribute("unorAtasan");
            String UnorPnsid = (String) request.getAttribute("UnorPnsid");
            String InstansiPns = (String) request.getAttribute("InstansiPns");
            String NipPns = (String) request.getAttribute("NipPns");
            
               String _pilih_session= (String) request.getAttribute("_pilih_session");
               
                 if (_pilih_session==null){
                 _pilih_session="-";
             }
                 PnsSkp UnorAts = null;
         if(ModelLocatorSKP.nipBaruAtasan==null || ModelLocatorSKP.nipBaruAtasan.equals("")|| ModelLocatorSKP.nipBaruAtasan.equals(" ")){
               UnorAts = new GoIndex().getUnorAtasan(unorAtasan);
         }else{
                UnorAts = new GoIndex().getPns(ModelLocatorSKP.nipBaruAtasan);
         }
          

            String nipPNScetak2 = UnorAts.getNipBaru();
            String jabatanPNScetak2 =UnorAts.getNamaJabatan();
            String unkerPNScetak2 = UnorAts.getNamaUnor();

            PnsSkp CetakPns = new GoIndex().getPns(nipPNScetak2);
            String namaPNScetak2 =CetakPns.getNamaPns();

            String golruPNScetak2 = CetakPns.getPangkat();
            golruPNScetak2 = CetakPns.getNamaGolru() +" / " + CetakPns.getPangkat();

           // List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPnsid, InstansiPns, NipPns);
              List<TupoksiKeIsi4Faktor> tukesiServlet = null;
               if (_pilih_session.equals("-")) {
            tukesiServlet = new GoIndex().getTukesi(UnorPnsid, InstansiPns, NipPns);
 }else{         
            tukesiServlet = new GoIndex().getTukesiSession(UnorPnsid, InstansiPns, NipPns,_pilih_session);
 }      
            
            if (tukesiServlet != null && tukesiServlet.size() > 0)
            {    
                List<RealisasiIsi4faktorTupoksi> realkesiServlet = new GoIndex().getRealkesi(NipPns);
               
                 if (_pilih_session.equals("-")) {
                      realkesiServlet = new GoIndex().getRealkesi(NipPns);
              
                 }else{
                      realkesiServlet = new GoIndex().getRealkesiSession(ModelLocatorSKP.IdUnorUser,NipPns,_pilih_session);
                 }     
                
                //List<TugasTambahan> tugasTambahan = new GoIndex().getTugasTambahanAllList(NipPns);
                //TugasTambahan tugasTambahan = new GoIndex().getTugasTambahanNotList(NipPns);
                //getDBqueryTugasTambahanList
                //List<TugasTambahan> tugasTambahan = new GoIndex().getTugasTambahanListList(NipPns);
                //List<TugasTambahan> tugasTambahan = new GoIndex().getTugasTambahanList(NipPns);
                //List<RealisasiIsi4faktorTupoksiHitung> tugastambahanServlet = new GoIndex().getRealkesiHitung(NipPns);
                //nilaiprestasikerja npk = new GoIndex().getNilaiPrestasiKerjaAllNotList(NipPns);
                List<TugasTambahan> tugasTambahan = new GoIndex().getNilaiTugasTambahanList(NipPns);
                List<TugasTambahan> kratifitasTambahan = new GoIndex().getTugasTambahanMakList(NipPns);
                
                //*****************
                //String nilaitambahan = tugasTambahan.getNilaiTambahan();
               // String nilaikreatifitas = npk.getKreatifitas();
        for (TugasTambahan tukesiDomaintt : tugasTambahan){
            String niltest=tukesiDomaintt.getNilaiTambahan();
            String niltest2=tukesiDomaintt.getNilai2();
        }
                Map<String, Object> myMap = new HashMap<String, Object>();

                myMap.put("rf", rf);
                myMap.put("NAMAPNSCETAK", namaPNScetak);
                myMap.put("NIPPNSCETAK", nipPNScetak);
                myMap.put("GOLRUPNSCETAK", golruPNScetak);
                myMap.put("JABATANPNSCETAK", jabatanPNScetak);
                myMap.put("UNKERPNSCETAK", unkerPNScetak);

                myMap.put("NAMAPNSCETAK2", namaPNScetak2);
                myMap.put("NIPPNSCETAK2", nipPNScetak2);
                myMap.put("GOLRUPNSCETAK2", golruPNScetak2);
                myMap.put("JABATANPNSCETAK2", jabatanPNScetak2);
                myMap.put("UNKERPNSCETAK2", unkerPNScetak2);
                
                //myMap.put("nilaitambahan", nilaitambahan);
              //  myMap.put("nilaikreatifitas", nilaikreatifitas);

                myMap.put("tugasTambahan", tugasTambahan);
                myMap.put("kratifitasTambahan", kratifitasTambahan);
                //myMap.put("npk", npk);
                myMap.put("realkesiServlet", realkesiServlet);

                List<Map<String,Object>> listResult = new ArrayList<Map<String,Object>>();

                StringBuffer Keterangan = new StringBuffer();

                int nomorHitung=0;
                String nomorstr;

                for (RealisasiIsi4faktorTupoksi tukesiDomain : realkesiServlet)
                {
                        Map<String, Object> test = new HashMap<String, Object>();

                        nomorHitung=nomorHitung+1;

                        String idTupoksi=tukesiDomain.getId_tupoksi();
                        String id4Faktor=tukesiDomain.getId_isi4faktor();
                        
                        tupoksi tupoksiak = new GoIndex().getIdtupoksiAll(idTupoksi);
                        String tmp2 = tupoksiak.getangka_krdt();
                        if(tmp2.equals("")){
                          tmp2=" ";
                        }else if(tmp2==null){
                             tmp2=" ";
                        }else{
                            tmp2= "(" + tmp2 +")";  
                        }
                    
String tuko = tukesiDomain.getNama_tupoksi()+ tmp2 ;
                        nomorstr =Integer.toString(nomorHitung);
                        test.put("NOMORTUPOKSI",nomorstr); 
                        test.put("NAMATUPOKSI",tuko); 
                        test.put("KUANTITAS4",tukesiDomain.getKuantitas4());
                        test.put("KUALITAS4",tukesiDomain.getKualitas4());
                        test.put("WAKTU4",tukesiDomain.getWaktu4());
                        test.put("BIAYA4",tukesiDomain.getBiaya4());
                        test.put("KUANTITASR",tukesiDomain.getKuantitasr());
                        test.put("KUALITASR", tukesiDomain.getKualitasr());
                        test.put("WAKTUR", tukesiDomain.getWaktur());
                        test.put("BIAYAR", tukesiDomain.getWaktur());
                        test.put("PENGHITUNGAN", tukesiDomain.getPenghitungan());
                        test.put("NILAICAPAIANSKP", tukesiDomain.getNilai_capaian_skp());

                        listResult.add(test);
                        break;
                }  
                  String total_skp =null;
                //INI SUMBER DARI SEGALA SUMBER PENILAIAN!!!!!!!!########         
                  //  String total_skp = new GoIndex().getNilaiAll(NipPns); //-->cuman "SKP realisasi" saja
                  //  double n4 = Double.parseDouble(total_skp);
                 ///   DecimalFormat formatterR = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
                 //   formatterR.setMaximumFractionDigits(2);
                 //   total_skp= formatterR.format(n4);
                if (_pilih_session.equals("-")) {
                    total_skp = new GoIndex().getNilaiAll(NipPns);
                 }else{
                     total_skp = new GoIndex().getNilaiAllSession(ModelLocatorSKP.IdUnorUser,NipPns,_pilih_session);
                 }
                
                myMap.put("TOTAL_SKP", total_skp);

              //  double i_nilaiangka = Double.parseDouble(total_skp);
               //  float i_nilaiangka = Float.parseFloat(total_skp);
                // int i_nilaiangka=Integer.parseInt(total_skp);
                 validasiString vs = new validasiString();
        
        vs.setkoma(total_skp);
        total_skp= vs.getmashudi();
            double i_nilaiangka = Double.parseDouble(total_skp);     
                String nilaihuruf = null;

                if(i_nilaiangka <= 50)
                {
                    nilaihuruf = "BURUK";
                }
                else if(i_nilaiangka <= 60 && i_nilaiangka >= 51)
                {
                    nilaihuruf = "SEDANG";
                }
                else if(i_nilaiangka <= 75 && i_nilaiangka >= 61)
                {
                    nilaihuruf = "CUKUP";
                }
                else if(i_nilaiangka <= 90 && i_nilaiangka >= 76)
                {
                    nilaihuruf = "BAIK";
                }
                else if(i_nilaiangka <= 100 && i_nilaiangka >= 91)
                {
                    nilaihuruf = "SANGAT BAIK";
                }

                myMap.put("NILAIHURUF", nilaihuruf);

                this.generalPDFReports(listResult.toArray(),request, response, myMap, fileNameSB);
            }
            else
            {
                getRealisasi2(request, response);
            }
        }
        else if (typeReport.equalsIgnoreCase("SKPrealisasi"))
        { 
            jenisReportingR = "REALISASI";
            String baseDirR = getBaseDirectoryR(request);
            fileNameR = baseDirR ;

            String rf = tglskrg.format(Calendar.getInstance().getTime());
            rf="31 Desember 2013";
            DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            formatter.setMaximumFractionDigits(2);
            int nilai=1000;
            System.out.println(formatter.format(nilai)); 

            String namaPNScetak = (String) request.getAttribute("namaPNScetak");
            String nipPNScetak = (String) request.getAttribute("nipPNScetak");
            String golruPNScetak = (String) request.getAttribute("golruPNScetak");
            String jabatanPNScetak = (String) request.getAttribute("jabatanPNScetak");
            String unkerPNScetak = (String) request.getAttribute("unkerPNScetak");

            String unorAtasan = (String) request.getAttribute("unorAtasan");
            String UnorPnsid = (String) request.getAttribute("UnorPnsid");
            String InstansiPns = (String) request.getAttribute("InstansiPns");
            String NipPns = (String) request.getAttribute("NipPns");

            PnsSkp UnorAts = new GoIndex().getUnorAtasan(unorAtasan);

            String nipPNScetak2 = UnorAts.getNipBaru();
            String jabatanPNScetak2 =UnorAts.getNamaJabatan();
            String unkerPNScetak2 = UnorAts.getNamaUnor();

            PnsSkp CetakPns = new GoIndex().getPns(nipPNScetak2);
            String namaPNScetak2 =CetakPns.getNamaPns();

            String golruPNScetak2 = CetakPns.getPangkat();

            List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPnsid, InstansiPns, NipPns);
            List<RealisasiIsi4faktorTupoksi> realkesiServlet = new GoIndex().getRealkesi(NipPns);
            List<TugasTambahan> tugasTambahan = new GoIndex().getTugasTambahanList(NipPns);
            //List<RealisasiIsi4faktorTupoksiHitung> tugastambahanServlet = new GoIndex().getRealkesiHitung(NipPns);

            Map<String, Object> myMap = new HashMap<String, Object>();

            myMap.put("rf", rf);
            myMap.put("NAMAPNSCETAK", namaPNScetak);
            myMap.put("NIPPNSCETAK", nipPNScetak);
            myMap.put("GOLRUPNSCETAK", golruPNScetak);
            myMap.put("JABATANPNSCETAK", jabatanPNScetak);
            myMap.put("UNKERPNSCETAK", unkerPNScetak);

            myMap.put("NAMAPNSCETAK2", namaPNScetak2);
            myMap.put("NIPPNSCETAK2", nipPNScetak2);
            myMap.put("GOLRUPNSCETAK2", golruPNScetak2);
            myMap.put("JABATANPNSCETAK2", jabatanPNScetak2);
            myMap.put("UNKERPNSCETAK2", unkerPNScetak2); 

            List<Map<String,Object>> listResult = new ArrayList<Map<String,Object>>();
            
            StringBuffer Keterangan = new StringBuffer();
            
            int nomorHitung=0;
            String nomorstr;
            
            for (RealisasiIsi4faktorTupoksi tukesiDomain : realkesiServlet)
            {
                    Map<String, Object> test = new HashMap<String, Object>();
                    
                    nomorHitung=nomorHitung+1;
                    
                    String idTupoksi=tukesiDomain.getId_tupoksi();
                    String id4Faktor=tukesiDomain.getId_isi4faktor();

                     tupoksi tupoksiak = new GoIndex().getIdtupoksiAll(idTupoksi);
                        String tmp2 = tupoksiak.getangka_krdt();
                        
String tuko = tukesiDomain.getNama_tupoksi()+ "(" + tmp2 +")";
                    
                    nomorstr =Integer.toString(nomorHitung);
                    test.put("NOMORTUPOKSI",nomorstr); 
                    test.put("NAMATUPOKSI",tuko); 
                    test.put("KUANTITAS4",tukesiDomain.getKuantitas4());
                    test.put("KUALITAS4",tukesiDomain.getKualitas4());
                    test.put("WAKTU4",tukesiDomain.getWaktu4());
                    test.put("BIAYA4",tukesiDomain.getBiaya4());
                    test.put("KUANTITASR",tukesiDomain.getKuantitasr());
                    test.put("KUALITASR", tukesiDomain.getKualitasr());
                    test.put("WAKTUR", tukesiDomain.getWaktur());
                    test.put("BIAYAR", tukesiDomain.getWaktur());
                    test.put("PENGHITUNGAN", tukesiDomain.getPenghitungan());
                    test.put("NILAICAPAIANSKP", tukesiDomain.getNilai_capaian_skp());
                          
                    listResult.add(test);
            }                  
            this.generalPDFReports(listResult.toArray(),request, response, myMap, fileNameR);
        }
        else if (typeReport.equalsIgnoreCase("SKPunsurpenunjang"))
        { 
            jenisReportingU = "TAMBAHAN";
            fileNameU = baseDirU ;

            String rf = tglskrg.format(Calendar.getInstance().getTime());

            DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            formatter.setMaximumFractionDigits(2);
            int nilai=1000;
            System.out.println(formatter.format(nilai)); 

            String namaPNScetak = (String) request.getAttribute("namaPNScetak");
            String nipPNScetak = (String) request.getAttribute("nipPNScetak");
            String golruPNScetak = (String) request.getAttribute("golruPNScetak");
            String jabatanPNScetak = (String) request.getAttribute("jabatanPNScetak");
            String unkerPNScetak = (String) request.getAttribute("unkerPNScetak");

            String unorAtasan = (String) request.getAttribute("unorAtasan");
            String UnorPnsid = (String) request.getAttribute("UnorPnsid");
            String InstansiPns = (String) request.getAttribute("InstansiPns");
            String NipPns = (String) request.getAttribute("NipPns");

            PnsSkp UnorAts = new GoIndex().getUnorAtasan(unorAtasan);

            String nipPNScetak2 = UnorAts.getNipBaru();
            String jabatanPNScetak2 =UnorAts.getNamaJabatan();
            String unkerPNScetak2 = UnorAts.getNamaUnor();

            PnsSkp CetakPns = new GoIndex().getPns(nipPNScetak2);
            String namaPNScetak2 =CetakPns.getNamaPns();

            String golruPNScetak2 = CetakPns.getPangkat();

            List<TupoksiKeIsi4Faktor> tukesiServlet = new GoIndex().getTukesi(UnorPnsid, InstansiPns, NipPns);
            List<TugasTambahan> tugastambahanServlet = new GoIndex().getTugasTambahanList(NipPns);

            Map<String, Object> myMap = new HashMap<String, Object>();

            myMap.put("rf", rf);
            myMap.put("NAMAPNSCETAK", namaPNScetak);
            myMap.put("NIPPNSCETAK", nipPNScetak);
            myMap.put("GOLRUPNSCETAK", golruPNScetak);
            myMap.put("JABATANPNSCETAK", jabatanPNScetak);
            myMap.put("UNKERPNSCETAK", unkerPNScetak);

            myMap.put("NAMAPNSCETAK2", namaPNScetak2);
            myMap.put("NIPPNSCETAK2", nipPNScetak2);
            myMap.put("GOLRUPNSCETAK2", golruPNScetak2);
            myMap.put("JABATANPNSCETAK2", jabatanPNScetak2);
            myMap.put("UNKERPNSCETAK2", unkerPNScetak2);

            List<Map<String,Object>> listResult = new ArrayList<Map<String,Object>>();
            
            StringBuffer Keterangan = new StringBuffer();
            
            int nomorHitung=0;
            String nomorstr;
            
            for (TugasTambahan tukesiDomain : tugastambahanServlet)
            {
                    Map<String, Object> test = new HashMap<String, Object>();
                    
                    nomorHitung=nomorHitung+1;

                    nomorstr =Integer.toString(nomorHitung);
                    test.put("NOMORTAMBAHAN",nomorstr); 
                    test.put("NAMATUGASTAMBAHAN",tukesiDomain.getNama());
                    test.put("NILAITARGET",tukesiDomain.getNilai1());
                    test.put("NILAIREALISASI",tukesiDomain.getNilai2());
                    test.put("NILAIHITUNG",tukesiDomain.getHitungTambahan());
                    test.put("NILAINILAI",tukesiDomain.getNilaiTambahan());

                    listResult.add(test);
            }
            
            String nilaiangka = new GoIndex().getNilaiAll(NipPns);
            int i_nilaiangka = Integer.parseInt(nilaiangka);
            String nilaihuruf = null;
            
            if(i_nilaiangka <= 50)
            {
                nilaihuruf = "BURUK";
            }
            else if(i_nilaiangka <= 60 && i_nilaiangka >= 51)
            {
                nilaihuruf = "SEDANG";
            }
            else if(i_nilaiangka <= 75 && i_nilaiangka >= 61)
            {
                nilaihuruf = "CUKUP";
            }
            else if(i_nilaiangka <= 90 && i_nilaiangka >= 76)
            {
                nilaihuruf = "BAIK";
            }
            else if(i_nilaiangka <= 100 && i_nilaiangka >= 91)
            {
                nilaihuruf = "SANGAT BAIK";
            }
            
            myMap.put("NILAIANGKA", nilaiangka);
            myMap.put("NILAIHURUF", nilaihuruf);
                        
            this.generalPDFReports(listResult.toArray(),request, response, myMap, fileNameU);
        }
        else if (typeReport.equalsIgnoreCase("reportPenilaianPrestasiKerja"))
        {
            jenisReportingP = "PRESTASIKERJA";
            fileNameP = baseDirP ;

            String rf = tglskrg.format(Calendar.getInstance().getTime());
            rf="31 Desember 2013";

            DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            formatter.setMaximumFractionDigits(2);
            int nilai=1000;
            System.out.println(formatter.format(nilai));
            
            //PNS YANG DINILAI
            String namaPns = (String) request.getAttribute("namaPns");
            String nipPns = (String) request.getAttribute("nipPns");
            String pangkatPns = (String) request.getAttribute("pangkatPns");
            String golonganPns = (String) request.getAttribute("golonganPns");
            String unorPns = (String) request.getAttribute("unorPns");
            String jabatan = (String) request.getAttribute("jabatan");

            String diAtasanPns = (String) request.getAttribute("diAtasanPns");
            String instansiIdPns = (String) request.getAttribute("instansiIdPns");
            String unorIdPns = (String) request.getAttribute("unorIdPns");
            
              String _pilih_session= (String) request.getAttribute("_pilih_session");
             
             if (_pilih_session==null){
                 _pilih_session="-";
             }
            
            //PEJABAT PENILAI ==> ATASAN LANGSUNG
            PnsSkp idUnorAtasan = new GoIndex().getUnorAtasan(diAtasanPns);
            
            String namaAtasan = idUnorAtasan.getNamaPns();
            String nipAtasan = idUnorAtasan.getNipBaru();
            String pangkatAtasan = idUnorAtasan.getPangkat();
            String golonganAtasan = idUnorAtasan.getNamaGolru();
            String unorAtasan = idUnorAtasan.getNamaUnor();
            String jabatanAtasan = idUnorAtasan.getNamaJabatan();
            
            String diAtasanAtasan = idUnorAtasan.getDiAtasanId();
            String instansiIdAtasan = idUnorAtasan.getInstansiId();
            String unorIdAtasan = idUnorAtasan.getUnorId();
            
            //ATASAN PEJABAT PENILAI
            PnsSkp idUnorAtasanLagi = new GoIndex().getUnorAtasan(diAtasanAtasan);
            
            String namaAtasanLagi = idUnorAtasanLagi.getNamaPns();
            String nipAtasanLagi = idUnorAtasanLagi.getNipBaru();
            String pangkatAtasanLagi = idUnorAtasanLagi.getPangkat();
            String golonganAtasanLagi = idUnorAtasanLagi.getNamaGolru();
            String unorAtasanLagi = idUnorAtasanLagi.getNamaUnor();
            String jabatanAtasanLagi = idUnorAtasanLagi.getNamaJabatan();
            
            String diAtasanAtasanLagi = idUnorAtasanLagi.getDiAtasanId();
            String instansiIdAtasanLagi = idUnorAtasanLagi.getInstansiId();
            String unorIdAtasanLagi = idUnorAtasanLagi.getUnorId();
            
            //NILAI SKP
            String nilaiSKP = null;
         
             /* if (_pilih_session.equals("-")) {
                    nilaiSKP= new GoIndex().getNilaiAll(nipPns);
                 }else{
                     nilaiSKP = new GoIndex().getNilaiAllSession(nipPns,_pilih_session);
                 }*/
              
                if (_pilih_session.equals("-")) {
                    nilaiSKP= new GoIndex().getNilaiAllIdunor(nipPns,unorIdPns);
                 }else{
                     nilaiSKP = new GoIndex().getNilaiAllSession_unor(nipPns,unorIdPns,_pilih_session);
                 }
              
            double d_nilaiSKP =0;
            
            validasiString vs = new validasiString();
        
        vs.setkoma(nilaiSKP);
        nilaiSKP= vs.getmashudi();
            
           if(nilaiSKP != null )
           {
              d_nilaiSKP = Double.parseDouble(nilaiSKP) * 0.6;   
           }else{
               nilaiSKP="0";
              d_nilaiSKP = Double.parseDouble(nilaiSKP) * 0.6;  
           }
            // d_nilaiSKP = Double.parseDouble(nilaiSKP) * 0.6;
            DecimalFormat formatter4 = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            formatter4.setMaximumFractionDigits(2);
            String s_d_nilaiSKP = formatter4.format(d_nilaiSKP);
            //String s_d_nilaiSKP = Double.toString(d_nilaiSKP);
            validasiString vis = new validasiString();
            vis.setkoma(s_d_nilaiSKP);
            s_d_nilaiSKP = vis.getmashudi();
            
            //NILAI PERILAKU
            nilaiPerilaku perilakuPns = new GoIndex().getPrilaku(nipPns);
            
            String pelayanan ="0";
            String integritas = "0";
            String komitmen = "0";        
            String disiplin = "0";
            String kerjasama = "0";
            String kepemimpinan = "0";
            String jumlah = "0";        
            String ratarata ="0";
            if(perilakuPns!= null ){
                
               pelayanan = perilakuPns.getPelayanan();
               integritas = perilakuPns.getIntegritas();
               komitmen = perilakuPns.getKomitmen();        
               disiplin = perilakuPns.getDisiplin();
               kerjasama = perilakuPns.getKerjasama();
               
               kepemimpinan = perilakuPns.getKepemimpinan();
               if (kepemimpinan.equals("0") || kepemimpinan.equals("-")|| kepemimpinan.equals(" ")|| kepemimpinan.equals("")){
                   kepemimpinan ="0";
               }
               jumlah = perilakuPns.getJumlah();        
               ratarata = perilakuPns.getRatarata();
               
            }
             
             vs = new validasiString();
        
        vs.setkoma(ratarata);
        ratarata= vs.getmashudi();
        
            double d_ratarata = Double.parseDouble(ratarata) * 0.4;
             String s_d_ratarata = formatter4.format(d_ratarata);
          //  String s_d_ratarata = Double.toString(d_ratarata);
                    
            //NILAI PRESTASI KERJA
            double d_prestasi = d_nilaiSKP + d_ratarata;
            //String s_d_prestasi = Double.toString(d_prestasi);
            String s_d_prestasi = formatter4.format(d_prestasi);
            //validasiString vis = new validasiString();
            vis.setkoma(s_d_prestasi);
            s_d_prestasi = vis.getmashudi();
            
            //NAMA INSTANSI
            instansiri idInstansi = new GoIndex().getInstansi(instansiIdPns);
            String namaInstansi = idInstansi.getNamaInstansi();
            
            //NILAI HURUF
            nilaiHuruf _nilaiHuruf = new nilaiHuruf();
            _nilaiHuruf.setNilaiHuruf(pelayanan);
            String h_pelayanan = _nilaiHuruf.getNilaiHuruf();
            
            _nilaiHuruf.setNilaiHuruf(integritas);
            String h_integritas = _nilaiHuruf.getNilaiHuruf();
            
            _nilaiHuruf.setNilaiHuruf(komitmen);
            String h_komitmen = _nilaiHuruf.getNilaiHuruf();
            
            _nilaiHuruf.setNilaiHuruf(disiplin);
            String h_disiplin = _nilaiHuruf.getNilaiHuruf();
            
            _nilaiHuruf.setNilaiHuruf(kerjasama);
            String h_kerjasama = _nilaiHuruf.getNilaiHuruf();
            
            _nilaiHuruf.setNilaiHuruf(kepemimpinan);
            String h_kepemimpinan = _nilaiHuruf.getNilaiHuruf();
            
            _nilaiHuruf.setNilaiHuruf(s_d_prestasi);
            String h_s_d_prestasi = _nilaiHuruf.getNilaiHuruf();
            
            //CETAKAN
            Map<String, Object> myMap = new HashMap<String, Object>();
            
            myMap.put("rf", rf);
            
            myMap.put("namaPns", namaPns);
            myMap.put("nipPns", nipPns);
            myMap.put("pangkatPns", pangkatPns);
            myMap.put("golonganPns", golonganPns);
            myMap.put("unorPns", unorPns);
            myMap.put("jabatan", jabatan);
            
            myMap.put("namaAtasan", namaAtasan);
            myMap.put("nipAtasan", nipAtasan);
            myMap.put("pangkatAtasan", pangkatAtasan);
            myMap.put("golonganAtasan", golonganAtasan);
            myMap.put("unorAtasan", unorAtasan);
            myMap.put("jabatanAtasan", jabatanAtasan);
            
            myMap.put("namaAtasanLagi", namaAtasanLagi);
            myMap.put("nipAtasanLagi", nipAtasanLagi);
            myMap.put("pangkatAtasanLagi", pangkatAtasanLagi);
            myMap.put("golonganAtasanLagi", golonganAtasanLagi);
            myMap.put("unorAtasanLagi", unorAtasanLagi);
            myMap.put("jabatanAtasanLagi", jabatanAtasanLagi);
            
            myMap.put("nilaiSKP", nilaiSKP);
            myMap.put("s_d_nilaiSKP", s_d_nilaiSKP);
            
            myMap.put("pelayanan", pelayanan);
            myMap.put("integritas", integritas);
            myMap.put("komitmen", komitmen);
            myMap.put("disiplin", disiplin);
            myMap.put("kerjasama", kerjasama);
             if (kepemimpinan.equals("0") || kepemimpinan.equals("-")|| kepemimpinan.equals(" ")|| kepemimpinan.equals("")){
                   kepemimpinan ="-";
               }
            myMap.put("kepemimpinan", kepemimpinan);
            myMap.put("jumlah", jumlah);
            myMap.put("ratarata", ratarata);
            myMap.put("s_d_ratarata", s_d_ratarata);
            
            myMap.put("h_pelayanan", h_pelayanan);
            myMap.put("h_integritas", h_integritas);
            myMap.put("h_komitmen", h_komitmen);
            myMap.put("h_disiplin", h_disiplin);
            myMap.put("h_kerjasama", h_kerjasama);
            myMap.put("h_kepemimpinan", h_kepemimpinan);
            myMap.put("h_s_d_prestasi", h_s_d_prestasi);
            
            myMap.put("s_d_prestasi", s_d_prestasi);
            
            myMap.put("namaInstansi", namaInstansi);
                        
            List<Map<String,Object>> listResult = new ArrayList<Map<String,Object>>();
            listResult.add(myMap);
  
            //this.generalPDFReports(null,request, response, myMap, fileNameP); 
            this.generalPDFReports(listResult.toArray(),request, response, myMap, fileNameP);
            
        }
         
        else
        {}
    }
    
    
    
    
    
    
    protected static String getBaseDirectory(HttpServletRequest request) 
    {
       return request.getSession().getServletContext().getRealPath("/WEB-INF/REPORT/report_isi4faktor.jasper");
      //  return request.getSession().getServletContext().getRealPath("/WEB-INF/REPORT/report_isi4faktor_baru.jasper");
    }
    
    public static void setRptIsi4Faktor(String rptIsi4Faktor)
    {
	rptIsi4Faktor = rptIsi4Faktor;
    }

    public static String getRptIsi4Faktor()
    {
	return var_reportisi4faktor;
    }
    
    
    
    
    protected static String getBaseDirectoryR(HttpServletRequest request) 
    {
        return request.getSession().getServletContext().getRealPath("/WEB-INF/REPORT/SKPrealisasi.jasper");
        //return request.getSession().getServletContext().getRealPath("/WEB-INF/REPORT/SKPrealisasi_baru.jasper"); 
    }
    
    public static void setRptRealisasi(String rptRealisasi)
    {
	rptRealisasi = rptRealisasi;
    }

    public static String getRptRealisasi()
    {
	return var_realisasi;
    }
    
    
    
    
    
     protected static String getBaseDirectoryU(HttpServletRequest request) 
    {
        return request.getSession().getServletContext().getRealPath("/WEB-INF/REPORT/SKPunsurpenunjang.jasper");
    }
    
    public static void setRptTambahan(String rptTambahan)
    {
	rptTambahan = rptTambahan;
    }

    public static String getRptTambahan()
    {
	return var_tambahan;
    }
    
    
    
    
    
    
    
    protected static String getBaseDirectorySB(HttpServletRequest request) 
    {
       //return request.getSession().getServletContext().getRealPath("/WEB-INF/REPORT/report1.jasper");
        return request.getSession().getServletContext().getRealPath("/WEB-INF/REPORT/SKPrealisasi_baru_subreportBaru.jasper");
    }
     protected static String getBaseDirectorySN(HttpServletRequest request) 
    {
       //return request.getSession().getServletContext().getRealPath("/WEB-INF/REPORT/report1.jasper");
        return request.getSession().getServletContext().getRealPath("/WEB-INF/REPORT/reportNominatifSkpr.jasper");
    }
    public static void setRptRealisasiSubReport(String rptRealisasiSubReport)
    {
	rptRealisasiSubReport = rptRealisasiSubReport;
    }

    public static String getRptRealisasiSubReport()
    {
	return var_RealisasiSubReport;
    }
    
    
    
    
    protected static String getBaseDirectoryP(HttpServletRequest request) 
    {
        //return request.getSession().getServletContext().getRealPath("/WEB-INF/REPORT/SKPrealisasi_baru_subreport.jasper");
        return request.getSession().getServletContext().getRealPath("/WEB-INF/REPORT/prestasikerja3.jasper");
    }
    
    public static void setRptPrestasiKerja(String rptPrestasiKerja)
    {
	rptPrestasiKerja = rptPrestasiKerja;
    }

    public static String getRptPrestasiKerja()
    {
	return var_prestasikerja;
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
       // processRequest(request, response);
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

    private void generalPDFReports(Object[] pMyData,HttpServletRequest request, HttpServletResponse response, Map<String, Object> myMap, String fileName) throws ServletException
    {
        try
        {
            byte[] bytes = null;
            net.sf.jasperreports.engine.data.JRBeanArrayDataSource myJrDataSource = new JRBeanArrayDataSource(pMyData);
            bytes = JasperRunManager.runReportToPdf(fileName, myMap, myJrDataSource);
            serveReport(request, response, bytes);
	}
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("eee === "+e.getMessage());
	}
    }
    
    
    private void serveReport(HttpServletRequest request, HttpServletResponse response, byte[] bytes) throws IOException
    {
        InputStream inputStream = new ByteArrayInputStream(bytes);
        OutputStream outputStream = response.getOutputStream();

        response.setContentType("application/pdf");
        response.setContentLength(bytes.length);
        outputStream.write(bytes, 0, bytes.length);
        outputStream.flush();
        outputStream.close();
    }

    private String number_format(int n, int i, String string, String string0)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    
    private void getRealisasi2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
         //di index.jsp mengklik link REALISASI dan menuju ke indexRealisasi.jsp dan otomatis terisi
         //sesuai dengan nip ybs 
        String idp;
        String id = request.getParameter("nipnilai2SB");
        //String tupo = request.getParameter("idTupoksi");
        String idNiptambahan = (String) request.getAttribute("idNiptambahan");
        
        if ( id == null)
        {
            id = idNiptambahan;
        }
        
        if (id != null && id != "" && id != " ")
        {
            idp = id;
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
                    realisasi Realisasi= new GoIndex().getIdRealitas(idTupoksi, idp, idIsi4faktor);
                    nomorstr =Integer.toString(nomorHitung);
                    
                     tupoksi tupoksiak = new GoIndex().getIdtupoksiAll(idTupoksi);
                        String tmp2 = tupoksiak.getangka_krdt();
                        
String tuko = tukesiDomain.getNamaTupoksi()+ "(" + tmp2 +")";
                    
                    
                    if (Realisasi != null)
                    {
                    test.put("KUALITASR", Realisasi.getKualitasR());
                    test.put("KUANTITASR",Realisasi.getKuantitasR());
                    test.put("WAKTUR",Realisasi.getWaktuR());
                    test.put("BAYARR",Realisasi.getBiayaR());

                    test.put("NOMORTUPOKSI",nomorstr); 
                    test.put("NAMATUPOKSI",tuko); 

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
                        test.put("NAMATUPOKSI",tuko); 
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
            
            getTugasTambahan(request, response);

            //RequestDispatcher dis = request.getRequestDispatcher("indexRealisasi.jsp");
            RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/indexRealisasiBaruBiru.jsp");
            dis.forward(request, response);
        }
        else if (id == null || id == "" || id == " ")
        {
            RequestDispatcher dis = request.getRequestDispatcher("indexRealisasiBaruBiru.jsp");
            dis.forward(request, response);
        }
        else
        {}
        
    }
    
    
    
 public void getTugasTambahan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
 {
     //String id = (String) request.getAttribute("NipPns"); 
     String id = request.getParameter("nipnilai2SB");
     
     List<TugasTambahan> tugasTambahans = new GoIndex().getTugasTambahanList(id);
     request.setAttribute("tugasTambahans", tugasTambahans);
     
     List<TugasTambahan> kereaktifitas = new GoIndex().getKreatifitasList(id);
     request.setAttribute("kereaktifitas", kereaktifitas);
 }
 
 
 
 private void getTarget2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
 {
        String idB = request.getParameter("nipnilai2");
        String idR = null;
        
        if(idR == null)
        {
            //untuk button KEMBALI di isi4faktor.jsp
            //jika idB ada isinya (nip pns ybs)
            PnsSkp pns = new GoIndex().getPns(idB);

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
        }
 }
        
}