package redo.p2900_2999;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class P2905 {

    class Solution {
        public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
            OrderCounter<Integer> orderCounter = new OrderCounter<>();
            Map<Integer, Integer> index = new HashMap<>();
            for (int i = indexDifference; i < nums.length; ++i) {
                orderCounter.plus1(nums[i]);
                index.put(nums[i], i);
            }
            for (int i = 0; i < nums.length - indexDifference; ++i) {
                if (Math.abs(nums[i] - orderCounter.minKey()) >= valueDifference) {
                    return new int[]{i, index.get(orderCounter.minKey())};
                } else if (Math.abs(nums[i] - orderCounter.maxKey()) >= valueDifference) {
                    return new int[]{i, index.get(orderCounter.maxKey())};
                }
                orderCounter.minus1(nums[i + indexDifference]);
            }
            return new int[]{-1, -1};
        }

        class OrderCounter<K extends Comparable<K>> {
            private TreeMap<K, IntValue> counter = new TreeMap<>();

            public final IntValue NUM_0 = new IntValue();


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