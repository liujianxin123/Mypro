package shejimoshi.代理模式;

public class ManProxy implements IPerson{
    private Man man;

    public ManProxy(Man man) {
        this.man = man;
    }

    @Override
    public String say() {
        return man.say();
    }
}
