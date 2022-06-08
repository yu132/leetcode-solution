package redo.p1700_1799;

/**  
 * @ClassName: P1768  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月1日  
 *  
 */
public class P1768 {

    class Solution {
        public String mergeAlternately(String word1, String word2) {
            StringBuilder buf =
                new StringBuilder(word1.length() + word2.length());

            int index1 = 0, index2 = 0;

            boolean flag = true;

            while (index1 < word1.length() && index2 < word2.length()) {
                if (flag) {
                    buf.append(word1.charAt(index1++));
                } else {
                    buf.append(word2.charAt(index2++));
                }
                flag = !flag;
            }

            buf.append(word1, index1, word1.length());
            buf.append(word2, index2, word2.length());

            return buf.toString();
        }
    }

}
