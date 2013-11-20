<%-- 
    Document   : indexRealisasi
    Created on : Feb 21, 2012, 7:50:24 AM
    Author     : diptaisme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Capaian Realisasi SKP</title>
        
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
/*{background-color:whitesmoke}*/
{
    background:#000 url(/SKPapplication/images/rusak.jpeg) repeat top left;
    margin:0;
    padding:0;
}
            
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
</style>

    </head>
    <body>
       <form method="post" name="form1" action="GetPnsServlet">
            <div align="center" class="style1"> 
                <p><h2>FORMULIR CAPAIAN SASARAN KERJA</h2>
                <h2>PEGAWAI NEGERI SIPIL</h2></p>
                <p align="left"><span class="style3"><strong><font size ="4">Nomor Induk Pegawai Negeri Sipil ( 18 Digit ) :</font></strong> 
                <input class="highlight" name="txtNIPBaru" type="text" size="35." maxlength="18">
                <input type="submit" class="button black bigrounded" name="param" value="CARI_PNS">
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
                <div align="right">      </div>
                <div align="right"></div>
                </div>
                            <br><br>
                <table width="1198" border="1" align="left">
                <tr>
                    <td width="30"><div align="left"><span class="style3">1</span></div></td>
                    <td width="135" align="left"><span class="style3">Nama</span></td>
                    <td width="414" align="left"> <c:out value="${UnorAts.getNamaPns()}" /> </td>
                    <td width="30"><div align="left"><span class="style3">1</span></div></td>
                    <td width="135" align="left"><span class="style3">Nama</span></td>
                    <td width="414" align="left"> <c:out value="${pns.getNamaPns()}" /> </td>
                </tr>
                <tr>
                    <td><div align="left"><span class="style3">2</span></div></td>
                    <td align="left"><span class="style3">NIP</span></td>
                    <td align="left"><c:out value="${UnorAts.getNipBaru()}" /></td>
                    <td><div align="left"><span class="style3">2</span></div></td>
                    <td align="left"><span class="style3">NIP</span></td>
                    <td align="left"><c:out value="${pns.getNipBaru()}" /></td>
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
                <table width="1564" border="1" align="left">
                <tr>
                    <td width="31" rowspan="2"><div align="center"><span class="style3">NO</span></div></td>
                    <td width="80" rowspan="2"><div align="center"><span class="style3">KODE</span></div></td>
                    <td width="383" rowspan="2"><div align="center"><span class="style3">III. KEGIATAN TUGAS POKOK JABATAN </span></div></td>
                    <td colspan="4"><div align="center"><span class="style3">TARGET</span></div></td>
                    <td colspan="4"><div align="center"><span class="style3">REALISASI</span></div></td>
                    <td width="114" rowspan="2"><div align="center"><span class="style3">PENGHITUNGAN</span> </div>          <div align="center"></div></td>
                    <td width="138" rowspan="2"><div align="center"><span class="style3">NILAI CAPAIAN SKP </span></div></td>
                </tr>
                <tr>
                    <td width="105" height="21"><div align="center"><span class="style3">KUANT/OUTPUT</span></div></td>
                    <td width="100"><div align="center"><span class="style3">KUAL/MUTU</span></div></td>
                    <td width="70"><div align="center"><span class="style3">WAKTU</span></div></td>
                    <td width="136"><div align="center"><span class="style3">BIAYA</span></div></td>
                    <td width="105"><div align="center"><span class="style3">KUANT/OUTPUT</span></div></td>
                    <td width="100"><div align="center"><span class="style3">KUAL/MUTU</span></div></td>
                    <td width="70"><div align="center"><span class="style3">WAKTU</span></div></td>
                    <td width="136"><div align="center"><span class="style3">BIAYA</span></div></td>
                </tr>
                <%--
                <c:forEach var="listTukesi" items="${tukesiServlet}" varStatus = "count">
                    <tr>
                        <td>&nbsp;</td>
                        <td><a href ="index.jsp"></a></td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                </c:forEach>
                --%>
                
                    <c:forEach var="listTukesi" items="${realkesiServlet}" varStatus ="count">
                        <tr>
                            <td>${(count.index)+1}</td>
                            <td><a href ="Isi4FaktorServlet?nipnilaiR=<c:out value="${pns.getNipBaru()}"/>&idTupoksiR=<c:out value="${listTukesi.getIdTupoksi()}"/>">${listTukesi.getIdTupoksi()}</td>
                            <td>${listTukesi.getNamaTupoksi()}</td>
                            <td>${listTukesi.getKuantitas4()}</td>
                            <td>${listTukesi.getKualitas4()}</td>
                            <td>${listTukesi.getWaktu4()}</td>
                            <td>${listTukesi.getBiaya4()}</td>
                            <td>${listTukesi.getKuantitasR()}</td>
                            <td>${listTukesi.getKualitasR()}</td>
                            <td>${listTukesi.getWaktuR()}</td>
                            <td>${listTukesi.getBiayaR()}</td>
                            <td>${listTukesi.getPenghitungan()}</td>
                            <td>${listTukesi.getNilaiCapaianSKP()}</td>
                    </tr>
                </c:forEach>
                
                <%--
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
                --%>
                </table>
                <p>&nbsp;</p><br>
                <p><input type="hidden" onclick="next()" value="OPERATOR"></p><br>
                <span style="font-family:Verdana; font-size: 12px; font-weight:bold; text-shadow:4px 4px 8px blue; letter-spacing:10px; word-spacing:20px;"> <marquee direction="left" scrollamount="5" height="20px" width="100%"> Aplikasi Sasaran Kinerja Individu PNS Badan Kepegawaian Negara </marquee></span>
                <%-- <p style="direction:rtl;text-shadow:4px 4px 8px blue;"> A p l i k a s i   S a s a r a n   K i n e r j a   I n d i v i d u   P N S   B a d a n K e p e g a w a i a n N e g a r a </p><br>--%>
                <p>&nbsp;</p>
                <div align="left" id="menu">
                    <a href="cetakIsi4FaktorServlet?nipnilai2R=<c:out value="${pns.getNipBaru()}"/>">CETAK SKP</a>
                    <%-- <a href="cetakIsi4FaktorServlet?nipnilai2=<c:out value="${pns.getNipBaru()}"/>">CETAK FORM SKP</a><br> --%>
                    <%--<a href="GetPnsServlet?txtNIPBaruT=<c:out value="${pns.getNipBaru()}"/>&idTupoksiT=<c:out value="${listTukesi.getIdTupoksi()}"/>">TARGET SKP</a>--%>
                    <a href="RequestServlet?page=cobaIndex">KELUAR</a>
                </p></div>


    <SCRIPT TYPE="text/javascript">
    <!--
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
    //-->
    </SCRIPT>

                <p>&nbsp;</p>
                <p align="justify">&nbsp;</p>
            </div>
        </form>
            <p align="justify">&nbsp;</p>
            <p align="center"><strong></strong></p>
            <p>&nbsp; </p>
    </body>
</html>
