/**
 * UserSellHistory.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.lab2.SimpleMarketPlace.Models;

public class UserSellHistory  implements java.io.Serializable {
    private int cost;

    private java.lang.String description;

    private java.lang.String product_name;

    private int quantity;

    private java.lang.String seller_info;

    public UserSellHistory() {
    }

    public UserSellHistory(
           int cost,
           java.lang.String description,
           java.lang.String product_name,
           int quantity,
           java.lang.String seller_info) {
           this.cost = cost;
           this.description = description;
           this.product_name = product_name;
           this.quantity = quantity;
           this.seller_info = seller_info;
    }


    /**
     * Gets the cost value for this UserSellHistory.
     * 
     * @return cost
     */
    public int getCost() {
        return cost;
    }


    /**
     * Sets the cost value for this UserSellHistory.
     * 
     * @param cost
     */
    public void setCost(int cost) {
        this.cost = cost;
    }


    /**
     * Gets the description value for this UserSellHistory.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this UserSellHistory.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the product_name value for this UserSellHistory.
     * 
     * @return product_name
     */
    public java.lang.String getProduct_name() {
        return product_name;
    }


    /**
     * Sets the product_name value for this UserSellHistory.
     * 
     * @param product_name
     */
    public void setProduct_name(java.lang.String product_name) {
        this.product_name = product_name;
    }


    /**
     * Gets the quantity value for this UserSellHistory.
     * 
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }


    /**
     * Sets the quantity value for this UserSellHistory.
     * 
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    /**
     * Gets the seller_info value for this UserSellHistory.
     * 
     * @return seller_info
     */
    public java.lang.String getSeller_info() {
        return seller_info;
    }


    /**
     * Sets the seller_info value for this UserSellHistory.
     * 
     * @param seller_info
     */
    public void setSeller_info(java.lang.String seller_info) {
        this.seller_info = seller_info;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UserSellHistory)) return false;
        UserSellHistory other = (UserSellHistory) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.cost == other.getCost() &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.product_name==null && other.getProduct_name()==null) || 
             (this.product_name!=null &&
              this.product_name.equals(other.getProduct_name()))) &&
            this.quantity == other.getQuantity() &&
            ((this.seller_info==null && other.getSeller_info()==null) || 
             (this.seller_info!=null &&
              this.seller_info.equals(other.getSeller_info())));
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
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getProduct_name() != null) {
            _hashCode += getProduct_name().hashCode();
        }
        _hashCode += getQuantity();
        if (getSeller_info() != null) {
            _hashCode += getSeller_info().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UserSellHistory.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Models.SimpleMarketPlace.lab2.com", "UserSellHistory"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
