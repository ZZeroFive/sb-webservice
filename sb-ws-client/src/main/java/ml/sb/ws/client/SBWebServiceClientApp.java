package ml.sb.ws.client;


import ml.sb.ws.domain.User;
import ml.sb.ws.service.UserService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import java.util.List;


public class SBWebServiceClientApp {


    /**
     * 静态代理访问web service
     * 演示访问UserService接口，其他接口访问逻辑都是相似的
     */
    public static void webServiceClientDemo01 () {
        // 接口地址 客户端可以请求web service的多种port
        // 但是所有的port接口地址都是一致的
        String userServiceWSDL = "http://localhost:8080/service/ws/api/user?wsdl";
        // 创建代理工厂
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        // 指定工厂访问的web service地址
        factoryBean.setAddress(userServiceWSDL);
        // 设置需要访问的web service
        factoryBean.setServiceClass(UserService.class);
        // 生成service代理对象
        UserService userService = (UserService) factoryBean.create();
        // 这里打印下代理对象的类型
        // 代理对象类名： com.sun.proxy.$Proxy37
        System.out.println("代理对象类名： " + userService.getClass().getName());
        // 通过调用代理对象方法，访问web service
        User user = userService.getUserByID("10081");
        System.out.println("静态代理访问结果：" + user);
    }

    /**
     * 基于动态代理方式访问web service接口
     * 演示访问UserService的列表接口
     */
    public static void webServiceClientDemo02() {
        JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
        String userServiceWSDL = "http://localhost:8080/service/ws/api/user?wsdl";
        Object[] result = new Object[0];
        try (Client client = factory.createClient(userServiceWSDL)) {
            String methodName = "getAllUsers";
            result = client.invoke(methodName);
            System.out.println(methodName+" 返回数据： " + result[0]);
            System.out.println(result[0].getClass().getName());
            List users = (List)result[0];
            for (Object u : users) {
                System.out.println(u);
            }
        } catch (Exception e) {
            System.out.println("动态web service代理访问失败！ " );
            e.printStackTrace();
        }
    }


    public static void main( String[] args ) {
       SBWebServiceClientApp.webServiceClientDemo01();
       SBWebServiceClientApp.webServiceClientDemo02();
    }
}
