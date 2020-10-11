package lcof;

/**  
 * @ClassName: M56_1  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月22日  
 *  
 */
public class M56_1 {

    class Solution {
        public int[] singleNumbers(int[] nums) {

            int xor = 0;

            for (int each : nums) {
                xor ^= each;
            }

            int   lowbit = xor & -xor;

            int[] ans    = new int[2];

            for (int each : nums) {
                if ((each & lowbit) == 0) {
                    ans[0] ^= each;
                } else {
                    ans[1] ^= each;
                }
            }

            return ans;
        }
    }

}
