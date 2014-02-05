<%-- 
    Document   : tupoksiBaru22
    Created on : Feb 24, 2013, 11:20:08 PM
    Author     : asus-U46E
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>SASARAN KINERJA PEGAWAI</title>
        <link href="http://fonts.googleapis.com/css?family=Abel" rel="stylesheet" type="text/css" />

        <link rel="stylesheet" type="text/css" href="/SKPapplication/css/style2.css" />

        <style type="text/css"> 
            
             #headerLokal {
	padding: 0px;
        width: 1000px;
       
	position: relative;
	height: 80px;
        left : -50px;
}

 #logoLokal {
	margin-top:  2px;
        width: 500px;
       
	position: relative;
	height: 80px;
        left : 10px;
}
            #leftside {

                position :  absolute;
                top : 64px;
                left : 10px;
                width : 156px;
                height : 501px;
            }

            #content {
                position :  absolute;
                top : 86px;
                left : 200px;
                width : 1000px;
                height : 501px;
                overflow: auto;
            }
        </style>
        <style type="text/css">
            #menu3 {
                padding-top: 20px;
                position: absolute;
                width: 600px;
                height: 20px;
                background-color:#ffcc33

            }

            #menu3 ul li a:hover {
                background-color: #CCCCFF;
                color: darkorange;
                font-size: medium

            }
            #menu3 li  a {
                float:left;
                display:inline;

                font-size:12px;
                color:#000000;

                border-bottom:3px solid #085d93;
                text-decoration:none;
                width:100px;
                margin-top: -9px;
                 padding-left:20px;
                padding-top: 0px;
                height:auto;
                border-radius: 0px 0px 10px 10px;
                box-shadow: inset 0px 0px 0px 0px rgba(255,255,255,0.5), inset 0px 0px 0px 2px rgba(0,0,0,0.25), 0px 4px 3px 1px rgba(0,0,0,0.25);
                border: solid 3px rgba(0,0,0,0.5);

            }
        </style>
    </head>
    <body>
        <div id="wrapper">
 

          


            <form name="form1" method="post" action="tupoksiServlet2">
                <div id="headerLokal">
                    <%@ include file="SlindronHeader.jsp" %>
                </div>   
                
                <div id="leftside">
                    <%@ include file="navigasiPro.jsp" %>
                </div>   
                
 
                <div id="content">

                    <div style="padding-top:40px">
                        <table width="600" border="0" >
                            <tr>
                                <td width="200" rowspan="4"><p align="center" class="style1">&nbsp;</p>      </td>
                                <th colspan="3" style="background:darkorange"><div align="center">DAFTAR TUPOKSI</div></th>
                            </tr>
                            <tr>
                                <td  style="background:darkorange" height="23">INSTANSI</td>
                                <td>:</td>
                                <td style="background-color: #ffcc33"><c:out value="${ins.getNamaInstansi()}" /></td>
                            </tr>
                            <tr>
                                <td style="background:darkorange" width="92" height="23">JABATAN</td>
                                <td>:</td>
                                <td style="background-color: #ffcc33" width="712"><c:out value="${pns.getNamaJabatan()}" /></td>
                            </tr>
                            <tr>
                                <td style="background:darkorange">UNIT KERJA</td>
                                <td>:</td>
                                <td style="background-color: #ffcc33"><c:out value="${pns.getNamaUnor()}" /></td>
                            </tr>


                        </table>
                    </div>

                    <input  type="hidden"  name="idnipText" value="${pns.getNipBaru()}"/>
                    <div style="padding-top:40px;overflow: auto">
                        <table width="600" border="0">
                            <tr>
                                <td>
                                    Pilih Jabatan Fungsional serumpun lainnya :
                                </td>
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
                    </div>
                    <div style=" padding-top:40px;overflow: auto">
                        <table width="600" border="0">
                            <thead>

                                <tr>
                                    <th style="background:darkorange"> NO </th>
                                    <th style="background:darkorange">>KODE </th>
                                    <th style="background:darkorange">>NAMA TUGAS DAN FUNGSI</th>
                                    <c:if test="${jabatan == '2'}">
                                        <th style="background:darkorange">>ANGKA KREDIT</th>
                                    </c:if>
                                </tr>

                            </thead>
                            <c:forEach var="listUnosi" items="${unosiServlet}" varStatus="count">
                                <tr>
                                    <td>${(count.index)+1}</td>
                                    <td><a href="isiTupoksiServlet?isCetak=true&nipnilai=<c:out value="${pns.getNipBaru()}"/>&kelompokTugas=<c:out value="${namaKelompok}"/>&UnorIdisert=<c:out value="${pns.getUnorId()}"/>&idTupoksi=<c:out value="${listUnosi.getIdTupoksi()}"/>">${listUnosi.getIdTupoksi()}</a></td>
                                    <td>${listUnosi.getNamaTupoksi()}</td>
                                    <c:if test="${jabatan == '2'}">   
                                        <td><center> ${listUnosi.getangka_krdt()} </center></td>
                                    </c:if>
                                </tr>
                            </c:forEach> 

                        </table>

                    </div>

                    <div id="menu3">
                        <ul>
                            <li style="border-collapse: collapse"><a href="GetPnsServlet?txtNIPBaruB=<c:out value="${pns.getNipBaru()}"/>" target="_parent">KEMBALI</a></li>
                            <%--  <li><a href="RequestServlet?page=indexloginBaru" target="_parent" title="Keluar">Keluar</a></li> --%>
                        </ul>

                    </div>
                </div>
            </form>
        </div>

    </body>
</html>
