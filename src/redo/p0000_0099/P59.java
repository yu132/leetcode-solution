package redo.p0000_0099;

import java.util.function.BiConsumer;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P59  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月13日  
 *  
 */
public class P59 {

    static//

    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] ans = new int[n][n];
            int[] val = new int[1];
            val[0] = 0;
            spiralOrder(n, n, (i, j) -> ans[i][j] = ++val[0]);
            return ans;
        }

        static void spiralOrder(int m, int n, BiConsumer<Integer, Integer> consumer) {
            int top = 0, bottom = m - 1, left = 0, right = n - 1, eleNum = m * n;
            while (eleNum >= 1) {
                for (int i = left; i <= right && eleNum >= 1; ++i) {
                    consumer.accept(top, i);
                    --eleNum;
                }
                ++top;
                for (int i = top; i <= bottom && eleNum >= 1; ++i) {
                    consumer.accept(i, right);
                    --eleNum;
                }
                --right;
                for (int i = right; i >= left && eleNum >= 1; --i) {
                    consumer.accept(bottom, i);
                    --eleNum;
                }
                --bottom;
                for (int i = bottom; i >= top && eleNum >= 1; --i) {
                    consumer.accept(i, left);
                    --eleNum;
                }
                ++left;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[[1,2,3],[8,9,4],[7,6,5]]", Arrs.toStr(s.generateMatrix(3)));
    }

}
