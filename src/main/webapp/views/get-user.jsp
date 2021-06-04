<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add/Edit New User</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
</head>
<body>
  <h1>User Details </h1>
   <div class="container container-default">
   		<div class="well">
	                <label for="id" class="col-2 col-form-label"> ID</label>
	                <div class="col-10">
		                    ${user.id}
	                </div>
	            </div>

	            <div class="form-group row">
                	                <label for="id" class="col-2 col-form-label"> Name</label>
                	                <div class="col-10">
                		                    ${user.name}
                	                </div>
                	            </div>
                <div class="form-group row">
                                	                <label for="id" class="col-2 col-form-label"> Email</label>
                                	                <div class="col-10">
                                		                    ${user.email}
                                	                </div>
                                	            </div>
                   <div class="form-group row">
                                                	                <label for="id" class="col-2 col-form-label"> Password</label>
                                                	                <div class="col-10">
                                                		                    ${user.password}
                                                	                </div>
                                                	            </div>
                                                	            <div class="form-group row">
                                                                	                <label for="id" class="col-2 col-form-label"> Country</label>
                                                                	                <div class="col-10">
                                                                		                    ${user.country}
                                                                	                </div>
                                                                	            </div>


		


		</div>
	</div>



	 <a class="btn btn-primary" role="button" style="padding-left:5px;"
    	                        href="/deleteUser?id=<c:out value="${oneUser.id }"/>">Delete</a>
</body>
</html>
