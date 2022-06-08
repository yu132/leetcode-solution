package redo.p1400_1499;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P1448  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月7日  
 *  
 */
public class P1448 {

    class Solution {
        public int goodNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return helper(root, root.val);
        }

        public int helper(TreeNode node, int max) {
            if (node == null) {
                return 0;
            }
            int count = node.val >= max ? 1 : 0;
            count += helper(node.left, Math.max(max, node.val));
            count += helper(node.right, Math.max(max, node.val));
            return count;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.goodNodes(BinaryTreeTestUtil.build("[3,1,4,3,null,1,5]")));
        Assert.assertEquals(3, s.goodNodes(BinaryTreeTestUtil.build("[3,3,null,4,2]")));
        Assert.assertEquals(1, s.goodNodes(BinaryTreeTestUtil.build("[3]")));
    }

}
