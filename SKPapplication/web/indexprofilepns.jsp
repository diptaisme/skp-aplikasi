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
<link href="styleBiru.css" rel="stylesheet" type="text/css" />
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
        <form name="form1" action="administratorFunctionServlet" method="post" enctype="multipart/form-data">
            <div style="border:1px ridge #000000; width: auto">
                <table>
                    <tr>
                        <td rowspan="5"><img></img></td>
                        <td><strong>NIP LAMA</strong></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><strong>NIP BARU</strong></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><strong>NAMA</strong></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><strong>Tempat, tgllhr</strong></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><strong>Unit Kerja</strong></td>
                        <td></td>
                    </tr>
                </table>
            </div>
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
                        
   function ButtonBack()
{
    ddtk = document.form1.inputnip.value;

    location = 'TampilkanPhotoServlet?idNiptambahan='+ddtk;
}
                </script> 
                
</body>
</html>
