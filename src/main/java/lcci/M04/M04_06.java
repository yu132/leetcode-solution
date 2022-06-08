package lcci.M04;

import model.TreeNode;

/**  
 * @ClassName: M04_06  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月1日  
 *  
 */
public class M04_06 {

    class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if (root == p) {
                if (root.right == null) {
                    return null;
                } else {
                    root = root.right;
                    while (root.left != null) {
                        root = root.left;
                    }
                    return root;
                }
            } else if (root.val > p.val) {
                TreeNode ans = inorderSuccessor(root.left, p);
                if (ans == null) {
                    return root;
                } else {
                    return ans;
                }
            } else {// root.val < p.val
                TreeNode ans = inorderSuccessor(root.right, p);
                if (ans == null) {
                    return null;
                } else {
                    return ans;
                }
            }
        }
    }

}
