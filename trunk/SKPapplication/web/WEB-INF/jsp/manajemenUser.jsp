<%-- 
    Document   : manajemenUser
    Created on : Apr 19, 2012, 11:16:18 AM
    Author     : diptaisme
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ADMINISTRATOR</title>
<meta name="keywords" content="corporate, free web template" />
<meta name="description" content="SKI" />
<link href="/SKPapplication/css/styleBiru.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript">
function clearText(field)
{
    if (field.defaultValue == field.value) field.value = '';
    else if (field.value == '') field.value = field.defaultValue;
}
</script>
</head>
<body>
    <div id="container">
    <div id="templatemo_site_title_bar3_wrapper">
        <div id="templatemo_site_title_bar3">
            <div id="templatemo_menu">
                	
            </div> <!-- end of templatemo_menu -->  
            <div class="cleaner"></div>
            <div id="search_box">

            </div>
        </div> <!-- end of templatemo_site_title_bar -->
    </div> <!-- end of templatemo_site_title_bar_wrapper -->
    
    <div id="templatemo_content3_admin">
        <form action="administratorFunctionServlet" method="post">
            <table width="1320" border="0" align="left">
                <tr>
                    <td>
                        <table width="330" border="0" align="left">
                            <tr>
                                <td colspan="3" align="center"><strong><h3>TAMBAH USER</h3></strong></td>
                            </tr>
                            <tr>
                                <td width="50"></td>
                                <td width="100"></td>
                                <td width="180"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td width="30"><div align="left"><span class="style3">NIP BARU</span></div></td>
                                <td><input type="text" name="nipbaru" onkeypress="return alertnipnull(event)" maxlength="18"></input></td>
                                <td>
                                    <input type="submit" name="param" class="button black bigrounded" value="AMBIL" />
                                </td>
                            </tr>
                            <tr>
                                <td width="30"><div align="left"><span class="style3">1</span></div></td>
                                <td width="135" align="left"><span class="style3">Nama</span></td>
                                <td width="414" align="left"> <c:out value="${pns.getNamaPns()}"/> </td>
                            </tr>
                            <tr>
                                <td><div align="left"><span class="style3">2</span></div></td>
                                <td align="left"><span class="style3">NIP</span></td>
                                <td align="left"><c:out value="${pns.getNipBaru()}" /></td>
                                <input  type="hidden"  name="getNipBaruPns" value="${pns.getNipBaru()}">
                            </tr>
                            <tr>
                                <td><div align="left"><span class="style3">3</span></div></td>
                                <td align="left"><span class="style3">Pangkat/Gol.Ruang</span></td>
                                <td align="left"><c:out value="${pns.getPangkat()}" /></td>
                            </tr>
                            <tr>
                                <td><div align="left"><span class="style3">4</span></div></td>
                                <td align="left"><span class="style3">Jabatan</span></td>
                                <td align="left"><c:out value="${pns.getNamaJabatan()}" /></td>
                            </tr>
                            <tr>
                                <td><div align="left"><span class="style3">5</span></div></td>
                                <td align="left"><span class="style3">Unit Kerja </span></td>
                                <td align="left"><c:out value="${pns.getNamaUnor()}" /></td>
                            </tr>
                            <tr>
                                <td><div align="left"><span class="style3">6</span></div></td>
                                <td align="left"><span class="style3">USERNAME</span></td>
                                <td><input type="text" name="usernameinputan"></input></td>
                            </tr>
                            <tr>
                                <td><div align="left"><span class="style3">7</span></div></td>
                                <td align="left"><span class="style3">PASSWORD</span></td>
                                <td><input type="text" name="passwordinputan"></input></td>
                            </tr>
                            <tr>
                                <td><div align="left"><span class="style3">8</span></div></td>
                                <td><div align="left"><span class="style3">KEWENANGAN</span></div></td>
                                <td>
                                    <select name="kewenangan" id="kewenangan">
                                        <option value="-">-</option>
                                        <option value="user">user</option>
                                        <option value="operator">operator</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td>
                                    <input type="submit" name="param" class="button black bigrounded" value="OK" /> 
                                </td>
                            </tr>
                        </table>
                    </td>
                    <td>
                        <table width="330" border="0" align="left">
                            <tr>
                                <td colspan="3" align="center"><strong><h3>PENCARIAN USER</h3></strong></td>
                            </tr>
                            <tr>
                                <td width="50"></td>
                                <td width="100"></td>
                                <td width="180"></td>
                            </tr>
                            <tr>
                                <td width="30"><div align="left"><span class="style3">NIP BARU</span></div></td>
                                <td><input type="text" name="nipbaru" onkeypress="return alertnipnull(event)" maxlength="18"></input></td>
                                <td>
                                    <input type="submit" name="param" class="button black bigrounded" value="AMBIL" />
                                </td>
                            </tr>
                            <tr>
                                <td width="30"><div align="left"><span class="style3">1</span></div></td>
                                <td width="135" align="left"><span class="style3">Nama</span></td>
                                <td width="414" align="left"> <c:out value="${pns.getNamaPns()}"/> </td>
                            </tr>
                            <tr>
                                <td><div align="left"><span class="style3">2</span></div></td>
                                <td align="left"><span class="style3">NIP</span></td>
                                <td align="left"><c:out value="${pns.getNipBaru()}" /></td>
                                <input  type="hidden"  name="getNipBaruPns" value="${pns.getNipBaru()}">
                            </tr>
                            <tr>
                                <td><div align="left"><span class="style3">3</span></div></td>
                                <td align="left"><span class="style3">Pangkat/Gol.Ruang</span></td>
                                <td align="left"><c:out value="${pns.getPangkat()}" /></td>
                            </tr>
                            <tr>
                                <td><div align="left"><span class="style3">4</span></div></td>
                                <td align="left"><span class="style3">Jabatan</span></td>
                                <td align="left"><c:out value="${pns.getNamaJabatan()}" /></td>
                            </tr>
                            <tr>
                                <td><div align="left"><span class="style3">5</span></div></td>
                                <td align="left"><span class="style3">Unit Kerja </span></td>
                                <td align="left"><c:out value="${pns.getNamaUnor()}" /></td>
                            </tr>
                            <tr>
                                <td><div align="left"><span class="style3">6</span></div></td>
                                <td align="left"><span class="style3">USERNAME</span></td>
                                <td><input type="text" name="usernameinputan"></input></td>
                            </tr>
                            <tr>
                                <td><div align="left"><span class="style3">7</span></div></td>
                                <td align="left"><span class="style3">PASSWORD</span></td>
                                <td><input type="text" name="passwordinputan"></input></td>
                            </tr>
                            <tr>
                                <td><div align="left"><span class="style3">8</span></div></td>
                                <td><div align="left"><span class="style3">KEWENANGAN</span></div></td>
                                <td><input type="text" name="kewenanganinputan"></input></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td>
                                    <input type="submit" name="param" class="button black bigrounded" value="UBAH" /> 
                                    <input type="submit" name="param" class="button black bigrounded" value="HAPUS" /> 
                                </td>
                            </tr>
                        </table>
                    </td>
                    <td>
                        <table width="330" border="0" align="left">
                            <tr>
                                <td colspan="3" align="center"><strong><h3>FUNGSI ADMIN LAINNYA</h3></strong></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                        </table>
                    </td>
                    <td>
                        <table width="330" border="0" align="left">
                            <tr>
                                <td colspan="3" align="center"><strong><h3>FUNGSI ADMIN LAINNYA</h3></strong></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>
                        <table width="330" border="0" align="left">
                            <tr>
                                <td colspan="3" align="center"><strong><h3>FUNGSI ADMIN LAINNYA</h3></strong></td>
                            </tr>
                            <tr>
                                <td width="50"><b><i>NO</i></b></td>
                                <td width="100"><b><i>NAMA</i></b></td>
                                <td width="180"><b><i>KET</i></b></td>
                            </tr>
                            <tr>
                                <td><i>sample</i></td>
                                <td><i>sample</i></td>
                                <td><i>sample</i></td>
                            </tr>
                            <tr>
                                <td><i>sample</i></td>
                                <td><i>sample</i></td>
                                <td><i>sample</i></td>
                            </tr>
                            <tr>
                                <td><i>sample</i></td>
                                <td><i>sample</i></td>
                                <td><i>sample</i></td>
                            </tr>
                            <tr>
                                <td><i>sample</i></td>
                                <td><i>sample</i></td>
                                <td><i>sample</i></td>
                            </tr>
                            <tr>
                                <td><i>sample</i></td>
                                <td><i>sample</i></td>
                                <td><i>sample</i></td>
                            </tr>
                            <tr>
                                <td><i>sample</i></td>
                                <td><i>sample</i></td>
                                <td><i>sample</i></td>
                            </tr>
                            <tr>
                                <td><i>sample</i></td>
                                <td><i>sample</i></td>
                                <td><i>sample</i></td>
                            </tr>
                            <tr>
                                <<td><i>sample</i></td>
                                <td><i>sample</i></td>
                                <td><i>sample</i></td>
                            </tr>
                            <tr>
                                <td><i>sample</i></td>
                                <td><i>sample</i></td>
                                <td><i>sample</i></td>
                            </tr>
                            <tr>
                                <td><i>sample</i></td>
                                <td><i>sample</i></td>
                                <td><i>sample</i></td>
                            </tr>
                            <tr>
                                <td><i>sample</i></td>
                                <td><i>sample</i></td>
                                <td><i>sample</i></td>
                            </tr>
                        </table>
                    </td>
                    <td>
                        <table width="330" border="0" align="left">
                            <tr>
                                <td colspan="3" align="center"><strong><h3>FUNGSI ADMIN LAINNYA</h3></strong></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                        </table>
                    </td>
                    <td>
                        <table width="330" border="0" align="left">
                            <tr>
                                <td colspan="3" align="center"><strong><h3>FUNGSI ADMIN LAINNYA</h3></strong></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                        </table>
                    </td>
                    <td>
                        <table width="330" border="0" align="left">
                            <tr>
                                <td colspan="3" align="center"><strong><h3>FUNGSI ADMIN LAINNYA</h3></strong></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </form>  
    </div>
                
                <SCRIPT TYPE="text/javascript">
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
                </script> 
                
</body>
</html>
