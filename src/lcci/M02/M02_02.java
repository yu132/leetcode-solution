package lcci.M02;

import model.ListNode;

/**  
 * @ClassName: M02_02  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月14日  
 *  
 */
public class M02_02 {

    class Solution {
        public int kthToLast(ListNode head, int k) {
            ListNode fast = head;
            ListNode slow = head;

            while (k-- != 0) {
                if (fast == null) {// 没有这个节点，因为节点数不足k个
                    return -1;
                }
                fast = fast.next;
            }

            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow.val;
        }
    }

}
