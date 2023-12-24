package redo.p0900_0999;

import redo.testUtil.Arrs;

import java.util.*;

public class P992 {

    class Solution {
        public int subarraysWithKDistinct(int[] nums, int k) {
            Counter<Integer> counter = new Counter<>();
            int ans = 0;
            int l = 0, ml = 0, r = 0;
            while (r < nums.length && counter.counter.size() < k) {
                counter.plus1(nums[r++]);
            }
            if (r == nums.length) {
                return counter.counter.size() == k ? 1 : 0;
            }
            while (counter.counter.size() == k) {
                counter.minus1(nums[ml++]);
            }
            ans += ml - l;
            for (; r < nums.length; ++r) {
                counter.plus1(nums[r]);
                if (counter.counter.size() == k) {
                    if (nums[r] != nums[ml - 1]) {
                        l = ml;
                    }
                    while (counter.counter.size() == k) {
                        counter.minus1(nums[ml++]);
                    }
                }
                ans += ml - l;
            }
            return ans;
        }

        class Counter<K> {

            private Map<K, Counter.IntValue> counter;

            public Counter() {
                this(16);
            }

            public Counter(int size) {
                super();
                this.counter = new HashMap<>(size);
            }

            public final Counter.IntValue NUM_0 = new Counter.IntValue();

            public int plus1(K key) {
                return ++counter.computeIfAbsent(key, (x) -> new Counter.IntValue()).value;
            }

            public void add(K key, int num) {
                counter.computeIfAbsent(key, (x) -> new Counter.IntValue()).value += num;
            }

            public int minus1(K key) {
                if (counter.containsKey(key)) {
                    Counter.IntValue val = counter.get(key);
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
                for (Counter.IntValue val : counter.values()) {
                    list.add(val.value);
                }
                return list;
            }

            public List<Counter.Count> keysAndVals() {
                List<Counter.Count> list = new ArrayList<>(counter.size());
                for (Map.Entry<K, Counter.IntValue> entry : counter.entrySet()) {
                    list.add(new Counter.Count(entry.getKey(), entry.getValue().value));
                }
                return list;
            }

            class Count {
                K key;
                int count;

                public Count(K key, int count) {
                    super();
                    this.key = key;
                    this.count = count;
                }
            }

            class IntValue {
                int value = 0;
            }
        }

        public int maxCount(Counter<?> counter) {
            int max = Integer.MIN_VALUE;
            for (Counter<?>.IntValue value : counter.counter.values()) {
                max = Math.max(max, value.value);
            }
            return max;
        }

        public <K> Counter<K> toCounter(K[] array) {
            Counter<K> counter = new Counter<>();
            for (K item : array) {
                counter.plus1(item);
            }
            return counter;
        }
    }

    public static void main(String[] args) {
        int x = new P992().new Solution().subarraysWithKDistinct(Arrs.build("[1,2,1,2,3]"), 2);
        System.out.println(x + " " + 7);
    }
}
