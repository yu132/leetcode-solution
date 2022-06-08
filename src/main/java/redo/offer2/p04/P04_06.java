package redo.offer2.p04;

import model.TreeNode;

/**  
 * @ClassName: P04_06  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月9日  
 *  
 */
public class P04_06 {

    class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            return helper(root, p, null);
        }

        public TreeNode helper(TreeNode node, TreeNode p, TreeNode next) {
            if (node == null) {
                return null;
            }
            if (node == p) {
                if (node.right != null) {
                    TreeNode min = node.right;
                    while (min.left != null) {
                        min = min.left;
                    }
                    return min;
                }
                return next;
            }
            TreeNode left = helper(node.left, p, node);
            if (left != null) {
                return left;
            }
            TreeNode right = helper(node.right, p, next);
            return right;
        }
    }

}
