package suanfa.Offer;

/**
 * 找出旋转数组中最小的数字
 * {3,4,5,1,2}是{1,2,3,4,5}的反转
 */
public class Offer_11 {
    public static void main(String[] args) {

    }

    public static int minNum(int[] p){
        int start = 0;
        int end = p.length-1;
        if(p[start] < p[end]){//此处是为了防止数组本身并没有旋转，或者说是旋转了零个元素
            return p[start];
        }
        while (start<end){
            int mid = start + (end - start)>>>1;
            if(p[start] == p[mid]&& p[mid] == p[end]){//如果说三个数相等，比如反转数组{1，0，1，1，1}，只能通过顺序查找
                return minNum2(p);
            }
            if(p[mid] > p[start] ){
                start = mid;
            }else if(p[mid] < p[start]){
                end = mid;
            }else {
                return p[mid];
            }
        }
        return -1;
    }
    public static int minNum2(int[] p){
        int result = p[0];
        for (int i = 1; i < p.length; i++) {
            if(result < p[i]){
                result = p[i];
            }
        }
        return result;
    }
}
