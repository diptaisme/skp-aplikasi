<%-- 
    Document   : updateMenu2
    Created on : Feb 24, 2013, 10:17:38 PM
    Author     : asus-U46E
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UPDATE UNOR</title>
<link href="http://fonts.googleapis.com/css?family=Abel" rel="stylesheet" type="text/css" />

        <link rel="stylesheet" type="text/css" href="/SKPapplication/css/style2.css" />
    </head>
    <body>
        <div id="wrapper">
            
            <div id="header">
                <div id="logo">
                                    <table >
                                        <tr>
                                            <th rowspan="2" >
                                    <img src="images/burung_garuda7.png"/></th>
                                            <td>
                                    SASARAN KINERJA PEGAWAI
				</td>
                                        </tr>
                                        <tr><td>
                                                BKN
                                            </td></tr>
                                    
                                    </table>
				</div>
                <div id="menu">
					<ul>
						<li>
                                                     <a href="GetPnsServlet?txtNIPBaruB=<c:out value="${pns.getNipBaru()}"/>" target="_parent" title="Target Sasaran SKI"><span></span>Kembali</a>
                                                </li>

						
						 <li><a href="RequestServlet?page=indexloginBaru" target="_parent" title="Keluar"><span></span>Keluar</a></li>
					</ul>
					<br class="clearfix" />
				</div>
                
            </div>
                                                <div id="page">
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
                                                    
                                                    
                                <br class="clearfix" />                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                                </div>
                                                <div id="page-bottom">
                                                     <form name="form2" method="post" action="referensiInstansiServlet">
                <table> 
             <tr>
                 <td>Cari Unit Kerja : </td>
		<td> <input name="updateUnor" type="text" size="75"/></td>
                <td> <input name="cariUnorUpdate" type="Submit" value="CARI" /> </td>
                <td>  <input  type="hidden"  name="idnip" value="${pns.getNipBaru()}"/> </td>
                <td> <input  type="hidden"  name="instansi" value="${pns.getInstansiId()}"/> </td>
              
	</tr>
         </table>
   
        
       
            </form>
                 <div class="table">	
                <table width="1090" border="0" align="left" id="rounded-corner">
                    <thead>
                                    
                                    

                        <tr>
                <th width="20">No.</th>
                                      <th >NAMA UNIT ORGANISASI</th>
                                      
                                      <th >NAMA JABATAN</th>
                                      </tr>
                                      </thead>
                                      </table>
                 </div>
                                                    <div class="scroll2" >
                                                        <table width="1090" id="rounded-corner" >
                                                            
                                                          
                                      
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
                                                        
                                                    </div>
                                                    
                                                    
                                                </div>
                                     
        </div>
        
        <div id="footer">
			&copy; 2013 KEDEPUTIAN INFORMASI KEPEGAWAIAN.
		</div>
        
        
    </body>
</html>
