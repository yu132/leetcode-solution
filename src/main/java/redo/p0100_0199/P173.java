package redo.p0100_0199;

import java.util.Deque;
import java.util.LinkedList;

import model.TreeNode;

/**  
 * @ClassName: P173  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月28日  
 *  
 */
public class P173 {

    class BSTIterator {

        Deque<TreeNode> stack = new LinkedList<>();

        public BSTIterator(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public int next() {
            TreeNode node = stack.pop();
            int ret = node.val;
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            return ret;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

}
