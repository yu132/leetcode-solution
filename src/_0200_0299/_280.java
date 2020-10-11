package _0200_0299;

/**  
 * @ClassName: _280  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月10日  
 *  
 */
public class _280 {

    class Solution {
        public void wiggleSort(int[] nums) {
            if (nums.length <= 1) {
                return;
            }
            if (nums[0] > nums[1]) {
                int temp = nums[0];
                nums[0] = nums[1];
                nums[1] = temp;
            }
            boolean up = true;
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
