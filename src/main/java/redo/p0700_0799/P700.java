package redo.p0700_0799;

import model.TreeNode;

/**  
 * @ClassName: P700  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P700 {

    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) {
                return null;
            }
            if (root.val == val) {
                return root;
            }
            if (root.val < val) {
                return searchBST(root.right, val);
            }
            return searchBST(root.left, val);
        }
    }

}
