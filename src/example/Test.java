package example;

import example.client.HelloWorldServiceLocator;
import example.client.HelloWorld_PortType;

import java.util.Scanner;

public class Test {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] argv) {
        try {
            HelloWorldServiceLocator locator = new HelloWorldServiceLocator();
            HelloWorld_PortType service = locator.getHelloWorld();
            System.out.println("请输入你的扣除应扣除的款项后的剩余薪水:");
            double income = sc.nextDouble();
            // If authorization is required
            //((HelloWorldSoapBindingStub)service).setUsername("user3");
            //((HelloWorldSoapBindingStub)service).setPassword("pass3");
            // invoke business method
            double tax=calculate(income);
            System.out.println(service.calculateTax(tax));
        } catch (javax.xml.rpc.ServiceException ex) {
            ex.printStackTrace();
        } catch (java.rmi.RemoteException ex) {
            ex.printStackTrace();
        }
    }

    public static double calculate(double income) {
        double result = 0;
        income-=5000;
        if (income <= 36000) {
            result = income * 0.03;
        }else if(income<=144000)result=income*0.1;
        else if(income<=300000)result=income*0.2;
        else if(income<=420000)result=income*0.25;
        else if(income<=660000)result=income*0.3;
        else if(income<=960000)result=income*0.35;
        else result=income*0.45;
        return result;
    }
}
