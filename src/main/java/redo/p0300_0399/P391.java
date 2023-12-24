package redo.p0300_0399;

import redo.testUtil.Arrs;

import java.util.*;

public class P391 {

    class Solution {
        public boolean isRectangleCover(int[][] rectangles) {
            int xMin = Integer.MAX_VALUE, xMax = Integer.MIN_VALUE;
            int yMin = Integer.MAX_VALUE, yMax = Integer.MIN_VALUE;

            Counter<Node> counter = new Counter<>();

            long sumArea = 0;
            for (int i = 0; i < rectangles.length; ++i) {
                int x1 = rectangles[i][0], y1 = rectangles[i][1];
                int x2 = rectangles[i][2], y2 = rectangles[i][3];
                sumArea += (long) Math.abs(x1 - x2) * Math.abs(y1 - y2);
                xMin = Math.min(xMin, Math.min(x1, x2));
                xMax = Math.max(xMax, Math.max(x1, x2));
                yMin = Math.min(yMin, Math.min(y1, y2));
                yMax = Math.max(yMax, Math.max(y1, y2));
                counter.plus1(new Node(x1, y1));
                counter.plus1(new Node(x1, y2));
                counter.plus1(new Node(x2, y1));
                counter.plus1(new Node(x2, y2));
            }

            if (sumArea != (long) Math.abs(xMin - xMax) * Math.abs(yMin - yMax)) {
                return false;
            }
            Counter.IntValue a = counter.counter.remove(new Node(xMin, yMin));
            Counter.IntValue b = counter.counter.remove(new Node(xMin, yMax));
            Counter.IntValue c = counter.counter.remove(new Node(xMax, yMin));
            Counter.IntValue d = counter.counter.remove(new Node(xMax, yMax));
            if (a == null || a.value != 1 || b == null || b.value != 1 || c == null || c.value != 1 || d == null || d.value != 1) {
                return false;
            }
            for (Map.Entry<Node, Counter<Node>.IntValue> entry : counter.counter.entrySet()) {
                if (entry.getValue().value != 2 && entry.getValue().value != 4) {
                    return false;
                }
            }
            return true;
        }
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
            return x + y;
        }
    }

    class Counter<K> {

        Map<K, IntValue> counter;

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

    public static void main(String[] args) {
        boolean ans = new P391().new Solution().isRectangleCover(Arrs.build2D("[[0,0,1,1],[0,0,1,1],[1,1,2,2],[1,1,2,2]]"));
        System.out.println(ans);
    }


}
