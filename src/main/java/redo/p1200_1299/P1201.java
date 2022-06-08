package redo.p1200_1299;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1201  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月14日  
 *  
 */
public class P1201 {

    class Solution {
        public int nthUglyNumber(int n, int a, int b, int c) {
            int low = 1, high =
                (int)min(2000000001, (long)a * n, (long)b * n, (long)c * n);
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (check(mid, n, a, b, c)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        public long min(long... nums) {
            long min = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                min = Math.min(min, nums[i]);
            }
            return min;
        }

        public boolean check(int x, int target, int a, int b, int c) {
            int count = (int)(x / a + x / b + x / c - x / mcm(a, b)
                - x / mcm(b, c) - x / mcm(a, c) + x / mcm(mcm(a, b), c));
            return count >= target;
        }


        public long gcd(long m, long n) {
            long r;
            while (n > 0) {
                r = m % n;
                m = n;
                n = r;
            }
            return m;
        }

        public long mcm(long m, long n) {
            return m * n / gcd(m, n);
        }
    }


    /*
     * public int ugly(int n, int a, int b, int c) {
            long ab = mcm(a, b), bc = mcm(b, c), ac = mcm(a, c),
                abc = mcm(ab, c);
    
            int low = 0, high = Integer.MAX_VALUE / 2;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (check(mid, n, a, b, c, ab, bc, ac, abc)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
    
            return low;
        }
    
        public boolean check(int x, int n, int a, int b, int c, long ab,
            long bc, long ac, long abc) {
            return x / a + x / b + x / c - x / ab - a / bc - x / ac
                + x / abc >= n;
        }
    
        long mcm(long m, long n) {
            return m * n / gcd(m, n);
        }
    
        long gcd(long m, long n) {
            long r;
            while (n > 0) {
                r = m % n;
                m = n;
                n = r;
            }
            return m;
        }
     */


    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.nthUglyNumber(3, 2, 3, 5));
        Assert.assertEquals(6, s.nthUglyNumber(4, 2, 3, 4));
        Assert.assertEquals(10, s.nthUglyNumber(5, 2, 11, 13));
        Assert.assertEquals(1999999984,
            s.nthUglyNumber(1000000000, 2, 217983653, 336916467));
    }

}
