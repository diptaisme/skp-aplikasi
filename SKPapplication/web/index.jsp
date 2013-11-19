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
 
#menu a
{
        display:block;
        width:120px;
        margin: 1em 0; padding:7px 0 10px 20px;
        font: bold 14px/1 sans-serif;
        color:#c60;
        /*background: url(http://www.image-share.com/upload/1396/159.gif) 0 0 no-repeat;*/
        background: url(images/button.gif) 0 0 no-repeat;
        text-decoration: none;
}
	
#menu a:hover
{	
        background-position: -157px 0;
        color: #E9BE75;
}
	
#menu a:active
{
        background-position: -314px 0;
        color:white;
}
   
    
    
    
    
    
    
    
tr:nth-child
{
    background-color:#D9D7D7; color: black;
}

tr:nth-child(even)
{
    background-color:#D9D7D7; color: black;
}

/*
table
{
    border-spacing: 0px;
}

th
{
    font-weight: bold;
    border: 2px solid #FFFFFF;
}

td
{
    border: 2px solid #FFFFFF;
}
*/
     
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
/*{background-image:url(http://www.image-share.com/upload/1396/142.jpg)}*/
/*{background-image:aliceblue}*/
{
    background:#000 url(images/rusak.jpeg) repeat top left;
    margin:0;
    padding:0;
}
</style>
    </head>
    <body onload="updateClock();">
      <form name="clock">
          Waktu Sekarang : <input name="time" type="text" value="" size="35">
      </form>
      <form action="loginPassServlet">
          Login Sebagai : <input name="login" type="text" value="${sessionScope.log.getusername_login()}" size="35">
      </form>
      <form method="post" name="form1" action="GetPnsServlet">
          <div align="center" class="style1"> 
            <p><h2>FORMULIR SASARAN KERJA</h2></P>
            <p><h2>PEGAWAI NEGERI SIPIL</h2></p>
            <p align="left"><span class="style3"><strong><font size ="4">Nomor Induk Pegawai Negeri Sipil ( 18 Digit ) :</font></strong> 
            <input class="highlight" name="txtNIPBaru" type="text" size="35." maxlength="18">
            <input type="submit" class="button black bigrounded" name="param" value="CARI" onclick="alertnipnull()">
            </span></p>
            <div align="justify">
                    <table width="1198" height="34" border="0" align="left">
                        <tr>
                            <td width="30" height="28"><div align="center"><span class="style3">NO</span></div></td>
                            <td width="555"><span class="style3"><strong>I. PEJABAT PENILAI</strong></span></td>
                            <td width="30"><div align="center"><span class="style3">NO</span></div></td>
                            <td width="555"><span class="style3"><strong>II. PEGAWAI NEGERI SIPIL YANG DINILAI</strong></span></td>
                        </tr>
                    </table>
                    <div align="right"></div>
                    <div align="right"></div>
             </div>
                <table width="1198" border="0" align="left">
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
                
                <table width="1400" border="0" align="left">
                    <tr>
                        <td width="31" rowspan="2"><div align="center"><span class="style3"><strong>NO</strong></span></div></td>
                        <td width="80" rowspan="2"><div align="center"><span class="style3"><strong>KODE</strong></span></div></td>
                        <td width="383" rowspan="2"><div align="center"><span class="style3"><strong>III. KEGIATAN TUGAS POKOK JABATAN</strong></span></div></td>
                        <td colspan="4"><div align="center"><span class="style3"><strong>TARGET</strong></span></div></td>
                    </tr>
                    <tr>
                        <td width="105" height="21"><div align="center"><span class="style3"><strong>KUANT/OUTPUT</strong></span></div></td>
                        <td width="100"><div align="center"><span class="style3"><strong>KUAL/MUTU</strong></span></div></td>
                        <td width="70"><div align="center"><span class="style3"><strong>WAKTU</strong></span></div></td>
                        <td width="136"><div align="center"><span class="style3"><strong>BIAYA</strong></span></div></td>
                    </tr>
                    <c:forEach var="listTukesi" items="${tukesiServlet}" varStatus = "count">
                        <tr>
                            <td><div align="center">${(count.index)+1}</div></td>
                            <td><div align="center"><a href ="Isi4FaktorServlet?nipnilai=<c:out value="${pns.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>">${listTukesi.getIdTupoksi()}</div></td>
                            <td><div align="left">${listTukesi.getNamaTupoksi()}</div></td>
                            <td><div align="right">${listTukesi.getKuantitas4()} ${listTukesi.getkuantitas_label()} </div></td>
                            <td><div align="right">${listTukesi.getKualitas4()}</div></td>
                            <td><div align="right">${listTukesi.getWaktu4()} ${listTukesi.getwaktu_label()} </div></td>
                            <td><div align="right">${listTukesi.getBiaya4()}</div></td>
                        </tr>
                    </c:forEach>
                </table>
                <p>&nbsp;</p><br>
                <p><input type="hidden" onclick="next()" value="OPERATOR"></p><br>
                <span style="font-family:Verdana; font-size: 12px; font-weight:bold; text-shadow:4px 4px 8px blue; letter-spacing:10px; word-spacing:20px;"> <marquee direction="left" scrollamount="5" height="20px" width="100%"> Aplikasi Sasaran Kinerja Individu PNS Badan Kepegawaian Negara </marquee></span>
                <%-- <p style="direction:rtl;text-shadow:4px 4px 8px blue;"> A p l i k a s i   S a s a r a n   K i n e r j a   I n d i v i d u   P N S   B a d a n K e p e g a w a i a n N e g a r a </p><br>--%>
                <p>&nbsp;</p>
                <div align="left" id="menu">  
                    <a href="cetakIsi4FaktorServlet?nipnilai2=<c:out value="${pns.getNipBaru()}"/>">CETAK SKP</a>
                    <%--    <a href="tupoksi.jsp">TUGAS FUNGSI</a><br>  --%>
                    <%-- <a href="tupoksiServlet?txtNIPBaru=<c:out value="${pns.getNipBaru()}"/>" onclick="myPopup2()">TUGAS FUNGSI</a><br> --%>
                    <a href="tupoksiServlet?txtNIPBaru=<c:out value="${pns.getNipBaru()}"/>">TUGAS FUNGSI</a>
                    <%-- <a href="indexRealisasi.jsp">REALISASIXXX</a> --%>
                    <a href="GetPnsServlet?txtNIPBaru=<c:out value="${pns.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>">REALISASI</a>
                    <a href="cobaIndex.jsp">KELUAR</a>
                    <%-- <a href="GetPnsServlet?niprealisasi=<c:out value="${pns.getNipBaru()}"/>">LAPORAN REALISASI</a><br> --%>
                </div>
                <%--<p><input type="submit"  name="param" value="INSERT"></p>--%>
                
                <%--<p><input type="button" onclick="show_alert()" value="Show alert box"></p>--%>
                <%-- <p><input type="button" onclick="myPopup2()" value="SHOW"></p> --%>
                
                
            
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
    //location = 'insertTupoksiBaruBiru.jsp';
}
function next_isi4faktor()
{
    location = 'insertTupoksi.jsp';
    //location = 'insertTupoksiBaruBiru.jsp';
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

function alertnipnull()
{
    if (txtNIPBaru == null)
    {
        window.alert("Masukkan NIP anda terlebih dahulu");
    }
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
