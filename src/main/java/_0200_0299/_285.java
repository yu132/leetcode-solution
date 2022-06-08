package _0200_0299;

import model.TreeNode;

/**  
 * @ClassName: _285  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月10日  
 *  
 */
public class _285 {

    class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            return helper(null, root, p);
        }

        public TreeNode helper(TreeNode before, TreeNode now, TreeNode p) {
            if (now == p) {
                if (now.right == null) {
                    return before;
                }
                now = now.right;
                while (now.left != null) {
                    now = now.left;
                }
                return now;
            } else {
                if (p.val < now.val) {
                    return helper(now, now.left, p);
                } else {
                    return helper(before, now.right, p);
                }
            }
        }
    }

}
