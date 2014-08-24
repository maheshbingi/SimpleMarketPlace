/**
 * UserBuyHistory.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.lab2.SimpleMarketPlace.Models;

public class UserBuyHistory  implements java.io.Serializable {
    private int cost;

    private int productCount;

    private java.lang.String productName;

    public UserBuyHistory() {
    }

    public UserBuyHistory(
           int cost,
           int productCount,
           java.lang.String productName) {
           this.cost = cost;
           this.productCount = productCount;
           this.productName = productName;
    }


    /**
     * Gets the cost value for this UserBuyHistory.
     * 
     * @return cost
     */
    public int getCost() {
        return cost;
    }


    /**
     * Sets the cost value for this UserBuyHistory.
     * 
     * @param cost
     */
    public void setCost(int cost) {
        this.cost = cost;
    }


    /**
     * Gets the productCount value for this UserBuyHistory.
     * 
     * @return productCount
     */
    public int getProductCount() {
        return productCount;
    }


    /**
     * Sets the productCount value for this UserBuyHistory.
     * 
     * @param productCount
     */
    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }


    /**
     * Gets the productName value for this UserBuyHistory.
     * 
     * @return productName
     */
    public java.lang.String getProductName() {
        return productName;
    }


    /**
     * Sets the productName value for this UserBuyHistory.
     * 
     * @param productName
     */
    public void setProductName(java.lang.String productName) {
        this.productName = productName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UserBuyHistory)) return false;
        UserBuyHistory other = (UserBuyHistory) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.cost == other.getCost() &&
            this.productCount == other.getProductCount() &&
            ((this.productName==null && other.getProductName()==null) || 
             (this.productName!=null &&
              this.productName.equals(other.getProductName())));
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
        _hashCode += getCost();
        _hashCode += getProductCount();
        if (getProductName() != null) {
            _hashCode += getProductName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UserBuyHistory.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Models.SimpleMarketPlace.lab2.com", "UserBuyHistory"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cost");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Models.SimpleMarketPlace.lab2.com", "cost"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Models.SimpleMarketPlace.lab2.com", "productCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Models.SimpleMarketPlace.lab2.com", "productName"));
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
