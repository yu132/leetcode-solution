package redo.Util.math;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @Classname: Pow  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月6日  
 *  
 */
public class Pow {

    public double myPow(double x, int N) {
        double num = 1;
        long n = N;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        while (n > 0) {
            if (n % 2 == 1) {
                num *= x;
            }
            n >>= 1;
            x = x * x;
        }
        return num;
    }

    public static int myPow(long x, int n, int mod) {
        long num = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                num = (num * x) % mod;
            }
            n >>= 1;
            x = (x * x) % mod;
        }
        return (int)num;
    }



    @Test
    public void test() {
        Assert.assertEquals(myPow(3, 1000, 1000000007), BigInteger.valueOf(3)
            .pow(1000).mod(BigInteger.valueOf(1000000007)).intValue());
    }

}
