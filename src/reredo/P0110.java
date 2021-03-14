package reredo;

import model.TreeNode;

/**  
 * @ClassName: P0110  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月4日  
 *  
 */
public class P0110 {

    class Solution {

        boolean isBalanced = true;

        public boolean isBalanced(TreeNode root) {
            helper(root);
            return isBalanced;
        }

        int helper(TreeNode node) {
            if (!isBalanced) {
                return -100;
            }
            if (node == null) {
                return 0;
            }
            int left = helper(node.left), right = helper(node.right);
            if (Math.abs(left - right) > 1) {
                isBalanced = false;
                return -100;
            }
            return 1 + Math.max(left, right);
        }
    }

}
