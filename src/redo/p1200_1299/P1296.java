package redo.p1200_1299;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1296  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月11日  
 *  
 */
public class P1296 {

    static//

    class Solution {
        public boolean isPossibleDivide(int[] nums, int k) {
            if (nums.length % k != 0) {
                return false;
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>();

            Counter<Integer> counter = new Counter<>();

            for (int num : nums) {
                counter.plus1(num);
            }

            for (int num : counter.keys()) {
                pq.offer(num);
            }

            Set<Integer> toRemove = new HashSet<>();

            while (!pq.isEmpty()) {
                int min = pq.peek();
                for (int i = min; i < min + k; ++i) {
                    int mark = counter.minus1(i);
                    if (mark == 0) {
                        toRemove.add(i);
                    } else if (mark == -1) {
                        return false;
                    }
                }
                while (toRemove.contains(pq.peek())) {
                    pq.poll();
                }
            }

            return true;
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
                return -1;
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

            public List<Pair<K>> keysAndVals() {
                List<Pair<K>> list = new ArrayList<>(counter.size());
                for (Map.Entry<K, IntValue> entry : counter.entrySet()) {
                    list.add(new Pair<K>(entry.getKey(), entry.getValue().value));
                }
                return list;
            }

        }

        static class Pair<K> {
            K key;
            int val;

            public Pair(K key, int val) {
                super();
                this.key = key;
                this.val = val;
            }
        }

        static class IntValue {
            int value = 0;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.isPossibleDivide(new int[] {1, 2, 3, 3, 4, 4, 5, 6}, 4));
        Assert.assertEquals(true, s.isPossibleDivide(new int[] {3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11}, 3));
        Assert.assertEquals(true, s.isPossibleDivide(new int[] {3, 3, 2, 2, 1, 1}, 3));
        Assert.assertEquals(false, s.isPossibleDivide(new int[] {1, 2, 3, 4}, 3));
        Assert.assertEquals(false, s.isPossibleDivide(new int[] {1, 2, 3, 1, 2, 4}, 3));
    }
}
