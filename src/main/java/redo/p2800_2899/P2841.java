package redo.p2800_2899;

import java.util.*;

public class P2841 {

    class Solution {
        public long maxSum(List<Integer> nums, int m, int k) {
            Counter<Integer> counter = new Counter<>();
            long sum = 0;
            for (int i = 0; i < k; ++i) {
                counter.plus1(nums.get(i));
                sum += nums.get(i);
            }
            long ans = 0;
            if (counter.counter.size() >= m) {
                ans = sum;
            }
            for (int i = k; i < nums.size(); ++i) {
                counter.plus1(nums.get(i));
                counter.minus1(nums.get(i - k));
                sum += nums.get(i) - nums.get(i - k);
                if (counter.counter.size() >= m) {
                    ans = Math.max(ans, sum);
                }
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
