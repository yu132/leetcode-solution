package redo.offer;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P36  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P36 {

    class Solution {

        Node pre, head;

        public Node treeToDoublyList(Node root) {

            if (root == null) {
                return null;
            }

            inorder(root);

            pre.right = head;
            head.left = pre;

            return head;
        }

        public void inorder(Node node) {

            if (node == null) {
                return;
            }

            inorder(node.left);

            if (pre == null) {
                head = node;
            } else {
                pre.right = node;
                node.left = pre;
            }

            pre = node;

            inorder(node.right);
        }

    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };



    @Test
    public void test() {
        Solution s = new Solution();

        Node _4 = new Node(4);
        Node _2 = new Node(2);
        Node _1 = new Node(1);
        Node _3 = new Node(3);
        Node _5 = new Node(5);

        _4.left = _2;
        _4.right = _5;
        _2.left = _1;
        _2.right = _3;

        Node head = s.treeToDoublyList(_4), node = head;

        do {
            System.out.println(node.val);
            node = node.right;
        } while (head != node);
    }

}
