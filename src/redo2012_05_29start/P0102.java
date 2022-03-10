package redo2012_05_29start;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import model.TreeNode;

/**  
 * @ClassName: P0102  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年5月30日  
 *  
 */
public class P0102 {

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {

            if (root == null) {
                return Collections.emptyList();
            }

            Deque<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            List<List<Integer>> ans = new ArrayList<>();

            int size = 0, level = -1;

            while (!queue.isEmpty()) {
                if (size == 0) {
                    size = queue.size();
                    ++level;
                    ans.add(new ArrayList<>());
                }
                TreeNode node = queue.poll();
                ans.get(level).add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                --size;
            }
            return ans;
        }
    }

}
