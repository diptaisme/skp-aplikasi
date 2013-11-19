/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author diptaisme
 */
public class instansiri
{
    private String id_instansi;
    private String nama_instansi;
    private String cepat_kode;
    
    //FIELD = ID_INSTANSI
    public String getIdInstansi()
    {
        return id_instansi;
    }
    
    public void setIdInstansi(String sIdInstansi)
    {
        this.id_instansi = sIdInstansi;
    }
    
    //FIELD = NAMA_INSTANSI
    public String getNamaInstansi()
    {
        return nama_instansi;
    }
    
    public void setNamaInstansi(String sNamaInstansi)
    {
        this.nama_instansi = sNamaInstansi;
    }
    
    //FIELD = CEPAT_KODE
    public String getCepatKode()
    {
        return cepat_kode;
    }
    
    public void setCepatKode(String sCepatKode)
    {
        this.cepat_kode = sCepatKode;
    }
    
}
