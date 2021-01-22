package redo.p0000_0099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P54  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月13日  
 *  
 */
public class P54 {

    static//

    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ans = new ArrayList<>();
            int m = matrix.length, n = matrix[0].length;
            spiralOrder(m, n, (i, j) -> ans.add(matrix[i][j]));
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
        Assert.assertEquals(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5),
            s.spiralOrder(Arrs.build2D("[[1,2,3],[4,5,6],[7,8,9]]")));
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7),
            s.spiralOrder(Arrs.build2D("[[1,2,3,4],[5,6,7,8],[9,10,11,12]]")));
    }

}
