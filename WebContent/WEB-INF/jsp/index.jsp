<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Sports News</h2>

	<a href="ContextParametersServlet">Ch. 3: Context Parameters Servlet</a>
	<br />
	<a href="uploadtest">Ch. 3: File Upload Servlet</a>
	<br />
	<a href="welcome">Ch. 3: Greeting Servlet</a>
	<br />
	<a href="Dogs">Ch. 3: Test Servlet</a>
	<br />
	<a href="JspDispatcherServlet">Ch. 4: JSP Dispatcher Servlet</a>
	<br />
	<a href="ExpressionLanguageExample">Ch. 6: Expression Language Example</a>
	<br />
	<a href="JavaStandardTagLibraryServlet">Ch. 7: Java Standard Tag Library Example</a>
	<br />
	<a href="CustomTagExample">Ch. 8: Custom Tag and Function Libraries - Tag File Example</a>
	<br />
	<a href="TagLibraryDescriptorExample">Ch. 8: Custom Tag and Function Libraries - Tag Library Descriptor Example</a>
	<br />
	<a href="TagLibraryDescriptorELExample">Ch. 8: Custom Tag and Function Libraries - TLD EL Function Example</a>
	<br />
	<a href="logout">Ch. 9: Improving the Application using Filters</a>
	<br />
	<a href="#">Ch. 10: Making the Application Interactive with Web Sockets</a>
	<br />
	<a href="Log4J2Example">Ch. 11: Using Logging to Monitor the Application</a>
	<br />
	<br />
	<br />
	<a href="logout">Logout</a>
	<br />
	<br />
	<br /> ${requestScope["line"]} ${requestScope["story"]}
</body>
</html>
