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

        <form class="emps-form" method="post">

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

            <!-- hidden input with param 'id'-->
            <input type="hidden" name="id" value="${employee.id}" />

            <td align="center">
              <button formaction="<c:url value="/empedit_form.html" />"
                      class="btn btn-sm btn-primary">Edit</button>
            </td>

            <td align="center">
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