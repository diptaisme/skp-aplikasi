<%-- 
    Document   : isi4faktor
    Created on : Feb 16, 2012, 1:04:50 PM
    Author     : diptaisme
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Isian Target SKP</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <link href="css/button.css" type="text/css" rel="stylesheet" media="screen,projection" />
        <script src="js/animation.js" type="text/javascript" charset="UTF-8"></script>
<style type="text/css">

.style1
{
	font-size: 24px;
	font-weight: bold;
}

.style2
{
    font-size: 14px;
}

body
{
    background:#000 url(images/rusak.jpeg) repeat top left;
    margin:0;
    padding:0;
}

</style>
    </head>
    <body onload="updateClock();">
        <form name="clock">Waktu Sekarang : <input name="time" type="" value="" size="35"></form>
        <form>Login Sebagai  : <input name="login" type="" value="" size="35"></form>
        <form>
            <table border="0">
                <tr><td>&nbsp;</td></tr>
            </table>
            <span style="font-family:Verdana; font-size: 12px; font-weight:bold; text-shadow:4px 4px 8px blue; letter-spacing:10px; word-spacing:20px;"><marquee direction="left" scrollamount="5" height="20px" width="100%"> Isian Sasaran Kerja Individu meliputi : Kegiatan tugas pokok jabatan, Bobot kegiatan, Sasaran kerja yang akan dicapai, Target (aspek kuantitas, kualitas, waktu dan/atau biaya). </marquee></span>
            <table border="0">
                <tr><td>&nbsp;</td></tr>
            </table>
        </form>
        <form method="post" name="form1" action="Isi4FaktorServlet">
            <table width="750" border="1">
                <tr>
                    <td colspan="3" align="center"><span class="style1">FORM ISIAN TARGET 4 FAKTOR </span></td>
                </tr>
                <tr>
                    
                    <td width="119" rowspan="9">
                        <div align="center">
                            <input type="submit" name="param" value="SAVE">
                            <input type="submit" name="param" value="CANCEL">
                            <input type="button" name="param" onclick="ButtonBack()" value="KEMBALI">
                            <input type="submit" name="param" value="CARI TUPOKSI">
                        </div>
                    </td>
                    <%--
                    <td width="119" rowspan="9">
                        <div id="button-container" class="demo">
                            <a href="Isi4FaktorServlet?saveIsi4FaktorServletTupoksi=<c:out value="${idtupoksidijsp}" />&saveIsi4FaktorServletNip=<c:out value="${pnsp.getNipBaru()}" />&kuantitas4text=<c:out value="${tupoksiKeIsi4Faktor.getKuantitas4()}" />&kualitas4text=<c:out value="${tupoksiKeIsi4Faktor.getKualitas4()}" />&waktu4text=<c:out value="${tupoksiKeIsi4Faktor.getWaktu4()}" />&biaya4text=<c:out value="${tupoksiKeIsi4Faktor.getBiaya4()}" />" id="button" name="param" type="submit">SAVE</a>

                            <a href="Isi4FaktorServlet?saveIsi4FaktorServletTupoksi=<c:out value="${idtupoksidijsp}" />&saveIsi4FaktorServletNip=<c:out value="${pnsp.getNipBaru()}" />&kuantitas4text=<c:out value="${tupoksiKeIsi4Faktor.getKuantitas4()}" />&kualitas4text=<c:out value="${tupoksiKeIsi4Faktor.getKualitas4()}" />&waktu4text=<c:out value="${tupoksiKeIsi4Faktor.getWaktu4()}" />&biaya4text=<c:out value="${tupoksiKeIsi4Faktor.getBiaya4()}" />">SAVE</a>
                            <a href="Isi4FaktorServlet?saveIsi4FaktorServletTupoksi=<c:out value="${idtupoksidijsp}" />&saveIsi4FaktorServletNip=<c:out value="${pnsp.getNipBaru()}" />" id="button" name="param" type="submit">SAVE</a>
                            <div id="arrow-container">
                                <div id="arrow-rectangle"></div>
                                <div id="arrow-triangle" ></div>
                            </div>
			</div>
                        <div id="button-container" class="download">
                            <a href="#" id="button" name="param" type="submit">CANCEL</a>
                            <div id="arrow-container">
                                <div id="arrow-rectangle"></div>
                                <div id="arrow-triangle" ></div>
                            </div>
                        </div>
                        <div id="button-container" class="digg">
                            <a href="ButtonBack()" id="button" name="param" type="submit">KEMBALI</a>
                            <div id="arrow-container">
                                <div id="arrow-rectangle"></div>
                                <div id="arrow-triangle" ></div>
                            </div>
                        </div>
                        <div id="button-container" class="rss">
                            <a href="Isi4FaktorServlet?caritupoksiIsi4FaktorServlet=CARITUPOKSI" id="button" name="param" type="submit">CARI TUPOKSI</a>
                            <div id="arrow-container">
                                <div id="arrow-rectangle"></div>
                                <div id="arrow-triangle" ></div>
                            </div>
                        </div>
                    </td>
                    --%>
                    <td width="150"><strong><span class="style2">NIP PNS</span></strong></td>
                    <td width="2791">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2">:</span></strong><c:out value="${pnsp.getNipBaru()}" /></td>
                </tr> 
                <tr>
                    <td><strong><span class="style2">NAMA PNS </span></strong></td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2">:</span></strong><c:out value="${pnsp.getNamaPns()}" /></td>
                </tr>
                <tr>
                    <td><strong><span class="style2">KODE TUPOKSI </span></strong></td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2">:</span></strong><c:out value="${idtupoksidijsp}" /></td> 
                </tr>
                <tr>
                    <td><strong><span class="style2">NAMA TUPOKSI</span></strong></td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2">:  </span></strong><c:out value="${namaTupoksijsp}" /></td>
                </tr>
                <tr>
                    <td><strong><span class="style2">KUANTITAS</span></strong></td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2">:  <input type="text" align="right" name="kuantitas4text" value="${tupoksiKeIsi4Faktor.getKuantitas4()}" style="text-align: right"></span></strong>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <select name="pilih_output">
                            <option value="Dokumen">Dokumen</option>
                            <option value="Kegiatan">Kegiatan</option>
                            <option value="Laporan">Laporan</option>
                            <option value="Paket">Paket</option>
                         </select>
                    </td>
                </tr>
                <tr>
                    <td><strong><span class="style2">KUALITAS</span></strong></td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2">:  <input type="text" name="kualitas4text" value="${tupoksiKeIsi4Faktor.getKualitas4()}" align="right" style="text-align: right"></span></strong></td>
                </tr>
                <tr>
                    <td><strong><span class="style2">WAKTU</span></strong></td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2">:  <input type="text" name="waktu4text" value="${tupoksiKeIsi4Faktor.getWaktu4()}" align="right" style="text-align: right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; bln </span></strong></td>
                </tr>
                <tr>
                    <td><strong><span class="style2">BIAYA</span></strong></td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2">:  <input type="text" name="biaya4text"  value="${tupoksiKeIsi4Faktor.getBiaya4()}" style="text-align: right"></span></strong></td>
                </tr>
            </table>
    
<SCRIPT TYPE="text/javascript">
function ButtonBack()
{
    //location = 'index.jsp';
    //location = 'GetPnsServlet?txtNIPBaruB=idNipBaruText';
    location = 'GetPnsServlet?txtNIPBaruB=<c:out value="${pnsp.getNipBaru()}"/>';
}
        
function updateClock()
{
    var now = new Date();
    
    var jam = now.getHours().toString();
    var menit = now.getMinutes().toString();
    var detik = now.getSeconds().toString();
    var mili = now.getMilliseconds().toString();
    
    var tgl = now.getDate().toString();
    var bulan = now.getMonth().toString();
    var tahun = now.getYear().toString();
    
    var hari = now.getDay().toString();
    
    var coba = now.getD

    if (menit.length < 2)
        menit = "0" + menit
    if (detik.length < 2)
        detik = "0" + detik
    if (tgl.length < 2)
        tgl = "0" + tgl
    if (bulan == "0")
        bulan = "Januari"
    if (bulan == "1")
        bulan = "Februari"
    if (bulan == "2")
        bulan = "Maret"
    if (bulan == "3")
        bulan = "April"
    if (bulan == "4")
        bulan = "Mei"
    if (bulan == "5")
        bulan = "Juni"
    if (bulan == "6")
        bulan = "Juli"
    if (bulan == "7")
        bulan = "Agustus"
    if (bulan == "8")
        bulan = "September"
    if (bulan == "9")
        bulan = "Oktober"
    if (bulan == "10")
        bulan = "November"
    if (bulan == "11")
        bulan = "Desember"
    if (hari == "1")
        hari = "Senin"
    if (hari == "2")
        hari = "Selasa"
    if (hari == "3")
        hari = "Rabu"
    if (hari == "4")
        hari = "Kamis"
    if (hari == "5")
        hari = "Jumat"
    if (hari == "6")
        hari = "Sabtu"
    if (hari == "0")
        hari = "Minggu"
    
    var time = hari + ", " + tgl + " " + bulan + " " + tahun + " / "+ jam + ":" + menit + ":" + detik + ":" + mili;
     
    document.forms["clock"].time.value = time;
    setTimeout("updateClock();", 1000);
}
    </script>
</form>
</body>
</html>