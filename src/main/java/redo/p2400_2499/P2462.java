package redo.p2400_2499;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P2462 {

    class Solution {
        public long totalCost(int[] costs, int k, int candidates) {
            int left = candidates, right = costs.length - candidates - 1;
            PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(Node::getVal)
                    .thenComparing(Node::getIndex));
            if (candidates * 2 >= costs.length) {
                for (int i = 0; i < costs.length; ++i) {
                    pq.offer(new Node(costs[i], i));
                }
            } else {
                for (int i = 0; i < left; ++i) {
                    pq.offer(new Node(costs[i], i));
                }
                for (int i = right + 1; i < costs.length; ++i) {
                    pq.offer(new Node(costs[i], i));
                }
            }
            long cost = 0;
            for (int i = 0; i < k; ++i) {
                Node node = pq.poll();
                cost += node.val;
                if (left <= right) {
                    if (node.index < left) {
                        pq.offer(new Node(costs[left], left));
                        ++left;
                    } else {
                        pq.offer(new Node(costs[right], right));
                        --right;
                    }
                }
            }
            return cost;
        }

        class Node {
            int val, index;

            public Node(int val, int index) {
                this.val = val;
                this.index = index;
            }

            public int getVal() {
                return val;
            }

            public int getIndex() {
                return index;
            }
        }
    }


}
