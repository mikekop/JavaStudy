package ru.logrocon.app.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * Examples code for spring boot with CXF services. Hello is the interface for
 * sayHello interface. This class was generated by Apache CXF 3.1.0
 * 2015-05-18T13:02:03.098-05:00 Generated source version: 3.1.0
 */
@WebService(targetNamespace = "http://logrocon.ru.app/", name = "Hello")
public interface Hello {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "sayHello",
            targetNamespace = "http://logrocon.ru.app/",
            className = "ru.logrocon.app.ws.SayHello")
    @WebMethod(action = "urn:SayHello")
    @ResponseWrapper(localName = "sayHelloResponse",
            targetNamespace = "http://logrocon.ru.app/",
            className = "ru.logrocon.app.ws.SayHelloResponse")
    String sayHello(@WebParam(name = "myname", targetNamespace = "") String myname);
}