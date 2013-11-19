<%-- 
    Document   : seletron
    Created on : 13 Nov 13, 14:06:12
    Author     : Sony
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <script type="text/javascript" src="jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="jquery.slidertron-1.1.js"></script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
<style type="text/css">        
   #slideshow {
       width : 100px;
        height: 150px;
        margin: 0px auto;
        padding: 5px 0px 0px 0px;
        background: url(images/img03.jpg) no-repeat left top;
}

#foobar {
        position: relative;
}

#foobar .navigation {
        position: absolute;
        display: block;
        z-index: 100;
        color: #ffffff;
        bottom: 0px;
        right: 0px;
        margin: 10px;
        padding: 1px;
        background-color: #303030;
        opacity: 0.75;
}

#foobar .navigation a {
        color: #ffffff;
        text-decoration: none;
        outline: none;
}

#foobar .viewer {
        width: 100px;
        height: 150px;
		
}

#foobar .viewer .reel .slide {
        position: relative;
        width: 100px;
        height: 150px;
}

#foobar .viewer .reel .slide span {
        position: absolute;
        display: block;
        width: 100px;
        opacity: 0.30;
        padding: 15px;
        background-color: #FFFFFF;
        color: #000000;
        bottom: 0px;
        left: 0px;
        font-size: 18px;
}


#foobar .viewer-wrapper {
        float: left;
        width:  100px;
        height: 100px;
        background: red;
}

.arrow-left {
        background: blue;
        width: 100px;
        float: left;
}

.arrow-right {
        background: green;
        width: 100px;
        float: right;
}

#col1 {
        width: 100px;
        float: left;
		 left: 0px;
}

#col1 a {
        outline: none;
        display: block;
        width: 77px;
        height: 100px;
        background: url(images/img05.jpg) no-repeat 30px 130px;
        text-decoration: none;
}

#col2 {
        float: left;
        width: 100px;
		 left: 0px;
}

#col3 a {
        float: right;
        outline: none;
        width: 87px;
        height: 100px;
        background: url(images/img06.jpg) no-repeat 10px 130px;
        text-decoration: none;
}



</style>
    </head>
 

    <body>
        <div id="slideshow">
<div id="foobar">   
    <div id="col2">
 <div class="viewer">        <div class="reel"> 
 <div class="slide">                     <img src="images/arrow-on-target.jpg" width="100" height="100" alt="" /> <span>Harley checking in at DDL Elliott.</span>
</div><div class="slide">                <img src="images/blurry.jpg" width="100" height="100" alt="" /> <span>Harley checking in at DDL Elliott.</span>
</div><div class="slide">                <img src="images/sukses.jpg" width="100" height="100" alt="" /> <span>Harley checking in at DDL Elliott.</span>
</div><div class="slide">                <img src="images/meeting.jpg" width="100" height="100" alt="" /> <span>Harley checking in at DDL Elliott.</span>
</div></div></div></div></div></div>

<script type="text/javascript">
    $('#foobar').slidertron({
        viewerSelector: '.viewer',
        reelSelector: '.viewer .reel',
        slidesSelector: '.viewer .reel .slide',
        advanceDelay: 3000,
        speed: 'slow'
    });
</script>
    </body>
</html>
