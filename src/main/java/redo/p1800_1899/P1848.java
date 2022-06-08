package redo.p1800_1899;

/**  
 * @ClassName: P1848  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年7月26日  
 *  
 */
public class P1848 {

    class Solution {
        public int getMinDistance(int[] nums, int target, int start) {
            while (true) {
                for (int i = 0;; ++i) {
                    if (get(nums, start + i) == target) {
                        return i;
                    }
                    if (get(nums, start - i) == target) {
                        return i;
                    }
                }
            }
        }

        int get(int[] nums, int index) {
            if (index < 0 || index >= nums.length) {
                return Integer.MAX_VALUE;
            }
            return nums[index];
        }
    }

}
