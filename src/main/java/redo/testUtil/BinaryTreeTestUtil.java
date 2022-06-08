package redo.testUtil;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import model.TreeNode;
import org.junit.Test;

/**  
 * @ClassName: BinaryTreeTestUtil  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class BinaryTreeTestUtil {

    public static TreeNode find(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode node = find(root.left, val);
        if (node != null) {
            return node;
        }
        return find(root.right, val);
    }

    public static TreeNode build(String str) {
        if (str == null) {
            return null;
        }

        if (str.length() >= 1 && str.charAt(0) == '[') {
            str = str.substring(1, str.length() - 1);
        }

        if (str.length() == 0 || str.equals("")) {
            return null;
        }

        String[] sps = str.split(",");

        Deque<TreeNode> nodes = new LinkedList<>();

        TreeNode node = null, head = null;
        boolean left = true;

        for (String sp : sps) {
            if (sp.equals("null")) {
                if (left) {
                    left = false;
                } else {
                    node = nodes.poll();
                    left = true;
                }
            } else {
                int value = Integer.valueOf(sp);
                if (head == null) {
                    node = head = new TreeNode(value);
                } else {
                    if (left) {
                        node.left = new TreeNode(value);
                        nodes.offer(node.left);
                        left = false;
                    } else {
                        node.right = new TreeNode(value);
                        nodes.offer(node.right);
                        node = nodes.poll();
                        left = true;
                    }
                }
            }
        }

        return head;
    }

    public static String toStr(TreeNode head) {
        if (head == null) {
            return "[]";
        }
        Deque<TreeNode> nodes = new LinkedList<>();
        nodes.push(head);

        List<String> strs = new ArrayList<>();

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (node == null) {
                strs.add("null");
            } else {
                strs.add(String.valueOf(node.val));
                nodes.offer(node.left);
                nodes.offer(node.right);
            }
        }

        while (strs.get(strs.size() - 1).equals("null")) {
            strs.remove(strs.size() - 1);
        }

        StringBuilder sb = new StringBuilder(strs.size() * 3);
        sb.append('[');
        for (int i = 0; i < strs.size() - 1; ++i) {
            sb.append(strs.get(i)).append(',');
        }
        sb.append(strs.get(strs.size() - 1)).append(']');

        return sb.toString();
    }

    public static boolean same(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        return p == q || p.val == q.val && same(p.left, q.left) && same(p.right, q.right);
    }

    @Test
    public void testToStr() {
        TreeNode _1 = new TreeNode(1);
        TreeNode _2 = new TreeNode(2);
        TreeNode _3 = new TreeNode(3);
        TreeNode _4 = new TreeNode(4);
        TreeNode _5 = new TreeNode(5);
        _1.left = _2;
        _1.right = _3;
        _2.left = _4;
        _2.right = _5;
        assertEquals("[1,2,3,4,5]", toStr(_1));
    }

    @Test
    public void test() {
        assertEquals("[1,2,3,4,5]", toStr(build("[1,2,3,4,5]")));
        assertEquals("[1,2,3,4,5,null,11]", toStr(build("[1,2,3,4,5,null,11]")));
    }
}
