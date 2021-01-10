package redo.p1400_1499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1423  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月8日  
 *  
 */
public class P1423 {

    static//

    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            if (k == cardPoints.length) {
                return sum(cardPoints, 0, cardPoints.length);
            }

            int left = sum(cardPoints, 0, k), right = 0, max = left;

            for (int i = 0; i < k; ++i) {
                left -= cardPoints[k - 1 - i];
                right += cardPoints[cardPoints.length - 1 - i];
                max = Math.max(max, left + right);
            }

            return max;
        }

        public static int sum(int[] nums, int start, int end) {
            int sum = 0;
            for (int i = start; i < end; ++i) {
                sum += nums[i];
            }
            return sum;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(12, s.maxScore(new int[] {1, 2, 3, 4, 5, 6, 1}, 3));
        Assert.assertEquals(4, s.maxScore(new int[] {2, 2, 2}, 2));
        Assert.assertEquals(55, s.maxScore(new int[] {9, 7, 7, 9, 7, 7, 9}, 7));
        Assert.assertEquals(1, s.maxScore(new int[] {1, 1000, 1}, 1));
        Assert.assertEquals(202, s.maxScore(new int[] {1, 79, 80, 1, 1, 1, 200, 1}, 3));
    }


}
