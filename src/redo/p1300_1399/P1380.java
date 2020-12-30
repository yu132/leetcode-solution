package redo.p1300_1399;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1380  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1380 {

    class Solution {
        public List<Integer> luckyNumbers(int[][] matrix) {
            if (matrix.length == 0) {
                return Collections.emptyList();
            }
            int[] xMin = new int[matrix.length], yMax = new int[matrix[0].length];
            Arrays.fill(xMin, Integer.MAX_VALUE);
            for (int i = 0; i < matrix.length; ++i) {
                for (int j = 0; j < matrix[i].length; ++j) {
                    xMin[i] = Math.min(xMin[i], matrix[i][j]);
                    yMax[j] = Math.max(yMax[j], matrix[i][j]);
                }
            }
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < matrix.length; ++i) {
                for (int j = 0; j < matrix[i].length; ++j) {
                    if (xMin[i] == yMax[j]) {
                        ans.add(xMin[i]);
                    }
                }
            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList(15), s.luckyNumbers(Arrs.build2D("[[3,7,8],[9,11,13],[15,16,17]]")));
        Assert.assertEquals(Arrays.asList(12), s.luckyNumbers(Arrs.build2D("[[1,10,4,2],[9,3,8,7],[15,16,17,12]]")));
        Assert.assertEquals(Arrays.asList(7), s.luckyNumbers(Arrs.build2D("[[7,8],[1,2]]")));

    }

}
