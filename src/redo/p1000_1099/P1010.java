package redo.p1000_1099;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1010  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月20日  
 *  
 */
public class P1010 {

    static//

    class Solution {
        public int numPairsDivisibleBy60(int[] time) {
            Counter<Integer> counter = new Counter<>(100);
            for (int num : time) {
                counter.plus1(num % 60);
            }
            int ans = 0;
            for (int num : time) {
                int pair = (60 - num % 60) % 60;

                int pairs = counter.get(pair);

                if (pair == num % 60) {
                    ans += pairs - 1;
                } else {
                    ans += pairs;
                }
            }

            return ans / 2;
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
        Assert.assertEquals(3, s.numPairsDivisibleBy60(new int[] {30, 20, 150, 100, 40}));
        Assert.assertEquals(3, s.numPairsDivisibleBy60(new int[] {60, 60, 60}));
    }

}
