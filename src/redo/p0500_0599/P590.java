package redo.p0500_0599;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import redo.p0500_0599.P589.Node;

/**  
 * @ClassName: P590  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P590 {

    class Solution {
        public List<Integer> postorder(Node root) {
            if (root == null) {
                return Collections.emptyList();
            }
            Deque<Node> stack = new LinkedList<>();
            List<Integer> ans = new ArrayList<>();
            stack.push(root);
            stack.push(root);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                if (node == stack.peek()) {
                    for (int i = node.children.size() - 1; i >= 0; --i) {
                        stack.push(node.children.get(i));
                        stack.push(node.children.get(i));
                    }
                } else {
                    ans.add(node.val);
                }
            }
            return ans;
        }
    }

}
