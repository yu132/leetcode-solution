package redo.p2500_2599;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P2542 {

    class Solution {
        public long maxScore(int[] nums1, int[] nums2, int k) {
            Node[] nodes = new Node[nums1.length];
            for (int i = 0; i < nums1.length; ++i) {
                nodes[i] = new Node(nums1[i], nums2[i]);
            }
            Arrays.sort(nodes, Comparator.<Node>comparingInt(a -> a.n2).reversed());
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            long sumN1 = 0;
            long minN2 = Integer.MAX_VALUE;
            long ans = 0;

            for (Node node : nodes) {
                if (pq.size() < k) {
                    pq.offer(node.n1);
                    sumN1 += node.n1;
                    minN2 = node.n2;
                    if (pq.size() == k) {
                        ans = Math.max(ans, sumN1 * minN2);
                    }
                } else {
                    Integer min = pq.peek();
                    if (node.n1 > min) {
                        sumN1 = sumN1 - min + node.n1;
                        minN2 = node.n2;
                        pq.poll();
                        pq.offer(node.n1);
                        ans = Math.max(ans, sumN1 * minN2);
                    }
                }
            }

            return ans;
        }

        class Node {
            int n1, n2;

            public Node(int n1, int n2) {
                this.n1 = n1;
                this.n2 = n2;
            }
        }
    }

}
