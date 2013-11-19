/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author diptaisme
 * 
 * ini seperti DOMAIN di framework NCSIS **************
 * 
 * DOMAIN TUPOKSI
 * 
 */
public class tupoksi_lama
{
    private String id_tupoksi;
    private String nama_tupoksi;
    private String id_unor;
    private String nama_unor;
    private String id_instansi;
    private String id_diatasan;
    private String instansi_nama;
    private String angka_krdt;
    private String namaKelompok;
    private String idJenisJabatan;
    private String idJabatanFung;
    
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
    
    //FIELD = NAMA_UNOR
    public String getNamaUnor()
    {
        return nama_unor;
    }
    
    public void setNamaUnor(String sNamaUnor)
    {
        this.nama_unor = sNamaUnor;
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
     public String getangka_krdt()
    {
        return angka_krdt;
    }
    
    public void setangka_krdt(String sangka_krdt)
    {
        this.angka_krdt = sangka_krdt;
    }
    
     public String getnamaKelompok()
    {
        return namaKelompok;
    }
    
    public void setnamaKelompok(String namaKelompok)
    {
        this.namaKelompok= namaKelompok;
    }
     public String getidJenisJabatan()
    {
        return idJenisJabatan;
    }
    
    public void setidJenisJabatan(String idJenisJabatan)
    {
        this.idJenisJabatan = idJenisJabatan;
    }
   
}
