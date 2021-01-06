package redo.Util.math;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;

import org.junit.Test;

/**  
 * @ClassName: ArrangementNumber  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月27日  
 *  
 */
public class ArrangementNumber {

    public static int arrangementNumber(int m, int n, int mod) {
        return factorial(n, mod) / factorial(n - m, mod);
    }

    // public static int combinatorialNumber(int m, int n, int mod) {
    // return factorial(n, mod) / (factorial(n - m, mod) * factorial(m, mod));
    // }

    public static int factorial(int num, int mod) {
        long n = 1;
        for (int i = 2; i <= num; ++i) {
            n *= i;
            n %= mod;
        }
        return (int)n;
    }

    // public static int combinatorialNumber(int m, int n) {
    // return factorial(n) / (factorial(n - m) * factorial(m));
    // }
    //
    // public static int factorial(int num) {
    // int n = 1;
    // for (int i = 2; i <= num; ++i) {
    // n *= i;
    // }
    // return n;
    // }

    // n > m
    public int combinatorialNumber(int m, int n, int mod) {
        BigInteger a = factorial(n);
        BigInteger b = (factorial(n - m).multiply(factorial(m)));
        BigInteger c = a.divide(b);
        return c.mod(BigInteger.valueOf(mod)).intValue();
    }

    public BigInteger factorial(int num) {
        BigInteger ans = BigInteger.ONE;
        for (int i = 2; i <= num; ++i) {
            ans = ans.multiply(BigInteger.valueOf(i));
        }
        return ans;
    }

    @Test
    public void test() {
        assertEquals(6, combinatorialNumber(2, 4, 10));
        assertEquals(3, combinatorialNumber(1, 3, 10));
        assertEquals(45449810, combinatorialNumber(123, 32003, 1000000007));
    }

}
