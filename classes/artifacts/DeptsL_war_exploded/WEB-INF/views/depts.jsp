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

  <table class="table table-bordered table-hover depts-table">

    <tr>
      <th>Dept ID</th>
      <th>Dept name</th>
      <th>Edit</th>
      <th>Delete</th>
      <th>View</th>
    </tr>

    <c:forEach items="${deptsList}" var="dept">

      <form class="depts-form" method="post">

        <tr>

          <td>${dept.id}</td>
          <td><c:out value="${dept.name}" /></td>
          <td>
            <button formaction="<c:url value="/deptedit_form.html" />"
                    class="btn btn-sm btn-primary">Edit</button>
          </td>

          <!-- hidden input with param 'deptId'-->
          <input type="hidden" name="deptId" value="${dept.id}" />

          <td>
            <button formaction="<c:url value="/deptdel.html" />"
                    class="btn btn-sm btn-danger">Delete</button>
          </td>

          <td>
            <button formaction="<c:url value="/emplist.html" />"
                    class="btn btn-sm btn-primary">View</button>
          </td>

        </tr>
      </form>

    </c:forEach>

  </table>

  <form class="emps-addbtn-form" method="post">
    <button formaction="<c:url value="/deptadd_form.html" />"
            class="btn btn-primary dept-add-btn">Add new dept</button>
  </form>

  <button onclick="window.history.back()"
          class="btn btn-primary btn-back">Go back</button>

  <%@ include file="/WEB-INF/fragments/footer.jspf"%>

</div>

</body>

</html>