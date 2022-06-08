package _1000_1099;

import model.TreeNode;

/**  
 * @ClassName: _1026  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月9日  
 *  
 */
public class _1026 {

    class Solution {
        public int maxAncestorDiff(TreeNode root) {
            return helper(root, root.val, root.val);
        }

        public int helper(TreeNode root, int maxVal, int minVal) {
            if (root == null) {
                return 0;
            }
            int num   = Math.max(Math.abs(maxVal - root.val), Math.abs(minVal - root.val));
            int left  = helper(root.left, Math.max(maxVal, root.val), Math.min(minVal, root.val));
            int right = helper(root.right, Math.max(maxVal, root.val), Math.min(minVal, root.val));

            return Math.max(Math.max(left, right), num);
        }
    }

}
