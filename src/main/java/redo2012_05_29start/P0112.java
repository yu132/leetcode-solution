package redo2012_05_29start;

import model.TreeNode;

/**  
 * @ClassName: P0112  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年6月5日  
 *  
 */
public class P0112 {

    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            targetSum -= root.val;
            if (root.left == root.right) {
                return targetSum == 0;
            }

            return hasPathSum(root.left, targetSum)
                || hasPathSum(root.right, targetSum);
        }
    }

}
