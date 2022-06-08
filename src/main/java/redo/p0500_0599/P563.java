package redo.p0500_0599;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P563  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P563 {

    class Solution {
        int ans = 0;

        public int findTilt(TreeNode root) {
            sum(root);
            return ans;
        }

        public int sum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = sum(root.left);
            int right = sum(root.right);
            ans += Math.abs(left - right);
            return root.val + left + right;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.findTilt(BinaryTreeTestUtil.build("1,2,3")));
        s = new Solution();
        Assert.assertEquals(15, s.findTilt(BinaryTreeTestUtil.build("4,2,9,3,5,null,7")));
    }

}
