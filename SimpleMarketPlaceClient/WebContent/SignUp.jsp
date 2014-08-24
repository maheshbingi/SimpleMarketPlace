<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>New User SignUp</title>
		<link rel="stylesheet" href="./stylesheets/style.css" type="text/css"></link>
		<link rel="stylesheet" href="./stylesheets/bootstrap.min.css" type="text/css"></link>
	</head>
	<body>
		<form action="SignUp" method="post">
		   <label for="errorMessage" class="signupError"> 
				<% if(request.getAttribute("isUserExists")!= null) 
					{	%>
						<%=request.getAttribute("isUserExists") %>
				<% } %>	 
		   </label>
		   <div class="panel panel-primary signupPage">
		     <!-- Default panel contents -->
		       <div class="panel-heading">Sign Up</div>
		       <div class="panel-body">
		          <form class="form-horizontal" role="form">
	                  <div class="form-group">
	                     <label for="FirstName" class="col-sm-2 control-label">First Name</label>
	                     <div class="col-sm-10">
	                         <input type="text" class="form-control" name="inputFirstName" id="inputFirstName" placeholder="First Name">
	                     </div>
	                  </div>
	                   <div class="form-group">
	                     <label for="LastName" class="col-sm-2 control-label">Last Name</label>
	                     <div class="col-sm-10">
	                       <input type="text" class="form-control" name="inputLastName" id="inputLastName" placeholder="Last Name">
	                     </div>
	                   </div>
	                   <div class="form-group">
	                     <label for="Email ID" class="col-sm-2 control-label">Email Id</label>
	                     <div class="col-sm-10">
	                       <input type="email" class="form-control" name="inputEmailID" id="inputEmailID" placeholder="Email ID">
	                     </div>
	                   </div>
	                   <div class="form-group">
	                     <label for="Password" class="col-sm-2 control-label">Password</label>
	                     <div class="col-sm-10">
	                       <input type="password" class="form-control" name="inputPassword" id="inputPassword" placeholder="Password">
	                     </div>
	                   </div>                                        
	                   <div class="form-group">
	                     <div class="col-sm-offset-2 col-sm-10">
	                       <button type="submit" class="btn btn-primary">Sign Up</button>
	                     </div>
	                   </div>
		          </form>
		       </div>
		   </div>
		</form>
	</body>
</html>