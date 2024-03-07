package redo.p1300_1399;

import java.util.*;

public class P1345 {

    class Solution {
        public int minJumps(int[] arr) {
            boolean[] visitedIdx = new boolean[arr.length];
            HashSet<Integer> visitedNum = new HashSet<>();

            ListMap<Integer, Integer> numMapIndexes = new ListMap<>();

            for (int i = 0; i < arr.length; ++i) {
                numMapIndexes.add(arr[i], i);
            }

            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node(0, 0));

            while (true) {
                Node node = queue.poll();
                int idx = node.idx;
                if (idx == -1) {
                    continue;
                }
                if (idx == arr.length - 1) {
                    return node.dis;
                }
                if (visitedIdx[idx]) {
                    continue;
                }
                visitedIdx[idx] = true;
                queue.offer(new Node(idx + 1, node.dis + 1));
                queue.offer(new Node(idx - 1, node.dis + 1));
                if (!visitedNum.contains(arr[idx])) {
                    visitedNum.add(arr[idx]);
                    for (int idxInner : numMapIndexes.get(arr[idx])) {
                        queue.offer(new Node(idxInner, node.dis + 1));
                    }
                }
            }
        }

        class Node {
            int idx;
            int dis;

            public Node(int idx, int dis) {
                this.idx = idx;
                this.dis = dis;
            }
        }

        class ListMap<K, E> {

            Map<K, List<E>> map = new HashMap<>();

            public void add(K key, E element) {
                get(key).add(element);
            }

            public void remove(K key, E element) {
                get(key).remove(element);
            }

            public List<E> get(K key) {
                return map.computeIfAbsent(key, (x) -> new ArrayList<>());
            }

        }
    }

}
