package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1536  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月5日  
 *  
 */
public class P1536 {

    class Solution {
        public int minSwaps(int[][] grid) {

            int n = grid.length;

            int[] count0 = new int[n];

            for (int i = 0; i < n; ++i) {
                count0[i] = n;
                for (int j = n - 1; j >= 0; --j) {
                    if (grid[i][j] == 1) {
                        count0[i] = n - j - 1;
                        break;
                    }
                }
            }

            int ans = 0;

            for (int i = 0; i < n; ++i) {
                if (count0[i] >= n - i - 1) {
                    continue;
                }
                int targetLine = -1;
                for (int j = i + 1; j < n; ++j) {
                    if (count0[j] >= n - i - 1) {
                        targetLine = j;
                        break;
                    }
                }
                if (targetLine == -1) {
                    return -1;
                }
                for (int j = targetLine; j > i; --j) {
                    int temp = count0[j];
                    count0[j] = count0[j - 1];
                    count0[j - 1] = temp;
                    ++ans;
                }
            }

            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.minSwaps(Arrs.build2D("[[0,0,1],[1,1,0],[1,0,0]]")));
        Assert.assertEquals(-1, s.minSwaps(Arrs.build2D("[[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,1,1,0]]")));
        Assert.assertEquals(0, s.minSwaps(Arrs.build2D("[[1,0,0],[1,1,0],[1,1,1]]")));
    }

}
