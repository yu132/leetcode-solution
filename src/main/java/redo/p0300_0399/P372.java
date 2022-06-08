package redo.p0300_0399;

import java.math.BigInteger;

import javax.lang.model.element.Element;

/**  
 * @ClassName: P372  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月15日  
 *  
 */
public class P372 {

    static //

    class Solution {
        public int superPow(int a, int[] b) {
            return eulerFastPow(a, b, 1337);
        }

        int eulerFastPow(long base, int[] expArr, int mod) {
            long eulerNumber = eulerFunction(mod);

            StringBuilder buf = new StringBuilder(expArr.length);

            for (int num : expArr) {
                buf.append(num);
            }

            long exp = new BigInteger(buf.toString())
                .mod(BigInteger.valueOf(eulerNumber)).longValue() + eulerNumber;
            return pow(base, exp, mod);
        }

        int pow(long base, long exp, int mod) {
            long ans = 1;
            base %= mod;
            while (exp > 0) {
                if (exp % 2 != 0) {
                    ans = (ans * base) % mod;
                }
                exp >>= 1;
                base = (base * base) % mod;
            }
            return (int)ans;
        }

        long eulerFunction(long n) {
            long eulerNumbers = n;
            for (long i = 2; i * i <= n; ++i) {
                if (n % i == 0) {
                    eulerNumbers = eulerNumbers / i * (i - 1);
                    while (n % i == 0) {
                        n /= i;
                    }
                }
            }
            if (n > 1) {
                eulerNumbers = eulerNumbers / n * (n - 1);
            }
            return eulerNumbers;
        }
    }

}
