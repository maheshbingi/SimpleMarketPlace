<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
		<title>Insert title here</title>
		<link rel="stylesheet" href="./stylesheets/style.css" type="text/css"></link>
		<link rel="stylesheet" href="./stylesheets/bootstrap.min.css" type="text/css"></link>
		<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
		<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	</head>
	<body>
		<header>
  	 		<div class="header-top">
      			<div class="container">
       				<div class="welcome_name pull-left">
         				<h4>HTTP Error</h4>
         			</div>
       				<div class="pull-right">
         				<nav class="navbar clear-right pull-right">
           					<ul class="nav nav-pills">      
				                <li>
				                  	<a href="SignIn" title="home" class="active">SignIn</a>
				                </li>
				           	</ul>
         				</nav>
       				</div>
     			</div>
   			</div>
     	</header>
     	<div class="panel panel-primary checkoutBody">
        	<div class="panel-heading">HTTP 401: Unauthorized (Invalid session)</div>
	        <div class="panel-body">
	           <form class="form-horizontal" role="form">
			               <div class="form-group  usernameDiv">
			                  <label class="checkout control-label pull-left" style="margin-left: 2%;">Please sign-in to use marketplace</label>
			               </div>
		          </form>
	        </div>
		</div>
	</body>
</html>