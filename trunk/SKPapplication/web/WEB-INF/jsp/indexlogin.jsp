<%-- 
    Document   : indexlogin
    Created on : Feb 21, 2012, 4:11:48 PM
    Author     : diptaisme
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link rel="stylesheet" type="text/css" href="http://admin.myvirtualpaper.com/css/login.css" />
        <%-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
        <title>Restricted Area</title>
    </head>
   <body>
   <form name="form1" method="post" action="loginPassServlet">    
    <table width="100%" height="550" bgcolor="" cellpadding="0" cellspacing="0" style="position:relative;top:-25px;">
	<tr>
            <td>&nbsp;</td>
            <td width="198" bgcolor="" style="background-image:url(/SKPapplication/images/login-left.jpg);background-repeat: no-repeat;background-position: bottom center">&nbsp;</td>
            <td width="285" valign="top">
                <div style="cursor:pointer;position:absolute;top:0px;height:75px;width:285px;background-image:url(/SKPapplication/images/login-bgtop-trans.png);background-repeat: no-repeat;background-position: top center"</div>
                    <table width="100%" bgcolor="#ffffff" cellpadding="0" cellspacing="0">
                        <tr height="147" bgcolor="">
                            <td valign="bottom">
                                <%--<img style="cursor:pointer;" width="285" height="119" src="<c:url value="/image/Untitled-1.jpg"/>" border="0"> http://www.image-share.com/upload/1395/241m.jpg --%>
                                <img style="cursor:pointer;" width="285" height="119" src="images/garudalogin.jpg" border="0">
                            </td>
			</tr>
			<tr height="403" valign="top">
                            <td style="background-image:url(/SKPapplication/images/login-center.jpg);background-repeat:no-repeat;background-position: bottom center"><br><br>
                                <div style="position:relative">
                                        <table class="activity" style="background-color:">
                                            <tr>
						<td class="labels">Username</td><td><input type="text" name="usernametext" class="usertext" size="15" value="" /></td>
                                            </tr>
                                            <tr>
						<td class="labels">Password</td><td><input type="password" name="passwordtext" class="usertext" size="15" value="" /></td>
                                            </tr>
                                            <tr bgcolor="">
                                                <td colspan="2" style="height:8px;"></td>
                                            </tr>
                                            <tr>
                                                <td align="right">
                                                    <input id='tsubmit' class="login_button" type="submit" name="Submit" style="" value="" onclick="document.getElementById('tsubmit').style.display='none'; document.getElementById('loadeux').style.display=''; document.getElementById('formaction').submit();">
                                                    <img id='loadeux' src="/SKPapplication/images/loader.gif" style="display:none;position:relative;top:-5px;">
                                                 </td>
                                            </tr>
					</table>
                                    </div>
				</td>
			</tr>
		 </table>
		</td>
		<td width="201" style="background-image:url(/SKPapplication/images/login-right.jpg);background-repeat: no-repeat;background-position: bottom center">&nbsp;</td>
		<td>&nbsp;</td>
</table>
</form> 
</body>
</html>
