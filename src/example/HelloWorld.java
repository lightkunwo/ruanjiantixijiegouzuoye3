package example;

import example.client.HelloWorldService;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class HelloWorld {
  public String sayHelloWorldFrom(String from) {
    String result = "您的税款为:" + from;
    System.out.println(result);
    return result;
  }

}
