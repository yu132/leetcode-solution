package redo.p0800_0899;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P867  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月22日  
 *  
 */
public class P867 {

    class Solution {
        public int[][] transpose(int[][] A) {
            int[][] ans = new int[A[0].length][A.length];
            for (int i = 0; i < A.length; ++i) {
                for (int j = 0; j < A[0].length; ++j) {
                    ans[j][i] = A[i][j];
                }
            }
            return ans;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[[1,4,7],[2,5,8],[3,6,9]]",
            Arrays.deepToString(s.transpose(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})).replaceAll("\\s", ""));
        Assert.assertEquals("[[1,4],[2,5],[3,6]]",
            Arrays.deepToString(s.transpose(new int[][] {{1, 2, 3}, {4, 5, 6}})).replaceAll("\\s", ""));
    }
}
