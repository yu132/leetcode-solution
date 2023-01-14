package old._0800_0899;

import java.util.HashSet;

import model.ListNode;

/**  
 * @ClassName: _817  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月7日  
 *  
 */
public class _817 {

    class Solution {
        public int numComponents(ListNode head, int[] G) {

            int              count  = 0;
            boolean          isComp = false;

            HashSet<Integer> set    = new HashSet<>();

            for (int each : G) {
                set.add(each);
            }

            while (head != null) {
                if (set.contains(head.val)) {
                    if (!isComp) {
                        isComp = true;
                    }
                } else {
                    if (isComp) {
                        ++count;
                        isComp = false;
                    }
                }
                head = head.next;
            }

            return isComp ? count + 1 : count;
        }
    }

}
