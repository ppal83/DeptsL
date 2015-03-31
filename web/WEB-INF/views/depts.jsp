<!DOCTYPE html>

<html>

<head>

  <title>List of departments page</title>

  <%@ include file="/WEB-INF/fragments/imports.jspf"%>

</head>

<body>

<div class="container">

  <%@ include file="/WEB-INF/fragments/header.jspf"%>

  <h2>List of departments</h2>

  <form class="depts-form" method="post">

    <table class="table table-bordered table-hover depts-table">

      <tr>
        <th width="40" align="center">Dept ID</th>
        <th width="160">Dept name</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
        <th width="60">View</th>
      </tr>

      <c:forEach items="${deptsList}" var="dept">
        <tr>
          <td align="center">${dept.id}</td>
          <td>${dept.name}</td>
          <td align="center">
            <button formaction="<c:url value="/dept/edit/${dept.id}" />"
                    class="btn btn-sm btn-primary">Edit</button>
          </td>
          <td align="center">
            <button formaction="<c:url value="/dept/delete?deptId=${dept.id}" />"
                    class="btn btn-sm btn-danger">Delete</button>
          </td>
          <td align="center">
            <button formaction="<c:url value="/employee/list?deptId=${dept.id}" />"
                    class="btn btn-sm btn-primary">View</button>
          </td>
        </tr>
      </c:forEach>

    </table>

    <button formaction="<c:url value="/dept/add" />"
            class="btn btn-primary dept-add-btn">Add new dept</button>

  </form>

  <%@ include file="/WEB-INF/fragments/footer.jspf"%>

</div>

</body>

</html>