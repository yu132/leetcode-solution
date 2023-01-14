package old._0300_0399;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import model.TreeNode;

/**  
 * @ClassName: _314  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月10日  
 *  
 */
public class _314 {

    class Solution {

        class Node {
            TreeNode node;
            int distince;

            public Node(TreeNode node, int distince) {
                super();
                this.node     = node;
                this.distince = distince;
            }
        }

        public List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>>         ans   = new ArrayList<>();

            Map<Integer, List<Integer>> temp  = new TreeMap<>();

            LinkedList<Node>            queue = new LinkedList<>();

            queue.addLast(new Node(root, 0));

            while (!queue.isEmpty()) {
                Node node = queue.removeFirst();
                if (node.node == null) {
                    continue;
                }
                temp.computeIfAbsent(node.distince, (x) -> new ArrayList<>()).add(node.node.val);
                queue.addLast(new Node(node.node.left, node.distince - 1));
                queue.addLast(new Node(node.node.right, node.distince + 1));
            }

            for (List<Integer> list : temp.values()) {
                ans.add(list);
            }

            return ans;
        }

    }

}
