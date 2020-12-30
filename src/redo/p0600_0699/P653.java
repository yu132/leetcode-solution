package redo.p0600_0699;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P653  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P653 {

    class Solution {
        public boolean findTarget(TreeNode root, int k) {
            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            Set<Integer> set = new HashSet<>();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node == null) {
                    continue;
                }
                if (set.contains(k - node.val)) {
                    return true;
                }
                set.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
            return false;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.findTarget(BinaryTreeTestUtil.build("5,3,6,2,4,null,7"), 9));
        Assert.assertEquals(false, s.findTarget(BinaryTreeTestUtil.build("5,3,6,2,4,null,7"), 28));
    }
}
