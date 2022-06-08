package redo.p1300_1399;

import model.TreeNode;

/**  
 * @ClassName: P1379  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月9日  
 *  
 */
public class P1379 {

    class Solution {
        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
            if (original == null) {
                return null;
            }
            if (original == target) {
                return cloned;
            }
            TreeNode left = getTargetCopy(original.left, cloned.left, target);
            if (left != null) {
                return left;
            }
            TreeNode right = getTargetCopy(original.right, cloned.right, target);
            if (right != null) {
                return right;
            }
            return null;
        }
    }

}
