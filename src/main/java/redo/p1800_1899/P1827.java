package redo.p1800_1899;

/**  
 * @ClassName: P1827  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年7月26日  
 *  
 */
public class P1827 {

    class Solution {
        public int minOperations(int[] nums) {
            int last = Integer.MIN_VALUE, ans = 0;
            for (int num : nums) {
                if (num > last) {
                    last = num;
                } else {
                    ans += last + 1 - num;
                    last += 1;
                }
            }
            return ans;
        }
    }

}
