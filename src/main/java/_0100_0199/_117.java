package _0100_0199;

/**  
 * @ClassName: _117  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月18日  
 *  
 */
public class _117 {

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
            val   = _val;
            left  = _left;
            right = _right;
            next  = _next;
        }
    };

    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            if (root.left != null && root.right != null) {
                root.left.next = root.right;
            }
            if (root.left != null && root.right == null) {
                root.left.next = getNext(root.next);
            }
            if (root.right != null) {
                root.right.next = getNext(root.next);
            }
            connect(root.right);
            connect(root.left);
            return root;
        }

        public Node getNext(Node node) {
            if (node == null) {
                return null;
            }
            if (node.left != null) {
                return node.left;
            }
            if (node.right != null) {
                return node.right;
            }
            return getNext(node.next);
        }
    }

}
