package test;

import model.ListNode;

/**  
 * @ClassName: Test  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月25日  
 *  
 */
public class Test {

    ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(-1), node = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                node.next = node1;
                node1 = node1.next;
            } else {
                node.next = node2;
                node2 = node2.next;
            }
            node = node.next;
        }
        if (node1 != null) {
            node.next = node1;
        } else {
            node.next = node2;
        }
        return dummy.next;
    }

}
