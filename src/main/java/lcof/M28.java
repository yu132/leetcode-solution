package lcof;

import model.TreeNode;

/**  
 * @ClassName: M28  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月14日  
 *  
 */
public class M28 {

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            } else {
                return helper(root.left, root.right);
            }
        }

        public boolean helper(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return true;
            }
            if (root1 == null || root2 == null) {
                return false;
            }
            if (root1.val != root2.val) {
                return false;
            }

            return helper(root1.left, root2.right) && helper(root1.right, root2.left);
        }
    }

}
