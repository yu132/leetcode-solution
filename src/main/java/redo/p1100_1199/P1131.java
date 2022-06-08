package redo.p1100_1199;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1131  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月14日  
 *  
 */
public class P1131 {

    static//

    class Solution {
        public int maxAbsValExpr(int[] arr1, int[] arr2) {
            int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, max4 = Integer.MIN_VALUE,
                min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, min3 = Integer.MAX_VALUE, min4 = Integer.MAX_VALUE;
            for (int i = 0; i < arr1.length; ++i) {
                max1 = Math.max(max1, arr1[i] + arr2[i] + i);
                max2 = Math.max(max2, -arr1[i] + arr2[i] + i);
                max3 = Math.max(max3, arr1[i] - arr2[i] + i);
                max4 = Math.max(max4, arr1[i] + arr2[i] - i);

                min1 = Math.min(min1, arr1[i] + arr2[i] + i);
                min2 = Math.min(min2, -arr1[i] + arr2[i] + i);
                min3 = Math.min(min3, arr1[i] - arr2[i] + i);
                min4 = Math.min(min4, arr1[i] + arr2[i] - i);
            }

            return Math.max(Math.max(max1 - min1, max2 - min2), Math.max(max3 - min3, max4 - min4));
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(13, s.maxAbsValExpr(new int[] {1, 2, 3, 4}, new int[] {-1, 4, 5, 6}));
        Assert.assertEquals(20, s.maxAbsValExpr(new int[] {1, -2, -5, 0, 10}, new int[] {0, -2, -1, -7, -4}));
    }

}
