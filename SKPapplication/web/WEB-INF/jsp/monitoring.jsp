<%-- 
    Document   : monitoring
    Created on : Apr 1, 2013, 9:31:25 AM
    Author     : Radius Imam Taufik
--%>

<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <!-- <script type="text/javascript" src="jquery-1.5.2.min.js"></script> -->
        <script type="text/javascript" src="/SKPapplication/js/jquery-1.7.1.min.js"></script>
        <script type="text/javascript" src="/SKPapplication/js/jquery.slidertron-1.1.js"></script>

        <title>Monitoring</title>
        <link rel="stylesheet" type="text/css" href="/SKPapplication/css/style2.css" />
        <link href="/SKPapplication/css/styleBiru.css" rel="stylesheet" type="text/css" />
        <link href="http://fonts.googleapis.com/css?family=Abel" rel="stylesheet" type="text/css" />
       
        <%
            ArrayList al = new ArrayList();
            String[] arr_inkerl = new String[3000];
            int ijl;
            ijl = 0;
        %>    


        <script language="javascript" type="text/javascript">
            function validate(evt) {
                var theEvent = evt || window.event;
                var key = theEvent.keyCode || theEvent.which;
                key = String.fromCharCode( key );
                var regex = /[0-9]|\./;
                if( !regex.test(key) ) {
                    theEvent.returnValue = false;
                    if(theEvent.preventDefault) theEvent.preventDefault();
                }
            }

            function ButtonBack()
            {
                pilihan=document.getElementById("pilih_session_monit");
                var pilihanSelected = pilihan.options[pilihan.selectedIndex].text;
                location = 'isiPerilakuServlet?nipatasanMonitoring2=<c:out value="${nipAtasan}"/>&pilih_session_monit='+pilihanSelected;
            };
            function ButtonBackCetak()
            {
                pilihan=document.getElementById("pilih_session_monit");
                var pilihanSelected = pilihan.options[pilihan.selectedIndex].text;
                location = 'cetakIsi4FaktorServlet?nipatasanMonitoringCetak=<c:out value="${nipAtasan}"/>&pilih_session_monit='+pilihanSelected ;
            };
            function validasi4 (){
                var vbiaya4text =document.getElementById("pilih_session_monit");
                var ddtk = vbiaya4text.options[vbiaya4text.selectedIndex].text;
                //   document.getElementById("session").value = ddtk;
            }; 
            function validasitest(){ 
                //document.getElementById("kuantitas4text").value
                var vkuantitas4text = document.getElementById("kuantitasRtext"); 
                var vidkualitas4text = document.getElementById("kualitasRtext"); 
                var vwaktu4text = document.getElementById("waktuRtext");
                var vbiaya4text =  document.getElementById("biayaRtext");
                //var namaUnorText= document.getElementById("namaUnorTex");
                //        var cariUmum = document.getElementById("cariUmum");
 
                if(vkuantitas4text.value == "-" || vkuantitas4text.value == "" ){ 
      
                    vkuantitas4text.focus(); 
                    return false; 
                }
                else if(vidkualitas4text.value == "-" || vidkualitas4text.value == ""){ 
      
                    vidkualitas4text.focus(); 
                    return false; 
                }
                else if(vwaktu4text.value == "-" || vwaktu4text.value == ""){ 
       
                    vwaktu4text.focus(); 
                    return false; 
                }
                else if(vbiaya4text.value == "-" || vbiaya4text.value == ""){ 
      
                    vbiaya4text.focus(); 
                    return false; 
                }else{
     
     
                    return true; 
                } 
    
            };
            
         
        </script>


        <style type="text/css"> 

            #slideshow {
                width : 100px;
                height: 150px;
                margin: 10px auto;
                padding: 5px 0px 0px 100px;

            }

            #foobar {
                position: relative;
            }

            #foobar .navigation {
                position: absolute;
                display: block;
                z-index: 100;
                color: #ffffff;
                bottom: 0px;
                right: 0px;
                margin: 10px;
                padding: 1px;
                background-color: #303030;
                opacity: 0.75;
            }

            #foobar .navigation a {
                color: #ffffff;
                text-decoration: none;
                outline: none;
            }

            #foobar .viewer {
                width: 100px;
                height: 150px;

            }

            #foobar .viewer .reel .slide {
                position: relative;
                width: 100px;
                height: 150px;
            }

            #foobar .viewer .reel .slide span {
                position: absolute;
                display: block;
                width: 100px;
                opacity: 0.30;
                padding: 15px;
                background-color: #FFFFFF;
                color: #000000;
                bottom: 0px;
                left: 0px;
                font-size: 18px;
            }


            #foobar .viewer-wrapper {
                float: left;
                width:  100px;
                height: 100px;
                background: red;
            }

            .arrow-left {
                background: blue;
                width: 100px;
                float: left;
            }

            .arrow-right {
                background: green;
                width: 100px;
                float: right;
            }

            #col1 {
                width: 100px;
                float: left;
                left: 0px;
            }

            #col1 a {
                outline: none;
                display: block;
                width: 100px;
                height: 100px;

                text-decoration: none;
            }

            #col2 {
                float: left;
                width: 100px;
                left: 0px;
            }

            #col3 a {
                float: right;
                outline: none;
                width: 87px;
                height: 100px;

                text-decoration: none;
            }




            #menu1 {
                position: relative;
                width: 200px;
                height: 400px;

                font-family: arial;

                font:italic bold 12px/30px Georgia, serif;
            }
            #menu1 ul {
                margin: 0;
                padding: 0;
                list-style: none;
            }
            #menu1 ul li {
                position: relative;
                float: left;
                width: 200px;

            }
            #menu1 ul li a {
                display: block;
                text-decoration: none;
                color: #000000;
                padding: 10px;
                float: left;
                width: 200px;

            }
            #menu1 ul li a:hover {
                background-color: #CCCCFF;
                color: #FF0000;
                font-size: 18px;
            }
            #menu1 ul li ul {
                display: none;
            }


            #menu1 ul li:hover ul{
                display: block;
                position: relative;
                top: 0px;
                left: 50px;
            }
            #menu1 ul li:hover ul li a {
                display: block;
                background: #CC66FF;
                color: #fff;
                width: 100%;
            }
            #menu1 ul li:hover ul li a:hover {
                background:#1c83ce;
                color: #33CC00;
            }
            #menu ul li:hover ul ul {
                display: none;
            }

            #menu1 ul li:hover ul li:hover ul {
                display: block;
                position: relative;
            }
            #menu1 ul li:hover ul li:hover ul a {
                display: block;
                position: relative;
                left: 50px;
            }


            #right {
                position :  absolute;
                top : 300px;
                left : 1px;
                width : 173px;
                height : 600px;

            }

            .Collapsable {
                width:100%;
                cursor:pointer;
                background-color:#E5E5E5;
                position:relative;

                background-color:#E5E5E5;
                position:relative;
            }
            #rightIsian {
                position :  absolute;
                top : 500px;
                left : 1px;
                width : 173px;
                height : 300px;
            }
            #rightIsian2 {
                position :  absolute;
                top : 200px;
                left : 50px;
                width : 500px;
                height : 300px;
            }
            #content {
                background :#BCEDF1 ;
                position :  absolute;
                top : 150px;
                left : 300px;
                width : 1000px;
                height : 501px;}

            #leftside {
                position :  absolute;
                top : 150px;
                left : 1px;
                width : 173px;
                height : 100px;
            }

            #leftside2 {
                position :  absolute;
                top : 180px;
                left : 350px;
                width : 600px;
                height : 200px;
            }

        </style>




    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <div id="logo">
                    <table >
                        <tr>
                            <th rowspan="2" >
                                <img src="/SKPapplication/images/burung_garuda7.png"/></th>
                            <td>
                                SASARAN KINERJA PEGAWAI
                            </td>
                        </tr>
                        <tr><td>
                                B K N
                            </td>
                            <td width="100" hidden="true" align="left"> &nbsp;&nbsp;&nbsp;&nbsp;Login <c:out  value="${sessionScope.user}" /> </td>
                            <td width="414" hidden="true" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NIP <c:out value="${sessionScope.NipPnsSession}" /> </td>
                        </tr>

                    </table>
                </div>
                <div id="menu">
                    <ul>
                        <li><a href="GetPnsServlet?txtNIPBaruB=<c:out value="${sessionScope.NipPnsSession}"/>" target="_parent" title="Target Sasaran SKI"><span></span>Kembali</a></li>	
                        <li><a href="RequestServlet?page=indexloginBaru" target="_parent" title="Keluar"><span></span>Keluar</a></li>

                    </ul>
                    <br class="clearfix" />
                </div>

            </div>

            <form method="post" name="form1"  onsubmit="return validasitest()"  action="isiPerilakuServlet"> 


                <table> <TR>

                        <TD>

                            <%-- CARI NIP DAN NAMA --%>
                            <div id="leftside">
                                <div STYLE=" height: 100px;   width: 250px; font-size: 12px; overflow: auto;">                  
                                    <table  align="top" width="320">

                                        <tr>

                                            <td width="80">NIP BARU   :</td>
                                            <td width="100" ><input type="number" maxlength="18" id="cariNipMon" name="cariNipMon" onkeypress='validate(event)'/> </td>
                                            <td><input type="image" src="/SKPapplication/images/cari.png" id="cariNipMon" name="cariNipMon" value="cari"/></td>

                                        </tr>

                                        <tr>
                                            <td>Nama :<input type="hidden" name="nipAtasan" id ="nipAtasan" value="${nipAtasan}"/><input type="hidden"  name="nipBaru" id ="nipBaru" value="${pns.getNipBaru()}"/></td>
                                            <td><input type="text" id="cariNamaMon" name="cariNamaMon" /></td>
                                            <td><input type="image" src="/SKPapplication/images/cari.png" id="cariNamaMon" name="cariNamaMon" value="cari"/></td>
                                        </tr>                          
                                    </table></div>
                            </div>

                        </TD> 

                        <TD rowspan ="2">&nbsp;

                        </td>

                        <TH ROWSPAN=2 BGCOLOR="#81BEF7">


                    <table border ="0" id="rounded-corner4">



                        <tr>
                            <td hidden="true">
                                ${nipdimonitoring}

                            </td>

                        </tr>


                    </table>

                    <div  id="content">

                        <table>
                            <tr  BGCOLOR="#81BEF7">
                                <th  width="38" rowspan="2">NO.</th>
                                <th rowspan="2" width="66">KODE</th>
                                <th rowspan="2" width="211">KEGIATAN TUGAS POKOK JABATAN</th>
                                <th colspan="5">TARGET</th>
                                <th colspan="4">REALISASI</th>
                                <th width="80" rowspan="2">PENGHITUNGAN PENCAPAIAN</th>


                            </tr>

                            <tr  BGCOLOR="#81BEF7">
                                <th width="51">AK</th>
                                <th width="85">KUANT/ OUTPUT</th>
                                <th width="78">KUAL/ MUTU</th>
                                <th width="68">WAKTU</th>
                                <th width="91" >BIAYA</th>

                                <th width="85">KUANT/ OUTPUT</th>
                                <th width="78">KUAL/ MUTU</th>
                                <th width="68">WAKTU</th>
                                <th width="95" >BIAYA</th>
                            </tr>
                            <c:forEach var="listTukesi" items="${realkesiServlet}" varStatus ="count">
                                <c:choose>
                                    <c:when test="${(listTukesi.getNilai_capaian_skp()) <'76'}">

                                        <tr bgcolor="#FF0000">

                                            <td width="54" align="center">${(count.index)+1}<input type="text" name="nipsendiri" id ="nipsendiri" value="${nipsendiri}"/></td>
                                            <td width="87" align="center"> <div align="center"><a href ="Isi4FaktorServlet?action=Monitor&nipnilaiR=<c:out value="${nipdimonitoring}"/>&NipAtasan=<c:out value="${pns.getNipBaru()}"/>&nipsendiriMonitoring=<c:out value="${nipsendiri}"/>&nipsendiriR=<c:out value="${nipsendiri}"/>&idTupoksiR=<c:out value="${listTukesi.getId_tupoksi()}"/>">${listTukesi.getId_tupoksi()}</a></div></td>
                                            <td width="530" align="left">${listTukesi.getNama_tupoksi()}<input type="hidden" name="Id_tupoksi" id ="Id_tupoksi" value="${listTukesi.getId_tupoksi()}"/></td>
                                            <td width="51" align="left">${listTukesi.getangkaKrdt4()}</td>
                                            <td width="85" align="center">${listTukesi.getKuantitas4()} ${listTukesi.getKuantitas_label()}</td>
                                            <td width="78" align="center">${listTukesi.getKualitas4()} %</td>
                                            <td width="68"align="center">${listTukesi.getWaktu4()} ${listTukesi.getWaktu_label()}</td>
                                            <td  width="91" align="center">Rp. ${listTukesi.getBiaya4()}</td>

                                            <td width="85" align="center">${listTukesi.getKuantitasr()} ${listTukesi.getKuantitas_label()}</td>
                                            <td width="78" align="center">${listTukesi.getKualitasr()} %</td>
                                            <td width="68" align="center">${listTukesi.getWaktur()} ${listTukesi.getWaktu_label()}</td>
                                            <td width="95" align="center">Rp. ${listTukesi.getBiayar()}</td>
                                            <td width="95" align="center"> ${listTukesi.getNilai_capaian_skp()}<input type="hidden" name="thn_sesion" id ="thn_sesion" value="${listTukesi.get_pilih_session()}"/></td>

                                        </tr>
                                    </c:when>
                                    <c:otherwise>
                                        <tr bgcolor="#e8edff">

                                            <td width="54" align="center">${(count.index)+1}<input type="text" name="nipsendiri" id ="nipsendiri" value="${nipsendiri}"/></td>
                                            <td width="87" align="center"> <div align="center"><a href ="Isi4FaktorServlet?action=Monitor&nipnilaiR=<c:out value="${nipdimonitoring}"/>&NipAtasan=<c:out value="${pns.getNipBaru()}"/>&nipsendiriMonitoring=<c:out value="${nipsendiri}"/>&nipsendiriR=<c:out value="${nipsendiri}"/>&idTupoksiR=<c:out value="${listTukesi.getId_tupoksi()}"/>">${listTukesi.getId_tupoksi()}</a></div></td>
                                            <td width="530" align="left">${listTukesi.getNama_tupoksi()}<input type="hidden" name="Id_tupoksi" id ="Id_tupoksi" value="${listTukesi.getId_tupoksi()}"/></td>
                                            <td width="51" align="left">${listTukesi.getangkaKrdt4()}</td>
                                            <td width="85" align="center">${listTukesi.getKuantitas4()} ${listTukesi.getKuantitas_label()}</td>
                                            <td width="78" align="center">${listTukesi.getKualitas4()} %</td>
                                            <td width="68"align="center">${listTukesi.getWaktu4()} ${listTukesi.getWaktu_label()}</td>
                                            <td  width="91" align="center">Rp. ${listTukesi.getBiaya4()}</td>

                                            <td width="85" align="center">${listTukesi.getKuantitasr()} ${listTukesi.getKuantitas_label()}</td>
                                            <td width="78" align="center">${listTukesi.getKualitasr()} %</td>
                                            <td width="68" align="center">${listTukesi.getWaktur()} ${listTukesi.getWaktu_label()}</td>
                                            <td width="95" align="center">Rp. ${listTukesi.getBiayar()}</td>
                                            <td width="95" align="center"> ${listTukesi.getNilai_capaian_skp()}<input type="hidden" name="thn_sesion" id ="thn_sesion" value="${listTukesi.get_pilih_session()}"/></td>

                                        </tr>
                                    </c:otherwise>

                                </c:choose>

                            </c:forEach> 


                        </table>

                        <table bgcolor="#1c83ce">
                            <thead>

                                <tr bgcolor="#CC99FF">
                                    <th width="31"><div align="center">NO.</div></th>
                            <th width="138"><div align="center">KODE</div></th>
                            <th width="138"><div align="center">JENIS TUGAS</div></th>
                            <th width="383"><div align="center">NAMA TUGAS TAMBAHAN</div></th>
                            <th width="138"><div align="center">TARGET</div></th>
                            <th width="138"><div align="center">REALISASI</div></th>
                            <th width="138"><div align="center">PENGHITUNGAN </div>  </th>        
                            <th width="138"><div align="center">NILAI CAPAIAN SKP</div></th>
                            </tr>

                            </thead>




                            <c:forEach var="tambahans" items="${tugasTambahans}" varStatus ="count">
                                <c:choose>
                                    <c:when test="${count.index % 2 == 0}">
                                        <tr bgcolor="#7FFFD4">
                                            <td width="31" align="center">${(count.index)+1}</td>
                                            <td width="138" align="center">${tambahans.getIdTambahan()}</td>
                                            <td width="138" align="left">${tambahans.getJenisTambahan()}</td>
                                            <td width="383" align="left">${tambahans.getNama()}</td>
                                            <td width="138" align="right">${tambahans.getNilai1()}</td>
                                            <td width="138" align="right">${tambahans.getNilai2()}</td>
                                            <td width="138" align="right">${tambahans.getHitungTambahan()}</td>
                                            <td width="138" align="right">${tambahans.getNilaiTambahan()}</td>
                                        </tr>
                                    </c:when>
                                    <c:otherwise>
                                        <tr bgcolor=#ADFF2F">
                                            <td width="31" align="center">${(count.index)+1}</td>
                                            <td width="138" align="center">${tambahans.getIdTambahan()}</td>
                                            <td width="138" align="left">${tambahans.getJenisTambahan()}</td>
                                            <td width="383" align="left">${tambahans.getNama()}</td>
                                            <td width="138" align="right">${tambahans.getNilai1()}</td>
                                            <td width="138" align="right">${tambahans.getNilai2()}</td>
                                            <td width="138" align="right">${tambahans.getHitungTambahan()}</td>
                                            <td width="138" align="right">${tambahans.getNilaiTambahan()}</td>
                                        </tr>
                                    </c:otherwise>

                                </c:choose>
                            </c:forEach>

                        </table>

                        <table >

                            <thead>
                                <tr bgcolor="#FF9966">
                                    <th width="31"><div align="center">NO.</div></th>
                            <th width="138"><div align="center">KODE</div></th>
                            <th width="138"><div align="center">JENIS TUGAS</div></th>
                            <th width="383"><div align="center">NAMA KREATIFITAS</div></th>
                            <th width="138"><div align="center">TARGET</div></th>
                            <th width="138"><div align="center">REALISASI</div></th>
                            <th width="138"><div align="center">PENGHITUNGAN </div>  </th>        
                            <th width="138"><div align="center">NILAI CAPAIAN SKP</div></th>
                            </tr>

                            </thead>




                            <c:forEach var="tambahans" items="${kereaktifitas}" varStatus ="count">
                                <c:choose>
                                    <c:when test="${count.index % 2 == 0}"> 
                                        <tr bgcolor="#7FFFD4">
                                            <td width="31" align="center">${(count.index)+1}</td>
                                            <td width="138" align="center">${tambahans.getIdTambahan()}</td>
                                            <td width="138" align="left">${tambahans.getJenisTambahan()}</td>
                                            <td width="383" align="left">${tambahans.getNama()}</td>
                                            <td width="138" align="right">${tambahans.getNilai1()}</td>
                                            <td width="138" align="right">${tambahans.getNilai2()}</td>
                                            <td width="138" align="right">${tambahans.getHitungTambahan()}</td>
                                            <td width="138" align="right">${tambahans.getNilaiTambahan()}</td>
                                        </tr>
                                    </c:when>
                                    <c:otherwise>
                                        <tr  bgcolor=#ADFF2F">
                                            <td width="31" align="center">${(count.index)+1}</td>
                                            <td width="138" align="center">${tambahans.getIdTambahan()}</td>
                                            <td width="138" align="left">${tambahans.getJenisTambahan()}</td>
                                            <td width="383" align="left">${tambahans.getNama()}</td>
                                            <td width="138" align="right">${tambahans.getNilai1()}</td>
                                            <td width="138" align="right">${tambahans.getNilai2()}</td>
                                            <td width="138" align="right">${tambahans.getHitungTambahan()}</td>
                                            <td width="138" align="right">${tambahans.getNilaiTambahan()}</td>
                                        </tr>
                                    </c:otherwise>

                                </c:choose>
                            </c:forEach>

                        </table>



                    </div>
                    </TH>
                    </TR>
                    <TR>
                        <TD>
                            <div id="right">
                                <table    width="410" >
                                    <tr>
                                        <td>
                                            <input type="button"  name="param" onclick="ButtonBack()" value="..."/> 
                                        </td>  


                                        <td width="10">
                                            <select id="pilih_session_monit" width="10"  name="pilih_session_monit" onchange="validasi4()" >
                                                <option value="-">-</option>
                                                <option value="2013">2013</option>
                                                <option value="2014">2014</option>
                                                <option value="2015">2015</option>
                                                <option value="2016">2016</option>
                                                <option value="2017">2017</option>
                                                <option value="2018">2018</option>
                                                <option value="2019">2019</option>
                                                <option value="2020">2020</option>
                                            </select>
                                        </td>  
                                        <td>
                                            <input type="button" name="CetakSeluruh" onclick="ButtonBackCetak()" target="_blank" value="CetakSeluruhBawahan"/>
                                        </td>
                                    </tr>      

                                </table>

                                <div STYLE=" height: 400px;   width: 300px; font-size: 12px;  overflow: scroll;">   

                                    <table  width="300"  >

                                        <tr>
                                            <td width ="30">No.</td>
                                            <td  width ="140" >NIP BARU</td>
                                            <td width ="200" >NAMA</td>
                                        </tr>         
                                        <c:forEach var="pnsList" items="${pnsList}" varStatus="count">
                                            <c:choose>
                                                <c:when test="${(pnsList.getRealisasi()) <'45'}">

                                                    <tr bgcolor="#FF0000">
                                                        <td width ="30" align="center">${(count.index)+1}</td>
                                                        <td width ="140" ><div align="left"><a href="GetPnsServlet?action=Monitor&txtNIPBaru=<c:out value="${pnsList.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>&NipAtasan=<c:out value="${nipAtasan}"/>" >${pnsList.getNipBaru()}</a></div></td>
                                                        <td><div align="left"><a href="GetPnsServlet?action=Monitor&txtNIPBaru=<c:out value="${pnsList.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>&NipAtasan=<c:out value="${nipAtasan}"/>" >${pnsList.getNamaPns()}</a></div></td>
                                                    </tr>  
                                                </c:when>
                                                <c:when test="${(pnsList.getRealisasi()) <'76'}">

                                                    <tr bgcolor="#CCFF99">
                                                        <td width ="30" align="center">${(count.index)+1}</td>
                                                        <td width ="140" ><div align="left"><a href="GetPnsServlet?action=Monitor&txtNIPBaru=<c:out value="${pnsList.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>&NipAtasan=<c:out value="${nipAtasan}"/>" >${pnsList.getNipBaru()}</a></div></td>
                                                        <td><div align="left"><a href="GetPnsServlet?action=Monitor&txtNIPBaru=<c:out value="${pnsList.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>&NipAtasan=<c:out value="${nipAtasan}"/>" >${pnsList.getNamaPns()}</a></div></td>

                                                    </tr>  
                                                </c:when>    

                                                <c:otherwise>
                                                    <tr bgcolor="#e8edff">   
                                                        <td width ="30" align="center">${(count.index)+1}</td>
                                                        <td width ="140" ><div align="left"><a href="GetPnsServlet?action=Monitor&txtNIPBaru=<c:out value="${pnsList.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>&NipAtasan=<c:out value="${nipAtasan}"/>" >${pnsList.getNipBaru()}</a></div></td>
                                                        <td><div align="left"><a href="GetPnsServlet?action=Monitor&txtNIPBaru=<c:out value="${pnsList.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>&NipAtasan=<c:out value="${nipAtasan}"/>" >${pnsList.getNamaPns()}</a></div></td>
                                                    </tr>       
                                                </c:otherwise>

                                            </c:choose>      
                                        </c:forEach>

                                    </table>
                                    <div id="menu1">

                                        <ul>   


                                            <c:forEach var="pnsBaw" items="${pnsBawahan}" varStatus="count">
                                                <li><a href="#">${pnsBaw.getNamaPns()}</a>
                                                    <ul>

                                                        <c:forEach var="pnsBaw2" items="${pnsBawahan2}">
                                                            <c:choose>
                                                                <c:when test="${(pnsBaw2.getDiAtasanId() == pnsBaw.getUnorId() &&  pnsBaw.getjnsjbtn_id()=='1' )}">  
                                                                    <c:set var="namArray" value="${pnsBaw2.getNamaPns()}"/>


                                                                    <li><a href="#">${pnsBaw2.getNamaPns()}</a>

                                                                        <ul>  
                                                                            <c:forEach var="pnsBaw3" items="${pnsBawahan3}">
                                                                                <c:choose>
                                                                                    <c:when test="${(pnsBaw3.getDiAtasanId() == pnsBaw2.getUnorId() && pnsBaw2.getjnsjbtn_id()=='1' )}">  
                                                                                        <li><a href="#">${pnsBaw3.getNamaPns()}</a>                        
                                                                                            <ul>
                                                                                                <c:forEach var="pnsBaw4" items="${pnsBawahan4}">
                                                                                                    <c:choose>
                                                                                                        <c:when test="${(pnsBaw4.getDiAtasanId() == pnsBaw3.getUnorId() ) && pnsBaw3.getjnsjbtn_id()=='1'}">  
                                                                                                            <li><a href="#">BAWAHAN4 : &nbsp;&nbsp;${pnsBaw4.getNamaPns()}</a></li>              
                                                                                                        </c:when>
                                                                                                    </c:choose>
                                                                                                </c:forEach>
                                                                                            </ul>
                                                                                        </li>
                                                                                    </c:when>
                                                                                </c:choose>
                                                                            </c:forEach>  
                                                                        </ul>         
                                                                    </li>                     
                                                                </c:when>
                                                            </c:choose>
                                                        </c:forEach>  

                                                    </ul>    
                                                </li>
                                            </c:forEach>
                                        </ul>      

                                    </div>

                                </div>

                            </div> 
                        </TD> 
                    </TR>


                </table>      
                <jsp:useBean id="animalList" class="java.util.ArrayList" />



                <%--<script type="text/javascript">
                    $(".Collapsable").click(function () {

                                            $(this).parent().children().toggle();
                                            $(this).toggle();

                                        });
                                    </script>--%>



                <div id="rightIsian">
                    <div id="rightIsian2">

                        <table>
                            <td>
                                <div id="slideshow">
                        <div id="foobar">   
                            <div id="col2">
                                <div class="viewer">        <div class="reel"> 
                                        <div class="slide">                     <img src="/SKPapplication/images/arrow-on-target.jpg" width="100" height="130" alt="" /> <span>S.K.P</span>
                                        </div><div class="slide">                <img src="/SKPapplication/images/blurry.jpg" width="100" height="130" alt="" /> <span>S.K.P</span>
                                        </div><div class="slide">                <img src="/SKPapplication/images/sukses.jpg" width="100" height="130" alt="" /> <span>S.K.P</span>
                                        </div><div class="slide">                <img src="/SKPapplication/images/meeting.jpg" width="100" height="130" alt="" /> <span>S.K.P</span>
                                        </div></div></div></div></div></div>


                            </td>
                            <td width="400">

                                <table border ="0" width="400">

                                    <tr >
                                        <td colspan="4">
                                    <center>TARGET</center>
                            </td>
                            </tr>
                            <tr >
                                <td colspan="4">&nbsp;

                                </td>
                            </tr>
                            <tr>
                                <td width="100">
                                    Angka Kredit
                                </td>
                                <td>
                                    :
                                </td>
                                <td colspan="2">
                                    ${realisasiIsi4faktorTupoksiId.getangkaKrdt4()} <input type="hidden" name="angkakrdt4" value="${realisasiIsi4faktorTupoksiId.getangkaKrdt4()}"/>
                                </td>

                            </tr>
                            <tr>
                                <td>
                                    Kuantitas
                                </td>
                                <td>
                                    :
                                </td>
                                <td colspan="2">
                                    ${realisasiIsi4faktorTupoksiId.getKuantitas4()} &nbsp; ${realisasiIsi4faktorTupoksiId.getKuantitas_label()}
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    Kualitas
                                </td>
                                <td>
                                    :
                                </td>
                                <td>
                                    ${realisasiIsi4faktorTupoksiId.getKualitas4()} 
                                </td>
                                <td>
                                    %
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    Waktu
                                </td>
                                <td>
                                    :
                                </td>
                                <td>
                                    ${realisasiIsi4faktorTupoksiId.getWaktu4()} 
                                </td>
                                <td>
                                    bln
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Biaya
                                </td>
                                <td>
                                    :
                                </td>
                                <td colspan="2">
                                    Rp. ${realisasiIsi4faktorTupoksiId.getBiaya4()} &nbsp; ,-
                                </td>

                            </tr>

                        </table>

                        </td>
                        <td>

                            <table width="300" border ="0">
                                <tr >
                                    <td colspan="4">
                                <center>REALISASI</center>
                        </td>
                        </tr>
                        <tr >
                            <td colspan="4">&nbsp;

                            </td>
                        </tr>
                        <tr>
                            <td>
                                Angka Kredit
                            </td>
                            <td>
                                :
                            </td>
                            <td colspan="2">
                                ${realisasiIsi4faktorTupoksiId.getangkaKrdt4()} <input type="hidden" name="angkakrdt4" value="${realisasiIsi4faktorTupoksiId.getangkaKrdt4()}"/>
                            </td>


                        </tr>
                        <tr>
                            <td>
                                Kuantitas
                            </td>
                            <td>
                                :
                            </td>
                            <td colspan="2">
                                <input size="10" type="text"  align="right" name="kuantitasRtext" id="kuantitasRtext"  value="${realisasiIsi4faktorTupoksiId.getKuantitasr()}" style="text-align: right" onKeyPress="return alertnipnull(event)" onFocus="clearText(this)" />&nbsp;${realisasiIsi4faktorTupoksiId.getKuantitas_label()}                              
                            </td>
                        </tr>

                        <tr>
                            <td>
                                Kualitas
                            </td>
                            <td>
                                :
                            </td>
                            <td colspan="2">
                                <input size="10" type="text"  name="kualitasRtext" id="kualitasRtext" value="${realisasiIsi4faktorTupoksiId.getKualitasr()}" align="right" style="text-align: right" onFocus="clearText(this)" onKeyPress="return alertnipnull(event)"/>%
                            </td>
                        </tr>

                        <tr>
                            <td>
                                Waktu
                            </td>
                            <td>
                                :
                            </td>
                            <td colspan="2">
                                <input size="10" type="text" name="waktuRtext" id="waktuRtext"  maxlength="2" value="${realisasiIsi4faktorTupoksiId.getWaktur()}" align="right" style="text-align: right" onFocus="clearText(this)" onKeyPress="return alertnipnull(event)"/> bln                   
                            </td>

                        </tr>
                        <tr>
                            <td>
                                Biaya
                            </td>
                            <td>
                                :
                            </td>
                            <td colspan="2">
                                Rp. <input type="text" name="biayaRtext"  id="biayaRtext" value="${realisasiIsi4faktorTupoksiId.getBiayar()}" style="text-align: right" onKeyPress="return alertnipnull(event)" onFocus="clearText(this)" /> &nbsp; ,-
                            </td>
                            <td>
                                <input type="submit" class="button black bigrounded" name="Submit" value="SIMPAN"/>
                            </TD> 
                            
                        </tr>

                        </table>

                        </td>
                       
                        <td >  <img src="/SKPapplication/images/Spining Globe_thumb[1].gif" width="100" height="100"/></td>


                        </table>

                    </div>   
                    <H1 style="color:#CCFF99"> <span id="merah">
                            <div STYLE="  width: 850px; font-size: 18px; overflow: auto; margin-top:400px; "><font face="georgia" color="White"><strong><marquee bgcolor="red" width="100%" scrollamount="3" behavior="alternate">Konsinyasi Dray R-Perka BKN Peraturan Perundang-undangan Bidang Pemberhentian dan Pensiun.. </marquee></strong></font></div> 
                        </span> </H1>



                                        <script type="text/javascript">
                        
                        $('#foobar').slidertron({
                            viewerSelector: '.viewer',
                            reelSelector: '.viewer .reel',
                            slidesSelector: '.viewer .reel .slide',
                            advanceDelay: 3000,
                            speed: 'slow'
                        });
                    </script>




                </div>              

            </form>

        </div>


    </body>
</html>
