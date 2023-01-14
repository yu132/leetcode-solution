package old._0200_0299;

import model.TreeNode;

/**  
 * @ClassName: _270  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月26日  
 *  
 */
public class _270 {

    class Solution {
        public int closestValue(TreeNode root, double target) {
            return helper(root, target, Double.MAX_VALUE, -1);
        }

        public int helper(TreeNode root, double target, double min, int ans) {
            if (root == null) {
                return ans;
            }
            double dif = Math.abs(root.val - target);
            if (dif == 0) {
                return root.val;
            } else if (target > root.val) {
                return dif < min ? helper(root.right, target, dif, root.val) : helper(root.right, target, min, ans);
            } else {
                return dif < min ? helper(root.left, target, dif, root.val) : helper(root.left, target, min, ans);
            }
        }
    }

}
