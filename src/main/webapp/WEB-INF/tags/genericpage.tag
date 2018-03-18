<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<c:set var="isAuthorized" value="${not empty sessionScope.name}" />
<c:set var="uri" value="${pageContext.request.requestURI}" />

<%@attribute name="title" fragment="true" %>
<%@attribute name="style" fragment="true" %>
<%@attribute name="h1" fragment="true" %>
<!doctype html>
<html lang="ru">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>
        <jsp:invoke fragment="title"/> | App
    </title>
    <style>
        .main-content{
            min-height: 100vh;
            display: flex;
            align-items: center;
            flex-direction: column;
            width: 100%;
        }
        .navbar{
            width: 100%;
            flex-shrink: 0;
        }
        .main-content > .container{
            flex: 1;
            min-height: 100%;
            padding-top: 20px;
        }
        <jsp:invoke fragment="style" />
    </style>
  </head>
  <body>
  <div class="main-content">
      <nav class="navbar navbar-dark navbar-expand bg-dark">
        <a class="navbar-brand" href="${context}/">JavaStudy</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar" aria-controls="navbar" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbar">
                <ul class="navbar-nav mr-auto">
                  <li class="nav-item">
                    <a class="nav-link" href="${context}/">Главная <span class="sr-only">(current)</span></a>
                  </li>
                  <c:if test="${isAuthorized}">
                  <li class="nav-item">
                    <a class="nav-link" href="info.jsp">Личный кабинет</a>
                  </li>
                  </c:if>
                  <c:if test="${not isAuthorized}">
                  <li class="nav-item">
                    <a class="nav-link" href="${context}/login">Войти</a>
                  </li>
                  </c:if>
                  <c:if test="${isAuthorized}">
                  <li class="nav-item">
                    <a class="nav-link" href="${context}/logout">Выйти</a>
                  </li>
                  </c:if>
                </ul>
              </div>
      </nav>
    <div class="container">
        <c:if test="${not empty sessionScope.errorMessage}">
            <div class="alert alert-danger" role="alert">
                <c:out value="${sessionScope.errorMessage}" />
            </div>
            <c:remove var="errorMessage" scope="session" />
        </c:if>
        <c:if test="${not empty sessionScope.successMessage}">
            <div class="alert alert-success" role="alert">
                <c:out value="${sessionScope.successMessage}" />
            </div>
            <c:remove var="successMessage" scope="session" />
        </c:if>
        <c:if test="${not empty h1}">
            <h1><jsp:invoke fragment="h1" /></h1>
        </c:if>
      <jsp:doBody/>
    </div>
  </div>
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>