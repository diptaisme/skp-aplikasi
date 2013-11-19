///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package model;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// *
// * @author diptaisme
// */
//public class ReportIsi4FaktorCommand
//{
//    private static String defaultDirectory = "reports" + File.separator;
//    
//    public static final String VAR_REPORTISI4FAKTOR = "var_reportisi4faktor";
//    
//    private static String var_reportisi4faktor = defaultDirectory + "report_isi4faktor.jasper";
//    
//    
//    
//    
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
//    {
//        DateFormat rf = new SimpleDateFormat("dd-MM-yyyy");
//        String baseDir = getBaseDirectory(request);
//	String typeReport = request.getParameter("typeReport");
//        String fileName = "";
//	String jenisReporting = "";
//        
//        jenisReporting = "ISI4FAKTOR";
//        fileName = baseDir + "/" + getRptIsi4Faktor();
//        
//        
//    }
//    
//    
//    
//    
//    protected static String getBaseDirectory(HttpServletRequest request) 
//    {
//        return request.getSession().getServletContext().getRealPath("/WEB-INF/");
//    }
//    
//    
//    
//    public static void setRptIsi4Faktor(String rptIsi4Faktor)
//    {
//	rptIsi4Faktor = rptIsi4Faktor;
//    }
//
//
//    public static String getRptIsi4Faktor()
//    {
//	return var_reportisi4faktor;
//    }
//}
