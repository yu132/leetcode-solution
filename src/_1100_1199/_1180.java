package _1100_1199;

/**  
 * @ClassName: _1180  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月31日  
 *  
 */
public class _1180 {

    class Solution {
        public int countLetters(String S) {

            if (S.length() == 0) {
                return 0;
            }

            int  count = 0, index = 1, len = 1;
            char now   = S.charAt(0);

            while (index < S.length()) {
                char next = S.charAt(index++);
                if (now == next) {
                    ++len;
                    continue;
                } else {
                    count += len * (len + 1) / 2;
                    len    = 0;
                    now    = next;
                }
            }

            return count + len * (len + 1) / 2;

        }
    }

}
