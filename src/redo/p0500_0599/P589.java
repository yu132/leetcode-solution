package redo.p0500_0599;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**  
 * @ClassName: P589  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P589 {

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

    class Solution {
        public List<Integer> preorder(Node root) {
            if (root == null) {
                return Collections.emptyList();
            }
            List<Integer> ans = new ArrayList<>(100);
            Deque<Node> stack = new LinkedList<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                ans.add(node.val);
                for (int i = node.children.size() - 1; i >= 0; --i) {
                    stack.push(node.children.get(i));
                }
            }
            return ans;
        }
    }

}
