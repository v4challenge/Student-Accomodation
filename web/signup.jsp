<%--
  Created by IntelliJ IDEA.
  User: chanthan
  Date: 8/23/19
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="header.jsp" />
<body>
<script type="text/javascript">
    $(function () {
        $("#role").change(function() {
            if (this.value !== '1') {
                $("#studentId").val("0");
                $("#student").hide();
            } else {
                $("#student").show();
            }
        });
    });
</script>
<table align="center">
    <div class="jumbotron">
            <form method="post" action="signup">
            <tr>
                <td colspan="2"><h3 class="form-signin-heading">Signup</h3></td>
            </tr>
            <tr>
                <td><br></td>
            </tr>
            <tr>
                <td><label class="control-label">Email</label></td>
                <td><input type="email" class="form-control" placeholder="Email address" required autofocus
                           NAME="email"></td>
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
                <td><input type="text" class="form-control" placeholder="First name" required name="firstName">
                </td>
            </tr>
            <tr>
                <td><br></td>
            </tr>
            <tr>
                <td><label class="control-label">Last Name</label></td>
                <td><input type="text" class="form-control" placeholder="Last name" required name="lastName"></td>
            </tr>
            <tr>
                <td><br></td>
            </tr>
            <tr>
                <td><label class="control-label">Address</label></td>
                <td><textarea ROWS="3" type="text" class="form-control" placeholder="Address" required name="address"></textarea></td>
            </tr>
            <tr>
                <td><br></td>
            </tr>
            <tr>
                <td><label class="control-label">Telephone #</label></td>
                <td><input type="number" class="form-control" placeholder="Telephone Number" required name="telephoneNumber"></td>
            </tr>
            <tr>
                <td><br></td>
            </tr>
            <tr>
                <td><label class="control-label">Role Id</label></td>
                <td>
                    <select id="role" class="form-control" name="roleId">
                        <c:forEach items="${roles}" var="role">
                            <option value="${role.roleId}">${role.roleName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td><br></td>
            </tr>
            <tbody id="student">
            <tr>
                <td><label class="control-label">Student Id</label></td>
                <td><input type="text" id="studentId" class="form-control" placeholder="Student Id" required name="studentId"></td>
            </tr>
            <tr>
                <td><br></td>
            </tr>
            </tbody>
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
<jsp:include page="footer.jsp" />
</body>
</html>
