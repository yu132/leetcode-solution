package reredo;

import model.TreeNode;

/**  
 * @ClassName: P0543  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月4日  
 *  
 */
public class P0543 {

    class Solution {

        int max = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            helper(root);
            return Math.max(max - 1, 0);
        }

        int helper(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int left = helper(node.left), right = helper(node.right);
            max = Math.max(max, 1 + left + right);
            return 1 + Math.max(left, right);
        }
    }

}
