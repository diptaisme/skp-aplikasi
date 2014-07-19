/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Sony
 */
public class Revisi4FaktorTarget {

    private String revisi;
     private String id_revisiTarget;
    private String id_isi4faktor;
    private String nip_pns;
    private String id_tupoksi;
    private String kuantitas4;
    private String kualitas4;
    private String waktu4;
    private String biaya4;
    private String kuantitas_label;
    private String waktu_label;
    private String idUnor;

   
     public String getrevisi() {
        return revisi;
    }

    public void setrevisi(String srevisi) {
        this.revisi = srevisi;
    }
    
     public String getid_revisiTarget() {
        return id_revisiTarget;
    }

    public void setid_revisiTarget(String sid_revisiTarget) {
        this.id_revisiTarget = sid_revisiTarget;
    }
    
    public String getIdIsi4Faktor() {
        return id_isi4faktor;
    }

    public void setIdIsi4Faktor(String sIdIsi4Faktor) {
        this.id_isi4faktor = sIdIsi4Faktor;
    }

    //FIELD = NIP_PNS
    public String getNipPns() {
        return nip_pns;
    }

    public void setNipPns(String sNipPns) {
        this.nip_pns = sNipPns;
    }

    //FIELD = ID_TUPOKSI
    public String getIdTupoksi() {
        return id_tupoksi;
    }

    public void setIdTupoksi(String sIdTupoksi) {
        this.id_tupoksi = sIdTupoksi;
    }

    // FIELD = KUANTITAS4
    public String getKuantitas4() {
        return kuantitas4;
    }

    public void setKuantitas4(String sKuantitas4) {
        this.kuantitas4 = sKuantitas4;
    }

    //FIELD = KUALITAS4
    public String getKualitas4() {
        return kualitas4;
    }

    public void setKualitas4(String sKualitas4) {
        this.kualitas4 = sKualitas4;
    }

    //FIELD = WAKTU4
    public String getWaktu4() {
        return waktu4;
    }

    public void setWaktu4(String sWaktu4) {
        this.waktu4 = sWaktu4;
    }

    //FIELD = BIAYA4
    public String getBiaya4() {
        return biaya4;
    }

    public void setBiaya4(String sBiaya4) {
        this.biaya4 = sBiaya4;
    }

    //FIELD = kuantitas_label
    public String getkuantitas_label() {
        return kuantitas_label;
    }

    public void setkuantitas_label(String skuantitas_label) {
        this.kuantitas_label = skuantitas_label;
    }

    //FIELD = waktu_label
    public String getwaktu_label() {
        return waktu_label;
    }

    public void setwaktu_label(String swaktu_label) {
        this.waktu_label = swaktu_label;
    }

    public String getidUnor() {
        return idUnor;
    }

    public void setidUnor(String sidUnor) {
        this.idUnor = sidUnor;
    }
}
