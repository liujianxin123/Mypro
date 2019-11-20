package suanfa.Offer;

public class Offer_17 {

    public static void main(String[] args) {

        printToMaxOfDigits(3);
//        char number[] = new char[3];
//        for (int i = 0; i < number.length; ++i) { //放字符0进行初始化
//            number[i] = '0';
//        }
//        incrementNumber(number);
//        char zz = 'z'-' ';
//        System.out.println(zz);
//        String ss = "ab 2 3";
//        char[] sss = ss.toCharArray();
//        for (int i = 0; i < sss.length; i++) {
//            if(sss[i] == ' '){
//                System.out.println(sss[i]);
//            }
//        }

    }

    //打印1到最大的n位数
    public static void printToMaxOfDigits(int n){
        if(n <= 0){
            System.out.println("输入的n没有意义");
            return;
        }
        //声明字符数组,用来存放一个大数
        char number[] = new char[n];
        for (int i = 0; i < number.length; ++i) { //放字符0进行初始化
            number[i] = '0';
        }
        while(!incrementNumber(number)){ //如果大数自加，直到自溢退出
            printNumber(number); //打印大数
        }
    }

    //自加
//    下面就说说为什么字符减'0'可以到相应的整数。现在比如我们要字符‘1’转换成数字1，就这么一个变化，
//    我们看到了大家注意了字符型常量用''括起来的原因是，它们在计算机中都以各自的ASCII表示。
//    而‘1’的对应编码是49的二进制码，但是我们的数字1，就等于1呀，所以为了由原来的‘1’实际上
//    就是49的二进制变成现在的1对应的二进制1，只好用49-48=1了。
//    但是在ASCII码里‘0’对应的刚好是48的二进制码，所以我们转换的时候只需要‘1’-‘0’=1；
//    就可以了。而数字的ASCII码是按顺序规定的。所以其它字符要转换成数字都可以用减‘0’来表示。
//    比如‘2’的ASCII是50，而我们要得到数字2，于是用‘2’-48=2了。
//    看来当我们知道数据在计算机中的存储规则的时候，问题就迎刃而解了。
//    大小写字母的转换：先看ASCII码：a~z是97~122的二进制，
//    而A~Z是65~90的二进制编码，于是我们就得出：大写字母=小写字母-32 ；
//    这个公式了。当然这里的32我也可以这么写‘Z’=‘z’-'空格'。因为空格的ASCII码是32对应的二进制编码。

    private static boolean incrementNumber(char[] number) {
        boolean isOverflow = false; //判断是否溢出
        int nTakeOver = 0; //判断是否进位
        int nLength = number.length;
        for (int i = nLength - 1; i >= 0 ; --i) {
            int nSum = number[i] - '0' + nTakeOver; //取到第i位的字符转换为数字 +进位符
            if(i == nLength - 1){ //末尾自加1
                ++nSum;
            }
            if(nSum >= 10){
                if(i == 0){
                    isOverflow = true;
                }else{
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = (char) ('0' + nSum);
                }
            }else{
                number[i] = (char) (nSum + '0');
                break;
            }
        }
        return isOverflow;
    }
    //打印数字
    private static void printNumber(char[] number) {
        boolean isBeginning0 = true;
        int nLength = number.length;
        for (int i = 0; i < nLength; ++i) {
            if(isBeginning0 && number[i]!='0'){
                isBeginning0 = false;

            }
            if(!isBeginning0){
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }
}
