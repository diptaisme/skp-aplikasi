/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author diptaisme
 */
public class rw_periode
{
    private String idPeriode;
    private String idNipPns;
    private String idIsi4Faktor;
    private String idRealisasi;
    private String idTugasTambahan;
    private String periode;

    public String getIdIsi4Faktor() {
        return idIsi4Faktor;
    }

    public void setIdIsi4Faktor(String idIsi4Faktor) {
        this.idIsi4Faktor = idIsi4Faktor;
    }

    public String getIdNipPns() {
        return idNipPns;
    }

    public void setIdNipPns(String idNipPns) {
        this.idNipPns = idNipPns;
    }

    public String getIdPeriode() {
        return idPeriode;
    }

    public void setIdPeriode(String idPeriode) {
        this.idPeriode = idPeriode;
    }

    public String getIdRealisasi() {
        return idRealisasi;
    }

    public void setIdRealisasi(String idRealisasi) {
        this.idRealisasi = idRealisasi;
    }

    public String getIdTugasTambahan() {
        return idTugasTambahan;
    }

    public void setIdTugasTambahan(String idTugasTambahan) {
        this.idTugasTambahan = idTugasTambahan;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }
    
}
