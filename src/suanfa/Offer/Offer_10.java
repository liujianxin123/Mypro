package suanfa.Offer;
//打印斐波那契数列
//F[n]=F[n-1]+F[n-2](n>=3,F[1]=1,F[2]=1)
public class Offer_10 {

    public static void main(String[] args) {
       // System.out.println(Offer_10.feibo(10));
        System.out.println(Offer_10.feibo2(20));
    }

    /**
     * 不建议使用递归，因为递归需要做大量的重复计算，时间复杂度是以n的指数上升的
     * @param n
     * @return
     */
    public static long feibo(long n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return feibo(n-2) + feibo(n-1);
    }

    public static long feibo2(long n){
        if (n < 3) return 1;

        long a1 = 1;
        long a2 = 1;
        long result = 0;
        for (int i = 2; i < n; i++) {
            result = a1 + a2;
            a1 = a2;
            a2 = result;
        }

        return result;
    }


    public static String quickSort(int[] p){

        int start = 0;
        int end = p.length -1;
        int tmp = p[0];
        while (start < end){



        }


        return null;
    }



}
