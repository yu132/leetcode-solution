package redo.p2400_2499;

import redo.testUtil.Arrs;

import java.util.*;

public class P2461 {

    class Solution {
        public long maximumSubarraySum(int[] nums, int k) {
            Counter<Integer> counter = new Counter<>();
            int countIntRep = 0;
            long sumAll = 0, ans = 0;
            for (int i = 0; i < k; ++i) {
                sumAll += nums[i];
                if (counter.plus1(nums[i]) == 2) {
                    ++countIntRep;
                }
            }
            if (countIntRep == 0) {
                ans = sumAll;
            }
            for (int i = k; i < nums.length; ++i) {
                sumAll += nums[i];
                sumAll -= nums[i - k];
                if (counter.plus1(nums[i]) == 2) {
                    ++countIntRep;
                }
                if (counter.minus1(nums[i - k]) == 1) {
                    --countIntRep;
                }
                if (countIntRep == 0) {
                    ans = Math.max(ans, sumAll);
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

    public static void main(String[] args) {
        new P2461().new Solution().maximumSubarraySum(Arrs.build("[9,9,9,1,2,3]"), 3);
    }

}
