
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
    	<h5>Second text abbreviated by TLD EL function:</h5>
    	<br />
    	<br />
    	<b>Short text:</b> ${wrox:abbreviateString(shortText, 32)}<br />
    	<b>Long text:</b> ${wrox:abbreviateString(longText, 32)}<br />
    </body>

</html>