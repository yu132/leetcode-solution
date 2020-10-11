package lcci.M04;

import model.TreeNode;

/**  
 * @ClassName: M04_04  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月29日  
 *  
 */
public class M04_04 {

    class Solution {
        public boolean isBalanced(TreeNode root) {
            return helper(root) != -1;
        }

        public int helper(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int l = helper(root.left);
            int r = helper(root.right);
            if (l == -1 || r == -1) {
                return -1;
            }
            if (Math.abs(l - r) > 1) {
                return -1;
            }
            return Math.max(l, r) + 1;
        }
    }

}
