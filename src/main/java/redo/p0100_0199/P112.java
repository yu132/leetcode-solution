package redo.p0100_0199;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P112  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P112 {

    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null) {
                return sum == root.val;
            }
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true,
            s.hasPathSum(BinaryTreeTestUtil.build("5,4,8,11,null,13,4,7,2,null,null,null,2"), 22));
    }

}
