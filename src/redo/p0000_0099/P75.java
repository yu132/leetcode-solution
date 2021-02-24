package redo.p0000_0099;

/**  
 * @ClassName: P75  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P75 {

    class Solution {
        public void sortColors(int[] nums) {
            int index0 = 0, index1 = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] == 1) {
                    swap(nums, i, index1);
                    ++index1;
                } else if (nums[i] == 0) {
                    swap(nums, i, index0);
                    if (index0 < index1) {
                        swap(nums, i, index1);
                    }
                    ++index1;
                    ++index0;
                }
            }
        }

        void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

}
