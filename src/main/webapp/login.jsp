<%@page contentType="text/html" pageEncoding="UTF-8" language="java" session="true"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<t:genericpage>
    <jsp:attribute name="title">Информация</jsp:attribute>
    <jsp:attribute name="h1">Авторизуйтесь, пожалуйста</jsp:attribute>
    <jsp:body>
        <form method="POST" action="login">

          <div class="form-group">
            <label for="name">Логин</label>
            <input
                type="text"
                class="form-control"
                id="name"
                name="name"
                placeholder="Введите имя"
                required
                pattern="^[A-Za-z]+$"
            />
            <small class="form-text text-muted">Только латинские символы</small>
          </div>
            <div class="form-group">
              <label for="pass">Пароль</label>
              <input
                  type="password"
                  class="form-control"
                  id="pass"
                  name="pass"
                  placeholder="Введите пароль"
                  required
                  pattern="^[A-Za-z0-9]+$"
              />
              <small class="form-text text-muted">Только латинские символы и цифры</small>
            </div>
          <button type="submit" class="btn btn-primary">Авторизоваться</button>
        </form>

        <script>
            document.addEventListener("DOMContentLoaded", function(){
                document.getElementById("name").focus();
            });
        </script>
    </jsp:body>
</t:genericpage>