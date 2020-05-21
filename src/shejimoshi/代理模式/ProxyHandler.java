package shejimoshi.代理模式;

import com.sun.deploy.net.proxy.ProxyUtils;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 */
public class ProxyHandler implements InvocationHandler {
    private Man man;

    public ProxyHandler(Man man) {
        this.man = man;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName());
        return method.invoke(man,args);
    }

    public static void main(String[] args) throws IOException {

        Man man = new Man();
        ClassLoader classLoader = man.getClass().getClassLoader();

        Class[] interfaces = man.getClass().getInterfaces();//得到man的接口

        ProxyHandler proxyHandler = new ProxyHandler(man);


        //获取动态创建的代理类
        Object newProxyInstance = Proxy.newProxyInstance(classLoader, interfaces, proxyHandler);
        IPerson iPerson = (IPerson)newProxyInstance;
        iPerson.say();

        InputStream in = new FileInputStream("/user/wangzheng/test.txt");
        InputStream bin = new BufferedInputStream(in);
        DataInputStream din = new DataInputStream(bin);
        int data = din.readInt();
    }
}
