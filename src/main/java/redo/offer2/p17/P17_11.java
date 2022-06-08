package redo.offer2.p17;

/**  
 * @ClassName: P17_11  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月16日  
 *  
 */
public class P17_11 {

    class Solution {
        public int findClosest(String[] words, String word1, String word2) {
            int i1 = indexOf(words, word1, 0), i2 = indexOf(words, word2, 0),
                min = Math.abs(i1 - i2);
            while (true) {
                if (i1 < i2) {
                    i1 = indexOf(words, word1, i1 + 1);
                } else {
                    i2 = indexOf(words, word2, i2 + 1);
                }
                if (i1 == -1 || i2 == -1) {
                    break;
                }
                min = Math.min(min, Math.abs(i1 - i2));
            }
            return min;
        }

        int indexOf(String[] strs, String str, int start) {
            for (int i = start; i < strs.length; ++i) {
                if (strs[i].equals(str)) {
                    return i;
                }
            }
            return -1;
        }
    }

}
