<%-- 
    Document   : IndexBaruBiru2
    Created on : Feb 7, 2013, 10:02:03 AM
    Author     : asus-U46E
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>SASARAN KINERJA PEGAWAI</title>
        <link href="http://fonts.googleapis.com/css?family=Abel" rel="stylesheet" type="text/css" />

        <link rel="stylesheet" type="text/css" href="/SKPapplication/css/style2.css" />

        <style>

            #merah { color : red }

            #biru { color : blue }

            #hijau { color : green }

            #kuning { color : yellow }

        </style>

    </head>
    <body>

        <div id="wrapper">
            <div id="header">
                <div id="logo">
                    <table >
                        <tr>
                            <th rowspan="6" >
                                <img src="/SKPapplication/images/burung_garuda7.png"/></th>
                            <td  id="hijau" width="500" >
                                SASARAN KINERJA PEGAWAI
                            </td>
                        </tr>
                        <td>
                            BKN
                        </td>
                        <tr>
                            <td id="merah" width="500" hidden="true" align="LEFT"> &nbsp;Login <c:out value="${sessionScope.user}" /> </td>
                            <td id="merah" width="414" hidden="true" align="right">&nbsp;&nbsp;NIP <c:out value="${sessionScope.NipPnsSession}" /> </td>
                        </tr> 
                    </table>

                </div>

                <c:set var="navigasi_pilihan" value="${navigasiPilihan}" />    

                <div id="menu">
                    <ul>
                        <li>
                            <%-- <a href="GetPnsServlet?txtNIPBaruB=<c:out value="${pns.getNipBaru()}"/>"class="current_page_item" target="_parent" title="Target Sasaran SKI"><span></span>Target</a> --%>

                            <a href="GetPnsServlet?action=HitungtupoksiServlet3&txtNIPBaruB=<c:out value="${pns.getNipBaru()}"/>" id="url" onclick="redirect2W()"class="current_page_item" target="_parent" title="Target Sasaran SKI">Target</a>
                        </li>
                        <li><a href="GetPnsServlet?txtNIPBaru=<c:out value="${pns.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>"  target="_parent" title="Realisasi Capaian SKI"><span></span>Realisasi</a></li> 

                        <li>
                            <%--   <c:if test="${jenis_user == '1'}">--%>

                            <a href="SalinDataUtamaServlet?action=InsertData&txtNIPBaruBData=<c:out value="${pns.getNipBaru()}"/>" id="url2" onclick="redirectInsertData()"class="current_page_item" target="_parent" title="Target Sasaran SKI">Salin Data Utama</a>

                            <%-- </c:if>--%>

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

                        <li><a href="RequestServlet?page=indexloginBaru" target="_parent" title="Keluar"><span></span>Keluar</a></li>
                    </ul>
                    <br class="clearfix" />
                </div>
            </div>
            <div id="page">
                <c:if test="${navigasi_pilihan =='3'}">
                    <table>
                        <td>   
                            <input type="text" id="nipInputan" name="nipInputan" on maxlength="18"  /> 
                        </td>
                        <td>
                            <a id="urlNip"  title="cariNip" onclick="redirectNip()"><img src="images/ubah2.png"/></a>
                        </td>
                    </table>
                </c:if>

                <div id="page-bottom-content" >


                    <table>




                        <tr>                       
                            <td width="30"><div align="left"><span class="style3">1</span></div></td>
                            <td width="135" align="left"><span class="style3">Nama</span></td>
                            <td>:</td>
                            <td width="414" align="left"> <c:out value="${UnorAts.getNamaPns()}" /> </td>
                        </tr>
                        <tr>
                            <td><div align="left"><span class="style3">2</span></div></td>
                            <td align="left"><span class="style3">NIP</span></td>
                            <td>:</td>

                            <td align="left"><c:out value="${UnorAts.getNipBaru()}" /> <a href="updateServlets?instansiAtasan=<c:out value="${ UnorAts.getInstansiId()}"/>&instansiIdpns=<c:out value="${pns.getNipBaru()}"/>&instansiIdunorbwhan=<c:out value="${pns.getUnorId()}"/>">  <img src="images/ubah2.png"/> </a></td>
                        </tr>
                        <tr>
                            <td><div align="left"><span class="style3">3</span></div></td>
                            <td align="left"><span class="style3">Pangkat/Gol.Ruang</span></td>
                            <td>:</td>
                            <td align="left"><c:out value="${UnorAts.getPangkat()}" /> / <c:out value="${UnorAts.getNamaGolru()}" /></td>
                        </tr>
                        <tr>
                            <td><div align="left"><span class="style3">4</span></div></td>
                            <td align="left"><span class="style3">Jabatan</span></td>
                            <td>:</td>
                            <td align="left"><c:out value="${UnorAts.getNamaJabatan()}" /></td>
                        </tr> <tr>
                            <td><div align="left"><span class="style3">5</span></div></td>
                            <td align="left"><span class="style3">Unit Kerja </span></td>
                            <td>:</td>
                            <td align="left"><c:out value="${UnorAts.getNamaUnor()}" /></td>
                        </tr>

                    </table>
                    <%-- ===================================== USER ======================================================	--%>			
                </div>
                <div id="page-bottom-sidebar">
                    <table >
                        <tr>
                            <td width="30"><div align="left"><span class="style3">1</span></div></td>
                            <td width="135" align="left"><span class="style3">Nama</span></td>
                            <td>:</td>
                            <td width="414" align="left"> <c:out value="${pns.getNamaPns()}"/> </td>
                        </tr>
                        <tr>
                            <td><div align="left"><span class="style3">2</span></div></td>
                            <td align="left"><span class="style3">NIP</span></td>
                            <td>:</td>
                            <td align="left"><c:out value="${pns.getNipBaru()}" /></td>


                        <input  type="hidden"  name="_getInstansi" id="_getInstansi" value="${pns.getNipBaru()}"></input>
                        <input  type="hidden"  name="_getidUnor"  id="_getidUnor" value="${pns.getUnorId()}">

                        </tr>

                        <tr> <td><div align="left"><span class="style3">3</span></div></td>
                            <td align="left"><span class="style3">Pangkat/Gol.Ruang</span></td>
                            <td>:</td>
                            <td align="left"><c:out value="${pns.getPangkat()}" /> / <c:out value="${pns.getNamaGolru()}" /></td>
                        </tr>
                        <tr>
                            <td><div align="left"><span class="style3">4</span></div></td>
                            <td align="left"><span class="style3">Jabatan</span></td>
                            <td>:</td>
                            <td align="left"><c:out value="${pns.getNamaJabatan()}" /></td>
                        </tr>
                        <tr>
                            <td><div align="left"><span class="style3">5</span></div></td>
                            <td align="left"><span class="style3">Unit Kerja </span></td>
                            <td>:</td>
                            <td align="left"><c:out value="${pns.getNamaUnor()}" /> <a href="updateServlets?txtNIPBaru=<c:out value="${pns.getNipBaru()}"/>">  <img src="images/ubah2.png"/> </a></td>

                        </tr>

                    </table>


                </div>

                <br class="clearfix" />

            </div>
            <div id="page-bottom">
                <div class="table">		
                    <table width="1070" border="0" align="left" id="rounded-corner">
                        <thead>



                            <tr>
                                <th  width="31" rowspan="2" id="kuning" >NO.</th>
                                <th rowspan="2" width="80"id="kuning" >KODE</th>
                                <th rowspan="2" width="383" id="kuning" >KEGIATAN TUGAS JABATAN</th>
                                <th colspan="6">TARGET</th>

                            </tr>
                            <tr>


                                <th width="70">AK</th>
                                <th width="105">KUANT/ OUTPUT</th>
                                <th width="100">KUAL/ MUTU</th>
                                <th width="70">WAKTU</th>
                                <th width="136" >BIAYA</th>
                                <th width="31" >&nbsp;</th>  
                            </tr>
                        </thead>
                    </table>
                </div>
                <div class="scroll2" >
                    <table width="1090" >

                        <c:forEach var="listTukesi" items="${tukesiServlet}" varStatus = "count">
                            <c:choose>
                                <c:when test="${count.index % 2 == 0}">
                                    <tr bgcolor="#b9c9fe">
                                        <td width="31"><div align="center">${(count.index)+1}</div></td>
                                        <td width="80"><div align="center"><a href ="Isi4FaktorServlet?nipnilai=<c:out value="${pns.getNipBaru()}"/>&_idUnor=<c:out value="${pns.getUnorId()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>">${listTukesi.getIdTupoksi()}</a></div></td>
                                        <td width="383"><div align="left">${listTukesi.getNamaTupoksi()} </div></td>
                                        <td width="70"><div align="right">${listTukesi.getangka_krdtR()}</div></td>
                                        <td width="105"><div align="right">${listTukesi.getKuantitas4()} ${listTukesi.getkuantitas_label()} </div></td>
                                        <td width="100"><div align="right">${listTukesi.getKualitas4()} %</div></td>
                                        <td width="70"><div align="right">${listTukesi.getWaktu4()} ${listTukesi.getwaktu_label()} (${listTukesi.getpilih_session()})</div></td>
                                        <td width="136"><div align="right">Rp. ${listTukesi.getBiaya4()}</div></td>
                                        <td width="31"><div align="Left"><a href="Isi4FaktorServlet?idTupoksiHapus=<c:out value="${listTukesi.getIdTupoksi()}"/>&nipHapus=<c:out value="${pns.getNipBaru()}"/>"><img src="images/hapus2.png"></img></a></div></td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <tr bgcolor="#e8edff">
                                        <td width="31"><div align="center">${(count.index)+1}</div></td>
                                        <td width="80"><div align="center"><a href ="Isi4FaktorServlet?nipnilai=<c:out value="${pns.getNipBaru()}"/>&_idUnor=<c:out value="${pns.getUnorId()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>">${listTukesi.getIdTupoksi()}</a></div></td>
                                        <td width="383"><div align="left">${listTukesi.getNamaTupoksi()}</div></td>
                                        <td width="70"><div align="right">${listTukesi.getangka_krdtR()}</div></td>
                                        <td width="105"><div align="right">${listTukesi.getKuantitas4()} ${listTukesi.getkuantitas_label()} </div></td>
                                        <td width="100"><div align="right">${listTukesi.getKualitas4()} %</div></td>
                                        <td width="70"><div align="right">${listTukesi.getWaktu4()} ${listTukesi.getwaktu_label()} (${listTukesi.getpilih_session()}) </div></td>
                                        <td width="136"><div align="right">Rp. ${listTukesi.getBiaya4()}</div></td>
                                        <td width="31"><div align="Left"><a href="Isi4FaktorServlet?idTupoksiHapus=<c:out value="${listTukesi.getIdTupoksi()}"/>&nipHapus=<c:out value="${pns.getNipBaru()}"/>"><img src="images/hapus2.png"></img></a></div></td>
                                    </tr>
                                </c:otherwise>

                            </c:choose>
                        </c:forEach>
                    </table>
                </div>
                <div>

                </div>
                <table >
                    <tr>   <td>
                            &nbsp;    
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <%-- <a href="tupoksiServlet2?txtNIPBaru=<c:out value="${pns.getNipBaru()}"/>&_idUnorTambah=<c:out value="${pns.getUnorId()}"/>&jenis=<c:out value="${pns.getjnsjbtn_id()}"/>"><img src="images/tambah.png"/></a>   --%>
                            <%-- <a href="GetPnsServlet?action=HitungtupoksiServlet3&txtNIPBaruB=<c:out value="${pns.getNipBaru()}"/>" id="url" onclick="redirect2()"class="current_page_item" target="_parent" title="Target Sasaran SKI">Target</a> --%>
                            <a href="tupoksiServlet2?txtNIPBaru=<c:out value="${pns.getNipBaru()}"/>&_idUnorTambah=<c:out value="${pns.getUnorId()}"/>&jenis=<c:out value="${pns.getjnsjbtn_id()}"/>" id="urltest" onclick="redirect_testt()"><img src="images/tambah.png"/></a>
                        </td>
                        <td>
                            <a id="url3test"  onclick="redirect3Test()"><img src="/SKPapplication/images/tambah.png"/></a>
                        </td>

                        <td>
                            <%--     <a href="cetakIsi4FaktorServlet?nipnilai2=<c:out value="${pns.getNipBaru()}"/>&target=target" target="_blank" title="Cetak"><img src="images/cetak.png"/></a> --%>



                            <a id="url3" target="_blank"  title="Cetak" onclick="redirect3W()"><img src="images/cetak.png"/></a>
                        </td>
                        <td align="left"><span class="style3">Tgl Cetak </span></td>
                        <td>   
                            &nbsp;  &nbsp; <input type="text" id="tglCetak" name="tglCetak" on maxlength="8" onfocus="clearText2()" onblur="clearText()"  onkeypress="return alertnipnull3(event)"/> 
                        </td>
                        <td>DDMMYYYY </td>
                        <%--   
                           <td>
                               <a href="realisasiBaru2.jsp"><img src="images/cari.png"/></a>
                           </td>
                        --%>  

                    </tr>
                </table>

            </div>

            <br class="clearfix" />
        </div>

        <div id="footer">
            &copy; 2013 KEDEPUTIAN INFORMASI KEPEGAWAIAN.
        </div>
        <script language="javascript" type="text/javascript">  
            function clearText()
            {    
                var temp = document.getElementById("tglCetak").value;
                if (temp.length==8){
                    var hasil = temp.substring(0, 2) + "-"+temp.substring(2, 4)+ "-"+temp.substring(4, 8);
                    document.getElementById("tglCetak").value = hasil;
                }
            }
            function popup(mylink, windowname)
            {
                if (! window.focus)return true;
                var href;
                if (typeof(mylink) == 'string')
                    href=mylink;
                else
                    href=mylink.href;
                window.open(href, windowname, 'width=400,height=200,scrollbars=yes');
                return false;
            }
            function myPopup2()        
            {
                window.open( "updateServlets?instansiAtasan=<c:out value="${ UnorAts.getInstansiId()}"/>&instansiIdpns=<c:out value="${pns.getNipBaru()}"/>&instansiIdunorbwhan=<c:out value="${pns.getUnorId()}"/>", "myWindow", "status = 0, height = 500, width = 1000, resizable = 0, scrollbars=yes" )
      

            }
            function clearText2()
            {    
                var temp = document.getElementById("tglCetak").value;
                if (temp.length==10){
                    var hasil = temp.substring(0, 2) + temp.substring(3, 5)+temp.substring(6, 10);
                    document.getElementById("tglCetak").value = hasil;
                }
            }

            function redirect2W()
            {
                pilihan=document.getElementById("pilih_session").value;
 
                url=document.getElementById("url");
 
                url.href=url.href+"&pilih_session=" + pilihan;
    
                // url=url+"&pilih_session=" + pilihan;
    
                // window.open(url.href, windowname, 'width=400,height=200,scrollbars=yes'); 
            }
            function redirect_testt()
            {
   
                urltest=document.getElementById("urltest");
 
                // url.href=url.href;
    
                // urltest=urltest+"&pilih_session=" + pilihan;
    
                window.open(urltest.href, windowname, 'width=200,height=200,scrollbars=yes'); 
            }
            function redirectInsertData(){
    
                var answer = confirm ("Yakin  Ingin Salin Data ?")
                if (answer){
                    pilihan=document.getElementById("pilih_session").value;
                    url2=document.getElementById("url2");
                    url2.href=url2.href+"&pilih_session=" + pilihan; }

            }
            function redirect3W()       
            {
                var hr="cetakIsi4FaktorServlet?action=HitungtupoksiServlet3&nipnilai2=<c:out value='${pns.getNipBaru()}'/>"; 
                tglCetak=document.getElementById("tglCetak").value;
                pilihan=document.getElementById("pilih_session").value;
                url3=document.getElementById("url3");
   
                //   url3.href=url3.href+"&pilih_session=" + pilihan+"&tglCetak="+tglCetak;
                url3.href=hr+"&pilih_session=" + pilihan+"&tglCetak="+tglCetak; 
   
            }
            function redirectNip()       
            {
                var hr="GetPnsServlet?action=CariNipInput&nipnilai2=<c:out value='${sessionScope.NipPnsSession}'/>"; 
                
                pilihan=document.getElementById("pilih_session").value;
                urlNip=document.getElementById("urlNip");
                _nipInputan=document.getElementById("nipInputan").value;
   
                //   url3.href=url3.href+"&pilih_session=" + pilihan+"&tglCetak="+tglCetak;
                urlNip.href=hr+"&pilih_session=" + pilihan+"&vnipInputan="+_nipInputan; 
   
            }
            function redirect3Test       ()
            {
                var har2="tupoksiServlet2?txtNIPBaru=<c:out value="${pns.getNipBaru()}"/>&_idUnorTambah=<c:out value="${pns.getUnorId()}"/>&jenis=<c:out value="${pns.getjnsjbtn_id()}"/>";
                url3test=document.getElementById("url3test");
                //  url3test.href=har2;
  
                //   url3.href=url3.href+"&pilih_session=" + pilihan+"&tglCetak="+tglCetak;
                //url3.href=hr+"&pilih_session=" + pilihan+"&tglCetak="+tglCetak; 
    

   
                //url3test=har2;
                //  url3tes =har2.href;
  
                window.open(url3test.href=har2 , windowname, 'width=400,height=200,resizable = 0,scrollbars=yes'); 
            }
            function validasi4 (){
                var vbiaya4text =document.getElementById("pilih_session");
                var ddtk = vbiaya4text.options[vbiaya4text.selectedIndex].text;
                document.getElementById("session").value = ddtk;
            };   
            function alertnipnull3(evt)
            {
                evt = (evt) ? evt : window.event
                var charCode = (evt.which) ? evt.which : evt.keyCode
                if (charCode > 31 && (charCode < 48 || charCode > 57)) 
                {
                    status = "This field accepts numbers only."
                    return false
                }
    
                status = ""
                return true
            }
            function redirect2()
{
   pilihan=document.getElementById("pilih_session").value;
   url=document.getElementById("url");
  // url.href=url.href+"&session=" + pilihan;
    url.href=url.href+"&pilih_session=" + pilihan;
    
};
function redirect3()
{  
   var hr= "cetakIsi4FaktorServlet?nipnilai2SB=<c:out value='${pns.getNipBaru()}'/>";
   tglCetak=document.getElementById("tglCetak").value;
    pilihan=document.getElementById("pilih_session").value;
   //pilihan=document.getElementById("pilih_session").value;
   url3=document.getElementById("url3");
 //  url3.href=hr+"&tglCetak="+tglCetak; 
   url3.href=hr+"&pilih_session=" + pilihan+"&tglCetak="+tglCetak; 
 //   pilihan=document.getElementById("pilih_session").value;
 //  url3=document.getElementById("url3");
  //   url3.href=url3.href+"&pilih_session=" + pilihan+"&tglCetak="+tglCetak;;
  
}
function redirect4()
{
   pilihan=document.getElementById("pilih_session").value;
   url4=document.getElementById("url4");
   url4.href=url4.href+"&pilih_session=" + pilihan;
  
}

        </script>

    </body>
</html>
