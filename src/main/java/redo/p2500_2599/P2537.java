package redo.p2500_2599;

import java.util.*;

public class P2537 {

    class Solution {
        public long countGood(int[] nums, int k) {
            Counter<Integer> counter = new Counter<>();
            long count = 0, ans = 0;
            for (int l = 0, r = 0; r <= nums.length; ) {
                while (r < nums.length && count < k) {
                    count += counter.get(nums[r]);
                    counter.plus1(nums[r]);
                    ++r;
                }
                if (count < k) {
                    break;
                } else {
                    ans += nums.length - r + 1;
                }
                count -= counter.minus1(nums[l]);
                ++l;
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

    public static void main(String[] args) {
        new P2537().new Solution().countGood(new int[]{3, 1, 4, 3, 2, 2, 4}, 2);
    }

}
