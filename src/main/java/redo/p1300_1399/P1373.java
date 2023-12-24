package redo.p1300_1399;

import model.TreeNode;

public class P1373 {

    class Solution {
        int max = 0;

        public int maxSumBST(TreeNode root) {
            helper(root);
            return max;
        }

        public int[] helper(TreeNode node) {
            if (null == node.left && null == node.right) {
                max = Math.max(max, node.val);
                return new int[]{node.val, node.val, node.val};
            }
            if (null == node.right) {
                int[] ll = helper(node.left);
                if (null == ll || ll[1] >= node.val) {
                    return null;
                }
                int sum = ll[2] + node.val;
                max = Math.max(max, sum);
                return new int[]{ll[0], node.val, sum};
            }
            if (null == node.left) {
                int[] rr = helper(node.right);
                if (null == rr || node.val >= rr[0]) {
                    return null;
                }
                int sum = rr[2] + node.val;
                max = Math.max(max, sum);
                return new int[]{node.val, rr[1], sum};
            }
            int[] ll = helper(node.left);
            int[] rr = helper(node.right);
            if (null == ll || null == rr || ll[1] >= node.val || node.val >= rr[0]) {
                return null;
            }
            int sum = ll[2] + rr[2] + node.val;
            max = Math.max(max, sum);
            return new int[]{ll[0], rr[1], sum};
        }

    }

}
