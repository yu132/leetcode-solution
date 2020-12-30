package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1539  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1539 {

    class Solution {
        public int findKthPositive(int[] arr, int k) {
            int last = 0;
            for (int i = 0; i < arr.length; ++i) {
                int diff = arr[i] - last;
                if (k > diff - 1) {
                    k -= diff - 1;
                } else {
                    return last + k;
                }
                last = arr[i];
            }
            return last + k;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(9, s.findKthPositive(new int[] {2, 3, 4, 7, 11}, 5));
        Assert.assertEquals(6, s.findKthPositive(new int[] {1, 2, 3, 4}, 2));
    }

}
