/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author diptaisme
 */
public class RealisasiIsi4faktorTupoksi
{
    private String id_realisasi;
    private String id_isi4faktor;
    private String nip_pns;
    private String id_tupoksi;
    private String kuantitasr;
    private String kualitasr;
    private String waktur;
    private String biayar;
    private String penghitungan;
    private String nilai_capaian_skp;
    private String waktu;
    private String angkaKrdtr;
    
    private String id_tupoksi_dariTupoksi;
    private String nama_tupoksi;
    private String id_unor;
    private String nama_unor;
    private String id_instansi;
    private String id_diatasan;
    private String instansi_nama;
    
    private String id_isi4faktor_dariIsi4Faktor;
    private String nip_pns_dariIsi4Faktor;
    private String id_tupoksi_dariIsi4Faktor;
    private String kuantitas4;
    private String kualitas4;    
    private String waktu4;
    private String biaya4;
    private String kuantitas_label;
    private String waktu_label;
    private String angkaKrdt4;
       private String _pilih_session;
     private String _idUnor;
    
//    //FIELD = ID_REALISASI
//    public String getIdRealisasi()
//    {
//        return id_realisasi;
//    }
//    
//    public void setIdRealisasi(String sIdRealisasi)
//    {
//        this.id_realisasi = sIdRealisasi;
//    }
//    
//    //FIELD = ID_ISI4FAKTOR
//    public String getIdIsi4Faktor()
//    {
//        return id_isi4faktor;
//    }
//    
//    public void setIdIsi4Faktor(String sIdIsi4Faktor)
//    {
//        this.id_isi4faktor = sIdIsi4Faktor;
//    }
//    
//    //FIELD = NIP_PNS
//    public String getNipPns()
//    {
//        return nip_pns;
//    }
//    
//    public void setNipPns(String sNipPns)
//    {
//        this.nip_pns = sNipPns;
//    }
//    
//    //FIELD = ID_TUPOKSI
//    public String getIdTupoksi()
//    {
//        return id_tupoksi;
//    }
//    
//    public void setIdTupoksi(String sIdTupoksi)
//    {
//        this.id_tupoksi = sIdTupoksi;
//    }
//    
//    //FIELD = KUANTITASR
//    public String getKuantitasR()
//    {
//        return kuantitasr;
//    }
//    
//    public void setKuantitasR(String sKuantitasR)
//    {
//        this.kuantitasr = sKuantitasR;
//    }
//    
//    //FIELD = KUALITASR
//    public String getKualitasR()
//    {
//        return kualitasr;
//    }
//    
//    public void setKualitasR(String sKualitasR)
//    {
//        this.kualitasr = sKualitasR;
//    }
//    
//    //FIELD = WAKTUR
//    public String getWaktuR()
//    {
//        return waktur;
//    }
//    
//    public void setWaktuR(String sWaktuR)
//    {
//        this.waktur = sWaktuR;
//    }
//    
//    //FIELD = BIAYAR
//    public String getBiayaR()
//    {
//        return biayar;
//    }
//    
//    public void setBiayaR(String sBiayaR)
//    {
//        this.biayar = sBiayaR;
//    }
//    
//    //FIELD = PENGHITUNGAN
//    public String getPenghitungan()
//    {
//        return penghitungan;
//    }
//    
//    public void setPenghitungan(String sPenghitungan)
//    {
//        this.penghitungan = sPenghitungan;
//    }
//    
//    //FIELD = NILAI_CAPAIAN_SKP
//    public String getNilaiCapaianSKP()
//    {
//        return nilai_capaian_skp;
//    }
//    
//    public void setNilaiCapaianSKP(String sNilaiCapaianSKP)
//    {
//        this.nilai_capaian_skp = sNilaiCapaianSKP;
//    }
//    
//    //FIELD = WAKTU
//    public String getWaktu()
//    {
//        return waktu;
//    }
//    
//    public void setWaktu(String sWaktu)
//    {
//        this.waktu = sWaktu;
//    }
//    
//    
//    
//    
//    //FIELD = ID_TUPOKSI
//    public String getid_tupoksi_dariTupoksi()
//    {
//        return id_tupoksi_dariTupoksi;
//    }
//    
//    public void setid_tupoksi_dariTupoksi(String sIdTupoksi)
//    {
//        this.id_tupoksi_dariTupoksi = sIdTupoksi;
//    }
//    
//    //FIELD = NAMA_TUPOKSI
//    public String getNamaTupoksi()
//    {
//        return nama_tupoksi;
//    }
//    
//    public void setNamaTupoksi(String sNamaTupoksi)
//    {
//        this.nama_tupoksi = sNamaTupoksi;
//    }
//    
//    //FIELD = ID_UNOR
//    public String getIdUnor()
//    {
//        return id_unor;
//    }
//    
//    public void setIdUnor(String sIdUnor)
//    {
//        this.id_unor = sIdUnor;
//    }
//    
//    //FIELD = NAMA_UNOR
//    public String getNamaUnor()
//    {
//        return nama_unor;
//    }
//    
//    public void setNamaUnor(String sNamaUnor)
//    {
//        this.nama_unor = sNamaUnor;
//    }
//    
//    //FIELD = ID_INSTANSI
//    public String getIdInstansi()
//    {
//        return id_instansi;
//    }
//    
//    public void setIdInstansi(String sIdInstansi)
//    {
//        this.id_instansi = sIdInstansi;
//    }
//    
//    //FIELD = ID_DIATASAN
//    public String getIdDiAtasan()
//    {
//        return id_diatasan;
//    }
//    
//    public void setIdDiAtasan(String sIdDiAtasan)
//    {
//        this.id_diatasan = sIdDiAtasan;
//    }
//    
//    //FIELD = INSTANSI_NAMA
//    public String getInstansiNama()
//    {
//        return instansi_nama;
//    }
//    
//    public void setInstansiNama(String sInstansiNama)
//    {
//        this.instansi_nama = sInstansiNama;
//    }
//    
//    
//    
//    
//    //FIELD = ID_ISI4FAKTOR
//    public String getid_isi4faktor_dariIsi4Faktor()
//    {
//        return id_isi4faktor_dariIsi4Faktor;
//    }
//    
//    public void setid_isi4faktor_dariIsi4Faktor(String sIdIsi4Faktor)
//    {
//        this.id_isi4faktor_dariIsi4Faktor = sIdIsi4Faktor;
//    }
// 
//    
//    //FIELD = NIP_PNS
//    public String getnip_pns_dariIsi4Faktor()
//    {
//        return nip_pns_dariIsi4Faktor;
//    }
//    
//    public void setnip_pns_dariIsi4Faktor(String sNipPns)
//    {
//        this.nip_pns_dariIsi4Faktor = sNipPns;
//    }
// 
//    
//    //FIELD = ID_TUPOKSI
//    public String getid_tupoksi_dariIsi4Faktor()
//    {
//        return id_tupoksi_dariIsi4Faktor;
//    }
//    
//    public void setid_tupoksi_dariIsi4Faktor(String sIdTupoksi)
//    {
//        this.id_tupoksi_dariIsi4Faktor = sIdTupoksi;
//    }
//    
//    // FIELD = KUANTITAS4
//    public String getKuantitas4()
//    {
//        return kuantitas4;
//    }
//    
//    public void setKuantitas4(String sKuantitas4)
//    {
//        this.kuantitas4 = sKuantitas4;
//    }
//    
//    //FIELD = KUALITAS4
//    public String getKualitas4()
//    {
//        return kualitas4;
//    }
//    
//    public void setKualitas4(String sKualitas4)
//    {
//        this.kualitas4 = sKualitas4;
//    }
//    
//    //FIELD = WAKTU4
//    public String getWaktu4()
//    {
//        return waktu4;
//    }
//    
//    public void setWaktu4(String sWaktu4)
//    {
//        this.waktu4 = sWaktu4;
//    }
//    
//    //FIELD = BIAYA4
//    public String getBiaya4()
//    {
//        return biaya4;
//    }
//    
//    public void setBiaya4(String sBiaya4)
//    {
//        this.biaya4 = sBiaya4;
//    }
//    
//            //FIELD = kuantitas_label
//    public String getkuantitas_label()
//    {
//        return kuantitas_label;
//    }
//    
//    public void setkuantitas_label(String skuantitas_label)
//    {
//        this.kuantitas_label = skuantitas_label;
//    }
//    
//        //FIELD = waktu_label
//    public String getwaktu_label()
//    {
//        return waktu_label;
//    }
//    
//    public void setwaktu_label(String swaktu_label)
//    {
//        this.waktu_label = swaktu_label;
//    }

    public String getBiaya4() {
        return biaya4;
    }

    public void setBiaya4(String biaya4) {
        this.biaya4 = biaya4;
    }

    public String getBiayar() {
        return biayar;
    }

    public void setBiayar(String biayar) {
        this.biayar = biayar;
    }

    public String getId_diatasan() {
        return id_diatasan;
    }

    public void setId_diatasan(String id_diatasan) {
        this.id_diatasan = id_diatasan;
    }

    public String getId_instansi() {
        return id_instansi;
    }

    public void setId_instansi(String id_instansi) {
        this.id_instansi = id_instansi;
    }

    public String getId_isi4faktor() {
        return id_isi4faktor;
    }

    public void setId_isi4faktor(String id_isi4faktor) {
        this.id_isi4faktor = id_isi4faktor;
    }

    public String getId_isi4faktor_dariIsi4Faktor() {
        return id_isi4faktor_dariIsi4Faktor;
    }

    public void setId_isi4faktor_dariIsi4Faktor(String id_isi4faktor_dariIsi4Faktor) {
        this.id_isi4faktor_dariIsi4Faktor = id_isi4faktor_dariIsi4Faktor;
    }

    public String getId_realisasi() {
        return id_realisasi;
    }

    public void setId_realisasi(String id_realisasi) {
        this.id_realisasi = id_realisasi;
    }

    public String getId_tupoksi() {
        return id_tupoksi;
    }

    public void setId_tupoksi(String id_tupoksi) {
        this.id_tupoksi = id_tupoksi;
    }

    public String getId_tupoksi_dariIsi4Faktor() {
        return id_tupoksi_dariIsi4Faktor;
    }

    public void setId_tupoksi_dariIsi4Faktor(String id_tupoksi_dariIsi4Faktor) {
        this.id_tupoksi_dariIsi4Faktor = id_tupoksi_dariIsi4Faktor;
    }

    public String getId_tupoksi_dariTupoksi() {
        return id_tupoksi_dariTupoksi;
    }

    public void setId_tupoksi_dariTupoksi(String id_tupoksi_dariTupoksi) {
        this.id_tupoksi_dariTupoksi = id_tupoksi_dariTupoksi;
    }

    public String getId_unor() {
        return id_unor;
    }

    public void setId_unor(String id_unor) {
        this.id_unor = id_unor;
    }

    public String getInstansi_nama() {
        return instansi_nama;
    }

    public void setInstansi_nama(String instansi_nama) {
        this.instansi_nama = instansi_nama;
    }

    public String getKualitas4() {
        return kualitas4;
    }

    public void setKualitas4(String kualitas4) {
        this.kualitas4 = kualitas4;
    }

    public String getKualitasr() {
        return kualitasr;
    }

    public void setKualitasr(String kualitasr) {
        this.kualitasr = kualitasr;
    }

    public String getKuantitas4() {
        return kuantitas4;
    }

    public void setKuantitas4(String kuantitas4) {
        this.kuantitas4 = kuantitas4;
    }

    public String getKuantitas_label() {
        return kuantitas_label;
    }

    public void setKuantitas_label(String kuantitas_label) {
        this.kuantitas_label = kuantitas_label;
    }

    public String getKuantitasr() {
        return kuantitasr;
    }

    public void setKuantitasr(String kuantitasr) {
        this.kuantitasr = kuantitasr;
    }

    public String getNama_tupoksi() {
        return nama_tupoksi;
    }

    public void setNama_tupoksi(String nama_tupoksi) {
        this.nama_tupoksi = nama_tupoksi;
    }

    public String getNama_unor() {
        return nama_unor;
    }

    public void setNama_unor(String nama_unor) {
        this.nama_unor = nama_unor;
    }

    public String getNilai_capaian_skp() {
        return nilai_capaian_skp;
    }

    public void setNilai_capaian_skp(String nilai_capaian_skp) {
        this.nilai_capaian_skp = nilai_capaian_skp;
    }

    public String getNip_pns() {
        return nip_pns;
    }

    public void setNip_pns(String nip_pns) {
        this.nip_pns = nip_pns;
    }

    public String getNip_pns_dariIsi4Faktor() {
        return nip_pns_dariIsi4Faktor;
    }

    public void setNip_pns_dariIsi4Faktor(String nip_pns_dariIsi4Faktor) {
        this.nip_pns_dariIsi4Faktor = nip_pns_dariIsi4Faktor;
    }

    public String getPenghitungan() {
        return penghitungan;
    }

    public void setPenghitungan(String penghitungan) {
        this.penghitungan = penghitungan;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getWaktu4() {
        return waktu4;
    }

    public void setWaktu4(String waktu4) {
        this.waktu4 = waktu4;
    }

    public String getWaktu_label() {
        return waktu_label;
    }

    public void setWaktu_label(String waktu_label) {
        this.waktu_label = waktu_label;
    }

    public String getWaktur() {
        return waktur;
    }

    public void setWaktur(String waktur) {
        this.waktur = waktur;
    }
     public String getangkaKrdtr() {
        return angkaKrdtr;
    }

    public void setangkaKrdtr(String angkaKrdtr) {
        this.angkaKrdtr =angkaKrdtr;
    }
    
     public String getangkaKrdt4() {
        return angkaKrdt4;
    }

    public void setangkaKrdt4(String angkaKrdt4) {
        this.angkaKrdt4 =angkaKrdt4;
    }
    
     public String get_pilih_session() {
        return _pilih_session;
    }

    public void set_pilih_session(String _pilih_session) {
        this._pilih_session =_pilih_session;
    }
      public String get_idUnor() {
        return _idUnor;
    }

    public void set_idUnor(String _idUnor) {
        this._idUnor =_idUnor;
    }
}
