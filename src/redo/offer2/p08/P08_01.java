package redo.offer2.p08;

/**  
 * @ClassName: P08_01  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月10日  
 *  
 */
public class P08_01 {

    class Solution {

        final static int MOD = 1000000007;

        public int waysToStep(int n) {
            if (n <= 3) {
                if (n == 1) {
                    return 1;
                } else if (n == 2) {
                    return 2;
                } else if (n == 3) {
                    return 4;
                }
            }
            long a = 1, b = 2, c = 4;
            for (int i = 4; i <= n; ++i) {
                long temp = (a + b + c) % MOD;
                a = b;
                b = c;
                c = temp;
            }
            return (int)c;
        }
    }

}
