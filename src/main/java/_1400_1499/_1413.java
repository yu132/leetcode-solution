package _1400_1499;

/**  
 * @ClassName: _1413  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年5月14日  
 *  
 */
public class _1413 {

    class Solution {
        public int minStartValue(int[] nums) {

            int sum = 0, min = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; ++i) {
                sum += nums[i];
                min  = Math.min(min, sum);
            }

            return min > 0 ? 1 : -min + 1;
        }
    }

}
