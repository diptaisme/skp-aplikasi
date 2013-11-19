/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author diptaisme
 */
public class nilaiHuruf
{
    private String nilaiHuruf;

    public String getNilaiHuruf() 
    {
        return nilaiHuruf;
    }

    public void setNilaiHuruf(String nilaiHurufMasukan) 
    {
       double i_nilaiangka =0;
        if(nilaiHurufMasukan.equals("-")){
            i_nilaiangka=0;
        }
        i_nilaiangka = Double.parseDouble(nilaiHurufMasukan);
        
        if(i_nilaiangka <= 50)
        {
            nilaiHuruf = "BURUK";
        }
        else if(i_nilaiangka <= 60 && i_nilaiangka >= 51)
        {
            nilaiHuruf = "SEDANG";
        }
        else if(i_nilaiangka <= 75 && i_nilaiangka >= 61)
        {
            nilaiHuruf = "CUKUP";
        }
        else if(i_nilaiangka <= 90 && i_nilaiangka >= 76)
        {
            nilaiHuruf = "BAIK";
        }
        else if(i_nilaiangka <= 100 && i_nilaiangka >= 91)
        {
            nilaiHuruf = "SANGAT BAIK";
        }
         if(i_nilaiangka == 0)
        {
            nilaiHuruf = "-";
        }
        this.nilaiHuruf = nilaiHuruf;
    }
    
}
