package redo.p0100_0199;

import model.TreeNode;

/**  
 * @ClassName: P129  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月23日  
 *  
 */
public class P129 {

    class Solution {
        public int sumNumbers(TreeNode root) {
            return helper(root, 0);
        }

        int helper(TreeNode node, int val) {
            if (node == null) {
                return 0;
            }
            val = val * 10 + node.val;
            if (node.left == null && node.right == null) {
                return val;
            }
            return helper(node.left, val) + helper(node.right, val);
        }
    }

}
