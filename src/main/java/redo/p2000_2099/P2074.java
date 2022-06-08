package redo.p2000_2099;

import model.ListNode;
import redo.testUtil.LinkedListTestUtil;

public class P2074 {

    class Solution {
        public ListNode reverseEvenLengthGroups(ListNode head) {
            ListNode dummy = new ListNode(-1), last = dummy, node = head;
            dummy.next = head;
            int n = 1;
            while (node != NULL) {
                if (n % 2 == 1) {
                    ListNode nextK = nextK(last, n);
                    if (nextK == null || nextK.next == null || nextK == NULL) {
                        break;
                    }
                    last = nextK;
                    node = last.next;
                } else {
                    ListNode reverseTail = node, nextK = nextK(node, n);
                    if (nextK == null) {
                        break;
                    }
                    last.next = reverseK(node, n);
                    if (nextK == NULL) {
                        return dummy.next;
                    }
                    reverseTail.next = nextK;
                    last = reverseTail;
                    node = nextK;
                }
                ++n;
            }

            if (len(node) % 2 == 0) {
                last.next = reverseK(node, n);
            }

            return dummy.next;
        }

        ListNode NULL = new ListNode(0);

        public ListNode nextK(ListNode node, int k) {
            while (node != null && k-- != 0) {
                node = node.next;
            }
            if (node != null) {
                return node;
            }
            if (k == 0) {// 没有下一组但是本组还足k个，依然要反转
                return NULL;
            }
            return null;
        }

        public ListNode reverseK(ListNode node, int k) {
            ListNode head = new ListNode(-1);
            while (k-- != 0 && node != null) {
                ListNode next = node.next;
                node.next = head.next;
                head.next = node;
                node = next;
            }
            return head.next;
        }

        int len(ListNode head) {
            int len = 0;
            while (head != null) {
                ++len;
                head = head.next;
            }
            return len;
        }
    }

    public static void main(String[] args) {
        ListNode head = LinkedListTestUtil.build("[1,1,0,6,5]");
        System.out.println(new P2074().new Solution().reverseEvenLengthGroups(head));
    }

}
