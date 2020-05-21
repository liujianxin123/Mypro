package shejimoshi.guanchazhemoshi;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private  List<RegObserver> rs = new ArrayList<RegObserver>(8);


    public void setRserver(List<RegObserver> regObserver){
        rs.addAll(regObserver);
    }

    public void test(long userid){
        for(RegObserver r : rs){
            r.handleRegSuccess(userid);
        }
    }

    public static void main(String[] args) {
//        List<RegObserver> rs = new ArrayList<RegObserver>(8);
//        rs.add(new RegPromotionObserver());
//
//
//        UserController userController = new UserController();
//        userController.setRserver(rs);
//        userController.test(1233);

//        System.out.println(UserController.class.getClassLoader().toString());
//        System.out.println(UserController.class.getClassLoader().getParent().toString());
//        System.out.println(UserController.class.getClassLoader().getParent().getParent().toString());
//        final int a = 2;

        int num1 = 23;
        int num2 = 1;
        int a = tet(-7);
        System.out.println(a);
    }
    //任意一个数a，与a-1做与运算后，二进制中右边第一个1会变成零，
    public static int tet(int n){
        int num = 0;
        while (n != 0){
            num++;
            n = n & (n - 1);//1与零做与运算等于0
        }
        return num;
    }
    //
    public static int tet2(int n){
        int num = 0;
        while (n != 0){
            if((n&1 ) == 1){
                num++;
                n = n >> 1;
            }
        }
        return num;
    }
}
