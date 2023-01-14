package redo.p0400_0499;

import java.util.*;

public class P480 {

    class Solution {

        //大堆（最小堆）
        PriorityQueue<Integer> min = new PriorityQueue<>(),
        //小堆（最大堆）
        max = new PriorityQueue<>(Comparator.reverseOrder());

        int minHeapSize = 0, maxHeapSize = 0;

        Counter<Integer> counters = new Counter<>();

        public double[] medianSlidingWindow(int[] nums, int k) {
            for (int i = 0; i < k; ++i) {
                add(nums[i]);
            }
            double[] ans = new double[nums.length - k + 1];
            ans[0] = mid();
            for (int i = k; i < nums.length; ++i) {
                add(nums[i]);
                remove(nums[i - k]);
                ans[i - k + 1] = mid();
            }
            return ans;
        }

        double mid() {
            if (minHeapSize == maxHeapSize) {
                return ((double) min.peek() + max.peek()) / 2;
            } else if (minHeapSize > maxHeapSize) {
                return min.peek();
            } else {
                return max.peek();
            }
        }

        void reOrganize() {
            removeDelayTop();
            if (minHeapSize + 1 < maxHeapSize) {
                min.offer(max.poll());
                ++minHeapSize;
                --maxHeapSize;
            } else if (minHeapSize > maxHeapSize + 1) {
                max.offer(min.poll());
                --minHeapSize;
                ++maxHeapSize;
            }
            removeDelayTop();
        }

        void add(int val) {
            if (min.isEmpty()) {
                min.offer(val);
                ++minHeapSize;
            } else if (min.peek() <= val) {
                min.offer(val);
                ++minHeapSize;
            } else {
                max.offer(val);
                ++maxHeapSize;
            }
            reOrganize();
        }

        void remove(int val) {
            if (!min.isEmpty() && min.peek() == val) {
                min.poll();
                --minHeapSize;
            } else if (!max.isEmpty() && max.peek() == val) {
                max.poll();
                --maxHeapSize;
            } else {
                if (min.peek() < val) {
                    --minHeapSize;
                } else {
                    --maxHeapSize;
                }
                counters.plus1(val);
            }
            reOrganize();
        }

        void removeDelayTop() {
            while (!min.isEmpty() && counters.get(min.peek()) > 0) {
                int val = min.poll();
                counters.minus1(val);
            }
            while (!max.isEmpty() && counters.get(max.peek()) > 0) {
                int val = max.poll();
                counters.minus1(val);
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
        new P480().new Solution().medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 4);
    }
}
