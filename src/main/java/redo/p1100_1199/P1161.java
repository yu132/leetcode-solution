package redo.p1100_1199;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P1161  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月14日  
 *  
 */
public class P1161 {

    class Solution {
        public int maxLevelSum(TreeNode root) {
            Deque<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            int sum = Integer.MIN_VALUE, size = 0, max = Integer.MIN_VALUE, level = 0, maxLevel = 0;
            while (!queue.isEmpty()) {
                if (size == 0) {
                    if (sum > max) {
                        max = sum;
                        maxLevel = level;
                    }
                    ++level;
                    size = queue.size();
                    sum = 0;
                }
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                --size;
            }

            if (sum > max) {
                max = sum;
                maxLevel = level;
            }

            return maxLevel;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.maxLevelSum(BinaryTreeTestUtil.build("[1,7,0,7,-8,null,null]")));
        Assert.assertEquals(2,
            s.maxLevelSum(BinaryTreeTestUtil.build("[989,null,10250,98693,-89388,null,null,null,-32127]")));

        Assert.assertEquals(2, s.maxLevelSum(BinaryTreeTestUtil.build("[1,2,3]")));

        Assert.assertEquals(3, s.maxLevelSum(BinaryTreeTestUtil.build("[-100,-200,-300,-20,-5,-10,null]")));

    }

}
