package redo.p0900_0999;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P954  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月21日  
 *  
 */
public class P954 {

    static//

    class Solution {
        public boolean canReorderDoubled(int[] arr) {
            Counter<Integer> counter = new Counter<>();
            for (int num : arr) {
                counter.plus1(num);
            }
            Arrays.sort(arr);
            int len = unique(arr);
            for (int i = 0; i < len; ++i) {
                int num = arr[i], count = counter.get(num);
                if (count == 0) {
                    continue;
                }
                if (num < 0) {
                    if (num % 2 != 0) {
                        return false;
                    }
                    if (counter.get(num / 2) < count) {
                        return false;
                    }
                    counter.add(num / 2, -count);
                } else if (num == 0) {
                    if (count % 2 != 0) {
                        return false;
                    }
                    counter.add(0, -count);
                } else {
                    if (counter.get(num * 2) < count) {
                        return false;
                    }
                    counter.add(num * 2, -count);
                }
            }
            return true;
        }

        public int unique(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int indexToFill = 1;
            for (int indexToCheck = 1; indexToCheck < nums.length; ++indexToCheck) {
                if (nums[indexToCheck] != nums[indexToCheck - 1]) {
                    nums[indexToFill++] = nums[indexToCheck];
                }
            }
            return indexToFill;
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

            public int plus1(K key) {
                return ++counter.computeIfAbsent(key, (x) -> new IntValue()).value;
            }

            public void add(K key, int num) {
                counter.computeIfAbsent(key, (x) -> new IntValue()).value += num;
            }

            public int minus1(K key) {
                if (counter.containsKey(key)) {
                    IntValue val = counter.get(key);
                    --val.value;
                    if (val.value == 0) {
                        counter.remove(key);
                    }
                    return val.value;
                }
                return 0;
            }

            public int get(K key) {
                return counter.getOrDefault(key, NUM_0).value;
            }

            public Set<K> keys() {
                return counter.keySet();
            }

            public List<Integer> values() {
                List<Integer> list = new ArrayList<>(counter.size());
                for (IntValue val : counter.values()) {
                    list.add(val.value);
                }
                return list;
            }

            public List<Count<K>> keysAndVals() {
                List<Count<K>> list = new ArrayList<>(counter.size());
                for (Map.Entry<K, IntValue> entry : counter.entrySet()) {
                    list.add(new Count<K>(entry.getKey(), entry.getValue().value));
                }
                return list;
            }

        }

        static class Count<K> {
            K key;
            int count;

            public Count(K key, int count) {
                super();
                this.key = key;
                this.count = count;
            }
        }

        static class IntValue {
            int value = 0;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(false, s.canReorderDoubled(new int[] {3, 1, 3, 6}));
        Assert.assertEquals(false, s.canReorderDoubled(new int[] {2, 1, 2, 6}));
        Assert.assertEquals(true, s.canReorderDoubled(new int[] {4, -2, 2, -4}));
        Assert.assertEquals(false, s.canReorderDoubled(new int[] {1, 2, 4, 16, 8, 4}));
        Assert.assertEquals(false, s.canReorderDoubled(new int[] {0, 0, 0}));
        Assert.assertEquals(true, s.canReorderDoubled(new int[] {0, 0}));
    }

}
