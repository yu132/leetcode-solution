package redo.p0100_0199;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import model.TreeNode;

/**  
 * @ClassName: P145  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月23日  
 *  
 */
public class P145 {

    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {

            List<Integer> ans = new ArrayList<>();

            Deque<TreeNode> stack = new LinkedList<>();

            while (root != null) {
                stack.push(root);
                stack.push(root);
                root = root.left;
            }

            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node == stack.peek()) {
                    node = node.right;
                    while (node != null) {
                        stack.push(node);
                        stack.push(node);
                        node = node.left;
                    }
                } else {
                    ans.add(node.val);
                }
            }

            return ans;
        }
    }

}
