<%-- 
    Document   : updateMenu2
    Created on : Feb 24, 2013, 10:17:38 PM
    Author     : asus-U46E
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UPDATE UNOR</title>
        <link href="http://fonts.googleapis.com/css?family=Abel" rel="stylesheet" type="text/css" />

        <link rel="stylesheet" type="text/css" href="/SKPapplication/css/style2.css" />
        
        <script type="text/javascript">
        function ubahidjabform2 (){
        var vbiaya4text =document.getElementById("pilihubahjabatan");
        var ddtk = vbiaya4text.options[vbiaya4text.selectedIndex].value;
        document.getElementById("idubahjabatan").value = ddtk;
        };
        </script>
             
        <style type="text/css"> 

            #page2Lokal{
                width: 650px;
                position: absolute;               
                background: #BDE1F1;
                margin-top : 210px;
                /*text-shadow: 1px 1px 1px rgba(0,0,0,0.75);*/
                font-family:Abel, sans-serif;
                font-size: 14px;
                overflow: auto;
                height: 300px;
            }

            #page2Lokal2{
                width: 700px;
                position: absolute;               
                background: #BDE1F1;
                margin-top : 40px;
                /*text-shadow: 1px 1px 1px rgba(0,0,0,0.75);*/
                font-family:Abel, sans-serif;
                font-size: 14px;
                overflow: auto;
                height: 200px;
            }

            #headerLokal {
                padding: 0px;
                width: 1000px;

                position: relative;
                height: 80px;
                left : -30px;
            }
            #leftside {

                position :  absolute;
                top : 60px;
                left : 25px;
                width : 156px;
                height : 600px;
            }

            #content {
                position :  absolute;
                top : 50px;
                left : 180px;
                width : 1000px;
                height : 600px;

            }
        </style>

    </head>
    <body>
        <div id="wrapper">


            <div id="headerLokal">
                <%@ include file="SlindronHeader.jsp" %>
            </div>   
            <div id="leftside">
                <%@ include file="navigasiPro.jsp" %>
            </div>  
            <div id="content">
                <div id="menu">
                    <ul>
                        <li>
                            <a href="GetPnsServlet?txtNIPBaruB=<c:out value="${pns.getNipBaru()}"/>" target="_parent" title="Target Sasaran SKI"><span></span>Kembali</a>
                        </li>


                        <li><a href="RequestServlet?page=indexloginBaru" target="_parent" title="Keluar"><span></span>Keluar</a></li>
                    </ul>
                    <br class="clearfix" />
                </div>
                <div id="page2Lokal2">

                    <table width="619" border="0">


                        <tr>
                            <td>NAMA :</td>
                            <td><c:out value="${pns.getNamaPns()}"/></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>NIP :</td>
                            <td><c:out value="${pns.getNipBaru()}"/></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>INSTANSI KERJA :</td>
                            <td><c:out value="${ins.getNamaInstansi()}"/></td>
                            <td><input type="hidden" name="idInstansiText" value="${ins.getIdInstansi()}"/></td>
                        </tr>
                        <tr>
                            <td>JABATAN :</td>
                            <td><c:out value="${pns.getNamaJabatan()}"/></td>
                            <td></td>
                        </tr>

                        <tr>
                            <td>UNIT KERJA :</td>
                            <td><c:out value="${pns.getNamaUnor()}"/></td>
                        </tr>

                    </table>

                    <form name="form2" method="post" action="referensiInstansiServlet">
                        <table> 
                            <tr>
                                <td>Jenis Jabatan</td>
                                
                                <td>
                                    <input type="text" id="idubahjabatan" name="idubahjabatan" value="${sesiontahun}" hidden/>
                                    <select id="pilihubahjabatan" name="pilihubahjabatan" onchange="ubahidjabform2()">
                                        <option value="2">Fungsional Tertentu</option>  
                                        <option value="4">Fungsional Umum</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Cari Jabatan ...: </td>
                                <td> <input name="UpdateJabatan" type="text" size="75"/></td>
                                <td> <input name="cariUnorUpdate" type="Submit" value="CARI" /> </td>
                                <td>  <input  type="hidden"  name="idnip" value="${pns.getNipBaru()}"/> </td>
                                <td> <input  type="hidden"  name="instansi" value="${pns.getInstansiId()}"/> </td>
                            </tr>    
                        </table>
                    </form>
                </div>
                <div id="page2Lokal">
                    <div style="overflow: auto">	
                        <table width="610" border="0" align="left" >
                            <thead>
      <tr>
                                    <th width="10" style="background-color: darkorange">No.</th>
                                    <th style="background-color: darkorange">CEPAT KODE</th>

                                    <th style="background-color: darkorange">NAMA JABATAN</th>
                                </tr>
                            </thead>


                            <c:forEach var="listUnories" items="${unories}" varStatus="count">
                                <tr>
                                    <td style="background-color: #ffcc99"width="10"><div align="center">${(count.index)+1}</div></td>
                                    <td style="background-color: #ffcc99"width="10"><div align="center">${listUnories.getCepatKode()}</div></td>
                                    <td style="background-color: #ffcc99" width="300">
                                        <a href="referensiInstansiServlet?&idJabatan=<c:out value="${listUnories.getId()}"/>&nipBaru=<c:out value="${pns.getNipBaru()}"/>&jenis=<c:out value="${pns.getjnsjbtn_id()}"/>&namaJabatan=<c:out value="${listUnories.getNama()}"/>&jenisjabatanidubah=${jenisjabatanidubah}&UbahJabatan=updateJabatan"> ${listUnories.getNama()}</a>
                                    </td>
                                    <%-- <td>${listUnories.getNamaJabatan()}</td> --%>
                                    <%--<td><a href="referensiInstansiServlet?&idInstkode=<c:out value="${listInstansies.getIdInstansi()}"/>&namaInstansiL=<c:out value="${listInstansies.getNamaInstansi()}"/>">${listInstansies.getNamaInstansi()}</a></td>--%>
                                </tr>
                            </c:forEach>

                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
