package redo.p0500_0599;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import model.TreeNode;

/**  
 * @ClassName: P515  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月28日  
 *  
 */
public class P515 {

    class Solution {
        public List<Integer> largestValues(TreeNode root) {

            if (root == null) {
                return Collections.emptyList();
            }

            Deque<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            List<Integer> ans = new ArrayList<>();

            int size = 0, level = -1, max = Integer.MIN_VALUE;

            while (true) {
                if (size == 0) {
                    size = queue.size();
                    ++level;
                    if (level != 0) {
                        ans.add(max);
                    }
                    max = Integer.MIN_VALUE;
                    if (size == 0) {
                        break;
                    }
                }
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
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
