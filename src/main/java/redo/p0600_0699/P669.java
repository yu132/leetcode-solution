package redo.p0600_0699;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P669  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P669 {

    class Solution {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) {
                return null;
            }
            if (root.val < low) {
                return trimBST(root.right, low, high);
            } else if (root.val > high) {
                return trimBST(root.left, low, high);
            }
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[1,null,2]", BinaryTreeTestUtil.toStr(s.trimBST(BinaryTreeTestUtil.build("1,0,2"), 1, 2)));
        Assert.assertEquals("[3,2,null,1]",
            BinaryTreeTestUtil.toStr(s.trimBST(BinaryTreeTestUtil.build("[3,0,4,null,2,null,null,1]"), 1, 3)));

    }

}
