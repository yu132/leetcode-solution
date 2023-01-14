package redo.mianshi.p04;

import model.TreeNode;

/**  
 * @ClassName: P04_08  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月9日  
 *  
 */
public class P04_08 {

    class Solution {

        TreeNode ans;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
            TreeNode q) {

            ans = null;

            helper(root, p, q);

            return ans;
        }

        public boolean helper(TreeNode node, TreeNode p, TreeNode q) {
            if (node == null) {
                return false;
            }
            boolean l = helper(node.left, p, q), r = helper(node.right, p, q),
                pp = node == p, qq = node == q;

            if ((l && r) || ((l || r) && (pp || qq))) {
                ans = node;
                return false;
            }
            return l || r || pp || qq;
        }
    }

}
