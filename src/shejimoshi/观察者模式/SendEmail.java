package shejimoshi.观察者模式;

public class SendEmail implements RegisterObserver{
    @Override
    public void doSomeThing() {
        System.out.println("发邮箱");
    }
}
