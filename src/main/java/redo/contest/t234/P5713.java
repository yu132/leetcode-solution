package redo.contest.t234;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;

/**  
 * @ClassName: P5713  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月28日  
 *  
 */
public class P5713 {

    class Solution {
        public int numDifferentIntegers(String word) {

            Set<String> set = new HashSet<>();

            int start = -1;

            for (int i = 0; i < word.length(); ++i) {
                int ch = word.charAt(i);
                if (!Character.isDigit(ch)) {
                    if (start != -1) {
                        set.add(substr(start, i, word));
                        start = -1;
                    }
                } else {
                    if (start == -1) {
                        start = i;
                    }
                }
            }
            if (start != -1) {
                set.add(substr(start, word.length(), word));
            }


            return set.size();
        }

        String substr(int start, int end, String word) {
            while (start < end && word.charAt(start) == '0') {
                ++start;
            }
            if (start == end) {
                return "0";
            }
            return word.substring(start, end);
        }
    }
}
