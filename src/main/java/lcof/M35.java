package lcof;

import java.util.HashMap;
import java.util.Map;

/**  
 * @ClassName: M35  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月19日  
 *  
 */
public class M35 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val    = val;
            this.next   = null;
            this.random = null;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            Map<Node, Integer> map  = new HashMap<>();
            Node               node = head;
            while (node != null) {
                map.put(node, map.size());
                node = node.next;
            }
            int[] rmap = new int[map.size()];
            node = head;
            int index = 0;
            while (node != null) {
                rmap[index++] = map.getOrDefault(node.random, -1);
                node          = node.next;
            }
            Node newFakeHead = new Node(0);
            Node nBNode      = newFakeHead;
            node = head;
            Node[] arr = new Node[map.size()];
            index = 0;
            while (node != null) {
                Node newNode = new Node(node.val);
                arr[index++] = newNode;
                nBNode.next  = newNode;
                nBNode       = newNode;
                node         = node.next;
            }

            for (int i = 0; i < arr.length; ++i) {
                arr[i].random = rmap[i] == -1 ? null : arr[rmap[i]];
            }
            return newFakeHead.next;
        }
    }

}
