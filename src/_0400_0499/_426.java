package _0400_0499;

/**  
 * @ClassName: _426  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月12日  
 *  
 */
public class _426 {

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val   = _val;
            left  = _left;
            right = _right;
        }
    };

    class Solution {

        private Node head, now;

        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }
            inorer(root);
            head.left = now;
            now.right = head;
            return head;
        }

        public void inorer(Node root) {
            if (root == null) {
                return;
            }
            inorer(root.left);

            if (head == null) {
                head = root;
                now  = root;
            } else {
                now.right = root;
                root.left = now;
                now       = root;
            }

            inorer(root.right);
        }
    }

    public static void main(String[] args) {
        Node _4 = new Node(4);
        Node _2 = new Node(2);
        Node _5 = new Node(5);
        Node _1 = new Node(1);
        Node _3 = new Node(3);
        _4.left  = _2;
        _4.right = _5;
        _2.left  = _1;
        _2.right = _3;
        new _426().new Solution().treeToDoublyList(_4);
    }

}
