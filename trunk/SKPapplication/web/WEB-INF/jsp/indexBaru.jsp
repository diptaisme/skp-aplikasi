<%-- 
    Document   : indexBaru
    Created on : Apr 18, 2012, 8:00:55 AM
    Author     : diptaisme
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Production Template, XHTML CSS Layout, Web Design</title>
<meta name="keywords" content="free css template, Production Template, XHTML CSS Layout, Web Design XHTML, CSS" />
<meta name="description" content="Production Template is a free XHTML CSS Layout from TemplateMo.com" />
<link href="/SKPapplication/css/templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="templatemo_container">
		<div id="templatemo_header">
        	<div id="templatemo_menu">
				<ul>
                    <li class="current"><a href="#" >SASARAN</a></li>        
					<li><a href="#">CAPAIAN</a></li>
            	</ul>
			</div>
            
        	<div id="templatemo_logo_area">
				<div id="templatemo_logo">
                	SASARAN KINERJA INDIVIDU
                </div>
                
                <div id="templatemo_slogan">
                	 BKN mewujudkan PNS yang PNS
                </div>
            </div>
 
		</div>
        
        <div class="templatemo_one_col">
        	<img src="/SKPapplication/images/label (2).png" alt="Studio" />
        	<h1>Sasaran Kinerja Individu</h1>
            <p>Kebijakan penilaian prestasi kerja dilaksanakan untuk mewujudkan Pegawai Negeri Sipil (PNS) yang professional, bertanggungjawab, jujur dan adil melalui pembinaan yang dilaksanakan berdasarkan system prestasi kerja dan system karier yang dititikberatkan pada sistem prestasi kerja, serta untuk menjamin objektivitas dalam mempertimbangkan pengangkatan dalam jabatan dan kenaikan pangkat.</p>
          <div class="cleaner"></div>
        </div>   

	</div><!-- End Of Container -->
	
    <div id="templatemo_content_area"> 
        <div id="templatemo_content_area_top">
        </div>
            <div class="templatemo_container">
            	<div id="templatemo_left">
                	<div class="templatemo_section_1">
						<form method="post" name="form1" action="GetPnsServlet">
							<div align="center" class="style1"> 
								<p><h2>FORMULIR SASARAN KERJA</h2></P>
								<p><h2>PEGAWAI NEGERI SIPIL</h2></p>
								<p align="left"><span class="style3"><strong><font size ="4">Nomor Induk Pegawai Negeri Sipil ( 18 Digit ) :</font></strong> 
								<input class="highlight" name="txtNIPBaru" type="text" size="35." maxlength="18">
								<input type="submit" class="button black bigrounded" name="param" value="CARI" onclick="alertnipnull()">
								</span></p>
								<div align="justify">
									<table width="1198" height="34" border="0" align="left">
										<tr>
											<td width="30" height="28"><div align="center"><span class="style3">NO</span></div></td>
											<td width="555"><span class="style3"><strong>I. PEJABAT PENILAI</strong></span></td>
											<td width="30"><div align="center"><span class="style3">NO</span></div></td>
											<td width="555"><span class="style3"><strong>II. PEGAWAI NEGERI SIPIL YANG DINILAI</strong></span></td>
										</tr>
									</table>
									<div align="right"></div>
									<div align="right"></div>
								</div>
								<table width="1198" border="0" align="left">
									<tr>
										<td width="30"><div align="left"><span class="style3">1</span></div></td>
										<td width="135" align="left"><span class="style3">Nama</span></td>
										<td width="414" align="left"> <c:out value="${UnorAts.getNamaPns()}" /> </td>
										<td width="30"><div align="left"><span class="style3">1</span></div></td>
										<td width="135" align="left"><span class="style3">Nama</span></td>
										<td width="414" align="left"> <c:out value="${pns.getNamaPns()}"/> </td>
									</tr>
									<tr>
										<td><div align="left"><span class="style3">2</span></div></td>
										<td align="left"><span class="style3">NIP</span></td>
										<td align="left"><c:out value="${UnorAts.getNipBaru()}" /></td>
										<td><div align="left"><span class="style3">2</span></div></td>
										<td align="left"><span class="style3">NIP</span></td>
										<td align="left"><c:out value="${pns.getNipBaru()}" /></td>
										<input  type="hidden"  name="_getInstansi" value="${pns.getNipBaru()}">
									</tr>
									<tr>
										<td><div align="left"><span class="style3">3</span></div></td>
										<td align="left"><span class="style3">Pangkat/Gol.Ruang</span></td>
										<td align="left"><c:out value="${UnorAts.getPangkat()}" /></td>
										<td><div align="left"><span class="style3">3</span></div></td>
										<td align="left"><span class="style3">Pangkat/Gol.Ruang</span></td>
										<td align="left"><c:out value="${pns.getPangkat()}" /></td>
									</tr>
									<tr>
										<td><div align="left"><span class="style3">4</span></div></td>
										<td align="left"><span class="style3">Jabatan</span></td>
										<td align="left"><c:out value="${UnorAts.getNamaJabatan()}" /></td>
										<td><div align="left"><span class="style3">4</span></div></td>
										<td align="left"><span class="style3">Jabatan</span></td>
										<td align="left"><c:out value="${pns.getNamaJabatan()}" /></td>
									</tr>
									<tr>
										<td><div align="left"><span class="style3">5</span></div></td>
										<td align="left"><span class="style3">Unit Kerja </span></td>
										<td align="left"><c:out value="${UnorAts.getNamaUnor()}" /></td>
										<td><div align="left"><span class="style3">5</span></div></td>
										<td align="left"><span class="style3">Unit Kerja </span></td>
										<td align="left"><c:out value="${pns.getNamaUnor()}" /></td>
									</tr>
								</table>
								<p align="left">&nbsp;</p>
								<p align="left">&nbsp;</p>
								<p align="left">&nbsp;</p>
								<p align="left">&nbsp;</p>
                
								<table width="1400" border="0" align="left">
									<tr>
										<td width="31" rowspan="2"><div align="center"><span class="style3"><strong>NO</strong></span></div></td>
										<td width="80" rowspan="2"><div align="center"><span class="style3"><strong>KODE</strong></span></div></td>
										<td width="383" rowspan="2"><div align="center"><span class="style3"><strong>III. KEGIATAN TUGAS POKOK JABATAN</strong></span></div></td>
										<td colspan="4"><div align="center"><span class="style3"><strong>TARGET</strong></span></div></td>
									</tr>
									<tr>
										<td width="105" height="21"><div align="center"><span class="style3"><strong>KUANT/OUTPUT</strong></span></div></td>
										<td width="100"><div align="center"><span class="style3"><strong>KUAL/MUTU</strong></span></div></td>
										<td width="70"><div align="center"><span class="style3"><strong>WAKTU</strong></span></div></td>
										<td width="136"><div align="center"><span class="style3"><strong>BIAYA</strong></span></div></td>
									</tr>
									<c:forEach var="listTukesi" items="${tukesiServlet}" varStatus = "count">
										<tr>
											<td><div align="center">${(count.index)+1}</div></td>
											<td><div align="center"><a href ="Isi4FaktorServlet?nipnilai=<c:out value="${pns.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>">${listTukesi.getIdTupoksi()}</div></td>
											<td><div align="left">${listTukesi.getNamaTupoksi()}</div></td>
											<td><div align="right">${listTukesi.getKuantitas4()} ${listTukesi.getkuantitas_label()} </div></td>
											<td><div align="right">${listTukesi.getKualitas4()}</div></td>
											<td><div align="right">${listTukesi.getWaktu4()} ${listTukesi.getwaktu_label()} </div></td>
											<td><div align="right">${listTukesi.getBiaya4()}</div></td>
										</tr>
									</c:forEach>
								</table>
          
<SCRIPT TYPE="text/javascript">
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

function next()
{
    location = 'RequestServlet?page=insertTupoksi';
}
function next_isi4faktor()
{
    location = 'RequestServlet?page=insertTupoksi';
}
function myPopup2() 
{
    window.open( "tupoksiServlet?txtNIPBaru=<c:out value="${pns.getNipBaru()}"/>", "myWindow", "status = 0, height = 500, width = 1000, resizable = 0, scrollbars=yes" )
}

function show_alert()
{
    var r=confirm("Press a button");
        
    if (r==true)
    {
        alert("You pressed OK!");
    }
    else
    {
        alert("You pressed Cancel!");
    }
}

function alert()
{
    alert("TUPOKSI MASIH KOSONG");
}

function banner()
{
    
}

function updateClock()
{
    var now = new Date();
    
    var jam = now.getHours().toString();
    var menit = now.getMinutes().toString();
    var detik = now.getSeconds().toString();
    var mili = now.getMilliseconds().toString();
    
    var tgl = now.getDate().toString();
    var bulan = now.getMonth().toString();
    var tahun = now.getYear().toString();
    
    var hari = now.getDay().toString();
    
    var coba = now.getD

    if (menit.length < 2)
        menit = "0" + menit
    if (detik.length < 2)
        detik = "0" + detik
    if (tgl.length < 2)
        tgl = "0" + tgl
    if (bulan == "0")
        bulan = "Januari"
    if (bulan == "1")
        bulan = "Februari"
    if (bulan == "2")
        bulan = "Maret"
    if (bulan == "3")
        bulan = "April"
    if (bulan == "4")
        bulan = "Mei"
    if (bulan == "5")
        bulan = "Juni"
    if (bulan == "6")
        bulan = "Juli"
    if (bulan == "7")
        bulan = "Agustus"
    if (bulan == "8")
        bulan = "September"
    if (bulan == "9")
        bulan = "Oktober"
    if (bulan == "10")
        bulan = "November"
    if (bulan == "11")
        bulan = "Desember"
    if (hari == "1")
        hari = "Senin"
    if (hari == "2")
        hari = "Selasa"
    if (hari == "3")
        hari = "Rabu"
    if (hari == "4")
        hari = "Kamis"
    if (hari == "5")
        hari = "Jumat"
    if (hari == "6")
        hari = "Sabtu"
    if (hari == "0")
        hari = "Minggu"
    
    var time = hari + ", " + tgl + " " + bulan + " " + tahun + " / "+ jam + ":" + menit + ":" + detik + ":" + mili;
     
    document.forms["clock"].time.value = time;
    setTimeout("updateClock();", 1000);
}

function alertnipnull()
{
    if (txtNIPBaru == null)
    {
        window.alert("Masukkan NIP anda terlebih dahulu");
    }
}
</script>

            
            <p>&nbsp;</p>
            <p align="justify">&nbsp;</p>
        </div>
     </form>
                    	
               	    </div>
                    
					
					
                    <div class="templatemo_h_line"></div>
                    
                    
                    <div class="templatemo_h_line"></div>    
                    <div class="cleaner"></div>
                </div>
            </div><!-- End Of left -->
                
                
                <div class="cleaner"></div>
            </div><!-- End Of Container -->
        <div id="templatemo_footer">
        	Copyright ? 2012 |  Pranata Komputer INKA Pusat | Badan Kepegawaian Negara
        </div>        
    </div><!-- End Of Content area-->
<!--  Free CSS Templates by TemplateMo.com  -->
</body>
</html>