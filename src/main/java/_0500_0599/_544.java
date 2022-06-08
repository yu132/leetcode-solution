package _0500_0599;

/**  
 * @ClassName: _544  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月12日  
 *  
 */
public class _544 {

    class Solution {
        public String findContestMatch(int n) {

            String[] str = new String[n];

            for (int i = 1; i <= n; ++i) {
                str[i - 1] = Integer.toString(i);
            }

            while (n != 1) {
                n /= 2;
                for (int i = 0; i < n; ++i) {
                    str[i] = "(" + str[i] + "," + str[2 * n - i - 1] + ")";
                }
            }

            return str[0];
        }
    }

}
