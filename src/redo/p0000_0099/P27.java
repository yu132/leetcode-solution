package redo.p0000_0099;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P27  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class P27 {

    class Solution {
        public int removeElement(int[] nums, int val) {
            int indexToFill = 0;
            for (int indexToCheck = 0; indexToCheck < nums.length; ++indexToCheck) {
                if (nums[indexToCheck] != val) {
                    nums[indexToFill++] = nums[indexToCheck];
                }
            }
            return indexToFill;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();

        int[] arr = new int[] {3, 2, 2, 3};
        int[] after = new int[] {2, 2, 2, 3};
        assertEquals(2, s.removeElement(arr, 3));
        assertArrayEquals(after, arr);

        arr = new int[] {0, 1, 2, 2, 3, 0, 4, 2};
        after = new int[] {0, 1, 3, 0, 4, 0, 4, 2};
        assertEquals(5, s.removeElement(arr, 2));
        assertArrayEquals(after, arr);

    }
}
