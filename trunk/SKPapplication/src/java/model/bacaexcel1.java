/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.sql.SQLException;
import javax.swing.JOptionPane;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.Workbook.*;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.format.Colour;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WriteException;
/**
 *
 * @author leo
 */
public class bacaexcel1 {
    public  String id_unor;
    private String instansi_id;
    private String diatasan_id;
    private String eselon_id;
    private String nama_unor;
    private String nama_jabatan;
    private String pemimpin_pns_id;
    public void bersihdata() {
        this.id_unor = "";
        this.instansi_id = "";
        this.diatasan_id = "";
        this.eselon_id = "";
        this.nama_unor = "";
        this.nama_jabatan = "";
        this.pemimpin_pns_id = "";
        
    }

    public void gettosql() throws SQLException {
        //  String queryinsert = "insert into PnsSkp values('"+this.id+"','"+this.nip_lama+"','"+this.nip_baru+"','"+this.nama_pns+"','"+this.golonganid+"','"+this.namagolru+"','"+this.pangkat+"',"
        //          + "'"+this.unorid+"','"+this.namaunor+"','"+this.namajabatan+"','"+this.diatasanid+"',"
        //          + "'"+this.instansiid+"','"+this.jenisjabatan+"','"+this.jabatan_fungsional+"','"+this.jabatan_fungsional_umum+"')" ;
        //      database data = new database();
        //      Statement st2 = data.getkoneksimysql().createStatement();
        //      st2.executeUpdate(queryinsert);
        //      st2.close();
    }

    public void getnilai(int no, String data) {
        if (no == 0) {
            this.id_unor = data;
        } else if (no == 1) {
            this.instansi_id = data;
        } else if (no == 2) {
            this.diatasan_id = data;
        } else if (no == 3) {
            this.eselon_id = data;
        } else if (no == 4) {
            this.nama_unor = data;
        } else if (no == 5) {
            this.nama_jabatan = data;
        } else if (no == 6) {
            this.pemimpin_pns_id = data;
        }  else {
        }
    }

    public void main2() throws Exception, FileNotFoundException, IOException {
        // TODO code application logic here
        //  bacaexcel2 baca = new bacaexcel2();
        File datafile = new File("E:\\data.xls");
        Workbook w = Workbook.getWorkbook(datafile);
        Sheet[] sheet = w.getSheets();
        int x = sheet[0].getRows();
        int y = sheet[0].getColumns();
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                String ret = sheet[0].getCell(j, i).getContents();
                getnilai(j, ret);
            }
            System.out.println(i);

            DBConnection dbConn = DBConnection.getInstance();
            PnsSkp ipns = new PnsSkp();
            DBqueryPNS dBqueryPNS = new DBqueryPNS(dbConn.getConnection());
            // baca.gettosql();
            // baca.bersihdata();


            try {

                dBqueryPNS.getDBqueryInsertUNOR(this.id_unor, this.instansi_id, this.diatasan_id, this.eselon_id, this.nama_unor, this.nama_jabatan, this.pemimpin_pns_id);

            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                dbConn.closeConnection();
            }
        }
        System.out.println("SELESAI");
        JOptionPane.showMessageDialog(null, "data berhasil", "Alert", JOptionPane.INFORMATION_MESSAGE);

    }
}
