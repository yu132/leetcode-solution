package redo.p0000_0099;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P88  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class P88 {

    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int last = m + n - 1;
            m = m - 1;
            n = n - 1;
            while (m >= 0 && n >= 0) {
                if (nums1[m] >= nums2[n]) {
                    nums1[last--] = nums1[m--];
                } else {
                    nums1[last--] = nums2[n--];
                }
            }

            while (n >= 0) {
                nums1[last--] = nums2[n--];
            }
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        s.merge(nums1, 3, nums2, 3);
        assertArrayEquals(new int[] {1, 2, 2, 3, 5, 6}, nums1);
    }

}
