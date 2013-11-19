<%-- 
    Document   : TabelUnor
    Created on : Mar 1, 2012, 9:43:08 AM
    Author     : diptaisme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="form1" method="post" action="referensiInstansiServlet">
             <p>Pencarian Unit Organisasi : <input name="cariUnor" type="text" size="75">   <input name="submit" type="Submit" value="CARI"></p>
            <table width="1194" border="1">
                <tr>
                    <td colspan="4"><div align="center" class="style1"><strong><h3>TABEL REFERENSI UNIT ORGANISASI</h3></strong></div></td>
                </tr>
                <tr>
                    <td width="20"><div align="center" class="style2 style3">NO</div></td>
                    <td width="100"><div align="center" class="style5">KODE</div></td>
                    <td width="750"><div align="center" class="style5">NAMA UNIT ORGANISASI</div></td>
                    <td width="750"><div align="center" class="style5">NAMA JABATAN STRUKTURAL</div></td>
                </tr>
                <c:forEach var="listUnories" items="${unories}" varStatus="count">
                    <tr>
                        <td><div align="center">${(count.index)+1}</div></td>
                        <td>${listUnories.getIdUnor()}</td>
                        <td><a href="referensiInstansiServlet?&idUnorKode=<c:out value="${listUnories.getIdUnor()}"/>&namaUnorL=<c:out value="${listUnories.getNamaUnor()}"/>&namaIDInstansiUnor=<c:out value="${listUnories.getInstansiId()}"/>">${listUnories.getNamaUnor()}</td>
                       <%-- <td>${listUnories.getNamaJabatan()}</td> --%>
                       <td>${listUnories.getNamaJabatan()}</a></td>
                        <%--<td><a href="referensiInstansiServlet?&idInstkode=<c:out value="${listInstansies.getIdInstansi()}"/>&namaInstansiL=<c:out value="${listInstansies.getNamaInstansi()}"/>">${listInstansies.getNamaInstansi()}</a></td>--%>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>
