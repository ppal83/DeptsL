<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Test Page JSP</title>
  <link href="WEB-INF/css/bootstrap.min.css" rel="stylesheet">
  <script src="WEB-INF/js/jquery-2.1.3.js"></script>
  <script src="WEB-INF/js/bootstrap.min.js"></script>
</head>
<body>

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

</body>
</html>