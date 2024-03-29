package reredo;

/**  
 * @ClassName: P0088  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月4日  
 *  
 */
public class P0088 {

    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int index1 = m - 1, index2 = n - 1, index = m + n - 1;

            while (index1 >= 0 && index2 >= 0) {
                if (nums1[index1] >= nums2[index2]) {
                    nums1[index--] = nums1[index1--];
                } else {
                    nums1[index--] = nums2[index2--];
                }
            }

            while (index2 >= 0) {
                nums1[index--] = nums2[index2--];
            }
        }
    }

}
