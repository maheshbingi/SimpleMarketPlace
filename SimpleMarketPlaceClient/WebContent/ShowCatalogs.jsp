<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@page import="com.lab2.SimpleMarketPlace.Models.ProductCatalogs"%>
<%@page import="com.lab2.SimpleMarketPlace.Models.Products"%>
<%@page import="java.util.ArrayList"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
		<title>Welcome to Marketplace</title>
		<link rel="stylesheet" href="./stylesheets/style.css" type="text/css"></link>
		<link rel="stylesheet" href="./stylesheets/bootstrap.min.css" type="text/css"></link>
		<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
		<script type="text/javascript">
            jQuery(document).ready(function()
            {
                var count = 0; 
                $('input[name="text[]"]').blur(function()
                {
                	count = $(this).val();
                }); 
                    
                $(".add_to_cart").click(function()
                {
                	var prodPrice=($(this).attr("class"));
                	
                    $(".resultAddToCart").empty();            
                    
                    if(count==0)
                    {           
                         $(".resultAddToCart").append("Enter quantity of product");
                          return false;
                    }
                    
                    nop = count;
                    count=0;
                    $.ajax({
                            type: "POST",
                            url:"/SimpleMarketPlaceClient/AddProductToCart",
                            data: 
                            { 
                              product_name : $(this).attr("id"),
                              quantity : nop,
                              price : prodPrice
                            },
                        success: function(op_str) 
                        {               
                          $(".resultAddToCart").append("Successfully Added");
                        },
                        error: function (error) 
                        {
                              alert('Error');
                        }
                      });   
                });
            });
		</script>
	</head>
	<body>
		<header>
  	 		<div class="header-top">
      			<div class="container">
       				<div class="welcome_name pull-left">
         				<h4>Welcome to MarketPlace</h4>
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
     	
     
     	<div class="bs-example">
			    <ul class="nav nav-pills nav-stacked" style="max-width: 300px;">
			      <li class="active"><a href="/SimpleMarketPlaceClient/ShowCatalogs">All</a></li>			      
			      <%
			      	if(request.getAttribute("catalogList") != null)
			      	{	
			      		ProductCatalogs[] catalogs= (ProductCatalogs[])request.getAttribute("catalogList");
		     	    	for (ProductCatalogs catalog: catalogs) {   
		       				if(catalog != null) {
		          %>
		                	 <li><a href="/SimpleMarketPlaceClient/ParticularCatalogs?CatalogName=<%=catalog.getName() %>"><%=catalog.getName() %></a></li>
		          <%
		       				}
		       			}
			      	}	
				  %>	
			    </ul>
		</div>
 		<div class="product_content pull-left">	
            <h4>Products<label class="resultAddToCart"></label><span class="pull-right lastLogin">Last Login: <% if(request.getSession().getAttribute("lastlogin")!= null) %> 
			<%	{	%>
					<%=request.getSession().getAttribute("lastlogin") %>
			<% } %>	</span></h4>
	        
	        <div class="rows-container pull-left">
                 <% if(request.getAttribute("productList") != null)
			      	{	
			      		Products[] products= (Products[])request.getAttribute("productList");
		     	    	for (Products product: products) {   
		       				if(product != null) {                   
                  %>
                 <div class="span3 pull-left">
                           <p><strong>Name: </strong><%= product.getProduct_name() %></p>
                           <p><strong>Details: </strong><%= product.getDescription() %></p>
                           <p><strong>Seller: </strong><%= product.getSeller_info() %></p>
                           <p><strong>Price: </strong><%= product.getCost() %></p>
                           <% if(product.getQuantity() < 5) 
                          	{                     
                            %>
                            <p><strong>Out of Stock </strong></p>
                            <% } 
                           else
                            { 
                              %>
                              <p><strong>Available </strong></p>                                   
                                <form method="post" action="">  
                                  <input type="hidden" name="product_name" value="<%= product.getProduct_name() %>" class="product_name <%= product.getProduct_name() %>" id="<%= product.getProduct_name() %>"/>
                                  <input type="text" class="quantity" name="text[]" />
                                  <input type="button" class="add_to_cart <%= product.getCost() %>" id="<%= product.getProduct_name() %>" name="add_to_cart" value="Add To Cart"/>  
                                </form>
                            <% } %>
                 </div>
                 <% 
                   			} 
		     	    	}
			      	}	
                 %>
	        </div>
        </div>
	</body>
</html>