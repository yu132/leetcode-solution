package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P965  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月25日  
 *  
 */
public class P965 {

    class Solution {
        public boolean isUnivalTree(TreeNode root) {
            return helper(root, root.val);
        }

        public boolean helper(TreeNode root, int val) {
            if (root == null) {
                return true;
            }
            return root.val == val && helper(root.left, val) && helper(root.right, val);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.isUnivalTree(BinaryTreeTestUtil.build("[1,1,1,1,1,null,1]")));
        Assert.assertEquals(false, s.isUnivalTree(BinaryTreeTestUtil.build("[2,2,2,5,2]")));

    }

}
