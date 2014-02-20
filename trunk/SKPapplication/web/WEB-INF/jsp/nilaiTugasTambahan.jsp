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

        <script language="javascript" type="text/javascript">
            function clearText(field)
            {
                if (field.defaultValue == field.value) field.value = '';
                else if (field.value == '') field.value = field.defaultValue;
            }
        </script>

        <style type="text/css"> 
            #headerLokal {
                padding: 0px;
                width: 1000px;

                position: relative;
                height: 80px;
                left : -50px;
            }
            #leftside {

                position :  absolute;
                top : 60px;
                left : 10px;
                width : 156px;
                height : 501px;
            }

            #contentdalam {
                position :  absolute;
                top : 130px;
                left : 170px;
                width : 1200px;
                height : 501px;
                overflow: auto;
            }
            #contentdalamsub{
                position :  absolute;
                top : 10px;
                left : 402px;
                width : 300px;
                height : 500px;
                overflow: auto;
            }
            #contentdalamsub2{
                position :  absolute;
                left: 702px;
                top: 5px;
                width : 250px;
                height : 500px;
                overflow: auto;
            }
            #contentdalamsub3{
                position :  absolute;
                left: 600px;
                height : 200px;
                width : 250px;
                height : 300px;
                overflow: auto;
            }
        </style>

        <style type="text/css">
            #menu2 {
                position: relative;
                width: 600px;
                height: 40px;

                font-family: arial;
                padding-left: 2px;
                top :0px;
            }

            #menu2 ul li a:hover {
                background-color: #CCCCFF;
                color: #FF0000;
            }

        </style>
    </head>
    <body>
        <div id="wrapper">
            <form method="post" name="form1" action="isiPerilakuServlet">  
                <div id="headerLokal">
                    <%@ include file="SlindronHeader.jsp" %>
                </div>   
                <div id="leftside">
                    <%@ include file="navigasiPro.jsp" %>
                </div>   
                <div id="contentdalam">

                    

                    <div style="padding-left:0px;padding-top: 10px;overflow: auto;background-color: #99ffcc;width: 400px ;height: 500px">
                        <table width="400" border="0" >
                            <tr>
                                <th colspan="3"><strong style="color: #000">STAFF/PEJABAT STRUKTURAL</strong>
                                    <input type="hidden" name="nipAtasan" id ="nipAtasan" value="${nipAtasan}"/> <input type="hidden"  name="nipBaru" id ="nipBaru" value="${pns.getNipBaru()}"/></th>

                            </tr>
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
                                <head>
                                    <td><strong style="color: #000">No</strong></td>
                                    <td><strong style="color: #000">NIP</strong></td>
                                    <td><strong style="color: #000">Nama PNS</strong></td>
                                </head>
                            </tr> 

                            <c:forEach var="pnsList" items="${pnsList}" varStatus="count">
                                <c:choose>
                                    <c:when test="${count.index % 2 == 0}">
                                        <tr bgcolor="#b9c9fe">


                                            <td align="center"><a href="isiPerilakuServlet?action=Koef&NipKoefKreatifitas=<c:out value="${pnsList.getNipBaru()}"/>">${(count.index)+1}</a></td>
                                            <td><div align="left"><a href="isiPerilakuServlet?action=Koef&NipKoefKreatifitas=<c:out value="${pnsList.getNipBaru()}"/>">${pnsList.getNipBaru()}</a></div></td>
                                            <td><div align="left"><a href="isiPerilakuServlet?action=Koef&NipKoefKreatifitas=<c:out value="${pnsList.getNipBaru()}"/>">${pnsList.getNamaPns()}</a></div></td>

                                        </tr>
                                    </c:when>
                                    <c:otherwise>
                                        <tr bgcolor="#e8edff">

                                            <td align="center"><a href="isiPerilakuServlet?action=Koef&NipKoefKreatifitas=<c:out value="${pnsList.getNipBaru()}"/>">${(count.index)+1}</a></td>
                                            <td><div align="left"><a href="isiPerilakuServlet?action=Koef&NipKoefKreatifitas=<c:out value="${pnsList.getNipBaru()}"/>">${pnsList.getNipBaru()}</a></div></td>
                                            <td><div align="left"><a href="isiPerilakuServlet?action=Koef&NipKoefKreatifitas=<c:out value="${pnsList.getNipBaru()}"/>">${pnsList.getNamaPns()}</a></div></td>

                                        </tr> 
                                    </c:otherwise>

                                </c:choose>

                            </c:forEach>

                        </table>   
                    </div>    

                    <div id="contentdalamsub" >
                        <table width="300" >
                            <tbody>
                                <tr align="center">
                                    <td colspan="5"><strong style="color: #000"><u>Penilaian Tugas Tambahan</u></strong></td>
                                </tr>
                                <tr>
                                    <td><strong style="color: #000">No</strong></td>
                                    <%--<td><strong>Id</strong></td>--%>
                                    <td><strong style="color: #000">Nama</strong></td>
                                    <td><strong style="color: #000">Persetujuan</strong></td>
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
                        <div><a href="isiPerilakuServlet?action=HitungTambahan&nipTambahan=<c:out value="${idNipTambahan}"/>">HITUNG</a><strong>&nbsp;&nbsp;:&nbsp;&nbsp;</strong>${hitunganTugasTambahan}</div>
                    </div>


                    <div id="contentdalamsub2">
                        <table >

                            <tr align="center">
                                <td colspan="5"><strong style="color: #000"><u>Kreatifitas</u></strong></td>
                            </tr>
                            <tr>
                                <td><strong style="color: #000">No</strong></td>
                                <td  style="width: 150px"><strong style="color: #000">Tugas</strong></td>
                                <td><strong style="color: #000">Persetujuan</strong></td>
                            </tr> 
                            <c:forEach var="tambahans" items="${kereaktifitas}" varStatus ="count">
                                <tr>
                                    <td align="center" style="background-color:darkorange">${(count.index)+1}</td>
                                    <td align="left" style="background-color:darkorange;width: 150px"><a href="isiPerilakuServlet?action=Kreaf&NipKoefKreatifitas=<c:out value="${idNipTambahan}"/>&idTam=<c:out value="${tambahans.getIdTambahan()}"/>">${tambahans.getNama()}</a></td>
                                    <td align="left" style="background-color:darkorange"><a href="isiPerilakuServlet?action=Kreaf&NipKoefKreatifitas=<c:out value="${idNipTambahan}"/>&idTam=<c:out value="${tambahans.getIdTambahan()}"/>">${tambahans.getKoef_kreatifitas()}</a></td>
                                </tr>
                            </c:forEach>

                        </table>
                        <div style="padding-top: 20px;background-color: #FFF7D7">  
                            <table >

                                <tr align="center">
                                    <td colspan="5"><strong style="color: #000"><u>Penilaian Kreatifitas</u></strong></td>
                                </tr>
                                <tr>
                                    <td><strong style="color: #000">Id</strong></td>
                                    <td><strong style="color: #000">Nama</strong></td>
                                    <td><strong style="color: #000">Koefisien</strong></td>
                                </tr>
                                <tr>
                                    <td>${kereaktifitas2.getIdTambahan()}</td>
                                    <td>${kereaktifitas2.getNama()}</td>

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

                            </table>
                        </div>
                    </div>

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

                                function kembali(                            )
                                {
                                    location = 'GetPnsServlet?txtNIPBaruReal=<c:out value="${nipAtasan}"/>';
                                }
                               

                                function refresh(                            )
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
                                
                                    //location = 'isiPerilakuServlet?action=HitungKreatifitas&idTambahanKreatifitas=<c:out value="${tambahans.getIdTambahan()}"/>&nipTambahan=<c:out value="${idNipTambahan}"/>&koef_kreatifitas='+dd                            tk;
                                    //location = 'isiPerilakuServlet?action=HitungKreatifitas&idTambahanKreatifitas=<c:out value="${tambahans.getIdTambahan()}"/>&nipTambahan=<c:out value="${tambahans.getIdNip()}"/>&koef_kreatifitas='+dd                            tk;
                                    //location = 'isiPerilakuServlet?action=HitungKreatifitas&idTambahanKreatifitas='+ddtk2+'&nipTambahan=<c:out value="${idNipTambahan}"/>&koef_kreatifitas='+dd                            tk;
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


                            </body>
                            </html>
