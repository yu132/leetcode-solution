package lcci.M04;

import model.TreeNode;

/**  
 * @ClassName: M04_05  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月1日  
 *  
 */
public class M04_05 {

    class Solution {
        public boolean isValidBST(TreeNode root) {
            return helper(root, (long)Integer.MIN_VALUE - 1, (long)Integer.MAX_VALUE + 1);
        }

        public boolean helper(TreeNode root, long min, long max) {
            if (root == null) {
                return true;
            }
            if (!(root.val > min && root.val < max)) {
                return false;
            }
            return helper(root.left, min, root.val) && helper(root.right, root.val, max);
        }
    }

}
