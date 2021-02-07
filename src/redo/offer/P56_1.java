package redo.offer;

/**  
 * @ClassName: P56_1  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P56_1 {

    class Solution {
        public int[] singleNumbers(int[] nums) {
            int xor = 0;
            for (int num : nums) {
                xor ^= num;
            }
            int lowbit = xor & -xor;
            int[] ans = new int[2];
            for (int num : nums) {
                if ((num & lowbit) == 0) {
                    ans[0] ^= num;
                } else {
                    ans[1] ^= num;
                }
            }
            return ans;
        }
    }

}
