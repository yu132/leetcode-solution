package redo.p0000_0099;

import java.util.Arrays;

/**  
 * @ClassName: P16  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月21日  
 *  
 */
public class P16 {

    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int dis = Integer.MAX_VALUE, num = 0;
            for (int i = 0; i < nums.length; ++i) {
                int low = 0, high = nums.length - 1;
                while (low < high) {
                    if (low == i) {
                        ++low;
                        continue;
                    } else if (high == i) {
                        --high;
                        continue;
                    }
                    int val = nums[i] + nums[low] + nums[high];
                    if (Math.abs(val - target) < dis) {
                        dis = Math.abs(val - target);
                        num = val;
                    }
                    if (val > target) {
                        --high;
                    } else {
                        ++low;
                    }
                }
            }
            return num;
        }
    }

}
