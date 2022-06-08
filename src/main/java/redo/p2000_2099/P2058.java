package redo.p2000_2099;

import model.ListNode;

public class P2058 {

    class Solution {
        public int[] nodesBetweenCriticalPoints(ListNode head) {
            int prev = head.val;
            ListNode node = head.next;
            int lastIndex = -1, firstIndex = -1, nowIndex = 1;
            int[] ans = new int[]{Integer.MAX_VALUE, -1};
            boolean update = false;
            while (node.next != null) {
                if ((node.val > prev && node.val > node.next.val)
                        || (node.val < prev && node.val < node.next.val)) {
                    if (lastIndex != -1) {
                        ans[0] = Math.min(nowIndex - lastIndex, ans[0]);
                        ans[1] = nowIndex - firstIndex;
                        update = true;
                    }
                    if (firstIndex == -1) {
                        firstIndex = nowIndex;
                    }
                    lastIndex = nowIndex;
                }

                ++nowIndex;
                prev = node.val;
                node = node.next;
            }
            if (!update) {
                return new int[]{-1, -1};
            }
            return ans;
        }
    }

}
