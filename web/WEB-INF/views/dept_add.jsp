<!DOCTYPE html>

<html>

<head>

  <title>Add new dept page</title>

  <%@ include file="/WEB-INF/fragments/imports.jspf"%>

</head>

<body>

<div class="container">

  <%@ include file="/WEB-INF/fragments/header.jspf"%>

  <h2>Add dept</h2>

  <form id="dept-add-form" method="post">

    <table class="dept-add-table">

      <tr>
        <td><label for="name" class="form-control">Name</label></td>
        <td><input type="text" id="name" name="name" class="form-control"></td>
      </tr>

      <tr>
        <td colspan="2">
          <button formaction="<c:url value="/dept/add.do" />"
                  class="btn btn-primary cust">Add new dept</button>
        </td>
      </tr>

    </table>

  </form>

  <%@ include file="/WEB-INF/fragments/footer.jspf"%>

</div>

</body>

</html>

