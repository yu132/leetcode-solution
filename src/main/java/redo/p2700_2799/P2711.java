package redo.p2700_2799;

import java.util.*;

public class P2711 {

    class Solution {
        public int[][] differenceOfDistinctValues(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] ans = new int[m][n];
            for (int i = m - 1; i >= 0; --i) {
                Counter<Integer> bR = new Counter<>(), tL = new Counter<>();
                for (int x = i, y = 0; x < m && y < n; ++x, ++y) {
                    bR.plus1(grid[x][y]);
                }
                for (int x = i, y = 0; x < m && y < n; ++x, ++y) {
                    bR.minus1(grid[x][y]);
                    ans[x][y] = Math.abs(tL.counter.size() - bR.counter.size());
                    tL.plus1(grid[x][y]);
                }
            }
            for (int j = 1; j < n; ++j) {
                Counter<Integer> bR = new Counter<>(), tL = new Counter<>();
                for (int x = 0, y = j; x < m && y < n; ++x, ++y) {
                    bR.plus1(grid[x][y]);
                }
                for (int x = 0, y = j; x < m && y < n; ++x, ++y) {
                    bR.minus1(grid[x][y]);
                    ans[x][y] = Math.abs(tL.counter.size() - bR.counter.size());
                    tL.plus1(grid[x][y]);
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

}
