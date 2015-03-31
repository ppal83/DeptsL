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

  <form class="emps-form" method="post">

    <div class="table-responsive">

      <table class="table table-bordered table-hover empls-table">

        <tr>
          <th width="40" align="center">Employee ID</th>
          <th width="160">Employee Name</th>
          <th width="80">Birthday</th>
          <th width="80">Hireday</th>
          <th width="140">Address</th>
          <th width="120">Email</th>
          <th width="120">Department</th>
          <th width="60">Salary</th>
          <th width="60">Edit</th>
          <th width="60">Delete</th>
        </tr>

        <c:forEach items="${empsList}" var="employee">

          <tr>
            <td align="center">${employee.id}</td>
            <td>${employee.name}</td>
            <td align="center"><fmt:formatDate pattern="yyyy-MM-dd"
                                               value="${employee.birthDate}" /></td>
            <td align="center"><fmt:formatDate pattern="yyyy-MM-dd"
                                               value="${employee.hireDate}" /></td>
            <td>${employee.address}</td>
            <td>${employee.email}</td>
            <td>${dept.name}</td>
            <td align="center">${employee.salary}</td>
            <td align="center">
              <button formaction="<c:url value="/employee/edit?id=${employee.id}" />"
                      class="btn btn-sm btn-primary">Edit</button>
            </td>
            <td align="center">
              <button formaction="<c:url value="/employee/delete?id=${employee.id}" />"
                      class="btn btn-sm btn-danger">Delete</button></a>
            </td>
          </tr>

        </c:forEach>

      </table>

      <button formaction="<c:url value="/employee/add" />"
              class="btn btn-primary emp-add-btn">Add new employee</button>

      <button onclick="window.history.back()"
              class="btn btn-primary cust">Go Back</button>

    </div>

  </form>

  <%@ include file="/WEB-INF/fragments/footer.jspf"%>

</div>

</body>

</html>