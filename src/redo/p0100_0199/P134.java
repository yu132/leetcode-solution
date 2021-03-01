package redo.p0100_0199;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P134  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月25日  
 *  
 */
public class P134 {

    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {

            int n = gas.length;

            int count = 0, i = 0;

            while (count < n) {

                int gasNow = 0, index = i;
                boolean first = true;

                for (; gasNow >= 0 && (first || index != i);
                    index = (index + 1) % n) {
                    first = false;
                    ++count;
                    gasNow += gas[index];
                    gasNow -= cost[index];
                }

                if (gasNow < 0) {
                    i = index;
                } else {
                    return index;
                }

            }

            return -1;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.canCompleteCircuit(new int[] {1, 2, 3, 4, 5},
            new int[] {3, 4, 5, 1, 2}));
    }

}
