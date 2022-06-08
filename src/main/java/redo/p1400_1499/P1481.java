package redo.p1400_1499;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1481  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月7日  
 *  
 */
public class P1481 {

    static//

    class Solution {
        public int findLeastNumOfUniqueInts(int[] arr, int k) {
            Counter<Integer> counter = new Counter<>();
            for (int i = 0; i < arr.length; ++i) {
                counter.plus1(arr[i]);
            }
            List<Integer> list = new ArrayList<>();
            for (IntValue val : counter.counter.values()) {
                list.add(val.value);
            }
            Collections.sort(list);

            for (int i = 0; i < list.size(); ++i) {
                if (k < list.get(i)) {
                    return list.size() - i;
                }
                k -= list.get(i);
            }

            return 0;
        }

        static class Counter<K> {

            private Map<K, IntValue> counter;

            public Counter() {
                this(16);
            }

            public Counter(int size) {
                super();
                this.counter = new HashMap<>(size);
            }

            public final static IntValue NUM_0 = new IntValue();

            public void plus1(K key) {
                ++counter.computeIfAbsent(key, (x) -> new IntValue()).value;
            }

            public void minus1(K key) {
                if (counter.containsKey(key)) {
                    IntValue val = counter.get(key);
                    --val.value;
                    if (val.value == 0) {
                        counter.remove(key);
                    }
                }
            }

            public int get(K key) {
                return counter.getOrDefault(key, NUM_0).value;
            }

            public Set<K> keys() {
                return counter.keySet();
            }
        }

        static class IntValue {
            int value = 0;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.findLeastNumOfUniqueInts(new int[] {5, 5, 4}, 1));
        Assert.assertEquals(2, s.findLeastNumOfUniqueInts(new int[] {4, 3, 1, 1, 3, 3, 2}, 3));
    }

}
