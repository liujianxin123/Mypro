package shejimoshi.访问者模式;

public class DemoMain {
    public static void main(String[] args) {
//        SingleDispatchClass demo = new SingleDispatchClass();
//        ParentClass p = new ChildClass();
//        ParentClass p2 = new ParentClass();
//        p.f();
//        p2.f();
//        demo.polymorphismFunction(p);//执行哪个对象的方法，由对象的实际类型决定
//        demo.overloadFunction(p);//执行对象的哪个方法，由参数对象的声明类型决定


        String text = "abccba";
        System.out.println(isHuiWen(text));


    }


    public static boolean isHuiWen(String text) {
        int length = text.length();
        for (int i = 0; i < length / 2; i++) {
            if (text.toCharArray()[i] != text.toCharArray()[length - i - 1]) {
                return false;
            }
        }
        return true;
    }

}
