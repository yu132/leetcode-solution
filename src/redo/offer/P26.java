package redo.offer;

import model.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P26  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P26 {

    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null && B == null) {
                return true;
            }
            if (A == null || B == null) {
                return false;
            }
            if (isPartSame(A, B)) {
                return true;
            }
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        public boolean isPartSame(TreeNode A, TreeNode B) {
            if (A == null && B == null) {
                return true;
            }
            if (B == null) {
                return true;
            }
            if (A == null) {
                return false;
            }
            return A.val == B.val && isPartSame(A.left, B.left)
                && isPartSame(A.right, B.right);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(false,
            s.isSubStructure(BinaryTreeTestUtil.build("[1,2,3]"),
                BinaryTreeTestUtil.build("[3,1]")));

        Assert.assertEquals(true,
            s.isSubStructure(BinaryTreeTestUtil.build("[3,4,5,1,2]"),
                BinaryTreeTestUtil.build("[4,1]")));
    }

}
