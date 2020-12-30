package redo.p1000_1099;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1051  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月26日  
 *  
 */
public class P1051 {

    class Solution {
        public int heightChecker(int[] heights) {
            int[] copy = new int[heights.length];
            System.arraycopy(heights, 0, copy, 0, heights.length);
            Arrays.sort(copy);
            int count = 0;
            for (int i = 0; i < heights.length; ++i) {
                if (heights[i] != copy[i]) {
                    ++count;
                }
            }
            return count;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.heightChecker(new int[] {1, 1, 4, 2, 1, 3}));
        Assert.assertEquals(5, s.heightChecker(new int[] {5, 1, 2, 3, 4}));
        Assert.assertEquals(0, s.heightChecker(new int[] {1, 2, 3, 4, 5}));
    }

}
