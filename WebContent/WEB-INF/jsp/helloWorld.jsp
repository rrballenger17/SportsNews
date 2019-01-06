<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Hello World Application</title>
    </head>
    <body>
    
    
        Hello, World! 
        
        <br/>
        <br/>
        
       
      <br/>Ticket #: <%= request.getAttribute("ticketId") %>
      <br/>Ticket Name: <%= request.getAttribute("ticket") %>       
       
      <jsp:include page="footer.jsp" />
       
    </body>
</html>