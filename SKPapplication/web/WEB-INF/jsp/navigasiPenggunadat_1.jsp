<%-- 
    Document   : navigasiPenggunadat
    Created on : 16 Jan 14, 13:29:57
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

        <title>SASARAN KERJA INDIVIDU</title>
        <script type='text/javascript' src='/SKPapplication/js/jquery.min.js'></script>
        <script src="/SKPapplication/js/jquery-ui-1.8.21.custom.min.js"></script>
        <script src="/SKPapplication/js/jquery-1.7.1.min.js"></script>
        <script type='text/javascript' src='/SKPapplication/js/FusionCharts.js'></script>
        <script type='text/javascript' src='/SKPapplication/js/FusionCharts.jQueryPlugin.js'></script>
        <script type='text/javascript' src='/SKPapplication/js/FusionCharts.HTMLTableDataHandler.js'></script>


        <link href="http://fonts.googleapis.com/css?family=Abel" rel="stylesheet" type="text/css" />

        <link rel="stylesheet" type="text/css" href="/SKPapplication/css/style2.css" />
        <style type="text/css"> 
            /*=======================Monitoring*/

            #headerLokalUtama {
                padding: 0px;
                width: 1020px;

                position: relative;
                height: 80px;
                left : 1px;
            }
            #headermetting {

                position :  absolute;
                top : -1px;
                left : 1000px;
                width : 200px;
                height : 100px;

            }	 
            #layar {
                width : 990px;
                height: 50x;
                padding-left:  189px;

                font-size: 18px
            }

            #warnass {color:#ff9900;font-weight:bold; font-size:14px;text-decoration:blink;font-family:Arial, Helvetica, sans-serif}




            .arrow-left {
                background: blue;
                width: 107px;
                float: left;
            }

            .arrow-right {
                background: green;
                width: 100px;
                float: right;
            }

            #col1 {
                width: 107px;
                float: left;
                left: 14px;
            }

            #col1 a {
                outline: none;
                display: block;
                width: 77px;
                height: 100px;
                background: url(images/img05.jpg) no-repeat 30px 130px;
                text-decoration: none;
            }

            #col2 {
                float: left;
                width: 733px;
                left: -15px;
            }

            #col3 a {
                float: right;
                outline: none;
                width: 87px;
                height: 100px;
                background: url(images/img06.jpg) no-repeat 10px 130px;
                text-decoration: none;
            }
            #merah { color : red }

            #biru { color : blue }

            #hijau { color : green }

            #warna {color:#FFFF00;font-weight:bold; font-size:40px;text-decoration:blink;font-family:Arial, Helvetica, sans-serif}
            /*=======================Monitoring*/

            #menuxx {

                position: absolute;
                bottom: 0;
                left: 0;
                font-family: Abel, sans-serif;
                margin: 0 0 0 0;
                height: 30px;
                background: #bdb7bc url(/SKPapplication/images/bg1.png) top left repeat-x;
                width: 1090px;
                padding: 0 45px 0 45px;
                line-height: 30px;
                /*text-shadow: 1px 1px 0px #FFF;*/
                border-radius: 10px 10px 0px 0px;

            }
            #current_page_item1 {
                background: rgba(0,0,0,0.1);
                border-radius: 4px;
                padding: 1px 15px 1px 15px !important;
                border-top: solid 1px rgba(0,0,0,0.2);
                border-bottom: solid 1px #fff;
            }
            #content {
                position :  absolute;
                top : 127px;
                left : 140px;
                width : 1020px;
                height : 600px;
                overflow: auto;
            }
            #content50 {
                position :  absolute;
                top : 40px;
                left : 140px;
                width : 1020px;
                height : 600px;
                overflow: auto;
            }

            #leftside {
                background:url(home.png);
                position :  absolute;
                top : 110px;
                left : 50px;
                width : 156px;
                height : 501px;
            }




            #leftsideMonitor {

                position :  absolute;
                top : 60px;
                left : 1px;
                width : 173px;
                height : 400px;

            }
            #contentMonitor {

                position :  absolute;
                top : 60px;
                margin-left:150px;
                width : 1000px;
                overflow: auto;
                height : 501px;}

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
                display:block;

                font-size:12px;
                color:#000000;

                float: left;
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


                padding:0 0 2px -20px;

            }
            #place-nav ul ul a {
                font-size:15px; 
                height:auto;
                width:180px;
                display:block;
                padding: 10px;

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
        <form action="administratorFunctionServlet" method="post" id="formBackToUserManagement" >
            <input type="hidden" name="nipbaru" id="nipBaru" value="<c:out value="${nipbaru}"/>" />
            <input type="hidden" name="param" value="AMBIL" />  
        </form> 
    </body>
</html>
<script>                                
$(document).ready(function(){
   $('#formBackToUserManagement').submit();   
});
</script>
