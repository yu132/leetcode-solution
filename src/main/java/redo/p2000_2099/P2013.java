package redo.p2000_2099;

import java.util.*;

public class P2013 {

    class DetectSquares {

        Counter<Point> counter = new Counter<>();

        SetMap<Integer, Point> x = new SetMap<>();

        public DetectSquares() {
        }

        public void add(int[] point) {
            Point p = new Point(point);
            counter.plus1(p);
            x.add(point[0], p);
        }

        public int count(int[] point) {

            int ans = 0;

            Point p1 = new Point(point);

            for (Point p2 : x.get(point[0])) {
                if (p1.y == p2.y) {
                    continue;
                }

                int dis = Math.abs(p1.y - p2.y);

                //left
                {
                    Point p3 = new Point(p1.x - dis, p1.y),
                            p4 = new Point(p1.x - dis, p2.y);

                    int c2 = counter.get(p2), c3 = counter.get(p3), c4 = counter.get(p4);
                    ans += c2 * c3 * c4;
                }

                //right
                {
                    Point p3 = new Point(p1.x + dis, p1.y),
                            p4 = new Point(p1.x + dis, p2.y);

                    int c2 = counter.get(p2), c3 = counter.get(p3), c4 = counter.get(p4);
                    ans += c2 * c3 * c4;
                }
            }

            return ans;
        }

        class Point {
            int x, y;

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Point point = (Point) o;
                return x == point.x &&
                        y == point.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }

            public Point(int[] point) {
                this.x = point[0];
                this.y = point[1];
            }

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
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

            public List<Count<K>> keysAndVals() {
                List<Count<K>> list = new ArrayList<>(counter.size());
                for (Map.Entry<K, IntValue> entry : counter.entrySet()) {
                    list.add(new Count<K>(entry.getKey(), entry.getValue().value));
                }
                return list;
            }

        }

        class Count<K> {
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
