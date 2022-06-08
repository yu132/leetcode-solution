package redo2012_05_29start;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import model.TreeNode;
import redo.Util.math.ArrangementNumber;

/**  
 * @ClassName: P0199  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年6月5日  
 *  
 */
public class P0199 {

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {

            if (root == null) {
                return Collections.emptyList();
            }

            List<Integer> ans = new ArrayList<>();

            Deque<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            int size = 0, level = -1;

            while (!queue.isEmpty()) {
                if (size == 0) {
                    size = queue.size();
                    ++level;
                }
                TreeNode node = queue.poll();
                if (ans.size() == level) {
                    ans.add(node.val);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
                if (null != node.left) {
                    queue.offer(node.left);
                }
                --size;
            }
            return ans;
        }
    }

}
