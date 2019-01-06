
<%@ taglib prefix="wrox" uri="http://www.wrox.com/jsp/tld/wrox" %>

<%-- comments --%>
<%--@elvariable id="date" type="java.util.Date"--%>
<%--@elvariable id="calendar" type="java.util.Calendar"--%>
<%--@elvariable id="instant" type="java.time.Instant"--%>

<!DOCTYPE html>
<html>

    <head>
        <title>Title</title>
    </head>
    
    <body>
    	<b>Short Date:</b>
    	<wrox:formatDate value="asdf" dateStyle="short" />
    	<br />
    	<b>Medium Date:</b>
    	<wrox:formatDate value="asdf" dateStyle="medium" />
    	<br />
    	<b>Long Date:</b>
    	<wrox:formatDate value="sdf" dateStyle="long" />
    	<br />
    	<br />
    </body>

</html>