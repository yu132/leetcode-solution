package redo.offer;

import java.util.HashMap;
import java.util.Map;

/**  
 * @ClassName: P35  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P35 {

    class Solution {
        public Node copyRandomList(Node head) {
            return newNode(head, new HashMap<>());
        }

        public Node newNode(Node old, Map<Node, Node> oldNweMapping) {
            if (old == null) {
                return null;
            }
            if (oldNweMapping.containsKey(old)) {
                return oldNweMapping.get(old);
            }
            Node newNode = new Node(old.val);
            oldNweMapping.put(old, newNode);// 提前发布，以防循环依赖
            newNode.next = newNode(old.next, oldNweMapping);
            newNode.random = newNode(old.random, oldNweMapping);
            return newNode;
        }
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
