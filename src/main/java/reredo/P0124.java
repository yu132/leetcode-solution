package reredo;

import model.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P124  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月3日  
 *  
 */
public class P0124 {

    class Solution {

        int max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            helper(root);
            return max;
        }

        int helper(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int left = helper(node.left), right = helper(node.right);
            int val =
                Math.max(Math.max(left, right), Math.max(left + right, 0));
            max = Math.max(max, val + node.val);
            return Math.max(0, Math.max(right, left)) + node.val;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(42, s
            .maxPathSum(BinaryTreeTestUtil.build("[-10,9,20,null,null,15,7]")));
    }
}
