<%-- 
    Document   : index
    Created on : Feb 13, 2012, 4:19:05 PM
    Author     : diptaisme
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sasaran Kerja PNS</title>
        
<style type="text/css">
            form fieldset
            {
                border: none;
            }
            form input.highlight
            {
                background: #f9f9f9;
                border: solid 1px #CCCCCC;
                padding: 5px;
            }
            form input.highlight:focus
            {
                border: solid 1px #D9AD00;
                background: #FFF7D7;
            }
            
.button {
	display: inline-block;
	zoom: 1; /* zoom and *display = ie7 hack for display:inline-block */
	display: inline;
	vertical-align: baseline;
	margin: 0 2px;
	outline: none;
	cursor: pointer;
	text-align: center;
	text-decoration: none;
	font: 14px/100% Arial, Helvetica, sans-serif;
	padding: .5em 2em .55em;
	text-shadow: 0 1px 1px rgba(0,0,0,.3);
	-webkit-border-radius: .5em; 
	-moz-border-radius: .5em;
	border-radius: .5em;
	-webkit-box-shadow: 0 1px 2px rgba(0,0,0,.2);
	-moz-box-shadow: 0 1px 2px rgba(0,0,0,.2);
	box-shadow: 0 1px 2px rgba(0,0,0,.2);
}
.button:hover {
	text-decoration: none;
}
.button:active {
	position: relative;
	top: 1px;
}
.bigrounded {
	-webkit-border-radius: 2em;
	-moz-border-radius: 2em;
	border-radius: 2em;
}
.black {
	color: #d7d7d7;
	border: solid 1px #333;
	background: #333;
	background: -webkit-gradient(linear, left top, left bottom, from(#666), to(#000));
	background: -moz-linear-gradient(top,  #666,  #000);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#666666', endColorstr='#000000');
}
.black:hover {
	background: #000;
	background: -webkit-gradient(linear, left top, left bottom, from(#444), to(#000));
	background: -moz-linear-gradient(top,  #444,  #000);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#444444', endColorstr='#000000');
}
.black:active {
	color: #666;
	background: -webkit-gradient(linear, left top, left bottom, from(#000), to(#444));
	background: -moz-linear-gradient(top,  #000,  #444);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#000000', endColorstr='#666666');
}

body
{background-color:whitesmoke}
</style>
    </head>
    <body onload="updateClock();">
      <form name="clock">
          Waktu Sekarang : <input name="time" type="text" value="" size="35">
      </form>
      <form>
          Login Sebagai : <input name="login" type="" value="" size="35">
      </form>
      <form method="post" name="form1" action="GetPnsServlet">
        <div align="center" class="style1"> 
            <p><h2>FORMULIR SASARAN KERJA REALISASI</h2></P>
            <p><h2>PEGAWAI NEGERI SIPIL</h2></p>
            <p align="left"><span class="style3">Nomor Induk Pegawai Negeri Sipil ( 18 Digit ) : 
            <input class="highlight" name="txtNIPBaru" type="text" size="35." maxlength="18">
            <input type="submit" class="button black bigrounded" name="Submit" value="CARI">
            </span></p>
            <div align="justify">
                    <table width="1198" height="34" border="1" align="left">
                        <tr>
                            <td width="30" height="28"><div align="center"><span class="style3">NO</span></div></td>
                            <td width="555"><span class="style3">I. PEJABAT PENILAI </span></td>
                            <td width="30"><div align="center"><span class="style3">NO</span></div></td>
                            <td width="555"><span class="style3">II. PEGAWAI NEGERI SIPIL YANG DINILAI </span></td>
                        </tr>
                    </table>
                    <div align="right"></div>
                    <div align="right"></div>
             </div>
                <table width="1198" border="1" align="left">
                    <tr>
                        <td width="30"><div align="left"><span class="style3">1</span></div></td>
                        <td width="135" align="left"><span class="style3">Nama</span></td>
                        <td width="414" align="left"> <c:out value="${UnorAts.getNamaPns()}" /> </td>
                        <td width="30"><div align="left"><span class="style3">1</span></div></td>
                        <td width="135" align="left"><span class="style3">Nama</span></td>
                        <td width="414" align="left"> <c:out value="${pns.getNamaPns()}"/> </td>
                    </tr>
                    <tr>
                        <td><div align="left"><span class="style3">2</span></div></td>
                        <td align="left"><span class="style3">NIP</span></td>
                        <td align="left"><c:out value="${UnorAts.getNipBaru()}" /></td>
                        <td><div align="left"><span class="style3">2</span></div></td>
                        <td align="left"><span class="style3">NIP</span></td>
                        <td align="left"><c:out value="${pns.getNipBaru()}" /></td>
                        <input  type="hidden"  name="_getInstansi" value="${pns.getNipBaru()}">
                    </tr>
                    <tr>
                        <td><div align="left"><span class="style3">3</span></div></td>
                        <td align="left"><span class="style3">Pangkat/Gol.Ruang</span></td>
                        <td align="left"><c:out value="${UnorAts.getPangkat()}" /></td>
                        <td><div align="left"><span class="style3">3</span></div></td>
                        <td align="left"><span class="style3">Pangkat/Gol.Ruang</span></td>
                        <td align="left"><c:out value="${pns.getPangkat()}" /></td>
                    </tr>
                    <tr>
                        <td><div align="left"><span class="style3">4</span></div></td>
                        <td align="left"><span class="style3">Jabatan</span></td>
                        <td align="left"><c:out value="${UnorAts.getNamaJabatan()}" /></td>
                        <td><div align="left"><span class="style3">4</span></div></td>
                        <td align="left"><span class="style3">Jabatan</span></td>
                        <td align="left"><c:out value="${pns.getNamaJabatan()}" /></td>
                    </tr>
                    <tr>
                        <td><div align="left"><span class="style3">5</span></div></td>
                        <td align="left"><span class="style3">Unit Kerja </span></td>
                        <td align="left"><c:out value="${UnorAts.getNamaUnor()}" /></td>
                        <td><div align="left"><span class="style3">5</span></div></td>
                        <td align="left"><span class="style3">Unit Kerja </span></td>
                        <td align="left"><c:out value="${pns.getNamaUnor()}" /></td>
                    </tr>
                </table>
                <p align="left">&nbsp;</p>
                <p align="left">&nbsp;</p>
                <p align="left">&nbsp;</p>
                <p align="left">&nbsp;</p>
                <table width="1400" border="1" align="left">
                    <tr>
                        <td width="31" rowspan="2"><div align="center"><span class="style3">NO</span></div></td>
                        <td width="80" rowspan="2"><div align="center"><span class="style3">KODE</span></div></td>
                        <td width="383" rowspan="2"><div align="center"><span class="style3">III. KEGIATAN TUGAS POKOK JABATAN </span></div></td>
                        <td colspan="4"><div align="center"><span class="style3">TARGET</span></div></td>
                    </tr>
                    <tr>
                        <td width="105" height="21"><div align="center"><span class="style3">KUANT/OUTPUT</span></div></td>
                        <td width="100"><div align="center"><span class="style3">KUAL/MUTU</span></div></td>
                        <td width="70"><div align="center"><span class="style3">WAKTU</span></div></td>
                        <td width="136"><div align="center"><span class="style3">BIAYA</span></div></td>
                    </tr>
                    <c:forEach var="listResult" items="${listResult}" varStatus = "count">
                        <tr>
                            <td>${(count.index)+1}</td>
                            <td>${listResult.getIdTupoksi()}</td>
                            <td>${listResult.getNamaTupoksi()}</td>
                            <td>${listResult.getKuantitas4()}</td>
                            <td>${listResult.getKualitas4()}</td>
                            <td>${listResult.getWaktu4()}</td>
                            <td>${listResult.getBiaya4()} <div align="center"> </div> </td>
                        </tr>
                    </c:forEach>
                </table>
                <p>&nbsp;</p>
                <p>
                    <a href="cetakIsi4FaktorServlet?nipnilai2=<c:out value="${pns.getNipBaru()}"/>">CETAK FORM SKP</a><br>
                    <%--    <a href="tupoksi.jsp">TUGAS FUNGSI</a><br>  --%>
                    <%--
                    <a href="tupoksiServlet?txtNIPBaru=<c:out value="${pns.getNipBaru()}"/>" onclick="myPopup2()">TUGAS FUNGSI</a><br>
                    <a href="indexRealisasi.jsp">REALISASIXXX</a>
                     <a href="GetPnsServlet?niprealisasi=<c:out value="${pns.getNipBaru()}"/>">LAPORAN REALISASI</a><br>
                </P>
                <p><input type="submit"  name="param" value="INSERT"></p>
               
                <%--<p><input type="button" onclick="show_alert()" value="Show alert box"></p>--%>
                <%--
                <p><input type="button" onclick="myPopup2()" value="SHOW"></p>
                <p><input type="button" onclick="next()" value="OPERATOR"></p>
                
            
<SCRIPT TYPE="text/javascript">
function popup(mylink, windowname)
{
if (! window.focus)return true;
var href;
if (typeof(mylink) == 'string')
   href=mylink;
else
   href=mylink.href;
window.open(href, windowname, 'width=400,height=200,scrollbars=yes');
return false;
}

function next()
{
    location = 'insertTupoksi.jsp';
}
function next_isi4faktor()
{
    location = 'insertTupoksi.jsp';
}
function myPopup2() 
{
    window.open( "tupoksiServlet?txtNIPBaru=<c:out value="${pns.getNipBaru()}"/>", "myWindow", "status = 0, height = 500, width = 1000, resizable = 0, scrollbars=yes" )
}

function show_alert()
{
    var r=confirm("Press a button");
        
    if (r==true)
    {
        alert("You pressed OK!");
    }
    else
    {
        alert("You pressed Cancel!");
    }
}

function alert()
{
    alert("TUPOKSI MASIH KOSONG");
}

function banner()
{
    
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

            
            <p>&nbsp;</p>
            <p align="justify">&nbsp;</p>
        </div>
     </form>
        <p align="justify">&nbsp;</p>
        <p align="center"><strong></strong></p>
        <p>&nbsp; </p>
    </body>
</html>
--%>
