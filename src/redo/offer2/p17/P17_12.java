package redo.offer2.p17;

import model.TreeNode;

/**  
 * @ClassName: P17_12  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月16日  
 *  
 */
public class P17_12 {

    class Solution {
        public TreeNode convertBiNode(TreeNode root) {
            return helper(root, null);
        }

        public TreeNode helper(TreeNode root, TreeNode next) {
            if (root == null) {
                return next;
            }
            TreeNode head = helper(root.left, root);
            root.left = null;
            root.right = helper(root.right, next);
            return head;
        }
    }

}
