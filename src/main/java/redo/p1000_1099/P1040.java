package redo.p1000_1099;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1040  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月19日  
 *  
 */
public class P1040 {

    class Solution {
        public int[] numMovesStonesII(int[] stones) {

            int n = stones.length;

            Arrays.sort(stones);
            int empty = stones[n - 1] - stones[0] - n + 1;
            int minRange = Math.min(stones[n - 1] - stones[n - 2] - 1, stones[1] - stones[0] - 1);

            int maxAns = empty - minRange;

            int minAns = Integer.MAX_VALUE;

            for (int left = 0, right = 0; left < stones.length; ++left) {
                while (right < n && stones[right] - stones[left] < n) {
                    ++right;
                }
                int cost = n - (right - left);
                if (right - left == n - 1 && stones[right - 1] - stones[left] + 1 == n - 1) {
                    cost = 2;
                }
                minAns = Math.min(minAns, cost);
            }
            return new int[] {minAns, maxAns};
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {1, 2}, s.numMovesStonesII(new int[] {7, 4, 9}));
        Assert.assertArrayEquals(new int[] {2, 3}, s.numMovesStonesII(new int[] {6, 5, 4, 3, 10}));
        Assert.assertArrayEquals(new int[] {0, 0}, s.numMovesStonesII(new int[] {100, 101, 104, 102, 103}));

        Assert.assertArrayEquals(new int[] {1, 1}, s.numMovesStonesII(new int[] {8, 7, 6, 5, 10}));
    }



}
