package reredo.rrrd;

import model.TreeNode;

/**  
 * @ClassName: P226  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月24日  
 *  
 */
public class P226 {

    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode right = root.right;
            root.right = invertTree(root.left);
            root.left = invertTree(right);
            return root;
        }
    }

}
