package redo.p1000_1099;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P1026  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月19日  
 *  
 */
public class P1026 {

    class Solution {
        public int maxAncestorDiff(TreeNode root) {
            return helper(root, root.val, root.val);
        }

        public int helper(TreeNode node, int max, int min) {

            if (node == null) {
                return 0;
            }

            int ans = Math.max(max - node.val, node.val - min);

            max = Math.max(max, node.val);
            min = Math.min(min, node.val);

            ans = Math.max(ans, helper(node.left, max, min));
            ans = Math.max(ans, helper(node.right, max, min));

            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(7, s.maxAncestorDiff(BinaryTreeTestUtil.build("[8,3,10,1,6,null,14,null,null,4,7,13]")));
        Assert.assertEquals(3, s.maxAncestorDiff(BinaryTreeTestUtil.build("[1,null,2,null,0,3]")));

    }

}
