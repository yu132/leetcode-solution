package _1300_1399;

/**  
 * @ClassName: _1374  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月12日  
 *  
 */
public class _1374 {

    class Solution {
        public String generateTheString(int n) {
            if ((n & 1) == 1) {
                StringBuilder sb = new StringBuilder(n);
                for (int i = 0; i < n; ++i) {
                    sb.append('a');
                }
                return sb.toString();
            } else {
                StringBuilder sb = new StringBuilder(n);
                for (int i = 0; i < n - 1; ++i) {
                    sb.append('a');
                }
                sb.append('b');
                return sb.toString();
            }
        }
    }

}
