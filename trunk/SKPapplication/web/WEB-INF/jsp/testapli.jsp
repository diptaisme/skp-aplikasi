<%-- 
    Document   : testapli
    Created on : 20 Sep 13, 14:02:20
    Author     : Sony
--%>


    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <script type="text/javascript" src="jquery-1.5.2.min.js"></script>
        <title>Monitoring</title>
        <link rel="stylesheet" type="text/css" href="style2.css" />
        <link href="/SKPapplication/css/styleBiru.css" rel="stylesheet" type="text/css" />
        <link href="http://fonts.googleapis.com/css?family=Abel" rel="stylesheet" type="text/css" />
          
               <style>
 
        #right {
	position :  absolute;
	top : 300px;
	left : 1px;
	width : 173px;
	height : 600px;
         }
       #header2 {
	background :#f00;
	position :  absolute;
	top : 100px;
        left : 50px;
	width : 500px;
	height : 500px;
	overflow: scroll;
	}	
        
         #left20 {
	
	position :relative;
	top : 100px;
        left : 60px;
	width : 500px;
	height : 500px;
	
	}
   .Collapsable {
    width:100%;
    cursor:pointer;
    background-color:#E5E5E5;
    position:relative;
}
               </style>
        </head>
            <body>
                <%   
                int x1=5;
                %>
                
                <div id="header2">            
 <ul id="left20">  
     <% for(int i = 1; i < 4; i++ ){ %> 
     <li style="left: 70px;"><span class="Collapsable">item 1</span>
         <ul>
        <li style="left: 75px;"><span class="Collapsable">item 1</span></li>
        <li style="left: 75px;"><span class="Collapsable">item 2</span>
            <ul>
            <li><span class="Collapsable">item 1</span></li>
            <li><span class="Collapsable">item 2</span></li>
            <li><span class="Collapsable">item 3</span></li>
            <li><span class="Collapsable">item 4</span></li>
        </ul>
        </li>
        <li><span class="Collapsable">item 3</span></li>
        <li><span class="Collapsable">item 4</span>
            <ul>
            <li><span class="Collapsable">item 1</span></li>
            <li><span class="Collapsable">item 2</span></li>
            <li><span class="Collapsable">item 3</span></li>
            <li><span class="Collapsable">item 4</span></li>
        </ul>
        </li>
    </ul>
    </li>
    <li><span class="Collapsable">item 2</span><ul>
        <li><span class="Collapsable">item 1</span></li>
        <li><span class="Collapsable">item 2</span></li>
        <li><span class="Collapsable">item 3</span></li>
        <li><span class="Collapsable">item 4</span></li>
    </ul>
    </li>
    <li><span class="Collapsable">item 3</span><ul>
        <li><span class="Collapsable">item 1</span></li>
        <li><span class="Collapsable">item 2</span></li>
        <li><span class="Collapsable">item 3</span></li>
        <li><span class="Collapsable">item 4</span></li>
    </ul>
    </li>
    <li><span class="Collapsable">item 4</span></li>
     <%} %> 
</ul>
     
                </div>
<script type="text/javascript">
    $(".Collapsable").click(function () {

        $(this).parent().children().toggle();
        $(this).toggle();

    });
</script>
                
   </body>
</html>     
</html