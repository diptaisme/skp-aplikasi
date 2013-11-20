<%-- 
    Document   : SKIBiru
    Created on : Apr 18, 2012, 9:58:24 AM
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
function clearText(field)
{
    if (field.defaultValue == field.value) field.value = '';
    else if (field.value == '') field.value = field.defaultValue;
}
</script>
</head>
<body>
<div id="templatemo_site_title_bar_wrapper">
    <div id="templatemo_site_title_bar">
        <div id="templatemo_menu">
            <ul>
                <li><a href="RequestServlet?page=SKIBiru" class="current" title="SKI"><span></span>SKI</a></li>
                <li><a href="RequestServlet?page=indexBaruBiru2" target="_parent" title="Target Sasaran SKI"><span></span>Target</a></li>
                <li><a href="RequestServlet?page=indexRealisasiBaruBiru" target="_parent" title="Realisasi Capaian SKI"><span></span>Realisasi</a></li>
                <li><a href="RequestServlet?page=indexloginBaru" target="_parent" title="Keluar"><span></span>Keluar</a></li>
            </ul>    	
        </div> <!-- end of templatemo_menu -->
     <div class="cleaner"></div>
     </div> <!-- end of templatemo_site_title_bar -->
</div> <!-- end of templatemo_site_title_bar_wrapper -->

<div id="templatemo_content">
    <p>
        <h2>Paradigma Penilaian Kinerja Pegawai Negeri Sipil</h2>
        <h3>Kebijakan Penilaian</h3>
        Kebijakan penilaian prestasi kerja dilaksanakan untuk mewujudkan Pegawai Negeri Sipil (PNS) yang professional, bertanggungjawab, jujur dan adil melalui pembinaan yang dilaksanakan berdasarkan system prestasi kerja dan system karier yang dititikberatkan pada sistem prestasi kerja, serta untuk menjamin objektivitas dalam mempertimbangkan pengangkatan dalam jabatan dan kenaikan pangkat.
        <h3>Paradigma Penilaian</h3>
        Penilaian prestasi kerja Pegawai Negeri Sipil adalah suatu proses penilaian secara sistematis yang dilakukan oleh Pejabat Penilai terhadap Sasaran Kerja Individu (SKI) dan perilaku kerja PNS.
        <h3>Sasaran Kerja Individu (SKI)</h3>
        Sasaran Kerja Individu adalah rencana kerja dan target yang akan dicapai oleh seorang Pegawai Negeri Sipil, yang disusun dam disepakati bersama antara Pejabat Penilai dengan Pegawai Negeri Sipil yang dinilai, meliptui : Kegiatan tugas pokok jabatan, Bobot kegiatan, Sasaran kerja yang akan dicapai, Target (aspek kuantitas, kualitas, waktu dan/atau biaya).
        <a href="http://www.bkn.go.id/in/profil/unit-kerja/organisasi-deputi-kinerja-dan-perundangan/direktorat-rekrutmen-dan-kinerja-pegawai/penilaian-kinerja.html">Sumber : Badan Kepegawaian Negara</a>
        <h3>Aspek Penilaian</h3>
        Kuantitas adalah ukuran jumlah atau banyaknya hasil kerja yang dicapai sesuai dengan norma, standar, prosedur, dan kriteria yang berlaku.
        Kualitas adalah ukuran mutu setiap hasil kerja yang dicapai sesuai dengan norma, standar, prosedur, dan kriteria yang berlaku.
        Waktu adalah ukuran lamanya proses setiap hasil kerja yang dicapai sesuai dengan norma, standar, prosedur, dan kriteria yang berlaku.
        Biaya adalah ukuran besar kecilnya anggaran yang digunakan setiap hasil kegiatan sesuai dengan norma, standar, prosedur, dan kriteria yang berlaku.  
    </p>
    <div class="cleaner_h60"></div>
</div> <!-- end of content -->

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
                    <p>Dalam rangka akselerasi reformasi birokrasi. BKN menetapkan quick wins BKN yaitu SAPK, CAT, SKI, Assesment Center.</p>
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

function alertnipnull()
{
    if (txtNIPBaru == null)
    {
        window.alert("Masukkan NIP anda terlebih dahulu");
    }
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
</style>

</body>
</html>