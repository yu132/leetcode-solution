package redo.p1000_1099;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P1080  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月17日  
 *  
 */
public class P1080 {

    class Solution {
        public TreeNode sufficientSubset(TreeNode root, int limit) {
            if (root == null) {
                return null;
            }
            limit -= root.val;
            if (root.left == null && root.right == null) {
                if (limit <= 0) {
                    return root;
                } else {
                    return null;
                }
            }
            root.left = sufficientSubset(root.left, limit);
            root.right = sufficientSubset(root.right, limit);
            if (root.left == root.right) {
                return null;
            }
            return root;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[1,2,3,4,null,null,7,8,9,null,14]", BinaryTreeTestUtil
            .toStr(s.sufficientSubset(BinaryTreeTestUtil.build("[1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14]"), 1)));

        Assert.assertEquals("[5,4,8,11,null,17,4,7,null,null,null,5]", BinaryTreeTestUtil
            .toStr(s.sufficientSubset(BinaryTreeTestUtil.build("[5,4,8,11,null,17,4,7,1,null,null,5,3]"), 22)));

        Assert.assertEquals("[]",
            BinaryTreeTestUtil.toStr(s.sufficientSubset(BinaryTreeTestUtil.build("[5,-6,-6]"), 0)));

    }

}
