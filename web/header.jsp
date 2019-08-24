<%--
  Created by IntelliJ IDEA.
  User: chanthan
  Date: 8/21/19
  Time: 11:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/style.css" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Student-Accomodation</title>
</head>
<body>
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
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="home">Student-Accommodation</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="home">Home</a></li>
                <% if (session.getAttribute("roleId") != null && (Integer) session.getAttribute("roleId") == 2) { %>
                <li><a href="property">Property</a></li>
                <% } %>
                <li><a href="#"><%=session.getAttribute("name")%>'s Profile</a></li>
                <li><a href="access">Log out</a></li>
            </ul>


        </div>
    </div>
</div>
</body>
</html>
