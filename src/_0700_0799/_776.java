package _0700_0799;

import model.TreeNode;

/**  
 * @ClassName: _776  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月15日  
 *  
 */
public class _776 {

    class Solution {
        public TreeNode[] splitBST(TreeNode root, int V) {
            if (root == null) {
                return new TreeNode[] {null, null};
            }
            if (V < root.val) {
                TreeNode[] res = splitBST(root.left, V);
                root.left = res[1];
                return new TreeNode[] {res[0], root};
            } else {
                TreeNode[] res = splitBST(root.right, V);
                root.right = res[0];
                return new TreeNode[] {root, res[1]};
            }
        }
    }

}
