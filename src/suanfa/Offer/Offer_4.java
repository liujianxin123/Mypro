package suanfa.Offer;
// 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按
// 照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个
// 整数，判断数组中是否含有该整数。
public class Offer_4 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(Offer_4.seek(matrix,40));
        System.out.println(Offer_4.find(40,matrix));
    }



    public static boolean seek(int[][] p,int tar){
        int i = 0;//行的第一个下标
        int j = p[0].length-1;//列的最后一位下表

        while (j>=0 && i<= p.length-1){
            if(p[i][j] < tar){//最右上角的数字是否小于目标值，如果小于就往下一行找，因为每行是递增的
                i++;
            }else if(p[i][j] > tar){//最右上角的数字是否大于目标值，如果小于就减少一列，因为每列是递增的
                j--;
            }else {
                return true;
            }
        }

        return false;
    }
    public static boolean find(int target, int[][] array) {
        int row = 0;
        int col = array[0].length - 1;
        while (row <= array.length - 1 && col >= 0) {
            if (target == array[row][col]) {
                return true;
            } else if (target > array[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
