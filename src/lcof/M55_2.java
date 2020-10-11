package lcof;

import model.TreeNode;

/**  
 * @ClassName: M55_2  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月22日  
 *  
 */
public class M55_2 {

    class Solution {

        boolean f = true;

        public boolean isBalanced(TreeNode root) {
            helper(root);
            return f;
        }

        public int helper(TreeNode root) {
            if (!f) {
                return -1;
            }
            if (root == null) {
                return 0;
            }
            int left  = helper(root.left);
            int right = helper(root.right);
            if (Math.abs(left - right) > 1) {
                f = false;
                return -1;
            }
            return 1 + Math.max(left, right);
        }
    }

}
