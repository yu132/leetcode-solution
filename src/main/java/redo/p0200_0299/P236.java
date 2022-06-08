package redo.p0200_0299;

import model.TreeNode;

/**  
 * @ClassName: P236  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P236 {

    class Solution {

        TreeNode ans;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
            TreeNode q) {
            helper(root, p, q);
            return ans;
        }

        public boolean helper(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return false;
            }

            boolean l = helper(root.left, p, q), r = helper(root.right, p, q),
                pp = root == p, qq = root == q;

            if ((l && r) || ((l || r) && (pp || qq))) {
                ans = root;
                return false;
            }

            return l || r || pp || qq;
        }
    }

}
