package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P1315  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月10日  
 *  
 */
public class P1315 {

    class Solution {
        public int sumEvenGrandparent(TreeNode root) {
            return helper(root, 1, 1);
        }

        public int helper(TreeNode node, int p, int pp) {
            if (node == null) {
                return 0;
            }
            int sum = pp % 2 == 0 ? node.val : 0;
            sum += helper(node.left, node.val, p);
            sum += helper(node.right, node.val, p);
            return sum;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(18,
            s.sumEvenGrandparent(BinaryTreeTestUtil.build("[6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]")));
    }

}
