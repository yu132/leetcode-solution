package redo.p2000_2099;

import java.util.PriorityQueue;

public class P2054 {

    class Solution {
        public int maxTwoEvents(int[][] events) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            for (int[] event : events) {
                pq.offer(new Node(event[2], event[0], true));
                pq.offer(new Node(event[2], event[1], false));
            }
            int max = 0, ans = 0;
            while (!pq.isEmpty()) {
                Node node = pq.poll();
                if (node.start) {
                    ans = Math.max(max + node.index, ans);
                } else {
                    max = Math.max(max, node.index);
                }
            }
            return ans;
        }

        class Node implements Comparable<Node> {
            int index;
            int time;
            boolean start;

            public Node(int index, int time, boolean start) {
                this.index = index;
                this.time = time;
                this.start = start;
            }

            @Override
            public int compareTo(Node o) {
                if (time != o.time) {
                    return Integer.compare(time, o.time);
                }
                if (o.start) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }

}
