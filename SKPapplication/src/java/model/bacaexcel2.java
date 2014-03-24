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
 * @author Sony
 */
public class bacaexcel2 {

    public String id;
    private String nip_lama;
    private String nip_baru;
    private String nama_pns;
    private String golonganid;
    private String namagolru;
    private String pangkat;
    private String unorid;
    private String namaunor;
    private String namajabatan;
    private String diatasanid;
    private String instansiid;
    private String jenisjabatan;
    private String jabatan_fungsional;
    private String jabatan_fungsional_umum;

    public void bersihdata() {
        this.id = "";
        this.nip_lama = "";
        this.nip_baru = "";
        this.nama_pns = "";
        this.golonganid = "";
        this.namagolru = "";
        this.pangkat = "";
        this.unorid = "";
        this.namaunor = "";
        this.namajabatan = "";
        this.diatasanid = "";
        this.instansiid = "";
        this.jenisjabatan = "";
        this.jabatan_fungsional = "";
        this.jabatan_fungsional_umum = "";
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
            this.id = data;

        } else if (no == 1) {
            this.nip_lama = data;
        } else if (no == 2) {
            this.nip_baru = data;
        } else if (no == 3) {
            this.nama_pns = data;
            if (data.contains("'")) {
                this.nama_pns = data.replace("'", "''");
                System.out.println(this.nama_pns);
            }
        } else if (no == 4) {
            this.golonganid = data;
        } else if (no == 5) {
            this.namagolru = data;
        } else if (no == 6) {
            this.pangkat = data;
        } else if (no == 7) {
            this.unorid = data;
        } else if (no == 8) {
            this.namaunor = data;
            if (data.contains("'")) {
                this.namaunor = data.replace("'", "''");
                System.out.println(this.namaunor);
            }
        } else if (no == 9) {
            this.namajabatan = data;
            if (data.contains("'")) {
                this.namajabatan = data.replace("'", "''");
                System.out.println(this.namajabatan);
            }

        } else if (no == 10) {
            this.diatasanid = data;
        } else if (no == 11) {
            this.instansiid = data;
        } else if (no == 12) {
            this.jenisjabatan = data;
        } else if (no == 13) {
            this.jabatan_fungsional = data;
        } else if (no == 14) {
            this.jabatan_fungsional_umum = data;
        } else {
        }
    }
public String cekdata(String id) throws SQLException
    {
       DBConnection dbConn = DBConnection.getInstance();;
       DBqueryPNS dBqueryPNS = new DBqueryPNS(dbConn.getConnection());
       return dBqueryPNS.getcekpns(id);  
    }
    public void main2( String pathdata) throws Exception, FileNotFoundException, IOException {
        // TODO code application logic here
        //  bacaexcel2 baca = new bacaexcel2();
        String _patData=pathdata;
        File datafile = new File(_patData);
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

      if(cekdata(this.id).equals("tidakada"))
      {
            try {

                dBqueryPNS.getDBqueryInsertPNS(this.id, this.nip_lama, this.nip_baru, this.nama_pns, this.golonganid, this.namagolru, this.pangkat, this.unorid, this.namaunor, this.namajabatan, this.diatasanid, this.instansiid, this.jenisjabatan, this.jabatan_fungsional, this.jabatan_fungsional_umum);

            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                dbConn.closeConnection();
            }
        }
       else
            {
                dBqueryPNS.getDBqueryUpdateImportPNS(this.golonganid,this.namagolru,
                this.pangkat,this.unorid,this.namaunor,this.namajabatan,this.diatasanid,
                this.jenisjabatan,this.jabatan_fungsional,this.jabatan_fungsional_umum);
            }
       

    }
         System.out.println("SELESAI");
        JOptionPane.showMessageDialog(null, "data berhasil", "Alert", JOptionPane.INFORMATION_MESSAGE);
}
}
