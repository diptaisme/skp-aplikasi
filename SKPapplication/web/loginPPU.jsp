<%-- 
    Document   : indexloginBaru
    Created on : Apr 19, 2012, 8:12:10 AM
    Author     : diptaisme
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Sasaran Kerja Individu</title>
        <link href="stylelog.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
            <div id="layer01_holder">
                <div id="left"></div>
                <div id="center"></div>
                <div id="right"></div>
            </div>

            <div id="layer02_holder">
                <div id="left"></div>
                <div id="center"></div>
                <div id="right"></div>
            </div>

            <div id="layer03_holder">
                <div id="left"></div>
                <div id="center">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td>
                                <form id="form1" name="form1" method="post" action="loginPassServlet">
                                    <label>Nama  
                                        <input name="usernametext" type="text" id="textfield" />
                                    </label>
                                    <label>Password  
                                        <input type="password" name="passwordtext" id="textfield2" style="margin-top:5px;" />
                                    </label>
                                    <label>
                                        <input type="submit" name="Submit" id="button" value="Login" />
                                    </label>
                                </form>
                            </td>
                        </tr>
                    </table>
                </div>
                <div id="right"></div>
            </div>

            <div id="layer04_holder">
                <div id="left"></div>
                <div id="center"></div>
                <div id="right"></div>
            </div>

            <div id="layer05_holder">
                <div align="left">Copyright © 2012, National Team of Technology Transfer and Integration (NT3I)</div>
            </div>
    </body>
</html>
