package redo.p2700_2799;

import java.util.*;

public class P2747 {

    class Solution {
        public int[] countServers(int n, int[][] logs, int x, int[] queries) {
            Queue<int[]> logsQueue = new LinkedList<>();
            Counter<Integer> counter = new Counter<>();
            Arrays.sort(logs, Comparator.comparingInt(a -> a[1]));
            Map<Integer, Integer> indexes = getIndexMap(queries);
            Arrays.sort(queries);
            int indexOfLog = 0;
            int[] ans = new int[queries.length];
            for (int query : queries) {
                while (indexOfLog < logs.length && logs[indexOfLog][1] <= query) {
                    logsQueue.offer(logs[indexOfLog]);
                    counter.plus1(logs[indexOfLog][0]);
                    ++indexOfLog;
                }
                while (!logsQueue.isEmpty() && logsQueue.peek()[1] < query - x) {
                    int[] log = logsQueue.poll();
                    counter.minus1(log[0]);
                }
                ans[indexes.get(query)] = n - counter.counter.size();
            }
            return ans;
        }

        Map<Integer, Integer> getIndexMap(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; ++i) {
                map.put(arr[i], i);
            }
            return map;
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
