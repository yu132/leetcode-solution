package redo.LCP;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: LCP18  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class LCP18 {

    class Solution {
        public int breakfastNumber(int[] staple, int[] drinks, int x) {
            Arrays.sort(staple);
            int ans = 0;
            for (int i = 0; i < drinks.length; ++i) {
                ans += upperBound(staple, x - drinks[i], 0, staple.length);
                ans %= 1000000007;
            }
            return ans;
        }

        public int upperBound(int[] nums, int target, int start, int end) {
            int low = start, high = end;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (nums[mid] <= target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(6, s.breakfastNumber(new int[] {10, 20, 5}, new int[] {5, 5, 2}, 15));
        Assert.assertEquals(8, s.breakfastNumber(new int[] {2, 1, 1}, new int[] {8, 9, 5, 1}, 9));
    }

}
