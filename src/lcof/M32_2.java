package lcof;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import model.TreeNode;

/**  
 * @ClassName: M32_2  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月18日  
 *  
 */
public class M32_2 {

    class Solution {

        class Node {
            TreeNode node;
            int level;

            public Node(TreeNode root, int level) {
                super();
                this.node  = root;
                this.level = level;
            }
        }

        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }

            Deque<Node> queue = new LinkedList<>();

            queue.addLast(new Node(root, 0));

            int                 nowLevel = -1;

            List<List<Integer>> ans      = new ArrayList<>();

            while (!queue.isEmpty()) {
                Node node = queue.removeFirst();
                if (node.level != nowLevel) {
                    nowLevel = node.level;
                    ans.add(new ArrayList<>());
                }
                ans.get(nowLevel).add(node.node.val);
                if (node.node.left != null) {
                    queue.addLast(new Node(node.node.left, node.level + 1));
                }
                if (node.node.right != null) {
                    queue.addLast(new Node(node.node.right, node.level + 1));
                }
            }

            return ans;
        }
    }

}
