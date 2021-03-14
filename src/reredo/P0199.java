package reredo;

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
 * @date 2021年3月2日  
 *  
 */
public class P0199 {

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {

            if (root == null) {
                return Collections.emptyList();
            }

            Deque<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            List<Integer> list = new ArrayList<>();

            int level = -1, size = 0;

            while (!queue.isEmpty()) {
                if (size == 0) {
                    size = queue.size();
                    ++level;
                }

                TreeNode node = queue.poll();

                if (level >= list.size()) {
                    list.add(node.val);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                --size;
            }

            return list;
        }
    }

}
