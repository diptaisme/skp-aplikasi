<%-- 
    Document   : validasi2
    Created on : 23 Jan 13, 13:46:32
    Author     : Sony
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    if(request.getParameter("jenis_tambahan").toString().equals("Keterampilan")){
        out.print("<select name='koef_kreatifitas'><option value='10'>Unit Organisasi</option><option value='20'>Instansi</option><option value='30'>Nasional</option> </select>"); 
    }

%>