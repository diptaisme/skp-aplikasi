<%-- 
    Document   : Bulalanan
    Created on : Sep 11, 2014, 8:07:06 PM
    Author     : radius
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <script type='text/javascript' src='/SKPapplication/js/jquery.min.js'></script>
        <script src="/SKPapplication/js/jquery-ui-1.8.21.custom.min.js"></script>
        <script src="/SKPapplication/js/jquery-1.7.1.min.js"></script>
        <script type='text/javascript' src='/SKPapplication/js/FusionCharts.js'></script>
        <script type='text/javascript' src='/SKPapplication/js/FusionCharts.jQueryPlugin.js'></script>
        <script type='text/javascript' src='/SKPapplication/js/FusionCharts.HTMLTableDataHandler.js'></script>

        <link href="/SKPapplication/css/style2.css" rel="stylesheet" type="text/css" />


        <link href="http://fonts.googleapis.com/css?family=Abel" rel="stylesheet" type="text/css" />

        <link rel="stylesheet" type="text/css" href="/SKPapplication/css/style2.css" />


        <style type="text/css"> 
            #slideText {
                width : 1180px;
                height: 40x;
                left: 20px;
                margin-top:  100px;

            }
            #warnass {color:#ff9900;font-weight:bold; font-size:14px;text-decoration:blink;font-family:Arial, Helvetica, sans-serif}

            #headermetting {

                position :  absolute;
                top : 1px;
                left : 1020px;
                width : 200px;
                height : 100px;

            }	 
            #logoLokal {
                margin-top:  20px;
                width: 400px;
                text-shadow: 1px 1px 1px #000;

                position: absolute;
                height: 100px;
                margin-left: 40px;
            }
            #layar {
                width : 990px;
                height: 50x;
                padding-left:  189px;

                font-size: 18px
            }
            #headerLokalUtama {
                padding: 0px;
                width: 1180px;

                position: relative;
                height: 80px;
                left : 1px;
            }
            #slideshow {
                width : 1180px;
                height: 100x;
                left: 1px;
                margin: -15px auto;
                padding: 5px 0px 0px 0px;
                background: url(images/img03.jpg) no-repeat left top;
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
                width: 1180px;
                height: 100px;

            }

            #foobar .viewer .reel .slide {
                position: relative;
                width: 1180px;
                height: 100px;
            }

            #foobar .viewer .reel .slide span {
                position: absolute;
                display: block;
                width: 1180px;
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
                width: 1180px;
                height: 100px;
                background: red;
            }

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

        </style>

        <style type="text/css"> 
            #headerLokal {
                padding: 0px;
                width: 1000px;

                position: relative;
                height: 80px;
                left : 5px;
            }


            #contentdalam {
                position :  absolute;
                top : 100px;
                left : 180px;
                width : 1270px;
                height : 501px;

            }
            #contentdalamsub{
                position :  absolute;
                top : 65px;
                left : 1px;
                width : 1200px;
                height : 400px;

            }
            #contentdalamsubajak{
                position :  absolute;
                top : 55px;
                left : 4px;
                width : 800px;
                height : 400px;
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

            #met {
                position: relative;
                width: 997px;
                height: 40px;
                background: #9999CC;

                font-family: arial;
                padding-left: 10px;
                top :0px;
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
        <style type="text/css"> 
            #leftside {

                position :  absolute;
                top : 100px;
                left : 40px;
                width : 156px;
                height : 501px;
            }
            #place-nav {
                width:100px;
                height:300px;
                margin:0 0 0 0;
                left : -10px;
                height:auto;
            }
            #nav {
                height:300px;
                left : -10px;

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

        <style type="text/css"> 
            /*=======================Monitoring*/
            #graph {

                position :  absolute;
                top : 510px;
                left : 180px;
                width : 1000px;
                height : 350px;
                overflow: auto;


            }	 </style>
        <script>
            $(document).ready(
            function() {
                   

                $("#chartContainer20").insertFusionCharts({
                    type:  "MSColumn2D",
                    width: "250",
                    height: "300",
                               
                    dataFormat: "json",
                    dataSource: {
                        "chart":{
                            "caption":"Grafik Capaian Kinerja Kuantitas Bulanan ",
                            "bgcolor":"ffffff,ffffff",
                            "showlabels":"1",
                            "showvalues":"0",
                            "showborder":"0",
                            "decimals":"0"
                        },
                        "categories":[
                            {
                                "category":[
                                    {
                                        "label":"progres Kuantitas"
                                    }
                                ]
                            }
                        ],
                        "dataset":[
                            {
                                "seriesname":"Nilai Capaian Prestasi Bulan",
                                "color":"AFD8F8",
                                "data":[
                                    {
                                        "value":"${kuanitasMaxBulan}"
                                    }
                                ]
                            },
                            {
                                "seriesname":"Standarisasi Target Kuantitas",
                                "color":"F6BD0F",
                                "data":[
                                    {
                                        "value":"${kuantitasTahun}"
                                    }
                                ]
                            }
                            
                        ]
                    }
                });
                
                $("#chartContainer23").insertFusionCharts({
                    type:  "MSColumn2D",
                    width: "250",
                    height: "300",
                               
                    dataFormat: "json",
                    dataSource: {
                        "chart":{
                            "caption":"Grafik Capaian Kinerja Kualitas Bulanan ",
                            "bgcolor":"ffffff,ffffff",
                            "showlabels":"1",
                            "showvalues":"0",
                            "showborder":"0",
                            "decimals":"0"
                        },
                        "categories":[
                            {
                                "category":[
                                    {
                                        "label":"progres Kualitas"
                                    }
                                ]
                            }
                        ],
                        "dataset":[
                            {
                                "seriesname":"Nilai Capaian Prestasi Bulan",
                                "color":"AFD8F8",
                                "data":[
                                    {
                                        "value":"${kualitasMaxBulan}"
                                    }
                                ]
                            },
                            {
                                "seriesname":"Standarisasi Target kualitas",
                                "color":"F6BD0F",
                                "data":[
                                    {
                                        "value":"${kualitasTahun}"
                                    }
                                ]
                            }
                            
                        ]
                    }
                });
                
                $("#chartContainer24").insertFusionCharts({
                    type:  "MSColumn2D",
                    width: "250",
                    height: "300",
                               
                    dataFormat: "json",
                    dataSource: {
                        "chart":{
                            "caption":"Grafik Capaian Kinerja Waktu Bulanan ",
                            "bgcolor":"ffffff,ffffff",
                            "showlabels":"1",
                            "showvalues":"0",
                            "showborder":"0",
                            "decimals":"0"
                        },
                        "categories":[
                            {
                                "category":[
                                    {
                                        "label":"progres Waktu"
                                    }
                                ]
                            }
                        ],
                        "dataset":[
                            {
                                "seriesname":"Nilai Capaian Prestasi Bulan",
                                "color":"AFD8F8",
                                "data":[
                                    {
                                        "value":"${waktusMaxBulan}"
                                    }
                                ]
                            },
                            {
                                "seriesname":"Standarisasi Target Waktu",
                                "color":"F6BD0F",
                                "data":[
                                    {
                                        "value":"${waktuTahun}"
                                    }
                                ]
                            }
                            
                        ]
                    }
                });
                
                $("#chartContainer25").insertFusionCharts({
                    type:  "MSColumn2D",
                    width: "250",
                    height: "300",
                               
                    dataFormat: "json",
                    dataSource: {
                        "chart":{
                            "caption":"Grafik Capaian Kinerja Biaya Bulanan ",
                            "bgcolor":"ffffff,ffffff",
                            "showlabels":"1",
                            "showvalues":"0",
                            "showborder":"0",
                            "decimals":"0"
                        },
                        "categories":[
                            {
                                "category":[
                                    {
                                        "label":"progres Biaya"
                                    }
                                ]
                            }
                        ],
                        "dataset":[
                            {
                                "seriesname":"Nilai Capaian Prestasi Bulan",
                                "color":"AFD8F8",
                                "data":[
                                    {
                                        "value":"${biayaMaxBulan}"
                                    }
                                ]
                            },
                            {
                                "seriesname":"Standarisasi Target Biaya",
                                "color":"F6BD0F",
                                "data":[
                                    {
                                        "value":"${biayaTahun}"
                                    }
                                ]
                            }
                            
                        ]
                    }
                });
            });
       
        </script>

        <form method="post" name="form1" action="LaporanBulananServlet" >  
            <div id="headerLokalUtama">
                <div id="slideshow">
                    <div id="foobar1">   
                        <div id="col2">
                            <div class="viewer1">        <div class="reel"> 
                                    <div class="slide1">                    
                                        <img src="images/sweet-white-blue-swirl-powerpoint-backgrounds.1440x300.jpg" width="1180" height="100" alt=""  /> <span></span>
                                    </div><div class="slide1">                 <span></span>
                                    </div></div></div></div></div>




                </div>
                <div id="logoLokal">
                    <table >
                        <tr>
                            <th rowspan="2" >
                                <img src="/SKPapplication/images/burung_garuda7.png"/></th>
                            <td>
                                SASARAN KINERJA PEGAWAI
                            </td>
                        </tr>
                        <tr><td>
                                BADAN KEPEGAWAIAN NEGARA
                            </td></tr>

                    </table>
                </div>
            </div>

            <div id="graph">
                <table>   
                    <td> <div id="chartContainer20"></div></td>  
                    <td><div id="chartContainer23"></div></td>
                    <td><div id="chartContainer24"></div></td>
                    <td><div id="chartContainer25"></div></td>

                </table>
            </div>

            <input type="hidden" name="nipAtasan" id ="nipAtasan" value="${nipAtasan}"/><input type="hidden"  name="nipBaru" id ="nipBaru" value="${pns.getNipBaru()}"/>

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

                <div id="contentdalam">
                    <div id="met">
                        <ul>


                            <li> 
                                <a id="url4"  onclick="redirect4Kembali()" ><center>Kembali</center></a>
                            </li>

                            <input type="hidden" name="nippns" value="${sessionScope.user}"/>
                            <input type="hidden" name="nippns" value="${sessionScope.NipPnsSession}"/>
                            <input type="hidden" name="tingkatuser" value="${sessionScope.levelPemakaian}"/>
                        </ul>
                    </div>

                    <input type="hidden" id="session" name="session" /> 
                    <div id="contentdalamsub">
                        <table width="500" border="1" >

                            <tr>

                                <td  style="font-weight:normal; font-size: 12px" width="135" align="left">
                                    Kuantitas
                                </td>
                                <td>
                                    <input  id="kuantitasTahun" name="kuantitasTahun" value="${kuantitasTahun}" onkeypress="return alertnipnull3(event)" />
                                </td>
                                <td>
                                    <input  id="kuantitasBulanText" name="kuantitasBulanText" value="${kuantitasBulanText}" onkeypress="return alertnipnull3(event)" />
                                </td>
                                <td>
                                    <select id="kuantitas_bulan"  name="kuantitas_bulan" onchange="validasi4W1()" >

                                        <option value="-">-</option>
                                        <option value="0">0%</option>
                                        <option value="5">5%</option>
                                        <option value="10">10%</option>
                                        <option value="15">15%</option>
                                        <option value="20">20%</option>

                                        <option value="25">25%</option>
                                        <option value="30">30%</option>
                                        <option value="35">35%</option>
                                        <option value="40">40%</option>

                                        <option value="45">45%</option>
                                        <option value="50">50%</option>
                                        <option value="55">55%</option>
                                        <option value="60">60%</option>

                                        <option value="65">65%</option>
                                        <option value="70">70%</option>
                                        <option value="75">75%</option>
                                        <option value="80">80%</option>

                                        <option value="85">85%</option>
                                        <option value="90">90%</option>
                                        <option value="95">95%</option>
                                        <option value="100">100%</option>

                                    </select>
                                </td> 
                            </tr> 

                            <tr>
                                <td style="font-weight:normal; font-size: 12px" width="135" align="left">  
                                    Kualitas
                                </td>
                                <td>
                                    <input  id="kualitasTahun" name="kualitasTahun" value="${kualitasTahun}" onkeypress="return alertnipnull3(event)" />
                                </td>
                                <td>
                                    <input  id="kualitasBulanText" name="kualitasBulanText" value="${kualitasBulanText}" onkeypress="return alertnipnull3(event)" />
                                </td>
                                <td>
                                    <select id="kualitas_bulan"  name="kualitas_bulan" onchange="validasi4W2()" >

                                        <option value="-">-</option>
                                        <option value="0">0%</option>
                                        <option value="5">5%</option>
                                        <option value="10">10%</option>
                                        <option value="15">15%</option>
                                        <option value="20">20%</option>

                                        <option value="25">25%</option>
                                        <option value="30">30%</option>
                                        <option value="35">35%</option>
                                        <option value="40">40%</option>

                                        <option value="45">45%</option>
                                        <option value="50">50%</option>
                                        <option value="55">55%</option>
                                        <option value="60">60%</option>

                                        <option value="65">65%</option>
                                        <option value="70">70%</option>
                                        <option value="75">75%</option>
                                        <option value="80">80%</option>

                                        <option value="85">85%</option>
                                        <option value="90">90%</option>
                                        <option value="95">95%</option>
                                        <option value="100">100%</option>

                                    </select>
                                </td> 
                            </tr>
                            <tr>
                                <td style="font-weight:normal; font-size: 12px" width="135" align="left" >  
                                    Waktu
                                </td>
                                <td>
                                    <input  id="waktuTahun" name="waktuTahun" value="${waktuTahun}" onkeypress="return alertnipnull3(event)" />
                                </td>
                                <td>
                                    <input  id="waktuBulanText" name="waktuBulanText" value="${waktuBulanText}" onkeypress="return alertnipnull3(event)" />
                                </td>
                                <td>
                                    <select id="waktu_bulan"  name="waktu_bulan" onchange="validasi4W3()" >

                                        <option value="-">-</option>
                                        <option value="0">0%</option>
                                        <option value="5">5%</option>
                                        <option value="10">10%</option>
                                        <option value="15">15%</option>
                                        <option value="20">20%</option>

                                        <option value="25">25%</option>
                                        <option value="30">30%</option>
                                        <option value="35">35%</option>
                                        <option value="40">40%</option>

                                        <option value="45">45%</option>
                                        <option value="50">50%</option>
                                        <option value="55">55%</option>
                                        <option value="60">60%</option>

                                        <option value="65">65%</option>
                                        <option value="70">70%</option>
                                        <option value="75">75%</option>
                                        <option value="80">80%</option>

                                        <option value="85">85%</option>
                                        <option value="90">90%</option>
                                        <option value="95">95%</option>
                                        <option value="100">100%</option>

                                    </select>
                                </td> 
                            </tr>
                            <tr>
                                <td style="font-weight:normal; font-size: 12px" width="135" align="left">  
                                    Biaya
                                </td>
                                <td>
                                    <input  id="biayaTahun" name="biayaTahun" value="${biayaTahun}" onkeypress="return alertnipnull3(event)" />
                                </td>
                                <td>
                                    <input  id="biayaBulanText" name="biayaBulanText" value="${biayaBulanText}" onkeypress="return alertnipnull3(event)" />
                                </td>
                                <td>
                                    <select id="biaya_bulan"  name="biaya_bulan" onchange="validasi4W4()" >

                                        <option value="-">-</option>
                                        <option value="0">0%</option>
                                        <option value="5">5%</option>
                                        <option value="10">10%</option>
                                        <option value="15">15%</option>
                                        <option value="20">20%</option>

                                        <option value="25">25%</option>
                                        <option value="30">30%</option>
                                        <option value="35">35%</option>
                                        <option value="40">40%</option>

                                        <option value="45">45%</option>
                                        <option value="50">50%</option>
                                        <option value="55">55%</option>
                                        <option value="60">60%</option>

                                        <option value="65">65%</option>
                                        <option value="70">70%</option>
                                        <option value="75">75%</option>
                                        <option value="80">80%</option>

                                        <option value="85">85%</option>
                                        <option value="90">90%</option>
                                        <option value="95">95%</option>
                                        <option value="100">100%</option>

                                    </select>
                                </td>
                            </tr>
                        </table>

                        <table>
                            <tr>
                                <td> Bulan Ke </td>

                                <td>
                                    <input  id="bulankeText" name="bulankeText" value="${bulankeText}" onkeypress="return alertnipnull3(event)" />
                                </td>
                                <td> 
                                    <select id="bulan_ke"  name="bulan_ke" onchange="validasi4W_ke()" >

                                        <option value="-">-</option>
                                        <option value="01">KeSatu</option>
                                        <option value="02">KeDua</option>
                                        <option value="03">keTiga</option>
                                        <option value="04">keEmpat</option>
                                        <option value="05">keLima</option>

                                        <option value="06">KeEnam</option>
                                        <option value="07">KeTujuh</option>
                                        <option value="08">KeDelapan</option>
                                        <option value="09">KeSembilan</option>

                                        <option value="10">KeSepuluh</option>
                                        <option value="11">KeSebelas</option>
                                        <option value="12">KeDuabelas</option>

                                    </select>
                                </td>

                                <td >
                                    <input type="submit" name="param"  value="SIMPAN" />

                                </td>
                                <td>
                                    <input type="submit" name="param"  value="LIHAT" />

                                </td>

                                <td><a target="_blank" id="url3"  onclick="redirect3K()" title="Cetak"><center><img src="/SKPapplication/images/cetak.png"/></center></a></td>


                            <input type="hidden"  id="idtupoksidiSesiion" name="idtupoksidiSesiion" value="${idtupoksidijsp}" />
                            <input type="hidden"  name="_getidUnor4jspSesiion" value="${_getidUnor4jsp}" />
                            <input type="hidden"  id="getIdIsi4Faktor" name="getIdIsi4Faktor" value="${getIdIsi4Faktor}" />
                            <input type="hidden"  id="getId" name="getIdIsi4Faktor" value="${getIdbulan}" />


                            </tr>
                        </table>

                        <div class="scroll2" >
                            <table width="1080" >
                                <tr style="background: #ccccff">
                                    <th  style="font-weight:normal; font-size: 12px;background-color: #9999ff" width="31" rowspan="2" >NO</th>
                                    <th style="font-weight:normal; font-size: 12px ;background-color: #9999ff" rowspan="2" width="80">KODE</th>
                                    <th style="font-weight:normal; font-size: 12px ;background-color: #9999ff" rowspan="2" width="383" >NAMA URAIAN TUGAS</th>
                                    <th style="font-weight:normal; font-size: 12px ;background-color: #9999ff" colspan="6">TARGET BULANAN</th>

                                </tr>
                                <tr style="background: #FF9900">



                                    <th style="font-weight:normal; font-size: 12px ;background-color: #9999ff" width="105">KUANTITAS</th>
                                    <th style="font-weight:normal; font-size: 12px ;background-color: #9999ff" width="100">KUALITAS</th>
                                    <th style="font-weight:normal; font-size: 12px ;background-color: #9999ff" width="70">WAKTU</th>
                                    <th style="font-weight:normal; font-size: 12px ;background-color: #9999ff" width="136" >BIAYA</th>
                                    <th style="font-weight:normal; font-size: 12px ;background-color: #9999ff" width="70">BULAN KE</th>
                                    <th style="font-weight:normal; font-size: 12px ;background-color: #9999ff" width="31" >&nbsp;</th>  

                                </tr>


                                <c:forEach var="listTukesi" items="${isiTargetBulanan}" varStatus = "count">
                                    <c:choose>
                                        <c:when test="${count.index % 2 == 0}">
                                            <tr bgcolor="#b9c9fe">
                                                <td style="font-weight:normal; font-size: 12px"width="31"><div align="center">${(count.index)+1}</div></td>
                                                <td style="font-weight:normal; font-size: 12px" width="80"><div align="center"><a href ="LaporanBulananServlet?getidbulan=<c:out value="${listTukesi.getId()}"/>&getidIsi$faktorList=<c:out value="${getIdIsi4Faktor}"/>&getidITupoksiBulalanList=<c:out value="${idtupoksidijsp}"/>">${listTukesi.getId()}</a></div></td> 
                                                <td style="font-weight:normal; font-size: 12px"width="383"><div align="left">${listTukesi.getNamaTupoksi()} </div></td>


                                                <td style="font-weight:normal; font-size: 12px"width="105"><div align="right">${listTukesi.getkuantitas_bulan()} </div></td>
                                                <td style="font-weight:normal; font-size: 12px"width="100"><div align="right">${listTukesi.getkualitas_bulan()} </div></td>
                                                <td style="font-weight:normal; font-size: 12px"width="70"><div align="right">${listTukesi.getwaktu_bulan()}</div></td>
                                                <td style="font-weight:normal; font-size: 12px"width="136"><div align="right"> ${listTukesi.biaya_bulan()}</div></td>
                                                <td style="font-weight:normal; font-size: 12px"width="70"><div align="right">${listTukesi.bulanke()}</div></td>
                                                <td style="font-weight:normal; font-size: 12px"width="31"><div align="Left"><a href ="LaporanBulananServlet?getidbulanHapus=<c:out value="${listTukesi.getId()}"/>&getidIsi$faktorList=<c:out value="${getIdIsi4Faktor}"/>&getidITupoksiBulalanList=<c:out value="${idtupoksidijsp}"/>"><img src="images/hapus2.png"></img></a></div></td>

                                            </tr>
                                        </c:when>
                                        <c:otherwise>
                                            <tr bgcolor="#e8edff">
                                                <td style="font-weight:normal; font-size: 12px"width="31"><div align="center">${(count.index)+1}</div></td>
                                                <td style="font-weight:normal; font-size: 12px" width="80"><div align="center"><a href ="LaporanBulananServlet?getidbulan=<c:out value="${listTukesi.getId()}"/>&getidIsi$faktorList=<c:out value="${getIdIsi4Faktor}"/>&getidITupoksiBulalanList=<c:out value="${idtupoksidijsp}"/>">${listTukesi.getId()}</a></div></td> 
                                                <td style="font-weight:normal; font-size: 12px"width="383"><div align="left">${listTukesi.getNamaTupoksi()} </div></td>


                                                <td style="font-weight:normal; font-size: 12px"width="105"><div align="right">${listTukesi.getkuantitas_bulan()} </div></td>
                                                <td style="font-weight:normal; font-size: 12px"width="100"><div align="right">${listTukesi.getkualitas_bulan()} </div></td>
                                                <td style="font-weight:normal; font-size: 12px"width="70"><div align="right">${listTukesi.getwaktu_bulan()}</div></td>
                                                <td style="font-weight:normal; font-size: 12px"width="136"><div align="right"> ${listTukesi.biaya_bulan()}</div></td>
                                                <td style="font-weight:normal; font-size: 12px"width="70"><div align="right">${listTukesi.bulanke()}</div></td>
                                                <td style="font-weight:normal; font-size: 12px"width="31"><div align="Left"><a href ="LaporanBulananServlet?getidbulanHapus=<c:out value="${listTukesi.getId()}"/>&getidIsi$faktorList=<c:out value="${getIdIsi4Faktor}"/>&getidITupoksiBulalanList=<c:out value="${idtupoksidijsp}"/>"><img src="images/hapus2.png"></img></a></div></td>

                                            </tr>
                                        </c:otherwise>

                                    </c:choose>
                                </c:forEach>
                            </table>

                        </div>


                    </div>
                </div>


        </form>	

    </body>



    <script language="javascript" type="text/javascript">
        function redirect3K()
        {  
            var hr= "cetakIsi4FaktorServlet?nipBaruTargetBulan=<c:out value='${pns.getNipBaru()}'/>";
            idIsi4faktorBulan_TEXT=document.getElementById("getIdIsi4Faktor").value;
            idtupoksidiSesiion_TEXT=document.getElementById("idtupoksidiSesiion").value;
            //pilihan=document.getElementById("pilih_session").value;
            url3=document.getElementById("url3");
            //  url3.href=hr+"&tglCetak="+tglCetak; 
            url3.href=hr+"&idIsi4faktorBulan=" +idIsi4faktorBulan_TEXT+"&idtupoksidiSesiion_="+idtupoksidiSesiion_TEXT; 
        
          
        }
        
        function redirect4Kembali()
        {  
            var hr= "LaporanBulananServlet?nipBaruTargetBulanKembali=<c:out value='${pns.getNipBaru()}'/>";
            idIsi4faktorBulan_TEXT=document.getElementById("getIdIsi4Faktor").value;
            idtupoksidiSesiion_TEXT=document.getElementById("idtupoksidiSesiion").value;
            //pilihan=document.getElementById("pilih_session").value;
            url4=document.getElementById("url4");
            //  url3.href=hr+"&tglCetak="+tglCetak; 
            url4.href=hr+"&idIsi4faktorBulan=" +idIsi4faktorBulan_TEXT+"&idtupoksidiSesiion_="+idtupoksidiSesiion_TEXT; 
        
          
        }
        function alertnipnull3(evt)
        {
            evt = (evt) ? evt : window.event
            var charCode = (evt.which) ? evt.which : evt.keyCode
            if (charCode > 0) 
            {
        
                status = "This field accepts numbers only."
                return false
            }
    
            status = ""
            return true
        }
        function peringatan(){
            var pupup = document.getElementById("alerting"); 
            if(pupup.value != null||pupup.value != ""){
                alert("Data Berhasil diupdate!");
                return true;
            }else{
                alert("Data Berhasil diupdate!");
                return false;
            }
        }
        
        function validasi4W4 (){
            var vbiaya4text =document.getElementById("biaya_bulan");
            var ddtk = vbiaya4text.options[vbiaya4text.selectedIndex].value;
            document.getElementById("biayaBulanText").value = ddtk;
        };
        function validasi4W3 (){
            var vbiaya4text =document.getElementById("waktu_bulan");
            var ddtk = vbiaya4text.options[vbiaya4text.selectedIndex].value;
            document.getElementById("waktuBulanText").value = ddtk;
        };
        function validasi4W2 (){
            var vbiaya4text =document.getElementById("kualitas_bulan");
            var ddtk = vbiaya4text.options[vbiaya4text.selectedIndex].value;
            document.getElementById("kualitasBulanText").value = ddtk;
        };
        function validasi4W1 (){
            var vbiaya4text =document.getElementById("kuantitas_bulan");
            var ddtk = vbiaya4text.options[vbiaya4text.selectedIndex].value;
            document.getElementById("kuantitasBulanText").value = ddtk;
        };
        function validasi4W_ke (){
            var vbiaya4text =document.getElementById("bulan_ke");
            var ddtk = vbiaya4text.options[vbiaya4text.selectedIndex].value;
            document.getElementById("bulankeText").value = ddtk;
        };
    </script>
</html>
