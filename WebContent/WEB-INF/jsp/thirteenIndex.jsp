<%--@elvariable id="text" type="java.lang.String"--%>
<%--@elvariable id="date" type="java.time.Instant"--%>
<!DOCTYPE html>
<html>
    <head>
        <title>Dashboard</title>
    </head>
    <body>
    	<h1> Chapter thirteen: Replacing Your Servlets with Controllers</h1>
        Text: ${text}<br />
        Date: ${date}
        
        
        <br />
        <br />
        <br />
        <a href="thirteen?special=true">Parameter restriction example</a>
        <br />
                <br />
                <br />
        Input-bound Form Processing:
        <br />
        <form action="thirteenFormInbound" method="post">
        	<input type= "text" name="username" value="myUserName" />
        	<input type= "text" name="emailAddress" value ="MyEmail@dog.net" />
        	<input type= "text" name="password" value = "MyPassword" />
        	<br/>
        	<input type="submit" name="Submit" />
        </form>
        <br />
        <br />
        <a href="thirteenRedirectView">Redirect View Example</a>
        
        <br />
        <br />
    </body>
</html>