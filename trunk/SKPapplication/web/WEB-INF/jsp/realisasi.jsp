<%-- 
    Document   : realisasi
    Created on : Feb 20, 2012, 1:08:03 PM
    Author     : diptaisme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Isian Target SKP</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<style type="text/css">

.style1 {
        font-size: 24px;
        font-weight: bold;
}
.style2 {font-size: 14px}

body
            {
                background:#000 url(/SKPapplication/images/rusak.jpeg) repeat top left;
                margin:0;
                padding:0;
            }

</style>
    </head>
    <body onload="updateClock();">
        <form name="clock">
            Waktu Sekarang : <input name="time" type="" value="" size="35">
        </form>
        <form>
            Login Sebagai : <input name="login" type="" value="" size="35">
        </form>
        <form method="post" name="form1" action="Isi4FaktorServlet">
            <table width="750" border="1">
                <tr>
                    <td width="119"><img src="/SKPapplication/images/arrow-on-target.jpg" width="93" height="78"></td>
                    <td colspan="4"><span class="style1">FORM ISIAN REALISASI </span></td>
                    <%--<td width="269" rowspan="10">&nbsp;</td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>--%>
                </tr>
                <tr>
                    <td rowspan="10">&nbsp;</td>
                    <td width="150"><strong><span class="style2">NIP PNS</span></strong></td>
                    <td width="2791" colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2"></span></strong><c:out value="${pnsp.getNipBaru()}" /></td>
                </tr> 
                <tr>
                    <td><strong><span class="style2">NAMA PNS </span></strong></td>
                    <td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2"></span></strong><c:out value="${pnsp.getNamaPns()}" /></td>
                </tr>
                <tr>
                    <td><strong><span class="style2">KODE TUPOKSI </span></strong></td>
                    <td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2"></span></strong><c:out value="${realisasiIsi4faktorTupoksiId.getIdTupoksi()}" /></td> 
                </tr>
                <tr>
                    <td><strong><span class="style2">NAMA TUPOKSI</span></strong></td>
                    <td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2"></span></strong><c:out value="${realisasiIsi4faktorTupoksiId.getNamaTupoksi()}" /></td>
                </tr>
                <tr>
                    <td align="center" colspan="2"><strong>TARGET</strong></td>
                    <td align="center" colspan="2"><strong>REALISASI</strong></td>
                </tr>
                <tr>
                    <td><strong><span class="style2">KUANTITAS</span></strong></td>
                    <td align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2">${realisasiIsi4faktorTupoksiId.getKuantitas4()}</span></strong></td>
                    <%--<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2"><input type="text" align="right" name="kuantitas4text" value="${realisasiIsi4faktorTupoksiId.getKuantitas4()}" style="text-align: right"></span></strong></td>--%>
                    <td><strong><span class="style2">KUANTITAS</span></strong></td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2"><input type="text" align="right" name="kuantitasRtext" value="${realisasiIsi4faktorTupoksiId.getKuantitasR()}" style="text-align: right"></span></strong></td>
                </tr>
                <tr>
                    <td><strong><span class="style2">KUALITAS</span></strong></td>
                    <td align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2">${realisasiIsi4faktorTupoksiId.getKualitas4()}</span></strong></td>
                    <%--<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2"><input type="text" name="kualitas4text" value="${realisasiIsi4faktorTupoksiId.getKualitas4()}" align="right" style="text-align: right"></span></strong></td>--%>
                    <td><strong><span class="style2">KUALITAS</span></strong></td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2"><input type="text" name="kualitasRtext" value="${realisasiIsi4faktorTupoksiId.getKualitasR()}" align="right" style="text-align: right"></span></strong></td>
                </tr>
                <tr>
                    <td><strong><span class="style2">WAKTU</span></strong></td>
                    <td align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2">${realisasiIsi4faktorTupoksiId.getWaktu4()}</span></strong></td>
                    <%--<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2"><input type="text" name="waktu4text" value="${realisasiIsi4faktorTupoksiId.getWaktu4()}" align="right" style="text-align: right"></span></strong></td>--%>
                    <td><strong><span class="style2">WAKTU</span></strong></td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2"><input type="text" name="waktuRtext" value="${realisasiIsi4faktorTupoksiId.getWaktuR()}" align="right" style="text-align: right"></span></strong></td>
                </tr>
                <tr>
                    <td><strong><span class="style2">BIAYA</span></strong></td>
                    <td align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2">${realisasiIsi4faktorTupoksiId.getBiaya4()}</span></strong></td>
                    <%--<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2"><input type="text" name="biaya4text"  value="${realisasiIsi4faktorTupoksiId.getBiaya4()}" style="text-align: right"></span></strong></td>--%>
                    <td><strong><span class="style2">BIAYA</span></strong></td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2"><input type="text" name="biayaRtext"  value="${realisasiIsi4faktorTupoksiId.getBiayaR()}" style="text-align: right"></span></strong></td>
                </tr>
                <tr>
                    <td colspan="4">
                        <input type="submit" name="paramRealisasi" value="SAVE">
                        <input type="submit" name="paramRealisasi" value="CANCEL">
                        <input type="button" name="paramRealisasi" onclick="ButtonBack()" value="KEMBALI">
                    </td>
                    <%--
                    <td width="75">
                            <div align="center">
                                <input type="submit" name="paramRealisasi" value="CARI TUPOKSI">
                            </div>
                    </td>
                    --%>
                </tr>
            </table>

 <SCRIPT TYPE="text/javascript">
function ButtonBack()
{
    location = 'GetPnsServlet?txtNIPBaruReal=<c:out value="${pnsp.getNipBaru()}"/>';
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

        if (menit.length < 2)
            menit = "0" + menit;
        if (detik.length < 2)
            detik = "0" + detik;
        if (tgl.length < 2)
            tgl = "0" + tgl;
        if (bulan == "0")
            bulan = "Januari";
        if (bulan == "1")
            bulan = "Februari";
        if (bulan == "2")
            bulan = "Maret";
        if (bulan == "3")
            bulan = "April";
        if (bulan == "4")
            bulan = "Mei";
        if (bulan == "5")
            bulan = "Juni";
        if (bulan == "6")
            bulan = "Juli";
        if (bulan == "7")
            bulan = "Agustus";
        if (bulan == "8")
            bulan = "September";
        if (bulan == "9")
            bulan = "Oktober";
        if (bulan == "10")
            bulan = "November";
        if (bulan == "11")
            bulan = "Desember";
        if (hari == "1")
            hari = "Senin";
        if (hari == "2")
            hari = "Selasa";
        if (hari == "3")
            hari = "Rabu";
        if (hari == "4")
            hari = "Kamis";
        if (hari == "5")
            hari = "Jumat";
        if (hari == "6")
            hari = "Sabtu";
        if (hari == "0")
            hari = "Minggu";

        var time = hari + ", " + tgl + " " + bulan + " " + tahun + " / "+ jam + ":" + menit + ":" + detik + ":" + mili;

        document.forms["clock"].time.value = time;
        setTimeout("updateClock();", 1000);
}
</script>
        </form>
    </body>
</html>