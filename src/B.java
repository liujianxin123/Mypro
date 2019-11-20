public class B extends A{
    public int a = 1;
    String get(A a) {
        return "BA";
    }

    String get(B b) {
        return "BB";
    }
    public void fun(){
        System.out.println("b");
    }
    public static void main(String args[]){
        A testa = new B();
        testa.fun();
        System.out.println(testa.a);
    }
}
