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
<table align="center">
    <div class="jumbotron">
            <form method="post" action="user">
            <tr>
                <td colspan="2"><h3 class="form-signin-heading"><%=session.getAttribute("name")%>'s Profile</h3></td>
            </tr>
            <tr>
                <td><br></td>
            </tr>
            <tr>
                <td><label class="control-label">User Id</label></td>
                <td><input type="text" class="form-control" placeholder="Update Your Role" required name="userId"
                           value="${user.userId}" readonly></td>
            </tr>
            <tr>
                <td><br></td>
            </tr>
            <tr>
                <td><label class="control-label">Email</label></td>
                <td><input type="email" class="form-control" placeholder="Email address" required autofocus
                           value="${user.email}" name="email"></td>
            </tr>
            <tr>
                <td><br></td>
            </tr>
            <tr>
                <td><label class="control-label">Password</label></td>
                <td><input type="password" readonly value="${user.password}" class="form-control" placeholder="Password" required name="password">
                </td>
            </tr>

            <tr>
                <td><br></td>
            </tr>
            <tr>
                <td><label class="control-label">First Name</label></td>
                <td><input type="text" value="${user.firstName}" class="form-control" placeholder="First name" required name="firstName">
                </td>
            </tr>
            <tr>
                <td><br></td>
            </tr>
            <tr>
                <td><label class="control-label">Last Name</label></td>
                <td><input type="text" value="${user.lastName}" class="form-control" placeholder="Last name" required name="lastName"></td>
            </tr>
            <tr>
                <td><br></td>
            </tr>
            <tr>
                <td><label class="control-label">Address</label></td>
                <td><textarea ROWS="3" type="text" class="form-control" placeholder="Address" required name="address">${user.address}</textarea></td>
            </tr>
            <tr>
                <td><br></td>
            </tr>
            <tr>
                <td><label class="control-label">Telephone #</label></td>
                <td><input type="number" value="${user.telephoneNumber}" class="form-control" placeholder="Telephone Number" required name="telephoneNumber"></td>
            </tr>
            <tr>
                <td><br></td>
            </tr>
            <tr>
                <td><label class="control-label">Role </label></td>
                <td>
                    <select id="role" class="form-control" name="roleId" readonly>
                        <c:forEach items="${roles}" var="role">
                            <option value="${role.roleId}" ${role.roleId == user.roleId ? 'selected' : 'disabled'}>${role.roleName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td><br></td>
            </tr>
            <c:if test="${user.studentId != 0}">
            <tr>
                <td><label class="control-label">Student Id</label></td>
                <td><input type="text" value="${user.studentId}" id="studentId" class="form-control" placeholder="Student Id" required name="studentId"></td>
            </tr>
            <tr>
                <td><br></td>
            </tr>
            </c:if>
            <c:if test="${user.rentId != 0}">
                <tr>
                    <td><label class="control-label">Property Id</label></td>
                    <td><input type="text" value="${user.rentId}" readonly class="form-control" placeholder="Property Id" required name="rentId"></td>
                </tr>
                <tr>
                    <td><br></td>
                </tr>
            </c:if>
            <tr>
                <td></td>
                <td>
                    <button class="btn btn-primary" type="submit">Update</button>
                </td>
                &nbsp;&nbsp;&nbsp;
            </tr>

        </form>
    </div>
</table>
<jsp:include page="footer.jsp" />
</body>
</html>
