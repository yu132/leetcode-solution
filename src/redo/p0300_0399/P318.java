package redo.p0300_0399;

/**  
 * @ClassName: P318  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月14日  
 *  
 */
public class P318 {

    class Solution {
        public int maxProduct(String[] words) {
            int[] hashs = new int[words.length];

            for (int i = 0; i < words.length; ++i) {
                int hash = 0;
                for (char ch : words[i].toCharArray()) {
                    hash |= 1 << (ch - 'a');
                }
                hashs[i] = hash;
            }

            int max = 0;

            for (int i = 0; i < words.length; ++i) {
                for (int j = i + 1; j < words.length; ++j) {
                    if ((hashs[i] & hashs[j]) == 0) {
                        max = Math.max(max,
                            words[i].length() * words[j].length());
                    }
                }
            }

            return max;
        }
    }

}
