package redo.offer;

import model.TreeNode;

/**  
 * @ClassName: P55  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P55_2 {

    class Solution {

        boolean isBalanced;

        public boolean isBalanced(TreeNode root) {
            isBalanced = true;
            depth(root);
            return isBalanced;
        }

        int depth(TreeNode root) {
            if (root == null || !isBalanced) {
                return 0;
            }
            int left = depth(root.left), right = depth(root.right);
            if (Math.abs(left - right) > 1) {
                isBalanced = false;
            }
            return 1 + Math.max(left, right);
        }
    }

}
