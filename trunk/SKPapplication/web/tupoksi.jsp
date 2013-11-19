<%-- 
    Document   : tupoksi
    Created on : Feb 21, 2012, 9:40:48 AM
    Author     : diptaisme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabel Bantu Tupoksi</title>
        
<style type="text/css">
body
{
    background:#000 url(images/rusak.jpeg) repeat top left;
    margin:0;
    padding:0;
}
</style>        
        
    </head>
    <body onload="updateClock();">
      <form name="clock">
          Waktu Sekarang : <input name="time" type="" value="" size="35"><br>
      </form>
      <form>
          Login Sebagai : <input name="login" type="" value="" size="35">
      </form>
        <form name="form1" method="post" action="tupoksiServlet">
            <table width="918" border="1">
                <tr>
                    <td width="92" rowspan="4"><p align="center" class="style1">&nbsp;</p>      </td>
                    <td colspan="2"><div align="center"><span class="style1"><strong>DAFTAR TUGAS FUNGSI (berdasarkan Unit Kerja dan Jabatan)</strong></span></div></td>
                </tr>
                <tr>
                    <td height="23"><strong>INSTANSI</strong></td>
                    <td><c:out value="${ins.getNamaInstansi()}" /></td>
                </tr>
                <tr>
                    <td width="92" height="23"><strong>JABATAN</strong></td>
                    <td width="712"><c:out value="${pns.getNamaJabatan()}" /></td>
                </tr>
                <tr>
                    <td><strong>UNIT KERJA</strong></td>
                    <td><c:out value="${pns.getNamaUnor()}" /></td>
                </tr>
                <tr>
                    <td colspan="2"><div align="center"><strong>KODE</strong></div></td>
                    <td><div align="center"><strong>NAMA TUGAS DAN FUNGSI </strong></div></td>
                </tr>
                <%--
                <c:forEach var="listTukesi" items="${tukesiServlet}">
                    <tr>
                --%>
                        <%-- (varStatus = "count") <td>${(count.index)+1}</td> --%>
                <%--
                        <td><a href ="Isi4FaktorServlet?nipnilai=<c:out value="${pns.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>">${listTukesi.getIdTupoksi()}</td>
                        <td>${listTukesi.getNamaTupoksi()}</td>
                        <td>${listTukesi.getKuantitas4()}</td>
                        <td>${listTukesi.getKualitas4()}</td>
                        <td>${listTukesi.getWaktu4()}</td>
                        <td>${listTukesi.getBiaya4()}</td>
                    </tr>
                </c:forEach>
                --%>
                <c:forEach var="listUnosi" items="${unosiServlet}" varStatus="count">
                    <tr>
                        <td><div align="center">${(count.index)+1}</div></td>
                        <%--<td><a href="link"><div align="center">${listUnosi.getIdTupoksi()}</div></a></td>--%>
                        <%--<td><a href="isiTupoksiServlet?nipnilai=<c:out value="${pns.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>"><div align="center">${listUnosi.getIdTupoksi()}</div></a></td>--%>
                        <td><a href="isiTupoksiServlet?isCetak=true&nipnilai=<c:out value="${pns.getNipBaru()}"/>&idTupoksi=<c:out value="${listUnosi.getIdTupoksi()}"/>"><div align="center">${listUnosi.getIdTupoksi()}</div></a></td>
                        <td>${listUnosi.getNamaTupoksi()}</td>
                    </tr>
                </c:forEach> 
            </table>
            <%--
            <p>
                <input type="submit" name="Submit" value="Submit">
            </p>
            --%>
            
            
            
            
<SCRIPT TYPE="text/javascript">
      
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
