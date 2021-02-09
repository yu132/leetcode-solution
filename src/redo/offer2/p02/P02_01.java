package redo.offer2.p02;

import java.util.HashSet;
import java.util.Set;

import model.ListNode;

/**  
 * @ClassName: P02_01  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P02_01 {

    class Solution {
        public ListNode removeDuplicateNodes(ListNode head) {

            if (head == null) {
                return null;
            }

            Set<Integer> set = new HashSet<>();
            ListNode node = head;
            while (node.next != null) {
                set.add(node.val);
                if (set.contains(node.next.val)) {
                    node.next = node.next.next;
                } else {
                    node = node.next;
                }
            }
            return head;
        }
    }

}
