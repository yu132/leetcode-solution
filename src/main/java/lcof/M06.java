package lcof;

import java.util.ArrayList;
import java.util.List;

import model.ListNode;

/**  
 * @ClassName: M06  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月12日  
 *  
 */
public class M06 {

    class Solution {
        public int[] reversePrint(ListNode head) {
            List<Integer> list = new ArrayList<>();

            while (head != null) {
                list.add(head.val);
                head = head.next;
            }

            int[] ans = new int[list.size()];

            for (int i = list.size() - 1; i >= 0; --i) {
                ans[list.size() - i - 1] = list.get(i);
            }

            return ans;
        }
    }

}
