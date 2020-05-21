package shejimoshi.工厂模式;

public class Dog {
    private static Dog ourInstance = new Dog();

    public static Dog getInstance() {
        return ourInstance;
    }

    private Dog() {
    }
}
