package redo.p2800_2899;

import java.util.List;
import java.util.TreeMap;

public class P2817 {

    class Solution {
        public int minAbsoluteDifference(List<Integer> nums, int x) {
            int[] arr = cv(nums);
            OrderCounter<Integer> counter = new OrderCounter<>();
            for (int i = x; i < arr.length; ++i) {
                counter.plus1(arr[i]);
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length - x; ++i) {
                Integer top = counter.counter.ceilingKey(arr[i]);
                if (null != top && top == arr[i]) {
                    return 0;
                }
                Integer floor = counter.counter.floorKey(arr[i]);
                if (floor == null) {
                    ans = Math.min(ans, Math.abs(top - arr[i]));
                } else if (top == null) {
                    ans = Math.min(ans, Math.abs(floor - arr[i]));
                } else {
                    ans = Math.min(ans, Math.min(Math.abs(floor - arr[i]), Math.abs(top - arr[i])));
                }
                counter.minus1(arr[i + x]);
            }
            return ans;
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

        int[] cv(List<Integer> list) {
            int[] arr = new int[list.size()];
            for (int i = 0; i < list.size(); ++i) {
                arr[i] = list.get(i);
            }
            return arr;
        }
    }


}
