<%-- 
    Document   : isi4faktorBaru.jsp
    Created on : Apr 19, 2012, 12:05:48 PM
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
<link href="/SKPapplication/css/styleBiru.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript">

$(document).ready(function(){
    $('#waktu4text').keyup(function(){
        var len=this.value.length;
        if (len > 3){
            this.value=this.value.substring(0,2)
        }
    })
});



function validasitest2(){
var vkuantitas4text = document.getElementById("kuantitas4text"); 
var vidkualitas4text = document.getElementById("kualitas4text"); 
var vwaktu4text = document.getElementById("waktu4text");
var vbiaya4text =  document.getElementById("biaya4text");

if(vkuantitas4text.value == "-"||vkuantitas4text.value == ""||vkuantitas4text.value == " "){
    alert("Mohon Cek untuk Kuantitas");
    return false;
    }
if(vidkualitas4text.value == "-"||vidkualitas4text.value == ""){
    alert("Mohon Cek untuk Kualitas");
    return false;
    }
if(vwaktu4text.value == "-"||vwaktu4text.value == ""){
    alert("Mohon Cek untuk Biaya");
    return false;
    }
if(vbiaya4text.value == "-"||vbiaya4text.value == ""){
    alert("Mohon Cek untuk Biaya");
    return false;
    }

else{
    return true;
}



function hitung(field){
      //  document.form1.akr.value = document.form1.kuantitas4text.value * document.form1.akt.value ;
    //    var a = document.getElementById("kuantitas4text").value;
       alert('test' + document.form1.kuantitas4text.value);
}

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
	background-image:url('images/clicktosend_hover.gif');
	background-position:left top;
	background-repeat:no-repeat;
}
</style>

</head>
<body>

   <div id="templatemo_site_title_bar_wrapper">
        <div id="templatemo_site_title_bar">
            <div id="templatemo_menu">
                <ul>
                    <li><a href="GetPnsServlet?txtNIPBaruB=<c:out value="${pnsp.getNipBaru()}"/>" target="_parent" title="Target Sasaran SKI"><span></span>Target</a></li>
                    <li><a href="RequestServlet?page=indexloginBaru" target="_parent" title="Keluar"><span></span>Keluar</a></li>
                </ul>    	
            </div> <!-- end of templatemo_menu -->  
            <div class="cleaner"></div>
            <%--
            <div id="search_box">
                <form action="GetPnsServlet" method="post">
                    <input type="text" value="Masukkan NIP BARU disini..." name="txtNIPBaru" size="10" id="searchfield" title="searchfield" onfocus="clearText(this)" onblur="clearText(this)" />
                    <input type="Submit" name="Search" value="" alt="Search" id="searchbutton" title="Search" />
                    <input type="hidden" name="param" value="CARI"/>
                </form>
            </div>
            --%>
        </div> <!-- end of templatemo_site_title_bar -->
    </div> <!-- end of templatemo_site_title_bar_wrapper -->

            
    <div id="templatemo_content2">
        <form method="post" name="form1" id="form1" action="Isi4FaktorServlet">
            <table width="800" border="0">
                <tr>
                    <td colspan="3" align="center"><span class="style1">FORM ISIAN TARGET 4 FAKTOR </span></td>
                </tr>
                <tr>
                    <td width="119" rowspan="10">
                        <div align="center">
                            <input type="submit" name="param" class="button black bigrounded" value="SIMPAN" />
                            <input type="submit" name="param" class="button black bigrounded" value="BATAL" />
                            <input type="button" name="param" onclick="ButtonBack()" class="button black bigrounded" value="KEMBALI" />
                            <%--<input type="submit" name="param" value="CARI TUPOKSI">--%>
                        </div>       
                    </td>
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
                    <td><strong><span class="style2">ANGKA KREDIT</span></strong></td>
                    
                     <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2">:  </span></strong><c:out value="${namaAngka_krdtjsp}" /></td>
                    
                </tr>
                <tr>
                    <td><strong><span class="style2">KUANTITAS</span></strong></td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2">:  <input type="text" align="right" id="kuantitas4text" name="kuantitas4text"  onfocus="clearText(this)" value="${tupoksiKeIsi4Faktor.getKuantitas4()}" style="text-align: right" onkeypress="return alertnipnull(event)" /></span></strong>
                        ${tupoksiKeIsi4Faktor.getkuantitas_label()}
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <select name="pilih_output">
                            <option value="-">-</option>
                            <option value="Dokumen">Dokumen</option>
                            <option value="Kegiatan">Kegiatan</option>
                            <option value="Laporan">Laporan</option>
                            <option value="Paket">Paket</option>
                            <option value="Nota Persetujuan">Nota Persetujuan</option>
                            <option value="Konsep">Konsep</option>
                            <option value="Berkas">Berkas</option>
                            <option value="Data">Data</option>
                            <option value="Surat">Surat</option>
                            <option value="Kali">Kali</option>
                            <option value="Naskah">Naskah</option>
                            <option value="Jam Pelajaran">Jam Pelajaran</option>
                            <option value="Bahan Tayang">Bahan Tayang</option>
                            <option value="GBPP/SAP">GBPP/SAP</option>
                            <option value="Artikel">Artikel</option>
                            <option value="Buku">Buku</option>
                            <option value="SPP">SPP</option>
                            <option value="SPM">SPM</option>
                            <option value="Modul">Modul</option>
                            <option value="Jabatan">Jabatan</option>
                         </select>
                    </td>
                </tr>
                        
                     <tr>     
                             <td><strong><span class="style2">AK TARGET</span></strong></td>
                             <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2">:  </span></strong><c:out value="${tupoksiKeIsi4Faktor.getangka_krdtR()}" /></td>
                    </tr>
                 <tr>
                             <td><strong><span class="style2">KUALITAS</span></strong></td>
                             <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2">:  <input type="text" id="idkualitas4text" name="kualitas4text" value="${tupoksiKeIsi4Faktor.getKualitas4()}" align="right" style="text-align: right" onfocus="clearText(this)" onchange="hitung(event)" onkeypress="return alertnipnull(event)" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; % </span></strong></td>
                </tr>
                
                <tr>
                             <td><strong><span class="style2">WAKTU</span></strong></td>
                             <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2">:  <input type="text" maxlength="2" onfocus="clearText(this)" id ="waktu4text" name="waktu4text" value="${tupoksiKeIsi4Faktor.getWaktu4()}" align="right" style="text-align: right" onkeypress="return alertnipnull2(event)" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; bln </span></strong></td>
                </tr>
                <tr>
                             <td><strong><span class="style2">BIAYA</span></strong></td>
                             <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2">: Rp. <input onfocus="clearText(this)" type="text" name="biaya4text"  value="${tupoksiKeIsi4Faktor.getBiaya4()}" style="text-align: right" onkeypress="return alertnipnull(event)" /></span></strong></td>
                </tr>
                 <input type="hidden" align="right" id="akt" name="akt" value="${namaAngka_krdtjsp}" style="text-align: right" onkeypress="return alertnipnull(event)" />
            </table>
    
<SCRIPT TYPE="text/javascript">
function refresh()
{
    location = 'Isi4FaktorServlet?nipnilai=<c:out value="${pns.getNipBaru()}"/>;idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>';
}

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

function alertnipnull2(evt)
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
                Using JavaOOP JSP HTML CSS JavaScript |
            </center>
        </div> <!-- end of footer -->
    </div>

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
    location = 'RequestServlet?page=insertTupoksiBaruBiru';
}
function next_isi4faktor()
{
    //location = 'insertTupoksi.jsp';
    location = 'RequestServlet?page=insertTupoksiBaruBiru';
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
