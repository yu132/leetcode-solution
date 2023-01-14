package old._0100_0199;

import model.TreeNode;

/**  
 * @ClassName: _156  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月16日  
 *  
 */
public class _156 {

    class Solution {
        public TreeNode upsideDownBinaryTree(TreeNode root) {
            return helper(root, null, null);
        }

        public TreeNode helper(TreeNode node, TreeNode father, TreeNode rightBro) {
            if (node == null) {
                return null;
            }
            TreeNode right = helper(node.right, null, null);
            node.right = father;
            TreeNode left = node.left;
            node.left = rightBro;
            return left != null ? helper(left, node, right) : node;
        }
    }

}
