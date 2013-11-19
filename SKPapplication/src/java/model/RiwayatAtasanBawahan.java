/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Sony
 */
public class RiwayatAtasanBawahan {
     private  String idAtasani;
    private String instansiIdAtasan;
    private String UnorIdatasan;
    private  String instansiIdpnsBawahan;
    private String instansiIdunorbawahan;    
    
      public String getidAtasani()
    {
        return idAtasani;
    }
    
    public void setidAtasani(String idAtasani)
    {
        this.idAtasani = idAtasani;
    }
 
    
    //FIELD = NIP_PNS
    public String geinstansiIdAtasan()
    {
        return instansiIdAtasan;
    }
    
    public void setinstansiIdAtasan(String instansiIdAtasan)
    {
        this.instansiIdAtasan = instansiIdAtasan;
    }
 
    
    //FIELD = ID_TUPOKSI
    public String getUnorIdatasan()
    {
        return UnorIdatasan;
    }
    
    public void setUnorIdatasan(String UnorIdatasan)
    {
        this.UnorIdatasan= UnorIdatasan;
    }
    
    // FIELD = KUANTITAS4
    public String getinstansiIdpnsBawahan()
    {
        return instansiIdpnsBawahan;
    }
    
    public void setinstansiIdpnsBawahan(String instansiIdpnsBawahan)
    {
        this.instansiIdpnsBawahan = instansiIdpnsBawahan;
    }
    
    //FIELD = KUALITAS4
    public String getinstansiIdunorbawahan()
    {
        return instansiIdunorbawahan;
    }
    
    public void setinstansiIdunorbawahan(String instansiIdunorbawahan)
    {
        this.instansiIdunorbawahan = instansiIdunorbawahan;
    }
    
}
