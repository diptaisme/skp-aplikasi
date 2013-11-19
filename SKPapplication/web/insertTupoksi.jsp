<%-- 
    Document   : insertTupoksi
    Created on : Feb 22, 2012, 4:36:34 PM
    Author     : diptaisme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INSERT TO TUPOKSI STRUKTURAL</title>
    </head>
    <body>
        <form name="form1" method="post" action="referensiInstansiServlet">
            <table width="900" height="200" border="0">
                <tr>
                    <td colspan="3"><div align="center" class="style1"><strong><h2>FORM PENGISIAN TUSI STRUKTURAL</h2></strong></div></td>
                </tr>
                <tr>
                    <td width="450" height="38">INSTANSI   :</td>
                    <%-- <td width="275"><input type="text" name="textfield" size="75" value=""></td> --%>
                    <td><input size="75" type="text" align="right" name="namaInstansiText" value="${instansie.getNamaInstansi()}"></td>
                        <input  type="hidden"  name="idInstansiText" value="${instansie.getIdInstansi()}">
                    
                    <%--<td width="275"><c:out value="${instansie.getNamaInstansi()}" /></td>--%>
                    <td width="75">
                        <div align="center">
                            <input type="submit" name="Submit" value="CARI INSTANSI">
                            <%-- <input type="submit" name="Submit" value="CARI" onclick="myPopupInstansi()"> --%>
                            <%--<a href="referensiInstansiServlet?asd=asd">INSTANSI</a>--%>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>UNIT ORGANISASI   :</td>
                    <%--<td width="275"><c:out value="${unorie.getNamaUnor()}" /></td>--%>
                    <td><input size="75" type="text" align="right" name="namaUnorText" value="${unorie.getNamaUnor()}"></td>
                    <input  type="hidden"  name="idUnorText" value="${unorie.getIdUnor()}"> 
                    <%--<input type="text" align="right" name="namaUnorText" value="${unorie.getNamaUnor()}" style="text-align: right">--%>
                    <td width="75">
                        <div align="center">
                           <%--<input type="submit" name="Submit" value="CARI UNOR" onclick="myPopupUnor()">--%>
                           <input type="submit" name="Submit" value="CARI UNOR">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>TUGAS POKOK DAN FUNGSI </td>
                    <td><textarea name="textarea1" cols="57" rows="6"></textarea></td>
                    <td>
                        <div align="center">
                            <input type="submit" name="Submit" value="LIHAT TUPOKSI">
                            <input type="submit" name="Submit" value="SIMPAN">
                            <input type="submit" name="Submit" value="BATAL">
                            <input type="submit" name="Submit" value="KELUAR">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>
                        <div align="center">  
                        </div>
                    </td>
                </tr>
            </table>
                           
            <table width="700" border="0" align="left">  
                   <tr>
                        <td width="20"><div align="center"><span class="style3"><strong>NO</strong></span></div></td>
                        <td width="80"><div align="center"><span class="style3"><strong>KODE</strong></span></div></td>
                        <td width="600"><div align="center"><span class="style3"><strong>NAMA TUPOKSI</strong></span></div></td>
                    </tr>
                    <tr></tr>
                    
                    <c:forEach var="listTupoksi" items="${Tupoksi}" varStatus="count">
                       
                        <tr>
                            <td><div align="center">${(count.index)+1}</div></td>
                            <td><div align="center">${listTupoksi.getIdTupoksi()}</div></td>
                            <td><div align="left">${listTupoksi.getNamaTupoksi()}</div></td>
                            <%--<td><a href ="referensiInstansiServlet?idTupoksihit=<c:out value="${listTupoksi.getIdTupoksi()}"/>">hapus</td>
                            <!--<input  type="text" id='<c:out value="${listTupoksi.getIdTupoksi()}"/>' value="<c:out value="${listTupoksi.getIdTupoksi()}"/>">-->
                            <!--<td><input type="button" name="btnHapus" value="HAPUS" onclick=""></input></td>  -->--%>                        
                            <td><a href="referensiInstansiServlet?action=HapusTupoksi&idTupoksiHapus=<c:out value="${listTupoksi.getIdTupoksi()}"/>">HAPUS</a></td>
                            <td><input type="submit" name="UPDATETUPOKSI" value="UPDATE"></td>
                        </tr>
                    </c:forEach>
             </table>               
        </form>
                           
                           
                           
        <SCRIPT TYPE="text/javascript">
            function myPopupInstansi() 
            {
                window.open("referensiInstansiServlet?isAllInstansi=true", "myWindow", "status = 0, height = 500, width = 1000, resizable = 0, scrollbars=yes")
            }
            
            function myPopupUnor() 
            {
                window.open("TabelUnor.jsp", "myWindow", "status = 0, height = 500, width = 1000, resizable = 0, scrollbars=yes")
            }
        </script> 
        
        <style type="text/css">
            body
            {
                background:#000 url(images/rusak.jpeg) repeat top left;
                margin:0;
                padding:0;
            }
        </style>
    </body>
</html>
