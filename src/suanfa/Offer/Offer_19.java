package suanfa.Offer;


//题目描述
//请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以
//出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
//例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配


//主要思想就是字符的第一个字符和模式第一个字符相匹配，那么字符串和模式都向后移动一个字符继续匹配；出现不匹配时直接返回false。但是当第二个字符是'*'时，比较复杂，可以有不同的匹配方式。
//具体来说：
//
//当模式中的第二个字符不是“*”时：
//
//
//a1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
//a2、如果 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。
//
//而当模式中的第二个字符是“*”时：
//c1、如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。
//
//如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
//b1、模式后移2字符，相当于x*被忽略；
//b2、字符串后移1字符，模式后移2字符；
//b3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；
//————————————————
//原文链接：https://blog.csdn.net/hh_zheng/article/details/78585413
public class Offer_19 {
    public static void main(String[] args) {
        char[] s = "aaa".toCharArray();
        char[] m = "ab*ac*a".toCharArray();
        System.out.println(math(s,m));
    }


    public static boolean math(char[] s,char[] m){

        if(s.length < 1 || m.length < 1){
            return false;
        }
        int s_index = 0;
        int m_index = 0;

        return math2(s,s_index,m,m_index);
    }

    public static boolean math2(char[] s,int s_index,char[] m, int m_index){

        //当字符串与模式串都监测到尾部，说明匹配
        if(s_index == s.length && m_index == m.length){
            return true;
        }
        //当字符串到尾部，模式串没有，说明不匹配
        if(s_index == s.length && m_index != m.length){
            return false;
        }
        //当模式中的第二个字符是“*”时：
        if(m_index+1 < m.length && m[m_index+1] == '*'){
            //第一个位置相同 或者 模式第一个位置为. 即任意字符
            if(s[s_index] == m[m_index] && s_index != s.length || m[m_index+ 1] == '.' && s.length != s_index){
                return math2(s,s_index,m,m_index+2) || math2(s,s_index+1,m,m_index+2) || math2(s,s_index+1,m,m_index);
            }else{
                return math2(s,s_index,m,m_index+2);
            }
        }
        //a1的情况
        if(s.length != s_index && (s[s_index] == m[m_index] || m[m_index +1] != '.')){
            return math2(s,s_index+1,m,m_index+1);
        }else{
            return false;
        }
    }
}
