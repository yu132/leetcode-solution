package redo.p2000_2099;

import java.util.LinkedList;

public class P2059 {

    class Solution {
        public int minimumOperations(final int[] nums, int start, int goal) {

            LinkedList<Node> queue = new LinkedList<>();

            boolean[] visited = new boolean[1001];

            queue.offer(new Node(start, 0));

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                if (node.value == goal) {
                    return node.step;
                }
                if (node.value < 0 || node.value > 1000) {
                    continue;
                }
                if (visited[node.value]) {
                    continue;
                }
                visited[node.value] = true;
                for (int num : nums) {
                    queue.offer(new Node(node.value + num, node.step + 1));
                    queue.offer(new Node(node.value - num, node.step + 1));
                    queue.offer(new Node(node.value ^ num, node.step + 1));
                }
            }

            return -1;
        }

        class Node {
            int value;
            int step;

            public Node(int value, int step) {
                this.value = value;
                this.step = step;
            }
        }
    }

}
