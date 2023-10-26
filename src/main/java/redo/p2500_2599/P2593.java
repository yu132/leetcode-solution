package redo.p2500_2599;

import redo.testUtil.Arrs;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class P2593 {

    class Solution {
        public long findScore(int[] nums) {
            PriorityQueue<Node> nodes = new PriorityQueue<>(Comparator
                    .comparingInt(Node::getVal)
                    .thenComparing(Node::getIndex));

            HashSet<Node> set = new HashSet<>();

            if (nums.length == 1) {
                return nums[0];
            }

            Node a = new Node(nums[0], 0);
            Node b = new Node(nums[1], 1);
            a.next = b;
            b.prev = a;
            nodes.add(a);

            for (int i = 1; i < nums.length - 1; ++i) {
                Node next = new Node(nums[i + 1], i + 1);
                b.next = next;
                next.prev = b;
                a = b;
                b = next;
                nodes.add(a);
            }

            nodes.add(b);

            long point = 0;
            while (!nodes.isEmpty()) {
                Node node = nodes.poll();
                if (set.contains(node)) {
                    continue;
                }
                point += node.val;
                if (null != node.prev) {
                    set.add(node.prev);
                }
                if (null != node.next) {
                    set.add(node.next);
                }
            }

            return point;
        }

        class Node {
            int val;
            int index;
            Node prev, next;

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

    public static void main(String[] args) {
        new P2593().new Solution().findScore(Arrs.build("[2,1,3,4,5,2]"));
    }

}
