package redo.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import model.TreeNode;

/**  
 * @ClassName: P32_2  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P32_2 {

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {

            if (root == null) {
                return Collections.emptyList();
            }

            List<List<Integer>> ans = new ArrayList<>();

            Deque<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            int level = -1, size = 0;

            while (!queue.isEmpty()) {
                if (size == 0) {
                    ++level;
                    size = queue.size();
                }
                TreeNode node = queue.poll();
                if (ans.size() <= level) {
                    ans.add(new ArrayList<>());
                }
                ans.get(level).add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                --size;
            }

            return ans;
        }
    }


}
