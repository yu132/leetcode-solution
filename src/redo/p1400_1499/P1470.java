package redo.p1400_1499;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1470  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1470 {

    class Solution {
        public int[] shuffle(int[] nums, int n) {
            for (int i = n - 1; i >= 1; --i) {
                int temp = nums[i];
                System.arraycopy(nums, i + 1, nums, i, i);
                nums[i * 2] = temp;
            }
            return nums;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.shuffle(new int[] {2, 5, 1, 3, 4, 7}, 3)));
        Assert.assertArrayEquals(new int[] {2, 3, 5, 4, 1, 7}, s.shuffle(new int[] {2, 5, 1, 3, 4, 7}, 3));
        Assert.assertArrayEquals(new int[] {1, 4, 2, 3, 3, 2, 4, 1}, s.shuffle(new int[] {1, 2, 3, 4, 4, 3, 2, 1}, 4));
        Assert.assertArrayEquals(new int[] {1, 2, 1, 2}, s.shuffle(new int[] {1, 1, 2, 2}, 2));

    }
}
