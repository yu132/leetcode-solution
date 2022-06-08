package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P897  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月23日  
 *  
 */
public class P897 {

    class Solution {
        public TreeNode increasingBST(TreeNode root) {
            return helper(root, null);
        }

        public TreeNode helper(TreeNode node, TreeNode parent) {
            TreeNode min;
            if (node.left != null) {
                min = helper(node.left, node);
                node.left = null;
            } else {
                min = node;
            }
            if (node.right != null) {
                node.right = helper(node.right, parent);
            } else {
                node.right = parent;
            }

            return min;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true,
            BinaryTreeTestUtil.same(
                BinaryTreeTestUtil.build("[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]"),
                s.increasingBST(BinaryTreeTestUtil.build("[5,3,6,2,4,null,8,1,null,null,null,7,9]"))));
    }
}
