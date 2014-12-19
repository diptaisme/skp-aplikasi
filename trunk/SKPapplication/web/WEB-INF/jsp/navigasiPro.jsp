<%-- 
    Document   : navigasiPro
    Created on : 27 Jan 14, 14:23:23
    Author     : Sony
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>

<c:if test="${sessionScope.user==null}">
    <%
        String redirectURL = "/SKPapplication/";
        response.sendRedirect(redirectURL);
    %>
</c:if>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="/SKPapplication/js/jquery-1.7.1.min.js"></script>
        <script type="text/javascript" src="/SKPapplication/js/jquery.slidertron-1.1.js"></script>
        <link href="http://fonts.googleapis.com/css?family=Abel" rel="stylesheet" type="text/css" />

        <link rel="stylesheet" type="text/css" href="/SKPapplication/css/style2.css" />
        <title>JSP Page</title>
        <style type="text/css"> 
            #leftside {
                background:url(home.png);
                position :  absolute;

            }
            #place-nav {
                width:100px;
                height:300px;
                margin:0 0 0 0;
                left : -20px;
                height:auto;
            }
            #nav {
                height:300px;
                left : -20px;

            }
            #nav li {
                left : -20px;
                height:auto;
                float:left;
                display:inline;

                position:relative;
                font-family: Arial, verdana, serif;
                z-index:1000;
                width:100px;

                text-decoration:none;


            }

            #nav li a {
                float:left;
                display:inline;

                font-size:12px;
                color:#000000;

                border-bottom:0px solid #085d93;
                text-decoration:none;
                width:100px;
                left : -10px;
                height:auto;

            }
            #nav li:hover a {
                text-decoration:none;
                color:#000000;
                font-size:20px;
                width:100px;
                border-bottom:0px solid #085d93;
                float: left;
                height:auto;
            }
            #nav li ul  {
                text-decoration:none;
                color:#505050;
                width:100px;
                height:auto;
                float: left;
            }
            #place-nav ul ul {

                z-index:1200;
                display:inline;
                width:180px;

                margin: 0 0 0 0px;
                position:relative;


                padding:0 0 2px -20px;
            }


            #place-nav ul li ul li {
                display: inline;
                float: left;
                width:160px;
                height:auto;
                border-bottom:1px solid #085d93;
                float: left;
                padding: 0;
                position:relative;
                margin:0;
            }
            #place-nav ul ul ul {
                position:relative;
                z-index:1300;
                display:none;
                width:50px;
                margin: 0;
                top: 0;
                left:180px;
                background:#1c83ce;
                border-left:1px solid #1479c3;
                padding:0;
                height:auto;
            }

            #place-nav  li:hover ul {
                display:block;
                float: left;
                height:auto;
                padding: 0;
            }
            #place-nav  li:hover li {
                display:block;
                float: left;
                height:auto;
                padding: 0;
            }
            #place-nav ul li ul li:hover ul {
                display:block;
                float: left;
                height:auto;
                padding: 0;
            }

            place-nav ul li ul li:hover ul a {
                display:block;
                float: left;
                height:auto;
                padding: 0;
            }

            #place-nav ul ul a {
                font-size:15px; 
                height:auto;
                width:180px;
                display:block;
                padding: 10px;

            }


            #place-nav #nav li:hover ul li a, #place-nav #nav li:hover ul li a:link, #place-nav #nav li:hover ul li a:visited {

                font-size:12px;
                width:170px;
                height:auto;
                text-transform:none;
                border:none;
                background: none;
                padding:9px 8px;
                text-shadow:none;
                margin:0;
                font-weight:lighter;
            }
            #place-nav #nav li:hover ul li a:hover, #place-nav #nav li ul li a:hover {
                text-decoration:none;
                color:#000000;
                font-size:20px;


            }
            div#place-nav li:hover ul ul,
            div#place-nav li li:hover ul ul
            {display:none;}div#place-nav li:hover ul,
            div#place-nav li li:hover ul
            {display:block;}
        </style>
    </head>
    <body>
        <p hidden="true"> &nbsp;&nbsp;&nbsp;&nbsp;Login <c:out  value="${sessionScope.user}" /> </p>
        <p hidden="true">     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NIP <c:out value="${sessionScope.NipPnsSession}" /> </p>
        <p hidden="true">     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NIP <c:out value="${sessionScope.levelPemakaian}" /> </p>

        <c:set var="tingkat" value="${sessionScope.levelPemakaian}" />   <div>
            <div id="leftside">     
                <div id="place-nav" >
                    <ul id="nav">
                        <li><a href="#"><div style="font-size: 20px">...</div></a>
                            <ul>
                                <c:if test="${tingkat=='3'}">
                                    <li><a href="NavigasiProfile?nipManajemenPengguna=<c:out value="${sessionScope.NipPnsSession}"/>">Manajemen Pengguna</a></li>
                                    <li><a href="NavigasiProfile?nipPerwakilan=<c:out value="${sessionScope.NipPnsSession}"/>">Entry Data tk. Esl II</a></li>
                                    <li><a href="NavigasiProfile?nipPengguna=<c:out value="${sessionScope.NipPnsSession}"/>">Entry Data Personal</a></li>
                                    <li><a href="NavigasiProfile?nipentriTupoksi=<c:out value="${sessionScope.NipPnsSession}"/>">Entri Kegiatan Tugas Jabatan</a></li>
                                    <li><a href="NavigasiProfile?nipmonitoring=<c:out value="${sessionScope.NipPnsSession}"/>">Monitoring</a></li>
                                    <li><a href="NavigasiProfile?salindata=<c:out value="${sessionScope.NipPnsSession}"/>">Salin Data </a></li>
                                    <li><a href="NavigasiProfile?refisidata=<c:out value="${sessionScope.NipPnsSession}"/>">Revisi </a></li>
                                    <li><a href="NavigasiProfile?rekapdata=<c:out value="${sessionScope.NipPnsSession}"/>">rekapitulasi </a></li>
                                    <li><a href="RequestServlet?page1=indexloginBaru" target="_parent" title="Keluar">KELUAR</a></li>    
                                </c:if>
                                <c:if test="${tingkat=='2'}">
                                    <li><a href="NavigasiProfile?nipPerwakilan=<c:out value="${sessionScope.NipPnsSession}"/>">Entry Data tk. Esl II</a></li>
                                    <li><a href="NavigasiProfile?nipPengguna=<c:out value="${sessionScope.NipPnsSession}"/>">Entry Data Personal</a></li>
                                    <li><a href="NavigasiProfile?nipentriTupoksi=<c:out value="${sessionScope.NipPnsSession}"/>">Entri Kegiatan Tugas Jabatan</a></li>
                                    <li><a href="NavigasiProfile?nipmonitoring=<c:out value="${sessionScope.NipPnsSession}"/>">Monitoring</a></li>
                                    <li><a href="NavigasiProfile?refisidata=<c:out value="${sessionScope.NipPnsSession}"/>">Revisi </a></li>
                                    <li><a href="NavigasiProfile?rekapdata=<c:out value="${sessionScope.NipPnsSession}"/>">rekapitulasi </a></li>
                                    <li><a href="RequestServlet?page1=indexloginBaru" target="_parent" title="Keluar">KELUAR</a></li>
                                </c:if>
                                <c:if test="${tingkat=='1'}">
                                    <li><a href="NavigasiProfile?nipPengguna=<c:out value="${sessionScope.NipPnsSession}"/>">Entry Data Personal</a></li>
                                    <li><a href="NavigasiProfile?nipentriTupoksi=<c:out value="${sessionScope.NipPnsSession}"/>">Entri Kegiatan Tugas Jabatan</a></li>
                                    <li><a href="NavigasiProfile?nipmonitoring=<c:out value="${sessionScope.NipPnsSession}"/>">Monitoring</a></li>
                                    <li><a href="NavigasiProfile?refisidata=<c:out value="${sessionScope.NipPnsSession}"/>">Revisi </a></li>
                                    <li><a href="RequestServlet?page1=indexloginBaru" target="_parent" title="Keluar">KELUAR</a></li>
                                </c:if> 
                                <c:if test="${tingkat=='0'}">
                                    <li><a href="NavigasiProfile?nipPengguna=<c:out value="${sessionScope.NipPnsSession}"/>">Entry Data Personal</a></li>
                                    <li><a href="NavigasiProfile?nipmonitoring=<c:out value="${sessionScope.NipPnsSession}"/>">Monitoring</a></li>
                                    <li><a href="NavigasiProfile?refisidata=<c:out value="${sessionScope.NipPnsSession}"/>">Revisi </a></li>
                                    <li><a href="RequestServlet?page1=indexloginBaru" target="_parent" title="Keluar">KELUAR</a></li>
                                </c:if>
                            </ul>
                        </li> 

                    </ul>
                </div> 
            </div>

    </body>
</html>
