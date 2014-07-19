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

        <script src="/SKPapplication/js/jquery-1.7.1.min.js"></script>

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
            function ubahuser()
            {
                document.getElementById("simpan").disabled = false;
                document.getElementById("batal").disabled = false;
                document.getElementById("tambah").disabled = true;
                document.getElementById("ubah").disabled = true;
                document.getElementById("kewenangan").disabled = true;
            }
            function bataluser()
            {
                document.getElementById("simpan").disabled = true;
                document.getElementById("batal").disabled = true;
                document.getElementById("tambah").disabled = false;
                document.getElementById("ubah").disabled = false;
                document.getElementById("kewenangan").disabled = false;
                document.getElementById("usernameinputan").value = "";
                document.getElementById("passwordinputan").value = "";
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
            table.table1
            {
                border-collapse: collapse;
                box-shadow: 8px 8px 4px #0c0c0c;
                
            }
            td.table1,th.table1 
            {
              background: #B280B2;
              padding: 5px 7px;
              border-left: 1px solid white;
              border-right: 1px solid white;
              border-bottom: 1px solid white;
            }
            td.table2 
            {
              background: #CCCCFF; 
              padding: 5px 7px;
              border-left: 1px solid white;
              border-right: 1px solid white;
              border-bottom: 1px solid white
            }
            tr.table1
            {
               background: #B280B2;
            }
            th.table1
            {
               background: #751975    
            }
        </style>
    </head>
    <body>
        <div style="width: 1200px" >


            <form action="AdministratorKewenangan" method="post">
                <div id="headerLokal">
                    <%@ include file="SlindronHeader.jsp" %>
                </div>   
                <div id="leftside">
                    <%@ include file="navigasiPro.jsp" %>
                </div> 

                <div id="content">
                    <div id="metw">


                      <!--  <a href="referensiInstansiServlet?nipPengguna=<c:out value="${sessionScope.NipPnsSession}"/>">Kembali</a> -->
                            <a href="#" id="btnBack">Kembali</a>

                    </div>
                        <div style="margin-left: 10px">
                        <table class="table1" border="1" style="margin-top: 20px;">
                            <tr>
                                <th class="table1" colspan="3" align="center">Manajemen User</th>
                            </tr>
                        <tr>
                            <td class="table1" width="50" align="center">1</td>
                            <td class="table1" width="100" align="center">Username</td>
                            <td width="200" class="table2"> <input type="text" name="usernameinputan" value="<c:out value="${username}"/>" />
                                </input> </td>
                            <td><input type="hidden" name="nip_baru" value="<c:out value="${nip}"/>" /></input> </td>
                        </tr>
                        <tr>
                            <td class="table1" align="center">2</td>
                            <td class="table1" align="center">Password</td>
                            <td class="table2"><input type="text" name="passwordinputan" value="<c:out value="${password}"/>"/> </input></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td class="table1" align="center">3</td>
                            <td class="table1" align="center">Kewenangan</td>
                            <td class="table2">
                                <select name="kewenangan" nama="kewenangan" >
                                                <option value="user">Operator Tugas Jabatan</option>
                                                <option value="operator">Operator SKP Seluruh</option>
                                                <option value="Perwakilan_user">Operator SKP Personal</option>
                                                <option value="administrator">Administrator</option>
                                                
                                 </select>
                            </td>    
                            <td></td>
                        </tr>   
                            <tr>
                                <td colspan="3" class="table1">
                                    <input type="submit" name="param" value="ubah"></input>        
                                    <!--<input type="submit" name="param" value="TambahKewenangan"></input> -->
                                    
                                </td>
                        </tr> 
                    </table>
                            </div>
                        
                            
                       
  </form>
                            
                            <form action="administratorFunctionServlet" method="post" id="formBackToUserManagement" >
                                <input type="hidden" name="nipbaru" id="nipBaru" value="<c:out value="${nip}"/>" />
                                <input type="hidden" name="param" value="AMBIL" />  
                                
                            </form>    
    </body>
</html>
                                <script>                                
$(document).ready(function(){
    $('#btnBack').click(function (event){
        event.preventDefault();
        $('#formBackToUserManagement').submit();
    });  
});
</script>