<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add/Edit New Student</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
</head>
<body>
  <h1>Add/Edit User Page</h1>
   <div class="container container-default">
   		<div class="well">
			<form action="localhost:8080/user" method="post">
				 <div class="form-group row">
	                <label for="id" class="col-2 col-form-label"> ID</label> 
	                <div class="col-10">
		                <input type="text" class="form-control"
		                    name="id" value="<c:out value="${oneUser.id}" />"
		                    readonly="readonly" placeholder="Read only field" />
	                </div>
	            </div>
				<div class="form-group row">
					<label for="name" class="col-2 col-form-label">
						Name</label>
					<div class="col-10">
						<input class="form-control" type="text" name="name"
							value="<c:out value="${oneUser.firstName}"/>" id="name"
							placeholder=" Name">
					</div>
				</div>
				<div class="form-group row">
					<label for="email" class="col-2 col-form-label">Email</label>
					<div class="col-10">
						<input class="form-control" type="text" name="email"
							value="<c:out value="${oneUser.email}"/>" id="email"
							placeholder="Email">
					</div>
				</div>
		
				<div class="form-group row">
					<label for="password" class="col-2 col-form-label">Password</label>
					<div class="col-10">
						<input class="form-control" type="text" name="password"
							value="<c:out value="${oneUser.password}"/>" id="password"
							placeholder="password">
					</div>
				</div>
				<div class="form-group row">
					<label for="country" class="col-2 col-form-label">Country</label>
					<div class="col-10">
						<input class="form-control" type="text" name="country"
							value="<c:out value="${oneUser.country}"/>" id="country"
							placeholder="country">
					</div>
				</div>
		
				<div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
		
			</form>
		</div>
	</div>
</body>
</html>
