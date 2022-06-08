package redo.p0000_0099;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import model.TreeNode;

/**  
 * @ClassName: P94  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月23日  
 *  
 */
public class P94 {

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {

            List<Integer> ans = new ArrayList<>();

            Deque<TreeNode> stack = new LinkedList<>();
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                ans.add(node.val);
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }

            return ans;
        }
    }

}
