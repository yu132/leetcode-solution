package redo.p0000_0099;

/**  
 * @ClassName: P41  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月23日  
 *  
 */
public class P41 {

    class Solution {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < nums.length; ++i) {
                int swap = nums[i];
                nums[i] = -1;
                while (swap > 0 && swap <= nums.length
                    && swap != nums[swap - 1]) {
                    int temp = swap;
                    swap = nums[temp - 1];
                    nums[temp - 1] = temp;
                }
            }

            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }
            return n + 1;
        }
    }

}
