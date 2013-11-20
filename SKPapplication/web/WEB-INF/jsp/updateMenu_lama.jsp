<%-- 
    Document   : updateMenu
    Created on : Jan 23, 2013, 8:35:52 AM
    Author     : Radius Imam Taufik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>SASARAN KERJA INDIVIDU</title>
<meta name="keywords" content="corporate, free web template" />
<meta name="description" content="SKI" />
<link href="/SKPapplication/css/styleBiru.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript">
function clearText(field)
{
    if (field.defaultValue == field.value) field.value = '';
    else if (field.value == '') field.value = field.defaultValue;
}
</script>
    
 
    </head>
    <body>
      
        <div id="templatemo_site_title_bar_wrapper">
            <div id="templatemo_site_title_bar">
                <div id="templatemo_menu">
                   
                </div>
            </div>
            
            
            
            
            
        </div>
        
        <div id="templatemo_content9" >
          
                <table width="1000" border="0">
                   
                        <%-- <td ><c:out value="${nama_jab}"/></td> --%>
                    
                         
         <tr>
		<td>NAMA :</td>
		<td><c:out value="${pns.getNamaPns()}"/></td>
                     <td></td>
	</tr>
	<tr>
		<td>NIP :</td>
		<td><c:out value="${pns.getNipBaru()}"/></td>
                     <td></td>
	</tr>
	<tr>
		<td>INSTANSI KERJA :</td>
		<td><c:out value="${ins.getNamaInstansi()}"/></td>
                <td><input type="hidden" name="idInstansiText" value="${ins.getIdInstansi()}"/></td>
	</tr>
        <tr>
		<td>JABATAN :</td>
		<td><c:out value="${pns.getNamaJabatan()}"/></td>
                <td></td>
	</tr>
	



        <tr>
		<td>UNIT KERJA :</td>
		<td><c:out value="${pns.getNamaUnor()}"/></td>
	</tr>
        
        
	
  



</table>
           
           
             
            
                  <form name="form2" method="post" action="referensiInstansiServlet">
                <table> 
             <tr>
		
		<td> <input name="updateUnor" type="text" size="75"/></td>
                <td> <input name="cariUnorUpdate" type="Submit" value="CARI" class="button black bigrounded"/> </td>
                <td>  <input  type="hidden"  name="idnip" value="${pns.getNipBaru()}"/> </td>
                <td> <input  type="hidden"  name="instansi" value="${pns.getInstansiId()}"/> </td>
              
	</tr>
         </table>
   
        
       
            </form>
        </div>
        
        <div id="templatemo_content_p" class="scroll3">
            <table width="1194" border="1">
                <td colspan ="3">UPDATE UNOR ATASAN</td>
                <c:forEach var="listUnories" items="${unories}" varStatus="count">
                    <tr>
                        <td width="20"><div align="center">${(count.index)+1}</div></td>
                      
                        <td width="750">
                             <a href="referensiInstansiServlet?&idUnorBaru=<c:out value="${listUnories.getIdUnor()}"/>&nipBaru=<c:out value="${pns.getNipBaru()}"/>&jenis=<c:out value="${pns.getjnsjbtn_id()}"/>&diatasanId=<c:out value="${listUnories.getDiAtasanId()}"/>&namaUnorL=<c:out value="${listUnories.getNamaUnor()}"/>&jenisStatus=<c:out value="updateUnorAtasan"/>"> ${listUnories.getNamaUnor()}</a>
                        </td>
                       <%-- <td>${listUnories.getNamaJabatan()}</td> --%>
                       <td width="750">${listUnories.getNamaJabatan()}</td>
                        <%--<td><a href="referensiInstansiServlet?&idInstkode=<c:out value="${listInstansies.getIdInstansi()}"/>&namaInstansiL=<c:out value="${listInstansies.getNamaInstansi()}"/>">${listInstansies.getNamaInstansi()}</a></td>--%>
                    </tr>
                </c:forEach>
            </table>
            <a href="GetPnsServlet?txtNIPBaruB=<c:out value="${pns.getNipBaru()}"/>" target="_parent" title="Target Sasaran SKI"><span></span>Kembali</a>
    </div>
        
        
        
        
        
        
        
        
        
        
        
        
        
    </body>
</html>
