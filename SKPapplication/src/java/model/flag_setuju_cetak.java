/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author diptaisme
 */
public class flag_setuju_cetak 
{
    private String idInstansi;
    private String idDiAtasan;
    private String idUnor;
    private String nipAtasan;
    private String nipPns;
    private String flag;
    private String keterangan;
    private String periode;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getIdDiAtasan() {
        return idDiAtasan;
    }

    public void setIdDiAtasan(String idDiAtasan) {
        this.idDiAtasan = idDiAtasan;
    }

    public String getIdInstansi() {
        return idInstansi;
    }

    public void setIdInstansi(String idInstansi) {
        this.idInstansi = idInstansi;
    }

    public String getIdUnor() {
        return idUnor;
    }

    public void setIdUnor(String idUnor) {
        this.idUnor = idUnor;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getNipAtasan() {
        return nipAtasan;
    }

    public void setNipAtasan(String nipAtasan) {
        this.nipAtasan = nipAtasan;
    }

    public String getNipPns() {
        return nipPns;
    }

    public void setNipPns(String nipPns) {
        this.nipPns = nipPns;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }
    
}
