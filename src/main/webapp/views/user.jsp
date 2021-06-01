<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>All Students</title>
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
</head>
<body>

    <div class="container container-default">

	   <h1>Student List Page</h1>
	    <table class="table table-striped">
	        <thead>
	            <tr>
	                <th> ID</th>
	                <th> Name</th>
	                <th> Email</th>
	                <th>Password</th>
	                <th>Country</th>
	                <th colspan="2">Action</th>
	            </tr>
	        </thead>
	        <tbody>
	            <c:forEach var="oneUser" items="${users}" >
	                <tr>
	                    <td><c:out value="${oneUser.id}" /></td>
	                    <td><c:out value="${oneUser.name}" /></td>
	                    <td><c:out value="${oneUser.email}" /></td>
	                    <td><c:out value="${oneUser.password}" /></td>
	                    <td><c:out value="${oneUser.country}" /></td>
	                    <td><a class="btn btn-primary" role="button"
	                        href="StudentServlet.do?action=edit&oneUserId=<c:out value="${oneUser.id }"/>">Update</a>
	                    <a class="btn btn-primary" role="button" style="padding-left:5px;"
	                        href="StudentServlet.do?action=delete&oneUserId=<c:out value="${oneUser.id }"/>">Delete</a>

	                    </td>

	                </tr>
	            </c:forEach>
	        </tbody>
	    </table>
	    <p>
	        <a href="StudentServlet.do?action=insert" class="btn btn-primary" role="button">Add Student</a>
	    </p>
	</div>


	<form action = "/home" method = "GET">
             First Name: <input type = "text" name = "first_name">
             <br />
             Last Name: <input type = "text" name = "last_name" />
             <input type = "submit" value = "Submit" />
          </form>


</body>
</html>