package redo.offer2.p04;

import model.TreeNode;

/**  
 * @ClassName: P04_05  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月9日  
 *  
 */
public class P04_05 {

    class Solution {
        public boolean isValidBST(TreeNode root) {
            return helper(root, Integer.MIN_VALUE - 1L, Integer.MAX_VALUE + 1L);
        }

        public boolean helper(TreeNode node, long min, long max) {
            if (node == null) {
                return true;
            }
            if (node.val <= min || node.val >= max) {
                return false;
            }
            return helper(node.left, min, node.val)
                && helper(node.right, node.val, max);
        }
    }

}
