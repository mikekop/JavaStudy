<%@page contentType="text/html" pageEncoding="UTF-8" language="java" session="true"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:set var="context" value="${pageContext.request.contextPath}" />

<t:genericpage>
    <jsp:attribute name="title">Информация</jsp:attribute>
    <jsp:attribute name="h1">Привет, <c:out value="${sessionScope.name}" /></jsp:attribute>
</t:genericpage>