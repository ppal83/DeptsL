<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>

  <title>Bootstrap Test Page JSP</title>

  <link href="../../css/bootstrap.min.css" rel="stylesheet">
  <script src="../../js/bootstrap.min.js"></script>
  <script src="../../js/jquery-1.11.2.min.js"></script>

</head>

<body>

<div class="container">
  <nav class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">TutorialsPoint</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">iOS</a></li>
        <li><a href="#">SVN</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">
            Java
            <b class="caret"></b>
          </a>
          <ul class="dropdown-menu">
            <li><a href="#">jmeter</a></li>
            <li><a href="#">EJB</a></li>
            <li><a href="#">Jasper Report</a></li>
            <li class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </nav>
</div>

<script>
  alert(typeof jQuery);
</script>

</body>

</html>