package com.lab2.SimpleMarketPlace.WebServices;

public class SimpleMarketPlaceProxy implements com.lab2.SimpleMarketPlace.WebServices.SimpleMarketPlace {
  private String _endpoint = null;
  private com.lab2.SimpleMarketPlace.WebServices.SimpleMarketPlace simpleMarketPlace = null;
  
  public SimpleMarketPlaceProxy() {
    _initSimpleMarketPlaceProxy();
  }
  
  public SimpleMarketPlaceProxy(String endpoint) {
    _endpoint = endpoint;
    _initSimpleMarketPlaceProxy();
  }
  
  private void _initSimpleMarketPlaceProxy() {
    try {
      simpleMarketPlace = (new com.lab2.SimpleMarketPlace.WebServices.SimpleMarketPlaceServiceLocator()).getSimpleMarketPlace();
      if (simpleMarketPlace != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)simpleMarketPlace)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)simpleMarketPlace)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (simpleMarketPlace != null)
      ((javax.xml.rpc.Stub)simpleMarketPlace)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.lab2.SimpleMarketPlace.WebServices.SimpleMarketPlace getSimpleMarketPlace() {
    if (simpleMarketPlace == null)
      _initSimpleMarketPlaceProxy();
    return simpleMarketPlace;
  }
  
  public java.lang.String signIn(java.lang.String email, java.lang.String pwd) throws java.rmi.RemoteException{
    if (simpleMarketPlace == null)
      _initSimpleMarketPlaceProxy();
    return simpleMarketPlace.signIn(email, pwd);
  }
  
  public java.lang.String addProductToCart(java.lang.String email, java.lang.String sessionID, java.lang.String productName, int productCount, int cost) throws java.rmi.RemoteException{
    if (simpleMarketPlace == null)
      _initSimpleMarketPlaceProxy();
    return simpleMarketPlace.addProductToCart(email, sessionID, productName, productCount, cost);
  }
  
  public com.lab2.SimpleMarketPlace.Models.UserSellHistory[] getUserSellHistory(java.lang.String email) throws java.rmi.RemoteException{
    if (simpleMarketPlace == null)
      _initSimpleMarketPlaceProxy();
    return simpleMarketPlace.getUserSellHistory(email);
  }
  
  public com.lab2.SimpleMarketPlace.Models.UserBuyHistory[] getUserBuyHistory(java.lang.String email) throws java.rmi.RemoteException{
    if (simpleMarketPlace == null)
      _initSimpleMarketPlaceProxy();
    return simpleMarketPlace.getUserBuyHistory(email);
  }
  
  public com.lab2.SimpleMarketPlace.Models.ShoppingCart[] getProductsFromCart(java.lang.String email, java.lang.String sessionID) throws java.rmi.RemoteException{
    if (simpleMarketPlace == null)
      _initSimpleMarketPlaceProxy();
    return simpleMarketPlace.getProductsFromCart(email, sessionID);
  }
  
  public java.lang.String signUp(java.lang.String email, java.lang.String pwd, java.lang.String fname, java.lang.String lname) throws java.rmi.RemoteException{
    if (simpleMarketPlace == null)
      _initSimpleMarketPlaceProxy();
    return simpleMarketPlace.signUp(email, pwd, fname, lname);
  }
  
  public java.lang.String addProduct(java.lang.String productName, java.lang.String catalogName, java.lang.String userID, java.lang.String productDescription, java.lang.String sellerInfo, int productCost, int productQuantity) throws java.rmi.RemoteException{
    if (simpleMarketPlace == null)
      _initSimpleMarketPlaceProxy();
    return simpleMarketPlace.addProduct(productName, catalogName, userID, productDescription, sellerInfo, productCost, productQuantity);
  }
  
  public com.lab2.SimpleMarketPlace.Models.ProductCatalogs[] getCatalogs() throws java.rmi.RemoteException{
    if (simpleMarketPlace == null)
      _initSimpleMarketPlaceProxy();
    return simpleMarketPlace.getCatalogs();
  }
  
  public java.lang.String addCatalog(java.lang.String productCatalog) throws java.rmi.RemoteException{
    if (simpleMarketPlace == null)
      _initSimpleMarketPlaceProxy();
    return simpleMarketPlace.addCatalog(productCatalog);
  }
  
  public java.lang.String signOut(java.lang.String email) throws java.rmi.RemoteException{
    if (simpleMarketPlace == null)
      _initSimpleMarketPlaceProxy();
    return simpleMarketPlace.signOut(email);
  }
  
  public com.lab2.SimpleMarketPlace.Models.Products[] getProducts() throws java.rmi.RemoteException{
    if (simpleMarketPlace == null)
      _initSimpleMarketPlaceProxy();
    return simpleMarketPlace.getProducts();
  }
  
  public java.lang.String checkOut(java.lang.String email, java.lang.String sessionID) throws java.rmi.RemoteException{
    if (simpleMarketPlace == null)
      _initSimpleMarketPlaceProxy();
    return simpleMarketPlace.checkOut(email, sessionID);
  }
  
  public com.lab2.SimpleMarketPlace.Models.Products[] getProductsByCategory(java.lang.String category) throws java.rmi.RemoteException{
    if (simpleMarketPlace == null)
      _initSimpleMarketPlaceProxy();
    return simpleMarketPlace.getProductsByCategory(category);
  }
  
  public java.lang.String deleteProductFromCart(java.lang.String email, java.lang.String productName, int prodCount) throws java.rmi.RemoteException{
    if (simpleMarketPlace == null)
      _initSimpleMarketPlaceProxy();
    return simpleMarketPlace.deleteProductFromCart(email, productName, prodCount);
  }
  
  
}