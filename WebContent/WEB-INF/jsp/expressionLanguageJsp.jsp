<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    application.setAttribute("appAttribute", "foo");
    pageContext.setAttribute("pageAttribute", "bar");
    session.setAttribute("sessionAttribute", "sand");
    request.setAttribute("requestAttribute", "castle");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<p>First Name: ${user.getFirstName() }</p>
	<p>Last Name: ${user.getLastName() }</p>
	<p>Age ${user.getAge() } </p>
	<p>Favorite Language: ${user.getFavoriteLanguage() } </p>
	<p>Location: ${user.getLocation() } </p>
	
	<p>
	
        Remote Address: ${pageContext.request.remoteAddr}<br />
        
        Request URL: ${pageContext.request.requestURL}<br />
        
        Session ID: ${pageContext.request.session.id}<br />
        
        Application Scope: ${applicationScope["appAttribute"]}<br />
        
        Page Scope: ${pageScope["pageAttribute"]}<br />
        
        Session Scope: ${sessionScope["sessionAttribute"]}<br />
        
        Request Scope: ${requestScope["requestAttribute"]}<br />
                        
        Accept Header: ${header["Accept"]}<br />
        
        Session ID Cookie Value: ${cookie["JSESSIONID"].value}<br />
   </p>

</body>
</html>