<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="title" fragment="true" %>
<%@attribute name="style" fragment="true" %>
<!doctype html>
<html lang="en">
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
        }
        <jsp:invoke fragment="style" />
    </style>
  </head>
  <body>
  <div class="main-content">
    <div class="container">
      <jsp:doBody/>
    </div>
  </div>
  </body>
</html>