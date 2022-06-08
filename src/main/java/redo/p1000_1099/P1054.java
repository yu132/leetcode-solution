package redo.p1000_1099;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1054  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月17日  
 *  
 */
public class P1054 {

    static//

    class Solution {
        public int[] rearrangeBarcodes(int[] barcodes) {

            PriorityQueue<Count<Integer>> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.count, a.count));

            Counter<Integer> counter = new Counter<>();

            for (int num : barcodes) {
                counter.plus1(num);
            }

            for (Count<Integer> count : counter.keysAndVals()) {
                pq.offer(count);
            }

            Count<Integer> max = pq.poll();

            for (int i = 0; i < barcodes.length; i += 2) {
                barcodes[i] = max.key;
                --max.count;
                if (max.count == 0) {
                    max = pq.poll();
                }
            }

            for (int i = 1; i < barcodes.length; i += 2) {
                barcodes[i] = max.key;
                --max.count;
                if (max.count == 0) {
                    max = pq.poll();
                }
            }

            return barcodes;
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
        Assert.assertArrayEquals(new int[] {1, 2, 1, 2, 1, 2}, s.rearrangeBarcodes(new int[] {1, 1, 1, 2, 2, 2}));

        Assert.assertArrayEquals(new int[] {1, 3, 1, 3, 1, 2, 1, 2},
            s.rearrangeBarcodes(new int[] {1, 1, 1, 1, 2, 2, 3, 3}));

        Assert.assertArrayEquals(new int[] {1}, s.rearrangeBarcodes(new int[] {1}));

        Assert.assertArrayEquals(new int[] {5, 7, 5, 7, 5, 7, 5, 8, 7, 8},
            s.rearrangeBarcodes(new int[] {7, 7, 7, 8, 5, 7, 5, 5, 5, 8}));

        Assert.assertArrayEquals(new int[] {1, 2, 1}, s.rearrangeBarcodes(new int[] {1, 1, 2}));
    }

}
