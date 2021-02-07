package redo.offer;

import model.TreeNode;

/**  
 * @ClassName: P54  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P54 {

    class Solution {

        int K;
        int ans;

        public int kthLargest(TreeNode root, int k) {
            K = k;
            dfs(root);
            return ans;
        }

        public void dfs(TreeNode node) {
            if (node == null || K == 0) {
                return;
            }
            dfs(node.right);
            --K;
            if (K == 0) {
                ans = node.val;
            }
            dfs(node.left);
        }
    }

}
