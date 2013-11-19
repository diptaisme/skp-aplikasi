<%-- 
    Document   : indexBaruBiru
    Created on : Apr 18, 2012, 8:50:01 AM
    Author     : diptaisme
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>SASARAN KERJA INDIVIDU</title>
    <meta name="keywords" content="corporate, free web template" />
    <meta name="description" content="SKI" />
    <link href="styleBiru.css" rel="stylesheet" type="text/css" />
    <script language="javascript" type="text/javascript">
    function clearText(field)
    {
        if (field.defaultValue == field.value) field.value = '';
        else if (field.value == '') field.value = field.defaultValue;
    }
    </script>
</head>
<body>
    <div id="container">
    <div id="templatemo_site_title_bar_wrapper">
        <div id="templatemo_site_title_bar">
            <div id="templatemo_menu" class="drop">
                <ul>
                    <%--<li><a href="SKIBiru.jsp" target="_parent" title="SKI"><span></span>SKI</a></li>
                    <li><a href="indexBaruBiru.jsp" class="current" target="_parent" title="Target Sasaran SKI"><span></span>Target</a></li>--%>
                    <li><a href="GetPnsServlet?txtNIPBaruB=<c:out value="${pns.getNipBaru()}"/>" class="current" target="_parent" title="Target Sasaran SKI"><span></span>Target</a></li>
                    
                    <li><a href="cetakIsi4FaktorServlet?nipnilai2=<c:out value="${pns.getNipBaru()}"/>&target=target" target="_blank" title="Cetak"><span></span>Cetak</a></li>
                    <li><a href="GetPnsServlet?txtNIPBaru=<c:out value="${pns.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>" target="_parent" title="Realisasi Capaian SKI"><span></span>Realisasi</a></li>  
                    <li><a href="indexloginBaru.jsp" target="_parent" title="Keluar"><span></span>Keluar</a></li>
                </ul>    	
            </div> <!-- end of templatemo_menu -->  
           
            <%--
            <div id="search_box">
                <form action="GetPnsServlet" method="post">
                    <input type="text" value="Masukkan NIP BARU disini..." name="txtNIPBaru" size="10" maxlength="18" id="searchfield" title="searchfield" onfocus="clearText(this)" onblur="clearText(this)" onkeypress="return alertnipnull(event)" />
                    <input type="Submit" name="Search" value="" alt="Search" id="searchbutton" title="Search" />
                    <input type="hidden" name="param" value="CARI" onclick="ambilPeriode()"/>
                </form>
            </div>
            --%>
            
        </div> <!-- end of templatemo_site_title_bar -->
    </div> <!-- end of templatemo_site_title_bar_wrapper -->


    
    <div id="templatemo_content3">
        <table width="1198" border="0" align="left">
            <%--
            <tr>
                <td colspan="6"><strong>Periode :</strong>
                    <select name="periode" id="periode">
                        <option value="-">-</option>
                        <option value="2011">2011</option>
                        <option value="2012">2012</option>
                        <option value="2013">2013</option>
                        <option value="2014">2014</option>
                        <option value="2015">2015</option>
                    </select>
                </td>
            </tr>
            --%>
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
                <td align="left"><c:out value="${UnorAts.getPangkat()}" /> / <c:out value="${UnorAts.getNamaGolru()}" /></td>
                <td><div align="left"><span class="style3">3</span></div></td>
                <td align="left"><span class="style3">Pangkat/Gol.Ruang</span></td>
                <td align="left"><c:out value="${pns.getPangkat()}" /> / <c:out value="${pns.getNamaGolru()}" /></td>
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
    </div>
            
    <div id="templatemo_content2" class="scroll">
        <table width="1400" border="0" align="left">
            <tr>
                <td width="31" rowspan="2"><div align="center"><span class="style3"><strong>NO</strong></span></div></td>
                <td width="80" rowspan="2"><div align="center"><span class="style3"><strong>KODE</strong></span></div></td>
                <td width="383" rowspan="2"><div align="center"><span class="style3"><strong>III. KEGIATAN TUGAS POKOK JABATAN</strong></span></div></td>
                <td colspan="5"><div align="center"><span class="style3"><strong>TARGET</strong></span></div></td>
            </tr>
            <tr>
                <td width="70" ><div align="center"><span class="style3"><strong>AK</strong></span></div></td>
                <td width="105" height="21"><div align="center"><span class="style3"><strong>KUANT/OUTPUT</strong></span></div></td>
                <td width="100"><div align="center"><span class="style3"><strong>KUAL/MUTU</strong></span></div></td>
                <td width="70"><div align="center"><span class="style3"><strong>WAKTU</strong></span></div></td>
                <td width="136"><div align="center"><span class="style3"><strong>BIAYA</strong></span></div></td>
            </tr>
            <c:forEach var="listTukesi" items="${tukesiServlet}" varStatus = "count">
                <tr>
                    <td><div align="center">${(count.index)+1}</div></td>
                    <td><div align="center"><a href ="Isi4FaktorServlet?nipnilai=<c:out value="${pns.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>">${listTukesi.getIdTupoksi()}</a></div></td>
                    <td><div align="left">${listTukesi.getNamaTupoksi()}</div></td>
                    <td><div align="right">${listTukesi.getangka_krdtR()}</div></td>
                    <td><div align="right">${listTukesi.getKuantitas4()} ${listTukesi.getkuantitas_label()} </div></td>
                    <td><div align="right">${listTukesi.getKualitas4()} %</div></td>
                    <td><div align="right">${listTukesi.getWaktu4()} ${listTukesi.getwaktu_label()} </div></td>
                    <td><div align="right">Rp. ${listTukesi.getBiaya4()}</div></td>
                    <td><div align="Left"><a href="Isi4FaktorServlet?idTupoksiHapus=<c:out value="${listTukesi.getIdTupoksi()}"/>&nipHapus=<c:out value="${pns.getNipBaru()}"/>"><img src="images/hapus2.png"></img></a></div></td>

                </tr>
            </c:forEach>
        </table>
        
        <div class="cleaner_h60"></div>				
        
        <div align="left" id="menu">
             <a href="updateServlets?txtNIPBaru=<c:out value="${pns.getNipBaru()}"/>">UPDATE</a>
          
            <a href="tupoksiServlet2?txtNIPBaru=<c:out value="${pns.getNipBaru()}"/>&jenis=<c:out value="${pns.getjnsjbtn_id()}"/>">TUGAS FUNGSI</a>
        </div>

    </div> <!-- end of content -->
    
    <div id="templatemo_footer_wrapper">
        <div id="templatemo_footer">
          
           
          
            <div class="cleaner_h10"></div>
            <center>
                | Copyright © 2013 <a href="w">Kedeputian INKA BKN Pusat</a> | 
              
            </center>
        </div> <!-- end of footer -->
    </div>

<SCRIPT TYPE="text/javascript">
function ambilPeriode()
{
    var e = document.getElementById("periode");
    var ddtk = e.options[e.selectedIndex].text;
    
    var e2 = document.getElementById("searchfield");
    var ddtk2 = e2.value;
    
    location = 'GetPnsServlet?action=NipBaruCari&txtNIPBaru='+ddtk2+'&Periode='+ddtk;
}

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
    //location = 'insertTupoksi.jsp';
    location = 'insertTupoksiBaruBiru.jsp';
}
function next_isi4faktor()
{
    //location = 'insertTupoksi.jsp';
    location = 'insertTupoksiBaruBiru.jsp';
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

//function alertnipnull()
//{
//    if (txtNIPBaru == null)
//    {
//       window.alert("Masukkan NIP anda terlebih dahulu");
//    }
//}

function alertnipnull(evt)
{
    evt = (evt) ? evt : window.event
    var charCode = (evt.which) ? evt.which : evt.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57)) 
    {
        status = "This field accepts numbers only."
        return false
    }
    status = ""
    return true
}
</script>

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


ul#nav {margin: 0 0 0 200px;}
ul.drop a { display:block; color: #fff; font-family: Verdana; font-size: 14px; text-decoration: none;}
ul.drop, ul.drop li, ul.drop ul { list-style: none; margin: 0; padding: 0; border: 1px solid #fff; background: #555; color: #fff;}
ul.drop { position: relative; z-index: 597; float: left; }
ul.drop li { float: left; line-height: 1.3em; vertical-align: middle; zoom: 1; padding: 5px 10px; }
ul.drop li.hover, ul.drop li:hover { position: relative; z-index: 599; cursor: default; background: #1e7c9a; }
ul.drop ul { visibility: hidden; position: absolute; top: 100%; left: 0; z-index: 598; width: 195px; background: #555; border: 1px solid #fff; }
ul.drop ul li { float: none; }
ul.drop ul ul { top: -2px; left: 100%; }
ul.drop li:hover > ul { visibility: visible }



</style>
    </div>
</body>
</html>
