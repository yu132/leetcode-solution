package lcof;

import model.TreeNode;

/**  
 * @ClassName: M68  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月25日  
 *  
 */
public class M68_1 {

    class Solution {

        private TreeNode ans;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            helper(root, p, q);
            return ans;
        }

        public int helper(TreeNode root, TreeNode p, TreeNode q) {

            if (root == null) {
                return -1;
            }

            int l = helper(root.left, p, q);
            int r = helper(root.right, p, q);

            if (l == 2 || r == 2) {
                return 2;
            }

            boolean pf = l == 0 || r == 0 || root == p;
            boolean qf = l == 1 || r == 1 || root == q;

            if (pf && qf) {
                ans = root;
                return 2;
            } else if (pf) {
                return 0;
            } else if (qf) {
                return 1;
            } else {
                return -1;
            }
        }
    }

}
