package _0200_0299;

/**  
 * @ClassName: _243  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月26日  
 *  
 */
public class _243 {

    class Solution {
        public int shortestDistance(String[] words, String word1, String word2) {

            int index1 = words.length, index2 = -words.length, min = Integer.MAX_VALUE;
            for (int i = 0; i < words.length; ++i) {
                if (words[i].equals(word1)) {
                    index1 = i;
                } else if (words[i].equals(word2)) {
                    index2 = i;
                }
                min = Math.min(min, Math.abs(index1 - index2));
            }

            return min;
        }
    }

}
