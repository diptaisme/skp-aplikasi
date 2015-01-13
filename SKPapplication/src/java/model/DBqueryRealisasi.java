/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author diptaisme
 * 
 * ini seperti DAO di Framework NCSIS **************
 * 
 * DAO REALISASI
 * 
 */
public class DBqueryRealisasi
{
    Connection conn;
    
    
    public DBqueryRealisasi(Connection conn)
    {
        this.conn = conn;
    }
    
    
    
    
    public realisasi getDBqueryRealisasiId(String sid_realisasi) throws SQLException
    {
        String sql = "SELECT id_realisasi,id_isi4faktor,nip_pns,id_tupoksi,kuantitasr,kualitasr,waktur,biayar,penghitungan,nilai_capaian_skp,waktu,angka_krdt FROM realisasi WHERE id_realisasi =? ";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        realisasi irealisasi = null;
        pst.setString(1, sid_realisasi);
        ResultSet rs = pst.executeQuery();
        if (rs.next())
        {
            irealisasi = new realisasi();
            irealisasi.setIdRealisasi(rs.getString(1));
            irealisasi.setIdIsi4Faktor(rs.getString(2));
            irealisasi.setIdTupoksi(rs.getString(3));
            irealisasi.setKuantitasR(rs.getString(4));
            irealisasi.setKualitasR(rs.getString(5));
            irealisasi.setWaktuR(rs.getString(6));
            irealisasi.setBiayaR(rs.getString(7));
            irealisasi.setPenghitungan(rs.getString(8));
            irealisasi.setNilaiCapaianSKP(rs.getString(9));
            irealisasi.setWaktu(rs.getString(10));
            irealisasi.setangkaKrdt(rs.getString(11));
        }
        return irealisasi;
    }
    
    
    
    
    public realisasi getDBqueryRealisasi(String sId_Tupoksi,String snip_pns, String sid_isi4faktor) throws SQLException
    {
      //  List<realisasi> realisasies = new ArrayList<realisasi>();
        String sql = "SELECT id_realisasi,id_isi4faktor,nip_pns,id_tupoksi,kuantitasr,kualitasr,waktur,biayar,penghitungan,nilai_capaian_skp,waktu,angka_krdt FROM realisasi WHERE id_tupoksi =? and nip_pns =? and id_isi4faktor =? ";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryRealisasi nDBqueryRealisasi = null;
         realisasi irealisasi = null;
        pst.setString(1, sId_Tupoksi);
        pst.setString(2, snip_pns);
        pst.setString(3, sid_isi4faktor);
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            irealisasi = new realisasi();
            irealisasi.setIdRealisasi(rs.getString(1));
            irealisasi.setIdIsi4Faktor(rs.getString(2));
            irealisasi.setNipPns(rs.getString(3));
            irealisasi.setIdTupoksi(rs.getString(4));
            irealisasi.setKuantitasR(rs.getString(5));
            irealisasi.setKualitasR(rs.getString(6));
            irealisasi.setWaktuR(rs.getString(7));
            irealisasi.setBiayaR(rs.getString(8));
            irealisasi.setPenghitungan(rs.getString(9));
            irealisasi.setNilaiCapaianSKP(rs.getString(10));
            irealisasi.setWaktu(rs.getString(11));
            irealisasi.setangkaKrdt(rs.getString(12));
          //  realisasies.add(irealisasi);
        }
        return irealisasi;
    }
    
//    public RealisasiIsi4faktorTupoksi getFormatPenghitunganIsi4Faktor(String sId_Tupoksi,String snip_pns, String sid_isi4faktor) throws SQLException
//    {
//        String sql = "SELECT "
//                        + "r.id_realisasi,"
//                        + "r.id_isi4faktor,"
//                        + "r.nip_pns,"
//                        + "r.id_tupoksi,"
//                        + "r.kuantitasr,"
//                        + "r.kualitasr,"
//                        + "r.waktur,"
//                        + "r.biayar,"
//                        + "r.penghitungan,"
//                        + "r.nilai_capaian_skp,"
//                        + "r.waktu,"
//                        + "i.kuantitas4,"
//                        + "i.kualitas4,"
//                        + "i.waktu4,"
//                        + "i.biaya4 "
//                    + "FROM "
//                        + "realisasi r,"
//                        + "isi4faktor i "
//                    + "WHERE "
//                        + "r.id_tupoksi = '"+sId_Tupoksi+"' and "
//                        + "r.nip_pns = '"+snip_pns+"' and "
//                        + "r.id_isi4faktor = '"+sid_isi4faktor+"' and "
//                        + "r.id_isi4faktor = i.id_isi4faktor and "
//                        + "r.nip_pns = i.nip_pns and "
//                        + "r.id_tupoksi = i.id_tupoksi";
//        PreparedStatement pst = this.conn.prepareStatement(sql);
//        DBqueryRealisasi nDBqueryRealisasi = null;
//        RealisasiIsi4faktorTupoksi irealisasi = null;
////        pst.setString(1, sId_Tupoksi);
////        pst.setString(2, snip_pns);
////        pst.setString(3, sid_isi4faktor);
//        ResultSet rs = pst.executeQuery();
//        while (rs.next())
//        {
//            irealisasi = new RealisasiIsi4faktorTupoksi();
//            irealisasi.setIdRealisasi(rs.getString(1));
//            irealisasi.setIdIsi4Faktor(rs.getString(2));
//            irealisasi.setNipPns(rs.getString(3));
//            irealisasi.setIdTupoksi(rs.getString(4));
//            irealisasi.setKuantitasR(rs.getString(5));
//            irealisasi.setKualitasR(rs.getString(6));
//            irealisasi.setWaktuR(rs.getString(7));
//            irealisasi.setBiayaR(rs.getString(8));
//            
//                irealisasi.setPenghitungan(rs.getString(9));
//                irealisasi.setKuantitas4(rs.getString(12));
//                irealisasi.setKualitas4(rs.getString(13));
//                irealisasi.setWaktu4(rs.getString(14));
//                irealisasi.setBiaya4(rs.getString(15));
//                
//                String kuantitasR = irealisasi.getKuantitasR();
//                String kualitasR = irealisasi.getKualitasR(); 
//                String waktuR = irealisasi.getWaktuR();
//                String biayaR = irealisasi.getBiayaR();
//                String kuantitas4 = irealisasi.getKuantitas4();
//                String kualitas4 = irealisasi.getKualitas4(); 
//                String waktu4 = irealisasi.getWaktu4();
//                String biaya4 = irealisasi.getBiaya4();
//                
//                int ikuantitasR = Integer.parseInt(kuantitasR);  
//                int ikualitasR = Integer.parseInt(kualitasR);
//                int iwaktuR = Integer.parseInt(waktuR);
//                int ibiayaR = Integer.parseInt(biayaR);
//                int ikuantitas4 = Integer.parseInt(kuantitas4);
//                int ikualitas4 = Integer.parseInt(kualitas4);
//                int iwaktu4 = Integer.parseInt(waktu4);
//                int ibiaya4 = Integer.parseInt(biaya4);
//                
//                double dpenghitungan = ((ikuantitasR/ikuantitas4*100)+(ikualitasR/ikuantitas4*100)+(((1.76*iwaktu4-iwaktuR)/iwaktu4)*100)+(((1.76*ibiaya4-ibiayaR)/ibiaya4)*100));
//                String p = Double.toString(dpenghitungan);
//                //int ipenghitungan = Integer.parseInt(p);
//                //String penghitungan = Integer.toString(ipenghitungan);
//                
//                System.out.println("double penghitungan = "+dpenghitungan);
//                System.out.println("string penghitungan dari double = "+p);
//                //System.out.println("integer penghitungan = "+ipenghitungan);
//                //System.out.println("string penghitungan dari integer = "+penghitungan);
//                
//           irealisasi.setPenghitungan(p);
//                
//                irealisasi.setNilaiCapaianSKP(rs.getString(10));
//                
//                //int icapaian = ipenghitungan/4;
//                //String capaian = Integer.toString(icapaian);
//                double icapaian = dpenghitungan/4.0;
//                String capaian = Double.toString(icapaian);
//                
//                System.out.println("string capaian dari integer = "+capaian);
//                
//            irealisasi.setPenghitungan(capaian);
//                
//            irealisasi.setWaktu(rs.getString(11));
//          //  realisasies.add(irealisasi);
//            
////                real4faktupok.setBiayaR(rs.getString(8));
////                String sR = real4faktupok.getBiayaR();
////                if (sR.equals("-"))
////                {
////                    sR ="000000";
////                }
////                long nR = Long.parseLong(sR);
////                DecimalFormat formatterR = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
////                formatterR.setMaximumFractionDigits(2);
////                String nilaibiR = formatterR.format(nR);
////                String hasil3R = nilaibiR.toString();
////            real4faktupok.setBiayaR(hasil3R);
//            
//        }
//        return irealisasi; 
//    }
    
    
    
    public RealisasiIsi4faktorTupoksi getFormatPenghitunganIsi4FaktorDao(String sId_Tupoksi,String snip_pns) throws SQLException
    {
        String sql = "SELECT "
                        + "r.id_realisasi,"
                        + "r.id_isi4faktor,"
                        + "r.nip_pns,"
                        + "r.id_tupoksi,"
                        + "r.kuantitasr,"
                        + "r.kualitasr,"
                        + "r.waktur,"
                        + "r.biayar,"
                        + "r.penghitungan,"
                        + "r.nilai_capaian_skp,"
                        + "r.waktu,"
                        + "i.kuantitas4,"
                        + "i.kualitas4,"
                        + "i.waktu4,"
                        + "i.biaya4,"
                        + "r.angka_krdt,"
                        + "i.angka_krdt "
                    + "FROM "
                        + "realisasi r,"
                        + "isi4faktor i "
                    + "WHERE "
                        + "r.id_tupoksi = '"+sId_Tupoksi+"' and "
                        + "r.nip_pns = '"+snip_pns+"' and "
                        + "r.id_isi4faktor = i.id_isi4faktor and "
                        + "r.nip_pns = i.nip_pns and "
                        + "r.id_tupoksi = i.id_tupoksi";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryRealisasi nDBqueryRealisasi = null;
        RealisasiIsi4faktorTupoksi irealisasi = null;
//        pst.setString(1, sId_Tupoksi);
//        pst.setString(2, snip_pns);
//        pst.setString(3, sid_isi4faktor);
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            irealisasi = new RealisasiIsi4faktorTupoksi();
            irealisasi.setId_realisasi(rs.getString(1));
            irealisasi.setId_isi4faktor(rs.getString(2));
            irealisasi.setNip_pns(rs.getString(3));
            irealisasi.setId_tupoksi(rs.getString(4));
            irealisasi.setKuantitasr(rs.getString(5));
            irealisasi.setKualitasr(rs.getString(6));
            irealisasi.setWaktur(rs.getString(7));
            irealisasi.setBiayar(rs.getString(8));
            
                irealisasi.setPenghitungan(rs.getString(9));
                irealisasi.setKuantitas4(rs.getString(12));
                irealisasi.setKualitas4(rs.getString(13));
                irealisasi.setWaktu4(rs.getString(14));
                irealisasi.setBiaya4(rs.getString(15));
                irealisasi.setangkaKrdtr(rs.getString(16));
                irealisasi.setangkaKrdt4(rs.getString(17));
                
                String idtupoksiang= irealisasi.getId_tupoksi();
                
                String kuantitasR = irealisasi.getKuantitasr();
                String kualitasR = irealisasi.getKualitasr(); 
                String waktuR = irealisasi.getWaktur();
                String biayaR = irealisasi.getBiayar();
                String kuantitas4 = irealisasi.getKuantitas4();
                String kualitas4 = irealisasi.getKualitas4(); 
                String waktu4 = irealisasi.getWaktu4();
                String biaya4 = irealisasi.getBiaya4();
                
                String angkaKrdtr = irealisasi.getangkaKrdtr();
                String angkaKrdt4 = irealisasi.getangkaKrdt4();
                
               DecimalFormat formatterR = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
               
                validasiString vs = new validasiString();
                 
                
                 vs.setkoma(angkaKrdtr);
                 angkaKrdtr = vs.getmashudi();
                 
                 vs.setkoma(angkaKrdt4);
                 angkaKrdt4 = vs.getmashudi();
                
                vs.setmashudi(kuantitasR);
                kuantitasR = vs.getmashudi();
                
                vs.setmashudi(kualitasR);
                kualitasR = vs.getmashudi();
                
                vs.setmashudi(waktuR);
                waktuR = vs.getmashudi();
                
                vs.setmashudi(biayaR);
                biayaR = vs.getmashudi();
                
                vs.setmashudi(kuantitas4);
                kuantitas4 = vs.getmashudi();
                
                vs.setmashudi(kualitas4);
                kualitas4 = vs.getmashudi();
                
                vs.setmashudi(waktu4);
                waktu4 = vs.getmashudi();
                
                vs.setmashudi(biaya4);
                biaya4 = vs.getmashudi();
                
              /* int ikuantitasR = Integer.parseInt(kuantitasR);  
                int ikualitasR = Integer.parseInt(kualitasR);
                int iwaktuR = Integer.parseInt(waktuR);
                int ibiayaR = Integer.parseInt(biayaR);
                int ikuantitas4 = Integer.parseInt(kuantitas4);
                int ikualitas4 = Integer.parseInt(kualitas4);
                int iwaktu4 = Integer.parseInt(waktu4);
                int ibiaya4 = Integer.parseInt(biaya4);*/
                
                double ikuantitasR = Double.parseDouble(kuantitasR);  
                double  ikualitasR = Double.parseDouble(kualitasR);
                double  iwaktuR = Double.parseDouble(waktuR);
                double  ibiayaR = Double.parseDouble(biayaR);
                double  ikuantitas4 = Double.parseDouble(kuantitas4);
                double  ikualitas4 = Double.parseDouble(kualitas4);
                double  iwaktu4 =Double.parseDouble(waktu4);
                double  ibiaya4 = Double.parseDouble(biaya4);
                
                
                double dpenghitunganDalam;
                String pq = null;
                double test = ((((1.76*ibiaya4)-ibiayaR)/ibiaya4)*100);
                if(ikuantitasR == 0 || ikualitasR == 0 || iwaktuR == 0)
                {
                    dpenghitunganDalam = 0;
                }
                else
                {
                    if (ibiaya4 == 0){
                        
                     dpenghitunganDalam =((ikuantitasR/ikuantitas4)*100)+((ikualitasR/ikualitas4)*100)+((((1.76*iwaktu4)-iwaktuR)/iwaktu4)*100);
                }else{

                    dpenghitunganDalam =((ikuantitasR/ikuantitas4)*100)+((ikualitasR/ikualitas4)*100)+((((1.76*iwaktu4)-iwaktuR)/iwaktu4)*100)+((((1.76*ibiaya4)-ibiayaR)/ibiaya4)*100);
                    }
                    pq = Double.toString(dpenghitunganDalam);
                    
                }
                //=((K10/D10*100)+(M10/F10*100)+(((1,76*G10-N10)/G10)*100)+(((1,76*I10-P10)/I10)*100))
                double dpenghitungan = dpenghitunganDalam;
                String p = pq;
                
                //int ipenghitungan = Integer.parseInt(p);
                //String penghitungan = Integer.toString(ipenghitungan);
                double ddkualitas = ((ikuantitasR/ikuantitas4)*100);
                double ddkuantitas = ((ikualitasR/ikualitas4)*100);
                
                double ddwaktu = ((((1.76*iwaktu4)-iwaktuR)/iwaktu4)*100);
                
              //   double ddwaktu = 100 - (iwaktuR/iwaktu4*100);
                    if (ddwaktu > 100)
                    //if (ddwaktu > ((iwaktu4*24)/100))
                    {
                        double x = ddwaktu - 100;
                        ddwaktu = 76 - x;
                    }
                    
                   
                double ddbiaya = ((((1.76*ibiaya4)-ibiayaR)/ibiaya4)*100);
                    //penambahan 04-09-2012
                    if (ddbiaya > 100)
                    //if (ddwaktu > ((iwaktu4*24)/100))
                    {
                        double x = ddbiaya - 100;
                        ddbiaya = 76 - x;
                    }
                    if (ibiaya4 == 0){
                        ddbiaya = 0;
                    }
                 dpenghitunganDalam=ddkualitas+ddkuantitas+ddwaktu+ddbiaya;
                 
                 pq = Double.toString(dpenghitunganDalam);
                 p = pq;
             //    long n4 = Long.parseLong(pq);
                 formatterR = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
                 formatterR.setMaximumFractionDigits(2);
                 p= formatterR.format(dpenghitunganDalam);
                
                System.out.println("double penghitungan = "+dpenghitungan);
                System.out.println("string penghitungan dari double = "+p);
                System.out.println("kualitas = "+ddkualitas);
                System.out.println("kuantitas = "+ddkuantitas);
                System.out.println("waktu = "+ddwaktu);
                System.out.println("biaya = "+ddbiaya);
                //System.out.println("integer penghitungan = "+ipenghitungan);
                //System.out.println("string penghitungan dari integer = "+penghitungan);
                
           irealisasi.setPenghitungan(p);
                
                irealisasi.setNilai_capaian_skp(rs.getString(10));
                
                //int icapaian = ipenghitungan/4;
                //String capaian = Integer.toString(icapaian);
                double icapaian;
                if (ibiaya4 == 0 || ibiayaR == 0 || "-".equals(biaya4) || "-".equals(biayaR) || biaya4 == null || biayaR == null)
                {
                    icapaian = dpenghitungan/3.0;
                }
                else
                {
                    icapaian = dpenghitungan/4.0;
                }
               // String capaian = Double.toString(icapaian);
                
                  String capaian =formatterR.format(icapaian);

                System.out.println("string capaian dari integer = "+capaian);
                
            irealisasi.setNilai_capaian_skp(capaian);
                
            irealisasi.setWaktu(rs.getString(11));
          //  realisasies.add(irealisasi);
            
//                real4faktupok.setBiayaR(rs.getString(8));
//                String sR = real4faktupok.getBiayaR();
//                if (sR.equals("-"))
//                {
//                    sR ="000000";
//                }
//                long nR = Long.parseLong(sR);
//                DecimalFormat formatterR = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
//                formatterR.setMaximumFractionDigits(2);
//                String nilaibiR = formatterR.format(nR);
//                String hasil3R = nilaibiR.toString();
//            real4faktupok.setBiayaR(hasil3R);
            
        }
        return irealisasi; 
    }
    
    public RealisasiIsi4faktorTupoksi getFormatPenghitungansessionIsi4FaktorDao(String sId_Tupoksi,String snip_pns,String session) throws SQLException
    {
        String sql = "SELECT "
                        + "r.id_realisasi,"
                        + "r.id_isi4faktor,"
                        + "r.nip_pns,"
                        + "r.id_tupoksi,"
                        + "r.kuantitasr,"
                        + "r.kualitasr,"
                        + "r.waktur,"
                        + "r.biayar,"
                        + "r.penghitungan,"
                        + "r.nilai_capaian_skp,"
                        + "r.waktu,"
                        + "i.kuantitas4,"
                        + "i.kualitas4,"
                        + "i.waktu4,"
                        + "i.biaya4,"
                        + "r.angka_krdt,"
                        + "i.angka_krdt "
                    + "FROM "
                        + "realisasi r,"
                        + "isi4faktor i "
                    + "WHERE "
                        + "r.id_tupoksi = '"+sId_Tupoksi+"' and "
                        + "r.nip_pns = '"+snip_pns+"' and "
                        + "r.session = '"+session+"' and "
                        + "r.id_isi4faktor = i.id_isi4faktor and "
                        + "r.nip_pns = i.nip_pns and "
                        + "r.id_tupoksi = i.id_tupoksi";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryRealisasi nDBqueryRealisasi = null;
        RealisasiIsi4faktorTupoksi irealisasi = null;
//        pst.setString(1, sId_Tupoksi);
//        pst.setString(2, snip_pns);
//        pst.setString(3, sid_isi4faktor);
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            irealisasi = new RealisasiIsi4faktorTupoksi();
            irealisasi.setId_realisasi(rs.getString(1));
            irealisasi.setId_isi4faktor(rs.getString(2));
            irealisasi.setNip_pns(rs.getString(3));
            irealisasi.setId_tupoksi(rs.getString(4));
            irealisasi.setKuantitasr(rs.getString(5));
            irealisasi.setKualitasr(rs.getString(6));
            irealisasi.setWaktur(rs.getString(7));
            irealisasi.setBiayar(rs.getString(8));
            
                irealisasi.setPenghitungan(rs.getString(9));
                irealisasi.setKuantitas4(rs.getString(12));
                irealisasi.setKualitas4(rs.getString(13));
                irealisasi.setWaktu4(rs.getString(14));
                irealisasi.setBiaya4(rs.getString(15));
                irealisasi.setangkaKrdtr(rs.getString(16));
                irealisasi.setangkaKrdt4(rs.getString(17));
                
                String idtupoksiang= irealisasi.getId_tupoksi();
                
                String kuantitasR = irealisasi.getKuantitasr();
                String kualitasR = irealisasi.getKualitasr(); 
                String waktuR = irealisasi.getWaktur();
                String biayaR = irealisasi.getBiayar();
                String kuantitas4 = irealisasi.getKuantitas4();
                String kualitas4 = irealisasi.getKualitas4(); 
                String waktu4 = irealisasi.getWaktu4();
                String biaya4 = irealisasi.getBiaya4();
                
                String angkaKrdtr = irealisasi.getangkaKrdtr();
                String angkaKrdt4 = irealisasi.getangkaKrdt4();
                
               DecimalFormat formatterR = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
               
                validasiString vs = new validasiString();
                 
                
                 vs.setkoma(angkaKrdtr);
                 angkaKrdtr = vs.getmashudi();
                 
                 vs.setkoma(angkaKrdt4);
                 angkaKrdt4 = vs.getmashudi();
                
                vs.setmashudi(kuantitasR);
                kuantitasR = vs.getmashudi();
                
                vs.setmashudi(kualitasR);
                kualitasR = vs.getmashudi();
                
                vs.setmashudi(waktuR);
                waktuR = vs.getmashudi();
                
                vs.setmashudi(biayaR);
                biayaR = vs.getmashudi();
                
                vs.setmashudi(kuantitas4);
                kuantitas4 = vs.getmashudi();
                
                vs.setmashudi(kualitas4);
                kualitas4 = vs.getmashudi();
                
                vs.setmashudi(waktu4);
                waktu4 = vs.getmashudi();
                
                vs.setmashudi(biaya4);
                biaya4 = vs.getmashudi();
                
              /* int ikuantitasR = Integer.parseInt(kuantitasR);  
                int ikualitasR = Integer.parseInt(kualitasR);
                int iwaktuR = Integer.parseInt(waktuR);
                int ibiayaR = Integer.parseInt(biayaR);
                int ikuantitas4 = Integer.parseInt(kuantitas4);
                int ikualitas4 = Integer.parseInt(kualitas4);
                int iwaktu4 = Integer.parseInt(waktu4);
                int ibiaya4 = Integer.parseInt(biaya4);*/
                
                double ikuantitasR = Double.parseDouble(kuantitasR);  
                double  ikualitasR = Double.parseDouble(kualitasR);
                double  iwaktuR = Double.parseDouble(waktuR);
                double  ibiayaR = Double.parseDouble(biayaR);
                double  ikuantitas4 = Double.parseDouble(kuantitas4);
                double  ikualitas4 = Double.parseDouble(kualitas4);
                double  iwaktu4 =Double.parseDouble(waktu4);
                double  ibiaya4 = Double.parseDouble(biaya4);
                
                
                double dpenghitunganDalam;
                String pq = null;
                double test = ((((1.76*ibiaya4)-ibiayaR)/ibiaya4)*100);
                if(ikuantitasR == 0 || ikualitasR == 0 || iwaktuR == 0)
                {
                    dpenghitunganDalam = 0;
                }
                else
                {
                    if (ibiaya4 == 0){
                        
                     dpenghitunganDalam =((ikuantitasR/ikuantitas4)*100)+((ikualitasR/ikualitas4)*100)+((((1.76*iwaktu4)-iwaktuR)/iwaktu4)*100);
                }else{

                    dpenghitunganDalam =((ikuantitasR/ikuantitas4)*100)+((ikualitasR/ikualitas4)*100)+((((1.76*iwaktu4)-iwaktuR)/iwaktu4)*100)+((((1.76*ibiaya4)-ibiayaR)/ibiaya4)*100);
                    }
                    pq = Double.toString(dpenghitunganDalam);
                    
                }
                //=((K10/D10*100)+(M10/F10*100)+(((1,76*G10-N10)/G10)*100)+(((1,76*I10-P10)/I10)*100))
                double dpenghitungan = dpenghitunganDalam;
                String p = pq;
                
                //int ipenghitungan = Integer.parseInt(p);
                //String penghitungan = Integer.toString(ipenghitungan);
                double ddkualitas = ((ikuantitasR/ikuantitas4)*100);
                double ddkuantitas = ((ikualitasR/ikualitas4)*100);
                
                double ddwaktu = ((((1.76*iwaktu4)-iwaktuR)/iwaktu4)*100);
                
              //   double ddwaktu = 100 - (iwaktuR/iwaktu4*100);
                    if (ddwaktu > 100)
                    //if (ddwaktu > ((iwaktu4*24)/100))
                    {
                        double x = ddwaktu - 100;
                        ddwaktu = 76 - x;
                    }
                    
                   
                double ddbiaya = ((((1.76*ibiaya4)-ibiayaR)/ibiaya4)*100);
                    //penambahan 04-09-2012
                    if (ddbiaya > 100)
                    //if (ddwaktu > ((iwaktu4*24)/100))
                    {
                        double x = ddbiaya - 100;
                        ddbiaya = 76 - x;
                    }
                    if (ibiaya4 == 0){
                        ddbiaya = 0;
                    }
                 dpenghitunganDalam=ddkualitas+ddkuantitas+ddwaktu+ddbiaya;
                 
                 pq = Double.toString(dpenghitunganDalam);
                 p = pq;
             //    long n4 = Long.parseLong(pq);
                 formatterR = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
                 formatterR.setMaximumFractionDigits(2);
                 p= formatterR.format(dpenghitunganDalam);
                
                System.out.println("double penghitungan = "+dpenghitungan);
                System.out.println("string penghitungan dari double = "+p);
                System.out.println("kualitas = "+ddkualitas);
                System.out.println("kuantitas = "+ddkuantitas);
                System.out.println("waktu = "+ddwaktu);
                System.out.println("biaya = "+ddbiaya);
                //System.out.println("integer penghitungan = "+ipenghitungan);
                //System.out.println("string penghitungan dari integer = "+penghitungan);
                
           irealisasi.setPenghitungan(p);
                
                irealisasi.setNilai_capaian_skp(rs.getString(10));
                
                //int icapaian = ipenghitungan/4;
                //String capaian = Integer.toString(icapaian);
                double icapaian;
                if (ibiaya4 == 0 || ibiayaR == 0 || "-".equals(biaya4) || "-".equals(biayaR) || biaya4 == null || biayaR == null)
                {
                    icapaian = dpenghitunganDalam/3.0;
                }
                else
                {
                    icapaian = dpenghitunganDalam/4.0;
                }
               // String capaian = Double.toString(icapaian);
                
                  String capaian =formatterR.format(icapaian);

                System.out.println("string capaian dari integer = "+capaian);
                
            irealisasi.setNilai_capaian_skp(capaian);
                
            irealisasi.setWaktu(rs.getString(11));
          //  realisasies.add(irealisasi);
            
//                real4faktupok.setBiayaR(rs.getString(8));
//                String sR = real4faktupok.getBiayaR();
//                if (sR.equals("-"))
//                {
//                    sR ="000000";
//                }
//                long nR = Long.parseLong(sR);
//                DecimalFormat formatterR = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
//                formatterR.setMaximumFractionDigits(2);
//                String nilaibiR = formatterR.format(nR);
//                String hasil3R = nilaibiR.toString();
//            real4faktupok.setBiayaR(hasil3R);
            
        }
        return irealisasi; 
    }
    
    
    
    public RealisasiIsi4faktorTupoksi getIsiRealisasi4Faktor(String sId_Tupoksi,String snip_pns, String sid_isi4faktor) throws SQLException
    {
        String sql = "SELECT "
                        + "r.id_realisasi,"
                        + "r.id_isi4faktor,"
                        + "r.nip_pns,"
                        + "r.id_tupoksi,"
                        + "r.kuantitasr,"
                        + "r.kualitasr,"
                        + "r.waktur,"
                        + "r.biayar,"
                        + "r.penghitungan,"
                        + "r.nilai_capaian_skp,"
                        + "r.waktu,"
                        + "i.kuantitas4,"
                        + "i.kualitas4,"
                        + "i.waktu4,"
                        + "r.angka_krdt,"
                        + "i.angka_krdt,"
                        + "i.biaya4 "
                    + "FROM "
                        + "realisasi r,"
                        + "isi4faktor i "
                    + "WHERE "
                        + "r.id_tupoksi = '"+sId_Tupoksi+"' and "
                        + "r.nip_pns = '"+snip_pns+"' and "
                        + "r.id_isi4faktor = '"+sid_isi4faktor+"' and "
                        + "r.id_isi4faktor = i.id_isi4faktor and "
                        + "r.nip_pns = i.nip_pns and "
                        + "r.id_tupoksi = i.id_tupoksi";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryRealisasi nDBqueryRealisasi = null;
        RealisasiIsi4faktorTupoksi irealisasi = null;
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            irealisasi = new RealisasiIsi4faktorTupoksi();
            irealisasi.setId_realisasi(rs.getString(1));
            irealisasi.setId_isi4faktor(rs.getString(2));
            irealisasi.setNip_pns(rs.getString(3));
            irealisasi.setId_tupoksi(rs.getString(4));
            irealisasi.setKuantitasr(rs.getString(5));
            irealisasi.setKualitasr(rs.getString(6));
            irealisasi.setWaktur(rs.getString(7));
            irealisasi.setBiayar(rs.getString(8));
            irealisasi.setPenghitungan(rs.getString(9));
            irealisasi.setNilai_capaian_skp(rs.getString(10));    
            irealisasi.setWaktu(rs.getString(11));
            irealisasi.setKuantitas4(rs.getString(12));
            irealisasi.setKualitas4(rs.getString(13));
            irealisasi.setWaktu4(rs.getString(14));
             irealisasi.setangkaKrdtr(rs.getString(15));
            irealisasi.setangkaKrdt4(rs.getString(16));
            irealisasi.setBiaya4(rs.getString(17));  
        }
        return irealisasi; 
    }
    
    
    
    
    
      public List<realisasi> getDBqueryRealisasiNip(String snip_pns) throws SQLException
    {
        List<realisasi> realisasies = new ArrayList<realisasi>();
        String sql = "SELECT id_realisasi,id_isi4faktor,nip_pns,id_tupoksi,kuantitasr,kualitasr,waktur,biayar,penghitungan,nilai_capaian_skp,waktu,angka_krdt FROM realisasi WHERE  nip_pns =? ";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        DBqueryRealisasi nDBqueryRealisasi = null;
        pst.setString(1, snip_pns);
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            realisasi irealisasi = new realisasi();
            irealisasi.setIdRealisasi(rs.getString(1));
            irealisasi.setIdIsi4Faktor(rs.getString(2));
            irealisasi.setIdTupoksi(rs.getString(3));
            irealisasi.setKuantitasR(rs.getString(4));
            irealisasi.setKualitasR(rs.getString(5));
            irealisasi.setWaktuR(rs.getString(6));
            irealisasi.setBiayaR(rs.getString(7));
            irealisasi.setPenghitungan(rs.getString(8));
            irealisasi.setNilaiCapaianSKP(rs.getString(9));
            irealisasi.setWaktu(rs.getString(10));
             irealisasi.setangkaKrdt(rs.getString(11));
            realisasies.add(irealisasi);
        }
        return realisasies;
    }
      
       public String getDBquery_angka_krdt(String sid_tupoksi) throws SQLException
    {   
        String sql2 = "SELECT angka_krdt FROM struktural_bkn WHERE  id_tupoksi = '"+sid_tupoksi+"' ";
        PreparedStatement pst2 = this.conn.prepareStatement(sql2);
        String _angka_krdt = null;
        ResultSet rs2 = pst2.executeQuery();
        if (rs2.next())
        {
            _angka_krdt = rs2.getString("angka_krdt");
        }  
        return _angka_krdt;
    }
      
     
      
}
