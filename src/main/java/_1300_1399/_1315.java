package _1300_1399;

import model.TreeNode;

/**  
 * @ClassName: _1315  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月10日  
 *  
 */
public class _1315 {

    class Solution {
        public int sumEvenGrandparent(TreeNode root) {
            return helper(root, 1, 1);
        }

        public int helper(TreeNode root, int p, int pp) {
            if (root == null) {
                return 0;
            }
            int count = (pp & 1) == 0 ? root.val : 0;
            count += helper(root.left, root.val, p);
            count += helper(root.right, root.val, p);

            return count;
        }
    }

}
