<%-- 
    Document   : realisasiBaru2
    Created on : Feb 14, 2013, 9:01:52 AM
    Author     : asus-U46E
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TARGET</title>
         <link href="http://fonts.googleapis.com/css?family=Abel" rel="stylesheet" type="text/css" />

        <link rel="stylesheet" type="text/css" href="style2.css" />
        <script language="javascript" type="text/javascript">
function alertnipnull(evt)
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

function validasi0 (){
    var vkuantitas4text = document.getElementById("kuantitas4text"); 
     if(vkuantitas4text.value == "-"){ 
        document.getElementById("kuantitas4text").value = "";
            kuantitas4text.focus(); 
           
    } 
};
function validasi2 (){
    var vidkualitas4text = document.getElementById("idkualitas4text"); 
     if(vidkualitas4text.value == "-"){ 
        document.getElementById("idkualitas4text").value = "";
            vidkualitas4textt.focus(); 
           
    } 
};
 function validasi3 (){
    var vwaktu4text =document.getElementById("waktu4text");
     if(vwaktu4text.value == "-"){ 
        document.getElementById("waktu4text").value = "";
           vwaktu4text.focus(); 
           
    } };
    function validasi4 (){
    var vbiaya4text =document.getElementById("biaya4text");
     if(vbiaya4text.value == "-"){ 
        document.getElementById("biaya4text").value = "";
            vbiaya4text.focus(); 
           
    } 
};   


function validasitest(){
var vkuantitas4text = document.getElementById("kuantitasRtext"); 
var vidkualitas4text = document.getElementById("kualitasRtext"); 
var vwaktu4text = document.getElementById("waktuRtext");
var vbiaya4text =  document.getElementById("biayaRtext");

if(vkuantitas4text.value == "-"||vkuantitas4text.value == ""){
    alert("Mohon Cek untuk Kuantitas");
    return false;
    }
if(vidkualitas4text.value == "-"||vidkualitas4text.value == ""){
    alert("Mohon Cek untuk Kualitas");
    return false;
    }
if(vwaktu4text.value == "-"||vwaktu4text.value == ""){
    alert("Mohon Cek untuk Waktu");
    return false;
    }
if(vbiaya4text.value == "-"||vbiaya4text.value == ""){
    alert("Mohon Cek untuk Biaya");
    return false;
    }

else{
    return true;
}

}

   function validasi(){ 
        //document.getElementById("kuantitas4text").value
        var vkuantitas4text = document.getElementById("kuantitasRtext"); 
        var vidkualitas4text = document.getElementById("kualitasRtext"); 
        var vwaktu4text = document.getElementById("waktuRtext");
        var vbiaya4text =  document.getElementById("biayaRtext");
        //var namaUnorText= document.getElementById("namaUnorTex");
//        var cariUmum = document.getElementById("cariUmum");
 
    if(vkuantitas4text.value == "-" || vkuantitas4text.value == "" ){ 
      
        vkuantitas4text.focus(); 
            return false; 
    }
     else if(vidkualitas4text.value == "-" || vidkualitas4text.value == ""){ 
      
            vidkualitas4text.focus(); 
            return false; 
    }
      else if(vwaktu4text.value == "-" || vwaktu4text.value == ""){ 
       
            vwaktu4text.focus(); 
            return false; 
    }
else if(vbiaya4text.value == "-" || vbiaya4text.value == ""){ 
      
        vbiaya4text.focus(); 
        return false; 
 }else{
     
     
    return true; 
    } 
    
} 



function clearText(field)
{
    if (field.defaultValue == field.value) field.value = '';
    else if (field.value == '') field.value = field.defaultValue;
}



                                    
                                </script>      
    
    
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
                                            </td>
                                            <td width="100" align="left"> &nbsp;&nbsp;&nbsp;&nbsp;Login <c:out value="${sessionScope.user}" /> </td>
                                          <td width="414" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NIP <c:out value="${sessionScope.NipPnsSession}" /> </td>
                                        
                                        </tr>
                                    
                                    </table>
				</div>
                
                <div id="menuKecil">
					<ul>
                                            <li><a href="GetPnsServlet?txtNIPBaru=<c:out value="${pnsp.getNipBaru()}"/>&idTupoksi=<c:out value="${idtupoksidijsp}"/>" target="_parent" title="Realisasi Capaian SKI">Kembali</a></li>	
						 <li><a href="indexloginBaru.jsp" target="_parent" title="Keluar"><span></span>Keluar</a></li>
					
                                        </ul>
					<br class="clearfix" />
				</div>
                                                 
                
                
            </div>
    <form method="post" name="form1" action="Isi4FaktorServlet" onsubmit="return validasitest()">
        <div id="pageKecil">
    
            <table width="600" border="0">
                <tr>
                    
                    <td colspan="3"><center><span class="style1">FORM ISIAN REALISASI </span></center></td>
                  
                </tr>
                <tr>
                    <td><c:out value="${_pilih_session}" /></td> 
                    <td colspan="3">&nbsp;
                        
                    </td>
                </tr>
                
                <tr >
                   
                    <td width="100">NIP</td>
                    <td width="20">:</td>
                    <td><c:out value="${pnsp.getNipBaru()}" /></td>
                </tr> 
                <tr >
                
                    <td width="80">NAMA</td>
                    <td width="5">:</td>
                    <td  ><c:out value="${pnsp.getNamaPns()}" /></td>
                </tr> 
                <input type="hidden" name="_pilih_session" value="${_pilih_session}"/>
                <tr >
                
                    <td width="80">KODE TUPOKSI</td>
                    <td width="5">:</td>
                    <td><c:out value="${idtupoksidijsp}" /></td>
                       <input type="hidden"  name="idtupoksidiSesiion" value="${idtupoksidijsp}" />
                </tr> 
                <tr >
                
                    <td width="80">NAMA TUPOKSI</td>
                    <td width="5">:</td>
                    <td  ><c:out value="${namaTupoksijsp}" /></td>
                </tr> 




                <tr>

                    <td colspan="3">
                        &nbsp;
                    </td>
                </tr>
                    
                </table>
                </div>
                
                <div id="pageKecil-bottomkecil">
                    <div id="pageKecil-bottomkecil-kiri">
                        <table border ="0" width="250">
                            <tr >
                                <td colspan="4">
                            <center>TARGET</center>
                                </td>
                            </tr>
                            <tr >
                                <td colspan="4">&nbsp;
                                    
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Angka Kredit
                                </td>
                                <td>
                                    :
                                </td>
                                <td colspan="2">
                                    ${realisasiIsi4faktorTupoksiId.getangkaKrdt4()} <input type="hidden" name="angkakrdt4" value="${realisasiIsi4faktorTupoksiId.getangkaKrdt4()}"/>
                                </td>
                                
                                
                            </tr>
                            <tr>
                                <td>
                                    Kuantitas
                                </td>
                                <td>
                                    :
                                </td>
                                <td colspan="2">
                                    ${realisasiIsi4faktorTupoksiId.getKuantitas4()} &nbsp; ${realisasiIsi4faktorTupoksiId.getKuantitas_label()}
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    Kualitas
                                </td>
                                <td>
                                    :
                                </td>
                                <td>
                                   ${realisasiIsi4faktorTupoksiId.getKualitas4()} 
                                </td>
                                <td>
                                    %
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    Waktu
                                </td>
                                <td>
                                    :
                                </td>
                                <td>
                                    ${realisasiIsi4faktorTupoksiId.getWaktu4()} 
                                </td>
                                <td>
                                    bln
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Biaya
                                </td>
                                <td>
                                    :
                                </td>
                                <td colspan="2">
                                    Rp. ${realisasiIsi4faktorTupoksiId.getBiaya4()} &nbsp; ,-
                                </td>
                                
                            </tr>

                            
                            
                        </table>
                  </div>
                    <div id="pageKecil-bottomkecil-kanan">
                         <table width="300" border ="0">
                            <tr >
                                <td colspan="4">
                            <center>REALISASI</center>
                                </td>
                            </tr>
                            <tr >
                                <td colspan="4">&nbsp;
                                    
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Angka Kredit
                                </td>
                                <td>
                                    :
                                </td>
                                <td colspan="2">
                                  ${realisasiIsi4faktorTupoksiId.getangkaKrdt4()} <input type="hidden" name="angkakrdt4" value="${realisasiIsi4faktorTupoksiId.getangkaKrdt4()}"/>
                                </td>
                                
                                
                            </tr>
                            <tr>
                                <td>
                                    Kuantitas
                                </td>
                                <td>
                                    :
                                </td>
                                <td colspan="2">
                                    <input size="10" type="text" align="right" name="kuantitasRtext" id="kuantitasRtext"  value="${realisasiIsi4faktorTupoksiId.getKuantitasr()}" style="text-align: right" onkeypress="return alertnipnull(event)" onfocus="clearText(this)" />&nbsp;${realisasiIsi4faktorTupoksiId.getKuantitas_label()}                              
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    Kualitas
                                </td>
                                <td>
                                    :
                                </td>
                                <td colspan="2">
                                    <input size="10" type="text" name="kualitasRtext" id="kualitasRtext" value="${realisasiIsi4faktorTupoksiId.getKualitasr()}" align="right" style="text-align: right" onfocus="clearText(this)" onkeypress="return alertnipnull(event)"/>%
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    Waktu
                                </td>
                                <td>
                                    :
                                </td>
                                <td colspan="2">
       <input size="10" type="text" name="waktuRtext" id="waktuRtext" maxlength="2" value="${realisasiIsi4faktorTupoksiId.getWaktur()}" align="right" style="text-align: right" onfocus="clearText(this)" onkeypress="return alertnipnull(event)"/> bln                   
                                </td>
                              
                            </tr>
                            <tr>
                                <td>
                                    Biaya
                                </td>
                                <td>
                                    :
                                </td>
                                <td colspan="2">
                                    Rp. <input type="text" name="biayaRtext" id="biayaRtext" value="${realisasiIsi4faktorTupoksiId.getBiayar()}" style="text-align: right" onkeypress="return alertnipnull(event)" onfocus="clearText(this)" /> &nbsp; ,-
                                </td>
                            </tr>                       
                        </table>
                             
                               
                                       
              </div>
                                <div>
                                    &nbsp;
                                </div>
                                <input type="submit" name="paramRealisasi"  value="SIMPAN" />
                        <input type="submit" name="paramRealisasi"  value="BATAL"/>
                        
                </div>
                                                     
            </form>	
            
        </div>
                                <div id="footer">
			&copy; 2013 KEDEPUTIAN INFORMASI KEPEGAWAIAN.
		</div>
    </body>
</html>
