package redo.testUtil;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import model.ListNode;

/**  
 * @ClassName: LinkedList  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class LinkedListTestUtil {

    public static ListNode build(String nums) {
        return build(Arrs.build(nums));
    }

    public static ListNode build(int... nums) {
        ListNode head = new ListNode(0), node = head;
        for (int num : nums) {
            node.next = new ListNode(num);
            node = node.next;
        }
        return head.next;
    }

    public static ListNode get(int val, ListNode head) {
        while (head != null) {
            if (head.val == val) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    public static ListNode buildCycle(int cycle, int... nums) {
        ListNode head = new ListNode(0), node = head, cycNode = null;
        for (int num : nums) {
            node.next = new ListNode(num);
            if (num == cycle) {
                cycNode = node.next;
            }
            node = node.next;
        }
        if (cycNode == null) {
            throw new RuntimeException("循环节点不存在");
        }
        node.next = cycNode;
        return head.next;
    }

    public static String toStr(ListNode head, boolean hasBlank) {
        if (head == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        boolean first = true;
        while (head != null) {
            if (first) {
                first = false;
            } else {
                sb.append(",").append(hasBlank ? " " : "");
            }
            sb.append(head.val);
            head = head.next;
        }
        sb.append(']');
        return sb.toString();
    }

    public static String toStr(ListNode head) {
        return toStr(head, false);
    }

    @Test
    public void test() {
        assertEquals("[1, 2, 3, 4]", toStr(build(1, 2, 3, 4), true));
    }

}
