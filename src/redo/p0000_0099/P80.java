package redo.p0000_0099;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P80  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月21日  
 *  
 */
public class P80 {

    class Solution {
        public int removeDuplicates(int[] nums) {
            int indexToFill = 0, indexToCheck = 0;
            for (; indexToCheck < nums.length; ++indexToCheck) {
                if (indexToCheck == 0 || nums[indexToCheck - 1] != nums[indexToCheck]) {
                    nums[indexToFill++] = nums[indexToCheck];
                    if (indexToCheck + 1 < nums.length && nums[indexToCheck] == nums[indexToCheck + 1]) {
                        nums[indexToFill++] = nums[indexToCheck];
                    }
                }
            }
            return indexToFill;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        int[] arr = {1, 1, 1, 2, 2, 3};
        Assert.assertEquals(5, s.removeDuplicates(arr));
        Assert.assertArrayEquals(new int[] {1, 1, 2, 2, 3, 3}, arr);

        arr = new int[] {0, 0, 1, 1, 1, 1, 2, 3, 3};
        Assert.assertEquals(7, s.removeDuplicates(arr));
        Assert.assertArrayEquals(new int[] {0, 0, 1, 1, 2, 3, 3, 3, 3}, arr);

        arr = new int[] {1, 2, 2};
        Assert.assertEquals(3, s.removeDuplicates(arr));
        Assert.assertArrayEquals(new int[] {1, 2, 2}, arr);
    }

}
