package reredo.rrrd;

import model.TreeNode;

/**  
 * @ClassName: P101  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月24日  
 *  
 */
public class P101 {

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return helper(root.left, root.right);
        }

        boolean helper(TreeNode left, TreeNode right) {
            if (left == right) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            return helper(left.left, right.right)
                && helper(left.right, right.left);
        }
    }

}
