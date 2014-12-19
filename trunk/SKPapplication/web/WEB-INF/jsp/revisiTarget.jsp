<%-- 
    Document   : revisiTarget
    Created on : 15 Apr 14, 14:45:21
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
        <link href="http://fonts.googleapis.com/css?family=Abel" rel="stylesheet" type="text/css" />

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

            #page-bottomBarulk {
                width: 810px;
                padding: 200px 1px 1px 1px;
                overflow: auto;

            }

            #headerLokal {
                padding: 0px;
                width: 1000px;

                position: relative;
                height: 80px;
                left : -35px;
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
                top : 70px;
                left : 160px;
                width : 1000px;
                height :1000px;

            }
            #contentdalamsub{
                position :  absolute;
                top : 50px;
                left : 1px;
                width : 1000px;
                height : 1000px;
                overflow: auto;
            }
            #contentdalamsubajak{
                position :  absolute;
                top : 10px;
                left : 500px;
                width : 800px;
                height : 500px;
                overflow: auto;
            }
            #contentdalamsub2{
                position :  absolute;
                left: 702px;
                top: 5px;
                width : 250px;
                height : 800px;
                overflow: auto;
            }
            #contentdalamsub3{
                position :  absolute;
                left: 600px;
                height : 200px;
                width : 250px;
                height : 800px;
                overflow: auto;
            }

            #met {
                position: relative;
                width: 980px;
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

        <div id="wrapper">
            <form method="post" name="form1" action="SalinDataUtamaServlet" enctype="multipart/form-data" >  
                <input type="hidden" name="nipAtasan" id ="nipAtasan" value="${nipAtasan}"/><input type="hidden"  name="nipBaru" id ="nipBaru" value="${pns.getNipBaru()}"/>
                <input type="hidden" name="nippns" value="${sessionScope.user}"/>
                <input type="hidden" name="nippns" value="${sessionScope.NipPnsSession}"/>

                <div id="headerLokal">
                    <%@ include file="SlindronHeader.jsp" %>
                </div>   
                <div id="leftside">
                    <%@ include file="navigasiPro.jsp" %>
                </div> 

                <div id="contentdalam">
                    <div id="met">
                        <ul>
                            <li>

                                <a href="RevisiServlet?action=HitungtupoksiServlet3&txtNIPBaruB=<c:out value="${pns.getNipBaru()}"/>" id="url" onclick="redirect2()"  target="_parent" >Revisi</a>
                            </li>
                            <li> <a href="NavigasiProfile?nipPengguna=<c:out value="${sessionScope.NipPnsSession}"/>">Kembali</a> 
                            </li>
                            <li>        
                                <input type="text" id="session" name="session" /> 
                            </li>
                            
                            <li> 
                                <select id="pilih_session"  name="pilih_session" onchange="validasi4()" >
                                    <option value="-">-</option>
                                    <option value="2013">2013</option>
                                    <option value="2014">2014</option>
                                    <option value="2015">2015</option>
                                    <option value="2016">2016</option>
                                    <option value="2017">2017</option>
                                    <option value="2018">2018</option>
                                    <option value="2019">2019</option>
                                    <option value="2020">2020</option>
                                </select>
                            </li>
                        </ul>
                    </div>
                    <div id="contentdalamsub">
                        <table>
                            <td style="width: 500px">
                                <table>

                                    <tr>                       
                                        <td style="font-weight:normal; font-size: 12px" width="30"><div align="left">1</div></td>
                                        <td style="font-weight:normal; font-size: 12px" width="135" align="left">Nama</td>
                                        <td>:</td>
                                        <td style="font-weight:normal; font-size: 12px" align="left"> <c:out value="${UnorAts.getNamaPns()}" /> </td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:normal; font-size: 12px"><div align="left">2</div></td>
                                        <td style="font-weight:normal; font-size: 12px" align="left">NIP</td>
                                        <td>:</td>

                                        <td style="font-weight:normal; font-size: 12px" align="left"><c:out value="${UnorAts.getNipBaru()}" /> <a href="updateServlets?instansiAtasan=<c:out value="${UnorAts.getInstansiId()}"/>&instansiIdpns=<c:out value="${pns.getNipBaru()}"/>&instansiIdunorbwhan=<c:out value="${pns.getUnorId()}"/>"><img src="images/ubah2.png"/></a></td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:normal; font-size: 12px"><div align="left">3</div></td>
                                        <td style="font-weight:normal; font-size: 12px"align="left">Pangkat/Gol.Ruang</td>
                                        <td>:</td>
                                        <td style="font-weight:normal; font-size: 12px" align="left"><c:out value="${UnorAts.getPangkat()}" /> / <c:out value="${UnorAts.getNamaGolru()}" /></td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:normal; font-size: 12px"><div align="left">4</div></td>
                                        <td style="font-weight:normal; font-size: 12px"align="left">Jabatan</td>
                                        <td>:</td>
                                        <td style="font-weight:normal; font-size: 12px"align="left"><c:out value="${UnorAts.getNamaJabatan()}" /></td>
                                    </tr> 
                                    <tr>
                                        <td style="font-weight:normal; font-size: 12px"><div align="left">5</div></td>
                                        <td style="font-weight:normal; font-size: 12px"align="left">Unit Kerja </td>
                                        <td>:</td>
                                        <td style="font-weight:normal; font-size: 12px"align="left"><c:out value="${UnorAts.getNamaUnor()}" /></td>
                                    </tr>

                                </table>
                                <%-- ===================================== USER ======================================================	--%>			
                            </td>

                            <td>
                                <table >
                                    <tr>
                                        <td style="font-weight:normal; font-size: 12px"width="30"><div align="left">1</div></td>
                                        <td style="font-weight:normal; font-size: 12px"width="135" align="left">Nama</td>
                                        <td>:</td>
                                        <td style="font-weight:normal; font-size: 12px"align="left"> <c:out value="${pns.getNamaPns()}"/> </td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:normal; font-size: 12px"><div align="left">2</div></td>
                                        <td style="font-weight:normal; font-size: 12px"align="left">NIP</td>
                                        <td>:</td>
                                        <td style="font-weight:normal; font-size: 12px"align="left"><c:out value="${pns.getNipBaru()}" /></td>


                                    <input  type="hidden"  name="_getInstansi" id="_getInstansi" value="${pns.getNipBaru()}"></input>
                                    <input  type="hidden"  name="_getidUnor"  id="_getidUnor" value="${pns.getUnorId()}">

                                    </tr>

                                    <tr> <td style="font-weight:normal; font-size: 12px"><div align="left">3</div></td>
                                        <td style="font-weight:normal; font-size: 12px"align="left">Pangkat/Gol.Ruang</td>
                                        <td>:</td>
                                        <td style="font-weight:normal; font-size: 12px"align="left"><c:out value="${pns.getPangkat()}" /> / <c:out value="${pns.getNamaGolru()}" /></td>
                                    </tr>
                                    <tr>
                                        <td><div align="left">4</div></td>
                                        <td align="left">Jabatan</td>
                                        <td>:</td>
                                        <td align="left"><c:out value="${pns.getNamaJabatan()}" /></td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:normal; font-size: 12px"><div align="left">5</div></td>
                                        <td style="font-weight:normal; font-size: 12px"align="left">Unit Kerja </td>
                                        <td>:</td>
                                        <td style="font-weight:normal; font-size: 12px"align="left"><c:out value="${pns.getNamaUnor()}" /> <a href="updateServlets?txtNIPBaru=<c:out value="${pns.getNipBaru()}"/>">  <img src="images/ubah2.png"/> </a></td>

                                    </tr>

                                </table>
                            </td>
                        </table>



                        <div style="width: 1000px;height: 200px;margin-top: 5px; ">
                            <div class="scroll2" >
                                <table >
                                    <tr style="background: #ccccff">
                                        <th  style="font-weight:normal; font-size: 12px;background-color: #9999ff" width="31" rowspan="2" >NO</th>
                                        <th style="font-weight:normal; font-size: 12px ;background-color: #9999ff" rowspan="2" width="80">KODE</th>
                                        <th style="font-weight:normal; font-size: 12px ;background-color: #9999ff" rowspan="2" width="383" >KEGIATAN TUGAS JABATAN</th>
                                        <th style="font-weight:normal; font-size: 12px ;background-color: #9999ff" colspan="6">TARGET</th>

                                    </tr>
                                    <tr style="background: #FF9900">


                                        <th style="font-weight:normal; font-size: 12px ;background-color: #9999ff" width="70">AK</th>
                                        <th style="font-weight:normal; font-size: 12px ;background-color: #9999ff" width="105">KUANT/ OUTPUT</th>
                                        <th style="font-weight:normal; font-size: 12px ;background-color: #9999ff" width="100">KUAL/ MUTU</th>
                                        <th style="font-weight:normal; font-size: 12px ;background-color: #9999ff" width="70">WAKTU</th>
                                        <th style="font-weight:normal; font-size: 12px ;background-color: #9999ff" width="136" >BIAYA</th>
                                        <th style="font-weight:normal; font-size: 12px ;background-color: #9999ff" width="31" >&nbsp;</th>  
                                    </tr>

                                    <c:forEach var="listTukesi" items="${tukesiServlet}" varStatus = "count">
                                        <c:choose>
                                            <c:when test="${count.index % 2 == 0}">
                                                <tr bgcolor="#b9c9fe">
                                                    <td style="font-weight:normal; font-size: 12px"width="31"><div align="center">${(count.index)+1}</div></td>
                                                    <td style="font-weight:normal; font-size: 12px" width="80"><div align="center"><a href ="RevisiServlet?nipnilai=<c:out value="${pns.getNipBaru()}"/>&_idUnor=<c:out value="${pns.getUnorId()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>&getIdIsi4Faktor=<c:out value="${listTukesi.getIdIsi4Faktor()}"/>">${listTukesi.getIdTupoksi()}</a></div></td>
                                                    <td style="font-weight:normal; font-size: 12px"width="383"><div align="left">${listTukesi.getNamaTupoksi()} </div></td>



                                                    <td style="font-weight:normal; font-size: 12px"width="70"><div align="right">${listTukesi.getangka_krdtR()}</div></td>


                                                    <c:if test="${(listTukesi.getvar_perubahan1())=='u'}">


                                                        <td style="font-weight:normal; font-size: 12px"width="105"><div align="right"><strike>${listTukesi.getKuantitas4()} </strike> ${listTukesi.getkuantitas_label()} </div></td>
                                                    </c:if>
                                                    <c:if test="${(listTukesi.getvar_perubahan1())!='u'}">  

                                                        <td style="font-weight:normal; font-size: 12px"width="105"><div align="right">${listTukesi.getKuantitas4()} ${listTukesi.getkuantitas_label()} </div></td>
                                                    </c:if>

                                                    <c:if test="${(listTukesi.getvar_perubahan2())=='u'}">    
                                                        <td style="font-weight:normal; font-size: 12px"width="100"><div align="right"><strike>${listTukesi.getKualitas4()} %</strike></div></td>
                                                    </c:if>

                                                    <c:if test="${(listTukesi.getvar_perubahan2())!='u'}">    
                                                        <td style="font-weight:normal; font-size: 12px"width="100"><div align="right">${listTukesi.getKualitas4()} %</div></td>
                                                    </c:if>
                                                    <c:if test="${(listTukesi.getvar_perubahan3())=='u'}">
                                                        <td style="font-weight:normal; font-size: 12px"width="70"><div align="right"><strike>${listTukesi.getWaktu4()}</strike> ${listTukesi.getwaktu_label()} (${listTukesi.getpilih_session()})</div></td>
                                                    </c:if>
                                                    <c:if test="${(listTukesi.getvar_perubahan3())!='u'}">
                                                        <td style="font-weight:normal; font-size: 12px"width="70"><div align="right">${listTukesi.getWaktu4()} ${listTukesi.getwaktu_label()} (${listTukesi.getpilih_session()})</div></td>
                                                    </c:if>
                                                    <c:if test="${(listTukesi.getvar_perubahan4())=='u'}">
                                                        <td style="font-weight:normal; font-size: 12px"width="136"><div align="right">Rp. <strike>${listTukesi.getBiaya4()}</strike></div></td>
                                                    </c:if>
                                                    <c:if test="${(listTukesi.getvar_perubahan4())!='u'}">
                                                        <td style="font-weight:normal; font-size: 12px"width="136"><div align="right">Rp. ${listTukesi.getBiaya4()}</div></td>
                                                    </c:if>
                                                    <td style="font-weight:normal; font-size: 12px"width="31"><div align="Left"><a href="RevisiServlet?idTupoksiHapus=<c:out value="${listTukesi.getIdTupoksi()}"/>&idRevisiHapus=<c:out value="${listTukesi.getid_revisiTarget()}"/>&nipHapus=<c:out value="${pns.getNipBaru()}"/>"><img src="images/hapus2.png"></img></a></div></td>
                                                </tr>
                                            </c:when>
                                            <c:otherwise>
                                                <tr bgcolor="#e8edff">
                                                    <td style="font-weight:normal; font-size: 12px"width="31"><div align="center">${(count.index)+1}</div></td>
                                                    <td style="font-weight:normal; font-size: 12px"width="80"><div align="center"><a href ="RevisiServlet?nipnilai=<c:out value="${pns.getNipBaru()}"/>&_idUnor=<c:out value="${pns.getUnorId()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>&getIdIsi4Faktor=<c:out value="${listTukesi.getIdIsi4Faktor()}"/>">${listTukesi.getIdTupoksi()}</a></div></td>
                                                    <td style="font-weight:normal; font-size: 12px"width="383"><div align="left">${listTukesi.getNamaTupoksi()}</div></td>
                                                    <td style="font-weight:normal; font-size: 12px"width="70"><div align="right">${listTukesi.getangka_krdtR()}</div></td>


                                                     <c:if test="${(listTukesi.getvar_perubahan1())=='u'}">


                                                        <td style="font-weight:normal; font-size: 12px"width="105"><div align="right"><strike>${listTukesi.getKuantitas4()} </strike> ${listTukesi.getkuantitas_label()} </div></td>
                                                    </c:if>
                                                    <c:if test="${(listTukesi.getvar_perubahan1())!='u'}">  

                                                        <td style="font-weight:normal; font-size: 12px"width="105"><div align="right">${listTukesi.getKuantitas4()} ${listTukesi.getkuantitas_label()} </div></td>
                                                    </c:if>

                                                    <c:if test="${(listTukesi.getvar_perubahan2())=='u'}">    
                                                        <td style="font-weight:normal; font-size: 12px"width="100"><div align="right"><strike>${listTukesi.getKualitas4()} %</strike></div></td>
                                                    </c:if>

                                                    <c:if test="${(listTukesi.getvar_perubahan2())!='u'}">    
                                                        <td style="font-weight:normal; font-size: 12px"width="100"><div align="right">${listTukesi.getKualitas4()} %</div></td>
                                                    </c:if>
                                                    <c:if test="${(listTukesi.getvar_perubahan3())=='u'}">
                                                        <td style="font-weight:normal; font-size: 12px"width="70"><div align="right"><strike>${listTukesi.getWaktu4()}</strike> ${listTukesi.getwaktu_label()} (${listTukesi.getpilih_session()})</div></td>
                                                    </c:if>
                                                    <c:if test="${(listTukesi.getvar_perubahan3())!='u'}">
                                                        <td style="font-weight:normal; font-size: 12px"width="70"><div align="right">${listTukesi.getWaktu4()} ${listTukesi.getwaktu_label()} (${listTukesi.getpilih_session()})</div></td>
                                                    </c:if>
                                                    <c:if test="${(listTukesi.getvar_perubahan4())=='u'}">
                                                        <td style="font-weight:normal; font-size: 12px"width="136"><div align="right">Rp. <strike>${listTukesi.getBiaya4()}</strike></div></td>
                                                    </c:if>
                                                    <c:if test="${(listTukesi.getvar_perubahan4())!='u'}">
                                                        <td style="font-weight:normal; font-size: 12px"width="136"><div align="right">Rp. ${listTukesi.getBiaya4()}</div></td>
                                                    </c:if>
                                                    <td style="font-weight:normal; font-size: 12px"width="31"><div align="Left"><a href="RevisiServlet?idTupoksiHapus=<c:out value="${listTukesi.getIdTupoksi()}"/>&idRevisiHapus=<c:out value="${listTukesi.getid_revisiTarget()}"/>&nipHapus=<c:out value="${pns.getNipBaru()}"/>"><img src="images/hapus2.png"></img></a></div></td>
                                                </tr>
                                            </c:otherwise>

                                        </c:choose>
                                    </c:forEach>
                                </table>
                            </div>
                            <table >

                                <tr>

                                    <td>
                                        <a id="url3test"  onclick="redirect3Test()"><img src="/SKPapplication/images/tambah.png"/></a>
                                    </td>

                                    <td>

                                        <a id="url3" target="_blank"  title="Cetak" onclick="redirect3()"><img src="images/cetak.png"/></a>
                                    </td>
                                    <td align="left"><span class="style3">Tgl Cetak </span></td>
                                    <td>   
                                        &nbsp;  &nbsp; <input type="text" id="tglCetak" name="tglCetak" on maxlength="8" onfocus="clearText2()" onblur="clearText()"  onkeypress="return alertnipnull3(event)"/> 
                                    </td>
                                    <td>DDMMYYYY </td>

                                </tr>
                            </table>



                        </div>
                    </div>
                    <input type="hidden" name="nipAtasan" id="nipAtasan" value="${nipAtasan}"/>
                    <%--<input type="button" name="param" class="button black bigrounded" onclick="kembali()" value="SELESAI"/> --%>




                </div>
            </form>			
        </div> <!-- end of content -->



        <SCRIPT TYPE="text/javascript">
            
            function redirect2()
            {
                pilihan=document.getElementById("pilih_session").value;
 
                url=document.getElementById("url");
 
                url.href=url.href+"&pilih_session=" + pilihan;
    
              
            }
            
            function redirect3Test()
            {
                var har2="tupoksiServlet2?txtNIPBaru=<c:out value="${pns.getNipBaru()}"/>&_idUnorTambah=<c:out value="${pns.getUnorId()}"/>&jenis=<c:out value="${pns.getjnsjbtn_id()}"/>";
                url3test=document.getElementById("url3test");
                
  
                window.open(url3test.href=har2 , windowname, 'width=400,height=200,resizable = 0,scrollbars=yes'); 
            }
            function redirect3()       
            {
                var hr="cetakIsi4FaktorServlet?action=HitungtupoksiServlet3&nipnilaiRevisi=<c:out value='${pns.getNipBaru()}'/>"; 
                tglCetak=document.getElementById("tglCetak").value;
                pilihan=document.getElementById("pilih_session").value;
                url3=document.getElementById("url3");
   
                //   url3.href=url3.href+"&pilih_session=" + pilihan+"&tglCetak="+tglCetak;
                url3.href=hr+"&pilih_session=" + pilihan+"&tglCetak="+tglCetak; 
   
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