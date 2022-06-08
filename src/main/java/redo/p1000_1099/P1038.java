package redo.p1000_1099;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P1038  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月19日  
 *  
 */
public class P1038 {

    class Solution {
        public TreeNode bstToGst(TreeNode root) {
            int preSum = 0;

            Deque<TreeNode> stack = new LinkedList<>();

            TreeNode ret = root;

            while (root != null) {
                stack.push(root);
                root = root.right;
            }

            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                preSum += node.val;
                node.val = preSum;
                TreeNode left = node.left;
                while (left != null) {
                    stack.push(left);
                    left = left.right;
                }
            }

            return ret;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]", BinaryTreeTestUtil
            .toStr(s.bstToGst(BinaryTreeTestUtil.build("[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]"))));
        Assert.assertEquals("[1,null,1]", BinaryTreeTestUtil.toStr(s.bstToGst(BinaryTreeTestUtil.build("[0,null,1]"))));
        Assert.assertEquals("[3,3,2]", BinaryTreeTestUtil.toStr(s.bstToGst(BinaryTreeTestUtil.build("[1,0,2]"))));
        Assert.assertEquals("[7,9,4,10]", BinaryTreeTestUtil.toStr(s.bstToGst(BinaryTreeTestUtil.build("[3,2,4,1]"))));
    }

}
