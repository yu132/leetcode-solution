package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1310  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月10日  
 *  
 */
public class P1310 {

    class Solution {
        public int[] xorQueries(int[] arr, int[][] queries) {
            int[] xorPrefix = new int[arr.length + 1];
            for (int i = 0; i < arr.length; ++i) {
                xorPrefix[i + 1] = arr[i] ^ xorPrefix[i];
            }
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; ++i) {
                ans[i] = xorPrefix[queries[i][1] + 1] ^ xorPrefix[queries[i][0]];
            }
            return ans;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {2, 7, 14, 8},
            s.xorQueries(new int[] {1, 3, 4, 8}, Arrs.build2D("[[0,1],[1,2],[0,3],[3,3]]")));
        Assert.assertArrayEquals(new int[] {8, 0, 4, 4},
            s.xorQueries(new int[] {4, 8, 2, 10}, Arrs.build2D("[[2,3],[1,3],[0,0],[0,3]]")));
    }

}
