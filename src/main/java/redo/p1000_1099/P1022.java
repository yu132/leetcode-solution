package redo.p1000_1099;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P1022  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月26日  
 *  
 */
public class P1022 {

    class Solution {
        public int sumRootToLeaf(TreeNode root) {
            return helper(root, 0);
        }

        public int helper(TreeNode root, int parent) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return parent << 1 | root.val;
            }
            return helper(root.left, parent << 1 | root.val) + helper(root.right, parent << 1 | root.val);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(22, s.sumRootToLeaf(BinaryTreeTestUtil.build("[1,0,1,0,1,0,1]")));
        Assert.assertEquals(0, s.sumRootToLeaf(BinaryTreeTestUtil.build("[0]")));
        Assert.assertEquals(1, s.sumRootToLeaf(BinaryTreeTestUtil.build("[1]")));
        Assert.assertEquals(3, s.sumRootToLeaf(BinaryTreeTestUtil.build("[1,1]")));
    }

}
