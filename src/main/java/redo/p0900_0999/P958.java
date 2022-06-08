package redo.p0900_0999;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P958  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月21日  
 *  
 */
public class P958 {

    class Solution {

        public boolean isCompleteTree(TreeNode root) {
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean notFull = false;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    if (notFull) {
                        return false;
                    }
                    queue.offer(node.left);
                } else {
                    notFull = true;
                }
                if (node.right != null) {
                    if (notFull) {
                        return false;
                    }
                    queue.offer(node.right);
                } else {
                    notFull = true;
                }
            }
            return true;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.isCompleteTree(BinaryTreeTestUtil.build("[1,2,3,4,5,6]")));
        Assert.assertEquals(false, s.isCompleteTree(BinaryTreeTestUtil.build("[1,2,3,4,5,null,7]")));
    }

}
