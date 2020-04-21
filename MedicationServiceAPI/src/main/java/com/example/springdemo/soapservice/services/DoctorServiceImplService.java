
package com.example.springdemo.soapservice.services;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "DoctorServiceImplService", targetNamespace = "http://services.soapService.springdemo.example.com/", wsdlLocation = "http://app-server:8888/ws/doctor?wsdl")
public class DoctorServiceImplService
    extends Service
{

    private final static URL DOCTORSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException DOCTORSERVICEIMPLSERVICE_EXCEPTION;
    private final static QName DOCTORSERVICEIMPLSERVICE_QNAME = new QName("http://services.soapService.springdemo.example.com/", "DoctorServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://app-server:8888/ws/doctor?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        DOCTORSERVICEIMPLSERVICE_WSDL_LOCATION = url;
        DOCTORSERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public DoctorServiceImplService() {
        super(__getWsdlLocation(), DOCTORSERVICEIMPLSERVICE_QNAME);
    }

    public DoctorServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), DOCTORSERVICEIMPLSERVICE_QNAME, features);
    }

    public DoctorServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, DOCTORSERVICEIMPLSERVICE_QNAME);
    }

    public DoctorServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, DOCTORSERVICEIMPLSERVICE_QNAME, features);
    }

    public DoctorServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DoctorServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns DoctorSoapService
     */
    @WebEndpoint(name = "DoctorSoapServicePort")
    public DoctorSoapService getDoctorSoapServicePort() {
        return super.getPort(new QName("http://services.soapService.springdemo.example.com/", "DoctorSoapServicePort"), DoctorSoapService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DoctorSoapService
     */
    @WebEndpoint(name = "DoctorSoapServicePort")
    public DoctorSoapService getDoctorSoapServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://services.soapService.springdemo.example.com/", "DoctorSoapServicePort"), DoctorSoapService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (DOCTORSERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw DOCTORSERVICEIMPLSERVICE_EXCEPTION;
        }
        return DOCTORSERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}