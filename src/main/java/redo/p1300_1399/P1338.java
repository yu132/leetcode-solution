package redo.p1300_1399;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1338  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月10日  
 *  
 */
public class P1338 {

    static//

    class Solution {
        public int minSetSize(int[] arr) {
            Counter<Integer> counter = new Counter<>();
            for (int num : arr) {
                counter.plus1(num);
            }
            List<IntValue> list = new ArrayList<>(counter.counter.values());
            Collections.sort(list, (a, b) -> Integer.compare(a.value, b.value));
            for (int i = list.size() - 1, size = arr.length; i >= 0; --i) {
                size -= list.get(i).value;
                if (size * 2 <= arr.length) {
                    return list.size() - i;
                }
            }
            throw new RuntimeException("impossible");
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

            public void add(K key, int num) {
                counter.computeIfAbsent(key, (x) -> new IntValue()).value += num;
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
        Assert.assertEquals(2, s.minSetSize(new int[] {3, 3, 3, 3, 5, 5, 5, 2, 2, 7}));
        Assert.assertEquals(1, s.minSetSize(new int[] {7, 7, 7, 7, 7, 7}));
        Assert.assertEquals(1, s.minSetSize(new int[] {1, 9}));
        Assert.assertEquals(1, s.minSetSize(new int[] {1000, 1000, 3, 7}));
        Assert.assertEquals(5, s.minSetSize(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }
}
