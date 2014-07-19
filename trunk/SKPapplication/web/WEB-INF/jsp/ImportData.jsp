<%-- 
    Document   : ImportData
    Created on : 06 Feb 14, 8:42:33
    Author     : Sony
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>JSP Page</title>
        <script type="text/javascript" src="/SKPapplication/js/jquery-1.7.1.min.js"></script>
        <script type="text/javascript" src="/SKPapplication/js/jquery.slidertron-1.1.js"></script>


        <link href="/SKPapplication/css/styleawan.css" rel="stylesheet" type="text/css" />
        <link href="/SKPapplication/css/style2.css" rel="stylesheet" type="text/css" />


        <!--[if gte IE 9 ]><link rel="stylesheet" type="text/css" href="_styles.css" media="screen"><![endif]-->
        <!--[if !IE]>--><link rel="stylesheet" type="text/css" href="/SKPapplication/css/_styles.css" media="screen"/><!--<![endif]-->
        <script language="javascript" type="text/javascript">
      
    
     
            function ButtonBackNit(id)
            {
                pilihan=document.getElementById("pilih_session_monit");
                alert(id);
                location = 'isiPerilakuServlet?nipatasanMonitoring2=<c:out value="${nipAtasan}"/>';
            };
        </script>

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
                top : 110px;
                left : 170px;
                width : 1200px;
                height : 501px;
                overflow: auto;
            }
            #contentdalamsub{
                position :  absolute;
                top : 50px;
                left : 1px;
                width : 1200px;
                height : 500px;
                overflow: auto;
            }
            #contentdalamsubajak{
                position :  absolute;
                top : 10px;
                left : 500px;
                width : 500px;
                height : 500px;
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
                width: 960px;
                height: 40px;
                background: #9999CC;

                font-family: arial;
                padding-left: 1px;
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

        <div id="wrapper">
            <form method="post" name="form1" action="SalinDataUtamaServlet" enctype="multipart/form-data" >  
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
                                <th colspan="3"><strong style="color: #000">SALIN DATA</strong>
                                    <input type="hidden" name="nipAtasan" ondblclick="showComboBox(this.value)" id ="nipAtasan" value="${nipAtasan}"/> <input type="hidden"  name="nipBaru" id ="nipBaru" value="${pns.getNipBaru()}"/></th>

                            </tr>
                            <tr>
                                <td colspan="3" align="left">
                                    <input type="file" name="filechooserfoto" id="filechooserfoto" accept="xls/sql/csv" />
                                </td>
                            </tr>
                            <tr>
                                <td>  
                                    <input type="text" id="session" name="session" /> 
                                </td>
                                <td>
                                    <select id="pilih_session"  name="pilih_session" onchange="validasi4W()" >
                                        <option value="-">-</option>
                                        <option value="pns">Pns SKP</option>
                                        <option value="unor">Unor SKP</option>

                                    </select>
                                </td> 
                                <td> <input type="submit" name="Submit" value="SIMPAN"/></td>



                                <%--<td style="background-color: #D9AD00"><a href="SalinDataUtamaServlet?action=InsertData&txtNIPBaruBData=<c:out value="${pns.getNipBaru()}"/>?filechooserfoto=<c:out value="${pns.getNipBaru()}"/>" id="url2" onclick="redirectInsertData()"  style="font-size: 20px"> Salin Data Utama</a></td> 
                               <td style="background-color: #D9AD00"><a href="SalinDataUtamaServlet?action=InsertDataUnor&txtNIPBaruBDataUnor=<c:out value="${pns.getNipBaru()}"/>" id="url3" onclick="redirectInsertData2()" style="font-size: 20px">Salin Data Unit Organisasi</a></td> --%>
                            </tr>
                            <tr>



                                <td colspan="2">
                                    <a href="SalinDataUtamaServlet?nipImportdata=<c:out value="${nipAtasan}"/>">lihat</a>
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
                        <div id="contentdalamsubajak">
                            <div style="width: 460px;overflow: scroll;background-color: #CCCCFF">
                                <table style="width: 460px">
                                    <td>
                                        <div id="koef_kreatifitas"> </div>
                                    </td>
                                </table>
                            </div>
                        </div> 

                    </div>
                </div>
                




        <input type="hidden" name="nipAtasan" id="nipAtasan" value="${nipAtasan}"/>
        <%--<input type="button" name="param" class="button black bigrounded" onclick="kembali()" value="SELESAI"/> --%>




    </form>			
</div> <!-- end of content -->



<SCRIPT TYPE="text/javascript">
    function validasi4W (){
        var vbiaya4text =document.getElementById("pilih_session");
        var ddtk = vbiaya4text.options[vbiaya4text.selectedIndex].text;
        document.getElementById("session").value = ddtk;
    };   

    function redirectInsertData(){
    
        var answer = confirm ("Yakin  Ingin Salin Data ?")
        if (answer){
            pilihan=document.getElementById("filechooserfoto").value;
            url2=document.getElementById("url2");
            url2.href=url2.href+"&pilih_session=" + pilihan; }

    }
    function redirectInsertData2(){
    
        var answer = confirm ("Yakin  Ingin Salin Data ?")
        if (answer){
            pilihan=document.getElementById("filechooserfoto").value;
            url3=document.getElementById("url3");
            url3.href=url3.href+"&pilih_session=" + pilihan; }

    }
            
    function showComboBox(value)  
    {
        //xmlHttp=GetXmlHttpObject()  
        xmlHttp=GetXmlHttpObject();  
    
        if (xmlHttp==null)  
        {
            alert ("Browser does not support HTTP Request")  
            return  ;
        } 
        var url="RequestServlet?page=validasi_unor&jenis_tambahan="+value;
        xmlHttp.onreadystatechange=stateChange2  
        xmlHttp.open("GET",url,true)  
        xmlHttp.send(null)  
    }  
    
    function showloadBox(value)  
    {
        //xmlHttp=GetXmlHttpObject()  
        xmlHttp=GetXmlHttpObject();  
    
        if (xmlHttp==null)  
        {
            alert ("Browser does not support HTTP Request")  
            return  ;
        } 
        var url="RequestServlet?page=validasi_unor&jenis_tambahan="+value;
        xmlHttp.onreadystatechange=stateChange2  
        xmlHttp.open("GET",url,true)  
        xmlHttp.send(null)  
    }  
            
    function redirect_testtAjak2(e, id)
    {
        var evt = e ? e:window.event;
        if (evt.preventDefault) evt.preventDefault();
                
        xmlHttp=GetXmlHttpObject(); 
        if (xmlHttp==null)  
        {
            alert ("Browser does not support HTTP Request")  
            return  ;
        } 
        var url=document.getElementById(id);
        // urltest=document.getElementById("urltestAjak");
        //pilihan=document.getElementById("pilih_session").value;
                   
        xmlHttp.onreadystatechange=stateChange  
        xmlHttp.open("GET",url,true)  
        xmlHttp.send(null)  
                   
        // url2.href=url2.href+"&pilih_session=" + pilihan; 

    
        // window.open(urltest.href, windowname, 'width=200,height=200,scrollbars=yes'); 
    }
            
    function stateChange2()   
    {   
        if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete")  
        {   
            document.getElementById("koef_kreatifitas").innerHTML=xmlHttp.responseText   
        }   
    }   
            
    function stateChange()   
    {   
        if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete")  
        {   
            document.getElementById("koef_kreatifitas").innerHTML=xmlHttp.responseText   
        }   
    }   
            
    function GetXmlHttpObject()
    {
        if (window.XMLHttpRequest)
        {
            return new XMLHttpRequest();
        }
        if (window.ActiveXObject)
        {
            return new ActiveXObject("Microsoft.XMLHTTP");
        }
        return null;
    }
</script>



</body>
</html>
