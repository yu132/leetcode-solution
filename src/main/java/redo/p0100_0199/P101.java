package redo.p0100_0199;

import static org.junit.jupiter.api.Assertions.*;
import static redo.testUtil.BinaryTreeTestUtil.*;

import org.junit.Test;

import model.TreeNode;

/**  
 * @ClassName: P101  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class P101 {

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isSim(root.left, root.right);
        }

        public boolean isSim(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            } else if (left == null || right == null) {
                return false;
            }
            return left.val == right.val && isSim(left.left, right.right) && isSim(left.right, right.left);
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isSymmetric(build("1,2,2,3,4,4,3")));
        assertTrue(!s.isSymmetric(build("1,2,3")));
        assertTrue(!s.isSymmetric(build("1,2,2,null,3,null,3")));
    }

}
