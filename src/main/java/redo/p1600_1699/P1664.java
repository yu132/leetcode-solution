package redo.p1600_1699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1664  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月2日  
 *  
 */
public class P1664 {

    class Solution {
        public int waysToMakeFair(int[] nums) {
            int evenLeft = 0, oddLeft = 0, evenRight = 0, oddRight = 0;

            for (int i = 0; i < nums.length; i += 2) {
                evenRight += nums[i];
            }
            for (int i = 1; i < nums.length; i += 2) {
                oddRight += nums[i];
            }

            int count = 0;

            for (int i = 0, last = 0; i < nums.length; ++i) {
                if (i % 2 == 0) {
                    oddLeft += last;
                    evenRight -= nums[i];
                } else {
                    evenLeft += last;
                    oddRight -= nums[i];
                }
                if (evenLeft + oddRight == oddLeft + evenRight) {
                    ++count;
                }
                last = nums[i];
            }

            return count;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.waysToMakeFair(new int[] {2, 1, 6, 4}));
        Assert.assertEquals(3, s.waysToMakeFair(new int[] {1, 1, 1}));
        Assert.assertEquals(0, s.waysToMakeFair(new int[] {6, 1, 7, 4, 1}));
    }

}
