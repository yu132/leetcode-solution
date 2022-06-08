package redo2012_05_29start;

import model.TreeNode;

/**  
 * @ClassName: P0236  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年6月5日  
 *  
 */
public class P0236 {

    class Solution {

        TreeNode ans;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
            TreeNode q) {
            helper(root, p, q);
            return ans;
        }

        boolean helper(TreeNode root, TreeNode p, TreeNode q) {
            if (null == root) {
                return false;
            }
            boolean ll = helper(root.left, p, q), rr = helper(root.right, p, q),
                pp = root == p, qq = root == q;
            if ((ll && rr) || ((ll || rr) && (pp || qq))) {
                ans = root;
            }
            return ll || rr || pp || qq;
        }
    }

}
