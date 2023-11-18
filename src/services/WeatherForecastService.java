package services;

import services.WeatherWebServiceLocator;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

public class WeatherForecastService {

    public static void main(String[] args) throws RemoteException, ServiceException {
        System.out.println("======程序启动======");
        String result[] = QueryWeatherForecastInfo("杭州");
        for (String r : result)
            System.out.println(r);
        System.out.println("======程序结束======");
    }

    public static String[] QueryWeatherForecastInfo(String cityName) throws RemoteException, ServiceException {
        WeatherWebServiceLocator locator = new WeatherWebServiceLocator();

        // 调用xxLocator对象的getXXPort()方法生成xxSoapBindingStub对象
        WeatherWebServiceSoap12Stub stud =  (WeatherWebServiceSoap12Stub) locator.getWeatherWebServiceSoap12();
        // 输出当天的天气状况
        String[] weather = stud.getWeatherbyCityName("杭州");

        return weather;
    }

}
