public class JiaZaiSX {
    private static int a = 0;

    public JiaZaiSX(){
        System.out.println("构造方法");
    }

    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("代码块");
    }

    public void test(){
        System.out.println("普通代码块");
    }


    public static void main(String[] args) {
        JiaZaiSX j = new JiaZaiSX();
        j.test();
    }

}
