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
    <title>Web</title>
  </head>
  <body>
  <!-- header -->
    <div align="center" >
      <br>
      <br>
      <form method="post" action="redirect">
        <table >
          <tr>
              <td>
                <label>ФИО:
                  <input type="text" name="name"><br />
                </label>
              </td>
          </tr>
          <tr>
            <td>
                <button type="submit">Отправить</button>
            </td>
          </tr>
        </table>
      </form>
    </div>
  </body>
</html>
