package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P875  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月27日  
 *  
 */
public class P875 {

    static//

    class Solution {
        public int minEatingSpeed(int[] piles, int H) {
            int low = 1, high = max(piles);

            while (low < high) {
                int mid = (low + high) >>> 1;
                if (check(mid, piles, H)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            return low;
        }

        private boolean check(int eat, int[] piles, int h) {
            int count = 0;
            for (int pile : piles) {
                count += (pile - 1) / eat + 1;
            }
            return count <= h;
        }


        public static int max(int[] nums) {
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return max;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.minEatingSpeed(new int[] {3, 6, 7, 11}, 8));
        Assert.assertEquals(30, s.minEatingSpeed(new int[] {30}, 1));
        Assert.assertEquals(30, s.minEatingSpeed(new int[] {30, 11, 23, 4, 20}, 5));
        Assert.assertEquals(23, s.minEatingSpeed(new int[] {30, 11, 23, 4, 20}, 6));
        Assert.assertEquals(1, s.minEatingSpeed(new int[] {312884470}, 968709470));

    }

}
