package old._0800_0899;

import model.TreeNode;

/**  
 * @ClassName: _865  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月6日  
 *  
 */
public class _865 {

    class Solution {

        TreeNode node;
        int max = 0;

        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            depth(root, 1);
            return node;
        }

        public int depth(TreeNode root, int depth) {
            if (root == null) {
                return depth - 1;
            }

            if (depth > max) {
                max = depth;
            }

            int left  = depth(root.left, depth + 1);
            int right = depth(root.right, depth + 1);

            if (left == right && left == max) {
                node = root;
            }

            return Math.max(left, right);
        }
    }

}
