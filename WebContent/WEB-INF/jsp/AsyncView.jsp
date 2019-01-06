<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="3" />
<title>Insert title here</title>
</head>
<body>
<form method="GET" action="/SportsNews/home">
  <input type="submit" value="Home Page">
</form>
<br />
<br />

Note: This page automatically refreshes every 3 seconds.
<br />
<form method="GET">
  <input type="submit" value="Manually Refresh Page">
</form>
<br />
<br />
<hr>
<br />
<br />
There is a scheduled method call that runs every 15 seconds. 
<br />
<br />
Below is the number of times that the method has been called. 
<br />
<br />

<c:out value="${calls}" />

<br />
<br />
<hr>
<br />
<br />
Clicking the button increments the asynchronous count asynchronously.
<br />
<br />
5 seconds after the button is clicked, the count shown below is incremented by one.
<br />
<br />

<form method="POST">
  <input type="submit" value="Click Here">
</form>

<br />
<br />
<c:out value="${asyncCalls}" />
<br />
<br />


</body>
</html>
