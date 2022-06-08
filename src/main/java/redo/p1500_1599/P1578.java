package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1578  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月4日  
 *  
 */
public class P1578 {

    class Solution {
        public int minCost(String s, int[] cost) {
            char lastCh = '\0';
            int lastCost = 0;

            int delete = 0;
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == lastCh) {
                    if (lastCost > cost[i]) {
                        delete += cost[i];
                    } else {
                        delete += lastCost;
                        lastCost = cost[i];
                    }
                } else {
                    lastCh = s.charAt(i);
                    lastCost = cost[i];
                }
            }

            return delete;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.minCost("abaac", new int[] {1, 2, 3, 4, 5}));
        Assert.assertEquals(0, s.minCost("anc", new int[] {1, 2, 3}));
        Assert.assertEquals(2, s.minCost("aabaa", new int[] {1, 2, 3, 4, 1}));
        Assert.assertEquals(23, s.minCost("bbbaaa", new int[] {4, 9, 3, 8, 8, 9}));
    }

}
