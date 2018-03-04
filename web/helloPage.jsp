<%--
  Created by IntelliJ IDEA.
  User: WD45
  Date: 04.03.2018
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Привет!</title>
</head>
<body>
    <div align="center" >
        <br>
        <br>
            <table >
                <tr>
                    <td>
                        <%
                            String name = (String)request.getAttribute("name");
                            if (name != "") {
                                out.print("<label> Привет "+name+" ! </label>");
                            }else{
                                out.print("<label> Привет незнакомец ! </label>");
                            }
                        %>
                    </td>
                </tr>
                <tr>
                    <td>
                        <button type="button" onclick="location.href='/index.jsp'">Назад</button>
                    </td>
                </tr>
            </table>
    </div>
</body>
</html>
