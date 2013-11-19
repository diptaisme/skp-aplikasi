/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileInputStream;

/**
 *
 * @author diptaisme
 */
public class fotobinary 
{
    private String nippns;
    private FileInputStream fotobinari;

    public FileInputStream getFotobinari() {
        return fotobinari;
    }

    public void setFotobinari(FileInputStream fotobinari) {
        this.fotobinari = fotobinari;
    }

    public String getNippns() {
        return nippns;
    }

    public void setNippns(String nippns) {
        this.nippns = nippns;
    }
    
    
}
