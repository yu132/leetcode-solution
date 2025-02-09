package redo.p3000_3099;

import redo.Util.counter.MapCounterUtil;
import redo.testUtil.Arrs;

import java.util.*;

public class P3002 {

    class Solution {
        public int maximumSetSize(int[] nums1, int[] nums2) {
            Counter<Integer> counter1 = new Counter<>();
            Counter<Integer> counter2 = new Counter<>();
            for (int num : nums1) {
                counter1.plus1(num);
            }
            for (int num : nums2) {
                counter2.plus1(num);
            }

            Set<Integer> num1 = new HashSet<>();

            int n = nums1.length;
            int todo = n / 2;
            for (Counter<Integer>.Count count : counter1.keysAndVals()) {
                if (count.count > 1) {
                    todo -= count.count - 1;
                }
                num1.add(count.key);
            }

            Set<Integer> num2 = new HashSet<>();

            int todo2 = n / 2;
            for (Counter<Integer>.Count count : counter2.keysAndVals()) {
                if (count.count > 1) {
                    todo2 -= count.count - 1;
                }
                num2.add(count.key);
            }

            Set<Integer> toRemove = new HashSet<>();
            Set<Integer> locked = new HashSet<>();
            int todo3 = 0;
            int total = 0;

            if (todo <= 0) {
                locked.addAll(num1);
            } else {
                toRemove.addAll(num1);
                todo3 += todo;
                total += num1.size();
            }

            if (todo2 <= 0) {
                locked.addAll(num2);
            } else {
                toRemove.addAll(num2);
                todo3 += todo2;
                total += num2.size();
            }

            todo3 -= total - toRemove.size();

            if (todo3 > 0) {
                int same = 0;
                for (int num : toRemove) {
                    if (locked.contains(num)) {
                        ++same;
                    }
                }
                todo3 = Math.max(0, todo3 - same);
                return toRemove.size() + locked.size() - same - todo3;
            } else {
                return Math.min(toRemove.size() + locked.size(), n);
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


    public static void main(String[] args) {
        new P3002().new Solution().maximumSetSize(Arrs.build("[1,3,1,1]"), Arrs.build("[1,3,1,2]"));
    }


}
