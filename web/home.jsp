<%--
  Created by IntelliJ IDEA.
  User: chanthan
  Date: 8/23/19
  Time: 6:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setDateHeader("Expires", 0);
    response.setHeader("Pragma","no-cache");
    if(session.getAttribute("name")==null)
    {
        response.sendRedirect("index.jsp");
    }
%>
<jsp:include page="header.jsp" />
<body>
    <table align="center" class="table table-striped">
        <div class="jumbotron">
            <h2 align="center">Properties</h2>
            <tr>
                <th>propertyId</th>
                <th>userId</th>
                <th>address</th>
                <th>property_type</th>
                <th>tenants</th>
                <th>image</th>
                <th>amount</th>
                <th>isAvailable</th>
                <td align="center" colspan="3">Action</td>
            </tr>
            <c:forEach var="property" items="${properties}">
            <tr>
                <td><c:out value="${property.propertyId}" /></td>
                <td><c:out value="${property.userId}" /></td>
                <td><c:out value="${property.address}" /></td>
                <td><c:out value="${property.propertyType}" /></td>
                <td><c:out value="${property.tenants}" /></td>
                <td><c:out value="${property.image}" /></td>
                <td><c:out value="${property.amount}" /></td>
                <td><c:out value="${property.isAvailable()}" /></td>
                <% if (session.getAttribute("roleId") != null && (Integer) session.getAttribute("roleId") == 2) { %>
                <td><a href="property?edit=${property.propertyId}">Edit</a></td>
                <td><a href="property?delete=${property.propertyId}">Delete</a></td>
                <% } %>
                <c:choose>
                    <c:when test="${property.isAvailable()}"><td><a style="color: #10ca10f7" href="book?propertyId=${property.propertyId}&userId=${property.userId}">Book</a></td>
                    </c:when>
                    <c:otherwise>
                    <td style="color: red;">Booked</td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:forEach>
        </div>
    </table>
<jsp:include page="footer.jsp" />
</body>
</html>
