<%-- 
    Document   : RekapitulasiView
    Created on : May 8, 2014, 1:43:16 PM
    Author     : Radius Imam Taufik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="/SKPapplication/js/jquery-1.7.1.min.js"></script>
        <script type="text/javascript" src="/SKPapplication/js/jquery.slidertron-1.1.js"></script>


        <link href="/SKPapplication/css/styleawan.css" rel="stylesheet" type="text/css" />
        <link href="/SKPapplication/css/style2.css" rel="stylesheet" type="text/css" />


        <!--[if gte IE 9 ]><link rel="stylesheet" type="text/css" href="_styles.css" media="screen"><![endif]-->
        <!--[if !IE]>--><link rel="stylesheet" type="text/css" href="/SKPapplication/css/_styles.css" media="screen"/><!--<![endif]-->
        
        <style type="text/css"> 
            #headerLokal {
                padding: 0px;
                width: 1000px;

                position: relative;
                height: 80px;
                left : -10px;
            }
            #leftside {

                position :  absolute;
                top : 60px;
                left : 30px;
                width : 156px;
                height : 501px;
            }

            #contentdalam {
                position :  absolute;
                top : 110px;
                left : 200px;
                width : 1200px;
                height : 501px;
               
            }
            #contentdalamsub{
                position :  absolute;
                top : 50px;
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
        <form method="post" name="form1" action="RekapitulasiTarget" enctype="multipart/form-data" >  
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

 <input type="hidden" id="session" name="session" /> 
                <div id="contentdalamsub">
                    <table width="500" border="1" >

                        <tr>
                           
                            <td>  
                               Tingkat Eselon
                            </td>
                            <td>
                                <select id="pilih_session"  name="pilih_session" onchange="validasi4W()" >
                                    
                                    <option value="1">I</option>
                                    <option value="2">II</option>
                                    <option value="3">III</option>
                                    <option value="4">IV</option>
                                  

                                </select>
                            </td> 
                              <td colspan="1">
                                <a  id="url" onclick="redirect2K()"><center><img src="images/cetakprestasi.png"/></center></a>
                                 
                            </td>

                        </tr>
                       

                    </table>   

                    <div id="contentdalamsubajak">
                       
                            
                                    <div id="rekapanTarget"> </div>
                         
                    </div> 

                </div>
            </div>


         
        </form>	

        <SCRIPT TYPE="text/javascript">
             function ButtonBackNit(id)
            {
                pilihan=document.getElementById("pilih_session_monit");
                alert(id);
                location = 'isiPerilakuServlet?nipatasanMonitoring2=<c:out value="${nipAtasan}"/>';
            };
            function redirect2K()
            { xmlHttp=GetXmlHttpObject(); 
                if (xmlHttp==null)  
                {
                    alert ("Browser does not support HTTP Request")  
                    return  ;
                } 
                pilihan=document.getElementById("pilih_session").value;
              
                var url="RekapitulasiTarget?action=realisasi2&pilih_session="+pilihan;
                 
                 xmlHttp.onreadystatechange=stateChange45  
                xmlHttp.open("GET",url,true)  
                xmlHttp.send(null)  
    
            };
              function stateChange45()   
            {   
                if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete")  
                {   
                    document.getElementById("rekapanTarget").innerHTML=xmlHttp.responseText   
                }   
            }   
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
