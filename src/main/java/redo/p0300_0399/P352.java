package redo.p0300_0399;

import java.util.*;

public class P352 {

    class SummaryRanges {

        TreeMap<Integer, Node> treeMap = new TreeMap<>();
        HashSet<Integer> visited = new HashSet<>();

        int[][] cache = null;

        boolean diff = true;

        class Node {
            int start;
            int end;

            public Node(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }

        public SummaryRanges() {

        }

        public void addNum(int value) {
            if (visited.contains(value)) {
                return;
            }
            treeMap.put(value, new Node(value, value + 1));
            visited.add(value);
            diff = true;
        }

        public int[][] getIntervals() {
            if (!diff) {
                return cache;
            }
            List<Integer> keys = new ArrayList<>(treeMap.keySet());
            for (Integer key : keys) {
                if (!treeMap.containsKey(key)) {
                    continue;
                }
                Node node = treeMap.get(key);
                while (treeMap.containsKey(node.end)) {
                    Node next = treeMap.remove(node.end);
                    node.end = next.end;
                }
            }
            cache = new int[treeMap.size()][2];
            int i = 0;
            for (Map.Entry<Integer, Node> entry : treeMap.entrySet()) {
                cache[i][0] = entry.getKey();
                cache[i][1] = entry.getValue().end - 1;
                ++i;
            }
            diff = false;
            return cache;
        }
    }

}
