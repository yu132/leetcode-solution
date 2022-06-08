package reredo.rrrd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import model.TreeNode;

/**  
 * @ClassName: P103  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月24日  
 *  
 */
public class P103 {

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

            if (root == null) {
                return Collections.emptyList();
            }

            List<List<Integer>> ans = new ArrayList<>();

            Deque<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            int level = -1, size = 0;

            LinkedList<Integer> list = null;

            while (!queue.isEmpty()) {
                if (size == 0) {
                    size = queue.size();
                    ++level;
                    list = new LinkedList<>();
                    ans.add(list);
                }

                TreeNode node = queue.poll();

                if ((level & 1) == 0) {
                    list.addLast(node.val);
                } else {
                    list.addFirst(node.val);
                }

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
