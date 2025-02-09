package redo.p2900_2999;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P2998 {

    class Solution {
        public int minimumOperationsToMakeEqual(int x, int y) {
            if (y >= x) {
                return y - x;
            }
            int[] minDis = new int[x + 12];
            Arrays.fill(minDis, -1);

            PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dis));
            pq.offer(new Node(x, 0));
            while (true) {
                Node min = pq.poll();
                if (min.val < 0 || min.val > x + 11) {
                    continue;
                }
                if (min.val == y) {
                    return min.dis;
                }
                if (minDis[min.val] != -1) {
                    continue;
                }
                minDis[min.val] = min.dis;
                if (min.val % 11 == 0) {
                    pq.offer(new Node(min.val / 11, min.dis + 1));
                }
                if (min.val % 5 == 0) {
                    pq.offer(new Node(min.val / 5, min.dis + 1));
                }
                pq.offer(new Node(min.val - 1, min.dis + 1));
                pq.offer(new Node(min.val + 1, min.dis + 1));
            }
        }

        class Node {
            int val;
            int dis;

            public Node(int val, int dis) {
                this.val = val;
                this.dis = dis;
            }
        }
    }

}
