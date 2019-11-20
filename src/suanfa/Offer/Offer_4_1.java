package suanfa.Offer;

public class Offer_4_1 {
    public static void main(String[] args) {
        String a = "test";
        String b = "test";
        String c = new String("test2");
        String d = new String("test2");
        System.out.println(a==b);
        System.out.println(c==b);
        System.out.println(c==d);
    }
}
