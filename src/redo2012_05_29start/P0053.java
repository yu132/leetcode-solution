package redo2012_05_29start;

/**  
 * @ClassName: P0053  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年5月30日  
 *  
 */
public class P0053 {

    class Solution {
        public int maxSubArray(int[] nums) {
            int maxSum = Integer.MIN_VALUE, nowSum = 0;
            for (int num : nums) {
                nowSum = Math.max(0, nowSum) + num;
                maxSum = Math.max(maxSum, nowSum);
            }
            return maxSum;
        }
    }

}
