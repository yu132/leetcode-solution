package redo.offer2.p08;

/**  
 * @ClassName: P08_05  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月10日  
 *  
 */
public class P08_05 {

    class Solution {
        public int multiply(int A, int B) {
            int small = Math.min(A, B), big = Math.max(A, B);
            return fastMul(big, small);
        }

        public int fastMul(int base, int mul) {
            int ans = 0;
            while (mul != 0) {
                if ((mul & 1) == 1) {
                    ans += base;
                }
                base += base;
                mul >>= 1;
            }
            return ans;
        }
    }

}
