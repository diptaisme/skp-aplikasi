<%-- 
    Document   : insertTupoksiBaruBiru
    Created on : Apr 27, 2012, 8:56:17 AM
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
<script type="text/javascript" language="javascript"> 
    
  
   


  
     function testHilang() {
    
    if (document.getElementById('jabatan1').checked) {
  //return document.getElementById('tombolInstansi').disabled = false;

      document.getElementById('tombolInstansi').style.visibility='visible';
       document.getElementById('tombolUnitOrganisasi').style.visibility='visible'; 
       document.getElementById('kelJab').style.visibility='hidden'; 
         document.getElementById('tombolKeloJabatan').style.visibility='hidden'; 
         document.getElementById('tombolJabatan').style.visibility='hidden'; 
         document.getElementById('jabatanfungfum').style.visibility='hidden'; 
          document.getElementById('kredit').style.visibility='hidden'; 
               document.getElementById('cariUmum').style.display = 'none';
                  document.getElementById('namaUnorText').style.visibility='visible'; 
                  document.getElementById('namaInstansiText').style.visibility='visible';  
      
    } else if (document.getElementById('jabatan2').checked){
    // return   document.getElementById('tombolInstansi').disabled = true;
         document.getElementById('tombolInstansi').style.visibility='hidden';
        document.getElementById('tombolUnitOrganisasi').style.visibility='hidden'; 
          document.getElementById('kelJab').style.visibility='visible'; 
            document.getElementById('tombolKeloJabatan').style.visibility='visible'; 
         document.getElementById('tombolJabatan').style.visibility='visible'; 
         document.getElementById('jabatanfungfum').style.visibility='visible'; 
           document.getElementById('kredit').style.visibility='visible'; 
           document.getElementById('cariUmum').style.display = 'none';
               document.getElementById('namaUnorText').style.visibility='hidden'; 
                  document.getElementById('namaInstansiText').style.visibility='hidden';  
    }
    
    
    else if (document.getElementById('jabatan4').checked){
     document.getElementById('tombolInstansi').style.visibility='hidden';
        document.getElementById('tombolUnitOrganisasi').style.visibility='hidden'; 
          document.getElementById('kelJab').style.visibility='hidden'; 
            document.getElementById('tombolKeloJabatan').style.visibility='hidden'; 
         document.getElementById('tombolJabatan').style.visibility='visible'; 
         document.getElementById('jabatanfungfum').style.visibility='visible';
         document.getElementById('kredit').style.visibility='hidden'; 
         document.getElementById('cariUmum').style.display = 'block'; 
         document.getElementById('namaUnorText').style.visibility='hidden'; 
                  document.getElementById('namaInstansiText').style.visibility='hidden';  
    }
}  
    
 
         function myFunction()
{
     var e = document.getElementById("pilih_output_Jabatan");
    var ddtk = e.options[e.selectedIndex].text;
    document.form1.JenisJabatan.value=ddtk;
    document.getElementById("JenisJabatan").value = ddtk;
}
  

window.onload=function(){
    testHilang();
}
function getSelectedRadio(payment_means){
if(document.getElementById('pay3').checked){
return document.getElementById('chq').style.visibility='visible';
return document.getElementById('chq2').style.visibility='visible';
}
else{
return document.getElementById('chq').style.visibility='hidden';
return document.getElementById('chq2').style.visibility='hidden';
}
} 


    </script> 
</head>
<body>
    <div id="templatemo_site_title_bar_wrapper">
        <div id="templatemo_site_title_bar">

        </div> <!-- end of templatemo_site_title_bar -->
    </div> <!-- end of templatemo_site_title_bar_wrapper -->
       
 <%--   <form onclick="getSelectedRadio()">
<input type="radio" name="Jabatan" value="Cash" id="pay1" />&nbsp;Struktural
<input type="radio" name="Jabatan" value="Bank Transfer" id="pay2" />&nbsp;Fungsional Tertentu
<input type="radio" name="Jabatan" value="Cheque" id="pay3" onClick="getSelectedRadio()" />&nbsp;Umum
<input type="text" name="chq" value="" id="chq" style="visibility:hidden;" />
<input type="text" name="chq2" value="" id="chq2" style="visibility:hidden;" />

</form> --%>
 
 




 
 
   
 
 
 <form name="form1" method="post" action="referensiInstansiServlet"  >
         
            <table width="1030" height="150" border="0">
                <tr>
                    <td colspan="3"><div align="center" class="style1"><strong><h2>FORM PENGISIAN TUGAS POKOK FUNGSI</h2></strong></div></td>
                </tr>
                <tr>
                  <td>
                 <%--   
         <select id="jabatan" name="jabatan" style="width: 212px;" >
<option value="1" >Struktural</option>
<option value="2">Fungsional Tertentu</option>
<option value="3" >Fungsional Umum</option>

 </select>--%>
                 
                 <input type="radio" name="jabatan"   value="1" id="jabatan1" onclick="testHilang()" <c:if test="${jabatan == '1'}">checked</c:if> />&nbsp;Struktural
                 <input type="radio" name="jabatan" value="2" id="jabatan2" onclick="testHilang()" <c:if test="${jabatan == '2'}">checked</c:if> />&nbsp;Fungsional Tertentu
                <input type="radio" name="jabatan" value="4" id="jabatan4" onclick="testHilang()" <c:if test="${jabatan == '4'}">checked</c:if> />&nbsp;Fungsional Umum
                </td>
                <td> <div align="center">  
                        </div></td>
               
               </tr>
                
                <tr>
                    <td width="450" height="38">INSTANSI   :</td>
                    <%-- <td width="275"><input type="text" name="textfield" size="75" value=""></td> 
                    <td><input size="75" type="text" align="right" name="namaInstansiText" value="${instansie.getNamaInstansi()}"></td>
                        <input  type="hidden"  name="idInstansiText" value="${instansie.getIdInstansi()}">--%>
                            
                    <td><c:out value="${namaInstansi}" />
                        <input size="75" type="hidden"  style="visibility:hidden;" align="right"  id="namaInstansiText" name="namaInstansiText" value="${namaInstansi}"/></td>
                        <input  type="hidden"  name="idInstansiText" value="${kodeInstansi}"/>
                    
                    <%--<td width="275"><c:out value="${instansie.getNamaInstansi()}" /></td>--%>
                    <td width="75">
                        <div align="center">
                            <input type="submit" name="Submit" style="visibility:hidden;" class="button black bigrounded" id="tombolInstansi" value="CARI INSTANSI"/>
                            <%-- <input type="submit" name="Submit" value="CARI" onclick="myPopupInstansi()"> --%>
                            <%--<a href="referensiInstansiServlet?asd=asd">INSTANSI</a>--%>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>UNIT ORGANISASI   :</td>
                    <%--<td width="275"><c:out value="${unorie.getNamaUnor()}" /></td>
                    <td><input size="75" type="text" align="right" name="namaUnorText" value="${unorie.getNamaUnor()}"></td>
                    <input  type="hidden"  name="idUnorText" value="${unorie.getIdUnor()}">--%> 
                    <td><c:out value="${namaUnor}" />
                        <input size="75" type="hidden" align="right" style="visibility:hidden;" id="namaUnorText" name="namaUnorText" value="${namaUnor}"/></td>
                    <input  type="hidden"  name="idUnorText" value="${kodeUnor}"/> 
                    <%--<input type="text" align="right" name="namaUnorText" value="${unorie.getNamaUnor()}" style="text-align: right">--%>
                    <td width="75">
                        <div align="center">
                           <%--<input type="submit" name="Submit" value="CARI UNOR" onclick="myPopupUnor()">--%>
                          
                           <input type="submit" name="Submit" style="visibility: hidden;" class="button black bigrounded" id="tombolUnitOrganisasi" value="CARI UNOR"/>
                        </div>
                    </td>
                </tr>
                          
                     <tr>
                    <td> KELOMPOK JABATAN   :</td> 
                    <td><input type="submit" name="Submit"  style="visibility:hidden;" value="CARI KELOMPOK" id="tombolKeloJabatan"/>
                        <select id ="kelJab" name ="kelJab"style="visibility:hidden;" >
                   <c:forEach var="kelJab" items="${kelJab}" varStatus="count">
                                        <option value=${kelJab.getId()} >${kelJab.getNama()}</option>
                                    </c:forEach>
                                        </select>
                                        </td>
                    <td>
                        
                    </td>
                </tr>          
                     <tr>
                    <td> JABATAN   :</td>   
                    <td> <input type="text" name="cariUmum"  size="25" id="cariUmum"/>
                       <input type="submit" name="Submit" style="visibility:hidden;"  value="CARI JABATAN" id="tombolJabatan"/>
                       <select id ="jabatanfungfum" name ="jabatanfungfum" style="visibility:hidden;" >
                   <c:forEach var="jabatanfungfum" items="${jabatanfungfum}" varStatus="count">
                                        <option value=${jabatanfungfum.getId()} >${jabatanfungfum.getNama()}</option>
                                    </c:forEach>
                                        </select>
                                        </td>
                   
                    <td>
                        
                    <input type="submit" class="button black bigrounded" name="Submit" value="LIHAT TUPOKSI"/>
                   
                    </td>
                </tr>          
                <tr>
                    <td>TUGAS POKOK DAN FUNGSI </td>
                    <td><textarea id="textarea1" name="textarea1" cols="57" rows="6"></textarea></td>
                    <td>
                         <div align="center">
                            
                            <%--<input type="submit" class="button black bigrounded" name="Submit" value="SIMPAN" onclick="return validasi();"/>--%>
                            <input type="submit" class="button black bigrounded" name="Submit" value="SIMPAN" onclick="return validasi()"/>
                            <input type="submit" class="button black bigrounded" name="Submit" value="BATAL"/>
                            <input type="submit" class="button black bigrounded" name="Submit" value="KELUAR"/>
                        </div>
                    </td>
                </tr>
                           
                
                           
                 <tr>
                    <td>NILAI ANGKA KREDIT (AK)   :</td>
                    <td><input  type="text" align="right"  name="angka_krdtText" style="visibility:hidden;" id="kredit" onkeypress="return alertnipnull1(event)"/></td>
                    <td>
                        <div align="center">  
                        </div>
                    </td>
                </tr>
                             <tr>
                    <td> </td>
                    <td></td>
                    <td>
                      
                    </td>
                </tr>

            </table>
                            
          <div id="templatemo_content2" class="scroll">                 
              <table width="100%" border="1" align="left"> 
                   <tr>
                        <td width="20"><div align="center"><span class="style3"><strong>NO</strong></span></div></td>
                        <td width="80"><div align="center"><span class="style3"><strong>KODE</strong></span></div></td>
                        <td width="100%"><div align="center"><span class="style3"><strong>NAMA TUPOKSI</strong></span></div></td>
                        <c:if test="${jabatan == '2'}">
                        <td width="50"><div align="center"><span class="style3"><strong>NILAI AK</strong></span></div></td>
                   </c:if>
                        </tr>
                    <tr></tr>
                    
                    <c:forEach var="listTupoksi" items="${Tupoksi}" varStatus="count">
                        <tr>
                            <td><div align="center">${(count.index)+1}</div></td>
                            <td><div align="center">${listTupoksi.getIdTupoksi()}</div></td>
                            <td><div align="left">${listTupoksi.getNamaTupoksi()}</div></td>
                             <td><div align="left">${listTupoksi.getangka_krdt()}</div></td>
                            <%--<td><a href ="referensiInstansiServlet?idTupoksihit=<c:out value="${listTupoksi.getIdTupoksi()}"/>">hapus</td>
                            <!--<input  type="text" id='<c:out value="${listTupoksi.getIdTupoksi()}"/>' value="<c:out value="${listTupoksi.getIdTupoksi()}"/>">-->
                            <!--<td><input type="button" name="btnHapus" value="HAPUS" onclick=""></input></td>  -->--%>                        
                            <td><a href="referensiInstansiServlet?action=HapusTupoksi&idTupoksiHapus=<c:out value="${listTupoksi.getIdTupoksi()}"/>&InstansiHapus=<c:out value="${kodeInstansi}"/>&UnorHapus=<c:out value="${kodeUnor}"/>&JabHapus=<c:out value="${listTupoksi.getjabatanId()}"/>"><img src="images/hapus2.png"></img></a></td>
                            <td><a href="referensiInstansiServlet?action=UpdateTupoksi&idTupoksiUpdate=<c:out value="${listTupoksi.getIdTupoksi()}"/>"><img src="images/ubah2.png"></img></a></td>
                            <%--<td><input type="submit" name="Submit" value="UBAH"></td>--%>
                        </tr>
                    </c:forEach>
             </table> 
          </div>
                     
       
                           
        
  </form>
  
            
            
            
            
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

 function alertnipnull1(evt)
    {
        evt = (evt) ? evt : window.event
        var charCode = (evt.which) ? evt.which : evt.keyCode
        if (charCode > 31 && (charCode < 44  || charCode > 57)) 
        {
            status = "This field accepts numbers only."
            return false
        }
        status = ""
        return true
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
