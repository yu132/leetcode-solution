package redo.p0800_0899;

import java.util.HashSet;
import java.util.Set;

import model.ListNode;
import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.LinkedListTestUtil;

/**  
 * @ClassName: P817  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月30日  
 *  
 */
public class P817 {

    class Solution {
        public int numComponents(ListNode head, int[] G) {
            Set<Integer> set = new HashSet<>();
            for (int num : G) {
                set.add(num);
            }

            boolean isComp = false;
            int ans = 0;
            while (head != null) {
                if (isComp) {
                    if (!set.contains(head.val)) {
                        isComp = false;
                    }
                } else {
                    if (set.contains(head.val)) {
                        ++ans;
                        isComp = true;
                    }
                }
                head = head.next;
            }

            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.numComponents(
            LinkedListTestUtil.build("[0,1,2,3]"), new int[] {0, 1, 3}));

        Assert.assertEquals(2, s.numComponents(
            LinkedListTestUtil.build("[0,1,2,3,4]"), new int[] {0, 1, 3, 4}));

        Assert.assertEquals(3,
            s.numComponents(LinkedListTestUtil.build("[0,1,2,3,4,5,6]"),
                new int[] {0, 6, 1, 3, 4}));
    }

}
