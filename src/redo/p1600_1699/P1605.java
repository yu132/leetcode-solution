package redo.p1600_1699;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1605  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月3日  
 *  
 */
public class P1605 {


    class Solution {
        public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
            int[][] ans = new int[rowSum.length][colSum.length];
            for (int i = 0; i < rowSum.length; ++i) {
                for (int j = 0; j < colSum.length; ++j) {
                    ans[i][j] = Math.min(rowSum[i], colSum[j]);
                    rowSum[i] -= ans[i][j];
                    colSum[j] -= ans[i][j];
                }
            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[[3,0],[1,7]]", Arrs.toStr(s.restoreMatrix(new int[] {3, 8}, new int[] {4, 7})));
        Assert.assertEquals("[[5,0,0],[3,4,0],[0,2,8]]",
            Arrs.toStr(s.restoreMatrix(new int[] {5, 7, 10}, new int[] {8, 6, 8})));
        Assert.assertEquals("[[6,8,0],[0,1,8]]", Arrs.toStr(s.restoreMatrix(new int[] {14, 9}, new int[] {6, 9, 8})));
        Assert.assertEquals("[[0]]", Arrs.toStr(s.restoreMatrix(new int[] {0}, new int[] {0})));
    }

}
