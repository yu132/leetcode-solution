package redo.p2500_2599;

import java.util.*;

public class P2588 {

    class Solution {
        public long beautifulSubarrays(int[] nums) {
            Counter<Integer> counter = new Counter<>();
            int xor = 0;
            long ans = 0;
            counter.plus1(0);
            for (int num : nums) {
                xor ^= num;
                ans += counter.get(xor);
                counter.plus1(xor);
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
    }

}
