<%@ taglib prefix="fmt"
           uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html>

<head>

  <title>List of employees page</title>

  <%@ include file="/WEB-INF/fragments/imports.jspf"%>

</head>

<body>

<div class="container">

  <%@ include file="/WEB-INF/fragments/header.jspf"%>

  <h2>List of employees of ${dept.name} department</h2>

  <div class="table-responsive">

    <table class="table table-bordered table-hover empls-table">

      <tr>
        <th>Employee ID</th>
        <th>Employee Name</th>
        <th>Birthday</th>
        <th>Hireday</th>
        <th>Address</th>
        <th>Email</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Edit</th>
        <th>Delete</th>
      </tr>

      <c:forEach items="${empsList}" var="employee">

        <form class="emps-form" method="post">

          <tr>

            <td>${employee.id}</td>
            <td><c:out value="${employee.name}" /></td>
            <td><fmt:formatDate pattern="yyyy-MM-dd"
                                value="${employee.birthDate}" /></td>
            <td><fmt:formatDate pattern="yyyy-MM-dd"
                                value="${employee.hireDate}" /></td>
            <td><c:out value="${employee.address}" /></td>
            <td>${employee.email}</td>
            <td><c:out value="${dept.name}" /></td>
            <td>${employee.salary}</td>

            <!-- hidden input with param 'id'-->
            <input type="hidden" name="id" value="${employee.id}" />

            <td>
              <button formaction="<c:url value="/empedit_form.html" />"
                      class="btn btn-sm btn-primary">Edit</button>
            </td>

            <td>
              <button formaction="<c:url value="/empdel.html" />"
                      class="btn btn-sm btn-danger">Delete</button></a>
            </td>

          </tr>

        </form>

      </c:forEach>

    </table>

    <form class="emps-addbtn-form" method="post">

      <!-- hidden input with param 'deptsList'-->
      <button formaction="<c:url value="/empadd_form.html" />"
              class="btn btn-primary emp-add-btn">Add new employee</button>
    </form>

    <button onclick="window.history.back()"
            class="btn btn-primary btn-back">Go Back</button>

  </div>

  <%@ include file="/WEB-INF/fragments/footer.jspf"%>

</div>

</body>

</html>