<%--
  Created by IntelliJ IDEA.
  User: WD45
  Date: 27.02.2018
  Time: 22:53
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
          <tr>
            <td colspan="2" align="left">
              <a href="publicPage.jsp" id="publicPage">go Public Page</a>
            </td>
          </tr>
          <tr>
            <td colspan="2" align="left" >
              <a heref="privatePage.jsp" id="privatePage">go Private Page</a>
            </td>
          </tr>
        </table>
      </form>
    </div>
  </body>
</html>

<script>
      $( document ).ready(function() {
          $("#privatePage").on("click", "a", function(e){
              d = "false";
              <%
                String isAuthorized = (String)session.getAttribute("isAuthorized");
                if (isAuthorized == "true") {
                  out.print("d = \"true\"");
                }
              %>
              if (d != "true"){
                  e.preventDefault(); //отменяем переход по ссылке
                  alert("No access!");
              }
          });
      });
</script>
