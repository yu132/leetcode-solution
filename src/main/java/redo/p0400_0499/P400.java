package redo.p0400_0499;

/**  
 * @ClassName: P400  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P400 {

    class Solution {

        public int findNthDigit(int n) {

            --n;

            int base = 1;
            long batch = 9;

            while (n >= batch * base) {
                n -= batch * base;
                ++base;
                batch = batch * 10;
            }

            int first = (int)Math.pow(10, base - 1);

            int num = first + n / base;

            n %= base;

            int diff = base - n - 1;

            while (diff-- != 0) {
                num /= 10;
            }

            return num % 10;
        }
    }

}
