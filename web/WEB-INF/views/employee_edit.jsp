<%@ taglib prefix="fmt"
           uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html>

<head>

  <title>Edit employee page</title>

  <%@ include file="/WEB-INF/fragments/imports.jspf"%>

</head>

<body>

<div class="container">

  <%@ include file="/WEB-INF/fragments/header.jspf"%>

  <h2>Edit employee</h2>

  <form class="emp-edit-form" method="post">

    <table class="emp-edit-table">

      <tr>
        <td><label for="id" class="form-control">ID</label></td>
        <td><input type="text" id="id" name="id" class="form-control"
                   readonly value="${employee.id}" /></td>
      </tr>

      <tr>
        <td><label for="name" class="form-control">Name</label></td>
        <td><input type="text" id="name" name="name" class="form-control" value="${employee.name}" /></td>
      </tr>

      <tr>
        <td><label for="Birthday" class="form-control">Birthday</label></td>
        <td><input type="text" id="Birthday" name="Birthday" class="form-control" placeholder="yyyy-MM-dd"
                   value="<fmt:formatDate pattern="yyyy-MM-dd" value="${employee.birthDate}" />"></td>
      </tr>

      <tr>
        <td><label for="HireDate" class="form-control">HireDate</label></td>
        <td><input type="text" id="HireDate" name="HireDate" class="form-control" placeholder="yyyy-MM-dd"
                   value="<fmt:formatDate pattern="yyyy-MM-dd" value="${employee.hireDate}" />" /></td>
      </tr>

      <tr>
        <td><label for="address" class="form-control">Address</label></td>
        <td><input type="text" id="address" name="address" class="form-control"
                   value="${employee.address}" /></td>
      </tr>

      <tr>
        <td><label for="email" class="form-control">Email</label></td>
        <td><input type="text" id="email" name="email" class="form-control"
                value="${employee.email}"/></td>
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
        <td><input type="text" id="salary" name="salary" class="form-control"
                   value="${employee.salary}" /></td>
      </tr>

      <tr>
        <td colspan="2">
          <button formaction="<c:url value="/empedit.html" />"
                  class="btn btn-primary cust">Edit employee</button>
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

