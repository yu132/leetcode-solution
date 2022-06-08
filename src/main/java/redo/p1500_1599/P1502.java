package redo.p1500_1599;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1502  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1502 {

    class Solution {
        public boolean canMakeArithmeticProgression(int[] arr) {
            Arrays.sort(arr);
            int diff = arr[1] - arr[0];
            for (int i = 2; i < arr.length; ++i) {
                if (arr[i] - arr[i - 1] != diff) {
                    return false;
                }
            }
            return true;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.canMakeArithmeticProgression(new int[] {3, 5, 1}));
        Assert.assertEquals(false, s.canMakeArithmeticProgression(new int[] {1, 2, 4}));
    }
}
