<%-- 
    Document   : isi4faktorBaru2
    Created on : Feb 24, 2013, 3:11:45 PM
    Author     : asus-U46E
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ISIAN 4 FAKTOR</title>
        
         <link href="http://fonts.googleapis.com/css?family=Abel" rel="stylesheet" type="text/css" />

        <link rel="stylesheet" type="text/css" href="style2.css" />
         <style>
	 
	#merah { color : red }
	 
         #biru { color : blue }
	 
	#hijau { color : green }
        
        #kuning { color : yellow }
	 
	</style>
        <script language="javascript" type="text/javascript">
            function validasitest4Faktor(){
var vkuantitas4text = document.getElementById("kuantitas4text"); 
var vidkualitas4text = document.getElementById("idkualitas4text"); 
var vwaktu4text = document.getElementById("waktu4text");
var vbiaya4text =  document.getElementById("biaya4text");
var vpilihanKuantitas = document.getElementById("pilihanKuantitas");

if(vkuantitas4text.value == "-"||vkuantitas4text.value == ""){
    alert("Mohon Cek untuk Kuantitas");
    document.getElementById("kuantitas4text").style.backgroundColor='red';
    return false;
    }
if(vpilihanKuantitas.value == "-"||vpilihanKuantitas.value == ""){
    alert("Mohon Cek untuk Pilihan Kuantitas");
     document.getElementById("idkualitas4text").style.backgroundColor='red';
    return false;
    }

if(vidkualitas4text.value == "-"||vidkualitas4text.value == ""){
    alert("Mohon Cek untuk Kualitas");
      document.getElementById("idkualitas4text").style.backgroundColor='red';
    return false;
    }
if(vwaktu4text.value == "-"||vwaktu4text.value == ""){
    alert("Mohon Cek untuk Waktu");
      document.getElementById("waktu4text").style.backgroundColor='red';
    return false;
    }
if(vbiaya4text.value == "-"||vbiaya4text.value == ""){
    alert("Mohon Cek untuk Biaya");
     document.getElementById("biaya4text").style.backgroundColor='red';
    return false;
    }

else{
    return true;
     document.getElementById("waktu4text").style.backgroundColor='white';
     document.getElementById("biaya4text").style.backgroundColor='white';
     document.getElementById("biaya4text").style.backgroundColor='white';
     document.getElementById("biaya4text").style.backgroundColor='white';
        
}

}

window.onload=function(){
    if(${alerting != null}){
        
         alert("Data Berhasil diupdate!");
    }
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
function pilih_sessi (){
               var vbiaya4text =document.getElementById("pilih_session");
                 if(vbiaya4text.value == "-"){ 
                      document.getElementById("session").value = "";
                 }else{
               var ddtk = vbiaya4text.options[vbiaya4text.selectedIndex].text;
                document.getElementById("session").value = ddtk;
                 }
};   

function alertnipnull3(evt)
{
    evt = (evt) ? evt : window.event
    var charCode = (evt.which) ? evt.which : evt.keyCode
    if (charCode > 0) 
    {
        
        status = "This field accepts numbers only."
        return false
    }
    
    status = ""
    return true
}
function peringatan(){
    var pupup = document.getElementById("alerting"); 
if(pupup.value != null||pupup.value != ""){
alert("Data Berhasil diupdate!");
    return true;
}else{
    alert("Data Berhasil diupdate!");
     return false;
}
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
                                                B K N
                                            </td>
                                                 <td width="100" align="left"> &nbsp;&nbsp;&nbsp;&nbsp;Login <c:out value="${sessionScope.user}" /> </td>
                                                 <td width="414" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NIP <c:out value="${sessionScope.NipPnsSession}" /> </td>
                                        </tr>
                                    
                                    </table>
				</div>
                
                   <div id="menuKecil">
					<ul>
                                            <li><a href="GetPnsServlet?txtNIPBaruB=<c:out value="${pnsp.getNipBaru()}"/>" target="_parent" title="Target Sasaran SKI"><span></span>Kembali</a></li>	
						 <li><a href="indexloginBaru.jsp" target="_parent" title="Keluar"><span></span>Keluar</a></li>
					
                                        </ul>
					<br class="clearfix" />
				</div>
                
                
            </div>
            
                                                 <form method="post" name="form1" id="form1" action="Isi4FaktorServlet" onsubmit="return validasitest4Faktor()">
                <div id="pageKecil">
                    <table width="600" border="0">
                <tr>
                <input type="hidden" name="alerting" id="alerting" value="${alerting}" onload="return peringatan()"/>
                    <td colspan="3"><center><span class="style1">FORM ISIAN 4 FAKTOR </span></center></td>
                  
                </tr>
                <tr>
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
                    
                     <td id="merah">Session </td>
                    <td><input type="text" id="session" name="session" onkeypress="return alertnipnull3(event)" value="${tupoksiKeIsi4Faktor.getpilih_session()}" /> </td>
              
                           <td>  <select id="pilih_session"  name="pilih_session" onchange="pilih_sessi()" > 
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
                           </td>
                    
                </tr> 
                <tr >
                
                    <td width="80">KODE TUPOKSI</td>
                    <td width="5">:</td>
                    <td  ><c:out value="${idtupoksidijsp}" /></td>
                    <input type="hidden"  name="idtupoksidiSesiion" value="${idtupoksidijsp}" />
                    <input type="hidden"  name="_getidUnor4jspSesiion" value="${_getidUnor4jsp}" />
                </tr> 
                <tr >
                
                    <td width="80">NAMA TUPOKSI</td>
                    <td width="5">:</td>
                    <td  ><c:out value="${namaTupoksijsp}" /></td>
                </tr> 
 <tr >
                
                    <td width="80">ANGKA KREDIT</td>
                    <td width="5">:</td>
                    <td  ><c:out value="${namaAngka_krdtjsp}" /></td>
                </tr> 



                <tr>

                    <td colspan="3">
                        &nbsp;
                    </td>
                </tr>
                    
                </table >
            
                    
                </div>
                
                <div id="pageKecil-bottomkecil">
                    <table width="600" border="0">
                        
                    <tr>
                    <td>KUANTITAS</td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2">:  <input type="text" align="right" id="kuantitas4text" name="kuantitas4text"  onfocus="validasi0()" value="${tupoksiKeIsi4Faktor.getKuantitas4()}" style="text-align: right" onkeypress="return alertnipnull(event)" /></span></strong>
                        ${tupoksiKeIsi4Faktor.getkuantitas_label()}
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <select id="pilihanKuantitas" name="pilih_output">
                            <option  value="-">-</option>
                            <option  value="Dokumen">Dokumen</option>
                            <option value="Kegiatan">Kegiatan</option>
                            <option value="Laporan">Laporan</option>
                            <option value="Paket">Paket</option>
                            <option value="Nota Persetujuan">Nota Persetujuan</option>
                            <option value="Konsep">Konsep</option>
                            <option value="Berkas">Berkas</option>
                            <option value="Data">Data</option>
                            <option value="Surat">Surat</option>
                            <option value="Kali">Kali</option>
                            <option value="Naskah">Naskah</option>
                            <option value="Jam Pelajaran">Jam Pelajaran</option>
                            <option value="Bahan Tayang">Bahan Tayang</option>
                            <option value="GBPP/SAP">GBPP/SAP</option>
                            <option value="Artikel">Artikel</option>
                            <option value="Buku">Buku</option>
                            <option value="SPP">SPP</option>
                            <option value="SPM">SPM</option>
                            <option value="Modul">Modul</option>
                            <option value="Jabatan">Jabatan</option>
                         </select>
                    </td>
                </tr>
                        
                     <tr>     
                             <td>AK TARGET</td>
                             <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2">:  </span></strong><c:out value="${tupoksiKeIsi4Faktor.getangka_krdtR()}" /></td>
                    </tr>
                 <tr>
                             <td>KUALITAS</td>
                             <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2">:  <input type="text" id="idkualitas4text" name="kualitas4text" value="${tupoksiKeIsi4Faktor.getKualitas4()}" align="right" style="text-align: right" onfocus="validasi2 ()" onchange="hitung(event)" onkeypress="return alertnipnull(event)" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; % </span></strong></td>
                </tr>
                
                <tr>
                             <td>WAKTU</td>
                             <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2">:  <input type="text" maxlength="2" onfocus="validasi3 ()" id ="waktu4text" name="waktu4text" value="${tupoksiKeIsi4Faktor.getWaktu4()}" align="right" style="text-align: right" onkeypress="return alertnipnull2(event)" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; bln </span></strong></td>
                </tr>
                <tr>
                             <td>BIAYA</td>
                             <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span class="style2">: Rp. <input onfocus="validasi4()" type="text" name="biaya4text" id="biaya4text" value="${tupoksiKeIsi4Faktor.getBiaya4()}" style="text-align: right" onkeypress="return alertnipnull(event)" /></span></strong></td>
                </tr>
                 <input type="hidden" align="right" id="akt" name="akt" value="${namaAngka_krdtjsp}" style="text-align: right" onkeypress="return alertnipnull(event)" />
            </table>
                    
                    
                     <input type="submit" name="param"  value="SIMPAN" />
                    
                </div>
                
            </form>
            
            
            
        </div>
        
        
        
        <div id="footer">
			&copy; 2013 KEDEPUTIAN INFORMASI KEPEGAWAIAN.
		</div>
        
    </body>
</html>
