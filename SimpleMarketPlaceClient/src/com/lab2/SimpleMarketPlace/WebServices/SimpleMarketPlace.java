/**
 * SimpleMarketPlace.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.lab2.SimpleMarketPlace.WebServices;

public interface SimpleMarketPlace extends java.rmi.Remote {
    public java.lang.String signIn(java.lang.String email, java.lang.String pwd) throws java.rmi.RemoteException;
    public java.lang.String addProductToCart(java.lang.String email, java.lang.String sessionID, java.lang.String productName, int productCount, int cost) throws java.rmi.RemoteException;
    public com.lab2.SimpleMarketPlace.Models.UserSellHistory[] getUserSellHistory(java.lang.String email) throws java.rmi.RemoteException;
    public com.lab2.SimpleMarketPlace.Models.UserBuyHistory[] getUserBuyHistory(java.lang.String email) throws java.rmi.RemoteException;
    public com.lab2.SimpleMarketPlace.Models.ShoppingCart[] getProductsFromCart(java.lang.String email, java.lang.String sessionID) throws java.rmi.RemoteException;
    public java.lang.String signUp(java.lang.String email, java.lang.String pwd, java.lang.String fname, java.lang.String lname) throws java.rmi.RemoteException;
    public java.lang.String addProduct(java.lang.String productName, java.lang.String catalogName, java.lang.String userID, java.lang.String productDescription, java.lang.String sellerInfo, int productCost, int productQuantity) throws java.rmi.RemoteException;
    public com.lab2.SimpleMarketPlace.Models.ProductCatalogs[] getCatalogs() throws java.rmi.RemoteException;
    public java.lang.String addCatalog(java.lang.String productCatalog) throws java.rmi.RemoteException;
    public java.lang.String signOut(java.lang.String email) throws java.rmi.RemoteException;
    public com.lab2.SimpleMarketPlace.Models.Products[] getProducts() throws java.rmi.RemoteException;
    public java.lang.String checkOut(java.lang.String email, java.lang.String sessionID) throws java.rmi.RemoteException;
    public com.lab2.SimpleMarketPlace.Models.Products[] getProductsByCategory(java.lang.String category) throws java.rmi.RemoteException;
    public java.lang.String deleteProductFromCart(java.lang.String email, java.lang.String productName, int prodCount) throws java.rmi.RemoteException;
}
