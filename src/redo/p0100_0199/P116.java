package redo.p0100_0199;

import java.util.Deque;
import java.util.LinkedList;

/**  
 * @ClassName: P116  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月13日  
 *  
 */
public class P116 {

    class Solution {
        public Node connect(Node root) {

            if (root == null) {
                return null;
            }

            Deque<Node> queue = new LinkedList<>();

            queue.offer(root);

            int size = 0;

            Node next = null;

            while (!queue.isEmpty()) {

                if (size == 0) {
                    size = queue.size();
                    next = null;
                }

                Node node = queue.poll();
                node.next = next;

                if (node.right != null) {
                    queue.offer(node.right);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                next = node;

                --size;
            }

            return root;
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

}
