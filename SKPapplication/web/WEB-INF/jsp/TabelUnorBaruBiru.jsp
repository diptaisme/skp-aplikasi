<%-- 
    Document   : TabelUnorBaruBiru
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
        <link href="/SKPapplication/css/styleBiru.css" rel="stylesheet" type="text/css" />
        <script src="/SKPapplication/js/jquery-1.7.1.min.js"></script>
        <script language="javascript" type="text/javascript">
            function clearText(field)
            {
                if (field.defaultValue == field.value) field.value = '';
                else if (field.value == '') field.value = field.defaultValue;
            }
            function redirectToFB(id){
                
                
                url3test=document.getElementById(id);
               
                window.opener.location.href=url3test;
                //url3test.href=url3test.href;
                self.close();
            }
            
        </script>

        <style type="text/css"> 
            #headerLokal {
                padding: 0px;
                width: 1000px;

                position: relative;
                height: 80px;
                left : -79px;
            }
            #leftside {

                position :  absolute;
                top : 60px;
                left : -10px;
                width : 156px;
                height : 501px;
            }

            #contentdalam {
                position :  absolute;
                top : 80px;
                left : 185px;
                width : 1200px;
                height : 501px;

            }
            #contentdalamsub {
                position: relative;
                width:  1200px;
                height: 501px;

                top : 50px;

                font-family: arial;
                padding-left: 3px;

            }
            #metik {
                position: relative;
                width: 910px;
                height: 40px;
                background: #9999CC;

                font-family: arial;
                padding-left: 1px;
                top :45px;
                text-decoration: none;
                left : 6px;


            }



            #metik  a {
                display:inline;
                text-decoration: none;
                color: #FFF;
                float: left;
                width: 40px;
                font-size: 20px;
                padding-top:10px;


            }

            #metik a:hover {
                background-color: #CCCCFF;
                color: #FF0000;
                width: 100px;
                height: 40px
            }

        </style>

    </head>
    <body>


        <form name="form1" method="post" action="referensiInstansiServlet">
            <p>Pencarian Unit Organisasi : <input name="cariUnor" id="cariUnor" type="text" size="75"/>   <input name="submit" type="Submit" value="CARI UNOR" class="button black bigrounded"/>   <%--<input name="button" type="button" value="KEMBALI" onclick="ButtonBack()" class="button black bigrounded"/>   <input name="button" type="button" value="KELUAR" onclick="ButtonExit()" class="button black bigrounded"/></p>--%>
                <input type ="hidden" name ="idInstansiText" id="idInstansiText" value="${instansi}"/>     
                <table width="1194" border="1">

                    <table width="1194" border="1">
                        <tr>

                            <td colspan="3"><div align="center" class="style1"><strong><h3>TABEL REFERENSI UNIT ORGANISASI</h3></strong></div></td>

                        </tr>
                        <tr>
                            <td width="20"><div align="center" class="style2 style3">NO</div></td>

                            <td width="750"><div align="center" class="style5">NAMA UNIT ORGANISASI</div></td>
                            <td width="750"><div align="center" class="style5">NAMA JABATAN STRUKTURAL</div></td>
                        </tr>
                    </table>

                    <table width="1194" border="1">
                        <c:forEach var="listUnories" items="${unories}" varStatus="count">
                            <tr>
                                <td width="20"><div align="center">${(count.index)+1}</div></td>

                                <td width="750"><a href="referensiInstansiServlet?idInstkode=<c:out value="${listUnories.getInstansiId()}"/>&idUnorKode=<c:out value="${listUnories.getIdUnor()}"/>&namaUnorL=<c:out value="${listUnories.getNamaUnor()}"/>&namaIDInstansiUnor=<c:out value="${listUnories.getInstansiId()}"/>" id="url3test<c:out value="${count.count}"/>"   onclick="redirectToFB(this.id)" >${listUnories.getNamaUnor()}</a></td>
                                <%-- <td>${listUnories.getNamaJabatan()}</td> --%>
                                <td width="750">${listUnories.getNamaJabatan()}</td>
                                <%--<td><a href="referensiInstansiServlet?&idInstkode=<c:out value="${listInstansies.getIdInstansi()}"/>&namaInstansiL=<c:out value="${listInstansies.getNamaInstansi()}"/>">${listInstansies.getNamaInstansi()}</a></td>--%>
                            </tr>
                        </c:forEach>
                    </table>

                </table>
        </form> 





        <SCRIPT TYPE="text/javascript">
            function ButtonBack()
            {
                location = 'RequestServlet?page=insertTupoksiBaruBiru';
            }
           
            function ButtonExit()
            {
                location = 'RequestServlet?page=indexloginBaru';
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

            function alertnipnull()
            {
                if (txtNIPBaru == null)
                {
                    window.alert("Masukkan NIP anda terlebih dahulu");
                }
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
                color: #d7d7d7;
                border: solid 1px #333;
                background: #333;
                background: -webkit-gradient(linear, left top, left bottom, from(#666), to(#000));
                background: -moz-linear-gradient(top,  #666,  #000);
                filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#666666', endColorstr='#000000');
            }
            .black:hover {
                background: #000;
                background: -webkit-gradient(linear, left top, left bottom, from(#444), to(#000));
                background: -moz-linear-gradient(top,  #444,  #000);
                filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#444444', endColorstr='#000000');
            }
            .black:active {
                color: #666;
                background: -webkit-gradient(linear, left top, left bottom, from(#000), to(#444));
                background: -moz-linear-gradient(top,  #000,  #444);
                filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#000000', endColorstr='#666666');
            }
        </style>

    </body>
</html>