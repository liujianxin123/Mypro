package shejimoshi.模板模式;

/**
 * 模板模式：
 * 在一个方法中定义一个算法骨架，这个算法可以是一个业务流程，比如下面这个templateMethod1方法，
 * 然后把算法的具体实现定义成abstract类型的，暴露给子类，让子类自己去实现
 */
public abstract class AbstractClass {
    public final void templateMethod1() {
        //...
        method1();
        //...
        method2();
        //...
    }

    public final void templateMethod2() {
        //...
        method3();
        //...
        method4();
        //...
    }

    protected abstract void method1();
    protected abstract void method2();
    protected abstract void method3();
    protected abstract void method4();
}