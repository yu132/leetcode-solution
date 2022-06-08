package redo.p0600_0699;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P671  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P671 {

    class Solution {
        public int findSecondMinimumValue(TreeNode root) {
            int ans = helper(root, root.val);
            return ans == root.val ? -1 : ans;
        }

        public int helper(TreeNode root, int parent) {
            if (root == null) {
                return parent;
            }
            if (root.val != parent) {
                return root.val;
            }
            int left = helper(root.left, parent);
            int right = helper(root.right, parent);
            if (root.val == left && root.val == right) {
                return parent;
            } else if (root.val == left) {
                return right;
            } else if (root.val == right) {
                return left;
            } else {
                return Math.min(left, right);
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(5, s.findSecondMinimumValue(BinaryTreeTestUtil.build("[2,2,5,null,null,5,7]")));
        Assert.assertEquals(-1, s.findSecondMinimumValue(BinaryTreeTestUtil.build("[2,2,2]")));
        Assert.assertEquals(2,
            s.findSecondMinimumValue(BinaryTreeTestUtil.build("[1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1]")));
        Assert.assertEquals(4, s.findSecondMinimumValue(BinaryTreeTestUtil.build("[1,1,1,1,5,1,4]")));
    }

}
