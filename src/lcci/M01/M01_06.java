package lcci.M01;

/**  
 * @ClassName: M01_06  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月26日  
 *  
 */
public class M01_06 {

    class Solution {
        public String compressString(String S) {
            if (S.length() == 0) {
                return S;
            }

            char          ch   = S.charAt(0);
            int           time = 1;
            StringBuilder sb   = new StringBuilder(S.length());

            for (int i = 1; i < S.length(); ++i) {
                if (S.charAt(i) == ch) {
                    ++time;
                } else {
                    sb.append(ch).append(time);
                    ch   = S.charAt(i);
                    time = 1;
                }
            }

            sb.append(ch).append(time);

            return sb.length() < S.length() ? sb.toString() : S;
        }
    }

}
