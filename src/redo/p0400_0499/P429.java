package redo.p0400_0499;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**  
 * @ClassName: P429  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月16日  
 *  
 */
public class P429 {

    class Solution {
        public List<List<Integer>> levelOrder(Node root) {

            if (root == null) {
                return Collections.emptyList();
            }

            Deque<Node> queue = new LinkedList<>();

            queue.offer(root);

            List<List<Integer>> ans = new ArrayList<>();

            int size = 0, level = -1;

            while (!queue.isEmpty()) {
                if (size == 0) {
                    ++level;
                    size = queue.size();
                    ans.add(new ArrayList<>());
                }

                Node node = queue.poll();

                ans.get(level).add(node.val);

                for (Node child : node.children) {
                    queue.offer(child);
                }

                --size;
            }

            return ans;
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

}
