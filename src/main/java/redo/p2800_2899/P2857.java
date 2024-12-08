package redo.p2800_2899;

import java.util.*;

public class P2857 {

    class Solution {
        public int countPairs(List<List<Integer>> coordinates, int k) {
            Counter<Node> counter = new Counter<>();
            for (List<Integer> l : coordinates) {
                counter.plus1(new Node(l.get(0), l.get(1)));
            }
            long ans = 0;
            for (List<Integer> p : coordinates) {
                for (int i = 0; i <= k; ++i) {
                    int l = i, r = k - i;
                    int x1 = p.get(0), y1 = p.get(1);
                    int x2 = x1 ^ l, y2 = y1 ^ r;
                    if (x1 == x2 && y1 == y2) {
                        ans += counter.get(new Node(x2, y2)) - 1;
                    } else {
                        ans += counter.get(new Node(x2, y2));
                    }
                }
            }
            return (int) (ans / 2);
        }

        class Node {
            int x, y;

            public Node(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Node node = (Node) o;
                return x == node.x && y == node.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
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
