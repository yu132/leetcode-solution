package lcof;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: M36  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月19日  
 *  
 */
public class M36 {

    class Node {
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
        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }
            List<Node> inOrder = new ArrayList<>();
            inOrder(inOrder, root);
            if (inOrder.size() == 1) {
                root.left  = root;
                root.right = root;
                return root;
            }
            inOrder.get(0).left                   = inOrder.get(inOrder.size() - 1);
            inOrder.get(0).right                  = inOrder.get(1);
            inOrder.get(inOrder.size() - 1).left  = inOrder.get(inOrder.size() - 2);
            inOrder.get(inOrder.size() - 1).right = inOrder.get(0);
            for (int i = 1; i < inOrder.size() - 1; ++i) {
                inOrder.get(i).left  = inOrder.get(i - 1);
                inOrder.get(i).right = inOrder.get(i + 1);
            }
            return inOrder.get(0);
        }

        public void inOrder(List<Node> inOrder, Node node) {
            if (node == null) {
                return;
            }
            inOrder(inOrder, node.left);
            inOrder.add(node);
            inOrder(inOrder, node.right);
        }
    }

}
