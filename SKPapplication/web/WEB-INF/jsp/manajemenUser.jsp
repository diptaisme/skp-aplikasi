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

        <style type="text/css"> 
            #headerLokal {
                padding: 0px;
                width: 1000px;

                position: relative;
                height: 80px;
                left : -20px;
            }
            #leftside {

                position :  absolute;
                top : 60px;
                left : 20px;
                width : 156px;
                height : 501px;
            }

            #content {
                position :  absolute;
                top : 115px;
                left : 200px;
                width : 1300px;
                height : 501px;


            }

            #metw {
                position: relative;
                width: 930px;
                height: 30px;
                background: #9999CC;
                left : 1px;
                font-family: arial;
                padding-left: 30px;
                top :0px;
                text-decoration: none;

            }
            #metw  a {
                display:inline;
                text-decoration: none;
                color: #FFF;
                left : 100px;

                width: 100px;
                font-size: 14px

            }

            #metw  a:hover {
                background-color: #CCCCFF;
                color: #FF0000;
            }

            #wrapper22k {
                width: 1000px;
                position: relative;

            }

        </style>
    </head>
    <body>
        <div style="width: 1200px" >


            <form action="administratorFunctionServlet" method="post">
                <div id="headerLokal">
                    <%@ include file="SlindronHeader.jsp" %>
                </div>   
                <div id="leftside">
                    <%@ include file="navigasiPro.jsp" %>
                </div> 

                <div id="content">
                    <div id="metw">


                        <a href="referensiInstansiServlet?nipPengguna=<c:out value="${sessionScope.NipPnsSession}"/>">Kembali</a> 


                    </div>
                    <table >
                        <tr>
                            <td>
                                <table width="330" border="0" align="left">

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

                                        <td>
                                            <input type="submit" name="param"  value="Simpan" /> 
                                        </td>
                                        <td>
                                            <input type="submit" name="param"  value="Hapus" /> 
                                        </td>
                                        <td>
                                            <input type="submit" name="param"  value="Kembali" /> 
                                        </td>
                                    </tr>
                                </table>
                            </td>

                        </tr>
                    </table>
                </div>                  


            </form>  


        </div>             
    </body>
</html>
