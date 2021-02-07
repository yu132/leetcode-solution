package redo.offer;

/**  
 * @ClassName: P50  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P50 {

    class Solution {
        public char firstUniqChar(String s) {
            int[] queue = new int[26], count = new int[26];

            int index = 0;

            for (char ch : s.toCharArray()) {
                if (count[ch - 'a'] == 0) {
                    queue[index++] = ch;
                }
                ++count[ch - 'a'];
            }

            for (int i = 0; i < index; ++i) {
                if (count[queue[i] - 'a'] == 1) {
                    return (char)queue[i];
                }
            }

            return ' ';
        }
    }

}
