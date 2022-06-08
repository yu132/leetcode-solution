package lcof;

import java.math.BigInteger;

/**  
 * @ClassName: M14_2  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月14日  
 *  
 */
public class M14_2 {

    class Solution {
        public int cuttingRope(int n) {
            if (n <= 3) {
                return n - 1;
            }
            switch (n % 3) {
                case 0:
                    return BigInteger.valueOf(3).pow(n / 3).mod(BigInteger.valueOf(1000000007)).intValue();
                case 1:
                    return BigInteger.valueOf(3).pow(n / 3 - 1).multiply(BigInteger.valueOf(4))
                        .mod(BigInteger.valueOf(1000000007)).intValue();
                case 2:
                    return BigInteger.valueOf(3).pow(n / 3).multiply(BigInteger.valueOf(2))
                        .mod(BigInteger.valueOf(1000000007)).intValue();
            }
            return -1;
        }
    }

}
