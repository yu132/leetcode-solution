package redo.p0500_0599;


import java.util.List;

/**  
 * @ClassName: P559  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P559 {

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
        public int maxDepth(Node root) {
            if (root == null) {
                return 0;
            }
            int max = 0;
            for (Node child : root.children) {
                max = Math.max(max, maxDepth(child));
            }
            return 1 + max;
        }
    }

}
