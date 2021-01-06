package redo.p1500_1599;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1577  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月4日  
 *  
 */
public class P1577 {

    static//

    class Solution {
        public int numTriplets(int[] nums1, int[] nums2) {
            Counter<Long> counter1 = new Counter<>(nums1.length), counter2 = new Counter<>(nums2.length);
            for (int num : nums1) {
                counter1.plus1((long)num * num);
            }
            for (int num : nums2) {
                counter2.plus1((long)num * num);
            }
            int count = 0;
            for (int i = 0; i < nums1.length; ++i) {
                for (int j = i + 1; j < nums1.length; ++j) {
                    count += counter2.get((long)nums1[i] * nums1[j]);
                }
            }
            for (int i = 0; i < nums2.length; ++i) {
                for (int j = i + 1; j < nums2.length; ++j) {
                    count += counter1.get((long)nums2[i] * nums2[j]);
                }
            }
            return count;
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
        Assert.assertEquals(1, s.numTriplets(new int[] {7, 4}, new int[] {5, 2, 8, 9}));
        Assert.assertEquals(9, s.numTriplets(new int[] {1, 1}, new int[] {1, 1, 1}));
        Assert.assertEquals(2, s.numTriplets(new int[] {7, 7, 8, 3}, new int[] {1, 2, 9, 7}));
        Assert.assertEquals(0, s.numTriplets(new int[] {4, 7, 9, 11, 23}, new int[] {3, 5, 1024, 12, 18}));
        Assert.assertEquals(0, s.numTriplets(new int[] {43024, 99908}, new int[] {1864}));

    }

}
