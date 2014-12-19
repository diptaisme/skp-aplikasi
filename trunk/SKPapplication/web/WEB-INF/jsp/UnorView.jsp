<%-- 
    Document   : UnorView
    Created on : Dec 8, 2014, 8:17:16 PM
    Author     : Diptaisme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="/SKPapplication/js/jquery-1.7.1.min.js"></script>
        <script type="text/javascript" src="/SKPapplication/js/jquery.slidertron-1.1.js"></script>


        <link href="/SKPapplication/css/styleawan.css" rel="stylesheet" type="text/css" />
        <link href="/SKPapplication/css/style2.css" rel="stylesheet" type="text/css" />


       
        <style type="text/css"> 
            #headerLokal {
                padding: 0px;
                width: 1000px;

                position: relative;
                height: 80px;
                left : 5px;
            }
            #leftside {

                position :  absolute;
                top : 55px;
                left : 30px;
                width : 156px;
                height : 501px;
            }

            #contentdalam {
                position :  absolute;
                top : 55px;
                left : 160px;
                width : 1200px;
                height : 501px;
               
            }
            #contentdalamsub{
                position :  absolute;
                top : 65px;
                left : 1px;
                width : 1200px;
                height : 400px;
               
            }
            #contentdalamsubajak{
                position :  absolute;
                top : 55px;
                left : 4px;
                width : 800px;
                height : 400px;
                overflow: auto;
            }
            #contentdalamsub2{
                position :  absolute;
                left: 702px;
                top: 5px;
                width : 250px;
                height : 500px;
                overflow: auto;
            }
            #contentdalamsub3{
                position :  absolute;
                left: 600px;
                height : 200px;
                width : 250px;
                height : 300px;
                overflow: auto;
            }

            #met {
                position: relative;
                width: 970px;
                height: 40px;
                background: #9999CC;

                font-family: arial;
                padding-left: 10px;
                top :0px;
                text-decoration: none;



            }
            #met ul li a {
                display: block;
                text-decoration: none;
                color: #FFF;
                padding: 10px;
                float: left;
                width: 100px;
                font-size: 18px

            }

            #met ul li a:hover {
                background-color: #CCCCFF;
                color: #FF0000;
            }


        </style>

    </head>
    <body>
        <form method="post" name="form1" action="UnorView" >  
            <input type="hidden" name="nipAtasan" id ="nipAtasan" value="${nipAtasan}"/><input type="hidden"  name="nipBaru" id ="nipBaru" value="${pns.getNipBaru()}"/>
            <div id="headerLokal">
                <%@ include file="SlindronHeader.jsp" %>
            </div>   
            <div id="leftside">
                <%@ include file="navigasiPro.jsp" %>
            </div> 

            <div id="contentdalam">
                <div id="met">
                    <ul>

                        <li> <a href="NavigasiProfile?nipPengguna=<c:out value="${sessionScope.NipPnsSession}"/>">Kembali</a> 
                        </li>
                    </ul>
                </div>


                <div id="contentdalamsub">
                    <table width="500" border="1" >
                        <tr>
                            <td>
                                <b>Instansi :</b>
                                <input  type="hidden"  name="idInstansiText" id="idInstansiText" value="${kodeInstansi}"/>
                                
                            </td>
                            <td colspan="3">
                                <c:out value="${InstansiName}" />
                            </td>
                        </tr>
                        <%--
                        <tr>
                            <td>
                                    <select id="pilih_session"  name="pilih_session" onchange="validasi4W()" >
                                        <option value="-">Pilih Eselon</option>
                                        <option value="eselon1">Eselon 1</option>
                                        <option value="eselon2">Eselon 2</option>
                                        <option value="eselon3">Eselon 3</option>
                                        <option value="eselon4">Eselon 4</option>
                                        <option value="eselon5">Eselon 5</option>
                                    </select>
                             </td>
                             <td colspan="2">
                                <input type="text" name="eselon111" size="100" />
                            </td>
                            <td>
                                <a  id="url"><center><img src="images/simpanButton.png"/></center></a>   
                            </td>
                        </tr>
                        --%>
                        
                        <tr>
                            <td>  
                               Tingkat Eselon I
                            </td>
                            <td>
                                <input type="text" name="eselon111" size="100" />
                            </td> 
                            <td>
                                <input  type="button" name="Submit" value="CARI UNOR esl1" onclick="popup_showwsUnitOr();" />   
                            </td>
                            <td colspan="1">
                                <input type="submit" name="Submit" value="SIMPAN esl1" onclick="return validasi();"/> 
                            </td>
                        </tr>       
                        <tr>
                            <td>  
                               Tingkat Eselon II
                            </td>
                            <td>
                                <input type="text" name="eselon222" size="100" /> 
                            </td> 
                            <td>
                                <input  type="button" name="Submit" value="CARI UNOR esl2" onclick="popup_showwsUnitOr();"    id="tombolUnitOrganisasi" />   
                            </td>
                            <td colspan="1">
                                <input type="submit" name="Submit" value="SIMPAN esl2" onclick="return validasi();"/>
                            </td>
                        </tr>
                        <tr>
                            <td>  
                               Tingkat Eselon III
                            </td>
                            <td>
                                <input type="text" name="eselon333" size="100" /> 
                            </td> 
                            <td>
                                <input  type="button" name="Submit" value="CARI UNOR esl3" onclick="popup_showwsUnitOr();"    id="tombolUnitOrganisasi" />
                            </td>
                            <td colspan="1">
                                <input type="submit" name="Submit" value="SIMPAN esl3" onclick="return validasi();"/> 
                            </td>
                        </tr>
                        <tr>
                            <td>  
                               Tingkat Eselon IV
                            </td>
                            <td>
                                <input type="text" name="eselon333" size="100" /> 
                            </td> 
                            <td>
                                <input  type="button" name="Submit" value="CARI UNOR esl4" onclick="popup_showwsUnitOr();"    id="tombolUnitOrganisasi" />          
                            </td>
                            <td colspan="1">
                                <input type="submit" name="Submit" value="SIMPAN esl4" onclick="return validasi();"/>
                            </td>
                        </tr>
                        <tr>
                            <td>  
                               Tingkat Eselon V
                            </td>
                            <td>
                                <input type="text" name="eselon555" size="100" /> 
                            </td> 
                            <td>
                                <input  type="button" name="Submit" value="CARI UNOR esl5" onclick="popup_showwsUnitOr();"    id="tombolUnitOrganisasi" />   
                            </td>
                            <td colspan="1">
                                <input type="submit" name="Submit" value="SIMPAN esl5" onclick="return validasi();"/> 
                            </td>
                        </tr>
                        
                        <tr>
                            <td colspan="4">
                                    <a href="SalinDataUtamaServlet?nipImportdata=<c:out value="${nipAtasan}"/>">Lihat Daftar UNOR</a>
                            </td>
                        </tr>
                        
                        </table> 
                        
                            <ol class="tree" >
                            <ol>   
                                <c:forEach var="pnsBaw" items="${pnsBawahan}" varStatus="count">
                                    <li> 
                                        <label for="folder<c:out value="${count.count}"/>"><c:out value="${pnsBaw.getNamaUnor()}"/></label>
                                        <input type="checkbox" ondblclick="showComboBox(this.value)" id="folder<c:out value="${count.count}"/>" value="${pnsBaw.getIdUnor()}" />
                                        <ol>

                                            <c:forEach var="pnsBaw2" items="${pnsBawahan2}" varStatus="count2">
                                                <c:choose>
                                                    <c:when test="${(pnsBaw2.getDiAtasanId() == pnsBaw.getIdUnor() )}">  

                                                        <li>                                                            
                                                            
                                                                    <label for="folder2<c:out value="${count2.count}"/>"><c:out value="${pnsBaw2.getNamaUnor()}"/></label>
                                                                    <input type="checkbox"  ondblclick="showComboBox(this.value)" id="folder2<c:out value="${count2.count}"/>" value="${pnsBaw2.getIdUnor()}" /> 
                                                                   
                                                              

                                                            <ol>  
                                                                <c:forEach var="pnsBaw3" items="${pnsBawahan3}" varStatus="count3">
                                                                    <c:choose>
                                                                        <c:when test="${(pnsBaw3.getDiAtasanId()== pnsBaw2.getIdUnor() )}">  

                                                                            <li>


                                                                                        <label for="folder<c:out value="${count3.count}"/>"><c:out value="${pnsBaw3.getNamaUnor()}"/></label>
                                                                                        <input type="checkbox"  ondblclick="showComboBox(this.value)" id="folder3<c:out value="${count3.count}"/>" value="${pnsBaw3.getIdUnor()}" /> 
                                                                                      
                                                                                  

                                                                                <ol>
                                                                                    <c:forEach var="pnsBaw4" items="${pnsBawahan4}" varStatus="count4">
                                                                                        <c:choose>
                                                                                            <c:when test="${(pnsBaw4.getDiAtasanId() == pnsBaw3.getIdUnor() )}"> 


                                                                                                <li>


                                                                                                            <label for="folder<c:out value="${count4.count}"/>"><c:out value="${pnsBaw4.getNamaUnor()}"/></label>
                                                                                                            <input type="checkbox"  ondblclick="showComboBox(this.value)" id="folder4<c:out value="${count4.count}"/>" value="${pnsBaw4.getIdUnor()}" />
                                                                                                          
                                                                                                     
                                                                                                </li>

                                                                                            </c:when>
                                                                                        </c:choose>
                                                                                    </c:forEach>
                                                                                </ol>
                                                                            </li>
                                                                        </c:when>
                                                                    </c:choose>
                                                                </c:forEach>  
                                                            </ol>         
                                                        </li>                     
                                                    </c:when>
                                                </c:choose>
                                            </c:forEach>  

                                        </ol>    
                                    </li>
                                </c:forEach>
                            </ol>      
                        </ol>
                      
                </div>
            </div>


         
        </form>	

        <SCRIPT TYPE="text/javascript">
             function popup_showwsUnitOr() {
                jabatan2=  document.getElementById('namaUnorText').value;
                unitOrg= document.getElementById('idInstansiText').value;
                idInstansi=document.getElementById('idInstansiText').value;
                document.write("jabatan2 = "+jabatan2);
                document.write(unitOrg);
                document.write(idInstansi);
                var w = 700;
                var h = 400;
                var winl = (screen.width-w)/2;
                var wint = (screen.height-h)/2;
                if (winl < 0) winl = 0;
                if (wint < 0) wint = 0;
                var page = "referensiInstansiServlet?pagepopUnor=popshow&idInstansiText="+unitOrg+"&idInstansi="+idInstansi;
              
                windowprops = "height="+h+",width="+w+",top="+ wint +",left="+ winl +",location=no,"
                    + "scrollbars=yes,menubars=no,toolbars=no,resizable=no,status=yes";
                window.open(page, "myWindow", windowprops);
            };
            
             function validasi(){ 
        //document.getElementById("kuantitas4text").value
        var vkuantitas4text = document.getElementById("kuantitasRtext"); 
        var vidkualitas4text = document.getElementById("kualitasRtext"); 
        var vwaktu4text = document.getElementById("waktuRtext");
        var vbiaya4text =  document.getElementById("biayaRtext");
        //var namaUnorText= document.getElementById("namaUnorTex");
//        var cariUmum = document.getElementById("cariUmum");
 
    if(vkuantitas4text.value === "-" || vkuantitas4text.value === "" ){ 
      
        vkuantitas4text.focus(); 
            return false; 
    }
     else if(vidkualitas4text.value === "-" || vidkualitas4text.value === ""){ 
      
            vidkualitas4text.focus(); 
            return false; 
    }
      else if(vwaktu4text.value === "-" || vwaktu4text.value === ""){ 
       
            vwaktu4text.focus(); 
            return false; 
    }
else if(vbiaya4text.value === "-" || vbiaya4text.value === ""){ 
      
        vbiaya4text.focus(); 
        return false; 
 }else{
     
     
    return true; 
    } 
    
} ;
        </script>

    </body>
</html>
