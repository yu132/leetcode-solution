package redo.p2000_2099;

import java.util.TreeMap;

public class P2007 {

    class Solution {
        public int[] findOriginalArray(int[] changed) {
            if (changed.length % 2 == 1) {
                return new int[0];
            }
            OrderCounter<Integer> counter = new OrderCounter<>();
            int[] ans = new int[changed.length / 2];
            int index = 0;
            for (int num : changed) {
                counter.plus1(num);
            }
            while (!counter.counter.isEmpty()) {
                int min = counter.minKey();
                if (counter.get(min * 2) == 0) {
                    return new int[0];
                }
                ans[index++] = min;
                counter.minus1(min);
                counter.minus1(min * 2);
            }
            return ans;
        }

        class OrderCounter<K extends Comparable<K>> {
            private TreeMap<K, OrderCounter.IntValue> counter = new TreeMap<>();

            public final OrderCounter.IntValue NUM_0 = new OrderCounter.IntValue();

            public int plus1(K key) {
                return ++counter.computeIfAbsent(key, (x) -> new OrderCounter.IntValue()).value;
            }

            public void add(K key, int num) {
                counter.computeIfAbsent(key, (x) -> new OrderCounter.IntValue()).value += num;
            }

            public int minus1(K key) {
                if (counter.containsKey(key)) {
                    OrderCounter.IntValue val = counter.get(key);
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

            public K minKey() {
                return counter.firstKey();
            }

            public K maxKey() {
                return counter.lastKey();
            }

            class IntValue {
                int value = 0;
            }
        }
    }

}
