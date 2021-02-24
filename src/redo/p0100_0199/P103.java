package redo.p0100_0199;

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
 * @date 2021年2月23日  
 *  
 */
public class P103 {

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

            if (root == null) {
                return Collections.emptyList();
            }

            Deque<TreeNode> deque = new LinkedList<>();

            deque.offerFirst(root);

            int size = 0, level = -1;

            List<List<Integer>> ans = new ArrayList<>();

            while (!deque.isEmpty()) {
                if (size == 0) {
                    size = deque.size();
                    ++level;
                    ans.add(new ArrayList<>());
                }
                if ((level & 1) == 0) {
                    TreeNode node = deque.pollFirst();
                    ans.get(level).add(node.val);
                    if (node.left != null) {
                        deque.offerLast(node.left);
                    }
                    if (node.right != null) {
                        deque.offerLast(node.right);
                    }
                } else {
                    TreeNode node = deque.pollLast();
                    ans.get(level).add(node.val);
                    if (node.right != null) {
                        deque.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        deque.offerFirst(node.left);
                    }
                }
                --size;
            }
            return ans;
        }
    }

}
