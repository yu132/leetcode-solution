package redo.p1600_1699;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1679  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月31日  
 *  
 */
public class P1679 {

    static//

    class Solution {
        public int maxOperations(int[] nums, int k) {

            Counter<Integer> counter = new Counter<>(nums.length);

            Set<Integer> visited = new HashSet<>();

            for (int num : nums) {
                counter.plus1(num);
            }
            int sum = 0;
            for (int num : counter.keys()) {
                if (visited.contains(num)) {
                    continue;
                }
                int diff = k - num;
                if (diff == num) {
                    sum += counter.get(num) / 2;
                } else {
                    sum += Math.min(counter.get(num), counter.get(diff));
                }
                visited.add(diff);
            }
            return sum;
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
        Assert.assertEquals(2, s.maxOperations(new int[] {1, 2, 3, 4}, 5));
        Assert.assertEquals(1, s.maxOperations(new int[] {3, 1, 3, 4, 3}, 6));
    }

}
