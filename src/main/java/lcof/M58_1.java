package lcof;

import java.util.ArrayList;

/**  
 * @ClassName: M58_1  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月23日  
 *  
 */
public class M58_1 {

    class Solution {
        public String reverseWords(String s) {

            if (s.length() == 0) {
                return "";
            }

            ArrayList<String> list = new ArrayList<>();

            int               from = 0, to = s.length() - 1;

            // trim
            while (from < s.length() && s.charAt(from) == ' ') {
                ++from;
            }

            if (from == s.length() && s.charAt(from - 1) == ' ') {
                return "";
            }

            while (s.charAt(to) == ' ') {
                --to;
            }

            int indexF = from;
            for (int i = from; i <= to; ++i) {
                if (s.charAt(i) == ' ') {
                    if (indexF == i) {
                        ++indexF;
                    } else {
                        list.add(s.substring(indexF, i));
                        indexF = i + 1;
                    }
                }
            }
            if (indexF != to + 1) {
                list.add(s.substring(indexF, to + 1));
            }

            if (list.size() == 0) {
                return "";
            }

            StringBuilder sb = new StringBuilder(s.length());

            for (int i = list.size() - 1; i > 0; --i) {
                sb.append(list.get(i)).append(' ');
            }

            sb.append(list.get(0));

            return sb.toString();
        }
    }

}
