package redo.p0800_0899;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P898  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月26日  
 *  
 */
public class P898 {

    class Solution {
        public int subarrayBitwiseORs(int[] arr) {
            Set<Integer> ans = new HashSet<>(arr.length);
            Set<Integer> cur = new HashSet<>();
            for (int x : arr) {
                Set<Integer> cur2 = new HashSet<>(cur.size());
                for (int y : cur) {
                    cur2.add(x | y);
                }
                cur2.add(x);
                cur = cur2;
                ans.addAll(cur);
            }
            return ans.size();
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.subarrayBitwiseORs(new int[] {0}));
        Assert.assertEquals(3, s.subarrayBitwiseORs(new int[] {1, 1, 2}));
        Assert.assertEquals(6, s.subarrayBitwiseORs(new int[] {1, 2, 4}));
    }
}
