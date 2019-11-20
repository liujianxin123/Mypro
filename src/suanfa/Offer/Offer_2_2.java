package suanfa.Offer;

public class Offer_2_2 {

        public static void main(String[] args) {
            Offer_2_2 test = new Offer_2_2();
            int[] arr = {1,2,2,3,4,5};
            System.out.println(test.getDuplication2(arr));
        }
        public int getDuplication2(int[] arr) {
            // 参数有效性检查
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < 0 || arr[i] >= arr.length) {
                    throw new IllegalArgumentException("参数不正确");
                }
            }
            int start = 1;
            int end = arr.length - 1;
            while (end >= start) {
                // 计算出中间位置
                int middle = ((end - start) >> 1) + start;
                int count = countRange(arr, start, middle);
                if (end == start) {
                    if (count > 1) {
                        return start;
                    } else {
                        break;
                    }
                }
                if (count > (middle - start + 1)) {
                    end = middle;
                } else {
                    start = middle + 1;
                }

            }
            return -1;
        }

        private int countRange(int[] arr, int start, int end) {
            if (arr == null) {
                return 0;
            }
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= start && arr[i] <= end) {
                    count++;
                }
            }
            return count;
        }


        public int test(int[] p){
            int str = 1;
            int end = p.length -1;

            int cont = countRange(p,str,end);
            while (str<end){
                int mid = str + (end - str)>>1;

                if(end == str){
                    if(cont>1){
                        return str;
                    }else {
                        break;
                    }

                }

                if (cont > end-str+1){
                    end = mid;
                }else {
                    str = mid + 1;
                }
            }

            return -1;
        }
    }
