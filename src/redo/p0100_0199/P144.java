package redo.p0100_0199;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import model.TreeNode;

/**  
 * @ClassName: P144  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P144 {

    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {

            if (root == null) {
                return Collections.emptyList();
            }

            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);

            List<Integer> ans = new ArrayList<>();

            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                ans.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }

            return ans;
        }
    }

}
