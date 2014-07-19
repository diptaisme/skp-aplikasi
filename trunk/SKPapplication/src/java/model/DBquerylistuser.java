/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author bkn04
 */
public class DBquerylistuser {
    Connection conn;
    loginweb lw;
    List<loginweb> listuser;
    public DBquerylistuser(Connection conn)
    {
        this.conn = conn;
    }
    public List<loginweb> getDBquerylistuser()
    {
        
        return null;
    }
}

