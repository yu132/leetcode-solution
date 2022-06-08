package _0600_0699;

import model.TreeNode;

/**  
 * @ClassName: _623  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月19日  
 *  
 */
public class _623 {

    class Solution {
        public TreeNode addOneRow(TreeNode root, int v, int d) {
            if (d == 1) {
                TreeNode node = new TreeNode(v);
                node.left = root;
                return node;
            } else {
                helper(root, v, d, 1);
                return root;
            }
        }

        public void helper(TreeNode root, int v, int d, int depth) {
            if (root == null) {
                return;
            }
            if (depth == d - 1) {
                TreeNode node = new TreeNode(v);
                node.left  = root.left;
                root.left  = node;

                node       = new TreeNode(v);
                node.right = root.right;
                root.right = node;
            } else {
                helper(root.left, v, d, depth + 1);
                helper(root.right, v, d, depth + 1);
            }
        }
    }

}
