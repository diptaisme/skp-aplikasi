/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author diptaisme
 */
public class unorskp
{
    private String idunor;
    private String instansi_id;
    private String diatasan_id;
    private String eselon_id;
    private String nama_unor;
    private String nama_jabatan;
    private String pemimpin_pns_id;
    private String lev;
    
    //FIELD = IDUNOR
    public String getIdUnor()
    {
        return idunor;
    }
    
    public void setIdUnor(String idunor)
    {
        this.idunor = idunor;
    }
    
    //FIELD = INSTANSI_ID
    public String getInstansiId()
    {
        return instansi_id;
    }
    
    public void setInstansiId(String instansi_id)
    {
        this.instansi_id = instansi_id;
    }
    
    //FIELD = DIATASAN_ID
    public String getDiAtasanId()
    {
        return diatasan_id;
    }
    
    public void setDiAtasanId(String diatasan_id)
    {
        this.diatasan_id = diatasan_id;
    }
    
    //FIELD = ESELON_ID
    public String getEselonId()
    {
        return eselon_id;
    }
    
    public void setEselonId(String eselon_id)
    {
        this.eselon_id = eselon_id;
    }
    
    //FIELD = NAMA_UNOR
    public String getNamaUnor()
    {
        return nama_unor;
    }
    
    public void setNamaUnor(String nama_unor)
    {
        this.nama_unor = nama_unor;
    }
    
    //FIELD = NAMA_JABATAN
    public String getNamaJabatan()
    {
        return nama_jabatan;
    }
    
    public void setNamaJabatan(String nama_jabatan)
    {
        this.nama_jabatan = nama_jabatan;
    }
            
    //FIELD = PEMIMPIN_PNS_ID
    public String getPemimpinPnsId()
    {
        return pemimpin_pns_id;
    }
    
    public void setPemimpinPnsId(String pemimpin_pns_id)
    {
        this.pemimpin_pns_id = pemimpin_pns_id;
    }
     public String getLevel() {
        return lev;
    }

    public void setLevel(String lev) {
        this.lev = lev;
    }
       
}
