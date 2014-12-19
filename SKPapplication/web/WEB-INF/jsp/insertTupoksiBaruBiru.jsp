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
        <script src="/SKPapplication/js/jquery-1.7.1.min.js"></script>
        <link href="/SKPapplication/css/styleBiru.css" rel="stylesheet" type="text/css" />
        <link href="/SKPapplication/css/style2.css" rel="stylesheet" type="text/css" />
        <link href="/SKPapplication/css/StylecssinsertTupoksiBaruBiru.css" rel="stylesheet" type="text/css" />
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
                    document.getElementById('tombolJabatanfum').style.visibility='hidden'; 
                   //  document.getElementById('jabatanfungfum').style.visibility='hidden'; 
                   //   document.getElementById('jabatanfungfum1').style.visibility='hidden'; 
                    document.getElementById('kredit').style.visibility='hidden'; 
                    document.getElementById('cariUmum').style.display = 'none';
                    document.getElementById('cariUmum').style.visibility='hidden';
                    document.getElementById('namaUnorText').style.visibility='visible'; 
                    document.getElementById('namaInstansiText').style.visibility='visible';  
                    document.getElementById('navigasiPilihan_').value='3';
                    document.form1.navigasiPilihan_.value='3';
      
                } else if (document.getElementById('jabatan2').checked){
                    // return   document.getElementById('tombolInstansi').disabled = true;
                    document.getElementById('tombolInstansi').style.visibility='hidden';
                    document.getElementById('tombolUnitOrganisasi').style.visibility='hidden'; 
                   document.getElementById('kelJab').style.visibility='visible'; 
                    document.getElementById('tombolKeloJabatan').style.visibility='visible'; 
                    document.getElementById('tombolJabatan').style.visibility='visible'; 
                    document.getElementById('tombolJabatanfum').style.visibility='hidden'; 
                  //  document.getElementById('jabatanfungfum').style.visibility='visible'; 
                  //  document.getElementById('jabatanfungfum1').style.visibility='visible'; 
                    document.getElementById('kredit').style.visibility='visible'; 
                    document.getElementById('cariUmum').style.display = 'none';
                    document.getElementById('namaUnorText').style.visibility='hidden'; 
                    document.getElementById('namaInstansiText').style.visibility='hidden';  
                    document.getElementById('navigasiPilihan_').value='2';
                    document.form1.navigasiPilihan_.value='2';
                   
           
                }
    
    
                else if (document.getElementById('jabatan4').checked){
                    document.getElementById('tombolInstansi').style.visibility='hidden';
                    document.getElementById('tombolUnitOrganisasi').style.visibility='hidden'; 
                     document.getElementById('kelJab').style.visibility='hidden'; 
                    document.getElementById('tombolKeloJabatan').style.visibility='hidden'; 
                    document.getElementById('tombolJabatan').style.visibility='hidden'; 
                    document.getElementById('tombolJabatanfum').style.visibility='visible'; 
                    // document.getElementById('jabatanfungfum').style.visibility='visible';
                   // document.getElementById('jabatanfungfum').style.visibility='visible'; 
                   // document.getElementById('jabatanfungfum1').style.visibility='visible'; 
                    document.getElementById('kredit').style.visibility='hidden'; 
                    document.getElementById('cariUmum').style.display = 'block'; 
                    document.getElementById('namaUnorText').style.visibility='hidden'; 
                    document.getElementById('namaInstansiText').style.visibility='hidden';  
                    document.getElementById('navigasiPilihan_').value='2';
                    document.form1.navigasiPilihan_.value='2';
          
           
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

        <style type="text/css"> 
            #headerLokal {
                padding: 0px;
                width: 1200px;
                left : -40px;
                position: relative;
                height: 80px;
                
            }
            #leftside {

                position :  absolute;
                top : 55px;
                left : 30px;
                width : 156px;
                height : 501px;
            }

            #contentdalam {
                position :  absolute;
                top : 65px;
                left : 175px;
                width : 1200px;
                height : 501px;
                overflow: auto;
            }

            #met {
                position: relative;
                width: 990px;
                height: 40px;
                background: #9999CC;

                font-family: arial;
                padding-left: 1px;
                top :13px;
                text-decoration: none;



            }
            #met ul li a {
                display: block;
                text-decoration: none;
                color: #FFF;
                padding: 10px;
                float: left;
                width: 100px;
                font-size: 18px

            }

            #met ul li a:hover {
                background-color: #CCCCFF;
                color: #FF0000;
            }

        </style>
    </head>
    <body>
        <div id="wrapper">

            <form name="form1" method="post" action="referensiInstansiServlet"  >
                <div id="headerLokal">
                    <%@ include file="SlindronHeader.jsp" %>
                </div>   
                <div id="leftside">
                    <%@ include file="navigasiPro.jsp" %>
                </div>   
                <div id="contentdalam">
                    <div id="met">
                        <ul>

                            <li> <a href="referensiInstansiServlet?nipPengguna=<c:out value="${sessionScope.NipPnsSession}"/>">Kembali</a> 
                            </li>
                        </ul>
                    </div>
                    <input  type="hidden"  style="visibility:hidden;" align="right"  id="namaInstansiText" name="namaInstansiText" value="${namaInstansi}"/>
                    <input  type="hidden"  name="idInstansiText" id="idInstansiText" value="${kodeInstansi}"/>

                    <table width="900" height="300" border="1" style="border-collapse: collapse;margin-top: 25px;margin-left: 25px;">
                        <tr>
                            <td colspan="5" align="center" class="table1"><div><h2 style="color: #000">ENTRY DATA KEGIATAN TUGAS JABATAN</h2></div></td>
                        </tr>
                        <tr>
                            <td colspan="5" align="center" class="table1">
                                <input type="radio" name="jabatan" value="1" id="jabatan1" onclick="testHilang()" <c:if test="${jabatan == '1'}">checked</c:if> />&nbsp;Struktural
                                <input type="radio" name="jabatan" value="2" id="jabatan2" onclick="testHilang()" <c:if test="${jabatan == '2'}">checked</c:if> />&nbsp;Fungsional Tertentu
                                <input type="radio" name="jabatan" value="4" id="jabatan4" onclick="testHilang()" <c:if test="${jabatan == '4'}">checked</c:if> />&nbsp;Fungsional Umum
                            </td>
                        </tr> 
                        <tr style="width: 900px">
                            <td style="width: 150px" align="center">INSTANSI </td>
                            <td style="width: 20px" align="center">:</td>
                            <td colspan="2" ><c:out value="${namaInstansi}" /></td>
                            <%--<td width="275"><c:out value="${instansie.getNamaInstansi()}" /></td>--%>
                            <td>
                                <div align="center">
                                    <%--<input type="submit" name="Submit" style="visibility:hidden;" class="button black bigrounded" id="tombolInstansi" value="CARI INSTANSI"/> --%>
                                    <input type="button" name="Submit"  onclick="popup_showws()" style="visibility:hidden;"   class="button black bigrounded" value="CARI iNSTANSI" id="tombolInstansi"   />


                                    <%-- <input type="submit" name="Submit" value="CARI" onclick="myPopupInstansi()"> --%>
                                    <%--<a href="referensiInstansiServlet?asd=asd">INSTANSI</a>--%>
                                </div>
                            </td>
                               
                        </tr>
                        <tr style="width: 900px">
                            <td style="width: 150px" align="center">UNIT ORGANISASI   </td>
                            <td style="width: 20px" align="center">:</td>
                            <td colspan="2"><c:out value="${namaUnor}" /></td>
                            <input  type="hidden" align="right" style="visibility:hidden;" id="namaUnorText" name="namaUnorText" value="${namaUnor}"/>
                            <input  type="hidden"  name="idUnorText" value="${kodeUnor}"/> 
                            <%--<input type="text" align="right" name="namaUnorText" value="${unorie.getNamaUnor()}" style="text-align: right">--%>
                            <td >
                                <div align="center">
                                    <%--<input type="submit" name="Submit" value="CARI UNOR" onclick="myPopupUnor()">--%>

                                    <%--<input type="submit" name="Submit" style="visibility: hidden;" class="button black bigrounded" id="tombolUnitOrganisasi" value="CARI UNOR"/>--%>
                                    <input  type="button" name="Submit" style="visibility: hidden;" class="button black bigrounded" value="CARI UNOR" onclick="popup_showwsUnitOr()"    id="tombolUnitOrganisasi" />
                                </div>
                            </td>
                                  
                        </tr>

                        <tr>
                            <td style="width: 150px" align="center"> KELOMPOK JABATAN   </td> 
                            <td style="width: 20px" align="center">:</td>
                            <td style="width: 150px" height="50px" align="center"><input type="submit" name="Submit"  style="visibility:hidden;background-color: #FF9900" value="CARI KELOMPOK" id="tombolKeloJabatan"/>
                                
                            </td>
                            <td colspan="2">
                                <select id ="kelJab" name ="kelJab" >
                                    <c:forEach var="kelJab" items="${kelJab}" varStatus="count">
                                        <option value=${kelJab.getId()} >${kelJab.getNama()}</option>
                                    </c:forEach>
                                </select></td>
                            
                           
                        </tr>
                        <c:set var="navigasi_pilihan" value="${navigasiPilihanjns}" /> 
                        <input  type="hidden"  name="navigasiPilihan_" id="navigasiPilihan_"  onchange="validasijns()"/>
                        <tr style="width:900px">
                                    <td style="width: 150px" align="center"> JABATAN  </td> 
                                    <td style="width: 20px" align="center">:</td>
                                    <td align="center"> 
                                        <input type="hidden" name="cariUmum"  size="10" id="cariUmum" />
                                        <input type="button" name="Submit" onclick="showloadBox2fum()"  style="visibility:hidden;background-color: #FF9900;width: 100px"  value="CARI JABFUM" id="tombolJabatanfum" />      
                                        <input type="button" name="Submit" onclick="showloadBox2()"  style="visibility:hidden;background-color: #FF9900"  value="CARI JABATAN" id="tombolJabatan" /> 
                                    </td>                    
                                    <td colspan="2">
                                <div style="width: 200px;overflow: auto">

                                    <%-- <c:if test="${navigasi_pilihan=='2'}">
                                         <div  id ="jabatanfungfum1" name ="jabatanfungfum1"> </div>  
                                     </c:if>

                                    <c:if test="${navigasi_pilihan=='3' }">
                                        <select id ="jabatanfungfum" name ="jabatanfungfum">
                                            <c:forEach var="jabatanfungfum" items="${jabatanfungfum}" varStatus="count">
                                                <option value=${jabatanfungfum.getId()} >${jabatanfungfum.getNama()}</option>
                                            </c:forEach>

                                        </select>
                                    </c:if>   --%>

                                    <c:choose>
                                        <c:when test="${navigasi_pilihan=='3'}">
                                            <select id ="jabatanfungfum" name ="jabatanfungfum">
                                                <c:forEach var="jabatanfungfum" items="${jabatanfungfum}" varStatus="count">
                                                    <option value=${jabatanfungfum.getId()} >${jabatanfungfum.getNama()}</option>
                                                </c:forEach>
                                            </select>
                                        </c:when>
                                        <c:otherwise>
                                            <div  id ="jabatanfungfum1" name ="jabatanfungfum1" > </div>  

                                        </c:otherwise>  

                                    </c:choose>


                                </div>
                            </td>  
                        </tr>          
                        <tr style="width: 900px" >
                            <td style="width: 150px" align="center">TUGAS KEGIATAN JABATAN</td>
                            <td style="width: 20px" align="center">:</td>
                            <td colspan="2"><textarea id="textarea1" name="textarea1" cols="40" rows="6"></textarea></td>
                            
                                    
                        </tr>

                        <tr style="width: 900px">
                            <td style="width: 150px" align="center">NILAI ANGKA KREDIT (AK)   </td>
                            <td style="width: 20px" align="center">:</td>
                            <td colspan="3"><input  type="text" align="right"  name="angka_krdtText" style="visibility:hidden;" id="kredit" onkeypress="return alertnipnull1(event)"/></td>
                            
                        </tr>

                    </table>
                    
                <table style="margin-left: 190px;" >
                        <tr>
                           <td>
                                    <%--<input type="submit" class="button black bigrounded" name="Submit" value="SIMPAN" onclick="return validasi();"/>--%>
                                    <input style="width: 100px;font-size: x-small;" type="submit" class="button black bigrounded" name="Submit" value="LIHAT TUPOKSI" />
                                    <input style="width: 100px;font-size: x-small;" type="submit" class="button black bigrounded" name="Submit" value="SIMPAN" onclick="return validasi()"/>
                                    <input style="width: 100px;font-size: x-small;" type="submit" class="button black bigrounded" name="Submit" value="BATAL"/>
                                    <input style="width: 101px;font-size: x-small;" type="submit" class="button black bigrounded" name="Submit" value="KELUAR"/>
                                   
                            </td> 
                        </tr>                    
                    </table>

                    <div id="templatemo_content2" class="scroll">                 
                        <table  width="900"border="1" align="left"  style="border-collapse: collapse;margin-top: 15px;margin-left: 25px;"> 
                            <tr>
                                <td width="5" style="font-size: small;background-color: #9999ff"><div align="center">NO</div></td>
                                <td width="10" style="font-size: small;background-color: #9999ff"><div align="center">KODE</div></td>
                                <td width="300" style="font-size: small;background-color: #9999ff"><div align="center">NAMA TUPOKSI</div></td>
                                <c:if test="${jabatan == '2'}">
                                    <td width="5" style="font-size: small;background-color: #9999ff"><div align="center"><span class="style3"><strong>NILAI AK</strong></span></div></td>
                                </c:if>
                                <c:if test="${jabatan != '2'}">
                                    <td width="5" style="font-size: small;background-color: #9999ff"><div align="center"><span class="style3"><strong>NILAI AK</strong></span></div></td>
                                </c:if>
                                <td width="8" style="font-size: small;background-color: #9999ff"><div align="center"> Hapus</div></td> 
                                <td width="8" style="font-size: small;background-color: #9999ff"><div align="center"> Edit</div></td>
                            </tr>
                            <tr></tr>

                            <c:forEach var="listTupoksi" items="${Tupoksi}" varStatus="count">
                                <c:choose>
                                    <c:when test="${count.index % 2 == 0}">
                                        <tr bgcolor="#b9c9fe">

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
                                    </c:when>
                                    <c:otherwise>
                                        <tr bgcolor="#e8edff">
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
                                    </c:otherwise>

                                </c:choose>
                            </c:forEach>
                        </table> 
                    </div>
                </div>
            </form>

        </div>          
        <SCRIPT TYPE="text/javascript">
            function validasijns (){
                var ddtk =document.getElementById("navigasiPilihan_");
               
                document.getElementById("navigasiPilihan_").value = ddtk;
                alert(ddtk);
            }; 
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
                window.open("RequestServlet?page=TabelUnor", "myWindow", "status = 0, height = 500, width = 1000, resizable = 0, scrollbars=yes")
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
            
            function showloadBox2fum()  
            {
                //xmlHttp=GetXmlHttpObject()  
                xmlHttp=GetXmlHttpObject();  
    
                if (xmlHttp==null)  
                {
                    alert ("Browser does not support HTTP Request")  
                    return  ;
                } 
           
                //var keljabtext = vbiaya4text.options[vbiaya4text.selectedIndex].text;(i
                var jabatan2 ="4";
              
                jabatan2=  document.getElementById('jabatan4').value;
            
                var carinama=document.getElementById("cariUmum").value;
                var nav='3';
              
                var url="referensiInstansiServlet?carijabatan=cari_jabatan&cari_nama="+ carinama +"&jabatan2="+jabatan2+"&nav="+nav ;
                xmlHttp.onreadystatechange=stateChange2  
                xmlHttp.open("GET",url,true)  
                xmlHttp.send(null) 
              
            }
            
            
            function showloadBox2()  
            {
                //xmlHttp=GetXmlHttpObject()  
                xmlHttp=GetXmlHttpObject();  
    
                if (xmlHttp==null)  
                {
                    alert ("Browser does not support HTTP Request")  
                    return  ;
                } 
           
                //var keljabtext = vbiaya4text.options[vbiaya4text.selectedIndex].text;(i
                var jabatan2 ="4";
                // /for// ( i=0;1 < document.forms[0].jabatan.length;i++){
                //    if(document.forms[0].jabatan[i].checked){
                //      jabatan2=  document.forms[0].jabatan[i].value;
                //     }
                // }
                var vbiaya4text =document.getElementById("kelJab");
                //  var vbiaya4text=document.form1.keljab.value;
                var keljabtext = vbiaya4text.options[vbiaya4text.selectedIndex].value;
                
                
                if (document.getElementById('jabatan2').checked){
                    jabatan2=  document.getElementById('jabatan2').value;
                    //vbiaya4text =document.getElementById("keljab").value;
                    // keljabtext = vbiaya4text.options[vbiaya4text.selectedIndex].text;
                }
                if (document.getElementById('jabatan4').checked){
                    jabatan2=  document.getElementById('jabatan4').value;
                }
       
                var carinama=document.getElementById("cariUmum").value;
                var nav='3';
                
                if(nav=='3'){
                    // var url="referensiInstansiServlet?carijabatan=cari_jabatan&cari_nama="+ carinama +"&jabatan2="+jabatan2+"&kelJab=" + keljabtext +"&nav="+nav  ;
                    // url.href=url.href; 
                    
                    var url="referensiInstansiServlet?carijabatan=cari_jabatan&cari_nama="+ carinama +"&jabatan2="+jabatan2+"&kelJab=" + keljabtext +"&nav="+nav ;
                    xmlHttp.onreadystatechange=stateChange2  
                    xmlHttp.open("GET",url,true)  
                    xmlHttp.send(null) 
                }else{
                 
                    var url="referensiInstansiServlet?carijabatan=cari_jabatan&cari_nama="+ carinama +"&jabatan2="+jabatan2+"&kelJab=" + keljabtext +"&nav="+nav ;
                    xmlHttp.onreadystatechange=stateChange2  
                    xmlHttp.open("GET",url,true)  
                    xmlHttp.send(null)  
                }
                //   var url="referensiInstansiServlet&carijabatan=cari_jabatan?cari_nama="+carinama + "?kelJab=" +keljabtext +"?jabatan2="+jabatan2 +"?jabatan4="+jabatan4;
               
            }
            
            function stateChange2()   
            {   
                if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete")  
                {   
                    document.getElementById("jabatanfungfum1").innerHTML=xmlHttp.responseText   
                }   
            } 
            
            function popup_showws() {
                jabatan2=  document.getElementById('namaInstansiText').value;
                var w = 700;
                var h = 400;
                var winl = (screen.width-w)/2;
                var wint = (screen.height-h)/2;
                if (winl < 0) winl = 0;
                if (wint < 0) wint = 0;
                var page = "referensiInstansiServlet?pagepop=popshow&namaInstansiText="+jabatan2;
              
                windowprops = "height="+h+",width="+w+",top="+ wint +",left="+ winl +",location=no,"
                    + "scrollbars=yes,menubars=no,toolbars=no,resizable=no,status=yes";
                window.open(page, "myWindow", windowprops);
            }
            function popup_showwsUnitOr() {
                jabatan2=  document.getElementById('namaUnorText').value;
                unitOrg= document.getElementById('idInstansiText').value;
                idInstansi=document.getElementById('idInstansiText').value;
                var w = 700;
                var h = 400;
                var winl = (screen.width-w)/2;
                var wint = (screen.height-h)/2;
                if (winl < 0) winl = 0;
                if (wint < 0) wint = 0;
                var page = "referensiInstansiServlet?pagepopUnor=popshow&namaUnorText="+jabatan2+"&idInstansiText="+unitOrg+"&idInstansi="+idInstansi;
              
                windowprops = "height="+h+",width="+w+",top="+ wint +",left="+ winl +",location=no,"
                    + "scrollbars=yes,menubars=no,toolbars=no,resizable=no,status=yes";
                window.open(page, "myWindow", windowprops);
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
            .button_03{
                width: 65px;
                background: url(/SKPapplication/images/cari.png) 0 0 no-repeat;
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

                background: #D9AD00;

            }
            .black:hover {
                background: #E9BE75;
                background: -webkit-gradient(linear, left top, left bottom, from(#444), to(#000));
                background: -moz-linear-gradient(top,  #444,  #E9BE75);
                filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#444444', endColorstr='#000000');
            }
            .black:active {
                color: #D9AD00;
                background: -webkit-gradient(linear, left top, left bottom, from(#D9AD00), to(#444));
                background: -moz-linear-gradient(top,  #000,  #444);
                filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#D9AD00', endColorstr='#666666');
            }
        </style>

    </body>
</html>
