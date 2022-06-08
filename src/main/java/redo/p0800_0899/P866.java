package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P866  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月29日  
 *  
 */
public class P866 {

    static//

    class Solution {
        public int primePalindrome(int N) {
            for (;; ++N) {
                if (10_000_000 < N && N < 100_000_000) {
                    N = 100_000_000;
                }
                if (isPalindrome(N) && isPrime(N)) {
                    return N;
                }
            }
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

        public static boolean isPalindrome(int num) {
            return reverse(num) == num;
        }

        public static int reverse(int num) {
            int rev = 0;
            while (num != 0) {
                rev = rev * 10 + num % 10;
                num /= 10;
            }
            return rev;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(7, s.primePalindrome(6));
        Assert.assertEquals(11, s.primePalindrome(8));
        Assert.assertEquals(101, s.primePalindrome(13));
    }

}
