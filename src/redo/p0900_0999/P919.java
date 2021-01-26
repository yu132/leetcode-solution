package redo.p0900_0999;

import java.util.Deque;
import java.util.LinkedList;

import model.TreeNode;

/**  
 * @ClassName: P919  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月25日  
 *  
 */
public class P919 {

    class CBTInserter {

        TreeNode root;
        Deque<TreeNode> toInsert;

        public CBTInserter(TreeNode root) {
            this.root = root;
            toInsert = new LinkedList<>();

            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.right == null) {
                    toInsert.offer(node);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        public int insert(int v) {
            TreeNode node = toInsert.peek();
            if (node.left == null) {
                node.left = new TreeNode(v);
                toInsert.offer(node.left);
            } else {
                node.right = new TreeNode(v);
                toInsert.offer(node.right);
                toInsert.poll();
            }
            return node.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }

}
