<%-- 
    Document   : tupoksiBaru22
    Created on : Feb 24, 2013, 11:20:08 PM
    Author     : asus-U46E
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
         <title>SASARAN KINERJA PEGAWAI</title>
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
                
                <div id="menu">
					<ul>
						 <li><a href="GetPnsServlet?txtNIPBaruB=<c:out value="${pns.getNipBaru()}"/>" target="_parent" title="Target Sasaran SKI"><span></span>KEMBALI</a></li>
                    <li><a href="RequestServlet?page=indexloginBaru" target="_parent" title="Keluar"><span></span>Keluar</a></li>
					</ul>
					<br class="clearfix" />
				</div>
                
            </div>
                    <form name="form1" method="post" action="tupoksiServlet2">
                    <div id="page">
                    
                    <table width="600" border="0" >
                 <tr>
                    <td width="200" rowspan="4"><p align="center" class="style1">&nbsp;</p>      </td>
                    <td colspan="3"><div align="right">DAFTAR TUPOKSI</div></td>
                </tr>
                <tr>
                    <td height="23">INSTANSI</td>
                    <td>:</td>
                    <td><c:out value="${ins.getNamaInstansi()}" /></td>
                </tr>
                <tr>
                    <td width="92" height="23">JABATAN</td>
                    <td>:</td>
                    <td width="712"><c:out value="${pns.getNamaJabatan()}" /></td>
                </tr>
                <tr>
                    <td>UNIT KERJA</td>
                    <td>:</td>
                    <td><c:out value="${pns.getNamaUnor()}" /></td>
                </tr>
                    
                        <tr>
                            <td></td>
                            <td></td>
                           
                                          </tr>  
            </table>
               
              <input  type="hidden"  name="idnipText" value="${pns.getNipBaru()}"/>
                    
                    <br class="clearfix" />
                    
                    
                    </div>
                    
                    <div id="page-bottom">
                        <table>
                            <tr>
                                <td>
                                    Pilih Jabatan Fungsional serumpun lainnya :
                                </td>
                        <c:if test="${jabatan == '2'}">
                            <td>
                                <select id ="jabfung" name ="jabfung" >
                                    
                                    <c:forEach var="lisJabfung" items="${lisJabfung}" varStatus="count">
                                        <option value=${lisJabfung.getId()} >  ${lisJabfung.getNama()}</option>
                                    </c:forEach>
                                </select>                                
                            </td>
                           
                            <td>
                                <input type="hidden" id="txtNIPBaru" name="txtNIPBaru" value="<c:out value="${pns.getNipBaru()}"/>"/> 
                                <input type="submit" value="cariJabatan" name="submitCari"/>
                              
                            </td>
                                </c:if>
                            </tr>
                            </table>
                        <br class="clearfix" />
                         <div class="table">	
                             <table width="1070" border="0" align="left" id="rounded-corner">
                                 <thead>
               
                <tr>
                    <th> NO </th>
                    <th>KODE </th>
                    <th>NAMA TUGAS DAN FUNGSI</th>
                    <c:if test="${jabatan == '2'}">
                    <th>ANGKA KREDIT</th>
                    </c:if>
                </tr>
               
      </thead>
                             </table>
                         </div>
         
                  <div class="scroll2" >
                                <table width="1090" id="rounded-corner" >
                <c:forEach var="listUnosi" items="${unosiServlet}" varStatus="count">
                    <tr>
                        <td>${(count.index)+1}</td>
                        <td><a href="isiTupoksiServlet?isCetak=true&nipnilai=<c:out value="${pns.getNipBaru()}"/>&kelompokTugas=<c:out value="${namaKelompok}"/>&UnorIdisert=<c:out value="${pns.getUnorId()}"/>&idTupoksi=<c:out value="${listUnosi.getIdTupoksi()}"/>">${listUnosi.getIdTupoksi()}</a></td>
                        <td>${listUnosi.getNamaTupoksi()}</td>
                        <c:if test="${jabatan == '2'}">   
                            <td><center> ${listUnosi.getangka_krdt()} </center></td>
                        </c:if>
                    </tr>
                </c:forEach> 
                   
                        

            </table>
                        
                  </div>
                        
                        
                        
                        
                        
                    </div>
        </form>
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        </div>
        <div id="footer">
			&copy; 2013 KEDEPUTIAN INFORMASI KEPEGAWAIAN.
		</div>
        
        
    </body>
</html>
