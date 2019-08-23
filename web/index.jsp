<%--
  Created by IntelliJ IDEA.
  User: chanthan
  Date: 8/21/19
  Time: 9:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="header.jsp" />
<body>
  Hello Student-Accomodation
  <div class="">
    <table align="center">
      <div class="jumbotron">
        <form method="post" action="SignupServlet">
          <tr>
            <td colspan="2"><h3 class="form-signin-heading">Signup</h3></td>
          </tr>
          <tr>
            <td><br></td>
          </tr>
          <tr>
            <td><label class="control-label">Email</label></td>
            <td><input type="email" class="form-control" placeholder="Email address" required autofocus
                       name="email"></td>
          </tr>
          <tr>
            <td><br></td>
          </tr>
          <tr>
            <td><label class="control-label">Password</label></td>
            <td><input type="password" class="form-control" placeholder="Password" required name="password">
            </td>
          </tr>

          <tr>
            <td><br></td>
          </tr>
          <tr>
            <td><label class="control-label">First Name</label></td>
            <td><input type="text" class="form-control" placeholder="First name" required name="first_name">
            </td>
          </tr>
          <tr>
            <td></td>
            <td>
              <button class="btn btn-primary" type="submit">Signup</button>
              &nbsp;
              <button class="btn btn-primary" type="reset">Reset</button>
            </td>
            &nbsp;&nbsp;&nbsp;
          </tr>

        </form>
      </div>
    </table>
  </div>
  <jsp:include page="footer.jsp" />
</body>
</html>
