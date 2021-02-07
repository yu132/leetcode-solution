package redo.p0100_0199;

/**  
 * @ClassName: P137  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P137 {

    class Solution {
        public int singleNumber(int[] nums) {
            int a = 0, b = 0;

            for (int num : nums) {
                // int t = a ^ num & ~b;
                // b = (a & num) | (b & ~(a | num));
                // a = t;
                a = a ^ num & ~b;
                b = b ^ num & ~a;
            }
            return a;
        }
    }

}
