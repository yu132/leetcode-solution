package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P938  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月25日  
 *  
 */
public class P938 {

    class Solution {
        public int rangeSumBST(TreeNode root, int low, int high) {
            if (root == null) {
                return 0;
            }
            if (root.val < low) {
                return rangeSumBST(root.right, low, high);
            } else if (root.val > high) {
                return rangeSumBST(root.left, low, high);
            }
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(32, s.rangeSumBST(BinaryTreeTestUtil.build("[10,5,15,3,7,null,18]"), 7, 15));
        Assert.assertEquals(23, s.rangeSumBST(BinaryTreeTestUtil.build("[10,5,15,3,7,13,18,1,null,6]"), 6, 10));

    }

}
