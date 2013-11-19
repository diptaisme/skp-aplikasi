/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author diptaisme
 */
public class TupoksiKeIsi4Faktor
{
    private String id_tupoksi;
    private String nama_tupoksi;
    private String id_unor;
    private String id_instansi;
    private String id_diatasan;
    private String instansi_nama;
    private String id_isi4faktor;
    private String nip_pns;
    private String id_tupoksi2;
    private String kuantitas4;
    private String kualitas4;    
    private String waktu4;
    private String biaya4;
    private String kuantitas_label;
    private String waktu_label;
     private String angka_krdt;
       private String angka_krdtR;
       private String pilih_session;
    
    
    //FIELD = ID_TUPOKSI
    public String getIdTupoksi()
    {
        return id_tupoksi;
    }
    
    public void setIdTupoksi(String sIdTupoksi)
    {
        this.id_tupoksi = sIdTupoksi;
    }
    
    //FIELD = NAMA_TUPOKSI
    public String getNamaTupoksi()
    {
        return nama_tupoksi;
    }
    
    public void setNamaTupoksi(String sNamaTupoksi)
    {
        this.nama_tupoksi = sNamaTupoksi;
    }
    
    //FIELD = ID_UNOR
    public String getIdUnor()
    {
        return id_unor;
    }
    
    public void setIdUnor(String sIdUnor)
    {
        this.id_unor = sIdUnor;
    }
    
    //FIELD = ID_INSTANSI
    public String getIdInstansi()
    {
        return id_instansi;
    }
    
    public void setIdInstansi(String sIdInstansi)
    {
        this.id_instansi = sIdInstansi;
    }
    
    //FIELD = ID_DIATASAN
    public String getIdDiAtasan()
    {
        return id_diatasan;
    }
    
    public void setIdDiAtasan(String sIdDiAtasan)
    {
        this.id_diatasan = sIdDiAtasan;
    }
    
    //FIELD = INSTANSI_NAMA
    public String getInstansiNama()
    {
        return instansi_nama;
    }
    
    public void setInstansiNama(String sInstansiNama)
    {
        this.instansi_nama = sInstansiNama;
    }
    
    
    
    
    //FIELD = ID_ISI4FAKTOR
    public String getIdIsi4Faktor()
    {
        return id_isi4faktor;
    }
    
    public void setIdIsi4Faktor(String sIdIsi4Faktor)
    {
        this.id_isi4faktor = sIdIsi4Faktor;
    }
 
    
    //FIELD = NIP_PNS
    public String getNipPns()
    {
        return nip_pns;
    }
    
    public void setNipPns(String sNipPns)
    {
        this.nip_pns = sNipPns;
    }
 
    
    //FIELD = ID_TUPOKSI
    public String getIdTupoksi2()
    {
        return id_tupoksi2;
    }
    
    public void setIdTupoksi2(String sIdTupoksi2)
    {
        this.id_tupoksi2 = sIdTupoksi2;
    }
    
    // FIELD = KUANTITAS4
    public String getKuantitas4()
    {
        return kuantitas4;
    }
    
    public void setKuantitas4(String sKuantitas4)
    {
        this.kuantitas4 = sKuantitas4;
    }
    
    //FIELD = KUALITAS4
    public String getKualitas4()
    {
        return kualitas4;
    }
    
    public void setKualitas4(String sKualitas4)
    {
        this.kualitas4 = sKualitas4;
    }
    
    //FIELD = WAKTU4
    public String getWaktu4()
    {
        return waktu4;
    }
    
    public void setWaktu4(String sWaktu4)
    {
        this.waktu4 = sWaktu4;
    }
    
    //FIELD = BIAYA4
    public String getBiaya4()
    {
        return biaya4;
    }
    
    public void setBiaya4(String sBiaya4)
    {
        
           
           //   System.out.println(formatter.format(nilai));
        
        this.biaya4 = sBiaya4;
    }
    
    
            //FIELD = kuantitas_label
    public String getkuantitas_label()
    {
        return kuantitas_label;
    }
    
    public void setkuantitas_label(String skuantitas_label)
    {
        this.kuantitas_label = skuantitas_label;
    }
    
        //FIELD = waktu_label
    public String getwaktu_label()
    {
        return waktu_label;
    }
    
    public void setwaktu_label(String swaktu_label)
    {
        this.waktu_label = swaktu_label;
    }
    
     public String getangka_krdt()
    {
        return angka_krdt;
    }
    
    public void setangka_krdt(String sangka_krdt)
    {
        this.angka_krdt = sangka_krdt;
    }
    
     public String getangka_krdtR()
    {
        return angka_krdtR;
    }
    
    public void setangka_krdtR(String sangka_krdtR)
    {
        this.angka_krdtR = sangka_krdtR;
    }
    
      public String getpilih_session()
    {
        return pilih_session;
    }
    
    public void setpilih_session(String pilih_session)
    {
        this.pilih_session = pilih_session;
    }
}
