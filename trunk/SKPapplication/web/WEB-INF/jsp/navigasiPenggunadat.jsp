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

<script language="javascript" type="text/javascript">
    function validasi4W (){
        var vbiaya4text =document.getElementById("pilih_sessionw");
        var ddtk = vbiaya4text.options[vbiaya4text.selectedIndex].text;
        document.getElementById("sessionw").value = ddtk;
    };   
 
    function validate(evt) {
    <%-- 
    var theEvent = evt || window.event;
     var key = theEvent.keyCode || theEvent.which;
     key = String.fromCharCode( key );
     var regex = /[0-9]|\./;
     if( !regex.test(key) ) {
         theEvent.returnValue = false;
         if(theEvent.preventDefault) theEvent.preventDefault();
    --%>
            var panjangkata = evt.length
            var unicode=evt.charCode? evt.charCode : evt.keyCode 
            if (unicode!=8){ //if the key isn't the backspace key (which we should allow)
                if ((unicode<48||unicode>57)) //if not a number
                    return false //disable key press
            }     
        };
        function ButtonBackNit()
        {
            pilihan=document.getElementById("pilih_session_monit");
            var pilihanSelected = pilihan.options[pilihan.selectedIndex].text;
            location = 'isiPerilakuServlet?nipatasanMonitoring2=<c:out value="${nipAtasan}"/>&pilih_session_monit='+pilihanSelected;
        };
    
        function ButtoncarinipMonitoring()
        {
            pilihan=document.getElementById("pilih_session_monit");
            var nipatasanMonitoring2 = document.getElementById("nipAtasan");
            nipatasanMonitoring2.value.text;
            statusbutton=document.getElementById("statusbutton");
            statusbutton.value = "cari";
            var pilihanSelected = pilihan.options[pilihan.selectedIndex].text;
            location = 'isiPerilakuServlet?nipatasanMonitoring2='+nipatasanMonitoring2+'&statusbutton='+statusbutton+'&pilih_session_monit='+pilihanSelected;
        };
    
        function ButtonBackNitView()
        {
            pilihan=document.getElementById("pilih_session_monit");
            var pilihanSelected = pilihan.options[pilihan.selectedIndex].text;
            location = 'isiPerilakuServlet?nipatasanMonitoringView=<c:out value="${nipAtasan}"/>&pilih_session_monit='+pilihanSelected;
        };
    
        function ButtonBackCetak()
        {
            pilihan=document.getElementById("pilih_session_monit");
            var pilihanSelected = pilihan.options[pilihan.selectedIndex].text;
            location = 'cetakIsi4FaktorServlet?nipatasanMonitoringCetak=<c:out value="${nipAtasan}"/>&pilih_session_monit='+pilihanSelected ;
        };
        function validasi4Monitor(){
            var vbiaya4text =document.getElementById("pilih_session_monit");
            var ddtk = vbiaya4text.options[vbiaya4text.selectedIndex].text;
            //   document.getElementById("session").value = ddtk;
        }; 
        function validasitestMonitor(){ 
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
        function redirect()
        {
            pilihan=document.getElementById("pilih_session");
            var pilihanSelected = pilihan.options[pilihan.selectedIndex].text;
            url=document.getElementById("url");   
            url.href=url.href+"&pilih_session=" + pilihanSelected;    
        };

        function onchangecombo()
        {
            document.getElementById("button1").style.bgColor = 0xFFFF00;
    
            var vbiaya4text =document.getElementById("pilih_session");
            var ddtk2 = vbiaya4text.options[vbiaya4text.selectedIndex].text;
            //  document.getElementById("session").value = ddtk2;
    
            //    var e2 = document.getElementById("idKreaf");
            //   var ddtk2 = e2.value;
    
            // var e = document.getElementById("koef_kreatifitas");
            // var ddtk = e.options[e.selectedIndex].text;

            location = 'tupoksiServlet2?action=HitungtupoksiServlet2&txtNIPBaru=<c:out value="${pns.getNipBaru()}"/>&jenis=<c:out value="${pns.getjnsjbtn_id()}"/>&pilih_session='+ddtk2;
            document.getElementById("button1").style.backgroundColor = '#FFFF00';

        };
          
</script>
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
        <div id="headerLokalUtama">
            <%@ include file="SlindronHeader.jsp" %>

        </div>   
        <div id="wrapperUtama">


            <input type="hidden" name="nippns" value="${sessionScope.user}"/>
            <input type="hidden" name="nippns" value="${sessionScope.NipPnsSession}"/>
            <input type="hidden" name="tingkatuser" value="${sessionScope.levelPemakaian}"/>



            <%-- ===================================== ======================================================	--%>      
            <c:set var="navigasi_pilihan" value="${navigasiPilihan}" />   
            <div id="content50">
                <c:if test="${navigasi_pilihan =='0'}">
                    <div style ="height: 300px;overflow: auto">

                        <table style="margin-top: 0px ;font-size: 12px">
                            <td style="font-size: 12px; width:500px; font-family: sans-serif; text-align: center; font: bold ">

                                <table style="padding-top:0px">
                                    <tr style="padding-top: 0px">
                                        <td style="font-weight:normal; font-size: 12px"width="30"><div align="left"><span class="style3">1</span></div></td>
                                        <td style="font-weight:normal; font-size: 12px"width="135" align="left"><span class="style3">Nama</span></td>
                                        <td>:</td>
                                        <td style="font-weight:normal; font-size: 12px"width="414" align="left"> <c:out value="${UnorAts.getNamaPns()}" /> </td>
                                    </tr>
                                    <tr tr style="padding-top: 0px">
                                        <td style="font-weight:normal; font-size: 12px"><div align="left"><span class="style3">2</span></div></td>
                                        <td style="font-weight:normal; font-size: 12px"align="left"><span class="style3">NIP</span></td>
                                        <td>:</td>

                                        <td style="font-weight:normal; font-size: 12px"align="left"><c:out value="${UnorAts.getNipBaru()}" /> </td>
                                    </tr>
                                    <tr style="padding-top: 0px ">
                                        <td style="font-weight:normal; font-size: 12px"><div align="left"><span class="style3">3</span></div></td>
                                        <td style="font-weight:normal; font-size: 12px"align="left"><span class="style3">Pangkat/Gol.Ruang</span></td>
                                        <td>:</td>
                                        <td style="font-weight:normal; font-size: 12px"align="left"><c:out value="${UnorAts.getPangkat()}" /> / <c:out value="${UnorAts.getNamaGolru()}" /></td>
                                    </tr>
                                    <tr   style="padding-top : 0px">
                                        <td style="font-weight:normal; font-size: 12px"><div align="left"><span class="style3">4</span></div></td>
                                        <td style="font-weight:normal; font-size: 12px"align="left"><span class="style3">Jabatan</span></td>
                                        <td>:</td>
                                        <td style="font-weight:normal; font-size: 12px"align="left"><c:out value="${UnorAts.getNamaJabatan()}" /></td>
                                    </tr> <tr  style="padding-top: 0px">
                                        <td style="font-weight:normal; font-size: 12px"<div align="left"><span class="style3">5</span></div></td>
                                        <td style="font-weight:normal; font-size: 12px" align="left"><span class="style3">Unit Kerja </span></td>
                                        <td>:</td>
                                        <td style="font-weight:normal; font-size: 12px"align="left"><c:out value="${UnorAts.getNamaUnor()}" /></td>
                                    </tr>

                                </table>
                            </td>       
                            <%-- ===================================== USER ======================================================	--%>			

                            <td  style="font-size: 12px; width:500px; padding-top: 0px;font-family: sans-serif; text-align: center; font: bold "> 
                                <table  style="padding-top:0px" >
                                    <tr  style="padding-top: 0px">
                                        <td style="font-weight:normal; font-size: 12px" width="30"><div align="left"><span class="style3">1</span></div></td>
                                        <td style="font-weight:normal; font-size: 12px" width="135" align="left"><span class="style3">Nama</span></td>
                                        <td>:</td>
                                        <td style="font-weight:normal; font-size: 12px"width="414" align="left"> <c:out value="${pns.getNamaPns()}"/> </td>
                                    </tr>
                                    <tr style="padding-top: 0px">
                                        <td style="font-weight:normal; font-size: 12px"><div align="left"><span class="style3">2</span></div></td>
                                        <td style="font-weight:normal; font-size: 12px"align="left"><span class="style3">NIP</span></td>
                                        <td>:</td>
                                        <td style="font-weight:normal; font-size: 12px"align="left"><c:out value="${pns.getNipBaru()}" /></td>


                                    <input  type="hidden"  name="_getInstansi" id="_getInstansi" value="${pns.getNipBaru()}"></input>
                                    <input  type="hidden"  name="_getidUnor"  id="_getidUnor" value="${pns.getUnorId()}">

                                    </tr>

                                    <tr style="padding-top: 0px"> <td style="font-weight:normal; font-size: 12px"><div align="left"><span class="style3">3</span></div></td>
                                        <td style="font-weight:normal; font-size: 12px"align="left"><span class="style3">Pangkat/Gol.Ruang</span></td>
                                        <td>:</td>
                                        <td style="font-weight:normal; font-size: 12px"align="left"><c:out value="${pns.getPangkat()}" /> / <c:out value="${pns.getNamaGolru()}" /></td>
                                    </tr>
                                    <tr style="padding-top: 0px">
                                        <td style="font-weight:normal; font-size: 12px"><div align="left"><span class="style3">4</span></div></td>
                                        <td style="font-weight:normal; font-size: 12px"align="left"><span class="style3">Jabatan</span></td>
                                        <td>:</td>
                                        <td style="font-weight:normal; font-size: 12px"align="left"><c:out value="${pns.getNamaJabatan()}" /></td>
                                    </tr>
                                    <tr style="padding-top: 0px">
                                        <td style="font-weight:normal; font-size: 12px"><div align="left"><span class="style3">5</span></div></td>
                                        <td style="font-weight:normal; font-size: 12px"align="left"><span class="style3">Unit Kerja </span></td>
                                        <td>:</td>
                                        <td style="font-weight:normal; font-size: 12px"align="left"><c:out value="${pns.getNamaUnor()}" /> </td>

                                    </tr>

                                </table>

                            </td>

                        </table>

                    </div>
                    <div id="graph">
                        <div id="chartContainer20"></div>  
                    </div>            

                    <style type="text/css"> 
                        /*=======================Monitoring*/
                        #graph {

                            position :  absolute;
                            top : 145px;
                            left : 10px;
                            width : 400px;
                            height : 250px;
                            overflow: auto;

                        }	 </style>




                    <script>
                        $(document).ready(
                        function() {
                   

                            $("#chartContainer20").insertFusionCharts({
                                type: "MSColumn3D",
                                width: "350",
                                height: "250",
                               
                                dataFormat: "json",
                                dataSource: {
                                    "chart":{
                                        "caption":"Grafik Capaian Kinerja ",
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
                                                    "label":"Kinerja"
                                                },
                                                {
                                                    "label":"Prilaku"
                                                }
                                            ]
                                        }
                                    ],
                                    "dataset":[
                                        {
                                            "seriesname":"Nilai Capaian Prestasi",
                                            "color":"AFD8F8",
                                            "data":[
                                                {
                                                    "value":"${nilaiSKP}"
                                                },
                                                {
                                                    "value":"${ratarata}"
                                                }
                                            ]
                                        },
                                        {
                                            "seriesname":"Standarisasi_prestasi",
                                            "color":"F6BD0F",
                                            "data":[
                                                {
                                                    "value":"76"
                                                },
                                                {
                                                    "value":"76"
                                                }
                                            ]
                                        }
                            
                                    ]
                                }
                            });	
                        });
                    </script>



                </c:if>
                <style type="text/css">
                    #menu2 {
                        position: relative;
                        width: 990px;
                        height: 40px;
                        background: #9999CC;
                        font-family: arial;
                        padding-left: 2px;
                    }

                    #menu2 ul li a:hover {
                        background-color: #CCCCFF;
                        color: #FF0000;
                    }

                </style>
                
                <c:if test="${navigasi_pilihan =='3' || navigasi_pilihan =='1' || navigasi_pilihan =='2'}">


                    <c:set var="navigasi_pilihan" value="${navigasiPilihan}" />    

                    <div id="menu2">
                        <ul>
                            <li>
                                <%-- <a href="GetPnsServlet?txtNIPBaruB=<c:out value="${pns.getNipBaru()}"/>"class="current_page_item" target="_parent" title="Target Sasaran SKI"><span></span>Target</a> --%>
                                <c:set var="sesiontahun" value="${sesiontahun}" /> 
                                <a href="GetPnsServlet?action=HitungtupoksiServlet3&txtNIPBaruB=<c:out value="${pns.getNipBaru()}"/>&menutarget=ada" id="url" onclick="redirect2()"  target="_parent" >Target</a>
                            </li>
                            <li><a href="GetPnsServlet?txtNIPBaru=<c:out value="${pns.getNipBaru()}"/>&pilih_session=<c:out value="${sesiontahun}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>"  target="_parent" ><span></span>Realisasi</a></li> 


                            <li>        
                                <input type="text" id="session" name="session" value="${sesiontahun}" /> 
                            </li>

                            <li> 
                                <select id="pilih_session"  name="pilih_session" onchange="validasi4()" >
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
                            </li>

                            <li><a href="RequestServlet?page=indexloginBaru" target="_parent" title="Keluar"><span></span>Kembali</a></li>
                        </ul>

                    </div>

                    <div id="pageTarget">
                        <c:if test="${navigasi_pilihan =='3'}">
                            <table>
                                <td>   
                                    <input type="text" id="nipInputan" name="nipInputan" on maxlength="18"  /> 
                                </td>
                                <td>
                                    <a id="urlNip"  title="cariNip" onclick="redirectNip()"><img src="images/ubah2.png"/></a>
                                </td>
                            </table>
                        </c:if>


                        <table>
                            <td style="width: 500px">
                                <table>

                                    <tr>                       
                                        <td style="font-weight:normal; font-size: 12px" width="30"><div align="left">1</div></td>
                                        <td style="font-weight:normal; font-size: 12px"width="135" align="left">Nama</td>
                                        <td>:</td>
                                        <td style="font-weight:normal; font-size: 12px"align="left"> <c:out value="${UnorAts.getNamaPns()}" /> </td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:normal; font-size: 12px"><div align="left">2</div></td>
                                        <td style="font-weight:normal; font-size: 12px" align="left">NIP</td>
                                        <td>:</td>

                                        <td style="font-weight:normal; font-size: 12px"align="left"><c:out value="${UnorAts.getNipBaru()}" /> <a href="updateServlets?instansiAtasan=<c:out value="${ UnorAts.getInstansiId()}"/>&unoratasanlama=<c:out value="${ UnorAts.getNamaUnor()}"/>&nipatasanlama=<c:out value="${ UnorAts.getNipBaru()}"/>&nip_baruuser=<c:out value="${NipPnsSession}"/>&instansiIdpns=<c:out value="${pns.getNipBaru()}"/>&instansiIdunorbwhan=<c:out value="${pns.getUnorId()}"/>">  <img src="images/ubah2.png"/> </a></td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:normal; font-size: 12px"><div align="left">3</div></td>
                                        <td style="font-weight:normal; font-size: 12px"align="left">Pangkat/Gol.Ruang</td>
                                        <td>:</td>
                                        <td style="font-weight:normal; font-size: 12px" align="left"><c:out value="${UnorAts.getPangkat()}" /> / <c:out value="${UnorAts.getNamaGolru()}" /></td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:normal; font-size: 12px"><div align="left">4</div></td>
                                        <td style="font-weight:normal; font-size: 12px"align="left">Jabatan</td>
                                        <td>:</td>
                                        <td style="font-weight:normal; font-size: 12px"align="left"><c:out value="${UnorAts.getNamaJabatan()}" /></td>
                                    </tr> <tr>
                                        <td style="font-weight:normal; font-size: 12px"><div align="left">5</div></td>
                                        <td style="font-weight:normal; font-size: 12px"align="left">Unit Kerja </td>
                                        <td>:</td>
                                        <td style="font-weight:normal; font-size: 12px"align="left"><c:out value="${UnorAts.getNamaUnor()}" /></td>
                                    </tr>

                                </table>
                                <%-- ===================================== USER ======================================================	--%>			
                            </td>

                            <td>
                                <table >
                                    <tr>
                                        <td style="font-weight:normal; font-size: 12px"width="30"><div align="left">1</div></td>
                                        <td style="font-weight:normal; font-size: 12px"width="135" align="left">Nama</td>
                                        <td>:</td>
                                        <td style="font-weight:normal; font-size: 12px"align="left"> <c:out value="${pns.getNamaPns()}"/> </td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:normal; font-size: 12px"><div align="left">2</div></td>
                                        <td style="font-weight:normal; font-size: 12px"align="left">NIP</td>
                                        <td>:</td>
                                        <td style="font-weight:normal; font-size: 12px"align="left"><c:out value="${pns.getNipBaru()}" /></td>


                                    <input  type="hidden"  name="_getInstansi" id="_getInstansi" value="${pns.getNipBaru()}"></input>
                                    <input  type="hidden"  name="_getidUnor"  id="_getidUnor" value="${pns.getUnorId()}">

                                    </tr>

                                    <tr> <td style="font-weight:normal; font-size: 12px"><div align="left">3</div></td>
                                        <td style="font-weight:normal; font-size: 12px"align="left">Pangkat/Gol.Ruang</td>
                                        <td>:</td>
                                        <td style="font-weight:normal; font-size: 12px"align="left"><c:out value="${pns.getPangkat()}" /> / <c:out value="${pns.getNamaGolru()}" /></td>
                                    </tr>
                                    <tr>
                                        <td><div style="font-weight:normal; font-size: 12px" align="left">4</div></td>
                                        <td align="left" style="font-weight:normal; font-size: 12px"align="left">Jabatan</td>
                                        <td>:</td>
                                        <td align="left" style="font-weight:normal; font-size: 12px"align="left"><c:out value="${pns.getNamaJabatan()}" /></td>
                                        <td><a href="updateServlets?NIPBaruUbahjabatan=<c:out value="${pns.getNipBaru()}"/>">  <img src="images/ubah2.png"/> </a></td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:normal; font-size: 12px"><div align="left">5</div></td>
                                        <td style="font-weight:normal; font-size: 12px" align="left">Unit Kerja </td>
                                        <td>:</td>
                                        <td style="font-weight:normal; font-size: 12px"align="left"><c:out value="${pns.getNamaUnor()}" /> 
                                        </td><td><a href="updateServlets?txtNIPBaru=<c:out value="${pns.getNipBaru()}"/>">  <img src="images/ubah2.png"/> </a></td>

                                    </tr>

                                </table>
                            </td>
                        </table>



                    </div>
                    <div id="page-bottomBaru">

                        <div class="scroll2" >
                            <table width="1080" >
                                <tr style="background: #ccccff">
                                    <th  style="font-weight:normal; font-size: 12px;background-color: #9999ff" width="31" rowspan="2" >NO</th>
                                    <th style="font-weight:normal; font-size: 12px ;background-color: #9999ff" rowspan="2" width="80">KODE</th>
                                    <th style="font-weight:normal; font-size: 12px ;background-color: #9999ff" rowspan="2" width="383" >KEGIATAN TUGAS JABATAN</th>
                                    <th style="font-weight:normal; font-size: 12px ;background-color: #9999ff" colspan="6">TARGET</th>

                                </tr>
                                <tr style="background: #FF9900">


                                    <th style="font-weight:normal; font-size: 12px ;background-color: #9999ff" width="70">AK</th>
                                    <th style="font-weight:normal; font-size: 12px ;background-color: #9999ff" width="105">KUANT/ OUTPUT</th>
                                    <th style="font-weight:normal; font-size: 12px ;background-color: #9999ff" width="100">KUAL/ MUTU</th>
                                    <th style="font-weight:normal; font-size: 12px ;background-color: #9999ff" width="70">WAKTU</th>
                                    <th style="font-weight:normal; font-size: 12px ;background-color: #9999ff" width="136" >BIAYA</th>
                                    <th style="font-weight:normal; font-size: 12px ;background-color: #9999ff" width="31" >&nbsp;</th>  
                                </tr>

                                <c:forEach var="listTukesi" items="${tukesiServlet}" varStatus = "count">
                                    <c:choose>
                                        <c:when test="${count.index % 2 == 0}">
                                            <tr bgcolor="#b9c9fe">
                                                <td style="font-weight:normal; font-size: 12px"width="31"><div align="center">${(count.index)+1}</div></td>
                                                <td style="font-weight:normal; font-size: 12px" width="80"><div align="center"><a href ="Isi4FaktorServlet?nipnilai=<c:out value="${pns.getNipBaru()}"/>&pilih_session=${sesiontahun}&_idUnor=<c:out value="${pns.getUnorId()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>&getIdIsi4Faktor=<c:out value="${listTukesi.getIdIsi4Faktor()}"/>">${listTukesi.getIdTupoksi()}</a></div></td>
                                                <td style="font-weight:normal; font-size: 12px"width="383"><div align="left">${listTukesi.getNamaTupoksi()} </div></td>
                                                <td style="font-weight:normal; font-size: 12px"width="70"><div align="right">${listTukesi.getangka_krdtR()}</div></td>
                                                <td style="font-weight:normal; font-size: 12px"width="105"><div align="right">${listTukesi.getKuantitas4()} ${listTukesi.getkuantitas_label()} </div></td>
                                                <td style="font-weight:normal; font-size: 12px"width="100"><div align="right">${listTukesi.getKualitas4()} %</div></td>
                                                <td style="font-weight:normal; font-size: 12px"width="70"><div align="right">${listTukesi.getWaktu4()} ${listTukesi.getwaktu_label()} (${listTukesi.getpilih_session()})</div></td>
                                                <td style="font-weight:normal; font-size: 12px"width="136"><div align="right">Rp. ${listTukesi.getBiaya4()}</div></td>
                                                <td style="font-weight:normal; font-size: 12px"width="31"><div align="Left"><a href="Isi4FaktorServlet?idTupoksiHapus=<c:out value="${listTukesi.getIdTupoksi()}"/>&pilih_session=${sesiontahun}&nipHapus=<c:out value="${pns.getNipBaru()}"/>"><img src="images/hapus2.png"></img></a></div></td>
                                            </tr>
                                        </c:when>
                                        <c:otherwise>
                                            <tr bgcolor="#e8edff">
                                                <td style="font-weight:normal; font-size: 12px"width="31"><div align="center">${(count.index)+1}</div></td>
                                                <td style="font-weight:normal; font-size: 12px"width="80"><div align="center"><a href ="Isi4FaktorServlet?nipnilai=<c:out value="${pns.getNipBaru()}"/>&pilih_session=${sesiontahun}&_idUnor=<c:out value="${pns.getUnorId()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>&getIdIsi4Faktor=<c:out value="${listTukesi.getIdIsi4Faktor()}"/>">${listTukesi.getIdTupoksi()}</a></div></td>
                                                <td style="font-weight:normal; font-size: 12px"width="383"><div align="left">${listTukesi.getNamaTupoksi()}</div></td>
                                                <td style="font-weight:normal; font-size: 12px"width="70"><div align="right">${listTukesi.getangka_krdtR()}</div></td>
                                                <td style="font-weight:normal; font-size: 12px"width="105"><div align="right">${listTukesi.getKuantitas4()} ${listTukesi.getkuantitas_label()} </div></td>
                                                <td style="font-weight:normal; font-size: 12px"width="100"><div align="right">${listTukesi.getKualitas4()} %</div></td>
                                                <td style="font-weight:normal; font-size: 12px"width="70"><div align="right">${listTukesi.getWaktu4()} ${listTukesi.getwaktu_label()} (${listTukesi.getpilih_session()}) </div></td>
                                                <td style="font-weight:normal; font-size: 12px"width="136"><div align="right">Rp. ${listTukesi.getBiaya4()}</div></td>
                                                <td style="font-weight:normal; font-size: 12px"width="31"><div align="Left"><a href="Isi4FaktorServlet?idTupoksiHapus=<c:out value="${listTukesi.getIdTupoksi()}"/>&pilih_session=${sesiontahun}&nipHapus=<c:out value="${pns.getNipBaru()}"/>"><img src="images/hapus2.png"></img></a></div></td>
                                            </tr>
                                        </c:otherwise>

                                    </c:choose>
                                </c:forEach>
                            </table>
                        </div>

                        <table >

                            <tr>
                                <td>
                                    <%-- <a href="tupoksiServlet2?txtNIPBaru=<c:out value="${pns.getNipBaru()}"/>&_idUnorTambah=<c:out value="${pns.getUnorId()}"/>&jenis=<c:out value="${pns.getjnsjbtn_id()}"/>"><img src="images/tambah.png"/></a>   --%>
                                    <%-- <a href="GetPnsServlet?action=HitungtupoksiServlet3&txtNIPBaruB=<c:out value="${pns.getNipBaru()}"/>" id="url" onclick="redirect2()"class="current_page_item" target="_parent" title="Target Sasaran SKI">Target</a> --%>
                                    <a href="tupoksiServlet2?txtNIPBaru=<c:out value="${pns.getNipBaru()}"/>&_idUnorTambah=<c:out value="${pns.getUnorId()}"/>&jenis=<c:out value="${pns.getjnsjbtn_id()}"/>&sesiontahun=${sesiontahun}" id="urltest" onclick="redirect_testt()"><img src="images/tambah.png"/></a>
                                </td>

                                <td>
                                    <%--     <a href="cetakIsi4FaktorServlet?nipnilai2=<c:out value="${pns.getNipBaru()}"/>&target=target" target="_blank" title="Cetak"><img src="images/cetak.png"/></a> --%>



                                    <a id="url3" target="_blank"  title="Cetak" onclick="redirect3()"><img src="images/cetak.png"/></a>
                                </td>
                                <td align="left"><span class="style3">Tgl Cetak </span></td>
                                <td>   
                                    &nbsp;  &nbsp; <input type="text" id="tglCetak" name="tglCetak" on maxlength="8" onfocus="clearText2()" onblur="clearText()"  onkeypress="return alertnipnull3(event)"/> 
                                </td>
                               
                                <td> DDMMYYYY</td>
                                <%--   
                                   <td>
                                       <a href="realisasiBaru2.jsp"><img src="images/cari.png"/></a>
                                   </td>
                                --%>  

                            </tr>
                        </table>

                    </div>
                </c:if> 
                <c:if test="${navigasi_pilihan =='44' }">
                    <div id="menu2">
                        <ul>
                            <li><a href="GetPnsServlet?txtNIPBaruB=<c:out value="${pns.getNipBaru()}"/>&pilih_session=<c:out value="${sesiontahun}"/>" target="_parent" title="Target Sasaran SKI">TARGET</a>
                                <%--   <li><a href="GetPnsServlet?txtNIPBaru=<c:out value="${pns.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>" class="current_page_item" target="_parent" title="Realisasi Capaian SKI">REALISASI</a> --%>
                            <li> <a href="GetPnsServlet?txtNIPBaru=<c:out value="${pns.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getId_tupoksi()}"/>" class="current_page_item" target="_parent" title="Realisasi Capaian SKI" id="url" onclick="redirect2K()">REALISASI</a>  
                            <li>
                                <input type="text" id="sessionw" name="sessionw" value="${sesiontahun}"/> 
                            </li>
                            <li>
                                <select id="pilih_sessionw"  name="pilih_sessionw" onchange="validasi4W()" >
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
                            </li>

                            <li><a href="RequestServlet?page=indexloginBaru" target="_parent" title="Keluar">Kembali</a>
                                <c:if test="${pns.getjnsjbtn_id() == '1'}">
                                <li> <a href="isiPerilakuServlet?nipAtasan=<c:out value="${pns.getNipBaru()}"/>">Persetujuan</a></li>

                                <li><a href="isiPerilakuServlet?nipnilaiPrilaku=<c:out value="${pns.getNipBaru()}"/>">PERILAKU</a></li>
                            </c:if>
                            <li>  <a href="RequestServlet?page=indexKeberatanPns">KEBERATAN</a></li>

                        </ul>
                    </div>

                    <div id="page-bottomBaru">
                        <div>REALISASI</div>

                        <div class="scroll3" id="hof">

                            <table>
                                <tr style="background:#9999ff">
                                    <th style="font-weight:normal; font-size: 12px" width="38" rowspan="2" >NO</th>
                                    <th style="font-weight:normal; font-size: 12px" rowspan="2" width="66">KODE</th>
                                    <th style="font-weight:normal; font-size: 12px" rowspan="2" width="211">KEGIATAN TUGAS POKOK JABATAN</th>
                                    <th style="font-weight:normal; font-size: 12px" colspan="5">TARGET</th>
                                    <th style="font-weight:normal; font-size: 12px" colspan="4">REALISASI</th>
                                    <th style="font-weight:normal; font-size: 12px" width="80" rowspan="2">PENGHITUNGAN</th>
                                    <th style="font-weight:normal; font-size: 12px" width="80" rowspan="2">PENCAPAIAN</th>

                                </tr>

                                <tr style="background: #9999ff">
                                    <th style="font-weight:normal; font-size: 12px" width="51">AK</th>
                                    <th style="font-weight:normal; font-size: 12px" width="85">KUANT/ OUTPUT</th>
                                    <th style="font-weight:normal; font-size: 12px" width="78">KUAL/ MUTU</th>
                                    <th style="font-weight:normal; font-size: 12px" width="68">WAKTU</th>
                                    <th style="font-weight:normal; font-size: 12px" width="91" >BIAYA</th>

                                    <th style="font-weight:normal; font-size: 12px" width="85">KUANT/ OUTPUT</th>
                                    <th style="font-weight:normal; font-size: 12px" width="78">KUAL/ MUTU</th>
                                    <th style="font-weight:normal; font-size: 12px" width="68">WAKTU</th>
                                    <th style="font-weight:normal; font-size: 12px" width="95" >BIAYA</th>
                                </tr>
                                <c:forEach var="listTukesi" items="${realkesiServlet}" varStatus ="count">
                                    <c:choose>
                                        <c:when test="${count.index % 2 == 0}">
                                            <tr bgcolor="#b9c9fe">

                                                <td style="font-weight:normal ; font-size: 12px" width="38" align="center">${(count.index)+1}</td>
                                                <td  style="font-weight:normal; font-size: 12px" width="66" align="center"> <div align="center"><a href ="Isi4FaktorServlet?nipnilaiR=<c:out value="${pns.getNipBaru()}"/>&pilih_session=<c:out value="${sesiontahun}"/>&idTupoksiR=<c:out value="${listTukesi.getId_tupoksi()}"/>">${listTukesi.getId_tupoksi()}</a></div></td>
                                                <td style="font-weight:normal; font-size: 12px" width="211" align="left">${listTukesi.getNama_tupoksi()}</td>
                                                <td style="font-weight:normal; font-size: 12px" width="51" align="left">${listTukesi.getangkaKrdt4()}</td>
                                                <c:if test="${(listTukesi.getvar_perubahan1())=='u'}">
                                                    <td style="font-weight:normal; font-size: 12px"width="85" align="center"><strike>${listTukesi.getKuantitas4()} ${listTukesi.getKuantitas_label()}</strike></td>
                                                </c:if>
                                                <c:if test="${(listTukesi.getvar_perubahan1())!='u'}">
                                                <td style="font-weight:normal; font-size: 12px"width="85" align="center">${listTukesi.getKuantitas4()} ${listTukesi.getKuantitas_label()}</td>
                                            </c:if>

                                            <c:if test="${(listTukesi.getvar_perubahan2())=='u'}">
                                                <td style="font-weight:normal; font-size: 12px"width="78" align="center"><strike>${listTukesi.getKualitas4()} %</strike></td>
                                            </c:if>
                                            <c:if test="${(listTukesi.getvar_perubahan2())!='u'}">
                                                <td style="font-weight:normal; font-size: 12px"width="78" align="center">${listTukesi.getKualitas4()} %</td>
                                            </c:if>  
                                            <c:if test="${(listTukesi.getvar_perubahan3())=='u'}">
                                                <td style="font-weight:normal; font-size: 12px"width="68"align="center"><strike>${listTukesi.getWaktu4()} ${listTukesi.getWaktu_label()}</strike> </td>
                                            </c:if>

                                            <c:if test="${(listTukesi.getvar_perubahan3())!='u'}">
                                                <td style="font-weight:normal; font-size: 12px"width="68"align="center">${listTukesi.getWaktu4()} ${listTukesi.getWaktu_label()}</td>
                                            </c:if>
                                            <c:if test="${(listTukesi.getvar_perubahan4())=='u'}">

                                                <td style="font-weight:normal; font-size: 12px" width="91" align="center"><strike>Rp. ${listTukesi.getBiaya4()}</strike></td>
                                            </c:if>

                                            <c:if test="${(listTukesi.getvar_perubahan4())!='u'}">

                                                <td style="font-weight:normal; font-size: 12px" width="91" align="center">Rp. ${listTukesi.getBiaya4()}</td>
                                            </c:if>
                                            <%--<td align="left">${listTukesi.getangkaKrdtr()}</td>--%>

                                            <c:choose>
                                                <c:when test="${(listTukesi.getvar_perubahan1()=='u' || listTukesi.getvar_perubahan2()=='u' || listTukesi.getvar_perubahan3()=='u' || listTukesi.getvar_perubahan4()=='u' )}">



                                                    <td style="font-weight:normal; font-size: 12px"width="85" align="center">"-"</td>
                                                    <td style="font-weight:normal; font-size: 12px"width="78" align="center">"-"</td>
                                                    <td style="font-weight:normal; font-size: 12px"width="68" align="center">"-"</td>                        
                                                    <td style="font-weight:normal; font-size: 12px"width="95" align="center">"-"</td>                       
                                                    <td style="font-weight:normal; font-size: 12px"width="80" align="center">"-"</td>
                                                    <td style="font-weight:normal; font-size: 12px"width="80" align="center">"-"</td>
                                                </c:when>     
                                                <c:otherwise>
                                                    <td style="font-weight:normal; font-size: 12px"width="85" align="center">${listTukesi.getKuantitasr()} ${listTukesi.getKuantitas_label()}</td>
                                                    <td style="font-weight:normal; font-size: 12px"width="78" align="center">${listTukesi.getKualitasr()} %</td>
                                                    <td style="font-weight:normal; font-size: 12px"width="68" align="center">${listTukesi.getWaktur()} ${listTukesi.getWaktu_label()}</td>                        
                                                    <td style="font-weight:normal; font-size: 12px"width="95" align="center">Rp. ${listTukesi.getBiayar()}</td>                       
                                                    <td style="font-weight:normal; font-size: 12px"width="80" align="center">${listTukesi.getPenghitungan()}</td>
                                                    <td style="font-weight:normal; font-size: 12px"width="80" align="center">${listTukesi.getNilai_capaian_skp()}</td>           
                                                </c:otherwise>
                                            </c:choose>

                                            </tr>
                                        </c:when>
                                        <c:otherwise>
                                            <tr bgcolor="#e8edff">

                                                <td style="font-weight:normal ; font-size: 12px" width="38" align="center">${(count.index)+1}</td>
                                                <td  style="font-weight:normal; font-size: 12px" width="66" align="center"> <div align="center"><a href ="Isi4FaktorServlet?nipnilaiR=<c:out value="${pns.getNipBaru()}"/>&pilih_session=<c:out value="${sesiontahun}"/>&idTupoksiR=<c:out value="${listTukesi.getId_tupoksi()}"/>">${listTukesi.getId_tupoksi()}</a></div></td>
                                                <td style="font-weight:normal; font-size: 12px" width="211" align="left">${listTukesi.getNama_tupoksi()}</td>
                                                <td style="font-weight:normal; font-size: 12px" width="51" align="left">${listTukesi.getangkaKrdt4()}</td>
                                                <c:if test="${(listTukesi.getvar_perubahan1())=='u'}">
                                                    <td style="font-weight:normal; font-size: 12px"width="85" align="center"><strike>${listTukesi.getKuantitas4()} ${listTukesi.getKuantitas_label()}</strike></td>
                                                </c:if>
                                                <c:if test="${(listTukesi.getvar_perubahan1())!='u'}">
                                                <td style="font-weight:normal; font-size: 12px"width="85" align="center">${listTukesi.getKuantitas4()} ${listTukesi.getKuantitas_label()}</td>
                                            </c:if>

                                            <c:if test="${(listTukesi.getvar_perubahan2())=='u'}">
                                                <td style="font-weight:normal; font-size: 12px"width="78" align="center"><strike>${listTukesi.getKualitas4()} %</strike></td>
                                            </c:if>
                                            <c:if test="${(listTukesi.getvar_perubahan2())!='u'}">
                                                <td style="font-weight:normal; font-size: 12px"width="78" align="center">${listTukesi.getKualitas4()} %</td>
                                            </c:if>  
                                            <c:if test="${(listTukesi.getvar_perubahan3())=='u'}">
                                                <td style="font-weight:normal; font-size: 12px"width="68"align="center"><strike>${listTukesi.getWaktu4()} ${listTukesi.getWaktu_label()}</strike> </td>
                                            </c:if>

                                            <c:if test="${(listTukesi.getvar_perubahan3())!='u'}">
                                                <td style="font-weight:normal; font-size: 12px"width="68"align="center">${listTukesi.getWaktu4()} ${listTukesi.getWaktu_label()}</td>
                                            </c:if>
                                            <c:if test="${(listTukesi.getvar_perubahan4())=='u'}">

                                                <td style="font-weight:normal; font-size: 12px" width="91" align="center"><strike>Rp. ${listTukesi.getBiaya4()}</strike></td>
                                            </c:if>

                                            <c:if test="${(listTukesi.getvar_perubahan4())!='u'}">

                                                <td style="font-weight:normal; font-size: 12px" width="91" align="center">Rp. ${listTukesi.getBiaya4()}</td>
                                            </c:if>
                                            <%--<td align="left">${listTukesi.getangkaKrdtr()}</td>--%>

                                            <c:choose>
                                                <c:when test="${(listTukesi.getvar_perubahan1()=='u' || listTukesi.getvar_perubahan2()=='u' || listTukesi.getvar_perubahan3()=='u' || listTukesi.getvar_perubahan4()=='u' )}">



                                                    <td style="font-weight:normal; font-size: 12px"width="85" align="center">"-"</td>
                                                    <td style="font-weight:normal; font-size: 12px"width="78" align="center">"-"</td>
                                                    <td style="font-weight:normal; font-size: 12px"width="68" align="center">"-"</td>                        
                                                    <td style="font-weight:normal; font-size: 12px"width="95" align="center">"-"</td>                       
                                                    <td style="font-weight:normal; font-size: 12px"width="80" align="center">"-"</td>
                                                    <td style="font-weight:normal; font-size: 12px"width="80" align="center">"-"</td>
                                                </c:when>     
                                                <c:otherwise>
                                                    <td style="font-weight:normal; font-size: 12px"width="85" align="center">${listTukesi.getKuantitasr()} ${listTukesi.getKuantitas_label()}</td>
                                                    <td style="font-weight:normal; font-size: 12px"width="78" align="center">${listTukesi.getKualitasr()} %</td>
                                                    <td style="font-weight:normal; font-size: 12px"width="68" align="center">${listTukesi.getWaktur()} ${listTukesi.getWaktu_label()}</td>                        
                                                    <td style="font-weight:normal; font-size: 12px"width="95" align="center">Rp. ${listTukesi.getBiayar()}</td>                       
                                                    <td style="font-weight:normal; font-size: 12px"width="80" align="center">${listTukesi.getPenghitungan()}</td>
                                                    <td style="font-weight:normal; font-size: 12px"width="80" align="center">${listTukesi.getNilai_capaian_skp()}</td>           
                                                </c:otherwise>
                                            </c:choose>

                                            </tr>
                                        </c:otherwise>

                                    </c:choose>
                                </c:forEach>

                            </table>
                        </div>
                        <div>&nbsp;</div>
                        <div>TUGAS TAMBAHAN</div>


                        <div class="scroll3" id="hof">
                            <table >
                                <tr style="background:#9999ff">
                                    <th style="font-weight:normal; font-size: 12px" width="31"><div align="center">NO.</div></th>
                                <th style="font-weight:normal; font-size: 12px" width="138"><div align="center">KODE</div></th>
                                <th style="font-weight:normal; font-size: 12px" width="138"><div align="center">JENIS TUGAS</div></th>
                                <th style="font-weight:normal; font-size: 12px" width="383"><div align="center">NAMA TUGAS TAMBAHAN</div></th>
                                <th style="font-weight:normal; font-size: 12px" width="138"><div align="center">TARGET</div></th>
                                <th style="font-weight:normal; font-size: 12px" width="138"><div align="center">REALISASI</div></th>
                                <th style="font-weight:normal; font-size: 12px" width="138"><div align="center">PENGHITUNGAN </div>  </th>        
                                <th style="font-weight:normal; font-size: 12px" width="138"><div align="center">NILAI CAPAIAN SKP</div></th>
                                </tr>

                                <c:forEach var="tambahans" items="${tugasTambahans}" varStatus ="count">
                                    <c:choose>
                                        <c:when test="${count.index % 2 == 0}">
                                            <tr bgcolor="#7FFFD4">
                                                <td style="font-weight:normal; font-size: 12px"width="31" align="center">${(count.index)+1}</td>
                                                <td style="font-weight:normal; font-size: 12px"width="138" align="center">${tambahans.getIdTambahan()}</td>
                                                <td style="font-weight:normal; font-size: 12px" width="138" align="left">${tambahans.getJenisTambahan()}</td>
                                                <td style="font-weight:normal; font-size: 12px"width="383" align="left">${tambahans.getNama()}</td>
                                                <td style="font-weight:normal; font-size: 12px"width="138" align="right">${tambahans.getNilai1()}</td>
                                                <td style="font-weight:normal; font-size: 12px"width="138" align="right">${tambahans.getNilai2()}</td>
                                                <td style="font-weight:normal; font-size: 12px"width="138" align="right">${tambahans.getHitungTambahan()}</td>
                                                <td style="font-weight:normal; font-size: 12px"width="138" align="right">${tambahans.getNilaiTambahan()}</td>
                                            </tr>
                                        </c:when>
                                        <c:otherwise>
                                            <tr bgcolor=#ADFF2F">
                                                <td style="font-weight:normal; font-size: 12px"width="31" align="center">${(count.index)+1}</td>
                                                <td style="font-weight:normal; font-size: 12px"width="138" align="center">${tambahans.getIdTambahan()}</td>
                                                <td style="font-weight:normal; font-size: 12px"width="138" align="left">${tambahans.getJenisTambahan()}</td>
                                                <td style="font-weight:normal; font-size: 12px"width="383" align="left">${tambahans.getNama()}</td>
                                                <td style="font-weight:normal; font-size: 12px"width="138" align="right">${tambahans.getNilai1()}</td>
                                                <td style="font-weight:normal; font-size: 12px"width="138" align="right">${tambahans.getNilai2()}</td>
                                                <td style="font-weight:normal; font-size: 12px"width="138" align="right">${tambahans.getHitungTambahan()}</td>
                                                <td style="font-weight:normal; font-size: 12px"width="138" align="right">${tambahans.getNilaiTambahan()}</td>
                                            </tr>
                                        </c:otherwise>

                                    </c:choose>
                                </c:forEach>

                            </table>
                        </div>

                        <div>
                            <%-- <a href="tupoksiServlet?txtNIPBaruTB=<c:out value="${pns.getNipBaru()}"/>"><img src="images/tambah.png"/>
                            </a>--%>
                            <a href="tupoksiServlet2?txtNIPBaruTB=<c:out value="${pns.getNipBaru()}"/>&pilih_session=<c:out value="${sesiontahun}"/>"><img src="/SKPapplication/images/tambah.png"/>
                            </a>
                        </div>
                        <div>&nbsp;</div>
                        <div>
                            KREATIFITAS

                        </div>



                        <div class="scroll3" id="hof">
                            <table  >
                                <tr style="background:#9999ff">

                                    <th style="font-weight:normal; font-size: 12px" width="31"><div align="center">NO.</div></th>
                                <th style="font-weight:normal; font-size: 12px" width="138"><div align="center">KODE</div></th>
                                <th style="font-weight:normal; font-size: 12px" width="138"><div align="center">JENIS TUGAS</div></th>
                                <th style="font-weight:normal; font-size: 12px" width="383"><div align="center">NAMA KREATIFITAS</div></th>
                                <th style="font-weight:normal; font-size: 12px" width="138"><div align="center">TARGET</div></th>
                                <th style="font-weight:normal; font-size: 12px" width="138"><div align="center">REALISASI</div></th>
                                <th style="font-weight:normal; font-size: 12px" width="138"><div align="center">PENGHITUNGAN </div>  </th>        
                                <th style="font-weight:normal; font-size: 12px" width="138"><div align="center">NILAI CAPAIAN SKP</div></th>
                                </tr>   
                                <c:forEach var="tambahans" items="${kereaktifitas}" varStatus ="count">
                                    <c:choose>
                                        <c:when test="${count.index % 2 == 0}"> 
                                            <tr bgcolor="#7FFFD4">
                                                <td style="font-weight:normal; font-size: 12px"width="31" align="center">${(count.index)+1}</td>
                                                <td style="font-weight:normal; font-size: 12px"width="138" align="center">${tambahans.getIdTambahan()}</td>
                                                <td style="font-weight:normal; font-size: 12px"width="138" align="left">${tambahans.getJenisTambahan()}</td>
                                                <td style="font-weight:normal; font-size: 12px"width="383" align="left">${tambahans.getNama()}</td>
                                                <td style="font-weight:normal; font-size: 12px"width="138" align="right">${tambahans.getNilai1()}</td>
                                                <td style="font-weight:normal; font-size: 12px"width="138" align="right">${tambahans.getNilai2()}</td>
                                                <td style="font-weight:normal; font-size: 12px"width="138" align="right">${tambahans.getHitungTambahan()}</td>
                                                <td style="font-weight:normal; font-size: 12px"width="138" align="right">${tambahans.getNilaiTambahan()}</td>
                                            </tr>
                                        </c:when>
                                        <c:otherwise>
                                            <tr  bgcolor=#ADFF2F">
                                                <td style="font-weight:normal; font-size: 12px"width="31" align="center">${(count.index)+1}</td>
                                                <td style="font-weight:normal; font-size: 12px"width="138" align="center">${tambahans.getIdTambahan()}</td>
                                                <td style="font-weight:normal; font-size: 12px"width="138" align="left">${tambahans.getJenisTambahan()}</td>
                                                <td style="font-weight:normal; font-size: 12px"width="383" align="left">${tambahans.getNama()}</td>
                                                <td style="font-weight:normal; font-size: 12px"width="138" align="right">${tambahans.getNilai1()}</td>
                                                <td style="font-weight:normal; font-size: 12px"width="138" align="right">${tambahans.getNilai2()}</td>
                                                <td style="font-weight:normal; font-size: 12px"width="138" align="right">${tambahans.getHitungTambahan()}</td>
                                                <td style="font-weight:normal; font-size: 12px"width="138" align="right">${tambahans.getNilaiTambahan()}</td>
                                            </tr>
                                        </c:otherwise>

                                    </c:choose>
                                </c:forEach>

                            </table>

                        </div>
                        <div>
                            <%--<a href="tupoksiServlet?txtNIPBaruTB=<c:out value="${pns.getNipBaru()}"/>"><img src="images/tambah.png"/>
                            --%>
                            <a href="tupoksiServlet2?txtNIPBaruTB=<c:out value="${pns.getNipBaru()}"/>"><img src="/SKPapplication/images/tambah.png"/></a>
                        </div>
                        <center>
                            <table>
                                <tr>

                                    <%--  <td><a href="cetakIsi4FaktorServlet?nipnilai2SB=<c:out value="${pns.getNipBaru()}"/>&realisasi=realisasi" target="_blank" title="Cetak"><center><img src="images/cetak.png"/></center></a></td>--%>
                                    <%--  <td><a href="cetakIsi4FaktorServlet?nipPrestasi=<c:out value="${pns.getNipBaru()}"/>"target="_blank"><center><img src="images/cetakprestasi.png"/></center></a></td> --%>

                                    <td><a href="cetakIsi4FaktorServlet?nipPrestasi=<c:out value="${pns.getNipBaru()}"/>&realisasi2=realisasi2"  target="_blank" id="url4"  onclick="redirect4K()" title="Prestasi"><center><img src="images/cetakprestasi.png"/></center></a></td> 
                                    <td><a target="_blank" id="url3"  onclick="redirect3K()" title="Cetak"><center><img src="/SKPapplication/images/cetak.png"/></center></a></td>
                                    <td>Tanggal Cetak </td>
                                    <%--<td>&nbsp;&nbsp;&nbsp;<input type="text" id="tglCetakwx" name="tglCetakwx" on maxlength="8" onfocus="clearText2WW_()" onblur="clearTextWW_()" onkeypress="return alertnipnull3(event)"/> </td>--%>
                                    <td>&nbsp;  &nbsp; <input type="text" id="tglCetakw" name="tglCetakw" on maxlength="8" onfocus="clearText2WW_()" onblur="clearTextWW_()" onkeypress="return alertnipnull3(event)"/> </td>
                                    <td>DDMMYYYY</td>    


                                </tr>
                            </table>
                        </center>

                    </div>

                </c:if>
                <script language="javascript" type="text/javascript">  
   

                    function clearTextWW_()
                    {    
                                        
                        var temp = document.getElementById("tglCetakw").value;
                        //var temp = document.getElementById("tglCetak").value;
                       
                        if (temp.length==8){
                            
                            var hasil = temp.substring(0, 2) + "-"+temp.substring(2, 4)+ "-"+temp.substring(4, 8);
                            document.getElementById("tglCetakw").value = hasil;
                        }
                    }
                    function clearText2WW_()
                    {    
                                        
                        var temp = document.getElementById("tglCetakw").value;
                                        
                        if (temp.length==10){
                                           
                            var hasil = temp.substring(0, 2) + temp.substring(3, 5)+temp.substring(6, 10);
                            document.getElementById("tglCetakw").value = hasil;
                        }
                    }
                                    
                </script>

                <c:if test="${navigasi_pilihan =='46' }">
                    <div id="menu2">
                        <ul>
                            <li><a href="GetPnsServlet?txtNIPBaruB=<c:out value="${sessionScope.NipPnsSession}"/>" target="_parent" title="Target Sasaran SKI"><span></span>Kembali</a></li>	
                            <li><a href="RequestServlet?page=indexloginBaru" target="_parent" title="Keluar"><span></span>Keluar</a></li>

                        </ul>
                        <br class="clearfix" />
                    </div>
                    <form method="post" name="form1"  onsubmit="return validasitest()"  action="isiPerilakuServlet"> 

                        <div id="leftsideMonitor">
                            <div STYLE=" height: 400px;   width: 300px; font-size: 8px; overflow: auto;">                  
                                <table  align="top" width="173">

                                    <tr>
                                    <input type="hidden" name="statusbutton" value="" id="statusbutton" />   
                                    <td style="font-size: 12px ">Nip baru :</td>
                                    <td colspan="3" style="font-size: 12px "><input type="number"  maxlength="18" id="cariNipMon" name="cariNipMon" onkeypress='return validate(event)'/> </td>
                                    <td><input type="image" src="/SKPapplication/images/cari.png" id="cariNipMon" onclick="ButtoncarinipMonitoring()" name="cariNipMon" value="cari"/></td>

                                    </tr>

                                    <tr>
                                        <td style="font-size: 12px"> Nama :<input type="hidden" name="nipAtasan" id ="nipAtasan" value="${nipAtasan}"/><input type="hidden"  name="nipBaru" id ="nipBaru" value="${pns.getNipBaru()}"/></td>
                                        <td colspan="3" style="font-size: 12px"><input type="text" id="cariNamaMon" name="cariNamaMon" /></td>
                                        <td><input type="image" src="/SKPapplication/images/cari.png" id="cariNamaMon" name="cariNamaMon" value="cari"/></td>
                                    </tr> 

                                    <tr>
                                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp</td>

                                        <td style ="width: 5px">
                                            <select id="pilih_session_monit" name="pilih_session_monit" onchange="validasi4()" >
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
                                        <td>
                                            <input type="button"  name="param" onclick="ButtonBackNit()" value="Lihat Staf"/> 
                                        </td>  

                                        <td>
                                            <input type="button" name="CetakSeluruh" onclick="ButtonBackCetak()" target="_blank" value="Print ALL"/>
                                        </td>


                                    </tr>      

                                    <tr>
                                        <td colspan="3">
                                            <input type="button" name="CetakSeluruh" onclick="ButtonBackNitView()" value="Listing Laporan Staf"/>
                                        </td>
                                    </tr>

                                </table>
                                <style type="text/css"> 
                                    #menu1 {
                                        position: relative;
                                        width: 200px;
                                        height: 400px;

                                        font-family: arial;

                                        font:italic bold 11px/25px Georgia, serif;
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
                                        padding: 0px;
                                        float: left;
                                        width: 200px;

                                    }
                                    #menu1 ul li a:hover {

                                        color: #FF0000;
                                        font-size: 11px;
                                    }
                                    #menu1 ul li ul {
                                        display: none;
                                    }


                                    #menu1 ul li:hover ul{
                                        display: block;
                                        position: relative;
                                        top: 0px;
                                        left: 30px;
                                    }
                                    #menu1 ul li:hover ul li a {
                                        display: block;

                                        color: #fff;
                                        width: 100%;
                                    }
                                    #menu1 ul li:hover ul li a:hover {

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
                                        left: 30px;
                                    }

                                </style>
                                <div id="menu1">

                                    <ul>   

                                        <c:forEach var="pnsBaw" items="${pnsBawahan}" varStatus="count">
                                            <c:set var="capaian" value="${pnsBaw.getRealisasi()}" /> 
                                            <c:choose>   

                                                <c:when test="${(pnsBaw.getRealisasi()) <'45'}">
                                                    <li><a href="GetPnsServlet?action=Monitor&txtNIPBaru=<c:out value="${pnsBaw.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>&NipAtasan=<c:out value="${nipAtasan}"/>"><div id="merah"> ${pnsBaw.getNamaPns()}</div></a>
                                                    </c:when> 

                                                    <c:when test="${(pnsBaw.getRealisasi()) <'76'}">
                                                    <li><a href="GetPnsServlet?action=Monitor&txtNIPBaru=<c:out value="${pnsBaw.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>&NipAtasan=<c:out value="${nipAtasan}"/>"><div id="kuning"> ${pnsBaw.getNamaPns()}</div></a>
                                                    </c:when> 
                                                    <c:otherwise>
                                                    <li> <a href="GetPnsServlet?action=Monitor&txtNIPBaru=<c:out value="${pnsBaw.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>&NipAtasan=<c:out value="${nipAtasan}"/>"><div id="biru"> ${pnsBaw.getNamaPns()}</div></a>

                                                    </c:otherwise>   
                                                </c:choose>           

                                                <ul>

                                                    <c:forEach var="pnsBaw2" items="${pnsBawahan2}">
                                                        <c:choose>
                                                            <c:when test="${(pnsBaw2.getDiAtasanId() == pnsBaw.getUnorId() &&  pnsBaw.getjnsjbtn_id()=='1' )}">  
                                                                <c:set var="namArray" value="${pnsBaw2.getNamaPns()}"/>
                                                                <c:set var="capaian" value="${pnsBaw2.getRealisasi()}" /> 
                                                                <c:choose> 

                                                                    <c:when test="${(pnsBaw2.getRealisasi()) <'45'}">
                                                                        <li><a href="GetPnsServlet?action=Monitor&txtNIPBaru=<c:out value="${pnsBaw2.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>&NipAtasan=<c:out value="${nipAtasan}"/>"><div id="merah"> ${pnsBaw2.getNamaPns()}</div></a>
                                                                        </c:when> 

                                                                        <c:when test="${(pnsBaw2.getRealisasi()) <'76'}">
                                                                        <li> <a href="GetPnsServlet?action=Monitor&txtNIPBaru=<c:out value="${pnsBaw2.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>&NipAtasan=<c:out value="${nipAtasan}"/>"><div id="kuning"> ${pnsBaw2.getNamaPns()}</div></a>
                                                                        </c:when> 
                                                                        <c:otherwise>
                                                                        <li><a href="GetPnsServlet?action=Monitor&txtNIPBaru=<c:out value="${pnsBaw2.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>&NipAtasan=<c:out value="${nipAtasan}"/>"><div id="biru"> ${pnsBaw2.getNamaPns()}</div></a>


                                                                        </c:otherwise>   
                                                                    </c:choose> 
                                                                    <ul>  
                                                                        <c:forEach var="pnsBaw3" items="${pnsBawahan3}">
                                                                            <c:choose>
                                                                                <c:when test="${(pnsBaw3.getDiAtasanId() == pnsBaw2.getUnorId() && pnsBaw2.getjnsjbtn_id()=='1' )}">  
                                                                                    <c:set var="capaian" value="${pnsBaw3.getRealisasi()}" /> 
                                                                                    <c:choose>    
                                                                                        <c:when test="${(pnsBaw3.getRealisasi()) <'45'}">
                                                                                            <li><a href="GetPnsServlet?action=Monitor&txtNIPBaru=<c:out value="${pnsBaw3.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>&NipAtasan=<c:out value="${nipAtasan}"/>"><div id="merah"> ${pnsBaw3.getNamaPns()}</div></a>
                                                                                            </c:when> 

                                                                                            <c:when test="${(pnsBaw3.getRealisasi()) <'76'}">
                                                                                            <li><a href="GetPnsServlet?action=Monitor&txtNIPBaru=<c:out value="${pnsBaw3.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>&NipAtasan=<c:out value="${nipAtasan}"/>"><div id="kuning"> ${pnsBaw3.getNamaPns()}</div></a>
                                                                                            </c:when> 
                                                                                            <c:otherwise>
                                                                                            <li><a href="GetPnsServlet?action=Monitor&txtNIPBaru=<c:out value="${pnsBaw3.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>&NipAtasan=<c:out value="${nipAtasan}"/>"><div id="biru"> ${pnsBaw3.getNamaPns()}</div></a>

                                                                                            </c:otherwise>   
                                                                                        </c:choose> 

                                                                                        <ul>
                                                                                            <c:forEach var="pnsBaw4" items="${pnsBawahan4}">
                                                                                                <c:choose>
                                                                                                    <c:when test="${(pnsBaw4.getDiAtasanId() == pnsBaw3.getUnorId() ) && pnsBaw3.getjnsjbtn_id()=='1'}"> 
                                                                                                        <c:set var="capaian" value="${pnsBaw4.getRealisasi()}" /> 
                                                                                                        <c:choose>    
                                                                                                            <c:when test="${(pnsBaw4.getRealisasi()) <'45'}">
                                                                                                                <li><a href="GetPnsServlet?action=Monitor&txtNIPBaru=<c:out value="${pnsBaw4.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>&NipAtasan=<c:out value="${nipAtasan}"/>"><div id="merah"> ${pnsBaw4.getNamaPns()}</div></a>
                                                                                                                </c:when> 

                                                                                                                <c:when test="${(pnsBaw4.getRealisasi()) <'76'}">
                                                                                                                <li><a href="GetPnsServlet?action=Monitor&txtNIPBaru=<c:out value="${pnsBaw4.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>&NipAtasan=<c:out value="${nipAtasan}"/>"><div id="kuning"> ${pnsBaw4.getNamaPns()}</div></a>
                                                                                                                </c:when> 
                                                                                                                <c:otherwise>
                                                                                                                <li><a href="GetPnsServlet?action=Monitor&txtNIPBaru=<c:out value="${pnsBaw4.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>&NipAtasan=<c:out value="${nipAtasan}"/>"><div id="biru"> ${pnsBaw4.getNamaPns()}</div></a></li>

                                                                                                            </c:otherwise>   
                                                                                                        </c:choose> 


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

                                <%--================================================--%>
                                <%--<ol class="tree">

                                    <ol>   

                                        <c:forEach var="pnsBaw" items="${pnsBawahan}" varStatus="count">
                                            <c:set var="capaian" value="${pnsBaw.getRealisasi()}" /> 
                                           
                                                  
                                                    <li> 
                                                        <label for="folder<c:out value="${count.count}"/>"><c:out value="${pnsBaw.getNamaPns()}"/></label> <input type="checkbox" id="folder<c:out value="${count.count}"/>" value="${pnsBaw.getNamaPns()}"/> 



                                                <ol>

                                                    <c:forEach var="pnsBaw2" items="${pnsBawahan2}" varStatus="count2">
                                                        <c:choose>
                                                            <c:when test="${(pnsBaw2.getDiAtasanId() == pnsBaw.getUnorId() &&  pnsBaw.getjnsjbtn_id()=='1' )}">  
                                                                <c:set var="namArray" value="${pnsBaw2.getNamaPns()}"/>
                                                                <c:set var="capaian" value="${pnsBaw2.getRealisasi()}" /> 
                                                               
                                                                        <li>
                                                                              <label for="folder2<c:out value="${count2.count}"/>"><c:out value="${pnsBaw2.getNamaPns()}"/></label> <input type="checkbox" id="folder2<c:out value="${count2.count}"/>" value="${pnsBaw2.getNamaPns()}"/> 

                                                                    <ol>  
                                                                        <c:forEach var="pnsBaw3" items="${pnsBawahan3}">
                                                                            <c:choose>
                                                                                <c:when test="${(pnsBaw3.getDiAtasanId() == pnsBaw2.getUnorId() && pnsBaw2.getjnsjbtn_id()=='1' )}">  
                                                                                    <c:set var="capaian" value="${pnsBaw3.getRealisasi()}" /> 
                                                                                  
                                                                                            <li>
                                                                                                  <label for="folder3"><c:out value="${pnsBaw3.getNamaPns()}"/></label> <input type="checkbox" id="folder3" value="${pnsBaw3.getNamaPns()}"/> 

                                                                                        <ol>
                                                                                            <c:forEach var="pnsBaw4" items="${pnsBawahan4}">
                                                                                                <c:choose>
                                                                                                    <c:when test="${(pnsBaw4.getDiAtasanId() == pnsBaw3.getUnorId() ) && pnsBaw3.getjnsjbtn_id()=='1'}"> 
                                                                                                        <c:set var="capaian" value="${pnsBaw4.getRealisasi()}" /> 
                                                                                                        
                                                                                                                <li>
                                                                                                                      <label for="folder4"><c:out value="${pnsBaw4.getNamaPns()}"/></label> <input type="checkbox" id="folder4" value="${pnsBaw4.getNamaPns()}"/> </li>

                                                                                                              
                                                                                                        </c:when>
                                                                                                    </c:choose>
                                                                                                </c:forEach>
                                                                                        </ol>
                                                                                    </li>
                                                                                </c:when>
                                                                            </c:choose>
                                                                        </c:forEach>  
                                                                    </ol>         
                                                                </li>                     
                                                            </c:when>
                                                        </c:choose>
                                                    </c:forEach>  

                                                </ol>    
                                            </li>
                                        </c:forEach>
                                    </ol>      

                                </ol> %-->
                                <%--================================================--%>
                            </div>


                        </div>
                        <div  id="contentMonitor">
                            <div style="height: 200px; overflow:  auto;background: #ffffff;">
                                <table >
                                    <tr  BGCOLOR="#9999ff">
                                        <th style="font-weight:normal; font-size: 12px" width="38" rowspan="2" style="font-weight:normal">NO.</th>
                                        <th style="font-weight:normal; font-size: 12px"rowspan="2" width="66" style="font-weight:normal">KODE</th>
                                        <th style="font-weight:normal; font-size: 12px"rowspan="2" width="211" style="font-weight:normal">KEGIATAN TUGAS POKOK JABATAN</th>
                                        <th style="font-weight:normal; font-size: 12px"colspan="5" style="font-weight:normal">TARGET</th>
                                        <th style="font-weight:normal; font-size: 12px"colspan="4" style="font-weight:normal">REALISASI</th>
                                        <th style="font-weight:normal; font-size: 12px"width="80" rowspan="2" style="font-weight:normal">PENGHITUNGAN PENCAPAIAN</th>


                                    </tr>

                                    <tr  BGCOLOR="#9999ff">
                                        <th style="font-weight:normal; font-size: 12px"width="51" style="font-weight:normal">AK</th>
                                        <th style="font-weight:normal; font-size: 12px"width="85" style="font-weight:normal">KUANT/ OUTPUT</th>
                                        <th style="font-weight:normal; font-size: 12px"width="78" style="font-weight:normal">KUAL/ MUTU</th>
                                        <th style="font-weight:normal; font-size: 12px"width="68" style="font-weight:normal">WAKTU</th>
                                        <th style="font-weight:normal; font-size: 12px"width="91" style="font-weight:normal">BIAYA</th>

                                        <th style="font-weight:normal; font-size: 12px"width="85" style="font-weight:normal">KUANT/ OUTPUT</th>
                                        <th style="font-weight:normal; font-size: 12px"width="78" style="font-weight:normal">KUAL/ MUTU</th>
                                        <th style="font-weight:normal; font-size: 12px"width="68" style="font-weight:normal">WAKTU</th>
                                        <th style="font-weight:normal; font-size: 12px"width="95" style="font-weight:normal">BIAYA</th>
                                    </tr>
                                    <c:forEach var="listTukesi" items="${realkesiServlet}" varStatus ="count">
                                        <c:choose>
                                            <c:when test="${(listTukesi.getNilai_capaian_skp()) <'76'}">

                                                <tr bgcolor="#FF0000">

                                                    <td style="font-weight:normal; font-size: 12px"width="54" align="center">${(count.index)+1}<input type="hidden" name="nipsendiri" id ="nipsendiri" value="${nipsendiri}"/></td>
                                                    <td style="font-weight:normal; font-size: 12px"width="87" align="center"> <div align="center"><a href ="Isi4FaktorServlet?action=Monitor&nipnilaiR=<c:out value="${nipdimonitoring}"/>&NipAtasan=<c:out value="${pns.getNipBaru()}"/>&nipsendiriMonitoring=<c:out value="${nipsendiri}"/>&nipsendiriR=<c:out value="${nipsendiri}"/>&idTupoksiR=<c:out value="${listTukesi.getId_tupoksi()}"/>">${listTukesi.getId_tupoksi()}</a></div></td>
                                                    <td style="font-weight:normal; font-size: 12px"width="530" align="left">${listTukesi.getNama_tupoksi()}<input type="hidden" name="Id_tupoksi" id ="Id_tupoksi" value="${listTukesi.getId_tupoksi()}"/></td>
                                                    <td style="font-weight:normal; font-size: 12px"width="51" align="left">${listTukesi.getangkaKrdt4()}</td>
                                                    <td style="font-weight:normal; font-size: 12px"width="85" align="center">${listTukesi.getKuantitas4()} ${listTukesi.getKuantitas_label()}</td>
                                                    <td style="font-weight:normal; font-size: 12px"width="78" align="center">${listTukesi.getKualitas4()} %</td>
                                                    <td style="font-weight:normal; font-size: 12px"width="68"align="center">${listTukesi.getWaktu4()} ${listTukesi.getWaktu_label()}</td>
                                                    <td  style="font-weight:normal; font-size: 12px"width="91" align="center">Rp. ${listTukesi.getBiaya4()}</td>

                                                    <td style="font-weight:normal; font-size: 12px"width="85" align="center">${listTukesi.getKuantitasr()} ${listTukesi.getKuantitas_label()}</td>
                                                    <td style="font-weight:normal; font-size: 12px"width="78" align="center">${listTukesi.getKualitasr()} %</td>
                                                    <td style="font-weight:normal; font-size: 12px"width="68" align="center">${listTukesi.getWaktur()} ${listTukesi.getWaktu_label()}</td>
                                                    <td style="font-weight:normal; font-size: 12px"width="95" align="center">Rp. ${listTukesi.getBiayar()}</td>
                                                    <td style="font-weight:normal; font-size: 12px"width="95" align="center"> ${listTukesi.getNilai_capaian_skp()}<input type="hidden" name="thn_sesion" id ="thn_sesion" value="${listTukesi.get_pilih_session()}"/></td>

                                                </tr>
                                            </c:when>
                                            <c:otherwise>
                                                <tr bgcolor="#e8edff">

                                                    <td style="font-weight:normal; font-size: 12px"width="54" align="center">${(count.index)+1}<input type="hidden" name="nipsendiri" id ="nipsendiri" value="${nipsendiri}"/></td>
                                                    <td style="font-weight:normal; font-size: 12px"width="87" align="center"> <div align="center"><a href ="Isi4FaktorServlet?action=Monitor&nipnilaiR=<c:out value="${nipdimonitoring}"/>&NipAtasan=<c:out value="${pns.getNipBaru()}"/>&nipsendiriMonitoring=<c:out value="${nipsendiri}"/>&nipsendiriR=<c:out value="${nipsendiri}"/>&idTupoksiR=<c:out value="${listTukesi.getId_tupoksi()}"/>">${listTukesi.getId_tupoksi()}</a></div></td>
                                                    <td style="font-weight:normal; font-size: 12px"width="530" align="left">${listTukesi.getNama_tupoksi()}<input type="hidden" name="Id_tupoksi" id ="Id_tupoksi" value="${listTukesi.getId_tupoksi()}"/></td>
                                                    <td style="font-weight:normal; font-size: 12px"width="51" align="left">${listTukesi.getangkaKrdt4()}</td>
                                                    <td style="font-weight:normal; font-size: 12px"width="85" align="center">${listTukesi.getKuantitas4()} ${listTukesi.getKuantitas_label()}</td>
                                                    <td style="font-weight:normal; font-size: 12px"width="78" align="center">${listTukesi.getKualitas4()} %</td>
                                                    <td style="font-weight:normal; font-size: 12px"width="68"align="center">${listTukesi.getWaktu4()} ${listTukesi.getWaktu_label()}</td>
                                                    <td  style="font-weight:normal; font-size: 12px"width="91" align="center">Rp. ${listTukesi.getBiaya4()}</td>

                                                    <td style="font-weight:normal; font-size: 12px"width="85" align="center">${listTukesi.getKuantitasr()} ${listTukesi.getKuantitas_label()}</td>
                                                    <td style="font-weight:normal; font-size: 12px"width="78" align="center">${listTukesi.getKualitasr()} %</td>
                                                    <td style="font-weight:normal; font-size: 12px"width="68" align="center">${listTukesi.getWaktur()} ${listTukesi.getWaktu_label()}</td>
                                                    <td style="font-weight:normal; font-size: 12px"width="95" align="center">Rp. ${listTukesi.getBiayar()}</td>
                                                    <td style="font-weight:normal; font-size: 12px"width="95" align="center"> ${listTukesi.getNilai_capaian_skp()}<input type="hidden" name="thn_sesion" id ="thn_sesion" value="${listTukesi.get_pilih_session()}"/></td>

                                                </tr>
                                            </c:otherwise>

                                        </c:choose>

                                    </c:forEach> 


                                </table>
                            </div>
                            <div style="height: 100px;overflow: auto;background: #ffffff" >
                                <table>
                                    <thead>

                                        <tr style="background-color: #9999ff;height: 30px">
                                            <th width="31" style="font-weight:normal"><div align="center">NO.</div></th>
                                    <th width="138" style="font-weight:normal;font-size: 12px"><div align="center">KODE</div></th>
                                    <th width="138" style="font-weight:normal;font-size: 12px"><div align="center">JENIS TUGAS</div></th>
                                    <th width="383" style="font-weight:normal;font-size: 12px"><div align="center">NAMA TUGAS TAMBAHAN</div></th>
                                    <th width="138" style="font-weight:normal;font-size: 12px"><div align="center">TARGET</div></th>
                                    <th width="138" style="font-weight:normal;font-size: 12px"><div align="center">REALISASI</div></th>
                                    <th width="138" style="font-weight:normal;font-size: 12px"><div align="center">PENGHITUNGAN </div>  </th>        
                                    <th width="138" style="font-weight:normal;font-size: 12px"><div align="center">NILAI CAPAIAN SKP</div></th>
                                    </tr>

                                    </thead>




                                    <c:forEach var="tambahans" items="${tugasTambahans}" varStatus ="count">
                                        <c:choose>
                                            <c:when test="${count.index % 2 == 0}">
                                                <tr bgcolor="#7FFFD4">
                                                    <td width="31" align="center" style="font-weight:normal;font-size: 12px">${(count.index)+1}</td>
                                                    <td width="138" align="center" style="font-weight:normal;font-size: 12px">${tambahans.getIdTambahan()}</td>
                                                    <td width="138" align="left" style="font-weight:normal;font-size: 12px">${tambahans.getJenisTambahan()}</td>
                                                    <td width="383" align="left" style="font-weight:normal;font-size: 12px">${tambahans.getNama()}</td>
                                                    <td width="138" align="right" style="font-weight:normal;font-size: 12px">${tambahans.getNilai1()}</td>
                                                    <td width="138" align="right" style="font-weight:normal;font-size: 12px">${tambahans.getNilai2()}</td>
                                                    <td width="138" align="right" style="font-weight:normal;font-size: 12px">${tambahans.getHitungTambahan()}</td>
                                                    <td width="138" align="right" style="font-weight:normal;font-size: 12px">${tambahans.getNilaiTambahan()}</td>
                                                </tr>
                                            </c:when>
                                            <c:otherwise>
                                                <tr bgcolor=#ADFF2F">
                                                    <td width="31" align="center" style="font-weight:normal;font-size: 12px">${(count.index)+1}</td>
                                                    <td width="138" align="center" style="font-weight:normal;font-size: 12px">${tambahans.getIdTambahan()}</td>
                                                    <td width="138" align="left" style="font-weight:normal;font-size: 12px"> ${tambahans.getJenisTambahan()}</td>
                                                    <td width="383" align="left" style="font-weight:normal;font-size: 12px">${tambahans.getNama()}</td>
                                                    <td width="138" align="right" style="font-weight:normal;font-size: 12px">${tambahans.getNilai1()}</td>
                                                    <td width="138" align="right" style="font-weight:normal;font-size: 12px">${tambahans.getNilai2()}</td>
                                                    <td width="138" align="right" style="font-weight:normal;font-size: 12px">${tambahans.getHitungTambahan()}</td>
                                                    <td width="138" align="right" style="font-weight:normal;font-size: 12px">${tambahans.getNilaiTambahan()}</td>
                                                </tr>
                                            </c:otherwise>

                                        </c:choose>
                                    </c:forEach>

                                </table>
                            </div>
                            <div style="height: 100px; overflow: auto;background: #ffffff">
                                <table   >

                                    <thead >
                                        <tr style="background-color: #9999ff;height: 30px">
                                            <th width="31" style="font-weight:normal;font-size: 12px"><div align="center">NO.</div></th>
                                    <th width="138" style="font-weight:normal;font-size: 12px"><div align="center">KODE</div></th>
                                    <th width="138" style="font-weight:normal;font-size: 12px"><div align="center">JENIS TUGAS</div></th>
                                    <th width="383" style="font-weight:normal;font-size: 12px"><div align="center">NAMA KREATIFITAS</div></th>
                                    <th width="138" style="font-weight:normal;font-size: 12px"><div align="center">TARGET</div></th>
                                    <th width="138" style="font-weight:normal;font-size: 12px"><div align="center">REALISASI</div></th>
                                    <th width="138" style="font-weight:normal;font-size: 12px"><div align="center">PENGHITUNGAN </div>  </th>        
                                    <th width="138" style="font-weight:normal;font-size: 12px"><div align="center">NILAI CAPAIAN SKP</div></th>
                                    </tr>

                                    </thead>

                                    <c:forEach var="tambahans" items="${kereaktifitas}" varStatus ="count">
                                        <c:choose>
                                            <c:when test="${count.index % 2 == 0}"> 
                                                <tr bgcolor="#7FFFD4">
                                                    <td style="font-weight:normal;font-size: 12"pxwidth="31" align="center">${(count.index)+1}</td>
                                                    <td style="font-weight:normal;font-size: 12"pxwidth="138" align="center">${tambahans.getIdTambahan()}</td>
                                                    <td style="font-weight:normal;font-size: 12"pxwidth="138" align="left">${tambahans.getJenisTambahan()}</td>
                                                    <td style="font-weight:normal;font-size: 12"xwidth="383" align="left">${tambahans.getNama()}</td>
                                                    <td style="font-weight:normal;font-size: 12"width="138" align="right">${tambahans.getNilai1()}</td>
                                                    <td style="font-weight:normal;font-size: 12"width="138" align="right">${tambahans.getNilai2()}</td>
                                                    <td style="font-weight:normal;font-size: 12"width="138" align="right">${tambahans.getHitungTambahan()}</td>
                                                    <td style="font-weight:normal;font-size: 12"width="138" align="right">${tambahans.getNilaiTambahan()}</td>
                                                </tr>
                                            </c:when>
                                            <c:otherwise>
                                                <tr  bgcolor=#ADFF2F">
                                                    <td style="font-weight:normal;font-size: 12"width="31" align="center">${(count.index)+1}</td>
                                                    <td style="font-weight:normal;font-size: 12"width="138" align="center">${tambahans.getIdTambahan()}</td>
                                                    <td style="font-weight:normal;font-size: 12"width="138" align="left">${tambahans.getJenisTambahan()}</td>
                                                    <td style="font-weight:normal;font-size: 12"width="383" align="left">${tambahans.getNama()}</td>
                                                    <td style="font-weight:normal;font-size: 12"width="138" align="right">${tambahans.getNilai1()}</td>
                                                    <td style="font-weight:normal;font-size: 12"width="138" align="right">${tambahans.getNilai2()}</td>
                                                    <td style="font-weight:normal;font-size: 12"="138" align="right">${tambahans.getHitungTambahan()}</td>
                                                    <td style="font-weight:normal;font-size: 12"width="138" align="right">${tambahans.getNilaiTambahan()}</td>
                                                </tr>
                                            </c:otherwise>

                                        </c:choose>
                                    </c:forEach>

                                    <%-- ============================= --%>


                                    <%-- ============================= --%>


                                </table>
                            </div>



                        </div>

                        <style type="text/css"> 
                            #rightIsian {
                                position :  absolute;
                                top : 500px;
                                left : 1px;
                                width : 173px;
                                height : 300px;
                            }
                            #rightIsian2 {
                                position :  absolute;

                                left : 50px;
                                width : 500px;
                                height : 300px;
                            }
                            #rightIsiansub2 {
                                position :  absolute;
                                top : 1px;
                                margin-left: 720px;
                                width : 300px;
                                height : 300px;
                                overflow: auto;
                            }



                        </style>

                        <%-- ============================= --%>
                        <div id="rightIsian">
                            <div id="rightIsian2">

                                <table>

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
                                </table>
                                <div id="rightIsiansub2">
                                    <table>
                                        <c:forEach var="pnsBaw" items="${pnsList}" varStatus="count">
                                            <c:choose>
                                                <c:when test="${count.index % 2 == 0}">
                                                    <tr bgcolor="#7FFFD4">
                                                        <td style="font-weight:normal;font-size: 12px" width="150" align="left"><a href="GetPnsServlet?action=Monitor&txtNIPBaru=<c:out value="${pnsBaw.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>&NipAtasan=<c:out value="${nipAtasan}"/>"><div id="merah"> ${pnsBaw.getNamaPns()}</div></a></td>
                                                        <td style="font-weight:normal;font-size: 12px" width="50" align="right">${pnsBaw.getRealisasi()}</td>   

                                                    </tr>
                                                </c:when>
                                                <c:otherwise>
                                                    <tr  bgcolor=#ADFF2F">
                                                        <td style="font-weight:normal;font-size: 12px" width="150" align="left"><a href="GetPnsServlet?action=Monitor&txtNIPBaru=<c:out value="${pnsBaw.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>&NipAtasan=<c:out value="${nipAtasan}"/>"><div id="merah"> ${pnsBaw.getNamaPns()}</div></a></td>  
                                                        <td style="font-weight:normal;font-size: 12px" width="50" align="right">${pnsBaw.getRealisasi()}</td>   

                                                    </tr>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>

                                    </table>

                                </div>


                            </div>   


                        </div>               
                        <%-- ============================= --%>

                    </form>

                </c:if>

            </div>
        </div>
        <br class="clearfix" />

        <script language="javascript" type="text/javascript">  
   

            function clearTextWW()
            {    
                var temp = document.getElementById("tglCetakW").value;
                if (temp.length==8){
                    var hasil = temp.substring(0, 2) + "-"+temp.substring(2, 4)+ "-"+temp.substring(4, 8);
                    document.getElementById("tglCetakW").value = hasil;
                }
            }
            function clearText2WW()
            {    
                var temp = document.getElementById("tglCetakw").value;
                if (temp.length==10){
                    var hasil = temp.substring(0, 2) + temp.substring(3, 5)+temp.substring(6, 10);
                    document.getElementById("tglCetakw").value = hasil;
                }
            }
            function clearText()
            {    
              
                var temp = document.getElementById("tglCetak").value;
                if (temp.length==8){
                    
                    var hasil = temp.substring(0, 2) + "-"+temp.substring(2, 4)+ "-"+temp.substring(4, 8);
                    document.getElementById("tglCetak").value = hasil;
                }
            }
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
            function myPopup2()        
            {
                window.open( "updateServlets?instansiAtasan=<c:out value="${ UnorAts.getInstansiId()}"/>&instansiIdpns=<c:out value="${pns.getNipBaru()}"/>&instansiIdunorbwhan=<c:out value="${pns.getUnorId()}"/>", "myWindow", "status = 0, height = 500, width = 1000, resizable = 0, scrollbars=yes" )
      

            }
            function clearText2()
            {    
                var temp = document.getElementById("tglCetak").value;
                if (temp.length==10){
                    var hasil = temp.substring(0, 2) + temp.substring(3, 5)+temp.substring(6, 10);
                    document.getElementById("tglCetak").value = hasil;
                }
            }

            function redirect2()
            {
                pilihan=document.getElementById("pilih_session").value;
 
                url=document.getElementById("url");
 
                url.href=url.href+"&pilih_session=" + pilihan;
    
                // url=url+"&pilih_session=" + pilihan;
    
                // window.open(url.href, windowname, 'width=400,height=200,scrollbars=yes'); 
            }
            function redirect_testt()
            {
   
                urltest=document.getElementById("urltest");
 
                // url.href=url.href;
    
                // urltest=urltest+"&pilih_session=" + pilihan;
    
                window.open(urltest.href, windowname, 'width=200,height=200,scrollbars=yes'); 
            }
            
            function redirect_testtAjak()
            {
                url2=document.getElementById("urltestAjak");
                // urltest=document.getElementById("urltestAjak");
                pilihan=document.getElementById("pilih_session").value;
                   
                url2.href=url2.href+"&pilih_session=" + pilihan; 

    
                // window.open(urltest.href, windowname, 'width=200,height=200,scrollbars=yes'); 
            }
            function redirectInsertData(){
    
                var answer = confirm ("Yakin  Ingin Salin Data ?")
                if (answer){
                    pilihan=document.getElementById("pilih_session").value;
                    url2=document.getElementById("url2");
                    url2.href=url2.href+"&pilih_session=" + pilihan; }

            }
            function redirect3()       
            {
                var hr="cetakIsi4FaktorServlet?action=HitungtupoksiServlet3&nipnilai2=<c:out value='${pns.getNipBaru()}'/>"; 
                tglCetak=document.getElementById("tglCetak").value;
                pilihan=document.getElementById("pilih_session").value;
                url3=document.getElementById("url3");
   
                //   url3.href=url3.href+"&pilih_session=" + pilihan+"&tglCetak="+tglCetak;
                url3.href=hr+"&pilih_session=" + pilihan+"&tglCetak="+tglCetak; 
                
                
   
            }
            function redirectNip()       
            {
                var hr="GetPnsServlet?action=CariNipInput&nipnilai2=<c:out value='${sessionScope.NipPnsSession}'/>"; 
                
                pilihan=document.getElementById("pilih_session").value;
                urlNip=document.getElementById("urlNip");
                _nipInputan=document.getElementById("nipInputan").value;
   
                //   url3.href=url3.href+"&pilih_session=" + pilihan+"&tglCetak="+tglCetak;
                if (_nipInputan == ""){
                    alert('input nip tidak boleh kosong');
                } else {
                    urlNip.href=hr+"&pilih_session=" + pilihan+"&vnipInputan="+_nipInputan; 
                }
                
   
            }
            function redirect3Test()
            {
                var har2="tupoksiServlet2?txtNIPBaru=<c:out value="${pns.getNipBaru()}"/>&_idUnorTambah=<c:out value="${pns.getUnorId()}"/>&jenis=<c:out value="${pns.getjnsjbtn_id()}"/>";
                url3test=document.getElementById("url3test");
                
  
                window.open(url3test.href=har2 , windowname, 'width=400,height=200,resizable = 0,scrollbars=yes'); 
            }
            function validasi4 (){
                var vbiaya4text =document.getElementById("pilih_session");
                var ddtk = vbiaya4text.options[vbiaya4text.selectedIndex].text;
                document.getElementById("session").value = ddtk;
            };   
            function alertnipnull3(evt)
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
                
            function redirect2K()
            {
                pilihan=document.getElementById("pilih_sessionw").value;
                url=document.getElementById("url");
                // url.href=url.href+"&session=" + pilihan;
                url.href=url.href+"&pilih_session=" + pilihan;
    
            };
            function redirect3K()
            {  
                var hr= "cetakIsi4FaktorServlet?nipnilai2SB=<c:out value='${pns.getNipBaru()}'/>";
                tglCetak=document.getElementById("tglCetakw").value;
                pilihan=document.getElementById("pilih_sessionw").value;
                //pilihan=document.getElementById("pilih_session").value;
                url3=document.getElementById("url3");
                //  url3.href=hr+"&tglCetak="+tglCetak; 
                url3.href=hr+"&pilih_session=" + pilihan+"&tglCetak="+tglCetak; 
                //   pilihan=document.getElementById("pilih_session").value;
                //  url3=document.getElementById("url3");
                //   url3.href=url3.href+"&pilih_session=" + pilihan+"&tglCetak="+tglCetak;;
  
            }
            function redirect4K()
            {
                pilihan=document.getElementById("pilih_sessionw").value;
                url4=document.getElementById("url4");
                url4.href=url4.href+"&pilih_session=" + pilihan;
  
            }


        </script>


        <c:set var="tingkat" value="${tingkatPengguna}" />               
        <div id="leftside">     
            <div id="place-nav" >
                <ul id="nav">
                    <li><a href="#"><div style="font-size: 20px">... </div></a>
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
    </div>
</body>
</html>
