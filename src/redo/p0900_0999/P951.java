package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P951  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月21日  
 *  
 */
public class P951 {

    class Solution {
        public boolean flipEquiv(TreeNode root1, TreeNode root2) {
            if (root1 == root2) {
                return true;
            }
            if (root1 == null || root2 == null) {
                return false;
            }
            if (root1.val != root2.val) {
                return false;
            }
            return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
                || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.flipEquiv(BinaryTreeTestUtil.build("[1,2,3,4,5,6,null,null,null,7,8]"),
            BinaryTreeTestUtil.build("[1,3,2,null,6,4,5,null,null,null,null,8,7]")));
    }

}
