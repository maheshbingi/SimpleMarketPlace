/**
 * Products.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.lab2.SimpleMarketPlace.Models;

public class Products  implements java.io.Serializable {
    private int categoryID;

    private int cost;

    private java.lang.String description;

    private int pid;

    private java.lang.String product_name;

    private int quantity;

    private java.lang.String seller_info;

    private java.lang.String userID;

    public Products() {
    }

    public Products(
           int categoryID,
           int cost,
           java.lang.String description,
           int pid,
           java.lang.String product_name,
           int quantity,
           java.lang.String seller_info,
           java.lang.String userID) {
           this.categoryID = categoryID;
           this.cost = cost;
           this.description = description;
           this.pid = pid;
           this.product_name = product_name;
           this.quantity = quantity;
           this.seller_info = seller_info;
           this.userID = userID;
    }


    /**
     * Gets the categoryID value for this Products.
     * 
     * @return categoryID
     */
    public int getCategoryID() {
        return categoryID;
    }


    /**
     * Sets the categoryID value for this Products.
     * 
     * @param categoryID
     */
    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }


    /**
     * Gets the cost value for this Products.
     * 
     * @return cost
     */
    public int getCost() {
        return cost;
    }


    /**
     * Sets the cost value for this Products.
     * 
     * @param cost
     */
    public void setCost(int cost) {
        this.cost = cost;
    }


    /**
     * Gets the description value for this Products.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Products.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the pid value for this Products.
     * 
     * @return pid
     */
    public int getPid() {
        return pid;
    }


    /**
     * Sets the pid value for this Products.
     * 
     * @param pid
     */
    public void setPid(int pid) {
        this.pid = pid;
    }


    /**
     * Gets the product_name value for this Products.
     * 
     * @return product_name
     */
    public java.lang.String getProduct_name() {
        return product_name;
    }


    /**
     * Sets the product_name value for this Products.
     * 
     * @param product_name
     */
    public void setProduct_name(java.lang.String product_name) {
        this.product_name = product_name;
    }


    /**
     * Gets the quantity value for this Products.
     * 
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }


    /**
     * Sets the quantity value for this Products.
     * 
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    /**
     * Gets the seller_info value for this Products.
     * 
     * @return seller_info
     */
    public java.lang.String getSeller_info() {
        return seller_info;
    }


    /**
     * Sets the seller_info value for this Products.
     * 
     * @param seller_info
     */
    public void setSeller_info(java.lang.String seller_info) {
        this.seller_info = seller_info;
    }


    /**
     * Gets the userID value for this Products.
     * 
     * @return userID
     */
    public java.lang.String getUserID() {
        return userID;
    }


    /**
     * Sets the userID value for this Products.
     * 
     * @param userID
     */
    public void setUserID(java.lang.String userID) {
        this.userID = userID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Products)) return false;
        Products other = (Products) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.categoryID == other.getCategoryID() &&
            this.cost == other.getCost() &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            this.pid == other.getPid() &&
            ((this.product_name==null && other.getProduct_name()==null) || 
             (this.product_name!=null &&
              this.product_name.equals(other.getProduct_name()))) &&
            this.quantity == other.getQuantity() &&
            ((this.seller_info==null && other.getSeller_info()==null) || 
             (this.seller_info!=null &&
              this.seller_info.equals(other.getSeller_info()))) &&
            ((this.userID==null && other.getUserID()==null) || 
             (this.userID!=null &&
              this.userID.equals(other.getUserID())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getCategoryID();
        _hashCode += getCost();
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        _hashCode += getPid();
        if (getProduct_name() != null) {
            _hashCode += getProduct_name().hashCode();
        }
        _hashCode += getQuantity();
        if (getSeller_info() != null) {
            _hashCode += getSeller_info().hashCode();
        }
        if (getUserID() != null) {
            _hashCode += getUserID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Products.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Models.SimpleMarketPlace.lab2.com", "Products"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("categoryID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Models.SimpleMarketPlace.lab2.com", "categoryID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cost");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Models.SimpleMarketPlace.lab2.com", "cost"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Models.SimpleMarketPlace.lab2.com", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Models.SimpleMarketPlace.lab2.com", "pid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("product_name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Models.SimpleMarketPlace.lab2.com", "product_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quantity");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Models.SimpleMarketPlace.lab2.com", "quantity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seller_info");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Models.SimpleMarketPlace.lab2.com", "seller_info"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Models.SimpleMarketPlace.lab2.com", "userID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
