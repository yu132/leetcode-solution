package old._0200_0299;

import model.TreeNode;

/**  
 * @ClassName: _298  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月10日  
 *  
 */
public class _298 {

    class Solution {
        public int longestConsecutive(TreeNode root) {
            return helper(root, Integer.MIN_VALUE, 0);
        }

        public int helper(TreeNode node, int father, int len) {
            if (node == null) {
                return len;
            }
            int lenNext;
            if (node.val == father + 1) {
                ++len;
                lenNext = len;
            } else {
                lenNext = 1;
            }
            return Math.max(len, Math.max(helper(node.left, node.val, lenNext), helper(node.right, node.val, lenNext)));
        }
    }

}
