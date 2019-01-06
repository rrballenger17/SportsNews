<%--@elvariable id="discussions" type="java.util.List<com.wrox.site.entity.Discussion>"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<!DOCTYPE html>
<html>
    <head>
        <title>Sports News</title>
    </head>
    <body>
        <h2>Sports News</h2>
        
        <br />
        <h3 style="color:blue">This page was generated using the Controller-Service-Repository pattern</h5>
        <br />
        
                <c:forEach items="${items}" var="item">
					Name: <c:out value="${item.name}" /><br />
					Description: <c:out value="${item.description }" /><br />
					<br />
					<br />
                    
                </c:forEach>
    </body>
</html>
