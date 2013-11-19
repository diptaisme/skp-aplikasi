<%-- 
    Document   : indexRealisasiBaruBiru2
    Created on : Feb 10, 2013, 10:15:03 PM
    Author     : asus-U46E
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<script language="javascript" type="text/javascript">
     function validasi4 (){
               var vbiaya4text =document.getElementById("pilih_session");
               var ddtk = vbiaya4text.options[vbiaya4text.selectedIndex].text;
                document.getElementById("session").value = ddtk;
};   

function redirect()
{
   pilihan=document.getElementById("pilih_session");
   var pilihanSelected = pilihan.options[pilihan.selectedIndex].text;
   url=document.getElementById("url");   
    url.href=url.href+"&pilih_session=" + pilihanSelected;    
};

function onchangecombo()
{
     document.getElementById("button1").style.bgColor = 0xFFFF00;
    
      var vbiaya4text =document.getElementById("pilih_session");
               var ddtk2 = vbiaya4text.options[vbiaya4text.selectedIndex].text;
              //  document.getElementById("session").value = ddtk2;
    
//    var e2 = document.getElementById("idKreaf");
 //   var ddtk2 = e2.value;
    
   // var e = document.getElementById("koef_kreatifitas");
   // var ddtk = e.options[e.selectedIndex].text;

    location = 'tupoksiServlet2?action=HitungtupoksiServlet2&txtNIPBaru=<c:out value="${pns.getNipBaru()}"/>&jenis=<c:out value="${pns.getjnsjbtn_id()}"/>&pilih_session='+ddtk2;
document.getElementById("button1").style.backgroundColor = '#FFFF00';

};
          
        </script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SASARAN KERJA INDIVIDU</title>
        
        <link href="http://fonts.googleapis.com/css?family=Abel" rel="stylesheet" type="text/css" />
        <link href="style2.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
         <form method="post" name="form1" action="Isi4FaktorServlet">  
        <div id="wrapper">
            <div id="header">
                <div id="logo">
                     <table >
                                      <tr>
                                            <th rowspan="2" >
                                    <img src="images/burung_garuda7.png"/></th>
                                            <td>
                                    SASARAN KERJA PEGAWAI
				</td>
                                        </tr>
                                        <tr><td>
                                                BKN
                                            </td>
                                            <td width="100" hidden="true" align="left"> &nbsp;&nbsp;&nbsp;&nbsp;Login <c:out value="${sessionScope.user}" /> </td>
                                          <td width="414" hidden="true" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NIP <c:out value="${sessionScope.NipPnsSession}" /> </td>
                                     </tr>
                                        
                     </table>
                </div>
                <div id="menu">
                    <ul>
                        <li><a href="GetPnsServlet?txtNIPBaruB=<c:out value="${pns.getNipBaru()}"/>" target="_parent" title="Target Sasaran SKI">TARGET</a>
                            <%--   <li><a href="GetPnsServlet?txtNIPBaru=<c:out value="${pns.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>" class="current_page_item" target="_parent" title="Realisasi Capaian SKI">REALISASI</a> --%>
                    <li> <a href="GetPnsServlet?txtNIPBaru=<c:out value="${pns.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getId_tupoksi()}"/>" class="current_page_item" target="_parent" title="Realisasi Capaian SKI" id="url" onclick="redirect2()">REALISASI</a>  
                   
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
                                      
                   <li><a href="indexloginBaru.jsp" target="_parent" title="Keluar">KELUAR</a>
                    </ul>
                </div>
               
            </div>
            <div id="header2">
                <div id="menu2">
                    <ul>
                        <c:if test="${pns.getjnsjbtn_id() == '1'}">
                          <li> <a href="isiPerilakuServlet?nipAtasan=<c:out value="${pns.getNipBaru()}"/>">Persetujuan</a></li>
                          <li><a href="isiPerilakuServlet?nipAtasanMonitoring=<c:out value="${pns.getNipBaru()}"/>">Monitoring</a></li>
                          <li><a href="isiPerilakuServlet?nipnilaiPrilaku=<c:out value="${pns.getNipBaru()}"/>">PERILAKU</a></li>
                        </c:if>
                        <li>  <a href="indexKeberatanPns.jsp">KEBERATAN</a></li>
                    </ul>
                    
                </div>
            </div>

            <div id="page2">
                 <div>REALISASI</div>
                <table width="100%" id="rounded-corner2">
                                
                                    
                                    
                               <thead>
                                    
                                    

  <tr>
   <th  width="38" rowspan="2">NO.</th>
    <th rowspan="2" width="66">KODE</th>
    <th rowspan="2" width="211">KEGIATAN TUGAS POKOK JABATAN</th>
    <th colspan="5">TARGET</th>
      <th colspan="4">REALISASI</th>
          <th width="80" rowspan="2">PENGHITUNGAN</th>
    <th width="80" rowspan="2">PENCAPAIAN</th>

   </tr>
  
  <tr>
    <th width="51">AK</th>
    <th width="85">KUANT/ OUTPUT</th>
    <th width="78">KUAL/ MUTU</th>
    <th width="68">WAKTU</th>
    <th width="91" >BIAYA</th>
    
    <th width="85">KUANT/ OUTPUT</th>
    <th width="78">KUAL/ MUTU</th>
    <th width="68">WAKTU</th>
    <th width="95" >BIAYA</th>
 </tr>
 
 
            </thead>
  
            
                            </table>
                <div class="scroll3" id="hof">
                    
                    <table>
                          <c:forEach var="listTukesi" items="${realkesiServlet}" varStatus ="count">
                       <c:choose>
                    <c:when test="${count.index % 2 == 0}">
                          <tr bgcolor="#b9c9fe">
                             
                            <td width="38" align="center">${(count.index)+1}</td>
                            <td width="66" align="center"> <div align="center"><a href ="Isi4FaktorServlet?nipnilaiR=<c:out value="${pns.getNipBaru()}"/>&idTupoksiR=<c:out value="${listTukesi.getId_tupoksi()}"/>">${listTukesi.getId_tupoksi()}</a></div></td>
                            <td width="211" align="left">${listTukesi.getNama_tupoksi()}</td>
                            <td width="51" align="left">${listTukesi.getangkaKrdt4()}</td>
                            <td width="85" align="center">${listTukesi.getKuantitas4()} ${listTukesi.getKuantitas_label()}</td>
                            <td width="78" align="center">${listTukesi.getKualitas4()} %</td>
                            <td width="68"align="center">${listTukesi.getWaktu4()} ${listTukesi.getWaktu_label()}</td>
                            <td  width="91" align="center">Rp. ${listTukesi.getBiaya4()}</td>
                            <%--<td align="left">${listTukesi.getangkaKrdtr()}</td>--%>
                            <td width="85" align="center">${listTukesi.getKuantitasr()} ${listTukesi.getKuantitas_label()}</td>
                            <td width="78" align="center">${listTukesi.getKualitasr()} %</td>
                            <td width="68" align="center">${listTukesi.getWaktur()} ${listTukesi.getWaktu_label()}</td>
                            <td width="95" align="center">Rp. ${listTukesi.getBiayar()}</td>
                            <td width="80" align="center">${listTukesi.getPenghitungan()}</td>
                            <td width="80" align="center">${listTukesi.getNilai_capaian_skp()}</td>
                        </tr>
                           </c:when>
                    <c:otherwise>
                            <tr bgcolor="#e8edff">
                              
                            <td width="38" align="center">${(count.index)+1}</td>
                            <td width="66" align="center"> <div align="center"><a href ="Isi4FaktorServlet?nipnilaiR=<c:out value="${pns.getNipBaru()}"/>&idTupoksiR=<c:out value="${listTukesi.getId_tupoksi()}"/>">${listTukesi.getId_tupoksi()}</a></div></td>
                            <td width="211" align="left">${listTukesi.getNama_tupoksi()}</td>
                            <td width="51" align="left">${listTukesi.getangkaKrdt4()}</td>
                            <td width="85" align="center">${listTukesi.getKuantitas4()} ${listTukesi.getKuantitas_label()}</td>
                            <td width="78" align="center">${listTukesi.getKualitas4()} %</td>
                            <td width="68"align="center">${listTukesi.getWaktu4()} ${listTukesi.getWaktu_label()}</td>
                            <td  width="91" align="center">Rp. ${listTukesi.getBiaya4()}</td>
                            <%--<td align="left">${listTukesi.getangkaKrdtr()}</td>--%>
                            <td width="85" align="center">${listTukesi.getKuantitasr()} ${listTukesi.getKuantitas_label()}</td>
                            <td width="78" align="center">${listTukesi.getKualitasr()} %</td>
                            <td width="68" align="center">${listTukesi.getWaktur()} ${listTukesi.getWaktu_label()}</td>
                            <td width="95" align="center">Rp. ${listTukesi.getBiayar()}</td>
                            <td width="80" align="center">${listTukesi.getPenghitungan()}</td>
                            <td width="80" align="center">${listTukesi.getNilai_capaian_skp()}</td>
                             </tr>
                               </c:otherwise>
                    
                </c:choose>
                    </c:forEach>
                        
                    </table>
                    
                    
                </div>   
                
                <div>&nbsp;</div>
                <div>TUGAS TAMBAHAN</div>
     
                 <table width="1200" id="rounded-corner2">
                                    
             <thead>
                                    
                 <tr>
                    <th width="31"><div align="center">NO.</div></th>
                    <th width="138"><div align="center">KODE</div></th>
                    <th width="138"><div align="center">JENIS TUGAS</div></th>
                    <th width="383"><div align="center">NAMA TUGAS TAMBAHAN</div></th>
                    <th width="138"><div align="center">TARGET</div></th>
                    <th width="138"><div align="center">REALISASI</div></th>
                    <th width="138"><div align="center">PENGHITUNGAN </div>  </th>        
                    <th width="138"><div align="center">NILAI CAPAIAN SKP</div></th>
                </tr>
 
            </thead>
  
            
                            </table>
                
                <div class="scroll30" id="hof">
                    <table bgcolor="#FAFAD2">
                        <c:forEach var="tambahans" items="${tugasTambahans}" varStatus ="count">
                <c:choose>
                    <c:when test="${count.index % 2 == 0}">
                    <tr bgcolor="#7FFFD4">
                        <td width="31" align="center">${(count.index)+1}</td>
                        <td width="138" align="center">${tambahans.getIdTambahan()}</td>
                        <td width="138" align="left">${tambahans.getJenisTambahan()}</td>
                        <td width="383" align="left">${tambahans.getNama()}</td>
                        <td width="138" align="right">${tambahans.getNilai1()}</td>
                        <td width="138" align="right">${tambahans.getNilai2()}</td>
                        <td width="138" align="right">${tambahans.getHitungTambahan()}</td>
                        <td width="138" align="right">${tambahans.getNilaiTambahan()}</td>
                    </tr>
                     </c:when>
                     <c:otherwise>
                        <tr bgcolor=#ADFF2F">
                        <td width="31" align="center">${(count.index)+1}</td>
                        <td width="138" align="center">${tambahans.getIdTambahan()}</td>
                        <td width="138" align="left">${tambahans.getJenisTambahan()}</td>
                        <td width="383" align="left">${tambahans.getNama()}</td>
                        <td width="138" align="right">${tambahans.getNilai1()}</td>
                        <td width="138" align="right">${tambahans.getNilai2()}</td>
                        <td width="138" align="right">${tambahans.getHitungTambahan()}</td>
                        <td width="138" align="right">${tambahans.getNilaiTambahan()}</td>
                        </tr>
                      </c:otherwise>
                    
                </c:choose>
                </c:forEach>
 
                    </table>
                </div>
                
                <div>
                   <%-- <a href="tupoksiServlet?txtNIPBaruTB=<c:out value="${pns.getNipBaru()}"/>"><img src="images/tambah.png"/>
                   </a>--%>
                   <a href="tupoksiServlet2?txtNIPBaruTB=<c:out value="${pns.getNipBaru()}"/>"><img src="images/tambah.png"/>
                   </a>
                </div>
                   <div>&nbsp;</div>
                   <div>
                       KREATIFITAS
                       
                   </div>

                 <table width="1200" id="rounded-corner2">
                                
                  <thead>
                 <tr>
                    <th width="31"><div align="center">NO.</div></th>
                    <th width="138"><div align="center">KODE</div></th>
                    <th width="138"><div align="center">JENIS TUGAS</div></th>
                    <th width="383"><div align="center">NAMA KREATIFITAS</div></th>
                    <th width="138"><div align="center">TARGET</div></th>
                    <th width="138"><div align="center">REALISASI</div></th>
                    <th width="138"><div align="center">PENGHITUNGAN </div>  </th>        
                    <th width="138"><div align="center">NILAI CAPAIAN SKP</div></th>
                </tr>
 
            </thead>
  
            
                            </table>

                   <div class="scroll30" id="hof">
                       <table>
                    <c:forEach var="tambahans" items="${kereaktifitas}" varStatus ="count">
                  <c:choose>
                    <c:when test="${count.index % 2 == 0}"> 
                  <tr bgcolor="#7FFFD4">
                        <td width="31" align="center">${(count.index)+1}</td>
                        <td width="138" align="center">${tambahans.getIdTambahan()}</td>
                        <td width="138" align="left">${tambahans.getJenisTambahan()}</td>
                        <td width="383" align="left">${tambahans.getNama()}</td>
                        <td width="138" align="right">${tambahans.getNilai1()}</td>
                        <td width="138" align="right">${tambahans.getNilai2()}</td>
                        <td width="138" align="right">${tambahans.getHitungTambahan()}</td>
                        <td width="138" align="right">${tambahans.getNilaiTambahan()}</td>
                    </tr>
                       </c:when>
                     <c:otherwise>
                        <tr  bgcolor=#ADFF2F">
                          <td width="31" align="center">${(count.index)+1}</td>
                          <td width="138" align="center">${tambahans.getIdTambahan()}</td>
                          <td width="138" align="left">${tambahans.getJenisTambahan()}</td>
                          <td width="383" align="left">${tambahans.getNama()}</td>
                          <td width="138" align="right">${tambahans.getNilai1()}</td>
                          <td width="138" align="right">${tambahans.getNilai2()}</td>
                          <td width="138" align="right">${tambahans.getHitungTambahan()}</td>
                          <td width="138" align="right">${tambahans.getNilaiTambahan()}</td>
                        </tr>
                   </c:otherwise>
                    
                </c:choose>
                </c:forEach>

                       </table>
                       
                   </div>
            <div>
                             <%--<a href="tupoksiServlet?txtNIPBaruTB=<c:out value="${pns.getNipBaru()}"/>"><img src="images/tambah.png"/>
                           --%>
                           <a href="tupoksiServlet2?txtNIPBaruTB=<c:out value="${pns.getNipBaru()}"/>"><img src="images/tambah.png"/></a>
                       </div>
                             <center>
                                   <table>
                                     <tr>
                                      
                                         <%--  <td><a href="cetakIsi4FaktorServlet?nipnilai2SB=<c:out value="${pns.getNipBaru()}"/>&realisasi=realisasi" target="_blank" title="Cetak"><center><img src="images/cetak.png"/></center></a></td>--%>
                                       <%--  <td><a href="cetakIsi4FaktorServlet?nipPrestasi=<c:out value="${pns.getNipBaru()}"/>"target="_blank"><center><img src="images/cetakprestasi.png"/></center></a></td> --%>
                                        
                                         <td><a href="cetakIsi4FaktorServlet?nipPrestasi=<c:out value="${pns.getNipBaru()}"/>&realisasi2=realisasi2"  target="_blank" id="url4"  onclick="redirect4()" title="Prestasi"><center><img src="images/cetakprestasi.png"/></center></a></td> 
                                         <td><a target="_blank" id="url3"  onclick="redirect3()" title="Cetak"><center><img src="images/cetak.png"/></center></a></td>
                                         <td>Tanggal Cetak </td>
                                         <td>&nbsp;&nbsp;&nbsp;<input type="text" id="tglCetak" name="tglCetak" maxlength="8"onfocus="clearText2()" onblur="clearText()"onkeypress="return alertnipnull3(event)"/> </td>
                                         <td>DDMMYYYY </td>          
                                    </tr>
                                 </table>
                             </center>
                              
            </div>
            
        </div>
        <div id="footer">
            &copy; 2013 KEDEPUTIAN INFORMASI KEPEGAWAIAN.
        </div>
        
        
        
        <script language="javascript" type="text/javascript">

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

function clearText()
{    
    var temp = document.getElementById("tglCetak").value;
    if (temp.length==8){
    var hasil = temp.substring(0, 2) + "-"+temp.substring(2, 4)+ "-"+temp.substring(4, 8);
    document.getElementById("tglCetak").value = hasil;
    }
}
function clearText2()
{    
    var temp = document.getElementById("tglCetak").value;
    if (temp.length==10){
    var hasil = temp.substring(0, 2) + temp.substring(3, 5)+temp.substring(6, 10);
    document.getElementById("tglCetak").value = hasil;
    }
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
        
        
        
        
        
        
        </form>   
        
    </body>
</html>
