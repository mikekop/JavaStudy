<%--
  Created by IntelliJ IDEA.
  User: WD45
  Date: 17.03.2018
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
  <title>Web</title>
</head>
<body>
<!-- header -->
<div align="center" >
  <br>
  <br>
  <form method="post" action="authorization">
    <table >
      <tr>
        <td>
          <label>Login:</label>
        </td>
        <td>
          <input type="text" name="login"><br />
        </td>
      </tr>
      <tr>
        <td>
          <label>Password:</label>
        </td>
        <td>
          <input type="password" name="password"><br />
        </td>
      </tr>
      <tr>
        <td colspan="2" align="right">
          <button type="submit">Sign in</button>
        </td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>
