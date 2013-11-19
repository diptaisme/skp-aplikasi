<%-- 
    Document   : TugasTambahan
    Created on : 11 Mei 12, 0:26:14
    Author     : Sony
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>SASARAN KERJA INDIVIDU</title>
<meta name="keywords" content="corporate, free web template" />
<meta name="description" content="SKI" />
<link href="styleBiru.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript">
function clearText()
{    
    var temp = document.getElementById("TmtPeriodeText").value;
    if (temp.length==8){
    var hasil = temp.substring(0, 2) + "-"+temp.substring(2, 4)+ "-"+temp.substring(4, 8);
    document.getElementById("TmtPeriodeText").value = hasil;
    }
}
function clearText2()
{    
    var temp = document.getElementById("TmtPeriodeText").value;
    if (temp.length==10){
    var hasil = temp.substring(0, 2) + temp.substring(3, 5)+temp.substring(6, 10);
    document.getElementById("TmtPeriodeText").value = hasil;
    }
}
</script>
<script language="javascript" type="text/javascript">  
var xmlHttp  
function showComboBox(value)  
{
//xmlHttp=GetXmlHttpObject()  
  xmlHttp=GetXmlHttpObject();  
    
    if (xmlHttp==null)  
    {
        alert ("Browser does not support HTTP Request")  
        return  ;
    } 
    var url="validasi.jsp"  
    url=url+"?jenis_tambahan="+value
    xmlHttp.onreadystatechange=stateChange  
    xmlHttp.open("GET",url,true)  
    xmlHttp.send(null)  
}  
function stateChange()   
{   
    if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete")  
    {   
        document.getElementById("koef_kreatifitas").innerHTML=xmlHttp.responseText   
    }   
}   
function GetXmlHttpObject()
{
    if (window.XMLHttpRequest)
    {
       return new XMLHttpRequest();
    }
    if (window.ActiveXObject)
    {
      return new ActiveXObject("Microsoft.XMLHTTP");
    }
 return null;
}
</script>  
</head>
<body>
    <div id="templatemo_site_title_bar_wrapper">
        <div id="templatemo_site_title_bar">

        </div> <!-- end of templatemo_site_title_bar -->
    </div> <!-- end of templatemo_site_title_bar_wrapper -->
       
    <div id="templatemo_content24">
         <form name="form1" method="post" action="TugasTambahanServlet">
            <table width="900" height="200" border="0">
                <tr>
                    <td colspan="4"><div align="center" class="style1"><strong><h2>FORM PENGISIAN TUGAS TAMBAHAN</h2></strong></div></td>
                </tr>
                <tr>
                    <td>NIP BARU   :</td>
                    <td>${idNip}</td>
                    <td>
                        <div align="center">
                            <input type="button" name="paramTambahan" onclick="ButtonBack()" class="button black bigrounded" value="KELUAR"/>
                           
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>NAMA PNS   :</td>
                    <td>${namaPns}</td>
                    <td>
                        <div align="center">
                            <input type="submit" class="button black bigrounded" name="Submit" value="TUGAS TAMBAHAN"/>
                        </div>
                    </td>
                </tr>
                <tr>
                   <td width="100" height="38">JENIS TUGAS TAMBAHAN   :</td>
                    <td>${JenisTambahan}</td>
                    <td>    
                            <select name="jenis_tambahan" onchange="showComboBox(this.value)">
                                <option value="-">-</option>
                                <option value="Tugas Tambahan">Tugas Tambahan</option>
                                <option value="Keterampilan">Kreatifitas</option>
                            </select>
                    </td>
                    
                    <td>  
                        <div id="koef_kreatifitas"/>                           
                    </td>
                  
                    <input  type="hidden"  name="idTambahanText" value="${idTambahan}"/>
                    <input  type="hidden"  name="idNipText" id="idNipTextId" value="${idNip}"/>
                    <input  type="hidden"  name="namaPnsText" value="${namaPns}"/>
                    <input  type="hidden"  name="JenisTambahanText" value="${JenisTambahan}"/>
                </tr>
                
                <tr>
                    <td>TGL PERIODE   :</td>
                    <td><input size="75" type="text" onfocus="clearText2()" onblur="clearText()" maxlength="8" align="right" id="TmtPeriodeText" name="TmtPeriodeText" value="${TmtPeriode}"/></td>
                     <td>
                        <div align="center">
                             <input type="submit" class="button black bigrounded" name="Submit" value="SIMPAN"/>
                         </div>
                     </td>  
                </tr>
                <%--
                <tr>
                    <td>TARGET   :</td>
                    <td><input size="75" type="text" align="right" name="nilai1Text" value="${nilai1}"></td>
                     <td>
                        <div align="center">
                             <input type="submit" class="button black bigrounded" name="Submit" value="SIMPAN">
                         </div>
                     </td>    
                </tr>
                <tr>
                    <td>REALISASI   :</td>
                    <td>${nilai2}</td>
                      <td>
                            <div align="center">
                            <input type="submit" class="button black bigrounded" name="Submit" value="BATAL">
                            </div>
                     </td>    
                </tr>
                --%>
                <tr>
                    <td>KETERANGAN </td>
                    <td><input size="75" type="text" align="right" name="namaText" value="${nama}"/></td>
                    <td>
                            <div align="center">
                            <input type="submit" class="button black bigrounded" name="Submit" value="BATAL"/>
                            </div>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp; </td>
                    <td>&nbsp; </td>
                    <td>
                        <div align="center">  
                        </div>
                    </td>
                </tr>
            </table>
        </div>
                    
        <div class="cleaner_h40"></div>	
                           
         <div id="templatemo_content_o" class="scroll1">                  
            <table width="1200" border="0" align="left">  
                   <tr>
                        <td width="20"><div align="center"><span class="style3"><strong>NO</strong></span></div></td>
                        <td width="80"><div align="center"><span class="style3"><strong>KODE</strong></span></div></td>
                        <td width="500"><div align="center"><span class="style3"><strong>JENIS</strong></span></div></td>
                        <td width="1000"><div align="center"><span class="style3"><strong>NAMA</strong></span></div></td>
                        <td width="500"><div align="center"><span class="style3"><strong>TMT PERIODE</strong></span></div></td>
                        <%--
                        <td width="500"><div align="center"><span class="style3"><strong>NILAI1</strong></span></div></td>
                        <td width="500"><div align="center"><span class="style3"><strong>NILAI2</strong></span></div></td>
                        --%>
                   </tr>
                    <tr></tr>
                    
                    <c:forEach var="listtugasTambahans" items="${tugasTambahans}" varStatus="count">
                        <tr>       
                            <td><div align="center">${(count.index)+1}</div></td>
                            <td><div align="center">${listtugasTambahans.getIdTambahan()}</div></td>
                            <td><div align="left">${listtugasTambahans.getJenisTambahan()}</div></td>
                            <td><div align="left">${listtugasTambahans.getNama()}</div></td>
                            <td><div align="left">${listtugasTambahans.getTmtPeriode()}</div></td>
                            <%--
                            <td><div align="left">${listtugasTambahans.getNilai1()}</div></td>
                            <td><div align="left">${listtugasTambahans.getNilai2()}</div></td>
                            --%>
                            <td><div align="left">${listtugasTambahans.getIdNip()}</div></td>
                       
                            <td><a href="TugasTambahanServlet?action=HapusTambahan&idTambahanHapus=<c:out value="${listtugasTambahans.getIdTambahan()}"/>&namaText=<c:out value="${namaPns}"/>">HAPUS</a></td>
                            <td><a href="TugasTambahanServlet?action=UpdateTambahan&idTambahanUpdate=<c:out value="${listtugasTambahans.getIdTambahan()}"/>&namaText=<c:out value="${namaPns}"/>">UBAH</a></td>
                        </tr>
                    </c:forEach>
             </table>               
    <div class="cleaner_h60"></div>				
    </div> <!-- end of content -->
  
            
            
            
            
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

 function myPopupInstansi() 
{
    window.open("referensiInstansiServlet?isAllInstansi=true", "myWindow", "status = 0, height = 500, width = 1000, resizable = 0, scrollbars=yes")
}

function myPopupUnor() 
{
    window.open("TabelUnor.jsp", "myWindow", "status = 0, height = 500, width = 1000, resizable = 0, scrollbars=yes")
}
</script>

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

function alertnipnull()
{
    if (txtNIPBaru == null)
    {
        window.alert("Masukkan NIP anda terlebih dahulu");
    }
}

function ButtonBack()
{
    ddtk = document.form1.idNipTextId.value;
    //location = 'TugasTambahanServlet?idNiptambahan=<c:out value="${idNip}"/>';
    location = 'TugasTambahanServlet?idNiptambahan='+ddtk;
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

