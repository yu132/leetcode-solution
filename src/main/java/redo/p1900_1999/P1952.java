package redo.p1900_1999;

import org.junit.Assert;
import org.junit.Test;

public class P1952 {

    class Solution {
        public boolean isThree(int n) {
            double sqrt = Math.sqrt(n);
            return isInteger(sqrt, 0.000001) && isPrime((int) sqrt);
        }

        public boolean isInteger(double num, double bias) {
            return Math.abs(num - (int) num) < bias;
        }

        public boolean isPrime(int n) {
            if (n < 2) {
                return false;
            }
            for (int i = 2; i * i <= n; ++i) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    @Test
    public void test() {
        Assert.assertFalse(new Solution().isThree(1));
        Assert.assertFalse(new Solution().isThree(2));
        Assert.assertTrue(new Solution().isThree(4));
        Assert.assertFalse(new Solution().isThree(16));
    }


}
