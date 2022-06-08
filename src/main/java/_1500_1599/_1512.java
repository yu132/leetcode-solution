package _1500_1599;

/**  
 * @ClassName: _1512  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年7月28日  
 *  
 */
public class _1512 {

    class Solution {
        public int numIdenticalPairs(int[] nums) {

            int[] count = new int[101];

            for (int i = 0; i < nums.length; ++i) {
                ++count[nums[i]];
            }

            int ans = 0;

            for (int i = 1; i < count.length; ++i) {
                ans += count[i] * (count[i] - 1) / 2;
            }

            return ans;
        }
    }

}
