package redo.p1100_1199;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1186  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月14日  
 *  
 */
public class P1186 {

    static//

    class Solution {
        public int maximumSum(int[] arr) {
            int keep, remove, max;
            keep = remove = max = -10000000;
            for (int num : arr) {
                remove = Math.max(remove + num, keep);
                keep = Math.max(keep + num, num);
                max = Math.max(max, Math.max(keep, remove));
            }
            return max;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.maximumSum(new int[] {1, -2, 0, 3}));
        Assert.assertEquals(3, s.maximumSum(new int[] {1, -2, -2, 3}));
        Assert.assertEquals(-1, s.maximumSum(new int[] {-1, -1, -1}));
        Assert.assertEquals(7, s.maximumSum(new int[] {1, -4, -5, -2, 5, 0, -1, 2}));
    }
}
