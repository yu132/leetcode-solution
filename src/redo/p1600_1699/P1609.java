package redo.p1600_1699;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P1609  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月3日  
 *  
 */
public class P1609 {

    class Solution {
        public boolean isEvenOddTree(TreeNode root) {
            Deque<TreeNode> queue = new LinkedList<>();

            boolean isOdd = false;
            queue.offer(root);
            int size = 0, lastNum = -1;

            while (!queue.isEmpty()) {
                if (size == 0) {
                    size = queue.size();
                    isOdd = !isOdd;
                    if (isOdd) {
                        lastNum = queue.peek().val - 1;
                    } else {
                        lastNum = queue.peek().val + 1;
                    }
                }
                TreeNode node = queue.poll();
                if (isOdd) {
                    if (node.val <= lastNum || node.val % 2 == 0) {
                        return false;
                    }
                } else {
                    if (node.val >= lastNum || node.val % 2 != 0) {
                        return false;
                    }
                }
                lastNum = node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                --size;
            }

            return true;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.isEvenOddTree(BinaryTreeTestUtil.build("[1,10,4,3,null,7,9,12,8,6,null,null,2]")));
        Assert.assertEquals(false, s.isEvenOddTree(BinaryTreeTestUtil.build("[5,4,2,3,3,7]")));
        Assert.assertEquals(false, s.isEvenOddTree(BinaryTreeTestUtil.build("[5,9,1,3,5,7]")));
        Assert.assertEquals(true, s.isEvenOddTree(BinaryTreeTestUtil.build("[1]")));
        Assert.assertEquals(true,
            s.isEvenOddTree(BinaryTreeTestUtil.build("[11,8,6,1,3,9,11,30,20,18,16,12,10,4,2,17]")));
    }

}
