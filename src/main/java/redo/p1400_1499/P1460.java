package redo.p1400_1499;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1460  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1460 {

    static//

    class Solution {
        public boolean canBeEqual(int[] target, int[] arr) {
            int start = 1, end = 1001;
            int[] tCount = count(target, start, end), arrCount = count(arr, start, end);
            return Arrays.equals(tCount, arrCount);
        }

        public static int[] count(int[] nums, int start, int end) {
            int[] count = new int[end - start];
            for (int num : nums) {
                ++count[num - start];
            }
            return count;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.canBeEqual(new int[] {1, 2, 3, 4}, new int[] {2, 4, 1, 3}));
        Assert.assertEquals(true, s.canBeEqual(new int[] {7}, new int[] {7}));
        Assert.assertEquals(true, s.canBeEqual(new int[] {1, 12}, new int[] {12, 1}));
        Assert.assertEquals(false, s.canBeEqual(new int[] {3, 7, 9}, new int[] {3, 7, 11}));
    }

}
