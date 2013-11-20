<%-- 
    Document   : nilaiTugasTambahan
    Created on : Jun 1, 2012, 2:55:05 PM
    Author     : diptaisme
--%>

<%@page import="groovy.lang.PackageScope"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>SASARAN KERJA INDIVIDU</title>
<meta name="keywords" content="corporate, free web template" />
<meta name="description" content="SKI" />
<link href="/SKPapplication/css/styleBiru.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript">
function clearText(field)
{
    if (field.defaultValue == field.value) field.value = '';
    else if (field.value == '') field.value = field.defaultValue;
}
</script>
<style type="text/css">
#button {
	display: block;
	width: 175px;
	height: 45px;
	margin: 0px auto;
}
#button input:focus{

}
#button input:hover{
	background-image:url('/SKPapplication/images/clicktosend_hover.gif');
	background-position:left top;
	background-repeat:no-repeat;
}
</style>

</head>
<body>

   <div id="templatemo_site_title_bar_wrapper">
        <div id="templatemo_site_title_bar">

        </div> <!-- end of templatemo_site_title_bar -->
    </div> <!-- end of templatemo_site_title_bar_wrapper -->

    
       
 <form method="post" name="form1" action="isiPerilakuServlet">  
     <div >
         <table width="1198" border="0">
             <tr >
                 <td><strong>STAFF/PEJABAT STRUKTURAL</strong><input type="hidden" name="nipAtasan" id ="nipAtasan" value="${nipAtasan}"/> <input type="hidden"  name="nipBaru" id ="nipBaru" value="${pns.getNipBaru()}"</td>
                 <td><strong>PENILAIAN TUGAS TAMBAHAN</strong></td>
                 <td><strong>PENILAIAN KREATIFITAS</strong> </td>
             </tr>
             <tr>
                 <td valign="top">
                     <table width="430">
                         <tbody>
                             <tr>
                                 <td>NIP BARU   :</td>
                                 <td><input type="number" maxlength="18" id="cariNip" name="cariNip"/> </td>
                                 <td><input type="image" src="/SKPapplication/images/cari.png" id="cariNip" name="cariNip" value="cari"/></td>
                                 <%--<td><a href="isiPerilakuServlet?action=CariBawahan"><img src="images/cari.png"></img></a></td>
                                 --%>
                             </tr>
                                 
                             <tr>
                                 <td>Nama :</td>
                                 <td><input type="text" id="cariNama" name="cariNama" /></td>
                                 <td><input type="image" src="/SKPapplication/images/cari.png" id="cariNama" name="cariNama" value="cari"/></td>
                             </tr>
                               <tr>
                                   
                                    <td><strong>No</strong></td>
                                    <td><strong>NIP</strong></td>
                                    <td><strong>Nama PNS</strong></td>
                                </tr> 
                     </table>
                     <div    class="scrollKecil">
                     <table width="398"  >
                            <c:forEach var="pnsList" items="${pnsList}" varStatus="count">
                               
                             <tr >
                                 
                                   
                                    <td align="center"><a href="isiPerilakuServlet?action=Koef&NipKoefKreatifitas=<c:out value="${pnsList.getNipBaru()}"/>">${(count.index)+1}</a></td>
                                    <td><div align="left"><a href="isiPerilakuServlet?action=Koef&NipKoefKreatifitas=<c:out value="${pnsList.getNipBaru()}"/>">${pnsList.getNipBaru()}</a></div></td>
                                    <td><div align="left"><a href="isiPerilakuServlet?action=Koef&NipKoefKreatifitas=<c:out value="${pnsList.getNipBaru()}"/>">${pnsList.getNamaPns()}</a></div></td>
                                 
                            </tr>
                                    
                            </c:forEach>
                                                         
                         </tbody>
                     </table>
                         </div>
                 </td>
                 <%--
                 <td>
                    <table width="400">
                        <tbody>
                               <tr align="center">
                                   <td colspan="5"><strong><u>Tugas Tambahan</u></strong></td>
                                </tr>
                                <tr>
                                    <td><strong>No</strong></td>
                                    <td><strong>Tugas</strong></td>
                                    <td><strong>T</strong></td>
                                    <td><strong>R</strong></td>
                                    <td><strong>Nilai</strong></td>
                                </tr> 
                            <c:forEach var="listtugasTambahans" items="${tugasTambahans}" varStatus="count">
                                <tr>       
                                    <td><div align="center">${(count.index)+1}</div></td>
                                    <td><div align="left">${listtugasTambahans.getNama()}</div></td>
                                    <td><div align="center">${listtugasTambahans.getNilai1()}</div></td>
                                    <td><div align="center">${listtugasTambahans.getNilai2()}</div></td>
                                    <td><div align="center">${listtugasTambahans.getNilaiTambahan()}</div></td>
                                </tr>
                            </c:forEach>
                         </tbody>
                    </table>
                    <hr />
                    <table width="400">
                        <tbody>
                                <tr align="center">
                                    <td colspan="5"><strong><u>Kreatifitas</u></strong></td>
                                </tr>
                                <tr>
                                    <td><strong>No</strong></td>
                                    <td><strong>Tugas</strong></td>
                                    <td><strong>T</strong></td>
                                    <td><strong>R</strong></td>
                                    <td><strong>Nilai</strong></td>
                                </tr> 
                            <c:forEach var="tambahans" items="${kereaktifitas}" varStatus ="count">
                                <tr>
                                    <td align="center">${(count.index)+1}</td>
                                    <td align="left"><a href="isiPerilakuServlet?action=Kreaf&NipKoefKreatifitas=<c:out value="${idNipTambahan}"/>&idTam=<c:out value="${tambahans.getIdTambahan()}"/>">${tambahans.getNama()}</a></td>
                                    <td align="center">${tambahans.getNilai1()}</td>
                                    <td align="center">${tambahans.getNilai2()}</td>
                                    <td align="center">${tambahans.getNilaiTambahan()}</td>
                                </tr>
                            </c:forEach>
                         </tbody>
                    </table>
                </td>
                 --%>
                 <td valign="top">
                    <table width="400">
                        <tbody>
                            <tr align="center">
                                    <td colspan="5"><strong><u>Penilaian Tugas Tambahan</u></strong></td>
                            </tr>
                            <tr>
                                <td><strong>No</strong></td>
                                <%--<td><strong>Id</strong></td>--%>
                                <td><strong>Nama</strong></td>
                                <td><strong>Persetujuan</strong></td>
                            </tr>
                            <c:forEach var="listtugasTambahans" items="${tugasTambahans}" varStatus="count">
                                <tr>       
                                    <td><div align="center">${(count.index)+1}</div></td>
                                    <%--<td><div align="left">${listtugasTambahans.getIdTambahan()}</div></td>--%>
                                    <td><div align="left">${listtugasTambahans.getNama()}</div></td>
                                    <td><div align="center"><a href="isiPerilakuServlet?action=TolakTugasTambahan&idTambahanTgsTmbhn=<c:out value="${listtugasTambahans.getIdTambahan()}"/>&nipTambahan=<c:out value="${idNipTambahan}"/>">TOLAK???</a></div></td>
                                </tr>
                            </c:forEach>
                            <input type="hidden" name="idNilaiKoef" value="${idNipTambahan}">
                         </tbody>   
                    </table>
                    <hr />     
                    <div><a href="isiPerilakuServlet?action=HitungTambahan&nipTambahan=<c:out value="${idNipTambahan}"/>">HITUNG</a><strong>&nbsp;&nbsp;:&nbsp;&nbsp;</strong>${hitunganTugasTambahan}</div>
               </td> 
               <td valign="top">
                    <table width="400">
                        <tbody>
                                <tr align="center">
                                    <td colspan="5"><strong><u>Kreatifitas</u></strong></td>
                                </tr>
                                <tr>
                                    <td><strong>No</strong></td>
                                    <td><strong>Tugas</strong></td>
                                    <td><strong>Persetujuan</strong></td>
                                </tr> 
                            <c:forEach var="tambahans" items="${kereaktifitas}" varStatus ="count">
                                <tr>
                                    <td align="center">${(count.index)+1}</td>
                                    <td align="left"><a href="isiPerilakuServlet?action=Kreaf&NipKoefKreatifitas=<c:out value="${idNipTambahan}"/>&idTam=<c:out value="${tambahans.getIdTambahan()}"/>">${tambahans.getNama()}</a></td>
                                    <td align="left"><a href="isiPerilakuServlet?action=Kreaf&NipKoefKreatifitas=<c:out value="${idNipTambahan}"/>&idTam=<c:out value="${tambahans.getIdTambahan()}"/>">${tambahans.getKoef_kreatifitas()}</a></td>
                                </tr>
                            </c:forEach>
                         </tbody>
                    </table>
                    <hr />
                    <table width="400">
                        <tbody>
                            <tr align="center">
                                    <td colspan="5"><strong><u>Penilaian Kreatifitas</u></strong></td>
                            </tr>
                            <tr>
                                <td><strong>Id</strong></td>
                                <td><strong>Nama</strong></td>
                                <td><strong>Koefisien</strong></td>
                            </tr>
                            <tr>
                                <td>${kereaktifitas2.getIdTambahan()}</td>
                                <td>${kereaktifitas2.getNama()}</td>
                                <%--
                                <td>
                                    <select name="koef_kreatifitas" id="koef_kreatifitas">
                                        <option value="10">10</option>
                                        <option value="20">20</option>
                                        <option value="30">30</option>
                                    </select>
                                </td>
                                --%>
                                <td>
                                    <select name="koef_kreatifitas" id="koef_kreatifitas">
                                        <option value="-">-</option>
                                        <option value="10">Unit Kerja</option>
                                        <option value="20">Instansi</option>
                                        <option value="30">Nasional</option>
                                        <option value="40">Tidak Valid</option>
                                    </select>
                                </td>
                            </tr>
                            <%-- <input type="button" name="paramKoefKreatifitas" onclick="ButtonKoef()" value="HITUNG"> --%>
                            <%-- <td><a href=  id="url" onclick="redirect()">HITUNG</a></td> --%>
                            <td><a href="isiPerilakuServlet?action=HitungKreatifitas&idTambahanKreatifitas=<c:out value="${kereaktifitas2.getIdTambahan()}"/>&nipTambahan=<c:out value="${idNipTambahan}"/>" id="url" onclick="redirect()">HITUNG</a></td> 
                            <input type="hidden" name="idNilaiKoef" value="${idNipTambahan}">
                         </tbody>
                    </table>
               </td>
            </tr>
       </table>
       <%--<input type="submit" name="param" class="button black bigrounded" value="CETAK">
       <td><c:out value="${nipAtasan}"/></td>
       <td align="center"><a href="GetPnsServlet?txtNIPBaruReal=<c:out value="${nipAtasan}"/>">SELESAI</a></td>--%>
       <input type="hidden" name="nipAtasan" id="nipAtasan" value="${nipAtasan}">
       <input type="button" name="param" class="button black bigrounded" onclick="kembali()" value="SELESAI">
     </div>    
                
    
<SCRIPT TYPE="text/javascript">
function onchangecombo()
{
    var e2 = document.getElementById("idKreaf");
    var ddtk2 = e2.value;
    
    var e = document.getElementById("koef_kreatifitas");
    var ddtk = e.options[e.selectedIndex].text;

    location = 'isiPerilakuServlet?action=HitungKreatifitas&idTambahanKreatifitas='+ddtk2+'&nipTambahan=<c:out value="${idNipTambahan}"/>&koef_kreatifitas='+ddtk;
}

function selfSubmit()
{
  document.form1.action="";
  document.form1.submit();
}

function redirect()
{
   pilihan=document.getElementById("koef_kreatifitas").value;
   url=document.getElementById("url");
   url.href=url.href+"&koef_kreatifitas=" + pilihan;
} 

function ambil_combo()
{
    var e = document.getElementById("koef_kreatifitas");
    var ddtk = e.options[e.selectedIndex].text;
    return ddtk;
}

function kembali()
{
    location = 'GetPnsServlet?txtNIPBaruReal=<c:out value="${nipAtasan}"/>';
}

function refresh()
{
    location = 'Isi4FaktorServlet?nipnilai=<c:out value="${pns.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>';
}

function ButtonKoef()
{
    //ddtk = document.getElementById("koef_kreatifitas");
    //document.myform.options[document.myform.selectedIndex].text
    //ddtk = document.form1.koef_kreatifitas.selectedIndex.value;
    //ddtk = document.form1.idNipTextId.value;
    //var e2 = document.getElementById("idKreaf");
    //var ddtk2 = e2.options[e2.selectedIndex].text;
    
    //var ddtk2 = document.form1.idKreaf.value;
    var e2 = document.getElementById("idKreaf");
    var ddtk2 = e2.value;
    
    var e = document.getElementById("koef_kreatifitas");
    var ddtk = e.options[e.selectedIndex].text;

    location = 'isiPerilakuServlet?action=HitungKreatifitas&idTambahanKreatifitas='+ddtk2+'&nipTambahan=<c:out value="${idNipTambahan}"/>&koef_kreatifitas='+ddtk;
    
    //location = 'isiPerilakuServlet?action=HitungKreatifitas&idTambahanKreatifitas=<c:out value="${tambahans.getIdTambahan()}"/>&nipTambahan=<c:out value="${idNipTambahan}"/>&koef_kreatifitas='+ddtk;
    //location = 'isiPerilakuServlet?action=HitungKreatifitas&idTambahanKreatifitas=<c:out value="${tambahans.getIdTambahan()}"/>&nipTambahan=<c:out value="${tambahans.getIdNip()}"/>&koef_kreatifitas='+ddtk;
    //location = 'isiPerilakuServlet?action=HitungKreatifitas&idTambahanKreatifitas='+ddtk2+'&nipTambahan=<c:out value="${idNipTambahan}"/>&koef_kreatifitas='+ddtk;
    //location = 'isiPerilakuServlet?action=HitungKreatifitas&idTambahanKreatifitas='+ddtk2+'<c:out value="${tambahans.getIdTambahan()}"/>&nipTambahan=<c:out value="${idNipTambahan}"/>&koef_kreatifitas='+ddtk;
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
    
    var coba = now.getDay().toString();

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
</form>			
    </div> <!-- end of content -->
<div class="cleaner_h60"></div>
    <div id="templatemo_footer_wrapper">
        <div id="templatemo_footer">
            <div class="section_w280">
                <h3>Alamat Kantor</h3>
                <div class="sub_content">
                    <p>
                        Jl. Letjen Sutoyo No.12<br />
                        Cililitan Jakarta Timur 13640.<br />
                        Tel : 021-8093008 #4210<br />
                    </p>
                </div>
            </div>
            <div class="section_w280">
                <h3>Partners</h3>
                <div class="sub_content">
                    <ul class="footer_list">
                        <li><a href="https://sapk.bkn.go.id" target="_parent">SAPK</a></li>
                        <li><a href="https://hr.bkn.go.id" target="_parent">HRMA</a></li>
                        <li><a href="https://dms.bkn.go.id" target="_parent">TAKAH</a></li>
                    </ul>
                </div>
            </div>
            <div class="section_w280">
                <h3>Quick Wins</h3>
                <div class="sub_content">
                    <p>Dalam rangka akselerasi reformasi birokrasi. BKN menetapkan quick wins BKN yaitu SAPK, CAT, SKI, Assesment Center dan KPE.</p>
                </div>
            </div>
            <div class="cleaner_h10"></div>
            <center>
                | Copyright © 2012  | 
            </center>
        </div> <!-- end of footer -->
    </div>

<%--
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
--%>

<style type="text/css"> 
#menu a
{
        display:block;
        width:120px;
        margin: 1em 0; padding:7px 0 10px 20px;
        font: bold 14px/1 sans-serif;
        color:#c60;
        /*background: url(http://www.image-share.com/upload/1396/159.gif) 0 0 no-repeat;*/
        background: url(/SKPapplication/images/button.gif) 0 0 no-repeat;
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
        width: 150px;
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
</style>

</body>
</html>
