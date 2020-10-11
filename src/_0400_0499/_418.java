package _0400_0499;

/**  
 * @ClassName: _418  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月12日  
 *  
 */
public class _418 {

    class Solution {
        public int wordsTyping(String[] sentence, int rows, int cols) {

            int[] dp = new int[sentence.length], next = new int[sentence.length];

            for (int i = 0; i < sentence.length; ++i) {
                int times = 0;
                int index = i;
                int clen  = cols;
                while (clen >= sentence[index].length()) {
                    clen -= sentence[index++].length() + 1;
                    if (index == sentence.length) {
                        ++times;
                        index = 0;
                    }
                }
                dp[i]   = times;
                next[i] = index;
            }

            int count = 0;
            int index = 0;
            for (int i = 0; i < rows; ++i) {
                count += dp[index];
                index  = next[index];
            }
            return count;
        }
    }

}
