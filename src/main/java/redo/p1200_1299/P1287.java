package redo.p1200_1299;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1287  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月28日  
 *  
 */
public class P1287 {

    class Solution {
        public int findSpecialInteger(int[] arr) {
            int n0_25 = (int)(arr.length * 0.25);
            int count = 0, num = -1;
            for (int i = 0; i < arr.length; ++i) {
                if (arr[i] == num) {
                    ++count;
                } else {
                    if (count > n0_25) {
                        return num;
                    }
                    count = 1;
                    num = arr[i];
                }
            }
            if (count > n0_25) {
                return num;
            }
            throw new RuntimeException("answer not exist");
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(6, s.findSpecialInteger(new int[] {1, 2, 2, 6, 6, 6, 6, 7, 10}));
        Assert.assertEquals(3, s.findSpecialInteger(new int[] {1, 2, 3, 3}));
        Assert.assertEquals(1, s.findSpecialInteger(new int[] {1}));
    }

}
