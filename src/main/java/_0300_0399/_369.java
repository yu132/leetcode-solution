package _0300_0399;

import model.ListNode;

/**  
 * @ClassName: _369  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月12日  
 *  
 */
public class _369 {

    class Solution {
        public ListNode plusOne(ListNode head) {

            if (head.next == null) {
                if (head.val == 9) {
                    head.next = new ListNode(0);
                    head.val  = 1;
                    return head;
                } else {
                    ++head.val;
                    return head;
                }
            }

            ListNode n = head.next;
            head.next = null;
            while (n != null) {
                ListNode next = n.next;
                n.next = head;
                head   = n;
                n      = next;
            }

            head.val += 1;

            if (head.val == 10) {
                head.val = 0;
                n        = head.next;
                while (true) {
                    ++n.val;
                    if (n.val == 10) {
                        n.val = 0;
                        if (n.next == null) {
                            n.next = new ListNode(1);
                            break;
                        }
                    } else {
                        break;
                    }
                    n = n.next;
                }
            }

            n         = head.next;
            head.next = null;
            while (n != null) {
                ListNode next = n.next;
                n.next = head;
                head   = n;
                n      = next;
            }

            return head;
        }
    }

}
