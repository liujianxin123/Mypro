package suanfa.Offer;

//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
//路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
//如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如 a b c e s f c s a d e e
//矩阵中包含一条字符串”bcced”的路径，但是矩阵中不包含”abcb”路径，因为字符串的第一个字符b占据了矩阵
//中的第一行第二个格子之后，路径不能再次进入该格子


//二维解决https://blog.csdn.net/aa792978017/article/details/89096939
public class Offer_12 {

    public static void main(String[] args) {
        char[] p = {1,2,3,4,5,6,7,8,9};
        char[] str = {1,3,5,8,9};
        System.out.println(Offer_12.havePath(p,3,3,str));
    }
    public static boolean havePath(char[] p,int row,int cols,char[] str){

        //定义一个二维数组，将p的一维数组转换成二维数组放进去
        char[][] chars = new char[row][cols];

        //用来标记的数组，来标记矩阵中的字符是否被用过，0没有，1用过
        char[][] flag = new char[row][cols];
        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                chars[i][j] = p[index++];
                flag[i][j] = 0;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                if(getPath(chars,i,j,flag,str,0)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 回朔算法
     * @param chars 二维数组
     * @param row 行
     * @param cols 列
     * @param flag 标记
     * @param str  要查找的路径
     * @return
     */
    public static boolean getPath(char[][] chars,int row,int cols,char[][] flag,char[] str,int index){
        if(index == str.length){
            return true;
        }

        if(row <0 || cols <0 || row > chars[0].length || cols > chars.length || flag[row][cols] == 1){
            return false;
        }
        if(chars[row][cols] == str[index]){
            //标记已经用过
            chars[row][cols] = 1;
            index++;
            if(getPath(chars,row,cols-1,flag,str,index)){//向上找
                return true;
            }if(getPath(chars,row,cols+1,flag,str,index)){//向下找
                return true;
            }if(getPath(chars,row-1,cols,flag,str,index)){//向左找
                return true;
            }if(getPath(chars,row+1,cols,flag,str,index)){//向右找
                return true;
            }

        }
        chars[row][cols] = 0;
        return false;
    }


    public static void quickSort(int[] p,int low, int high){

        int i = low;
        int j = high;
        int tmp = p[low];
        if(low > high){
            return;
        }
        while (i<j){
            while (p[i]<= tmp && i<j) {
                i++;
            }
            while (p[j]>=tmp && i<j){
                j--;
            }
            if(i<j){
                int t = p[i];
                p[i] = p[j];
                p[j] = t;
            }
        }
        p[low] = p[i];
        p[i] = tmp;
        quickSort(p,low,j-1);
        quickSort(p,high,j+1);
    }
}
