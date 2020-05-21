package shejimoshi.访问者模式;

public class SingleDispatchClass {
    public void polymorphismFunction(ParentClass p) {
        p.f();
    }
    public void overloadFunction(ParentClass p) {
        System.out.println("I am overloadFunction(ParentClass p).");
        p.f();
    }
    public void overloadFunction(ChildClass c) {
        System.out.println("I am overloadFunction(ChildClass c).");
    }
}
