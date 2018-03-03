<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:attribute name="title">Информация</jsp:attribute>
    <jsp:body>
        <h1>Представьтесь, пожалуйста</h1>
        <form method="POST" action="info">
          <div class="form-group">
            <label for="name">Ваше имя</label>
            <input
                type="text"
                class="form-control"
                id="name"
                name="name"
                placeholder="Введите имя"
                required
                pattern="^[A-Za-z ]+$"
            />
            <small class="form-text text-muted">Только латинские символы и пробел</small>
          </div>
          <button type="submit" class="btn btn-primary">Представиться</button>
        </form>

        <script>
            document.addEventListener("DOMContentLoaded", function(){
                document.getElementById("name").focus();
            });
        </script>
    </jsp:body>
</t:genericpage>