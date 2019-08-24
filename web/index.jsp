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
  <table align="center">
    <div class="jumbotron">
      <form method="post" action="access">
        <tr>
          <td><h3 class="form-signin-heading">Login</h3></td>
        </tr>
        <tr>
          <td><input type="email" name="email" class="form-control" placeholder="Email address" required
                     autofocus></td>
        </tr>
        <tr>
          <td><br></td>
        </tr>
        <tr>
          <td><input type="password" name="password" class="form-control" placeholder="Password" required>
          </td>
        </tr>
        <tr>
          <td>
            <div class="checkbox">
              <label>
                <input type="checkbox" value="remember-me"> Remember me
              </label>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
          </td>
        </tr>
        <tr>
          <td><br></td>
        </tr>
        <tr>
          <td><label>Don't have an account<a href="signup">&nbsp;Signup</a></label></td>
        </tr>
      </form>
    </div>
  </table>
  <jsp:include page="footer.jsp" />
</body>
</html>
