package redo.p1200_1299;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1262  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月12日  
 *  
 */
public class P1262 {

    static//

    class Solution {
        public int maxSumDivThree(int[] nums) {
            int bound = 10000000;
            int minMod2 = bound, min2Mod2 = bound, minMod1 = bound, min2Mod1 = bound, sum = 0;
            for (int num : nums) {
                sum += num;
                if (num % 3 == 1) {
                    if (num < minMod1) {
                        min2Mod1 = minMod1;
                        minMod1 = num;
                    } else if (num < min2Mod1) {
                        min2Mod1 = num;
                    }
                } else if (num % 3 == 2) {
                    if (num < minMod2) {
                        min2Mod2 = minMod2;
                        minMod2 = num;
                    } else if (num < min2Mod2) {
                        min2Mod2 = num;
                    }
                }
            }
            if (sum % 3 == 0) {
                return sum;
            } else if (sum % 3 == 1) {
                sum -= Math.min(minMod1, minMod2 + min2Mod2);
            } else {
                sum -= Math.min(minMod2, minMod1 + min2Mod1);
            }
            return sum;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(18, s.maxSumDivThree(new int[] {3, 6, 5, 1, 8}));
        Assert.assertEquals(0, s.maxSumDivThree(new int[] {4}));
        Assert.assertEquals(12, s.maxSumDivThree(new int[] {1, 2, 3, 4, 4}));
        Assert.assertEquals(3, s.maxSumDivThree(new int[] {1, 1, 1, 1, 1}));
        Assert.assertEquals(6, s.maxSumDivThree(new int[] {2, 2, 2, 2, 2}));
        Assert.assertEquals(15, s.maxSumDivThree(new int[] {2, 6, 2, 2, 7}));
    }

}
