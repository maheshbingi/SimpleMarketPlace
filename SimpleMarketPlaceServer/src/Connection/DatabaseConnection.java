package Connection;

import java.sql.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.lab2.SimpleMarketPlace.Models.ProductCatalogs;
import com.lab2.SimpleMarketPlace.Models.Products;
import com.lab2.SimpleMarketPlace.Models.ShoppingCart;
import com.lab2.SimpleMarketPlace.Models.UserBuyHistory;
import com.lab2.SimpleMarketPlace.Models.UserSellHistory;

public class DatabaseConnection {
	
	Connection con = null;
	static ResultSet rs;
    Statement stmt = null;
	
	public DatabaseConnection(){		
		try {			
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplemarketplace","root","");
				stmt = con.createStatement();
				if(!con.isClosed())
					System.out.println("Successfully Connected!!!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public String signIn(String email, String pwd){
		String result = "",storeLastLogin="";
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String last_login=dateFormat.format(date).toString();
		try 
		{
			String query = "select * from Users where emailid='"+email+"' and password='"+pwd+"'";
			rs= stmt.executeQuery(query);
			
			if(rs.next())
			{
				storeLastLogin = rs.getString("lastlogin");
				query = "update Users set lastlogin='"+last_login+"' where emailid='"+email+"'";
				stmt.executeUpdate(query);
				
				result="true:"+storeLastLogin;
			}
			else
			{
				result="false: Invalid username or password";
			}	
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public String signUp(String email,String pwd,String fname,String lname)
	{
		String result = "";
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String last_login=dateFormat.format(date).toString();
		
		int rowcount;
		try 
		{
			String query = "select emailid from Users where emailid='"+email+"'";
			rs= stmt.executeQuery(query);
			
			if(rs.next())
			{
				result="User already exists";
			}
			else
			{
				query = "insert into Users (emailid, password,fname,lname,lastlogin) values ('"+email+"','"+pwd+"','"+fname+"','"+lname+"','"+last_login+"')";
				rowcount=stmt.executeUpdate(query);
				
				if(rowcount > 0)
				{
					result="true";
					System.out.println("User SignUp Successful");
				}
				else
				{
					result="The data could not be inserted in the database.";
				}
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public String addCatalogToDB(String productCatalog)
	{
		String result = "";
		
		int rowcount;
		try 
		{
			String query = "select Name from ProductCatalogs where Name='"+productCatalog+"'";
			rs= stmt.executeQuery(query);
			
			if(rs.next())
			{
				result="Catalog already exists";
			}
			else
			{
				query = "insert into ProductCatalogs(Name) values ('"+productCatalog+"')";
				rowcount=stmt.executeUpdate(query);
				
				if(rowcount > 0)
				{
					result="true";
					System.out.println("Catalog: "+productCatalog+" added successfully");
				}
				else
				{
					result="The data could not be inserted in the database.";
				}
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public ProductCatalogs[] getCatalogsFromDB() throws SQLException
	{
		int rowcount=0,i=0;
		
		try 
		{
			String query = "select * from ProductCatalogs";
			rs= stmt.executeQuery(query);
			
			// getting number of product catalogs
			if(rs != null)
			{
				rs.beforeFirst();
				rs.last();
				rowcount=rs.getRow();
				rs.beforeFirst();
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		ProductCatalogs[] productCatalogs=new ProductCatalogs[rowcount];
		
		while(rs.next())
		{
			ProductCatalogs pc=new ProductCatalogs();
			pc.setId(rs.getInt("id"));
			pc.setName(rs.getString("Name"));
			productCatalogs[i++]=pc;
			
			System.out.println("Catalog"+i+": "+rs.getString("Name"));
		}
		System.out.println("Catalogs returned from DB:"+productCatalogs);
		return productCatalogs;
	}
	
	public String addProductToDB(String productName,String catalogName,String userID, String productDescription,String sellerInfo,int productCost,int productQuantity)
	{
		String result = "";
		
		int rowcount;
		try 
		{
			String query = "insert into Products(categoryID,userID,product_name,description,seller_info,cost,quantity) values ((select id from ProductCatalogs where Name='"+catalogName+"'),'"+userID+"','"+productName+"','"+productDescription+"','"+sellerInfo+"',"+productCost+","+productQuantity+")";
			System.out.println("Insert Query:"+query);
			rowcount=stmt.executeUpdate(query);
			
			if(rowcount > 0)
			{
				//result="true";
				query = "insert into UsersSellHistory values ('"+userID+"','"+productName+"',"+productQuantity+","+productCost+")";
				System.out.println("Insert Query in UsersSellHistory:"+query);
				rowcount=stmt.executeUpdate(query);
				
				if(rowcount >0)
				{
					result="true";
					System.out.println("Product added successfully");
				}
				else
				{
					result="false:The data could not be added to UsersSellHistory";
				}	
			}
			else
			{
				result="The data could not be inserted in the database.";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public Products[] getProductsFromDB() throws SQLException
	{
		int rowcount=0,i=0;
		
		try 
		{
			String query = "select * from Products";
			rs= stmt.executeQuery(query);
			
			// getting number of product catalogs
			if(rs != null)
			{
				rs.beforeFirst();
				rs.last();
				rowcount=rs.getRow();
				rs.beforeFirst();
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		Products[] products=new Products[rowcount];
		
		while(rs.next())
		{
			Products p=new Products();
			p.setPid(rs.getInt("pid"));
			p.setCategoryID(rs.getInt("categoryID"));
			p.setUserID(rs.getString("userID"));
			p.setProduct_name(rs.getString("product_name"));
			p.setDescription(rs.getString("description"));
			p.setSeller_info(rs.getString("seller_info"));
			p.setCost(rs.getInt("cost"));
			p.setQuantity(rs.getInt("quantity"));
			
			products[i++]=p;
			
			System.out.println("product_name"+i+": "+rs.getString("product_name"));
		}
		System.out.println("Catalogs returned from DB:"+products);
		return products;
	}
	
	
	public Products[] getProductsByCategoryFromDB(String category) throws SQLException
	{
		int rowcount=0,i=0;
		
		try 
		{
			String query = "select * from Products where categoryID= (select id from ProductCatalogs where Name='"+category+"')";
			rs= stmt.executeQuery(query);
			
			// getting number of products
			if(rs != null)
			{
				rs.beforeFirst();
				rs.last();
				rowcount=rs.getRow();
				rs.beforeFirst();
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		Products[] products=new Products[rowcount];
		
		while(rs.next())
		{
			Products p=new Products();
			p.setPid(rs.getInt("pid"));
			p.setCategoryID(rs.getInt("categoryID"));
			p.setUserID(rs.getString("userID"));
			p.setProduct_name(rs.getString("product_name"));
			p.setDescription(rs.getString("description"));
			p.setSeller_info(rs.getString("seller_info"));
			p.setCost(rs.getInt("cost"));
			p.setQuantity(rs.getInt("quantity"));
			
			products[i++]=p;
			
			System.out.println("product_name"+i+": "+rs.getString("product_name"));
		}
		System.out.println("Catalogs returned from DB for "+category+"category :"+products);
		return products;
	}
	
	public ShoppingCart[] getProductsFromCartDB(String email,String sessionID) throws SQLException
	{
		int rowcount=0,i=0;
		
		try 
		{
			String query = "select * from ShoppingCart where userID='"+email+"'";
			rs= stmt.executeQuery(query);
			
			// getting number of products shopping cart
			if(rs != null)
			{
				rs.beforeFirst();
				rs.last();
				rowcount=rs.getRow();
				rs.beforeFirst();
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		ShoppingCart[] cart=new ShoppingCart[rowcount];
		
		while(rs.next())
		{
			ShoppingCart sc=new ShoppingCart();
			sc.setUserID(rs.getString("userID"));
			sc.setProductName(rs.getString("productName"));
			sc.setProductCount(rs.getInt("productCount"));
			sc.setCost(rs.getInt("cost"));
			
			cart[i++]=sc;
			System.out.println("CartProduct"+i+": "+rs.getString("productName"));
		}
		System.out.println("Catalogs returned from DB:"+cart);
		return cart;
	}
	
	
	public UserBuyHistory[] getUserBuyHistoryFromDB(String email) throws SQLException
	{
		int rowcount=0,i=0;
		
		try 
		{
			String query = "select * from UsersBuyHistory where userID='"+email+"'";
			rs= stmt.executeQuery(query);
			
			// getting number of products user bought
			if(rs != null)
			{
				rs.beforeFirst();
				rs.last();
				rowcount=rs.getRow();
				rs.beforeFirst();
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		UserBuyHistory[] userBuyList=new UserBuyHistory[rowcount];
		
		while(rs.next())
		{
			UserBuyHistory ubh=new UserBuyHistory();
			
			ubh.setProductName(rs.getString("productName"));
			ubh.setProductCount(rs.getInt("productCount"));
			ubh.setCost(rs.getInt("cost"));
			
			userBuyList[i++]=ubh;
			System.out.println("CartProduct"+i+": "+rs.getString("productName"));
		}
		System.out.println("Products returned from DB:"+userBuyList);
		return userBuyList;
	}
	
	
	public UserSellHistory[] getUserSellHistoryFromDB(String email) throws SQLException
	{
		int rowcount=0,i=0;
		
		try 
		{
			String query = "select * from UsersSellHistory where userID='"+email+"'";
			rs= stmt.executeQuery(query);
			
			// getting number of products user sold
			if(rs != null)
			{
				rs.beforeFirst();
				rs.last();
				rowcount=rs.getRow();
				rs.beforeFirst();
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		UserSellHistory[] userSellList=new UserSellHistory[rowcount];
		
		while(rs.next())
		{
			UserSellHistory ush=new UserSellHistory();
			
			ush.setProduct_name(rs.getString("productName"));
			ush.setCost(rs.getInt("cost"));
			ush.setQuantity(rs.getInt("productCount"));
			
			userSellList[i++]=ush;
			System.out.println("CartProduct"+i+": "+rs.getString("productName"));
		}
		System.out.println("Products returned from DB:"+userSellList);
		return userSellList;
	}
	
	public String checkOut(String email,String sessionID)
	{
		String result = "";
		int rowcount;
		
		try 
		{
			String query="insert into UsersBuyHistory(select userID,productName,productCount,cost from ShoppingCart where userID='"+email+"')";
			System.out.println("Insert Query:"+query);
			rowcount=stmt.executeUpdate(query);
			
			if(rowcount > 0)
			{
				System.out.println("Product Checked Out successfully");
				query="delete from ShoppingCart where userID='"+email+"'";
				System.out.println("Delete Query :"+query);
				rowcount=stmt.executeUpdate(query);
				
				if(rowcount > 0)
				{
					result="true";
					System.out.println("Product deleted from shopping cart successfully");
				}
				else
				{
					result="false:The data could not be deleted from database.";
				}	
			}
			else
			{
				result="false:The data could not be inserted in the database.";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String addProductToCartInDB(String email,String sessionID,String productName,int productCount,int cost)
	{
		String result = "";
		
		int rowcount;
		try 
		{
			String query = "insert into ShoppingCart values ('"+email+"','"+productName+"',"+productCount+","+productCount*cost+")";
			System.out.println("Insert Query:"+query);
			rowcount=stmt.executeUpdate(query);
			
			if(rowcount > 0)
			{
				//result="true";
				System.out.println("Product added successfully");
				query="update Products set quantity=quantity-"+productCount+" where product_name='"+productName+"' and cost="+cost;
				System.out.println("Update items in in DB:"+query);
				rowcount=stmt.executeUpdate(query);
				
				if(rowcount > 0)
				{
					result="true";
					System.out.println("Product deleted from product table successfully");
				}
				else
				{
					result="false:The data could not be deleted from database.";
				}
			}
			else
			{
				result="The data (add to cart) could not be inserted in the database.";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public String deleteProductFromCartFromDB(String email,String productName,int productCount)
	{
		String result = "";
		int rowcount;
		
		try 
		{
			String query = "delete from ShoppingCart where userID='"+email+"' and productName='"+productName+"'";
			System.out.println("Delete Query:"+query);
			rowcount=stmt.executeUpdate(query);
	
			if(rowcount > 0)
			{
				System.out.println("Product deleted successfully");
				query="update Products set quantity=quantity+"+productCount+" where product_name='"+productName+"'";
				System.out.println("Update items in in DB:"+query);
				rowcount=stmt.executeUpdate(query);
				
				if(rowcount > 0)
				{
					result="true";
					System.out.println("Product added to product table successfully");
				}
				else
				{
					result="false:The data could not be added to database.";
				}
			}
			else
			{
				result="The data (delete from cart) could not be deleted from the database.";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
