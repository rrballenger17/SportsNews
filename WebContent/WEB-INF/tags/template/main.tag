<%@ tag body-content="scriptless" dynamic-attributes="dynamicAttributes"
        trimDirectiveWhitespaces="true" %>
<%@ attribute name="htmlTitle" type="java.lang.String" rtexprvalue="true"
              required="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>

<!DOCTYPE html>
<html<c:forEach items="${dynamicAttributes}" var="a">
    <c:out value=' ${a.key}="${fn:escapeXml(a.value)}"' escapeXml="false" />
</c:forEach>>
    <head>
        <title><c:out value="${fn:trim(htmlTitle)}" /></title>
    </head>
    <body>
        <jsp:doBody />
    </body>
</html>