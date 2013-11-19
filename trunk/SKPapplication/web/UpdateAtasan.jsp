<%-- 
    Document   : UpdateAtasan
    Created on : 16 Jul 13, 13:22:11
    Author     : Sony
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="http://fonts.googleapis.com/css?family=Abel" rel="stylesheet" type="text/css" />
         <link href="style2.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <form name="form1" method="post" action="updateServlets">
         <div id="wrapper"> 
            <p>Pencarian Atasan : <input name="cariInstansi" id="cariInstansi" type="text" size="75"/>   <input name="submitCari" type="Submit" value="CARINAMA"/></p>
            <table width="1194" border="1">
                <tr>
                    <td colspan="3"><div align="center" class="style1"><strong><h3>Pencarian Nama Atasan</h3></strong></div></td>
                </tr>    
                <tr>
                    
                   <input  type="hidden"  name="instansiIdpns" id="instansiIdpns" value="${instansiIdpns}"/>
                   <input  type="hidden"  name="instansiIdunorbwhan"  id="instansiIdunorbwhan" value="${instansiIdunorbwhan}"/>   
                 
                   <input name="instansiAtasan" id="instansiAtasan" type="hidden"  value="${instansiAtasan}"/>
                   
                    <td width="40"><div align="center" class="style2 style3">NO</div></td>
                    <td width="250"><div align="center" class="style5">NIP</div></td>
                    <td width="750"><div align="center" class="style5">NAMA </div></td>
                   
                </tr>
                <c:forEach var="listatasans" items="${pnsList}" varStatus="count">
                    <tr>
                        <td><div align="center">${(count.index)+1}</div></td>
                        <td>${listatasans.getNipBaru()}</td>
                        <td><a href="SimpanatasanBawahanRiwayatServlet?getIdPns=<c:out value="${listatasans.getNipBaru()}"/>&getinstansiId=<c:out value="${listatasans.getInstansiId()}"/>&getUnorId=<c:out value="${listatasans.getUnorId()}"/>"  id="url" onclick="redirect2()">${listatasans.getNamaPns()}</a></td>
                    </tr>
                </c:forEach>
            </table>
       
         </div>                
 <script language="javascript" type="text/javascript">  
 function redirect2()
{    
   instansiIdpns=document.getElementById("instansiIdpns").value;
   instansiIdunorbwhandocument=document.getElementById("instansiIdunorbwhan").value;
   url=document.getElementById("url");
   url.href=url.href+"&instansiIdpns=" +instansiIdpns+"&instansiIdunorbwhandocument="+instansiIdunorbwhandocument; 
    };

                    </script>
       </form>              
    </body>
</html>