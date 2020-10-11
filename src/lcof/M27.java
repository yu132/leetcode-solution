package lcof;

import model.TreeNode;

/**  
 * @ClassName: M27  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月14日  
 *  
 */
public class M27 {

    class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode temp = root.left;
            root.left  = mirrorTree(root.right);
            root.right = mirrorTree(temp);
            return root;
        }
    }

}
