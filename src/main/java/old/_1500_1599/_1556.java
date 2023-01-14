package old._1500_1599;

/**  
 * @ClassName: _1556  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年8月26日  
 *  
 */
public class _1556 {

    class Solution {
        public String thousandSeparator(int n) {

            if (n == 0) {
                return "0";
            }

            StringBuilder sb    = new StringBuilder();

            int           digit = 0;

            while (n != 0) {
                sb.append(n % 10);
                n /= 10;
                ++digit;
                if (digit % 3 == 0 && n != 0) {
                    sb.append('.');
                }
            }

            return sb.reverse().toString();
        }
    }

}
