package redo.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import model.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P32_1  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P32_1 {

    class Solution {
        public int[] levelOrder(TreeNode root) {

            if (root == null) {
                return new int[0];
            }

            List<Integer> ans = new ArrayList<>();

            Deque<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                ans.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            return toArray(ans);
        }

        public int[] toArray(List<Integer> list) {
            int[] ans = new int[list.size()];
            for (int i = 0; i < ans.length; ++i) {
                ans[i] = list.get(i);
            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {3, 9, 20, 15, 7},
            s.levelOrder(BinaryTreeTestUtil.build("[3,9,20,null,null,15,7]")));
    }

}
