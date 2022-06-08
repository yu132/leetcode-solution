package redo.p1800_1899;

import java.util.*;

public class P1865 {

    class FindSumPairs {

        Counter<Integer> counter;
        int[] nums1, nums2;

        public FindSumPairs(int[] nums1, int[] nums2) {
            counter = new Counter<>(nums2.length);
            for (int num2 : nums2) {
                counter.plus1(num2);
            }
            this.nums1 = nums1;
            this.nums2 = nums2;
        }

        public void add(int index, int val) {
            counter.minus1(nums2[index]);
            counter.plus1(nums2[index] + val);
            nums2[index] += val;
        }

        public int count(int tot) {
            int ans = 0;
            for (int num1 : nums1) {
                ans += counter.get(tot - num1);
            }
            return ans;
        }

        class Counter<K> {

            private Map<K, IntValue> counter;

            public Counter() {
                this(16);
            }

            public Counter(int size) {
                super();
                this.counter = new HashMap<>(size);
            }

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

            public List<Count> keysAndVals() {
                List<Count> list = new ArrayList<>(counter.size());
                for (Map.Entry<K, IntValue> entry : counter.entrySet()) {
                    list.add(new Count(entry.getKey(), entry.getValue().value));
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
    }

}
