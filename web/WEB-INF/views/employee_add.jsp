<!DOCTYPE html>

<html>

<head>

  <title>Add new employee page</title>

  <%@ include file="/WEB-INF/fragments/imports.jspf"%>

</head>

<body>

<div class="container">

  <%@ include file="/WEB-INF/fragments/header.jspf"%>

  <h2>Add employee</h2>

  <form class="emp-add-form" method="post">

    <table class="emp-add-table">

      <tr>
        <td><label for="name" class="form-control">Name</label></td>
        <td><input type="text" id="name" name="name" class="form-control"></td>
        <td>${errorsBean.name}</td>
      </tr>

      <tr>
        <td><label for="Birthday" class="form-control">Birthday</label></td>
        <td><input type="text" id="Birthday" name="Birthday"
                   class="form-control" placeholder="yyyy-MM-dd"></td>
        <td>${errorsBean.birthDate}</td>
      </tr>

      <tr>
        <td><label for="HireDate" class="form-control">HireDate</label></td>
        <td><input type="text" id="HireDate" name="HireDate"
                   class="form-control" placeholder="yyyy-MM-dd"></td>
        <td>${errorsBean.hireDate}</td>
      </tr>

      <tr>
        <td><label for="address" class="form-control">Address</label></td>
        <td><input type="text" id="address" name="address" class="form-control"></td>
        <td>${errorsBean.address}</td>
      </tr>

      <tr>
        <td><label for="email" class="form-control">Email</label></td>
        <td><input type="text" id="email" name="email" class="form-control"></td>
        <td>${errorsBean.email}</td>
      </tr>

      <tr>
        <td><label for="dept" class="form-control">Dept</label></td>
        <td><select id="dept" name="dept" class="form-control">
          <c:forEach items="${deptsList}" var="dept">
          <option value="${dept.id}">${dept.name}
            </c:forEach>
        </select></td>
      </tr>

      <tr>
        <td><label for="salary" class="form-control">Salary</label></td>
        <td><input type="text" id="salary" name="salary" class="form-control"></td>
        <td>${errorsBean.salary}</td>
      </tr>

      <tr>
        <td colspan="2">
          <button formaction="<c:url value="/empadd.html" />"
                  class="btn btn-primary cust">Add new employee</button>
        </td>
      </tr>

      <tr>
        <td>
          <button onclick="window.history.back()"
                  class="btn btn-primary btn-back">Go Back</button>
        </td>
      </tr>

    </table>

  </form>

  <%@ include file="/WEB-INF/fragments/footer.jspf"%>

</div>

</body>

</html>

