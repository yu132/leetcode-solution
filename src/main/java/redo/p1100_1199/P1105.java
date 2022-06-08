package redo.p1100_1199;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1105  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月15日  
 *  
 */
public class P1105 {

    class Solution {

        int[] dp;

        public int minHeightShelves(int[][] books, int shelf_width) {
            dp = new int[books.length + 1];
            Arrays.fill(dp, -1);
            return dp(0, shelf_width, books);
        }

        public int dp(int index, int width, int[][] books) {
            if (index == books.length) {
                return 0;
            }
            int temp = index;
            if (dp[index] == -1) {
                int widthNow = 0, maxH = 0, min = Integer.MAX_VALUE;
                while (index < books.length && widthNow + books[index][0] <= width) {
                    widthNow += books[index][0];
                    maxH = Math.max(maxH, books[index][1]);
                    min = Math.min(min, maxH + dp(++index, width, books));
                }
                dp[temp] = min;
            }
            return dp[temp];
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(6, s.minHeightShelves(Arrs.build2D("[[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]]"), 4));

        Assert.assertEquals(17, s.minHeightShelves(Arrs.build2D("[[9,9],[5,4],[3,1],[1,5],[7,3]]"), 10));

    }
}
