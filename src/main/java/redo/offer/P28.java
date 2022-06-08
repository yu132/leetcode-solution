package redo.offer;

import model.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P28  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P28 {

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return helper(root.left, root.right);
        }

        public boolean helper(TreeNode a, TreeNode b) {
            if (a == null && b == null) {
                return true;
            }
            if (a == null || b == null) {
                return false;
            }
            return a.val == b.val && helper(a.left, b.right)
                && helper(a.right, b.left);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true,
            s.isSymmetric(BinaryTreeTestUtil.build("[1,2,2,3,4,4,3]")));
        Assert.assertEquals(false,
            s.isSymmetric(BinaryTreeTestUtil.build("[1,2,2,null,3,null,3]")));

    }
}
