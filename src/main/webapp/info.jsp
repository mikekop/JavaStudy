<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:attribute name="title">Информация</jsp:attribute>
    <jsp:attribute name="style">
        .name-title{
            text-align: center;
            font-size: 4em;
        }
        .name-helper{
            text-align: center;
            font-size: 2em;
        }
    </jsp:attribute>

    <jsp:body>
        <h1 class="name-title">Привет, ${name}</h1>
        <p class="name-helper">Мы что то перепутали? <a href="index.jsp">представьтесь заново</a></p>
    </jsp:body>
</t:genericpage>