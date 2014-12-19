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
        <link href="/SKPapplication/css/style2.css" rel="stylesheet" type="text/css" />
        <script src="/SKPapplication/js/jquery-1.7.1.min.js"></script>

        <style type="text/css"> 
            #headerLokal {
                padding: 0px;
                width: 1000px;

                position: relative;
                height: 80px;
                left : 10px;
            }
            #leftside {

                position :  absolute;
                top : 60px;
                left : 20px;
                width : 156px;
                height : 501px;
            }

            #contentxx {
                position :  absolute;
                top : 120px;
                left : 180px;
                width : 1000px;
                height : 300px;

            }
        </style>
    </head>
    <body>
        <form name="form1" method="post" action="updateServlets">
            <div id="headerLokal">
                <%@ include file="SlindronHeader.jsp" %>
            </div>   
            <div id="leftside">
                <%@ include file="navigasiPro.jsp" %>
            </div>   
            <div id="contentxx">
                <p>Pencarian Atasan : <input name="cariInstansi" id="cariInstansi" type="text" size="50"/>   <input name="submitCari" type="Submit"   value="CARINAMA" style="background-color: #FF9900"/></p>
                <div style="height: 300px; width:500px;  overflow: scroll">
                    <table width="500"   border="0" >
                        <tr>
                            <td colspan="3"><div align="center">Pencarian Nama Atasan</div></td>
                        </tr>    
                        <tr>

                        <input  type="hidden"  name="instansiIdpns" id="instansiIdpns" value="${instansiIdpns}"/>
                        <input  type="hidden"  name="instansiIdunorbwhan"  id="instansiIdunorbwhan" value="${instansiIdunorbwhan}"/>   

                        <input name="instansiAtasan" id="instansiAtasan" type="hidden"  value="${instansiAtasan}"/>

                        <td width="50" style="background: #FF9900"><div align="center" >NO</div></td>
                        <td width="150" style="background: #FF9900"><div align="center" >NIP</div></td>
                        <td width="300" style="background: #FF9900"><div align="center" >NAMA </div></td>

                        </tr>
                        <c:forEach var="listatasans" items="${pnsList}" varStatus="count">
                            <tr>
                                <td><div align="center">${(count.index)+1}</div></td>
                                <td>${listatasans.getNipBaru()}</td>
                                <td><a href="SimpanatasanBawahanRiwayatServlet?instansiIdunorbawahan=<c:out value="${instansiIdpns}"/>&unoratasanlama=<c:out value="${unoratasanlama}"/>&nipatasanlama=<c:out value="${nipatasanlama}"/>&nip_baruuser=<c:out value="${nip_baruuser}"/>&instansiIdpns=<c:out value="${instansiIdpns}"/>&getIdPns=<c:out value="${listatasans.getNipBaru()}"/>&getinstansiId=<c:out value="${listatasans.getInstansiId()}"/>&getUnorId=<c:out value="${listatasans.getUnorId()}"/>"  id="url" onclick="redirect2()">${listatasans.getNamaPns()}</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
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