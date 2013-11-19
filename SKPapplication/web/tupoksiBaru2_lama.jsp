<%-- 
    Document   : tupoksiBaru
    Created on : Apr 20, 2012, 1:34:05 PM
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
    <div id="templatemo_site_title_bar_wrapper">
        <div id="templatemo_site_title_bar">
            <div id="templatemo_menu">
                <ul>
                    <li><a href="GetPnsServlet?txtNIPBaruB=<c:out value="${pns.getNipBaru()}"/>" target="_parent" title="Target Sasaran SKI"><span></span>Target</a></li>
                    <li><a href="indexloginBaru.jsp" target="_parent" title="Keluar"><span></span>Keluar</a></li>
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

            <form name="form1" method="post" action="tupoksiServlet2">
                
                <table width="600" border="0" align="left">
                 <tr>
                    <td width="92" rowspan="4"><p align="center" class="style1">&nbsp;</p>      </td>
                    <td colspan="2"><div align="center"><span class="style1"><strong>DAFTAR TUPOKSI</strong></span></div></td>
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
                            <td></td>
                            <td></td>
                           
                             <c:if test="${jabatan == '2'}">
                            <td>
                                <select id ="jabfung" name ="jabfung" >
                                    <c:forEach var="lisJabfung" items="${lisJabfung}" varStatus="count">
                                        <option value=${lisJabfung.getId()} >  ${lisJabfung.getNama()}</option>
                                    </c:forEach>
                                </select>                                
                            </td>
                           
                            <td>
                                <input type="hidden" id="txtNIPBaru" name="txtNIPBaru" value="<c:out value="${pns.getNipBaru()}"/>"/> 
                                <input type="submit" value="cariJabatan" name="submitCari"/>
                              
                            </td>
                                </c:if>
                            
                          
                         
                            
                            
                                          </tr>
                
            </table>
               
              <input  type="hidden"  name="idnipText" value="${pns.getNipBaru()}"/>
              <div id="templatemo_content4" class="scroll2">
            <table width="1000" border="0">
               
                <tr>
                    <td><div align="center"><strong>NO </strong></div></td>
                    <td><div align="center"><strong>KODE </strong></div></td>
                    <td><div align="center"><strong>NAMA TUGAS DAN FUNGSI </strong></div></td>
                    <c:if test="${jabatan == '2'}">
                    <td><div align="center"><strong>ANGKA KREDIT </strong></div></td>
                    </c:if>
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
                        <td><a href="isiTupoksiServlet?isCetak=true&nipnilai=<c:out value="${pns.getNipBaru()}"/>&kelompokTugas=<c:out value="${namaKelompok}"/>&idTupoksi=<c:out value="${listUnosi.getIdTupoksi()}"/>"><div align="center">${listUnosi.getIdTupoksi()}</div></a></td>
                        <td>${listUnosi.getNamaTupoksi()}</td>
                        <c:if test="${jabatan == '2'}">   
                            <td><center> ${listUnosi.getangka_krdt()} </center></td>
                        </c:if>
                    </tr>
                </c:forEach> 
                   
                        

            </table>
                 </div>
                </form>
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
    
        <div class="cleaner_h60"></div>				
     <!-- end of content -->


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
function function1(jabfung) {ab
    var j = (jabfung.options[jabfung.selectedIndex].value);
   
    alert("SelectedIndex value = "+j); 
function ButtonBack()
{
    location = 'insertTupoksiBaruBiru.jsp';
}

function ButtonExit()
{
    location = 'indexloginBaru.jsp';
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
    window.open( "tupoksiServlet2?txtNIPBaru=<c:out value="${pns.getNipBaru()}"/>", "myWindow", "status = 0, height = 500, width = 1000, resizable = 0, scrollbars=yes" )
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
