package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1534  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1534 {

    class Solution {
        public int countGoodTriplets(int[] arr, int a, int b, int c) {
            int count = 0;
            for (int i = 0; i < arr.length; ++i) {
                for (int j = i + 1; j < arr.length; ++j) {
                    for (int k = j + 1; k < arr.length; ++k) {
                        int a1 = Math.abs(arr[i] - arr[j]);
                        int b1 = Math.abs(arr[j] - arr[k]);
                        int c1 = Math.abs(arr[i] - arr[k]);
                        if (a1 <= a && b1 <= b && c1 <= c) {
                            ++count;
                        }
                    }
                }
            }
            return count;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.countGoodTriplets(new int[] {3, 0, 1, 1, 9, 7}, 7, 2, 3));
        Assert.assertEquals(0, s.countGoodTriplets(new int[] {1, 1, 2, 2, 3}, 0, 0, 1));
    }

}
