<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title><tiles:getAsString name="title" /></title>
        <link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
        
    </head>
    <body>
        <div class="flex-container">
            <tiles:insertAttribute name="header" />
            
            <tiles:insertAttribute name="menu" />
            
	        <article class="article">
	            <tiles:insertAttribute name="body" />
	        </article>
	       	 	
      		<tiles:insertAttribute name="footer" />
        </div>
    </body>
</html>