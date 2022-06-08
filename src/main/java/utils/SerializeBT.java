package utils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import model.TreeNode;

/**  
 * @ClassName: SerializeBT  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月11日  
 *  
 */
public class SerializeBT {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) {
            return "[]";
        }

        List<String>    list  = new ArrayList<>(100);

        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            if (node == null) {
                list.add("e");
            } else {
                list.add(String.valueOf(node.val));
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        for (int i = list.size() - 1; i >= 0; --i) {
            if (list.get(i).equals("e")) {
                list.remove(i);
            } else {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < list.size() - 1; ++i) {
            sb.append(list.get(i)).append(',');
        }
        sb.append(list.get(list.size() - 1) + ']');

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        data = data.replaceAll("\\s", "");

        data = data.substring(1, data.length() - 1);

        if (data.length() == 0) { // 空树
            return null;
        }

        String[]        value = data.split(",");

        Deque<TreeNode> queue = new LinkedList<>();

        TreeNode        head  = new TreeNode(Integer.valueOf(value[0]));

        queue.addLast(head);

        for (int i = 1; i < value.length; i += 2) {
            TreeNode father = queue.removeFirst();
            if (!value[i].equals("e")) {
                father.left = new TreeNode(Integer.valueOf(value[i]));
                queue.addLast(father.left);
            }
            if (i + 1 < value.length && !value[i + 1].equals("e")) {
                father.right = new TreeNode(Integer.valueOf(value[i + 1]));
                queue.addLast(father.right);
            }
        }

        return head;
    }

}
