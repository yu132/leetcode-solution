package redo.p0100_0199;

import static org.junit.Assert.*;

import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P110  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class P110 {

    class Solution {
        public boolean isBalanced(TreeNode root) {
            return getHeightAndCheckBalance(root) != -1;
        }

        private int getHeightAndCheckBalance(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int heightLeft = getHeightAndCheckBalance(root.left);
            int heightRight = getHeightAndCheckBalance(root.right);
            if (heightLeft == -1 || heightRight == -1) {
                return -1;
            }
            if (Math.abs(heightLeft - heightRight) > 1) {
                return -1;
            }
            return 1 + Math.max(heightLeft, heightRight);
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isBalanced(BinaryTreeTestUtil.build("[3,9,20,null,null,15,7]")));
        assertTrue(!s.isBalanced(BinaryTreeTestUtil.build("[1,2,2,3,3,null,null,4,4]")));
        assertTrue(s.isBalanced(BinaryTreeTestUtil.build("[]")));
    }

}
