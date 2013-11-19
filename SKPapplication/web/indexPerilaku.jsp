<%-- 
    Document   : indexPerilaku
    Created on : May 23, 2012, 11:05:51 AM
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

function enableTextArea()
{    
    var rekomen = document.getElementById('rekomen');
    var textArea = document.getElementById('textarea1');
    
    if (rekomen.checked == true)
    {
        textArea.disabled=false;
    } 
    else 
    {
        textArea.disabled=true;
    }
}

function ButtonBackPerilaku()
{
    location = 'GetPnsServlet?txtNIPBaruReal=<c:out value="${nipAtasan}"/>';
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

            <%--
            <div id="search_box">
                <form action="GetPnsServlet" method="post">
                    <input type="text" value="Masukkan NIP BARU disini..." name="txtNIPBaruPerilaku" size="10" id="searchfield" title="searchfield" onfocus="clearText(this)" onblur="clearText(this)" />
                    <input type="Submit" name="Search" value="" alt="Search" id="searchbutton" title="Search" />
                    <input type="hidden" name="param" value="CARI_NIP"/>
                </form>
            </div>
            --%>
        </div> <!-- end of templatemo_site_title_bar -->
    </div> <!-- end of templatemo_site_title_bar_wrapper -->

    <%--
    <div id="">                  
        <table width="1200" border="0" align="left">  
                <tr>
                    <td width="350"><div align="center"><span class="style3"><strong>NIP PNS</strong></span></div></td>
                    <td width="200"><div align="center"><span class="style3"><strong>Orientasi Pelayanan</strong></span></div></td>
                    <td width="200"><div align="center"><span class="style3"><strong>Integritas</strong></span></div></td>
                    <td width="200"><div align="center"><span class="style3"><strong>Komitmen</strong></span></div></td>
                    <td width="200"><div align="center"><span class="style3"><strong>Disiplin</strong></span></div></td>
                    <td width="200"><div align="center"><span class="style3"><strong>Kerjasama</strong></span></div></td>
                    <td width="200"><div align="center"><span class="style3"><strong>Kepemimpinan</strong></span></div></td>
                    <td width="200"><div align="center"><span class="style3"><strong>JUMLAH</strong></span></div></td>
                    <td width="200"><div align="center"><span class="style3"><strong>RATA-RATA</strong></span></div></td>
                </tr>
                <tr></tr>
                <c:forEach var="listprilakumu" items="${prilakumu}" varStatus="count">
                    <tr>       
                        <td><div align="center">${listprilakumu.getNIPPNS()}</div></td>
                        <td><div align="left">${listprilakumu.getPelayanan()}</div></td>
                        <td><div align="left">${listprilakumu.getIntegritas()}</div></td>
                        <td><div align="left">${listprilakumu.getKomitmen()}</div></td>
                        <td><div align="left">${listprilakumu.getDisiplin()}</div></td>
                        <td><div align="left">${listprilakumu.getKerjasama()}</div></td>
                        <td><div align="left">${listprilakumu.getKepemimpinan()}</div></td>
                        <td><div align="left">${listprilakumu.getJumlah()}</div></td>
                        <td><div align="left">${listprilakumu.getRatarata()}</div></td>

                        <td><a href="isiPerilakuServlet?action=HapusPerilaku&NipPerilakuHapus=<c:out value="${listprilakumu.getNIPPNS()}"/>">HAPUS</a></td>
                        <td><a href="isiPerilakuServlet?action=UpdatePerilaku&NipPerilakuUpdate=<c:out value="${listprilakumu.getNIPPNS()}"/>">UBAH</a></td>
                    </tr>
                </c:forEach>       
            </table>               				
    </div> <!-- end of content -->
    --%>
   
       
 <form method="post" name="form1" action="isiPerilakuServlet">   
     <div id="">
         <table width="100%" border="0">
             <tr>
                 <td width="20%">STAFF PEJABAT STRUKTURAL</td>
                 <td width="40%">FORM ISIAN PENILAIAN PERILAKU PNS</td>
                 <td width="40%">REKOMENDASI ATASAN</td>
             </tr>
             <tr>
                 <td valign="top">
                     <table width="30%">
                         <tbody>
                            <c:forEach var="pnsList" items="${pnsList}" varStatus="count">
                                <tr>     
                                    <td align="center"><a href="isiPerilakuServlet?action=Lihat&NipPerilakuLihat=<c:out value="${pnsList.getNipBaru()}"/>">${(count.index)+1}</a></td>
                                    <td><div align="left"><a href="isiPerilakuServlet?action=Lihat&NipPerilakuLihat=<c:out value="${pnsList.getNipBaru()}"/>">${pnsList.getNipBaru()}</a></div></td>
                                    <td><div align="left"><a href="isiPerilakuServlet?action=Lihat&NipPerilakuLihat=<c:out value="${pnsList.getNipBaru()}"/>">${pnsList.getNamaPns()}</a></div></td>
                                </tr>
                            </c:forEach>
                         </tbody>
                     </table>
                 </td>
                 <td valign="top">
                    <table width="35%">
                        <tr>
                            <td width="119" rowspan="9">
                                <div align="center">
                                    <input type="submit" name="param" class="button black bigrounded" value="LIHAT">
                                    <input type="submit" name="param" class="button black bigrounded" value="SIMPAN">
                                    <input type="submit" name="param" class="button black bigrounded" value="BATAL">
                                    <input type="hidden" name="nipAtasan" id="nipAtasan" value="${nipAtasan}">
                                    <input type="button" name="param" onclick="ButtonBackPerilaku()" class="button black bigrounded" value="KEMBALI">
                                    <%--<input type="submit" name="param" value="CARI TUPOKSI">--%>
                                </div>
                            </td>
                            <td width="150"><strong><span class="style2">NIP PNS</span></strong></td>
                            <td width="2791">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2"></span></strong>${nip}</td>
                            <input type="hidden" name="nippns" value="${nip}"></input>
                        </tr>
                        <tr>
                            <td><strong><span class="style2">NAMA PNS </span></strong></td>
                            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2"></span></strong>${nama}</td>
                            <input type="hidden" name="namapns" value="${nama}"></input>
                        </tr>
                        <tr>
                            <td><strong><span class="style2">Periode Penilaian </span></strong></td>
                            <td><input type="text" name="Penilaian" value="${Penilaian}"></input></td>  
                        </tr>
                        <tr>
                            <td><strong><span class="style2">Orientasi Pelayanan </span></strong></td>
                            <td><input type="text" name="Pelayanan" value="${Pelayanan}"></input></td>  
                        </tr>
                        <tr>
                            <td><strong><span class="style2">Integritas</span></strong></td>
                            <td><input type="text" name="Integritas" value="${Integritas}"></input></td> 
                        </tr>
                        <tr>
                            <td><strong><span class="style2">Komitmen</span></strong></td>
                            <td><input type="text" name="Komitmen" value="${Komitmen}"></input></td> 
                        </tr>
                        <tr>
                            <td><strong><span class="style2">Disiplin</span></strong></td>
                            <td><input type="text" name="Disiplin" value="${Disiplin}"></input></td>
                        </tr>
                        <tr>
                            <td><strong><span class="style2">Kerjasama</span></strong></td>
                            <td><input type="text" name="Kerjasama" value="${Kerjasama}"></input></td> 
                        </tr>
                            <c:if test="${jenis == '1'}">
                                   <tr>
                                        <td><strong><span class="style2">Kepemimpinan</span></strong></td>
                                        <td><input type="text" name="Kepemimpinan" value="${Kepemimpinan}"> </input></td> 
                                   </tr>                                
                            </c:if>
                                     
                    </table>   
                </td>
                <td valign="top">
                    <table width="35%">
                        <tr>
                            <td><strong><span class="style2">NIP PNS</span></strong></td>
                            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2"></span></strong>${nip}</td>
                            <input type="hidden" name="nippns" value="${nip}"></input>
                        </tr>
                        <tr>
                            <td><strong><span class="style2">NAMA PNS </span></strong></td>
                            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2"></span></strong>${nama}</td>
                            <input type="hidden" name="namapns" value="${nama}"></input>
                        </tr>
                        <tr>
                            <td><strong><span class="style2">Periode Penilaian </span></strong></td>
                            <td><input type="text" id="Penilaian" name="Penilaian" value="${Penilaian}" disabled></input></td>  
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="checkbox" id="rekomen" name="rekomen" value="rekomen" onclick="enableTextArea()">Rekomendasi Atasan Langsung</input>
                            </td>
                        </tr>
                        <tr>
                            <td width="120" colspan="2"><textarea rows="9" id="textarea1" name="textarea1" cols="80" disabled></textarea></td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="submit" name="param" class="button black bigrounded" value="REKOMENDASI"></td>
                        </tr>
                    </table>  
                </td>
            </tr>
       </table>
     </div>    
</form>			

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
