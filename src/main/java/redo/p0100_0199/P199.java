package redo.p0100_0199;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import model.TreeNode;

/**  
 * @ClassName: P199  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P199 {

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }

            Deque<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            List<Integer> ans = new ArrayList<>();

            int level = -1, size = 0;

            while (!queue.isEmpty()) {
                if (size == 0) {
                    size = queue.size();
                    ++level;
                    ans.add(0);
                }

                TreeNode node = queue.poll();

                ans.set(level, node.val);

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
