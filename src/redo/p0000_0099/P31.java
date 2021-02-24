package redo.p0000_0099;

/**  
 * @ClassName: P31  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P31 {

    class Solution {
        public void nextPermutation(int[] nums) {
            for (int i = nums.length - 2; i >= 0; --i) {
                if (nums[i] >= nums[i + 1]) {
                    continue;
                } else {
                    int index = i + 1;
                    while (index + 1 < nums.length
                        && nums[index + 1] > nums[i]) {
                        ++index;
                    }
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                    reverse(nums, i + 1, nums.length - 1);
                    return;
                }
            }
            reverse(nums, 0, nums.length - 1);
        }

        void reverse(int[] nums, int low, int high) {
            for (; low < high; ++low, --high) {
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
            }
        }
    }

}
