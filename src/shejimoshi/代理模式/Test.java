package shejimoshi.代理模式;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

//        IPerson person = new ManProxy(new Man());
//        System.out.println(person.say());
//
//
//        Student1 student1 = new Student1();
//        Method method = student1.getClass().getMethod("getName_Age");
//        Object object = method.invoke(student1);
//        System.out.println(object);
//
//        Method method2 = student1.getClass().getMethod("getAll",new Class[]{String.class,String.class});
//        Object object2 = method2.invoke(student1,new String[]{"李四","30"});
//        System.out.println(object2);
        weakMap();
    }
    public static void weakMap(){
        int a = 128;
        Integer b = 128;
        Integer c = 128;
        System.out.println(a==b);
        System.out.println(c==b);
        System.out.println(c.equals(b));
    }
}
