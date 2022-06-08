package _1300_1399;

import model.TreeNode;

/**  
 * @ClassName: _1325  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月10日  
 *  
 */
public class _1325 {

    class Solution {
        public TreeNode removeLeafNodes(TreeNode root, int target) {
            if (root == null) {
                return null;
            }
            root.left  = removeLeafNodes(root.left, target);
            root.right = removeLeafNodes(root.right, target);
            if (root.left == null && root.right == null && root.val == target) {
                return null;
            }
            return root;
        }
    }

}
