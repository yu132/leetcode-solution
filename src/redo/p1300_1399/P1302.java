package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P1302  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月11日  
 *  
 */
public class P1302 {

    class Solution {

        int maxLevel = 0, sum = 0;

        public int deepestLeavesSum(TreeNode root) {
            helper(root, 0);
            return sum;
        }

        public void helper(TreeNode node, int level) {
            if (node == null) {
                return;
            }
            if (level > maxLevel) {
                maxLevel = level;
                sum = node.val;
            } else if (level == maxLevel) {
                sum += node.val;
            }
            helper(node.left, level + 1);
            helper(node.right, level + 1);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(15,
            s.deepestLeavesSum(BinaryTreeTestUtil.build("[1,2,3,4,5,null,6,7,null,null,null,null,8]")));
    }
}
