package redo.p2900_2999;

import java.util.*;

public class P2910 {

    class Solution {
        public int minGroupsForValidAssignment(int[] balls) {
            Counter<Integer> counter = new Counter<>();
            for (int num : balls) {
                counter.plus1(num);
            }
            List<Integer> values = counter.values();
            int num = Integer.MAX_VALUE;
            for (Integer value : values) {
                num = Math.min(num, value);
            }
            int ans = 0;
            for (; ; --num) {
                for (int a : values) {
                    if (a / num < a % num) {
                        ans = 0;
                        break;
                    }
                    ans += (a + num) / (num + 1);
                }
                if (ans > 0) {
                    return ans;
                }
            }
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
