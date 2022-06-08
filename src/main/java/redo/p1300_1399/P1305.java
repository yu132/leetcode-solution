package redo.p1300_1399;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P1305  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月11日  
 *  
 */
public class P1305 {

    class Solution {
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            Deque<TreeNode> stack1 = new LinkedList<>(), stack2 = new LinkedList<>();
            pushAllLeftNode(root1, stack1);
            pushAllLeftNode(root2, stack2);

            List<Integer> ans = new ArrayList<>();
            while (!stack1.isEmpty() && !stack2.isEmpty()) {
                int num1 = stack1.peek().val, num2 = stack2.peek().val;

                if (num1 <= num2) {
                    ans.add(num1);
                    TreeNode node = stack1.pop();
                    pushAllLeftNode(node.right, stack1);
                } else {
                    ans.add(num2);
                    TreeNode node = stack2.pop();
                    pushAllLeftNode(node.right, stack2);
                }
            }
            while (!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                ans.add(node.val);
                pushAllLeftNode(node.right, stack1);
            }

            while (!stack2.isEmpty()) {
                TreeNode node = stack2.pop();
                ans.add(node.val);
                pushAllLeftNode(node.right, stack2);
            }
            return ans;
        }

        void pushAllLeftNode(TreeNode node, Deque<TreeNode> stack) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList(0, 1, 1, 2, 3, 4),
            s.getAllElements(BinaryTreeTestUtil.build("[2,1,4]"), BinaryTreeTestUtil.build("[1,0,3]")));

        Assert.assertEquals(Arrays.asList(-10, 0, 0, 1, 2, 5, 7, 10),
            s.getAllElements(BinaryTreeTestUtil.build("[0,-10,10]"), BinaryTreeTestUtil.build("[5,1,7,0,2]")));

        Assert.assertEquals(Arrays.asList(0, 1, 2, 5, 7),
            s.getAllElements(BinaryTreeTestUtil.build("[]"), BinaryTreeTestUtil.build("[5,1,7,0,2]")));

        Assert.assertEquals(Arrays.asList(-10, 0, 10),
            s.getAllElements(BinaryTreeTestUtil.build("[0,-10,10]"), BinaryTreeTestUtil.build("[]")));

        Assert.assertEquals(Arrays.asList(1, 1, 8, 8),
            s.getAllElements(BinaryTreeTestUtil.build("[1,null,8]"), BinaryTreeTestUtil.build("[8,1]")));

    }

}
