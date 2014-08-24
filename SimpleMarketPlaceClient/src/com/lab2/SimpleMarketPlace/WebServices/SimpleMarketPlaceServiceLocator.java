/**
 * SimpleMarketPlaceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.lab2.SimpleMarketPlace.WebServices;

public class SimpleMarketPlaceServiceLocator extends org.apache.axis.client.Service implements com.lab2.SimpleMarketPlace.WebServices.SimpleMarketPlaceService {

    public SimpleMarketPlaceServiceLocator() {
    }


    public SimpleMarketPlaceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SimpleMarketPlaceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SimpleMarketPlace
    private java.lang.String SimpleMarketPlace_address = "http://localhost:8080/SimpleMarketPlace/services/SimpleMarketPlace";

    public java.lang.String getSimpleMarketPlaceAddress() {
        return SimpleMarketPlace_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SimpleMarketPlaceWSDDServiceName = "SimpleMarketPlace";

    public java.lang.String getSimpleMarketPlaceWSDDServiceName() {
        return SimpleMarketPlaceWSDDServiceName;
    }

    public void setSimpleMarketPlaceWSDDServiceName(java.lang.String name) {
        SimpleMarketPlaceWSDDServiceName = name;
    }

    public com.lab2.SimpleMarketPlace.WebServices.SimpleMarketPlace getSimpleMarketPlace() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SimpleMarketPlace_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSimpleMarketPlace(endpoint);
    }

    public com.lab2.SimpleMarketPlace.WebServices.SimpleMarketPlace getSimpleMarketPlace(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.lab2.SimpleMarketPlace.WebServices.SimpleMarketPlaceSoapBindingStub _stub = new com.lab2.SimpleMarketPlace.WebServices.SimpleMarketPlaceSoapBindingStub(portAddress, this);
            _stub.setPortName(getSimpleMarketPlaceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSimpleMarketPlaceEndpointAddress(java.lang.String address) {
        SimpleMarketPlace_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.lab2.SimpleMarketPlace.WebServices.SimpleMarketPlace.class.isAssignableFrom(serviceEndpointInterface)) {
                com.lab2.SimpleMarketPlace.WebServices.SimpleMarketPlaceSoapBindingStub _stub = new com.lab2.SimpleMarketPlace.WebServices.SimpleMarketPlaceSoapBindingStub(new java.net.URL(SimpleMarketPlace_address), this);
                _stub.setPortName(getSimpleMarketPlaceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SimpleMarketPlace".equals(inputPortName)) {
            return getSimpleMarketPlace();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://WebServices.SimpleMarketPlace.lab2.com", "SimpleMarketPlaceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://WebServices.SimpleMarketPlace.lab2.com", "SimpleMarketPlace"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SimpleMarketPlace".equals(portName)) {
            setSimpleMarketPlaceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
