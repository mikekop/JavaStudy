package client;

import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.Service.Mode;

public class Main {

    public static void main(String[] args) throws Exception {
        String address = "http://localhost:8080/Service/Hello";
        String request = "<soapenv:Envelope xmlns:soapenv=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:log=\"http://logrocon.ru.app/\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <log:sayHello>\n" +
                "         <!--Optional:-->\n" +
                "         <myname>123</myname>\n" +
                "      </log:sayHello>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        StreamSource source = new StreamSource(new StringReader(request));
        Service service = Service.create(new URL(address + "?wsdl"),
                new QName("http://logrocon.ru.app/" , "HelloService"));
        Dispatch<Source> disp = service.createDispatch(new QName("http://logrocon.ru.app/" , "HelloPort"),
                Source.class, Mode.PAYLOAD);

        Source result = disp.invoke(source);
        Transformer transformer= TransformerFactory.newInstance().newTransformer();
        StreamResult xmlOutput=new StreamResult(new StringWriter());
        transformer.transform(result,xmlOutput);
        System.out.println("result: ");
        System.out.println(xmlOutput.getWriter().toString());

    }
}