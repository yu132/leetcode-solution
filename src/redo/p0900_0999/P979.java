package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P979  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月20日  
 *  
 */
public class P979 {

    class Solution {

        int ans;

        public int distributeCoins(TreeNode root) {
            ans = 0;
            helper(root);
            return ans;
        }

        public int helper(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int l = helper(node.left), r = helper(node.right);
            ans += Math.abs(l) + Math.abs(r);
            int n = node.val - 1;
            return n + l + r;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.distributeCoins(BinaryTreeTestUtil.build("[3,0,0]")));
        Assert.assertEquals(3, s.distributeCoins(BinaryTreeTestUtil.build("[0,3,0]")));
        Assert.assertEquals(2, s.distributeCoins(BinaryTreeTestUtil.build("[1,0,2]")));
        Assert.assertEquals(4, s.distributeCoins(BinaryTreeTestUtil.build("[1,0,0,null,3]")));
    }

}
