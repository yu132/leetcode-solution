package redo.p0600_0699;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P628  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P628 {

    class Solution {
        public int maximumProduct(int[] nums) {
            int[][] maxMin = maxMinN(nums, 3);
            int[] min = maxMin[0], max = maxMin[1];

            return Math.max(min[0] * min[1] * max[0], max[0] * max[1] * max[2]);
        }

        public int[][] maxMinN(int[] arr, int k) {
            int[] max = new int[k], min = new int[k];
            Arrays.fill(max, Integer.MIN_VALUE);
            Arrays.fill(min, Integer.MAX_VALUE);
            for (int num : arr) {
                for (int i = 0; i < max.length; ++i) {
                    if (num >= max[i]) {
                        System.arraycopy(max, i, max, i + 1, max.length - i - 1);
                        max[i] = num;
                        break;
                    }
                }
                for (int i = 0; i < min.length; ++i) {
                    if (num <= min[i]) {
                        System.arraycopy(min, i, min, i + 1, min.length - i - 1);
                        min[i] = num;
                        break;
                    }
                }
            }
            return new int[][] {min, max};
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(6, s.maximumProduct(new int[] {1, 2, 3}));
        Assert.assertEquals(24, s.maximumProduct(new int[] {1, 2, 3, 4}));
        Assert.assertEquals(27 * 3, s.maximumProduct(new int[] {-1, -3, -9, 1, 2, 3}));
        Assert.assertEquals(0, s.maximumProduct(new int[] {-1, -3, -9, -10, -1, 0}));
    }

}
