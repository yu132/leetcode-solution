package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P1325  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月10日  
 *  
 */
public class P1325 {

    class Solution {
        public TreeNode removeLeafNodes(TreeNode root, int target) {
            if (root == null) {
                return null;
            }
            root.left = removeLeafNodes(root.left, target);
            root.right = removeLeafNodes(root.right, target);
            if (root.left == null && root.right == null && root.val == target) {
                return null;
            }
            return root;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[1,null,3,null,4]",
            BinaryTreeTestUtil.toStr(s.removeLeafNodes(BinaryTreeTestUtil.build("[1,2,3,2,null,2,4]"), 2)));
        Assert.assertEquals("[1,3,null,null,2]",
            BinaryTreeTestUtil.toStr(s.removeLeafNodes(BinaryTreeTestUtil.build("[1,3,3,3,2]"), 3)));
        Assert.assertEquals("[1]",
            BinaryTreeTestUtil.toStr(s.removeLeafNodes(BinaryTreeTestUtil.build("[1,2,null,2,null,2]"), 2)));
        Assert.assertEquals("[]", BinaryTreeTestUtil.toStr(s.removeLeafNodes(BinaryTreeTestUtil.build("[1,1,1]"), 1)));
        Assert.assertEquals("[1,2,3]",
            BinaryTreeTestUtil.toStr(s.removeLeafNodes(BinaryTreeTestUtil.build("[1,2,3]"), 1)));

    }

}
