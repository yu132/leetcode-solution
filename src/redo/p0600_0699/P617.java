package redo.p0600_0699;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P617  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P617 {

    class Solution {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) {
                return null;
            }

            if (t1 == null) {
                return t2;
            } else if (t2 == null) {
                return t1;
            }

            TreeNode node = new TreeNode(getVal(t1) + getVal(t2));

            node.left = mergeTrees(t1.left, t2.left);
            node.right = mergeTrees(t1.right, t2.right);

            return node;
        }

        public int getVal(TreeNode node) {
            if (node == null) {
                return 0;
            }
            return node.val;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[3,4,5,5,4,null,7]", BinaryTreeTestUtil
            .toStr(s.mergeTrees(BinaryTreeTestUtil.build("1,3,2,5"), BinaryTreeTestUtil.build("2,1,3,null,4,null,7"))));
    }

}
