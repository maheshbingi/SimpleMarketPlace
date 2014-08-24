<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
		<title>SignIn</title>
		<link rel="stylesheet" href="./stylesheets/style.css" type="text/css"></link>
		<link rel="stylesheet" href="./stylesheets/bootstrap.min.css" type="text/css"></link>
		<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
		<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	</head>
	<body>
		<form action="SignIn" method="post" class="afterSignIn">
			<label for="errorMessage" class="error_message"> 
				<% if(request.getAttribute("isValidUser")!= null) 
					{	%>
						<%=request.getAttribute("isValidUser") %>
				<% } %>	 
			</label>
			<div class="panel panel-primary">
			    <!-- Default panel contents -->
			       <div class="panel-heading">Login</div>
			       <div class="panel-body">
			          <form class="form-horizontal" role="form">
				               <div class="form-group  usernameDiv">
				                  <label class="inputUsername" class="col-sm-2 control-label pull-left">Enter your Email id</label>
				                  <div class="col-sm-10">
				                      <input type="email" class="form-control" name="inputUsername" id="inputUsername" placeholder="Email Id">
				                  </div>
				               </div>
			                  <div class="form-group  usernameDiv">
			                    <label for="inputPassword">Password</label>
			                    <div class="col-sm-10">
			                      <input type="password" class="form-control" name="inputPassword" id="inputPassword" placeholder="Password">
			                    </div>
			                  </div>
			                  
			                  <div class="form-group ">
			                    <div class="pull-left signIn">
			                      <button type="submit" class="btn btn-primary">Sign in</button>
			                    </div>
			                  </div>
			             </form>
			       </div>
			</div>
		
			<div class="control-group signuplink">
				<div class="controls">
			 			<label class="">Not a member? 
			 				<a href="SignUp.jsp" title="forget-password"> Sign Up </a> to register
					</label>			
				</div>		
			</div>
		</form>	
	</body>
	
</html>