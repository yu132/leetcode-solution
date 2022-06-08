package _0700_0799;

/**  
 * @ClassName: _791  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年6月8日  
 *  
 */
public class _791 {

    class Solution {
        public String customSortString(String S, String T) {
            int[] count = new int[26];

            for (char c : T.toCharArray()) {
                ++count[c - 'a'];
            }

            StringBuilder sb = new StringBuilder(T.length());

            for (char c : S.toCharArray()) {
                for (int i = 0; i < count[c - 'a']; ++i) {
                    sb.append(c);
                }
                count[c - 'a'] = 0;
            }

            for (int i = 0; i < count.length; ++i) {
                for (int x = 0; x < count[i]; ++x) {
                    sb.append((char)(i + 'a'));
                }
            }
            return sb.toString();
        }
    }

}
