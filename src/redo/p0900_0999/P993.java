package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P993  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月26日  
 *  
 */
public class P993 {

    class Solution {

        int xH = -1;
        int xP = -3;
        int yH = -2;
        int yP = -3;

        public boolean isCousins(TreeNode root, int x, int y) {
            helper(root, x, y, 0, -4);
            return xH == yH && xP != yP;
        }

        public void helper(TreeNode root, int x, int y, int H, int p) {
            if (root == null) {
                return;
            }
            if (root.val == x) {
                xH = H;
                xP = p;
            } else if (root.val == y) {
                yH = H;
                yP = p;
            } else {
                helper(root.left, x, y, H + 1, root.val);
                helper(root.right, x, y, H + 1, root.val);
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(false, s.isCousins(BinaryTreeTestUtil.build("[1,2,3,4]"), 4, 3));
        Assert.assertEquals(true, s.isCousins(BinaryTreeTestUtil.build("[1,2,3,null,4,null,5]"), 5, 4));
        Assert.assertEquals(false, s.isCousins(BinaryTreeTestUtil.build("[1,2,3,null,4]"), 2, 3));
        Assert.assertEquals(true, s.isCousins(BinaryTreeTestUtil.build(
            "[1,2,4,3,19,10,5,15,8,null,null,13,14,null,6,null,17,null,null,null,null,18,null,7,11,null,null,null,null,null,9,16,12,null,null,20]"),
            11, 17));

    }

}
