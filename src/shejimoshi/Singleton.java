package shejimoshi;

public class Singleton {

    //饿汉模式
//    private static final Singleton single = new Singleton();
//    private Singleton(){}
//    public static Singleton getInstance(){
//        return single;
//    }

    //懒汉模式
//    private static Singleton singleton ;
//
//    private Singleton(){}
//    public static synchronized Singleton getInstance(){
//        if(singleton == null){
//            singleton = new Singleton();
//        }
//        return singleton;
//    }


    //双重加载模型

//    private static Singleton singleton;
//    private Singleton(){}
//    public static Singleton getInstance(){
//        if(singleton == null){
//            synchronized (Singleton.class){
//                if(singleton == null){
//                    singleton = new Singleton();
//                }
//
//            }
//        }
//        return singleton;
//    }

    //静态内部类
    private Singleton(){}
    private static class Singletons {
        private static final Singleton sing = new Singleton();
    }
    public static Singleton getInstance(){
        return Singletons.sing;
    }
}
