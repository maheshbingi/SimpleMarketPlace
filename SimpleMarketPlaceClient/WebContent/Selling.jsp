<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
		<title>MarketPlace Seller Central</title>
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
        				<h4>MarketPlace Seller Central</h4>
        			</div>
      				<div class="pull-right">
        				<nav class="navbar clear-right pull-right">
          					<ul class="nav nav-pills">      
				                <li>
				                  	<a href="Selling" title="home" class="active">Home</a>
				                </li>
				                <li>
				                  	<a href="ShowCatalogs" title="home" class="active">Shopping</a>
				                </li>
			                  	<li>
			                    	<a href="SignOut" title="logout" class="">Signout</a>
			                	</li>
          					</ul>
        				</nav>
      				</div>
    			</div>
  			</div>
     	</header>
     	<div class="bs-example">
		    <ul class="nav nav-pills nav-stacked" style="max-width: 300px;">
		      <li class="active"><a href="Selling">Add Catalog</a></li>			      
		      <li><a href="SellProduct">Sell Product</a></li>
		    </ul>
		</div>
		<form action="Selling" method="post" class="addCatalog">
			<div class="form-group  addCatalogDiv pull-left">
	              <label class="inputCatalog" class="col-sm-2 control-label pull-left" style="margin-left: 15px;">Enter new Catalog</label>
	              <div class="col-sm-10">
	                  <input type="text" class="form-control" name="inputCatalogName" id="inputCatalogName" placeholder="New Catalog">
	              </div>
			</div>
			
	        <div class="form-group">
	            <div class="col-sm-offset-2 col-sm-10">
	               <button type="submit" class="btn btn-primary">Add Catalog</button>
	        </div>
	        </div>
	        <label class="error_message"> 
				<% if(request.getAttribute("isCatalogExists")!= null) 
					{	%>
						<%=request.getAttribute("isCatalogExists") %>
				<% } %>	 
			</label>
		</form>
	</body>
</html>