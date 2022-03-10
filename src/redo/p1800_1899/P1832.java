package redo.p1800_1899;

/**  
 * @ClassName: P1832  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年7月26日  
 *  
 */
public class P1832 {

    class Solution {
        public boolean checkIfPangram(String sentence) {
            boolean[] alph = new boolean[26];
            int count = 0;

            for (char ch : sentence.toCharArray()) {
                if (!alph[ch - 'a']) {
                    ++count;
                    alph[ch - 'a'] = true;
                    if (count == 26) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

}
