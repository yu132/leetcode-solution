package redo.p2600_2699;

import redo.testUtil.Arrs;

import java.util.LinkedList;
import java.util.Queue;

public class P2673 {

    class Solution {
        public int minIncrements(int n, int[] cost) {
            Queue<TNode> queue = new LinkedList<>();
            TNode root = new TNode(cost[0]);
//            root.sum = root.val;
            queue.offer(root);
            int max = 0;
            for (int i = 1; i < cost.length; i += 2) {
                TNode parent = queue.poll();
                TNode left = parent.left = new TNode(cost[i]);
                TNode right = parent.right = new TNode(cost[i + 1]);
                left.parent = right.parent = parent;
//                left.sum = parent.sum + left.val;
//                right.sum = parent.sum + right.sum;
//                max = Math.max(max, left.sum);
//                max = Math.max(max, right.sum);
                queue.offer(left);
                queue.offer(right);
            }
            int ans = 0;
            while (!queue.isEmpty()) {
                TNode node = queue.poll();
                ans += Math.abs(node.cLeft - node.cRight);
                int ll = node.val + Math.max(node.cLeft, node.cRight);
                if (node == root) {
                    break;
                }
                if (node == node.parent.left) {
                    node.parent.cLeft = ll;
                    queue.offer(node.parent);
                } else {
                    node.parent.cRight = ll;
                }
            }
            return ans;
        }

        class TNode {
            TNode left, right, parent;
            int val, cLeft, cRight;

            public TNode(int val) {
                this.val = val;
            }
        }
    }

    public static void main(String[] args) {
        new P2673().new Solution().minIncrements(7, Arrs.build("[1,5,2,2,3,3,1]"));
    }

}
