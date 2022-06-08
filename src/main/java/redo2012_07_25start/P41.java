package redo2012_07_25start;

import java.util.concurrent.ThreadPoolExecutor;

/**  
 * @ClassName: P41  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年8月8日  
 *  
 */
public class P41 {

    class Solution {
        public int firstMissingPositive(int[] nums) {
            for (int i = 0; i < nums.length; ++i) {
                int num = nums[i];
                nums[i] = -1;
                while (num > 0 && num <= nums.length && num != nums[num - 1]) {
                    int temp = nums[num - 1];
                    nums[num - 1] = num;
                    num = temp;
                }
            }
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }
            return nums.length + 1;
        }
    }

}
