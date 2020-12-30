package redo.p1000_1099;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1013  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月26日  
 *  
 */
public class P1013 {

    class Solution {
        public boolean canThreePartsEqualSum(int[] arr) {
            int sum = 0;
            for (int n : arr) {
                sum += n;
            }
            if (sum % 3 != 0) {
                return false;
            }
            sum /= 3;
            int count = 0, temp = 0;
            for (int i = 0; i < arr.length; ++i) {
                temp += arr[i];
                if (temp == sum) {
                    ++count;
                    temp = 0;
                }
            }
            return count == 3 || (count > 3 && sum == 0);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.canThreePartsEqualSum(new int[] {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1}));
        Assert.assertEquals(false, s.canThreePartsEqualSum(new int[] {0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1}));
        Assert.assertEquals(true, s.canThreePartsEqualSum(new int[] {3, 3, 6, 5, -2, 2, 5, 1, -9, 4}));
        Assert.assertEquals(true, s.canThreePartsEqualSum(new int[] {18, 12, -18, 18, -19, -1, 10, 10}));
        Assert.assertEquals(false, s.canThreePartsEqualSum(new int[] {1, -1, 1, -1}));
        Assert.assertEquals(false, s.canThreePartsEqualSum(new int[] {6, 1, 1, 13, -1, 0, -10, 20}));
        Assert.assertEquals(true, s.canThreePartsEqualSum(new int[] {10, -10, 10, -10, 10, -10, 10, -10}));

    }
}
