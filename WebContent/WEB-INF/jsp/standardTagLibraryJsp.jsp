<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		<a 
		href="<c:url value='https://www.google.com/search'>
				<c:param name='q' value='cats' />
			</c:url>">The link (Google search for cats) was generated with JSTL</a>
	</p>
	
	<br/>
	
	<c:out value="${someVariable}" default="This is a default value within a c:out tag." />


	<br/>
	<h5>The following lines are generated with a c:forEach loop </h5>
	<c:forEach var="i" begin="1" end="10">
    	Line ${i}<br />
	</c:forEach>


</body>
</html>