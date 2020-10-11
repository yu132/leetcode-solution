package lcci.M04;

import model.TreeNode;

/**  
 * @ClassName: M04_10  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月2日  
 *  
 */
public class M04_10 {

    class Solution {
        public boolean checkSubTree(TreeNode t1, TreeNode t2) {
            return helper(t1, t2, true);
        }

        public boolean helper(TreeNode t1, TreeNode t2, boolean isRoot) {
            if (t1 == null) {
                if (t2 == null) {
                    return true;
                } else {
                    return false;
                }
            }

            if (t2 == null) {
                return false;
            }

            if (t1.val == t2.val) {
                if (helper(t1.left, t2.left, false) && helper(t1.right, t2.right, false)) {
                    return true;
                }
            }

            if (isRoot) {
                return helper(t1.left, t2, true) || helper(t1.right, t2, true);
            } else {
                return false;
            }
        }
    }

}
