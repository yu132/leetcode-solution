package lcof;

import model.TreeNode;

/**  
 * @ClassName: M26  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月14日  
 *  
 */
public class M26 {

    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null) {
                return false;
            }
            return isSame(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        public boolean isSame(TreeNode A, TreeNode B) {
            if (A == null && B == null) {
                return true;
            } else if (A == null) {
                return false;
            } else if (B == null) {
                return true;
            }

            if (A.val != B.val) {
                return false;
            }

            return isSame(A.left, B.left) && isSame(A.right, B.right);
        }
    }

}
