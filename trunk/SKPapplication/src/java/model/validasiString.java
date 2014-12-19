/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author diptaisme
 */
public class validasiString {

    String mas, mas2, nmBulanvr, _bulan;

    //        setmashudi(biay4);
    //        setmashudi(biayr);
    //        namahasil4 = getmashudi();
    //        namahasilr = getmashudi();
    public void setmashudi(String mashudi) {
        mas = mashudi;
        if (mas.equals(null) || mas.equals("") || mas.equals("null")) {
            mas = "";
        } else {


            for (int i = 0; i < mas.length(); i++) {
                while ((mas.substring(i, i + 1).equals(".")) || (mas.substring(i, i + 1).equals(",")) || (mas.substring(i, i + 1).equals("-"))) {
                    mas2 = mas.substring(0, i) + "" + mas.substring(i + 1, mas.length());
                    mas = mas2;
                    break;
                }
            }
        }
    }

    public void setNamaBulan(String nmBulan) {
        _bulan = nmBulan.substring(3, 5);
        _bulan = nmBulan.substring(3, 5);
        if (_bulan.equals("08")) {
            _bulan = "Agustus";
        }
        if (_bulan.equals("09")) {
            _bulan = "September";
        }
        if (_bulan.equals("11")) {
            _bulan = "November";
        }
        if (_bulan.equals("10")) {
            _bulan = "Oktober";
        }
        if (_bulan.equals("12")) {
            _bulan = "Desember";
        }
        if (_bulan.equals("07")) {
            _bulan = "Juli";
        }
        if (_bulan.equals("06")) {
            _bulan = "Juni";
        }
        if (_bulan.equals("05")) {
            _bulan = "Mei";
        }
        if (_bulan.equals("04")) {
            _bulan = "April";
        }
        if (_bulan.equals("03")) {
            _bulan = "Maret";
        }
        if (_bulan.equals("02")) {
            _bulan = "Februari";
        }
        if (_bulan.equals("01")) {
            _bulan = "Januari";
        }

    }

    public String validasidata(String mashudi) {
        String stringmas = mashudi;
        if (stringmas==null || stringmas.equals("") || stringmas.equals("null") || stringmas.equals("-") || stringmas.equals(" ")) {
            stringmas = "0";
        }
        return stringmas;
    }

    public void setkoma(String mashudi) {
        mas = mashudi;
        if (mas.equals(null) || mas.equals("") || mas.equals("null")) {
            mas = "";
        } else {
            for (int i = 0; i < mas.length(); i++) {
                while ((mas.substring(i, i + 1).equals(".")) || (mas.substring(i, i + 1).equals(","))) {
                    mas2 = mas.substring(0, i) + "." + mas.substring(i + 1, mas.length());
                    mas = mas2;
                    break;
                }
            }
        }
    }

    public String getmashudi() {
        return mas;
    }

    public String getNamaBulan() {
        return _bulan;
    }
}
