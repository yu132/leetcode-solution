package redo.p0000_0099;

/**  
 * @ClassName: P4  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月26日  
 *  
 */
public class P04 {

    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            int index1 = 0, index2 = 0, n = nums1.length + nums2.length,
                half = n / 2 + 1;

            int prev = 0, now = 0;

            while (index1 < nums1.length && index2 < nums2.length
                && !(index1 + index2 == half)) {
                prev = now;
                if (nums1[index1] <= nums2[index2]) {
                    now = nums1[index1++];
                } else {
                    now = nums2[index2++];
                }
            }

            while (index1 < nums1.length && !(index1 + index2 == half)) {
                prev = now;
                now = nums1[index1++];
            }

            while (index2 < nums2.length && !(index1 + index2 == half)) {
                prev = now;
                now = nums2[index2++];
            }

            if ((n & 1) == 0) {
                return (prev + now) / 2.0;
            } else {
                return now;
            }
        }
    }

}
