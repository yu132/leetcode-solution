package redo.p2400_2499;

import java.util.*;

public class P2456 {

    class Solution {
        public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
            Counter<String> sumPlayCount = new Counter<>();
            Map<String, MaxPlayVideo> maxPlayVideoMap = new HashMap<>();
            for (int i = 0; i < creators.length; ++i) {
                sumPlayCount.add(creators[i], views[i]);
                if (!maxPlayVideoMap.containsKey(creators[i])) {
                    maxPlayVideoMap.put(creators[i], new MaxPlayVideo(ids[i], views[i]));
                } else {
                    MaxPlayVideo last = maxPlayVideoMap.get(creators[i]);
                    if (views[i] > last.playCount || (views[i] == last.playCount && ids[i].compareTo(last.name) < 0)) {
                        last.playCount = views[i];
                        last.name = ids[i];
                    }
                }
            }
            long maxCount = maxCount(sumPlayCount);
            List<List<String>> ans = new ArrayList<>();
            for (Counter<String>.Count c : sumPlayCount.keysAndVals()) {
                if (c.count == maxCount) {
                    ans.add(Arrays.asList(c.key, maxPlayVideoMap.get(c.key).name));
                }
            }
            return ans;
        }

        class MaxPlayVideo {
            String name;
            int playCount;

            public MaxPlayVideo(String name, int playCount) {
                this.name = name;
                this.playCount = playCount;
            }
        }

        public long maxCount(Counter<?> counter) {
            long max = Long.MIN_VALUE;
            for (Counter<?>.LongValue value : counter.counter.values()) {
                max = Math.max(max, value.value);
            }
            return max;
        }

        class Counter<K> {

            private Map<K, LongValue> counter;

            public Counter() {
                this(16);
            }

            public Counter(int size) {
                super();
                this.counter = new HashMap<>(size);
            }

            public final LongValue NUM_0 = new LongValue();

            public long plus1(K key) {
                return ++counter.computeIfAbsent(key, (x) -> new LongValue()).value;
            }

            public void add(K key, int num) {
                counter.computeIfAbsent(key, (x) -> new LongValue()).value += num;
            }

            public long minus1(K key) {
                if (counter.containsKey(key)) {
                    LongValue val = counter.get(key);
                    --val.value;
                    if (val.value == 0) {
                        counter.remove(key);
                    }
                    return val.value;
                }
                return 0;
            }

            public long get(K key) {
                return counter.getOrDefault(key, NUM_0).value;
            }

            public Set<K> keys() {
                return counter.keySet();
            }

            public List<Long> values() {
                List<Long> list = new ArrayList<>(counter.size());
                for (LongValue val : counter.values()) {
                    list.add(val.value);
                }
                return list;
            }

            public List<Count> keysAndVals() {
                List<Count> list = new ArrayList<>(counter.size());
                for (Map.Entry<K, LongValue> entry : counter.entrySet()) {
                    list.add(new Count(entry.getKey(), entry.getValue().value));
                }
                return list;
            }

            class Count {
                K key;
                long count;

                public Count(K key, long count) {
                    super();
                    this.key = key;
                    this.count = count;
                }
            }

            class LongValue {
                long value = 0;
            }
        }
    }

}
