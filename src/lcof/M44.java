package lcof;

/**  
 * @ClassName: M44  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月20日  
 *  
 */
public class M44 {

    class Solution {

        public int findNthDigit(int n) {

            long N     = n;

            int  num   = -1;
            int  index = -1;
            for (int i = 1;; ++i) {
                long totLen = 9 * (long)Math.pow(10, i - 1) * i;
                if (N > totLen) {
                    N -= totLen;
                } else {
                    num   = (int)((N - 1) / i + 1 + (int)Math.pow(10, i - 1) - 1);
                    index = (int)(i - (N - 1) % i - 1);
                    break;
                }
            }

            while (index-- != 0) {
                num /= 10;
            }

            return num % 10;
        }
    }

    public static void main(String[] args) {
        System.out.println(new M44().new Solution().findNthDigit(1000000000));
    }

}
