<!DOCTYPE html>

<html>

<head>

  <title>Edit dept page</title>

  <%@ include file="/WEB-INF/fragments/imports.jspf"%>

</head>

<body>

<div class="container">

  <%@ include file="/WEB-INF/fragments/header.jspf"%>

  <h2>Edit dept</h2>

  <form class="dept-edit-form" method="post">

    <table class="dept-edit-table">

      <tr>
        <td><label for="id" class="form-control">ID</label></td>
        <td><input type="text" id="id" name="id" class="form-control"
                   readonly value="${dept.id}" /></td>
      </tr>

      <tr>
        <td><label for="name" class="form-control">Name</label></td>
        <td><input type="text" id="name" name="name" class="form-control"
                   value="${dept.name}" /></td>
      </tr>

      <tr>
        <td colspan="2">
          <button formaction="<c:url value="/deptedit.html" />"
                  class="btn btn-primary cust">Edit dept</button>
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

