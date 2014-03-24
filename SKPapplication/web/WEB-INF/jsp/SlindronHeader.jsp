<%-- 
    Document   : SlindronHeader
    Created on : 01 Feb 14, 9:56:36
    Author     : Sony
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <script type="text/javascript" src="/SKPapplication/js/jquery.slidertron-1.1.js"></script>


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
            #slideshow {
                width : 1180px;
                height: 100x;
                left: 20px;
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
    </head>
    <body>
        <div id="slideshow">
            <div id="foobar">   
                <div id="col2">
                    <div class="viewer">        <div class="reel"> 
                            <div class="slide">                     <img src="images/sweet-white-blue-swirl-powerpoint-backgrounds.1440x300.jpg" width="1200" height="100" alt=""  /> <span>Direktorat Pengolahan Data.</span>
                            </div><div class="slide">                <img src="images/Abstract Blue backgrounds 3.1440x300.jpg" width="1200" height="100" alt="" /> <span>direktorat Pengolahan Data</span>
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
                        BKN
                    </td></tr>

            </table>
        </div>

        
        
        <div id="headermetting" > 
            <div id='sol'>
                <td  width="200" >  <img src="images/meeting 01.png" width="200" height="100"/>    </td>
            </div>
        </div>
        <div id="slideText">
        <div style="width: 1180px ">
            <font face="georgia"   color="White"><strong><marquee bgcolor="#CCCCFF" width="100%" scrollamount="3" behavior="alternate"><span id="warnass">Sasaran Kinerja Pegawai.. </span></marquee></strong></font></div>
        </div>

        <script type="text/javascript">
                        
            $('#foobar').slidertron({
                viewerSelector: '.viewer',
                reelSelector: '.viewer .reel',
                slidesSelector: '.viewer .reel .slide',
                advanceDelay: 3000,
                speed: 'slow'
            });
            
            $(function () {
                var $element = $('#sol');
                function fadeInOut () {
                    $element.fadeIn(1000, function () {
                        $element.fadeOut(1500, function () {
                            $element.fadeIn(1500, function () {
                                setTimeout(fadeInOut, 500);
                            });
                        });
                    });
                }

                fadeInOut();
            });
        </script>

    </body>
</html>
