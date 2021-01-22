package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P998  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月20日  
 *  
 */
public class P998 {

    class Solution {
        public TreeNode insertIntoMaxTree(TreeNode root, int val) {

            if (root == null) {
                return new TreeNode(val);
            }

            if (val > root.val) {
                TreeNode node = new TreeNode(val);
                node.left = root;
                return node;
            }

            root.right = insertIntoMaxTree(root.right, val);

            return root;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[5,4,null,1,3,null,null,2]",
            s.insertIntoMaxTree(BinaryTreeTestUtil.build("[4,1,3,null,null,2]"), 5).toString());
        Assert.assertEquals("[5,2,4,null,1,null,3]",
            s.insertIntoMaxTree(BinaryTreeTestUtil.build("[5,2,4,null,1]"), 3).toString());
        Assert.assertEquals("[5,2,4,null,1,3]",
            s.insertIntoMaxTree(BinaryTreeTestUtil.build("[5,2,3,null,1]"), 4).toString());
    }

}
