package redo.Util.counter;

import java.util.*;

public class LongMapCounter {

    public long maxCount(Counter<?> counter) {
        long max = Long.MIN_VALUE;
        for (Counter<?>.LongValue value : counter.counter.values()) {
            max = Math.max(max, value.value);
        }
        return max;
    }

    class Counter<K> {

        private Map<K, Counter.LongValue> counter;

        public Counter() {
            this(16);
        }

        public Counter(int size) {
            super();
            this.counter = new HashMap<>(size);
        }

        public final Counter.LongValue NUM_0 = new Counter.LongValue();

        public long plus1(K key) {
            return ++counter.computeIfAbsent(key, (x) -> new Counter.LongValue()).value;
        }

        public void add(K key, int num) {
            counter.computeIfAbsent(key, (x) -> new Counter.LongValue()).value += num;
        }

        public long minus1(K key) {
            if (counter.containsKey(key)) {
                Counter.LongValue val = counter.get(key);
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
            for (Counter.LongValue val : counter.values()) {
                list.add(val.value);
            }
            return list;
        }

        public List<Counter.Count> keysAndVals() {
            List<Counter.Count> list = new ArrayList<>(counter.size());
            for (Map.Entry<K, Counter.LongValue> entry : counter.entrySet()) {
                list.add(new Counter.Count(entry.getKey(), entry.getValue().value));
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
