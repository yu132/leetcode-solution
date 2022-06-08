package redo2012_05_29start;

import model.TreeNode;

/**  
 * @ClassName: P0124  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年6月6日  
 *  
 */
public class P0124 {

    class Solution {

        int ans = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            helper(root);
            return ans;
        }

        int helper(TreeNode node) {
            if (null == node) {
                return 0;
            }
            int l = Math.max(helper(node.left), 0),
                r = Math.max(helper(node.right), 0);
            ans = Math.max(ans, l + r + node.val);
            return Math.max(l, r) + node.val;
        }
    }

}
