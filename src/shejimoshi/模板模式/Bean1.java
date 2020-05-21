package shejimoshi.模板模式;

/**
 * 假设一个框架中的某个类暴露了两个模板方法，并且定义了一堆供模板方法调用的抽象方法，
 * 在项目开发中，即便我们只用到这个类的其中一个模板方法，我们还是要在子类中把所有的
 * 抽象方法都实现一遍，这相当于无效劳动，有没有其他方式来解决这个问题呢?
 * 解决方法，用一个Bean类继承模板类，然后实现模板类的所有方法，之后所有的子类继承自Bean类
 */
public class Bean1 extends AbstractClass{
    @Override
    protected void method1() {
        System.out.println("do something 1");
    }

    @Override
    protected void method2() {
        System.out.println("do something 2");
    }

    @Override
    protected void method3() {
        System.out.println("do something 3");
    }

    @Override
    protected void method4() {
        System.out.println("do something 4");
    }
}
