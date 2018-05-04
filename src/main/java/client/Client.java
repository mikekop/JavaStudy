package client;
import model.Good;
import soap.Soap;
import soap.WebServiceSEI;

import javax.xml.ws.Endpoint;
import java.util.List;

public class Client {

  public static void main(String[] args) {
    test();
  }

  private static void test() {
    WebServiceSEI implementor = new Soap();

    String address = "http://localhost:9000/Soap";
    Endpoint.publish(address, implementor);
    List<Good> result = implementor.getGoods();
    for (Good good : result)
    {
      System.out.println("Result: " + good);
    }
  }
}