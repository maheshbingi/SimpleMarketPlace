<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@page import="com.lab2.SimpleMarketPlace.Models.ProductCatalogs"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
		<title>Sell Product</title>
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
		      <li><a href="Selling">Add Catalog</a></li>			      
		      <li class="active"><a href="SellProduct">Sell Product</a></li>
		    </ul>
		</div>	
		
		<form action="SellProduct" method="post" class="addCatalog">
			<div class="form-group pull-left">
              <label for="ProductName" class="control-label pull-left labelProduct">Product Name</label>
              <div class="col-sm-10">
                  <input type="text" class="form-control" name="inputProductName" id="inputProductName" placeholder="Product Name">
              </div>
            </div>
			<div class="select_category pull-left category_list" style="width:100%">
			    <div class="control-group pull-left" style="width:100%">
			        <label class="control-label pull-left labelProduct">Select Category</label>
			        <div class="controls pull-left category_list1">                                      
			            <select name="category_list_product" class="category_list_product">
			            <%
			      			if(request.getAttribute("catalogList") != null)
			      			{	
			      				ProductCatalogs[] catalogs= (ProductCatalogs[])request.getAttribute("catalogList");
		     	    			for (ProductCatalogs catalog: catalogs) {   
		       						if(catalog != null) {
		          		%>
		                	
		                	  <option value="<%= catalog.getName() %>" name="catalogName"> <%= catalog.getName() %></option>
		          		<%
		       						}
		       					}
			      			}	
				  		%>
			            </select>
			        </div>
			    </div>                   
			</div>
			<div class="form-group common_css">
	            <label for="ProductDescription" class="pull-left labelProduct control-label">Product Description</label>
	            <div class="col-sm-10">
	              <input type="text" class="form-control" name="inputProductDescription" id="inputProductDescription" placeholder="Product Description">
	            </div>
	        </div>
	        <div class="form-group common_css">
	            <label for="SellerInfo" class="pull-left labelProduct control-label">Seller Information</label>
	            <div class="col-sm-10">
	              <input type="text" class="form-control" name="inputSellerInfo" id="inputSellerInfo" placeholder="Seller Information">
	            </div>
	        </div>
	        <div class="form-group common_css">
	            <label for="ProductCost" class="pull-left labelProduct control-label">Product Cost</label>
	            <div class="col-sm-10">
	              <input type="text" class="form-control" name="inputProductCost" id="inputProductCost" placeholder="Product Cost">
	            </div>
	        </div>
	        <div class="form-group common_css">
	            <label for="ProductQuantity" class="pull-left labelProduct control-label">Product Quantity</label>
	            <div class="col-sm-10">
	              <input type="text" class="form-control" name="inputProductQuantity" id="inputProductQuantity" placeholder="Product Quantity">
	            </div>
	        </div>
	        <div class="form-group common_css">
	            <div class="col-sm-offset-2 col-sm-10">
	              <button type="submit" class="btn btn-primary">Sell Product</button>
	            </div>
	        </div>
	        <label class="message pull-left" style="margin-left:24%, color:RED"> 
				<% if(request.getAttribute("isProductExists")!= null) 
					{	%>
						<%=request.getAttribute("isProductExists") %>
				<% } %>	 
			</label>
	    </form>   
	</body>
</html>