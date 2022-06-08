package lcof;

import model.TreeNode;

/**  
 * @ClassName: M54  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月22日  
 *  
 */
public class M54 {

    class Solution {

        int index = 0, ans, K;

        public int kthLargest(TreeNode root, int k) {
            K = k;
            helper(root);
            return ans;
        }

        public void helper(TreeNode root) {
            if (index == K) {
                return;
            }
            if (root == null) {
                return;
            }
            helper(root.right);
            ++index;
            if (index == K) {
                ans = root.val;
            }
            helper(root.left);
        }
    }

}
