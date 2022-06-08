package redo2012_05_29start;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import model.TreeNode;

/**  
 * @ClassName: P0103  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年5月30日  
 *  
 */
public class P0103 {

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (null == root) {
                return Collections.emptyList();
            }
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            int size = 0, level = -1;

            List<List<Integer>> ans = new ArrayList<>();
            LinkedList<Integer> nowLevel = null;

            while (!queue.isEmpty()) {
                if (size == 0) {
                    size = queue.size();
                    ++level;
                    nowLevel = new LinkedList<>();
                    ans.add(nowLevel);
                }

                TreeNode node = queue.poll();
                if ((level & 1) == 0) {
                    nowLevel.addLast(node.val);
                } else {
                    nowLevel.addFirst(node.val);
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
