package redo.p0400_0499;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import model.TreeNode;

/**  
 * @ClassName: P449  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月26日  
 *  
 */
public class P449 {

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {

            Deque<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            List<String> list = new ArrayList<>();

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node == null) {
                    list.add("null");
                    continue;
                }
                list.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            }

            return String.join(",", list);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if ("null".equals(data)) {
                return null;
            }

            String[] sp = data.split(",");

            TreeNode root = new TreeNode(Integer.parseInt(sp[0]));

            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            boolean left = true;

            for (int i = 1; i < sp.length; ++i, left = !left) {
                if (left) {
                    if ("null".equals(sp[i])) {
                        continue;
                    }
                    TreeNode node = new TreeNode(Integer.parseInt(sp[i]));
                    queue.peek().left = node;
                    queue.offer(node);
                } else {
                    if (!"null".equals(sp[i])) {
                        TreeNode node = new TreeNode(Integer.parseInt(sp[i]));
                        queue.peek().right = node;
                        queue.offer(node);
                    }
                    queue.poll();
                }
            }

            return root;
        }
    }

}
