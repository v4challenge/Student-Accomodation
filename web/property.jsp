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
<table align="center">
    <div class="jumbotron">
        <form method="post" action="property">
            <tr>
                <td colspan="2"><h3 class="form-signin-heading">Property</h3></td>
            </tr>
            <tr>
                <td><br></td>
            </tr>
            <c:if test="${not empty property.propertyId}">
            <tr>
                <td><label class="control-label">Property Id</label></td>
                <td><input type="text" class="form-control" placeholder="Update Your Role" required name="propertyId"
                           value="${property.propertyId}" readonly></td>
            </tr>
            <tr>
                <td><br></td>
            </tr>
            </c:if>
            <tr>
                <td><label class="control-label">Address</label></td>
                <td><textarea ROWS="3" type="text" class="form-control" placeholder="Address" required name="address">${property.address}</textarea></td>
            </tr>
            <tr>
                <td><br></td>
            </tr>
            <tr>
                <td><label class="control-label">Property Type</label></td>
                <td>
                    <select class="form-control" name="propertyType">
                        <c:forEach items="${propertyTypes}" var="propertyType">
                            <option value="${propertyType.propertyType}" ${propertyType.propertyType == property.propertyType ? 'selected' : ''}>${propertyType.propertyType}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td><br></td>
            </tr>
            <tr>
                <td><label class="control-label">No of Tenants </label></td>
                <td><input type="number" value="${property.tenants}" class="form-control" placeholder="No of Tenants" required name="tenants"></td>
            </tr>
            <tr>
                <td><br></td>
            </tr>
            <tr>
                <td><label class="control-label">Image</label></td>
                <td><input type="file" class="form-control" value="Select Image" required name="image"></td>
            </tr>
            <tr>
                <td><br></td>
            </tr>
            <tr>
                <td><label class="control-label">Amount</label></td>
                <td><input type="number" value="${property.amount}" class="form-control" placeholder="Amount" required name="amount"></td>
            </tr>
            <tr>
                <td><br></td>
            </tr>
            <tr>
                <td><label class="control-label">Booking</label></td>
                <td>
                    <select name="is_available" class="form-control">
                        <option value="false" ${property.isAvailable() == false ? 'selected' : ''}>Booked</option>
                        <option value="true" ${property.isAvailable() == true ? 'selected' : ''}>UnBooked</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><br></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <% if (request.getAttribute("action") != null && request.getAttribute("action").equals("edit")) { %><button class="btn btn-primary" type="submit">Update</button>
                    <% } else if (request.getAttribute("action") != null && request.getAttribute("action").equals("delete")) { %><button class="btn btn-primary" type="submit">Delete</button>
                    <% } else { %><button class="btn btn-primary" type="submit">Signup</button>
                    <% } %>
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
