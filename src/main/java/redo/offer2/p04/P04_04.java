package redo.offer2.p04;

import model.TreeNode;

/**  
 * @ClassName: P04_04  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月9日  
 *  
 */
public class P04_04 {

    class Solution {

        boolean isBalanced;

        public boolean isBalanced(TreeNode root) {
            isBalanced = true;
            depth(root);
            return isBalanced;
        }

        public int depth(TreeNode node) {

            if (!isBalanced || node == null) {
                return 0;
            }

            int left = depth(node.left), right = depth(node.right);

            if (Math.abs(left - right) > 1) {
                isBalanced = false;
                return 0;
            }

            return 1 + Math.max(left, right);
        }
    }

}
