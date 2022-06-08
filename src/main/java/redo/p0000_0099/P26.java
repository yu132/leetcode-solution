package redo.p0000_0099;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P26  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class P26 {

    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int indexToFill = 1;
            for (int indexToCheck = 1; indexToCheck < nums.length; ++indexToCheck) {
                if (nums[indexToCheck] != nums[indexToCheck - 1]) {
                    nums[indexToFill++] = nums[indexToCheck];
                }
            }
            return indexToFill;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        int[] arr = new int[] {1, 1, 2};
        int[] after = new int[] {1, 2, 2};
        assertEquals(2, s.removeDuplicates(arr));
        assertArrayEquals(after, arr);

        arr = new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        after = new int[] {0, 1, 2, 3, 4, 2, 2, 3, 3, 4};
        assertEquals(5, s.removeDuplicates(arr));
        assertArrayEquals(after, arr);
    }
}
