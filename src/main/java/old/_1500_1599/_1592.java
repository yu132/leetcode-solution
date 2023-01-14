package old._1500_1599;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: _1592  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年10月11日  
 *  
 */
public class _1592 {

    class Solution {
        public String reorderSpaces(String text) {

            List<String> words      = new ArrayList<>();

            int          countSpace = 0;

            boolean      word       = false;
            int          start      = -1;
            for (int i = 0; i < text.length(); ++i) {
                if (text.charAt(i) == ' ') {
                    if (word) {
                        words.add(text.substring(start, i));
                        word = false;
                    }
                    ++countSpace;
                } else {
                    if (!word) {
                        start = i;
                        word  = true;
                    }
                }
            }
            if (word) {
                words.add(text.substring(start, text.length()));
            }

            StringBuilder sb = new StringBuilder(text.length());

            if (words.size() > 1) {

                int n   = countSpace / (words.size() - 1);
                int dif = countSpace - n * (words.size() - 1);

                for (int i = 0; i < words.size() - 1; ++i) {
                    sb.append(words.get(i));
                    for (int j = 0; j < n; ++j) {
                        sb.append(' ');
                    }
                }

                sb.append(words.get(words.size() - 1));

                for (int i = 0; i < dif; ++i) {
                    sb.append(' ');
                }
            } else {
                sb.append(words.get(0));
                for (int i = 0; i < countSpace; ++i) {
                    sb.append(' ');
                }
            }

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new _1592().new Solution().reorderSpaces("  this   is  a sentence "));
    }

}
