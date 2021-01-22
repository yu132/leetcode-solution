package redo.p0500_0599;

import java.util.Deque;
import java.util.LinkedList;

import model.TreeNode;

/**  
 * @ClassName: P538  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月19日  
 *  
 */
public class P538 {

    class Solution {
        public TreeNode convertBST(TreeNode root) {
            return bstToGst(root);
        }

        public TreeNode bstToGst(TreeNode root) {
            int preSum = 0;

            Deque<TreeNode> stack = new LinkedList<>();

            TreeNode ret = root;

            while (root != null) {
                stack.push(root);
                root = root.right;
            }

            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                preSum += node.val;
                node.val = preSum;
                TreeNode left = node.left;
                while (left != null) {
                    stack.push(left);
                    left = left.right;
                }
            }

            return ret;
        }
    }

}
