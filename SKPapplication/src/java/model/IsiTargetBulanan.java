/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author radius
 */
public class IsiTargetBulanan {

    private String id;
    private String id_Isi4faktor;
    private String nip_pns;
    private String id_tupoksi;
    private String kuantitas_bulan;
    private String kualitas_bulan;
    private String waktu_bulan;
    private String biaya_bulan;
    private String bulanke;
    private String namaTupoksi;
            

    public String getNamaTupoksi() {
        return namaTupoksi;
    }

    public void setNamaTupoksi(String namaTupoksi) {
        this.namaTupoksi = namaTupoksi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //FIELD = NAMA_TUPOKSI
    public String getid_Isi4faktor() {
        return id_Isi4faktor;

    }

    public void setid_Isi4faktor(String id_isi4faktor) {
        this.id_Isi4faktor = id_isi4faktor;
    }

    //FIELD = ID_UNOR
    public String getnip_pns() {
        return nip_pns;
    }

    public void setnip_pns(String nip_pns) {
        this.nip_pns = nip_pns;
    }

    //FIELD = NAMA_UNOR
    public String getid_tupoksi() {
        return id_tupoksi;
    }

    public void setid_tupoksi(String id_tupoksi) {
        this.id_tupoksi = id_tupoksi;
    }

    //FIELD = ID_INSTANSI
    public String getkuantitas_bulan() {
        return kuantitas_bulan;
    }

    public void setkuantitas_bulan(String kuantitas_bulan) {
        this.kuantitas_bulan = kuantitas_bulan;
    }

    //FIELD = ID_DIATASAN
    public String getkualitas_bulan() {
        return kualitas_bulan;
    }

    public void setkualitas_bulan(String kualitas_bulan) {
        this.kualitas_bulan = kualitas_bulan;
    }

    //FIELD = INSTANSI_NAMA
    public String getwaktu_bulan() {
        return waktu_bulan;
    }

    public void setwaktu_bulan(String waktu_bulan) {
        this.waktu_bulan = waktu_bulan;
    }

    public String biaya_bulan() {
        return biaya_bulan;
    }

    public void setbiaya_bulan(String biaya_bulan) {
        if(biaya_bulan.equals("-") || biaya_bulan.equals(" ") || biaya_bulan==null){
             biaya_bulan="0";
        }
        this.biaya_bulan = biaya_bulan;
    }

    public String bulanke() {
        return bulanke;
    }

    public void setbulanke(String bulanke) {
        this.bulanke = bulanke;
    }

    public String getbulanke() {
        return bulanke;
    }
}
