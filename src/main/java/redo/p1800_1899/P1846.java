package redo.p1800_1899;

import java.util.TreeMap;

public class P1846 {

    class Solution {
        public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
            OrderCounter<Integer> oCounter = new OrderCounter<>();
            for (int num : arr) {
                oCounter.plus1(num);
            }
            int need = 1;
            for (int i = 0; i < arr.length; ++i) {
                int min = oCounter.minKey();
                oCounter.minus1(min);
                if (min == need - 1) {
                    continue;
                } else {
                    ++need;
                }
            }
            return need - 1;
        }

        class OrderCounter<K extends Comparable<K>> {
            private TreeMap<K, IntValue> counter = new TreeMap<>();

            public final IntValue NUM_0 = new IntValue();

            public OrderCounter() {

            }

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
