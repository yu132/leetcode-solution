package redo.mianshi.p01;

/**  
 * @ClassName: P01_06  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P01_06 {

    class Solution {
        public String compressString(String S) {
            if (S == null || S.equals("")) {
                return "";
            }
            char ch = S.charAt(0);
            int count = 1;

            StringBuilder buf = new StringBuilder(S.length());

            for (int i = 1; i < S.length(); ++i) {
                char now = S.charAt(i);
                if (now == ch) {
                    ++count;
                } else {
                    buf.append(ch).append(count);
                    ch = now;
                    count = 1;
                }
            }

            buf.append(ch).append(count);

            if (S.length() <= buf.length()) {
                return S;
            }

            return buf.toString();
        }
    }

}
