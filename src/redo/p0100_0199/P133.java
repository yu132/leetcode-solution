package redo.p0100_0199;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**  
 * @ClassName: P133  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月13日  
 *  
 */
public class P133 {

    class Solution {
        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }
            Map<Node, Node> newMap = new HashMap<>();
            return clone(node, newMap);
        }

        Node clone(Node node, Map<Node, Node> newMap) {
            if (!newMap.containsKey(node)) {
                Node copy = new Node(node.val);
                newMap.put(node, copy);
                for (Node child : node.neighbors) {
                    copy.neighbors.add(clone(child, newMap));
                }
            }
            return newMap.get(node);
        }
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}
