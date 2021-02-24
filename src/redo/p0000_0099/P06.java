package redo.p0000_0099;

import java.util.Arrays;

/**  
 * @ClassName: P06  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月21日  
 *  
 */
public class P06 {

    class Solution {
        public String convert(String s, int numRows) {
            int index = 0;

            if (numRows == 1) {
                return s;
            }

            StringBuilder[] bufs = new StringBuilder[numRows];

            Arrays.setAll(bufs, (x) -> new StringBuilder(s.length() / numRows));

            while (index < s.length()) {
                for (int i = 0; i < numRows - 1 && index < s.length(); ++i) {
                    bufs[i].append(s.charAt(index++));
                }

                for (int i = numRows - 1; i > 0 && index < s.length(); --i) {
                    bufs[i].append(s.charAt(index++));
                }
            }

            StringBuilder ans = new StringBuilder(s.length());

            for (StringBuilder buf : bufs) {
                ans.append(buf);
            }

            return ans.toString();
        }
    }

}
