package _0200_0299;

import model.TreeNode;

/**  
 * @ClassName: _250  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月8日  
 *  
 */
public class _250 {

    class Solution {
        public int countUnivalSubtrees(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return helper(root)[0];
        }

        public Integer[] helper(TreeNode root) {
            boolean common = true;
            int     sum    = 0;

            if (root.left != null) {
                Integer[] left = helper(root.left);
                if (left[1] == null || left[1] != root.val) {
                    common = false;
                }
                sum += left[0];
            }
            if (root.right != null) {
                Integer[] right = helper(root.right);
                if (right[1] == null || right[1] != root.val) {
                    common = false;
                }
                sum += right[0];
            }
            return new Integer[] {common ? sum + 1 : sum, common ? root.val : null};
        }
    }

}
