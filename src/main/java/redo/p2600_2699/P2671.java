package redo.p2600_2699;

import java.util.*;

public class P2671 {

    class FrequencyTracker {

        Counter<Integer> counter = new Counter<>();
        SetMap<Integer, Integer> setMap = new SetMap<>();

        public FrequencyTracker() {

        }

        public void add(int number) {
            int now = counter.plus1(number) - 1;
            if (now != 0) {
                setMap.remove(now, number);
            }
            setMap.add(now + 1, number);
        }

        public void deleteOne(int number) {
            int now = counter.minus1(number) + 1;
            setMap.remove(now, number);
            if (now - 1 != 0) {
                setMap.add(now - 1, number);
            }
        }

        public boolean hasFrequency(int frequency) {
            return !setMap.get(frequency).isEmpty();
        }

        class SetMap<K, E> {

            Map<K, Set<E>> map = new HashMap<>();

            public void add(K key, E element) {
                map.computeIfAbsent(key, (x) -> new HashSet<>()).add(element);
            }

            public void addAll(K key, Collection<E> elements) {
                map.computeIfAbsent(key, (x) -> new HashSet<>()).addAll(elements);
            }

            public void remove(K key, E element) {
                map.computeIfAbsent(key, (x) -> new HashSet<>()).remove(element);
            }

            public boolean contain(K key, E element) {
                return get(key).contains(element);
            }

            public Set<E> get(K key) {
                return map.getOrDefault(key, Collections.emptySet());
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
