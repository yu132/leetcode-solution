package redo.p0300_0399;

/**  
 * @ClassName: P389  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月16日  
 *  
 */
public class P389 {

    class Solution {
        public char findTheDifference(String s, String t) {
            int[] count = new int[26];

            for (char ch : t.toCharArray()) {
                ++count[ch - 'a'];
            }

            for (char ch : s.toCharArray()) {
                --count[ch - 'a'];
            }

            for (int i = 0; i < 26; ++i) {
                if (count[i] != 0) {
                    return (char)('a' + i);
                }
            }

            throw new RuntimeException();
        }
    }

}
