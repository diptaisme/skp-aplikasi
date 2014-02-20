<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<html lang="en-GB">

<head>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<meta name="author" content="The CSS Ninja">
	<meta name="keywords" content="CSS, Tree menu, checked pseudo-class, CSS Ninja">
	<meta name="description" content="Create a pure CSS tree folder structure with collapsible folders utilising checkboxes along with the checked pseudo-class">
	<meta name="robots" content="all">
	<meta name="copyright" content="The CSS Ninja">
	
	<!--[if gte IE 9 ]><link rel="stylesheet" type="text/css" href="_styles.css" media="screen"><![endif]-->
	<!--[if !IE]>--><link rel="stylesheet" type="text/css" href="/SKPapplication/css/_styles.css" media="screen"><!--<![endif]-->
	        <link rel="stylesheet" type="text/css" href="/SKPapplication/css/style2.css" />

	<title>Pure CSS collapsible tree menu | The CSS Ninja</title>

</head>
<body>
	
	<ol class="tree">
		<li>
			<label for="folder1">Folder 1</label> <input type="checkbox" checked disabled id="folder1" /> 
			<ol>
				<li class="file"><a href="document.html.pdf">File 1</a></li>
				<li>
					<label for="subfolder1">Subfolder 1</label> <input type="checkbox" id="subfolder1" /> 
					<ol>
						<li class="file"><a href="">Filey 1</a></li>
						<li>
							<label for="subsubfolder1">Subfolder 1</label> <input type="checkbox" id="subsubfolder1" /> 
							<ol>
								<li class="file"><a href="">File 1</a></li>
								<li>
									<label for="subsubfolder2">Subfolder 1</label> <input type="checkbox" id="subsubfolder2" /> 
									<ol>
										<li class="file"><a href="">Subfile 1</a></li>
										<li class="file"><a href="">Subfile 2</a></li>
										<li class="file"><a href="">Subfile 3</a></li>
										<li class="file"><a href="">Subfile 4</a></li>
										<li class="file"><a href="">Subfile 5</a></li>
										<li class="file"><a href="">Subfile 6</a></li>
									</ol>
								</li>
							</ol>
						</li>
						<li class="file"><a href="">File 3</a></li>
						<li class="file"><a href="">File 4</a></li>
						<li class="file"><a href="">File 5</a></li>
						<li class="file"><a href="">File 6</a></li>
					</ol>
				</li>
			</ol>
		</li>
		<li>
			<label for="folder2">Folder 2</label> <input type="checkbox" id="folder2" /> 
			<ol>
				<li class="file"><a href="">File 1</a></li>
				<li>
					<label for="subfolder2">Subfolder 1</label> <input type="checkbox" id="subfolder2" /> 
					<ol>
						<li class="file"><a href="">Subfile 1</a></li>
						<li class="file"><a href="">Subfile 2</a></li>
						<li class="file"><a href="">Subfile 3</a></li>
						<li class="file"><a href="">Subfile 4</a></li>
						<li class="file"><a href="">Subfile 5</a></li>
						<li class="file"><a href="">Subfile 6</a></li>
					</ol>
				</li>
			</ol>
		</li>
		<li>
			<label for="folder3">Folder 3</label> <input type="checkbox" id="folder3" /> 
			<ol>
				<li class="file"><a href="">File 1</a></li>
				<li>
					<label for="subfolder3">Subfolder 1</label> <input type="checkbox" id="subfolder3" /> 
					<ol>
						<li class="file"><a href="">Subfile 1</a></li>
						<li class="file"><a href="">Subfile 2</a></li>
						<li class="file"><a href="">Subfile 3</a></li>
						<li class="file"><a href="">Subfile 4</a></li>
						<li class="file"><a href="">Subfile 5</a></li>
						<li class="file"><a href="">Subfile 6</a></li>
					</ol>
				</li>
			</ol>
		</li>
		<li>
			<label for="folder4">Folder 4</label> <input type="checkbox" id="folder4" /> 
			<ol>
				<li class="file"><a href="">File 1</a></li>
				<li>
					<label for="subfolder4">Subfolder 1</label> <input type="checkbox" id="subfolder4" /> 
					<ol>
						<li class="file"><a href="">Subfile 1</a></li>
						<li class="file"><a href="">Subfile 2</a></li>
						<li class="file"><a href="">Subfile 3</a></li>
						<li class="file"><a href="">Subfile 4</a></li>
						<li class="file"><a href="">Subfile 5</a></li>
						<li class="file"><a href="">Subfile 6</a></li>
					</ol>
				</li>
			</ol>
		</li>
		<li>
			<label for="folder5">Folder 5</label> <input type="checkbox" id="folder5" /> 
			<ol>
				<li class="file"><a href="">File 1</a></li>
				<li>
					<label for="subfolder5">Subfolder 1</label> <input type="checkbox" id="subfolder5" /> 
					<ol>
						<li class="file"><a href="">Subfile 1</a></li>
						<li class="file"><a href="">Subfile 2</a></li>
						<li class="file"><a href="">Subfile 3</a></li>
						<li class="file"><a href="">Subfile 4</a></li>
						<li class="file"><a href="">Subfile 5</a></li>
						<li class="file"><a href="">Subfile 6</a></li>
					</ol>
				</li>
			</ol>
		</li>
	</ol>
    
      <ol class="tree">

                                    <ol>   

                                        <c:forEach var="pnsBaw" items="${pnsBawahan}" varStatus="count">
                                            <c:set var="capaian" value="${pnsBaw.getRealisasi()}" /> 
                                           
                                                  
                                                    <li> <a href="GetPnsServlet?action=Monitor&txtNIPBaru=<c:out value="${pnsBaw.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>&NipAtasan=<c:out value="${nipAtasan}"/>"><div id="biru"> ${pnsBaw.getNamaPns()}</div></a>
                                                    <label for="folder1"><c:out value="${pnsBaw.getNipBaru()}"/></label> <input type="checkbox" id="folder1" value="${pnsBaw.getNipBaru()}"/> 



                                                <ol>

                                                    <c:forEach var="pnsBaw2" items="${pnsBawahan2}">
                                                        <c:choose>
                                                            <c:when test="${(pnsBaw2.getDiAtasanId() == pnsBaw.getUnorId() &&  pnsBaw.getjnsjbtn_id()=='1' )}">  
                                                                <c:set var="namArray" value="${pnsBaw2.getNamaPns()}"/>
                                                                <c:set var="capaian" value="${pnsBaw2.getRealisasi()}" /> 
                                                               
                                                                        <li><a href="GetPnsServlet?action=Monitor&txtNIPBaru=<c:out value="${pnsBaw2.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>&NipAtasan=<c:out value="${nipAtasan}"/>"><div id="biru"> ${pnsBaw2.getNamaPns()}</div></a>
                                                                              <label for="folder2"><c:out value="${pnsBaw2.getNipBaru()}"/></label> <input type="checkbox" id="folder2" value="${pnsBaw2.getNipBaru()}"/> 

                                                                    <ol>  
                                                                        <c:forEach var="pnsBaw3" items="${pnsBawahan3}">
                                                                            <c:choose>
                                                                                <c:when test="${(pnsBaw3.getDiAtasanId() == pnsBaw2.getUnorId() && pnsBaw2.getjnsjbtn_id()=='1' )}">  
                                                                                    <c:set var="capaian" value="${pnsBaw3.getRealisasi()}" /> 
                                                                                  
                                                                                            <li><a href="GetPnsServlet?action=Monitor&txtNIPBaru=<c:out value="${pnsBaw3.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>&NipAtasan=<c:out value="${nipAtasan}"/>"><div id="biru"> ${pnsBaw3.getNamaPns()}</div></a>
                                                                                                  <label for="folder3"><c:out value="${pnsBaw3.getNipBaru()}"/></label> <input type="checkbox" id="subfolder3" value="${pnsBaw3.getNipBaru()}"/> 

                                                                                        <ol>
                                                                                            <c:forEach var="pnsBaw4" items="${pnsBawahan4}">
                                                                                                <c:choose>
                                                                                                    <c:when test="${(pnsBaw4.getDiAtasanId() == pnsBaw3.getUnorId() ) && pnsBaw3.getjnsjbtn_id()=='1'}"> 
                                                                                                        <c:set var="capaian" value="${pnsBaw4.getRealisasi()}" /> 
                                                                                                        
                                                                                                                <li><a href="GetPnsServlet?action=Monitor&txtNIPBaru=<c:out value="${pnsBaw4.getNipBaru()}"/>&idTupoksi=<c:out value="${listTukesi.getIdTupoksi()}"/>&NipAtasan=<c:out value="${nipAtasan}"/>"><div id="biru"> ${pnsBaw4.getNamaPns()}</div></a>
                                                                                                                      <label for="folder4"><c:out value="${pnsBaw4.getNipBaru()}"/></label> <input type="checkbox" id="folder4" value="${pnsBaw4.getNipBaru()}"/> 

                                                                                                              
                                                                                                        </c:when>
                                                                                                    </c:choose>
                                                                                                </c:forEach>
                                                                                        </ol>
                                                                                    </li>
                                                                                </c:when>
                                                                            </c:choose>
                                                                        </c:forEach>  
                                                                    </ol>         
                                                                </li>                     
                                                            </c:when>
                                                        </c:choose>
                                                    </c:forEach>  

                                                </ol>    
                                            </li>
                                        </c:forEach>
                                    </ol>      

                                </ol>
	
</body>
</html>
