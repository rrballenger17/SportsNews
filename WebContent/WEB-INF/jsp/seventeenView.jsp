<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<br />
RESTful Web Service Examples 
<br />
<br />
Send GET request to the greeting endpoint and view the JSON response:
<br />
<br />
<form action="/SportsNews/services/rest/greeting" method="GET">
	
	Name (Optional): <input type="text" name="name" value="" />
	<br/>
	<input type="submit" value ="Send Request" />

</form>
<br />
<br />
<br />
<br />
Send GET request to the comment endpoint and view all the comments:
<form action="/SportsNews/services/rest/comment" method="GET">
	<input type="submit" value ="Send Request" />
</form>

<br />
<br />
<br />
<br />
Or enter a comment ID below to view a specific comment:
<form onsubmit="this.action = this.action + this.commentId.value;" action="/SportsNews/services/rest/comment/" method="GET">
	<input type="text" name="commentId" />
	<input type="submit" value ="Send Request" />
</form>


</body>
</html>


<!-- 

CONFIGURING RESTFUL WEB SERVICES WITH SPRING MVC 
simply create a @Controller, add some @RequestMapping methods to it, and begin operating a RESTful web service.

create a separate DispatcherServlet and application context configured appropriately to form your RESTful web services.


SEGREGATING CONTROLLERS WITH STEREOTYPE ANNOTATIONS

@WebController marks controllers for traditional web requests, whereas @RestEndpoint denotes RESTful web service endpoints. 
- custom


CREATING SEPARATE WEB AND REST APPLICATION CONTEXTS

lacks any view resolution or multipart support because those features are simply not needed. 

fewer message converters, focusing only on the tasks of marshalling and unmarshalling JSON and XML 


HANDLING ERROR CONDITIONS IN RESTFUL WEB SERVICES

How you handle and respond to erroneous requests and error conditions in your RESTful web services is almost as important as how you handle and respond to successful requests.


Changing HTTP Response Codes

Without this, throwing such an exception from a controller method would normally result in a 500 Internal Server Error. 
- see notfoundexception.java

Declaring Exception Handlers
Using the Controller Advice Pattern

MAPPING RESTFUL REQUESTS TO CONTROLLER METHODS

Representing request and response entities is much simpler with JSON than it is with XML,




IMPROVING DISCOVERY WITH AN INDEX ENDPOINT


 -->
 
 
 
 
