/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author diptaisme
 */
public class loginweb
{
    private String username_login;
    private String password_login;
    private String kewenangan_login;
    private String nippns_login;
    
    public String getusername_login()
    {
        return username_login;
    }
    
    public void setusername_login(String username_login)
    {
        this.username_login = username_login;
    }
    
    public String getpassword_login()
    {
        return password_login;
    }
    
    public void setpassword_login(String password_login)
    {
        this.password_login = password_login;
    }
    
        public String getkewenangan_login()
    {
        return kewenangan_login;
    }
    
    public void setkewenangan_login(String kewenangan_login)
    {
        this.kewenangan_login = kewenangan_login;
    }
    
    public String getnippns_login()
    {
        return nippns_login;
    }
    
    public void setnippns_login(String nippns_login)
    {
        this.nippns_login = nippns_login;
    }
}
