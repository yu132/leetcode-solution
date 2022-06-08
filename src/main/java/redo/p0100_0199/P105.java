package redo.p0100_0199;

import java.util.Deque;
import java.util.LinkedList;

import model.TreeNode;

/**  
 * @ClassName: P105  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月2日  
 *  
 */
public class P105 {

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {

            if (preorder == null || preorder.length == 0) {
                return null;
            }

            int n = preorder.length;

            Deque<TreeNode> stack = new LinkedList<>();

            TreeNode root = new TreeNode(preorder[0]);

            stack.push(root);

            int inIndex = 0;

            for (int i = 1; i < n; ++i) {
                if (stack.peek().val != inorder[inIndex]) {
                    TreeNode node = new TreeNode(preorder[i]);
                    stack.peek().left = node;
                    stack.push(node);
                } else {
                    TreeNode parent = null;
                    while (!stack.isEmpty()
                        && stack.peek().val == inorder[inIndex]) {
                        ++inIndex;
                        parent = stack.pop();
                    }
                    parent.right = new TreeNode(preorder[i]);
                    stack.push(parent.right);
                }
            }

            return root;

        }
    }

}
