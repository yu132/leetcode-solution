package redo.p1800_1899;

/**  
 * @ClassName: P1897  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年7月26日  
 *  
 */
public class P1897 {

    class Solution {
        public boolean makeEqual(String[] words) {
            int[] count = new int[26];
            for (String str : words) {
                add(str, count);
            }
            for (int i = 0; i < 26; ++i) {
                if (count[i] % words.length != 0) {
                    return false;
                }
            }
            return true;
        }

        void add(String str, int[] count) {
            for (char ch : str.toCharArray()) {
                ++count[ch - 'a'];
            }
        }
    }

}
