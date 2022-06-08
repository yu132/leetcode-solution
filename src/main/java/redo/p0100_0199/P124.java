package redo.p0100_0199;

import model.TreeNode;

/**  
 * @ClassName: P124  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P124 {

    class Solution {

        int max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            helper(root);
            return max;
        }

        int helper(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = Math.max(0, helper(root.left)),
                right = Math.max(0, helper(root.right));
            int val = root.val + left + right;
            max = Math.max(max, val);
            return root.val + Math.max(left, right);
        }
    }

}
