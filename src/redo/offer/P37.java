package redo.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

import model.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P37  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P37 {

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            List<String> list = new ArrayList<>();

            Deque<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node == null) {
                    list.add("null");
                } else {
                    list.add(String.valueOf(node.val));
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }

            while (!list.isEmpty()
                && list.get(list.size() - 1).equals("null")) {
                list.remove(list.size() - 1);
            }

            StringJoiner sj = new StringJoiner(",", "[", "]");

            for (String value : list) {
                sj.add(value);
            }

            return sj.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() < 2 || data.equals("[]")) {
                return null;
            }
            data = data.trim().substring(1, data.length() - 1);
            String[] vals = data.split(",");
            boolean left = true;
            Deque<TreeNode> queue = new LinkedList<>();
            TreeNode head = null;
            for (int i = 0; i < vals.length; ++i) {
                if (vals[i].equals("null")) {
                    if (!left) {
                        queue.poll();
                    }
                } else {
                    if (queue.isEmpty()) {
                        head = new TreeNode(Integer.valueOf(vals[i]));
                        queue.offer(head);
                        continue;
                    } else {
                        if (left) {
                            TreeNode node =
                                new TreeNode(Integer.valueOf(vals[i]));
                            queue.peek().left = node;
                            queue.offer(node);
                        } else {
                            TreeNode node =
                                new TreeNode(Integer.valueOf(vals[i]));
                            queue.peek().right = node;
                            queue.offer(node);
                            queue.poll();
                        }
                    }
                }
                left = !left;
            }

            return head;
        }
    }



    @Test
    public void test() {
        Codec s = new Codec();
        Assert.assertEquals("[1,2,3,null,null,4,5]",
            s.serialize(s.deserialize("[1,2,3,null,null,4,5]")));
    }
}
