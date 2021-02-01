package redo.p0800_0899;

import model.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P814  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月30日  
 *  
 */
public class P814 {

    class Solution {
        public TreeNode pruneTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);
            if (root.left == null && root.right == null && root.val == 0) {
                return null;
            }
            return root;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[1,null,0,null,1]",
            s.pruneTree(BinaryTreeTestUtil.build("[1,null,0,0,1]")).toString());

        Assert.assertEquals("[1,null,1,null,1]", s
            .pruneTree(BinaryTreeTestUtil.build("[1,0,1,0,0,0,1]")).toString());

        Assert.assertEquals("[1,1,0,1,1,null,1]",
            s.pruneTree(BinaryTreeTestUtil.build("[1,1,0,1,1,0,1,0]"))
                .toString());
    }

}
