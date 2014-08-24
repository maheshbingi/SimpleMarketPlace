package com.lab2.SimpleMarketPlace.WebServices;

import javax.jws.WebService;

import com.lab2.SimpleMarketPlace.Models.ProductCatalogs;
import com.lab2.SimpleMarketPlace.Models.Products;
import com.lab2.SimpleMarketPlace.Models.ShoppingCart;
import com.lab2.SimpleMarketPlace.Models.UserBuyHistory;
import com.lab2.SimpleMarketPlace.Models.UserSellHistory;

import java.sql.SQLException;

import Connection.DatabaseConnection;

@WebService
public class SimpleMarketPlace {

	DatabaseConnection db=new DatabaseConnection();
	
	public String signIn(String email,String pwd)
	{
		System.out.println("In SignIn Service call");
		String result;
		
		result = db.signIn(email,pwd);
		return result;
	}
	
	public String signUp(String email,String pwd,String fname,String lname)
	{
		System.out.println("In SignUp Service call");
		String result;
		
		result = db.signUp(email, pwd, fname, lname);
		return result;
	}
	
	public String signOut(String email)
	{
		System.out.println("In SignOut Service call");
		return "true";
	}
	
	
	public String addCatalog(String productCatalog)
	{
		System.out.println("In AddCatalog Service call");
		String result;
		
		result = db.addCatalogToDB(productCatalog);
		return result;		
	}
	
	public ProductCatalogs[] getCatalogs() throws SQLException
	{
		System.out.println("In getCatalogs Service call");
		
		return db.getCatalogsFromDB();
	}
	
	public Products[] getProducts() throws SQLException
	{
		System.out.println("In GetProducts Service call");
		return db.getProductsFromDB();
	}
	
	public String addProduct(String productName,String catalogName,String userID,String productDescription,String sellerInfo,int productCost,int productQuantity)
	{
		System.out.println("In AddProduct Service call");
		return db.addProductToDB(productName, catalogName, userID, productDescription, sellerInfo, productCost, productQuantity);
	}
	
	public ShoppingCart[] getProductsFromCart(String email,String sessionID) throws SQLException
	{
		System.out.println("In GetProductsFromCart Service call");
		return db.getProductsFromCartDB(email, sessionID);
	}
	
	public UserBuyHistory[] getUserBuyHistory(String email) throws SQLException
	{
		System.out.println("In getUserBuyHistory Service call");
		return db.getUserBuyHistoryFromDB(email);
	}
	
	public UserSellHistory[] getUserSellHistory(String email) throws SQLException
	{
		System.out.println("In getUserSellHistory Service call");
		return db.getUserSellHistoryFromDB(email);
	}
	
	public String checkOut(String email,String sessionID)
	{
		System.out.println("In CheckOut Service call");
		return db.checkOut(email, sessionID);
	}
	
	public String addProductToCart(String email,String sessionID,String productName,int productCount,int cost)
	{
		System.out.println("In AddProductToCart Service call");
		return db.addProductToCartInDB(email, sessionID, productName, productCount, cost);
	}
	
	public Products[] getProductsByCategory(String category) throws SQLException
	{
		System.out.println("In GetCatalogs Service call");
		return db.getProductsByCategoryFromDB(category);
	}
	
	public String deleteProductFromCart(String email,String productName,int prodCount)
	{
		System.out.println("In DeleteProductFromCart Service call");
		return db.deleteProductFromCartFromDB(email, productName, prodCount);
	}
}
