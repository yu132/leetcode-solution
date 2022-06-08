package _1400_1499;

/**  
 * @ClassName: _1455  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年6月6日  
 *  
 */
public class _1455 {

    class Solution {
        public int isPrefixOfWord(String sentence, String searchWord) {
            String[] words = sentence.split(" ");
            for (int i = 0; i < words.length; ++i) {
                if (words[i].startsWith(searchWord)) {
                    return i + 1;
                }
            }
            return -1;
        }
    }

}
