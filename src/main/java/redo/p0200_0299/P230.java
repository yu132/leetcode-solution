package redo.p0200_0299;

import model.TreeNode;

/**  
 * @ClassName: P230  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月28日  
 *  
 */
public class P230 {

    class Solution {

        int count = 0, ans;

        public int kthSmallest(TreeNode root, int k) {
            inorder(root, k);
            return ans;
        }

        void inorder(TreeNode node, int k) {
            if (node == null) {
                return;
            }
            inorder(node.left, k);
            ++count;
            if (count > k) {
                return;
            }
            ans = node.val;
            inorder(node.right, k);
        }
    }

}
