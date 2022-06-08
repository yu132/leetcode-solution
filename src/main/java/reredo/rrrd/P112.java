package reredo.rrrd;

import model.TreeNode;

/**  
 * @ClassName: P112  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月24日  
 *  
 */
public class P112 {

    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            targetSum -= root.val;
            if (root.left == null && root.right == null && targetSum == 0) {
                return true;
            }
            return hasPathSum(root.left, targetSum)
                || hasPathSum(root.right, targetSum);
        }
    }

}
