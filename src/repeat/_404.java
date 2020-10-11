package repeat;

import model.TreeNode;

/**  
 * @ClassName: _404  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月19日  
 *  
 */
public class _404 {

    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return helper(root, false);
        }

        public int helper(TreeNode root, boolean isLeft) {
            if (root.left == null && root.right == null) {
                return isLeft ? root.val : 0;
            }
            int sum = 0;
            if (root.left != null) {
                sum += helper(root.left, true);
            }
            if (root.right != null) {
                sum += helper(root.right, false);
            }
            return sum;
        }
    }

}
