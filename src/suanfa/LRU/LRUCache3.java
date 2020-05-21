package suanfa.LRU;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap 本身内部有一个触发条件则自动执行的方法：删除最老元素（最近最少使用的元素）
 * 由于最近最少使用元素是 LinkedHashMap 内部处理
 * 故我们不再需要维护 最近访问元素放在链尾，get 时直接访问/ put 时直接存储
 * created by Ethan-Walker on 2019/2/16
 */
class LRUCache3 {
    private Map<Integer, Integer> map;
    private final int capacity;

    public LRUCache3(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
                return size() > capacity;
            }
        };
    }
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }


    public static void test(){

    // 10是初始大小，0.75是装载因子，true是表示按照访问时间排序
        HashMap<Integer, Integer> m = new LinkedHashMap<>(10, 0.75f, true);
        m.put(3, 11);
        m.put(1, 12);
        m.put(5, 23);
        m.put(2, 22);

        m.put(3, 26);
        m.get(5);

        for (Map.Entry e : m.entrySet()) {
            System.out.println(e.getKey());
        }
    }

    public static void main(String[] args) {
        test();
    }
}