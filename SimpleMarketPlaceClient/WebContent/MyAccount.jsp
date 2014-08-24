<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@page import="com.lab2.SimpleMarketPlace.Models.UserBuyHistory"%>
<%@page import="com.lab2.SimpleMarketPlace.Models.UserSellHistory"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
		<title>MyAccount</title>
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
                   <h4>My Account</h4>
               </div>
               <div class="pull-right">
                   <nav class="navbar clear-right pull-right">
                       <ul class="nav nav-pills">      
                           <li>
			                	<a href="ShowCatalogs" title="home" class="active">Home</a>
			               </li>
			                
							<li>
			                  	<a href="Selling" title="selling" class="active">Selling</a>
			                </li>
			                
			           		<li>
	               				<a href="MyAccount" title="My Account" class="">My Account</a>
	             			</li>
	             					
	             			<li>
	               				<a href="MyCart" title="My Cart" class="">My Cart</a>
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
        <h4>Items bought</h4>
        <section class="adjust container">
	        <table class="table table-striped">                         
	            <thead>
	                <tr>
	                    <th>Product Name</th>
	                    <th>Product Count</th>
	                    <th>Amount</th>
	                    <th></th>
	                </tr>
	            </thead>
	            
	            <tbody>
		            <%
				      	if(request.getAttribute("userBuyHistoryList") != null)
				      	{	
				      		UserBuyHistory[] buyList= (UserBuyHistory[])request.getAttribute("userBuyHistoryList");
			     	    	for (UserBuyHistory buyItem: buyList) {   
			       				if(buyItem != null) {
			        %>
		                <tr>
		                     <th><%= buyItem.getProductName() %></th>
		                     <th><%= buyItem.getProductCount() %></th>
		                     <th><%= buyItem.getCost() %></th>
	                    </tr>
			        <%
			       				}
			       			}
				      	}	
					%>
	            </tbody>                        
	        </table>
        </section>
        
        <h4>Items Sold</h4>
        <section class="adjust container">
	        <table class="table table-striped">                         
	            <thead>
	                <tr>
	                    <th>Product Name</th>
	                    <th>Product Count</th>
	                    <th>Amount</th>
	                    <th></th>
	                </tr>
	            </thead>
	            <tbody>
		            <%
				      	if(request.getAttribute("userSellHistoryList") != null)
				      	{	
				      		UserSellHistory[] sellList= (UserSellHistory[])request.getAttribute("userSellHistoryList");
			     	    	for (UserSellHistory sellItem: sellList) {   
			       				if(sellItem != null) {
			        %>
		                <tr>
		                     <th><%= sellItem.getProduct_name() %></th>
		                     <th><%= sellItem.getQuantity() %></th>
		                     <th><%= sellItem.getCost() %></th>
	                    </tr>
			        <%
			       				}
			       			}
				      	}	
					%>
	            </tbody>                        
	        </table>
        </section>
	</body>
</html>