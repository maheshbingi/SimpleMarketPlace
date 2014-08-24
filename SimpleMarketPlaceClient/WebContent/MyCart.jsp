<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@page import="com.lab2.SimpleMarketPlace.Models.ShoppingCart"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
		<title>MyCart</title>
		<link rel="stylesheet" href="./stylesheets/style.css" type="text/css"></link>
		<link rel="stylesheet" href="./stylesheets/bootstrap.min.css" type="text/css"></link>
		<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
		<script type="text/javascript">
            jQuery(document).ready(function()
            {
                $(".delete_from_cart").click(function()
                {
                	var prodCount=($(this).attr("class"));
                	$.ajax({
                            type: "POST",
                            url:"/SimpleMarketPlaceClient/DeleteFromCart",
                            data: 
                            { 
                              product_name : $(this).attr("id"),
                              product_count : prodCount
                            },
                        success: function(op_str) 
                        {               
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
                   <h4>My Cart</h4>
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
	             
	             	<% int total=0; 
	             	if(request.getAttribute("shoppingCartList") != null)
			      	{	
	             		ShoppingCart[] cartList= (ShoppingCart[])request.getAttribute("shoppingCartList");
		     	    	for (ShoppingCart cart: cartList) {   
		       				if(cart != null) {
		         	%>
		         	 	<tr>
		                     <th><%= cart.getProductName() %></th>
		                     <th><%= cart.getProductCount() %></th>
		                     <th><%= cart.getCost() %></th>
		                     <th>                                	
		                     	<!-- <a href="DeleteFromCart?ProductName=<%= cart.getProductName() %>">Remove</a>  -->
		                     		<input type="button" class="delete_from_cart <%=cart.getProductCount() %>" id="<%= cart.getProductName() %>" name="delete_from_cart" value="Remove"/>   
		                     </th>	
		                </tr>
		         	 
		            <%	total = total +cart.getCost();
		       				}
		       			}
			      	}	
				    %>
	                
	             </tbody>                        
	             <tfoot>
	                 <td></td>
	                 <td class="bold">Total</td>
	                 <td class="bold total"></td>
	                 <td></td>
	              </tfoot>
	              
	              <script>
	                  jQuery(".total").text(<%= total %>);
	              </script>
	         </table>
        
		     <form class="container form-horizontal" action="CheckOut" method="post"> 
		         <label class="pull-left bold">Please enter your credit card number</label>
		         <input type="text" id="creditCard" name="creditCard" class="creditCard pull-left" style="clear:both">
		         <button type="submit" id="pay" name="pay" class="btn pull-left" style="margin-left: 10px;">Pay</button>
		         <label class="creditCardError"></label>
		     </form>
 		</section>
 		<script>
            jQuery(document).ready(function()
            {                   
                jQuery("#pay").click(function(){
                    var creditNumber = jQuery("#creditCard").val();
                    var length = creditNumber.length;
                    if(length!=16)
                    {
                        jQuery(".creditCardError").text("Invalid Credit card number");
                        return false;
                    }
                    else
                    {
                        jQuery(".creditCardError").text("");
                    }
                });                     
            });
        </script> 
	</body>
</html>