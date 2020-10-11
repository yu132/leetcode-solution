package lcci.M10;

/**  
 * @ClassName: M10_11  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月9日  
 *  
 */
public class M10_11 {

    class Solution {
        public void wiggleSort(int[] nums) {

            if (nums == null || nums.length <= 2) {
                return;
            }

            boolean up = nums[0] < nums[1];
            for (int i = 2; i < nums.length; ++i) {
                if (up) {
                    if (nums[i] > nums[i - 1]) {
                        int temp = nums[i];
                        nums[i]     = nums[i - 1];
                        nums[i - 1] = temp;
                    }
                    up = false;
                } else {
                    if (nums[i] < nums[i - 1]) {
                        int temp = nums[i];
                        nums[i]     = nums[i - 1];
                        nums[i - 1] = temp;
                    }
                    up = true;
                }
            }

        }
    }

}
