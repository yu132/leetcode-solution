package redo.p0900_0999;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P976  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月26日  
 *  
 */
public class P976 {

    class Solution {
        public int largestPerimeter(int[] A) {
            Arrays.sort(A);
            for (int i = A.length - 1; i >= 2; --i) {
                if (A[i - 2] + A[i - 1] > A[i]) {
                    return A[i - 2] + A[i - 1] + A[i];
                }
            }
            return 0;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(5, s.largestPerimeter(new int[] {2, 1, 2}));
        Assert.assertEquals(0, s.largestPerimeter(new int[] {1, 2, 1}));
        Assert.assertEquals(10, s.largestPerimeter(new int[] {3, 2, 3, 4}));
        Assert.assertEquals(8, s.largestPerimeter(new int[] {3, 6, 2, 3}));
    }

}
