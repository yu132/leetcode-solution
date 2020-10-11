package _0900_0999;

import java.util.LinkedList;

import model.TreeNode;

/**  
 * @ClassName: _919  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月19日  
 *  
 */
public class _919 {

    class CBTInserter {

        private TreeNode root;

        private LinkedList<TreeNode> list = new LinkedList<>();

        public CBTInserter(TreeNode root) {
            this.root = root;

            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.addLast(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.removeFirst();
                if (node.left != null && node.right != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                } else {
                    list.add(node);
                    if (node.left != null) {
                        queue.add(node.left);
                    } else if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
        }


        public int insert(int v) {
            TreeNode node = list.getFirst();
            if (node.left == null) {
                node.left = new TreeNode(v);
                list.addLast(node.left);
            } else {
                node.right = new TreeNode(v);
                list.addLast(node.right);
                list.removeFirst();
            }
            return node.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }

}
