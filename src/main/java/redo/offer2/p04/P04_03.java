package redo.offer2.p04;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import model.ListNode;
import model.TreeNode;

/**  
 * @ClassName: P04_03  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月9日  
 *  
 */
public class P04_03 {

    class Solution {
        public ListNode[] listOfDepth(TreeNode tree) {

            if (tree == null) {
                return new ListNode[0];
            }

            List<ListNode> heads = new ArrayList<>();

            Deque<TreeNode> queue = new LinkedList<>();

            queue.offer(tree);

            int size = 0, level = -1;

            while (!queue.isEmpty()) {
                if (size == 0) {
                    size = queue.size();
                    ++level;
                    if (level == heads.size()) {
                        heads.add(new ListNode(-1));
                    }
                }
                TreeNode node = queue.poll();

                ListNode head = heads.get(level), n = new ListNode(node.val);
                n.next = head.next;
                head.next = n;

                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                --size;
            }

            ListNode[] ans = heads.toArray(new ListNode[0]);

            for (int i = 0; i < ans.length; ++i) {
                ans[i] = ans[i].next;
            }

            return ans;
        }
    }

}
