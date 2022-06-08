package _1100_1199;

/**  
 * @ClassName: _1165  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月31日  
 *  
 */
public class _1165 {

    class Solution {
        public int calculateTime(String keyboard, String word) {

            int   now = 0, sum = 0;

            int[] map = new int[26];

            for (int i = 0; i < keyboard.length(); ++i) {
                map[keyboard.charAt(i) - 'a'] = i;
            }

            for (int i = 0; i < word.length(); ++i) {
                int next = map[word.charAt(i) - 'a'];
                sum += Math.abs(now - next);
                now  = next;
            }

            return sum;
        }
    }

}
