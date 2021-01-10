package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P1372  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月9日  
 *  
 */
public class P1372 {

    class Solution {
        public int longestZigZag(TreeNode root) {
            int count = helper(root, true);
            count = Math.max(count, helper(root, false));
            count = Math.max(count, helper2(root.left, true));
            count = Math.max(count, helper2(root.right, false));
            return count - 1;
        }

        public int helper2(TreeNode root, boolean isLeftChild) {
            if (root == null) {
                return 0;
            }
            int count = 0;
            if (isLeftChild) {
                count = helper(root, true);
            } else {
                count = helper(root, false);
            }
            count = Math.max(count, helper2(root.left, true));
            count = Math.max(count, helper2(root.right, false));
            return count;
        }

        public int helper(TreeNode root, boolean left) {
            if (root == null) {
                return 0;
            }
            if (left) {
                return 1 + helper(root.left, false);
            } else {
                return 1 + helper(root.right, true);
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3,
            s.longestZigZag(BinaryTreeTestUtil.build("[1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]")));
        Assert.assertEquals(4, s.longestZigZag(BinaryTreeTestUtil.build("[1,1,1,null,1,null,null,1,1,null,1]")));
        Assert.assertEquals(0, s.longestZigZag(BinaryTreeTestUtil.build("[1]")));
    }

}
