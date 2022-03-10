package redo.p1800_1899;

/**  
 * @ClassName: P1822  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年7月26日  
 *  
 */
public class P1822 {

    class Solution {
        public int arraySign(int[] nums) {
            int countNeg = 0;
            for (int num : nums) {
                if (0 == num) {
                    return 0;
                }
                if (num < 0) {
                    ++countNeg;
                }
            }
            return (countNeg & 1) == 0 ? 1 : -1;
        }
    }

}
