package redo.p0800_0899;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P825  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月30日  
 *  
 */
public class P825 {

    class Solution {
        public int numFriendRequests(int[] ages) {
            Arrays.sort(ages);

            int sameReverse = 0, num = ages[0], count = 1;

            for (int i = 1; i < ages.length; ++i) {
                if (num == ages[i]) {
                    ++count;
                } else {
                    num = ages[i];
                    count = 1;
                }
                if (num < (num - 7) * 2) {
                    sameReverse += count - 1;
                }
            }

            return sameReverse + helper(ages, 0, ages.length);
        }

        int helper(int[] ages, int start, int end) {
            if (start >= end) {
                return 0;
            }

            int low, high, ans = 0;
            low = high = end - 1;
            for (; high >= start; --high) {
                while (low - 1 >= 0 && (ages[low - 1] - 7) * 2 > ages[high]) {
                    --low;
                }
                ans += Math.max(high - low, 0);
            }
            return ans;
        }

    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.numFriendRequests(new int[] {16, 16}));
        Assert.assertEquals(2, s.numFriendRequests(new int[] {16, 17, 18}));
        Assert.assertEquals(3, s.numFriendRequests(new int[] {20, 30, 100, 110, 120}));

        Assert.assertEquals(3, s.numFriendRequests(new int[] {108, 115, 5, 24, 82}));
        Assert.assertEquals(4, s.numFriendRequests(new int[] {8, 85, 24, 85, 69}));
        Assert.assertEquals(29,
            s.numFriendRequests(new int[] {73, 106, 39, 6, 26, 15, 30, 100, 71, 35, 46, 112, 6, 60, 110}));
    }

}
