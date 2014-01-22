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
<link href="http://fonts.googleapis.com/css?family=Abel" rel="stylesheet" type="text/css" />
<link href="/SKPapplication/css/style2.css" rel="stylesheet" type="text/css" />
       



<script language="javascript" type="text/javascript">
function clearText(field)
{
    if (field.defaultValue == field.value) field.value = '';
    else if (field.value == '') field.value = field.defaultValue;
}

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
</head>
<body>
      <div id="wrapper">
      <div id="header">
                <div id="logo">
                    <table >
                        <tr>
                            <th rowspan="2" >
                                <img src="/SKPapplication/images/burung_garuda7.png"/></th>
                            <td>
                                SASARAN KINERJA PEGAWAI
                            </td>
                        </tr>
                        <tr>
                            <td>
                                B K N
                            </td>
                            <td width="100" hidden="true" align="left"> &nbsp;&nbsp;&nbsp;&nbsp;Login <c:out  value="${sessionScope.user}" /> </td>
                            <td width="414" hidden="true" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NIP <c:out value="${sessionScope.NipPnsSession}" /> </td>

                        </tr>

                    </table>
                </div>
            </div>
    
    
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
                                    <input type="submit" name="param"  value="AMBIL" />
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
                                <input  type="hidden"  name="getNipBaruPns" value="${pns.getNipBaru()}"/>
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
                                        <option value="administrator">Administrator</option>
                                        <option value="Perwakilan_user">Perwakilan User</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td>
                                    <input type="submit" name="param"  value="OK" /> 
                                </td>
                                 <td>
                                    <input type="submit" name="param"  value="Delete" /> 
                                </td>
                            </tr>
                        </table>
                    </td>
                   
                </tr>
            </table>
                            
                            
                            
        </form>  
  
              
      </div>             
</body>
</html>
