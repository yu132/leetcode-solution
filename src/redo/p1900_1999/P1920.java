package redo.p1900_1999;

/**  
 * @ClassName: P1920  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年8月1日  
 *  
 */
public class P1920 {

    class Solution {
        public int[] buildArray(int[] nums) {
            int[] ans = new int[nums.length];
            for (int i = 0; i < nums.length; ++i) {
                ans[i] = nums[nums[i]];
            }
            return ans;
        }
    }

}
