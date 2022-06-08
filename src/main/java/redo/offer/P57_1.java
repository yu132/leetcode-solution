package redo.offer;

/**  
 * @ClassName: P57  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P57_1 {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int low = 0, high = nums.length - 1;

            while (low < high) {
                int sum = nums[low] + nums[high];
                if (sum == target) {
                    return new int[] {nums[low], nums[high]};
                } else if (sum > target) {
                    --high;
                } else {
                    ++low;
                }
            }

            throw new RuntimeException("unreachable");
        }
    }

}
