<%-- 
    Document   : indexPerilaku
    Created on : May 23, 2012, 11:05:51 AM
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
        <link href="/SKPapplication/css/style2.css" rel="stylesheet" type="text/css" />
        <script language="javascript" type="text/javascript">
            function clearText(field)
            {
                if (field.defaultValue == field.value) field.value = '';
                else if (field.value == '') field.value = field.defaultValue;
            }

            function enableTextArea()
            {    
                var rekomen = document.getElementById('rekomen');
                var textArea = document.getElementById('textarea1');
    
                if (rekomen.checked == true)
                {
                    textArea.disabled=false;
                } 
                else 
                {
                    textArea.disabled=true;
                }
            }

            function ButtonBackPerilaku(        )
            {
                location = 'GetPnsServlet?txtNIPBaruReal=<c:out value="${nipAtasan}"/>';
            }
        </script>
        <style type="text/css">
            #button {
                display: block;
                width: 175px;
                height: 45px;
                margin: 0px auto;
            }
            #button input:focus{

            }
            #button input:hover{
                background-image:url('/SKPapplication/images/clicktosend_hover.gif');
                background-position:left top;
                background-repeat:no-repeat;
            }
        </style>
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
                left : 185px;
                width : 1200px;
                height : 501px;
                overflow: auto;
            }
            #contentdalamsub{
                position :  absolute;
                top : 10px;
                left : 500px;
                width : 500px;
                height : 300px;
                overflow: auto;
            }
            #contentdalamsub2{
                position :  absolute;
                padding-left: 5px;
                padding-top: 5px;
                width : 500px;
                height : 300px;
                overflow: auto;
            }
        </style>
    </head>
    <body  >

        <div id="wrapper">

            <form method="post" name="form1" action="isiPerilakuServlet">   

                <div id="headerLokal">
                    <%@ include file="SlindronHeader.jsp" %>
                </div>   
                <div id="leftside">
                    <%@ include file="navigasiPro.jsp" %>
                </div>   

                <div id="contentdalam">

                    <div style="padding-left: 5px;padding-top: 10px;overflow: auto;width: 500px">
                        <table width="500" >

                            <c:forEach var="pnsList" items="${pnsList}" varStatus="count">
                                <c:choose>
                                    <c:when test="${count.index % 2 == 0}">
                                        <tr bgcolor="#b9c9fe">


                                            <td align="center"><a href="isiPerilakuServlet?action=Lihat&NipPerilakuLihat=<c:out value="${pnsList.getNipBaru()}"/>">${(count.index)+1}</a></td>
                                            <td ><div align="left"><a href="isiPerilakuServlet?action=Lihat&NipPerilakuLihat=<c:out value="${pnsList.getNipBaru()}"/>">${pnsList.getNipBaru()}</a></div></td>
                                            <td><div align="left"><a href="isiPerilakuServlet?action=Lihat&NipPerilakuLihat=<c:out value="${pnsList.getNipBaru()}"/>">${pnsList.getNamaPns()}</a></div></td>
                                        </tr>
                                        <td style="font-weight:normal; font-size: 12px"width="80" align="center">${listTukesi.getNilai_capaian_skp()}</td>
                                        </tr>
                                    </c:when>
                                    <c:otherwise>
                                        <tr bgcolor="#e8edff">
                                            <td  align="center"><a href="isiPerilakuServlet?action=Lihat&NipPerilakuLihat=<c:out value="${pnsList.getNipBaru()}"/>">${(count.index)+1}</a></td>
                                            <td><div align="left"><a href="isiPerilakuServlet?action=Lihat&NipPerilakuLihat=<c:out value="${pnsList.getNipBaru()}"/>">${pnsList.getNipBaru()}</a></div></td>
                                            <td><div align="left"><a href="isiPerilakuServlet?action=Lihat&NipPerilakuLihat=<c:out value="${pnsList.getNipBaru()}"/>">${pnsList.getNamaPns()}</a></div></td>
                                        </tr>
                                    </c:otherwise>

                                </c:choose>
                            </c:forEach>

                        </table>
                    </div>

                    <div id="contentdalamsub">
                        <table width="200">
                            <tr>
                                <td width="119" rowspan="9">
                                    <div align="center">
                                        <input type="submit" name="param" class="button black bigrounded" value="LIHAT">
                                            <input type="submit" name="param" class="button black bigrounded" value="SIMPAN">
                                                <input type="submit" name="param" class="button black bigrounded" value="BATAL">
                                                    <input type="hidden" name="nipAtasan" id="nipAtasan" value="${nipAtasan}">
                                                        <input type="button" name="param" onclick="ButtonBackPerilaku()" class="button black bigrounded" value="KEMBALI">
                                                            <%--<input type="submit" name="param" value="CARI TUPOKSI">--%>
                                                            </div>
                                                            </td>
                                                            <td width="150"><strong strong style="color: #000"><span class="style2">NIP PNS</span></strong></td>
                                                            <td width="2791">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong strong style="color: #000"><span class="style2"></span></strong>${nip}</td>
                                                            <input type="hidden" name="nippns" value="${nip}"></input>
                                                            </tr>
                                                            <tr>
                                                                <td><strong strong style="color: #000" ><span class="style2">NAMA PNS </span></strong></td>
                                                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong strong style="color: #000"><span class="style2"></span></strong>${nama}</td>
                                                                <input type="hidden" name="namapns" value="${nama}"></input>
                                                            </tr>
                                                            <tr>
                                                                <td><strong strong style="color: #000"><span class="style2">Periode Penilaian </span></strong></td>
                                                                <td><input type="text" name="Penilaian" value="${Penilaian}"></input></td>  
                                                            </tr>
                                                            <tr>
                                                                <td><strong strong style="color: #000"><span class="style2">Orientasi Pelayanan </span></strong></td>
                                                                <td><input type="text" name="Pelayanan" value="${Pelayanan}"></input></td>  
                                                            </tr>
                                                            <tr>
                                                                <td><strong strong style="color: #000"><span class="style2">Integritas</span></strong></td>
                                                                <td><input type="text" name="Integritas" value="${Integritas}"></input></td> 
                                                            </tr>
                                                            <tr>
                                                                <td><strong strong style="color: #000"><span class="style2">Komitmen</span></strong></td>
                                                                <td><input type="text" name="Komitmen" value="${Komitmen}"></input></td> 
                                                            </tr>
                                                            <tr>
                                                                <td><strong strong style="color: #000"><span class="style2">Disiplin</span></strong></td>
                                                                <td><input type="text" name="Disiplin" value="${Disiplin}"></input></td>
                                                            </tr>
                                                            <tr>
                                                                <td><strong strong style="color: #000"><span class="style2">Kerjasama</span></strong></td>
                                                                <td><input type="text" name="Kerjasama" value="${Kerjasama}"></input></td> 
                                                            </tr>
                                                            <c:if test="${jenis == '1'}">
                                                                <tr>
                                                                    <td><strong strong style="color: #000"><span class="style2">Kepemimpinan</span></strong></td>
                                                                    <td><input type="text" name="Kepemimpinan" value="${Kepemimpinan}"> </input></td> 
                                                                </tr>                                
                                                            </c:if>

                                                            </table> 
                                                            </div>

                                                            <div id="contentdalamsub2">
                                                                <table width="35%">
                                                                    <tr>
                                                                        <td><strong strong style="color: #000"><span class="style2">NIP PNS</span></strong></td>
                                                                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2"></span></strong>${nip}</td>
                                                                        <input type="hidden" name="nippns" value="${nip}"></input>
                                                                    </tr>
                                                                    <tr>
                                                                        <td><strong strong style="color: #000"><span class="style2">NAMA PNS </span></strong></td>
                                                                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2"></span></strong>${nama}</td>
                                                                        <input type="hidden" name="namapns" value="${nama}"></input>
                                                                    </tr>
                                                                    <tr>
                                                                        <td><strong strong style="color: #000"><span class="style2">Periode Penilaian </span></strong></td>
                                                                        <td><input type="text" id="Penilaian" name="Penilaian" value="${Penilaian}" disabled></input></td>  
                                                                    </tr>
                                                                    <tr>
                                                                        <td colspan="2">
                                                                            <input type="checkbox" id="rekomen" name="rekomen" value="rekomen" onclick="enableTextArea()">Rekomendasi Atasan Langsung</input>
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td width="120" colspan="2"><textarea rows="9" id="textarea1" name="textarea1" cols="80" disabled></textarea></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td colspan="2"><input type="submit" name="param" class="button black bigrounded" value="REKOMENDASI"></td>
                                                                    </tr>
                                                                </table>  
                                                            </div>
                                                            </div>    
                                                            </form>			
                                                            </div>


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
                                                                    background: -webkit-gradient(linear, left top, left bottom, from(#666), to(darkorange));
                                                                    background: -moz-linear-gradient(top,  #666,  darkorange);
                                                                    filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#666666', endColorstr='darkorange');
                                                                }
                                                                .black:hover {
                                                                    background: #000;
                                                                    background: -webkit-gradient(linear, left top, left bottom, from(#444), to(darkorange));
                                                                    background: -moz-linear-gradient(top,  #444, darkorange);
                                                                    filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#444444', endColorstr='darkorange');
                                                                }
                                                                .black:active {
                                                                    color: #666;
                                                                    background: -webkit-gradient(linear, left top, left bottom, from(#000), to(#444));
                                                                    background: -moz-linear-gradient(top,  #000,  #444);
                                                                    filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='darkorange', endColorstr='#666666');
                                                                }
                                                            </style>

                                                            </body>
                                                            </html>
